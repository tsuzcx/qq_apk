package com.tencent.mobileqq.activity.aio.item;

import agqa;
import android.app.Activity;
import android.content.Context;
import bcef;
import bcgx;
import bciz;
import bclk;
import bclp;
import bclv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;

public class StructingMsgItemBuilderMenuHelper$1
  implements Runnable
{
  public StructingMsgItemBuilderMenuHelper$1(agqa paramagqa, MessageForStructing paramMessageForStructing, SessionInfo paramSessionInfo, Activity paramActivity, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "structingMsgItem public forward");
    }
    MessageForStructing localMessageForStructing = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    AbsShareMsg localAbsShareMsg;
    if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
    {
      localAbsShareMsg = (AbsShareMsg)localMessageForStructing.structingMsg;
      if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg)) {
        agqa.a(this.this$0, localAbsShareMsg, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    else
    {
      return;
    }
    Object localObject10 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    String str4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick;
    String str3 = localAbsShareMsg.mSourceIcon;
    Object localObject1 = localAbsShareMsg.mMsgUrl;
    Object localObject6 = localAbsShareMsg.mMsgAction;
    Object localObject5 = localAbsShareMsg.mMsgActionData;
    Object localObject4 = localAbsShareMsg.mMsg_A_ActionData;
    Object localObject3 = localAbsShareMsg.mMsg_I_ActionData;
    Object localObject2 = localAbsShareMsg.mMsgBrief;
    long l = localAbsShareMsg.msgId;
    String str5 = localAbsShareMsg.uin;
    if ((localAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      localObject7 = (StructMsgForGeneralShare)localAbsShareMsg;
      StructingMsgItemBuilder.c = StructMsgForGeneralShare.clickedItemIndex;
      if (StructingMsgItemBuilder.c == 0) {}
    }
    for (Object localObject7 = agqa.a(this.this$0, localAbsShareMsg, null);; localObject7 = null)
    {
      if (localObject7 != null)
      {
        if (!(localObject7 instanceof bcgx)) {
          break label931;
        }
        localObject7 = (bcgx)localObject7;
        localObject1 = ((bcgx)localObject7).a;
        localObject6 = ((bcgx)localObject7).c;
        localObject1 = ((bcgx)localObject7).b;
        localObject2 = ((bcgx)localObject7).d;
        localObject3 = ((bcgx)localObject7).e;
        localObject4 = ((bcgx)localObject7).f;
        localObject5 = ((bcgx)localObject7).g;
        localObject9 = agqa.a(this.this$0, (bcgx)localObject7, StructMsgItemTitle.class);
        localObject8 = agqa.a(this.this$0, (bcgx)localObject7, bclv.class);
        localObject7 = agqa.a(this.this$0, (bcgx)localObject7, bciz.class);
      }
      for (;;)
      {
        localObject10 = localMessageForStructing.senderuin;
        Object localObject11 = Long.toString(localAbsShareMsg.msgId);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject10, (String)localObject1, (String)localObject11, "");
        int i;
        label485:
        Object localObject15;
        Object localObject14;
        Object localObject13;
        if ((str3 == null) || ("".equals(str3)))
        {
          localObject10 = "https://url.cn/JS8oE7";
          agqa.a(this.this$0).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, (String)localObject9, (String)localObject8, (String)localObject7, str4, (String)localObject1, (String)localObject10, (String)localObject6, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, l, str5);
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, str5, "" + l, "" + StructingMsgItemBuilder.c, "android");
          return;
          i = 0;
          localObject7 = localObject10;
          if (i >= localAbsShareMsg.getItemCount()) {
            break label892;
          }
          Object localObject16 = localAbsShareMsg.getItemByIndex(i);
          localObject15 = localObject2;
          localObject14 = localObject3;
          localObject13 = localObject4;
          localObject12 = localObject5;
          localObject11 = localObject6;
          localObject10 = localObject1;
          if (!(localObject16 instanceof bcgx)) {
            break label853;
          }
          bcgx localbcgx = (bcgx)localObject16;
          localObject7 = localbcgx.a;
          localObject6 = agqa.a(this.this$0, (String)localObject6, localbcgx.c);
          localObject16 = agqa.a(this.this$0, (String)localObject1, localbcgx.b);
          localObject5 = agqa.a(this.this$0, (String)localObject5, localbcgx.d);
          localObject4 = agqa.a(this.this$0, (String)localObject4, localbcgx.e);
          localObject3 = agqa.a(this.this$0, (String)localObject3, localbcgx.f);
          localObject2 = agqa.a(this.this$0, (String)localObject2, localbcgx.g);
          String str1 = agqa.a(this.this$0, localbcgx, StructMsgItemTitle.class);
          String str2 = agqa.a(this.this$0, localbcgx, bclv.class);
          localObject7 = agqa.a(this.this$0, localbcgx, bciz.class);
          localObject1 = localObject7;
          if (localObject7 == null) {
            localObject1 = agqa.a(this.this$0, localbcgx, bclp.class);
          }
          localObject15 = localObject2;
          localObject14 = localObject3;
          localObject13 = localObject4;
          localObject12 = localObject5;
          localObject11 = localObject6;
          localObject10 = localObject16;
          localObject9 = localObject1;
          localObject8 = str2;
          localObject7 = str1;
          if (localObject1 != null) {
            break label853;
          }
          localObject7 = agqa.a(this.this$0, localbcgx, bclk.class);
          localObject8 = str2;
          localObject9 = str1;
          localObject1 = localObject5;
          localObject5 = localObject6;
          localObject6 = localObject16;
          localObject10 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject4;
          localObject4 = localObject1;
          localObject1 = localObject10;
        }
        for (;;)
        {
          i += 1;
          localObject10 = localObject9;
          localObject9 = localObject6;
          localObject6 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject9;
          localObject9 = localObject7;
          localObject7 = localObject10;
          break label485;
          localObject10 = str3;
          break;
          label853:
          localObject1 = localObject15;
          localObject2 = localObject14;
          localObject3 = localObject13;
          localObject4 = localObject12;
          localObject5 = localObject11;
          localObject6 = localObject10;
          localObject10 = localObject7;
          localObject7 = localObject9;
          localObject9 = localObject10;
        }
        label892:
        localObject10 = localObject2;
        localObject11 = localObject3;
        localObject3 = localObject4;
        localObject2 = localObject5;
        Object localObject12 = localObject7;
        localObject4 = localObject11;
        localObject5 = localObject10;
        localObject7 = localObject9;
        localObject9 = localObject12;
        continue;
        label931:
        localObject7 = localObject2;
        localObject8 = localObject3;
        localObject3 = localObject4;
        localObject2 = localObject5;
        localObject11 = null;
        localObject10 = null;
        localObject9 = null;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject7 = localObject11;
        localObject8 = localObject10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.1
 * JD-Core Version:    0.7.0.1
 */