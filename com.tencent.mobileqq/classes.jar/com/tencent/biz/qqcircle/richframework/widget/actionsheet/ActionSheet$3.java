package com.tencent.biz.qqcircle.richframework.widget.actionsheet;

import android.os.Handler;
import android.util.Pair;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ActionSheet$3
  implements URLDrawable.URLDrawableListener
{
  ActionSheet$3(ActionSheet paramActionSheet, TextView paramTextView, Pair paramPair) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.i("ActionSheet", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadFialed ");
    paramURLDrawable.append(paramThrowable.getMessage());
    QLog.i("ActionSheet", 1, paramURLDrawable.toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadProgressed ");
    paramURLDrawable.append(paramInt);
    QLog.i("ActionSheet", 1, paramURLDrawable.toString());
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoadSuccessed ");
      localStringBuilder.append(paramURLDrawable);
      QLog.i("ActionSheet", 1, localStringBuilder.toString());
      if (paramURLDrawable != null)
      {
        ActionSheet.a(this.c).post(new ActionSheet.3.1(this, paramURLDrawable));
        return;
      }
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */