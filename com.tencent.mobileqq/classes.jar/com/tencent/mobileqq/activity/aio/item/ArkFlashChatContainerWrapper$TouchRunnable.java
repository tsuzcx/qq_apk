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
    int i = this.jdField_a_of_type_Int;
    int j = 0;
    if ((i != 5) && (i != 6))
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
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 5) {
              break label219;
            }
            if (i == 6) {}
          }
          else
          {
            localObject1 = this.jdField_a_of_type_ComTencentArkArk$Container;
            localObject2 = this.jdField_a_of_type_ArrayOfFloat;
            arrayOfFloat = this.b;
            arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
            ((ark.Container)localObject1).TouchCancel((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentArkArk$Container;
          localObject2 = this.jdField_a_of_type_ArrayOfFloat;
          arrayOfFloat = this.b;
          arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
          ((ark.Container)localObject1).TouchMove((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
          return;
        }
      }
      localObject1 = (QQAppInterface)this.this$0.a.get();
      if (localObject1 != null)
      {
        localObject1 = (FlashChatManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        if (ArkFlashChatContainerWrapper.a(this.this$0) != null)
        {
          localObject2 = (MessageForArkFlashChat)ArkFlashChatContainerWrapper.a(this.this$0).get();
          if ((localObject2 != null) && (!((FlashChatManager)localObject1).c((MessageForArkFlashChat)localObject2)))
          {
            ((FlashChatManager)localObject1).a(null);
            ((FlashChatManager)localObject1).b((MessageForArkFlashChat)localObject2);
          }
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentArkArk$Container;
      localObject2 = this.jdField_a_of_type_ArrayOfFloat;
      arrayOfFloat = this.b;
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      ((ark.Container)localObject1).TouchEnd((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
      return;
    }
    label219:
    Object localObject1 = this.jdField_a_of_type_ComTencentArkArk$Container;
    Object localObject2 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat = this.b;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    ((ark.Container)localObject1).TouchStart((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.TouchRunnable
 * JD-Core Version:    0.7.0.1
 */