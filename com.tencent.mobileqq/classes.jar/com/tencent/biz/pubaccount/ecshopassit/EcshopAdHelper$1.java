package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class EcshopAdHelper$1
  implements View.OnClickListener
{
  EcshopAdHelper$1(EcshopAdHelper paramEcshopAdHelper, int paramInt, JSONObject paramJSONObject, Context paramContext, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if ((EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper) != null) && (EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).isShowing())) {
        EcshopAdHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdHelper).dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.jdField_a_of_type_OrgJsonJSONObject.optString("action_url", "");
      if (!StringUtil.a((String)localObject))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438");
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        }
        localIntent.putExtra("big_brother_source_key", (String)localObject);
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
        continue;
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (((MessageForArkApp)localObject).arkContainer != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Ecshop_EcshopAdHelper", 2, "doOnEvent ARKAPP_TYPE_DESTROY");
            }
            ((MessageForArkApp)localObject).arkContainer.doOnEvent(2);
          }
        }
        ((EcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(8, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131692318), 1).a();
        continue;
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (((MessageForArkApp)localObject).arkContainer != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Ecshop_EcshopAdHelper", 2, "doOnEvent ARKAPP_TYPE_DESTROY");
            }
            ((MessageForArkApp)localObject).arkContainer.doOnEvent(2);
          }
        }
        ((EcshopAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER)).a(7, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131692318), 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHelper.1
 * JD-Core Version:    0.7.0.1
 */