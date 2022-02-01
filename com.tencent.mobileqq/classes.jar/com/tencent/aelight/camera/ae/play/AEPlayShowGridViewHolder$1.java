package com.tencent.aelight.camera.ae.play;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class AEPlayShowGridViewHolder$1
  implements Runnable
{
  AEPlayShowGridViewHolder$1(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder, View paramView) {}
  
  public void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$itemView.getLayoutParams();
    ViewGroup localViewGroup = (ViewGroup)this.val$itemView.getParent();
    int m = ViewUtils.a(10.0F);
    int i = ViewUtils.a();
    int n = m * 2;
    i -= n;
    int j = localViewGroup.getHeight() - m;
    int k = i * 16 / 9;
    if (k > j) {
      i = j * 9 / 16;
    } else {
      j = k;
    }
    localMarginLayoutParams.width = i;
    localMarginLayoutParams.height = j;
    k = m + (localViewGroup.getWidth() - i - n) / 2;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("one itemHeight ");
      localStringBuilder.append(j);
      localStringBuilder.append(" itemWidth: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" screenWidth: ");
      localStringBuilder.append(ViewUtils.a());
      localStringBuilder.append(" viewWidth: ");
      localStringBuilder.append(localViewGroup.getWidth());
      localStringBuilder.append(" padding: ");
      localStringBuilder.append(k);
      QLog.d("AEPlayShowGridViewHolder", 4, localStringBuilder.toString());
    }
    this.val$itemView.setLayoutParams(localMarginLayoutParams);
    localViewGroup.setPadding(k, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.1
 * JD-Core Version:    0.7.0.1
 */