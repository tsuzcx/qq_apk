package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.Constants;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.net.MalformedURLException;
import java.net.URL;

public class PLNewsItemBuilder
  extends AbstractChatItemBuilder
{
  int e = 0;
  int f = 0;
  int g = 0;
  RoundedColorDrawable h;
  
  public PLNewsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.e = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296632) * 2);
    this.f = ((int)paramContext.getResources().getDimension(2131298892));
    this.g = paramContext.getResources().getDimensionPixelSize(2131298891);
    paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 3);
    }
  }
  
  private int a(PLNewsItemBuilder.Holder paramHolder)
  {
    int i = paramHolder.f.getBackground().getIntrinsicWidth();
    return paramHolder.f.getBackground().getIntrinsicHeight() * this.e / i;
  }
  
  private View a(View paramView, PLNewsItemBuilder.Holder paramHolder)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624436, null);
      paramHolder.d = paramView.findViewById(2131431322);
      paramHolder.f = ((TextView)paramView.findViewById(2131447062));
      paramHolder.e = ((TextView)paramView.findViewById(2131447463));
      paramHolder.g = ((CornerImageView)paramView.findViewById(2131429397));
      paramHolder.g.setRadius(this.f);
      paramHolder.g.setPressMask(true);
      int i = a(paramHolder);
      paramHolder.f.getLayoutParams().width = this.e;
      paramHolder.f.getLayoutParams().height = i;
      localView = paramView;
      if (v)
      {
        paramHolder.r = new StringBuilder();
        localView = paramView;
      }
    }
    if (v)
    {
      localView.setContentDescription(null);
      paramHolder.r.replace(0, paramHolder.r.length(), "");
    }
    return localView;
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      int k = paramString.codePointAt(j);
      if ((k >= 32) && (k <= 126))
      {
        i += 1;
      }
      else if (k >= 65535)
      {
        i += 1;
        j += 1;
      }
      else
      {
        i += 2;
      }
      if (i <= paramInt) {
        localStringBuilder.appendCodePoint(k);
      }
      if (i >= paramInt) {
        break;
      }
      j += 1;
    }
    if (localStringBuilder.length() < paramString.length()) {
      localStringBuilder.append("...");
    }
    return localStringBuilder.toString();
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramViewHolder = (PLNewsItemBuilder.Holder)paramViewHolder;
    paramView = a(paramView, paramViewHolder);
    paramViewHolder.h = paramLinearLayout.uniseq;
    paramViewHolder.i = paramLinearLayout.frienduin;
    paramOnLongClickAndTouchListener = a(this.d.e, 6);
    paramMessageRecord = Constants.a;
    int k = 1;
    String str = String.format(paramMessageRecord, new Object[] { paramOnLongClickAndTouchListener });
    if (!paramViewHolder.e.getText().equals(str)) {
      paramViewHolder.e.setText(str);
    }
    if (!paramViewHolder.f.getText().equals(paramLinearLayout.text)) {
      paramViewHolder.f.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramViewHolder.g.getTag(2131440717);
    Object localObject = (Integer)paramViewHolder.g.getTag(2131440716);
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((Integer)localObject).intValue();
    }
    int i = k;
    if (!TextUtils.isEmpty(paramLinearLayout.cover))
    {
      i = k;
      if (Utils.a(paramLinearLayout.cover, paramMessageRecord)) {
        i = 0;
      }
    }
    k = i;
    if (TextUtils.isEmpty(paramLinearLayout.cover))
    {
      k = i;
      if (j == paramLinearLayout.bgColor) {
        k = 0;
      }
    }
    if (k != 0)
    {
      i = paramLinearLayout.bgColor;
      j = this.f;
      localObject = new RoundedColorDrawable(i, j * 3, j * 3, j);
      i = this.f;
      RoundedColorDrawable localRoundedColorDrawable = new RoundedColorDrawable(0, i * 3, i * 3, i);
      if (!TextUtils.isEmpty(paramLinearLayout.cover))
      {
        try
        {
          paramMessageRecord = new URL(paramLinearLayout.cover);
        }
        catch (MalformedURLException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
          paramMessageRecord = null;
        }
        if (paramMessageRecord != null)
        {
          paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramViewHolder), a(paramViewHolder), localRoundedColorDrawable, (Drawable)localObject);
          paramMessageRecord.setDecodeHandler(URLDrawableDecodeHandler.s);
          paramViewHolder.g.setImageDrawable(paramMessageRecord);
          paramViewHolder.g.setTag(2131440717, paramLinearLayout.cover);
          break label393;
        }
      }
      paramMessageRecord = null;
      label393:
      if (paramMessageRecord == null)
      {
        paramViewHolder.g.setImageDrawable((Drawable)localObject);
        paramViewHolder.g.setTag(2131440716, Integer.valueOf(paramLinearLayout.bgColor));
      }
    }
    if (!TextUtils.isEmpty(paramLinearLayout.cover))
    {
      if (this.h == null)
      {
        i = Color.parseColor("#66000000");
        j = this.f;
        this.h = new RoundedColorDrawable(i, j * 3, j * 3, j);
      }
      paramViewHolder.d.setBackgroundDrawable(this.h);
    }
    else
    {
      paramViewHolder.d.setBackgroundDrawable(null);
    }
    if (v)
    {
      paramMessageRecord = paramViewHolder.r;
      paramMessageRecord.append(str);
      paramMessageRecord.append(paramLinearLayout.text);
      paramView.setContentDescription(paramViewHolder.r.toString());
    }
    paramViewHolder.d.setTag(paramViewHolder);
    paramViewHolder.d.setOnClickListener(new PLNewsItemBuilder.1(this, paramLinearLayout, paramOnLongClickAndTouchListener));
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new PLNewsItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PLNewsItemBuilder
 * JD-Core Version:    0.7.0.1
 */