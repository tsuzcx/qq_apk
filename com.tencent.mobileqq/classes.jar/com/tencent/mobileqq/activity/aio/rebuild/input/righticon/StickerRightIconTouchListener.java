package com.tencent.mobileqq.activity.aio.rebuild.input.righticon;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconTouchListener;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO;

public class StickerRightIconTouchListener
  implements IOnRightIconTouchListener
{
  private boolean a = false;
  private StickerBubbleTouchDelegate b;
  
  private StickerBubbleTouchDelegate a(AIOContext paramAIOContext, View paramView)
  {
    if (this.b == null)
    {
      StickerBubbleTouchDelegateCallbackForAIO localStickerBubbleTouchDelegateCallbackForAIO = new StickerBubbleTouchDelegateCallbackForAIO(paramAIOContext.b(), paramAIOContext);
      this.b = new StickerBubbleTouchDelegate(localStickerBubbleTouchDelegateCallbackForAIO, paramView, PokeItemHelper.e(paramAIOContext.a()), false);
      localStickerBubbleTouchDelegateCallbackForAIO.a(this.b);
    }
    return this.b;
  }
  
  public boolean a(AIOContext paramAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    EditTextUI localEditTextUI = paramAIOContext.p().d().f();
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          if (!this.a) {
            break label132;
          }
          a(paramAIOContext, paramView).a(paramMotionEvent);
          return false;
        }
      }
      if ((localEditTextUI.a().toString().isEmpty()) || (this.a))
      {
        a(paramAIOContext, paramView).a(paramMotionEvent);
        this.a = false;
        return true;
      }
    }
    else if (localEditTextUI.a().toString().isEmpty())
    {
      a(paramAIOContext, paramView).a(paramMotionEvent);
      this.a = true;
    }
    label132:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.righticon.StickerRightIconTouchListener
 * JD-Core Version:    0.7.0.1
 */