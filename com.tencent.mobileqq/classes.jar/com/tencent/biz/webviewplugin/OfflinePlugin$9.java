package com.tencent.biz.webviewplugin;

import abbc;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import txj;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(abbc paramabbc) {}
  
  public void run()
  {
    if (abbc.jdField_a_of_type_JavaUtilHashMap != null)
    {
      txj localtxj = (txj)abbc.jdField_a_of_type_JavaUtilHashMap.get(abbc.a(this.this$0));
      if ((localtxj != null) && (localtxj.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localtxj.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */