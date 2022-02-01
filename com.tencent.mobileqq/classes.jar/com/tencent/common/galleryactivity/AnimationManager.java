package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class AnimationManager
  extends AbstractAnimationManager
{
  Activity f;
  protected View g;
  protected AnimationView h;
  View i;
  View j;
  AbstractImageListModel k;
  int l;
  
  public AnimationManager(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.f = paramActivity;
    this.k = paramAbstractImageListModel;
    this.l = paramActivity.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, GalleryImage paramGalleryImage, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramGalleryImage == null) {
      return null;
    }
    Drawable localDrawable = paramGalleryImage.getAnimationDrawable();
    paramRect1 = paramGalleryImage.getThumbRect();
    if ((paramRect1 != null) && (localDrawable != null))
    {
      if (!paramGalleryImage.needAnimation(paramBoolean)) {
        return null;
      }
      int m = this.g.getWidth();
      int n = this.g.getHeight();
      int i1 = localDrawable.getIntrinsicWidth();
      int i2 = localDrawable.getIntrinsicHeight();
      paramRect2.set(0, 0, i1, i2);
      paramRect3.set(paramRect1);
      if ((paramGalleryImage instanceof AIORichMediaInfo)) {
        paramRect2 = ((AIORichMediaInfo)paramGalleryImage).a;
      } else {
        paramRect2 = null;
      }
      paramRect1 = localObject;
      if (!VersionUtils.e())
      {
        paramRect1 = localObject;
        if ((localDrawable instanceof URLDrawable))
        {
          paramRect1 = localObject;
          if ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)) {
            paramRect1 = AnimationUtils.a(i1, i2, m, n, false, paramRect2);
          }
        }
      }
      paramRect3 = paramRect1;
      if (paramRect1 == null) {
        paramRect3 = AnimationUtils.a(i1, i2, m, n, paramRect2);
      }
      paramRect4.set(paramRect3);
      return localDrawable;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = a();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.g == null) {
      f();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    GalleryImage localGalleryImage = this.k.d();
    if (localGalleryImage == null) {
      return false;
    }
    Rect localRect3 = localGalleryImage.getStartSrcRect();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localGalleryImage, true);
    this.b = true;
    if (localDrawable == null) {
      bool1 = false;
    }
    this.d = bool1;
    if (!this.d)
    {
      this.h.setVisibility(4);
    }
    else
    {
      this.h.setVisibility(0);
      this.h.setAnimationListener(this);
      this.h.a = localGalleryImage.isImgCenterCropMode;
      if (localRect3 == null) {
        this.h.a(localDrawable, localRect1, localRect2, localGalleryImage.getCutValue(), this.c);
      } else {
        this.h.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.c);
      }
    }
    return this.d;
  }
  
  public boolean c()
  {
    boolean bool2 = a();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.g == null) {
      f();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    GalleryImage localGalleryImage = this.k.d();
    Rect localRect1 = null;
    if (localGalleryImage != null) {
      localRect1 = localGalleryImage.getStartSrcRect();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localGalleryImage, false);
    this.b = true;
    if (localDrawable == null) {
      bool1 = false;
    }
    this.d = bool1;
    if (!this.d)
    {
      this.h.setVisibility(4);
    }
    else
    {
      this.h.setVisibility(0);
      this.h.setAnimationListener(this);
      this.h.a = localGalleryImage.isImgCenterCropMode;
      this.h.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.c);
      if (localRect1 == null) {
        this.h.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.c);
      } else {
        this.h.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.c);
      }
    }
    return this.d;
  }
  
  public void f()
  {
    this.g = this.f.findViewById(2131433934);
    this.h = ((AnimationView)this.f.findViewById(2131428368));
    this.i = this.f.findViewById(2131445137);
    this.j = this.f.findViewById(2131429234);
  }
  
  public void g()
  {
    this.b = false;
    this.h.setVisibility(4);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).g();
    }
    this.a.clear();
  }
  
  public void h()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).h();
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).i();
    }
  }
  
  public void j()
  {
    this.b = false;
    this.h.setVisibility(4);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).j();
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationManager
 * JD-Core Version:    0.7.0.1
 */