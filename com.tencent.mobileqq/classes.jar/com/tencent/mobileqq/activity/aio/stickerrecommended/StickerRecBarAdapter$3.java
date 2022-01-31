package com.tencent.mobileqq.activity.aio.stickerrecommended;

import agtq;
import agug;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(agtq paramagtq, List paramList1, List paramList2) {}
  
  public void run()
  {
    agug localagug = agug.a(agtq.a(this.this$0));
    if (agtq.a(this.this$0) == null) {
      localagug.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localagug.b(this.a);
      agtq.a(this.this$0).a(this.b);
      return;
      localagug.a(this.a, true, agtq.a(this.this$0).jdField_a_of_type_Int, agtq.a(this.this$0).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */