package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.utils.AVUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MemberInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116.MsgBody;

class MultiIncomingCallsActivity$5
  extends BroadcastReceiver
{
  MultiIncomingCallsActivity$5(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l1 = paramIntent.getLongExtra("groupId", 0L);
    long l2 = paramIntent.getLongExtra("roomId", 0L);
    boolean bool;
    if ((this.a.jdField_a_of_type_Long == l1) && (MultiIncomingCallsActivity.a(this.a) == l2)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(";current roomId=");
      ((StringBuilder)localObject2).append(MultiIncomingCallsActivity.a(this.a));
      ((StringBuilder)localObject2).append(";groupId=");
      ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_Long);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(paramContext)) {
      AVUtil.a(paramIntent);
    }
    if ((paramContext.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate")) && (bool))
    {
      localObject1 = new submsgtype0x116.MsgBody();
      try
      {
        ((submsgtype0x116.MsgBody)localObject1).mergeFrom(paramIntent.getByteArrayExtra("pushData"));
        paramIntent = new HashSet();
        paramContext = MultiIncomingCallsActivity.a(this.a).iterator();
        while (paramContext.hasNext()) {
          paramIntent.add(Long.valueOf(((Memberinfo)paramContext.next()).jdField_a_of_type_Long));
        }
        int m = ((submsgtype0x116.MsgBody)localObject1).enum_event_type.get();
        bool = QLog.isColorLevel();
        paramContext = ";eventType=";
        StringBuilder localStringBuilder;
        if (bool)
        {
          localObject2 = this.a.jdField_b_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mMemberChangeEventReceiver before totalCount:");
          localStringBuilder.append(((submsgtype0x116.MsgBody)localObject1).uint32_invite_list_total_count.get());
          localStringBuilder.append(";currentInviteMembers=");
          localStringBuilder.append(MultiIncomingCallsActivity.a(this.a).size());
          localStringBuilder.append(";eventType=");
          localStringBuilder.append(((submsgtype0x116.MsgBody)localObject1).enum_event_type.get());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        int j = 0;
        int i = 0;
        while (j < ((submsgtype0x116.MsgBody)localObject1).rpt_msg_member_join.size())
        {
          localObject2 = (submsgtype0x116.MemberInfo)((submsgtype0x116.MsgBody)localObject1).rpt_msg_member_join.get(j);
          l1 = ((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get();
          if ((l1 != this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) && (l1 != this.a.jdField_b_of_type_Long)) {
            k = 1;
          } else {
            k = 0;
          }
          if ((!paramIntent.contains(Long.valueOf(l1))) && (k != 0))
          {
            MultiIncomingCallsActivity.a(this.a).add(new Memberinfo(((submsgtype0x116.MemberInfo)localObject2).uint64_member_uin.get(), ((submsgtype0x116.MemberInfo)localObject2).uint32_invite_timestamp.get()));
            if (QLog.isColorLevel())
            {
              localObject2 = this.a.jdField_b_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("mMemberChangeEventReceiver add member UIN:");
              localStringBuilder.append(l1);
              QLog.d((String)localObject2, 2, localStringBuilder.toString());
            }
            i = 1;
          }
          j += 1;
        }
        int k = 0;
        j = i;
        i = k;
        while (i < ((submsgtype0x116.MsgBody)localObject1).rpt_msg_member_quit.size())
        {
          l1 = ((submsgtype0x116.MemberInfo)((submsgtype0x116.MsgBody)localObject1).rpt_msg_member_quit.get(i)).uint64_member_uin.get();
          localObject2 = MultiIncomingCallsActivity.a(this.a).iterator();
          do
          {
            k = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramIntent = (Memberinfo)((Iterator)localObject2).next();
          } while (paramIntent.jdField_a_of_type_Long != l1);
          MultiIncomingCallsActivity.a(this.a).remove(paramIntent);
          if (QLog.isColorLevel())
          {
            localObject2 = this.a.jdField_b_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("mMemberChangeEventReceiver remove member UIN:");
            localStringBuilder.append(paramIntent.jdField_a_of_type_Long);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          k = j;
          if (m != 2) {
            k = 1;
          }
          i += 1;
          j = k;
        }
        if (QLog.isColorLevel())
        {
          paramIntent = this.a.jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mMemberChangeEventReceiver after totalCount:");
          ((StringBuilder)localObject2).append(((submsgtype0x116.MsgBody)localObject1).uint32_invite_list_total_count.get());
          ((StringBuilder)localObject2).append(";currentInviteMembers=");
          ((StringBuilder)localObject2).append(MultiIncomingCallsActivity.a(this.a).size());
          ((StringBuilder)localObject2).append(paramContext);
          ((StringBuilder)localObject2).append(((submsgtype0x116.MsgBody)localObject1).enum_event_type.get());
          QLog.d(paramIntent, 2, ((StringBuilder)localObject2).toString());
        }
        if (j != 0)
        {
          MultiIncomingCallsActivity.a(this.a);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramContext)
      {
        paramContext.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "mMemberChangeEventReceiver throw exception");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.5
 * JD-Core Version:    0.7.0.1
 */