package com.tencent.mobileqq.apollo.cmgame;

import amln;
import ampj;
import amrj;
import ancb;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bgln;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
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
    int j = 0;
    for (;;)
    {
      try
      {
        localAppInterface = (AppInterface)CmGameStartChecker.b(this.this$0).get();
        if ((CmGameStartChecker.a(this.this$0) == null) || (localAppInterface == null))
        {
          QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] mCheckParam or app is null");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "[checkGame] startCheckParam:", CmGameStartChecker.a(this.this$0) });
        }
        localObject1 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("8.4.1");
        localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject1);
        localJSONObject = new JSONObject();
        if (CmGameStartChecker.a(this.this$0).gameId == 4698)
        {
          localObject1 = amrj.a(CmGameStartChecker.a(this.this$0).isWhiteUsr);
          localJSONObject.put("cmd", localObject1);
          if (!TextUtils.isEmpty(CmGameStartChecker.a(this.this$0).from)) {
            break label842;
          }
          localObject2 = "android";
          localJSONObject.put("from", localObject2);
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
            QLog.i("cmgame_process.CmGameStartChecker", 1, "[checkGame] local has not game data gameId:" + CmGameStartChecker.a(this.this$0).gameId);
          }
        }
      }
      catch (Exception localException1)
      {
        AppInterface localAppInterface;
        Object localObject1;
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
        JSONObject localJSONObject;
        float f;
        boolean bool;
        String str2;
        QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] pullApolloGameKey failed Exception:", localException1);
        return;
      }
      for (;;)
      {
        try
        {
          f = Float.parseFloat(CmGameStartChecker.a(this.this$0).version);
          i = (int)f;
        }
        catch (Exception localException3)
        {
          String str1;
          i = 0;
          continue;
        }
        try
        {
          bool = new File(ancb.s + CmGameStartChecker.a(this.this$0).gameId + ".zip").exists();
          if (bool) {
            continue;
          }
          i = j;
        }
        catch (Exception localException2)
        {
          continue;
          break;
        }
      }
      localJSONObject.put("localResVer", i);
      Object localObject2 = (TicketManager)localAppInterface.getManager(2);
      if (localObject2 != null)
      {
        str2 = ((TicketManager)localObject2).getSkey(localAppInterface.getCurrentAccountUin());
        localObject2 = str2;
        if (TextUtils.isEmpty(str2)) {
          localObject2 = "";
        }
        localJSONObject.put("skey", localObject2);
      }
      this.this$0.b = System.currentTimeMillis();
      j = ampj.b(CmGameStartChecker.a(this.this$0).gameId);
      localJSONObject.put("pkgMode", j);
      localJSONObject.put("pModel", bgln.i());
      localUniSsoServerReq.reqdata.set(localJSONObject.toString());
      localObject2 = new NewIntent(localAppInterface.getApp(), amln.class);
      ((NewIntent)localObject2).putExtra("key1", String.valueOf(this.a));
      ((NewIntent)localObject2).putExtra("cmd", (String)localObject1);
      ((NewIntent)localObject2).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject2).putExtra("timeout", 5000L);
      ((NewIntent)localObject2).setObserver(this.this$0);
      localAppInterface.startServlet((NewIntent)localObject2);
      ampj.a(new Object[] { "[checkGame], checkGameWay:", Integer.valueOf(this.a), ", localVersion:", Integer.valueOf(i), ", rscType:", Integer.valueOf(j) });
      QLog.i("cmgame_process.CmGameStartChecker", 1, "[checkGame] req gameId:" + CmGameStartChecker.a(this.this$0).gameId + ",checkGameWay:" + this.a + ",ver:" + i + ",src:" + CmGameStartChecker.a(this.this$0).src + ",rscType:" + j);
      return;
      str1 = "apollo_aio_game.check_game_v2";
      continue;
      label842:
      localObject2 = "android." + CmGameStartChecker.a(this.this$0).from;
      continue;
      QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] parse res version error:", (Throwable)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.2
 * JD-Core Version:    0.7.0.1
 */