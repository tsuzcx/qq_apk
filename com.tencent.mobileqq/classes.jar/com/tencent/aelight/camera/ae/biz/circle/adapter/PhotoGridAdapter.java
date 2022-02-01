package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleShowPhotoPreviewEvent;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class PhotoGridAdapter
  extends RecyclerView.Adapter<PhotoGridAdapter.PhotoVH>
  implements URLDrawableDownListener, MediaScanner.OnMediaScannerListener
{
  public ArrayList<LocalMediaInfo> a = new ArrayList();
  public Drawable b;
  public ColorDrawable c = new ColorDrawable(570425344);
  public LayoutInflater d;
  public int e;
  public int f;
  int g;
  int h = 0;
  boolean i;
  RecyclerView j;
  AECirclePhotoListLogic k;
  GridLayoutManager l;
  public int m = 1;
  private final Context n;
  private boolean o = true;
  
  public PhotoGridAdapter(Context paramContext, RecyclerView paramRecyclerView, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.n = paramContext;
    this.j = paramRecyclerView;
    this.l = ((GridLayoutManager)paramRecyclerView.getLayoutManager());
    this.k = paramAECirclePhotoListLogic;
    this.d = LayoutInflater.from(this.n);
    paramContext = paramContext.getResources();
    int i1 = paramContext.getDisplayMetrics().widthPixels;
    this.g = paramContext.getDimensionPixelSize(2131297020);
    this.e = ((i1 - this.g * 2) / 3);
    this.f = this.e;
    this.l.setSpanSizeLookup(new PhotoGridAdapter.1(this));
  }
  
  private void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo)
  {
    if (AppSetting.e)
    {
      paramLocalMediaInfo = QAlbumUtil.createContentDescriptionWithCheckBox(QAlbumUtil.getMediaType(paramLocalMediaInfo), paramLocalMediaInfo, paramInt, paramPhotoVH.d.isChecked());
      paramPhotoVH.d.setContentDescription(paramLocalMediaInfo);
    }
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setSelected], path=");
    localStringBuilder.append(paramLocalMediaInfo.path);
    AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
    paramPhotoVH.i.onClick(paramPhotoVH.g);
    paramLocalMediaInfo = paramPhotoVH.b;
    boolean bool = false;
    paramLocalMediaInfo.setVisibility(0);
    paramLocalMediaInfo = this.k;
    if (paramLocalMediaInfo != null) {
      paramLocalMediaInfo = paramLocalMediaInfo.i();
    } else {
      paramLocalMediaInfo = "";
    }
    if (n() > 0) {
      bool = true;
    }
    AEReportUtils.a(bool, true, getItemViewType(paramInt), paramInt, paramLocalMediaInfo);
  }
  
  private void a(PhotoGridAdapter.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if (d(paramInt))
    {
      paramPhotoVH.d.setCheckedNumber(e(this.k.e().selectedPhotoList.indexOf(paramLocalMediaInfo.path)));
      paramPhotoVH.b.setVisibility(0);
      return;
    }
    if (paramInt == 3)
    {
      paramPhotoVH.d.setChecked(false);
      paramPhotoVH.b.setVisibility(8);
      return;
    }
    paramPhotoVH.d.setChecked(false);
    paramPhotoVH.b.setVisibility(8);
  }
  
  private void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    paramList = new AECircleShowPhotoPreviewEvent(paramList, paramInt);
    SimpleEventBus.getInstance().dispatchEvent(paramList);
  }
  
  private void b(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePhotoItemClick, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("PhotoGridAdapter", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.a.get(paramInt);
    if (!paramPhotoVH.d.isChecked())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，点击后变选中, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("选中，点击后变未选中, position = ");
    localStringBuilder.append(paramInt);
    AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
    b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
  }
  
  private void b(int paramInt, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.i.onClick(paramPhotoVH.g);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelSelected path = ");
    localStringBuilder.append(paramLocalMediaInfo.path);
    AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
    paramPhotoVH.b.setVisibility(8);
    paramLocalMediaInfo = this.k;
    if (paramLocalMediaInfo != null) {
      paramLocalMediaInfo = paramLocalMediaInfo.i();
    } else {
      paramLocalMediaInfo = "";
    }
    boolean bool;
    if (n() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AEReportUtils.a(bool, false, getItemViewType(paramInt), paramInt, paramLocalMediaInfo);
  }
  
  private void b(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if ((paramPhotoVH != null) && (paramPhotoVH.a != null))
    {
      if (paramPhotoVH.d == null) {
        return;
      }
      paramPhotoVH.a.setAlpha(1.0F);
      paramPhotoVH.d.setActivated(false);
    }
  }
  
  private void c(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if (this.k.g().canPickVideo)
    {
      LocalMediaInfo localLocalMediaInfo = b(paramInt);
      if (this.k.a(this.n, localLocalMediaInfo)) {
        a(paramInt, paramPhotoVH);
      }
    }
    else
    {
      QQToast.makeText(this.n, HardCodeUtil.a(2064187572), 0).show();
    }
  }
  
  private void c(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if ((paramPhotoVH != null) && (paramPhotoVH.a != null))
    {
      if (paramPhotoVH.d == null) {
        return;
      }
      paramPhotoVH.a.setAlpha(0.3F);
      paramPhotoVH.d.setActivated(true);
    }
  }
  
  private boolean d(int paramInt)
  {
    return paramInt == 1;
  }
  
  private int e(int paramInt)
  {
    return paramInt + 1 + n();
  }
  
  private void i()
  {
    int i1 = this.m;
    Object localObject;
    if (i1 == 1)
    {
      if (this.o)
      {
        localObject = new LocalMediaInfo();
        ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
        this.a.add(0, localObject);
      }
    }
    else
    {
      LocalMediaInfo localLocalMediaInfo;
      if (i1 == 2)
      {
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
          if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      if (i1 == 3)
      {
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
          if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 0)) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
  }
  
  private void j()
  {
    boolean bool = k();
    int i2 = this.l.findFirstVisibleItemPosition();
    int i3 = this.l.findLastVisibleItemPosition();
    if (i2 != -1)
    {
      if (i3 == -1) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("notifyLimitState,startPosition:");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append("，endPosition:");
      ((StringBuilder)localObject1).append(i3);
      QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
      int i1 = i2;
      while (i1 <= i3)
      {
        if (getItemViewType(i1) != 2)
        {
          Object localObject2 = this.j.getChildAt(i1 - i2);
          localObject1 = b(i1);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("notifyLimitState view = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("notifyLimitState info = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (PhotoGridAdapter.PhotoVH)this.j.getChildViewHolder((View)localObject2);
            if (((!bool) || (d(((LocalMediaInfo)localObject1).selectStatus))) && (!a((LocalMediaInfo)localObject1)) && (!b((LocalMediaInfo)localObject1))) {
              b((PhotoGridAdapter.PhotoVH)localObject2);
            } else {
              c((PhotoGridAdapter.PhotoVH)localObject2);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  private boolean k()
  {
    return m() >= l();
  }
  
  private int l()
  {
    return this.k.e().maxSelectNum;
  }
  
  private int m()
  {
    return o() + n();
  }
  
  private int n()
  {
    return this.k.g().initialHasPickedNum;
  }
  
  private int o()
  {
    return this.k.e().selectedPhotoList.size();
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.n);
    localTextView.setGravity(17);
    localTextView.setTextSize(11.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(ViewUtils.dpToPx(26.0F), ViewUtils.dpToPx(16.0F));
    float f1 = ViewUtils.dpToPx(4.0F);
    localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  public PhotoGridAdapter.PhotoVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return new PhotoGridAdapter.PhotoVH(this, d());
        }
        return new PhotoGridAdapter.PhotoVH(this, g());
      }
      return new PhotoGridAdapter.PhotoVH(this, f());
    }
    return new PhotoGridAdapter.PhotoVH(this, e());
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  protected void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleVideoItemClickForMix, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("PhotoGridAdapter", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.a.get(paramInt);
    if (!paramPhotoVH.d.isChecked())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("没有选中，点击后变选中, position = ");
      localStringBuilder.append(paramInt);
      AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
      a(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("选中，点击后变未选中, position = ");
    localStringBuilder.append(paramInt);
    AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
    b(paramInt, (LocalMediaInfo)localObject, paramPhotoVH);
  }
  
  public void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, PhotoGridAdapter.PhotoItemClickListener paramPhotoItemClickListener)
  {
    paramPhotoVH.i = paramPhotoItemClickListener;
    if (paramPhotoVH.g != null) {
      paramPhotoVH.g.setVisibility(0);
    }
    paramPhotoVH.i.a(paramInt);
    paramPhotoVH.i.a(paramPhotoVH.d);
    paramPhotoItemClickListener = paramPhotoVH.a;
    paramPhotoItemClickListener.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = b(paramInt);
    Object localObject = QAlbumUtil.createContentDescription(0, localLocalMediaInfo, paramInt);
    paramPhotoVH.itemView.setContentDescription((CharSequence)localObject);
    if (localLocalMediaInfo != null)
    {
      if (a(localLocalMediaInfo))
      {
        if (paramPhotoVH.h == null)
        {
          paramPhotoVH.h = a();
          paramPhotoVH.h.setText("GIF");
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(11);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, ViewUtils.dpToPx(4.0F), ViewUtils.dpToPx(4.0F));
          ((RelativeLayout)paramPhotoVH.itemView).addView(paramPhotoVH.h, (ViewGroup.LayoutParams)localObject);
        }
        paramPhotoVH.h.setVisibility(0);
      }
      else if (paramPhotoVH.h != null)
      {
        paramPhotoVH.h.setVisibility(8);
      }
      int i1 = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i1;
      localLocalMediaInfo.thumbWidth = i1;
      localObject = paramPhotoVH.e;
      StringBuilder localStringBuilder = new StringBuilder("albumthumb");
      localStringBuilder.append("://");
      localStringBuilder.append(localLocalMediaInfo.path);
      if ((localObject == null) || (!((URLDrawable)localObject).getURL().toString().equals(localStringBuilder.toString())))
      {
        localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("photoGridAdapter,getView(),image url :");
          localStringBuilder.append(((URL)localObject).toString());
          QLog.d("PhotoGridAdapter", 2, localStringBuilder.toString());
        }
        localObject = URLDrawableHelper.getDrawable((URL)localObject, this.c, this.b);
        ((URLDrawable)localObject).setTag(localLocalMediaInfo);
        paramPhotoItemClickListener.setImageDrawable((Drawable)localObject);
        ((URLImageView)paramPhotoItemClickListener).setURLDrawableDownListener(this);
        paramPhotoVH.e = ((URLDrawable)localObject);
      }
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      i1 = localLocalMediaInfo.selectStatus;
      a(paramPhotoVH, localLocalMediaInfo, i1);
      a(paramInt, paramPhotoVH, localLocalMediaInfo);
      if (((k()) && (!d(i1))) || (a(localLocalMediaInfo))) {
        c(paramPhotoVH);
      } else {
        b(paramPhotoVH);
      }
      paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.3(this, localLocalMediaInfo, paramInt));
      paramPhotoItemClickListener = new PhotoGridAdapter.4(this, localLocalMediaInfo, paramPhotoVH, paramInt);
      paramPhotoVH.d.setOnClickListener(paramPhotoItemClickListener);
      paramPhotoVH.g.setOnClickListener(paramPhotoItemClickListener);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.k.c.selectedPhotoList;
    int i2 = this.l.findFirstVisibleItemPosition();
    int i3 = this.l.findLastVisibleItemPosition();
    int i1 = i2;
    while (i1 <= i3)
    {
      if ((!paramBoolean) || (paramInt == i1))
      {
        Object localObject2 = this.j.getChildAt(i1 - i2);
        Object localObject1 = b(i1);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
            ((StringBuilder)localObject1).append(i1);
            QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (localObject1 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
            ((StringBuilder)localObject1).append(i1);
            QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          int i4;
          if (paramInt != i1)
          {
            i4 = localArrayList.indexOf(((LocalMediaInfo)localObject1).path);
            if (i4 >= 0)
            {
              localObject1 = (PhotoGridAdapter.PhotoVH)this.j.getChildViewHolder((View)localObject2);
              if ((localObject1 != null) && (((PhotoGridAdapter.PhotoVH)localObject1).d != null)) {
                ((PhotoGridAdapter.PhotoVH)localObject1).d.setCheckedNumber(e(i4));
              }
            }
          }
          else
          {
            i4 = QAlbumUtil.getMediaType((LocalMediaInfo)localObject1);
            if ((i4 == 0) || (i4 == 1))
            {
              localObject2 = (PhotoGridAdapter.PhotoVH)this.j.getChildViewHolder((View)localObject2);
              if (d(((LocalMediaInfo)localObject1).selectStatus)) {
                ((PhotoGridAdapter.PhotoVH)localObject2).d.setCheckedNumber(e(localArrayList.indexOf(((LocalMediaInfo)localObject1).path)));
              } else {
                ((PhotoGridAdapter.PhotoVH)localObject2).d.setChecked(false);
              }
              a(i1, (PhotoGridAdapter.PhotoVH)localObject2, (LocalMediaInfo)localObject1);
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool1 = QLog.isColorLevel();
    int i1 = 2;
    if (bool1)
    {
      paramView = new StringBuilder();
      paramView.append("current select count:");
      paramView.append(o());
      QLog.d("PhotoGridAdapter", 2, paramView.toString());
    }
    paramView = b(paramInt);
    int i2 = paramView.selectStatus;
    if ((!d(i2)) && (k()))
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.k.f().H >= 1000L)
      {
        QQToast.makeText(this.n, c(paramView), 0).show();
        paramCheckBox.setChecked(false);
        this.k.f().H = l1;
      }
      return;
    }
    boolean bool2 = d(i2);
    bool1 = true;
    bool2 ^= true;
    if (bool2) {
      i1 = 1;
    }
    paramView.selectStatus = i1;
    String str = paramView.path;
    paramCheckBox = PresendPicMgr.a();
    if (bool2)
    {
      paramCheckBox = MimeHelper.getMimeType(paramView.mMimeType);
      if ((this.k.f().B) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        paramCheckBox = this.k.f();
        paramCheckBox.C += 1;
        if (this.k.f().C == 1) {
          this.k.f().E = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        paramCheckBox = this.k.f();
        paramCheckBox.D += 1;
      }
      this.k.e().selectedPhotoList.add(str);
      this.k.e().selectedIndex.add(paramView.position);
      this.k.e().selectedMediaInfoHashMap.put(str, paramView);
      paramCheckBox = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.k.e().albumId);
      paramView = paramCheckBox;
      if (paramCheckBox == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.k.e().albumId, paramView);
      }
      paramView.put(str, Integer.valueOf(this.l.findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        paramView.put(str, new Pair(this.k.e().albumId, this.k.e().albumName));
      }
    }
    else
    {
      Object localObject = MimeHelper.getMimeType(paramView.mMimeType);
      if ((this.k.f().B) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.k.f();
        ((PhotoListBaseData)localObject).C -= 1;
        if (this.k.f().C == 1) {
          this.k.f().E = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        localObject = this.k.f();
        ((PhotoListBaseData)localObject).D -= 1;
      }
      this.k.e().selectedPhotoList.remove(str);
      this.k.e().selectedIndex.remove(paramView.position);
      this.k.e().selectedMediaInfoHashMap.remove(str);
      if (paramCheckBox != null) {
        paramCheckBox.b(str, 1013);
      }
      paramView = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.k.e().albumId);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = AlbumUtil.sSelectItemAlbum;
      if (paramView.containsKey(str)) {
        paramView.remove(str);
      }
    }
    a(paramInt, bool2);
    if (bool2) {
      bool1 = false;
    }
    b(bool1);
  }
  
  public void a(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.7(this));
  }
  
  public void a(PhotoGridAdapter.PhotoVH paramPhotoVH, int paramInt)
  {
    PhotoGridAdapter.PhotoItemClickListener localPhotoItemClickListener = new PhotoGridAdapter.PhotoItemClickListener(this);
    int i1 = getItemViewType(paramInt);
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        a(paramPhotoVH);
        return;
      }
      b(paramInt, paramPhotoVH, localPhotoItemClickListener);
      return;
    }
    a(paramInt, paramPhotoVH, localPhotoItemClickListener);
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.a.clear();
    this.a.addAll(paramList);
    i();
    ThreadManager.getUIHandler().post(new PhotoGridAdapter.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public LocalMediaInfo b(int paramInt)
  {
    if (ArrayUtils.isOutOfArrayIndex(paramInt, this.a)) {
      return null;
    }
    if (this.i)
    {
      ArrayList localArrayList = this.a;
      if ((localArrayList != null) && (this.h != localArrayList.size()) && (paramInt > this.a.size() / 2))
      {
        this.h = this.a.size();
        this.k.o();
      }
    }
    return (LocalMediaInfo)this.a.get(paramInt);
  }
  
  public void b()
  {
    ArrayList localArrayList = this.k.c.selectedPhotoList;
    int i2 = this.l.findFirstVisibleItemPosition();
    int i3 = this.l.findLastVisibleItemPosition();
    if (i2 != -1)
    {
      if (i3 == -1) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyCheckBox,startPosition:");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append("，endPosition:");
      ((StringBuilder)localObject).append(i3);
      QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject).toString());
      int i1 = i2;
      while (i1 <= i3)
      {
        localObject = this.j.getChildAt(i1 - i2);
        if (localObject != null)
        {
          localObject = (PhotoGridAdapter.PhotoVH)this.j.getChildViewHolder((View)localObject);
          if ((localObject != null) && (((PhotoGridAdapter.PhotoVH)localObject).d != null) && (((PhotoGridAdapter.PhotoVH)localObject).b != null))
          {
            LocalMediaInfo localLocalMediaInfo = b(i1);
            if (localLocalMediaInfo != null)
            {
              int i4 = localArrayList.indexOf(localLocalMediaInfo.path);
              if (i4 >= 0)
              {
                ((PhotoGridAdapter.PhotoVH)localObject).d.setCheckedNumber(e(i4));
                ((PhotoGridAdapter.PhotoVH)localObject).b.setVisibility(0);
                a(i1, (PhotoGridAdapter.PhotoVH)localObject, localLocalMediaInfo);
              }
              else
              {
                ((PhotoGridAdapter.PhotoVH)localObject).d.setChecked(false);
                ((PhotoGridAdapter.PhotoVH)localObject).b.setVisibility(8);
              }
            }
          }
        }
        i1 += 1;
      }
      j();
    }
  }
  
  public void b(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, PhotoGridAdapter.PhotoItemClickListener paramPhotoItemClickListener)
  {
    if (paramPhotoVH.g != null) {
      paramPhotoVH.g.setVisibility(0);
    }
    paramPhotoVH.i = paramPhotoItemClickListener;
    paramPhotoItemClickListener = new PhotoGridAdapter.5(this, paramInt, paramPhotoVH);
    paramPhotoVH.d.setOnClickListener(paramPhotoItemClickListener);
    paramPhotoVH.g.setOnClickListener(paramPhotoItemClickListener);
    paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.6(this, paramInt));
    paramPhotoVH.i.a(paramInt);
    paramPhotoVH.i.a(paramPhotoVH.d);
    ImageView localImageView = paramPhotoVH.a;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = b(paramInt);
    paramPhotoItemClickListener = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
    paramPhotoVH.itemView.setContentDescription(paramPhotoItemClickListener);
    if (localLocalMediaInfo.isSystemMeidaStore) {
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
    } else {
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
    }
    int i1 = AlbumThumbDownloader.THUMB_WIDHT;
    localLocalMediaInfo.thumbHeight = i1;
    localLocalMediaInfo.thumbWidth = i1;
    Object localObject = paramPhotoVH.e;
    if ((localObject == null) || (!((URLDrawable)localObject).getURL().equals(paramPhotoItemClickListener)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PhotoListAdapter,getView(),vedio url :");
        ((StringBuilder)localObject).append(paramPhotoItemClickListener.toString());
        QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject).toString());
      }
      paramPhotoItemClickListener = URLDrawableHelper.getDrawable(paramPhotoItemClickListener, this.c, this.b);
      paramPhotoItemClickListener.setTag(localLocalMediaInfo);
      localImageView.setImageDrawable(paramPhotoItemClickListener);
      ((URLImageView)localImageView).setURLDrawableDownListener(this);
      paramPhotoVH.e = paramPhotoItemClickListener;
    }
    paramPhotoItemClickListener = paramPhotoVH.f;
    if ((!localLocalMediaInfo.isSystemMeidaStore) && (localLocalMediaInfo.mDuration <= 0L))
    {
      paramPhotoItemClickListener.setVisibility(8);
      paramPhotoItemClickListener = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      if (paramPhotoItemClickListener != null) {
        paramPhotoItemClickListener.queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
    }
    else
    {
      paramPhotoItemClickListener.setVisibility(0);
      if (localLocalMediaInfo.mDuration < 1000L) {
        localLocalMediaInfo.mDuration = 1000L;
      }
      paramPhotoItemClickListener.setText(QAlbumUtil.formatTimeToString(localLocalMediaInfo.mDuration));
    }
    i1 = localLocalMediaInfo.selectStatus;
    a(paramPhotoVH, localLocalMediaInfo, i1);
    if (((k()) && (!d(i1))) || (!this.k.g().canPickVideo)) {
      c(paramPhotoVH);
    } else {
      b(paramPhotoVH);
    }
    localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
    localLocalMediaInfo.listViewPosition = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    int i3 = m();
    int i1 = l();
    int i2 = 1;
    if (i3 == i1)
    {
      i1 = i2;
      if (!paramBoolean) {}
    }
    else if ((i3 == l() - 1) && (paramBoolean))
    {
      i1 = i2;
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0)
    {
      i2 = this.l.findFirstVisibleItemPosition();
      i3 = this.l.findLastVisibleItemPosition();
      i1 = i2;
      while (i1 <= i3)
      {
        if (getItemViewType(i1) != 2)
        {
          Object localObject2 = this.j.getChildAt(i1 - i2);
          Object localObject1 = b(i1);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (PhotoGridAdapter.PhotoVH)this.j.getChildViewHolder((View)localObject2);
            if (((paramBoolean) || (d(((LocalMediaInfo)localObject1).selectStatus))) && (!a((LocalMediaInfo)localObject1))) {
              b((PhotoGridAdapter.PhotoVH)localObject2);
            } else {
              c((PhotoGridAdapter.PhotoVH)localObject2);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    return (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1) && (!this.k.g().canPickVideo);
  }
  
  protected String c(LocalMediaInfo paramLocalMediaInfo)
  {
    return this.n.getResources().getString(2131892559, new Object[] { Integer.valueOf(l()) });
  }
  
  public void c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        if (localLocalMediaInfo != null) {
          localLocalMediaInfo.selectStatus = 2;
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.i = true;
    if (this.m != 1)
    {
      AECirclePhotoListLogic localAECirclePhotoListLogic = this.k;
      if (localAECirclePhotoListLogic != null) {
        localAECirclePhotoListLogic.o();
      }
    }
  }
  
  public View d()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.n);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(42.0F)));
    return localFrameLayout;
  }
  
  public View e()
  {
    View localView = LayoutInflater.from(this.n).inflate(2064056339, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
    return localView;
  }
  
  public View f()
  {
    View localView = LayoutInflater.from(this.n).inflate(2064056342, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
    return localView;
  }
  
  public View g()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.n);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(this.e, this.f));
    localFrameLayout.setBackgroundColor(-1315856);
    ImageView localImageView = new ImageView(this.n);
    localImageView.setImageResource(2130853650);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(40.0F), ViewUtils.dpToPx(40.0F));
    localLayoutParams.gravity = 17;
    localFrameLayout.addView(localImageView, localLayoutParams);
    return localFrameLayout;
  }
  
  public int getItemCount()
  {
    return this.a.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ArrayUtils.isOutOfArrayIndex(paramInt, this.a)) {
      return -1;
    }
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.a.get(paramInt));
  }
  
  public void h()
  {
    this.i = false;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i1 = paramView.listViewPosition;
    if (i1 != -1)
    {
      if (paramView.visableTime == 0L) {
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      long l2 = paramView.visableTime;
      if (QLog.isColorLevel())
      {
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("onLoadSuccessed,no next ,listViewPositon:");
        paramURLDrawable.append(i1);
        paramURLDrawable.append(" costTime:");
        paramURLDrawable.append(l1 - l2);
        paramURLDrawable.append(" imageInfo;");
        paramURLDrawable.append(paramView);
        QLog.d("PhotoGridAdapter", 2, paramURLDrawable.toString());
      }
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */