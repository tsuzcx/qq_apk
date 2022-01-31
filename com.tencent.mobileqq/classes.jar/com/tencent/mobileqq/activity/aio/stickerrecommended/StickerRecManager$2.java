package com.tencent.mobileqq.activity.aio.stickerrecommended;

import agyv;
import agyy;
import java.util.List;

public class StickerRecManager$2
  implements Runnable
{
  public StickerRecManager$2(agyv paramagyv, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.this$0.b(this.jdField_a_of_type_JavaLangString);
    agyv.a(this.this$0, this.jdField_a_of_type_Boolean, str);
    if ((agyv.a(this.this$0) != null) && (!agyv.a(this.this$0).isEmpty())) {
      agyv.a(this.this$0).a(agyv.a(this.this$0), str, "999");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.2
 * JD-Core Version:    0.7.0.1
 */