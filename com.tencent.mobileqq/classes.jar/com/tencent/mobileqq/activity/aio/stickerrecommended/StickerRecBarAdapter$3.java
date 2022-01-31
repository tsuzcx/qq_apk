package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aewl;
import aexb;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(aewl paramaewl, List paramList1, List paramList2) {}
  
  public void run()
  {
    aexb localaexb = aexb.a(aewl.a(this.this$0));
    if (aewl.a(this.this$0) == null) {
      localaexb.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localaexb.b(this.a);
      aewl.a(this.this$0).a(this.b);
      return;
      localaexb.a(this.a, true, aewl.a(this.this$0).jdField_a_of_type_Int, aewl.a(this.this$0).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */