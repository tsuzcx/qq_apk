package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import auxu;
import bdll;
import bdol;
import bdom;
import bdow;
import bdqo;
import bdsf;
import bdsg;
import bdsy;
import bdtd;
import bdtj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import txx;

class StructingMsgItemBuilder$4
  implements Runnable
{
  StructingMsgItemBuilder$4(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Context paramContext) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa struct_public start:" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "structingMsgItem public forward");
    }
    MessageForStructing localMessageForStructing;
    AbsShareMsg localAbsShareMsg;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
    {
      localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localAbsShareMsg = (AbsShareMsg)localMessageForStructing.structingMsg;
        if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (!((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg)) {
          break label272;
        }
        localObject1 = (StructMsgForGeneralShare)bdow.a(localAbsShareMsg.getBytes());
        txx.a((StructMsgForGeneralShare)localObject1);
        ((StructMsgForGeneralShare)localObject1).mSourceAction = "web";
        localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        ((StructMsgForGeneralShare)localObject1).mSourceUrl = txx.a((String)localObject2);
        ((StructMsgForGeneralShare)localObject1).mSourceName = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        ((StructMsgForGeneralShare)localObject1).source_puin = ((String)localObject2);
        ((StructMsgForGeneralShare)localObject1).mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
        ((StructMsgForGeneralShare)localObject1).setFlag(0);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("forward_type", -3);
        ((Bundle)localObject2).putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject1).mMsgServiceID);
        ((Bundle)localObject2).putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject1).getBytes());
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        auxu.a((Activity)this.this$0.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
      }
    }
    return;
    label272:
    Object localObject13 = null;
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject3 = null;
    Object localObject10 = null;
    Object localObject2 = null;
    String str2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    String str1 = localAbsShareMsg.mSourceIcon;
    Object localObject4 = localAbsShareMsg.mMsgUrl;
    Object localObject9 = localAbsShareMsg.mMsgAction;
    Object localObject7 = localAbsShareMsg.mMsgActionData;
    Object localObject6 = localAbsShareMsg.mMsg_A_ActionData;
    Object localObject5 = localAbsShareMsg.mMsg_I_ActionData;
    Object localObject8 = localAbsShareMsg.mMsgBrief;
    long l = localAbsShareMsg.msgId;
    String str3 = localAbsShareMsg.uin;
    int i;
    if ((localAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      localObject1 = (StructMsgForGeneralShare)localAbsShareMsg;
      StructingMsgItemBuilder.c = StructMsgForGeneralShare.clickedItemIndex;
      if (StructingMsgItemBuilder.c != 0)
      {
        i = 0;
        if (i < localAbsShareMsg.getItemCount())
        {
          localObject1 = localAbsShareMsg.getItemByIndex(i);
          if ((TextUtils.isEmpty(((bdol)localObject1).aa)) || (Integer.valueOf(((bdol)localObject1).aa).intValue() != StructingMsgItemBuilder.c) || ((!(localObject1 instanceof bdsf)) && (!(localObject1 instanceof bdsg)))) {}
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (!(localObject1 instanceof bdom)) {
          break label1801;
        }
        localObject1 = (bdom)localObject1;
        localObject9 = ((bdom)localObject1).a;
        localObject6 = ((bdom)localObject1).c;
        localObject8 = ((bdom)localObject1).b;
        localObject11 = ((bdom)localObject1).d;
        localObject10 = ((bdom)localObject1).e;
        localObject7 = ((bdom)localObject1).f;
        localObject5 = ((bdom)localObject1).g;
        i = 0;
        localObject1 = localObject12;
        label529:
        if (i < ((ArrayList)localObject9).size())
        {
          localObject4 = (bdol)((ArrayList)localObject9).get(i);
          if ((localObject4 instanceof StructMsgItemTitle))
          {
            localObject4 = ((StructMsgItemTitle)localObject4).b();
            localObject1 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
          for (;;)
          {
            i += 1;
            localObject4 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            break label529;
            i += 1;
            break;
            if ((localObject4 instanceof bdtj))
            {
              localObject4 = ((bdtj)localObject4).b();
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
            else
            {
              if (!(localObject4 instanceof bdqo)) {
                break label1782;
              }
              localObject4 = ((bdqo)localObject4).ac;
              localObject2 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
        }
        localObject4 = localObject7;
        localObject7 = localObject2;
        localObject9 = localObject1;
        localObject2 = localObject11;
        localObject1 = localObject8;
        localObject8 = localObject3;
        localObject3 = localObject10;
      }
      for (;;)
      {
        localObject10 = localMessageForStructing.senderuin;
        localObject11 = Long.toString(localAbsShareMsg.msgId);
        bdll.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject10, (String)localObject1, (String)localObject11, "");
        if ((str1 == null) || ("".equals(str1)))
        {
          localObject10 = "https://url.cn/JS8oE7";
          label785:
          this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject9, (String)localObject8, (String)localObject7, str2, (String)localObject1, (String)localObject10, (String)localObject6, (String)localObject2, localObject3, (String)localObject4, (String)localObject5, l, str3);
          bdll.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, str3, "" + l, "" + StructingMsgItemBuilder.c, "android");
          return;
          i = 0;
          localObject1 = localObject13;
          localObject2 = localObject11;
          localObject3 = localObject10;
          label921:
          if (i >= localAbsShareMsg.getItemCount()) {
            break label1665;
          }
          localObject10 = localAbsShareMsg.getItemByIndex(i);
          if ((localObject10 instanceof bdom))
          {
            localObject12 = (bdom)localObject10;
            localObject11 = ((bdom)localObject12).a;
            if ((((bdom)localObject12).c == null) || ("".equals(((bdom)localObject12).c)) || ((localObject9 != null) && (!"".equals(localObject9)))) {
              break label1662;
            }
            localObject9 = ((bdom)localObject12).c;
            label1005:
            localObject10 = localObject4;
            if (((bdom)localObject12).b != null)
            {
              localObject10 = localObject4;
              if (!"".equals(((bdom)localObject12).b)) {
                if (localObject4 != null)
                {
                  localObject10 = localObject4;
                  if (!"".equals(localObject4)) {}
                }
                else
                {
                  localObject10 = ((bdom)localObject12).b;
                }
              }
            }
            if ((((bdom)localObject12).d == null) || ("".equals(((bdom)localObject12).d)) || ((localObject7 != null) && (!"".equals(localObject7)))) {
              break label1655;
            }
            localObject4 = ((bdom)localObject12).d;
            label1107:
            if ((((bdom)localObject12).e == null) || (!"".equals(((bdom)localObject12).e)) || ((localObject6 != null) && (!"".equals(localObject6)))) {
              break label1652;
            }
            localObject6 = ((bdom)localObject12).e;
            label1152:
            if ((((bdom)localObject12).f == null) || (!"".equals(((bdom)localObject12).f)) || ((localObject5 != null) && (!"".equals(localObject5)))) {
              break label1649;
            }
            localObject5 = ((bdom)localObject12).f;
            label1197:
            if ((((bdom)localObject12).g == null) || (!"".equals(((bdom)localObject12).g)) || ((localObject8 != null) && (!"".equals(localObject8)))) {
              break label1642;
            }
            localObject7 = ((bdom)localObject12).g;
            label1242:
            int j = 0;
            if (j >= ((ArrayList)localObject11).size()) {
              break label1735;
            }
            localObject8 = (bdol)((ArrayList)localObject11).get(j);
            if (("title".equals(((bdol)localObject8).a)) && (localObject1 == null))
            {
              if (!(localObject8 instanceof StructMsgItemTitle)) {
                break label1720;
              }
              localObject8 = ((StructMsgItemTitle)localObject8).b();
              localObject1 = localObject3;
              localObject3 = localObject8;
            }
            for (;;)
            {
              label1309:
              j += 1;
              localObject8 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject8;
              break;
              if (("summary".equals(((bdol)localObject8).a)) && (localObject2 == null))
              {
                if (!(localObject8 instanceof bdtj)) {
                  break label1720;
                }
                localObject2 = ((bdtj)localObject8).b();
                localObject8 = localObject1;
                localObject1 = localObject3;
                localObject3 = localObject8;
              }
              else if (("picture".equals(((bdol)localObject8).a)) && (localObject3 == null))
              {
                if (!(localObject8 instanceof bdqo)) {
                  break label1720;
                }
                localObject8 = ((bdqo)localObject8).ac;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
              else if (("pavideo".equals(((bdol)localObject8).a)) && (localObject3 == null))
              {
                if (!(localObject8 instanceof bdtd)) {
                  break label1720;
                }
                localObject8 = ((bdtd)localObject8).ac;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
              else
              {
                if ((!"paaudio".equals(((bdol)localObject8).a)) || (localObject3 != null) || (!(localObject8 instanceof bdsy))) {
                  break label1720;
                }
                localObject8 = ((bdsy)localObject8).ac;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
            }
          }
          localObject10 = localObject8;
          localObject8 = localObject9;
          localObject9 = localObject1;
          localObject1 = localObject7;
          localObject7 = localObject3;
          localObject11 = localObject5;
          localObject3 = localObject9;
          localObject5 = localObject2;
          localObject9 = localObject4;
          localObject2 = localObject8;
          localObject4 = localObject1;
          localObject8 = localObject11;
          localObject1 = localObject10;
        }
        for (;;)
        {
          i += 1;
          localObject10 = localObject9;
          localObject9 = localObject8;
          localObject8 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          localObject3 = localObject7;
          localObject2 = localObject5;
          localObject1 = localObject8;
          localObject8 = localObject12;
          localObject5 = localObject9;
          localObject7 = localObject4;
          localObject9 = localObject11;
          localObject4 = localObject10;
          break label921;
          localObject10 = str1;
          break label785;
          label1642:
          localObject7 = localObject8;
          break label1242;
          label1649:
          break label1197;
          label1652:
          break label1152;
          label1655:
          localObject4 = localObject7;
          break label1107;
          label1662:
          break label1005;
          label1665:
          localObject12 = localObject6;
          localObject6 = localObject9;
          localObject9 = localObject3;
          localObject10 = localObject2;
          localObject11 = localObject1;
          localObject2 = localObject7;
          localObject1 = localObject4;
          localObject3 = localObject12;
          localObject4 = localObject5;
          localObject5 = localObject8;
          localObject7 = localObject9;
          localObject8 = localObject10;
          localObject9 = localObject11;
          break;
          label1720:
          localObject8 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject8;
          break label1309;
          label1735:
          localObject8 = localObject7;
          localObject7 = localObject10;
          localObject10 = localObject1;
          localObject11 = localObject2;
          localObject1 = localObject8;
          localObject8 = localObject5;
          localObject2 = localObject9;
          localObject9 = localObject7;
          localObject7 = localObject3;
          localObject5 = localObject11;
          localObject3 = localObject10;
        }
        label1782:
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
        label1801:
        localObject3 = localObject6;
        localObject6 = localObject9;
        localObject11 = null;
        localObject10 = null;
        localObject9 = null;
        localObject2 = localObject7;
        localObject1 = localObject4;
        localObject4 = localObject5;
        localObject5 = localObject8;
        localObject7 = localObject11;
        localObject8 = localObject10;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */