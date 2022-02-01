package com.tencent.mobileqq.apollo.view.hippy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionServlet;
import com.tencent.mobileqq.apollo.model.CmBattleGameInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.cmshow.game.OpenGameBox.StBoxItem;
import trpc.cmshow.game.OpenGameBox.StOpenGameBoxReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/view/hippy/CmBattleGameDataRequest;", "", "()V", "KEY_CM_BATTLE_GAME_HIPPY", "", "REQUEST_INTERVAL", "", "SP_KEY_REQUEST_INTERVAL", "SP_KEY_REQUEST_TIME", "TAG", "filterGameData", "", "Lcom/tencent/mobileqq/apollo/model/CmBattleGameInfo;", "sceneId", "", "gameStyle", "gameDataList", "getCmBattleGameDataFromDB", "appInterface", "Lcom/tencent/common/app/AppInterface;", "getCmBattleGameDataFromNet", "", "dataListener", "Lcom/tencent/mobileqq/apollo/view/hippy/ICmBattleGameDataListener;", "getFollowingCount", "gameInfoList", "isCmBattleGameDataValid", "", "saveCmBattleGameDataRequestInterval", "interval", "saveCmBattleGameDataRequestTime", "stBoxItem2CmBattleGame", "stBoxItem", "Ltrpc/cmshow/game/OpenGameBox$StBoxItem;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmBattleGameDataRequest
{
  public static final CmBattleGameDataRequest a = new CmBattleGameDataRequest();
  
  private final CmBattleGameInfo a(int paramInt1, int paramInt2, OpenGameBox.StBoxItem paramStBoxItem)
  {
    CmBattleGameInfo localCmBattleGameInfo = new CmBattleGameInfo();
    localCmBattleGameInfo.sceneId = paramInt1;
    localCmBattleGameInfo.gameStyle = paramInt2;
    localCmBattleGameInfo.appid = paramStBoxItem.appid.get();
    localCmBattleGameInfo.avatar = paramStBoxItem.avatar.get();
    localCmBattleGameInfo.name = paramStBoxItem.name.get();
    localCmBattleGameInfo.gamerRange = paramStBoxItem.gamer_range.get();
    localCmBattleGameInfo.background = paramStBoxItem.background.get();
    localCmBattleGameInfo.footerIcon = paramStBoxItem.footer_icon.get();
    localCmBattleGameInfo.adId = paramStBoxItem.ad_id.get();
    localCmBattleGameInfo.boxType = paramStBoxItem.box_type.get();
    localCmBattleGameInfo.hallJumpUrl = paramStBoxItem.hall_jump_url.get();
    localCmBattleGameInfo.miniappJumpUrl = paramStBoxItem.miniapp_jump_url.get();
    localCmBattleGameInfo.appDesc = paramStBoxItem.app_desc.get();
    return localCmBattleGameInfo;
  }
  
  private final void b(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_cm_battle_game_request_time");
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(paramInt2);
    localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis()).apply();
  }
  
  @Nullable
  public final List<CmBattleGameInfo> a(int paramInt1, int paramInt2, @Nullable List<? extends CmBattleGameInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (!(paramList instanceof ArrayList)) {
      paramList = CollectionsKt.toMutableList((Collection)paramList);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      CmBattleGameInfo localCmBattleGameInfo = (CmBattleGameInfo)localIterator.next();
      if ((localCmBattleGameInfo.sceneId != paramInt1) || (localCmBattleGameInfo.gameStyle != paramInt2)) {
        localIterator.remove();
      }
    }
    return paramList;
  }
  
  @Nullable
  public final List<CmBattleGameInfo> a(@NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "appInterface");
    paramAppInterface = paramAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "appInterface.getRuntimeS…ava, ProcessConstant.ALL)");
    paramAppInterface = (IApolloDaoManagerService)paramAppInterface;
    try
    {
      paramAppInterface = paramAppInterface.getCmBattleGameInfoList();
      return paramAppInterface;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("CmBattleGameDataRequest", 1, "getCmBattleGameDataFromDB error!", paramAppInterface);
    }
    return null;
  }
  
  public final void a(@NotNull AppInterface paramAppInterface, int paramInt1, int paramInt2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "appInterface");
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_cm_battle_game_request_interval");
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(paramInt2);
    localEditor.putLong(localStringBuilder.toString(), paramLong).apply();
  }
  
  public final void a(@NotNull AppInterface paramAppInterface, int paramInt1, int paramInt2, @NotNull ICmBattleGameDataListener paramICmBattleGameDataListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "appInterface");
    Intrinsics.checkParameterIsNotNull(paramICmBattleGameDataListener, "dataListener");
    if (paramInt1 < 0)
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("[getCmBattleGameDataFromNet] invalid sceneId ");
      paramAppInterface.append(paramInt1);
      QLog.e("CmBattleGameDataRequest", 1, paramAppInterface.toString());
      return;
    }
    paramAppInterface.addObserver((BusinessObserver)new CmBattleGameDataRequest.getCmBattleGameDataFromNet.1(paramAppInterface, paramInt1, paramInt2, paramICmBattleGameDataListener), true);
    try
    {
      paramICmBattleGameDataListener = new StringBuilder();
      paramICmBattleGameDataListener.append("[getCmBattleGameDataFromNet] sceneId = ");
      paramICmBattleGameDataListener.append(paramInt1);
      paramICmBattleGameDataListener.append(", gameStyle=");
      paramICmBattleGameDataListener.append(paramInt2);
      QLog.d("CmBattleGameDataRequest", 1, paramICmBattleGameDataListener.toString());
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
      paramICmBattleGameDataListener = new WebSSOAgent.UniSsoServerReq();
      paramICmBattleGameDataListener.comm.set((MessageMicro)localObject);
      localObject = new OpenGameBox.StOpenGameBoxReq();
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(Integer.valueOf(paramInt1));
      ((OpenGameBox.StOpenGameBoxReq)localObject).scene_ids.set((List)localArrayList);
      ((OpenGameBox.StOpenGameBoxReq)localObject).app_style.set(paramInt2);
      paramICmBattleGameDataListener.pbReqData.set(ByteStringMicro.copyFrom(((OpenGameBox.StOpenGameBoxReq)localObject).toByteArray()));
      localObject = new NewIntent((Context)paramAppInterface.getApp(), ApolloExtensionServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_light.cmshow_game_linkcmd_open_game_box");
      ((NewIntent)localObject).putExtra("data", paramICmBattleGameDataListener.toByteArray());
      ((NewIntent)localObject).putExtra("scene", paramInt1);
      ((NewIntent)localObject).putExtra("cm_battle_game_hippy", true);
      paramAppInterface.startServlet((NewIntent)localObject);
      long l = System.currentTimeMillis();
      ApolloUtilImpl.saveApolloPanelBattleGameLastRequestTime((AppRuntime)paramAppInterface, paramInt1, l);
      return;
    }
    catch (Exception paramAppInterface)
    {
      paramICmBattleGameDataListener = new StringBuilder();
      paramICmBattleGameDataListener.append("[getCmBattleGameDataFromNet] sceneId = ");
      paramICmBattleGameDataListener.append(paramInt1);
      paramICmBattleGameDataListener.append(", exception = ");
      QLog.e("CmBattleGameDataRequest", 1, paramICmBattleGameDataListener.toString(), (Throwable)paramAppInterface);
    }
  }
  
  public final void a(@NotNull AppInterface paramAppInterface, int paramInt1, int paramInt2, @NotNull List<? extends CmBattleGameInfo> paramList, @NotNull ICmBattleGameDataListener paramICmBattleGameDataListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "appInterface");
    Intrinsics.checkParameterIsNotNull(paramList, "gameInfoList");
    Intrinsics.checkParameterIsNotNull(paramICmBattleGameDataListener, "dataListener");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((CmBattleGameInfo)localIterator.next()).appid);
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).batchGetFollowingCount(localArrayList, (MiniAppCmdInterface)new CmBattleGameDataRequest.getFollowingCount.2(paramList, paramICmBattleGameDataListener, paramAppInterface, paramInt1, paramInt2));
  }
  
  public final boolean a(@NotNull AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "appInterface");
    Object localObject = BaseApplicationImpl.getContext();
    boolean bool = false;
    localObject = ((BaseApplication)localObject).getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_cm_battle_game_request_time");
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(paramInt2);
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_cm_battle_game_request_interval");
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(paramInt2);
    long l2 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 300000L);
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("requestTime=");
      paramAppInterface.append(l1);
      paramAppInterface.append(", interval=");
      paramAppInterface.append(l2);
      paramAppInterface.append(", currentTime=");
      paramAppInterface.append(System.currentTimeMillis());
      QLog.d("CmBattleGameDataRequest", 2, paramAppInterface.toString());
    }
    if (System.currentTimeMillis() - l1 > l2) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CmBattleGameDataRequest
 * JD-Core Version:    0.7.0.1
 */