package com.tencent.mobileqq.app;

import alkv;
import allj;
import aloz;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchManager$4$1
  implements Runnable
{
  ConditionSearchManager$4$1(ConditionSearchManager.4 param4) {}
  
  public void run()
  {
    try
    {
      if (this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        Card localCard = this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataCard;
        Object localObject;
        String str;
        if (localCard.strLocationCodes != null)
        {
          localObject = localCard.strLocationCodes.split("-");
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "parse location codes: " + localCard.strLocationCodes);
          }
          str = this.a.this$0.a((String[])localObject);
          localObject = str;
          if (str.equals("不限")) {
            localObject = "";
          }
          localCard.strLocationDesc = ((String)localObject);
        }
        if (localCard.strHometownCodes != null)
        {
          localObject = localCard.strHometownCodes.split("-");
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "parse hometown codes: " + localCard.strHometownCodes);
          }
          str = this.a.this$0.a((String[])localObject);
          localObject = str;
          if (str.equals("不限")) {
            localObject = "";
          }
          localCard.strHometownDesc = ((String)localObject);
        }
        ((aloz)allj.a(this.a.this$0).getManager(51)).a(localCard);
        ((alkv)allj.a(this.a.this$0).a(2)).notifyUI(43, true, localCard);
      }
      this.a.this$0.d = false;
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqDataCard = null;
      this.a.this$0.b(this.a.this$0.jdField_a_of_type_JavaLangObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConditionSearch.Manager", 1, "pendCardParseRequest fail!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.4.1
 * JD-Core Version:    0.7.0.1
 */