package com.tencent.mobileqq.activity.miniaio;

import aklc;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

public class MiniMsgIPCClient
  extends QIPCModule
{
  public static final String MODULE_NAME = "mini_msg_client_module";
  public static final String TAG = "mini_msg_IPCClient";
  private static MiniMsgIPCClient sInstance;
  private ConcurrentHashMap<Integer, aklc> mBusinessInfoMap = new ConcurrentHashMap();
  private MiniMsgUser mMiniUser;
  
  public MiniMsgIPCClient(String paramString)
  {
    super(paramString);
  }
  
  public static MiniMsgIPCClient getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniMsgIPCClient("mini_msg_client_module");
      }
      return sInstance;
    }
    finally {}
  }
  
  public static Bundle getModuleBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_msg_client_module");
    return localBundle;
  }
  
  private void notifyShowWindow()
  {
    new Handler(Looper.getMainLooper()).post(new MiniMsgIPCClient.1(this));
  }
  
  public static void onProcessBackground(int paramInt)
  {
    Bundle localBundle = getModuleBundle();
    localBundle.putInt("param_proc_businame", paramInt);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_backgound", localBundle, null);
  }
  
  public static void onProcessForeGround(int paramInt)
  {
    Bundle localBundle = getModuleBundle();
    localBundle.putInt("param_proc_businame", paramInt);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_proc_foregound", localBundle, null);
  }
  
  public static void register() {}
  
  public static void register(int paramInt, String paramString)
  {
    paramString = getInstance().mBusinessInfoMap;
    if (!paramString.containsKey(Integer.valueOf(paramInt)))
    {
      aklc localaklc = new aklc();
      localaklc.a = paramInt;
      paramString.put(Integer.valueOf(paramInt), localaklc);
      paramString = getInstance();
    }
    try
    {
      QIPCClientHelper.getInstance().register(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("mini_msg_IPCClient", 1, "register ipc module error.", paramString);
    }
  }
  
  public static void unregister() {}
  
  public static void unregister(String paramString1, String paramString2)
  {
    paramString2 = getInstance().mBusinessInfoMap;
    if (paramString2.containsKey(paramString1)) {
      paramString2.remove(paramString1);
    }
  }
  
  public void clearBusiness(int paramInt)
  {
    this.mBusinessInfoMap.remove(Integer.valueOf(paramInt));
    Bundle localBundle = getModuleBundle();
    localBundle.putInt("PARAM_CMD_BUSIID", paramInt);
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_clear_business", localBundle, null);
  }
  
  public aklc getBusinessInfo(int paramInt)
  {
    return (aklc)this.mBusinessInfoMap.get(Integer.valueOf(paramInt));
  }
  
  public MiniMsgUser getMiniUser()
  {
    return this.mMiniUser;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_IPCClient", 2, "onCall.action = " + paramString);
    }
    if ("action_sync_unreadcount".equals(paramString))
    {
      paramInt = paramBundle.getInt("param_proc_badge_count");
      try
      {
        if (this.mMiniUser != null) {
          this.mMiniUser.updateUnreadCountSync(paramInt);
        }
      }
      finally {}
    }
    else if ("action_msg_tab_back_refresh".equals(paramString))
    {
      paramInt = paramBundle.getInt("param_proc_badge_count");
      try
      {
        if (this.mMiniUser != null) {
          this.mMiniUser.updateWhenBackFromMiniChat(paramInt);
        }
      }
      finally {}
    }
    else if ("action_get_unread".equals(paramString))
    {
      paramInt = paramBundle.getInt("param_proc_badge_count");
      try
      {
        if (this.mMiniUser != null) {
          this.mMiniUser.updateUnreadCountGet(paramInt);
        }
      }
      finally {}
    }
    else if ("action_mini_msgtab_notify_to_conversation".equals(paramString))
    {
      try
      {
        notifyShowWindow();
        if (this.mMiniUser != null) {
          this.mMiniUser.notifyGoToConversation();
        }
      }
      finally {}
    }
    else if ("action_mini_aio_to_aio".equals(paramString))
    {
      try
      {
        notifyShowWindow();
        if (this.mMiniUser != null) {
          this.mMiniUser.notifyFromMiniAIOToAIO();
        }
      }
      finally {}
    }
    return null;
  }
  
  public void removetMiniUser(MiniMsgUser paramMiniMsgUser)
  {
    if (this.mMiniUser == paramMiniMsgUser) {
      try
      {
        if (this.mMiniUser == paramMiniMsgUser) {
          this.mMiniUser = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public void setMiniUser(MiniMsgUser paramMiniMsgUser)
  {
    if (this.mMiniUser != paramMiniMsgUser) {
      try
      {
        this.mMiniUser = paramMiniMsgUser;
        return;
      }
      finally {}
    }
  }
  
  public void syncGetUnread()
  {
    Bundle localBundle = getModuleBundle();
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_get_unread", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient
 * JD-Core Version:    0.7.0.1
 */