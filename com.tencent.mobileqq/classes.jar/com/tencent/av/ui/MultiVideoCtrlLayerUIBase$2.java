package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;

class MultiVideoCtrlLayerUIBase$2
  extends BroadcastReceiver
{
  MultiVideoCtrlLayerUIBase$2(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l1 = paramIntent.getLongExtra("groupId", 0L);
    long l2 = paramIntent.getLongExtra("roomId", 0L);
    long l3 = this.a.a.d();
    long l4 = this.a.b;
    boolean bool = true;
    int i;
    if (l4 == l1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (l3 == l2) {
      j = 1;
    } else {
      j = 0;
    }
    if (QLog.isColorLevel())
    {
      String str = this.a.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=");
      if ((i == 0) || (j == 0)) {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(";current roomId=");
      localStringBuilder.append(l3);
      localStringBuilder.append(";groupId=");
      localStringBuilder.append(this.a.b);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(paramContext)) {
      AVUtil.a(paramIntent);
    }
    if ((paramContext.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate")) && (i != 0) && (j != 0))
    {
      paramContext = new submsgtype0x116.MsgBody();
      try
      {
        paramContext.mergeFrom(paramIntent.getByteArrayExtra("pushData"));
        this.a.a.a(paramContext.rpt_msg_member_join, paramContext.rpt_msg_member_quit, paramContext.uint32_invite_list_total_count.get(), paramContext.enum_event_type.get());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramContext)
      {
        paramContext.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(this.a.d, 2, "mMemberChangeEventReceiver throw exception");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.2
 * JD-Core Version:    0.7.0.1
 */