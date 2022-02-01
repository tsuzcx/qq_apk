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
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    EditTextUI localEditTextUI = paramAIOContext.a().a().a();
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
    if (localEditTextUI.a(2131373888) != null)
    {
      if (localEditTextUI.a(2131373888) != null)
      {
        Object localObject2 = (MessageForTroopGift)localEditTextUI.a(2131373888);
        paramSendLogicParam.a().e = ((MessageForTroopGift)localObject2).senderUin;
        paramArrayList = HardCodeUtil.a(2131701203);
        Object localObject1 = SharedPreUtils.g(paramAIOContext.a(), "wantWord");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramArrayList = (ArrayList<AtTroopMemberInfo>)localObject1;
        }
        localEditTextUI.a(paramArrayList);
        int i = localBaseSessionInfo.jdField_a_of_type_Int;
        paramArrayList = localBaseSessionInfo.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((MessageForTroopGift)localObject2).senderUin);
        ((StringBuilder)localObject1).append("");
        paramArrayList = ContactUtils.a(localQQAppInterface, i, paramArrayList, ((StringBuilder)localObject1).toString());
        localObject1 = paramAIOContext.a();
        String str = localBaseSessionInfo.jdField_a_of_type_JavaLangString;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((MessageForTroopGift)localObject2).senderUin);
        ((StringBuilder)localObject3).append("");
        localObject2 = ((StringBuilder)localObject3).toString();
        localObject3 = localEditTextUI.a();
        boolean bool;
        if (localBaseSessionInfo.jdField_a_of_type_Int == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramArrayList = AtTroopMemberSpan.a(localQQAppInterface, (Context)localObject1, str, (String)localObject2, paramArrayList, false, (EditText)localObject3, bool);
        if ((paramArrayList != null) && (paramArrayList.length() != 0)) {
          localEditTextUI.b().insert(0, paramArrayList);
        }
        paramArrayList = new ArrayList();
        paramSendLogicParam.a(AtTroopMemberSpan.a(localEditTextUI.b(), paramArrayList));
        ChatActivityFacade.a(localQQAppInterface, paramAIOContext.a(), (SessionInfo)localBaseSessionInfo, paramSendLogicParam.a(), paramArrayList, paramSendLogicParam.a());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopGIftSendMessageCallback
 * JD-Core Version:    0.7.0.1
 */