package com.tencent.av.smallscreen;

import com.tencent.av.smallscreen.api.ISmallScreenActivityPluginHelperApi;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenActivityPlugin
{
  private static volatile SmallScreenActivityPlugin d;
  boolean a = false;
  boolean b = true;
  BaseVideoAppInterface c;
  
  private SmallScreenActivityPlugin(BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    this.c = paramBaseVideoAppInterface;
  }
  
  public static SmallScreenActivityPlugin a(BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new SmallScreenActivityPlugin(paramBaseVideoAppInterface);
        }
      }
      finally {}
    }
    return d;
  }
  
  public void a()
  {
    if (SmallScreenUtils.g()) {
      this.a = false;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ((ISmallScreenActivityPluginHelperApi)QRoute.api(ISmallScreenActivityPluginHelperApi.class)).onPauseRender(paramLong, this.c, this.b, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (SmallScreenUtils.g())
    {
      this.a = false;
      this.b = false;
    }
  }
  
  public void b()
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenActivityPlugin", 1, localStringBuilder.toString());
    }
    if (SmallScreenUtils.g())
    {
      this.a = false;
      this.b = true;
      ThreadManager.excute(new SmallScreenActivityPlugin.1(this, l), 16, null, false);
    }
    SmallScreenUtils.a(l, this.c, 0);
  }
  
  public boolean c()
  {
    return (this.a) || (!SmallScreenUtils.g());
  }
  
  public void d()
  {
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin
 * JD-Core Version:    0.7.0.1
 */