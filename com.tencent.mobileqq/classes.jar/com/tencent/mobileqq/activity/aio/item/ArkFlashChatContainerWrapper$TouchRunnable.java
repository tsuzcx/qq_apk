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
  private int a;
  private ark.Container b;
  private int[] c;
  private float[] d;
  private float[] e;
  
  public ArkFlashChatContainerWrapper$TouchRunnable(ArkFlashChatContainerWrapper paramArkFlashChatContainerWrapper, MotionEvent paramMotionEvent, ark.Container paramContainer, float paramFloat)
  {
    this.a = paramMotionEvent.getActionMasked();
    this.b = paramContainer;
    int i = this.a;
    int j = 0;
    if ((i != 5) && (i != 6))
    {
      int k = paramMotionEvent.getPointerCount();
      i = k;
      if (k > ark.arkGetMaxTouchPoints()) {
        i = ark.arkGetMaxTouchPoints();
      }
      this.c = new int[i];
      this.d = new float[i];
      this.e = new float[i];
    }
    while (j < i)
    {
      this.c[j] = paramMotionEvent.getPointerId(j);
      this.d[j] = (paramMotionEvent.getX(j) / paramFloat);
      this.e[j] = (paramMotionEvent.getY(j) / paramFloat);
      j += 1;
      continue;
      this.c = new int[1];
      this.d = new float[1];
      this.e = new float[1];
      i = paramMotionEvent.getActionIndex();
      this.c[0] = paramMotionEvent.getPointerId(i);
      this.d[0] = (paramMotionEvent.getX(i) / paramFloat);
      this.e[0] = (paramMotionEvent.getY(i) / paramFloat);
    }
  }
  
  public void run()
  {
    int i = this.a;
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
            localObject1 = this.b;
            localObject2 = this.d;
            arrayOfFloat = this.e;
            arrayOfInt = this.c;
            ((ark.Container)localObject1).TouchCancel((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
          }
        }
        else
        {
          localObject1 = this.b;
          localObject2 = this.d;
          arrayOfFloat = this.e;
          arrayOfInt = this.c;
          ((ark.Container)localObject1).TouchMove((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
          return;
        }
      }
      localObject1 = (QQAppInterface)this.this$0.c.get();
      if (localObject1 != null)
      {
        localObject1 = (FlashChatManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        if (ArkFlashChatContainerWrapper.a(this.this$0) != null)
        {
          localObject2 = (MessageForArkFlashChat)ArkFlashChatContainerWrapper.a(this.this$0).get();
          if ((localObject2 != null) && (!((FlashChatManager)localObject1).d((MessageForArkFlashChat)localObject2)))
          {
            ((FlashChatManager)localObject1).a(null);
            ((FlashChatManager)localObject1).e((MessageForArkFlashChat)localObject2);
          }
        }
      }
      localObject1 = this.b;
      localObject2 = this.d;
      arrayOfFloat = this.e;
      arrayOfInt = this.c;
      ((ark.Container)localObject1).TouchEnd((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
      return;
    }
    label219:
    Object localObject1 = this.b;
    Object localObject2 = this.d;
    float[] arrayOfFloat = this.e;
    int[] arrayOfInt = this.c;
    ((ark.Container)localObject1).TouchStart((float[])localObject2, arrayOfFloat, arrayOfInt, arrayOfInt.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.TouchRunnable
 * JD-Core Version:    0.7.0.1
 */