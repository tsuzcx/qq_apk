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
import com.tencent.mobileqq.studymode.AlphabeticFontHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qphone.base.util.QLog;

public class QQStoryCommentItemBuilder
  extends BaseBubbleBuilder
{
  protected static final int a = BaseChatItemLayout.k + BaseChatItemLayout.n;
  protected static final int w = BaseChatItemLayout.l + BaseChatItemLayout.o;
  protected static final int x = BaseChatItemLayout.getBubblePaddingAlignHead() + BaseChatItemLayout.getTextPaddingAlignHead();
  protected static final int y = BaseChatItemLayout.getBubblePaddingAlignError() + BaseChatItemLayout.getTextPaddingAlignError();
  View.OnClickListener A = new QQStoryCommentItemBuilder.1(this);
  private AlphabeticFontHelper B;
  final int z = DisplayUtil.a(this.e, 50.0F);
  
  public QQStoryCommentItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramViewHolder = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131628178, null);
      paramViewHolder.f = ((RelativeLayout)paramChatMessage.findViewById(2131446417));
      paramViewHolder.e = ((RelativeLayout)paramChatMessage.findViewById(2131446418));
      paramViewHolder.g = paramChatMessage.findViewById(2131435127);
      paramViewHolder.a = ((ImageView)paramChatMessage.findViewById(2131431458));
      paramViewHolder.b = ((TextView)paramChatMessage.findViewById(2131447463));
      paramViewHolder.d = ((TextView)paramChatMessage.findViewById(2131447345));
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131431033));
    }
    paramViewHolder.c.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = ThumbnailUrlHelper.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.e.getResources().getDrawable(2130848242);
      if (HttpUtil.isValidUrl(paramView))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
        int i = this.z;
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = i;
        paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
        if (paramView.getStatus() == 2) {
          paramView.restartDownload();
        }
        paramViewHolder.a.setImageDrawable(paramView);
      }
      else
      {
        paramViewHolder.a.setImageDrawable((Drawable)localObject);
      }
      paramViewHolder.b.setText(paramBaseChatItemLayout.title);
      paramView = paramViewHolder.b;
      paramViewHolder.d.setText(paramBaseChatItemLayout.summary);
      paramViewHolder.e.setOnClickListener(this.A);
      paramViewHolder.e.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.e.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    else
    {
      paramViewHolder.e.setVisibility(8);
      paramViewHolder.g.setVisibility(8);
    }
    paramViewHolder.f.setOnTouchListener(new QQStoryCommentItemBuilder.OnCommentTouchListener(this, paramOnLongClickAndTouchListener));
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQStoryCommentItemBuilder.QQStoryCommentViewHolder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131439015: 
      super.a(paramInt, this.e, paramChatMessage);
      StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
      return;
    case 2131438943: 
      super.a(paramInt, paramContext, paramChatMessage);
      StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    case 2131433636: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.u);
      paramContext.putInt("forward_source_uin_type", this.f.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      ForwardBaseOption.a((Activity)this.e, paramChatMessage, 21);
      StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131431695: 
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    }
    if (localMessageForQQStoryComment.comment != null) {
      try
      {
        ((ClipboardManager)this.e.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryCommentItemBuilder", 2, paramContext.toString());
        }
      }
    }
    StoryReportor.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(y, a, x, w);
      return;
    }
    paramView.setPadding(x, a, y, w);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    if (paramBubbleInfo.l == 0)
    {
      paramViewHolder.b.setTextColor(Color.argb(178, 0, 0, 0));
      paramViewHolder.d.setTextColor(Color.argb(127, 0, 0, 0));
      paramViewHolder.c.setTextColor(-16777216);
      paramViewHolder.g.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramBubbleInfo.l);
    int j = Color.green(paramBubbleInfo.l);
    int k = Color.blue(paramBubbleInfo.l);
    paramViewHolder.b.setTextColor(Color.argb(178, i, j, k));
    paramViewHolder.d.setTextColor(Color.argb(127, i, j, k));
    paramViewHolder.c.setTextColor(paramBubbleInfo.l);
    paramViewHolder.g.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    Object localObject = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    if (this.B == null) {
      this.B = new AlphabeticFontHelper();
    }
    if (this.B.a(this.d, (ETTextView)((QQStoryCommentItemBuilder.QQStoryCommentViewHolder)localObject).c, this.f.r)) {
      return;
    }
    paramViewHolder = ((IFontManagerService)this.d.getRuntimeService(IFontManagerService.class, "")).getUserFont(paramChatMessage);
    localObject = (ETTextView)((QQStoryCommentItemBuilder.QQStoryCommentViewHolder)localObject).c;
    if (paramViewHolder != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramViewHolder.a, paramViewHolder.b, ((ETTextView)localObject).getTextSize(), paramViewHolder.c, paramViewHolder.d), paramChatMessage.uniseq);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131431492, this.e.getString(2131888241), 2130839057);
    localQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
    paramView = ((BaseBubbleBuilder.ViewHolder)AIOUtils.b(paramView)).q;
    a(localQQCustomMenu, this.e, 2131438943, paramView, new Bundle());
    a(localQQCustomMenu, this.e, 2131431695, paramView, new Bundle());
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
    AlphabeticFontHelper localAlphabeticFontHelper = this.B;
    if (localAlphabeticFontHelper != null) {
      localAlphabeticFontHelper.a();
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder
 * JD-Core Version:    0.7.0.1
 */