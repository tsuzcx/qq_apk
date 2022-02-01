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
  protected QFileBubbleDownloadHandler a;
  protected QFileBubblePauseHandler a;
  protected QFileBubbleModel a;
  
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
        case 24: 
        default: 
          break;
        case 25: 
          paramQQCustomMenu.a(2131364785, HardCodeUtil.a(2131704619), 2130838911);
          break;
        case 23: 
          paramQQCustomMenu.a(2131377224, "StructMsg", 2130838912);
          break;
        case 22: 
          paramQQCustomMenu.a(2131378344, this.jdField_a_of_type_AndroidContentContext.getString(2131719531), 2130838924);
          break;
        case 21: 
          paramQQCustomMenu.a(2131376894, this.jdField_a_of_type_AndroidContentContext.getString(2131692339), 2130838912);
          break;
        case 20: 
          paramQQCustomMenu.a(2131367208, this.jdField_a_of_type_AndroidContentContext.getString(2131692340), 2130838912);
          break;
        case 19: 
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
          break;
        case 18: 
          paramQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692284), 2130838911);
          break;
        case 17: 
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramChatMessage, new Bundle());
          break;
        case 16: 
          super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
          break;
        case 15: 
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramChatMessage, new Bundle());
          break;
        case 14: 
          paramQQCustomMenu.a(2131376890, this.jdField_a_of_type_AndroidContentContext.getString(2131697353), 2130838908);
          break;
        case 13: 
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371660, null, null);
          break;
        case 12: 
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramChatMessage, null);
          break;
        case 11: 
          a(paramQQCustomMenu, paramChatMessage);
          break;
        case 10: 
          a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramChatMessage, null);
          break;
        case 9: 
          paramQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692287), 2130838912);
          break;
        case 8: 
          paramQQCustomMenu.a(2131376490, this.jdField_a_of_type_AndroidContentContext.getString(2131692734), 2130838919);
          break;
        case 7: 
          paramQQCustomMenu.a(2131372365, this.jdField_a_of_type_AndroidContentContext.getString(2131692573), 2130838916);
          break;
        case 6: 
          paramQQCustomMenu.a(2131364271, this.jdField_a_of_type_AndroidContentContext.getString(2131690787), 2130838901);
          break;
        case 5: 
          paramQQCustomMenu.a(2131376489, this.jdField_a_of_type_AndroidContentContext.getString(2131692703), 2130838919);
          break;
        case 4: 
          paramQQCustomMenu.a(2131372363, this.jdField_a_of_type_AndroidContentContext.getString(2131692573), 2130838916);
          break;
        case 3: 
          paramQQCustomMenu.a(2131364267, this.jdField_a_of_type_AndroidContentContext.getString(2131697345), 2130838908);
          break;
        case 1: 
          paramQQCustomMenu.a(2131365839, this.jdField_a_of_type_AndroidContentContext.getString(2131692571), 2130838908);
        }
      }
    }
    return paramQQCustomMenu;
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366309, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366308, paramChatMessage, null);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(paramChatMessage);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemQFileBubblePauseHandler;
    if (paramChatMessage != null) {
      paramChatMessage.a(paramViewGroup, paramView, this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a());
    }
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemQFileBubbleDownloadHandler;
    if (paramChatMessage != null)
    {
      paramChatMessage.a(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemQFileBubbleDownloadHandler.a(paramViewGroup, paramView, this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a());
    }
    return paramView;
  }
  
  protected abstract View a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
    paramView = a(paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    if ((paramViewHolder instanceof QFileItemBuilder.QFileBaseHolder))
    {
      paramOnLongClickAndTouchListener = (QFileItemBuilder.QFileBaseHolder)paramViewHolder;
      a(paramOnLongClickAndTouchListener, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramOnLongClickAndTouchListener.d = super.a(paramOnLongClickAndTouchListener.d, paramViewHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(paramOnLongClickAndTouchListener.d, paramBaseChatItemLayout, Integer.valueOf(2131379211), paramChatMessage, 2, Boolean.valueOf(false));
      }
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(), this);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return b();
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).a;
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(paramChatMessage);
    paramQQCustomMenu = a(paramQQCustomMenu, paramChatMessage, a(paramQQCustomMenu, paramBaseHolder));
    paramBaseHolder = new Bundle();
    paramBaseHolder.putBoolean("isSearch", true);
    super.a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramChatMessage, paramBaseHolder);
    return paramQQCustomMenu;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c();
  }
  
  protected void a(QFileItemBuilder.QFileBaseHolder paramQFileBaseHolder, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramQFileBaseHolder.a != null) {
        paramQFileBaseHolder.a.setVisibility(8);
      }
      return;
    }
    if (paramQFileBaseHolder.a == null)
    {
      paramQFileBaseHolder.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramQFileBaseHolder.a.setId(2131379211);
      paramQFileBaseHolder.a.setBackgroundResource(2130842702);
      paramQFileBaseHolder.a.setTextSize(1, 12.0F);
      paramQFileBaseHolder.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
      paramQFileBaseHolder.a.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.d());
      paramQFileBaseHolder.a.setSingleLine();
      paramQFileBaseHolder.a.setGravity(16);
      paramQFileBaseHolder.a.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramQFileBaseHolder.a.setOnClickListener(new QFileItemBuilder.1(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364521);
      paramViewGroup.addView(paramQFileBaseHolder.a, localLayoutParams);
    }
    paramQFileBaseHolder.a.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramQFileBaseHolder.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364521);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramQFileBaseHolder.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramQFileBaseHolder.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364521);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramQFileBaseHolder.a.setLayoutParams(paramViewGroup);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    a(paramChatMessage, paramViewHolder);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder) {}
  
  public void a(QFileBubbleModel paramQFileBubbleModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel = paramQFileBubbleModel;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemQFileBubblePauseHandler = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemQFileBubbleDownloadHandler = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramView != null) {
      if (paramView.isMultiMsg) {
        b(localQQCustomMenu, paramView, null);
      } else {
        a(localQQCustomMenu, paramView, null);
      }
    }
    return localQQCustomMenu.a();
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract BaseBubbleBuilder.ViewHolder b();
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(paramChatMessage);
    return a(paramQQCustomMenu, paramChatMessage, b(paramQQCustomMenu, paramBaseHolder));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder);
  
  public void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected abstract void c(View paramView);
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    if (!super.a())
    {
      ChatMessage localChatMessage = a(paramView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(localChatMessage);
      c(paramView);
      super.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileItemBuilder
 * JD-Core Version:    0.7.0.1
 */