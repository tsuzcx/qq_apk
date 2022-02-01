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
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "rejectMultiChat, session[" + paramString + "], relationType[" + paramInt + "], groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    TraeHelper.a(paramVideoAppInterface);
    VideoController.a().a(paramLong1, paramInt, paramLong2);
    paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a(paramString);
    }
  }
  
  public void a(long paramLong, VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "rejectDoubleChat, session[" + paramString1 + "], peerUin[" + paramString2 + "], isDoubleVideoMeeting[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    TraeHelper.a(paramVideoAppInterface);
    VideoController localVideoController = VideoController.a();
    if (paramBoolean)
    {
      localVideoController.a(paramLong, paramString2, 1, true);
      long l = CharacterUtil.a(paramString2);
      localVideoController.a(paramLong, 3, l);
      localVideoController.a(paramLong, l, 1);
    }
    for (;;)
    {
      paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a(paramString1);
      }
      return;
      localVideoController.a(paramLong, paramString2, 1, false);
      localVideoController.a(paramString2, 248);
      localVideoController.b(248);
      localVideoController.b(paramString2, 1);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    Object localObject;
    label209:
    do
    {
      return;
      paramContext = paramIntent.getAction();
      long l = SeqUtil.a(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotifyActionMonitor", 2, "onReceive action[" + paramContext + "], seq[" + l + "]");
      }
      if ("com.tencent.qav.notify.refuse".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("session_id");
        paramIntent = SessionMgr.a().c(paramContext);
        if (QLog.isColorLevel()) {
          QLog.i("QAVNotifyActionMonitor", 2, "refuse call session[" + paramContext + "], info[" + paramIntent + "], seq[" + l + "]");
        }
        if (paramIntent != null)
        {
          localObject = (VideoAppInterface)this.a.get();
          if (!SessionMgr.a(paramIntent)) {
            break label209;
          }
          a(l, (VideoAppInterface)localObject, paramIntent.c, paramIntent.d, paramIntent.J);
        }
        for (;;)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A2C7", "0X800A2C7", 0, 0, "", "", "", "");
          return;
          a(l, (VideoAppInterface)localObject, paramContext, paramIntent.F, paramIntent.g);
        }
      }
      if ("tencent.video.q2v.ptusoDownloadRet".equals(paramContext))
      {
        PtuResChecker.a(paramIntent);
        return;
      }
    } while (!"tencent.video.q2v.avReceivePushMsg".equals(paramContext));
    paramContext = paramIntent.getStringExtra("msg_key");
    int i = paramIntent.getIntExtra("msg_type", 0);
    paramIntent = paramIntent.getByteArrayExtra("msg_content");
    if (TextUtils.equals(paramContext, "avChatRoom"))
    {
      localObject = VideoController.a().a();
      if (localObject != null)
      {
        localObject = ((VideoAppInterface)localObject).a();
        if (localObject != null) {
          ((ChatRoomMng)localObject).a(i, paramIntent);
        }
      }
      label315:
      if (!QLog.isDevelopLevel()) {
        break label425;
      }
      paramContext = new StringBuilder().append("ACTION_AV_RECEIVE_PUSH_MSG , key[").append(paramContext).append("], msgType[").append(i).append("], msgContent[");
      if (paramIntent != null) {
        break label427;
      }
    }
    label425:
    label427:
    for (i = 0;; i = paramIntent.length)
    {
      QLog.i("ChatRoomMng", 4, i + "]");
      return;
      if (!TextUtils.equals(paramContext, "avWatchTogether")) {
        break label315;
      }
      localObject = VideoController.a().a();
      if (localObject == null) {
        break label315;
      }
      localObject = (WTogetherMng)((VideoAppInterface)localObject).a(15);
      if (localObject == null) {
        break label315;
      }
      ((WTogetherMng)localObject).a(i, paramIntent);
      break label315;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.QAVNotifyActionMonitor.QAVNotifyActionReceiver
 * JD-Core Version:    0.7.0.1
 */