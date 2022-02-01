package com.tencent.comic;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.comic.api.plugin.PreloadPublicParam;
import com.tencent.comic.api.plugin.PreloadServerParam;
import com.tencent.comic.utils.AppHelper;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQComicPreloadManager
{
  AppRuntime a;
  public AtomicReference<PreloadServerParam> b;
  public AtomicReference<PreloadPublicParam> c;
  public AtomicInteger d;
  private SparseArray<QQComicPreloadStrategy> e;
  private boolean f = false;
  
  public QQComicPreloadManager(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.e = new SparseArray();
    this.b = new AtomicReference(null);
    this.c = new AtomicReference(null);
    this.d = new AtomicInteger(-1);
  }
  
  public QQComicPreloadStrategy a(int paramInt)
  {
    QQComicPreloadStrategy localQQComicPreloadStrategy2 = (QQComicPreloadStrategy)this.e.get(paramInt, null);
    QQComicPreloadStrategy localQQComicPreloadStrategy1 = localQQComicPreloadStrategy2;
    if (localQQComicPreloadStrategy2 == null)
    {
      if ((paramInt != 5) && (paramInt != 6) && (paramInt != 9999)) {
        return localQQComicPreloadStrategy2;
      }
      localQQComicPreloadStrategy1 = new QQComicPreloadStrategy(paramInt);
      this.e.put(paramInt, localQQComicPreloadStrategy1);
    }
    return localQQComicPreloadStrategy1;
  }
  
  public void a()
  {
    this.a = null;
    this.e.clear();
  }
  
  public void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = AppHelper.a().getSharedPreferences("qqcomic_preload_profile", SecMsgUtil.a()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("active_time");
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public void b()
  {
    if (this.f) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.f) {
          return;
        }
        Object localObject1 = new PreloadServerParam(AppHelper.a(), 1113, this.a.getCurrentAccountUin());
        if (((PreloadServerParam)localObject1).a != -1)
        {
          this.b.set(localObject1);
          this.f = true;
          localObject1 = ((PreloadServerParam)localObject1).e;
          try
          {
            localObject1 = new JSONObject((String)localObject1);
            Object localObject3 = localObject1;
            try
            {
              if (!((JSONObject)localObject1).has("publicaccount")) {
                continue;
              }
              localObject3 = ((JSONObject)localObject1).getJSONObject("publicaccount");
              AtomicInteger localAtomicInteger = this.d;
              if (!((JSONObject)localObject3).getBoolean("switch")) {
                break label283;
              }
              i = 1;
              localAtomicInteger.set(i);
              localObject3 = localObject1;
            }
            catch (Exception localException1) {}
            localException2.printStackTrace();
          }
          catch (Exception localException2)
          {
            localObject1 = null;
          }
          Object localObject4 = localObject1;
          if (localObject4 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQComicPreloadManager", 2, "cannot resolve strategy from server.");
            }
            return;
          }
          localObject4 = PreloadPublicParam.a((JSONObject)localObject4);
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = new PreloadPublicParam();
            ((PreloadPublicParam)localObject1).b = true;
            ((PreloadPublicParam)localObject1).c = 127;
            ((PreloadPublicParam)localObject1).d = 16777215;
            ((PreloadPublicParam)localObject1).l = true;
            ((PreloadPublicParam)localObject1).e = true;
            ((PreloadPublicParam)localObject1).g = true;
            ((PreloadPublicParam)localObject1).h = true;
            ((PreloadPublicParam)localObject1).m = true;
            ((PreloadPublicParam)localObject1).n = 24;
            ((PreloadPublicParam)localObject1).o = true;
            ((PreloadPublicParam)localObject1).p = 20;
            ((PreloadPublicParam)localObject1).q = true;
            ((PreloadPublicParam)localObject1).r = 6;
            ((PreloadPublicParam)localObject1).s = 1;
            ((PreloadPublicParam)localObject1).t = 3;
          }
          this.c.set(localObject1);
          return;
        }
        return;
      }
      finally {}
      label283:
      int i = 0;
    }
  }
  
  public void b(int paramInt)
  {
    PluginPreloader.a(new PluginPreloadStrategy(a(paramInt)));
  }
  
  public long c()
  {
    SharedPreferences localSharedPreferences = AppHelper.a().getSharedPreferences("qqcomic_preload_profile", SecMsgUtil.a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("active_time");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public int d()
  {
    SharedPreferences localSharedPreferences = AppHelper.a().getSharedPreferences("qqcomic_preload_profile", SecMsgUtil.a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("use_times");
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public int[] e()
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = AppHelper.a().getSharedPreferences("qqcomic_preload_profile", SecMsgUtil.a());
    int i = 0;
    while (i < 24)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append("use_times");
      localStringBuilder.append("_");
      localStringBuilder.append(i);
      arrayOfInt[i] = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void f()
  {
    String str = this.a.getCurrentAccountUin();
    Object localObject1 = AppHelper.a().getSharedPreferences("qqcomic_preload_profile", SecMsgUtil.a());
    int i = d();
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append("use_times");
    ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), i + 1).commit();
    i = Calendar.getInstance().get(11);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append("use_times");
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(i);
    int j = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
    localObject1 = ((SharedPreferences)localObject1).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append("use_times");
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(i);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), j + 1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.QQComicPreloadManager
 * JD-Core Version:    0.7.0.1
 */