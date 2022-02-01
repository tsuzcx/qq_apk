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
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  protected View a;
  AbstractImageListModel jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel;
  protected AnimationView a;
  View b;
  View c;
  
  public AnimationManager(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
    this.jdField_a_of_type_Int = paramActivity.getResources().getDisplayMetrics().densityDpi;
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
      int i = this.jdField_a_of_type_AndroidViewView.getWidth();
      int j = this.jdField_a_of_type_AndroidViewView.getHeight();
      int k = localDrawable.getIntrinsicWidth();
      int m = localDrawable.getIntrinsicHeight();
      paramRect2.set(0, 0, k, m);
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
            paramRect1 = AnimationUtils.a(k, m, i, j, false, paramRect2);
          }
        }
      }
      paramRect3 = paramRect1;
      if (paramRect1 == null) {
        paramRect3 = AnimationUtils.a(k, m, i, j, paramRect2);
      }
      paramRect4.set(paramRect3);
      return localDrawable;
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131367431);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362696));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131376809);
    this.c = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363349);
  }
  
  public boolean b()
  {
    boolean bool2 = a();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    GalleryImage localGalleryImage = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a();
    if (localGalleryImage == null) {
      return false;
    }
    Rect localRect3 = localGalleryImage.getStartSrcRect();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localGalleryImage, true);
    this.jdField_a_of_type_Boolean = true;
    if (localDrawable == null) {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    else
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localGalleryImage.isImgCenterCropMode;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect1, localRect2, localGalleryImage.getCutValue(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    boolean bool2 = a();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    GalleryImage localGalleryImage = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a();
    Rect localRect1 = null;
    if (localGalleryImage != null) {
      localRect1 = localGalleryImage.getStartSrcRect();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localGalleryImage, false);
    this.jdField_a_of_type_Boolean = true;
    if (localDrawable == null) {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    else
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localGalleryImage.isImgCenterCropMode;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.jdField_a_of_type_Long);
      if (localRect1 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localGalleryImage.getCutValue(), localGalleryImage.getStartX(), localGalleryImage.getStartY(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.jdField_a_of_type_Long);
      }
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).g();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).h();
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AnimationLister)localIterator.next()).i();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationManager
 * JD-Core Version:    0.7.0.1
 */