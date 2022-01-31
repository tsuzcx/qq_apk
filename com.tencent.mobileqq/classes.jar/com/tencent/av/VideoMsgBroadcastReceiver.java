package com.tencent.av;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lec;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;
import mtm;

public class VideoMsgBroadcastReceiver
  extends BroadcastReceiver
{
  private static boolean a = true;
  private static boolean b;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((QLog.isColorLevel()) && (paramIntent != null)) {
      AudioHelper.a("VideoMsgBroadcastReceiver.onReceive", paramIntent.getExtras(), true);
    }
    if ((paramIntent == null) || (paramContext == null)) {
      QLog.w("VideoMsgBroadcastReceiver", 1, "onReceive, intent or context is null!");
    }
    String str3;
    Object localObject;
    do
    {
      do
      {
        do
        {
          Bundle localBundle;
          String str1;
          boolean bool;
          do
          {
            int i;
            do
            {
              VideoAppInterface localVideoAppInterface;
              int j;
              do
              {
                return;
                localBundle = paramIntent.getExtras();
                if (localBundle == null)
                {
                  QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive data is null!");
                  return;
                }
                paramContext = localBundle.getString("uin");
                str1 = localBundle.getString("fromUin");
                String str2 = localBundle.getString("gatewayip");
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
                QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive Recv uin = " + paramContext + " action " + str3);
                try
                {
                  localObject = MobileQQ.sMobileQQ;
                  if (localObject == null)
                  {
                    QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive mobileQQ is null!");
                    return;
                  }
                }
                catch (AccountNotMatchException paramIntent)
                {
                  QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive Account not match: uin = " + paramContext);
                  return;
                  localVideoAppInterface = (VideoAppInterface)((MobileQQ)localObject).getAppRuntime(paramContext);
                  if (localVideoAppInterface == null)
                  {
                    QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive app is null!");
                    return;
                  }
                }
                catch (Exception paramIntent)
                {
                  QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive Exception Account not match: uin = " + paramContext + "app == null", paramIntent);
                  return;
                }
                localObject = localVideoAppInterface.a();
                if (str2 != null) {
                  ((VideoController)localObject).f(str2, 0);
                }
                if (!str3.equals("com.tencent.av.ui.VChatActivity")) {
                  break;
                }
                i = localBundle.getInt("source");
                j = localBundle.getInt("type");
                l1 = localBundle.getLong("processExitTimestamp");
                QLog.d("VideoMsgBroadcastReceiver", 1, String.format("onReceive ACTION_AWAKE_PROCESS source=%s type=%s processExitTimestamp=%s sHasRecoverLastCall=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Boolean.valueOf(b) }));
                if (a) {
                  localVideoAppInterface.b(true);
                }
                a = false;
              } while (j != 1);
              paramContext = localVideoAppInterface.a();
            } while ((b) || (paramContext == null));
            paramContext.a(i, l1);
            b = true;
            return;
            if (!str3.equals("tencent.video.q2v.RecvSharpVideoCall")) {
              break;
            }
            l1 = localBundle.getLong("onLineStatus");
            bool = localBundle.getBoolean("isRequest");
            QLog.d("VideoMsgBroadcastReceiver", 1, "avideo onRecvSharpOfflineMsg:" + l1 + "|" + bool);
            ((VideoController)localObject).a(localBundle);
          } while (!bool);
          ((VideoController)localObject).b(201, str1);
          if (((VideoController)localObject).a() == 0)
          {
            ((VideoController)localObject).b(207, str1);
            return;
          }
          ((VideoController)localObject).b(206, str1);
          return;
          if (str3.equals("tencent.video.q2v.RecvMultiVideoCall"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoMsgBroadcastReceiver", 2, "onRecvMultiVideoOfflineMsg");
            }
            ((VideoController)localObject).b(localBundle);
            return;
          }
          if (!str3.equals("tencent.video.q2v.RecvBaseIMSharpMsg")) {
            break;
          }
          paramContext = paramIntent.getBundleExtra("msgData");
          QLog.d("VideoMsgBroadcastReceiver", 1, "RecvBaseIMSharpMsg:" + paramContext);
        } while (paramContext == null);
        paramContext = paramContext.getByteArray("value");
        l1 = paramIntent.getLongExtra("tinyid", 0L);
      } while (paramContext == null);
      ((VideoController)localObject).a(l1, paramContext);
      return;
    } while (!str3.equals("tencent.video.q2v.sendQueryRoomInfoRequest"));
    long l1 = paramIntent.getLongExtra("roomId", 0L);
    long l2 = paramIntent.getLongExtra("peerUin", 0L);
    long l3 = mtm.a(paramIntent);
    QLog.w("VideoMsgBroadcastReceiver", 1, "QueryRoomInfo.receive, roomId[" + l1 + "], peerUin[" + l2 + "], seq[" + l3 + "]");
    ((VideoController)localObject).c(l1, l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.VideoMsgBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */