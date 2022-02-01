package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PATextItemBuilder$1
  implements View.OnClickListener
{
  PATextItemBuilder$1(PATextItemBuilder paramPATextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySPEventReport.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
    Object localObject1 = (PATextItemBuilder.Holder)AIOUtils.a(paramView);
    if (((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).jumpNative(((PATextItemBuilder.Holder)localObject1).jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidContentContext)) {}
    for (;;)
    {
      localObject1 = ((PATextItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject1 instanceof MessageForPubAccount))
      {
        localObject1 = (MessageForPubAccount)localObject1;
        if ((((MessageForPubAccount)localObject1).mPAMessage != null) && (((MessageForPubAccount)localObject1).mPAMessage.mMsgId > 0L)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", ((MessageForPubAccount)localObject1).frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(((MessageForPubAccount)localObject1).mPAMessage.mMsgId), "", "", "");
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((((PATextItemBuilder.Holder)localObject1).b == null) || (!((PATextItemBuilder.Holder)localObject1).b.equals("open_local"))) {
        break;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("schemaurl", ((PATextItemBuilder.Holder)localObject1).c);
      ((Bundle)localObject2).putString("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      OpenAppClient.b((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2);
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("url", ((PATextItemBuilder.Holder)localObject1).c);
    ((Intent)localObject2).putExtra("assignBackText", this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690778));
    ((Intent)localObject2).putExtra("puin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("source_name", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    Object localObject3;
    if ((((PATextItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPubAccount))
    {
      localObject3 = (MessageForPubAccount)((PATextItemBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((((MessageForPubAccount)localObject3).mPAMessage == null) || (((MessageForPubAccount)localObject3).mPAMessage.mMsgId <= 0L)) {
        break label544;
      }
    }
    label544:
    for (long l = ((MessageForPubAccount)localObject3).mPAMessage.mMsgId;; l = -1L)
    {
      if (l >= 0L) {
        ((Intent)localObject2).putExtra("msg_id", String.valueOf(l));
      }
      ((Intent)localObject2).putExtra("fromAio", true);
      ((Intent)localObject2).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject2, ((PATextItemBuilder.Holder)localObject1).c);
      if (((Intent)localObject2).getComponent() != null) {
        this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      }
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, ((PATextItemBuilder.Holder)localObject1).c, "", "", "");
        break;
        localObject3 = new ActivityURIRequest(this.a.jdField_a_of_type_AndroidContentContext, "/pubaccount/browser");
        ((ActivityURIRequest)localObject3).extra().putAll(((Intent)localObject2).getExtras());
        QRoute.startUri((URIRequest)localObject3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PATextItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */