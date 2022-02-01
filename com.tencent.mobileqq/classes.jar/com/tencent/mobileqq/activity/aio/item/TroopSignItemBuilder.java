package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class TroopSignItemBuilder
  extends BaseBubbleBuilder
{
  protected int a;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h = 12303291;
  protected int i = 0;
  
  public TroopSignItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Int = DisplayUtil.a(paramContext, 151.5F);
    this.d = DisplayUtil.a(paramContext, 125.5F);
    this.e = DisplayUtil.a(paramContext, 152.0F);
    this.f = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
    this.g = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopSign)paramChatMessage).getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      if (paramInt != 2131376417)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    int j = this.f / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (paramInt == 7)
    {
      localLayoutParams.topMargin = this.f;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.addRule(10, -1);
    }
    else
    {
      localLayoutParams.topMargin = j;
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, 0);
      localLayoutParams.addRule(10, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = (j + this.g);
      } else {
        localLayoutParams.rightMargin = j;
      }
    }
    paramView.setLayoutParams(localLayoutParams);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, 0, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(TroopSignItemBuilder.SignItemHolder paramSignItemHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramSignItemHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Resources localResources;
    Object localObject;
    TextView localTextView;
    boolean bool;
    Drawable localDrawable;
    ColorDrawable localColorDrawable;
    if (paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = new FrameLayout.LayoutParams(-2, -2);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      bool = true;
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setBackgroundResource(2130842702);
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      paramSignItemHolder.e = localTextView;
      paramSignItemHolder.e.setText(localMessageForTroopSign.srcName);
      if (!TextUtils.isEmpty(localMessageForTroopSign.srcIconUrl))
      {
        localObject = localMessageForTroopSign.srcIconUrl;
        localDrawable = localResources.getDrawable(2130850833);
        localDrawable.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
        localColorDrawable = new ColorDrawable(15790320);
        localColorDrawable.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      }
    }
    for (;;)
    {
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, localDrawable, localColorDrawable);
        if (URLDrawableHelper.isMobileNetAndAutodownDisabled(this.jdField_a_of_type_AndroidContentContext)) {
          break label483;
        }
        ((URLDrawable)localObject).setAutoDownload(bool);
      }
      catch (Exception localException)
      {
        localObject = localColorDrawable;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setSourceView exception");
          ((StringBuilder)localObject).append(localException.toString());
          QLog.e("TroopSignItemBuilder", 2, ((StringBuilder)localObject).toString());
          localObject = localColorDrawable;
        }
      }
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      localTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, localResources));
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      break label365;
      localTextView.setCompoundDrawables(null, null, null, null);
      label365:
      localTextView.setPadding(AIOUtils.b(5.0F, localResources), 0, AIOUtils.b(5.0F, localResources), 0);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364521);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364521);
      paramBaseChatItemLayout.addView(paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramBaseChatItemLayout = (FrameLayout.LayoutParams)paramSignItemHolder.e.getLayoutParams();
      if (localMessageForTroopSign.isSend()) {
        paramBaseChatItemLayout.leftMargin = BaseChatItemLayout.k;
      } else {
        paramBaseChatItemLayout.leftMargin = this.g;
      }
      paramSignItemHolder.e.setLayoutParams(paramBaseChatItemLayout);
      return;
      label483:
      bool = false;
    }
  }
  
  public void a(TroopSignItemBuilder.SignItemHolder paramSignItemHolder, MessageForTroopSign paramMessageForTroopSign)
  {
    boolean bool = paramMessageForTroopSign.isSend();
    if ((paramMessageForTroopSign.markType != 1) && (paramMessageForTroopSign.markType != 2))
    {
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    else if (!TextUtils.isEmpty(paramMessageForTroopSign.markIconUrl))
    {
      try
      {
        Object localObject = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.i;
        localURLDrawableOptions.mRequestHeight = this.i;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramMessageForTroopSign.markIconUrl, localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramSignItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label159;
        }
      }
      QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(localException));
    }
    else
    {
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    label159:
    if (paramMessageForTroopSign.markType == 1)
    {
      paramSignItemHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
      paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramSignItemHolder.b.setVisibility(4);
      a(paramSignItemHolder.jdField_c_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
    }
    if (paramMessageForTroopSign.markType == 2)
    {
      paramSignItemHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
      paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramSignItemHolder.b.setVisibility(0);
      paramSignItemHolder.b.setText(paramMessageForTroopSign.markDesc);
      a(paramSignItemHolder.jdField_c_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
    }
    if (paramMessageForTroopSign.markType == 3)
    {
      paramSignItemHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
      paramSignItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageForTroopSign.markWord);
      paramSignItemHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForTroopSign.markDesc);
      a(paramSignItemHolder.jdField_d_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
    }
    paramSignItemHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
    paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (MessageForTroopSign)((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    if ((!a()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n))
    {
      Object localObject1 = (TroopSignItemBuilder.SignItemHolder)AIOUtils.a(paramView);
      Object localObject2 = (MessageForTroopSign)((TroopSignItemBuilder.SignItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView == ((TroopSignItemBuilder.SignItemHolder)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout)
      {
        localObject2 = ((MessageForTroopSign)localObject2).srcAction;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_checkin", "", "entry", "clk_obj_graybar", 0, 0, "", "", "", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSrcClick actionURL:");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("TroopSignItemBuilder", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      else if (paramView == ((TroopSignItemBuilder.SignItemHolder)localObject1).jdField_a_of_type_AndroidViewView)
      {
        localObject2 = ((MessageForTroopSign)localObject2).msgAction;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_checkin", "", "entry", "clk_obj", 0, 0, "", "", "", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onContentClick actionURL:");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("TroopSignItemBuilder", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = "";
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded((Intent)localObject2, (String)localObject1);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            break label324;
          }
        }
        QLog.w("TroopSignItemBuilder", 2, "onClick exp:", localException);
      }
      else
      {
        super.onClick(paramView);
      }
    }
    label324:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder
 * JD-Core Version:    0.7.0.1
 */