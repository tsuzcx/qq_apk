package com.tencent.avgame.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import mxc;
import myk;

public class AVGameBroadcastReceiver
  extends BroadcastReceiver
{
  public static final String[] a;
  public static final String[] b = { "tencent.avgame.g2q.preload", "action_notify_av_game_room_changed", "tencent.avgame.g2q.exit" };
  public static final String[] c = { "tencent.video.v2g.exitAVGame", "tencent.avgame.q2g.entring" };
  private final WeakReference<AppRuntime> a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  public AVGameBroadcastReceiver(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
  }
  
  private void a(VideoAppInterface paramVideoAppInterface, Context paramContext, Intent paramIntent)
  {
    paramVideoAppInterface = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBroadcastReceiver", 2, "actionToVideo, action[" + paramVideoAppInterface + "]");
    }
  }
  
  private void a(AVGameAppInterface paramAVGameAppInterface, Context paramContext, Intent paramIntent)
  {
    paramAVGameAppInterface = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBroadcastReceiver", 2, "actionToAVGame, action[" + paramAVGameAppInterface + "]");
    }
    if ("tencent.video.v2g.exitAVGame".equals(paramAVGameAppInterface)) {
      myk.a().a(8, null, myk.a().a());
    }
    while (!"tencent.avgame.q2g.entring".equals(paramAVGameAppInterface)) {
      return;
    }
    ProcessMonitor.a().a("ACTION_MAIN_TO_AV_GAME_ENTERING");
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBroadcastReceiver", 2, "actionToQQ, action[" + paramContext + "]");
    }
    if ("tencent.avgame.g2q.preload".equals(paramContext)) {
      AVGameUtilService.a(paramIntent, true);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!"action_notify_av_game_room_changed".equals(paramContext)) {
          break;
        }
        i = paramIntent.getIntExtra("action_key_status", 0);
        paramContext = paramIntent.getStringExtra("action_key_room_id");
        paramQQAppInterface = (mxc)paramQQAppInterface.getManager(373);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.a(i, paramContext);
      return;
    } while (!"tencent.avgame.g2q.exit".equals(paramContext));
    AVGameUtilService.a(null, false);
  }
  
  public String[] a()
  {
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localAppRuntime instanceof VideoAppInterface)) {
      return jdField_a_of_type_ArrayOfJavaLangString;
    }
    if ((localAppRuntime instanceof QQAppInterface)) {
      return b;
    }
    if ((localAppRuntime instanceof AVGameAppInterface)) {
      return c;
    }
    return null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localAppRuntime == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        str = paramIntent.getAction();
        if (QLog.isDevelopLevel()) {
          QLog.i("AVGameBroadcastReceiver", 4, "onReceive, action[" + str + "]");
        }
        String[] arrayOfString;
        if ((localAppRuntime instanceof VideoAppInterface))
        {
          arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
          j = arrayOfString.length;
          while (i < j)
          {
            if (TextUtils.equals(str, arrayOfString[i]))
            {
              a((VideoAppInterface)localAppRuntime, paramContext, paramIntent);
              return;
            }
            i += 1;
          }
        }
        else if ((localAppRuntime instanceof QQAppInterface))
        {
          arrayOfString = b;
          k = arrayOfString.length;
          i = j;
          while (i < k)
          {
            if (TextUtils.equals(str, arrayOfString[i]))
            {
              a((QQAppInterface)localAppRuntime, paramContext, paramIntent);
              return;
            }
            i += 1;
          }
        }
        else
        {
          if (!(localAppRuntime instanceof AVGameAppInterface)) {
            break;
          }
          arrayOfString = c;
          j = arrayOfString.length;
          i = k;
          while (i < j)
          {
            if (TextUtils.equals(str, arrayOfString[i]))
            {
              a((AVGameAppInterface)localAppRuntime, paramContext, paramIntent);
              return;
            }
            i += 1;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("AVGameBroadcastReceiver", 2, "onReceive, not deal action[" + str + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */