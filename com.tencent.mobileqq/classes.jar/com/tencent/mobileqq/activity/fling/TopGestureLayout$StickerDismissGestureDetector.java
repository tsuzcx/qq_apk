package com.tencent.mobileqq.activity.fling;

import afii;
import afim;
import afiw;
import agkp;
import agkq;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class TopGestureLayout$StickerDismissGestureDetector
  extends GestureDetector
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private int c;
  public boolean isInTowFingerMode;
  
  public TopGestureLayout$StickerDismissGestureDetector(TopGestureLayout paramTopGestureLayout, Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    super(paramContext, paramOnGestureListener);
  }
  
  void a(MotionEvent paramMotionEvent, ChatXListView paramChatXListView)
  {
    float f2 = paramMotionEvent.getX(this.jdField_a_of_type_Int) - this.jdField_a_of_type_Float;
    float f1 = paramMotionEvent.getX(this.jdField_b_of_type_Int) - this.jdField_b_of_type_Float;
    this.jdField_a_of_type_Float = paramMotionEvent.getX(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Float = paramMotionEvent.getX(this.jdField_b_of_type_Int);
    int i;
    if (f2 * f1 < 0.0F) {
      if (f2 < 0.0F)
      {
        i = EmojiStickerManager.g;
        this.c = i;
        if (paramChatXListView == null) {
          break label410;
        }
        i = paramChatXListView.getChildCount() - 1;
        label92:
        if (i < 0) {
          break label418;
        }
        paramMotionEvent = paramChatXListView.getChildAt(i);
        if (!(paramMotionEvent instanceof BaseChatItemLayout)) {
          break label230;
        }
        paramMotionEvent = (BaseChatItemLayout)paramMotionEvent;
        if (this.c != EmojiStickerManager.g) {
          break label187;
        }
        f2 = Math.min(0.0F, f2);
        f1 = Math.max(0.0F, f1);
        paramMotionEvent.a((int)Math.abs(f2 - f1), this.c);
      }
    }
    label156:
    label418:
    label419:
    for (;;)
    {
      float f3 = f2;
      float f4 = f1;
      label187:
      label230:
      int j;
      do
      {
        do
        {
          i -= 1;
          f1 = f4;
          f2 = f3;
          break label92;
          i = EmojiStickerManager.h;
          break;
          if (this.c != EmojiStickerManager.h) {
            break label419;
          }
          f2 = Math.max(0.0F, f2);
          f1 = Math.min(0.0F, f1);
          paramMotionEvent.a((int)Math.abs(f2 - f1), this.c);
          break label156;
          f4 = f1;
          f3 = f2;
        } while (!(paramMotionEvent instanceof LinearLayout));
        j = ((LinearLayout)paramMotionEvent).getChildCount() - 1;
        f4 = f1;
        f3 = f2;
      } while (j < 0);
      Object localObject = ((LinearLayout)paramMotionEvent).getChildAt(j);
      f4 = f1;
      f3 = f2;
      if ((localObject instanceof StickerGrayTipLayout))
      {
        localObject = (StickerGrayTipLayout)localObject;
        if (this.c == EmojiStickerManager.g)
        {
          f2 = Math.min(0.0F, f2);
          f1 = Math.max(0.0F, f1);
          ((StickerGrayTipLayout)localObject).doDismiss((int)Math.abs(f2 - f1), this.c);
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        f4 = f1;
        f3 = f2;
        if (this.c == EmojiStickerManager.h)
        {
          f3 = Math.max(0.0F, f2);
          f4 = Math.min(0.0F, f1);
          ((StickerGrayTipLayout)localObject).doDismiss((int)Math.abs(f3 - f4), this.c);
        }
        f1 = f4;
        f2 = f3;
      }
      QLog.e("TopGestureLayout", 1, "caclLeftAndRightOffset but list view is null");
      return;
    }
  }
  
  public boolean checkPttSlide(MotionEvent paramMotionEvent, ChatXListView paramChatXListView)
  {
    if (paramChatXListView != null)
    {
      int i = paramChatXListView.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramChatXListView.getChildAt(i);
        if ((localView.getTag() != null) && ((localView.getTag() instanceof agkp)) && (((agkp)localView.getTag()).a()))
        {
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
            return true;
          }
        }
        i -= 1;
      }
    }
    QLog.e("TopGestureLayout", 1, "checkPttSlide but list view is null");
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1;
    if (EmojiStickerManager.d)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131374005);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    if (EmojiStickerManager.c)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131374002);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    int i = paramMotionEvent.getPointerCount();
    if (i == 2)
    {
      localObject1 = BaseActivity.sTopActivity;
      if ((localObject1 instanceof FragmentActivity))
      {
        localObject1 = (FragmentActivity)localObject1;
        if (((FragmentActivity)localObject1).getChatFragment() != null)
        {
          localObject1 = ((FragmentActivity)localObject1).getChatFragment().a();
          if ((((localObject1 instanceof afii)) || ((localObject1 instanceof afiw)) || ((localObject1 instanceof afim))) && (EmojiStickerManager.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
          {
            this.isInTowFingerMode = true;
            switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
            {
            }
            for (;;)
            {
              return true;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370017);
              if ((localObject1 instanceof ChatXListView)) {
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
              }
              this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
              continue;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370017);
              if ((localObject1 instanceof ChatXListView)) {
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
              }
              if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
              {
                this.jdField_a_of_type_Int = 0;
                this.jdField_b_of_type_Int = 1;
                this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
                this.jdField_b_of_type_Float = paramMotionEvent.getX(1);
              }
              else
              {
                this.jdField_a_of_type_Int = 1;
                this.jdField_b_of_type_Int = 0;
                this.jdField_a_of_type_Float = paramMotionEvent.getX(1);
                this.jdField_b_of_type_Float = paramMotionEvent.getX(0);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370017);
                  if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
                    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
                  }
                }
                a(paramMotionEvent, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
                continue;
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
              }
            }
          }
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    boolean bool1;
    if (i == 1)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label777;
      }
      agkq.a = false;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370017);
        if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
        break label766;
      }
      bool1 = false;
      i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
      if (i >= 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
        if ((localObject1 instanceof BaseChatItemLayout))
        {
          localObject1 = (BaseChatItemLayout)localObject1;
          if (bool1) {
            break label972;
          }
          bool1 = ((BaseChatItemLayout)localObject1).d();
        }
      }
    }
    label706:
    label972:
    for (;;)
    {
      ((BaseChatItemLayout)localObject1).c();
      boolean bool2 = bool1;
      do
      {
        i -= 1;
        bool1 = bool2;
        break;
        bool2 = bool1;
      } while (!(localObject1 instanceof LinearLayout));
      int j = ((LinearLayout)localObject1).getChildCount() - 1;
      Object localObject2;
      for (;;)
      {
        bool2 = bool1;
        if (j < 0) {
          break;
        }
        localObject2 = ((LinearLayout)localObject1).getChildAt(j);
        bool2 = bool1;
        if ((localObject2 instanceof StickerGrayTipLayout))
        {
          localObject2 = (StickerGrayTipLayout)localObject2;
          bool2 = bool1;
          if (!bool1) {
            bool2 = ((StickerGrayTipLayout)localObject2).haveStickers();
          }
          ((StickerGrayTipLayout)localObject2).startAutoDismiss();
        }
        j -= 1;
        bool1 = bool2;
      }
      if (bool1)
      {
        i = EmojiStickerManager.a().jdField_a_of_type_Int;
        localObject1 = "1";
        if (i == 1)
        {
          localObject1 = "2";
          if (this.c != EmojiStickerManager.g) {
            break label731;
          }
          VasWebviewUtil.reportCommercialDrainage("", "Stick", "Hide", (String)localObject1, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
      }
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        if (i != 3000) {
          break;
        }
        localObject1 = "3";
        break;
        label731:
        VasWebviewUtil.reportCommercialDrainage("", "Stick", "CancelHide", (String)localObject1, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        break label706;
        label766:
        QLog.e("TopGestureLayout", 1, "on on pointer touch up but list view is null");
        break label706;
        if (paramMotionEvent.getAction() == 0)
        {
          this.isInTowFingerMode = false;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370017);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370018);
          }
          if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
          }
        }
        else if (paramMotionEvent.getAction() == 2)
        {
          if ((agkq.a) || (agkq.b)) {
            return false;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370017);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370018);
            }
            if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
            }
          }
          if (checkPttSlide(paramMotionEvent, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView))
          {
            agkq.a = true;
            return false;
          }
        }
        else if (paramMotionEvent.getAction() == 3)
        {
          agkq.a = false;
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
        }
        else
        {
          agkq.a = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopGestureLayout.StickerDismissGestureDetector
 * JD-Core Version:    0.7.0.1
 */