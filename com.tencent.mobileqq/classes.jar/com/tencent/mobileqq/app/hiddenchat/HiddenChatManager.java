package com.tencent.mobileqq.app.hiddenchat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.hiddenchat.data.HiddenChatEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;

public class HiddenChatManager
  implements Manager
{
  QQAppInterface a;
  SharedPreferences b;
  AtomicBoolean c = new AtomicBoolean(false);
  ConcurrentHashMap<String, HiddenChatEntity> d;
  
  public HiddenChatManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = HiddenChatUtil.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
    this.d = new ConcurrentHashMap();
  }
  
  public static HiddenChatManager a(QQAppInterface paramQQAppInterface)
  {
    return (HiddenChatManager)paramQQAppInterface.getManager(QQManagerFactory.HIDDENCHAT_MANAGER);
  }
  
  HiddenChatEntity a(String paramString, int paramInt)
  {
    synchronized (this.d)
    {
      HiddenChatEntity localHiddenChatEntity2 = (HiddenChatEntity)this.d.get(paramString);
      HiddenChatEntity localHiddenChatEntity1 = localHiddenChatEntity2;
      if (localHiddenChatEntity2 == null)
      {
        localHiddenChatEntity1 = new HiddenChatEntity();
        localHiddenChatEntity1.a = paramString;
        localHiddenChatEntity1.b = paramInt;
      }
      return localHiddenChatEntity1;
    }
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
    {
      HiddenChatEntity localHiddenChatEntity = (HiddenChatEntity)localIterator.next();
      localStringBuilder.append(localHiddenChatEntity.a);
      localStringBuilder.append("|");
      localStringBuilder.append(localHiddenChatEntity.b);
      localStringBuilder.append(";");
    }
    this.b.edit().putString("KeyHiddenChatList", localStringBuilder.toString()).commit();
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject = this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0);
    if (!((SharedPreferences)localObject).getBoolean("FirstSetHidden", false))
    {
      ((SharedPreferences)localObject).edit().putBoolean("FirstSetHidden", true).commit();
      localObject = paramActivity.getString(2131894122);
      DialogUtil.a(paramActivity, 230, paramActivity.getString(2131894124), (CharSequence)localObject, paramActivity.getString(2131916601), paramActivity.getString(2131894123), new HiddenChatManager.1(this, paramActivity), new DialogUtil.DialogOnClickAdapter()).show();
      ReportController.b(this.a, "dc00898", "", "", "0X800A349", "0X800A349", 0, 0, "0", "0", "", "");
    }
  }
  
  void a(HiddenChatEntity paramHiddenChatEntity)
  {
    if (paramHiddenChatEntity != null)
    {
      if (TextUtils.isEmpty(paramHiddenChatEntity.a)) {
        return;
      }
      synchronized (this.d)
      {
        this.d.put(paramHiddenChatEntity.a, paramHiddenChatEntity);
        a();
        return;
      }
    }
  }
  
  void a(String paramString)
  {
    synchronized (this.d)
    {
      this.d.remove(paramString);
      a();
      return;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.d.contains(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      a(a(paramString, paramInt));
      return;
    }
    a(paramString);
  }
  
  public ArrayList<HiddenChatEntity> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b.getString("KeyHiddenChatList", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString = localObject[i].split("\\|");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            try
            {
              HiddenChatEntity localHiddenChatEntity = new HiddenChatEntity();
              localHiddenChatEntity.a = arrayOfString[0];
              localHiddenChatEntity.b = Integer.parseInt(arrayOfString[1]);
              localArrayList.add(localHiddenChatEntity);
            }
            catch (Throwable localThrowable)
            {
              QLog.e("tag_hidden_chat", 2, localThrowable, new Object[0]);
            }
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void c()
  {
    if (!this.c.get())
    {
      d();
      this.c.set(true);
    }
  }
  
  boolean d()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        Object localObject1 = b();
        if (QLog.isColorLevel())
        {
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            QLog.d("tag_hidden_chat", 2, new Object[] { "doInitAllHidden(), dataList.size is ", Integer.valueOf(i) });
          }
        }
        else
        {
          if (localObject1 != null) {
            synchronized (this.d)
            {
              this.d.clear();
              localObject1 = ((List)localObject1).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                HiddenChatEntity localHiddenChatEntity = (HiddenChatEntity)((Iterator)localObject1).next();
                this.d.put(localHiddenChatEntity.a, localHiddenChatEntity);
                continue;
              }
              return true;
            }
          }
          StringBuilder localStringBuilder;
          return bool;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doInitAllHidden exception:");
          localStringBuilder.append(localException.getMessage());
          QLog.e("tag_hidden_chat", 2, localStringBuilder.toString());
        }
        bool = false;
      }
      int i = 0;
    }
  }
  
  public void onDestroy()
  {
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatManager
 * JD-Core Version:    0.7.0.1
 */