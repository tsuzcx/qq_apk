package com.tencent.mobileqq.apollo.game.process.chanel;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

public class CmGameToolCmdChannel
{
  private static String[] a = { "cs.game_start.local", "cs.check_pubAccount_state.local", "general_cmd_ui_show_toast", "cs.get_dress_path.local", "cs.report_data_2_backstage.local", "cs.report_flow_data.local", "cs.openWebView.local", "cs.openFloatTransparentView.local", "cs.get_server_ip_port.local", "cs.save_recommend_ip.local", "cs.script_get_action_data.local" };
  private static String[] b = { "cs.report_data_2_compass.local", "cs.qta_notify_test_result.local", "cs.apolloGameWebMessage.local", "cs.openWebViewWithoutUrl.local", "cs.enter_pubAccount_card.local", "cs.closeWebview.local", "cs.game_ad_video_jump.local", "cs.game_ad_video_close.local", "cs.get_user_info.local", "cs.get_app_friends.local", "cs.get_location.local", "cs.get_city.local", "cs.apolloGameTargetWebMessage.local", "cs.load_subpackage.local", "sc.load_percentage_nofity.local", "cs.file_correctness_check.local", "cs.report_event.local" };
  private static String[] c = { "cs.first_frame_drawn.local", "cs.close_room.local" };
  
  public static int a(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!CmGameUtil.a()) {
      return 0;
    }
    CmGameLauncher localCmGameLauncher = CmGameUtil.b(paramLong);
    int i;
    if (localCmGameLauncher != null) {
      i = localCmGameLauncher.g();
    } else {
      i = -1;
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
    } else if (a(paramString, b)) {
      i = 2;
    } else if (a(paramString, c)) {
      i = 3;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, new Object[] { "[getCmdType], cmd:", paramString, ",type:", Integer.valueOf(i) });
    }
    return i;
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
    if (paramString1.equals("cs.check_pubAccount_state.local"))
    {
      a(paramString1, paramString2, paramBoolean, new CmGameToolCmdChannel.1(paramLong), paramInt);
      return false;
    }
    Object localObject;
    if (paramString1.equals("cs.get_dress_path.local"))
    {
      CmGameToolCmdChannel.2 local2 = new CmGameToolCmdChannel.2(paramLong, paramString1);
      try
      {
        CmGameLauncher localCmGameLauncher = CmGameUtil.b(paramLong);
        String str = paramString2;
        if (localCmGameLauncher != null)
        {
          JSONObject localJSONObject = new JSONObject(paramString2);
          str = paramString2;
          if (!localJSONObject.has("gameId"))
          {
            localJSONObject.put("gameId", localCmGameLauncher.g());
            str = localJSONObject.toString();
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameToolCmdChannel", 1, localException, new Object[0]);
        localObject = paramString2;
      }
      a(paramString1, (String)localObject, paramBoolean, local2, paramInt);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append(" GET_DRESS_PATH ccallServer reqData:");
        paramString1.append((String)localObject);
        QLog.d("cmgame_process.CmGameToolCmdChannel", 2, paramString1.toString());
        return false;
      }
    }
    else if (paramString1.equals("cs.script_get_action_data.local"))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("cmd", paramString1);
      ((Bundle)localObject).putString("reqData", paramString2);
      ((Bundle)localObject).putBoolean("async", paramBoolean);
      paramString1 = new CmGameToolCmdChannel.3(paramLong);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_get_action_data", (Bundle)localObject, paramString1);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("GET_ACTION_DATA ccallServer bundle:");
        paramString1.append(localObject);
        QLog.d("cmgame_process.CmGameToolCmdChannel", 2, paramString1.toString());
        return false;
      }
    }
    else
    {
      a(paramString1, paramString2, paramBoolean, null, paramInt);
    }
    return false;
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfString != null))
    {
      if (paramArrayOfString.length == 0) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameToolCmdChannel
 * JD-Core Version:    0.7.0.1
 */