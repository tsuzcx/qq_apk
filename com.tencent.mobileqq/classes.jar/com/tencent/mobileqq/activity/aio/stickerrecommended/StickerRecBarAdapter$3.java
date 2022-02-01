package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

class StickerRecBarAdapter$3
  implements Runnable
{
  StickerRecBarAdapter$3(StickerRecBarAdapter paramStickerRecBarAdapter, List paramList1, List paramList2) {}
  
  public void run()
  {
    StickerRecManager localStickerRecManager = StickerRecManager.a(StickerRecBarAdapter.a(this.this$0));
    if (StickerRecBarAdapter.a(this.this$0) == null) {
      localStickerRecManager.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localStickerRecManager.b(this.a);
      StickerRecBarAdapter.a(this.this$0).a(this.b);
      return;
      localStickerRecManager.a(this.a, true, StickerRecBarAdapter.a(this.this$0).jdField_a_of_type_Int, StickerRecBarAdapter.a(this.this$0).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */