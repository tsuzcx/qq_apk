package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import wpy;
import wqt;
import wwv;
import www;
import wwx;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(wpy paramwpy, String paramString, wwx paramwwx, www paramwww) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Wwx.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Www.a(this.jdField_a_of_type_Wwx);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new wqt("", this.jdField_a_of_type_JavaLangString));
    new wwv(this.jdField_a_of_type_Www).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */