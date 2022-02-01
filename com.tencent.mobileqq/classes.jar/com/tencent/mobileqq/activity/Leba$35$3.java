package com.tencent.mobileqq.activity;

import aenj;
import android.widget.TextView;
import anni;
import bgfz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Leba$35$3
  implements Runnable
{
  Leba$35$3(Leba.35 param35, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null)
      {
        Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(0);
        Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setText(this.jdField_a_of_type_JavaLangString);
      }
      if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      if ((Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) && (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null)) {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).a(localArrayList);
      }
      if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
        bgfz.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), anni.a(2131704803));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.3
 * JD-Core Version:    0.7.0.1
 */