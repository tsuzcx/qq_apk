package com.tencent.biz.webviewplugin;

import aabq;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import uea;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(aabq paramaabq) {}
  
  public void run()
  {
    if (aabq.jdField_a_of_type_JavaUtilHashMap != null)
    {
      uea localuea = (uea)aabq.jdField_a_of_type_JavaUtilHashMap.get(aabq.a(this.this$0));
      if ((localuea != null) && (localuea.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localuea.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */