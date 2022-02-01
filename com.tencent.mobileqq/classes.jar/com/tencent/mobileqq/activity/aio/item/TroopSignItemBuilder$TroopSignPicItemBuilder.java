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
      paramChatMessage = LayoutInflater.from(this.e).inflate(2131629316, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.a + BaseChatItemLayout.getBubblePaddingAlignError() + DisplayUtil.a(this.e, 10.0F), this.x + BaseChatItemLayout.k + BaseChatItemLayout.l));
      paramViewHolder.a = ((RelativeLayout)paramChatMessage);
      paramViewHolder.v = ((BubbleImageView)paramViewHolder.a.findViewById(2131431458));
      paramViewHolder.w = ((EllipsizingTextView)paramViewHolder.a.findViewById(2131447463));
      paramViewHolder.b = ((TextView)paramViewHolder.a.findViewById(2131446627));
      paramViewHolder.c = ((ImageView)paramViewHolder.a.findViewById(2131437945));
      paramViewHolder.d = ((TextView)paramViewHolder.a.findViewById(2131437947));
      paramViewHolder.e = paramViewHolder.a.findViewById(2131437946);
      paramViewHolder.f = ((TextView)paramViewHolder.a.findViewById(2131437949));
      paramViewHolder.g = ((TextView)paramViewHolder.a.findViewById(2131437944));
      paramViewHolder.s = paramViewHolder.a.findViewById(2131437948);
      paramViewHolder.v.b(false);
      paramViewHolder.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewHolder.v.c(false);
      paramViewHolder.v.setFocusable(false);
      paramViewHolder.v.setFocusableInTouchMode(false);
      paramViewHolder.v.setClickable(false);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
      paramView.setShape(0);
      paramView.setGradientType(0);
      paramViewHolder.v.setImageDrawable(paramView);
    }
    boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.v.getLayoutParams();
    if (!bool2) {
      paramView.height = this.w;
    } else {
      paramView.height = this.x;
    }
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = DisplayUtil.a(this.e, 10.0F);
    }
    else
    {
      paramView.leftMargin = DisplayUtil.a(this.e, 10.0F);
      paramView.rightMargin = 0;
    }
    paramViewHolder.v.setLayoutParams(paramView);
    paramView = new ColorDrawable(this.A);
    paramViewHolder.v.setImageDrawable(paramView);
    if (!TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) {
      try
      {
        paramOnLongClickAndTouchListener = URLDrawable.URLDrawableOptions.obtain();
        paramOnLongClickAndTouchListener.mFailedDrawable = paramView;
        paramOnLongClickAndTouchListener.mLoadingDrawable = paramOnLongClickAndTouchListener.mFailedDrawable;
        paramOnLongClickAndTouchListener.mRequestWidth = this.a;
        if (!bool2) {
          paramOnLongClickAndTouchListener.mRequestHeight = this.w;
        } else {
          paramOnLongClickAndTouchListener.mRequestHeight = this.x;
        }
        paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramOnLongClickAndTouchListener);
        if (paramView.getStatus() == 2) {
          paramView.restartDownload();
        }
        paramViewHolder.v.setImageDrawable(paramView);
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(paramView));
        }
      }
    }
    if (!bool2) {
      paramViewHolder.v.setRadiusTop(14.0F);
    } else {
      paramViewHolder.v.setRadius(14.0F);
    }
    if (paramViewHolder.v.v != bool1)
    {
      paramViewHolder.v.v = bool1;
      if (paramViewHolder.v.e == 1) {
        paramViewHolder.v.a(paramViewHolder.v.getWidth(), paramViewHolder.v.getHeight());
      }
      paramViewHolder.v.invalidate();
    }
    if (!bool2)
    {
      paramViewHolder.b.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)paramViewHolder.b.getLayoutParams();
      if (bool1)
      {
        paramView.leftMargin = 0;
        paramView.rightMargin = this.z;
      }
      else
      {
        paramView.leftMargin = this.z;
        paramView.rightMargin = 0;
      }
      paramViewHolder.b.setLayoutParams(paramView);
      paramViewHolder.b.setText(localMessageForTroopSign.msgContent);
      paramViewHolder.b.setMaxLines(1);
      paramViewHolder.b.setEllipsize(TextUtils.TruncateAt.END);
      paramViewHolder.b.setGravity(19);
    }
    else
    {
      paramViewHolder.b.setVisibility(8);
    }
    paramView = (RelativeLayout.LayoutParams)paramViewHolder.w.getLayoutParams();
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = this.z;
    }
    else
    {
      paramView.leftMargin = this.z;
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
    paramViewHolder.w.setLayoutParams(paramView);
    if (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))
    {
      paramViewHolder.w.setText(localMessageForTroopSign.msgTitle);
      paramViewHolder.w.setMaxLines(2);
      paramViewHolder.w.setEllipsize(TextUtils.TruncateAt.END);
    }
    else
    {
      paramViewHolder.w.setText("");
    }
    a(paramViewHolder, localMessageForTroopSign);
    if ((AppSetting.e) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */