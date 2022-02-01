package com.tencent.aelight.camera.ae.album.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout;
import com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout;
import com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout.OnTouchCallback;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.ae.album.nocropper.AECropperView;
import com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AEAbstractPhotoListFragment
  extends Fragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AEAlbumPreviewMaskLayout.OnTouchCallback, AEAbstractAlbumListFragment.IAlbumListBack
{
  Dialog A;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> B;
  private FrameLayout C;
  private FrameLayout D;
  private BubbleTextView E;
  private ImageView F;
  private Runnable G;
  private boolean H = false;
  private TextView I;
  private LottieDrawable J;
  private LottieDrawable K;
  private Drawable L;
  private Drawable M;
  private boolean N;
  public AEPhotoListLogic a;
  PhotoListBaseData b;
  public AEAbstractAlbumListFragment c;
  public AEAbstractPhotoListFragment.PhotoGridAdapter d = null;
  SharedPreferences e;
  public int f;
  public int g;
  int h;
  public int i;
  public AEAlbumLinearLayout j;
  public GridLayoutManager k;
  public AECropperView l;
  public BaseVideoView m;
  public ViewGroup n;
  public ImageView o;
  public TextView p;
  public AEAlbumPreviewMaskLayout q;
  public RecyclerView r;
  public TextView s;
  public TextView t;
  View u;
  TextView v;
  View w;
  LinearLayout x;
  FrameLayout y;
  public final boolean z = AEThemeUtil.b();
  
  @Nullable
  private LocalMediaInfo a(Object paramObject)
  {
    LocalMediaInfo localLocalMediaInfo1;
    if ((this.a.c != null) && (this.a.c.selectedMediaInfoHashMap != null)) {
      localLocalMediaInfo1 = (LocalMediaInfo)this.a.c.selectedMediaInfoHashMap.get(paramObject);
    } else {
      localLocalMediaInfo1 = null;
    }
    LocalMediaInfo localLocalMediaInfo2 = localLocalMediaInfo1;
    if (localLocalMediaInfo1 == null)
    {
      localLocalMediaInfo2 = localLocalMediaInfo1;
      if (this.a.c != null)
      {
        localLocalMediaInfo2 = localLocalMediaInfo1;
        if (this.a.c.allMediaInfoHashMap != null) {
          localLocalMediaInfo2 = (LocalMediaInfo)this.a.c.allMediaInfoHashMap.get(paramObject);
        }
      }
    }
    return localLocalMediaInfo2;
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 180.0F;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 360.0F;
    } else {
      f2 = 180.0F;
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(300L);
    localRotateAnimation.setFillAfter(true);
    paramView.startAnimation(localRotateAnimation);
  }
  
  private void b(View paramView)
  {
    this.F = ((ImageView)paramView.findViewById(2063991172));
    this.m = ((BaseVideoView)QQVideoViewFactory.createBaseVideoView(getActivity(), 113L, null, null));
    this.D.post(new AEAbstractPhotoListFragment.5(this));
    this.m.setOnClickListener(new AEAbstractPhotoListFragment.6(this));
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.I;
    if (localObject == null) {
      return;
    }
    if (paramBoolean1)
    {
      ((TextView)localObject).setVisibility(0);
      localObject = this.l;
      int i1;
      if (localObject != null) {
        i1 = ((AECropperView)localObject).getRatioType();
      } else {
        i1 = 1;
      }
      if (i1 == 1)
      {
        localObject = this.K;
        if (localObject == null)
        {
          LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_expand.json", new AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener(this, paramBoolean2, true));
          return;
        }
        if (paramBoolean2) {
          ((LottieDrawable)localObject).playAnimation();
        } else {
          ((LottieDrawable)localObject).setProgress(1.0F);
        }
        this.I.setCompoundDrawables(this.K, null, null, null);
      }
      else if (i1 == 2)
      {
        localObject = this.J;
        if (localObject == null)
        {
          LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_shrink.json", new AEAbstractPhotoListFragment.ScaleLottieCompositionLoaderListener(this, paramBoolean2, false));
          return;
        }
        if (paramBoolean2) {
          ((LottieDrawable)localObject).playAnimation();
        } else {
          ((LottieDrawable)localObject).setProgress(1.0F);
        }
        this.I.setCompoundDrawables(this.J, null, null, null);
      }
      this.I.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(4.0F));
      return;
    }
    ((TextView)localObject).setVisibility(8);
  }
  
  private void e(boolean paramBoolean)
  {
    AECircleMultiUnit.a(paramBoolean ^ true, getActivity());
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = getResources().getDimensionPixelSize(2063859717);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.C.getLayoutParams();
    localMarginLayoutParams.bottomMargin = i1;
    this.C.setLayoutParams(localMarginLayoutParams);
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.L == null)
      {
        this.L = getResources().getDrawable(2063925591);
        this.L.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(30.0F));
      }
      this.s.setCompoundDrawables(this.L, null, null, null);
      this.s.setText(2064187452);
    }
    else
    {
      if (this.M == null)
      {
        this.M = getResources().getDrawable(2063925590);
        this.M.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0F), ImmersiveUtils.dpToPx(30.0F));
      }
      this.s.setCompoundDrawables(this.M, null, null, null);
      this.s.setText(2064187453);
    }
    this.s.setPadding(0, 0, ImmersiveUtils.dpToPx(10.0F), 0);
  }
  
  public void a()
  {
    this.a.h();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.a.c.selectedPhotoList;
    int i2 = ((GridLayoutManager)this.r.getLayoutManager()).findFirstVisibleItemPosition();
    int i3 = ((GridLayoutManager)this.r.getLayoutManager()).findLastVisibleItemPosition();
    int i1 = i2;
    while (i1 <= i3)
    {
      if ((!paramBoolean) || (paramInt == i1))
      {
        Object localObject2 = this.r.getChildAt(i1 - i2);
        LocalMediaInfo localLocalMediaInfo = this.d.a(i1);
        Object localObject1;
        if (localObject2 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
            ((StringBuilder)localObject1).append(i1);
            QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else if (localLocalMediaInfo == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
            ((StringBuilder)localObject1).append(i1);
            QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          int i4;
          if (paramInt != i1)
          {
            i4 = localArrayList.indexOf(localLocalMediaInfo.path);
            if (i4 >= 0)
            {
              localObject1 = (AEAbstractPhotoListFragment.PhotoVH)this.r.getChildViewHolder((View)localObject2);
              if ((localObject1 != null) && (((AEAbstractPhotoListFragment.PhotoVH)localObject1).e != null)) {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).e.setCheckedNumber(i4 + 1 + this.a.e.initialHasPickedNum);
              }
            }
          }
          else
          {
            i4 = QAlbumUtil.getMediaType(localLocalMediaInfo);
            if ((i4 == 0) || (i4 == 1))
            {
              localObject1 = (AEAbstractPhotoListFragment.PhotoVH)this.r.getChildViewHolder((View)localObject2);
              int i5 = localLocalMediaInfo.selectStatus;
              if (i5 == 1)
              {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).e.setCheckedNumber(localArrayList.indexOf(localLocalMediaInfo.path) + 1 + this.a.e.initialHasPickedNum);
                if (((View)localObject2).getBackground() != null) {
                  ((View)localObject2).setBackgroundDrawable(null);
                }
              }
              else if (i5 == 3)
              {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).e.setChecked(false);
              }
              else
              {
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).e.setChecked(false);
                if (((View)localObject2).getBackground() != null) {
                  ((View)localObject2).setBackgroundDrawable(null);
                }
              }
              if (AppSetting.e)
              {
                localObject2 = QAlbumUtil.createContentDescriptionWithCheckBox(i4, localLocalMediaInfo, i1, ((AEAbstractPhotoListFragment.PhotoVH)localObject1).e.isChecked());
                ((AEAbstractPhotoListFragment.PhotoVH)localObject1).e.setContentDescription((CharSequence)localObject2);
              }
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  protected void a(View paramView)
  {
    this.y = ((FrameLayout)paramView.findViewById(2063990877));
    this.u = paramView.findViewById(2063991165);
    this.t = ((TextView)paramView.findViewById(2063991166));
    this.u.setVisibility(0);
    this.u.setOnClickListener(this);
    this.t.setVisibility(0);
    this.t.setOnClickListener(this);
    this.v = ((TextView)paramView.findViewById(2063991168));
    String str;
    if (this.a.c.albumName != null) {
      str = this.a.c.albumName;
    } else if (this.a.c.showMediaType == 2) {
      str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
    } else {
      str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    }
    a(str);
    this.w = paramView.findViewById(2063991167);
    this.x = ((LinearLayout)paramView.findViewById(2063991164));
    this.x.setOnClickListener(this);
    this.C = ((FrameLayout)paramView.findViewById(2063991092));
    this.j = ((AEAlbumLinearLayout)paramView.findViewById(2063990863));
    this.j.setScrollListener(new AEAbstractPhotoListFragment.3(this));
    this.l = ((AECropperView)paramView.findViewById(2063990864));
    this.l.setMaxZoom(5.0F);
    this.E = ((BubbleTextView)paramView.findViewById(2063991463));
    this.q = ((AEAlbumPreviewMaskLayout)paramView.findViewById(2063991093));
    this.q.setOnTouchCallback(this);
    this.n = ((ViewGroup)paramView.findViewById(2063991236));
    this.o = ((ImageView)paramView.findViewById(2063991200));
    this.p = ((TextView)paramView.findViewById(2063991553));
    this.r = ((RecyclerView)paramView.findViewById(2063991298));
    ((DefaultItemAnimator)this.r.getItemAnimator()).setSupportsChangeAnimations(false);
    this.k = new GridLayoutManager(getActivity(), 3);
    this.r.setLayoutManager(this.k);
    this.d = new AEAbstractPhotoListFragment.PhotoGridAdapter(this);
    this.r.setAdapter(this.d);
    this.D = ((FrameLayout)paramView.findViewById(2063991320));
    b(paramView);
    this.s = ((TextView)paramView.findViewById(2063991543));
    this.s.setOnClickListener(new AEAbstractPhotoListFragment.4(this));
    this.I = ((TextView)paramView.findViewById(2063991557));
    this.I.setOnClickListener(this);
    this.a.c();
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAlbumListChoose--albumId=");
      localStringBuilder.append(paramQQAlbumInfo.id);
      AEQLog.b("PhotoListActivity", localStringBuilder.toString());
      this.a.c.albumName = paramQQAlbumInfo.name;
      this.a.c.albumId = paramQQAlbumInfo.id;
      if (this.a.c.albumName != null) {
        paramQQAlbumInfo = this.a.c.albumName;
      } else {
        paramQQAlbumInfo = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      }
      a(paramQQAlbumInfo);
      this.b.y = true;
      getActivity().runOnUiThread(new AEAbstractPhotoListFragment.8(this));
    }
    c(false);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    getActivity().setTitle(paramCharSequence);
    this.v.setText(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    if (this.b.N)
    {
      QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
      QAlbumUtil.sLastAlbumPhotoCountMap.put(this.a.c.albumId, Integer.valueOf(this.d.getItemCount()));
      if (!TextUtils.isEmpty(paramString))
      {
        QAlbumUtil.sLastAlbumPath = paramString;
        HashMap localHashMap = QAlbumUtil.sSelectItemAlbum;
        if (localHashMap.containsKey(paramString))
        {
          paramString = (Pair)localHashMap.get(paramString);
          QAlbumUtil.sLastAlbumId = (String)paramString.first;
          QAlbumUtil.sLastAlbumName = (String)paramString.second;
          QAlbumUtil.putLastAlbumInfo(getActivity(), QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
        }
      }
    }
    QAlbumUtil.clearSelectItemInfo();
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.F;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.B = new AEAbstractPhotoListFragment.QueryPhotoTask(this, paramBoolean1, paramBoolean2);
    this.B.execute(new Object[0]);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public void b()
  {
    c(false);
  }
  
  @MainThread
  public void b(boolean paramBoolean)
  {
    f(paramBoolean);
    e(paramBoolean);
  }
  
  protected abstract AEPhotoListLogic c();
  
  public void c(boolean paramBoolean)
  {
    if (this.c == null) {
      if (paramBoolean)
      {
        this.c = d();
        this.c.a(this);
      }
      else
      {
        return;
      }
    }
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    ObjectAnimator localObjectAnimator;
    if ((paramBoolean) && (!this.c.isAdded()))
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.y, "backgroundColor", new int[] { getResources().getColor(2131165795), getResources().getColor(2131165806) });
      a(this.w, false);
      localFragmentTransaction.add(2063990877, this.c, null);
    }
    else
    {
      localObjectAnimator = ObjectAnimator.ofInt(this.y, "backgroundColor", new int[] { getResources().getColor(2131165806), getResources().getColor(2131165795) });
      a(this.w, true);
      localFragmentTransaction.remove(this.c);
    }
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.commit();
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.start();
    this.a.c(paramBoolean);
  }
  
  public abstract AEAbstractAlbumListFragment d();
  
  public void d(boolean paramBoolean)
  {
    int i1 = this.a.c.selectedPhotoList.size() + this.a.e.initialHasPickedNum;
    if (((i1 == this.a.c.maxSelectNum) && (!paramBoolean)) || ((i1 == this.a.c.maxSelectNum - 1) && (paramBoolean))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      int i2 = ((GridLayoutManager)this.r.getLayoutManager()).findFirstVisibleItemPosition();
      int i3 = ((GridLayoutManager)this.r.getLayoutManager()).findLastVisibleItemPosition();
      i1 = i2;
      while (i1 <= i3)
      {
        if (this.d.getItemViewType(i1) != 2)
        {
          Object localObject2 = this.r.getChildAt(i1 - i2);
          Object localObject1 = this.d.a(i1);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox view = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("updateCheckbox info = null at ");
              ((StringBuilder)localObject1).append(i1);
              QLog.d("PhotoListActivity", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            localObject2 = (AEAbstractPhotoListFragment.PhotoVH)this.r.getChildViewHolder((View)localObject2);
            if ((!paramBoolean) && (((LocalMediaInfo)localObject1).selectStatus != 1)) {
              ((AEAbstractPhotoListFragment.PhotoVH)localObject2).b.setAlpha(0.3F);
            } else {
              ((AEAbstractPhotoListFragment.PhotoVH)localObject2).b.setAlpha(1.0F);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public abstract Class e();
  
  public void f()
  {
    b(true, false);
    h();
  }
  
  public void g()
  {
    b(false, false);
    i();
  }
  
  public void h()
  {
    if (this.E.getVisibility() != 0)
    {
      if (AECameraPrefsUtil.a().b("sp_key_ae_photo_switch_ratio_tips", false, 0)) {
        return;
      }
      this.E.setIncludeFontPadding(false);
      int i1 = UIUtils.a(getActivity(), 8.0F);
      int i2 = UIUtils.a(getActivity(), 6.0F);
      this.E.setPadding(i1, i2, i1, i2);
      this.E.setTextSize(1, 14.0F);
      this.E.setTextColor(-1);
      this.E.e = Color.parseColor("#252525");
      this.E.b = UIUtils.a(getActivity(), 6.0F);
      Object localObject = this.E;
      ((BubbleTextView)localObject).g = false;
      ((BubbleTextView)localObject).d = UIUtils.a(getActivity(), 6.0F);
      this.E.setText(getActivity().getString(2064187434));
      this.E.a();
      this.E.setVisibility(0);
      boolean bool = AECameraPrefsUtil.a().b("sp_key_ae_photo_switch_ratio_tips_should_auto_disappear", true, 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkShowSwitchRatioTips--shouldAutoDisappear=");
      ((StringBuilder)localObject).append(bool);
      AEQLog.a("PhotoListActivity", ((StringBuilder)localObject).toString());
      if (bool)
      {
        this.G = new AEAbstractPhotoListFragment.7(this);
        this.E.postDelayed(this.G, 5000L);
      }
    }
  }
  
  public void i()
  {
    if (this.E.getVisibility() == 0)
    {
      Runnable localRunnable = this.G;
      if (localRunnable != null) {
        this.E.removeCallbacks(localRunnable);
      }
      this.E.setVisibility(8);
      AECameraPrefsUtil.a().a("sp_key_ae_photo_switch_ratio_tips", true, 0);
    }
  }
  
  public void j()
  {
    try
    {
      if (this.A != null)
      {
        l();
      }
      else
      {
        this.A = k();
        this.A.setCancelable(true);
        this.A.show();
      }
      if (!this.A.isShowing())
      {
        this.A.show();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "show dialog error", localException);
      }
      this.A = null;
    }
  }
  
  protected Dialog k()
  {
    return new Dialog(getActivity());
  }
  
  public void l()
  {
    Dialog localDialog = this.A;
    if (localDialog != null) {
      try
      {
        localDialog.cancel();
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListActivity", 2, "cancel dialog error", localIllegalArgumentException);
        }
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131442912) {
      this.a.a(paramCompoundButton, paramBoolean);
    }
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    if (this.a == null) {
      return;
    }
    int i1 = paramView.getId();
    if (i1 == 2063991165)
    {
      this.a.a(paramView);
      return;
    }
    if (i1 == 2131440614)
    {
      this.a.b(paramView);
      return;
    }
    if (i1 == 2131445580)
    {
      this.a.c(paramView);
      return;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 == 2063991164)
    {
      paramView = this.c;
      if ((paramView == null) || (!paramView.isAdded())) {
        bool1 = true;
      }
      if (bool1) {
        this.a.b(getActivity().getIntent());
      }
      c(bool1);
      return;
    }
    if (i1 == 2063991166)
    {
      this.a.e(paramView);
      if ((this.a.c != null) && (this.a.c.selectedPhotoList != null))
      {
        int i2 = this.a.c.selectedPhotoList.size();
        AEBaseReportParam.a().n().d = AEBaseReportParam.a().S();
        if (this.a.e.canMixPhotoAndVideo)
        {
          AEBaseReportParam.a().n().v = AEBaseReportParam.g.longValue();
          paramView = this.a.c.selectedPhotoList.iterator();
          long l1 = 0L;
          i1 = 0;
          while (paramView.hasNext())
          {
            LocalMediaInfo localLocalMediaInfo = a(paramView.next());
            if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1))
            {
              i1 += 1;
              l1 += localLocalMediaInfo.mDuration / 1000L;
            }
          }
          AEBaseReportParam.a().n().w = i1;
          AEBaseReportParam.a().n().x = l1;
          i2 -= i1;
        }
        else
        {
          AEBaseReportParam.a().n().v = AEBaseReportParam.d.longValue();
          i1 = 0;
        }
        AEBaseDataReporter.a().a(i2);
        bool1 = bool2;
        if (this.a.e.initialHasPickedNum > 0) {
          bool1 = true;
        }
        AEReportUtils.a(bool1, i2, i1, "1");
      }
    }
    else if (i1 == 2063991557)
    {
      this.a.d(paramView);
      i();
      b(true, true);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    this.a = c();
    this.b = this.a.d;
    this.e = BaseApplication.getContext().getSharedPreferences("share", 4);
    paramBundle = getResources();
    int i1 = paramBundle.getDisplayMetrics().widthPixels;
    this.h = paramBundle.getDimensionPixelSize(2131297020);
    this.f = ((i1 - this.h * 2) / 3);
    this.g = this.f;
    paramBundle = getActivity().getIntent();
    this.a.a(paramBundle);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListActivity onCreate(),extra is:");
      localStringBuilder.append(paramBundle.getExtras());
      QLog.d("SelectPhotoTrace", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("PhotoListActivity,hashCode is:");
      paramBundle.append(System.identityHashCode(this));
      QLog.d("SelectPhotoTrace", 2, paramBundle.toString());
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2064056360, paramViewGroup, false);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new AEAbstractPhotoListFragment.1(this));
    if (paramLayoutInflater != null) {
      paramLayoutInflater.post(new AEAbstractPhotoListFragment.2(this, paramLayoutInflater));
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.g();
    Object localObject = this.j;
    if (localObject != null) {
      ((AEAlbumLinearLayout)localObject).setScrollListener(null);
    }
    localObject = this.q;
    if (localObject != null) {
      ((AEAlbumPreviewMaskLayout)localObject).setOnTouchCallback(null);
    }
  }
  
  public void onPause()
  {
    AEQLog.b("PhotoListActivity", "onPause---");
    super.onPause();
    this.B = null;
    i();
    BaseVideoView localBaseVideoView = this.m;
    if ((localBaseVideoView != null) && (localBaseVideoView.isPlaying()))
    {
      this.H = true;
      this.m.pause();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("PhotoListActivity", "onResume---");
    super.onResume();
    this.a.f();
    BaseVideoView localBaseVideoView = this.m;
    if ((localBaseVideoView != null) && (this.H))
    {
      this.H = false;
      localBaseVideoView.resume();
    }
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment
 * JD-Core Version:    0.7.0.1
 */