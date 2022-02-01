package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
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
  public int a;
  private final Context jdField_a_of_type_AndroidContentContext;
  public ColorDrawable a;
  public Drawable a;
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public LayoutInflater a;
  AECirclePhotoListLogic jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
  public ArrayList<LocalMediaInfo> a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  private boolean b;
  int c;
  int d = 0;
  public int e = 1;
  
  public PhotoGridAdapter(Context paramContext, RecyclerView paramRecyclerView, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = ((GridLayoutManager)paramRecyclerView.getLayoutManager());
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    paramContext = paramContext.getResources();
    int i = paramContext.getDisplayMetrics().widthPixels;
    this.c = paramContext.getDimensionPixelSize(2131296692);
    this.jdField_a_of_type_Int = ((i - this.c * 2) / 3);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.setSpanSizeLookup(new PhotoGridAdapter.1(this));
  }
  
  private int a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().maxSelectNum;
  }
  
  private int a(int paramInt)
  {
    return paramInt + 1 + c();
  }
  
  private void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo)
  {
    if (AppSetting.d)
    {
      paramLocalMediaInfo = QAlbumUtil.createContentDescriptionWithCheckBox(QAlbumUtil.getMediaType(paramLocalMediaInfo), paramLocalMediaInfo, paramInt, paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription(paramLocalMediaInfo);
    }
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setSelected], path=");
    localStringBuilder.append(paramLocalMediaInfo.path);
    AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener.onClick(paramPhotoVH.jdField_a_of_type_AndroidViewView);
    paramLocalMediaInfo = paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView;
    boolean bool = false;
    paramLocalMediaInfo.setVisibility(0);
    if (c() > 0) {
      bool = true;
    }
    AEReportUtils.a(bool, true, getItemViewType(paramInt), paramInt);
  }
  
  private void a(PhotoGridAdapter.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if (a(paramInt))
    {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.indexOf(paramLocalMediaInfo.path)));
      paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (paramInt == 3)
    {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    paramList = new AECircleShowPhotoPreviewEvent(paramList, paramInt);
    SimpleEventBus.getInstance().dispatchEvent(paramList);
  }
  
  private boolean a()
  {
    return b() >= a();
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  private int b()
  {
    return d() + c();
  }
  
  private void b(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePhotoItemClick, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("PhotoGridAdapter", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked())
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
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener.onClick(paramPhotoVH.jdField_a_of_type_AndroidViewView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelSelected path = ");
    localStringBuilder.append(paramLocalMediaInfo.path);
    AEQLog.a("PhotoGridAdapter", localStringBuilder.toString());
    paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    boolean bool;
    if (c() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    AEReportUtils.a(bool, false, getItemViewType(paramInt), paramInt);
  }
  
  private void b(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if ((paramPhotoVH != null) && (paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      if (paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox == null) {
        return;
      }
      paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(false);
    }
  }
  
  private int c()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().initialHasPickedNum;
  }
  
  private void c(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().canPickVideo)
    {
      LocalMediaInfo localLocalMediaInfo = a(paramInt);
      if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(this.jdField_a_of_type_AndroidContentContext, localLocalMediaInfo)) {
        a(paramInt, paramPhotoVH);
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2064515225), 0).a();
    }
  }
  
  private void c(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if ((paramPhotoVH != null) && (paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      if (paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox == null) {
        return;
      }
      paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.3F);
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(true);
    }
  }
  
  private int d()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.size();
  }
  
  private void d()
  {
    int i = this.e;
    Object localObject;
    if (i == 1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = new LocalMediaInfo();
        ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject);
      }
    }
    else
    {
      LocalMediaInfo localLocalMediaInfo;
      if (i == 2)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
          if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      if (i == 3)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  private void e()
  {
    boolean bool = a();
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    if (j != -1)
    {
      if (k == -1) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("notifyLimitState,startPosition:");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("，endPosition:");
      ((StringBuilder)localObject1).append(k);
      QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
      int i = j;
      while (i <= k)
      {
        if (getItemViewType(i) != 2)
        {
          Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
          localObject1 = a(i);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("notifyLimitState view = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("notifyLimitState info = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
            if (((!bool) || (a(((LocalMediaInfo)localObject1).selectStatus))) && (!a((LocalMediaInfo)localObject1)) && (!b((LocalMediaInfo)localObject1))) {
              b((PhotoGridAdapter.PhotoVH)localObject2);
            } else {
              c((PhotoGridAdapter.PhotoVH)localObject2);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public View a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.b(42.0F)));
    return localFrameLayout;
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setGravity(17);
    localTextView.setTextSize(11.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(ViewUtils.b(26.0F), ViewUtils.b(16.0F));
    float f = ViewUtils.b(4.0F);
    localGradientDrawable.setCornerRadii(new float[] { f, f, f, f, f, f, f, f });
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
          return new PhotoGridAdapter.PhotoVH(this, a());
        }
        return new PhotoGridAdapter.PhotoVH(this, d());
      }
      return new PhotoGridAdapter.PhotoVH(this, c());
    }
    return new PhotoGridAdapter.PhotoVH(this, b());
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    if (ArrayUtils.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return null;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (this.d != localArrayList.size()) && (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() / 2))
      {
        this.d = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.g();
      }
    }
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694856, new Object[] { Integer.valueOf(a()) });
  }
  
  public void a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.selectedPhotoList;
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    if (j != -1)
    {
      if (k == -1) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyCheckBox,startPosition:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("，endPosition:");
      ((StringBuilder)localObject).append(k);
      QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject).toString());
      int i = j;
      while (i <= k)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
        if (localObject != null)
        {
          localObject = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
          if ((localObject != null) && (((PhotoGridAdapter.PhotoVH)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) && (((PhotoGridAdapter.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView != null))
          {
            LocalMediaInfo localLocalMediaInfo = a(i);
            if (localLocalMediaInfo != null)
            {
              int m = localArrayList.indexOf(localLocalMediaInfo.path);
              if (m >= 0)
              {
                ((PhotoGridAdapter.PhotoVH)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(m));
                ((PhotoGridAdapter.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
                a(i, (PhotoGridAdapter.PhotoVH)localObject, localLocalMediaInfo);
              }
              else
              {
                ((PhotoGridAdapter.PhotoVH)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
                ((PhotoGridAdapter.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
          }
        }
        i += 1;
      }
      e();
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  protected void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleVideoItemClickForMix, position = ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("PhotoGridAdapter", ((StringBuilder)localObject).toString());
    localObject = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked())
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
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener = paramPhotoItemClickListener;
    if (paramPhotoVH.jdField_a_of_type_AndroidViewView != null) {
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramInt);
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    paramPhotoItemClickListener = paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView;
    paramPhotoItemClickListener.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = a(paramInt);
    Object localObject = QAlbumUtil.createContentDescription(0, localLocalMediaInfo, paramInt);
    paramPhotoVH.itemView.setContentDescription((CharSequence)localObject);
    if (localLocalMediaInfo != null)
    {
      if (a(localLocalMediaInfo))
      {
        if (paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView = a();
          paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(11);
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, ViewUtils.b(4.0F), ViewUtils.b(4.0F));
          ((RelativeLayout)paramPhotoVH.itemView).addView(paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        }
        paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else if (paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      localObject = paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable;
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
        localObject = URLDrawableHelper.getDrawable((URL)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((URLDrawable)localObject).setTag(localLocalMediaInfo);
        paramPhotoItemClickListener.setImageDrawable((Drawable)localObject);
        ((URLImageView)paramPhotoItemClickListener).setURLDrawableDownListener(this);
        paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      }
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      i = localLocalMediaInfo.selectStatus;
      a(paramPhotoVH, localLocalMediaInfo, i);
      a(paramInt, paramPhotoVH, localLocalMediaInfo);
      if (((a()) && (!a(i))) || (a(localLocalMediaInfo))) {
        c(paramPhotoVH);
      } else {
        b(paramPhotoVH);
      }
      paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.3(this, localLocalMediaInfo, paramInt));
      paramPhotoItemClickListener = new PhotoGridAdapter.4(this, localLocalMediaInfo, paramPhotoVH, paramInt);
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(paramPhotoItemClickListener);
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setOnClickListener(paramPhotoItemClickListener);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.selectedPhotoList;
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    while (i <= k)
    {
      if ((!paramBoolean) || (paramInt == i))
      {
        Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
        Object localObject1 = a(i);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (localObject1 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
            ((StringBuilder)localObject1).append(i);
            QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          int m;
          if (paramInt != i)
          {
            m = localArrayList.indexOf(((LocalMediaInfo)localObject1).path);
            if (m >= 0)
            {
              localObject1 = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
              if ((localObject1 != null) && (((PhotoGridAdapter.PhotoVH)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
                ((PhotoGridAdapter.PhotoVH)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(m));
              }
            }
          }
          else
          {
            m = QAlbumUtil.getMediaType((LocalMediaInfo)localObject1);
            if ((m == 0) || (m == 1))
            {
              localObject2 = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
              if (a(((LocalMediaInfo)localObject1).selectStatus)) {
                ((PhotoGridAdapter.PhotoVH)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(localArrayList.indexOf(((LocalMediaInfo)localObject1).path)));
              } else {
                ((PhotoGridAdapter.PhotoVH)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
              }
              a(i, (PhotoGridAdapter.PhotoVH)localObject2, (LocalMediaInfo)localObject1);
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    boolean bool1 = QLog.isColorLevel();
    int i = 2;
    if (bool1)
    {
      paramView = new StringBuilder();
      paramView.append("current select count:");
      paramView.append(d());
      QLog.d("PhotoGridAdapter", 2, paramView.toString());
    }
    paramView = a(paramInt);
    int j = paramView.selectStatus;
    if ((!a(j)) && (a()))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().b >= 1000L)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, a(paramView), 0).a();
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().b = l;
      }
      return;
    }
    boolean bool2 = a(j);
    bool1 = true;
    bool2 ^= true;
    if (bool2) {
      i = 1;
    }
    paramView.selectStatus = i;
    String str = paramView.path;
    paramCheckBox = PresendPicMgr.a();
    if (bool2)
    {
      paramCheckBox = MimeHelper.getMimeType(paramView.mMimeType);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().n) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        paramCheckBox = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        paramCheckBox.c += 1;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().c == 1) {
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().a = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        paramCheckBox = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        paramCheckBox.d += 1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.add(str);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedIndex.add(paramView.position);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.put(str, paramView);
      paramCheckBox = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId);
      paramView = paramCheckBox;
      if (paramCheckBox == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId, paramView);
      }
      paramView.put(str, Integer.valueOf(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        paramView.put(str, new Pair(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId, this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumName));
      }
    }
    else
    {
      Object localObject = MimeHelper.getMimeType(paramView.mMimeType);
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().n) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject).c -= 1;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().c == 1) {
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().a = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject).d -= 1;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedPhotoList.remove(str);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedIndex.remove(paramView.position);
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.remove(str);
      if (paramCheckBox != null) {
        paramCheckBox.b(str, 1013);
      }
      paramView = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().albumId);
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
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
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
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    d();
    ThreadManager.getUIHandler().post(new PhotoGridAdapter.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public View b()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2064318479, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    return localView;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
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
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.e != 1)
    {
      AECirclePhotoListLogic localAECirclePhotoListLogic = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic;
      if (localAECirclePhotoListLogic != null) {
        localAECirclePhotoListLogic.g();
      }
    }
  }
  
  public void b(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, PhotoGridAdapter.PhotoItemClickListener paramPhotoItemClickListener)
  {
    if (paramPhotoVH.jdField_a_of_type_AndroidViewView != null) {
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener = paramPhotoItemClickListener;
    paramPhotoItemClickListener = new PhotoGridAdapter.5(this, paramInt, paramPhotoVH);
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(paramPhotoItemClickListener);
    paramPhotoVH.jdField_a_of_type_AndroidViewView.setOnClickListener(paramPhotoItemClickListener);
    paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.6(this, paramInt));
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramInt);
    paramPhotoVH.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    ImageView localImageView = paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = a(paramInt);
    paramPhotoItemClickListener = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
    paramPhotoVH.itemView.setContentDescription(paramPhotoItemClickListener);
    if (localLocalMediaInfo.isSystemMeidaStore) {
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
    } else {
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
    }
    int i = AlbumThumbDownloader.THUMB_WIDHT;
    localLocalMediaInfo.thumbHeight = i;
    localLocalMediaInfo.thumbWidth = i;
    Object localObject = paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localObject == null) || (!((URLDrawable)localObject).getURL().equals(paramPhotoItemClickListener)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PhotoListAdapter,getView(),vedio url :");
        ((StringBuilder)localObject).append(paramPhotoItemClickListener.toString());
        QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject).toString());
      }
      paramPhotoItemClickListener = URLDrawableHelper.getDrawable(paramPhotoItemClickListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramPhotoItemClickListener.setTag(localLocalMediaInfo);
      localImageView.setImageDrawable(paramPhotoItemClickListener);
      ((URLImageView)localImageView).setURLDrawableDownListener(this);
      paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable = paramPhotoItemClickListener;
    }
    paramPhotoItemClickListener = paramPhotoVH.jdField_a_of_type_AndroidWidgetTextView;
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
    i = localLocalMediaInfo.selectStatus;
    a(paramPhotoVH, localLocalMediaInfo, i);
    if (((a()) && (!a(i))) || (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().canPickVideo)) {
      c(paramPhotoVH);
    } else {
      b(paramPhotoVH);
    }
    localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
    localLocalMediaInfo.listViewPosition = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    int k = b();
    int i = a();
    int j = 1;
    if (k == i)
    {
      i = j;
      if (!paramBoolean) {}
    }
    else if ((k == a() - 1) && (paramBoolean))
    {
      i = j;
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
      i = j;
      while (i <= k)
      {
        if (getItemViewType(i) != 2)
        {
          Object localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
          Object localObject1 = a(i);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("PhotoGridAdapter", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
            if (((paramBoolean) || (a(((LocalMediaInfo)localObject1).selectStatus))) && (!a((LocalMediaInfo)localObject1))) {
              b((PhotoGridAdapter.PhotoVH)localObject2);
            } else {
              c((PhotoGridAdapter.PhotoVH)localObject2);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    return (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1) && (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a().canPickVideo);
  }
  
  public View c()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2064318482, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    return localView;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public View d()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    localFrameLayout.setBackgroundColor(-1315856);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2064056659);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.b(40.0F), ViewUtils.b(40.0F));
    localLayoutParams.gravity = 17;
    localFrameLayout.addView(localImageView, localLayoutParams);
    return localFrameLayout;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ArrayUtils.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return -1;
    }
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i = paramView.listViewPosition;
    if (i != -1)
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
        paramURLDrawable.append(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */