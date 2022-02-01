package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.util.SquareRoundImageUtils.SquareRoundColorDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class AIOStoryVideoBuilder
  extends AbstractChatItemBuilder
{
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  
  public AIOStoryVideoBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.e = paramContext.getResources().getDimensionPixelSize(2131298904);
    int j = paramContext.getResources().getDimensionPixelSize(2131298905);
    this.i = j;
    this.h = j;
    this.g = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296632) * 2);
    this.f = paramContext.getResources().getDimensionPixelSize(2131298903);
  }
  
  private View a(View paramView, AIOStoryVideoBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.c).inflate(2131624415, null);
      paramHolder.d = localView.findViewById(2131431322);
      paramHolder.f = ((ImageView)localView.findViewById(2131428102));
      paramHolder.h = ((TextView)localView.findViewById(2131428103));
      paramHolder.g = ((CornerImageView)localView.findViewById(2131428100));
      paramHolder.e = ((ImageView)localView.findViewById(2131428101));
      paramHolder.g.setRadius(this.e);
      paramView = new SquareRoundImageUtils.SquareRoundColorDrawable(-1, this.h, this.i);
      paramHolder.f.setImageDrawable(paramView);
    }
    return localView;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForAIOStoryVideo)paramMessageRecord;
    paramOnLongClickAndTouchListener = (AIOStoryVideoBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramOnLongClickAndTouchListener);
    paramMessageRecord = (String)paramOnLongClickAndTouchListener.g.getTag(2131442205);
    int j;
    if ((!TextUtils.isEmpty(paramLinearLayout.cover)) && (Utils.a(paramLinearLayout.cover, paramMessageRecord))) {
      j = 0;
    } else {
      j = 1;
    }
    if (j != 0) {
      paramViewHolder = null;
    }
    try
    {
      paramMessageRecord = new URL(paramLinearLayout.cover);
    }
    catch (Exception paramMessageRecord)
    {
      label89:
      break label89;
    }
    paramMessageRecord = paramViewHolder;
    if (QLog.isColorLevel())
    {
      QLog.e("ChatItemBuilder", 2, " AIOStoryVideoBuilder:  url has problem");
      paramMessageRecord = paramViewHolder;
    }
    if (paramMessageRecord != null)
    {
      QQStoryCoverImageViewHelper.a(paramOnLongClickAndTouchListener.e, paramLinearLayout.cover);
      paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, this.g, this.f);
      paramMessageRecord.setDecodeHandler(URLDrawableDecodeHandler.s);
      paramOnLongClickAndTouchListener.g.setImageDrawable(paramMessageRecord);
      paramOnLongClickAndTouchListener.g.setTag(2131442205, paramLinearLayout.cover);
    }
    if (v) {
      paramView.setContentDescription(paramLinearLayout.text);
    }
    paramOnLongClickAndTouchListener.d.setOnClickListener(new AIOStoryVideoBuilder.1(this, paramLinearLayout));
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new AIOStoryVideoBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AIOStoryVideoBuilder
 * JD-Core Version:    0.7.0.1
 */