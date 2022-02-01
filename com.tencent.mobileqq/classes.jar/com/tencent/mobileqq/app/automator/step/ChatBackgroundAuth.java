package com.tencent.mobileqq.app.automator.step;

import QC.Hamlet;
import QC.UniBusinessItem;
import amsw;
import anaj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anfb;
import bgje;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.model.ChatBackgroundManager;
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
  
  private ArrayList<Hamlet> a(HashMap<String, Integer> paramHashMap1, HashMap<String, Integer> paramHashMap2, amsw paramamsw, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramamsw, paramHashMap1, localArrayList, paramInt1);
    a(paramamsw, paramHashMap2, localArrayList, paramInt2);
    return localArrayList;
  }
  
  private void a(amsw paramamsw, HashMap<String, Integer> paramHashMap, ArrayList<Hamlet> paramArrayList, int paramInt)
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
          localUniBusinessItem = new UniBusinessItem(paramInt, ((Integer)localObject2).intValue());
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
      label115:
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
        if (paramamsw.b((String)localObject1))
        {
          i = 2;
          break label115;
        }
        i = 3;
        break label115;
        if (!"null".equals(localObject3)) {
          break label298;
        }
        localObject1 = this.a.app.getCurrentUin();
        i = 1;
        break label115;
        return;
        localObject1 = localObject2;
      }
      label298:
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
    SharedPreferences localSharedPreferences = this.a.app.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastChabgAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep start auth");
      }
      Object localObject = (ChatBackgroundManager)this.a.app.getManager(63);
      HashMap localHashMap = ((ChatBackgroundManager)localObject).a();
      localObject = ((ChatBackgroundManager)localObject).c();
      ((anaj)this.a.app.getBusinessHandler(13)).a(a(localHashMap, (HashMap)localObject, (amsw)this.a.app.getManager(51), 8, 35), new anfb(this.a.app), true);
      localSharedPreferences.edit().putLong("lastChabgAuthTime", System.currentTimeMillis()).apply();
    }
    if (!bgje.a.a(this.a.app, "namePlate_UrlConfig")) {
      bgje.a.download(null, "namePlate_UrlConfig", null, false);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth
 * JD-Core Version:    0.7.0.1
 */