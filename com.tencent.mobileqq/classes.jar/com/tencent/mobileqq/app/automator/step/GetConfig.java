package com.tencent.mobileqq.app.automator.step;

import ajud;
import aklv;
import amoo;
import android.os.Build.VERSION;
import anpc;
import aqze;
import arpl;
import ayxs;
import ayxt;
import bbfj;
import bglh;
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
    ((arpl)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(128)).a();
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
    ((bglh)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(27)).a();
    ((anpc)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(77)).a(true);
    localObject = (ajud)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(4);
    ((ajud)localObject).a(null, new GetResourceReqInfo[] { ((ajud)localObject).d(), ((ajud)localObject).f(), ((ajud)localObject).b(), ((ajud)localObject).e(), ((ajud)localObject).c() });
    if (!"5.0.2".equals(Build.VERSION.RELEASE))
    {
      int i = bbfj.b(BaseApplication.getContext());
      if ((i == 1) || (i == 4))
      {
        localObject = new GetConfig.1(this);
        ayxs localayxs = (ayxs)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(193);
        if (!localayxs.a()) {
          break label264;
        }
        localayxs.a(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new ayxt(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, "tvk_sdkmgr", (Runnable)localObject, 4000L));
      }
    }
    for (;;)
    {
      aqze.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app).b();
      return 2;
      label264:
      ((Runnable)localObject).run();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new aklv(this, null);
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