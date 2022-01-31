package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aexb;
import aexe;
import java.util.List;

public class StickerRecManager$2
  implements Runnable
{
  public StickerRecManager$2(aexb paramaexb, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.this$0.b(this.jdField_a_of_type_JavaLangString);
    aexb.a(this.this$0, this.jdField_a_of_type_Boolean, str);
    if ((aexb.a(this.this$0) != null) && (!aexb.a(this.this$0).isEmpty())) {
      aexb.a(this.this$0).a(aexb.a(this.this$0), str, "999");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.2
 * JD-Core Version:    0.7.0.1
 */