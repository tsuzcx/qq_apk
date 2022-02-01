package com.tencent.common.galleryactivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ViscousFluidInterpolator;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import com.tencent.widget.Gallery.OnItemRotateListener;
import com.tencent.widget.Gallery.OnScollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class AbstractGalleryScene
  extends ImageScene
  implements AnimationLister, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener, Gallery.OnItemRotateListener, Gallery.OnScollListener
{
  public Activity a;
  public RelativeLayout a;
  protected AbstractGalleryPageView a;
  protected AbstractImageAdapter a;
  protected AbstractImageListModel a;
  protected AbstractProgressView a;
  AnimationLister a;
  public Gallery a;
  protected int b;
  protected View d;
  public boolean g = false;
  
  public AbstractGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister = new AbstractGalleryScene.1(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561450, null);
  }
  
  protected AbstractGalleryPageView a(Context paramContext)
  {
    return new GalleryPageView();
  }
  
  public AbstractImageAdapter a()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  protected abstract AbstractImageAdapter a(Context paramContext);
  
  protected AbstractProgressView a()
  {
    return new GalleryProgressView();
  }
  
  public Gallery a()
  {
    return this.jdField_a_of_type_ComTencentWidgetGallery;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b();
    }
    if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b())) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onScrollStart:" + paramInt);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
    if (paramViewGroup == null) {
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      b((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377356));
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131367677));
      this.d = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363419);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView = a(this.jdField_a_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView != null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(this.jdField_a_of_type_AndroidAppActivity, this, this.b);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView = a();
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a(this.jdField_a_of_type_AndroidAppActivity, this);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel);
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null)
      {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView);
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297168));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.b());
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemRotateListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnScollListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.d.getAnimation() != null) {
      this.d.clearAnimation();
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery.getAnimation() != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.clearAnimation();
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
    localAlphaAnimation.setFillAfter(true);
    if (paramBoolean2)
    {
      this.d.startAnimation(localAlphaAnimation);
      return;
    }
    localAlphaAnimation.setAnimationListener(new AbstractGalleryScene.2(this));
    a().startAnimation(localAlphaAnimation);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (!this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onScrollEnd:" + paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (b())
    {
      a(paramBoolean, this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().b());
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setBackgroundColor(-16777216);
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.f();
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramBoolean1, paramBoolean2);
    if (this.d.getAnimation() != null) {
      this.d.clearAnimation();
    }
    if (a().getAnimation() != null) {
      a().clearAnimation();
    }
    if (paramBoolean2)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      this.d.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new ViscousFluidInterpolator());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, this.jdField_a_of_type_AndroidViewViewGroup.getWidth() / 2, this.jdField_a_of_type_AndroidViewViewGroup.getHeight() / 2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new AbstractGalleryScene.3(this));
    this.d.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void c() {}
  
  protected boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a();
  }
  
  public boolean e()
  {
    l();
    if (this.g)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
      return true;
    }
    if (c()) {
      b(false, this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().c());
    }
    for (;;)
    {
      QQLiveImage.pauseAll(this.jdField_a_of_type_AndroidAppActivity);
      QQLiveImage.releaseAll(this.jdField_a_of_type_AndroidAppActivity);
      break;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.i();
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  @TargetApi(11)
  public void m()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "gallery setColor black");
      }
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        r();
      }
      if (((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null)
      {
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusColor(-16777216);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarColor(-16777216);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstart");
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstop");
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onItemClick");
    }
    e();
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView != null) && (a())) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(paramAdapterView, paramInt);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a(paramInt);
      if ((!d()) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (!this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(paramView, paramInt);
    } while (!QLog.isColorLevel());
    QLog.i("AbstractGalleryScene", 2, "AbstractGalleryScene.onItemSelected(): position=" + paramInt);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
    this.g = true;
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_a_of_type_Boolean = false;
      return;
    }
    b(true, this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager.c());
  }
  
  protected void r()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(4);
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractGalleryScene
 * JD-Core Version:    0.7.0.1
 */