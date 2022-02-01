package com.tencent.biz.webviewplugin;

import aarc;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import urx;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(aarc paramaarc) {}
  
  public void run()
  {
    if (aarc.jdField_a_of_type_JavaUtilHashMap != null)
    {
      urx localurx = (urx)aarc.jdField_a_of_type_JavaUtilHashMap.get(aarc.a(this.this$0));
      if ((localurx != null) && (localurx.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localurx.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */