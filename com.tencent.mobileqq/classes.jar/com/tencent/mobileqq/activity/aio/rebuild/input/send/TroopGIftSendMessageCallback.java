package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.AtTroopMemberInfo;>;

public class TroopGIftSendMessageCallback
  implements ISendMessageCallback
{
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    EditTextUI localEditTextUI = paramAIOContext.p().d().f();
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.O();
    if (localEditTextUI.c(2131441562) != null)
    {
      if (localEditTextUI.c(2131441562) != null)
      {
        Object localObject2 = (MessageForTroopGift)localEditTextUI.c(2131441562);
        paramSendLogicParam.b().u = ((MessageForTroopGift)localObject2).senderUin;
        paramArrayList = HardCodeUtil.a(2131899215);
        Object localObject1 = SharedPreUtils.at(paramAIOContext.b(), "wantWord");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject1;
        }
        localEditTextUI.a(paramArrayList);
        int i = localBaseSessionInfo.a;
        paramArrayList = localBaseSessionInfo.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((MessageForTroopGift)localObject2).senderUin);
        ((StringBuilder)localObject1).append("");
        paramArrayList = ContactUtils.a(localQQAppInterface, i, paramArrayList, ((StringBuilder)localObject1).toString());
        localObject1 = paramAIOContext.b();
        String str = localBaseSessionInfo.b;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((MessageForTroopGift)localObject2).senderUin);
        ((StringBuilder)localObject3).append("");
        localObject2 = ((StringBuilder)localObject3).toString();
        localObject3 = localEditTextUI.b();
        boolean bool;
        if (localBaseSessionInfo.a == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramArrayList = AtTroopMemberSpan.a(localQQAppInterface, (Context)localObject1, str, (String)localObject2, paramArrayList, false, (EditText)localObject3, bool);
        if ((paramArrayList != null) && (paramArrayList.length() != 0)) {
          localEditTextUI.c().insert(0, paramArrayList);
        }
        paramArrayList = new ArrayList();
        paramSendLogicParam.a(AtTroopMemberSpan.a(localEditTextUI.c(), paramArrayList));
        ChatActivityFacade.a(localQQAppInterface, paramAIOContext.b(), (SessionInfo)localBaseSessionInfo, paramSendLogicParam.a(), paramArrayList, paramSendLogicParam.b());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopGIftSendMessageCallback
 * JD-Core Version:    0.7.0.1
 */