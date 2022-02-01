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
import com.tencent.mobileqq.apollo.game.utils.ApolloGameRscVerify;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
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
  private volatile int jdField_a_of_type_Int = 0;
  public long a;
  private CmGameRscDownloader jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscDownloader;
  private StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
  private WeakReference<OnGameStartCheckListener> jdField_a_of_type_JavaLangRefWeakReference;
  public long b;
  private WeakReference<AppInterface> b;
  public long c;
  
  public CmGameStartChecker(AppInterface paramAppInterface)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(",startCheckParam:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameCheckFail:", Long.valueOf(paramLong), localStringBuilder.toString() });
        ((OnGameStartCheckListener)localObject).a(paramLong, this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam, null);
      }
    }
  }
  
  private void b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(",startCheckParam:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameFail:", Long.valueOf(paramLong), localStringBuilder.toString() });
        ((OnGameStartCheckListener)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam, paramLong);
      }
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      if (CmGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam))
      {
        b();
        return;
      }
      localObject = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int == 1)
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
  }
  
  public String a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    if (paramString == null) {
      return "";
    }
    return ApolloUtilImpl.getApolloGameResPath(paramString.gameId);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "startGame startCheckParam:", this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam });
    }
    ThreadManager.post(new CmGameStartChecker.1(this), 5, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((NetworkUtil.isNetSupport(((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getApp())) || (CmGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam))))
    {
      ThreadManagerV2.excute(new CmGameStartChecker.2(this, paramInt), 192, null, true);
      return;
    }
    QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] none network");
    a(-10L);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam == null) {
      return;
    }
    paramString = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramString != null)
    {
      paramString = (OnGameStartCheckListener)paramString.get();
      if (paramString != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onDownloadProgress] progress:");
        localStringBuilder.append(paramInt1);
        QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
        paramString.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam, paramInt1);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    if (paramString == null) {
      return;
    }
    paramString.startT = -1L;
    paramString = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramString != null)
    {
      paramString = (OnGameStartCheckListener)paramString.get();
      if (paramString != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gameCheckListener.onDownloadGameResStart startCheckParam:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
        QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
        paramString.d(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label1927;
        }
        localObject1 = (OnGameStartCheckListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        int k = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId;
        int m = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameMode;
        Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.from;
        Object localObject3 = new STCheckGame.STCheckGameRsp();
        ((STCheckGame.STCheckGameRsp)localObject3).mergeFrom(paramBundle.getByteArray("data"));
        paramBundle = ((STCheckGame.STCheckGameRsp)localObject3).wording.get();
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.wordingV2 = ((STCheckGame.STCheckGameRsp)localObject3).wordingV2.get();
        bool1 = TextUtils.isEmpty(paramBundle);
        if (!bool1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onGetGameKey failwording:");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.i("cmgame_process.CmGameStartChecker", 1, ((StringBuilder)localObject1).toString());
          this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.wordingV2 = paramBundle;
          ApolloItemBuilder.a(paramBundle, 1, BaseApplicationImpl.getContext());
          ApolloGameStateMachine.a().a(5, "fail in get key");
          a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.retCode);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.retCode != 0L)
        {
          QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "onGetGameKey checkGame failed retCode:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.retCode) });
          ApolloGameStateMachine.a().a(5, "fail in get key");
          a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.retCode);
          return;
        }
        String str4 = ((STCheckGame.STCheckGameRsp)localObject3).st.get();
        String str5 = ((STCheckGame.STCheckGameRsp)localObject3).stKey.get();
        int n = ((STCheckGame.STCheckGameRsp)localObject3).remainPlays.get();
        int i1 = ((STCheckGame.STCheckGameRsp)localObject3).svrResVer.get();
        if (((STCheckGame.STCheckGameRsp)localObject3).updateFlag.get() != 1) {
          break label1933;
        }
        bool1 = true;
        if (((STCheckGame.STCheckGameRsp)localObject3).isPatch.get() != 1) {
          break label1939;
        }
        bool2 = true;
        String str1 = ((STCheckGame.STCheckGameRsp)localObject3).patchUrl.get();
        String str2 = ((STCheckGame.STCheckGameRsp)localObject3).zipUrl.get();
        String str3 = ((STCheckGame.STCheckGameRsp)localObject3).zipMd5.get();
        long l1 = ((STCheckGame.STCheckGameRsp)localObject3).packageSize.get();
        long l2 = ((STCheckGame.STCheckGameRsp)localObject3).tipsSize.get();
        if (!((STCheckGame.STCheckGameRsp)localObject3).patchContent.has()) {
          break label1945;
        }
        paramBundle = ((STCheckGame.STCheckGameRsp)localObject3).patchContent.get().toByteArray();
        if (!((STCheckGame.STCheckGameRsp)localObject3).appIdSource.has()) {
          break label1950;
        }
        i = ((STCheckGame.STCheckGameRsp)localObject3).appIdSource.get();
        if (!((STCheckGame.STCheckGameRsp)localObject3).commFlagBits.has()) {
          break label1955;
        }
        j = ((STCheckGame.STCheckGameRsp)localObject3).commFlagBits.get();
        if (!((STCheckGame.STCheckGameRsp)localObject3).adDevUin.has()) {
          break label1960;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.adDevUin = ((STCheckGame.STCheckGameRsp)localObject3).adDevUin.get();
        if (((STCheckGame.STCheckGameRsp)localObject3).adForbitPosId.has()) {
          this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.adForbidPosId = ((STCheckGame.STCheckGameRsp)localObject3).adForbitPosId.get();
        }
        if (((STCheckGame.STCheckGameRsp)localObject3).adShareRate.has()) {
          this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.adShareRate = ((STCheckGame.STCheckGameRsp)localObject3).adShareRate.get();
        }
        if (((STCheckGame.STCheckGameRsp)localObject3).rpUrl.has()) {
          this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.rpUrl = ((STCheckGame.STCheckGameRsp)localObject3).rpUrl.get();
        }
        if (((STCheckGame.STCheckGameRsp)localObject3).rpPic.has()) {
          this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.rpIconUrl = ((STCheckGame.STCheckGameRsp)localObject3).rpPic.get();
        }
        if (((STCheckGame.STCheckGameRsp)localObject3).ssoCmdRule.has())
        {
          localObject2 = ((STCheckGame.STCheckGameRsp)localObject3).ssoCmdRule.get();
          if (localObject1 != null)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("onGetGameKey gameCheckListener.onSsoCmdRuleRsp startCheckParam:");
            ((StringBuilder)localObject5).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
            QLog.d("cmgame_process.CmGameStartChecker", 2, ((StringBuilder)localObject5).toString());
            ((OnGameStartCheckListener)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam, (String)localObject2);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey ssoCmdRule, no ssoCmdRule for game ", Integer.valueOf(k) });
        }
        localObject2 = "";
        if (((STCheckGame.STCheckGameRsp)localObject3).extInfo.has()) {
          localObject2 = new String(((STCheckGame.STCheckGameRsp)localObject3).extInfo.get().toByteArray());
        }
        if (!QLog.isColorLevel()) {
          break label1963;
        }
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("onGetGameKey checkGame done gameId: ");
        ((StringBuilder)localObject5).append(k);
        localObject5 = ((StringBuilder)localObject5).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(", from: ");
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(", gameMode: ");
        localStringBuilder.append(m);
        localStringBuilder.append(",extInfo:");
        localStringBuilder.append((String)localObject2);
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { localObject5, localStringBuilder.toString() });
        boolean bool3 = bool1;
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.apolloGameSt = str4;
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.apolloGameStkey = str5;
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.openId = ((STCheckGame.STCheckGameRsp)localObject3).openId.get();
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.sessionOpenId = ((STCheckGame.STCheckGameRsp)localObject3).sessionOpenId.get();
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.extInfoFromSvr = ((String)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.appIdSrc = i;
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.commFlag = j;
        if (((STCheckGame.STCheckGameRsp)localObject3).gameConfInfo.has())
        {
          localObject2 = new STCheckGame.STGameConfInfo();
          ((STCheckGame.STGameConfInfo)localObject2).mergeFrom(((STCheckGame.STGameConfInfo)((STCheckGame.STCheckGameRsp)localObject3).gameConfInfo.get()).toByteArray());
          localObject4 = new ApolloGameData();
          ((ApolloGameData)localObject4).gameId = ((STCheckGame.STGameConfInfo)localObject2).game_id.get();
          ((ApolloGameData)localObject4).actionId = ((STCheckGame.STGameConfInfo)localObject2).action_id.get();
          ((ApolloGameData)localObject4).appId = ((STCheckGame.STGameConfInfo)localObject2).appid.get();
          ((ApolloGameData)localObject4).developerName = ((STCheckGame.STGameConfInfo)localObject2).ep_name.get();
          ((ApolloGameData)localObject4).minVer = ((STCheckGame.STGameConfInfo)localObject2).g_start_ver.get();
          ((ApolloGameData)localObject4).maxVer = ((STCheckGame.STGameConfInfo)localObject2).g_end_ver.get();
          ((ApolloGameData)localObject4).name = ((STCheckGame.STGameConfInfo)localObject2).game_name.get();
          ((ApolloGameData)localObject4).hasOwnArk = ((STCheckGame.STGameConfInfo)localObject2).has_own_ark.get();
          if (((STCheckGame.STGameConfInfo)localObject2).isfeatured.get() != 1) {
            break label1966;
          }
          bool1 = true;
          ((ApolloGameData)localObject4).isFeatured = bool1;
          ((ApolloGameData)localObject4).isShow = ((STCheckGame.STGameConfInfo)localObject2).is_show_onpanel.get();
          ((ApolloGameData)localObject4).listCoverUrl = ((STCheckGame.STGameConfInfo)localObject2).list_cover_url.get();
          ((ApolloGameData)localObject4).logoUrl = ((STCheckGame.STGameConfInfo)localObject2).logo_url.get();
          ((ApolloGameData)localObject4).needOpenKey = ((STCheckGame.STGameConfInfo)localObject2).need_open_key.get();
          ((ApolloGameData)localObject4).officialAccountUin = String.valueOf(((STCheckGame.STGameConfInfo)localObject2).puin.get());
          ((ApolloGameData)localObject4).screenMode = ((STCheckGame.STGameConfInfo)localObject2).screen_mode.get();
          ((ApolloGameData)localObject4).viewMode = ((STCheckGame.STGameConfInfo)localObject2).view_mode.get();
          if (localObject1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey game_conf_info gameData:", ((ApolloGameData)localObject4).toString() });
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game = ((ApolloGameData)localObject4);
            this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.viewMode = ((ApolloGameData)localObject4).viewMode;
            ((OnGameStartCheckListener)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game == null)
        {
          QLog.e("cmgame_process.CmGameStartChecker", 1, "onGetGameKey get game is null");
          a(-11L);
          return;
        }
        if (((STCheckGame.STCheckGameRsp)localObject3).transInfo.has()) {
          this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.transInfo = new String(((STCheckGame.STCheckGameRsp)localObject3).transInfo.get().toByteArray());
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.delayMs = ((STCheckGame.STCheckGameRsp)localObject3).delayMs.get();
        com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.sApolloGameSt = str4;
        com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.sApolloGameStkey = str5;
        localObject3 = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (localObject3 != null) {
          ApolloGameUtil.a((AppInterface)localObject3, n);
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.from)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.from = "updateRes";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[game_launch_cost], check game:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.startT);
        QLog.i("cmgame_process.CmGameStartChecker", 1, ((StringBuilder)localObject2).toString());
        if (bool3) {
          CmGameUtil.a(ApolloUtilImpl.getApolloGameLuaPath(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId));
        }
        localObject4 = new HashMap();
        ((HashMap)localObject4).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId));
        if (!bool3) {
          break label1972;
        }
        localObject2 = "1";
        ((HashMap)localObject4).put("param_update", localObject2);
        if (localObject3 != null) {
          StatisticCollector.getInstance(((AppInterface)localObject3).getApp()).collectPerformance(((AppInterface)localObject3).getCurrentAccountUin(), "cmgame_checkgame_update", true, 0L, 0L, (HashMap)localObject4, "", false);
        }
        QLog.d("CmGameStat", 1, new Object[] { "cmgame_checkgame_update, needUpdate=", Boolean.valueOf(bool3), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId), "]" });
        if (localObject1 != null) {
          ((OnGameStartCheckListener)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.retCode, this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam, null);
        }
        if (ApolloGameRscVerify.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.isWhiteUsr, this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId))
        {
          localObject1 = new CmGameRscSvrInfo();
          ((CmGameRscSvrInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId);
          ((CmGameRscSvrInfo)localObject1).jdField_a_of_type_Long = l2;
          ((CmGameRscSvrInfo)localObject1).jdField_b_of_type_Long = l1;
          ((CmGameRscSvrInfo)localObject1).jdField_a_of_type_ArrayOfByte = paramBundle;
          ((CmGameRscSvrInfo)localObject1).jdField_b_of_type_Boolean = bool2;
          ((CmGameRscSvrInfo)localObject1).jdField_a_of_type_Boolean = bool3;
          ((CmGameRscSvrInfo)localObject1).jdField_c_of_type_JavaLangString = str3;
          ((CmGameRscSvrInfo)localObject1).jdField_e_of_type_JavaLangString = str1;
          ((CmGameRscSvrInfo)localObject1).jdField_d_of_type_JavaLangString = str2;
          ((CmGameRscSvrInfo)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId;
          ((CmGameRscSvrInfo)localObject1).jdField_a_of_type_Int = i1;
          ((CmGameRscSvrInfo)localObject1).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.enter;
          ((CmGameRscSvrInfo)localObject1).f = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.from;
          ((CmGameRscSvrInfo)localObject1).jdField_d_of_type_Int = 0;
          ((CmGameRscSvrInfo)localObject1).jdField_c_of_type_Long = System.currentTimeMillis();
          ((CmGameRscSvrInfo)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.delayMs;
          this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscDownloader = new CmGameRscDownloader((CmGameRscSvrInfo)localObject1, this);
          bool1 = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDownloadCmGameRscDownloader.a();
          paramBundle = new StringBuilder();
          paramBundle.append("onGetGameKey [cmgame_pack_main], response, gameId:");
          paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId);
          paramBundle.append(",ver:");
          paramBundle.append(i1);
          paramBundle.append(",isPatch:");
          paramBundle.append(bool2);
          paramBundle.append(",isUpdate:");
          paramBundle.append(bool3);
          QLog.i("cmgame_process.CmGameStartChecker", 1, paramBundle.toString());
          if (!bool1) {
            c();
          }
        }
        else
        {
          c();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("cmgame_process.CmGameStartChecker", 2, "onGetGameKey e:", paramBundle);
      }
      return;
      label1927:
      Object localObject1 = null;
      continue;
      label1933:
      boolean bool1 = false;
      continue;
      label1939:
      boolean bool2 = false;
      continue;
      label1945:
      paramBundle = null;
      continue;
      label1950:
      int i = 0;
      continue;
      label1955:
      int j = 0;
      continue;
      label1960:
      continue;
      label1963:
      continue;
      label1966:
      bool1 = false;
      continue;
      label1972:
      Object localObject2 = "0";
    }
  }
  
  public void a(CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onDownloadConfirm] startCheckParam:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
        QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
        ((OnGameStartCheckListener)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam, paramICmGameConfirmListener, paramLong);
      }
    }
  }
  
  public void a(StartCheckParam paramStartCheckParam, OnGameStartCheckListener paramOnGameStartCheckListener)
  {
    if ((paramStartCheckParam != null) && (paramOnGameStartCheckListener != null))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam = paramStartCheckParam;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "[launchGame], startCheckerParam:", paramStartCheckParam });
      }
      ApolloGameStateMachine.a().a();
      ApolloGameStateMachine.a().a(1);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnGameStartCheckListener);
      this.jdField_a_of_type_Int = 0;
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
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, "");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.transInfo = "{\"standAlone\":1}";
    c();
  }
  
  public void b(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    if (paramString == null) {
      return;
    }
    paramString.mUpdated = true;
    paramString.mGameType = ApolloGameUtil.a(paramString.gameId);
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    paramString.viewMode = ApolloGameUtil.a(paramString.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.mGameType);
    paramString = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramString != null)
    {
      paramString = (OnGameStartCheckListener)paramString.get();
      if (paramString != null)
      {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "gameCheckListener.onDownloadGameResDown startCheckParam:", this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam });
        paramString.e(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
      }
    }
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "checkLife startCheckParam is null");
      return;
    }
    Object localObject = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "checkLife app == null");
      return;
    }
    int i = ApolloGameUtil.a((AppInterface)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" checkLife  life =");
      ((StringBuilder)localObject).append(i);
      QLog.d("cmgame_process.CmGameStartChecker", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.retCode == ApolloConstant.jdField_a_of_type_Long)
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (OnGameStartCheckListener)((WeakReference)localObject).get();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gameCheckListener.onGameLifeTipShow startCheckParam:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
          QLog.d("cmgame_process.CmGameStartChecker", 2, localStringBuilder.toString());
          ((OnGameStartCheckListener)localObject).b(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.gameId);
      VipUtils.a(null, "cmshow", "Apollo", "game_times_short", 0, 0, new String[] { ((StringBuilder)localObject).toString() });
      return;
    }
    a();
  }
  
  public void c(int paramInt, String paramString)
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
    //   1: ldc_w 788
    //   4: invokevirtual 792	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   7: istore_1
    //   8: aload_3
    //   9: ldc_w 794
    //   12: invokevirtual 798	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 12
    //   17: ldc_w 800
    //   20: aload 12
    //   22: invokevirtual 804	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifne +51 -> 76
    //   28: aload_0
    //   29: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   32: getfield 642	com/tencent/mobileqq/apollo/model/StartCheckParam:isWhiteUsr	Z
    //   35: invokestatic 809	com/tencent/mobileqq/apollo/game/process/data/CmGameConstant:a	(Z)Ljava/lang/String;
    //   38: aload 12
    //   40: invokevirtual 804	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +6 -> 49
    //   46: goto +30 -> 76
    //   49: ldc 60
    //   51: iconst_1
    //   52: iconst_2
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: ldc_w 811
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload 12
    //   66: aastore
    //   67: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   70: iconst_0
    //   71: istore 4
    //   73: goto +161 -> 234
    //   76: aload_3
    //   77: ldc_w 813
    //   80: invokevirtual 798	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokestatic 816	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   86: istore 4
    //   88: iload_1
    //   89: istore 5
    //   91: aload_0
    //   92: invokestatic 587	java/lang/System:currentTimeMillis	()J
    //   95: putfield 817	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_c_of_type_Long	J
    //   98: aload_3
    //   99: ldc 208
    //   101: invokevirtual 214	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   104: astore 12
    //   106: aload 12
    //   108: ifnull +98 -> 206
    //   111: iload_2
    //   112: ifeq +94 -> 206
    //   115: new 819	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   118: dup
    //   119: invokespecial 820	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   122: astore_3
    //   123: aload_3
    //   124: aload 12
    //   126: invokevirtual 821	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   129: pop
    //   130: new 210	android/os/Bundle
    //   133: dup
    //   134: invokespecial 822	android/os/Bundle:<init>	()V
    //   137: astore 12
    //   139: aload 12
    //   141: ldc_w 823
    //   144: aload_3
    //   145: getfield 827	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   148: invokevirtual 830	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   151: invokevirtual 834	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   154: aload_0
    //   155: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   158: aload_3
    //   159: getfield 827	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   162: invokevirtual 830	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   165: putfield 265	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   168: aload 12
    //   170: ldc 208
    //   172: aload_3
    //   173: getfield 837	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:pbRsqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   176: invokevirtual 324	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   179: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   182: invokevirtual 841	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   185: new 843	com/tencent/mobileqq/apollo/game/CmGameStartChecker$3
    //   188: dup
    //   189: aload_0
    //   190: aload 12
    //   192: invokespecial 846	com/tencent/mobileqq/apollo/game/CmGameStartChecker$3:<init>	(Lcom/tencent/mobileqq/apollo/game/CmGameStartChecker;Landroid/os/Bundle;)V
    //   195: sipush 128
    //   198: aconst_null
    //   199: iconst_1
    //   200: invokestatic 847	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   203: goto +31 -> 234
    //   206: ldc 60
    //   208: iconst_1
    //   209: iconst_2
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: ldc_w 849
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: iload 5
    //   223: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: aastore
    //   227: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   230: aload_0
    //   231: invokespecial 851	com/tencent/mobileqq/apollo/game/CmGameStartChecker:d	()V
    //   234: aload_0
    //   235: getfield 32	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   238: invokevirtual 44	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   241: checkcast 144	com/tencent/common/app/AppInterface
    //   244: astore_3
    //   245: aload_3
    //   246: ifnull +728 -> 974
    //   249: aload_0
    //   250: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   253: astore 12
    //   255: aload 12
    //   257: ifnull +717 -> 974
    //   260: iload_1
    //   261: sipush 1000
    //   264: if_icmpne +13 -> 277
    //   267: aload 12
    //   269: getfield 265	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   272: lstore 8
    //   274: goto +7 -> 281
    //   277: iload_1
    //   278: i2l
    //   279: lstore 8
    //   281: aload_0
    //   282: getfield 817	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_c_of_type_Long	J
    //   285: aload_0
    //   286: getfield 852	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_b_of_type_Long	J
    //   289: lsub
    //   290: lstore 10
    //   292: aconst_null
    //   293: invokestatic 857	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   296: istore 6
    //   298: new 598	java/util/HashMap
    //   301: dup
    //   302: invokespecial 599	java/util/HashMap:<init>	()V
    //   305: astore 12
    //   307: aload 12
    //   309: ldc_w 859
    //   312: lload 8
    //   314: invokestatic 526	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   317: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   320: pop
    //   321: aload 12
    //   323: ldc_w 601
    //   326: aload_0
    //   327: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   330: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   333: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   336: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aload 12
    //   342: ldc_w 861
    //   345: iload 6
    //   347: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   350: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload_3
    //   355: invokevirtual 148	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   358: invokestatic 617	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   361: astore 13
    //   363: aload_3
    //   364: invokevirtual 620	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   367: astore_3
    //   368: lload 8
    //   370: lconst_0
    //   371: lcmp
    //   372: ifne +8 -> 380
    //   375: iconst_1
    //   376: istore_2
    //   377: goto +5 -> 382
    //   380: iconst_0
    //   381: istore_2
    //   382: aload 13
    //   384: aload_3
    //   385: ldc_w 863
    //   388: iload_2
    //   389: lload 10
    //   391: lconst_0
    //   392: aload 12
    //   394: ldc 113
    //   396: iconst_0
    //   397: invokevirtual 626	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   400: lload 8
    //   402: lconst_0
    //   403: lcmp
    //   404: ifne +8 -> 412
    //   407: iconst_0
    //   408: istore_1
    //   409: goto +5 -> 414
    //   412: iconst_1
    //   413: istore_1
    //   414: aload_0
    //   415: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   418: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   421: istore 7
    //   423: iload 4
    //   425: iconst_2
    //   426: if_icmpne +14 -> 440
    //   429: aload_0
    //   430: getfield 25	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_Int	I
    //   433: iconst_2
    //   434: isub
    //   435: istore 5
    //   437: goto +6 -> 443
    //   440: iconst_0
    //   441: istore 5
    //   443: aconst_null
    //   444: ldc_w 771
    //   447: ldc_w 773
    //   450: ldc_w 865
    //   453: iload 4
    //   455: iload_1
    //   456: iconst_2
    //   457: anewarray 391	java/lang/String
    //   460: dup
    //   461: iconst_0
    //   462: iload 7
    //   464: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   467: aastore
    //   468: dup
    //   469: iconst_1
    //   470: iload 5
    //   472: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   475: aastore
    //   476: invokestatic 780	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   479: ldc_w 628
    //   482: iconst_1
    //   483: bipush 9
    //   485: anewarray 4	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: ldc_w 867
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: lload 10
    //   498: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   501: aastore
    //   502: dup
    //   503: iconst_2
    //   504: ldc_w 637
    //   507: aastore
    //   508: dup
    //   509: iconst_3
    //   510: aload_0
    //   511: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   514: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   517: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: aastore
    //   521: dup
    //   522: iconst_4
    //   523: ldc_w 869
    //   526: aastore
    //   527: dup
    //   528: iconst_5
    //   529: lload 8
    //   531: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   534: aastore
    //   535: dup
    //   536: bipush 6
    //   538: ldc_w 871
    //   541: aastore
    //   542: dup
    //   543: bipush 7
    //   545: iload 6
    //   547: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   550: aastore
    //   551: dup
    //   552: bipush 8
    //   554: ldc_w 639
    //   557: aastore
    //   558: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   561: return
    //   562: astore_3
    //   563: iload 4
    //   565: istore_1
    //   566: goto +410 -> 976
    //   569: astore_3
    //   570: iload 4
    //   572: istore_1
    //   573: goto +32 -> 605
    //   576: astore_3
    //   577: iload_1
    //   578: istore 5
    //   580: goto +14 -> 594
    //   583: astore_3
    //   584: iload_1
    //   585: istore 5
    //   587: goto +16 -> 603
    //   590: astore_3
    //   591: iconst_0
    //   592: istore 5
    //   594: iconst_0
    //   595: istore_1
    //   596: goto +380 -> 976
    //   599: astore_3
    //   600: iconst_0
    //   601: istore 5
    //   603: iconst_0
    //   604: istore_1
    //   605: new 48	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   612: astore 12
    //   614: aload 12
    //   616: ldc_w 873
    //   619: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 12
    //   625: aload_3
    //   626: invokevirtual 876	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   629: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: ldc 60
    //   635: iconst_1
    //   636: aload 12
    //   638: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload_0
    //   645: getfield 32	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   648: invokevirtual 44	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   651: checkcast 144	com/tencent/common/app/AppInterface
    //   654: astore_3
    //   655: aload_3
    //   656: ifnull +318 -> 974
    //   659: aload_0
    //   660: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   663: astore 12
    //   665: aload 12
    //   667: ifnull +307 -> 974
    //   670: iload 5
    //   672: sipush 1000
    //   675: if_icmpne +13 -> 688
    //   678: aload 12
    //   680: getfield 265	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   683: lstore 8
    //   685: goto +8 -> 693
    //   688: iload 5
    //   690: i2l
    //   691: lstore 8
    //   693: aload_0
    //   694: getfield 817	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_c_of_type_Long	J
    //   697: aload_0
    //   698: getfield 852	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_b_of_type_Long	J
    //   701: lsub
    //   702: lstore 10
    //   704: aconst_null
    //   705: invokestatic 857	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   708: istore 6
    //   710: new 598	java/util/HashMap
    //   713: dup
    //   714: invokespecial 599	java/util/HashMap:<init>	()V
    //   717: astore 12
    //   719: aload 12
    //   721: ldc_w 859
    //   724: lload 8
    //   726: invokestatic 526	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   729: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   732: pop
    //   733: aload 12
    //   735: ldc_w 601
    //   738: aload_0
    //   739: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   742: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   745: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   748: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   751: pop
    //   752: aload 12
    //   754: ldc_w 861
    //   757: iload 6
    //   759: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   762: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   765: pop
    //   766: aload_3
    //   767: invokevirtual 148	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   770: invokestatic 617	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   773: astore 13
    //   775: aload_3
    //   776: invokevirtual 620	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   779: astore_3
    //   780: lload 8
    //   782: lconst_0
    //   783: lcmp
    //   784: ifne +8 -> 792
    //   787: iconst_1
    //   788: istore_2
    //   789: goto +5 -> 794
    //   792: iconst_0
    //   793: istore_2
    //   794: aload 13
    //   796: aload_3
    //   797: ldc_w 863
    //   800: iload_2
    //   801: lload 10
    //   803: lconst_0
    //   804: aload 12
    //   806: ldc 113
    //   808: iconst_0
    //   809: invokevirtual 626	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   812: lload 8
    //   814: lconst_0
    //   815: lcmp
    //   816: ifne +9 -> 825
    //   819: iconst_0
    //   820: istore 4
    //   822: goto +6 -> 828
    //   825: iconst_1
    //   826: istore 4
    //   828: aload_0
    //   829: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   832: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   835: istore 7
    //   837: iload_1
    //   838: iconst_2
    //   839: if_icmpne +14 -> 853
    //   842: aload_0
    //   843: getfield 25	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_Int	I
    //   846: iconst_2
    //   847: isub
    //   848: istore 5
    //   850: goto +6 -> 856
    //   853: iconst_0
    //   854: istore 5
    //   856: aconst_null
    //   857: ldc_w 771
    //   860: ldc_w 773
    //   863: ldc_w 865
    //   866: iload_1
    //   867: iload 4
    //   869: iconst_2
    //   870: anewarray 391	java/lang/String
    //   873: dup
    //   874: iconst_0
    //   875: iload 7
    //   877: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   880: aastore
    //   881: dup
    //   882: iconst_1
    //   883: iload 5
    //   885: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   888: aastore
    //   889: invokestatic 780	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   892: ldc_w 628
    //   895: iconst_1
    //   896: bipush 9
    //   898: anewarray 4	java/lang/Object
    //   901: dup
    //   902: iconst_0
    //   903: ldc_w 867
    //   906: aastore
    //   907: dup
    //   908: iconst_1
    //   909: lload 10
    //   911: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   914: aastore
    //   915: dup
    //   916: iconst_2
    //   917: ldc_w 637
    //   920: aastore
    //   921: dup
    //   922: iconst_3
    //   923: aload_0
    //   924: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   927: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   930: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   933: aastore
    //   934: dup
    //   935: iconst_4
    //   936: ldc_w 869
    //   939: aastore
    //   940: dup
    //   941: iconst_5
    //   942: lload 8
    //   944: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   947: aastore
    //   948: dup
    //   949: bipush 6
    //   951: ldc_w 871
    //   954: aastore
    //   955: dup
    //   956: bipush 7
    //   958: iload 6
    //   960: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   963: aastore
    //   964: dup
    //   965: bipush 8
    //   967: ldc_w 639
    //   970: aastore
    //   971: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   974: return
    //   975: astore_3
    //   976: aload_0
    //   977: getfield 32	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   980: invokevirtual 44	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   983: checkcast 144	com/tencent/common/app/AppInterface
    //   986: astore 12
    //   988: aload 12
    //   990: ifnull +322 -> 1312
    //   993: aload_0
    //   994: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   997: astore 13
    //   999: aload 13
    //   1001: ifnull +311 -> 1312
    //   1004: iload 5
    //   1006: sipush 1000
    //   1009: if_icmpne +13 -> 1022
    //   1012: aload 13
    //   1014: getfield 265	com/tencent/mobileqq/apollo/model/StartCheckParam:retCode	J
    //   1017: lstore 8
    //   1019: goto +8 -> 1027
    //   1022: iload 5
    //   1024: i2l
    //   1025: lstore 8
    //   1027: aload_0
    //   1028: getfield 817	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_c_of_type_Long	J
    //   1031: aload_0
    //   1032: getfield 852	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_b_of_type_Long	J
    //   1035: lsub
    //   1036: lstore 10
    //   1038: aconst_null
    //   1039: invokestatic 857	com/tencent/mqpsdk/util/NetUtil:a	(Landroid/content/Context;)I
    //   1042: istore 6
    //   1044: new 598	java/util/HashMap
    //   1047: dup
    //   1048: invokespecial 599	java/util/HashMap:<init>	()V
    //   1051: astore 13
    //   1053: aload 13
    //   1055: ldc_w 859
    //   1058: lload 8
    //   1060: invokestatic 526	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1063: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1066: pop
    //   1067: aload 13
    //   1069: ldc_w 601
    //   1072: aload_0
    //   1073: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   1076: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   1079: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1082: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1085: pop
    //   1086: aload 13
    //   1088: ldc_w 861
    //   1091: iload 6
    //   1093: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1096: invokevirtual 607	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1099: pop
    //   1100: aload 12
    //   1102: invokevirtual 148	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1105: invokestatic 617	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1108: astore 14
    //   1110: aload 12
    //   1112: invokevirtual 620	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1115: astore 12
    //   1117: lload 8
    //   1119: lconst_0
    //   1120: lcmp
    //   1121: ifne +8 -> 1129
    //   1124: iconst_1
    //   1125: istore_2
    //   1126: goto +5 -> 1131
    //   1129: iconst_0
    //   1130: istore_2
    //   1131: aload 14
    //   1133: aload 12
    //   1135: ldc_w 863
    //   1138: iload_2
    //   1139: lload 10
    //   1141: lconst_0
    //   1142: aload 13
    //   1144: ldc 113
    //   1146: iconst_0
    //   1147: invokevirtual 626	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1150: lload 8
    //   1152: lconst_0
    //   1153: lcmp
    //   1154: ifne +9 -> 1163
    //   1157: iconst_0
    //   1158: istore 4
    //   1160: goto +6 -> 1166
    //   1163: iconst_1
    //   1164: istore 4
    //   1166: aload_0
    //   1167: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   1170: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   1173: istore 7
    //   1175: iload_1
    //   1176: iconst_2
    //   1177: if_icmpne +14 -> 1191
    //   1180: aload_0
    //   1181: getfield 25	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_Int	I
    //   1184: iconst_2
    //   1185: isub
    //   1186: istore 5
    //   1188: goto +6 -> 1194
    //   1191: iconst_0
    //   1192: istore 5
    //   1194: aconst_null
    //   1195: ldc_w 771
    //   1198: ldc_w 773
    //   1201: ldc_w 865
    //   1204: iload_1
    //   1205: iload 4
    //   1207: iconst_2
    //   1208: anewarray 391	java/lang/String
    //   1211: dup
    //   1212: iconst_0
    //   1213: iload 7
    //   1215: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1218: aastore
    //   1219: dup
    //   1220: iconst_1
    //   1221: iload 5
    //   1223: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1226: aastore
    //   1227: invokestatic 780	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1230: ldc_w 628
    //   1233: iconst_1
    //   1234: bipush 9
    //   1236: anewarray 4	java/lang/Object
    //   1239: dup
    //   1240: iconst_0
    //   1241: ldc_w 867
    //   1244: aastore
    //   1245: dup
    //   1246: iconst_1
    //   1247: lload 10
    //   1249: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1252: aastore
    //   1253: dup
    //   1254: iconst_2
    //   1255: ldc_w 637
    //   1258: aastore
    //   1259: dup
    //   1260: iconst_3
    //   1261: aload_0
    //   1262: getfield 36	com/tencent/mobileqq/apollo/game/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam	Lcom/tencent/mobileqq/apollo/model/StartCheckParam;
    //   1265: getfield 118	com/tencent/mobileqq/apollo/model/StartCheckParam:gameId	I
    //   1268: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1271: aastore
    //   1272: dup
    //   1273: iconst_4
    //   1274: ldc_w 869
    //   1277: aastore
    //   1278: dup
    //   1279: iconst_5
    //   1280: lload 8
    //   1282: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1285: aastore
    //   1286: dup
    //   1287: bipush 6
    //   1289: ldc_w 871
    //   1292: aastore
    //   1293: dup
    //   1294: bipush 7
    //   1296: iload 6
    //   1298: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1301: aastore
    //   1302: dup
    //   1303: bipush 8
    //   1305: ldc_w 639
    //   1308: aastore
    //   1309: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1312: aload_3
    //   1313: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1314	0	this	CmGameStartChecker
    //   0	1314	1	paramInt	int
    //   0	1314	2	paramBoolean	boolean
    //   0	1314	3	paramBundle	Bundle
    //   71	1135	4	i	int
    //   89	1133	5	j	int
    //   296	1001	6	k	int
    //   421	793	7	m	int
    //   272	1009	8	l1	long
    //   290	958	10	l2	long
    //   15	1119	12	localObject1	Object
    //   361	782	13	localObject2	Object
    //   1108	24	14	localStatisticCollector	StatisticCollector
    // Exception table:
    //   from	to	target	type
    //   91	106	562	finally
    //   115	203	562	finally
    //   206	234	562	finally
    //   91	106	569	java/lang/Exception
    //   115	203	569	java/lang/Exception
    //   206	234	569	java/lang/Exception
    //   8	46	576	finally
    //   49	70	576	finally
    //   76	88	576	finally
    //   8	46	583	java/lang/Exception
    //   49	70	583	java/lang/Exception
    //   76	88	583	java/lang/Exception
    //   0	8	590	finally
    //   0	8	599	java/lang/Exception
    //   605	644	975	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameStartChecker
 * JD-Core Version:    0.7.0.1
 */