package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import sqs;
import srn;
import sxp;
import sxq;
import sxr;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(sqs paramsqs, String paramString, sxr paramsxr, sxq paramsxq) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Sxr.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Sxq.a(this.jdField_a_of_type_Sxr);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new srn("", this.jdField_a_of_type_JavaLangString));
    new sxp(this.jdField_a_of_type_Sxq).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */