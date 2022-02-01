package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

public class StickerBubbleListView
  extends ListView
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, StickerBubbleTouchDelegate.StickerBubbleSendCallbackByGesture
{
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private StickerBubbleTouchDelegate jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  private WeakReference<StickerBubbleImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public StickerBubbleListView(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = new StickerBubbleTouchDelegate(this, this, PokeItemHelper.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a(float paramFloat1, float paramFloat2, StickerBubbleListView.Action paramAction)
  {
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (!a(localView, paramFloat1, paramFloat2)) {
          break label101;
        }
        if ((localView instanceof StickerBubbleLinearLayout))
        {
          localView = ((StickerBubbleLinearLayout)localView).a(paramFloat1 - localView.getLeft(), paramFloat2 - localView.getTop());
          if (((localView instanceof LinearLayout)) && (((LinearLayout)localView).getChildAt(0) != null)) {
            paramAction.a(((LinearLayout)localView).getChildAt(0));
          }
        }
      }
      return;
      label101:
      i += 1;
    }
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < paramView.getLeft()) || (paramFloat1 > paramView.getRight())) {}
    while ((paramFloat2 < paramView.getTop()) || (paramFloat2 > paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = -1;
    a(paramFloat1, paramFloat2, new StickerBubbleListView.1(this, arrayOfInt));
    return arrayOfInt[0];
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, new StickerBubbleListView.3(this));
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    Object localObject = PEPanelHelper.a(paramInt1);
    if (localObject == null) {}
    StickerBubbleAnimationView localStickerBubbleAnimationView;
    do
    {
      return;
      localObject = ((PEItemData)localObject).jdField_a_of_type_JavaLangString;
      localStickerBubbleAnimationView = StickerBubbleAnimationViewHolder.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d, getContext());
      if (this.jdField_a_of_type_Boolean)
      {
        localStickerBubbleAnimationView.bringToFront();
        StickerBubbleAnimationViewHolder.a().b(this);
        this.jdField_a_of_type_Boolean = false;
      }
    } while (localObject == null);
    localStickerBubbleAnimationView.a(StickerBubbleAnimationHelper.a(new Point((int)paramFloat1, (int)paramFloat2), (String)localObject, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StickerBubbleAnimationViewHolder.a().d(getContext()).a();
    PEItemData localPEItemData = PEPanelHelper.a(paramInt1);
    if (localPEItemData != null)
    {
      StickerBubbleAnimationHelper.a(localPEItemData, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(null);
      ThreadManager.post(new StickerBubbleListView.2(this, localPEItemData, paramInt2), 10, null, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009222", "0X8009222", localPEItemData.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return !this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public void b()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.a();
  }
  
  public void c()
  {
    StickerBubbleAnimationHelper.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d);
  }
  
  public void d()
  {
    StickerBubbleAnimationHelper.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      StickerBubbleImageView localStickerBubbleImageView = (StickerBubbleImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localStickerBubbleImageView != null) {
        localStickerBubbleImageView.b();
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.a(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView
 * JD-Core Version:    0.7.0.1
 */