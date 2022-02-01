package com.tencent.mobileqq.avatar.ipc;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class AvatarServerIPCModule
  extends QIPCModule
{
  private static volatile AvatarServerIPCModule a;
  
  private AvatarServerIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static AvatarServerIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new AvatarServerIPCModule("AvatarServerIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult a(AppInterface paramAppInterface)
  {
    paramAppInterface = ((IQQAvatarHandlerService)paramAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getChoosedIP();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_ip", paramAppInterface);
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  public EIPCResult a(String paramString, AppInterface paramAppInterface)
  {
    paramString = ((IQQAvatarDataService)paramAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).getFaceSetting(paramString);
    paramAppInterface = new Bundle();
    paramAppInterface.putParcelable("key_face_setting", paramString);
    return EIPCResult.createSuccessResult(paramAppInterface);
  }
  
  public void a(Setting paramSetting, AppInterface paramAppInterface)
  {
    ((IQQAvatarDataService)paramAppInterface.getRuntimeService(IQQAvatarDataService.class, "")).updateSettingTableCache(paramSetting);
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager();
    paramAppInterface.persistOrReplace(paramSetting);
    paramAppInterface.close();
  }
  
  public void a(ArrayList<String> paramArrayList, long paramLong, AppInterface paramAppInterface)
  {
    if (paramLong <= 0L) {
      return;
    }
    IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)paramAppInterface.getRuntimeService(IQQAvatarDataService.class, "");
    EntityManager localEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
    paramAppInterface = localEntityManager.getTransaction();
    paramAppInterface.begin();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)localEntityManager.find(Setting.class, (String)paramArrayList.get(i));
        if (localSetting != null)
        {
          localSetting.updateTimestamp = paramLong;
          localIQQAvatarDataService.updateSettingTableCache(localSetting);
          localEntityManager.update(localSetting);
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      paramAppInterface.commit();
      paramAppInterface.end();
    }
  }
  
  public EIPCResult b(AppInterface paramAppInterface)
  {
    paramAppInterface = ((IQQAvatarHandlerService)paramAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getChoosedStrangerGroupIP();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_ip", paramAppInterface);
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localObject instanceof AppInterface)) {
      return null;
    }
    localObject = (AppInterface)localObject;
    if ("action_get_chose_ip".equals(paramString)) {
      paramString = a((AppInterface)localObject);
    }
    for (;;)
    {
      return paramString;
      if ("action_get_stranger_group_ip".equals(paramString))
      {
        paramString = b((AppInterface)localObject);
      }
      else if ("action_get_face_setting".equals(paramString))
      {
        paramString = a(paramBundle.getString("key_face_setting_key"), (AppInterface)localObject);
      }
      else if ("action_update_face_setting".equals(paramString))
      {
        a((Setting)paramBundle.getParcelable("key_face_setting"), (AppInterface)localObject);
        paramString = null;
      }
      else
      {
        if ("action_update_setting_timestamp".equals(paramString)) {
          a(paramBundle.getStringArrayList("key_key_list"), paramBundle.getLong("key_update_time", 0L), (AppInterface)localObject);
        }
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.ipc.AvatarServerIPCModule
 * JD-Core Version:    0.7.0.1
 */