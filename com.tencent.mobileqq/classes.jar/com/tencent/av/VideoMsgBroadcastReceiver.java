package com.tencent.av;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class VideoMsgBroadcastReceiver
  extends BroadcastReceiver
{
  private static boolean a = true;
  private static boolean b;
  
  private void a(Bundle paramBundle, VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgBroadcastReceiver", 2, "processMultiVideoOfflineMsg");
    }
    MqqHandler localMqqHandler = paramVideoController.aH();
    if (localMqqHandler != null)
    {
      localMqqHandler.post(new VideoMsgBroadcastReceiver.1(this, paramVideoController, paramBundle));
      return;
    }
    paramVideoController.n.receiveMultiVideoOfflineMsg(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgBroadcastReceiver", 2, "processMultiVideoOfflineMsg, sync");
    }
  }
  
  private void a(Bundle paramBundle, String paramString, VideoController paramVideoController)
  {
    if (paramBundle != null)
    {
      if (paramVideoController == null) {
        return;
      }
      long l = paramBundle.getLong("onLineStatus");
      boolean bool = paramBundle.getBoolean("isRequest");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("avideo processSharpVideoOfflineMsg, onLineStatus[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("], isRequest[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.d("VideoMsgBroadcastReceiver", 1, ((StringBuilder)localObject).toString());
      localObject = paramVideoController.aH();
      if (localObject != null)
      {
        ((MqqHandler)localObject).post(new VideoMsgBroadcastReceiver.2(this, paramBundle));
      }
      else
      {
        paramVideoController.n.receiveSharpVideoOfflineMsg(paramBundle);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processSharpVideoOfflineMsg, data[");
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append("], sync");
        QLog.i("VideoMsgBroadcastReceiver", 1, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        paramVideoController.a(201, paramString);
        if (paramVideoController.o() == 0)
        {
          paramVideoController.a(207, paramString);
          return;
        }
        paramVideoController.a(206, paramString);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((QLog.isColorLevel()) && (paramIntent != null)) {
      AudioHelper.a("VideoMsgBroadcastReceiver.onReceive", paramIntent.getExtras(), true);
    }
    Object localObject2;
    String str1;
    String str2;
    String str3;
    Object localObject1;
    if ((paramIntent != null) && (paramContext != null))
    {
      localObject2 = paramIntent.getExtras();
      if (localObject2 == null)
      {
        QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive data is null!");
        return;
      }
      paramContext = ((Bundle)localObject2).getString("uin");
      str1 = ((Bundle)localObject2).getString("fromUin");
      str2 = ((Bundle)localObject2).getString("gatewayip");
      if (paramContext == null)
      {
        QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive uin is null!");
        return;
      }
      str3 = paramIntent.getAction();
      if (TextUtils.isEmpty(str3))
      {
        QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive action is null!");
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive Recv uin = ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" action ");
      ((StringBuilder)localObject1).append(str3);
      QLog.d("VideoMsgBroadcastReceiver", 1, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = MobileQQ.sMobileQQ;
      if (localObject1 == null)
      {
        QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive mobileQQ is null!");
        return;
      }
      VideoAppInterface localVideoAppInterface = (VideoAppInterface)((MobileQQ)localObject1).getAppRuntime(paramContext);
      if (localVideoAppInterface == null)
      {
        QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive app is null!");
        return;
      }
      localObject1 = localVideoAppInterface.b();
      if (str2 != null) {
        ((VideoController)localObject1).d(str2, 0);
      }
      long l1;
      if ("com.tencent.av.ui.VChatActivity".equals(str3))
      {
        int i = ((Bundle)localObject2).getInt("source");
        int j = ((Bundle)localObject2).getInt("type");
        l1 = ((Bundle)localObject2).getLong("processExitTimestamp");
        QLog.d("VideoMsgBroadcastReceiver", 1, String.format("onReceive ACTION_AWAKE_PROCESS source=%s type=%s processExitTimestamp=%s sHasRecoverLastCall=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Boolean.valueOf(b) }));
        if (a) {
          localVideoAppInterface.b(true);
        }
        a = false;
        if (j == 1)
        {
          paramContext = localVideoAppInterface.d();
          if ((!b) && (paramContext != null))
          {
            paramContext.a(i, l1);
            b = true;
          }
        }
      }
      else
      {
        if ("tencent.video.q2v.RecvSharpVideoCall".equals(str3))
        {
          a((Bundle)localObject2, str1, (VideoController)localObject1);
          return;
        }
        if ("tencent.video.q2v.RecvMultiVideoCall".equals(str3))
        {
          a((Bundle)localObject2, (VideoController)localObject1);
          return;
        }
        if ("tencent.video.q2v.RecvBaseIMSharpMsg".equals(str3))
        {
          paramContext = paramIntent.getBundleExtra("msgData");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RecvBaseIMSharpMsg:");
          ((StringBuilder)localObject2).append(paramContext);
          QLog.d("VideoMsgBroadcastReceiver", 1, ((StringBuilder)localObject2).toString());
          if (paramContext != null)
          {
            paramContext = paramContext.getByteArray("value");
            l1 = paramIntent.getLongExtra("tinyid", 0L);
            paramIntent = new Bundle();
            paramIntent.putByteArray("buffer", paramContext);
            paramIntent.putLong("tiny_id", l1);
            ((VideoController)localObject1).n.receiveDeviceMsg(paramIntent);
          }
        }
        else if ("tencent.video.q2v.sendQueryRoomInfoRequest".equals(str3))
        {
          l1 = paramIntent.getLongExtra("roomId", 0L);
          long l2 = paramIntent.getLongExtra("peerUin", 0L);
          long l3 = SeqUtil.a(paramIntent);
          paramContext = new StringBuilder();
          paramContext.append("QueryRoomInfo.receive, roomId[");
          paramContext.append(l1);
          paramContext.append("], peerUin[");
          paramContext.append(l2);
          paramContext.append("], seq[");
          paramContext.append(l3);
          paramContext.append("]");
          QLog.w("VideoMsgBroadcastReceiver", 1, paramContext.toString());
          ((VideoController)localObject1).b(l1, l2);
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive Exception Account not match: uin = ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append("app == null");
      QLog.d("VideoMsgBroadcastReceiver", 1, ((StringBuilder)localObject1).toString(), paramIntent);
      return;
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive Account not match: uin = ");
      paramIntent.append(paramContext);
      QLog.d("VideoMsgBroadcastReceiver", 1, paramIntent.toString());
      return;
      QLog.w("VideoMsgBroadcastReceiver", 1, "onReceive, intent or context is null!");
      return;
    }
    catch (AccountNotMatchException paramIntent)
    {
      label678:
      break label678;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoMsgBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */