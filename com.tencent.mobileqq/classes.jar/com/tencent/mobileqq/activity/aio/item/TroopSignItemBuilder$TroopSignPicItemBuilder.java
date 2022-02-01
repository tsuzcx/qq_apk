package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class TroopSignItemBuilder$TroopSignPicItemBuilder
  extends TroopSignItemBuilder
{
  public TroopSignItemBuilder$TroopSignPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (TroopSignItemBuilder.TroopSignPicItemBuilder.SignPicItemHolder)paramViewHolder;
    boolean bool1 = paramChatMessage.isSend();
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562865, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int + BaseChatItemLayout.k + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), this.e + BaseChatItemLayout.h + BaseChatItemLayout.i));
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365284));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378784));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378120));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370668));
      paramViewHolder.b = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370670));
      paramViewHolder.jdField_c_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370669);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370672));
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370667));
      paramViewHolder.jdField_d_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370671);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
      paramView.setShape(0);
      paramView.setGradientType(0);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
    }
    boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
    if (!bool2) {
      paramView.height = this.d;
    } else {
      paramView.height = this.e;
    }
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    }
    else
    {
      paramView.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.rightMargin = 0;
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
    paramView = new ColorDrawable(this.h);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
    if (!TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) {
      try
      {
        paramOnLongClickAndTouchListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnLongClickAndTouchListener.mFailedDrawable = paramView;
        paramOnLongClickAndTouchListener.mLoadingDrawable = paramOnLongClickAndTouchListener.mFailedDrawable;
        paramOnLongClickAndTouchListener.mRequestWidth = this.jdField_a_of_type_Int;
        if (!bool2) {
          paramOnLongClickAndTouchListener.mRequestHeight = this.d;
        } else {
          paramOnLongClickAndTouchListener.mRequestHeight = this.e;
        }
        paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramOnLongClickAndTouchListener);
        if (paramView.getStatus() == 2) {
          paramView.restartDownload();
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(paramView));
        }
      }
    }
    if (!bool2) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadiusTop(14.0F);
    } else {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
    }
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.jdField_a_of_type_Int == 1) {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight());
      }
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
    }
    if (!bool2)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (bool1)
      {
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
      }
      else
      {
        paramView.leftMargin = this.g;
        paramView.rightMargin = 0;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
    }
    else
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = this.g;
    }
    else
    {
      paramView.leftMargin = this.g;
      paramView.rightMargin = 0;
    }
    if (!bool2)
    {
      paramView.addRule(12, 0);
      paramView.addRule(15, 0);
    }
    else if ((!TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) && (localMessageForTroopSign.msgCoverUrl.endsWith("e8e22512720843268d733a5f30f22d7f.png")))
    {
      paramView.addRule(12, 0);
      paramView.addRule(15, -1);
    }
    else
    {
      paramView.addRule(12, -1);
      paramView.addRule(15, 0);
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramView);
    if (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localMessageForTroopSign.msgTitle);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
    else
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
    }
    a(paramViewHolder, localMessageForTroopSign);
    if ((AppSetting.d) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle)))
    {
      paramView = new StringBuilder();
      paramView.append("");
      paramView.append(localMessageForTroopSign.msgTitle);
      paramChatMessage.setContentDescription(paramView.toString());
    }
    a(paramViewHolder, paramBaseChatItemLayout);
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopSignItemBuilder.TroopSignPicItemBuilder.SignPicItemHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */