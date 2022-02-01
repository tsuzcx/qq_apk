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
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
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
      if (ApolloResponseManager.d(this.a) == null) {
        return;
      }
      BaseChatPie localBaseChatPie = (BaseChatPie)ApolloResponseManager.d(this.a).get();
      if (localBaseChatPie == null) {
        return;
      }
      Object localObject1 = paramView.getTag(2131428473);
      paramView = paramView.getTag(2131428474);
      if (localObject1 != null)
      {
        if (paramView == null) {
          return;
        }
        int i = ((Integer)localObject1).intValue();
        int j = ((Integer)paramView).intValue();
        localObject1 = ((ApolloDaoManagerServiceImpl)ApolloResponseManager.a(this.a).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(i);
        if (localObject1 == null)
        {
          QLog.e("[cmshow]ApolloResponseManager", 1, "on click action is null!");
          return;
        }
        VipUtils.a(null, "cmshow", "Apollo", "quickresponseclick", String.valueOf(ApolloResponseManager.b(this.a)), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloResponseManager.c(this.a)), j, new String[] { String.valueOf(i), String.valueOf(((ApolloActionData)localObject1).feeType) });
        paramView = ApolloResManagerFacade.a.a(Scene.AIO);
        if (!paramView.c(((ApolloActionData)localObject1).actionId, ((ApolloActionData)localObject1).personNum))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloResponseManager", 2, "download action data");
          }
          ThreadManager.post(new ApolloResponseManager.1.1(this, paramView, (ApolloActionData)localObject1), 5, null, false);
        }
        paramView = new ApolloMainInfo(ApolloResponseManager.a(this.a).getCurrentUin());
        paramView.mSendSrc = 1;
        paramView.mAction = ((ApolloActionData)localObject1);
        ((ApolloActionData)localObject1).atNickName = "";
        ((ApolloActionData)localObject1).inputText = "";
        Object localObject2 = localBaseChatPie.ah;
        if (CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject2).a, 1))
        {
          ((ApolloActionData)localObject1).peerUin = ((SessionInfo)localObject2).b;
          if ((localBaseChatPie != null) && (localBaseChatPie.Y != null) && (localBaseChatPie.Y.getText() != null)) {
            ((ApolloActionData)localObject1).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.Y.getText().toString());
          }
        }
        else if ((CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject2).a, 2)) && (localBaseChatPie != null) && (localBaseChatPie.d != null) && (localBaseChatPie.f != null))
        {
          ArrayList localArrayList = new ArrayList();
          if ((localBaseChatPie != null) && (localBaseChatPie.Y != null)) {
            AtTroopMemberSpan.a(localBaseChatPie.Y.getEditableText(), localArrayList);
          }
          if (((ApolloActionData)localObject1).personNum == 1)
          {
            if ((localArrayList.size() == 1) && (0L != ((AtTroopMemberInfo)localArrayList.get(0)).uin) && (((AtTroopMemberInfo)localArrayList.get(0)).startPos == 0))
            {
              String str = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.Y.getText().toString());
              try
              {
                ((ApolloActionData)localObject1).atNickName = str.substring(0, ((AtTroopMemberInfo)localArrayList.get(0)).textLen);
                if (((AtTroopMemberInfo)localArrayList.get(0)).textLen >= localBaseChatPie.Y.getText().length() - 1) {
                  ((ApolloActionData)localObject1).inputText = "";
                } else {
                  ((ApolloActionData)localObject1).inputText = str.substring(((AtTroopMemberInfo)localArrayList.get(0)).textLen);
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
                ((ApolloActionData)localObject1).inputText = "";
              }
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append(((AtTroopMemberInfo)localArrayList.get(0)).uin);
              localStringBuilder1.append("");
              ((ApolloActionData)localObject1).peerUin = localStringBuilder1.toString();
              localBaseChatPie.Y.getText().clear();
            }
            else if (!android.text.TextUtils.isEmpty(ApolloResponseManager.b(this.a)))
            {
              localObject1 = ContactUtils.a(ApolloResponseManager.a(this.a), ApolloResponseManager.b(this.a), true);
              localObject2 = new StringBuilder("@");
              ((StringBuilder)localObject2).append((String)localObject1);
              paramView.mAction.peerUin = ApolloResponseManager.b(this.a);
              paramView.mAction.atNickName = ((StringBuilder)localObject2).toString();
              paramView.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.Y.getText().toString());
              localBaseChatPie.Y.getText().clear();
              localBaseChatPie.a(paramView);
              localBaseChatPie.aH = paramView;
              this.a.a();
            }
          }
          else if ((((ApolloActionData)localObject1).personNum == 0) && (localBaseChatPie != null) && (localBaseChatPie.Y != null) && (localBaseChatPie.Y.getText() != null))
          {
            ((ApolloActionData)localObject1).inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(localBaseChatPie.Y.getText().toString());
            localBaseChatPie.Y.getText().clear();
          }
        }
        if ((localBaseChatPie != null) && (localBaseChatPie.Y != null) && (localBaseChatPie.Y.getText() != null))
        {
          localObject1 = localBaseChatPie.Y.getText().toString();
          if ((localObject1 != null) && (((String)localObject1).length() > 99) && (localBaseChatPie.d != null))
          {
            ChatActivityUtils.a(localBaseChatPie.d.getApplication(), 2131916265, 1);
            return;
          }
          if (!CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject2).a, 2)) {
            localBaseChatPie.Y.getText().clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloResponseManager.1
 * JD-Core Version:    0.7.0.1
 */