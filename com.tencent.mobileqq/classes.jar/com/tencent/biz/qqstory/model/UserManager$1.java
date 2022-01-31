package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import tdo;
import tej;
import tkl;
import tkm;
import tkn;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(tdo paramtdo, String paramString, tkn paramtkn, tkm paramtkm) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Tkn.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Tkm.a(this.jdField_a_of_type_Tkn);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new tej("", this.jdField_a_of_type_JavaLangString));
    new tkl(this.jdField_a_of_type_Tkm).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */