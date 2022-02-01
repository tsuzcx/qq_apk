package com.tencent.mobileqq.activity.activateFriend;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ReminderCardItemPage$1
  implements URLDrawable.URLDrawableListener
{
  ReminderCardItemPage$1(ReminderCardItemPage paramReminderCardItemPage, boolean paramBoolean, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadProgressed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadSuccess");
    try
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if (this.a)
      {
        int j = ReminderCardItemPage.f();
        int i = j;
        if (j == 0) {
          i = this.b.getWidth();
        }
        this.b.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix localMatrix = new Matrix();
        float f = i * 1.0F / paramURLDrawable.getIntrinsicWidth();
        localMatrix.setScale(f, f);
        this.b.setImageMatrix(localMatrix);
        return;
      }
    }
    catch (Throwable paramURLDrawable)
    {
      QLog.e("ReminderCardItemPage", 1, "setImageFromUrl: with a error: ", paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.1
 * JD-Core Version:    0.7.0.1
 */