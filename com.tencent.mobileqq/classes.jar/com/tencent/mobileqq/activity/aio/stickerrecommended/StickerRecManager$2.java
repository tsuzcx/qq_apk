package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aexd;
import aexg;
import java.util.List;

public class StickerRecManager$2
  implements Runnable
{
  public StickerRecManager$2(aexd paramaexd, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.this$0.b(this.jdField_a_of_type_JavaLangString);
    aexd.a(this.this$0, this.jdField_a_of_type_Boolean, str);
    if ((aexd.a(this.this$0) != null) && (!aexd.a(this.this$0).isEmpty())) {
      aexd.a(this.this$0).a(aexd.a(this.this$0), str, "999");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.2
 * JD-Core Version:    0.7.0.1
 */