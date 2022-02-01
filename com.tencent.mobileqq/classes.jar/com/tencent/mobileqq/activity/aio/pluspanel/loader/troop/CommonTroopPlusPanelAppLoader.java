package com.tencent.mobileqq.activity.aio.pluspanel.loader.troop;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.filter.TroopCommonTeensModeFilter;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader.ScribbleResMgrShowConfig;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluspanel.appinfo.AppInfoFactory;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CommonTroopPlusPanelAppLoader
  extends TroopPlusPanelAppLoader
{
  private final int[] f = { 1104864054, 1200000003, 1104651886, 1106658188, 1107930043, 1104864062, 100719166, 1104864064, 1101487426, 1104864066, 1104864068, 1104864070, 1104788679, 1101678813, 1104536706, 1200000002, 1200000008 };
  
  public CommonTroopPlusPanelAppLoader()
  {
    a(new TroopCommonTeensModeFilter());
  }
  
  private long a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    paramSessionInfo = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramSessionInfo.b);
    boolean bool = paramSessionInfo.isTroopOwner(paramQQAppInterface.getCurrentUin());
    return (paramSessionInfo.isAdmin() & true) << true | (bool & true) << true | 0x1;
  }
  
  private void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reloadTroop, local, troopAppInfos[");
      ((StringBuilder)localObject).append(this.f.length);
      ((StringBuilder)localObject).append("]");
      QLog.w("CommonTroopPlusPanelStrategy", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject[i];
      if ((k != 1106114157) || (this.e.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface.getCurrentAccountUin()))) {
        a(paramBaseChatPie.ah.a, k);
      }
      i += 1;
    }
  }
  
  private boolean a(long paramLong, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    if ((!TextUtils.isEmpty(paramTroopAIOAppInfo.minVersion)) && (AppSetting.b(paramTroopAIOAppInfo.minVersion) < 0)) {
      return true;
    }
    if ((paramTroopAIOAppInfo.identifyMask & paramLong) == 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(".troop.troop_appCommonTroopPlusPanelStrategy", 1, new Object[] { "reloadTroop, appInfo is filtered: info: ", String.valueOf(paramTroopAIOAppInfo), " userIdentify: ", Long.toBinaryString(paramLong) });
      }
      return true;
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    int m = this.b.a.size();
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = this.b.a.keyAt(j);
      if (paramTroopAIOAppInfo.appid == k) {
        if ((k == 1106114157) && (!this.e.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface.getCurrentAccountUin())))
        {
          i = 1;
        }
        else
        {
          b(this.b.b(paramTroopAIOAppInfo, paramInt));
          k = 1;
          break;
        }
      }
      j += 1;
    }
    if (k == 0) {
      b(this.b.a(paramTroopAIOAppInfo, paramInt));
    }
    return paramBoolean;
  }
  
  @Nullable
  private List<TroopAIOAppInfo> b(@NotNull SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((ITroopAioAppService)paramQQAppInterface.getRuntimeService(ITroopAioAppService.class, "")).getAppsFromCache(GroupUtil.a(paramSessionInfo.b));
    paramSessionInfo = paramQQAppInterface;
    if (QQAudioHelper.b())
    {
      paramSessionInfo = paramQQAppInterface;
      if (QQAudioHelper.b(4) == 1)
      {
        QQAudioHelper.a(HardCodeUtil.a(2131906084));
        paramSessionInfo = null;
      }
    }
    return paramSessionInfo;
  }
  
  void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong, List<TroopAIOAppInfo> paramList)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reloadTroop, server, troopAppInfos[");
      ((StringBuilder)localObject).append(paramList.size());
      ((StringBuilder)localObject).append("]");
      QLog.w("CommonTroopPlusPanelStrategy", 1, ((StringBuilder)localObject).toString());
    }
    boolean bool = false;
    a(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (TroopAIOAppInfo)paramList.next();
      if (!a(paramLong, (TroopAIOAppInfo)localObject)) {
        bool = a(paramQQAppInterface, paramInt, bool, (TroopAIOAppInfo)localObject);
      }
    }
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    Object localObject = paramBaseChatPie.ah;
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    long l = a((SessionInfo)localObject, localQQAppInterface);
    localObject = b((SessionInfo)localObject, localQQAppInterface);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      QLog.d("CommonTroopPlusPanelStrategy", 1, new Object[] { "fillAppList get server config size: ", Integer.valueOf(((List)localObject).size()) });
      a(localQQAppInterface, paramBaseChatPie.ah.a, l, (List)localObject);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fillAppList local, troopAppInfos[");
    ((StringBuilder)localObject).append(this.f.length);
    ((StringBuilder)localObject).append("]");
    QLog.d("CommonTroopPlusPanelStrategy", 1, ((StringBuilder)localObject).toString());
    a(paramBaseChatPie, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.troop.CommonTroopPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */