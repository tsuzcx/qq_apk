package com.tencent.mobileqq.activity.photo.album.photolist;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.IAlbumListChoose;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PhotoGridView;
import com.tencent.widget.PhotoGridView.OnSelectListener;
import com.tencent.widget.TriangleView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PhotoListSceneBase
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IAlbumListChoose, ISceneCallBack
{
  public PeakFragmentActivity a;
  public AbstractAlbumListFragment b;
  PhotoGridView.OnSelectListener c = new GridSelectListener(this);
  public PhotoListCustomization<? extends OtherCommonData> d;
  public PhotoListBaseData e;
  public RelativeLayout f;
  public View g;
  public View h;
  public View i;
  public FrameLayout j;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> k;
  public PhotoGridView l;
  public GridLayoutManager m;
  public TextView n;
  public Button o;
  public TextView p;
  public TextView q;
  public TriangleView r;
  public LinearLayout s;
  public PhotoListAdapter t = null;
  
  public PhotoListSceneBase(PhotoListCustomization<? extends OtherCommonData> paramPhotoListCustomization)
  {
    this.d = paramPhotoListCustomization;
    if (paramPhotoListCustomization != null)
    {
      this.a = paramPhotoListCustomization.d;
      this.e = this.d.g;
      this.c = new GridSelectListener(this);
    }
  }
  
  private void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2, View paramView, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramInt1 != paramInt2)
    {
      paramInt1 = paramArrayList.indexOf(paramLocalMediaInfo.path);
      if (paramInt1 >= 0)
      {
        paramArrayList = (Holder)paramView.getTag();
        if ((paramArrayList != null) && (paramArrayList.f != null)) {
          paramArrayList.f.setCheckedNumber(paramInt1 + 1);
        }
      }
    }
    else
    {
      paramInt1 = QAlbumUtil.getMediaType(paramLocalMediaInfo);
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        Holder localHolder = (Holder)paramView.getTag();
        int i1 = paramLocalMediaInfo.selectStatus;
        if (i1 == 1)
        {
          if (localHolder.f != null) {
            localHolder.f.setCheckedNumber(paramArrayList.indexOf(paramLocalMediaInfo.path) + 1);
          }
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
        else if (i1 == 3)
        {
          if (localHolder.f != null) {
            localHolder.f.setChecked(false);
          }
        }
        else
        {
          if (localHolder.f != null) {
            localHolder.f.setChecked(false);
          }
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
        if ((AppSetting.e) && (localHolder.f != null))
        {
          paramArrayList = QAlbumUtil.createContentDescriptionWithCheckBox(paramInt1, paramLocalMediaInfo, paramInt2, localHolder.f.isChecked());
          localHolder.f.setContentDescription(paramArrayList);
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    int i1 = this.d.e.maxSelectNum;
    boolean bool = true;
    if ((paramInt != i1) || (paramBoolean))
    {
      if ((paramInt == this.d.e.maxSelectNum - 1) && (paramBoolean)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public View a()
  {
    this.f = new RelativeLayout(this.a);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.g = this.d.m();
    localObject = this.g;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.d.n();
      if (localObject != null) {
        this.f.addView(this.g, (ViewGroup.LayoutParams)localObject);
      } else {
        this.f.addView(this.g);
      }
    }
    this.h = this.d.o();
    localObject = this.h;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.d.p();
      if (localObject != null) {
        this.f.addView(this.h, (ViewGroup.LayoutParams)localObject);
      } else {
        this.f.addView(this.g);
      }
    }
    this.i = this.d.q();
    localObject = this.i;
    if (localObject != null)
    {
      ((View)localObject).setId(View.generateViewId());
      localObject = this.d.r();
      if (localObject != null) {
        this.f.addView(this.i, (ViewGroup.LayoutParams)localObject);
      } else {
        this.f.addView(this.i);
      }
    }
    this.j = new FrameLayout(this.a);
    this.j.setId(View.generateViewId());
    this.j.setBackgroundColor(this.a.getResources().getColor(2131165795));
    localObject = this.d.s();
    if (localObject != null) {
      this.f.addView(this.j, (ViewGroup.LayoutParams)localObject);
    } else {
      this.f.addView(this.j);
    }
    return this.f;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.d.e.selectedPhotoList;
    int i2 = this.m.findFirstVisibleItemPosition();
    int i3 = this.m.findLastVisibleItemPosition();
    int i1 = i2;
    while (i1 <= i3)
    {
      if ((!paramBoolean) || (paramInt == i1))
      {
        Object localObject = this.l.getChildAt(i1 - i2);
        LocalMediaInfo localLocalMediaInfo = this.t.a(i1);
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateCheckbox view = null at ");
            ((StringBuilder)localObject).append(i1);
            QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateCheckbox info = null at ");
            ((StringBuilder)localObject).append(i1);
            QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
          }
        }
        else {
          a(paramInt, localArrayList, i1, (View)localObject, localLocalMediaInfo);
        }
      }
      i1 += 1;
    }
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TextView localTextView = this.q;
      if (this.d.e.albumName != null) {
        paramQQAlbumInfo = this.d.e.albumName;
      } else {
        paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
      localTextView.setText(paramQQAlbumInfo);
      this.e.y = true;
      this.d.e.createMediaQueryHelper(this.a);
      this.a.runOnUiThread(new PhotoListSceneBase.2(this));
    }
    a(false);
  }
  
  public void a(String paramString)
  {
    if (this.e.N)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.d.e.albumId, Integer.valueOf(this.t.getItemCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(this.a, QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      if (paramBoolean)
      {
        this.b = this.d.j();
        this.b.a = this;
      }
      else
      {
        return;
      }
    }
    FragmentManager localFragmentManager = this.a.getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
    localFragmentTransaction.setTransition(4097);
    if (paramBoolean)
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.j, "backgroundColor", new int[] { this.a.getResources().getColor(2131165795), this.a.getResources().getColor(2131165806) });
      QAlbumUtil.rotate180Degrees(this.r, false);
      if ((this.b.isAdded()) || (localFragmentManager.findFragmentByTag(this.b.toString()) != null)) {}
    }
    try
    {
      localFragmentTransaction.add(this.j.getId(), this.b, this.b.toString());
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label165:
      break label165;
    }
    localFragmentTransaction.show(this.b);
    break label251;
    localFragmentTransaction.show(this.b);
    break label251;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.j, "backgroundColor", new int[] { this.a.getResources().getColor(2131165806), this.a.getResources().getColor(2131165795) });
    QAlbumUtil.rotate180Degrees(this.r, true);
    localFragmentTransaction.hide(this.b);
    label251:
    localFragmentTransaction.commit();
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.start();
    this.d.a(paramBoolean);
  }
  
  public void b()
  {
    View localView = this.g;
    if (localView != null)
    {
      this.p = ((TextView)localView.findViewById(2131436180));
      this.q = ((TextView)this.g.findViewById(2131436227));
      this.r = ((TriangleView)this.g.findViewById(2131436224));
      this.s = ((LinearLayout)this.g.findViewById(2131436174));
    }
    localView = this.h;
    if (localView != null)
    {
      this.n = ((TextView)localView.findViewById(2131440614));
      this.o = ((Button)this.h.findViewById(2131445580));
    }
    localView = this.i;
    if (localView != null) {
      this.l = ((PhotoGridView)localView.findViewById(2131440141));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (a(paramBoolean, this.d.e.selectedPhotoList.size()))
    {
      int i2 = this.m.findFirstVisibleItemPosition();
      int i3 = this.m.findLastVisibleItemPosition();
      int i1 = i2;
      while (i1 <= i3)
      {
        if (this.t.getItemViewType(i1) != 2)
        {
          Object localObject2 = this.l.getChildAt(i1 - i2);
          Object localObject1 = this.t.a(i1);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (Holder)((View)localObject2).getTag();
            if ((!paramBoolean) && (((LocalMediaInfo)localObject1).selectStatus != 1)) {
              ((Holder)localObject2).b.setAlpha(0.3F);
            } else {
              ((Holder)localObject2).b.setAlpha(1.0F);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  protected void c()
  {
    b();
    Object localObject = this.p;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      this.p.setOnClickListener(this);
    }
    TextView localTextView = this.q;
    if (localTextView != null)
    {
      if (this.d.e.albumName != null) {
        localObject = this.d.e.albumName;
      } else if (this.d.e.showMediaType == 2) {
        localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      } else {
        localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
      localTextView.setText((CharSequence)localObject);
    }
    localObject = this.r;
    if (localObject != null) {
      ((TriangleView)localObject).setColor(this.q.getCurrentTextColor());
    }
    localObject = this.s;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener(this);
    }
    this.m = new GridLayoutManager(this.a, this.d.g.M);
    this.l.setScrollBarStyle(0);
    this.t = new PhotoListAdapter(this.d);
    localObject = this.l;
    if (localObject != null)
    {
      ((PhotoGridView)localObject).setLayoutManager(this.m);
      this.l.setAdapter(this.t);
      this.l.setOnIndexChangedListener(this.c);
      this.l.addOnScrollListener(new PhotoListSceneBase.1(this));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.d.e.mMediaQueryHelper != null))
    {
      this.d.e.mMediaQueryHelper.close();
      this.d.e.mMediaQueryHelper = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListSceneBase,excuteQueryPhotoTask: needNew = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    this.k = new QueryPhotoTask(this.d);
    this.k.execute(new Object[0]);
  }
  
  public void d()
  {
    int i2 = this.m.findFirstVisibleItemPosition();
    int i3 = this.m.findLastVisibleItemPosition();
    int i1 = i2;
    while (i1 <= i3)
    {
      Object localObject = this.l.getChildAt(i1 - i2);
      LocalMediaInfo localLocalMediaInfo = this.t.a(i1);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCheckbox view = null at ");
          ((StringBuilder)localObject).append(i1);
          QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCheckbox info = null at ");
          ((StringBuilder)localObject).append(i1);
          QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        int i4 = this.d.e.selectedPhotoList.indexOf(localLocalMediaInfo.path);
        if (i4 >= 0)
        {
          localObject = (Holder)((View)localObject).getTag();
          if ((localObject != null) && (((Holder)localObject).f != null)) {
            ((Holder)localObject).f.setCheckedNumber(i4 + 1);
          }
        }
      }
      i1 += 1;
    }
  }
  
  @TargetApi(8)
  public File e()
  {
    Object localObject1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("JPEG_");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_");
    String str = ((StringBuilder)localObject2).toString();
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      boolean bool = false;
      if (Build.VERSION.SDK_INT > 7)
      {
        localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        bool = true;
      }
      else
      {
        localObject2 = new File(Environment.getExternalStorageDirectory(), "DCIM");
        localObject1 = localObject2;
        if (!((File)localObject2).exists())
        {
          bool = ((File)localObject2).mkdirs();
          localObject1 = localObject2;
        }
      }
      if (bool)
      {
        localObject1 = File.createTempFile(str, ".jpg", (File)localObject1);
        this.e.A = ((File)localObject1).getAbsolutePath();
        return localObject1;
      }
    }
    return null;
  }
  
  public void f()
  {
    if (!this.d.e.mMediaQueryHelper.mTraversalDone) {
      new QueryNextTask(this.d).execute(new Object[0]);
    }
  }
  
  public View m()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.a.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131627643, null);
    }
    return localView;
  }
  
  public RelativeLayout.LayoutParams n()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      return new RelativeLayout.LayoutParams(this.g.getLayoutParams());
    }
    localObject = new RelativeLayout.LayoutParams(-1, (int)this.a.getResources().getDimension(2131299920));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    return localObject;
  }
  
  public View o()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.a.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131627639, null);
    }
    return localView;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131442912) {
      this.d.a(paramCompoundButton, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131436180)
    {
      this.d.b(paramView);
    }
    else if (i1 == 2131440614)
    {
      this.d.c(paramView);
    }
    else if (i1 == 2131445580)
    {
      this.d.a(paramView);
    }
    else if (i1 == 2131436174)
    {
      AbstractAlbumListFragment localAbstractAlbumListFragment = this.b;
      boolean bool;
      if ((localAbstractAlbumListFragment != null) && (localAbstractAlbumListFragment.isAdded()) && (!this.b.isHidden())) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        this.d.c(this.a.getIntent());
      }
      a(bool);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public RelativeLayout.LayoutParams p()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      return new RelativeLayout.LayoutParams(this.h.getLayoutParams());
    }
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    return localObject;
  }
  
  public View q()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.a.getSystemService("layout_inflater");
    View localView = null;
    if (localLayoutInflater != null) {
      localView = localLayoutInflater.inflate(2131627638, null);
    }
    return localView;
  }
  
  public RelativeLayout.LayoutParams r()
  {
    Object localObject = this.i;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null)) {
      localObject = new RelativeLayout.LayoutParams(this.i.getLayoutParams());
    } else {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
    }
    View localView = this.g;
    if (localView != null) {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, localView.getId());
    }
    localView = this.h;
    if (localView != null) {
      ((RelativeLayout.LayoutParams)localObject).addRule(2, localView.getId());
    }
    return localObject;
  }
  
  public RelativeLayout.LayoutParams s()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    View localView = this.g;
    if (localView != null) {
      localLayoutParams.addRule(3, localView.getId());
    }
    return localLayoutParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase
 * JD-Core Version:    0.7.0.1
 */