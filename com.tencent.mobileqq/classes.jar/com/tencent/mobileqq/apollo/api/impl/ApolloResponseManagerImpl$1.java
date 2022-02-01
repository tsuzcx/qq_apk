package com.tencent.mobileqq.apollo.api.impl;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ApolloResponseManagerImpl$1
  implements View.OnClickListener
{
  ApolloResponseManagerImpl$1(ApolloResponseManagerImpl paramApolloResponseManagerImpl) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.a.mApp == null) || (this.a.mChatPieRef == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.a.mChatPieRef.get();
      if (localBaseChatPie != null)
      {
        Object localObject1 = paramView.getTag(2131362843);
        Object localObject2 = paramView.getTag(2131362844);
        if ((localObject1 != null) && (localObject2 != null))
        {
          int i = ((Integer)localObject1).intValue();
          int j = ((Integer)localObject2).intValue();
          Object localObject3 = ((ApolloDaoManagerServiceImpl)this.a.mApp.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(i);
          if (localObject3 == null)
          {
            QLog.e("ApolloResponseManager", 1, "on click action is null!");
          }
          else
          {
            VipUtils.a(null, "cmshow", "Apollo", "quickresponseclick", String.valueOf(this.a.mSenderUin), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.a.mSessionType), j, new String[] { String.valueOf(i), String.valueOf(((ApolloActionData)localObject3).feeType) });
            if (!ApolloUtilImpl.isActionResDone(((ApolloActionData)localObject3).actionId, ((ApolloActionData)localObject3).personNum))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResponseManager", 2, "download action data");
              }
              ThreadManager.post(new ApolloResponseManagerImpl.1.1(this, (ApolloActionData)localObject3), 5, null, false);
            }
            localObject1 = new ApolloMainInfo(this.a.mApp.getCurrentUin());
            ((ApolloInfo)localObject1).mSendSrc = 1;
            ((ApolloInfo)localObject1).mAction = ((ApolloActionData)localObject3);
            ((ApolloActionData)localObject3).atNickName = "";
            ((ApolloActionData)localObject3).inputText = "";
            localObject2 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if (CmShowAioMatcher.a(((SessionInfo)localObject2).jdField_a_of_type_Int, 1))
            {
              ((ApolloActionData)localObject3).peerUin = ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString;
              if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
                ((ApolloActionData)localObject3).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              }
            }
            for (;;)
            {
              if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
              {
                localObject3 = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
                if ((localObject3 != null) && (((String)localObject3).length() > 99) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                {
                  ChatActivityUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131719043, 1);
                  break;
                  if ((!CmShowAioMatcher.a(((SessionInfo)localObject2).jdField_a_of_type_Int, 2)) || (localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
                    continue;
                  }
                  ArrayList localArrayList = new ArrayList();
                  if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                    AtTroopMemberSpan.a(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
                  }
                  if (((ApolloActionData)localObject3).personNum == 1)
                  {
                    if ((localArrayList.size() == 1) && (0L != ((AtTroopMemberInfo)localArrayList.get(0)).uin) && (((AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
                    {
                      String str = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                      try
                      {
                        ((ApolloActionData)localObject3).atNickName = str.substring(0, ((AtTroopMemberInfo)localArrayList.get(0)).textLen);
                        if (((AtTroopMemberInfo)localArrayList.get(0)).textLen >= localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1) {}
                        for (((ApolloActionData)localObject3).inputText = "";; ((ApolloActionData)localObject3).inputText = str.substring(((AtTroopMemberInfo)localArrayList.get(0)).textLen))
                        {
                          ((ApolloActionData)localObject3).peerUin = (((AtTroopMemberInfo)localArrayList.get(0)).uin + "");
                          localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                          break;
                        }
                      }
                      catch (Exception localException)
                      {
                        for (;;)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("ApolloResponseManager", 2, "inputText err:" + localException.getMessage());
                          }
                          ((ApolloActionData)localObject3).inputText = "";
                        }
                      }
                    }
                    if (android.text.TextUtils.isEmpty(this.a.mSenderUin)) {
                      continue;
                    }
                    localObject2 = ContactUtils.c(this.a.mApp, this.a.mSenderUin, true);
                    localObject2 = new StringBuilder("@").append((String)localObject2);
                    ((ApolloInfo)localObject1).mAction.peerUin = this.a.mSenderUin;
                    ((ApolloInfo)localObject1).mAction.atNickName = ((StringBuilder)localObject2).toString();
                    ((ApolloInfo)localObject1).mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                    localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                    localBaseChatPie.a((ApolloInfo)localObject1);
                    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = ((ApolloInfo)localObject1);
                    this.a.removeResponseView();
                    break;
                  }
                  if ((((ApolloActionData)localObject3).personNum != 0) || (localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
                    continue;
                  }
                  ((ApolloActionData)localObject3).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
                  localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                  continue;
                }
                if (!CmShowAioMatcher.a(((SessionInfo)localObject2).jdField_a_of_type_Int, 2)) {
                  localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
                }
              }
            }
            if (localBaseChatPie != null) {
              localBaseChatPie.a((ApolloInfo)localObject1);
            }
            this.a.removeResponseView();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloResponseManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */