package com.tencent.biz.webviewplugin;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import rrs;
import xce;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(xce paramxce) {}
  
  public void run()
  {
    if (xce.jdField_a_of_type_JavaUtilHashMap != null)
    {
      rrs localrrs = (rrs)xce.jdField_a_of_type_JavaUtilHashMap.get(xce.a(this.this$0));
      if ((localrrs != null) && (localrrs.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localrrs.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */