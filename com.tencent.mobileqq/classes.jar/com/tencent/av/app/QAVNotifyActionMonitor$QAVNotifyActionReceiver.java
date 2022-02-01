package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SeqUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QAVNotifyActionMonitor$QAVNotifyActionReceiver
  extends BroadcastReceiver
{
  private final WeakReference<VideoAppInterface> a;
  
  private QAVNotifyActionMonitor$QAVNotifyActionReceiver(VideoAppInterface paramVideoAppInterface)
  {
    this.a = new WeakReference(paramVideoAppInterface);
  }
  
  public void a(long paramLong1, VideoAppInterface paramVideoAppInterface, String paramString, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rejectMultiChat, session[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.i("QAVNotifyActionMonitor", 2, localStringBuilder.toString());
    }
    TraeHelper.b(paramVideoAppInterface);
    VideoController.f().a(paramLong1, paramInt, paramLong2);
    paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a(paramString);
    }
  }
  
  public void a(long paramLong, VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rejectDoubleChat, session[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], peerUin[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], isDoubleVideoMeeting[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.i("QAVNotifyActionMonitor", 2, ((StringBuilder)localObject).toString());
    }
    TraeHelper.b(paramVideoAppInterface);
    Object localObject = VideoController.f();
    if (paramBoolean)
    {
      ((VideoController)localObject).a(paramLong, paramString2, 1, true);
      long l = CharacterUtil.b(paramString2);
      ((VideoController)localObject).a(paramLong, 3, l);
      ((VideoController)localObject).a(paramLong, l, 1);
    }
    else
    {
      ((VideoController)localObject).a(paramLong, paramString2, 1, false);
      ((VideoController)localObject).a(paramString2, 248);
      ((VideoController)localObject).b(248);
      ((VideoController)localObject).b(paramString2, 1);
    }
    paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a(paramString1);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    long l = SeqUtil.a(paramIntent);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive action[");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i("QAVNotifyActionMonitor", 2, ((StringBuilder)localObject).toString());
    }
    if ("com.tencent.qav.notify.refuse".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("session_id");
      paramIntent = SessionMgr.a().d(paramContext);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refuse call session[");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("], info[");
        ((StringBuilder)localObject).append(paramIntent);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        QLog.i("QAVNotifyActionMonitor", 2, ((StringBuilder)localObject).toString());
      }
      if (paramIntent != null)
      {
        localObject = (VideoAppInterface)this.a.get();
        if (SessionMgr.a(paramIntent)) {
          a(l, (VideoAppInterface)localObject, paramIntent.f, paramIntent.s, paramIntent.am);
        } else {
          a(l, (VideoAppInterface)localObject, paramContext, paramIntent.aQ, paramIntent.aN);
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2C7", "0X800A2C7", 0, 0, "", "", "", "");
      return;
    }
    if ("tencent.video.q2v.ptusoDownloadRet".equals(paramContext))
    {
      PtuResChecker.a(paramIntent);
      return;
    }
    boolean bool = "tencent.video.q2v.avReceivePushMsg".equals(paramContext);
    int i = 0;
    if (bool)
    {
      paramContext = paramIntent.getStringExtra("msg_key");
      int j = paramIntent.getIntExtra("msg_type", 0);
      paramIntent = paramIntent.getByteArrayExtra("msg_content");
      if (TextUtils.equals(paramContext, "avChatRoom"))
      {
        localObject = VideoController.f().aj();
        if (localObject != null)
        {
          localObject = ((VideoAppInterface)localObject).A();
          if (localObject != null) {
            ((ChatRoomMng)localObject).a(j, paramIntent);
          }
        }
      }
      else if (TextUtils.equals(paramContext, "avWatchTogether"))
      {
        localObject = VideoController.f().aj();
        if (localObject != null)
        {
          localObject = (WTogetherMng)((VideoAppInterface)localObject).c(17);
          if (localObject != null) {
            ((WTogetherMng)localObject).a(j, paramIntent);
          }
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ACTION_AV_RECEIVE_PUSH_MSG , key[");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("], msgType[");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("], msgContent[");
        if (paramIntent != null) {
          i = paramIntent.length;
        }
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("]");
        QLog.i("ChatRoomMng", 4, ((StringBuilder)localObject).toString());
      }
    }
    else if ("com.tencent.qqhead.getheadresp2".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("uin");
      if (QLog.isDevelopLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("ACTION_ON_UPDATE_FRIEND_HEAD, uin = ");
        paramIntent.append(paramContext);
        QLog.i("QavAvatarHelper", 4, paramIntent.toString());
      }
      ThreadManager.excute(new QAVNotifyActionMonitor.QAVNotifyActionReceiver.1(this, paramContext), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QAVNotifyActionMonitor.QAVNotifyActionReceiver
 * JD-Core Version:    0.7.0.1
 */