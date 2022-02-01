package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.image.QQLiveImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class GalleryManager
{
  private boolean a;
  protected AbstractGalleryScene b;
  public AbstractImageListScene c;
  protected AbstractImageListModel d;
  AbstractAnimationManager e;
  public boolean f = false;
  public boolean g = false;
  ViewGroup h;
  private Activity i;
  private ImageScene j;
  
  private void l()
  {
    GalleryImage localGalleryImage = this.d.d();
    if (localGalleryImage != null) {
      localGalleryImage.thubmRect = this.c.a();
    }
    this.b.v();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.b.y();
    this.b.q.setSelectionToNothing();
    QQLiveImage.releaseAll(this.i);
  }
  
  public AbstractAnimationManager a()
  {
    return this.e;
  }
  
  public abstract AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel);
  
  public abstract AbstractImageListModel a(Activity paramActivity);
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ImageScene localImageScene = this.j;
    if (localImageScene != null) {
      localImageScene.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    ImageScene localImageScene = this.j;
    if (localImageScene != null) {
      localImageScene.a(paramConfiguration);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.b.t();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startGalleryScene jumpFromImageList:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GalleryComponent", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.d.d();
    if (paramBoolean)
    {
      this.b.w();
      this.c.b();
      if (localObject != null) {
        ((GalleryImage)localObject).thubmRect = this.c.a();
      }
    }
    else
    {
      this.b.m();
    }
    this.b.b(paramBoolean);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    ImageScene localImageScene = this.j;
    if (localImageScene != null) {
      return localImageScene.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public abstract AbstractImageListScene b(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel);
  
  public void b(Activity paramActivity)
  {
    this.i = paramActivity;
    this.d = a(paramActivity);
    this.e = c(paramActivity, this.d);
    if (this.b == null)
    {
      this.b = a(paramActivity, this.d);
      this.b.a(this);
    }
    if (b()) {
      this.h = h();
    }
    this.b.a(this.h);
    if (this.h == null) {
      this.h = this.b.C();
    }
    ViewGroup localViewGroup = this.h;
    if (localViewGroup != null) {
      localViewGroup.addView(g());
    }
    this.j = this.b;
    this.g = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.h != null) && (!this.g) && (Build.VERSION.SDK_INT >= 16)) {
      this.h.setSystemUiVisibility(4);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public AbstractAnimationManager c(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new AnimationManager(paramActivity, paramAbstractImageListModel);
  }
  
  public AbstractGalleryScene c()
  {
    return this.b;
  }
  
  public void c(Activity paramActivity)
  {
    if ((!this.a) && (this.j == this.b)) {
      a(false);
    }
    this.a = true;
  }
  
  public AbstractImageListScene d()
  {
    return this.c;
  }
  
  public void d(Activity paramActivity)
  {
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.k();
    }
    paramActivity = this.c;
    if (paramActivity != null) {
      paramActivity.k();
    }
  }
  
  public ImageScene e()
  {
    return this.j;
  }
  
  public void f()
  {
    if (!b()) {
      return;
    }
    if (a().a()) {
      return;
    }
    Object localObject = this.j;
    AbstractGalleryScene localAbstractGalleryScene = this.b;
    if (localObject == localAbstractGalleryScene)
    {
      if (this.c == null)
      {
        this.c = b(this.i, this.d);
        localObject = this.c;
        if (localObject == null) {
          return;
        }
        ((AbstractImageListScene)localObject).a(this);
        this.c.a(this.h);
        this.c.a(this);
      }
      this.c.t();
      this.b.C().post(new GalleryManager.1(this));
      this.j = this.c;
      return;
    }
    if (localObject == this.c) {
      localAbstractGalleryScene.C().post(new GalleryManager.2(this));
    }
  }
  
  public AnimationView g()
  {
    AnimationView localAnimationView = new AnimationView(this.i, null);
    localAnimationView.setId(2131428368);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public RelativeLayout h()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.i);
    this.i.addContentView(localRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    return localRelativeLayout;
  }
  
  public boolean i()
  {
    if (this.j != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackEvent, isAnimating: ");
        localStringBuilder.append(this.e.a());
        QLog.d("GalleryManager", 2, localStringBuilder.toString());
      }
      if (!a().a()) {
        this.j.x();
      }
      return true;
    }
    return false;
  }
  
  public void j()
  {
    this.j.d();
  }
  
  public void k()
  {
    this.j.L_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.GalleryManager
 * JD-Core Version:    0.7.0.1
 */