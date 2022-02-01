package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aiiz;
import aijp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(aiiz paramaiiz, List paramList1, List paramList2) {}
  
  public void run()
  {
    aijp localaijp = aijp.a(aiiz.a(this.this$0));
    if (aiiz.a(this.this$0) == null) {
      localaijp.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localaijp.b(this.a);
      aiiz.a(this.this$0).a(this.b);
      return;
      localaijp.a(this.a, true, aiiz.a(this.this$0).jdField_a_of_type_Int, aiiz.a(this.this$0).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */