package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.download.CmGameRscDownloader;
import com.tencent.mobileqq.apollo.game.process.download.CmGameRscSvrInfo;
import com.tencent.mobileqq.apollo.game.process.download.ICmGameRscDownloadListener;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.apollo.STCheckGame.STCheckGameRsp;
import com.tencent.pb.apollo.STCheckGame.STGameConfInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.observer.BusinessObserver;

public class CmGameStartChecker
  implements ICmGameRscDownloadListener, BusinessObserver
{
  public static String a;
  public static String b;
  public long c;
  public long d;
  public long e;
  private WeakReference<OnGameStartCheckListener> f;
  private WeakReference<AppInterface> g;
  private StartCheckParam h;
  private volatile int i = 0;
  
  public CmGameStartChecker(AppInterface paramAppInterface)
  {
    this.g = new WeakReference(paramAppInterface);
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(",startCheckParam:");
        localStringBuilder.append(this.h);
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameCheckFail:", Long.valueOf(paramLong), localStringBuilder.toString() });
        ((OnGameStartCheckListener)localObject).a(paramLong, this.h, null);
      }
    }
  }
  
  private void b(long paramLong)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(",startCheckParam:");
        localStringBuilder.append(this.h);
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameFail:", Long.valueOf(paramLong), localStringBuilder.toString() });
        ((OnGameStartCheckListener)localObject).a(this.h, paramLong);
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    this.i += 1;
    if (this.i == 1)
    {
      ((OnGameStartCheckListener)localObject).a(1);
      a(1);
      return;
    }
    if (ProcessUtil.a())
    {
      a(-17L);
      return;
    }
    ((OnGameStartCheckListener)localObject).a(2);
  }
  
  public String a(int paramInt, String paramString)
  {
    paramString = this.h;
    if (paramString == null) {
      return "";
    }
    return ApolloGameTool.b(paramString.gameId);
  }
  
  public void a()
  {
    if (this.h == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "startGame startCheckParam:", this.h });
    }
    ThreadManager.post(new CmGameStartChecker.1(this), 5, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((this.g.get() != null) && (NetworkUtil.isNetSupport(((AppInterface)this.g.get()).getApp())))
    {
      ThreadManagerV2.excute(new CmGameStartChecker.2(this, paramInt), 192, null, true);
      return;
    }
    QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] none network");
    a(-10L);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.h == null) {
      return;
    }
    paramString = this.f;
    if (paramString != null)
    {
      paramString = (OnGameStartCheckListener)paramString.get();
      if (paramString != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onDownloadProgress] progress:");
        localStringBuilder.append(paramInt1);
        QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
        paramString.a(this.h, paramInt1);
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    if (this.h == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.f == null) {
          break label1701;
        }
        localObject1 = (OnGameStartCheckListener)this.f.get();
        int j = this.h.gameId;
        int k = this.h.gameMode;
        Object localObject3 = this.h.from;
        Object localObject2 = new STCheckGame.STCheckGameRsp();
        ((STCheckGame.STCheckGameRsp)localObject2).mergeFrom(paramBundle.getByteArray("data"));
        paramBundle = ((STCheckGame.STCheckGameRsp)localObject2).wording.get();
        this.h.wordingV2 = ((STCheckGame.STCheckGameRsp)localObject2).wordingV2.get();
        bool1 = TextUtils.isEmpty(paramBundle);
        if (!bool1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onGetGameKey failwording:");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.i("cmgame_process.CmGameStartChecker", 1, ((StringBuilder)localObject1).toString());
          this.h.wordingV2 = paramBundle;
          ApolloItemBuilder.a(paramBundle, 1, BaseApplicationImpl.getContext());
          ApolloGameStateMachine.a().a(5, "fail in get key");
          a(this.h.retCode);
          return;
        }
        if (this.h.retCode != 0L)
        {
          QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "onGetGameKey checkGame failed retCode:", Long.valueOf(this.h.retCode) });
          ApolloGameStateMachine.a().a(5, "fail in get key");
          a(this.h.retCode);
          return;
        }
        String str4 = ((STCheckGame.STCheckGameRsp)localObject2).st.get();
        String str5 = ((STCheckGame.STCheckGameRsp)localObject2).stKey.get();
        int m = ((STCheckGame.STCheckGameRsp)localObject2).remainPlays.get();
        int n = ((STCheckGame.STCheckGameRsp)localObject2).svrResVer.get();
        if (((STCheckGame.STCheckGameRsp)localObject2).updateFlag.get() != 1) {
          break label1707;
        }
        bool1 = true;
        if (((STCheckGame.STCheckGameRsp)localObject2).isPatch.get() != 1) {
          break label1713;
        }
        bool2 = true;
        String str1 = ((STCheckGame.STCheckGameRsp)localObject2).patchUrl.get();
        String str2 = ((STCheckGame.STCheckGameRsp)localObject2).zipUrl.get();
        String str3 = ((STCheckGame.STCheckGameRsp)localObject2).zipMd5.get();
        long l1 = ((STCheckGame.STCheckGameRsp)localObject2).packageSize.get();
        long l2 = ((STCheckGame.STCheckGameRsp)localObject2).tipsSize.get();
        byte[] arrayOfByte = ((STCheckGame.STCheckGameRsp)localObject2).patchContent.get().toByteArray();
        int i1 = ((STCheckGame.STCheckGameRsp)localObject2).appIdSource.get();
        int i2 = ((STCheckGame.STCheckGameRsp)localObject2).commFlagBits.get();
        this.h.adDevUin = ((STCheckGame.STCheckGameRsp)localObject2).adDevUin.get();
        this.h.adForbidPosId = ((STCheckGame.STCheckGameRsp)localObject2).adForbitPosId.get();
        this.h.adShareRate = ((STCheckGame.STCheckGameRsp)localObject2).adShareRate.get();
        this.h.rpUrl = ((STCheckGame.STCheckGameRsp)localObject2).rpUrl.get();
        this.h.rpIconUrl = ((STCheckGame.STCheckGameRsp)localObject2).rpPic.get();
        paramBundle = ((STCheckGame.STCheckGameRsp)localObject2).ssoCmdRule.get();
        if (localObject1 != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("onGetGameKey gameCheckListener.onSsoCmdRuleRsp startCheckParam:");
          ((StringBuilder)localObject4).append(this.h);
          QLog.d("cmgame_process.CmGameStartChecker", 2, ((StringBuilder)localObject4).toString());
          ((OnGameStartCheckListener)localObject1).a(this.h, paramBundle);
        }
        paramBundle = "";
        if (((STCheckGame.STCheckGameRsp)localObject2).extInfo.has()) {
          paramBundle = new String(((STCheckGame.STCheckGameRsp)localObject2).extInfo.get().toByteArray());
        }
        if (!QLog.isColorLevel()) {
          break label1719;
        }
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("onGetGameKey checkGame done gameId: ");
        ((StringBuilder)localObject4).append(j);
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(", from: ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(", gameMode: ");
        localStringBuilder.append(k);
        localStringBuilder.append(",extInfo:");
        localStringBuilder.append(paramBundle);
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { localObject4, localStringBuilder.toString() });
        boolean bool3 = bool1;
        this.h.apolloGameSt = str4;
        this.h.apolloGameStkey = str5;
        this.h.openId = ((STCheckGame.STCheckGameRsp)localObject2).openId.get();
        this.h.sessionOpenId = ((STCheckGame.STCheckGameRsp)localObject2).sessionOpenId.get();
        this.h.extInfoFromSvr = paramBundle;
        this.h.appIdSrc = i1;
        this.h.commFlag = i2;
        if (((STCheckGame.STCheckGameRsp)localObject2).gameConfInfo.has())
        {
          paramBundle = new STCheckGame.STGameConfInfo();
          paramBundle.mergeFrom(((STCheckGame.STGameConfInfo)((STCheckGame.STCheckGameRsp)localObject2).gameConfInfo.get()).toByteArray());
          localObject3 = new ApolloGameData();
          ((ApolloGameData)localObject3).gameId = paramBundle.game_id.get();
          ((ApolloGameData)localObject3).actionId = paramBundle.action_id.get();
          ((ApolloGameData)localObject3).appId = paramBundle.appid.get();
          ((ApolloGameData)localObject3).developerName = paramBundle.ep_name.get();
          ((ApolloGameData)localObject3).minVer = paramBundle.g_start_ver.get();
          ((ApolloGameData)localObject3).maxVer = paramBundle.g_end_ver.get();
          ((ApolloGameData)localObject3).name = paramBundle.game_name.get();
          ((ApolloGameData)localObject3).hasOwnArk = paramBundle.has_own_ark.get();
          if (paramBundle.isfeatured.get() != 1) {
            break label1722;
          }
          bool1 = true;
          ((ApolloGameData)localObject3).isFeatured = bool1;
          ((ApolloGameData)localObject3).isShow = paramBundle.is_show_onpanel.get();
          ((ApolloGameData)localObject3).listCoverUrl = paramBundle.list_cover_url.get();
          ((ApolloGameData)localObject3).logoUrl = paramBundle.logo_url.get();
          ((ApolloGameData)localObject3).needOpenKey = paramBundle.need_open_key.get();
          ((ApolloGameData)localObject3).officialAccountUin = String.valueOf(paramBundle.puin.get());
          ((ApolloGameData)localObject3).screenMode = paramBundle.screen_mode.get();
          ((ApolloGameData)localObject3).viewMode = paramBundle.view_mode.get();
          if (localObject1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey game_conf_info gameData:", ((ApolloGameData)localObject3).toString() });
            }
            this.h.game = ((ApolloGameData)localObject3);
            this.h.viewMode = ((ApolloGameData)localObject3).viewMode;
            ((OnGameStartCheckListener)localObject1).a(this.h);
          }
        }
        if (this.h.game == null)
        {
          QLog.e("cmgame_process.CmGameStartChecker", 1, "onGetGameKey get game is null");
          a(-11L);
          return;
        }
        if (((STCheckGame.STCheckGameRsp)localObject2).transInfo.has()) {
          this.h.transInfo = new String(((STCheckGame.STCheckGameRsp)localObject2).transInfo.get().toByteArray());
        }
        this.h.delayMs = ((STCheckGame.STCheckGameRsp)localObject2).delayMs.get();
        a = str4;
        b = str5;
        localObject2 = (AppInterface)this.g.get();
        if (localObject2 != null) {
          ApolloGameUtil.a((AppInterface)localObject2, m);
        }
        if (TextUtils.isEmpty(this.h.from)) {
          this.h.from = "updateRes";
        }
        paramBundle = new StringBuilder();
        paramBundle.append("[game_launch_cost], check game:");
        paramBundle.append(System.currentTimeMillis() - this.h.startT);
        QLog.i("cmgame_process.CmGameStartChecker", 1, paramBundle.toString());
        if (bool3) {
          CmGameUtil.b(ApolloGameTool.a(this.h.gameId));
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_gameId", String.valueOf(this.h.gameId));
        if (!bool3) {
          break label1728;
        }
        paramBundle = "1";
        ((HashMap)localObject3).put("param_update", paramBundle);
        if (localObject2 != null) {
          StatisticCollector.getInstance(((AppInterface)localObject2).getApp()).collectPerformance(((AppInterface)localObject2).getCurrentAccountUin(), "cmgame_checkgame_update", true, 0L, 0L, (HashMap)localObject3, "", false);
        }
        QLog.d("CmGameStat", 1, new Object[] { "cmgame_checkgame_update, needUpdate=", Boolean.valueOf(bool3), " [gameId=", Integer.valueOf(this.h.gameId), "]" });
        if (localObject1 != null) {
          ((OnGameStartCheckListener)localObject1).a(this.h.retCode, this.h, null);
        }
        paramBundle = new CmGameRscSvrInfo();
        paramBundle.h = String.valueOf(this.h.gameId);
        paramBundle.d = l2;
        paramBundle.e = l1;
        paramBundle.f = arrayOfByte;
        paramBundle.b = bool2;
        paramBundle.a = bool3;
        paramBundle.j = str3;
        paramBundle.l = str1;
        paramBundle.k = str2;
        paramBundle.g = this.h.gameId;
        paramBundle.c = n;
        paramBundle.m = this.h.enter;
        paramBundle.n = this.h.from;
        paramBundle.o = 0;
        paramBundle.p = System.currentTimeMillis();
        paramBundle.q = this.h.delayMs;
        bool1 = new CmGameRscDownloader(paramBundle, this).b();
        paramBundle = new StringBuilder();
        paramBundle.append("onGetGameKey [cmgame_pack_main], response, gameId:");
        paramBundle.append(this.h.gameId);
        paramBundle.append(",ver:");
        paramBundle.append(n);
        paramBundle.append(",isPatch:");
        paramBundle.append(bool2);
        paramBundle.append(",isUpdate:");
        paramBundle.append(bool3);
        QLog.i("cmgame_process.CmGameStartChecker", 1, paramBundle.toString());
        if (!bool1)
        {
          b();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("cmgame_process.CmGameStartChecker", 2, "onGetGameKey e:", paramBundle);
      }
      return;
      label1701:
      Object localObject1 = null;
      continue;
      label1707:
      boolean bool1 = false;
      continue;
      label1713:
      boolean bool2 = false;
      continue;
      label1719:
      continue;
      label1722:
      bool1 = false;
      continue;
      label1728:
      paramBundle = "0";
    }
  }
  
  public void a(CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if (this.h == null) {
      return;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onDownloadConfirm] startCheckParam:");
        localStringBuilder.append(this.h);
        QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
        ((OnGameStartCheckListener)localObject).a(this.h, paramICmGameConfirmListener, paramLong);
      }
    }
  }
  
  public void a(StartCheckParam paramStartCheckParam, OnGameStartCheckListener paramOnGameStartCheckListener)
  {
    if ((paramStartCheckParam != null) && (paramOnGameStartCheckListener != null))
    {
      this.c = System.currentTimeMillis();
      this.h = paramStartCheckParam;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "[launchGame], startCheckerParam:", paramStartCheckParam });
      }
      ApolloGameStateMachine.a().c();
      ApolloGameStateMachine.a().a(1);
      this.f = new WeakReference(paramOnGameStartCheckListener);
      this.i = 0;
      if (paramStartCheckParam.isRunning)
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameStartChecker", 2, "startGame from game resume");
        }
      }
      else
      {
        a(0);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, "[launchGame],startCheckParam == null || gameStartCheckListener == nul");
    }
  }
  
  public void b()
  {
    if (this.h == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "checkLife startCheckParam is null");
      return;
    }
    Object localObject = (AppInterface)this.g.get();
    if (localObject == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "checkLife app == null");
      return;
    }
    int j = ApolloGameUtil.a((AppInterface)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" checkLife  life =");
      ((StringBuilder)localObject).append(j);
      QLog.d("cmgame_process.CmGameStartChecker", 2, ((StringBuilder)localObject).toString());
    }
    if (this.h.retCode == ApolloConstant.q)
    {
      localObject = this.f;
      if (localObject != null)
      {
        localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gameCheckListener.onGameLifeTipShow startCheckParam:");
          localStringBuilder.append(this.h);
          QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
          ((OnGameStartCheckListener)localObject).b(this.h);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.h.gameId);
      VipUtils.a(null, "cmshow", "Apollo", "game_times_short", 0, 0, new String[] { ((StringBuilder)localObject).toString() });
      return;
    }
    a();
  }
  
  public void b(int paramInt, String paramString)
  {
    paramString = this.h;
    if (paramString == null) {
      return;
    }
    paramString.startT = -1L;
    paramString = this.f;
    if (paramString != null)
    {
      paramString = (OnGameStartCheckListener)paramString.get();
      if (paramString != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gameCheckListener.onDownloadGameResStart startCheckParam:");
        localStringBuilder.append(this.h);
        QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
        paramString.d(this.h);
      }
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    paramString = this.h;
    if (paramString == null) {
      return;
    }
    paramString.mUpdated = true;
    paramString.mGameType = 1;
    paramString.viewMode = ApolloGameUtil.b(paramString.gameId, this.h.mGameType);
    paramString = this.f;
    if (paramString != null)
    {
      paramString = (OnGameStartCheckListener)paramString.get();
      if (paramString != null)
      {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "gameCheckListener.onDownloadGameResDown startCheckParam:", this.h });
        paramString.e(this.h);
      }
    }
    b();
  }
  
  public void d(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("[onDownloadFailure], ret:");
    paramString.append(paramInt);
    QLog.e("cmgame_process.CmGameStartChecker", 1, paramString.toString());
    b(-12L);
  }
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc_w 772
    //   4: invokevirtual 776	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   7: istore_1
    //   8: aload_3
    //   9: ldc_w 778
    //   12: invokevirtual 782	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 13
    //   17: ldc_w 784
    //   20: aload 13
    //   22: invokevirtual 788	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: istore 8
    //   27: iload 8
    //   29: ifeq +186 -> 215
    //   32: aload_3
    //   33: ldc_w 790
    //   36: invokevirtual 782	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokestatic 793	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   42: istore 4
    //   44: iload_1
    //   45: istore 5
    //   47: aload_0
    //   48: invokestatic 556	java/lang/System:currentTimeMillis	()J
    //   51: putfield 794	com/tencent/mobileqq/apollo/game/CmGameStartChecker:e	J
    //   54: aload_3
    //   55: ldc 192
    //   57: invokevirtual 198	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   60: astore 13
    //   62: aload 13
    //   64: ifnull +98 -> 162
    //   67: iload_2
    //   68: ifeq +94 -> 162
    //   71: new 796	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   74: dup
    //   75: invokespecial 797	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   78: astore_3
    //   79: aload_3
    //   80: aload 13
    //   82: invokevirtual 798	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: pop
    //   86: new 194	android/os/Bundle
    //   89: dup
    //   90: invokespecial 799	android/os/Bundle:<init>	()V
    //   93: astore 13
    //   95: aload 13
    //   97: ldc_w 800
    //   100: aload_3
    //   101: getfield 804	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   104: invokevirtual 807	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   107: invokevirtual 811	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   110: aload_0
    //   111: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   114: aload_3
    //   115: getfield 804	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   118: invokevirtual 807	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   121: putfield 248	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   124: aload 13
    //   126: ldc 192
    //   128: aload_3
    //   129: getfield 814	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:pbRsqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   132: invokevirtual 304	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   135: invokevirtual 310	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   138: invokevirtual 818	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   141: new 820	com/tencent/mobileqq/apollo/game/CmGameStartChecker$3
    //   144: dup
    //   145: aload_0
    //   146: aload 13
    //   148: invokespecial 823	com/tencent/mobileqq/apollo/game/CmGameStartChecker$3:<init>	(Lcom/tencent/mobileqq/apollo/game/CmGameStartChecker;Landroid/os/Bundle;)V
    //   151: sipush 128
    //   154: aconst_null
    //   155: iconst_1
    //   156: invokestatic 824	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   159: goto +80 -> 239
    //   162: ldc 65
    //   164: iconst_1
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: ldc_w 826
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: iload 5
    //   179: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   186: aload_0
    //   187: invokespecial 827	com/tencent/mobileqq/apollo/game/CmGameStartChecker:c	()V
    //   190: goto +49 -> 239
    //   193: astore_3
    //   194: iload 5
    //   196: istore_1
    //   197: goto +769 -> 966
    //   200: astore_3
    //   201: iload 5
    //   203: istore_1
    //   204: goto +394 -> 598
    //   207: astore_3
    //   208: goto +378 -> 586
    //   211: astore_3
    //   212: goto +383 -> 595
    //   215: ldc 65
    //   217: iconst_1
    //   218: iconst_2
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: ldc_w 829
    //   227: aastore
    //   228: dup
    //   229: iconst_1
    //   230: aload 13
    //   232: aastore
    //   233: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   236: iconst_0
    //   237: istore 4
    //   239: aload_0
    //   240: getfield 38	com/tencent/mobileqq/apollo/game/CmGameStartChecker:g	Ljava/lang/ref/WeakReference;
    //   243: invokevirtual 49	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   246: checkcast 140	com/tencent/common/app/AppInterface
    //   249: astore_3
    //   250: aload_3
    //   251: ifnull +713 -> 964
    //   254: aload_0
    //   255: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   258: astore 13
    //   260: aload 13
    //   262: ifnull +702 -> 964
    //   265: iload_1
    //   266: sipush 1000
    //   269: if_icmpne +13 -> 282
    //   272: aload 13
    //   274: getfield 248	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   277: lstore 9
    //   279: goto +7 -> 286
    //   282: iload_1
    //   283: i2l
    //   284: lstore 9
    //   286: aload_0
    //   287: getfield 794	com/tencent/mobileqq/apollo/game/CmGameStartChecker:e	J
    //   290: aload_0
    //   291: getfield 830	com/tencent/mobileqq/apollo/game/CmGameStartChecker:d	J
    //   294: lsub
    //   295: lstore 11
    //   297: aconst_null
    //   298: invokestatic 835	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   301: istore 6
    //   303: new 571	java/util/HashMap
    //   306: dup
    //   307: invokespecial 572	java/util/HashMap:<init>	()V
    //   310: astore 13
    //   312: aload 13
    //   314: ldc_w 837
    //   317: lload 9
    //   319: invokestatic 498	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   322: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: aload 13
    //   328: ldc_w 574
    //   331: aload_0
    //   332: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   335: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   338: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   341: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   344: pop
    //   345: aload 13
    //   347: ldc_w 839
    //   350: iload 6
    //   352: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   355: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: aload_3
    //   360: invokevirtual 144	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   363: invokestatic 590	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   366: astore 14
    //   368: aload_3
    //   369: invokevirtual 593	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   372: astore_3
    //   373: lload 9
    //   375: lconst_0
    //   376: lcmp
    //   377: ifne +8 -> 385
    //   380: iconst_1
    //   381: istore_2
    //   382: goto +5 -> 387
    //   385: iconst_0
    //   386: istore_2
    //   387: aload 14
    //   389: aload_3
    //   390: ldc_w 841
    //   393: iload_2
    //   394: lload 11
    //   396: lconst_0
    //   397: aload 13
    //   399: ldc 110
    //   401: iconst_0
    //   402: invokevirtual 599	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   405: lload 9
    //   407: lconst_0
    //   408: lcmp
    //   409: ifne +8 -> 417
    //   412: iconst_0
    //   413: istore_1
    //   414: goto +5 -> 419
    //   417: iconst_1
    //   418: istore_1
    //   419: aload_0
    //   420: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   423: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   426: istore 7
    //   428: iload 4
    //   430: iconst_2
    //   431: if_icmpne +14 -> 445
    //   434: aload_0
    //   435: getfield 31	com/tencent/mobileqq/apollo/game/CmGameStartChecker:i	I
    //   438: iconst_2
    //   439: isub
    //   440: istore 5
    //   442: goto +6 -> 448
    //   445: iconst_0
    //   446: istore 5
    //   448: aconst_null
    //   449: ldc_w 735
    //   452: ldc_w 737
    //   455: ldc_w 843
    //   458: iload 4
    //   460: iload_1
    //   461: iconst_2
    //   462: anewarray 363	java/lang/String
    //   465: dup
    //   466: iconst_0
    //   467: iload 7
    //   469: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   472: aastore
    //   473: dup
    //   474: iconst_1
    //   475: iload 5
    //   477: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   480: aastore
    //   481: invokestatic 744	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   484: ldc_w 601
    //   487: iconst_1
    //   488: bipush 9
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: ldc_w 845
    //   498: aastore
    //   499: dup
    //   500: iconst_1
    //   501: lload 11
    //   503: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   506: aastore
    //   507: dup
    //   508: iconst_2
    //   509: ldc_w 610
    //   512: aastore
    //   513: dup
    //   514: iconst_3
    //   515: aload_0
    //   516: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   519: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   522: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: dup
    //   527: iconst_4
    //   528: ldc_w 847
    //   531: aastore
    //   532: dup
    //   533: iconst_5
    //   534: lload 9
    //   536: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   539: aastore
    //   540: dup
    //   541: bipush 6
    //   543: ldc_w 849
    //   546: aastore
    //   547: dup
    //   548: bipush 7
    //   550: iload 6
    //   552: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: aastore
    //   556: dup
    //   557: bipush 8
    //   559: ldc_w 617
    //   562: aastore
    //   563: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   566: return
    //   567: astore_3
    //   568: goto -360 -> 208
    //   571: astore_3
    //   572: goto -360 -> 212
    //   575: astore_3
    //   576: goto +10 -> 586
    //   579: astore_3
    //   580: goto +15 -> 595
    //   583: astore_3
    //   584: iconst_0
    //   585: istore_1
    //   586: iconst_0
    //   587: istore 4
    //   589: goto +377 -> 966
    //   592: astore_3
    //   593: iconst_0
    //   594: istore_1
    //   595: iconst_0
    //   596: istore 4
    //   598: new 53	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   605: astore 13
    //   607: aload 13
    //   609: ldc_w 851
    //   612: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 13
    //   618: aload_3
    //   619: invokevirtual 854	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   622: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: ldc 65
    //   628: iconst_1
    //   629: aload 13
    //   631: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 165	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload_0
    //   638: getfield 38	com/tencent/mobileqq/apollo/game/CmGameStartChecker:g	Ljava/lang/ref/WeakReference;
    //   641: invokevirtual 49	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   644: checkcast 140	com/tencent/common/app/AppInterface
    //   647: astore_3
    //   648: aload_3
    //   649: ifnull +315 -> 964
    //   652: aload_0
    //   653: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   656: astore 13
    //   658: aload 13
    //   660: ifnull +304 -> 964
    //   663: iload_1
    //   664: sipush 1000
    //   667: if_icmpne +13 -> 680
    //   670: aload 13
    //   672: getfield 248	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   675: lstore 9
    //   677: goto +7 -> 684
    //   680: iload_1
    //   681: i2l
    //   682: lstore 9
    //   684: aload_0
    //   685: getfield 794	com/tencent/mobileqq/apollo/game/CmGameStartChecker:e	J
    //   688: aload_0
    //   689: getfield 830	com/tencent/mobileqq/apollo/game/CmGameStartChecker:d	J
    //   692: lsub
    //   693: lstore 11
    //   695: aconst_null
    //   696: invokestatic 835	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   699: istore 6
    //   701: new 571	java/util/HashMap
    //   704: dup
    //   705: invokespecial 572	java/util/HashMap:<init>	()V
    //   708: astore 13
    //   710: aload 13
    //   712: ldc_w 837
    //   715: lload 9
    //   717: invokestatic 498	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   720: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   723: pop
    //   724: aload 13
    //   726: ldc_w 574
    //   729: aload_0
    //   730: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   733: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   736: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   739: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   742: pop
    //   743: aload 13
    //   745: ldc_w 839
    //   748: iload 6
    //   750: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   753: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   756: pop
    //   757: aload_3
    //   758: invokevirtual 144	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   761: invokestatic 590	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   764: astore 14
    //   766: aload_3
    //   767: invokevirtual 593	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   770: astore_3
    //   771: lload 9
    //   773: lconst_0
    //   774: lcmp
    //   775: ifne +8 -> 783
    //   778: iconst_1
    //   779: istore_2
    //   780: goto +5 -> 785
    //   783: iconst_0
    //   784: istore_2
    //   785: aload 14
    //   787: aload_3
    //   788: ldc_w 841
    //   791: iload_2
    //   792: lload 11
    //   794: lconst_0
    //   795: aload 13
    //   797: ldc 110
    //   799: iconst_0
    //   800: invokevirtual 599	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   803: lload 9
    //   805: lconst_0
    //   806: lcmp
    //   807: ifne +8 -> 815
    //   810: iconst_0
    //   811: istore_1
    //   812: goto +5 -> 817
    //   815: iconst_1
    //   816: istore_1
    //   817: aload_0
    //   818: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   821: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   824: istore 7
    //   826: iload 4
    //   828: iconst_2
    //   829: if_icmpne +14 -> 843
    //   832: aload_0
    //   833: getfield 31	com/tencent/mobileqq/apollo/game/CmGameStartChecker:i	I
    //   836: iconst_2
    //   837: isub
    //   838: istore 5
    //   840: goto +6 -> 846
    //   843: iconst_0
    //   844: istore 5
    //   846: aconst_null
    //   847: ldc_w 735
    //   850: ldc_w 737
    //   853: ldc_w 843
    //   856: iload 4
    //   858: iload_1
    //   859: iconst_2
    //   860: anewarray 363	java/lang/String
    //   863: dup
    //   864: iconst_0
    //   865: iload 7
    //   867: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   870: aastore
    //   871: dup
    //   872: iconst_1
    //   873: iload 5
    //   875: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   878: aastore
    //   879: invokestatic 744	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   882: ldc_w 601
    //   885: iconst_1
    //   886: bipush 9
    //   888: anewarray 4	java/lang/Object
    //   891: dup
    //   892: iconst_0
    //   893: ldc_w 845
    //   896: aastore
    //   897: dup
    //   898: iconst_1
    //   899: lload 11
    //   901: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   904: aastore
    //   905: dup
    //   906: iconst_2
    //   907: ldc_w 610
    //   910: aastore
    //   911: dup
    //   912: iconst_3
    //   913: aload_0
    //   914: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   917: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   920: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   923: aastore
    //   924: dup
    //   925: iconst_4
    //   926: ldc_w 847
    //   929: aastore
    //   930: dup
    //   931: iconst_5
    //   932: lload 9
    //   934: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   937: aastore
    //   938: dup
    //   939: bipush 6
    //   941: ldc_w 849
    //   944: aastore
    //   945: dup
    //   946: bipush 7
    //   948: iload 6
    //   950: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   953: aastore
    //   954: dup
    //   955: bipush 8
    //   957: ldc_w 617
    //   960: aastore
    //   961: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   964: return
    //   965: astore_3
    //   966: aload_0
    //   967: getfield 38	com/tencent/mobileqq/apollo/game/CmGameStartChecker:g	Ljava/lang/ref/WeakReference;
    //   970: invokevirtual 49	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   973: checkcast 140	com/tencent/common/app/AppInterface
    //   976: astore 13
    //   978: aload 13
    //   980: ifnull +319 -> 1299
    //   983: aload_0
    //   984: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   987: astore 14
    //   989: aload 14
    //   991: ifnull +308 -> 1299
    //   994: iload_1
    //   995: sipush 1000
    //   998: if_icmpne +13 -> 1011
    //   1001: aload 14
    //   1003: getfield 248	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   1006: lstore 9
    //   1008: goto +7 -> 1015
    //   1011: iload_1
    //   1012: i2l
    //   1013: lstore 9
    //   1015: aload_0
    //   1016: getfield 794	com/tencent/mobileqq/apollo/game/CmGameStartChecker:e	J
    //   1019: aload_0
    //   1020: getfield 830	com/tencent/mobileqq/apollo/game/CmGameStartChecker:d	J
    //   1023: lsub
    //   1024: lstore 11
    //   1026: aconst_null
    //   1027: invokestatic 835	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   1030: istore 6
    //   1032: new 571	java/util/HashMap
    //   1035: dup
    //   1036: invokespecial 572	java/util/HashMap:<init>	()V
    //   1039: astore 14
    //   1041: aload 14
    //   1043: ldc_w 837
    //   1046: lload 9
    //   1048: invokestatic 498	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1051: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1054: pop
    //   1055: aload 14
    //   1057: ldc_w 574
    //   1060: aload_0
    //   1061: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   1064: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   1067: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1070: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1073: pop
    //   1074: aload 14
    //   1076: ldc_w 839
    //   1079: iload 6
    //   1081: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1084: invokevirtual 580	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1087: pop
    //   1088: aload 13
    //   1090: invokevirtual 144	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1093: invokestatic 590	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1096: astore 15
    //   1098: aload 13
    //   1100: invokevirtual 593	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1103: astore 13
    //   1105: lload 9
    //   1107: lconst_0
    //   1108: lcmp
    //   1109: ifne +8 -> 1117
    //   1112: iconst_1
    //   1113: istore_2
    //   1114: goto +5 -> 1119
    //   1117: iconst_0
    //   1118: istore_2
    //   1119: aload 15
    //   1121: aload 13
    //   1123: ldc_w 841
    //   1126: iload_2
    //   1127: lload 11
    //   1129: lconst_0
    //   1130: aload 14
    //   1132: ldc 110
    //   1134: iconst_0
    //   1135: invokevirtual 599	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1138: lload 9
    //   1140: lconst_0
    //   1141: lcmp
    //   1142: ifne +8 -> 1150
    //   1145: iconst_0
    //   1146: istore_1
    //   1147: goto +5 -> 1152
    //   1150: iconst_1
    //   1151: istore_1
    //   1152: aload_0
    //   1153: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   1156: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   1159: istore 7
    //   1161: iload 4
    //   1163: iconst_2
    //   1164: if_icmpne +14 -> 1178
    //   1167: aload_0
    //   1168: getfield 31	com/tencent/mobileqq/apollo/game/CmGameStartChecker:i	I
    //   1171: iconst_2
    //   1172: isub
    //   1173: istore 5
    //   1175: goto +6 -> 1181
    //   1178: iconst_0
    //   1179: istore 5
    //   1181: aconst_null
    //   1182: ldc_w 735
    //   1185: ldc_w 737
    //   1188: ldc_w 843
    //   1191: iload 4
    //   1193: iload_1
    //   1194: iconst_2
    //   1195: anewarray 363	java/lang/String
    //   1198: dup
    //   1199: iconst_0
    //   1200: iload 7
    //   1202: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1205: aastore
    //   1206: dup
    //   1207: iconst_1
    //   1208: iload 5
    //   1210: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1213: aastore
    //   1214: invokestatic 744	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1217: ldc_w 601
    //   1220: iconst_1
    //   1221: bipush 9
    //   1223: anewarray 4	java/lang/Object
    //   1226: dup
    //   1227: iconst_0
    //   1228: ldc_w 845
    //   1231: aastore
    //   1232: dup
    //   1233: iconst_1
    //   1234: lload 11
    //   1236: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1239: aastore
    //   1240: dup
    //   1241: iconst_2
    //   1242: ldc_w 610
    //   1245: aastore
    //   1246: dup
    //   1247: iconst_3
    //   1248: aload_0
    //   1249: getfield 42	com/tencent/mobileqq/apollo/game/CmGameStartChecker:h	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   1252: getfield 115	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   1255: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1258: aastore
    //   1259: dup
    //   1260: iconst_4
    //   1261: ldc_w 847
    //   1264: aastore
    //   1265: dup
    //   1266: iconst_5
    //   1267: lload 9
    //   1269: invokestatic 73	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1272: aastore
    //   1273: dup
    //   1274: bipush 6
    //   1276: ldc_w 849
    //   1279: aastore
    //   1280: dup
    //   1281: bipush 7
    //   1283: iload 6
    //   1285: invokestatic 615	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1288: aastore
    //   1289: dup
    //   1290: bipush 8
    //   1292: ldc_w 617
    //   1295: aastore
    //   1296: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1299: goto +5 -> 1304
    //   1302: aload_3
    //   1303: athrow
    //   1304: goto -2 -> 1302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1307	0	this	CmGameStartChecker
    //   0	1307	1	paramInt	int
    //   0	1307	2	paramBoolean	boolean
    //   0	1307	3	paramBundle	Bundle
    //   42	1150	4	j	int
    //   45	1164	5	k	int
    //   301	983	6	m	int
    //   426	775	7	n	int
    //   25	3	8	bool	boolean
    //   277	991	9	l1	long
    //   295	940	11	l2	long
    //   15	1107	13	localObject1	Object
    //   366	765	14	localObject2	Object
    //   1096	24	15	localStatisticCollector	StatisticCollector
    // Exception table:
    //   from	to	target	type
    //   47	62	193	finally
    //   71	159	193	finally
    //   162	190	193	finally
    //   47	62	200	java/lang/Exception
    //   71	159	200	java/lang/Exception
    //   162	190	200	java/lang/Exception
    //   32	44	207	finally
    //   32	44	211	java/lang/Exception
    //   215	236	567	finally
    //   215	236	571	java/lang/Exception
    //   8	27	575	finally
    //   8	27	579	java/lang/Exception
    //   0	8	583	finally
    //   0	8	592	java/lang/Exception
    //   598	637	965	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameStartChecker
 * JD-Core Version:    0.7.0.1
 */