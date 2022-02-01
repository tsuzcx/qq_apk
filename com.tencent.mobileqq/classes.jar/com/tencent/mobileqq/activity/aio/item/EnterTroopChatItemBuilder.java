package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForEnterTroop.User;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnterTroopChatItemBuilder
  extends AbstractChatItemBuilder
{
  public EnterTroopChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (EnterTroopChatItemBuilder.Holder)paramViewHolder;
    int j = 0;
    paramViewHolder = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramViewHolder = new LinearLayout(paramLinearLayout.getContext());
      paramViewHolder.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = AIOUtils.b(9.0F, paramLinearLayout.getContext().getResources());
      paramViewHolder.setLayoutParams(paramView);
      localObject1 = new LinearLayout(paramViewHolder.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramOnLongClickAndTouchListener.f = ((LinearLayout)localObject1);
      paramView = new LinearLayout(paramViewHolder.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(4.0F, paramLinearLayout.getContext().getResources());
      paramViewHolder.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramOnLongClickAndTouchListener.e = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramOnLongClickAndTouchListener.e, (ViewGroup.LayoutParams)localObject1);
      paramOnLongClickAndTouchListener.e.setTextColor(-8355712);
      paramOnLongClickAndTouchListener.e.setGravity(1);
      paramOnLongClickAndTouchListener.e.setSingleLine();
      paramOnLongClickAndTouchListener.e.setEllipsize(TextUtils.TruncateAt.END);
      paramOnLongClickAndTouchListener.d = new ArrayList();
    }
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.c.getString(2131894995);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (int i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        MessageForEnterTroop.User localUser = (MessageForEnterTroop.User)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0)
        {
          paramView = new StringBuilder();
          paramView.append(paramMessageRecord);
          paramView.append(",");
          paramView = paramView.toString();
        }
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(paramView);
        paramMessageRecord.append(localUser.b);
        paramMessageRecord = paramMessageRecord.toString();
      }
      paramOnLongClickAndTouchListener.e.setText(paramMessageRecord);
      int k = ((MessageForEnterTroop)localObject1).mList.size();
      i = k;
      if (k > 5) {
        i = 5;
      }
      k = paramOnLongClickAndTouchListener.d.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramOnLongClickAndTouchListener.f.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = AIOUtils.b(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = AIOUtils.b(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = AIOUtils.b(4.0F, paramLinearLayout.getContext().getResources());
          paramOnLongClickAndTouchListener.f.addView(paramMessageRecord, paramView);
          paramOnLongClickAndTouchListener.d.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramMessageRecord = paramOnLongClickAndTouchListener.f;
          paramView = paramOnLongClickAndTouchListener.d;
          k = j - 1;
          paramMessageRecord.removeView((View)paramView.get(k));
          paramOnLongClickAndTouchListener.d.remove(k);
          j -= 1;
        }
      }
      paramMessageRecord = paramOnLongClickAndTouchListener.d.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramOnLongClickAndTouchListener = (MessageForEnterTroop.User)paramView.next();
        paramLinearLayout.setImageDrawable(FaceDrawable.getFaceDrawable(this.a, 1, paramOnLongClickAndTouchListener.a));
      }
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new EnterTroopChatItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.EnterTroopChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */