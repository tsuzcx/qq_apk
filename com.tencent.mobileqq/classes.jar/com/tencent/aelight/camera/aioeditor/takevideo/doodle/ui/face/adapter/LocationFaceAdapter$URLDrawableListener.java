package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import java.lang.ref.WeakReference;

class LocationFaceAdapter$URLDrawableListener
  implements URLDrawableDownListener
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private final WeakReference<ProgressBar> b;
  
  public LocationFaceAdapter$URLDrawableListener(@NonNull String paramString, @NonNull ImageView paramImageView, @NonNull ProgressBar paramProgressBar)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
    this.b = new WeakReference(paramProgressBar);
  }
  
  private boolean a(ImageView paramImageView)
  {
    paramImageView = (String)paramImageView.getTag(2131378314);
    return (!TextUtils.isEmpty(paramImageView)) && (paramImageView.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadCanceled,url:");
    paramView.append(this.jdField_a_of_type_JavaLangString);
    SLog.b("LocationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(4);
      paramView.setTag(2131378280, Boolean.valueOf(false));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadCanceled error.");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadFialed,url:");
    paramView.append(this.jdField_a_of_type_JavaLangString);
    SLog.b("LocationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(0);
      paramView.setTag(2131378280, Boolean.valueOf(false));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadFialed error.");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadProgressed,url:");
    paramView.append(this.jdField_a_of_type_JavaLangString);
    SLog.b("LocationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(0);
      paramView.setTag(2131378280, Boolean.valueOf(false));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadProgressed error.");
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadSuccessed,url:");
    paramView.append(this.jdField_a_of_type_JavaLangString);
    SLog.b("LocationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramURLDrawable = (ProgressBar)this.b.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(4);
      paramView.setTag(2131378280, Boolean.valueOf(true));
      return;
    }
    SLog.b("LocationFaceAdapter", "onLoadSuccessed error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.LocationFaceAdapter.URLDrawableListener
 * JD-Core Version:    0.7.0.1
 */