package com.tencent.biz.richframework.activity;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWCompactUtil;
import com.tencent.mobileqq.auto.engine.skin.AutoShadowNormalFactory2;
import com.tencent.mobileqq.auto.engine.skin.entity.SkinItem;
import com.tencent.mobileqq.qcircle.api.event.HostActivityResultEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;

public class ComponentBaseActivity
  extends FragmentActivity
  implements SimpleEventReceiver
{
  private SparseArray<List> a = new SparseArray();
  private Handler b;
  protected HashMap<View, SkinItem> c = new HashMap();
  private boolean d;
  
  private void a()
  {
    this.d = true;
  }
  
  private void b() {}
  
  @TargetApi(24)
  public void a(Object paramObject, int paramInt, String... paramVarArgs)
  {
    boolean bool = QLog.isColorLevel();
    int j = 1;
    if (bool) {
      QLog.d("qqBaseActivity", 2, new Object[] { "fight.requestPermissions-", paramVarArgs });
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramVarArgs.length;
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = paramVarArgs[i];
      if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission((String)localObject) != 0)) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      localObject = (List)this.a.get(paramInt);
      paramVarArgs = (String[])localObject;
      if (localObject == null) {
        paramVarArgs = new ArrayList();
      }
      k = paramVarArgs.size();
      i = 0;
      while (i < k)
      {
        localObject = paramVarArgs.get(i);
        if ((localObject != null) && (localObject == paramObject))
        {
          i = j;
          break label194;
        }
        i += 1;
      }
      i = 0;
      label194:
      if (i == 0)
      {
        paramVarArgs.add(paramObject);
        this.a.put(paramInt, paramVarArgs);
      }
      requestPermissions((String[])localArrayList.toArray(new String[localArrayList.size()]), paramInt);
      return;
    }
    if ((paramObject instanceof QQPermissionCallback))
    {
      ((QQPermissionCallback)paramObject).grant(paramInt, paramVarArgs, null);
      return;
    }
    QQPermissionHelper.doExecuteSuccess(paramObject, paramInt);
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public int checkSelfPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return super.checkSelfPermission(paramString);
    }
    return 0;
  }
  
  public Handler d()
  {
    if (this.b == null) {
      this.b = new Handler(Looper.getMainLooper());
    }
    return this.b;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HostActivityResultEvent.class);
    return localArrayList;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    if (c()) {
      LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), new AutoShadowNormalFactory2(this.c));
    }
    super.onCreate(paramBundle);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    a();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof HostActivityResultEvent))
    {
      paramSimpleBaseEvent = (HostActivityResultEvent)paramSimpleBaseEvent;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(": onActivityResult receive event, currentHashCode:");
      localStringBuilder.append(hashCode());
      localStringBuilder.append(",hostHashCode:");
      localStringBuilder.append(getBaseContext().hashCode());
      localStringBuilder.append(", shadowHashCode:");
      localStringBuilder.append(paramSimpleBaseEvent.getShadowTopContextHashCode());
      QLog.i("ComponentBaseActivity", 1, localStringBuilder.toString());
      onActivityResult(paramSimpleBaseEvent.getRequestCode(), paramSimpleBaseEvent.getResultCode(), paramSimpleBaseEvent.getIntent());
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {
      return;
    }
    List localList = (List)this.a.get(paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (localObject != null) {
          if ((localObject instanceof QQPermissionCallback))
          {
            localObject = (QQPermissionCallback)localObject;
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            while (i < paramArrayOfInt.length)
            {
              if (paramArrayOfInt[i] != 0) {
                localArrayList.add(paramArrayOfString[i]);
              }
              i += 1;
            }
            if (localArrayList.size() > 0) {
              ((QQPermissionCallback)localObject).deny(paramInt, paramArrayOfString, paramArrayOfInt);
            } else {
              ((QQPermissionCallback)localObject).grant(paramInt, paramArrayOfString, paramArrayOfInt);
            }
          }
          else
          {
            QQPermissionHelper.requestResult(localObject, paramInt, paramArrayOfString, paramArrayOfInt);
          }
        }
      }
    }
    if (localList != null) {
      this.a.remove(paramInt);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume :");
    localStringBuilder.append(this.d);
    QLog.i("ComponentBaseActivity", 1, localStringBuilder.toString());
    if (this.d)
    {
      this.d = false;
      RFWCompactUtil.a(this);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.activity.ComponentBaseActivity
 * JD-Core Version:    0.7.0.1
 */