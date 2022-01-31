package com.tencent.biz.webviewplugin;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import swb;
import zej;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(zej paramzej) {}
  
  public void run()
  {
    if (zej.jdField_a_of_type_JavaUtilHashMap != null)
    {
      swb localswb = (swb)zej.jdField_a_of_type_JavaUtilHashMap.get(zej.a(this.this$0));
      if ((localswb != null) && (localswb.b() == 1))
      {
        if (this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.this$0.jdField_a_of_type_AndroidWidgetProgressBar != null) {
          this.this$0.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        localswb.a(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */