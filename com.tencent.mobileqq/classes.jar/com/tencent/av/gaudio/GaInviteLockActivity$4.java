package com.tencent.av.gaudio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
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

class GaInviteLockActivity$4
  extends BroadcastReceiver
{
  GaInviteLockActivity$4(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l1 = paramIntent.getLongExtra("groupId", 0L);
    long l2 = paramIntent.getLongExtra("roomId", 0L);
    boolean bool;
    if ((this.a.jdField_a_of_type_Long == l1) && (GaInviteLockActivity.a(this.a) == l2)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=");
      localStringBuilder.append(bool);
      localStringBuilder.append(";current roomId=");
      localStringBuilder.append(GaInviteLockActivity.a(this.a));
      localStringBuilder.append(";groupId=");
      localStringBuilder.append(this.a.jdField_a_of_type_Long);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(paramContext)) {
      AVUtil.a(paramIntent);
    }
    if ((paramContext.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate")) && (bool))
    {
      paramContext = new submsgtype0x116.MsgBody();
      try
      {
        paramContext.mergeFrom(paramIntent.getByteArrayExtra("pushData"));
        paramIntent = new HashSet();
        localObject = GaInviteLockActivity.a(this.a).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramIntent.add(Long.valueOf(((Memberinfo)((Iterator)localObject).next()).jdField_a_of_type_Long));
        }
        int n = paramContext.enum_event_type.get();
        if (QLog.isColorLevel())
        {
          localObject = this.a.jdField_b_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mMemberChangeEventReceiver before totalCount:");
          localStringBuilder.append(paramContext.uint32_invite_list_total_count.get());
          localStringBuilder.append(";currentInviteMembers=");
          localStringBuilder.append(GaInviteLockActivity.a(this.a).size());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        int j = 0;
        for (int i = 0; j < paramContext.rpt_msg_member_join.size(); i = k)
        {
          localObject = (submsgtype0x116.MemberInfo)paramContext.rpt_msg_member_join.get(j);
          l1 = ((submsgtype0x116.MemberInfo)localObject).uint64_member_uin.get();
          int m;
          if ((l1 != this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) && (l1 != this.a.jdField_b_of_type_Long)) {
            m = 1;
          } else {
            m = 0;
          }
          k = i;
          if (!paramIntent.contains(Long.valueOf(l1)))
          {
            k = i;
            if (m != 0)
            {
              GaInviteLockActivity.a(this.a).add(new Memberinfo(((submsgtype0x116.MemberInfo)localObject).uint64_member_uin.get(), ((submsgtype0x116.MemberInfo)localObject).uint32_invite_timestamp.get()));
              if (QLog.isColorLevel())
              {
                localObject = this.a.jdField_b_of_type_JavaLangString;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("mMemberChangeEventReceiver add member UIN:");
                localStringBuilder.append(l1);
                QLog.d((String)localObject, 2, localStringBuilder.toString());
              }
              k = 1;
            }
          }
          j += 1;
        }
        int k = 0;
        j = i;
        i = k;
        while (i < paramContext.rpt_msg_member_quit.size())
        {
          l1 = ((submsgtype0x116.MemberInfo)paramContext.rpt_msg_member_quit.get(i)).uint64_member_uin.get();
          localObject = GaInviteLockActivity.a(this.a).iterator();
          do
          {
            k = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramIntent = (Memberinfo)((Iterator)localObject).next();
          } while (paramIntent.jdField_a_of_type_Long != l1);
          GaInviteLockActivity.a(this.a).remove(paramIntent);
          if (QLog.isColorLevel())
          {
            localObject = this.a.jdField_b_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("mMemberChangeEventReceiver remove member UIN:");
            localStringBuilder.append(paramIntent.jdField_a_of_type_Long);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
          k = j;
          if (n != 2) {
            k = 1;
          }
          i += 1;
          j = k;
        }
        if (QLog.isColorLevel())
        {
          paramIntent = this.a.jdField_b_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mMemberChangeEventReceiver after totalCount:");
          ((StringBuilder)localObject).append(paramContext.uint32_invite_list_total_count.get());
          ((StringBuilder)localObject).append(";currentInviteMembers=");
          ((StringBuilder)localObject).append(GaInviteLockActivity.a(this.a).size());
          ((StringBuilder)localObject).append(";eventType=");
          ((StringBuilder)localObject).append(paramContext.enum_event_type.get());
          QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
        }
        if (j != 0)
        {
          GaInviteLockActivity.a(this.a, "mMemberChangeEventReceiver");
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
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.4
 * JD-Core Version:    0.7.0.1
 */