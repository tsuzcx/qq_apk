package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import tdl;
import teg;
import tki;
import tkj;
import tkk;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(tdl paramtdl, String paramString, tkk paramtkk, tkj paramtkj) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Tkk.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Tkj.a(this.jdField_a_of_type_Tkk);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new teg("", this.jdField_a_of_type_JavaLangString));
    new tki(this.jdField_a_of_type_Tkj).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */