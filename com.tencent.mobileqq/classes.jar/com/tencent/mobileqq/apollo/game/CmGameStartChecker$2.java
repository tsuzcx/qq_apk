package com.tencent.mobileqq.apollo.game;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONObject;

class CmGameStartChecker$2
  implements Runnable
{
  CmGameStartChecker$2(CmGameStartChecker paramCmGameStartChecker, int paramInt) {}
  
  public void run()
  {
    label885:
    for (;;)
    {
      try
      {
        AppInterface localAppInterface = (AppInterface)CmGameStartChecker.c(this.this$0).get();
        if ((CmGameStartChecker.a(this.this$0) != null) && (localAppInterface != null))
        {
          boolean bool = QLog.isColorLevel();
          int j = 0;
          if (bool) {
            QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "[checkGame] startCheckParam:", CmGameStartChecker.a(this.this$0) });
          }
          Object localObject1 = new WebSSOAgent.UniSsoServerReqComm();
          ((WebSSOAgent.UniSsoServerReqComm)localObject1).platform.set(109L);
          ((WebSSOAgent.UniSsoServerReqComm)localObject1).osver.set(Build.VERSION.RELEASE);
          ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("8.8.17");
          WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
          localUniSsoServerReq.comm.set((MessageMicro)localObject1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("cmd", "apollo_aio_game.check_game_v2");
          if (TextUtils.isEmpty(CmGameStartChecker.a(this.this$0).from))
          {
            localObject1 = "android";
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("android.");
            ((StringBuilder)localObject1).append(CmGameStartChecker.a(this.this$0).from);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localJSONObject.put("from", localObject1);
          localJSONObject.put("version", CmGameStartChecker.a(this.this$0).version);
          localJSONObject.put("gameId", CmGameStartChecker.a(this.this$0).gameId);
          localJSONObject.put("aioType", CmGameStartChecker.a(this.this$0).sessionType);
          localJSONObject.put("sessionId", CmGameStartChecker.a(this.this$0).sessionUin);
          localJSONObject.put("src", CmGameStartChecker.a(this.this$0).src);
          if (!TextUtils.isEmpty(CmGameStartChecker.a(this.this$0).mSendMsgUin)) {
            localJSONObject.put("sendMsgUin", CmGameStartChecker.a(this.this$0).mSendMsgUin);
          }
          if ((CmGameStartChecker.a(this.this$0).isNeedConfInfo) || (CmGameStartChecker.a(this.this$0).game == null))
          {
            localJSONObject.put("needGConfInfo", 1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[checkGame] local has not game data gameId:");
            ((StringBuilder)localObject1).append(CmGameStartChecker.a(this.this$0).gameId);
            QLog.i("cmgame_process.CmGameStartChecker", 1, ((StringBuilder)localObject1).toString());
          }
          int i;
          try
          {
            float f = Float.parseFloat(CmGameStartChecker.a(this.this$0).version);
            i = (int)f;
            try
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
              ((StringBuilder)localObject1).append(CmGameStartChecker.a(this.this$0).gameId);
              ((StringBuilder)localObject1).append(".zip");
              bool = new File(((StringBuilder)localObject1).toString()).exists();
              if (bool) {
                break label885;
              }
              i = j;
            }
            catch (Exception localException1) {}
            QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] parse res version error:", localException2);
          }
          catch (Exception localException2)
          {
            i = 0;
          }
          break label885;
          localJSONObject.put("localResVer", i);
          Object localObject2 = (TicketManager)localAppInterface.getManager(2);
          if (localObject2 != null)
          {
            String str = ((TicketManager)localObject2).getSkey(localAppInterface.getCurrentAccountUin());
            localObject2 = str;
            if (TextUtils.isEmpty(str)) {
              localObject2 = "";
            }
            localJSONObject.put("skey", localObject2);
          }
          this.this$0.d = System.currentTimeMillis();
          j = ApolloGameResManager.a(CmGameStartChecker.a(this.this$0).gameId);
          localJSONObject.put("pkgMode", j);
          localJSONObject.put("pModel", DeviceInfoUtil.u());
          localUniSsoServerReq.reqdata.set(localJSONObject.toString());
          localObject2 = new NewIntent(localAppInterface.getApp(), CmGameServlet.class);
          ((NewIntent)localObject2).putExtra("key1", String.valueOf(this.a));
          ((NewIntent)localObject2).putExtra("cmd", "apollo_aio_game.check_game_v2");
          ((NewIntent)localObject2).putExtra("data", localUniSsoServerReq.toByteArray());
          ((NewIntent)localObject2).putExtra("timeout", 5000L);
          ((NewIntent)localObject2).setObserver(this.this$0);
          localAppInterface.startServlet((NewIntent)localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[checkGame] req gameId:");
          ((StringBuilder)localObject2).append(CmGameStartChecker.a(this.this$0).gameId);
          ((StringBuilder)localObject2).append(",checkGameWay:");
          ((StringBuilder)localObject2).append(this.a);
          ((StringBuilder)localObject2).append(",ver:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",src:");
          ((StringBuilder)localObject2).append(CmGameStartChecker.a(this.this$0).src);
          ((StringBuilder)localObject2).append(",rscType:");
          ((StringBuilder)localObject2).append(j);
          QLog.i("cmgame_process.CmGameStartChecker", 1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] mCheckParam or app is null");
          return;
        }
      }
      catch (Exception localException3)
      {
        QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] pullApolloGameKey failed Exception:", localException3);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameStartChecker.2
 * JD-Core Version:    0.7.0.1
 */