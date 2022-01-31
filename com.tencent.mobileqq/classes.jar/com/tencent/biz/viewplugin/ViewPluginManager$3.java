package com.tencent.biz.viewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mze;
import xjm;

public class ViewPluginManager$3
  implements Runnable
{
  public ViewPluginManager$3(xjm paramxjm) {}
  
  public void run()
  {
    String str = "http://" + this.this$0.b + "?_bid=" + this.this$0.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "checkOfflineUpNotCallback.");
    }
    mze.b(str, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager.3
 * JD-Core Version:    0.7.0.1
 */