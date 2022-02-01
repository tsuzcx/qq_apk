package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;

public class StarLeagueItemBuilder
  extends BaseBubbleBuilder
{
  View.OnClickListener a = new StarLeagueItemBuilder.1(this);
  
  public StarLeagueItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramViewHolder instanceof StarLeagueItemBuilder.Holder))
    {
      paramViewHolder = (StarLeagueItemBuilder.Holder)paramViewHolder;
    }
    else
    {
      paramViewHolder = (StarLeagueItemBuilder.Holder)a();
      paramViewHolder.j = paramBaseChatItemLayout;
      paramBaseChatItemLayout.setTag(paramViewHolder);
      paramView = null;
    }
    paramOnLongClickAndTouchListener = paramView;
    if (paramView == null)
    {
      paramOnLongClickAndTouchListener = LayoutInflater.from(localContext).inflate(2131626750, null);
      paramViewHolder.a = ((RoundCornerImageView)paramOnLongClickAndTouchListener.findViewById(2131446285));
      paramViewHolder.d = ((ImageView)paramOnLongClickAndTouchListener.findViewById(2131446291));
      paramViewHolder.c = ((TextView)paramOnLongClickAndTouchListener.findViewById(2131446292));
      paramViewHolder.b = ((TextView)paramOnLongClickAndTouchListener.findViewById(2131446293));
      paramViewHolder.e = ((ImageView)paramOnLongClickAndTouchListener.findViewById(2131449132));
      paramViewHolder.f = paramOnLongClickAndTouchListener.findViewById(2131432085);
      paramViewHolder.g = paramOnLongClickAndTouchListener.findViewById(2131431340);
      paramViewHolder.s = ((ImageView)paramOnLongClickAndTouchListener.findViewById(2131432056));
      paramViewHolder.g.getLayoutParams().width = BaseChatItemLayout.e;
    }
    paramBaseChatItemLayout.setHeadIconVisible(false);
    paramView = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.j);
    if ((paramView != null) && (paramView.checkViewNonNull())) {
      paramView.setViewVisibility(8);
    }
    paramView = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.i);
    if ((paramView != null) && (paramView.checkViewNonNull())) {
      paramView.setViewVisibility(8);
    }
    paramView = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.h);
    if ((paramView != null) && (paramView.checkViewNonNull())) {
      paramView.setViewVisibility(4);
    }
    if ((paramChatMessage instanceof MessageForStarLeague))
    {
      paramView = (MessageForStarLeague)paramChatMessage;
      paramViewHolder.b.setText(paramView.starName);
      paramViewHolder.c.setText(paramView.subTitle);
      if (paramView.levelStatus == 1)
      {
        paramViewHolder.g.setBackgroundResource(2130845002);
        paramViewHolder.d.setImageResource(2130844998);
        paramViewHolder.e.setVisibility(0);
        paramViewHolder.s.setVisibility(8);
        paramViewHolder.b.setTextColor(-1);
        paramViewHolder.c.setTextColor(-1);
      }
      else
      {
        paramViewHolder.g.setBackgroundResource(2130844999);
        paramViewHolder.d.setImageResource(2130844997);
        paramViewHolder.e.setVisibility(8);
        paramViewHolder.s.setVisibility(0);
        paramViewHolder.b.setTextColor(-16777216);
        paramViewHolder.c.setTextColor(Color.parseColor("#777777"));
      }
      if (!paramView.starAvatar.isEmpty()) {
        try
        {
          paramBaseChatItemLayout = URLDrawable.URLDrawableOptions.obtain();
          paramBaseChatItemLayout.mRequestWidth = DisplayUtil.a(localContext, 64.0F);
          paramBaseChatItemLayout.mRequestHeight = DisplayUtil.a(localContext, 64.0F);
          paramBaseChatItemLayout.mFailedDrawable = null;
          paramBaseChatItemLayout.mLoadingDrawable = null;
          paramBaseChatItemLayout = URLDrawable.getDrawable(paramView.starAvatar, paramBaseChatItemLayout);
          paramViewHolder.a.setImageDrawable(paramBaseChatItemLayout);
          paramViewHolder.a.setCorner(DisplayUtil.a(localContext, 32.0F));
        }
        catch (Throwable paramBaseChatItemLayout)
        {
          QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramBaseChatItemLayout);
        }
      }
      paramViewHolder.g.setContentDescription(paramView.brief);
    }
    paramViewHolder.g.setOnClickListener(this.a);
    paramViewHolder.q = paramChatMessage;
    return paramOnLongClickAndTouchListener;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new StarLeagueItemBuilder.Holder(this);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = (StarLeagueItemBuilder.Holder)paramViewHolder;
    if (paramChatMessage.h != null)
    {
      paramContext = paramChatMessage.h.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.h.setLayoutParams(paramContext);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.e, this.f.a);
    super.a(paramView, this.e, 2131428089, null, null);
    return paramView.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StarLeagueItemBuilder
 * JD-Core Version:    0.7.0.1
 */