package com.tencent.mobileqq.apollo.aio;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ApolloResponseManager$1
  implements View.OnClickListener
{
  ApolloResponseManager$1(ApolloResponseManager paramApolloResponseManager) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (ApolloResponseManager.a(this.a) != null))
    {
      if (ApolloResponseManager.a(this.a) == null) {
        return;
      }
      BaseChatPie localBaseChatPie = (BaseChatPie)ApolloResponseManager.a(this.a).get();
      if (localBaseChatPie == null) {
        return;
      }
      Object localObject1 = paramView.getTag(2131362787);
      paramView = paramView.getTag(2131362788);
      if (localObject1 != null)
      {
        if (paramView == null) {
          return;
        }
        int i = ((Integer)localObject1).intValue();
        int j = ((Integer)paramView).intValue();
        Object localObject2 = ((ApolloDaoManagerServiceImpl)ApolloResponseManager.a(this.a).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(i);
        if (localObject2 == null)
        {
          QLog.e("[cmshow]ApolloResponseManager", 1, "on click action is null!");
          return;
        }
        VipUtils.a(null, "cmshow", "Apollo", "quickresponseclick", String.valueOf(ApolloResponseManager.a(this.a)), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloResponseManager.a(this.a)), j, new String[] { String.valueOf(i), String.valueOf(((ApolloActionData)localObject2).feeType) });
        if (!CMResUtil.a(((ApolloActionData)localObject2).actionId, ((ApolloActionData)localObject2).personNum))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloResponseManager", 2, "download action data");
          }
          ThreadManager.post(new ApolloResponseManager.1.1(this, (ApolloActionData)localObject2), 5, null, false);
        }
        paramView = new ApolloMainInfo(ApolloResponseManager.a(this.a).getCurrentUin());
        paramView.mSendSrc = 1;
        paramView.mAction = ((ApolloActionData)localObject2);
        ((ApolloActionData)localObject2).atNickName = "";
        ((ApolloActionData)localObject2).inputText = "";
        localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject1).jdField_a_of_type_Int, 1))
        {
          ((ApolloActionData)localObject2).peerUin = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
          if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null)) {
            ((ApolloActionData)localObject2).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
          }
        }
        else if ((CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject1).jdField_a_of_type_Int, 2)) && (localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
        {
          ArrayList localArrayList = new ArrayList();
          if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
            AtTroopMemberSpan.a(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
          }
          if (((ApolloActionData)localObject2).personNum == 1)
          {
            if ((localArrayList.size() == 1) && (0L != ((AtTroopMemberInfo)localArrayList.get(0)).uin) && (((AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
            {
              String str = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              try
              {
                ((ApolloActionData)localObject2).atNickName = str.substring(0, ((AtTroopMemberInfo)localArrayList.get(0)).textLen);
                if (((AtTroopMemberInfo)localArrayList.get(0)).textLen >= localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1) {
                  ((ApolloActionData)localObject2).inputText = "";
                } else {
                  ((ApolloActionData)localObject2).inputText = str.substring(((AtTroopMemberInfo)localArrayList.get(0)).textLen);
                }
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel())
                {
                  StringBuilder localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append("inputText err:");
                  localStringBuilder2.append(localException.getMessage());
                  QLog.d("[cmshow]ApolloResponseManager", 2, localStringBuilder2.toString());
                }
                ((ApolloActionData)localObject2).inputText = "";
              }
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append(((AtTroopMemberInfo)localArrayList.get(0)).uin);
              localStringBuilder1.append("");
              ((ApolloActionData)localObject2).peerUin = localStringBuilder1.toString();
              localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
            }
            else if (!android.text.TextUtils.isEmpty(ApolloResponseManager.a(this.a)))
            {
              localObject1 = ContactUtils.a(ApolloResponseManager.a(this.a), ApolloResponseManager.a(this.a), true);
              localObject2 = new StringBuilder("@");
              ((StringBuilder)localObject2).append((String)localObject1);
              paramView.mAction.peerUin = ApolloResponseManager.a(this.a);
              paramView.mAction.atNickName = ((StringBuilder)localObject2).toString();
              paramView.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
              localBaseChatPie.a(paramView);
              localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = paramView;
              this.a.a();
            }
          }
          else if ((((ApolloActionData)localObject2).personNum == 0) && (localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
          {
            ((ApolloActionData)localObject2).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
            localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          }
        }
        if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
        {
          localObject2 = localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
          if ((localObject2 != null) && (((String)localObject2).length() > 99) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
          {
            ChatActivityUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131718759, 1);
            return;
          }
          if (!CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject1).jdField_a_of_type_Int, 2)) {
            localBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          }
        }
        if (localBaseChatPie != null) {
          localBaseChatPie.a(paramView);
        }
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloResponseManager.1
 * JD-Core Version:    0.7.0.1
 */