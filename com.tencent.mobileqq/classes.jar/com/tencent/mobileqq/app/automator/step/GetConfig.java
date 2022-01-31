package com.tencent.mobileqq.app.automator.step;

import allq;
import amdl;
import android.os.Build.VERSION;
import aofm;
import apgj;
import asps;
import atgf;
import bavr;
import bavs;
import bdee;
import bimg;
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
    ((atgf)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(128)).a();
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
    ((bimg)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(27)).a();
    ((apgj)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(77)).a(true);
    localObject = (allq)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(4);
    ((allq)localObject).a(null, new GetResourceReqInfo[] { ((allq)localObject).d(), ((allq)localObject).f(), ((allq)localObject).b(), ((allq)localObject).e(), ((allq)localObject).c() });
    if (!"5.0.2".equals(Build.VERSION.RELEASE))
    {
      int i = bdee.b(BaseApplication.getContext());
      if ((i == 1) || (i == 4))
      {
        localObject = new GetConfig.1(this);
        bavr localbavr = (bavr)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(193);
        if (!localbavr.a()) {
          break label264;
        }
        localbavr.a(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new bavs(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, "tvk_sdkmgr", (Runnable)localObject, 4000L));
      }
    }
    for (;;)
    {
      asps.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app).b();
      return 2;
      label264:
      ((Runnable)localObject).run();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new amdl(this, null);
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