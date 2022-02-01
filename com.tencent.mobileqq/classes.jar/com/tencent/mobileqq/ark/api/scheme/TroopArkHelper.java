package com.tencent.mobileqq.ark.api.scheme;

import KQQ.BatchResponse;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageCmd;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopArkHelper
{
  private static List<String> c = new ArrayList();
  private static TroopArkHelper d = new TroopArkHelper();
  String a = null;
  TroopObserver b = new TroopArkHelper.2(this);
  
  public static TroopArkHelper a()
  {
    return d;
  }
  
  private void a(String paramString, TroopInfoData paramTroopInfoData)
  {
    QQAppInterface localQQAppInterface = b();
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", localQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("troop_uin", paramString);
    localIntent.putExtra("forward_location", paramTroopInfoData.troopLocation);
    localIntent.putExtra("forward_latitude", paramTroopInfoData.troopLat);
    localIntent.putExtra("forward_longitude", paramTroopInfoData.troopLon);
    localIntent.putExtra("forward_cityid", paramTroopInfoData.cityId);
    localIntent.putExtra("key_qidian_private_troop", paramTroopInfoData.isQidianPrivateTroop);
    paramString = TroopBaseProxyActivity.a(BaseActivity.sTopActivity);
    paramTroopInfoData = new TroopManageCmd(localQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramTroopInfoData);
    }
    TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.j, TroopManageProxyActivity.class, BaseActivity.sTopActivity, localIntent, paramString, "com.tencent.mobileqq.activity.TroopManageActivity", localQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  protected void a(BatchResponse paramBatchResponse, TroopInfoData paramTroopInfoData, TroopInfo paramTroopInfo)
  {
    Object localObject1;
    if (paramBatchResponse != null)
    {
      if (paramBatchResponse.result != 0) {
        return;
      }
      localObject1 = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])paramBatchResponse.buffer);
        if ((paramBatchResponse.seq == 0) && (((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.has()))
        {
          paramBatchResponse = ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.get().toByteArray();
          try
          {
            localObject1 = new oidb_0x88d.RspBody();
            ((oidb_0x88d.RspBody)localObject1).mergeFrom(paramBatchResponse);
            localList = ((oidb_0x88d.RspBody)localObject1).stzrspgroupinfo.get();
            if (localList == null) {
              i = 0;
            } else {
              i = localList.size();
            }
          }
          catch (Exception paramBatchResponse)
          {
            List localList;
            int i;
            Object localObject2;
            int k;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.troopdisband.", 2, paramBatchResponse.toString());
          }
          if ((localObject1 == null) && (j < i))
          {
            localObject2 = (oidb_0x88d.RspGroupInfo)localList.get(j);
            if (localObject2 == null)
            {
              paramBatchResponse = (BatchResponse)localObject1;
            }
            else
            {
              k = ((oidb_0x88d.RspGroupInfo)localObject2).uint32_result.get();
              if ((k == 72) && (j == 0))
              {
                QQToast.makeText(BaseActivity.sTopActivity, 2131890186, 1).show(BaseActivity.sTopActivity.getTitleBarHeight());
                paramBatchResponse = (BatchResponse)localObject1;
              }
              else
              {
                paramBatchResponse = (BatchResponse)localObject1;
                if (k == 0)
                {
                  paramBatchResponse = (BatchResponse)localObject1;
                  if (((oidb_0x88d.RspGroupInfo)localObject2).stgroupinfo.has())
                  {
                    localObject1 = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject2).stgroupinfo.get();
                    paramBatchResponse = (BatchResponse)localObject1;
                    if (localObject1 != null)
                    {
                      paramBatchResponse = (BatchResponse)localObject1;
                      if (paramTroopInfoData != null)
                      {
                        paramTroopInfoData.coverFrom((oidb_0x88d.GroupInfo)localObject1);
                        if (QLog.isColorLevel())
                        {
                          k = ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext3.get();
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append("ChatSettingForToop_handle88dResp, troopUin=");
                          if (paramTroopInfoData == null) {
                            paramBatchResponse = "";
                          } else {
                            paramBatchResponse = paramTroopInfoData.troopUin;
                          }
                          ((StringBuilder)localObject2).append(paramBatchResponse);
                          ((StringBuilder)localObject2).append(", flagExt3=");
                          ((StringBuilder)localObject2).append(k);
                          ((StringBuilder)localObject2).append(", isQidianPrivateTroop=");
                          ((StringBuilder)localObject2).append(TroopInfo.isQidianPrivateTroop(k));
                          QLog.d(".troop.qidian_private_troop", 2, ((StringBuilder)localObject2).toString());
                        }
                        if (paramTroopInfo != null)
                        {
                          paramTroopInfo.coverFrom((oidb_0x88d.GroupInfo)localObject1);
                          paramTroopInfoData.newTroopName = paramTroopInfo.getTroopDisplayName();
                        }
                        paramTroopInfoData.isQidianPrivateTroop = TroopInfo.isQidianPrivateTroop(((oidb_0x88d.GroupInfo)localObject1).uint32_group_flagext3.get());
                        paramBatchResponse = (BatchResponse)localObject1;
                        if (paramTroopInfo != null)
                        {
                          paramBatchResponse = (BatchResponse)localObject1;
                          if (paramTroopInfoData.isMember)
                          {
                            ThreadManager.post(new TroopArkHelper.3(this, paramTroopInfo), 5, null, false);
                            paramBatchResponse = (BatchResponse)localObject1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            j += 1;
            localObject1 = paramBatchResponse;
            continue;
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBatchResponse)
      {
        paramBatchResponse.printStackTrace();
      }
      return;
      localObject1 = null;
      int j = 0;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.a = new JSONObject(paramString).optString("gc");
      if (TextUtils.isEmpty(this.a))
      {
        QLog.e("ark.Troop", 1, "troopUin empty!");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ark.Troop", 1, "json error!", paramString);
      paramString = b();
      TroopPluginManager localTroopPluginManager = (TroopPluginManager)paramString.getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER);
      TroopInfo localTroopInfo = ((TroopManager)paramString.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.a);
      if ((localTroopInfo != null) && (localTroopInfo.isAdmin()))
      {
        localTroopPluginManager.a("troop_manage_plugin.apk", new TroopArkHelper.1(this, paramString));
        return;
      }
      QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131912473), 0).show();
    }
  }
  
  public QQAppInterface b()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TroopArkHelper
 * JD-Core Version:    0.7.0.1
 */