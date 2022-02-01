package com.tencent.mobileqq.activity.emogroupstore;

import aitt;
import aium;
import java.util.List;

public class SDKEmotionSettingManager$21
  implements Runnable
{
  public SDKEmotionSettingManager$21(aitt paramaitt, int paramInt1, int paramInt2, String paramString, List paramList, int paramInt3) {}
  
  public void run()
  {
    if (aitt.a(this.this$0) != null) {
      aitt.a(this.this$0).dismiss();
    }
    aitt.a(this.this$0, false);
    if (this.jdField_a_of_type_Int == this.b) {
      aitt.a(this.this$0, aitt.a(this.this$0), Long.valueOf(aitt.a(this.this$0)).longValue(), true);
    }
    while (this.jdField_a_of_type_Int == 1)
    {
      aitt.a(this.this$0, ((Integer)this.jdField_a_of_type_JavaUtilList.get(0)).intValue(), this.jdField_a_of_type_JavaLangString);
      return;
      aitt.a(this.this$0, aitt.a(this.this$0), Long.valueOf(aitt.a(this.this$0)).longValue(), true, this.jdField_a_of_type_JavaLangString);
    }
    aitt.a(this.this$0, this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21
 * JD-Core Version:    0.7.0.1
 */