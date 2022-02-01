package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.qphone.base.util.QLog;

class CmShowEmotionAdapter$6$1
  implements Runnable
{
  CmShowEmotionAdapter$6$1(CmShowEmotionAdapter.6 param6) {}
  
  public void run()
  {
    QLog.i("[cmshow]CmShowEmotionAdapter", 4, "setBackgroundDrawable GetFrameCallback ");
    this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.a.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.getPanelDrawable(CmShowEmotionAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloEmotionviewApiImplCmShowEmotionAdapter), CmShowEmotionAdapter.b(this.a.jdField_a_of_type_ComTencentMobileqqApolloEmotionviewApiImplCmShowEmotionAdapter).getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.6.1
 * JD-Core Version:    0.7.0.1
 */