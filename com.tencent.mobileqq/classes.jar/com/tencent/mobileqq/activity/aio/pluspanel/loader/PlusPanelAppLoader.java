package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.filter.AppInfoFilter;
import com.tencent.mobileqq.activity.aio.pluspanel.filter.SharpAudioSupportFilter;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.appinfo.AppInfoFactory;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public abstract class PlusPanelAppLoader
{
  protected int a = -1;
  protected final AppInfoFactory b = new AppInfoFactory();
  final List<AppInfoFilter> c = new ArrayList();
  public PlusPanelAppLoader.ShortVideoRecordConfig d = new PlusPanelAppLoader.DefaultShortVideoRecordConfig(null);
  public PlusPanelAppLoader.ScribbleResMgrShowConfig e = new PlusPanelAppLoader.DefaultScribbleResMgrShowConfig(null);
  private final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
  private final ArrayList<PlusPanelAppInfo> g = new ArrayList();
  
  public PlusPanelAppLoader()
  {
    a(new SharpAudioSupportFilter());
  }
  
  private Drawable b(QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return SimpleModeHelper.a(this, paramQQAppInterface, paramPlusPanelAppInfo, paramPlusPanelAppInfo.simpleDayUrl, paramPlusPanelAppInfo.simpleNightUrl, paramURLDrawableOptions);
  }
  
  private String c(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    String str = paramPlusPanelAppInfo.name;
    int i = LocaleManager.d();
    if (i != 1033)
    {
      if (i != 2052) {
        return str;
      }
      return paramPlusPanelAppInfo.name;
    }
    return paramPlusPanelAppInfo.enName;
  }
  
  protected Drawable a(QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = SimpleModeHelper.a(paramPlusPanelAppInfo);
      localURLDrawableOptions.mFailedDrawable = localResources.getDrawable(i);
      localURLDrawableOptions.mLoadingDrawable = localResources.getDrawable(i);
      if (SimpleUIUtil.e()) {
        return b(paramQQAppInterface, paramPlusPanelAppInfo, localURLDrawableOptions);
      }
      paramQQAppInterface = a(paramQQAppInterface, paramPlusPanelAppInfo, localURLDrawableOptions);
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      label66:
      break label66;
    }
    return localResources.getDrawable(2130844780);
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, PlusPanelAppInfo paramPlusPanelAppInfo, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    paramQQAppInterface = paramPlusPanelAppInfo.iconUrl;
    if (TextUtils.isEmpty(paramQQAppInterface))
    {
      int i = paramPlusPanelAppInfo.defaultDrawableID();
      if (i > 0) {
        return BaseApplicationImpl.getContext().getResources().getDrawable(i);
      }
      return BaseApplicationImpl.getContext().getResources().getDrawable(2130844780);
    }
    return URLDrawable.getDrawable(paramQQAppInterface, paramURLDrawableOptions);
  }
  
  public abstract PluginData a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt);
  
  protected String a(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    String str = c(paramPlusPanelAppInfo);
    if (TextUtils.isEmpty(str)) {
      return paramPlusPanelAppInfo.getTitle();
    }
    return str;
  }
  
  public List<PlusPanelAppInfo> a()
  {
    this.f.readLock().lock();
    try
    {
      ArrayList localArrayList = (ArrayList)this.g.clone();
      return localArrayList;
    }
    finally
    {
      this.f.readLock().unlock();
    }
  }
  
  protected void a(int paramInt)
  {
    if (SimpleUIUtil.e())
    {
      a(paramInt, 1104864054);
      a(paramInt, 1200000003);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f.writeLock().lock();
    try
    {
      PlusPanelAppInfo localPlusPanelAppInfo = this.b.a(paramInt1, paramInt2);
      if (localPlusPanelAppInfo != null) {
        this.g.add(localPlusPanelAppInfo);
      }
      return;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  public void a(int paramInt, PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    this.f.writeLock().lock();
    if (paramPlusPanelAppInfo != null) {
      try
      {
        if (paramPlusPanelAppInfo.getAppID() > 0) {
          if (paramInt >= 0) {
            this.g.add(paramInt, paramPlusPanelAppInfo);
          } else {
            this.g.add(paramPlusPanelAppInfo);
          }
        }
      }
      finally
      {
        this.f.writeLock().unlock();
      }
    }
    this.f.writeLock().unlock();
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.f.writeLock().lock();
    try
    {
      this.g.clear();
      this.f.writeLock().unlock();
      com.tencent.mobileqq.shortvideo.ShortVideoUtils.sSupportShortVideo = this.d.a();
      return;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
  }
  
  public void a(AppInfoFilter paramAppInfoFilter)
  {
    if (paramAppInfoFilter != null) {
      this.c.add(paramAppInfoFilter);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((AppInfoFilter)localIterator.next()).a(this, paramQQAppInterface, paramInt, paramString);
    }
  }
  
  public int b()
  {
    this.f.readLock().lock();
    try
    {
      int i = this.g.size();
      return i;
    }
    finally
    {
      this.f.readLock().unlock();
    }
  }
  
  public PlusPanelAppInfo b(int paramInt)
  {
    this.f.readLock().lock();
    int i = 0;
    try
    {
      int j = this.g.size();
      while (i < j)
      {
        PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)this.g.get(i);
        if (localPlusPanelAppInfo != null)
        {
          int k = localPlusPanelAppInfo.getAppID();
          if (k == paramInt)
          {
            this.f.readLock().unlock();
            return localPlusPanelAppInfo;
          }
        }
        i += 1;
      }
      this.f.readLock().unlock();
      return null;
    }
    finally
    {
      this.f.readLock().unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(PlusPanelAppInfo paramPlusPanelAppInfo)
  {
    a(-1, paramPlusPanelAppInfo);
  }
  
  public int c()
  {
    return this.a;
  }
  
  public void c(int paramInt)
  {
    this.f.writeLock().lock();
    int i = 0;
    try
    {
      int j = this.g.size();
      while (i < j)
      {
        PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)this.g.get(i);
        if ((localPlusPanelAppInfo != null) && (localPlusPanelAppInfo.getAppID() == paramInt))
        {
          this.g.remove(i);
          break;
        }
        i += 1;
      }
      this.f.writeLock().unlock();
      return;
    }
    finally
    {
      this.f.writeLock().unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */