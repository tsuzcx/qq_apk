package com.tencent.biz.troop;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.associations.AllianceItem;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.troop.TroopManageCmd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class TroopMemberApiService$4
  extends TroopBusinessObserver
{
  TroopMemberApiService$4(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void onGetMaxTroopAdminNum(boolean paramBoolean, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.B);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(6));
    this.a.a(3, localBundle);
  }
  
  public void onGetPayToJoinTroopStatus(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.ai);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { paramString1, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), paramString2 });
    localBundle.putSerializable("observer_type", Integer.valueOf(6));
    localBundle.putString("processName", paramString2);
    this.a.a(3, localBundle);
  }
  
  public void onGetRelatedTroopList(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.ci);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong), paramAllianceItem });
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    localBundle.putSerializable("observer_type", Integer.valueOf(6));
    this.a.a(3, localBundle);
  }
  
  public void onGetTroopAppList(Boolean paramBoolean)
  {
    ArrayList localArrayList;
    if ((paramBoolean.booleanValue()) && (this.a.a))
    {
      paramBoolean = (TroopAppMgr)TroopMemberApiService.a(this.a).getManager(QQManagerFactory.TROOP_APP_MGR);
      localArrayList = new ArrayList();
      if (paramBoolean != null)
      {
        localObject = paramBoolean.a(false, 0);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label148;
        }
        localObject = ((List)localObject).iterator();
        TroopAIOAppInfo localTroopAIOAppInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
          localArrayList.add(Integer.valueOf(localTroopAIOAppInfo.appid));
        } while (localTroopAIOAppInfo.appid != this.a.d);
        QQToast.a(BaseApplication.getContext(), 2, 2131720033, 0).b(this.a.getResources().getDimensionPixelSize(2131299166));
      }
    }
    return;
    label148:
    localArrayList.add(Integer.valueOf(this.a.d));
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Integer.valueOf(this.a.d));
    paramBoolean.a(localArrayList, (ArrayList)localObject);
  }
  
  public void onGetTroopMemberMaxNum(boolean paramBoolean, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.ab);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(6));
    this.a.a(3, localBundle);
  }
  
  public void onGetUinByOpenId(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.aG);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("appid", paramInt1);
    localBundle.putString("openId", paramString1);
    localBundle.putString("token", paramString2);
    localBundle.putInt("seq", paramInt2);
    localBundle.putInt("retCode", paramInt3);
    localBundle.putString("uin", paramString3);
    if ((paramAllInOne != null) && ((!TextUtils.isEmpty(paramAllInOne.h)) || (!TextUtils.isEmpty(paramAllInOne.i))))
    {
      paramBoolean = true;
      localBundle.putBoolean("isFriend", paramBoolean);
      if (paramAllInOne != null) {
        break label165;
      }
      paramString1 = "";
      label124:
      localBundle.putString("nickName", paramString1);
      if (paramAllInOne != null) {
        break label174;
      }
    }
    label165:
    label174:
    for (paramString1 = "";; paramString1 = paramAllInOne.i)
    {
      localBundle.putString("remark", paramString1);
      this.a.a(60, localBundle);
      return;
      paramBoolean = false;
      break;
      paramString1 = paramAllInOne.h;
      break label124;
    }
  }
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.l);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramTroopInfo });
    localBundle.putSerializable("observer_type", Integer.valueOf(6));
    localBundle.putString("processName", "com.tencent.mobileqq:troopmanage");
    this.a.a(3, localBundle);
  }
  
  public void onNotifyTroopUpgradeSuccess(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.aa);
    localBundle.putBoolean("isSuccess", true);
    localBundle.putSerializable("data", new Object[] { paramString, Integer.valueOf(paramInt) });
    localBundle.putSerializable("observer_type", Integer.valueOf(6));
    this.a.a(3, localBundle);
  }
  
  public void onOIDB0X88D_0_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    paramTroopInfo = new TroopManageCmd((QQAppInterface)TroopMemberApiService.b(this.a));
    paramString = PluginCommunicationHandler.getInstance();
    if (paramString != null) {
      paramString.register(paramTroopInfo);
    }
    paramTroopInfo = new Bundle();
    paramTroopInfo.putBoolean("isSuccess", paramBoolean);
    paramTroopInfo.putInt("seq", ((Integer)paramArrayOfObject[0]).intValue());
    paramTroopInfo.putString("processName", (String)paramArrayOfObject[1]);
    this.a.a(59, paramTroopInfo);
  }
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.A);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), paramTroopInfo, Integer.valueOf(paramInt2), paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(6));
    this.a.a(3, localBundle);
  }
  
  public void onSortedTroopAppList(Boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", this.a.e);
    localBundle.putInt("type", TroopNotificationConstants.av);
    localBundle.putBoolean("isSuccess", paramBoolean.booleanValue());
    this.a.a(44, localBundle);
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.f);
    localBundle.putBoolean("isSuccess", false);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localBundle.putSerializable("observer_type", Integer.valueOf(8));
    this.a.a(3, localBundle);
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", TroopNotificationConstants.f);
    localBundle.putBoolean("isSuccess", true);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    localBundle.putSerializable("observer_type", Integer.valueOf(8));
    this.a.a(3, localBundle);
  }
  
  public void onTroopOpenApiVerifyed(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5)
  {
    paramString3 = new Bundle();
    paramString3.putInt("type", TroopNotificationConstants.at);
    paramString3.putBoolean("isSuccess", paramBoolean);
    paramString3.putInt("appid", paramInt1);
    paramString3.putString("openGroupId", paramString1);
    paramString3.putString("token", paramString2);
    paramString3.putInt("freq", paramInt2);
    paramString3.putInt("expireTime", paramInt3);
    paramString3.putStringArrayList("apilist", paramArrayList);
    paramString3.putInt("seq", paramInt4);
    paramString3.putInt("retCode", paramInt5);
    this.a.a(28, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.4
 * JD-Core Version:    0.7.0.1
 */