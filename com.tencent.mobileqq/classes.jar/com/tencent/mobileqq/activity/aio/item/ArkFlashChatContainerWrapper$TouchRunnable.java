package com.tencent.mobileqq.activity.aio.item;

import android.view.MotionEvent;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import java.lang.ref.WeakReference;

class ArkFlashChatContainerWrapper$TouchRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private ark.Container jdField_a_of_type_ComTencentArkArk$Container;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float[] b;
  
  public ArkFlashChatContainerWrapper$TouchRunnable(ArkFlashChatContainerWrapper paramArkFlashChatContainerWrapper, MotionEvent paramMotionEvent, ark.Container paramContainer, float paramFloat)
  {
    this.jdField_a_of_type_Int = paramMotionEvent.getActionMasked();
    this.jdField_a_of_type_ComTencentArkArk$Container = paramContainer;
    int i;
    if ((this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 6))
    {
      int k = paramMotionEvent.getPointerCount();
      i = k;
      if (k > ark.arkGetMaxTouchPoints()) {
        i = ark.arkGetMaxTouchPoints();
      }
      this.jdField_a_of_type_ArrayOfInt = new int[i];
      this.jdField_a_of_type_ArrayOfFloat = new float[i];
      this.b = new float[i];
    }
    while (j < i)
    {
      this.jdField_a_of_type_ArrayOfInt[j] = paramMotionEvent.getPointerId(j);
      this.jdField_a_of_type_ArrayOfFloat[j] = (paramMotionEvent.getX(j) / paramFloat);
      this.b[j] = (paramMotionEvent.getY(j) / paramFloat);
      j += 1;
      continue;
      this.jdField_a_of_type_ArrayOfInt = new int[1];
      this.jdField_a_of_type_ArrayOfFloat = new float[1];
      this.b = new float[1];
      i = paramMotionEvent.getActionIndex();
      this.jdField_a_of_type_ArrayOfInt[0] = paramMotionEvent.getPointerId(i);
      this.jdField_a_of_type_ArrayOfFloat[0] = (paramMotionEvent.getX(i) / paramFloat);
      this.b[0] = (paramMotionEvent.getY(i) / paramFloat);
    }
  }
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      return;
    case 0: 
    case 5: 
      this.jdField_a_of_type_ComTencentArkArk$Container.TouchStart(this.jdField_a_of_type_ArrayOfFloat, this.b, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfInt.length);
      return;
    case 1: 
    case 6: 
      Object localObject = (QQAppInterface)this.this$0.a.get();
      MessageForArkFlashChat localMessageForArkFlashChat;
      if (localObject != null)
      {
        localObject = (FlashChatManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        if (ArkFlashChatContainerWrapper.a(this.this$0) != null)
        {
          localMessageForArkFlashChat = (MessageForArkFlashChat)ArkFlashChatContainerWrapper.a(this.this$0).get();
          if ((localMessageForArkFlashChat != null) && (!((FlashChatManager)localObject).c(localMessageForArkFlashChat))) {
            break label164;
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentArkArk$Container.TouchEnd(this.jdField_a_of_type_ArrayOfFloat, this.b, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfInt.length);
        return;
        ((FlashChatManager)localObject).a(null);
        ((FlashChatManager)localObject).b(localMessageForArkFlashChat);
      }
    case 2: 
      label164:
      this.jdField_a_of_type_ComTencentArkArk$Container.TouchMove(this.jdField_a_of_type_ArrayOfFloat, this.b, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfInt.length);
      return;
    }
    this.jdField_a_of_type_ComTencentArkArk$Container.TouchCancel(this.jdField_a_of_type_ArrayOfFloat, this.b, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfInt.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.TouchRunnable
 * JD-Core Version:    0.7.0.1
 */