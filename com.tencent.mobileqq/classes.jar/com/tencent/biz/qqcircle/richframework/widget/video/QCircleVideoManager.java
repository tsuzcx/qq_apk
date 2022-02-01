package com.tencent.biz.qqcircle.richframework.widget.video;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.richframework.video.QCirclePlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleVideoManager
{
  private static volatile QCircleVideoManager a;
  private ConcurrentHashMap<String, QCirclePlayer> b = new ConcurrentHashMap();
  private ConcurrentHashMap<String, QCirclePlayer> c = new ConcurrentHashMap();
  
  private QCircleVideoManager()
  {
    b();
  }
  
  public static QCircleVideoManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleVideoManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Iterator<Map.Entry<String, QCirclePlayer>> paramIterator)
  {
    if (paramIterator == null) {
      return;
    }
    while (paramIterator.hasNext())
    {
      ((QCirclePlayer)((Map.Entry)paramIterator.next()).getValue()).f();
      paramIterator.remove();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Iterator localIterator = this.c.entrySet().iterator();
      break label35;
      localIterator = this.b.entrySet().iterator();
      label35:
      a(localIterator);
      return;
    }
    finally {}
  }
  
  private void b()
  {
    if (!QCirclePluginInitHelper.isVideoSDKReady()) {
      try
      {
        HostDataTransUtils.initVideoSdk(new QCircleVideoManager.1(this));
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("QCircleVideoManager", 1, localRuntimeException.getMessage());
        localRuntimeException.printStackTrace();
      }
    }
  }
  
  public QCirclePlayer a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("when newAQCirclePlayer release players, size:");
      ((StringBuilder)localObject).append(this.b.size());
      QLog.d("QCircleVideoManager", 1, ((StringBuilder)localObject).toString());
      a(paramBoolean);
      localObject = new QCirclePlayer();
      if (paramBoolean) {
        this.c.put(paramString, localObject);
      } else {
        this.b.put(paramString, localObject);
      }
      return localObject;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Object localObject = b(paramString);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("releasePlayer is null:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QCircleVideoManager", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releasePlayer :");
      localStringBuilder.append(paramString);
      QLog.d("QCircleVideoManager", 1, localStringBuilder.toString());
      if (this.b.containsKey(paramString)) {
        this.b.remove(paramString);
      } else {
        this.c.remove(paramString);
      }
      ((QCirclePlayer)localObject).f();
      return true;
    }
    finally {}
  }
  
  public QCirclePlayer b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.b.containsKey(paramString)) {
      return (QCirclePlayer)this.b.get(paramString);
    }
    if (this.c.containsKey(paramString)) {
      return (QCirclePlayer)this.c.get(paramString);
    }
    QLog.d("QCircleVideoManager", 1, "getPlayer null ");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.video.QCircleVideoManager
 * JD-Core Version:    0.7.0.1
 */