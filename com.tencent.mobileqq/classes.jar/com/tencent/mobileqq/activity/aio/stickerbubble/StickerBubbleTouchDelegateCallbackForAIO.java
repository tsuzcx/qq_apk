package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;

public class StickerBubbleTouchDelegateCallbackForAIO
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, StickerBubbleTouchDelegate.StickerBubbleSendCallbackByGesture
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private PEItemData jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData;
  private StickerBubbleTouchDelegate jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  
  public StickerBubbleTouchDelegateCallbackForAIO(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    StickerBubbleAnimationViewHolder.a().b(this);
  }
  
  public int a()
  {
    return PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData = PEPanelHelper.b(StickerBubbleAnimationHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData.jdField_a_of_type_JavaLangString;
    } while (str == null);
    StickerBubbleAnimationViewHolder.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d, this.jdField_a_of_type_AndroidContentContext).a(StickerBubbleAnimationHelper.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StickerBubbleAnimationViewHolder.a().d(this.jdField_a_of_type_AndroidContentContext).a();
    PEItemData localPEItemData = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData;
    if (localPEItemData != null)
    {
      StickerBubbleAnimationHelper.a(localPEItemData, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localPEItemData, paramInt2), 10, null, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80091A5", "0X80091A5", localPEItemData.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(StickerBubbleTouchDelegate paramStickerBubbleTouchDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = paramStickerBubbleTouchDelegate;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getLeft() > paramFloat1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getRight() < paramFloat1)) {
        return true;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getTop() <= paramFloat2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getBottom() >= paramFloat2));
    return true;
  }
  
  public void b()
  {
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.a();
    }
  }
  
  public void c()
  {
    StickerBubbleAnimationHelper.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d);
  }
  
  public void d()
  {
    StickerBubbleAnimationHelper.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO
 * JD-Core Version:    0.7.0.1
 */