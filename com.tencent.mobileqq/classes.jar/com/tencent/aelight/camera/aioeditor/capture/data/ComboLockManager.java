package com.tencent.aelight.camera.aioeditor.capture.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.DataSet;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ComboLockManager
  implements IEventReceiver
{
  public static final String l;
  volatile boolean a = false;
  boolean b = true;
  HashMap<String, LockedCategory> c;
  VideoFilterTools.ComboFilterData d;
  AppInterface e = CaptureContext.a();
  ComboLockManager.StoryVideoPublishStatusReceiver f;
  int g = -1;
  LockedCategory h;
  public QIMFilterCategoryItem i;
  public boolean j = false;
  CardObserver k = new ComboLockManager.3(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PathUtils.a);
    localStringBuilder.append("/tencent/qim/share/");
    l = localStringBuilder.toString();
  }
  
  private void c()
  {
    if (this.f == null)
    {
      this.f = new ComboLockManager.StoryVideoPublishStatusReceiver(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "registerStoryReceiver");
      }
      StoryDispatcher.a().registerSubscriber(this.f);
    }
  }
  
  public LockedCategory a(String paramString)
  {
    return (LockedCategory)this.c.get(paramString);
  }
  
  public void a()
  {
    if (this.f != null)
    {
      this.f = new ComboLockManager.StoryVideoPublishStatusReceiver(this);
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "unregisterStoryReceiver");
      }
      StoryDispatcher.a().unRegisterSubscriber(this.f);
      this.f = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    if (this.d == paramComboFilterData)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ComboLockManager", 2, "same data");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateConfigData isfrist ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" sendStory ");
      ((StringBuilder)localObject).append(this.a);
      QLog.i("ComboLockManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b)
    {
      this.b = false;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateConfigData first card.snedSrory ");
        ((StringBuilder)localObject).append(this.a);
        QLog.i("ComboLockManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    this.c = paramComboFilterData.c;
    this.d = paramComboFilterData;
    paramComboFilterData = this.c.keySet().iterator();
    while (paramComboFilterData.hasNext())
    {
      localObject = (String)paramComboFilterData.next();
      localObject = (LockedCategory)this.c.get(localObject);
      ((LockedCategory)localObject).a = c(((LockedCategory)localObject).b);
      if ((((LockedCategory)localObject).a) && (((LockedCategory)localObject).e == 2))
      {
        this.h = ((LockedCategory)localObject);
        c();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateConfigData ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" lock ");
        localStringBuilder.append(((LockedCategory)localObject).a);
        QLog.i("ComboLockManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a(String paramString, Context paramContext)
  {
    boolean bool2 = c(paramString);
    boolean bool1 = true;
    if (bool2)
    {
      Object localObject2 = a(paramString).c;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("ComboLockManager", 1, "empty jump url");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://ti.qq.com/unlocked/index.html?_wv=536870912&id=");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("k_f_id", paramString);
      paramContext.startActivity((Intent)localObject2);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("handleLockItemClick id ");
        paramContext.append(paramString);
        QLog.i("ComboLockManager", 2, paramContext.toString());
        return true;
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ComboLockManager", 2, "handleSendStory");
    }
    this.a = true;
    StoryDispatcher.a().unRegisterSubscriber(this.f);
    Object localObject = (CardHandler)this.e.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    this.e.addObserver(this.k, true);
    if (this.h != null)
    {
      localObject = BaseApplicationImpl.getContext();
      ComboLockManager.1 local1 = new ComboLockManager.1(this, (Context)localObject);
      ThreadManager.getUIHandler().postDelayed(new ComboLockManager.2(this, (Context)localObject, local1), 1000L);
    }
  }
  
  public void b(String paramString)
  {
    paramString = (LockedCategory)this.c.get(paramString);
    if (paramString != null) {
      paramString.a = false;
    }
  }
  
  public boolean c(String paramString)
  {
    Object localObject1 = this.c;
    boolean bool1 = false;
    boolean bool2 = false;
    int m = 1;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      m = -1;
    }
    else
    {
      localObject1 = (LockedCategory)((HashMap)localObject1).get(paramString);
      if (localObject1 == null) {
        m = 0;
      } else if (((LockedCategory)localObject1).a) {
        if (((LockedCategory)localObject1).a())
        {
          m = 2;
        }
        else
        {
          if (((LockedCategory)localObject1).e == 2)
          {
            if (this.a)
            {
              localObject2 = this.i;
              bool1 = bool2;
              if (localObject2 != null)
              {
                bool1 = bool2;
                if (!((QIMFilterCategoryItem)localObject2).a.equals(paramString)) {}
              }
            }
            else
            {
              bool1 = true;
            }
          }
          else
          {
            bool1 = bool2;
            if (((LockedCategory)localObject1).e == 1)
            {
              if (!((LockedCategory)localObject1).f)
              {
                ((LockedCategory)localObject1).a = SharedPreUtils.bL(BaseApplicationImpl.getApplication(), paramString);
                ((LockedCategory)localObject1).f = true;
              }
              bool1 = ((LockedCategory)localObject1).a;
            }
          }
          m = 3;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("is locke ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" code");
      ((StringBuilder)localObject2).append(m);
      QLog.i("ComboLockManager", 2, ((StringBuilder)localObject2).toString());
      if (m == 3)
      {
        paramString = new StringBuilder();
        paramString.append("islock result");
        paramString.append(bool1);
        paramString.append(" type ");
        paramString.append(((LockedCategory)localObject1).e);
        paramString.append(" mHaveSendStory ");
        paramString.append(this.a);
        QLog.i("ComboLockManager", 2, paramString.toString());
      }
    }
    return bool1;
  }
  
  public void d(String paramString)
  {
    Object localObject1 = this.d.a(this.g).a;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label101;
        }
        Object localObject2 = (FilterCategory)((Iterator)localObject1).next();
        if (((FilterCategory)localObject2).c != null)
        {
          localObject2 = ((FilterCategory)localObject2).c.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
            if (!paramString.equals(localQIMFilterCategoryItem.a)) {
              break;
            }
            this.i = localQIMFilterCategoryItem;
          }
        }
      }
    }
    label101:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setLockingItem ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" result ");
      ((StringBuilder)localObject1).append(this.i);
      QLog.i("ComboLockManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.ComboLockManager
 * JD-Core Version:    0.7.0.1
 */