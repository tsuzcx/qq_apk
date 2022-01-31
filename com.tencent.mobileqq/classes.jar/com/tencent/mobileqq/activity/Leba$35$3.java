package com.tencent.mobileqq.activity;

import abai;
import abbj;
import ajjy;
import android.widget.TextView;
import azve;
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
      if (abai.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null)
      {
        abai.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(0);
        abai.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setText(this.jdField_a_of_type_JavaLangString);
      }
      if (abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
        abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      if ((abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) && (abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null)) {
        abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).a(localArrayList);
      }
      if (abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
        azve.a(abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), ajjy.a(2131640212));
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
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.3
 * JD-Core Version:    0.7.0.1
 */