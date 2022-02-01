package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import anvl;
import aomi;
import aqzq;
import asde;
import avtm;
import awjw;
import bezv;
import bezw;
import bhnv;
import bmgk;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.qphone.base.util.BaseApplication;
import protocol.KQQConfig.GetResourceReqInfo;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  public int a()
  {
    ((awjw)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(128)).a();
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
    ((bmgk)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(27)).a();
    ((asde)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(77)).a(true);
    localObject = (anvl)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(4);
    ((anvl)localObject).a(null, new GetResourceReqInfo[] { ((anvl)localObject).d(), ((anvl)localObject).f(), ((anvl)localObject).b(), ((anvl)localObject).e(), ((anvl)localObject).c() });
    if (!"5.0.2".equals(Build.VERSION.RELEASE))
    {
      int i = bhnv.b(BaseApplication.getContext());
      if ((i == 1) || (i == 4))
      {
        localObject = new GetConfig.1(this);
        bezv localbezv = (bezv)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(193);
        if (!localbezv.a()) {
          break label264;
        }
        localbezv.a(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new bezw(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, "tvk_sdkmgr", (Runnable)localObject, 4000L));
      }
    }
    for (;;)
    {
      avtm.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app).b();
      return 2;
      label264:
      ((Runnable)localObject).run();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new aomi(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.b(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */