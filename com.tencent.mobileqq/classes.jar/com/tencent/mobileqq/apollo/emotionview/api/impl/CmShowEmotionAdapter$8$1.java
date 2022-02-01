package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.qphone.base.util.QLog;

class CmShowEmotionAdapter$8$1
  implements Runnable
{
  CmShowEmotionAdapter$8$1(CmShowEmotionAdapter.8 param8) {}
  
  public void run()
  {
    QLog.i("[cmshow]CmShowEmotionAdapter", 4, "setBackgroundDrawable GetFrameCallback ");
    this.a.a.b.setBackgroundDrawable(this.a.b.getPanelDrawable(CmShowEmotionAdapter.g(this.a.c), CmShowEmotionAdapter.h(this.a.c).getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.8.1
 * JD-Core Version:    0.7.0.1
 */