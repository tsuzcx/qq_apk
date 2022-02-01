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
  public boolean A = false;
  protected Gallery q;
  protected AbstractImageAdapter r;
  protected AbstractImageListModel s;
  protected RelativeLayout t;
  protected View u;
  protected AbstractGalleryPageView v;
  protected Activity w;
  protected AbstractProgressView x;
  protected int y;
  AnimationLister z = new AbstractGalleryScene.1(this);
  
  public AbstractGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.w = paramActivity;
    this.s = paramAbstractImageListModel;
  }
  
  public void A()
  {
    this.q.reset();
  }
  
  public Gallery B()
  {
    return this.q;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.w).inflate(2131627649, null);
  }
  
  protected AbstractGalleryPageView a(Context paramContext)
  {
    return new GalleryPageView();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    b();
    this.t = a();
    if (paramViewGroup == null) {
      this.w.addContentView(this.t, new ViewGroup.LayoutParams(-1, -1));
    } else {
      paramViewGroup.addView(this.t, new ViewGroup.LayoutParams(-1, -1));
    }
    b((ViewGroup)this.t.findViewById(2131445137));
    this.q = ((Gallery)this.w.findViewById(2131433934));
    this.u = this.w.findViewById(2131429234);
    this.v = a(this.w);
    paramViewGroup = this.v;
    if (paramViewGroup != null) {
      paramViewGroup.a(this.w, this, this.y);
    }
    this.x = e();
    paramViewGroup = this.x;
    if (paramViewGroup != null) {
      paramViewGroup.a(this.w, this);
    }
    this.r = b(this.w);
    this.r.a(this.s);
    paramViewGroup = this.x;
    if (paramViewGroup != null)
    {
      this.r.a(paramViewGroup);
      this.x.a();
    }
    this.q.setAdapter(this.r);
    this.q.setSpacing(this.w.getResources().getDimensionPixelSize(2131297535));
    this.q.setSelection(this.s.b());
    this.q.setOnItemSelectedListener(this);
    this.q.setOnItemClickListener(this);
    this.q.setOnItemLongClickListener(this);
    this.q.setOnItemRotateListener(this);
    this.q.setOnScollListener(this);
    this.t.setVisibility(4);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.u.getAnimation() != null) {
      this.u.clearAnimation();
    }
    if (this.q.getAnimation() != null) {
      this.q.clearAnimation();
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(this.C.a().e());
    localAlphaAnimation.setFillAfter(true);
    if (paramBoolean2)
    {
      this.u.startAnimation(localAlphaAnimation);
      return;
    }
    localAlphaAnimation.setAnimationListener(new AbstractGalleryScene.2(this));
    C().startAnimation(localAlphaAnimation);
  }
  
  protected abstract AbstractImageAdapter b(Context paramContext);
  
  public abstract void b();
  
  public void b(boolean paramBoolean)
  {
    if (p())
    {
      a(paramBoolean, this.C.a().b());
      return;
    }
    Gallery localGallery = this.q;
    if (localGallery != null) {
      localGallery.setBackgroundColor(-16777216);
    }
    this.z.g();
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramBoolean1, paramBoolean2);
    if (this.u.getAnimation() != null) {
      this.u.clearAnimation();
    }
    if (C().getAnimation() != null) {
      C().clearAnimation();
    }
    if (paramBoolean2)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      this.u.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(this.C.a().e());
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new ViscousFluidInterpolator());
    localAlphaAnimation.setDuration(this.C.a().e());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, this.B.getWidth() / 2, this.B.getHeight() / 2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(this.C.a().e());
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new AbstractGalleryScene.3(this));
    this.u.startAnimation(localAlphaAnimation);
    this.q.startAnimation(localAnimationSet);
  }
  
  public void d() {}
  
  protected AbstractProgressView e()
  {
    return new GalleryProgressView();
  }
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void m()
  {
    this.C.a().a(this.z);
  }
  
  public void n()
  {
    this.C.a().a(this.z);
  }
  
  public boolean o()
  {
    return true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onItemClick");
    }
    x();
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if ((this.v != null) && (o())) {
      this.v.a(paramAdapterView, paramInt);
    }
    this.s.b(paramInt);
    if (!s())
    {
      paramAdapterView = this.x;
      if ((paramAdapterView != null) && (!paramAdapterView.d())) {
        this.x.a();
      }
    }
    this.r.a(paramView, paramInt);
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("AbstractGalleryScene.onItemSelected(): position=");
      paramAdapterView.append(paramInt);
      QLog.i("AbstractGalleryScene", 2, paramAdapterView.toString());
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onRotateFinished(View paramView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(int paramInt)
  {
    Object localObject = this.x;
    if ((localObject != null) && (!((AbstractProgressView)localObject).d())) {
      this.x.a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollEnd:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AbstractGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onScrollStart(int paramInt)
  {
    Object localObject = this.x;
    if ((localObject != null) && (((AbstractProgressView)localObject).d())) {
      this.x.b();
    }
    localObject = this.x;
    if ((localObject != null) && (((AbstractProgressView)localObject).e())) {
      this.x.c();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStart:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AbstractGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected boolean p()
  {
    return true;
  }
  
  protected boolean q()
  {
    return true;
  }
  
  public AbstractImageAdapter r()
  {
    return this.r;
  }
  
  public boolean s()
  {
    return this.C.a().a();
  }
  
  @TargetApi(11)
  public void t()
  {
    if ((this.w instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "gallery setColor black");
      }
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.t != null)) {
        z();
      }
      if (((AIOGalleryActivity)this.w).A != null)
      {
        ((AIOGalleryActivity)this.w).A.setStatusColor(-16777216);
        ((AIOGalleryActivity)this.w).A.setStatusBarColor(-16777216);
      }
    }
    RelativeLayout localRelativeLayout = this.t;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstart");
    }
  }
  
  public void u()
  {
    this.t.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstop");
    }
  }
  
  public void v()
  {
    this.C.a().a(this.z);
  }
  
  public void w()
  {
    this.C.a().a(this.z);
    this.A = true;
  }
  
  public boolean x()
  {
    n();
    if (this.A)
    {
      this.C.f();
    }
    else
    {
      if (q()) {
        b(false, this.C.a().c());
      } else {
        this.z.j();
      }
      QQLiveImage.pauseAll(this.w);
      QQLiveImage.releaseAll(this.w);
    }
    return true;
  }
  
  public void y()
  {
    if (this.C.f)
    {
      this.C.f = false;
      return;
    }
    b(true, this.C.e.c());
  }
  
  protected void z()
  {
    this.t.setSystemUiVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractGalleryScene
 * JD-Core Version:    0.7.0.1
 */