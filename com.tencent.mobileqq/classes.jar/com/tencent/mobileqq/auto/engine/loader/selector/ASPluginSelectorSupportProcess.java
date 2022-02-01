package com.tencent.mobileqq.auto.engine.loader.selector;

import android.os.Build.VERSION;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.qphone.base.util.QLog;

public class ASPluginSelectorSupportProcess
  extends ASBaseSelectorProcess
{
  private boolean b()
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      QLog.i("ASDynamicEngine", 1, "ASPluginSelectorSupportProcess#isUnSupport():false");
      return false;
    }
    QLog.i("ASDynamicEngine", 1, "ASPluginSelectorSupportProcess#isUnSupport():true");
    return true;
  }
  
  public ASPluginBean a()
  {
    if (b()) {
      return new ASPluginBean();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.selector.ASPluginSelectorSupportProcess
 * JD-Core Version:    0.7.0.1
 */