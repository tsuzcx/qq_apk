package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aels;
import aemi;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(aels paramaels, List paramList1, List paramList2) {}
  
  public void run()
  {
    aemi localaemi = aemi.a(aels.a(this.this$0));
    if (aels.a(this.this$0) == null) {
      localaemi.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localaemi.b(this.a);
      aels.a(this.this$0).a(this.b);
      return;
      localaemi.a(this.a, true, aels.a(this.this$0).jdField_a_of_type_Int, aels.a(this.this$0).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */