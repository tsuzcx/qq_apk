package com.tencent.biz.viewplugin;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ViewPluginManager$3
  implements Runnable
{
  ViewPluginManager$3(ViewPluginManager paramViewPluginManager) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://");
    ((StringBuilder)localObject).append(this.this$0.b);
    ((StringBuilder)localObject).append("?_bid=");
    ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangString);
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.b((String)localObject, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginManager.3
 * JD-Core Version:    0.7.0.1
 */