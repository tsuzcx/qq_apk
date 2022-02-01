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
  private TopGestureLayout a;
  private float b;
  private float c;
  private int d = 0;
  private int e = 1;
  private int f;
  private ChatXListView g;
  public boolean isInTowFingerMode = false;
  
  public StickerDismissGestureDetector(TopGestureLayout paramTopGestureLayout, Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    super(paramContext, paramOnGestureListener);
    this.a = paramTopGestureLayout;
  }
  
  void a(MotionEvent paramMotionEvent, ChatXListView paramChatXListView)
  {
    float f4 = paramMotionEvent.getX(this.d) - this.b;
    float f3 = paramMotionEvent.getX(this.e) - this.c;
    this.b = paramMotionEvent.getX(this.d);
    this.c = paramMotionEvent.getX(this.e);
    if (f4 * f3 < 0.0F)
    {
      int i;
      if (f4 < 0.0F) {
        i = EmojiStickerManager.p;
      } else {
        i = EmojiStickerManager.q;
      }
      this.f = i;
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
            if (this.f == EmojiStickerManager.p)
            {
              f1 = Math.min(0.0F, f4);
              f2 = Math.max(0.0F, f3);
              paramMotionEvent.a((int)Math.abs(f1 - f2), this.f);
            }
            else
            {
              f1 = f4;
              f2 = f3;
              if (this.f == EmojiStickerManager.q)
              {
                f1 = Math.max(0.0F, f4);
                f2 = Math.min(0.0F, f3);
                paramMotionEvent.a((int)Math.abs(f1 - f2), this.f);
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
                  if (this.f == EmojiStickerManager.p)
                  {
                    f1 = Math.min(0.0F, f4);
                    f2 = Math.max(0.0F, f3);
                    ((StickerGrayTipLayout)localObject).doDismiss((int)Math.abs(f1 - f2), this.f);
                  }
                  else
                  {
                    f1 = f4;
                    f2 = f3;
                    if (this.f == EmojiStickerManager.q)
                    {
                      f1 = Math.max(0.0F, f4);
                      f2 = Math.min(0.0F, f3);
                      ((StickerGrayTipLayout)localObject).doDismiss((int)Math.abs(f1 - f2), this.f);
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
    if (EmojiStickerManager.e)
    {
      localObject1 = this.a.findViewById(2131442187);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    if (EmojiStickerManager.d)
    {
      localObject1 = this.a.findViewById(2131442184);
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
        localObject1 = ((BaseActivity)localObject1).getChatFragment().k();
        if ((((localObject1 instanceof BaseTroopChatPie)) || ((localObject1 instanceof FriendChatPie)) || ((localObject1 instanceof DiscussChatPie))) && (EmojiStickerManager.a().B.size() > 0))
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
                  localObject1 = this.a.findViewById(2131437281);
                  if ((localObject1 instanceof ChatXListView)) {
                    this.g = ((ChatXListView)localObject1);
                  }
                  if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
                  {
                    this.d = 0;
                    this.e = 1;
                    this.b = paramMotionEvent.getX(0);
                    this.c = paramMotionEvent.getX(1);
                    return true;
                  }
                  this.d = 1;
                  this.e = 0;
                  this.b = paramMotionEvent.getX(1);
                  this.c = paramMotionEvent.getX(0);
                  return true;
                }
              }
              else
              {
                if (this.g == null)
                {
                  localObject1 = this.a.findViewById(2131437281);
                  if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
                    this.g = ((ChatXListView)localObject1);
                  }
                }
                a(paramMotionEvent, this.g);
                return true;
              }
            }
            this.g = null;
            return true;
          }
          localObject1 = this.a.findViewById(2131437281);
          if ((localObject1 instanceof ChatXListView)) {
            this.g = ((ChatXListView)localObject1);
          }
          this.b = paramMotionEvent.getX(0);
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
        PttConstants.b = false;
        if (this.g == null)
        {
          localObject1 = this.a.findViewById(2131437281);
          if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
            this.g = ((ChatXListView)localObject1);
          }
        }
        localObject1 = this.g;
        if (localObject1 != null)
        {
          i = ((ChatXListView)localObject1).getChildCount() - 1;
          while (i >= 0)
          {
            localObject1 = this.g.getChildAt(i);
            boolean bool2;
            if ((localObject1 instanceof BaseChatItemLayout))
            {
              localObject1 = (BaseChatItemLayout)localObject1;
              bool2 = bool1;
              if (!bool1) {
                bool2 = ((BaseChatItemLayout)localObject1).i();
              }
              ((BaseChatItemLayout)localObject1).h();
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
            i = EmojiStickerManager.a().h;
            if (i == 1) {
              localObject1 = "2";
            } else if (i == 3000) {
              localObject1 = "3";
            } else {
              localObject1 = "1";
            }
            if (this.f == EmojiStickerManager.p) {
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
        this.g = null;
      }
      else if (paramMotionEvent.getAction() == 0)
      {
        this.isInTowFingerMode = false;
        localObject2 = this.a.findViewById(2131437281);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.a.findViewById(2131437282);
        }
        if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
          this.g = ((ChatXListView)localObject1);
        }
      }
      else if (paramMotionEvent.getAction() == 2)
      {
        if (!PttConstants.b)
        {
          if (PttConstants.c) {
            return false;
          }
          if (this.g == null)
          {
            localObject2 = this.a.findViewById(2131437281);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = this.a.findViewById(2131437282);
            }
            if ((localObject1 != null) && ((localObject1 instanceof ChatXListView))) {
              this.g = ((ChatXListView)localObject1);
            }
          }
          if (checkPttSlide(paramMotionEvent, this.g)) {
            PttConstants.b = true;
          }
        }
        else
        {
          return false;
        }
      }
      else if (paramMotionEvent.getAction() == 3)
      {
        PttConstants.b = false;
        this.g = null;
      }
      else
      {
        PttConstants.b = false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.StickerDismissGestureDetector
 * JD-Core Version:    0.7.0.1
 */