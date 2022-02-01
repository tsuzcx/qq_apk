package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.statistics.ReportController;

public class FoldMsgGrayTipsItemBuilder
  extends GrayTipsItemBuilder
{
  public FoldMsgGrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  @TargetApi(16)
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FoldMsgGrayTipsItemBuilder.Holder)paramViewHolder;
    paramView = LayoutInflater.from(this.c).inflate(2131624480, null);
    paramViewHolder.d = ((TextView)paramView.findViewById(2131434371));
    paramViewHolder.e = ((ImageView)paramView.findViewById(2131444539));
    paramViewHolder.f = ((ImageView)paramView.findViewById(2131439614));
    paramViewHolder.g = ((LinearLayout)paramView.findViewById(2131439726));
    paramViewHolder.d.setMovementMethod(LinkMovementMethod.getInstance());
    if ((paramMessageRecord instanceof MessageForFoldMsgGrayTips))
    {
      paramMessageRecord = (MessageForFoldMsgGrayTips)paramMessageRecord;
      paramViewHolder.d.setText(paramMessageRecord.getShowMsgContent(this.a, this.c));
      paramViewHolder.d.setLineSpacing(0.0F, 1.0F);
      paramLinearLayout = paramViewHolder.f;
      int i;
      if (paramMessageRecord.isOpen) {
        i = 8;
      } else {
        i = 0;
      }
      paramLinearLayout.setVisibility(i);
      if (paramMessageRecord.isOpen)
      {
        paramMessageRecord = paramViewHolder.d.getLayoutParams();
        if ((paramMessageRecord instanceof ViewGroup.MarginLayoutParams))
        {
          paramMessageRecord = (ViewGroup.MarginLayoutParams)paramMessageRecord;
          if (paramMessageRecord.rightMargin != AIOUtils.b(10.0F, this.c.getResources())) {
            paramMessageRecord.rightMargin = AIOUtils.b(10.0F, this.c.getResources());
          }
        }
      }
      paramMessageRecord = ((IPasswdRedBagService)this.a.getRuntimeService(IPasswdRedBagService.class)).getIconFromCacheByType("StatusIcon_HongBaoIcon", 2130849196);
      if (Build.VERSION.SDK_INT < 16) {
        paramViewHolder.e.setBackgroundDrawable(new BitmapDrawable(this.c.getResources(), paramMessageRecord));
      } else {
        paramViewHolder.e.setBackground(new BitmapDrawable(this.c.getResources(), paramMessageRecord));
      }
      paramViewHolder.g.setOnClickListener(new FoldMsgGrayTipsItemBuilder.1(this));
      ReportController.b(this.a, "CliOper", "", "", "0X80064BE", "0X80064BE", 0, 0, "", "", "", "");
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new FoldMsgGrayTipsItemBuilder.Holder(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FoldMsgGrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */