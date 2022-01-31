package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.webprocess.WebProcessManager;
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
    if (paramGameCenterManagerImp == null) {}
    while (paramGameCenterManagerImp.a(paramString) == -1) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return 3;
  }
  
  public ReqItem a()
  {
    ReqItem localReqItem = null;
    if (QLog.isColorLevel()) {
      QLog.d("PreloadInfoCheckUpdateItem", 2, "getCheckUpdateItemData");
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
    int i = ((SharedPreferences)localObject1).getInt("key_check_update_interval" + this.a.getCurrentAccountUin(), 259200);
    int j = ((SharedPreferences)localObject1).getInt("key_last_check_update_timestamp" + this.a.getCurrentAccountUin(), 0);
    int k = (int)(System.currentTimeMillis() / 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadInfoCheckUpdateItem", 2, "getPreloadInfo:lastCheckTime=" + j + ",nowSystemTime=" + k);
    }
    if ((k - j > i) || (k < j))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadInfoCheckUpdateItem", 2, "getPreloadInfo:start send check update new info update time.");
      }
      ((SharedPreferences)localObject1).edit().putInt("key_last_check_update_timestamp" + this.a.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L)).commit();
      localReqItem = new ReqItem();
      localReqItem.eServiceID = 123;
      Object localObject2 = new PreloadInfoCheckUpdate.PreloadInfoReq();
      Object localObject3 = new PreloadInfoCheckUpdate.ControlReqHead();
      ((PreloadInfoCheckUpdate.ControlReqHead)localObject3).protocol_ver.set(1);
      ((PreloadInfoCheckUpdate.ControlReqHead)localObject3).client_plat_id.set(109);
      ((PreloadInfoCheckUpdate.ControlReqHead)localObject3).client_ver.set("7.6.0");
      ((PreloadInfoCheckUpdate.ControlReqHead)localObject3).os_ver.set(Build.VERSION.SDK);
      ((PreloadInfoCheckUpdate.ControlReqHead)localObject3).uin.set(this.a.getLongAccountUin());
      ((PreloadInfoCheckUpdate.ControlReqHead)localObject3).mem.set((int)DeviceInfoUtil.e() / 1048576);
      ((PreloadInfoCheckUpdate.ControlReqHead)localObject3).ext1.set("nothing");
      ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject2).head.set((MessageMicro)localObject3);
      Object localObject4 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "key_web_plugin_list" + this.a.getCurrentAccountUin(), null);
      if ((localObject4 != null) && (!((Set)localObject4).isEmpty()))
      {
        localObject3 = (GameCenterManagerImp)this.a.getManager(11);
        localObject4 = ((Set)localObject4).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          String str = (String)((Iterator)localObject4).next();
          PreloadInfoCheckUpdate.AppBehavior localAppBehavior = new PreloadInfoCheckUpdate.AppBehavior();
          localAppBehavior.appid.set(Integer.parseInt(str));
          localAppBehavior.click_num.set(((SharedPreferences)localObject1).getInt("key_web_plugin_click_num" + str + this.a.getCurrentAccountUin(), 0));
          localAppBehavior.click_red_num.set(((SharedPreferences)localObject1).getInt("key_web_plugin_click_red_num" + str + this.a.getCurrentAccountUin(), 0));
          PBInt32Field localPBInt32Field = localAppBehavior.red_state;
          if (a((GameCenterManagerImp)localObject3, str)) {}
          for (i = 2;; i = 1)
          {
            localPBInt32Field.set(i);
            ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject2).app_behavior.add(localAppBehavior);
            break;
          }
        }
      }
      localObject1 = ((PreloadInfoCheckUpdate.PreloadInfoReq)localObject2).toByteArray();
      i = localObject1.length;
      j = i + 4;
      localObject2 = new byte[j];
      System.arraycopy(EndianUtil.b(j), 0, localObject2, 0, 4);
      System.arraycopy(localObject1, 0, localObject2, 4, i);
      localReqItem.vecParam = ((byte[])localObject2);
    }
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      i = paramRespItem.cResult;
      localObject1 = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadInfoCheckUpdateItem", 2, "handleCheckUpdateItemData result=" + i + ",dataLen=" + localObject1.length);
      }
      if (i == 2) {
        try
        {
          if (localObject1.length > 4)
          {
            i = (int)PkgTools.a((byte[])localObject1, 0);
            paramRespItem = new byte[i - 4];
            PkgTools.a(paramRespItem, 0, (byte[])localObject1, 4, i - 4);
            localObject1 = new PreloadInfoCheckUpdate.PreloadInfoRsp();
            ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).mergeFrom(paramRespItem);
            if (localObject1 != null)
            {
              paramRespItem = (PreloadInfoCheckUpdate.ControlRspHead)((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).head.get();
              if (paramRespItem != null)
              {
                i = paramRespItem.code.get();
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem preloadInfoRsp data code=" + i);
                }
                if (i != 0) {
                  break label1188;
                }
                paramRespItem = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).edit();
                paramRespItem.putInt("key_preload_strategy" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload_switch.get());
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "preload_switch=" + ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload_switch.get());
                }
                paramRespItem.putBoolean("key_preload_flag" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload.get());
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "preload=" + ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).preload.get());
                }
                paramRespItem.putInt("key_check_update_interval" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).interval.get());
                if (QLog.isColorLevel()) {
                  QLog.d("PreloadInfoCheckUpdateItem", 2, "interval=" + ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).interval.get());
                }
                localObject3 = ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).applist.get();
                if ((localObject3 == null) || (((List)localObject3).isEmpty())) {
                  break label651;
                }
                localObject2 = new HashSet();
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  str = (String)((Iterator)localObject3).next();
                  ((Set)localObject2).add(str);
                  paramRespItem.putInt("key_web_plugin_click_num" + str + this.a.getCurrentAccountUin(), 0);
                  paramRespItem.putInt("key_web_plugin_click_red_num" + str + this.a.getCurrentAccountUin(), 0);
                }
              }
            }
          }
          return;
        }
        catch (Exception paramRespItem)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem Exception msg=" + paramRespItem.getMessage());
          }
          paramRespItem.printStackTrace();
        }
      }
    }
    label651:
    label1188:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          int i;
          Object localObject1;
          Object localObject3;
          String str;
          Object localObject2 = ((Set)localObject2).toArray();
          SharedPreferencesHandler.a(paramRespItem, "key_web_plugin_list" + this.a.getCurrentAccountUin(), (Object[])localObject2);
          paramRespItem.putInt("key_red_ram" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).red_ram.get());
          if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "red_ram=" + ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).red_ram.get());
          }
          paramRespItem.putInt("key_click_ram" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).click_ram.get());
          if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "click_ram=" + ((PreloadInfoCheckUpdate.PreloadInfoRsp)localObject1).click_ram.get());
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
              ((SharedPreferences.Editor)localObject1).putInt(i + "preload_switch" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).preload_switch.get());
              ((SharedPreferences.Editor)localObject1).putBoolean(i + "preload" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).preload.get());
              ((SharedPreferences.Editor)localObject1).putBoolean(i + "preload_data" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).preload_data.get());
              ((SharedPreferences.Editor)localObject1).putInt(i + "mem_limit" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).mem_limit.get());
              ((SharedPreferences.Editor)localObject1).putString(i + "ext1" + this.a.getCurrentAccountUin(), ((PreloadInfoCheckUpdate.PreloadResult)localObject3).ext1.get());
            }
          }
          paramRespItem.putInt("key_last_check_update_timestamp" + this.a.getCurrentAccountUin(), (int)(System.currentTimeMillis() / 1000L));
          paramRespItem.commit();
          paramRespItem = (WebProcessManager)this.a.getManager(12);
        } while (paramRespItem == null);
        paramRespItem.a();
        paramRespItem.b();
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem preloadInfoRsp erro msg=" + paramRespItem.err_msg.get());
      return;
    }
    QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem handleCheckUpdateItemData respitem is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PreloadInfoCheckUpdateItem
 * JD-Core Version:    0.7.0.1
 */