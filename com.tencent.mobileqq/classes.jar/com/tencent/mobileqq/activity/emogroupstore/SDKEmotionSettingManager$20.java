package com.tencent.mobileqq.activity.emogroupstore;

import afup;
import afvg;
import java.util.List;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(afup paramafup, int paramInt1, int paramInt2, String paramString, List paramList, int paramInt3) {}
  
  public void run()
  {
    if (afup.a(this.this$0) != null) {
      afup.a(this.this$0).dismiss();
    }
    afup.a(this.this$0, false);
    if (this.jdField_a_of_type_Int == this.b) {
      afup.a(this.this$0, afup.a(this.this$0), Long.valueOf(afup.a(this.this$0)).longValue(), true);
    }
    while (this.jdField_a_of_type_Int == 1)
    {
      afup.a(this.this$0, ((Integer)this.jdField_a_of_type_JavaUtilList.get(0)).intValue(), this.jdField_a_of_type_JavaLangString);
      return;
      afup.a(this.this$0, afup.a(this.this$0), Long.valueOf(afup.a(this.this$0)).longValue(), true, this.jdField_a_of_type_JavaLangString);
    }
    afup.a(this.this$0, this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */