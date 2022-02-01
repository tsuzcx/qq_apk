package com.tencent.mobileqq.apollo.api.ui.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.ViewHolder;
import com.tencent.qphone.base.util.QLog;

class CmShowEmotionAdapter$6$1
  implements Runnable
{
  CmShowEmotionAdapter$6$1(CmShowEmotionAdapter.6 param6) {}
  
  public void run()
  {
    QLog.i("CmShowEmotionAdapter", 4, "setBackgroundDrawable GetFrameCallback ");
    this.a.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$ViewHolder.a.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.getPanelDrawable(CmShowEmotionAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiUiImplCmShowEmotionAdapter), CmShowEmotionAdapter.b(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiUiImplCmShowEmotionAdapter).getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.impl.CmShowEmotionAdapter.6.1
 * JD-Core Version:    0.7.0.1
 */