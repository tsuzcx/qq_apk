package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

class LayoutPreLoader$2
  implements RFAsyncLayoutInflater.OnInflateFinishedListener
{
  LayoutPreLoader$2(LayoutPreLoader paramLayoutPreLoader, int paramInt1, int paramInt2) {}
  
  public void a(@NonNull View paramView, int paramInt, @Nullable ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutPreLoader.a(this.c, this.a, this.b);
    if (paramViewGroup != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("headValidListener is ");
      localStringBuilder.append(paramViewGroup.hashCode());
      localStringBuilder.append(" resId:");
      localStringBuilder.append(paramInt);
      QLog.d("LayoutPreLoader", 1, localStringBuilder.toString());
      paramViewGroup.onPreloadResult(paramView);
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("headValidListener is null storeView resId:");
    paramViewGroup.append(paramInt);
    QLog.d("LayoutPreLoader", 1, paramViewGroup.toString());
    LayoutPreLoader.a(this.c, this.a, paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.2
 * JD-Core Version:    0.7.0.1
 */