package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import wtt;
import wuo;
import xaq;
import xar;
import xas;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(wtt paramwtt, String paramString, xas paramxas, xar paramxar) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Xas.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Xar.a(this.jdField_a_of_type_Xas);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new wuo("", this.jdField_a_of_type_JavaLangString));
    new xaq(this.jdField_a_of_type_Xar).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */