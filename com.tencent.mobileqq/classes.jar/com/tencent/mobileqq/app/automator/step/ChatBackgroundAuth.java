package com.tencent.mobileqq.app.automator.step;

import QC.Hamlet;
import QC.UniBusinessItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.quickupdate.VipIconCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ChatBackgroundAuth
  extends AsyncStep
{
  public static int a(int paramInt)
  {
    if (paramInt == 3) {
      return 1;
    }
    if (paramInt == 2) {
      return 0;
    }
    return -1;
  }
  
  private Hamlet a(ArrayList<Hamlet> paramArrayList, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Hamlet localHamlet = (Hamlet)paramArrayList.next();
      if ((localHamlet.uid == Long.parseLong(paramString)) && (paramInt == localHamlet.locationtype)) {
        return localHamlet;
      }
    }
    return null;
  }
  
  private ArrayList<Hamlet> a(HashMap<String, Integer> paramHashMap1, HashMap<String, Integer> paramHashMap2, FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramFriendsManager, paramHashMap1, localArrayList, paramInt1);
    a(paramFriendsManager, paramHashMap2, localArrayList, paramInt2);
    return localArrayList;
  }
  
  private void a(FriendsManager paramFriendsManager, HashMap<String, Integer> paramHashMap, ArrayList<Hamlet> paramArrayList, int paramInt)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    Object localObject3;
    Object localObject2;
    Object localObject1;
    UniBusinessItem localUniBusinessItem;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (String)localIterator.next();
        localObject2 = (Integer)paramHashMap.get(localObject3);
        localObject1 = null;
        if (localObject2 != null)
        {
          localUniBusinessItem = new UniBusinessItem(paramInt, ((Integer)localObject2).intValue(), "");
          if (((String)localObject3).contains("_"))
          {
            localObject3 = ((String)localObject3).split("_");
            localObject1 = localObject3[0];
            i = Integer.parseInt(localObject3[1]);
            if (i > -1) {
              i = b(i);
            }
          }
        }
      }
    }
    for (;;)
    {
      label117:
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "friendUin:" + (String)localObject1 + " serverUinType:" + i + " appId:" + paramInt + " id:" + localObject2);
      }
      localObject2 = a(paramArrayList, (String)localObject1, i);
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        localObject1 = new Hamlet(Long.parseLong((String)localObject1), i, (ArrayList)localObject2);
        paramArrayList.add(localObject1);
      }
      for (;;)
      {
        ((Hamlet)localObject1).itemlist.add(localUniBusinessItem);
        break;
        if (paramFriendsManager.b((String)localObject1))
        {
          i = 2;
          break label117;
        }
        i = 3;
        break label117;
        if (!"null".equals(localObject3)) {
          break label300;
        }
        localObject1 = this.a.a.getCurrentUin();
        i = 1;
        break label117;
        return;
        localObject1 = localObject2;
      }
      label300:
      i = 1;
    }
  }
  
  public static int b(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 3;
    }
    while (paramInt != 0) {
      return i;
    }
    return 2;
  }
  
  public int a()
  {
    SharedPreferences localSharedPreferences = this.a.a.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastChabgAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep start auth");
      }
      Object localObject = (ChatBackgroundManager)this.a.a.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
      HashMap localHashMap = ((ChatBackgroundManager)localObject).a();
      localObject = ((ChatBackgroundManager)localObject).c();
      ((SVIPHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(a(localHashMap, (HashMap)localObject, (FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER), 8, 35), new ChatBackgroundAuth.ChatBgAuthBusinessObserver(this.a.a), true);
      localSharedPreferences.edit().putLong("lastChabgAuthTime", System.currentTimeMillis()).apply();
    }
    if (!VipIconCallback.sInstance.isFileExists("namePlate_UrlConfig")) {
      VipIconCallback.sInstance.download("namePlate_UrlConfig", null, false);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth
 * JD-Core Version:    0.7.0.1
 */