package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.LRULinkedHashMap;
import mqq.os.MqqHandler;

class TextItemBuilder$8
  implements Runnable
{
  TextItemBuilder$8(TextItemBuilder paramTextItemBuilder, CharSequence paramCharSequence, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    SpannableString localSpannableString = this.this$0.a(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_Long);
    if (localSpannableString != null) {}
    synchronized (TextItemBuilder.jdField_a_of_type_ComTencentUtilLRULinkedHashMap)
    {
      TextItemBuilder.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(Long.valueOf(this.b), localSpannableString);
      Object localObject3 = this.this$0.b.obtainMessage();
      ((Message)localObject3).what = 1;
      ((Message)localObject3).obj = localSpannableString;
      ??? = new Bundle();
      ((Bundle)???).putLong("msg_id", this.b);
      ((Message)localObject3).setData((Bundle)???);
      this.this$0.b.sendMessage((Message)localObject3);
      localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(MiniChatActivity.class);
      if (localObject3 != null)
      {
        localObject3 = ((MqqHandler)localObject3).obtainMessage();
        ((Message)localObject3).what = 7;
        ((Message)localObject3).obj = localSpannableString;
        ((Message)localObject3).setData((Bundle)???);
        ((Message)localObject3).sendToTarget();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */