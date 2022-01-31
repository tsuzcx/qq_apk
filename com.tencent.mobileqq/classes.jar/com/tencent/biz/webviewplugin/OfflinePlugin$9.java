package com.tencent.biz.webviewplugin;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import seh;
import xlb;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(xlb paramxlb) {}
  
  public void run()
  {
    if (xlb.jdField_a_of_type_JavaUtilHashMap != null)
    {
      seh localseh = (seh)xlb.jdField_a_of_type_JavaUtilHashMap.get(xlb.a(this.this$0));
      if ((localseh != null) && (localseh.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localseh.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */