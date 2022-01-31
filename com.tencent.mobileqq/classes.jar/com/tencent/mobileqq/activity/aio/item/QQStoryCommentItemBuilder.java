package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import vag;
import vah;

public class QQStoryCommentItemBuilder
  extends BaseBubbleBuilder
{
  protected static final int b = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  View.OnClickListener a;
  final int f = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public QQStoryCommentItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vag(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramViewHolder = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2130970815, null);
      paramViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131371896));
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131371895));
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramChatMessage.findViewById(2131368264);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131364453));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131363360));
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131366837));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131366842));
    }
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = ThumbnailUrlHelper.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843307);
      if (HttpUtil.a(paramView))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
        localURLDrawableOptions.mRequestWidth = this.f;
        localURLDrawableOptions.mRequestHeight = this.f;
        paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
        if (paramView.getStatus() == 2) {
          paramView.restartDownload();
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView;
        paramViewHolder.c.setText(paramBaseChatItemLayout.summary);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new vah(this, paramOnLongClickAndTouchListener));
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      return paramChatMessage;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQStoryCommentItemBuilder.QQStoryCommentViewHolder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375336: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131375342: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQStoryCommentItemBuilder", 2, paramContext.toString());
          }
        }
      }
    case 2131363499: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131361906: 
      super.a(paramChatMessage);
      StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.c(paramChatMessage);
    StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(e, b, d, c);
      return;
    }
    paramView.setPadding(d, b, e, c);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    if (paramBubbleInfo.b == 0)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramViewHolder.c.setTextColor(Color.argb(127, 0, 0, 0));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramBubbleInfo.b);
    int j = Color.green(paramBubbleInfo.b);
    int k = Color.blue(paramBubbleInfo.b);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramViewHolder.c.setTextColor(Color.argb(127, i, j, k));
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.b);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    Object localObject = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    paramViewHolder = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).b(paramChatMessage);
    localObject = (ETTextView)((QQStoryCommentItemBuilder.QQStoryCommentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramViewHolder != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramViewHolder.b, paramViewHolder.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131375342, this.jdField_a_of_type_AndroidContentContext.getString(2131435065), 2130838301);
    localQQCustomMenu.a(2131363499, this.jdField_a_of_type_AndroidContentContext.getString(2131435066), 2130838309);
    paramView = ((BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView)).a;
    super.a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    BaseBubbleBuilder.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder
 * JD-Core Version:    0.7.0.1
 */