package com.tencent.mobileqq.activity.aio.item;

import agrz;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TroopGiftMsgItemBuilder$4
  implements Runnable
{
  public TroopGiftMsgItemBuilder$4(agrz paramagrz, String paramString1, BubbleImageView paramBubbleImageView, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (List)this.this$0.b.get(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
    this.this$0.b.remove(this.jdField_a_of_type_JavaLangString);
    agrz.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.b, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */