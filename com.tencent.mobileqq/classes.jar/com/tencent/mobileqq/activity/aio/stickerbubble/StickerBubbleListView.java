package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.ZhituTextChangeCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class StickerBubbleListView
  extends ListView
  implements StickerBubbleAnimationViewHolder.AnimationViewCallback, StickerBubbleSendCallback
{
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private StickerBubbleTouchDelegate jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  private WeakReference<StickerBubbleImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public StickerBubbleListView(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = new StickerBubbleTouchDelegate(this, this, PokeItemHelper.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a(float paramFloat1, float paramFloat2, StickerBubbleListView.Action paramAction)
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if (a((View)localObject, paramFloat1, paramFloat2))
      {
        if (!(localObject instanceof StickerBubbleLinearLayout)) {
          break;
        }
        localObject = ((StickerBubbleLinearLayout)localObject).a(paramFloat1 - ((View)localObject).getLeft(), paramFloat2 - ((View)localObject).getTop());
        if (!(localObject instanceof LinearLayout)) {
          break;
        }
        localObject = (LinearLayout)localObject;
        if (((LinearLayout)localObject).getChildAt(0) == null) {
          break;
        }
        paramAction.a(((LinearLayout)localObject).getChildAt(0));
        return;
      }
      i += 1;
    }
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= paramView.getLeft())
    {
      if (paramFloat1 > paramView.getRight()) {
        return false;
      }
      if (paramFloat2 >= paramView.getTop()) {
        return paramFloat2 <= paramView.getBottom();
      }
    }
    return false;
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
    if (localObject == null) {
      return;
    }
    localObject = ((PEItemData)localObject).jdField_a_of_type_JavaLangString;
    StickerBubbleAnimationView localStickerBubbleAnimationView = StickerBubbleAnimationViewHolder.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d, getContext());
    if (this.jdField_a_of_type_Boolean)
    {
      localStickerBubbleAnimationView.bringToFront();
      StickerBubbleAnimationViewHolder.a().b(this);
      this.jdField_a_of_type_Boolean = false;
    }
    if (localObject != null) {
      localStickerBubbleAnimationView.a(StickerBubbleAnimationHelper.a(new Point((int)paramFloat1, (int)paramFloat2), (String)localObject, paramInt2));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StickerBubbleAnimationViewHolder.a().d(getContext()).d();
    PEItemData localPEItemData = PEPanelHelper.a(paramInt1);
    if (localPEItemData != null)
    {
      StickerBubbleAnimationHelper.a(localPEItemData, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().i().iterator();
      while (localIterator.hasNext())
      {
        IEditTextChangeCallback localIEditTextChangeCallback = (IEditTextChangeCallback)localIterator.next();
        if ((localIEditTextChangeCallback instanceof ZhituTextChangeCallback)) {
          ((ZhituTextChangeCallback)localIEditTextChangeCallback).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(), null);
        }
      }
      ThreadManager.post(new StickerBubbleListView.2(this, localPEItemData, paramInt2), 10, null, false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009222", "0X8009222", localPEItemData.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramFloat1, (int)paramFloat2) ^ true;
  }
  
  public void b()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate.c();
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (StickerBubbleImageView)((WeakReference)localObject).get();
      if (localObject != null) {
        ((StickerBubbleImageView)localObject).b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView
 * JD-Core Version:    0.7.0.1
 */