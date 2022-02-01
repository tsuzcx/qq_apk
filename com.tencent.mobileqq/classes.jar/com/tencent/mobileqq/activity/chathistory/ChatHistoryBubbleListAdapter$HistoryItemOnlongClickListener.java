package com.tencent.mobileqq.activity.chathistory;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.selectable.AIOMenuWrapper;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.ChatAdapterSelectableHelper;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper;
import com.tencent.mobileqq.activity.selectable.CommonMenuWrapper.MenuPlaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

class ChatHistoryBubbleListAdapter$HistoryItemOnlongClickListener
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  CommonMenuWrapper a;
  ChatMessage b;
  View c;
  View d;
  boolean e = false;
  boolean f = false;
  private PointF h = new PointF();
  
  private ChatHistoryBubbleListAdapter$HistoryItemOnlongClickListener(ChatHistoryBubbleListAdapter paramChatHistoryBubbleListAdapter) {}
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      if (i == 2131431695)
      {
        if (this.g.w != null) {
          this.g.w.a(this.b);
        }
        if (this.g.x.a == 1) {
          ReportController.b(this.g.u, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, this.g.x.b, "", "", "");
        }
      }
      else
      {
        Object localObject2;
        if ((i == 2131431492) && (!(localObject1 instanceof MessageForPtt)))
        {
          if (AIOSelectableDelegateImpl.a().l())
          {
            localObject1 = AIOSelectableDelegateImpl.a().d();
          }
          else
          {
            localObject1 = this.b;
            if ((localObject1 instanceof MessageForStructing))
            {
              MessageForStructing localMessageForStructing = (MessageForStructing)localObject1;
              localObject2 = ((ChatMessage)localObject1).msg;
              localObject1 = localObject2;
              if (localMessageForStructing != null)
              {
                localObject1 = localObject2;
                if (localMessageForStructing.structingMsg != null)
                {
                  localObject1 = localObject2;
                  if ("web".equals(localMessageForStructing.structingMsg.mMsgAction))
                  {
                    localObject1 = localObject2;
                    if (localMessageForStructing.structingMsg.mMsgUrl != null) {
                      localObject1 = localMessageForStructing.structingMsg.mMsgUrl;
                    }
                  }
                }
              }
            }
            else
            {
              localObject1 = ((ChatMessage)localObject1).msg;
            }
          }
          localObject2 = (ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard");
          ClipboardMonitor.setText((ClipboardManager)localObject2, (CharSequence)localObject1);
          ((ClipboardManager)localObject2).setText((CharSequence)localObject1);
          if (this.g.x.a == 1) {
            ReportController.b(this.g.u, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, this.g.x.b, "", "", "");
          }
        }
        else
        {
          localObject1 = this.g.c.a(this.b, this.g);
          localObject2 = paramView.getContext();
          ((ChatItemBuilder)localObject1).u = 2;
          ((ChatItemBuilder)localObject1).a(paramView.getId(), (Context)localObject2, this.b);
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
    }
    if ((i != 2131445511) && (AIOSelectableDelegateImpl.a().l())) {
      AIOSelectableDelegateImpl.a().n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss()
  {
    this.f = false;
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((CommonMenuWrapper)localObject1).g();
    }
    if (this.b != null)
    {
      localObject1 = this.g.c.a(this.b, this.g);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        localObject1 = (BaseBubbleBuilder)localObject1;
        ((BaseBubbleBuilder)localObject1).f();
        localObject2 = ((BaseBubbleBuilder)localObject1).d(this.c);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label110;
        }
        ((BaseBubbleBuilder.TouchDelegate)localObject2).a(this.c, true);
        localObject1 = localObject2;
        break label110;
      }
    }
    localObject1 = null;
    label110:
    Object localObject2 = this.c;
    if (localObject2 != null)
    {
      ((View)localObject2).setPressed(false);
      localObject2 = this.c.getTag();
      if ((localObject2 != null) && ((localObject2 instanceof AbsStructMsgItem)))
      {
        ((AbsStructMsgItem)localObject2).b(this.c);
      }
      else
      {
        if ((localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
        {
          Object localObject4 = this.d;
          if (localObject4 != null)
          {
            Object localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
            ((View)localObject4).getLayoutParams();
            this.d.getPaddingLeft();
            this.d.getPaddingTop();
            this.d.getPaddingRight();
            this.d.getPaddingBottom();
            if (this.e)
            {
              if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).i != null) {
                ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).i.a(this.g.u, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).q.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).q.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).h, false);
              }
            }
            else
            {
              localObject4 = this.b;
              if ((localObject4 != null) && (((ChatMessage)localObject4).istroop == 1008))
              {
                if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).g) {
                  this.d.setBackgroundResource(2130838318);
                }
              }
              else
              {
                localObject3 = (MessageForStructing)this.b;
                if (localObject1 == null) {
                  ChatHistoryBubbleListAdapter.c((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject2, this.d, false);
                }
              }
            }
            localObject1 = this.d.findViewById(2131435545);
            if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView)))
            {
              ((PAHighLightImageView)localObject1).a();
              break label565;
            }
            localObject1 = this.d.findViewById(2131446464);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label565;
            }
            ((PAHighLightImageView)localObject1).a();
            break label565;
          }
        }
        if ((localObject2 instanceof StructMsgItemButton))
        {
          localObject1 = this.d.getLayoutParams();
          int i = this.d.getPaddingLeft();
          int j = this.d.getPaddingTop();
          int k = this.d.getPaddingRight();
          int m = this.d.getPaddingBottom();
          int n = ((Integer)this.d.getTag(2131446443)).intValue();
          if (n == 0) {
            this.d.setBackgroundResource(2130838306);
          } else if (n == 2) {
            this.d.setBackgroundResource(2130838310);
          } else {
            this.d.setBackgroundResource(2130838308);
          }
          this.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.d.setPadding(i, j, k, m);
        }
      }
      label565:
      this.c = null;
      this.d = null;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.f = true;
    boolean bool1;
    if (this.g.h) {
      bool1 = false;
    } else {
      bool1 = this.g.o.a(paramView);
    }
    if (!bool1)
    {
      localObject1 = this.a;
      if ((localObject1 != null) && (((CommonMenuWrapper)localObject1).e()))
      {
        a(paramView);
        return false;
      }
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    Object localObject3 = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
    Object localObject2 = new QQCustomMenu();
    Object localObject1 = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
    ChatItemBuilder localChatItemBuilder = this.g.c.a((ChatMessage)localObject1, this.g);
    Object localObject4 = localChatItemBuilder.a(paramView);
    int j;
    int i;
    int k;
    if ((localObject4 != null) && (localObject4.length > 0))
    {
      j = localObject4.length;
      i = 0;
      while (i < j)
      {
        QQCustomMenuItem localQQCustomMenuItem = localObject4[i];
        k = localQQCustomMenuItem.b();
        if ((k == 2131431492) || (k == 2131445511) || (k == 2131433636) || (k == 2131432813)) {
          ((QQCustomMenu)localObject2).a(localQQCustomMenuItem);
        }
        i += 1;
      }
    }
    ((QQCustomMenu)localObject2).a(2131431695, this.g.u.getApp().getResources().getString(2131887718), 2130839061);
    if (((QQCustomMenu)localObject2).b() > 0)
    {
      this.b = ((ChatItemBuilder.BaseHolder)localObject3).q;
      if ((this.b instanceof MessageForStructing)) {
        i = 1;
      } else {
        i = 0;
      }
      j = (int)this.h.y - AIOUtils.b(10.0F, paramView.getResources());
      localObject3 = new int[2];
      paramView.getLocationOnScreen((int[])localObject3);
      k = localObject3[1] - AIOUtils.b(3.0F, paramView.getResources());
      localObject3 = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject3);
      if (k - AIOUtils.b(72.0F, paramView.getResources()) > ((Rect)localObject3).top) {
        j = k;
      }
      if (this.a == null)
      {
        this.a = new AIOMenuWrapper(ChatHistoryBubbleListAdapter.a(this.g));
        this.a.a(this);
        this.a.a(this);
      }
      this.a.c = ((int)this.h.y);
      k = (int)this.h.x - ViewUtils.dpToPx(14.0F);
      localObject3 = this.a;
      ((CommonMenuWrapper)localObject3).d = k;
      int m;
      if (bool1)
      {
        boolean bool2;
        if ((localObject1 != null) && (((ChatMessage)localObject1).isMultiMsg)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        ((CommonMenuWrapper)localObject3).a((QQCustomMenu)localObject2, bool2);
        this.a.a(k);
        this.a.b(j);
      }
      else
      {
        localObject4 = ((CommonMenuWrapper)localObject3).a(paramView, ChatHistoryBubbleListAdapter.b(this.g));
        if ((ChatHistoryBubbleListAdapter.c(this.g) != null) && (ChatHistoryBubbleListAdapter.d(this.g).X != null))
        {
          localObject1 = new int[2];
          ChatHistoryBubbleListAdapter.e(this.g).X.getLocationInWindow((int[])localObject1);
        }
        else
        {
          localObject1 = null;
        }
        localObject3 = this.a;
        j = ((CommonMenuWrapper.MenuPlaceInfo)localObject4).a;
        m = ((CommonMenuWrapper.MenuPlaceInfo)localObject4).b;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Integer.valueOf(localObject1[1]);
        }
        ((CommonMenuWrapper)localObject3).a(paramView, k, j, (QQCustomMenu)localObject2, true, m, (Integer)localObject1);
      }
      a(paramView);
      if (i != 0)
      {
        paramView.setPressed(true);
        this.c = paramView;
        localObject1 = this.c.getTag();
        if ((localObject1 instanceof AbsStructMsgItem))
        {
          ((AbsStructMsgItem)localObject1).c(this.c);
        }
        else if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
        {
          localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
          if ((localChatItemBuilder instanceof StructingMsgItemBuilder)) {
            if (((StructingMsgItemBuilder)localChatItemBuilder).c(this.b) == 0)
            {
              if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.getChildCount() > 0)) {
                this.d = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.getChildAt(0);
              }
              this.e = false;
            }
            else
            {
              this.d = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a;
              this.e = true;
            }
          }
          if ((this.d != null) && (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).g))
          {
            localObject2 = this.d.getLayoutParams();
            i = this.d.getPaddingLeft();
            j = this.d.getPaddingTop();
            k = this.d.getPaddingRight();
            m = this.d.getPaddingBottom();
            if (this.e)
            {
              if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).q.isSend()) {
                ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).h.setBackgroundResource(2130852127);
              } else {
                ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).h.setBackgroundResource(2130851945);
              }
            }
            else if (this.b.istroop == 1008)
            {
              this.d.setBackgroundResource(2130838320);
            }
            else
            {
              localObject3 = (MessageForStructing)this.b;
              if (((BaseBubbleBuilder)localChatItemBuilder).d(paramView) == null) {
                ChatHistoryBubbleListAdapter.b((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject1, this.d, true);
              }
            }
            this.d.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.d.setPadding(i, j, k, m);
          }
        }
        else if ((localObject1 instanceof StructMsgItemButton))
        {
          this.d = paramView;
          localObject1 = this.d.getLayoutParams();
          i = this.d.getPaddingLeft();
          j = this.d.getPaddingTop();
          k = this.d.getPaddingRight();
          m = this.d.getPaddingBottom();
          int n = ((Integer)paramView.getTag(2131446443)).intValue();
          if (n == 0) {
            this.d.setBackgroundResource(2130838307);
          } else if (n == 2) {
            this.d.setBackgroundResource(2130838311);
          } else {
            this.d.setBackgroundResource(2130838309);
          }
          this.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.d.setPadding(i, j, k, m);
        }
      }
      if ((localChatItemBuilder instanceof BaseBubbleBuilder))
      {
        localObject1 = ((BaseBubbleBuilder)localChatItemBuilder).d(paramView);
        if (localObject1 != null)
        {
          this.c = paramView;
          if (bool1) {
            ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, true);
          } else {
            ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, false);
          }
        }
      }
      if (bool1) {
        if ((this.h != null) && (this.g.o.a(paramView, this.h.x, this.h.y, 1, 2)))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ChatHistoryBubbleListAdapter", 2, "performCursorTouch ");
            return true;
          }
        }
        else {
          this.g.o.a(paramView, this.a);
        }
      }
      return true;
    }
    a(paramView);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.h.x = paramMotionEvent.getRawX();
      this.h.y = paramMotionEvent.getRawY();
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
    }
    Object localObject = this.g.c.a(AIOUtils.a(paramView), this.g);
    if ((!this.f) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).d(paramView);
      if (localObject != null) {
        ((BaseBubbleBuilder.TouchDelegate)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter.HistoryItemOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */