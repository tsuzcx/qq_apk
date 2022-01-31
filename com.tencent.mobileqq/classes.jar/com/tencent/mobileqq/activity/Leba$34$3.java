package com.tencent.mobileqq.activity;

import ablf;
import ajyc;
import android.widget.TextView;
import bawi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Leba$34$3
  implements Runnable
{
  Leba$34$3(Leba.34 param34, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0) != null)
      {
        Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0).setVisibility(0);
        Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0).setText(this.jdField_a_of_type_JavaLangString);
      }
      if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0) != null) {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0).setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      if ((Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0) != null) && (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0) != null)) {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0).a(localArrayList);
      }
      if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0) != null) {
        bawi.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$34.this$0), ajyc.a(2131705997));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.34.3
 * JD-Core Version:    0.7.0.1
 */