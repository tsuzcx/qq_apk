package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import wke;
import wkz;
import wrb;
import wrc;
import wrd;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(wke paramwke, String paramString, wrd paramwrd, wrc paramwrc) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Wrd.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Wrc.a(this.jdField_a_of_type_Wrd);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new wkz("", this.jdField_a_of_type_JavaLangString));
    new wrb(this.jdField_a_of_type_Wrc).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */