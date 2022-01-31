package com.tencent.mobileqq.apollo.cmgame;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.apollo.STCheckGame.STCheckGameRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import yve;
import yvf;
import yvg;
import yvh;

public class CmGameStartChecker
  implements BusinessObserver
{
  public DownloadListener a;
  private WeakReference a;
  private WeakReference b;
  
  public CmGameStartChecker(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new yvh(this);
    this.b = new WeakReference(paramAppInterface);
  }
  
  private void e(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      OnGameStartCheckListener localOnGameStartCheckListener = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localOnGameStartCheckListener != null)
      {
        QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onGameCheckFinish startCheckParam:" + paramStartCheckParam);
        localOnGameStartCheckListener.onGameCheckFinish(-1, paramStartCheckParam, null);
      }
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "startGame startCheckParam:", paramStartCheckParam });
    }
    ThreadManager.post(new yve(this, paramStartCheckParam), 5, null, true);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, OnGameStartCheckListener paramOnGameStartCheckListener)
  {
    if ((paramStartCheckParam == null) || (paramOnGameStartCheckListener == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_CmGameStartChecker", 2, "[launchGame],startCheckParam == null || gameStartCheckListener == nul");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "[launchGame], startCheckerParam:", paramStartCheckParam });
      }
      ApolloGameStateMachine.a().a();
      ApolloGameStateMachine.a().a(1);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnGameStartCheckListener);
      if (!paramStartCheckParam.isRunning) {
        break;
      }
      a(paramStartCheckParam);
    } while (!QLog.isColorLevel());
    QLog.d("apollo_cmGame_CmGameStartChecker", 2, "startGame from game resume");
    return;
    b(paramStartCheckParam);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, String paramString)
  {
    Object localObject1 = (AppInterface)this.b.get();
    if ((localObject1 == null) || (paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      return;
    }
    localObject1 = (DownloaderFactory)((AppInterface)localObject1).getManager(46);
    if (localObject1 != null) {}
    for (localObject1 = ((DownloaderFactory)localObject1).a(1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        QLog.e("apollo_cmGame_CmGameStartChecker", 1, "updateGameRes no downloaderInterface");
        return;
      }
      Object localObject2 = DeviceInfoUtil.b();
      if ((localObject2 != null) && (localObject2.length == 2) && (localObject2[1] <= 50L))
      {
        ApolloItemBuilder.a("当前手机存储空间不足,无法启动游戏。", 1, BaseApplicationImpl.getContext());
        QLog.w("apollo_cmGame_CmGameStartChecker", 2, "updateGameRes:available space on SD card is less than 50M. ====> Stop download game rsc.");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(ApolloConstant.n).append(paramStartCheckParam.game.gameId);
      int k;
      if (paramStartCheckParam.isPatch)
      {
        localObject2 = ".patch";
        paramString = new DownloadTask(paramString, new File((String)localObject2));
        paramString.n = false;
        paramString.h = false;
        paramString.l = true;
        paramString.q = false;
        paramString.o = true;
        paramString.p = true;
        paramString.b = true;
        paramString.f = "apollo_res";
        localObject2 = new Bundle();
        ((Bundle)localObject2).putSerializable("download_param", paramStartCheckParam);
        ((DownloaderInterface)localObject1).a(paramString, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
        k = ((Bundle)localObject2).getInt("enter");
        if ((k != 2) && (k != 1)) {
          break label381;
        }
      }
      label381:
      for (int i = 1;; i = 0)
      {
        int j;
        if ((k != 4) && (k != 5))
        {
          j = k;
          if (k != 3) {}
        }
        else
        {
          j = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "game_renew_start", i, j, new String[] { paramStartCheckParam.game.gameId + "" });
        QLog.d("apollo_cmGame_CmGameStartChecker", 1, "updateGameRes gameId:" + paramStartCheckParam.game.gameId);
        return;
        localObject2 = ".zip";
        break;
      }
    }
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      return;
    }
    long l1;
    Object localObject;
    label248:
    String str1;
    long l2;
    int j;
    boolean bool;
    if (paramBoolean)
    {
      int k;
      int m;
      String str2;
      STCheckGame.STCheckGameRsp localSTCheckGameRsp;
      try
      {
        k = paramStartCheckParam.game.gameId;
        m = paramStartCheckParam.gameMode;
        paramBoolean = paramStartCheckParam.isCreator;
        l1 = paramStartCheckParam.roomId;
        str2 = paramStartCheckParam.from;
        i = paramStartCheckParam.enter;
        localObject = paramStartCheckParam.extendJson;
        i = paramStartCheckParam.src;
        l1 = paramStartCheckParam.retCode;
        localSTCheckGameRsp = new STCheckGame.STCheckGameRsp();
        localSTCheckGameRsp.mergeFrom(paramBundle.getByteArray("data"));
        paramBundle = localSTCheckGameRsp.wording.get();
        if (!TextUtils.isEmpty(paramBundle))
        {
          QLog.i("apollo_cmGame_CmGameStartChecker", 1, "failwording:" + paramBundle);
          ApolloItemBuilder.a(paramBundle, 1, BaseApplicationImpl.getContext());
          ApolloGameStateMachine.a().a(5, "fail in get key");
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("apollo_cmGame_CmGameStartChecker", 2, paramBundle, new Object[0]);
        return;
      }
      String str5 = localSTCheckGameRsp.st.get();
      String str6 = localSTCheckGameRsp.stKey.get();
      int n = localSTCheckGameRsp.remainPlays.get();
      int i1 = localSTCheckGameRsp.svrResVer.get();
      String str3 = localSTCheckGameRsp.wordingV2.get();
      if (localSTCheckGameRsp.updateFlag.get() != 1) {
        break label1101;
      }
      i = 1;
      if (localSTCheckGameRsp.isPatch.get() != 1) {
        break label1107;
      }
      paramBoolean = true;
      localObject = localSTCheckGameRsp.patchUrl.get();
      str1 = localSTCheckGameRsp.zipUrl.get();
      String str4 = localSTCheckGameRsp.zipMd5.get();
      l1 = localSTCheckGameRsp.packageSize.get();
      l2 = localSTCheckGameRsp.tipsSize.get();
      if (!localSTCheckGameRsp.appIdSource.has()) {
        break label1082;
      }
      j = localSTCheckGameRsp.appIdSource.get();
      if (localSTCheckGameRsp.ssoCmdRule.has())
      {
        paramBundle = localSTCheckGameRsp.ssoCmdRule.get();
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          OnGameStartCheckListener localOnGameStartCheckListener = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localOnGameStartCheckListener != null)
          {
            QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onSsoCmdRuleRsp startCheckParam:" + paramStartCheckParam);
            localOnGameStartCheckListener.onSsoCmdRuleRsp(paramStartCheckParam, paramBundle);
          }
        }
      }
      for (;;)
      {
        paramBundle = "";
        if (localSTCheckGameRsp.extInfo.has()) {
          paramBundle = new String(localSTCheckGameRsp.extInfo.get().toByteArray());
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "checkGame done gameId: " + k, ", launchLife=" + n + ", from: " + str2 + ", gameMode: " + m + ",extInfo:" + paramBundle });
        }
        paramStartCheckParam.apolloGameSt = str5;
        paramStartCheckParam.apolloGameStkey = str6;
        paramStartCheckParam.openId = localSTCheckGameRsp.openId.get();
        paramStartCheckParam.sessionOpenId = localSTCheckGameRsp.sessionOpenId.get();
        paramStartCheckParam.extInfoFromSvr = paramBundle;
        paramStartCheckParam.appIdSrc = j;
        ApolloManager.b = str5;
        ApolloManager.c = str6;
        paramBundle = (AppInterface)this.b.get();
        if (paramBundle != null) {
          ApolloGameUtil.a(paramBundle, n);
        }
        bool = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getBoolean("apollo_sp_game_rsc_verify_" + k, false);
        if (!bool) {
          break label1088;
        }
        break label1088;
        label652:
        QLog.i("apollo_cmGame_CmGameStartChecker", 1, "verify fail or oldVersion is overtime start download new version, isVerifyFail:" + bool + ",oldV:,newV:" + String.valueOf(i1));
        paramStartCheckParam.startT = -1L;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramBundle = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (paramBundle != null)
          {
            QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onDownloadGameResStart startCheckParam:" + paramStartCheckParam);
            paramBundle.onDownloadGameResStart(paramStartCheckParam);
          }
        }
        if (TextUtils.isEmpty(paramStartCheckParam.from)) {
          paramStartCheckParam.from = "updateRes";
        }
        paramStartCheckParam.isPatch = paramBoolean;
        paramStartCheckParam.zipMD5 = str4;
        paramStartCheckParam.wordingV2 = str3;
        paramBundle = localSTCheckGameRsp.patchContent.get().toByteArray();
        if ((!paramBoolean) || (!localSTCheckGameRsp.patchContent.has()) || (paramBundle.length <= 0)) {
          break;
        }
        ThreadManager.post(new yvf(this, paramStartCheckParam, paramBundle), 5, null, true);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "ssoCmdRule, no ssoCmdRule for game ", Integer.valueOf(k) });
        }
      }
      bool = NetworkUtil.h(BaseApplicationImpl.getApplication().getApplicationContext());
      if (!QLog.isColorLevel()) {
        break label1112;
      }
      QLog.i("apollo_cmGame_CmGameStartChecker", 2, "is wifi:" + bool + ",pkg size:" + l1 + ",tip size:" + l2);
      break label1112;
      label940:
      a(paramStartCheckParam, paramBundle);
      return;
      label947:
      paramBundle = new yvg(this, paramBoolean, (String)localObject, str1, str2);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onDownloadConfirm startCheckParam:" + paramStartCheckParam);
          ((OnGameStartCheckListener)localObject).onDownloadConfirm(paramStartCheckParam, paramBundle, l1);
        }
      }
      if (!"message".equals(str2)) {
        break label1141;
      }
    }
    label1082:
    label1088:
    label1101:
    label1107:
    label1112:
    label1141:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", i, 3, new String[] { String.valueOf(paramStartCheckParam.game.gameId) });
      return;
      do
      {
        d(paramStartCheckParam);
        return;
        e(paramStartCheckParam);
        return;
        j = 0;
        break;
        if (bool) {
          break label652;
        }
      } while (i == 0);
      break label652;
      i = 0;
      break;
      paramBoolean = false;
      break label248;
      if ((!bool) && (l1 >= l2)) {
        break label947;
      }
      if (paramBoolean)
      {
        paramBundle = (Bundle)localObject;
        break label940;
      }
      paramBundle = str1;
      break label940;
    }
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    int j = 0;
    if (paramStartCheckParam != null) {
      for (;;)
      {
        try
        {
          if (paramStartCheckParam.game == null) {
            return;
          }
          AppInterface localAppInterface = (AppInterface)this.b.get();
          if (localAppInterface == null) {
            break label541;
          }
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "checkKey startCheckParam:", paramStartCheckParam });
          }
          localObject = new WebSSOAgent.UniSsoServerReqComm();
          ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
          ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
          WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
          localUniSsoServerReq.comm.set((MessageMicro)localObject);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("cmd", "apollo_aio_game.check_game_v2");
          if (!TextUtils.isEmpty(paramStartCheckParam.from)) {
            break label494;
          }
          localObject = "android";
          localJSONObject.put("from", localObject);
          localJSONObject.put("version", paramStartCheckParam.version);
          localJSONObject.put("gameId", paramStartCheckParam.game.gameId);
          localJSONObject.put("aioType", paramStartCheckParam.sessionType);
          localJSONObject.put("sessionId", paramStartCheckParam.sessionUin);
          localJSONObject.put("src", paramStartCheckParam.src);
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "check game, src:", Integer.valueOf(paramStartCheckParam.src) });
          }
          float f;
          boolean bool;
          String str;
          QLog.e("apollo_cmGame_CmGameStartChecker", 2, "pullApolloGameKey failed ", paramStartCheckParam);
        }
        catch (Exception paramStartCheckParam)
        {
          for (;;)
          {
            try
            {
              f = Float.parseFloat(paramStartCheckParam.version);
              i = (int)f;
            }
            catch (Exception localException2)
            {
              Object localObject;
              int i = 0;
              continue;
            }
            try
            {
              bool = new File(ApolloConstant.n + paramStartCheckParam.game.gameId + ".zip").exists();
              if (bool) {
                continue;
              }
              i = j;
              localJSONObject.put("localResVer", i);
              localObject = (TicketManager)localAppInterface.getManager(2);
              if (localObject != null)
              {
                str = ((TicketManager)localObject).getSkey(localAppInterface.getCurrentAccountUin());
                localObject = str;
                if (TextUtils.isEmpty(str)) {
                  localObject = "";
                }
                localJSONObject.put("skey", localObject);
              }
              localUniSsoServerReq.reqdata.set(localJSONObject.toString());
              localObject = new NewIntent(localAppInterface.getApp(), CmGameServlet.class);
              ((NewIntent)localObject).putExtra("cmd", "apollo_aio_game.check_game_v2");
              ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
              ((NewIntent)localObject).putExtra("serializable", paramStartCheckParam);
              ((NewIntent)localObject).setObserver(this);
              localAppInterface.startServlet((NewIntent)localObject);
              return;
            }
            catch (Exception localException1) {}
          }
          paramStartCheckParam = paramStartCheckParam;
          if (!QLog.isColorLevel()) {
            break label541;
          }
        }
        return;
        label494:
        localObject = "android." + paramStartCheckParam.from;
        continue;
        QLog.e("apollo_cmGame_CmGameStartChecker", 1, "parse res version error:", (Throwable)localObject);
      }
    }
    label541:
  }
  
  public void c(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramStartCheckParam.game == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameStartChecker", 2, new Object[] { "doOnGameResFileDone startCheckParam:", paramStartCheckParam });
    }
    boolean bool = paramStartCheckParam.isCreator;
    long l = paramStartCheckParam.roomId;
    String str1 = paramStartCheckParam.from;
    int i = paramStartCheckParam.gameMode;
    l = paramStartCheckParam.retCode;
    str1 = paramStartCheckParam.wordingV2;
    i = paramStartCheckParam.enter;
    str1 = paramStartCheckParam.extendJson;
    i = paramStartCheckParam.src;
    bool = paramStartCheckParam.isPatch;
    String str2 = paramStartCheckParam.zipMD5;
    str1 = ApolloConstant.n + paramStartCheckParam.game.gameId + ".zip";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    try
    {
      localSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + paramStartCheckParam.game.gameId, false).commit();
      if ((bool) && (!ApolloManager.a(String.valueOf(paramStartCheckParam.game.gameId), str2)))
      {
        e(paramStartCheckParam);
        QLog.e("apollo_cmGame_CmGameStartChecker", 1, "doOnGameResFileDone patchGameRes false!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("apollo_cmGame_CmGameStartChecker", 1, "uncompressZip fail zip file: " + str1, localException);
      localSharedPreferences.edit().putBoolean("apollo_sp_game_rsc_verify_" + paramStartCheckParam.game.gameId, true).commit();
      e(paramStartCheckParam);
      return;
    }
    FileUtils.a(str1, ApolloUtil.a(paramStartCheckParam.game), false);
    ApolloUtil.a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      OnGameStartCheckListener localOnGameStartCheckListener = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localOnGameStartCheckListener != null)
      {
        QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onDownloadGameResDown startCheckParam:" + paramStartCheckParam);
        localOnGameStartCheckListener.onDownloadGameResDown(paramStartCheckParam);
      }
    }
    paramStartCheckParam.mUpdated = true;
    d(paramStartCheckParam);
  }
  
  public void d(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null)
    {
      QLog.e("apollo_cmGame_CmGameStartChecker", 1, "checkLife startCheckParam is null");
      return;
    }
    Object localObject = (AppInterface)this.b.get();
    if (localObject == null)
    {
      QLog.e("apollo_cmGame_CmGameStartChecker", 1, "checkLife app == null");
      return;
    }
    int i = ApolloGameUtil.a((AppInterface)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_CmGameStartChecker", 2, " checkLife  life =" + i);
    }
    if (paramStartCheckParam.retCode == ApolloConstant.a)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          QLog.d("apollo_cmGame_CmGameStartChecker", 2, "gameCheckListener.onGameLifeTipShow startCheckParam:" + paramStartCheckParam);
          ((OnGameStartCheckListener)localObject).onGameLifeTipShow(paramStartCheckParam);
        }
      }
      VipUtils.a(null, "cmshow", "Apollo", "game_times_short", 0, 0, new String[] { "" + paramStartCheckParam.game.gameId });
      return;
    }
    a(paramStartCheckParam);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    try
    {
      paramBundle.getInt("extra_result_code");
      localObject = paramBundle.getString("cmd");
      if ("apollo_aio_game.check_game_v2".equals(localObject))
      {
        localObject = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("serializable");
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        if ((arrayOfByte != null) && (paramBoolean))
        {
          paramBundle = new WebSSOAgent.UniSsoServerRsp();
          paramBundle.mergeFrom(arrayOfByte);
          Bundle localBundle = new Bundle();
          localBundle.putLong("retCode", paramBundle.ret.get());
          ((CmGameStartChecker.StartCheckParam)localObject).retCode = paramBundle.ret.get();
          localBundle.putByteArray("data", paramBundle.pbRsqData.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_CmGameStartChecker", 2, "[handleApolloGameKey],data:" + arrayOfByte);
          }
          a(true, localBundle, (CmGameStartChecker.StartCheckParam)localObject);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("apollo_cmGame_CmGameStartChecker", 2, "ret:" + paramBundle.ret.get());
          return;
        }
        QLog.e("apollo_cmGame_CmGameStartChecker", 2, "resp data is err.");
        a(false, paramBundle, (CmGameStartChecker.StartCheckParam)localObject);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("apollo_cmGame_CmGameStartChecker", 2, "errInfo->" + paramBundle.getMessage());
      return;
    }
    QLog.e("apollo_cmGame_CmGameStartChecker", 1, new Object[] { "CmGameServlet onReceive cmd !VasExtensionHandler.APOLLO_CHECK_GAME", localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker
 * JD-Core Version:    0.7.0.1
 */