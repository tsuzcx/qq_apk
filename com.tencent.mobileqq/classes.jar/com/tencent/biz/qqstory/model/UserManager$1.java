package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import vvj;
import vwe;
import wcg;
import wch;
import wci;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(vvj paramvvj, String paramString, wci paramwci, wch paramwch) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Wci.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Wch.a(this.jdField_a_of_type_Wci);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new vwe("", this.jdField_a_of_type_JavaLangString));
    new wcg(this.jdField_a_of_type_Wch).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */