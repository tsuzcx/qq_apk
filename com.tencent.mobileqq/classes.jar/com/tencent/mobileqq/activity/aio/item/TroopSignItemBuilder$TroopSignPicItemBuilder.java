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
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.a).inflate(2130971593, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.b + BaseChatItemLayout.j + DisplayUtil.a(this.a, 10.0F), this.d + BaseChatItemLayout.g + BaseChatItemLayout.h));
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364477));
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363378));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363527));
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375167));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375168));
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375166);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375170));
      paramViewHolder.d = ((TextView)paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375171));
      paramViewHolder.jdField_c_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375169);
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
    for (;;)
    {
      boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (!bool2)
      {
        paramView.height = this.c;
        if (!bool1) {
          break label843;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = DisplayUtil.a(this.a, 10.0F);
        label395:
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
        paramView = new ColorDrawable(this.g);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        if (!TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl))
        {
          paramOnLongClickAndTouchListener = URLDrawable.URLDrawableOptions.obtain();
          paramOnLongClickAndTouchListener.mFailedDrawable = paramView;
          paramOnLongClickAndTouchListener.mLoadingDrawable = paramOnLongClickAndTouchListener.mFailedDrawable;
          paramOnLongClickAndTouchListener.mRequestWidth = this.b;
          if (bool2) {
            break label864;
          }
          paramOnLongClickAndTouchListener.mRequestHeight = this.c;
          label478:
          paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramOnLongClickAndTouchListener);
          if (paramView.getStatus() == 2) {
            paramView.restartDownload();
          }
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        }
        if (bool2) {
          break label876;
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadiusTop(14.0F);
        label523:
        if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
        {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a == 1) {
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth(), paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight());
          }
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
        }
        if (bool2) {
          break label904;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!bool1) {
          break label888;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.f;
        label627:
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
        label674:
        paramView = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
        if (!bool1) {
          break label916;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.f;
        label703:
        if (bool2) {
          break label932;
        }
        paramView.addRule(12, 0);
        paramView.addRule(15, 0);
        label722:
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgTitle)) {
          break label991;
        }
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localMessageForTroopSign.msgTitle);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
      }
      for (;;)
      {
        a(paramViewHolder, localMessageForTroopSign);
        if ((AppSetting.b) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramChatMessage.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(paramViewHolder, paramBaseChatItemLayout);
        return paramChatMessage;
        paramView.height = this.d;
        break;
        label843:
        paramView.leftMargin = DisplayUtil.a(this.a, 10.0F);
        paramView.rightMargin = 0;
        break label395;
        label864:
        paramOnLongClickAndTouchListener.mRequestHeight = this.d;
        break label478;
        label876:
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
        break label523;
        label888:
        paramView.leftMargin = this.f;
        paramView.rightMargin = 0;
        break label627;
        label904:
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label674;
        label916:
        paramView.leftMargin = this.f;
        paramView.rightMargin = 0;
        break label703;
        label932:
        if ((!TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) && (localMessageForTroopSign.msgCoverUrl.endsWith("e8e22512720843268d733a5f30f22d7f.png")))
        {
          paramView.addRule(12, 0);
          paramView.addRule(15, -1);
          break label722;
        }
        paramView.addRule(12, -1);
        paramView.addRule(15, 0);
        break label722;
        label991:
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
      }
      paramChatMessage = paramView;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopSignItemBuilder.TroopSignPicItemBuilder.SignPicItemHolder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */