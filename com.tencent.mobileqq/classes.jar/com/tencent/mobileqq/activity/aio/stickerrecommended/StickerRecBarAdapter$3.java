package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aewn;
import aexd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(aewn paramaewn, List paramList1, List paramList2) {}
  
  public void run()
  {
    aexd localaexd = aexd.a(aewn.a(this.this$0));
    if (aewn.a(this.this$0) == null) {
      localaexd.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localaexd.b(this.a);
      aewn.a(this.this$0).a(this.b);
      return;
      localaexd.a(this.a, true, aewn.a(this.this$0).jdField_a_of_type_Int, aewn.a(this.this$0).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */