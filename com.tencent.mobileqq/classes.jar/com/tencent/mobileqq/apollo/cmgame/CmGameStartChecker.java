package com.tencent.mobileqq.apollo.cmgame;

import aiwi;
import aiwj;
import ajac;
import ajdb;
import ajde;
import ajdk;
import ajms;
import ajnl;
import android.os.Bundle;
import android.text.TextUtils;
import axrn;
import bbfj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.apollo.STCheckGame.STCheckGameRsp;
import com.tencent.pb.apollo.STCheckGame.STGameConfInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.observer.BusinessObserver;

public class CmGameStartChecker
  implements ajdk, BusinessObserver
{
  private volatile int jdField_a_of_type_Int;
  public long a;
  private ajdb jdField_a_of_type_Ajdb;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private WeakReference<aiwj> jdField_a_of_type_JavaLangRefWeakReference;
  public long b;
  private WeakReference<AppInterface> b;
  public long c;
  
  public CmGameStartChecker(AppInterface paramAppInterface)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aiwj localaiwj = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaiwj != null)
      {
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameCheckFail:", Long.valueOf(paramLong), ",startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
        localaiwj.onGameCheckFinish(paramLong, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, null);
      }
    }
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aiwj localaiwj = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaiwj != null)
      {
        QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "callBackGameFail:", Long.valueOf(paramLong), ",startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
        localaiwj.onGameFailed(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, paramLong);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    if (ajac.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))
    {
      b();
      return;
    }
    aiwj localaiwj = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      localaiwj.onGameCheckRetry(1);
      a(1);
      return;
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      a(-17L);
      return;
    }
    localaiwj.onGameCheckRetry(2);
  }
  
  public String a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return "";
    }
    return ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "startGame startCheckParam:", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
    }
    ThreadManager.post(new CmGameStartChecker.1(this), 5, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || ((!bbfj.d(((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getApp())) && (!ajac.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))))
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, "[checkGame] none network");
      a(-10L);
      return;
    }
    ThreadManagerV2.excute(new CmGameStartChecker.2(this, paramInt), 192, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      paramString = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString == null);
    QLog.d("cmgame_process.CmGameStartChecker", 2, "[onDownloadProgress] progress:" + paramInt1);
    paramString.onDownloadGameResProgress(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, paramInt1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.startT = -1L;
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      paramString = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString == null);
    QLog.d("cmgame_process.CmGameStartChecker", 2, "gameCheckListener.onDownloadGameResStart startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    paramString.onDownloadGameResStart(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  public void a(aiwi paramaiwi, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    aiwj localaiwj;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localaiwj = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localaiwj == null);
    QLog.d("cmgame_process.CmGameStartChecker", 2, "[onDownloadConfirm] startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    localaiwj.onDownloadConfirm(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, paramaiwi, paramLong);
  }
  
  protected void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    Object localObject1;
    label27:
    int k;
    int m;
    Object localObject4;
    Object localObject3;
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
        break label1898;
      }
      localObject1 = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      k = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
      m = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameMode;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from;
      localObject3 = new STCheckGame.STCheckGameRsp();
      ((STCheckGame.STCheckGameRsp)localObject3).mergeFrom(paramBundle.getByteArray("data"));
      paramBundle = ((STCheckGame.STCheckGameRsp)localObject3).wording.get();
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.wordingV2 = ((STCheckGame.STCheckGameRsp)localObject3).wordingV2.get();
      if (!TextUtils.isEmpty(paramBundle))
      {
        QLog.i("cmgame_process.CmGameStartChecker", 1, "onGetGameKey failwording:" + paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.wordingV2 = paramBundle;
        ApolloItemBuilder.a(paramBundle, 1, BaseApplicationImpl.getContext());
        ApolloGameStateMachine.a().a(5, "fail in get key");
        a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 2, "onGetGameKey e:", paramBundle);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode != 0L)
    {
      QLog.e("cmgame_process.CmGameStartChecker", 1, new Object[] { "onGetGameKey checkGame failed retCode:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode) });
      ApolloGameStateMachine.a().a(5, "fail in get key");
      a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode);
      return;
    }
    String str4 = ((STCheckGame.STCheckGameRsp)localObject3).st.get();
    String str5 = ((STCheckGame.STCheckGameRsp)localObject3).stKey.get();
    int n = ((STCheckGame.STCheckGameRsp)localObject3).remainPlays.get();
    int i1 = ((STCheckGame.STCheckGameRsp)localObject3).svrResVer.get();
    boolean bool1;
    label301:
    boolean bool2;
    label316:
    String str1;
    String str2;
    String str3;
    long l1;
    long l2;
    label389:
    int i;
    label409:
    int j;
    label429:
    boolean bool3;
    if (((STCheckGame.STCheckGameRsp)localObject3).updateFlag.get() == 1)
    {
      bool1 = true;
      if (((STCheckGame.STCheckGameRsp)localObject3).isPatch.get() != 1) {
        break label1910;
      }
      bool2 = true;
      str1 = ((STCheckGame.STCheckGameRsp)localObject3).patchUrl.get();
      str2 = ((STCheckGame.STCheckGameRsp)localObject3).zipUrl.get();
      str3 = ((STCheckGame.STCheckGameRsp)localObject3).zipMd5.get();
      l1 = ((STCheckGame.STCheckGameRsp)localObject3).packageSize.get();
      l2 = ((STCheckGame.STCheckGameRsp)localObject3).tipsSize.get();
      if (((STCheckGame.STCheckGameRsp)localObject3).patchContent.has())
      {
        paramBundle = ((STCheckGame.STCheckGameRsp)localObject3).patchContent.get().toByteArray();
        if (((STCheckGame.STCheckGameRsp)localObject3).appIdSource.has())
        {
          i = ((STCheckGame.STCheckGameRsp)localObject3).appIdSource.get();
          if (((STCheckGame.STCheckGameRsp)localObject3).commFlagBits.has())
          {
            j = ((STCheckGame.STCheckGameRsp)localObject3).commFlagBits.get();
            if (((STCheckGame.STCheckGameRsp)localObject3).adDevUin.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.adDevUin = ((STCheckGame.STCheckGameRsp)localObject3).adDevUin.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).adForbitPosId.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.adForbidPosId = ((STCheckGame.STCheckGameRsp)localObject3).adForbitPosId.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).adShareRate.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.adShareRate = ((STCheckGame.STCheckGameRsp)localObject3).adShareRate.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).rpUrl.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.rpUrl = ((STCheckGame.STCheckGameRsp)localObject3).rpUrl.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).rpPic.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.rpIconUrl = ((STCheckGame.STCheckGameRsp)localObject3).rpPic.get();
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).ssoCmdRule.has())
            {
              localObject2 = ((STCheckGame.STCheckGameRsp)localObject3).ssoCmdRule.get();
              if (localObject1 != null)
              {
                QLog.d("cmgame_process.CmGameStartChecker", 2, "onGetGameKey gameCheckListener.onSsoCmdRuleRsp startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                ((aiwj)localObject1).onSsoCmdRuleRsp(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, (String)localObject2);
              }
            }
            for (;;)
            {
              localObject2 = "";
              if (((STCheckGame.STCheckGameRsp)localObject3).extInfo.has()) {
                localObject2 = new String(((STCheckGame.STCheckGameRsp)localObject3).extInfo.get().toByteArray());
              }
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey checkGame done gameId: " + k, ", from: " + (String)localObject4 + ", gameMode: " + m + ",extInfo:" + (String)localObject2 });
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.apolloGameSt = str4;
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.apolloGameStkey = str5;
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId = ((STCheckGame.STCheckGameRsp)localObject3).openId.get();
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionOpenId = ((STCheckGame.STCheckGameRsp)localObject3).sessionOpenId.get();
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extInfoFromSvr = ((String)localObject2);
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.appIdSrc = i;
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag = j;
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
                  break label1916;
                }
                bool3 = true;
                label989:
                ((ApolloGameData)localObject4).isFeatured = bool3;
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
                  this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game = ((ApolloGameData)localObject4);
                  this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode = ((ApolloGameData)localObject4).viewMode;
                  ((aiwj)localObject1).onGetGameData(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
                break;
              }
              QLog.e("cmgame_process.CmGameStartChecker", 1, "onGetGameKey get game is null");
              a(-11L);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "onGetGameKey ssoCmdRule, no ssoCmdRule for game ", Integer.valueOf(k) });
              }
            }
            if (((STCheckGame.STCheckGameRsp)localObject3).transInfo.has()) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.transInfo = new String(((STCheckGame.STCheckGameRsp)localObject3).transInfo.get().toByteArray());
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.delayMs = ((STCheckGame.STCheckGameRsp)localObject3).delayMs.get();
            airx.b = str4;
            airx.jdField_c_of_type_JavaLangString = str5;
            localObject3 = (AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
            if (localObject3 != null) {
              ApolloGameUtil.a((AppInterface)localObject3, n);
            }
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from)) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from = "updateRes";
            }
            QLog.i("cmgame_process.CmGameStartChecker", 1, "[game_launch_cost], check game:" + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.startT));
            if (bool1) {
              ajac.a(ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
            }
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
            if (!bool1) {
              break label1922;
            }
          }
        }
      }
    }
    label1922:
    for (Object localObject2 = "1";; localObject2 = "0")
    {
      ((HashMap)localObject4).put("param_update", localObject2);
      axrn.a(((AppInterface)localObject3).getApp()).a(((AppInterface)localObject3).getCurrentAccountUin(), "cmgame_checkgame_update", true, 0L, 0L, (HashMap)localObject4, "", false);
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_checkgame_update, needUpdate=", Boolean.valueOf(bool1), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      if (localObject1 != null) {
        ((aiwj)localObject1).onGameCheckFinish(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, null);
      }
      if (ajnl.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId))
      {
        localObject1 = new ajde();
        ((ajde)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
        ((ajde)localObject1).jdField_a_of_type_Long = l2;
        ((ajde)localObject1).jdField_b_of_type_Long = l1;
        ((ajde)localObject1).jdField_a_of_type_ArrayOfByte = paramBundle;
        ((ajde)localObject1).jdField_b_of_type_Boolean = bool2;
        ((ajde)localObject1).jdField_a_of_type_Boolean = bool1;
        ((ajde)localObject1).jdField_c_of_type_JavaLangString = str3;
        ((ajde)localObject1).jdField_e_of_type_JavaLangString = str1;
        ((ajde)localObject1).jdField_d_of_type_JavaLangString = str2;
        ((ajde)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
        ((ajde)localObject1).jdField_a_of_type_Int = i1;
        ((ajde)localObject1).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        ((ajde)localObject1).f = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.from;
        ((ajde)localObject1).jdField_d_of_type_Int = 0;
        ((ajde)localObject1).jdField_c_of_type_Long = System.currentTimeMillis();
        ((ajde)localObject1).jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.delayMs;
        this.jdField_a_of_type_Ajdb = new ajdb((ajde)localObject1, this);
        bool3 = this.jdField_a_of_type_Ajdb.a();
        ajac.a(new Object[] { "[checkRes], serverVersion:" + i1 + ", isPatch:" + bool2, ", isUpdate:" + bool1, ",delay:", Integer.valueOf(((ajde)localObject1).jdField_e_of_type_Int) });
        QLog.i("cmgame_process.CmGameStartChecker", 1, "onGetGameKey [cmgame_pack_main], response, gameId:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId + ",ver:" + i1 + ",isPatch:" + bool2 + ",isUpdate:" + bool1);
        if (bool3) {
          break;
        }
        c();
        return;
      }
      c();
      return;
      j = 0;
      break label429;
      i = 0;
      break label409;
      paramBundle = null;
      break label389;
      label1898:
      localObject1 = null;
      break label27;
      bool1 = false;
      break label301;
      label1910:
      bool2 = false;
      break label316;
      label1916:
      bool3 = false;
      break label989;
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, aiwj paramaiwj)
  {
    if ((paramStartCheckParam == null) || (paramaiwj == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameStartChecker", 2, "[launchGame],startCheckParam == null || gameStartCheckListener == nul");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "[launchGame], startCheckerParam:", paramStartCheckParam });
      }
      ApolloGameStateMachine.a().a();
      ApolloGameStateMachine.a().a(1);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaiwj);
      this.jdField_a_of_type_Int = 0;
      if (!paramStartCheckParam.isRunning) {
        break;
      }
      a();
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameStartChecker", 2, "startGame from game resume");
    return;
    a(0);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, "");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.transInfo = "{\"standAlone\":1}";
    c();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mUpdated = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramString = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramString != null)
      {
        QLog.d("cmgame_process.CmGameStartChecker", 2, new Object[] { "gameCheckListener.onDownloadGameResDown startCheckParam:", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam });
        paramString.onDownloadGameResDown(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      }
    }
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)
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
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameStartChecker", 2, " checkLife  life =" + i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.retCode == ajms.jdField_a_of_type_Long)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (aiwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          QLog.d("cmgame_process.CmGameStartChecker", 2, "gameCheckListener.onGameLifeTipShow startCheckParam:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
          ((aiwj)localObject).onGameLifeTipShow(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
        }
      }
      VipUtils.a(null, "cmshow", "Apollo", "game_times_short", 0, 0, new String[] { "" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId });
      return;
    }
    a();
  }
  
  public void c(int paramInt, String paramString)
  {
    QLog.e("cmgame_process.CmGameStartChecker", 1, "[onDownloadFailure], ret:" + paramInt);
    ajac.a(new Object[] { "[downloadRes], failed ret:", Integer.valueOf(paramInt), ", packName:", paramString });
    b(-12L);
  }
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 7
    //   12: iload 7
    //   14: istore_1
    //   15: iload 9
    //   17: istore 6
    //   19: aload_3
    //   20: ldc_w 806
    //   23: invokevirtual 810	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   26: istore 8
    //   28: iload 7
    //   30: istore_1
    //   31: iload 8
    //   33: istore 4
    //   35: iload 9
    //   37: istore 6
    //   39: iload 8
    //   41: istore 5
    //   43: aload_3
    //   44: ldc_w 812
    //   47: invokevirtual 816	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 14
    //   52: iload 7
    //   54: istore_1
    //   55: iload 8
    //   57: istore 4
    //   59: iload 9
    //   61: istore 6
    //   63: iload 8
    //   65: istore 5
    //   67: ldc_w 818
    //   70: aload 14
    //   72: invokevirtual 822	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifne +36 -> 111
    //   78: iload 7
    //   80: istore_1
    //   81: iload 8
    //   83: istore 4
    //   85: iload 9
    //   87: istore 6
    //   89: iload 8
    //   91: istore 5
    //   93: aload_0
    //   94: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   97: getfield 654	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:isWhiteUsr	Z
    //   100: invokestatic 827	ajce:a	(Z)Ljava/lang/String;
    //   103: aload 14
    //   105: invokevirtual 822	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifeq +1051 -> 1159
    //   111: iload 7
    //   113: istore_1
    //   114: iload 8
    //   116: istore 4
    //   118: iload 9
    //   120: istore 6
    //   122: iload 8
    //   124: istore 5
    //   126: aload_3
    //   127: ldc_w 829
    //   130: invokevirtual 816	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic 832	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   136: istore 7
    //   138: iload 7
    //   140: istore_1
    //   141: iload 8
    //   143: istore 4
    //   145: iload 7
    //   147: istore 6
    //   149: iload 8
    //   151: istore 5
    //   153: aload_0
    //   154: invokestatic 602	java/lang/System:currentTimeMillis	()J
    //   157: putfield 833	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_c_of_type_Long	J
    //   160: iload 7
    //   162: istore_1
    //   163: iload 8
    //   165: istore 4
    //   167: iload 7
    //   169: istore 6
    //   171: iload 8
    //   173: istore 5
    //   175: aload_3
    //   176: ldc 220
    //   178: invokevirtual 226	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   181: astore 14
    //   183: aload 14
    //   185: ifnull +543 -> 728
    //   188: iload_2
    //   189: ifeq +539 -> 728
    //   192: iload 7
    //   194: istore_1
    //   195: iload 8
    //   197: istore 4
    //   199: iload 7
    //   201: istore 6
    //   203: iload 8
    //   205: istore 5
    //   207: new 835	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   210: dup
    //   211: invokespecial 836	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   214: astore_3
    //   215: iload 7
    //   217: istore_1
    //   218: iload 8
    //   220: istore 4
    //   222: iload 7
    //   224: istore 6
    //   226: iload 8
    //   228: istore 5
    //   230: aload_3
    //   231: aload 14
    //   233: invokevirtual 837	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   236: pop
    //   237: iload 7
    //   239: istore_1
    //   240: iload 8
    //   242: istore 4
    //   244: iload 7
    //   246: istore 6
    //   248: iload 8
    //   250: istore 5
    //   252: new 222	android/os/Bundle
    //   255: dup
    //   256: invokespecial 838	android/os/Bundle:<init>	()V
    //   259: astore 14
    //   261: iload 7
    //   263: istore_1
    //   264: iload 8
    //   266: istore 4
    //   268: iload 7
    //   270: istore 6
    //   272: iload 8
    //   274: istore 5
    //   276: aload 14
    //   278: ldc_w 839
    //   281: aload_3
    //   282: getfield 843	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   285: invokevirtual 846	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   288: invokevirtual 850	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   291: iload 7
    //   293: istore_1
    //   294: iload 8
    //   296: istore 4
    //   298: iload 7
    //   300: istore 6
    //   302: iload 8
    //   304: istore 5
    //   306: aload_0
    //   307: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   310: aload_3
    //   311: getfield 843	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   314: invokevirtual 846	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   317: putfield 275	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   320: iload 7
    //   322: istore_1
    //   323: iload 8
    //   325: istore 4
    //   327: iload 7
    //   329: istore 6
    //   331: iload 8
    //   333: istore 5
    //   335: aload 14
    //   337: ldc 220
    //   339: aload_3
    //   340: getfield 853	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:pbRsqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   343: invokevirtual 339	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   346: invokevirtual 345	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   349: invokevirtual 857	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   352: iload 7
    //   354: istore_1
    //   355: iload 8
    //   357: istore 4
    //   359: iload 7
    //   361: istore 6
    //   363: iload 8
    //   365: istore 5
    //   367: new 859	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$3
    //   370: dup
    //   371: aload_0
    //   372: aload 14
    //   374: invokespecial 862	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$3:<init>	(Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker;Landroid/os/Bundle;)V
    //   377: sipush 128
    //   380: aconst_null
    //   381: iconst_1
    //   382: invokestatic 863	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   385: iload 7
    //   387: istore_1
    //   388: aload_0
    //   389: getfield 30	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   392: invokevirtual 42	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   395: checkcast 148	com/tencent/common/app/AppInterface
    //   398: astore 15
    //   400: aload 15
    //   402: ifnull +325 -> 727
    //   405: aload_0
    //   406: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   409: ifnull +318 -> 727
    //   412: iload 8
    //   414: sipush 1000
    //   417: if_icmpne +783 -> 1200
    //   420: aload_0
    //   421: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   424: getfield 275	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   427: lstore 10
    //   429: aload_0
    //   430: getfield 833	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_c_of_type_Long	J
    //   433: aload_0
    //   434: getfield 864	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_b_of_type_Long	J
    //   437: lsub
    //   438: lstore 12
    //   440: aconst_null
    //   441: invokestatic 869	bcxw:a	(Landroid/content/Context;)I
    //   444: istore 6
    //   446: new 612	java/util/HashMap
    //   449: dup
    //   450: invokespecial 613	java/util/HashMap:<init>	()V
    //   453: astore_3
    //   454: aload_3
    //   455: ldc_w 871
    //   458: lload 10
    //   460: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   463: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: pop
    //   467: aload_3
    //   468: ldc_w 615
    //   471: aload_0
    //   472: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   475: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   478: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   481: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload_3
    //   486: ldc_w 873
    //   489: iload 6
    //   491: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   494: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   497: pop
    //   498: aload 15
    //   500: invokevirtual 152	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   503: invokestatic 630	axrn:a	(Landroid/content/Context;)Laxrn;
    //   506: astore 14
    //   508: aload 15
    //   510: invokevirtual 633	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   513: astore 15
    //   515: lload 10
    //   517: lconst_0
    //   518: lcmp
    //   519: ifne +689 -> 1208
    //   522: iconst_1
    //   523: istore_2
    //   524: aload 14
    //   526: aload 15
    //   528: ldc_w 875
    //   531: iload_2
    //   532: lload 12
    //   534: lconst_0
    //   535: aload_3
    //   536: ldc 117
    //   538: iconst_0
    //   539: invokevirtual 638	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   542: lload 10
    //   544: lconst_0
    //   545: lcmp
    //   546: ifne +667 -> 1213
    //   549: iconst_0
    //   550: istore 4
    //   552: aload_0
    //   553: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   556: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   559: istore 7
    //   561: iload_1
    //   562: iconst_2
    //   563: if_icmpne +656 -> 1219
    //   566: aload_0
    //   567: getfield 99	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_Int	I
    //   570: iconst_2
    //   571: isub
    //   572: istore 5
    //   574: aconst_null
    //   575: ldc_w 785
    //   578: ldc_w 787
    //   581: ldc_w 877
    //   584: iload_1
    //   585: iload 4
    //   587: iconst_2
    //   588: anewarray 400	java/lang/String
    //   591: dup
    //   592: iconst_0
    //   593: iload 7
    //   595: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   598: aastore
    //   599: dup
    //   600: iconst_1
    //   601: iload 5
    //   603: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   606: aastore
    //   607: invokestatic 794	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   610: ldc_w 640
    //   613: iconst_1
    //   614: bipush 9
    //   616: anewarray 4	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: ldc_w 879
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: lload 12
    //   629: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   632: aastore
    //   633: dup
    //   634: iconst_2
    //   635: ldc_w 649
    //   638: aastore
    //   639: dup
    //   640: iconst_3
    //   641: aload_0
    //   642: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   645: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   648: invokestatic 572	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   651: aastore
    //   652: dup
    //   653: iconst_4
    //   654: ldc_w 881
    //   657: aastore
    //   658: dup
    //   659: iconst_5
    //   660: lload 10
    //   662: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   665: aastore
    //   666: dup
    //   667: bipush 6
    //   669: ldc_w 883
    //   672: aastore
    //   673: dup
    //   674: bipush 7
    //   676: iload 6
    //   678: invokestatic 572	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   681: aastore
    //   682: dup
    //   683: bipush 8
    //   685: ldc_w 651
    //   688: aastore
    //   689: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   692: iconst_4
    //   693: anewarray 4	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: ldc_w 885
    //   701: aastore
    //   702: dup
    //   703: iconst_1
    //   704: lload 10
    //   706: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   709: aastore
    //   710: dup
    //   711: iconst_2
    //   712: ldc_w 887
    //   715: aastore
    //   716: dup
    //   717: iconst_3
    //   718: lload 12
    //   720: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   723: aastore
    //   724: invokestatic 720	ajac:a	([Ljava/lang/Object;)V
    //   727: return
    //   728: iload 7
    //   730: istore_1
    //   731: iload 8
    //   733: istore 4
    //   735: iload 7
    //   737: istore 6
    //   739: iload 8
    //   741: istore 5
    //   743: ldc 46
    //   745: iconst_1
    //   746: iconst_2
    //   747: anewarray 4	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: ldc_w 889
    //   755: aastore
    //   756: dup
    //   757: iconst_1
    //   758: iload 8
    //   760: invokestatic 572	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   763: aastore
    //   764: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   767: iload 7
    //   769: istore_1
    //   770: iload 8
    //   772: istore 4
    //   774: iload 7
    //   776: istore 6
    //   778: iload 8
    //   780: istore 5
    //   782: aload_0
    //   783: invokespecial 891	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:d	()V
    //   786: goto -401 -> 385
    //   789: astore_3
    //   790: ldc 46
    //   792: iconst_1
    //   793: new 56	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 893
    //   803: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_3
    //   807: invokevirtual 896	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   810: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   819: aload_0
    //   820: getfield 30	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   823: invokevirtual 42	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   826: checkcast 148	com/tencent/common/app/AppInterface
    //   829: astore 15
    //   831: aload 15
    //   833: ifnull -106 -> 727
    //   836: aload_0
    //   837: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   840: ifnull -113 -> 727
    //   843: iload 4
    //   845: sipush 1000
    //   848: if_icmpne +377 -> 1225
    //   851: aload_0
    //   852: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   855: getfield 275	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   858: lstore 10
    //   860: aload_0
    //   861: getfield 833	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_c_of_type_Long	J
    //   864: aload_0
    //   865: getfield 864	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_b_of_type_Long	J
    //   868: lsub
    //   869: lstore 12
    //   871: aconst_null
    //   872: invokestatic 869	bcxw:a	(Landroid/content/Context;)I
    //   875: istore 6
    //   877: new 612	java/util/HashMap
    //   880: dup
    //   881: invokespecial 613	java/util/HashMap:<init>	()V
    //   884: astore_3
    //   885: aload_3
    //   886: ldc_w 871
    //   889: lload 10
    //   891: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   894: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   897: pop
    //   898: aload_3
    //   899: ldc_w 615
    //   902: aload_0
    //   903: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   906: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   909: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   912: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   915: pop
    //   916: aload_3
    //   917: ldc_w 873
    //   920: iload 6
    //   922: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   925: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   928: pop
    //   929: aload 15
    //   931: invokevirtual 152	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   934: invokestatic 630	axrn:a	(Landroid/content/Context;)Laxrn;
    //   937: astore 14
    //   939: aload 15
    //   941: invokevirtual 633	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   944: astore 15
    //   946: lload 10
    //   948: lconst_0
    //   949: lcmp
    //   950: ifne +283 -> 1233
    //   953: iconst_1
    //   954: istore_2
    //   955: aload 14
    //   957: aload 15
    //   959: ldc_w 875
    //   962: iload_2
    //   963: lload 12
    //   965: lconst_0
    //   966: aload_3
    //   967: ldc 117
    //   969: iconst_0
    //   970: invokevirtual 638	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   973: lload 10
    //   975: lconst_0
    //   976: lcmp
    //   977: ifne +261 -> 1238
    //   980: iconst_0
    //   981: istore 4
    //   983: aload_0
    //   984: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   987: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   990: istore 7
    //   992: iload_1
    //   993: iconst_2
    //   994: if_icmpne +250 -> 1244
    //   997: aload_0
    //   998: getfield 99	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_Int	I
    //   1001: iconst_2
    //   1002: isub
    //   1003: istore 5
    //   1005: aconst_null
    //   1006: ldc_w 785
    //   1009: ldc_w 787
    //   1012: ldc_w 877
    //   1015: iload_1
    //   1016: iload 4
    //   1018: iconst_2
    //   1019: anewarray 400	java/lang/String
    //   1022: dup
    //   1023: iconst_0
    //   1024: iload 7
    //   1026: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1029: aastore
    //   1030: dup
    //   1031: iconst_1
    //   1032: iload 5
    //   1034: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1037: aastore
    //   1038: invokestatic 794	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1041: ldc_w 640
    //   1044: iconst_1
    //   1045: bipush 9
    //   1047: anewarray 4	java/lang/Object
    //   1050: dup
    //   1051: iconst_0
    //   1052: ldc_w 879
    //   1055: aastore
    //   1056: dup
    //   1057: iconst_1
    //   1058: lload 12
    //   1060: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1063: aastore
    //   1064: dup
    //   1065: iconst_2
    //   1066: ldc_w 649
    //   1069: aastore
    //   1070: dup
    //   1071: iconst_3
    //   1072: aload_0
    //   1073: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1076: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1079: invokestatic 572	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1082: aastore
    //   1083: dup
    //   1084: iconst_4
    //   1085: ldc_w 881
    //   1088: aastore
    //   1089: dup
    //   1090: iconst_5
    //   1091: lload 10
    //   1093: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1096: aastore
    //   1097: dup
    //   1098: bipush 6
    //   1100: ldc_w 883
    //   1103: aastore
    //   1104: dup
    //   1105: bipush 7
    //   1107: iload 6
    //   1109: invokestatic 572	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1112: aastore
    //   1113: dup
    //   1114: bipush 8
    //   1116: ldc_w 651
    //   1119: aastore
    //   1120: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1123: iconst_4
    //   1124: anewarray 4	java/lang/Object
    //   1127: dup
    //   1128: iconst_0
    //   1129: ldc_w 885
    //   1132: aastore
    //   1133: dup
    //   1134: iconst_1
    //   1135: lload 10
    //   1137: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1140: aastore
    //   1141: dup
    //   1142: iconst_2
    //   1143: ldc_w 887
    //   1146: aastore
    //   1147: dup
    //   1148: iconst_3
    //   1149: lload 12
    //   1151: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1154: aastore
    //   1155: invokestatic 720	ajac:a	([Ljava/lang/Object;)V
    //   1158: return
    //   1159: iload 7
    //   1161: istore_1
    //   1162: iload 8
    //   1164: istore 4
    //   1166: iload 9
    //   1168: istore 6
    //   1170: iload 8
    //   1172: istore 5
    //   1174: ldc 46
    //   1176: iconst_1
    //   1177: iconst_2
    //   1178: anewarray 4	java/lang/Object
    //   1181: dup
    //   1182: iconst_0
    //   1183: ldc_w 898
    //   1186: aastore
    //   1187: dup
    //   1188: iconst_1
    //   1189: aload 14
    //   1191: aastore
    //   1192: invokestatic 76	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1195: iconst_0
    //   1196: istore_1
    //   1197: goto -809 -> 388
    //   1200: iload 8
    //   1202: i2l
    //   1203: lstore 10
    //   1205: goto -776 -> 429
    //   1208: iconst_0
    //   1209: istore_2
    //   1210: goto -686 -> 524
    //   1213: iconst_1
    //   1214: istore 4
    //   1216: goto -664 -> 552
    //   1219: iconst_0
    //   1220: istore 5
    //   1222: goto -648 -> 574
    //   1225: iload 4
    //   1227: i2l
    //   1228: lstore 10
    //   1230: goto -370 -> 860
    //   1233: iconst_0
    //   1234: istore_2
    //   1235: goto -280 -> 955
    //   1238: iconst_1
    //   1239: istore 4
    //   1241: goto -258 -> 983
    //   1244: iconst_0
    //   1245: istore 5
    //   1247: goto -242 -> 1005
    //   1250: astore_3
    //   1251: iload 6
    //   1253: istore_1
    //   1254: iload 5
    //   1256: istore 4
    //   1258: aload_0
    //   1259: getfield 30	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   1262: invokevirtual 42	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1265: checkcast 148	com/tencent/common/app/AppInterface
    //   1268: astore 16
    //   1270: aload 16
    //   1272: ifnull +330 -> 1602
    //   1275: aload_0
    //   1276: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1279: ifnull +323 -> 1602
    //   1282: iload 4
    //   1284: sipush 1000
    //   1287: if_icmpne +317 -> 1604
    //   1290: aload_0
    //   1291: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1294: getfield 275	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:retCode	J
    //   1297: lstore 10
    //   1299: aload_0
    //   1300: getfield 833	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_c_of_type_Long	J
    //   1303: aload_0
    //   1304: getfield 864	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_b_of_type_Long	J
    //   1307: lsub
    //   1308: lstore 12
    //   1310: aconst_null
    //   1311: invokestatic 869	bcxw:a	(Landroid/content/Context;)I
    //   1314: istore 6
    //   1316: new 612	java/util/HashMap
    //   1319: dup
    //   1320: invokespecial 613	java/util/HashMap:<init>	()V
    //   1323: astore 14
    //   1325: aload 14
    //   1327: ldc_w 871
    //   1330: lload 10
    //   1332: invokestatic 535	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1335: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1338: pop
    //   1339: aload 14
    //   1341: ldc_w 615
    //   1344: aload_0
    //   1345: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1348: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1351: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1354: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1357: pop
    //   1358: aload 14
    //   1360: ldc_w 873
    //   1363: iload 6
    //   1365: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1368: invokevirtual 621	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1371: pop
    //   1372: aload 16
    //   1374: invokevirtual 152	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1377: invokestatic 630	axrn:a	(Landroid/content/Context;)Laxrn;
    //   1380: astore 15
    //   1382: aload 16
    //   1384: invokevirtual 633	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1387: astore 16
    //   1389: lload 10
    //   1391: lconst_0
    //   1392: lcmp
    //   1393: ifne +219 -> 1612
    //   1396: iconst_1
    //   1397: istore_2
    //   1398: aload 15
    //   1400: aload 16
    //   1402: ldc_w 875
    //   1405: iload_2
    //   1406: lload 12
    //   1408: lconst_0
    //   1409: aload 14
    //   1411: ldc 117
    //   1413: iconst_0
    //   1414: invokevirtual 638	axrn:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1417: lload 10
    //   1419: lconst_0
    //   1420: lcmp
    //   1421: ifne +196 -> 1617
    //   1424: iconst_0
    //   1425: istore 4
    //   1427: aload_0
    //   1428: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1431: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1434: istore 7
    //   1436: iload_1
    //   1437: iconst_2
    //   1438: if_icmpne +185 -> 1623
    //   1441: aload_0
    //   1442: getfield 99	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_Int	I
    //   1445: iconst_2
    //   1446: isub
    //   1447: istore 5
    //   1449: aconst_null
    //   1450: ldc_w 785
    //   1453: ldc_w 787
    //   1456: ldc_w 877
    //   1459: iload_1
    //   1460: iload 4
    //   1462: iconst_2
    //   1463: anewarray 400	java/lang/String
    //   1466: dup
    //   1467: iconst_0
    //   1468: iload 7
    //   1470: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1473: aastore
    //   1474: dup
    //   1475: iconst_1
    //   1476: iload 5
    //   1478: invokestatic 617	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1481: aastore
    //   1482: invokestatic 794	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1485: ldc_w 640
    //   1488: iconst_1
    //   1489: bipush 9
    //   1491: anewarray 4	java/lang/Object
    //   1494: dup
    //   1495: iconst_0
    //   1496: ldc_w 879
    //   1499: aastore
    //   1500: dup
    //   1501: iconst_1
    //   1502: lload 12
    //   1504: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1507: aastore
    //   1508: dup
    //   1509: iconst_2
    //   1510: ldc_w 649
    //   1513: aastore
    //   1514: dup
    //   1515: iconst_3
    //   1516: aload_0
    //   1517: getfield 34	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker:jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam	Lcom/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam;
    //   1520: getfield 122	com/tencent/mobileqq/apollo/cmgame/CmGameStartChecker$StartCheckParam:gameId	I
    //   1523: invokestatic 572	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1526: aastore
    //   1527: dup
    //   1528: iconst_4
    //   1529: ldc_w 881
    //   1532: aastore
    //   1533: dup
    //   1534: iconst_5
    //   1535: lload 10
    //   1537: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1540: aastore
    //   1541: dup
    //   1542: bipush 6
    //   1544: ldc_w 883
    //   1547: aastore
    //   1548: dup
    //   1549: bipush 7
    //   1551: iload 6
    //   1553: invokestatic 572	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1556: aastore
    //   1557: dup
    //   1558: bipush 8
    //   1560: ldc_w 651
    //   1563: aastore
    //   1564: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1567: iconst_4
    //   1568: anewarray 4	java/lang/Object
    //   1571: dup
    //   1572: iconst_0
    //   1573: ldc_w 885
    //   1576: aastore
    //   1577: dup
    //   1578: iconst_1
    //   1579: lload 10
    //   1581: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1584: aastore
    //   1585: dup
    //   1586: iconst_2
    //   1587: ldc_w 887
    //   1590: aastore
    //   1591: dup
    //   1592: iconst_3
    //   1593: lload 12
    //   1595: invokestatic 54	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1598: aastore
    //   1599: invokestatic 720	ajac:a	([Ljava/lang/Object;)V
    //   1602: aload_3
    //   1603: athrow
    //   1604: iload 4
    //   1606: i2l
    //   1607: lstore 10
    //   1609: goto -310 -> 1299
    //   1612: iconst_0
    //   1613: istore_2
    //   1614: goto -216 -> 1398
    //   1617: iconst_1
    //   1618: istore 4
    //   1620: goto -193 -> 1427
    //   1623: iconst_0
    //   1624: istore 5
    //   1626: goto -177 -> 1449
    //   1629: astore_3
    //   1630: goto -372 -> 1258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1633	0	this	CmGameStartChecker
    //   0	1633	1	paramInt	int
    //   0	1633	2	paramBoolean	boolean
    //   0	1633	3	paramBundle	Bundle
    //   4	1615	4	i	int
    //   1	1624	5	j	int
    //   17	1535	6	k	int
    //   10	1459	7	m	int
    //   26	1175	8	n	int
    //   7	1160	9	i1	int
    //   427	1181	10	l1	long
    //   438	1156	12	l2	long
    //   50	1360	14	localObject1	Object
    //   398	1001	15	localObject2	Object
    //   1268	133	16	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   19	28	789	java/lang/Exception
    //   43	52	789	java/lang/Exception
    //   67	78	789	java/lang/Exception
    //   93	111	789	java/lang/Exception
    //   126	138	789	java/lang/Exception
    //   153	160	789	java/lang/Exception
    //   175	183	789	java/lang/Exception
    //   207	215	789	java/lang/Exception
    //   230	237	789	java/lang/Exception
    //   252	261	789	java/lang/Exception
    //   276	291	789	java/lang/Exception
    //   306	320	789	java/lang/Exception
    //   335	352	789	java/lang/Exception
    //   367	385	789	java/lang/Exception
    //   743	767	789	java/lang/Exception
    //   782	786	789	java/lang/Exception
    //   1174	1195	789	java/lang/Exception
    //   19	28	1250	finally
    //   43	52	1250	finally
    //   67	78	1250	finally
    //   93	111	1250	finally
    //   126	138	1250	finally
    //   153	160	1250	finally
    //   175	183	1250	finally
    //   207	215	1250	finally
    //   230	237	1250	finally
    //   252	261	1250	finally
    //   276	291	1250	finally
    //   306	320	1250	finally
    //   335	352	1250	finally
    //   367	385	1250	finally
    //   743	767	1250	finally
    //   782	786	1250	finally
    //   1174	1195	1250	finally
    //   790	819	1629	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker
 * JD-Core Version:    0.7.0.1
 */