package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.AppBehavior;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.ControlRspHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadInfoReq;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadInfoRsp;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.PreloadResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PreloadInfoCheckUpdateItem
  implements CheckUpdateItemInterface
{
  QQAppInterface a;
  
  public PreloadInfoCheckUpdateItem(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private boolean a(GameCenterManagerImp paramGameCenterManagerImp, String paramString)
  {
    boolean bool = false;
    if (paramGameCenterManagerImp == null) {
      return false;
    }
    if (paramGameCenterManagerImp.a(paramString) != -1) {
      bool = true;
    }
    return bool;
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadInfoCheckUpdateItem", 2, "getCheckUpdateItemData");
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_check_update_interval");
    ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
    paramInt = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 259200);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_last_check_update_timestamp");
    ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
    int i = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
    int j = (int)(System.currentTimeMillis() / 1000L);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getPreloadInfo:lastCheckTime=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",nowSystemTime=");
      ((StringBuilder)localObject2).append(j);
      QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject2).toString());
    }
    if ((j - i <= paramInt) && (j >= i)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadInfoCheckUpdateItem", 2, "getPreloadInfo:start send check update new info update time.");
    }
    localObject2 = ((SharedPreferences)localObject1).edit();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("key_last_check_update_timestamp");
    ((StringBuilder)localObject3).append(this.a.getCurrentAccountUin());
    ((SharedPreferences.Editor)localObject2).putInt(((StringBuilder)localObject3).toString(), (int)(System.currentTimeMillis() / 1000L)).commit();
    localObject2 = new ReqItem();
    ((ReqItem)localObject2).eServiceID = 123;
    localObject3 = new PreloadInfoCheckUpdate.PreloadInfoReq();
    Object localObject4 = new PreloadInfoCheckUpdate.ControlReqHead();
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject4).protocol_ver.set(1);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject4).client_plat_id.set(109);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject4).client_ver.set("8.8.17");
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject4).os_ver.set(Build.VERSION.SDK);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject4).uin.set(this.a.getLongAccountUin());
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject4).mem.set((int)DeviceInfoUtil.a() / 1048576);
    ((PreloadInfoCheckUpdate.ControlReqHead)localObject4).ext1.set("nothing");
    ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject3).head.set((MessageMicro)localObject4);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("key_web_plugin_list");
    ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
    Object localObject5 = SharedPreferencesHandler.a((SharedPreferences)localObject1, ((StringBuilder)localObject4).toString(), null);
    if ((localObject5 != null) && (!((Set)localObject5).isEmpty()))
    {
      localObject4 = (GameCenterManagerImp)this.a.getManager(QQManagerFactory.GAMECENTER_MANAGER);
      localObject5 = ((Set)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        PreloadInfoCheckUpdate.AppBehavior localAppBehavior = new PreloadInfoCheckUpdate.AppBehavior();
        localAppBehavior.appid.set(Integer.parseInt(str));
        PBInt32Field localPBInt32Field = localAppBehavior.click_num;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_web_plugin_click_num");
        localStringBuilder.append(str);
        localStringBuilder.append(this.a.getCurrentAccountUin());
        localPBInt32Field.set(((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), 0));
        localPBInt32Field = localAppBehavior.click_red_num;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_web_plugin_click_red_num");
        localStringBuilder.append(str);
        localStringBuilder.append(this.a.getCurrentAccountUin());
        localPBInt32Field.set(((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), 0));
        localPBInt32Field = localAppBehavior.red_state;
        if (a((GameCenterManagerImp)localObject4, str)) {
          paramInt = 2;
        } else {
          paramInt = 1;
        }
        localPBInt32Field.set(paramInt);
        ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject3).app_behavior.add(localAppBehavior);
      }
    }
    localObject1 = ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject3).toByteArray();
    paramInt = localObject1.length;
    i = paramInt + 4;
    localObject3 = new byte[i];
    System.arraycopy(EndianUtil.b(i), 0, localObject3, 0, 4);
    System.arraycopy(localObject1, 0, localObject3, 4, paramInt);
    ((ReqItem)localObject2).vecParam = ((byte[])localObject3);
    return localObject2;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int i = paramRespItem.cResult;
      paramRespItem = paramRespItem.vecUpdate;
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleCheckUpdateItemData result=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(",dataLen=");
        ((StringBuilder)localObject1).append(paramRespItem.length);
        QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject1).toString());
      }
      if (i == 2) {
        try
        {
          if (paramRespItem.length <= 4) {
            return;
          }
          i = (int)PkgTools.getLongData(paramRespItem, 0) - 4;
          Object localObject2 = new byte[i];
          PkgTools.copyData((byte[])localObject2, 0, paramRespItem, 4, i);
          localObject1 = new PreloadInfoCheckUpdate.PreloadInfoRsp();
          ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).mergeFrom((byte[])localObject2);
          paramRespItem = (PreloadInfoCheckUpdate.ControlRspHead)((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).head.get();
          if (paramRespItem == null) {
            return;
          }
          i = paramRespItem.code.get();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("PreloadInfoCheckUpdateItem preloadInfoRsp data code=");
            ((StringBuilder)localObject2).append(i);
            QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject2).toString());
          }
          if (i == 0)
          {
            paramRespItem = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).edit();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("key_preload_strategy");
            ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
            paramRespItem.putInt(((StringBuilder)localObject2).toString(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload_switch.get());
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("preload_switch=");
              ((StringBuilder)localObject2).append(((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload_switch.get());
              QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject2).toString());
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("key_preload_flag");
            ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
            paramRespItem.putBoolean(((StringBuilder)localObject2).toString(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload.get());
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("preload=");
              ((StringBuilder)localObject2).append(((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload.get());
              QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject2).toString());
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("key_check_update_interval");
            ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
            paramRespItem.putInt(((StringBuilder)localObject2).toString(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).interval.get());
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("interval=");
              ((StringBuilder)localObject2).append(((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).interval.get());
              QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject2).toString());
            }
            Object localObject3 = ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).applist.get();
            Object localObject4;
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              localObject2 = new HashSet();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                ((Set)localObject2).add(localObject4);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("key_web_plugin_click_num");
                localStringBuilder.append((String)localObject4);
                localStringBuilder.append(this.a.getCurrentAccountUin());
                paramRespItem.putInt(localStringBuilder.toString(), 0);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("key_web_plugin_click_red_num");
                localStringBuilder.append((String)localObject4);
                localStringBuilder.append(this.a.getCurrentAccountUin());
                paramRespItem.putInt(localStringBuilder.toString(), 0);
              }
              localObject2 = ((Set)localObject2).toArray();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("key_web_plugin_list");
              ((StringBuilder)localObject3).append(this.a.getCurrentAccountUin());
              SharedPreferencesHandler.a(paramRespItem, ((StringBuilder)localObject3).toString(), (Object[])localObject2);
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("key_red_ram");
            ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
            paramRespItem.putInt(((StringBuilder)localObject2).toString(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).red_ram.get());
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("red_ram=");
              ((StringBuilder)localObject2).append(((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).red_ram.get());
              QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject2).toString());
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("key_click_ram");
            ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
            paramRespItem.putInt(((StringBuilder)localObject2).toString(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).click_ram.get());
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("click_ram=");
              ((StringBuilder)localObject2).append(((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).click_ram.get());
              QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject2).toString());
            }
            localObject2 = ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload_result.get();
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("ppp_profile", 4).edit();
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (PreloadInfoCheckUpdate.PreloadResult)((Iterator)localObject2).next();
                i = ((PreloadInfoCheckUpdate.PreloadResult)localObject3).appid.get();
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(i);
                ((StringBuilder)localObject4).append("preload_switch");
                ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
                ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject4).toString(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).preload_switch.get());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(i);
                ((StringBuilder)localObject4).append("preload");
                ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
                ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject4).toString(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).preload.get());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(i);
                ((StringBuilder)localObject4).append("preload_data");
                ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
                ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject4).toString(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).preload_data.get());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(i);
                ((StringBuilder)localObject4).append("mem_limit");
                ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
                ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject4).toString(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).mem_limit.get());
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(i);
                ((StringBuilder)localObject4).append("ext1");
                ((StringBuilder)localObject4).append(this.a.getCurrentAccountUin());
                ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject4).toString(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).ext1.get());
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("key_last_check_update_timestamp");
            ((StringBuilder)localObject1).append(this.a.getCurrentAccountUin());
            paramRespItem.putInt(((StringBuilder)localObject1).toString(), (int)(System.currentTimeMillis() / 1000L));
            paramRespItem.commit();
            ((IWebProcessManagerService)this.a.getRuntimeService(IWebProcessManagerService.class, "")).updatePreloadWebProcessFlag();
            paramRespItem = (ILebaHelperService)this.a.getRuntimeService(ILebaHelperService.class, "");
            paramRespItem.updateBuffer();
            paramRespItem.notifyRefreshWebProcess();
            return;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("PreloadInfoCheckUpdateItem preloadInfoRsp erro msg=");
          ((StringBuilder)localObject1).append(paramRespItem.err_msg.get());
          QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject1).toString());
          return;
        }
        catch (Throwable paramRespItem)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("PreloadInfoCheckUpdateItem Exception msg=");
            ((StringBuilder)localObject1).append(paramRespItem.getMessage());
            QLog.d("PreloadInfoCheckUpdateItem", 2, ((StringBuilder)localObject1).toString());
          }
          paramRespItem.printStackTrace();
          return;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem handleCheckUpdateItemData respitem is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */