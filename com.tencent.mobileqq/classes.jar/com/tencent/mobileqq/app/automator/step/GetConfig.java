package com.tencent.mobileqq.app.automator.step;

import alqf;
import amia;
import android.os.Build.VERSION;
import aojv;
import apks;
import asub;
import atko;
import bbaa;
import bbab;
import bdin;
import biqn;
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
    ((atko)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(128)).a();
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
    ((biqn)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(27)).a();
    ((apks)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(77)).a(true);
    localObject = (alqf)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(4);
    ((alqf)localObject).a(null, new GetResourceReqInfo[] { ((alqf)localObject).d(), ((alqf)localObject).f(), ((alqf)localObject).b(), ((alqf)localObject).e(), ((alqf)localObject).c() });
    if (!"5.0.2".equals(Build.VERSION.RELEASE))
    {
      int i = bdin.b(BaseApplication.getContext());
      if ((i == 1) || (i == 4))
      {
        localObject = new GetConfig.1(this);
        bbaa localbbaa = (bbaa)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(193);
        if (!localbbaa.a()) {
          break label264;
        }
        localbbaa.a(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new bbab(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, "tvk_sdkmgr", (Runnable)localObject, 4000L));
      }
    }
    for (;;)
    {
      asub.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app).b();
      return 2;
      label264:
      ((Runnable)localObject).run();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new amia(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.b(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */