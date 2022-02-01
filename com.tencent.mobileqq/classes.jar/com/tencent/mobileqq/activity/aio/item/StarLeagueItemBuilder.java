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
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
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
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramViewHolder instanceof StarLeagueItemBuilder.Holder))
    {
      paramOnLongClickAndTouchListener = (StarLeagueItemBuilder.Holder)paramViewHolder;
      paramViewHolder = paramView;
      paramView = paramOnLongClickAndTouchListener;
      if (paramViewHolder != null) {
        break label560;
      }
      paramViewHolder = LayoutInflater.from(localContext).inflate(2131560832, null);
      paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramViewHolder.findViewById(2131378403));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131378408));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131378409));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131378410));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131380948));
      paramView.jdField_c_of_type_AndroidViewView = paramViewHolder.findViewById(2131365991);
      paramView.d = paramViewHolder.findViewById(2131365304);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.findViewById(2131365962));
      paramView.d.getLayoutParams().width = BaseChatItemLayout.e;
    }
    label560:
    for (;;)
    {
      for (;;)
      {
        paramBaseChatItemLayout.setHeadIconVisible(false);
        paramOnLongClickAndTouchListener = paramBaseChatItemLayout.a(NickNameLayoutProcessor.j);
        if ((paramOnLongClickAndTouchListener != null) && (paramOnLongClickAndTouchListener.checkViewNonNull())) {
          paramOnLongClickAndTouchListener.setViewVisibility(8);
        }
        paramOnLongClickAndTouchListener = paramBaseChatItemLayout.a(NickNameLayoutProcessor.i);
        if ((paramOnLongClickAndTouchListener != null) && (paramOnLongClickAndTouchListener.checkViewNonNull())) {
          paramOnLongClickAndTouchListener.setViewVisibility(8);
        }
        paramBaseChatItemLayout = paramBaseChatItemLayout.a(NickNameLayoutProcessor.h);
        if ((paramBaseChatItemLayout != null) && (paramBaseChatItemLayout.checkViewNonNull())) {
          paramBaseChatItemLayout.setViewVisibility(4);
        }
        if ((paramChatMessage instanceof MessageForStarLeague))
        {
          paramBaseChatItemLayout = (MessageForStarLeague)paramChatMessage;
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.starName);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.subTitle);
          if (paramBaseChatItemLayout.levelStatus != 1) {
            break label486;
          }
          paramView.d.setBackgroundResource(2130844144);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844140);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          if (paramBaseChatItemLayout.starAvatar.isEmpty()) {}
        }
        try
        {
          paramOnLongClickAndTouchListener = URLDrawable.URLDrawableOptions.obtain();
          paramOnLongClickAndTouchListener.mRequestWidth = DisplayUtil.a(localContext, 64.0F);
          paramOnLongClickAndTouchListener.mRequestHeight = DisplayUtil.a(localContext, 64.0F);
          paramOnLongClickAndTouchListener.mFailedDrawable = null;
          paramOnLongClickAndTouchListener.mLoadingDrawable = null;
          paramOnLongClickAndTouchListener = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramOnLongClickAndTouchListener);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramOnLongClickAndTouchListener);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(DisplayUtil.a(localContext, 32.0F));
          paramView.d.setContentDescription(paramBaseChatItemLayout.brief);
          paramView.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          return paramViewHolder;
          paramView = (StarLeagueItemBuilder.Holder)a();
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
          paramBaseChatItemLayout.setTag(paramView);
          paramViewHolder = null;
          break;
          label486:
          paramView.d.setBackgroundResource(2130844141);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844139);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        }
        catch (Throwable paramOnLongClickAndTouchListener)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramOnLongClickAndTouchListener);
          }
        }
      }
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new StarLeagueItemBuilder.Holder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
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
    super.a(paramView, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StarLeagueItemBuilder
 * JD-Core Version:    0.7.0.1
 */