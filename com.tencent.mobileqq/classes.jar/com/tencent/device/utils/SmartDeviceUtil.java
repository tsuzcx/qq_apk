package com.tencent.device.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.SmartDeviceServlet;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.CgiReq;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.CommonHead;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.ReqBody;

public class SmartDeviceUtil
{
  public static String a(DeviceInfo paramDeviceInfo)
  {
    if (paramDeviceInfo == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramDeviceInfo.remark)) {
      return paramDeviceInfo.remark;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((SmartDeviceProxyMgr)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramDeviceInfo.productId);
      if ((localObject != null) && (!TextUtils.isEmpty(((ProductInfo)localObject).deviceName))) {
        return ((ProductInfo)localObject).deviceName;
      }
    }
    if (!TextUtils.isEmpty(paramDeviceInfo.name)) {
      return paramDeviceInfo.name;
    }
    if (paramDeviceInfo.din > 0L) {
      return String.valueOf(paramDeviceInfo.din);
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, DeviceInfo paramDeviceInfo, String paramString, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    Object localObject = URLUtil.a(paramString);
    if (localObject == null) {
      return;
    }
    String str1 = (String)((Map)localObject).get("from");
    paramString = str1;
    if (TextUtils.isEmpty(str1)) {
      paramString = "1";
    }
    for (;;)
    {
      try
      {
        if ("2".equals(paramString))
        {
          paramDeviceInfo = new Intent();
          paramDeviceInfo.putExtra("nickname", paramQQAppInterface.getCurrentNickname());
          paramDeviceInfo.putExtra("bitmap", paramQQAppInterface.getFaceBitmap(paramQQAppInterface.getCurrentAccountUin(), (byte)2, false));
          paramString = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
          paramBundle = new StringBuilder();
          paramBundle.append("square_url_");
          paramBundle.append(paramQQAppInterface.getCurrentAccountUin());
          paramString = paramString.getString(paramBundle.toString(), "");
          bool = TextUtils.isEmpty(paramString);
          if (!bool) {
            paramDeviceInfo.putExtra("url", paramString);
          } else {
            paramDeviceInfo.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          }
          SmartDevicePluginLoader.a().a((Activity)paramContext, paramQQAppInterface, paramQQAppInterface.getAccount(), paramDeviceInfo, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
          SmartDeviceReport.a(null, "Usr_NewDevice_Aio", 2, 0, 0);
          return;
        }
        boolean bool = "3".equals(paramString);
        if (bool)
        {
          paramString = (String)((Map)localObject).get("din");
          paramDeviceInfo = new Intent(paramContext, SplashActivity.class);
          paramDeviceInfo.putExtra("fragment_id", 1);
          paramDeviceInfo.putExtra("tab_index", FrameControllerUtil.c);
          paramDeviceInfo.putExtra("from", "smartdevice");
          paramDeviceInfo.setFlags(67108864);
          ((SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramString);
          if ((paramContext instanceof SplashActivity))
          {
            paramQQAppInterface = (SplashActivity)paramContext;
            paramDeviceInfo.putExtra("switch_anim", true);
            paramQQAppInterface.openMainFragment(paramDeviceInfo);
            return;
          }
          paramContext.startActivity(paramDeviceInfo);
          if ((paramContext instanceof Activity)) {
            ((Activity)paramContext).finish();
          }
        }
        else
        {
          paramString = (String)((Map)localObject).get("hash");
          String str2 = (String)((Map)localObject).get("param");
          String str3 = (String)((Map)localObject).get("script");
          str1 = (String)((Map)localObject).get("din");
          localObject = new JSONObject();
          bool = TextUtils.isEmpty(paramString);
          if (!bool) {
            ((JSONObject)localObject).put("hash", URLDecoder.decode(paramString, "UTF-8"));
          }
          if (!TextUtils.isEmpty(str2)) {
            ((JSONObject)localObject).put("param", URLDecoder.decode(str2, "UTF-8"));
          }
          if (!TextUtils.isEmpty(str3)) {
            ((JSONObject)localObject).put("script", URLDecoder.decode(str3, "UTF-8"));
          }
          if (paramBundle != null) {
            break label564;
          }
          paramString = new Bundle();
          paramBundle = ((JSONObject)localObject).toString();
          if (!TextUtils.isEmpty(paramBundle)) {
            paramString.putString("lightapp_init", paramBundle);
          }
          paramBundle = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
          if (paramDeviceInfo != null) {
            break label570;
          }
          paramQQAppInterface = paramBundle.a(Long.parseLong(str1));
          paramBundle.a((Activity)paramContext, paramQQAppInterface, false, paramString);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        LogUtility.c("SmartDeviceUtil", "jumpLightApp, Exception >>>", paramQQAppInterface);
      }
      return;
      label564:
      paramString = paramBundle;
      continue;
      label570:
      paramQQAppInterface = paramDeviceInfo;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, String paramString)
  {
    Object localObject = new Bundle();
    try
    {
      String str1 = paramJSONObject.getString("summary");
      String str2 = paramJSONObject.getString("icon");
      String str3 = paramJSONObject.getString("title");
      String str4 = paramJSONObject.getString("cover");
      String str5 = paramJSONObject.getString("url");
      paramJSONObject = paramJSONObject.getString("name");
      ((Bundle)localObject).putString("detail_url", str5);
      ((Bundle)localObject).putString("image_url_remote", str4);
      ((Bundle)localObject).putString("title", str3);
      ((Bundle)localObject).putString("desc", str1);
      ((Bundle)localObject).putString("struct_share_key_content_action", "web");
      ((Bundle)localObject).putString("struct_share_key_source_icon", str2);
      ((Bundle)localObject).putString("app_name", paramJSONObject);
      ((Bundle)localObject).putString("brief_key", str3);
      paramJSONObject = (StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject);
      localObject = (MessageForStructing)MessageRecordFactory.a(-2011);
      ((MessageForStructing)localObject).msgtype = -2011;
      ((MessageForStructing)localObject).istroop = 9501;
      ((MessageForStructing)localObject).issend = 0;
      ((MessageForStructing)localObject).isread = false;
      ((MessageForStructing)localObject).selfuin = paramQQAppInterface.getCurrentAccountUin();
      ((MessageForStructing)localObject).senderuin = paramString;
      ((MessageForStructing)localObject).frienduin = paramString;
      ((MessageForStructing)localObject).mIsParsed = true;
      ((MessageForStructing)localObject).structingMsg = paramJSONObject;
      ((MessageForStructing)localObject).msgData = paramJSONObject.getBytes();
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(String paramString1, Bundle paramBundle, int paramInt, String paramString2, AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramAppRuntime.getAccount(), "smart_device_proxy.cgi");
    paramBundle.putString("skey", ((TicketManager)paramAppRuntime.getManager(2)).getSkey(paramAppRuntime.getAccount()));
    paramBundle.putString("version", "8.7.0");
    Object localObject = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramBundle.get(str) == null) {
        return;
      }
      if (((StringBuilder)localObject).length() != 0) {
        ((StringBuilder)localObject).append("&");
      }
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append(URLEncoder.encode(String.valueOf(paramBundle.get(str))));
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("url2=");
      paramBundle.append(paramString1);
      paramBundle.append("?");
      paramBundle.append(((StringBuilder)localObject).toString());
      QLog.d("SmartDeviceUtil", 2, paramBundle.toString());
    }
    paramBundle = new smart_device_proxy.CgiReq();
    paramBundle.str_cgiName.set(paramString1);
    paramBundle.bytes_param.set(ByteStringMicro.copyFromUtf8(((StringBuilder)localObject).toString()));
    if (!TextUtils.isEmpty(paramString2)) {
      paramBundle.bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    paramString1 = new smart_device_proxy.CommonHead();
    paramString1.uint32_uin.set(Long.parseLong(paramAppRuntime.getAccount()));
    paramString2 = new smart_device_proxy.ReqBody();
    localObject = paramString2.int32_cmd;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((PBInt32Field)localObject).set(i);
    paramString2.msg_header.set(paramString1);
    paramString2.bytes_body.set(ByteStringMicro.copyFrom(paramBundle.toByteArray()));
    localToServiceMsg.putWupBuffer(paramString2.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), SmartDeviceServlet.class);
    paramString1.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
    paramString1.setObserver(paramBusinessObserver);
    paramAppRuntime.startServlet(paramString1);
  }
  
  public static void a(String paramString, Bundle paramBundle, AppRuntime paramAppRuntime, BusinessObserver paramBusinessObserver)
  {
    a(paramString, paramBundle, 0, null, paramAppRuntime, paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.utils.SmartDeviceUtil
 * JD-Core Version:    0.7.0.1
 */