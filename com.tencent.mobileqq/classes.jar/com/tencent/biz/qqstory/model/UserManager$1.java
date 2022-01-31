package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import usd;
import usy;
import uza;
import uzb;
import uzc;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(usd paramusd, String paramString, uzc paramuzc, uzb paramuzb) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Uzc.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Uzb.a(this.jdField_a_of_type_Uzc);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new usy("", this.jdField_a_of_type_JavaLangString));
    new uza(this.jdField_a_of_type_Uzb).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */