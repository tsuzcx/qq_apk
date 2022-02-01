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

class InformationFaceAdapter$URLDrawableListener
  implements URLDrawableDownListener
{
  private final String a;
  private final WeakReference<ImageView> b;
  private final WeakReference<ProgressBar> c;
  
  public InformationFaceAdapter$URLDrawableListener(@NonNull String paramString, @NonNull ImageView paramImageView, @NonNull ProgressBar paramProgressBar)
  {
    this.a = paramString;
    this.b = new WeakReference(paramImageView);
    this.c = new WeakReference(paramProgressBar);
  }
  
  private boolean a(ImageView paramImageView)
  {
    paramImageView = (String)paramImageView.getTag(2131446833);
    return (!TextUtils.isEmpty(paramImageView)) && (paramImageView.equals(this.a));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadCanceled,url:");
    paramView.append(this.a);
    SLog.b("InformationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.b.get();
    paramURLDrawable = (ProgressBar)this.c.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(4);
      paramView.setTag(2131446799, Boolean.valueOf(false));
      return;
    }
    SLog.b("InformationFaceAdapter", "onLoadCanceled error.");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadFialed,url:");
    paramView.append(this.a);
    SLog.b("InformationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.b.get();
    paramURLDrawable = (ProgressBar)this.c.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(0);
      paramView.setTag(2131446799, Boolean.valueOf(false));
      return;
    }
    SLog.b("InformationFaceAdapter", "onLoadFialed error.");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadProgressed,url:");
    paramView.append(this.a);
    SLog.b("InformationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.b.get();
    paramURLDrawable = (ProgressBar)this.c.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(0);
      paramView.setTag(2131446799, Boolean.valueOf(false));
      return;
    }
    SLog.b("InformationFaceAdapter", "onLoadProgressed error.");
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = new StringBuilder();
    paramView.append("onLoadSuccessed,url:");
    paramView.append(this.a);
    SLog.b("InformationFaceAdapter", paramView.toString());
    paramView = (ImageView)this.b.get();
    paramURLDrawable = (ProgressBar)this.c.get();
    if ((paramView != null) && (paramURLDrawable != null) && (a(paramView)))
    {
      paramURLDrawable.setVisibility(4);
      paramView.setTag(2131446799, Boolean.valueOf(true));
      return;
    }
    SLog.b("InformationFaceAdapter", "onLoadSuccessed error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.URLDrawableListener
 * JD-Core Version:    0.7.0.1
 */