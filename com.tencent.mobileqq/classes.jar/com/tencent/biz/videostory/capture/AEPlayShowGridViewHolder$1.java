package com.tencent.biz.videostory.capture;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import bajq;
import com.tencent.qphone.base.util.QLog;
import wrr;

public class AEPlayShowGridViewHolder$1
  implements Runnable
{
  public AEPlayShowGridViewHolder$1(wrr paramwrr, View paramView) {}
  
  public void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    ViewGroup localViewGroup = (ViewGroup)this.a.getParent();
    int k = bajq.a(10.0F);
    int j = bajq.a() - k * 2;
    int i = localViewGroup.getHeight() - k;
    if (j * 16 / 9 > i) {
      j = i * 9 / 16;
    }
    for (;;)
    {
      localMarginLayoutParams.width = j;
      localMarginLayoutParams.height = i;
      k += (localViewGroup.getWidth() - j - k * 2) / 2;
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowGridViewHolder", 4, "one itemHeight " + i + " itemWidth: " + j + " screenWidth: " + bajq.a() + " viewWidth: " + localViewGroup.getWidth() + " padding: " + k);
      }
      this.a.setLayoutParams(localMarginLayoutParams);
      localViewGroup.setPadding(k, 0, 0, 0);
      return;
      i = j * 16 / 9;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEPlayShowGridViewHolder.1
 * JD-Core Version:    0.7.0.1
 */