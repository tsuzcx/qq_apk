package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.AVLog;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.VideoController;
import com.tencent.av.business.handler.AudioTransClientInterfaceHandler;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.report.AVPushReport;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.GroupInviteFlag;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GAudioMessageMonitor$GAudioMsgReceiver
  extends BroadcastReceiver
{
  VideoAppInterface a;
  
  GAudioMessageMonitor$GAudioMsgReceiver(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      paramContext = this.a.a();
      Object localObject;
      if (paramContext == null)
      {
        if (QLog.isColorLevel())
        {
          paramContext = GAudioMessageMonitor.a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" onReceive: ");
          ((StringBuilder)localObject).append(paramIntent.getAction());
          QLog.d(paramContext, 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      StringBuilder localStringBuilder1;
      if (QLog.isColorLevel())
      {
        localObject = GAudioMessageMonitor.a;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("GAudioMsgReceiver_onReceive[");
        localStringBuilder1.append(paramIntent.getAction());
        localStringBuilder1.append("]");
        QLog.w((String)localObject, 1, localStringBuilder1.toString());
      }
      long l1;
      long l2;
      if (paramIntent.getAction().equals("tencent.video.q2v.GvideoMemUntInvite"))
      {
        l1 = paramIntent.getLongExtra("groupId", 0L);
        l2 = paramIntent.getLongExtra("dealMemUin", 0L);
        paramContext = paramIntent.getStringExtra("invitedId");
        this.a.a(new Object[] { Integer.valueOf(513), Long.valueOf(l1), Long.valueOf(l2), paramContext });
        return;
      }
      if (paramIntent.getAction().equals("tencent.video.q2v.close_invite_msg_box_by_invite_id"))
      {
        l1 = paramIntent.getLongExtra("groupId", 0L);
        paramContext = paramIntent.getStringExtra("inviteId");
        this.a.a(new Object[] { Integer.valueOf(516), Long.valueOf(l1), paramContext });
        return;
      }
      int i;
      if (paramIntent.getAction().equals("tencent.video.q2v.MultiVideo"))
      {
        i = paramIntent.getIntExtra("type", -1);
        if (QLog.isColorLevel())
        {
          localObject = GAudioMessageMonitor.a;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("GAudioMsgReceiver type: ");
          localStringBuilder1.append(i);
          QLog.d((String)localObject, 2, localStringBuilder1.toString());
        }
        if (i == 26)
        {
          l1 = paramIntent.getLongExtra("discussId", 0L);
          if ((paramContext.d) && (paramContext.jdField_a_of_type_Long == l1))
          {
            paramIntent = new Intent();
            paramIntent.setAction("tencent.av.v2q.MultiVideo");
            paramIntent.putExtra("type", 25);
            paramIntent.putExtra("relationId", l1);
            paramIntent.putExtra("relationType", 2);
            paramIntent.putExtra("from", "VideoAppInterface1");
            paramIntent.setPackage(this.a.getApp().getPackageName());
            this.a.getApp().sendBroadcast(paramIntent);
            paramContext.a(paramContext.b, paramContext.jdField_a_of_type_Long, 88);
            this.a.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
          }
        }
        else
        {
          if (i == 27)
          {
            paramContext.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveMultiVideoMsg(paramIntent.getExtras());
            return;
          }
          if (i == 30)
          {
            paramContext.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveMultiVideoAck(paramIntent.getExtras());
            return;
          }
          if (i == 24)
          {
            paramContext.a(paramIntent.getLongExtra("discussId", 0L), paramIntent.getStringExtra("cmdUin"), paramIntent.getStringArrayExtra("uins"));
            return;
          }
          if (i == 31)
          {
            l1 = paramIntent.getLongExtra("discussId", 0L);
            localObject = paramIntent.getStringExtra("cmdUin");
            paramIntent = paramIntent.getStringArrayExtra("uins");
            if ((paramIntent != null) && (paramIntent.length != 0))
            {
              localStringBuilder1 = paramIntent[0];
              String str1 = this.a.getCurrentAccountUin();
              if (QLog.isColorLevel())
              {
                String str2 = GAudioMessageMonitor.a;
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("TYPE_GAUDIO_MEMBER_KICKOUT-->discuss id = ");
                localStringBuilder2.append(l1);
                localStringBuilder2.append(", cmdUin = ");
                localStringBuilder2.append((String)localObject);
                localStringBuilder2.append(", outUin = ");
                localStringBuilder2.append(localStringBuilder1);
                localStringBuilder2.append(", selfUin = ");
                localStringBuilder2.append(str1);
                localStringBuilder2.append(", uinList.size = ");
                localStringBuilder2.append(paramIntent.length);
                QLog.d(str2, 2, localStringBuilder2.toString());
              }
              if ((paramContext.d) && (paramContext.jdField_a_of_type_Long == l1) && (localStringBuilder1.compareTo(str1) == 0))
              {
                paramContext.a(paramContext.b, paramContext.jdField_a_of_type_Long, 75);
                paramContext = new Intent();
                paramContext.setAction("tencent.av.v2q.MultiVideo");
                paramContext.putExtra("type", 25);
                paramContext.putExtra("relationId", l1);
                paramContext.putExtra("relationType", 2);
                paramContext.putExtra("from", "VideoAppInterface2");
                paramContext.setPackage(this.a.getApp().getPackageName());
                this.a.getApp().sendBroadcast(paramContext);
                return;
              }
              if ((paramContext.a().f == 7) && (paramContext.c == l1) && (localStringBuilder1.compareTo(str1) == 0))
              {
                paramContext.a().a("GAudioMsgReceiver", 0);
                this.a.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramContext.c), Integer.valueOf(4) });
                paramContext.c = 0L;
                paramContext.h = 0;
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.e(GAudioMessageMonitor.a, 2, "GAudioMsgReceiver-->uinlist is null");
            }
          }
          else if (i == 34)
          {
            l1 = paramIntent.getLongExtra("relationId", 0L);
            if ((paramContext.d) && (l1 == paramContext.jdField_a_of_type_Long))
            {
              paramContext.a(1, l1, 76);
              paramIntent = new Intent();
              paramIntent.setAction("tencent.av.v2q.MultiVideo");
              paramIntent.putExtra("MultiAVType", paramContext.a().j);
              paramIntent.putExtra("type", 25);
              paramIntent.putExtra("relationId", l1);
              paramIntent.putExtra("relationType", 1);
              paramIntent.putExtra("from", "VideoAppInterface3");
              paramIntent.setPackage(this.a.getApp().getPackageName());
              this.a.getApp().sendBroadcast(paramIntent);
            }
          }
          else if ((i == 35) && (paramContext.d))
          {
            paramContext.o();
          }
        }
      }
      else if (paramIntent.getAction().equals("tencent.video.q2v.AddDiscussMember"))
      {
        if (paramIntent.getBooleanExtra("result", false)) {
          paramContext.a(paramIntent.getLongExtra("roomId", paramContext.jdField_a_of_type_Long), paramIntent.getStringArrayListExtra("newMemberUin"));
        }
      }
      else
      {
        long l3;
        if (paramIntent.getAction().equals("tencent.video.q2v.SwitchToMultiAudo"))
        {
          if (paramIntent.getBooleanExtra("result", false))
          {
            l1 = paramIntent.getLongExtra("roomId", 0L);
            localObject = paramIntent.getStringArrayListExtra("memberUin");
            i = paramIntent.getIntExtra("uinType", 3000);
            l2 = SeqUtil.a(paramIntent);
            l3 = AudioHelper.b();
            paramIntent = GAudioMessageMonitor.a;
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("switchToMultiAudio, seq[");
            localStringBuilder1.append(l2);
            localStringBuilder1.append("], newseq[");
            localStringBuilder1.append(l3);
            localStringBuilder1.append("], [discussion]");
            QLog.w(paramIntent, 1, localStringBuilder1.toString());
            paramContext.a(l3, i, l1, (ArrayList)localObject);
          }
        }
        else
        {
          if (paramIntent.getAction().equals("tencent.video.q2v.GroupInfoChanged"))
          {
            paramContext = QAVGroupConfig.GroupInviteFlag.a(paramIntent.getExtras());
            this.a.a(new Object[] { Integer.valueOf(169), paramContext });
            return;
          }
          int j;
          if (paramIntent.getAction().equals("tencent.video.q2v.GroupSystemMsg"))
          {
            i = paramIntent.getIntExtra("type", -1);
            j = paramIntent.getIntExtra("relationType", -1);
            l1 = paramIntent.getLongExtra("relationId", -1L);
            l2 = paramIntent.getLongExtra("userUin", -1L);
            boolean bool = paramIntent.getBooleanExtra("needSendCmd", false);
            if (QLog.isColorLevel())
            {
              paramIntent = GAudioMessageMonitor.a;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("GAudioMsgReceiver_onReceive[tencent.video.q2v.GroupSystemMsg], type[");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append("], relationType[");
              ((StringBuilder)localObject).append(j);
              ((StringBuilder)localObject).append("], relationId[");
              ((StringBuilder)localObject).append(l1);
              ((StringBuilder)localObject).append("], userUin[");
              ((StringBuilder)localObject).append(l2);
              ((StringBuilder)localObject).append("], needSendCmd[");
              ((StringBuilder)localObject).append(bool);
              ((StringBuilder)localObject).append("]");
              QLog.w(paramIntent, 1, ((StringBuilder)localObject).toString());
            }
            if ((i != 7) && (i != 8))
            {
              paramContext.a(l1, l2, j, i, bool);
              return;
            }
            if ((paramContext.d) && (paramContext.jdField_a_of_type_Long == l1))
            {
              if (paramContext.a().j == 2)
              {
                paramIntent = this.a;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(l1);
                ((StringBuilder)localObject).append("");
                if (paramIntent.b(((StringBuilder)localObject).toString())) {
                  return;
                }
              }
              paramContext.a(1, l1, 77);
              paramContext.a(l1, l2, j, i, bool);
            }
            paramIntent = new Intent();
            paramIntent.setAction("tencent.av.v2q.MultiVideo");
            paramIntent.putExtra("type", 25);
            paramIntent.putExtra("relationId", l1);
            paramIntent.putExtra("relationType", j);
            paramIntent.putExtra("MultiAVType", paramContext.a().j);
            if (i == 7) {
              paramIntent.putExtra("reason", 4);
            } else {
              paramIntent.putExtra("reason", 8);
            }
            paramIntent.putExtra("from", "VideoAppInterface4");
            paramIntent.setPackage(this.a.getApp().getPackageName());
            this.a.getApp().sendBroadcast(paramIntent);
            return;
          }
          if (paramIntent.getAction().equals("tencent.video.q2v.SelectMember"))
          {
            if (QLog.isColorLevel()) {
              QLog.d(GAudioMessageMonitor.a, 2, "ACTION_SELECT_MEMBER");
            }
            i = paramIntent.getIntExtra("InviteCount", 0);
            paramIntent = paramIntent.getStringExtra("FirstName");
            if (QLog.isColorLevel())
            {
              localObject = GAudioMessageMonitor.a;
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("ACTION_SELECT_MEMBER --> InviteCount = ");
              localStringBuilder1.append(i);
              localStringBuilder1.append(" , FirstName = ");
              localStringBuilder1.append(paramIntent);
              QLog.d((String)localObject, 2, localStringBuilder1.toString());
            }
            if ((i > 0) && (paramContext != null)) {
              paramContext.d(i, paramIntent);
            }
          }
          else
          {
            if (paramIntent.getAction().equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED"))
            {
              paramContext.f(paramIntent.getBooleanExtra("isResume", false));
              return;
            }
            long l4;
            if (paramIntent.getAction().equals("tencent.video.q2v.GvideoGift"))
            {
              i = paramIntent.getIntExtra("type", -1);
              l1 = paramIntent.getLongExtra("fromUin", -1L);
              l2 = paramIntent.getLongExtra("toUin", -1L);
              j = paramIntent.getIntExtra("count", -1);
              l3 = paramIntent.getLongExtra("seq", -1L);
              l4 = paramIntent.getLongExtra("groupId", -1L);
              if ((i > 0) && (l1 > 0L) && (l2 > 0L) && (j > 0) && (l4 > 0L) && (paramContext != null)) {
                paramContext.a(i, l1, l2, j, l3, l4);
              }
            }
            else if (paramIntent.getAction().equals("tencent.video.q2v.GvideoLevelUpgrade"))
            {
              i = paramIntent.getIntExtra("type", -1);
              l1 = paramIntent.getLongExtra("fromUin", -1L);
              l2 = paramIntent.getLongExtra("toUin", -1L);
              j = paramIntent.getIntExtra("enable", -1);
              int k = paramIntent.getIntExtra("level", -1);
              l3 = paramIntent.getLongExtra("seq", -1L);
              l4 = paramIntent.getLongExtra("groupId", -1L);
              if ((i > 0) && (l1 > 0L) && (l2 > 0L) && (k > 0) && (l4 > 0L) && (paramContext != null)) {
                paramContext.a(i, l1, l2, j, k, l3, l4);
              }
            }
            else if (paramIntent.getAction().equals("tencent.video.q2v.randomMultiOwnerOnlinePush"))
            {
              if ((paramContext != null) && (paramContext.a() != null))
              {
                if (paramContext.a().E == 7)
                {
                  this.a.a(new Object[] { Integer.valueOf(209), Long.valueOf(paramIntent.getLongExtra("group_id", 0L)), Integer.valueOf(paramIntent.getIntExtra("member_num", 0)), paramIntent.getStringExtra("string_data") });
                  if (QLog.isColorLevel()) {
                    QLog.d(GAudioMessageMonitor.a, 2, "[random room owner] ACTION_RANDOM_MULTI_OWNER_ONLINE_PUSH");
                  }
                }
              }
              else if (paramContext.a() == null) {
                AVLog.printErrorLog(GAudioMessageMonitor.a, "ACTION_RANDOM_MULTI_OWNER_ONLINE_PUSH videoController.getSessionInfo() == null");
              }
            }
            else if (paramIntent.getAction().equals("tencent.video.q2v.random1V1OnlinePush"))
            {
              if ((paramContext != null) && (paramContext.a() != null))
              {
                this.a.a(new Object[] { Integer.valueOf(210), Integer.valueOf(paramIntent.getIntExtra("rsptype", 0)), paramIntent.getStringExtra("rspbody") });
                return;
              }
              if (paramContext.a() == null) {
                AVLog.printErrorLog(GAudioMessageMonitor.a, "ACTION_RANDOM_1V1_ONLINE_PUSH videoController.getSessionInfo() == null");
              }
            }
            else if (paramIntent.getAction().equals("tencent.video.q2v.AudioTransPush"))
            {
              if ((paramContext != null) && (paramContext.a() != null))
              {
                i = paramIntent.getIntExtra("rsptype", 0);
                paramContext = paramIntent.getByteArrayExtra("rspbody");
                paramIntent = GAudioMessageMonitor.a;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("ACTION_AUDIO_TRANS_PUSH rsptype=");
                ((StringBuilder)localObject).append(i);
                ((StringBuilder)localObject).append("|");
                ((StringBuilder)localObject).append(paramContext.length);
                QLog.d(paramIntent, 2, ((StringBuilder)localObject).toString());
                ((AudioTransClientInterfaceHandler)this.a.getBusinessHandler(BusinessHandlerFactory.a)).a(i, paramContext);
                return;
              }
              if (paramContext.a() == null) {
                AVLog.printErrorLog(GAudioMessageMonitor.a, " ACTION_AUDIO_TRANS_PUSH videoController.getSessionInfo() == null");
              }
            }
            else if (paramIntent.getAction().equals("tencent.video.q2v.avreportOnlinePush"))
            {
              if ((paramContext != null) && (paramContext.a() != null))
              {
                i = paramIntent.getIntExtra("rsptype", 0);
                if (i == 1) {
                  AVPushReport.a(this.a, i, paramIntent.getStringExtra("rspbody"));
                }
              }
              else if (paramContext.a() == null)
              {
                AVLog.printErrorLog(GAudioMessageMonitor.a, "ACTION_AV_REPORT_PUSH videoController.getSessionInfo() == null");
              }
            }
            else if ("tencent.video.q2v.AudioEngineReady".equals(paramIntent.getAction()))
            {
              l1 = paramIntent.getLongExtra("c2cuin", 0L);
              l2 = paramIntent.getLongExtra("c2croomid", 0L);
              paramIntent = GAudioMessageMonitor.a;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("ACTION_OPPOSITE_AUDIO_ENGINE_READY:");
              ((StringBuilder)localObject).append(l1);
              ((StringBuilder)localObject).append("|");
              ((StringBuilder)localObject).append(l2);
              QLog.d(paramIntent, 1, ((StringBuilder)localObject).toString());
              if (l1 != 0L)
              {
                if (l2 == 0L) {
                  return;
                }
                paramContext.a(l1, l2);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAudioMessageMonitor.GAudioMsgReceiver
 * JD-Core Version:    0.7.0.1
 */