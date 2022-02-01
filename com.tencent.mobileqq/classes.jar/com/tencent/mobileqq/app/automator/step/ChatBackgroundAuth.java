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
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.quickupdate.VipIconCallback;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
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
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = (Integer)paramHashMap.get(localObject2);
      String str = null;
      if (localObject1 != null)
      {
        UniBusinessItem localUniBusinessItem = new UniBusinessItem(paramInt, ((Integer)localObject1).intValue(), "");
        boolean bool = ((String)localObject2).contains("_");
        int j = 1;
        int i;
        if (bool)
        {
          localObject2 = ((String)localObject2).split("_");
          str = localObject2[0];
          i = Integer.parseInt(localObject2[1]);
          if (i > -1) {
            i = b(i);
          } else if (paramFriendsManager.n(str)) {
            i = 2;
          } else {
            i = 3;
          }
        }
        else
        {
          i = j;
          if ("null".equals(localObject2))
          {
            str = this.mAutomator.k.getCurrentUin();
            i = j;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("friendUin:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(" serverUinType:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" appId:");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" id:");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("QQInitHandler", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = a(paramArrayList, str, i);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          localObject1 = new Hamlet(Long.parseLong(str), i, (ArrayList)localObject1);
          paramArrayList.add(localObject1);
        }
        ((Hamlet)localObject1).itemlist.add(localUniBusinessItem);
      }
    }
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 1) {
      return 3;
    }
    if (paramInt == 0) {
      return 2;
    }
    return 1;
  }
  
  protected int doStep()
  {
    SharedPreferences localSharedPreferences = this.mAutomator.k.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastChabgAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep start auth");
      }
      Object localObject = (ChatBackgroundManager)this.mAutomator.k.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
      HashMap localHashMap = ((ChatBackgroundManager)localObject).d();
      localObject = ((ChatBackgroundManager)localObject).g();
      ((ISVIPHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(a(localHashMap, (HashMap)localObject, (FriendsManager)this.mAutomator.k.getManager(QQManagerFactory.FRIENDS_MANAGER), 8, 35), new ChatBackgroundAuth.ChatBgAuthBusinessObserver(this.mAutomator.k), true);
      localSharedPreferences.edit().putLong("lastChabgAuthTime", System.currentTimeMillis()).apply();
    }
    if (!VipIconCallback.sInstance.isFileExists("namePlate_UrlConfig")) {
      VipIconCallback.sInstance.download("namePlate_UrlConfig", null, false);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth
 * JD-Core Version:    0.7.0.1
 */