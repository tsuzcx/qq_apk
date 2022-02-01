package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.HashSet;

public class AppSharePicItemBuilder
  extends BaseBubbleBuilder
{
  private final float jdField_b_of_type_Float;
  HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  
  public AppSharePicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(AppSharePicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isMixed)
    {
      Object localObject2 = paramHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      if (((MessageForPic)localObject2).msgtype == -1032)
      {
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720113);
      Object localObject1;
      if (((MessageForPic)localObject2).shareAppID != 0L)
      {
        String str2 = AppShareIDUtil.a(((MessageForPic)localObject2).shareAppID);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(str2);
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (((AppShareID)localObject2).messagetail != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131690095));
            ((StringBuilder)localObject1).append(((AppShareID)localObject2).messagetail);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          localObject1 = str1;
          if (!this.jdField_b_of_type_JavaUtilHashSet.contains(str2))
          {
            ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str2);
            this.jdField_b_of_type_JavaUtilHashSet.add(str2);
            localObject1 = str1;
          }
        }
      }
      else
      {
        localObject1 = str1;
        if (((MessageForPic)localObject2).msgtype == -3001) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692099);
        }
      }
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
    }
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaurl", paramMessageForPic.action);
    localBundle.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localBundle.putString("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getvKeyStr());
    OpenAppClient.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (AppSharePicItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setOrientation(1);
      paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131372696);
      if (!jdField_a_of_type_Boolean) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth((int)(this.jdField_b_of_type_Float * 224.0F + 0.5F));
      paramView.setMaxHeight((int)(this.jdField_b_of_type_Float * 224.0F + 0.5F));
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      int i = (int)(this.jdField_b_of_type_Float * 5.0F + 0.5F);
      ((LinearLayout.LayoutParams)localObject).leftMargin = i;
      ((LinearLayout.LayoutParams)localObject).topMargin = i;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = i;
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setTextSize(2, 12.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      localLayoutParams.bottomMargin = i;
      paramViewHolder.addView((View)localObject, localLayoutParams);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramChatMessage;
    if (!paramChatMessage.isSendFromLocal())
    {
      paramView = URLDrawableHelper.getURL(paramChatMessage, 1);
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        paramChatMessage = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
      }
    }
    a(paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new AppSharePicItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131700851);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365480)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (paramInt == 2131371603) {
      super.a(2131371603, paramContext, paramChatMessage);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.o = true;
    if (!super.a()) {
      if (paramView.getId() == 2131364521)
      {
        Object localObject = (AppSharePicItemBuilder.Holder)AIOUtils.a(paramView);
        MessageForPic localMessageForPic = (MessageForPic)((AppSharePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject = ((AppSharePicItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
        if (!localMessageForPic.isSendFromLocal())
        {
          int i = ((URLDrawable)localObject).getStatus();
          if (i != 0)
          {
            if (i != 1)
            {
              if (i == 2) {
                ((URLDrawable)localObject).restartDownload();
              }
            }
            else if (localMessageForPic.msgtype == -3001) {
              a(localMessageForPic);
            } else if (localMessageForPic.msgtype == -3005) {
              ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype);
            } else if ((localMessageForPic.msgtype == -3000) || (localMessageForPic.msgtype == -3004) || (localMessageForPic.msgtype == -1032)) {
              ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype, null);
            }
          }
          else if (!((URLDrawable)localObject).isDownloadStarted()) {
            ((URLDrawable)localObject).startDownload();
          }
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AppSharePicItemBuilder
 * JD-Core Version:    0.7.0.1
 */