package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class StructingMsgItemBuilderMenuHelper$1
  implements Runnable
{
  StructingMsgItemBuilderMenuHelper$1(StructingMsgItemBuilderMenuHelper paramStructingMsgItemBuilderMenuHelper, MessageForStructing paramMessageForStructing, SessionInfo paramSessionInfo, Activity paramActivity, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "structingMsgItem public forward");
    }
    MessageForStructing localMessageForStructing = this.a;
    if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
    {
      AbsShareMsg localAbsShareMsg = (AbsShareMsg)localMessageForStructing.structingMsg;
      boolean bool = localAbsShareMsg instanceof StructMsgForGeneralShare;
      if ((bool) && (((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg))
      {
        StructingMsgItemBuilderMenuHelper.a(this.this$0, localAbsShareMsg, this.b, this.c);
        return;
      }
      String str3 = this.b.e;
      String str2 = localAbsShareMsg.mSourceIcon;
      Object localObject8 = localAbsShareMsg.mMsgUrl;
      Object localObject9 = localAbsShareMsg.mMsgAction;
      String str1 = localAbsShareMsg.mMsgActionData;
      Object localObject4 = localAbsShareMsg.mMsg_A_ActionData;
      Object localObject3 = localAbsShareMsg.mMsg_I_ActionData;
      Object localObject2 = localAbsShareMsg.mMsgBrief;
      long l = localAbsShareMsg.msgId;
      Object localObject1 = localAbsShareMsg.uin;
      if (bool)
      {
        localObject5 = (StructMsgForGeneralShare)localAbsShareMsg;
        StructingMsgItemBuilder.a = StructMsgForGeneralShare.clickedItemIndex;
        if (StructingMsgItemBuilder.a != 0)
        {
          localObject5 = StructingMsgItemBuilderMenuHelper.a(this.this$0, localAbsShareMsg, null);
          break label192;
        }
      }
      Object localObject5 = null;
      label192:
      Object localObject7;
      Object localObject6;
      if (localObject5 != null)
      {
        if ((localObject5 instanceof AbsStructMsgItem))
        {
          localObject4 = (AbsStructMsgItem)localObject5;
          localObject2 = ((AbsStructMsgItem)localObject4).ax;
          localObject5 = ((AbsStructMsgItem)localObject4).e;
          localObject10 = ((AbsStructMsgItem)localObject4).d;
          str1 = ((AbsStructMsgItem)localObject4).f;
          localObject7 = ((AbsStructMsgItem)localObject4).g;
          localObject8 = ((AbsStructMsgItem)localObject4).h;
          localObject9 = ((AbsStructMsgItem)localObject4).i;
          localObject2 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject4, StructMsgItemTitle.class);
          localObject3 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject4, StructMsgItemSummary.class);
          localObject4 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject4, StructMsgItemCover.class);
          localObject6 = localObject1;
          localObject1 = localObject10;
        }
        else
        {
          localObject5 = localObject8;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject6 = localObject2;
          localObject10 = localObject1;
          localObject2 = null;
          localObject3 = null;
          localObject4 = null;
          localObject1 = localObject5;
          localObject5 = localObject9;
          localObject9 = localObject6;
          localObject6 = localObject10;
        }
      }
      else
      {
        int i = 0;
        localObject7 = null;
        localObject5 = null;
        for (localObject6 = null; i < localAbsShareMsg.getItemCount(); localObject6 = localObject11)
        {
          localObject10 = localAbsShareMsg.getItemByIndex(i);
          if ((localObject10 instanceof AbsStructMsgItem))
          {
            localObject11 = (AbsStructMsgItem)localObject10;
            localObject5 = ((AbsStructMsgItem)localObject11).ax;
            localObject9 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (String)localObject9, ((AbsStructMsgItem)localObject11).e);
            localObject8 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (String)localObject8, ((AbsStructMsgItem)localObject11).d);
            str1 = StructingMsgItemBuilderMenuHelper.a(this.this$0, str1, ((AbsStructMsgItem)localObject11).f);
            localObject4 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (String)localObject4, ((AbsStructMsgItem)localObject11).g);
            localObject5 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (String)localObject3, ((AbsStructMsgItem)localObject11).h);
            localObject6 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (String)localObject2, ((AbsStructMsgItem)localObject11).i);
            localObject7 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject11, StructMsgItemTitle.class);
            localObject10 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject11, StructMsgItemSummary.class);
            localObject3 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject11, StructMsgItemCover.class);
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject11, StructMsgItemPAVideo.class);
            }
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = StructingMsgItemBuilderMenuHelper.a(this.this$0, (AbsStructMsgItem)localObject11, StructMsgItemPAAudio.class);
            }
            localObject2 = localObject10;
            localObject10 = localObject3;
            localObject11 = localObject2;
          }
          else
          {
            localObject11 = localObject6;
            localObject10 = localObject5;
            localObject6 = localObject2;
            localObject5 = localObject3;
          }
          i += 1;
          localObject3 = localObject5;
          localObject2 = localObject6;
          localObject5 = localObject10;
        }
        Object localObject12 = localObject1;
        localObject1 = localObject8;
        localObject10 = localObject9;
        localObject11 = localObject7;
        localObject8 = localObject3;
        localObject3 = localObject6;
        localObject9 = localObject2;
        localObject2 = localObject5;
        localObject6 = localObject12;
        localObject7 = localObject4;
        localObject5 = localObject10;
        localObject4 = localObject2;
        localObject2 = localObject11;
      }
      Object localObject10 = localMessageForStructing.senderuin;
      Object localObject11 = Long.toString(localAbsShareMsg.msgId);
      ReportController.b(this.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject10, (String)localObject1, (String)localObject11, "");
      if ((str2 != null) && (!"".equals(str2))) {
        localObject10 = str2;
      } else {
        localObject10 = "https://url.cn/JS8oE7";
      }
      StructingMsgItemBuilderMenuHelper.a(this.this$0).a(this.e, this.b.b, (String)localObject2, (String)localObject3, (String)localObject4, str3, (String)localObject1, (String)localObject10, (String)localObject5, str1, (String)localObject7, (String)localObject8, (String)localObject9, l, (String)localObject6);
      localObject1 = this.d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(l);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(StructingMsgItemBuilder.a);
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject6, (String)localObject2, ((StringBuilder)localObject3).toString(), "android");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.1
 * JD-Core Version:    0.7.0.1
 */