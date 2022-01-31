package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletSkinHandler;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import xlz;
import xma;
import xmc;
import xme;
import xmf;
import xmg;
import xmh;

public class QWalletIPCModule
  extends QIPCModule
{
  public static QWalletIPCModule a;
  
  private QWalletIPCModule()
  {
    super("QWalletIPCModule");
  }
  
  public static QWalletIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QWalletIPCModule();
      }
      return a;
    }
    finally {}
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle, int paramInt)
  {
    switch (paramBundle.getInt("oper_type", -1))
    {
    default: 
      return null;
    }
    paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramBundle.getString("uin"), true);
    paramBundle = new Bundle();
    paramBundle.putString("res", paramQQAppInterface);
    return EIPCResult.createSuccessResult(paramBundle);
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = paramBundle.getInt("channel");
    String str = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("group_id");
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(50);
    Object localObject1;
    if (((i != 5) && ((i & 0x10) == 0)) || ((((FriendsManager)localObject2).b(str)) && (!paramQQAppInterface.getCurrentAccountUin().equals(str)))) {
      if (!TextUtils.isEmpty(paramBundle))
      {
        localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
        localObject2 = ((FriendsManager)localObject2).c(str);
        paramBundle = ((TroopManager)localObject1).b(paramBundle, str);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).remark))) {
          paramBundle = ((Friends)localObject2).remark;
        }
      }
    }
    for (;;)
    {
      localObject1 = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        localObject1 = ContactUtils.b(paramQQAppInterface, str, true);
      }
      for (;;)
      {
        paramBundle = new EIPCResult();
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("user_nick", (String)localObject1);
        paramBundle.data = paramQQAppInterface;
        callbackResult(paramInt, paramBundle);
        return;
        if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.troopnick)))
        {
          paramBundle = paramBundle.troopnick;
          break;
        }
        if (localObject2 != null)
        {
          paramBundle = ((Friends)localObject2).name;
          break;
        }
        if (paramBundle == null) {
          break label305;
        }
        if (str.equals(paramQQAppInterface.getCurrentAccountUin()))
        {
          paramBundle = paramBundle.friendnick;
          break;
        }
        if (!TextUtils.isEmpty(paramBundle.autoremark))
        {
          paramBundle = paramBundle.autoremark;
          break;
        }
        paramBundle = paramBundle.friendnick;
        break;
        localObject1 = ContactUtils.b(paramQQAppInterface, str, true);
        continue;
        paramBundle = ContactUtils.q(paramQQAppInterface, str);
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject1 = str;
        }
      }
      label305:
      paramBundle = null;
    }
  }
  
  private void a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    if ((paramAppRuntime != null) && (paramBundle != null))
    {
      paramBundle = (HashMap)paramBundle.getSerializable("params_value");
      if (paramBundle != null)
      {
        paramAppRuntime = (QWalletConfigManager)((QQAppInterface)paramAppRuntime).getManager(244);
        if (paramAppRuntime != null) {
          paramAppRuntime.a(paramBundle);
        }
      }
    }
  }
  
  private EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {
      return null;
    }
    switch (paramBundle.getInt("method_type", -1))
    {
    default: 
      return null;
    case 1: 
      localObject = paramBundle.getString("url");
      String str = paramBundle.getString("md5");
      long l = paramBundle.getLong("md5_time");
      boolean bool = paramBundle.getBoolean("is_force_unzip");
      ((PreloadManager)paramQQAppInterface.getManager(150)).a((String)localObject, str, l, new xmg(this, paramInt), bool);
      return null;
    }
    Object localObject = paramBundle.getStringArray("url");
    if (localObject == null) {}
    for (localObject = null;; localObject = Arrays.asList((Object[])localObject))
    {
      paramBundle = new xmf(this, (ResultReceiver)paramBundle.getParcelable("receiver"));
      ((PreloadManager)paramQQAppInterface.getManager(150)).a((List)localObject, paramBundle);
      return null;
    }
  }
  
  public Bundle a(AppRuntime paramAppRuntime, Bundle paramBundle)
  {
    paramAppRuntime = (QWalletConfigManager)((QQAppInterface)paramAppRuntime).getManager(244);
    Bundle localBundle = new Bundle();
    String str = paramBundle.getString("module");
    int i = paramBundle.getInt("oper_type");
    String[] arrayOfString = paramBundle.getStringArray("sub_keys");
    switch (i)
    {
    default: 
      return localBundle;
    case 0: 
      localBundle.putInt("res_get_value", paramAppRuntime.a(str, paramBundle.getInt("def_value"), arrayOfString));
      return localBundle;
    case 1: 
      localBundle.putString("res_get_value", paramAppRuntime.a(str, paramBundle.getString("def_value"), arrayOfString));
      return localBundle;
    }
    localBundle.putString("res_get_value", paramAppRuntime.a(str));
    return localBundle;
  }
  
  public EIPCResult a(Bundle paramBundle, int paramInt)
  {
    paramBundle.setClassLoader(getClass().getClassLoader());
    paramInt = paramBundle.getInt("key_func");
    ResultReceiver localResultReceiver = (ResultReceiver)paramBundle.getParcelable("key_callback");
    IRedPacket localIRedPacket = RedPacketManager.getInstance();
    Object localObject = new Bundle();
    switch (paramInt)
    {
    default: 
    case 1: 
    case 5: 
    case 2: 
    case 3: 
      for (;;)
      {
        return null;
        paramBundle = (RedPacketInfoBase)paramBundle.getParcelable("key_red_packet_info");
        localObject = new xmh(this, (Bundle)localObject, localResultReceiver);
        if (paramInt == 1) {
          localIRedPacket.getSkin(paramBundle, (IRedPacket.OnGetSkinListener)localObject);
        }
        for (;;)
        {
          return null;
          if (paramInt == 5) {
            localIRedPacket.getVoiceRateRes(paramBundle, (IRedPacket.OnGetSkinListener)localObject);
          }
        }
        ((Bundle)localObject).putBoolean("key_is_risk_switch_open", localIRedPacket.isRiskSwitchOpen());
        return EIPCResult.createSuccessResult((Bundle)localObject);
        localIRedPacket.requestRedPacketSkinList();
      }
    case 6: 
      paramInt = paramBundle.getInt("theme_id");
      ((Bundle)localObject).putBoolean("key_theme_exist", ((RedPacketManager)RedPacketManager.getInstance()).onGetThemeConfig(paramInt));
      return EIPCResult.createSuccessResult((Bundle)localObject);
    }
    paramBundle = localIRedPacket.getPopAd(paramBundle.getInt("key_skin_id", 0), paramBundle.getInt("key_channel", 0));
    if (paramBundle != null)
    {
      ((Bundle)localObject).putString("pop_ad_tips", paramBundle.optString("tips"));
      ((Bundle)localObject).putString("pop_ad_url", paramBundle.optString("url"));
      ((Bundle)localObject).putInt("pop_ad_url_type", paramBundle.optInt("urlType"));
    }
    return EIPCResult.createSuccessResult((Bundle)localObject);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
    if ("getFilePathByResID".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletIPCModule", 2, "onCall getFilePathByResID");
      }
      ThreadManager.post(new xlz(this, paramBundle, paramInt, (AppRuntime)localObject), 5, null, true);
    }
    do
    {
      for (;;)
      {
        return null;
        if (("downloadModule".equals(paramString)) || ("downloadRes".equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "onCall downloadModule:" + System.currentTimeMillis());
          }
          ThreadManager.post(new xma(this, paramBundle, (AppRuntime)localObject, paramString), 5, null, true);
          callbackResult(paramInt, null);
        }
        else
        {
          if ("getVideoResPathByMID".equals(paramString))
          {
            paramString = paramBundle.getString("mid");
            paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(150)).b(paramString);
            if (QLog.isColorLevel()) {
              QLog.d("QWalletIPCModule", 2, "onCall getVideoResPathByMID:" + paramString);
            }
            paramBundle = new Bundle();
            paramBundle.putString("path", paramString);
            return EIPCResult.createSuccessResult(paramBundle);
          }
          if ("request_gold_msg_entry".equals(paramString))
          {
            ThreadManager.post(new xmc(this, (AppRuntime)localObject), 5, null, true);
          }
          else
          {
            if ("getResourceByResID".equals(paramString))
            {
              paramString = paramBundle.getString("res_id");
              paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(150)).a(paramString);
              if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCModule", 2, "onCall getResourceByResID:" + paramString);
              }
              paramBundle = new Bundle();
              paramBundle.putSerializable("res_info", paramString);
              return EIPCResult.createSuccessResult(paramBundle);
            }
            if ("getResInfoByResID".equals(paramString))
            {
              paramString = paramBundle.getString("res_id");
              paramString = ((PreloadManager)((QQAppInterface)localObject).getManager(150)).a(paramString);
              if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCModule", 2, "onCall ACTION_GET_RESINFO_BY_RESID:" + paramString);
              }
              paramBundle = new Bundle();
              paramBundle.putSerializable("res_info", paramString);
              return EIPCResult.createSuccessResult(paramBundle);
            }
            if ("getResIDByBusinessID".equals(paramString))
            {
              paramString = paramBundle.getString("bid");
              paramBundle = paramBundle.getString("uin");
              localObject = new Bundle();
              ((Bundle)localObject).putString("res_id", QWalletSkinHandler.a(paramString, paramBundle));
              return EIPCResult.createSuccessResult((Bundle)localObject);
            }
            if ("getConfig".equals(paramString)) {
              return EIPCResult.createSuccessResult(a((AppRuntime)localObject, paramBundle));
            }
            if ("setConfigSession".equals(paramString))
            {
              a((AppRuntime)localObject, paramBundle);
            }
            else
            {
              if ("getConditionSearchManager".equals(paramString))
              {
                paramString = (ResultReceiver)paramBundle.getParcelable("receiver");
                paramBundle = (ConditionSearchManager)((QQAppInterface)localObject).getManager(58);
                QLog.d("QWalletIPCModule", 2, "ConditionSearchManager " + paramBundle.toString());
                paramInt = paramBundle.a();
                if (paramInt != 0)
                {
                  paramInt = paramBundle.a(paramInt, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("QWalletIPCModule", 2, "ConditionSearchManager | update result = " + paramInt);
                  }
                  localObject = new Bundle();
                  if (paramInt == 0) {
                    paramBundle.c(new xme(this, (Bundle)localObject, paramInt, paramString, paramBundle));
                  }
                  ((Bundle)localObject).putInt("isUpdateSuccess", 0);
                  ((Bundle)localObject).putInt("updateResult", paramInt);
                  paramString.send(1, (Bundle)localObject);
                  return null;
                }
                paramString.send(0, null);
                return null;
              }
              if (!"getUserNick".equals(paramString)) {
                break;
              }
              a(paramBundle, (QQAppInterface)localObject, paramInt);
            }
          }
        }
      }
      if ("red_packet".equals(paramString)) {
        return a(paramBundle, paramInt);
      }
      if ("ComIPCUtils".equals(paramString)) {
        return a(localQQAppInterface, paramBundle, paramInt);
      }
    } while (!"preloadCommon".equals(paramString));
    return b(localQQAppInterface, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule
 * JD-Core Version:    0.7.0.1
 */