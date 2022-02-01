package com.tencent.biz.webviewplugin;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import java.util.HashMap;

class OfflinePlugin$9
  implements Runnable
{
  OfflinePlugin$9(OfflinePlugin paramOfflinePlugin) {}
  
  public void run()
  {
    if (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap != null)
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.a(this.this$0));
      if ((localOfflineUpdateStatus != null) && (localOfflineUpdateStatus.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localOfflineUpdateStatus.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */