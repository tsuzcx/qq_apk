package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler.OnDownloadIconClickListener;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class QFileItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, ContextMenuBuilder2, QFileBubbleDownloadHandler.OnDownloadIconClickListener
{
  protected QFileBubbleModel a;
  protected QFileBubblePauseHandler w;
  protected QFileBubbleDownloadHandler x;
  
  public QFileItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return paramQQCustomMenu;
      }
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        case 25: 
        default: 
          break;
        case 26: 
          paramQQCustomMenu.a(2131430893, HardCodeUtil.a(2131902523), 2130839065);
          break;
        case 24: 
          paramQQCustomMenu.a(2131445607, "StructMsg", 2130839066);
          break;
        case 23: 
          paramQQCustomMenu.a(2131446941, this.e.getString(2131917094), 2130839078);
          break;
        case 22: 
          paramQQCustomMenu.a(2131445242, this.e.getString(2131889327), 2130839066);
          break;
        case 21: 
          paramQQCustomMenu.a(2131433664, this.e.getString(2131889328), 2130839066);
          break;
        case 20: 
          a(paramQQCustomMenu, this.e, 2131428089, null, null);
          break;
        case 19: 
          paramQQCustomMenu.a(2131432813, this.e.getString(2131889272), 2130839065);
          break;
        case 18: 
          a(paramQQCustomMenu, paramChatMessage);
          break;
        case 17: 
          a(paramQQCustomMenu, this.e, 2131431695, paramChatMessage, new Bundle());
          break;
        case 16: 
          super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
          break;
        case 15: 
          a(paramQQCustomMenu, this.e, 2131438943, paramChatMessage, new Bundle());
          break;
        case 14: 
          paramQQCustomMenu.a(2131445236, this.e.getString(2131895126), 2130839062);
          break;
        case 13: 
          a(paramQQCustomMenu, this.e, 2131439081, null, null);
          break;
        case 12: 
          a(paramQQCustomMenu, this.e, 2131444651, paramChatMessage, null);
          break;
        case 11: 
          b(paramQQCustomMenu, paramChatMessage);
          break;
        case 10: 
          a(paramQQCustomMenu, this.e, 2131444634, paramChatMessage, null);
          break;
        case 9: 
          paramQQCustomMenu.a(2131433636, this.e.getString(2131889275), 2130839066);
          break;
        case 8: 
          paramQQCustomMenu.a(2131444731, this.e.getString(2131889805), 2130839073);
          break;
        case 7: 
          paramQQCustomMenu.a(2131439883, this.e.getString(2131889596), 2130839070);
          break;
        case 6: 
          paramQQCustomMenu.a(2131430288, this.e.getString(2131887713), 2130839055);
          break;
        case 5: 
          paramQQCustomMenu.a(2131444730, this.e.getString(2131889774), 2130839073);
          break;
        case 4: 
          paramQQCustomMenu.a(2131439881, this.e.getString(2131889596), 2130839070);
          break;
        case 3: 
          paramQQCustomMenu.a(2131430284, this.e.getString(2131895118), 2130839062);
          break;
        case 1: 
          paramQQCustomMenu.a(2131432097, this.e.getString(2131889594), 2130839062);
        }
      }
    }
    return paramQQCustomMenu;
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopTodoUtils.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131430283, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131430651, paramChatMessage, null);
    }
  }
  
  private void b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131432608, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131432607, paramChatMessage, null);
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (BaseBubbleBuilder.ViewHolder)AIOUtils.b(paramView);
    this.a.b(paramChatMessage);
    paramChatMessage = this.w;
    if (paramChatMessage != null) {
      paramChatMessage.a(paramViewGroup, paramView, this.a.v());
    }
    paramChatMessage = this.x;
    if (paramChatMessage != null)
    {
      paramChatMessage.a(this);
      this.x.a(paramViewGroup, paramView, this.a.v());
    }
    return paramView;
  }
  
  protected abstract View a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.a.b(paramChatMessage);
    this.a.m();
    paramView = a(paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder))
    {
      paramOnLongClickAndTouchListener = (QFileItemBuilder.QFileBaseHolder)paramViewHolder;
      a(paramOnLongClickAndTouchListener, paramBaseChatItemLayout, this.a.s());
      if (this.d != null)
      {
        paramOnLongClickAndTouchListener.x = super.a(paramOnLongClickAndTouchListener.x, paramViewHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
        super.a(paramOnLongClickAndTouchListener.x, paramBaseChatItemLayout, Integer.valueOf(2131447948), paramChatMessage, 2, Boolean.valueOf(false));
      }
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.a.n(), this);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return h();
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    this.a.b(paramChatMessage);
    paramQQCustomMenu = a(paramQQCustomMenu, paramChatMessage, a(paramQQCustomMenu, paramBaseHolder));
    paramBaseHolder = new Bundle();
    paramBaseHolder.putBoolean("isSearch", true);
    super.a(paramQQCustomMenu, this.e, 2131449133, paramChatMessage, paramBaseHolder);
    return paramQQCustomMenu;
  }
  
  protected abstract List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.a.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(QFileItemBuilder.QFileBaseHolder paramQFileBaseHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramQFileBaseHolder.w != null) {
        paramQFileBaseHolder.w.setVisibility(8);
      }
      return;
    }
    if (paramQFileBaseHolder.w == null)
    {
      paramQFileBaseHolder.w = new TextView(this.e);
      paramQFileBaseHolder.w.setId(2131447948);
      paramQFileBaseHolder.w.setBackgroundResource(2130843655);
      paramQFileBaseHolder.w.setTextSize(1, 12.0F);
      paramQFileBaseHolder.w.setTextColor(this.e.getResources().getColor(2131168464));
      paramQFileBaseHolder.w.setText(this.a.t());
      paramQFileBaseHolder.w.setSingleLine();
      paramQFileBaseHolder.w.setGravity(16);
      paramQFileBaseHolder.w.setPadding(DisplayUtil.a(this.e, 8.0F), 0, DisplayUtil.a(this.e, 8.0F), 0);
      paramQFileBaseHolder.w.setOnClickListener(new QFileItemBuilder.1(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131430578);
      paramViewGroup.addView(paramQFileBaseHolder.w, localLayoutParams);
    }
    paramQFileBaseHolder.w.setVisibility(0);
    if (this.a.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramQFileBaseHolder.w.getLayoutParams();
      paramViewGroup.addRule(7, 2131430578);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.e.getResources().getDimensionPixelSize(2131296615) + DisplayUtil.a(this.e, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramQFileBaseHolder.w.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramQFileBaseHolder.w.getLayoutParams();
    paramViewGroup.addRule(5, 2131430578);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.e.getResources().getDimensionPixelSize(2131296615) + DisplayUtil.a(this.e, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramQFileBaseHolder.w.setLayoutParams(paramViewGroup);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    a(paramChatMessage, paramViewHolder);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder) {}
  
  public void a(QFileBubbleModel paramQFileBubbleModel)
  {
    this.a = paramQFileBubbleModel;
    this.w = this.a.b();
    this.x = this.a.c();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = f(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView != null) {
      if (paramView.isMultiMsg) {
        b(localQQCustomMenu, paramView, null);
      } else {
        a(localQQCustomMenu, paramView, null);
      }
    }
    return localQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    this.a.b(paramChatMessage);
    return a(paramQQCustomMenu, paramChatMessage, b(paramQQCustomMenu, paramBaseHolder));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder);
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = f(paramView);
    this.a.b(paramView);
    this.a.o();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    this.a.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract void e(View paramView);
  
  protected ChatMessage f(View paramView)
  {
    return ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
  }
  
  public void f(ChatMessage paramChatMessage)
  {
    this.c.notifyDataSetChanged();
  }
  
  protected abstract BaseBubbleBuilder.ViewHolder h();
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    if (!super.c())
    {
      ChatMessage localChatMessage = f(paramView);
      this.a.b(localChatMessage);
      e(paramView);
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */