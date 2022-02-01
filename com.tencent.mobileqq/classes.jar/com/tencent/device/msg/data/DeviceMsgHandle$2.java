package com.tencent.device.msg.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.MsgPack;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MsgProxyBannerProcessor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.smartdevice.SmartDevicePluginDownloadActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class DeviceMsgHandle$2
  extends BroadcastReceiver
{
  DeviceMsgHandle$2(DeviceMsgHandle paramDeviceMsgHandle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst");
    Object localObject2 = Boolean.valueOf(false);
    long l1;
    int i;
    Object localObject1;
    Object localObject3;
    label999:
    Object localObject4;
    int j;
    long l2;
    Object localObject5;
    if (bool)
    {
      paramContext = paramIntent.getExtras();
      l1 = paramContext.getLong("deviceopdin", 0L);
      if (paramContext.getInt("deviceoprstcode", 0) == 0) {
        DeviceMsgHandle.a(this.a).getMessageFacade().a(Long.valueOf(l1).toString(), 9501);
      }
    }
    else if (paramIntent.getAction().equalsIgnoreCase("tencent.av.v2q.StartVideoChat"))
    {
      if (paramIntent.getStringExtra("peerUin") != null) {
        l1 = Long.parseLong(paramIntent.getStringExtra("peerUin"));
      } else {
        l1 = 0L;
      }
      paramContext = Long.valueOf(l1);
      if (paramContext.longValue() != 0L) {
        DeviceMsgHandle.a(this.a).add(paramContext);
      }
    }
    else if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceAdminUnbind"))
    {
      paramContext = Long.valueOf(paramIntent.getExtras().getLong("deviceopdin", 0L));
      if (DeviceMsgHandle.a(this.a).contains(paramContext) != true)
      {
        DeviceMsgHandle.a(this.a).getMessageFacade().a(paramContext.toString(), 9501);
        return;
      }
      if (paramContext.longValue() != 0L) {
        DeviceMsgHandle.b(this.a).add(paramContext);
      }
    }
    else if (paramIntent.getAction().equalsIgnoreCase("tencent.av.v2q.StopVideoChat"))
    {
      i = paramIntent.getIntExtra("stopReason", 0);
      paramContext = paramIntent.getStringExtra("selfUin");
      if (paramIntent.getStringExtra("peerUin") != null) {
        l1 = Long.parseLong(paramIntent.getStringExtra("peerUin"));
      } else {
        l1 = 0L;
      }
      paramIntent = Long.valueOf(l1);
      if ((i == 0) && (paramContext == null) && (paramIntent.longValue() != 0L) && (DeviceMsgHandle.b(this.a).contains(paramIntent)))
      {
        DeviceMsgHandle.a(this.a).getMessageFacade().a(paramIntent.toString(), 9501);
        DeviceMsgHandle.b(this.a).remove(paramIntent);
        return;
      }
      if (paramIntent.longValue() != 0L) {
        DeviceMsgHandle.a(this.a).remove(paramIntent);
      }
    }
    else
    {
      bool = paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveDPMsg");
      localObject1 = "";
      if (bool)
      {
        localObject2 = (DataPoint)paramIntent.getExtras().getParcelable("dataPoint");
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(DeviceMsgHandle.jdField_a_of_type_JavaLangString, 2, "dp is null in DeviceMsgHandler::onreceive");
          }
          return;
        }
        paramIntent = ((SmartDeviceProxyMgr)DeviceMsgHandle.a(this.a).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(((DataPoint)localObject2).mDin);
        if (paramIntent != null) {
          i = paramIntent.productId;
        } else {
          i = 0;
        }
        if ((11015 != ((DataPoint)localObject2).mProperityId) && (((DataPoint)localObject2).mProperityId != 11008) && (((DataPoint)localObject2).mProperityId != 11012))
        {
          if ((i == 0) && (((DataPoint)localObject2).mDin > 4294967295L)) {
            if (QLog.isColorLevel())
            {
              paramContext = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
              paramIntent = new StringBuilder();
              paramIntent.append("device info pid is 0; dp.mDin = ");
              paramIntent.append(((DataPoint)localObject2).mDin);
              QLog.d(paramContext, 2, paramIntent.toString());
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("device info pid is 0; dp.mDin = ");
          ((StringBuilder)localObject3).append(((DataPoint)localObject2).mDin);
          QLog.d(paramIntent, 2, ((StringBuilder)localObject3).toString());
        }
        if (10004 == ((DataPoint)localObject2).mProperityId)
        {
          this.a.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor.a((DataPoint)localObject2);
          if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
            break label6704;
          }
          DeviceMsgHandle.a(this.a);
          return;
        }
        if ((10012 != ((DataPoint)localObject2).mProperityId) && (11015 != ((DataPoint)localObject2).mProperityId))
        {
          if (11016 == ((DataPoint)localObject2).mProperityId) {
            try
            {
              paramContext = new JSONObject(((DataPoint)localObject2).mValue);
              l1 = paramContext.optLong("din");
              if (paramContext.optInt("flag") == 0)
              {
                paramContext = Message.obtain();
                paramContext.what = 3001;
                paramContext.obj = Long.valueOf(l1);
                BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 0, paramContext);
              }
              else
              {
                paramContext = paramContext.optString("remark", " ");
                paramIntent = Message.obtain();
                paramIntent.what = 3000;
                paramIntent.obj = new Pair(Long.valueOf(l1), paramContext);
                BannerManager.a().a(MsgProxyBannerProcessor.jdField_a_of_type_Int, 2, paramIntent);
              }
              paramContext = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
              paramIntent = new StringBuilder();
              paramIntent.append("PID_MSG_PROXY JSON :");
              paramIntent.append(((DataPoint)localObject2).mValue);
              QLog.d(paramContext, 2, paramIntent.toString());
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
          }
          if ((10003 != ((DataPoint)localObject2).mProperityId) && (10013 != ((DataPoint)localObject2).mProperityId))
          {
            if (10007 == ((DataPoint)localObject2).mProperityId)
            {
              paramContext = (Context)localObject1;
              try
              {
                paramIntent = new JSONObject(((DataPoint)localObject2).mValue);
                paramContext = (Context)localObject1;
                localObject3 = paramIntent.optString("ext_cmd", " ");
                paramContext = (Context)localObject1;
                paramIntent = paramIntent.optString("gray_flag", "");
                paramContext = paramIntent;
                if (!"OPT_DEV_AUTH_CONFIRM".equals(localObject3))
                {
                  paramContext = paramIntent;
                  if (!"OPT_DEV_AUTH_REQ".equals(localObject3))
                  {
                    paramContext = paramIntent;
                    bool = "TEXT_OF_11012".equals(localObject3);
                    paramContext = paramIntent;
                    if (!bool) {
                      break label999;
                    }
                  }
                }
                return;
              }
              catch (Exception paramIntent)
              {
                paramIntent.printStackTrace();
                if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals("1")))
                {
                  try
                  {
                    paramContext = new JSONObject(((DataPoint)localObject2).mValue);
                    paramContext.optLong("msg_time", MessageCache.a());
                    paramContext = paramContext.optString("text", " ");
                    this.a.a(String.valueOf(((DataPoint)localObject2).mDin), paramContext, MessageCache.a(), true, false, true);
                    return;
                  }
                  catch (Exception paramContext)
                  {
                    if (!QLog.isColorLevel()) {
                      break label6704;
                    }
                  }
                  paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("onRecvRawTextMsg parse from json error:");
                  ((StringBuilder)localObject1).append(paramContext.getMessage());
                  QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
                  return;
                }
                this.a.a((DataPoint)localObject2);
                SmartDeviceReport.a(DeviceMsgHandle.a(this.a), ((DataPoint)localObject2).mDin, "Usr_AIO_ReceiveMsg", 1, 0, i);
                if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
                  break label6704;
                }
              }
              DeviceMsgHandle.a(this.a);
              return;
            }
            if ((10011 != ((DataPoint)localObject2).mProperityId) && (10010 != ((DataPoint)localObject2).mProperityId))
            {
              if (10009 == ((DataPoint)localObject2).mProperityId)
              {
                try
                {
                  localObject4 = new JSONObject(((DataPoint)localObject2).mValue);
                  l1 = ((JSONObject)localObject4).getLong("from_uin");
                  if ((!TextUtils.isEmpty(DeviceMsgHandle.a(this.a).getCurrentAccountUin())) && (String.valueOf(l1).equals(DeviceMsgHandle.a(this.a).getCurrentAccountUin()))) {
                    return;
                  }
                  paramContext = ((JSONObject)localObject4).optString("media_key", "");
                  paramIntent = ((JSONObject)localObject4).optString("cover_key", "");
                  localObject1 = ((JSONObject)localObject4).optString("fkey2", "");
                  localObject3 = ((JSONObject)localObject4).optString("ckey2", "");
                  i = ((JSONObject)localObject4).optInt("duration", 0);
                  j = ((JSONObject)localObject4).optInt("csz_file_size", 0);
                  l2 = ((JSONObject)localObject4).getLong("to_din");
                  localObject4 = (MessageForDevLittleVideo)MessageRecordFactory.a(-4509);
                  ((MessageForDevLittleVideo)localObject4).msgtype = -4509;
                  ((MessageForDevLittleVideo)localObject4).istroop = 9501;
                  ((MessageForDevLittleVideo)localObject4).issend = 0;
                  ((MessageForDevLittleVideo)localObject4).isread = false;
                  ((MessageForDevLittleVideo)localObject4).selfuin = DeviceMsgHandle.a(this.a).getCurrentAccountUin();
                  ((MessageForDevLittleVideo)localObject4).senderuin = Long.toString(l1);
                  ((MessageForDevLittleVideo)localObject4).frienduin = Long.toString(l2);
                  ((MessageForDevLittleVideo)localObject4).videoFileStatus = 2001;
                  ((MessageForDevLittleVideo)localObject4).time = MessageCache.a();
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append(ContactUtils.a(DeviceMsgHandle.a(this.a), ((MessageForDevLittleVideo)localObject4).senderuin, true));
                  ((StringBuilder)localObject5).append(HardCodeUtil.a(2131703341));
                  ((MessageForDevLittleVideo)localObject4).msg = ((StringBuilder)localObject5).toString();
                  ((MessageForDevLittleVideo)localObject4).extStr = "device_groupchat";
                  ((MessageForDevLittleVideo)localObject4).thumbFileKey = paramIntent;
                  ((MessageForDevLittleVideo)localObject4).videoFileKey = paramContext;
                  ((MessageForDevLittleVideo)localObject4).fileKey2 = ((String)localObject1);
                  ((MessageForDevLittleVideo)localObject4).coverkey2 = ((String)localObject3);
                  ((MessageForDevLittleVideo)localObject4).videoFileTime = i;
                  ((MessageForDevLittleVideo)localObject4).videoFileSize = j;
                  ((MessageForDevLittleVideo)localObject4).videoFileFormat = 2;
                  ((MessageForDevLittleVideo)localObject4).videoFileProgress = 0;
                  ((MessageForDevLittleVideo)localObject4).serial();
                  DeviceMsgHandle.a(this.a).getMessageFacade().a((MessageRecord)localObject4, DeviceMsgHandle.a(this.a).getCurrentAccountUin());
                  if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
                    break label6704;
                  }
                  DeviceMsgHandle.a(this.a);
                  return;
                }
                catch (JSONException paramContext)
                {
                  if (!QLog.isColorLevel()) {
                    break label6704;
                  }
                }
                paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("getString from json error:");
                ((StringBuilder)localObject1).append(paramContext.getMessage());
                QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
                return;
              }
              if (((DataPoint)localObject2).mProperityId == 10008)
              {
                try
                {
                  if ((!TextUtils.isEmpty(DeviceMsgHandle.a(this.a).getCurrentAccountUin())) && (String.valueOf(((DataPoint)localObject2).mDin).equals(DeviceMsgHandle.a(this.a).getCurrentAccountUin()))) {
                    return;
                  }
                  paramIntent = new JSONObject(((DataPoint)localObject2).mValue);
                  paramContext = paramIntent.optString("senderDin", " ");
                  l1 = paramIntent.optLong("msg_time", MessageCache.a());
                  paramIntent = paramIntent.optString("text", " ");
                  l2 = ((DataPoint)localObject2).mDin;
                  DeviceMsgHandle.a(this.a, l2, paramContext, paramIntent, l1, true);
                  if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
                    break label6704;
                  }
                  DeviceMsgHandle.a(this.a);
                  return;
                }
                catch (Exception paramContext)
                {
                  if (!QLog.isColorLevel()) {
                    break label6704;
                  }
                }
                paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("onRecvRawTextMsg parse from json error:");
                ((StringBuilder)localObject1).append(paramContext.getMessage());
                QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
                return;
              }
              if (((DataPoint)localObject2).mProperityId != 10014) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!DeviceTipActivity.a)
        {
          localObject1 = new JSONObject(((DataPoint)localObject2).mValue);
          paramContext = String.valueOf(((DataPoint)localObject2).mDin);
          paramIntent = ((JSONObject)localObject1).optString("digest", "");
          l2 = ((JSONObject)localObject1).optLong("appear_time", MessageCache.a());
          localObject1 = SettingCloneUtil.readValue(DeviceMsgHandle.a(this.a).getApp(), DeviceMsgHandle.a(this.a).getCurrentAccountUin(), null, "account_login_success_time", "");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label6707;
          }
          l1 = Long.valueOf((String)localObject1).longValue();
          if (QLog.isColorLevel())
          {
            localObject3 = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("ReceiveDoorTip appear_time= ");
            ((StringBuilder)localObject4).append(l2);
            ((StringBuilder)localObject4).append(" : serverTime = ");
            ((StringBuilder)localObject4).append(MessageCache.a());
            ((StringBuilder)localObject4).append(" loginTimeStr= ");
            ((StringBuilder)localObject4).append((String)localObject1);
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
            i = (int)(MessageCache.a() - l2);
            localObject1 = DeviceMsgHandle.a(this.a).getApp();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(HardCodeUtil.a(2131703338));
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(HardCodeUtil.a(2131703340));
            QQToast.a((Context)localObject1, ((StringBuilder)localObject3).toString(), 1).a();
          }
          l1 -= l2;
          if (l1 > 1L)
          {
            if (QLog.isColorLevel())
            {
              paramIntent = DeviceMsgHandle.a(this.a).getApp();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("该消息是手Q登录前");
              ((StringBuilder)localObject1).append(l1);
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131703349));
              QQToast.a(paramIntent, ((StringBuilder)localObject1).toString(), 1).a();
            }
            this.a.a(paramContext, HardCodeUtil.a(2131703343), l2, "");
            return;
          }
          if (MessageCache.a() - l2 <= 30L)
          {
            localObject1 = new Intent(DeviceMsgHandle.a(this.a).getApp(), DeviceTipActivity.class);
            ((Intent)localObject1).setFlags(268435456);
            ((Intent)localObject1).putExtra("uin", paramContext);
            ((Intent)localObject1).putExtra("digest", paramIntent);
            DeviceMsgHandle.a(this.a).getApp().startActivity((Intent)localObject1);
          }
        }
        if (!DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue))
        {
          DeviceMsgHandle.a(this.a);
          return;
          if (((DataPoint)localObject2).mProperityId == 1600006)
          {
            try
            {
              paramContext = new JSONObject(((DataPoint)localObject2).mValue);
              paramIntent = paramContext.optString("digest", "");
              l1 = paramContext.optLong("msg_time", MessageCache.a());
              if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.trim()))) {
                this.a.a(Long.toString(((DataPoint)localObject2).mDin), paramIntent, l1, null);
              }
            }
            catch (Exception paramContext)
            {
              if (QLog.isColorLevel())
              {
                paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("onRecvRawTextMsg parse from json error:");
                ((StringBuilder)localObject1).append(paramContext.getMessage());
                QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
              }
            }
            if (!DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
              DeviceMsgHandle.a(this.a);
            }
          }
          else
          {
            String str1;
            if (((DataPoint)localObject2).mProperityId == 10004)
            {
              try
              {
                paramIntent = new JSONObject(((DataPoint)localObject2).mValue);
                paramIntent.optLong("msgSeq", 0L);
                localObject1 = paramIntent.optString("latitude");
                localObject3 = paramIntent.optString("longitude");
                localObject4 = paramIntent.optString("title");
                localObject5 = paramIntent.optString("summary");
                str1 = paramIntent.optString("dianpingId");
                l1 = paramIntent.optLong("msg_time", MessageCache.a());
                DeviceMsgHandle.a(this.a, paramContext, Long.toString(((DataPoint)localObject2).mDin), (String)localObject1, (String)localObject3, (String)localObject4, (String)localObject5, str1, l1);
                if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
                  continue;
                }
                DeviceMsgHandle.a(this.a);
                return;
              }
              catch (Exception paramContext)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
              }
              paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("onRecvRawTextMsg parse from json error:");
              ((StringBuilder)localObject1).append(paramContext.getMessage());
              QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
            }
            else if (((DataPoint)localObject2).mProperityId == 11010)
            {
              Object localObject6 = new JSONObject(((DataPoint)localObject2).mValue);
              paramContext = ((JSONObject)localObject6).optString("prompt", "");
              paramIntent = ((JSONObject)localObject6).getString("app");
              localObject1 = ((JSONObject)localObject6).getString("view");
              localObject3 = ((JSONObject)localObject6).optString("desc", "");
              localObject4 = ((JSONObject)localObject6).optString("ver", "");
              localObject5 = ((JSONObject)localObject6).optString("meta", "");
              str1 = ((JSONObject)localObject6).optString("config", "");
              String str2 = ((JSONObject)localObject6).optString("compatibleText", "");
              localObject6 = new SessionInfo();
              ((SessionInfo)localObject6).jdField_a_of_type_JavaLangString = Long.toString(((DataPoint)localObject2).mDin);
              ((SessionInfo)localObject6).b = "";
              ((SessionInfo)localObject6).jdField_a_of_type_Int = 9501;
              paramContext = new ArkAppMessage(paramContext, paramIntent, (String)localObject3, (String)localObject1, (String)localObject4, (String)localObject5, str1, str2);
              paramContext = MessageRecordFactory.a(DeviceMsgHandle.a(this.a), ((SessionInfo)localObject6).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject6).b, ((SessionInfo)localObject6).jdField_a_of_type_Int, paramContext);
              paramContext.istroop = 9501;
              paramContext.issend = 0;
              paramContext.isread = false;
              paramContext.selfuin = DeviceMsgHandle.a(this.a).getCurrentAccountUin();
              paramContext.senderuin = Long.toString(((DataPoint)localObject2).mDin);
              paramContext.frienduin = Long.toString(((DataPoint)localObject2).mDin);
              DeviceMsgHandle.a(this.a).getMessageFacade().a(paramContext, DeviceMsgHandle.a(this.a).getCurrentAccountUin());
              if (!DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
                DeviceMsgHandle.a(this.a);
              }
            }
            else if ((((DataPoint)localObject2).mProperityId != 11008) && (((DataPoint)localObject2).mProperityId != 11012))
            {
              if (((DataPoint)localObject2).mProperityId == 700154) {
                try
                {
                  paramIntent = new JSONObject(new JSONObject(((DataPoint)localObject2).mValue).optString("text"));
                  i = paramIntent.optInt("roomId");
                  paramContext = paramIntent.optString("sessionId");
                  j = paramIntent.optInt("cTime");
                  int k = paramIntent.optInt("cmd");
                  if (QLog.isColorLevel())
                  {
                    paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("openav roomId:");
                    ((StringBuilder)localObject1).append(i);
                    ((StringBuilder)localObject1).append(",sessionId:");
                    ((StringBuilder)localObject1).append(paramContext);
                    ((StringBuilder)localObject1).append(", cTime: ");
                    ((StringBuilder)localObject1).append(j);
                    ((StringBuilder)localObject1).append(", cmd:");
                    ((StringBuilder)localObject1).append(k);
                    QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
                  }
                  if (k != 1) {
                    continue;
                  }
                  paramIntent = new Intent(DeviceMsgHandle.a(this.a).getApp(), SmartDevicePluginDownloadActivity.class);
                  paramIntent.addFlags(268435456);
                  paramIntent.putExtra("KEY_OPENAV_ROOM_ID", i);
                  paramIntent.putExtra("device_id", String.valueOf(((DataPoint)localObject2).mDin));
                  paramIntent.putExtra("KEY_OPENAV_RECEIVE", true);
                  paramIntent.putExtra("KEY_OPENAV_SESSION_ID", paramContext);
                  paramIntent.putExtra("KEY_OPENAV_CTIME", j);
                  DeviceMsgHandle.a(this.a).getApp().startActivity(paramIntent);
                  return;
                }
                catch (Exception paramContext)
                {
                  paramContext.printStackTrace();
                  return;
                }
              }
            }
            else
            {
              try
              {
                paramContext = new JSONObject(((DataPoint)localObject2).mValue);
                SmartDeviceUtil.a(DeviceMsgHandle.a(this.a), paramContext, String.valueOf(((DataPoint)localObject2).mDin));
                if (DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue)) {
                  continue;
                }
                DeviceMsgHandle.a(this.a);
                return;
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
                if (!QLog.isColorLevel()) {
                  continue;
                }
              }
              paramIntent = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("auth_request_structmsg:");
              ((StringBuilder)localObject1).append(paramContext.getMessage());
              QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
              return;
              this.a.jdField_a_of_type_ComTencentDeviceMsgDataDeviceGroupChatMsgProcessor.a((DataPoint)localObject2);
              if (!DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue))
              {
                DeviceMsgHandle.a(this.a);
                return;
                this.a.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver.a((DataPoint)localObject2);
                SmartDeviceReport.a(DeviceMsgHandle.a(this.a), ((DataPoint)localObject2).mDin, "Usr_AIO_ReceiveMsg", 2, 0, i);
                if (!DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue))
                {
                  DeviceMsgHandle.a(this.a);
                  return;
                  this.a.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor.a((DataPoint)localObject2);
                  if (!DeviceMsgHandle.a(this.a, ((DataPoint)localObject2).mValue))
                  {
                    DeviceMsgHandle.a(this.a);
                    return;
                    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_sendCCDataPointMsgResult"))
                    {
                      paramContext = (MsgPack)paramIntent.getExtras().get("msgpack");
                      l1 = paramContext.uRecvUin;
                      bool = paramContext.bSendResult;
                      i = paramContext.dwMsgSequence;
                      if (bool)
                      {
                        DeviceMsgHandle.a(this.a, String.valueOf(l1), i);
                        return;
                      }
                      DeviceMsgHandle.b(this.a, String.valueOf(l1), i);
                      return;
                    }
                    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnMiniFileTransferProgress"))
                    {
                      paramContext = paramIntent.getExtras();
                      l1 = paramContext.getLong("cookie", 0L);
                      l2 = paramContext.getLong("progress", 0L);
                      long l3 = paramContext.getLong("total", 0L);
                      if ((l1 != 0L) && (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1))))
                      {
                        paramContext = (MessageRecord)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                        i = 0;
                      }
                      else
                      {
                        if ((l1 == 0L) || (!this.a.b.containsKey(Long.valueOf(l1)))) {
                          continue;
                        }
                        paramContext = (MessageRecord)this.a.b.get(Long.valueOf(l1));
                        i = 1;
                      }
                      if (((paramContext instanceof MessageForDevLittleVideo)) && (i != 0))
                      {
                        paramContext = (MessageForDevLittleVideo)paramContext;
                        paramContext.videoFileStatus = 2002;
                        double d1 = (float)l2;
                        Double.isNaN(d1);
                        double d2 = (float)l3;
                        Double.isNaN(d2);
                        d1 = d1 * 1.0D / d2;
                        paramContext.videoFileProgress = ((int)d1 * 100);
                        paramContext.serial();
                        DeviceMsgHandle.a(this.a).getMessageFacade().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                        this.a.a().b(paramContext, (float)d1);
                        return;
                      }
                    }
                    else
                    {
                      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnMiniFileTransferComplete"))
                      {
                        paramIntent = paramIntent.getExtras();
                        j = paramIntent.getInt("err_code", -1);
                        l1 = paramIntent.getLong("cookie", 0L);
                        if ((l1 != 0L) && (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l1))))
                        {
                          paramContext = (MessageRecord)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l1));
                          i = 0;
                        }
                        else
                        {
                          if ((l1 == 0L) || (!this.a.b.containsKey(Long.valueOf(l1)))) {
                            continue;
                          }
                          paramContext = (MessageRecord)this.a.b.get(Long.valueOf(l1));
                          i = 1;
                        }
                        if (j == 0)
                        {
                          localObject1 = paramIntent.getString("filepath");
                          paramIntent = new File((String)localObject1);
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
                          ((StringBuilder)localObject2).append("/smart_device/");
                          ((StringBuilder)localObject2).append(paramIntent.getName());
                          paramIntent = ((StringBuilder)localObject2).toString();
                          FileUtils.moveFile((String)localObject1, paramIntent);
                          if ((paramContext instanceof MessageForDeviceFile))
                          {
                            paramContext = (MessageForDeviceFile)paramContext;
                            paramContext.filePath = paramIntent;
                            paramContext.srcFileName = FileManagerUtil.a(paramIntent);
                            paramContext.fileSize = FileManagerUtil.a(paramIntent);
                            paramIntent = new StringBuilder();
                            paramIntent.append(ContactUtils.a(DeviceMsgHandle.a(this.a), paramContext.senderuin, true));
                            paramIntent.append(": ");
                            paramIntent.append(DeviceMsgHandle.a(this.a).getApp().getString(2131691563));
                            paramContext.msg = paramIntent.toString();
                            paramContext.serial();
                            DeviceMsgHandle.a(this.a).getMessageFacade().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                            this.a.a().a(paramContext, Boolean.valueOf(true));
                          }
                          else if ((paramContext instanceof MessageForDevLittleVideo))
                          {
                            paramContext = (MessageForDevLittleVideo)paramContext;
                            if (i != 0)
                            {
                              paramContext.videoFileName = paramIntent;
                              paramContext.videoFileStatus = 2003;
                              paramContext.serial();
                              DeviceMsgHandle.a(this.a).getMessageFacade().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                              this.a.a().b(paramContext, Boolean.valueOf(true));
                            }
                            else
                            {
                              paramContext.mThumbFilePath = paramIntent;
                              try
                              {
                                localObject1 = new BitmapFactory.Options();
                                ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(paramIntent, (BitmapFactory.Options)localObject1);
                                ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
                                paramContext.thumbWidth = ((BitmapFactory.Options)localObject1).outWidth;
                                paramContext.thumbHeight = ((BitmapFactory.Options)localObject1).outHeight;
                              }
                              catch (OutOfMemoryError paramIntent)
                              {
                                paramIntent.printStackTrace();
                              }
                              paramContext.serial();
                              DeviceMsgHandle.a(this.a).getMessageFacade().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                            }
                          }
                        }
                        else if ((paramContext instanceof MessageForDeviceFile))
                        {
                          paramContext = (MessageForDeviceFile)paramContext;
                          this.a.a().a(paramContext, (Boolean)localObject2);
                        }
                        else if (((paramContext instanceof MessageForDevLittleVideo)) && (i != 0))
                        {
                          paramContext = (MessageForDevLittleVideo)paramContext;
                          paramContext.videoFileProgress = 0;
                          paramContext.videoFileStatus = 2005;
                          paramContext.serial();
                          DeviceMsgHandle.a(this.a).getMessageFacade().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
                          this.a.a().b(paramContext, (Boolean)localObject2);
                        }
                        this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l1));
                        this.a.b.remove(Long.valueOf(l1));
                        return;
                        return;
                      }
                      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceVasFlagChange"))
                      {
                        paramIntent = paramIntent.getExtras();
                        if (paramIntent == null) {
                          return;
                        }
                        i = paramIntent.getInt("Flag", 0);
                        l1 = paramIntent.getLong("Din", 0L);
                        localObject1 = (SmartDeviceProxyMgr)DeviceMsgHandle.a(this.a).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
                        localObject2 = ((SmartDeviceProxyMgr)localObject1).a(l1);
                        if (localObject2 == null) {
                          return;
                        }
                        if (localObject2 != null) {
                          paramIntent = ((DeviceInfo)localObject2).serialNum;
                        } else {
                          paramIntent = "";
                        }
                        paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramIntent, "");
                        if (!StringUtil.a(paramIntent))
                        {
                          paramContext = paramIntent;
                          if (!paramIntent.equals("0")) {}
                        }
                        else
                        {
                          paramIntent = DeviceMsgHandle.a(this.a).getApp().getString(2131694657).split(":")[0];
                          paramContext = paramIntent;
                          if (((DeviceInfo)localObject2).isAdmin != 1)
                          {
                            ((SmartDeviceProxyMgr)localObject1).a(((DeviceInfo)localObject2).productId, ((DeviceInfo)localObject2).serialNum);
                            paramContext = paramIntent;
                          }
                        }
                        if ((i == 1) && (((DeviceInfo)localObject2).isAdmin != 1))
                        {
                          com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.H = true;
                          paramIntent = new StringBuilder();
                          paramIntent.append(paramContext);
                          paramIntent.append(DeviceMsgHandle.a(this.a).getApp().getString(2131691536));
                          paramContext = paramIntent.toString();
                          paramIntent = this.a;
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append(l1);
                          ((StringBuilder)localObject1).append("");
                          paramIntent.a(((StringBuilder)localObject1).toString(), paramContext, MessageCache.a(), true, false, 1);
                          return;
                        }
                        if ((i == 0) && (((DeviceInfo)localObject2).isAdmin != 1))
                        {
                          com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.H = false;
                          paramIntent = new StringBuilder();
                          paramIntent.append(paramContext);
                          paramIntent.append(DeviceMsgHandle.a(this.a).getApp().getString(2131691535));
                          paramContext = paramIntent.toString();
                          paramIntent = this.a;
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append(l1);
                          ((StringBuilder)localObject1).append("");
                          paramIntent.a(((StringBuilder)localObject1).toString(), paramContext, MessageCache.a(), true, false, true);
                        }
                      }
                      else if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_QueryIsDeviceBinded"))
                      {
                        paramIntent = paramIntent.getExtras();
                        if (paramIntent != null)
                        {
                          l1 = paramIntent.getLong("AdminBinderUin", 0L);
                          paramIntent = paramIntent.getString("DeviceSerialNum");
                          localObject1 = DeviceMsgHandle.a(this.a);
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append(l1);
                          ((StringBuilder)localObject2).append("");
                          localObject1 = ContactUtils.a((AppRuntime)localObject1, ((StringBuilder)localObject2).toString(), true);
                          PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString(paramIntent, (String)localObject1).commit();
                        }
                      }
                      else if (paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyJoin"))
                      {
                        paramContext = paramIntent.getExtras();
                        localObject2 = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
                        localObject3 = Long.valueOf(paramContext.getLong("deviceopuin", 0L));
                        paramIntent = (SmartDeviceProxyMgr)DeviceMsgHandle.a(this.a).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
                        localObject1 = paramIntent.a(((Long)localObject2).longValue());
                        if (localObject1 == null) {
                          return;
                        }
                        paramContext = paramIntent.a(((DeviceInfo)localObject1).productId);
                        if (paramContext == null) {
                          return;
                        }
                        if (paramIntent.a(((Long)localObject2).longValue()).booleanValue())
                        {
                          paramContext = HardCodeUtil.a(2131703351);
                        }
                        else if (((DeviceInfo)localObject1).isAdmin == 1)
                        {
                          paramIntent = new StringBuilder();
                          paramIntent.append(HardCodeUtil.a(2131703348));
                          paramIntent.append(paramContext.deviceName);
                          paramContext = paramIntent.toString();
                        }
                        else
                        {
                          paramContext = "";
                        }
                        if (!TextUtils.isEmpty(paramContext))
                        {
                          localObject1 = ContactUtils.a(DeviceMsgHandle.a(this.a), Long.toString(((Long)localObject3).longValue()), true);
                          paramIntent = (Intent)localObject1;
                          if (TextUtils.isEmpty((CharSequence)localObject1)) {
                            paramIntent = String.valueOf(localObject3);
                          }
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append(paramIntent);
                          ((StringBuilder)localObject1).append(paramContext);
                          paramContext = ((StringBuilder)localObject1).toString();
                          paramIntent = this.a;
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append(localObject2);
                          ((StringBuilder)localObject1).append("");
                          paramIntent.a(((StringBuilder)localObject1).toString(), paramContext, MessageCache.a(), true, false, true);
                        }
                      }
                      else if ((!paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyQuit")) && (!paramIntent.getAction().equalsIgnoreCase("DeviceSomebodyReject")))
                      {
                        if ("SmartDevice_DeviceBindRst".equals(paramIntent.getAction()))
                        {
                          if (paramIntent.getExtras().getInt("deviceoprstcode") == 0)
                          {
                            localObject1 = (SmartDeviceProxyMgr)DeviceMsgHandle.a(this.a).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
                            l1 = paramIntent.getExtras().getLong("deviceopdin", 0L);
                            if ((localObject1 != null) && (((SmartDeviceProxyMgr)localObject1).a(l1, 13))) {
                              return;
                            }
                            if (EquipmentLockImpl.a().a(DeviceMsgHandle.a(this.a), paramContext) != 0)
                            {
                              paramIntent = this.a;
                              localObject2 = new StringBuilder();
                              ((StringBuilder)localObject2).append(l1);
                              ((StringBuilder)localObject2).append("");
                              paramIntent.a(((StringBuilder)localObject2).toString(), "【重要！设备安全提醒】\n\n为防止QQ号被盗/丢失手机，导致设备被人恶意控制\n请点这里开启QQ设备锁\n\n\n查看QQ设备锁介绍", MessageCache.a(), "device_lock_msg");
                            }
                            if (localObject1 == null) {
                              return;
                            }
                            localObject2 = ((SmartDeviceProxyMgr)localObject1).a(l1);
                            if (localObject2 != null) {
                              paramIntent = ((DeviceInfo)localObject2).serialNum;
                            } else {
                              paramIntent = "";
                            }
                            paramIntent = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramIntent, "");
                            if (!StringUtil.a(paramIntent))
                            {
                              paramContext = paramIntent;
                              if (!paramIntent.equals("0")) {}
                            }
                            else
                            {
                              paramIntent = DeviceMsgHandle.a(this.a).getApp().getString(2131694657).split(":")[0];
                              paramContext = paramIntent;
                              if (localObject2 != null)
                              {
                                paramContext = paramIntent;
                                if (((DeviceInfo)localObject2).isAdmin != 1)
                                {
                                  ((SmartDeviceProxyMgr)localObject1).a(((DeviceInfo)localObject2).productId, ((DeviceInfo)localObject2).serialNum);
                                  paramContext = paramIntent;
                                }
                              }
                            }
                            if ((localObject2 != null) && (((DeviceInfo)localObject2).isAdmin != 1) && (((SmartDeviceProxyMgr)localObject1).a(l1).booleanValue()))
                            {
                              paramIntent = new StringBuilder();
                              paramIntent.append(paramContext);
                              paramIntent.append(DeviceMsgHandle.a(this.a).getApp().getString(2131691536));
                              paramContext = paramIntent.toString();
                              paramIntent = this.a;
                              localObject1 = new StringBuilder();
                              ((StringBuilder)localObject1).append(l1);
                              ((StringBuilder)localObject1).append("");
                              paramIntent.a(((StringBuilder)localObject1).toString(), paramContext, MessageCache.a(), true, false, 1);
                            }
                          }
                        }
                        else if ("On_OccupyMicrophoneNotify_Push".equals(paramIntent.getAction()))
                        {
                          if (QLog.isColorLevel())
                          {
                            paramContext = DeviceMsgHandle.jdField_a_of_type_JavaLangString;
                            localObject1 = new StringBuilder();
                            ((StringBuilder)localObject1).append("DeviceMsghandle intent.getExtras() : ");
                            ((StringBuilder)localObject1).append(paramIntent.getExtras());
                            QLog.d(paramContext, 2, ((StringBuilder)localObject1).toString());
                          }
                          paramContext = paramIntent.getExtras();
                          paramIntent = Long.valueOf(paramContext.getLong("din", 0L));
                          localObject1 = paramContext.getString("uin");
                          if ((paramIntent.longValue() != 0L) && (!TextUtils.isEmpty((CharSequence)localObject1)))
                          {
                            paramContext = ContactUtils.a(DeviceMsgHandle.a(this.a), (String)localObject1, true);
                            if ((!TextUtils.isEmpty(paramContext)) && (!((String)localObject1).equals(paramContext)))
                            {
                              localObject1 = new StringBuilder();
                              ((StringBuilder)localObject1).append(paramContext);
                              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131703347));
                              paramContext = ((StringBuilder)localObject1).toString();
                            }
                            else
                            {
                              paramContext = HardCodeUtil.a(2131703358);
                            }
                            this.a.a(String.valueOf(paramIntent), paramContext, MessageCache.a(), "");
                            DeviceMsgHandle.a(this.a);
                          }
                        }
                        else
                        {
                          if ("SmartDevice_sendToAIO_Capture".equals(paramIntent.getAction()))
                          {
                            paramIntent = paramIntent.getExtras();
                            paramContext = paramIntent.getString("uin");
                            localObject1 = paramIntent.getString("path");
                            localObject2 = new JSONObject();
                            ((JSONObject)localObject2).put("msg_time", MessageCache.a());
                            ((JSONObject)localObject2).put("guidewords", HardCodeUtil.a(2131703345));
                            ((JSONObject)localObject2).put("appear_time", MessageCache.a());
                            ((JSONObject)localObject2).put("digest", HardCodeUtil.a(2131703354));
                            ((JSONObject)localObject2).put("title", HardCodeUtil.a(2131703357));
                            paramIntent = (MessageForDeviceSingleStruct)MessageRecordFactory.a(-4502);
                            paramIntent.msgtype = -4502;
                            paramIntent.istroop = 9501;
                            paramIntent.issend = 0;
                            paramIntent.isread = false;
                            paramIntent.selfuin = DeviceMsgHandle.a(this.a).getCurrentAccountUin();
                            paramIntent.senderuin = paramContext;
                            paramIntent.frienduin = paramContext;
                            paramIntent.strCoverPath = ((String)localObject1);
                            paramIntent.strMediaPath = ((String)localObject1);
                            paramIntent.strMediaFileName = FileManagerUtil.a((String)localObject1);
                            paramIntent.parseFromJson(((JSONObject)localObject2).toString());
                            paramIntent.msg = paramIntent.strDigest;
                            paramIntent.nMediaFileStatus = 5;
                            paramIntent.nDataType = 1;
                            paramContext = new ArrayList();
                            paramContext.add(paramIntent);
                            DeviceMsgHandle.a(this.a, paramContext);
                            return;
                          }
                          if ("SmartDevice_sendToAIO_Mp4".equals(paramIntent.getAction()))
                          {
                            localObject3 = paramIntent.getExtras();
                            paramContext = ((Bundle)localObject3).getString("uin");
                            paramIntent = ((Bundle)localObject3).getString("path");
                            localObject1 = ((Bundle)localObject3).getString("imagepath");
                            localObject2 = ((Bundle)localObject3).getString("digest");
                            localObject4 = ((Bundle)localObject3).getString("title");
                            localObject3 = new JSONObject();
                            ((JSONObject)localObject3).put("msg_time", MessageCache.a());
                            ((JSONObject)localObject3).put("guidewords", HardCodeUtil.a(2131703356));
                            ((JSONObject)localObject3).put("appear_time", MessageCache.a());
                            ((JSONObject)localObject3).put("digest", localObject2);
                            ((JSONObject)localObject3).put("title", localObject4);
                            ((JSONObject)localObject3).put("data_type", "VIDEO");
                            ((JSONObject)localObject3).put("cover_url", localObject1);
                            localObject2 = (MessageForDeviceSingleStruct)MessageRecordFactory.a(-4502);
                            ((MessageForDeviceSingleStruct)localObject2).msgtype = -4502;
                            ((MessageForDeviceSingleStruct)localObject2).istroop = 9501;
                            ((MessageForDeviceSingleStruct)localObject2).issend = 0;
                            ((MessageForDeviceSingleStruct)localObject2).isread = false;
                            ((MessageForDeviceSingleStruct)localObject2).selfuin = DeviceMsgHandle.a(this.a).getCurrentAccountUin();
                            ((MessageForDeviceSingleStruct)localObject2).senderuin = paramContext;
                            ((MessageForDeviceSingleStruct)localObject2).frienduin = paramContext;
                            ((MessageForDeviceSingleStruct)localObject2).strCoverPath = ((String)localObject1);
                            ((MessageForDeviceSingleStruct)localObject2).strMediaPath = paramIntent;
                            ((MessageForDeviceSingleStruct)localObject2).nDataType = 2;
                            ((MessageForDeviceSingleStruct)localObject2).strMediaFileName = FileManagerUtil.a(paramIntent);
                            ((MessageForDeviceSingleStruct)localObject2).nMediaFileSize = FileUtils.getFileSizes(paramIntent);
                            ((MessageForDeviceSingleStruct)localObject2).nMediaFileStatus = 5;
                            ((MessageForDeviceSingleStruct)localObject2).parseFromJson(((JSONObject)localObject3).toString());
                            ((MessageForDeviceSingleStruct)localObject2).msg = ((MessageForDeviceSingleStruct)localObject2).strDigest;
                            paramContext = new ArrayList();
                            paramContext.add(localObject2);
                            DeviceMsgHandle.a(this.a, paramContext);
                          }
                        }
                      }
                      else
                      {
                        paramContext = paramIntent.getExtras();
                        localObject2 = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
                        localObject3 = Long.valueOf(paramContext.getLong("deviceopuin", 0L));
                        paramContext = (SmartDeviceProxyMgr)DeviceMsgHandle.a(this.a).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
                        paramIntent = paramContext.a(((Long)localObject2).longValue());
                        if (paramIntent == null) {
                          return;
                        }
                        if (paramContext.a(paramIntent.productId) == null) {
                          return;
                        }
                        if (paramContext.a(((Long)localObject2).longValue()).booleanValue()) {
                          paramContext = HardCodeUtil.a(2131703339);
                        } else {
                          paramContext = "";
                        }
                        if (!TextUtils.isEmpty(paramContext))
                        {
                          localObject1 = ContactUtils.a(DeviceMsgHandle.a(this.a), Long.toString(((Long)localObject3).longValue()), true);
                          paramIntent = (Intent)localObject1;
                          if (TextUtils.isEmpty((CharSequence)localObject1)) {
                            paramIntent = String.valueOf(localObject3);
                          }
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append(paramIntent);
                          ((StringBuilder)localObject1).append(paramContext);
                          paramContext = ((StringBuilder)localObject1).toString();
                          paramIntent = this.a;
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append(localObject2);
                          ((StringBuilder)localObject1).append("");
                          paramIntent.a(((StringBuilder)localObject1).toString(), paramContext, MessageCache.a(), true, false, true);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label6704:
        return;
      }
      catch (Exception paramContext)
      {
        return;
      }
      label6707:
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle.2
 * JD-Core Version:    0.7.0.1
 */