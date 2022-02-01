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
  HashSet<String> a = new HashSet();
  private final float w;
  
  public AppSharePicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.w = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(AppSharePicItemBuilder.Holder paramHolder)
  {
    if (paramHolder.c.isMixed)
    {
      Object localObject2 = paramHolder.c;
      if (((MessageForPic)localObject2).msgtype == -1032)
      {
        paramHolder.b.setVisibility(8);
        return;
      }
      String str1 = this.e.getString(2131917739);
      Object localObject1;
      if (((MessageForPic)localObject2).shareAppID != 0L)
      {
        String str2 = AppShareIDUtil.a(((MessageForPic)localObject2).shareAppID);
        localObject2 = this.d.getMsgHandler().d(str2);
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (((AppShareID)localObject2).messagetail != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.e.getString(2131886915));
            ((StringBuilder)localObject1).append(((AppShareID)localObject2).messagetail);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          localObject1 = str1;
          if (!this.a.contains(str2))
          {
            ConfigUtil.a(this.d, this.d.getCurrentAccountUin(), str2);
            this.a.add(str2);
            localObject1 = str1;
          }
        }
      }
      else
      {
        localObject1 = str1;
        if (((MessageForPic)localObject2).msgtype == -3001) {
          localObject1 = this.e.getString(2131889080);
        }
      }
      paramHolder.b.setVisibility(0);
      paramHolder.b.setText((CharSequence)localObject1);
      return;
    }
    paramHolder.b.setVisibility(8);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaurl", paramMessageForPic.action);
    localBundle.putString("uin", this.d.getCurrentAccountUin());
    localBundle.putString("vkey", this.d.getvKeyStr());
    OpenAppClient.a((Activity)this.e, localBundle);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (AppSharePicItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new LinearLayout(this.e);
      paramViewHolder.setOrientation(1);
      paramView = new ChatThumbView(this.e);
      paramView.setId(2131440242);
      if (!m) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth((int)(this.w * 224.0F + 0.5F));
      paramView.setMaxHeight((int)(this.w * 224.0F + 0.5F));
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      int i = (int)(this.w * 5.0F + 0.5F);
      ((LinearLayout.LayoutParams)localObject).leftMargin = i;
      ((LinearLayout.LayoutParams)localObject).topMargin = i;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = i;
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(this.e);
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
      paramBaseChatItemLayout.a = paramView;
      paramBaseChatItemLayout.b = ((TextView)localObject);
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout.c = paramChatMessage;
    if (!paramChatMessage.isSendFromLocal())
    {
      paramView = URLDrawableHelper.getURL(paramChatMessage, 1);
      if ((paramBaseChatItemLayout.d == null) || (!paramBaseChatItemLayout.d.getURL().equals(paramView)))
      {
        paramChatMessage = PicItemBuilder.a(this.e, paramChatMessage, paramBaseChatItemLayout.a);
        paramBaseChatItemLayout.a.setImageDrawable(paramChatMessage);
        paramBaseChatItemLayout.d = paramChatMessage;
      }
    }
    a(paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new AppSharePicItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131431695)
    {
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    }
    if (paramInt == 2131439015) {
      super.a(2131439015, paramContext, paramChatMessage);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.e, this.f.a);
    super.a(paramView, this.e, 2131439015, null, null);
    super.a(paramView, this.e, 2131428089, null, null);
    return paramView.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131898875);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    if (!super.c()) {
      if (paramView.getId() == 2131430578)
      {
        Object localObject = (AppSharePicItemBuilder.Holder)AIOUtils.b(paramView);
        MessageForPic localMessageForPic = (MessageForPic)((AppSharePicItemBuilder.Holder)localObject).q;
        localObject = ((AppSharePicItemBuilder.Holder)localObject).d;
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
              ChatActivityUtils.a(this.e, this.d, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype);
            } else if ((localMessageForPic.msgtype == -3000) || (localMessageForPic.msgtype == -3004) || (localMessageForPic.msgtype == -1032)) {
              ChatActivityUtils.a(this.e, this.d, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AppSharePicItemBuilder
 * JD-Core Version:    0.7.0.1
 */