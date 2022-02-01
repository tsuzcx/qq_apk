package com.tencent.mobileqq.activity.recent.msgbox.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.inject.TempMsgBoxBusinessInjectUtil;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class TempChatPluginManagerImpl
  implements ITempChatPluginManager, Manager
{
  public static final String TAG = "TempChatPluginManager";
  private static ArrayList<Integer> sTempUinTypeList = new TempChatPluginManagerImpl.1();
  private AppInterface mApp;
  private Map<String, AbstractTempChatPlugin> tempChatPluginMap;
  
  public static ArrayList<Integer> getTempUinTypeList()
  {
    return sTempUinTypeList;
  }
  
  private void init()
  {
    this.tempChatPluginMap = new HashMap();
    HashMap localHashMap = TempMsgBoxBusinessInjectUtil.b;
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (Class)localHashMap.get(str);
      if (localObject != null) {
        try
        {
          localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { AppInterface.class });
          ((Constructor)localObject).setAccessible(true);
          localObject = (AbstractTempChatPlugin)((Constructor)localObject).newInstance(new Object[] { this.mApp });
          this.tempChatPluginMap.put(str, localObject);
        }
        catch (Exception localException)
        {
          QLog.d("TempChatPluginManager", 1, "init tempChatPluginMap error: ", localException);
        }
      }
    }
  }
  
  public AbstractTempChatPlugin getTempChatPlugin(int paramInt)
  {
    try
    {
      if (this.tempChatPluginMap != null)
      {
        AbstractTempChatPlugin localAbstractTempChatPlugin = (AbstractTempChatPlugin)this.tempChatPluginMap.get(String.valueOf(paramInt));
        return localAbstractTempChatPlugin;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isCustomizeByBiz(int paramInt)
  {
    Map localMap = this.tempChatPluginMap;
    if (localMap != null) {
      return localMap.containsKey(String.valueOf(paramInt));
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    if (this.tempChatPluginMap == null) {
      init();
    }
  }
  
  public void onDestroy() {}
  
  public boolean onHeadIconClickCusTempConv(Context paramContext, int paramInt, String paramString)
  {
    Object localObject = getTempChatPlugin(paramInt);
    if (localObject == null) {
      return false;
    }
    try
    {
      paramString = ((AbstractTempChatPlugin)localObject).a(paramString);
      if (paramString.startsWith("http"))
      {
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramString);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject, paramString);
        paramContext.startActivity((Intent)localObject);
        return true;
      }
      if (paramString.startsWith("mqqapi"))
      {
        paramContext = JumpParser.a((BaseQQAppInterface)this.mApp, paramContext, paramString);
        if (paramContext != null)
        {
          paramContext.a();
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.d("TempChatPluginManager", 1, "onHeadIconClickCusTempConv Error: ", paramContext);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.api.impl.TempChatPluginManagerImpl
 * JD-Core Version:    0.7.0.1
 */