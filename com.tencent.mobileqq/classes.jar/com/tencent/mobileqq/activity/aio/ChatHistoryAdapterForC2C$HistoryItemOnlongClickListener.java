package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
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
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

class ChatHistoryAdapterForC2C$HistoryItemOnlongClickListener
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  CommonMenuWrapper a;
  ChatMessage b;
  View c;
  View d;
  boolean e = false;
  boolean f = false;
  private PointF h = new PointF();
  private boolean i = true;
  private boolean j = false;
  
  private ChatHistoryAdapterForC2C$HistoryItemOnlongClickListener(ChatHistoryAdapterForC2C paramChatHistoryAdapterForC2C) {}
  
  private void a(View paramView, ChatItemBuilder paramChatItemBuilder)
  {
    paramView.setPressed(true);
    this.c = paramView;
    Object localObject1 = this.c.getTag();
    if ((localObject1 instanceof AbsStructMsgItem))
    {
      ((AbsStructMsgItem)localObject1).c(this.c);
      return;
    }
    int k;
    int m;
    int n;
    int i1;
    if ((localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
    {
      Object localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
      if ((paramChatItemBuilder instanceof StructingMsgItemBuilder)) {
        if (((StructingMsgItemBuilder)paramChatItemBuilder).c(this.b) == 0)
        {
          if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a.getChildCount() > 0)) {
            this.d = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a.getChildAt(0);
          }
          this.e = false;
        }
        else
        {
          this.d = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a;
          this.e = true;
        }
      }
      if ((this.d != null) && (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).g))
      {
        ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
        k = this.d.getPaddingLeft();
        m = this.d.getPaddingTop();
        n = this.d.getPaddingRight();
        i1 = this.d.getPaddingBottom();
        if (this.e)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).q.isSend()) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).h.setBackgroundResource(2130852127);
          } else {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).h.setBackgroundResource(2130851945);
          }
        }
        else if (this.b.istroop == 1008)
        {
          this.d.setBackgroundResource(2130838320);
        }
        else
        {
          localObject2 = (MessageForStructing)this.b;
          if (((BaseBubbleBuilder)paramChatItemBuilder).d(paramView) == null) {
            ChatAdapter1.a((MessageForStructing)localObject2, (BaseBubbleBuilder.ViewHolder)localObject1, this.d, true);
          }
        }
        this.d.setLayoutParams(localLayoutParams);
        this.d.setPadding(k, m, n, i1);
      }
    }
    else if ((localObject1 instanceof StructMsgItemButton))
    {
      this.d = paramView;
      paramChatItemBuilder = this.d.getLayoutParams();
      k = this.d.getPaddingLeft();
      m = this.d.getPaddingTop();
      n = this.d.getPaddingRight();
      i1 = this.d.getPaddingBottom();
      int i2 = ((Integer)paramView.getTag(2131446443)).intValue();
      if (i2 == 0) {
        this.d.setBackgroundResource(2130838307);
      } else if (i2 == 2) {
        this.d.setBackgroundResource(2130838311);
      } else {
        this.d.setBackgroundResource(2130838309);
      }
      this.d.setLayoutParams(paramChatItemBuilder);
      this.d.setPadding(k, m, n, i1);
    }
  }
  
  private boolean a(QQCustomMenu paramQQCustomMenu, View paramView, boolean paramBoolean, ChatMessage paramChatMessage, ChatItemBuilder paramChatItemBuilder)
  {
    if (paramQQCustomMenu.b() > 0)
    {
      this.b = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
      Object localObject = this.b;
      int k;
      if ((localObject != null) && ((localObject instanceof MessageForStructing))) {
        k = 1;
      } else {
        k = 0;
      }
      int m = (int)this.h.y - AIOUtils.b(10.0F, paramView.getResources());
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      int n = localObject[1] - AIOUtils.b(3.0F, paramView.getResources());
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      if (n - AIOUtils.b(72.0F, paramView.getResources()) > ((Rect)localObject).top) {
        m = n;
      }
      if (this.a == null)
      {
        this.a = new AIOMenuWrapper(this.g.k);
        this.a.a(this);
        this.a.a(this);
      }
      this.a.c = ((int)this.h.y);
      n = (int)this.h.x - ViewUtils.dpToPx(14.0F);
      localObject = this.a;
      ((CommonMenuWrapper)localObject).d = n;
      if (paramBoolean)
      {
        boolean bool;
        if ((paramChatMessage != null) && (paramChatMessage.isMultiMsg)) {
          bool = true;
        } else {
          bool = false;
        }
        ((CommonMenuWrapper)localObject).a(paramQQCustomMenu, bool);
        this.a.a(n);
        this.a.b(m);
      }
      else
      {
        CommonMenuWrapper.MenuPlaceInfo localMenuPlaceInfo = ((CommonMenuWrapper)localObject).a(paramView, this.g.k);
        if ((this.g.k != null) && (this.g.k.X != null))
        {
          paramChatMessage = new int[2];
          this.g.k.X.getLocationInWindow(paramChatMessage);
        }
        else
        {
          paramChatMessage = null;
        }
        localObject = this.a;
        m = localMenuPlaceInfo.a;
        int i1 = localMenuPlaceInfo.b;
        if (paramChatMessage == null) {
          paramChatMessage = null;
        } else {
          paramChatMessage = Integer.valueOf(paramChatMessage[1]);
        }
        ((CommonMenuWrapper)localObject).a(paramView, n, m, paramQQCustomMenu, true, i1, paramChatMessage);
      }
      a(paramView);
      if (k != 0) {
        a(paramView, paramChatItemBuilder);
      }
      if ((paramChatItemBuilder instanceof BaseBubbleBuilder))
      {
        paramQQCustomMenu = ((BaseBubbleBuilder)paramChatItemBuilder).d(paramView);
        if (paramQQCustomMenu != null)
        {
          this.c = paramView;
          if (paramBoolean) {
            paramQQCustomMenu.a(paramView, true);
          } else {
            paramQQCustomMenu.a(paramView, false);
          }
        }
      }
      if (paramBoolean) {
        if ((this.h != null) && (this.g.o.a(paramView, this.h.x, this.h.y, 1, 2)))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ChatHistoryAdapterForC2C", 2, "performCursorTouch ");
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
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (this.b != null)
    {
      if (k == 2131431695)
      {
        if (ChatHistoryAdapterForC2C.a(this.g) != null) {
          ChatHistoryAdapterForC2C.a(this.g).a(this.b);
        }
        VipUtils.a(this.g.b, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
      }
      else
      {
        Object localObject;
        if (k == 2131446941)
        {
          ReportController.b(this.g.b, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
          localObject = (MessageForFile)this.b;
          localObject = FileManagerUtil.a(this.g.b, (MessageForFile)localObject);
          if (localObject != null) {
            TeamWorkConvertUtils.a((FileManagerEntity)localObject, this.g.u, this.g.b, 1);
          } else {
            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131917091), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
          }
        }
        else
        {
          localObject = this.g.c.a(this.b, this.g);
          Context localContext = paramView.getContext();
          ((ChatItemBuilder)localObject).a(paramView.getId(), localContext, this.b);
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
    }
    if ((k != 2131445511) && (AIOSelectableDelegateImpl.a().l())) {
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
      if ((localObject2 instanceof AbsStructMsgItem))
      {
        ((AbsStructMsgItem)localObject2).b(this.c);
      }
      else if (((localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) && (this.d != null))
      {
        Object localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
        if (this.e)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).i != null) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).i.a(this.g.b, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).q.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).q.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).h, false);
          }
        }
        else
        {
          ChatMessage localChatMessage = this.b;
          if ((localChatMessage != null) && (localChatMessage.istroop == 1008))
          {
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).g) {
              this.d.setBackgroundResource(2130838318);
            }
          }
          else
          {
            localObject3 = (MessageForStructing)this.b;
            if (localObject1 == null) {
              ChatAdapter1.a((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject2, this.d, false);
            }
          }
        }
        localObject1 = this.d.findViewById(2131435545);
        if ((localObject1 instanceof PAHighLightImageView))
        {
          ((PAHighLightImageView)localObject1).a();
        }
        else
        {
          localObject1 = this.d.findViewById(2131446464);
          if ((localObject1 instanceof PAHighLightImageView)) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      }
      else if ((localObject2 instanceof StructMsgItemButton))
      {
        localObject1 = this.d.getLayoutParams();
        int k = this.d.getPaddingLeft();
        int m = this.d.getPaddingTop();
        int n = this.d.getPaddingRight();
        int i1 = this.d.getPaddingBottom();
        int i2 = ((Integer)this.d.getTag(2131446443)).intValue();
        if (i2 == 0) {
          this.d.setBackgroundResource(2130838306);
        } else if (i2 == 2) {
          this.d.setBackgroundResource(2130838310);
        } else {
          this.d.setBackgroundResource(2130838308);
        }
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.d.setPadding(k, m, n, i1);
      }
      this.c = null;
      this.d = null;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = this.g.h;
    int k = 0;
    if (bool) {
      bool = false;
    } else {
      bool = this.g.o.a(paramView);
    }
    this.f = true;
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    if (!bool)
    {
      localObject1 = this.a;
      if ((localObject1 != null) && (((CommonMenuWrapper)localObject1).e()))
      {
        a(paramView);
        return false;
      }
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    this.b = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
    int m = this.b.msgtype;
    if ((m == -2014) || (m == -2005))
    {
      if (this.i)
      {
        this.j = TencentDocConvertConfigProcessor.a().c();
        this.i = false;
      }
      localObject1 = (MessageForFile)this.b;
      localObject3 = FileManagerUtil.a(this.g.b, (MessageForFile)localObject1);
      if ((localObject3 != null) && (((FileManagerEntity)localObject3).status != 16))
      {
        long l = FileManagerUtil.v(((FileManagerEntity)localObject3).fileName);
        localObject2 = TencentDocImportFileInfoProcessor.a().d();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ".doc|.docx|.xls|.xlsx|";
        }
        if ((this.j) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(((FileManagerEntity)localObject3).getFilePath(), ((FileManagerEntity)localObject3).fileName, (String)localObject1)) && (((FileManagerEntity)localObject3).fileSize <= l))
        {
          ReportController.b(this.g.b, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          localQQCustomMenu.a(2131446941, this.g.u.getString(2131917094), 2130839078);
        }
      }
    }
    Object localObject1 = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
    Object localObject2 = this.g.c.a((ChatMessage)localObject1, this.g);
    Object localObject3 = ((ChatItemBuilder)localObject2).a(paramView);
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      m = localObject3.length;
      while (k < m)
      {
        QQCustomMenuItem localQQCustomMenuItem = localObject3[k];
        int n = localQQCustomMenuItem.b();
        if (((n == 2131431492) || (n == 2131445511) || (n == 2131433636) || (n == 2131432813)) && (localQQCustomMenuItem.c() != 2130838495)) {
          localQQCustomMenu.a(localQQCustomMenuItem);
        }
        k += 1;
      }
    }
    localQQCustomMenu.a(2131431695, this.g.b.getApp().getResources().getString(2131887718), 2130839061);
    return a(localQQCustomMenu, paramView, bool, (ChatMessage)localObject1, (ChatItemBuilder)localObject2);
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
    Object localObject = this.g.c.a(((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q, this.g);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C.HistoryItemOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */