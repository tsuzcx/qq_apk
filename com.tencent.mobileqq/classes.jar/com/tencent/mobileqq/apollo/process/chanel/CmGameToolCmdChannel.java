package com.tencent.mobileqq.apollo.process.chanel;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import org.json.JSONObject;
import yrg;
import yrh;
import yri;
import yrj;

public class CmGameToolCmdChannel
{
  private static String[] a = { "cs.create_room.local", "cs.game_start.local", "cs.game_tips.local", "cs.check_pubAccount_state.local", "cs.enter_pubAccount_card.local", "cs.on_get_open_key.local", "general_cmd_ui_show_toast", "cs.get_dress_path.local", "cs.send_game_msg.local", "cs.report_data_2_backstage.local", "cs.report_flow_data.local", "cs.openWebView.local", "cs.openFloatTransparentView.local", "cs.get_server_ip_port.local", "cs.save_recommend_ip.local", "cs.script_get_action_data.local", "cs.game_shell_share_callback.local" };
  private static String[] b = { "cs.report_data_2_compass.local", "cs.invite_friends.local", "cs.share_game_result.local", "cs.share_pic.local", "cs.apolloGameWebMessage.local", "cs.openWebViewWithoutUrl.local", "cs.share_game_in_ark.local" };
  private static String[] c = { "cs.first_frame_drawn.local", "cs.join_room.local", "cs.make_room_min.local", "cs.close_room.local" };
  
  public static int a(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!CmGameUtil.a()) {
      return 0;
    }
    int i = -1;
    CmGameLauncher localCmGameLauncher = CmGameUtil.b(paramLong);
    if (localCmGameLauncher != null) {
      i = localCmGameLauncher.a();
    }
    int j = a(paramString1);
    if ((1 == j) || (3 == j)) {
      a(paramLong, paramString1, paramString2, paramBoolean, i);
    }
    return j;
  }
  
  public static int a(String paramString)
  {
    int i;
    if (a(paramString, a)) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameToolCmdChannel", 2, new Object[] { "[getCmdType], cmd:", paramString, ",type:", Integer.valueOf(i) });
      }
      return i;
      if (a(paramString, b)) {
        i = 2;
      } else if (a(paramString, c)) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, EIPCResultCallback paramEIPCResultCallback, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("reqData", paramString2);
    localBundle.putBoolean("async", paramBoolean);
    localBundle.putInt("gameId", paramInt);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_chanel_req", localBundle, paramEIPCResultCallback);
  }
  
  private static boolean a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    if (paramString1.equals("cs.check_pubAccount_state.local")) {
      a(paramString1, paramString2, paramBoolean, new yrg(paramLong), paramInt);
    }
    label199:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          return false;
          if (paramString1.equals("cs.on_get_open_key.local"))
          {
            a(paramString1, paramString2, paramBoolean, new yrh(paramLong), paramInt);
            return false;
          }
          if (!paramString1.equals("cs.get_dress_path.local")) {
            break label199;
          }
          localObject2 = new yri(paramLong, paramString1);
          try
          {
            CmGameLauncher localCmGameLauncher = CmGameUtil.b(paramLong);
            str = paramString2;
            if (localCmGameLauncher != null)
            {
              JSONObject localJSONObject = new JSONObject(paramString2);
              str = paramString2;
              if (!localJSONObject.has("gameId"))
              {
                localJSONObject.put("gameId", localCmGameLauncher.a());
                str = localJSONObject.toString();
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              String str;
              QLog.e("cmgame_process.CmGameToolCmdChannel", 1, localException, new Object[0]);
              localObject1 = paramString2;
            }
          }
          a(paramString1, str, paramBoolean, (EIPCResultCallback)localObject2, paramInt);
        } while (!QLog.isColorLevel());
        QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GET_DRESS_PATH ccallServer reqData:" + str);
        return false;
        if (!paramString1.equals("cs.script_get_action_data.local")) {
          break;
        }
        Object localObject1 = new yrj(paramLong);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("cmd", paramString1);
        ((Bundle)localObject2).putString("reqData", paramString2);
        ((Bundle)localObject2).putBoolean("async", paramBoolean);
        QIPCClientHelper.getInstance().callServer("cm_game_module", "action_get_action_data", (Bundle)localObject2, (EIPCResultCallback)localObject1);
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, "GET_ACTION_DATA ccallServer bundle:" + localObject2);
      return false;
      if (!"cs.game_shell_share_callback.local".equals(paramString1)) {
        break;
      }
      paramString1 = CmGameUtil.b(paramLong);
      if (paramString1 != null) {
        paramString1.c(paramString2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GAME_SHARE_CALLBACK ");
    return false;
    a(paramString1, paramString2, paramBoolean, null, paramInt);
    return false;
  }
  
  public static boolean a(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!CmGameUtil.a()) {}
    for (;;)
    {
      return false;
      try
      {
        CmGameOpenIdFinder localCmGameOpenIdFinder = CmGameUtil.a(paramLong);
        if (localCmGameOpenIdFinder != null)
        {
          paramBoolean = localCmGameOpenIdFinder.a(paramLong, paramBoolean, paramString1, paramString2);
          return paramBoolean;
        }
      }
      catch (Throwable paramString1) {}
    }
    return false;
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel
 * JD-Core Version:    0.7.0.1
 */