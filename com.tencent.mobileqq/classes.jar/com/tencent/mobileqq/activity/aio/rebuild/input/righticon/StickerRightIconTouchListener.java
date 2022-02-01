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
  private StickerBubbleTouchDelegate jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  private boolean jdField_a_of_type_Boolean = false;
  
  private StickerBubbleTouchDelegate a(AIOContext paramAIOContext, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate == null)
    {
      StickerBubbleTouchDelegateCallbackForAIO localStickerBubbleTouchDelegateCallbackForAIO = new StickerBubbleTouchDelegateCallbackForAIO(paramAIOContext.a(), paramAIOContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = new StickerBubbleTouchDelegate(localStickerBubbleTouchDelegateCallbackForAIO, paramView, PokeItemHelper.b(paramAIOContext.a()), false);
      localStickerBubbleTouchDelegateCallbackForAIO.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  }
  
  public boolean a(AIOContext paramAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    EditTextUI localEditTextUI = paramAIOContext.a().a().a();
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
          if (!this.jdField_a_of_type_Boolean) {
            break label132;
          }
          a(paramAIOContext, paramView).a(paramMotionEvent);
          return false;
        }
      }
      if ((localEditTextUI.a().toString().isEmpty()) || (this.jdField_a_of_type_Boolean))
      {
        a(paramAIOContext, paramView).a(paramMotionEvent);
        this.jdField_a_of_type_Boolean = false;
        return true;
      }
    }
    else if (localEditTextUI.a().toString().isEmpty())
    {
      a(paramAIOContext, paramView).a(paramMotionEvent);
      this.jdField_a_of_type_Boolean = true;
    }
    label132:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.righticon.StickerRightIconTouchListener
 * JD-Core Version:    0.7.0.1
 */