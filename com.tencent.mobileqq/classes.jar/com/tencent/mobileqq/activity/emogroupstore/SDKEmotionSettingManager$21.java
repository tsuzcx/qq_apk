package com.tencent.mobileqq.activity.emogroupstore;

import ahww;
import ahxp;
import java.util.List;

public class SDKEmotionSettingManager$21
  implements Runnable
{
  public SDKEmotionSettingManager$21(ahww paramahww, int paramInt1, int paramInt2, String paramString, List paramList, int paramInt3) {}
  
  public void run()
  {
    if (ahww.a(this.this$0) != null) {
      ahww.a(this.this$0).dismiss();
    }
    ahww.a(this.this$0, false);
    if (this.jdField_a_of_type_Int == this.b) {
      ahww.a(this.this$0, ahww.a(this.this$0), Long.valueOf(ahww.a(this.this$0)).longValue(), true);
    }
    while (this.jdField_a_of_type_Int == 1)
    {
      ahww.a(this.this$0, ((Integer)this.jdField_a_of_type_JavaUtilList.get(0)).intValue(), this.jdField_a_of_type_JavaLangString);
      return;
      ahww.a(this.this$0, ahww.a(this.this$0), Long.valueOf(ahww.a(this.this$0)).longValue(), true, this.jdField_a_of_type_JavaLangString);
    }
    ahww.a(this.this$0, this.b, this.c, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.21
 * JD-Core Version:    0.7.0.1
 */