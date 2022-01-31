package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.ArrayList;
import java.util.List;
import uwm;
import uxh;
import vdj;
import vdk;
import vdl;

public class UserManager$1
  implements Runnable
{
  public UserManager$1(uwm paramuwm, String paramString, vdl paramvdl, vdk paramvdk) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_Vdl.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_Vdk.a(this.jdField_a_of_type_Vdl);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new uxh("", this.jdField_a_of_type_JavaLangString));
    new vdj(this.jdField_a_of_type_Vdk).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */