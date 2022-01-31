package com.tencent.mobileqq.activity.emogroupstore;

import ahsh;
import ahta;
import java.util.List;

public class SDKEmotionSettingManager$21
  implements Runnable
{
  public SDKEmotionSettingManager$21(ahsh paramahsh, int paramInt1, int paramInt2, String paramString, List paramList, int paramInt3) {}
  
  public void run()
  {
    if (ahsh.a(this.this$0) != null) {
      ahsh.a(this.this$0).dismiss();
    }
    ahsh.a(this.this$0, false);
    if (this.jdField_a_of_type_Int == this.b) {
      ahsh.a(this.this$0, ahsh.a(this.this$0), Long.valueOf(ahsh.a(this.this$0)).longValue(), true);
    }
    while (this.jdField_a_of_type_Int == 1)
    {
      ahsh.a(this.this$0, ((Integer)this.jdField_a_of_type_JavaUtilList.get(0)).intValue(), this.jdField_a_of_type_JavaLangString);
      return;
      ahsh.a(this.this$0, ahsh.a(this.this$0), Long.valueOf(ahsh.a(this.this$0)).longValue(), true, this.jdField_a_of_type_JavaLangString);
    }
    ahsh.a(this.this$0, this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21
 * JD-Core Version:    0.7.0.1
 */