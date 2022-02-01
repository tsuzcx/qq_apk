package com.tencent.mobileqq.activity.aio.rebuild.input;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;

public class InputUIUtils
{
  public static void a(AIOContext paramAIOContext, BaseSessionInfo paramBaseSessionInfo, boolean paramBoolean)
  {
    EditTextUI localEditTextUI = paramAIOContext.p().d().f();
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    if ((paramBaseSessionInfo.a != 1) && (paramBaseSessionInfo.a != 3000) && (paramBaseSessionInfo.a != 10014)) {
      return;
    }
    Object localObject1 = ((ReplyHelper)paramAIOContext.a(119)).a();
    if (localObject1 != null)
    {
      if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName)) {
        return;
      }
      Object localObject2 = ((HotChatManager)paramAIOContext.a().getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramBaseSessionInfo.b);
      int i = 0;
      boolean bool1;
      if (localObject2 != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int j = paramBaseSessionInfo.a;
      localObject2 = paramBaseSessionInfo.b;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSenderUin);
      ((StringBuilder)localObject3).append("");
      localObject2 = ContactUtils.a(localQQAppInterface, j, (String)localObject2, ((StringBuilder)localObject3).toString());
      paramAIOContext = paramAIOContext.b();
      localObject3 = paramBaseSessionInfo.b;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSenderUin);
      ((StringBuilder)localObject4).append("");
      localObject1 = ((StringBuilder)localObject4).toString();
      localObject4 = localEditTextUI.b();
      boolean bool2;
      if (paramBaseSessionInfo.a == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramAIOContext = AtTroopMemberSpan.a(localQQAppInterface, paramAIOContext, (String)localObject3, (String)localObject1, (String)localObject2, bool1, (EditText)localObject4, bool2, true);
      if (paramAIOContext != null)
      {
        if (paramAIOContext.length() <= 0) {
          return;
        }
        if (paramBoolean)
        {
          localEditTextUI.c().insert(0, paramAIOContext);
          return;
        }
        if (localEditTextUI.j() >= 0) {
          i = localEditTextUI.j();
        }
        localEditTextUI.c().insert(i, paramAIOContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.InputUIUtils
 * JD-Core Version:    0.7.0.1
 */