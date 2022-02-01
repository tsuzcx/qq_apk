package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.util.VersionUtils;
import java.util.List;

public class QFileSimpleItemBuilder
  extends QFileItemBuilder
{
  public QFileSimpleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private String a(long paramLong)
  {
    double d1 = paramLong;
    Double.isNaN(d1);
    double d2 = 86400L;
    Double.isNaN(d2);
    int i = (int)Math.ceil(d1 * 1.0D / d2);
    return String.format(this.e.getString(2131889381), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(QFileSimpleItemBuilder.FileHolder paramFileHolder)
  {
    if (this.a.i() == 3)
    {
      i = this.a.k();
      paramFileHolder.d.setProgress(i);
      paramFileHolder.d.setVisibility(0);
      if ((paramFileHolder.g >= 0) && (i - paramFileHolder.g > 1))
      {
        paramFileHolder.g = i;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e.getString(2131889388));
        ((StringBuilder)localObject).append(i);
        QQAppInterface.speak(((StringBuilder)localObject).toString());
      }
      Object localObject = paramFileHolder.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getString(2131889388));
      localStringBuilder.append(i);
      ((ProgressBar)localObject).setContentDescription(localStringBuilder.toString());
      i = AIOUtils.b(14.0F, this.e.getResources());
      j = AIOUtils.b(18.0F, this.e.getResources());
      if (this.a.a())
      {
        paramFileHolder.e.setPadding(i, i, j, 0);
        return;
      }
      paramFileHolder.e.setPadding(j, i, i, 0);
      return;
    }
    paramFileHolder.d.setVisibility(8);
    int i = AIOUtils.b(14.0F, this.e.getResources());
    int j = AIOUtils.b(18.0F, this.e.getResources());
    if (this.a.a())
    {
      paramFileHolder.e.setPadding(i, i, j, i);
      return;
    }
    paramFileHolder.e.setPadding(j, i, i, i);
  }
  
  private void a(QFileSimpleItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.a.f();
    FileManagerUtil.a(paramFileHolder.f, paramBaseChatItemLayout);
    paramFileHolder.a.setText(paramBaseChatItemLayout);
    long l = this.a.g();
    paramFileHolder.b.setText(FileUtil.a(l, this.e.getResources().getDisplayMetrics().densityDpi));
    a(paramFileHolder);
    b(paramFileHolder);
  }
  
  private void b(QFileSimpleItemBuilder.FileHolder paramFileHolder)
  {
    int i = this.a.i();
    Object localObject = "";
    if (i == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.e.getString(2131889340));
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (i == 6)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.e.getString(2131889339));
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (i == 2)
    {
      i = this.a.j();
      if (i == 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(this.e.getString(2131889344));
        localObject = ((StringBuilder)localObject).toString();
      }
      else if (i == 6)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(this.e.getString(2131889343));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else if (i == 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.e.getString(2131889342));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      long l;
      if (i == 2)
      {
        l = this.a.p();
        if (l == -1L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" / ");
          ((StringBuilder)localObject).append(this.e.getString(2131889340));
          localObject = ((StringBuilder)localObject).toString();
        }
        else if (l != 0L)
        {
          localObject = a(l);
        }
      }
      else
      {
        int j = this.a.j();
        String str = this.a.r();
        if ((QFileAssistantUtils.b()) && (str.equals(this.e.getResources().getString(2131896190)))) {
          i = 1;
        } else {
          i = 0;
        }
        if (j != 1)
        {
          StringBuilder localStringBuilder;
          if (j == 2)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" / ");
            localStringBuilder.append(str);
            if (i != 0) {
              localObject = this.e.getString(2131889323);
            } else {
              localObject = this.e.getString(2131889345);
            }
            localStringBuilder.append((String)localObject);
            localObject = localStringBuilder.toString();
          }
          else if (j != 4)
          {
            if (j == 5)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" / ");
              localStringBuilder.append(str);
              if (i != 0) {
                localObject = this.e.getString(2131889338);
              } else {
                localObject = this.e.getString(2131889337);
              }
              localStringBuilder.append((String)localObject);
              localObject = localStringBuilder.toString();
            }
            else if (j == 6)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" / ");
              ((StringBuilder)localObject).append(this.e.getString(2131889343));
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              l = this.a.p();
              if (l == -1L)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(" / ");
                ((StringBuilder)localObject).append(this.e.getString(2131889339));
                localObject = ((StringBuilder)localObject).toString();
              }
              else if (l != 0L)
              {
                localObject = a(l);
              }
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramFileHolder.c.setVisibility(0);
      paramFileHolder.c.setText((CharSequence)localObject);
      return;
    }
    paramFileHolder.c.setVisibility(8);
  }
  
  protected View a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QFileSimpleItemBuilder.FileHolder localFileHolder = (QFileSimpleItemBuilder.FileHolder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      int j = AIOUtils.b(14.0F, this.e.getResources());
      int k = AIOUtils.b(6.0F, this.e.getResources());
      paramViewHolder = new RelativeLayout(this.e);
      paramViewHolder.setId(2131430578);
      Object localObject1 = this.e.getResources();
      paramViewHolder.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296611), ((Resources)localObject1).getDimensionPixelSize(2131296614), ((Resources)localObject1).getDimensionPixelSize(2131296609), ((Resources)localObject1).getDimensionPixelSize(2131296613));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z, -2);
      int i = ((Resources)localObject1).getDimensionPixelSize(2131299800);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, i, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131435219);
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localFileHolder.h = paramView;
      paramView = new LinearLayout(this.e);
      paramView.setMinimumHeight(AIOUtils.b(76.0F, this.e.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131430578);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.e);
      ((RelativeLayout)localObject1).setId(2131433128);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(j, j, j, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localFileHolder.e = ((RelativeLayout)localObject1);
      i = AIOUtils.b(48.0F, this.e.getResources());
      localObject2 = new AsyncImageView(this.e);
      ((AsyncImageView)localObject2).setWidth(i);
      ((AsyncImageView)localObject2).setHeight(i);
      ((AsyncImageView)localObject2).setId(2131430545);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(j, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.f = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.e, null);
      ((TextView)localObject2).setId(2131430547);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      if ((QQTheme.isNowSimpleUI()) && (QQTheme.isNowThemeIsNight())) {
        i = -3355444;
      } else {
        i = Color.parseColor("#03081a");
      }
      ((TextView)localObject2).setTextColor(i);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131430545);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.a = ((TextView)localObject2);
      localObject2 = new TextView(this.e);
      ((TextView)localObject2).setId(2131430544);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131430547);
      localLayoutParams.setMargins(0, k, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.b = ((TextView)localObject2);
      localObject2 = new TextView(this.e);
      ((TextView)localObject2).setId(2131430549);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131430544);
      localLayoutParams.addRule(8, 2131430544);
      localLayoutParams.setMargins(0, k, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.c = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.e, null, 16842872);
      ((ProgressBar)localObject1).setId(2131430548);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.e.getResources().getDrawable(2130845716));
      localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.b(2.0F, this.e.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(j, k, j, k);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localFileHolder.d = ((ProgressBar)localObject1);
      localFileHolder.h = paramViewHolder;
    }
    paramViewHolder.setOnClickListener(this);
    super.a(paramViewHolder, paramOnLongClickAndTouchListener);
    localFileHolder.j.setMiniAioShieldItemTouchListener(this);
    a(localFileHolder, paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.a.b(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.a.a(paramInt);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (paramChatMessage.isSend())
    {
      paramViewHolder.h.setBackgroundResource(2130852132);
      return;
    }
    paramViewHolder.h.setBackgroundResource(2130851950);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return this.e.getString(2131889385);
    }
    return this.e.getString(2131889382);
  }
  
  protected List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.a.c(1);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131430578) {
      this.a.a(1, paramView);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder h()
  {
    return new QFileSimpleItemBuilder.FileHolder(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileSimpleItemBuilder
 * JD-Core Version:    0.7.0.1
 */