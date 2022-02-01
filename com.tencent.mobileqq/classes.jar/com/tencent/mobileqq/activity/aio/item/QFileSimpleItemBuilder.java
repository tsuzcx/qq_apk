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
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692393), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(QFileSimpleItemBuilder.FileHolder paramFileHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c() == 3)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.e();
      paramFileHolder.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      paramFileHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramFileHolder.e >= 0) && (i - paramFileHolder.e > 1))
      {
        paramFileHolder.e = i;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692400));
        ((StringBuilder)localObject).append(i);
        QQAppInterface.speak(((StringBuilder)localObject).toString());
      }
      Object localObject = paramFileHolder.jdField_a_of_type_AndroidWidgetProgressBar;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131692400));
      localStringBuilder.append(i);
      ((ProgressBar)localObject).setContentDescription(localStringBuilder.toString());
      i = AIOUtils.b(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a())
      {
        paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
        return;
      }
      paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
      return;
    }
    paramFileHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    int i = AIOUtils.b(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a())
    {
      paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
      return;
    }
    paramFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
  }
  
  private void a(QFileSimpleItemBuilder.FileHolder paramFileHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
    FileManagerUtil.a(paramFileHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    paramFileHolder.b.setText(paramBaseChatItemLayout);
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a();
    paramFileHolder.c.setText(FileUtil.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    a(paramFileHolder);
    b(paramFileHolder);
  }
  
  private void b(QFileSimpleItemBuilder.FileHolder paramFileHolder)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c();
    Object localObject = "";
    if (i == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692352));
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (i == 6)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692351));
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (i == 2)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.d();
      if (i == 3)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692356));
        localObject = ((StringBuilder)localObject).toString();
      }
      else if (i == 6)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692355));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else if (i == 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692354));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      long l;
      if (i == 2)
      {
        l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
        if (l == -1L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" / ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692352));
          localObject = ((StringBuilder)localObject).toString();
        }
        else if (l != 0L)
        {
          localObject = a(l);
        }
      }
      else
      {
        int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.d();
        String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.c();
        if ((QFileAssistantUtils.a()) && (str.equals(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698289)))) {
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
              localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692335);
            } else {
              localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692357);
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
                localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692350);
              } else {
                localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692349);
              }
              localStringBuilder.append((String)localObject);
              localObject = localStringBuilder.toString();
            }
            else if (j == 6)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" / ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692355));
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b();
              if (l == -1L)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(" / ");
                ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692351));
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
      paramFileHolder.d.setVisibility(0);
      paramFileHolder.d.setText((CharSequence)localObject);
      return;
    }
    paramFileHolder.d.setVisibility(8);
  }
  
  protected View a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    QFileSimpleItemBuilder.FileHolder localFileHolder = (QFileSimpleItemBuilder.FileHolder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      int i = AIOUtils.b(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131364521);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramViewHolder.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296380), ((Resources)localObject1).getDimensionPixelSize(2131296382), ((Resources)localObject1).getDimensionPixelSize(2131296379), ((Resources)localObject1).getDimensionPixelSize(2131296381));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131299072);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131368343);
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localFileHolder.jdField_a_of_type_AndroidViewView = paramView;
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(AIOUtils.b(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364521);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131366806);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localFileHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      k = AIOUtils.b(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131364488);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject2).setId(2131364490);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364488);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.b = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364487);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364490);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.c = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364492);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364487);
      localLayoutParams.addRule(8, 2131364487);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localFileHolder.d = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131364491);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844399));
      localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localFileHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      localFileHolder.jdField_a_of_type_AndroidViewView = paramViewHolder;
    }
    paramViewHolder.setOnClickListener(this);
    super.a(paramViewHolder, paramOnLongClickAndTouchListener);
    localFileHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(localFileHolder, paramBaseChatItemLayout);
    return paramViewHolder;
  }
  
  protected List<Integer> a(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(paramInt);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (paramChatMessage.isSend())
    {
      paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850341);
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850165);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected BaseBubbleBuilder.ViewHolder b()
  {
    return new QFileSimpleItemBuilder.FileHolder(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692397);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692394);
  }
  
  protected List<Integer> b(QQCustomMenu paramQQCustomMenu, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.b(1);
  }
  
  protected void c(View paramView)
  {
    if (paramView.getId() == 2131364521) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerBubbleQFileBubbleModel.a(1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QFileSimpleItemBuilder
 * JD-Core Version:    0.7.0.1
 */