package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class QQWalletTransMsgItemBuilder$1
  implements View.OnClickListener
{
  QQWalletTransMsgItemBuilder$1(QQWalletTransMsgItemBuilder paramQQWalletTransMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a())
    {
      long l = System.currentTimeMillis();
      if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isValideToDoAction(this.a.c, l))
      {
        this.a.c = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((QQWalletTransMsgItemBuilder.QWalletTransMsgHolder)AIOUtils.a(paramView)).a;
        Object localObject1 = null;
        String str1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (localMessageForQQWalletMsg != null)
        {
          Object localObject2 = localMessageForQQWalletMsg.mQQWalletTransferMsg;
          int k = 0;
          int i;
          if (localObject2 != null)
          {
            localObject2 = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
            StringBuilder localStringBuilder1;
            if (localMessageForQQWalletMsg.messageType == 9)
            {
              if (localMessageForQQWalletMsg.isSend()) {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.buyerclick", 0, 0, "", "", "", "");
              } else {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payerclick", 0, 0, "", "", "", "");
              }
              localObject1 = localMessageForQQWalletMsg.mQQWalletTransferMsg.body;
              if (localObject1 != null) {
                i = ((QQWalletAioBodyReserve)localObject1).pfa_type;
              } else {
                i = 0;
              }
              if (i == 1) {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.qiukaitong.click", 0, 0, "", "", "", "");
              } else if (i == 2) {
                ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.aio.yikaitong.click", 0, 0, "", "", "", "");
              }
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = QQWalletTransMsgItemBuilder.jdField_a_of_type_JavaLangString;
                localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("onClick pfa_type=");
                localStringBuilder1.append(i);
                QLog.d((String)localObject1, 2, localStringBuilder1.toString());
                localObject1 = localObject2;
              }
            }
            else
            {
              localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("");
              localStringBuilder1.append(localMessageForQQWalletMsg.mQQWalletTransferMsg.templateId);
              ReportController.b((AppRuntime)localObject1, "P_CliOper", "Vip_pay_mywallet", "", "transferaccountmsg", "show", 0, 0, localStringBuilder1.toString(), "", "", "");
              localObject1 = localObject2;
            }
          }
          if (localObject1 != null) {
            if (TextUtils.isEmpty(((QQWalletBaseMsgElem)localObject1).g))
            {
              ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).d);
            }
            else
            {
              localObject2 = ((QQWalletBaseMsgElem)localObject1).g.split("\\|");
              int j = 0;
              i = k;
              while (j < localObject2.length)
              {
                if (!TextUtils.isEmpty(localObject2[j]))
                {
                  try
                  {
                    k = Integer.valueOf(localObject2[j]).intValue();
                  }
                  catch (Exception localException)
                  {
                    if (QLog.isDevelopLevel()) {
                      localException.printStackTrace();
                    }
                    k = i;
                    if (QLog.isColorLevel())
                    {
                      String str2 = QQWalletTransMsgItemBuilder.jdField_a_of_type_JavaLangString;
                      StringBuilder localStringBuilder2 = new StringBuilder();
                      localStringBuilder2.append("QQWalletMsgItemBuilder failed to convert String:");
                      localStringBuilder2.append(localObject2[j]);
                      localStringBuilder2.append(" to Interger,");
                      QLog.d(str2, 2, localStringBuilder2.toString(), localException);
                      k = i;
                    }
                  }
                  if (k == 1) {
                    if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).d)) {
                      break;
                    }
                  }
                  for (;;)
                  {
                    break;
                    if (k == 2)
                    {
                      if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doJumpAction(paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).h)) {
                        break label722;
                      }
                    }
                    else if (k == 3) {
                      if (QQWalletTransMsgItemBuilder.a(this.a, paramView.getContext(), ((QQWalletBaseMsgElem)localObject1).i, null, str1, localMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                        break label722;
                      }
                    }
                  }
                  i = -1;
                }
                j += 1;
              }
            }
          }
        }
      }
    }
    label722:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletTransMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */