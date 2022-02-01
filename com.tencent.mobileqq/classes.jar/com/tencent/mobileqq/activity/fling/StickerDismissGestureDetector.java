package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class StickerDismissGestureDetector
  extends GestureDetector
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private int c;
  public boolean isInTowFingerMode = false;
  
  public StickerDismissGestureDetector(TopGestureLayout paramTopGestureLayout, Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    super(paramContext, paramOnGestureListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = paramTopGestureLayout;
  }
  
  void a(MotionEvent paramMotionEvent, ChatXListView paramChatXListView)
  {
    float f4 = paramMotionEvent.getX(this.jdField_a_of_type_Int) - this.jdField_a_of_type_Float;
    float f3 = paramMotionEvent.getX(this.jdField_b_of_type_Int) - this.jdField_b_of_type_Float;
    this.jdField_a_of_type_Float = paramMotionEvent.getX(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Float = paramMotionEvent.getX(this.jdField_b_of_type_Int);
    if (f4 * f3 < 0.0F)
    {
      int i;
      if (f4 < 0.0F) {
        i = EmojiStickerManager.jdField_d_of_type_Int;
      } else {
        i = EmojiStickerManager.jdField_e_of_type_Int;
      }
      this.c = i;
      if (paramChatXListView != null)
      {
        i = paramChatXListView.getChildCount() - 1;
        while (i >= 0)
        {
          paramMotionEvent = paramChatXListView.getChildAt(i);
          float f1;
          float f2;
          if ((paramMotionEvent instanceof BaseChatItemLayout))
          {
            paramMotionEvent = (BaseChatItemLayout)paramMotionEvent;
            if (this.c == EmojiStickerManager.jdField_d_of_type_Int)
            {
              f1 = Math.min(0.0F, f4);
              f2 = Math.max(0.0F, f3);
              paramMotionEvent.a((int)Math.abs(f1 - f2), this.c);
            }
            else
            {
              f1 = f4;
              f2 = f3;
              if (this.c == EmojiStickerManager.jdField_e_of_type_Int)
              {
                f1 = Math.max(0.0F, f4);
                f2 = Math.min(0.0F, f3);
                paramMotionEvent.a((int)Math.abs(f1 - f2), this.c);
              }
            }
          }
          else
          {
            f1 = f4;
            f2 = f3;
            if ((paramMotionEvent instanceof LinearLayout))
            {
              paramMotionEvent = (LinearLayout)paramMotionEvent;
              int j = paramMotionEvent.getChildCount() - 1;
              for (;;)
              {
                f1 = f4;
                f2 = f3;
                if (j < 0) {
                  break;
                }
                Object localObject = paramMotionEvent.getChildAt(j);
                f1 = f4;
                f2 = f3;
                if ((localObject instanceof StickerGrayTipLayout))
                {
                  localObject = (StickerGrayTipLayout)localObject;
                  if (this.c == EmojiStickerManager.jdField_d_of_type_Int)
                  {
                    f1 = Math.min(0.0F, f4);
                    f2 = Math.max(0.0F, f3);
                    ((StickerGrayTipLayout)localObject).doDismiss((int)Math.abs(f1 - f2), this.c);
                  }
                  else
                  {
                    f1 = f4;
                    f2 = f3;
                    if (this.c == EmojiStickerManager.jdField_e_of_type_Int)
                    {
                      f1 = Math.max(0.0F, f4);
                      f2 = Math.min(0.0F, f3);
                      ((StickerGrayTipLayout)localObject).doDismiss((int)Math.abs(f1 - f2), this.c);
                    }
                  }
                }
                j -= 1;
                f4 = f1;
                f3 = f2;
              }
            }
          }
          i -= 1;
          f4 = f1;
          f3 = f2;
        }
      }
      QLog.e("TopGestureLayout", 1, "caclLeftAndRightOffset but list view is null");
    }
  }
  
  public boolean checkPttSlide(MotionEvent paramMotionEvent, ChatXListView paramChatXListView)
  {
    if (paramChatXListView != null)
    {
      int i = paramChatXListView.getChildCount() - 1;
      while (i >= 0)
      {
        Object localObject = paramChatXListView.getChildAt(i);
        if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof PttItemBuilder.Holder)))
        {
          localObject = (PttItemBuilder.Holder)((View)localObject).getTag();
          if (((PttItemBuilder.Holder)localObject).a())
          {
            Rect localRect = new Rect();
            ((PttItemBuilder.Holder)localObject).a(localRect);
            if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
              return true;
            }
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
    if (EmojiStickerManager.jdField_e_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131374092);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    if (EmojiStickerManager.jdField_d_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131374089);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    int i = paramMotionEvent.getPointerCount();
    boolean bool1 = false;
    if (i == 2)
    {
      localObject1 = BaseActivity.sTopActivity;
      if (((localObject1 instanceof BaseActivity)) && (((BaseActivity)localObject1).getChatFragment() != null))
      {
        localObject1 = ((BaseActivity)localObject1).getChatFragment().a();
        if ((((localObject1 instanceof BaseTroopChatPie)) || ((localObject1 instanceof FriendChatPie)) || ((localObject1 instanceof DiscussChatPie))) && (EmojiStickerManager.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
        {
          this.isInTowFingerMode = true;
          i = paramMotionEvent.getAction() & paramMotionEvent.getActionMasked();
          if (i != 0)
          {
            if (i != 1) {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i != 5) {
                    return true;
                  }
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370119);
                  if ((localObject1 instanceof ChatXListView)) {
                    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
                  }
                  if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
                  {
                    this.jdField_a_of_type_Int = 0;
                    this.jdField_b_of_type_Int = 1;
                    this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
                    this.jdField_b_of_type_Float = paramMotionEvent.getX(1);
                    return true;
                  }
                  this.jdField_a_of_type_Int = 1;
                  this.jdField_b_of_type_Int = 0;
                  this.jdField_a_of_type_Float = paramMotionEvent.getX(1);
                  this.jdField_b_of_type_Float = paramMotionEvent.getX(0);
                  return true;
                }
              }
              else
              {
                if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370119);
                  if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
                    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
                  }
                }
                a(paramMotionEvent, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
                return true;
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
            return true;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370119);
          if ((localObject1 instanceof ChatXListView)) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
          }
          this.jdField_a_of_type_Float = paramMotionEvent.getX(0);
          return true;
        }
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    if (i == 1)
    {
      Object localObject2;
      if (paramMotionEvent.getAction() == 1)
      {
        PttConstants.a = false;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370119);
          if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
        if (localObject1 != null)
        {
          i = ((ChatXListView)localObject1).getChildCount() - 1;
          while (i >= 0)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
            boolean bool2;
            if ((localObject1 instanceof BaseChatItemLayout))
            {
              localObject1 = (BaseChatItemLayout)localObject1;
              bool2 = bool1;
              if (!bool1) {
                bool2 = ((BaseChatItemLayout)localObject1).e();
              }
              ((BaseChatItemLayout)localObject1).c();
            }
            else
            {
              bool2 = bool1;
              if ((localObject1 instanceof LinearLayout))
              {
                localObject1 = (LinearLayout)localObject1;
                int j = ((LinearLayout)localObject1).getChildCount() - 1;
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
              }
            }
            i -= 1;
            bool1 = bool2;
          }
          if (bool1)
          {
            i = EmojiStickerManager.a().jdField_a_of_type_Int;
            if (i == 1) {
              localObject1 = "2";
            } else if (i == 3000) {
              localObject1 = "3";
            } else {
              localObject1 = "1";
            }
            if (this.c == EmojiStickerManager.jdField_d_of_type_Int) {
              VasWebviewUtil.a("", "Stick", "Hide", (String)localObject1, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            } else {
              VasWebviewUtil.a("", "Stick", "CancelHide", (String)localObject1, 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            }
          }
        }
        else
        {
          QLog.e("TopGestureLayout", 1, "on on pointer touch up but list view is null");
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
      }
      else if (paramMotionEvent.getAction() == 0)
      {
        this.isInTowFingerMode = false;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370119);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370120);
        }
        if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        if (!PttConstants.a)
        {
          if (PttConstants.b) {
            return false;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370119);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131370120);
            }
            if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)localObject1);
            }
          }
          if (checkPttSlide(paramMotionEvent, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView)) {
            PttConstants.a = true;
          }
        }
        else
        {
          return false;
        }
      }
      else if (paramMotionEvent.getAction() == 3)
      {
        PttConstants.a = false;
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
      }
      else
      {
        PttConstants.a = false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.StickerDismissGestureDetector
 * JD-Core Version:    0.7.0.1
 */