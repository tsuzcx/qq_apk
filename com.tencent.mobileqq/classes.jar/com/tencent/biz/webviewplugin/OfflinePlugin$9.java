package com.tencent.biz.webviewplugin;

import abff;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import txl;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(abff paramabff) {}
  
  public void run()
  {
    if (abff.jdField_a_of_type_JavaUtilHashMap != null)
    {
      txl localtxl = (txl)abff.jdField_a_of_type_JavaUtilHashMap.get(abff.a(this.this$0));
      if ((localtxl != null) && (localtxl.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localtxl.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */