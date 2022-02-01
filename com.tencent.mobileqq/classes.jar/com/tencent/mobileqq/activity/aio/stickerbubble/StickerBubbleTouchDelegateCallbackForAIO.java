package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.ZhituTextChangeCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class StickerBubbleTouchDelegateCallbackForAIO
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, StickerBubbleSendCallback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private PEItemData jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData;
  private StickerBubbleTouchDelegate jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  
  public StickerBubbleTouchDelegateCallbackForAIO(Context paramContext, AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    StickerBubbleAnimationViewHolder.a().b(this);
  }
  
  public int a()
  {
    return PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData = PEPanelHelper.b(StickerBubbleAnimationHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getCurrentUin()));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData;
    if (localObject == null) {
      return;
    }
    localObject = ((PEItemData)localObject).jdField_a_of_type_JavaLangString;
    if (localObject == null) {
      return;
    }
    StickerBubbleAnimationViewHolder.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_AndroidContentContext).a(StickerBubbleAnimationHelper.b(new Point((int)paramFloat1, (int)paramFloat2), (String)localObject, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StickerBubbleAnimationViewHolder.a().d(this.jdField_a_of_type_AndroidContentContext).d();
    PEItemData localPEItemData = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubblePEItemData;
    if (localPEItemData != null)
    {
      StickerBubbleAnimationHelper.a(localPEItemData, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getCurrentUin());
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().i().iterator();
      while (localIterator.hasNext())
      {
        IEditTextChangeCallback localIEditTextChangeCallback = (IEditTextChangeCallback)localIterator.next();
        if ((localIEditTextChangeCallback instanceof ZhituTextChangeCallback)) {
          ((ZhituTextChangeCallback)localIEditTextChangeCallback).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, null);
        }
      }
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localPEItemData, paramInt2), 10, null, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString, "0X80091A5", "0X80091A5", localPEItemData.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(StickerBubbleTouchDelegate paramStickerBubbleTouchDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = paramStickerBubbleTouchDelegate;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a(paramFloat1, paramFloat2);
  }
  
  public void b()
  {
    d();
    StickerBubbleTouchDelegate localStickerBubbleTouchDelegate = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
    if (localStickerBubbleTouchDelegate != null) {
      localStickerBubbleTouchDelegate.c();
    }
  }
  
  public void c()
  {
    StickerBubbleAnimationHelper.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
  }
  
  public void d()
  {
    StickerBubbleAnimationHelper.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO
 * JD-Core Version:    0.7.0.1
 */