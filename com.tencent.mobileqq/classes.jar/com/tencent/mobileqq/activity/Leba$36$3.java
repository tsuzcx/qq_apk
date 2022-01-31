package com.tencent.mobileqq.activity;

import adgt;
import alud;
import android.widget.TextView;
import bczz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Leba$36$3
  implements Runnable
{
  Leba$36$3(Leba.36 param36, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null)
      {
        Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setVisibility(0);
        Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setText(this.jdField_a_of_type_JavaLangString);
      }
      if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null) {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setVisibility(8);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      if ((Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null) && (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null)) {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).a(localArrayList);
      }
      if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null) {
        bczz.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0), alud.a(2131706392));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.36.3
 * JD-Core Version:    0.7.0.1
 */