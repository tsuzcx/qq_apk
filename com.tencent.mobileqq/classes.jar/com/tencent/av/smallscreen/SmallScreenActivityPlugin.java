package com.tencent.av.smallscreen;

import com.tencent.av.smallscreen.api.ISmallScreenActivityPluginHelperApi;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenActivityPlugin
{
  private static volatile SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  BaseVideoAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = true;
  
  private SmallScreenActivityPlugin(BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface = paramBaseVideoAppInterface;
  }
  
  public static SmallScreenActivityPlugin a(BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    if (jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin == null) {
          jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = new SmallScreenActivityPlugin(paramBaseVideoAppInterface);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  }
  
  public void a()
  {
    if (SmallScreenUtils.f()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ((ISmallScreenActivityPluginHelperApi)QRoute.api(ISmallScreenActivityPluginHelperApi.class)).onPauseRender(paramLong, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface, this.b, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (SmallScreenUtils.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!SmallScreenUtils.f());
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenActivityPlugin", 1, localStringBuilder.toString());
    }
    if (SmallScreenUtils.f())
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = true;
      ThreadManager.excute(new SmallScreenActivityPlugin.1(this, l), 16, null, false);
    }
    SmallScreenUtils.a(l, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface, 0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenActivityPlugin
 * JD-Core Version:    0.7.0.1
 */