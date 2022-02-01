package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EcshopAdHelper$2
  implements View.OnClickListener
{
  EcshopAdHelper$2(EcshopAdHelper paramEcshopAdHelper, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    int k;
    int m;
    try
    {
      ViewGroup localViewGroup = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().c.findViewById(2131362743);
      if (localViewGroup == null)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      int[] arrayOfInt = new int[2];
      ((ViewGroup)localObject).getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      int j = ((ViewGroup)localObject).getHeight();
      localObject = new int[2];
      this.jdField_a_of_type_AndroidWidgetTextView.getLocationOnScreen((int[])localObject);
      EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper, localObject[0]);
      EcshopAdHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper, localObject[1]);
      k = EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).getContentView().getMeasuredHeight();
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHelper", 2, "popheight: " + k);
      }
      m = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
      if (EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper) - i + m + k <= j) {
        break label322;
      }
    }
    EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847467));
    EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, EcshopAdHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper), EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper) - k);
    for (;;)
    {
      ((EcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(9, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).setOnDismissListener(new EcshopAdHelper.2.1(this));
      break;
      label322:
      EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847466));
      EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).showAtLocation(this.jdField_a_of_type_AndroidWidgetTextView, 0, EcshopAdHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper), m + EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHelper.2
 * JD-Core Version:    0.7.0.1
 */