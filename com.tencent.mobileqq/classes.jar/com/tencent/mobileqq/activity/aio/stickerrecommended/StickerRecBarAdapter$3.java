package com.tencent.mobileqq.activity.aio.stickerrecommended;

import agyf;
import agyv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(agyf paramagyf, List paramList1, List paramList2) {}
  
  public void run()
  {
    agyv localagyv = agyv.a(agyf.a(this.this$0));
    if (agyf.a(this.this$0) == null) {
      localagyv.a(this.a, false, 0, null);
    }
    for (;;)
    {
      localagyv.b(this.a);
      agyf.a(this.this$0).a(this.b);
      return;
      localagyv.a(this.a, true, agyf.a(this.this$0).jdField_a_of_type_Int, agyf.a(this.this$0).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */