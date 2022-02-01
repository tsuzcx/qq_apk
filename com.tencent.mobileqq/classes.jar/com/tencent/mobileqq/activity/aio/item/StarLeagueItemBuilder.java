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
  View.OnClickListener a;
  
  public StarLeagueItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new StarLeagueItemBuilder.1(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
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
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
      paramBaseChatItemLayout.setTag(paramViewHolder);
      paramView = null;
    }
    paramOnLongClickAndTouchListener = paramView;
    if (paramView == null)
    {
      paramOnLongClickAndTouchListener = LayoutInflater.from(localContext).inflate(2131560705, null);
      paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramOnLongClickAndTouchListener.findViewById(2131377817));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramOnLongClickAndTouchListener.findViewById(2131377822));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramOnLongClickAndTouchListener.findViewById(2131377823));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramOnLongClickAndTouchListener.findViewById(2131377824));
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramOnLongClickAndTouchListener.findViewById(2131380214));
      paramViewHolder.jdField_c_of_type_AndroidViewView = paramOnLongClickAndTouchListener.findViewById(2131365827);
      paramViewHolder.d = paramOnLongClickAndTouchListener.findViewById(2131365179);
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramOnLongClickAndTouchListener.findViewById(2131365799));
      paramViewHolder.d.getLayoutParams().width = BaseChatItemLayout.e;
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
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.starName);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.subTitle);
      if (paramView.levelStatus == 1)
      {
        paramViewHolder.d.setBackgroundResource(2130844047);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844043);
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      else
      {
        paramViewHolder.d.setBackgroundResource(2130844044);
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844042);
        paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
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
          paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramBaseChatItemLayout);
          paramViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(DisplayUtil.a(localContext, 32.0F));
        }
        catch (Throwable paramBaseChatItemLayout)
        {
          QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramBaseChatItemLayout);
        }
      }
      paramViewHolder.d.setContentDescription(paramView.brief);
    }
    paramViewHolder.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    return paramOnLongClickAndTouchListener;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new StarLeagueItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    paramChatMessage = (StarLeagueItemBuilder.Holder)paramViewHolder;
    if (paramChatMessage.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramChatMessage.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.jdField_a_of_type_AndroidViewView.setLayoutParams(paramContext);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StarLeagueItemBuilder
 * JD-Core Version:    0.7.0.1
 */