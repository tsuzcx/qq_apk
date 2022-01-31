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
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;

public abstract class TroopSignItemBuilder
  extends BaseBubbleBuilder
{
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g = 12303291;
  protected int h;
  
  public TroopSignItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = DisplayUtil.a(paramContext, 151.5F);
    this.c = DisplayUtil.a(paramContext, 125.5F);
    this.d = DisplayUtil.a(paramContext, 152.0F);
    this.e = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
    this.f = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.h = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
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
    switch (paramInt)
    {
    default: 
      return;
    case 2131375584: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    int i = this.e / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (paramInt == 7)
    {
      localLayoutParams.topMargin = this.e;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.addRule(10, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = i;
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, 0);
      localLayoutParams.addRule(10, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = (i + this.f);
      } else {
        localLayoutParams.rightMargin = i;
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, 0, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(TroopSignItemBuilder.SignItemHolder paramSignItemHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramSignItemHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Resources localResources;
    Object localObject1;
    TextView localTextView;
    Object localObject2;
    Drawable localDrawable;
    if (paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = new FrameLayout.LayoutParams(-2, -2);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setBackgroundResource(2130840645);
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject1);
      paramSignItemHolder.e = localTextView;
      paramSignItemHolder.e.setText(localMessageForTroopSign.srcName);
      if (!TextUtils.isEmpty(localMessageForTroopSign.srcIconUrl))
      {
        localObject2 = localMessageForTroopSign.srcIconUrl;
        localDrawable = localResources.getDrawable(2130846094);
        localDrawable.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        localObject1 = new ColorDrawable(15790320);
        ((Drawable)localObject1).setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
      }
    }
    else
    {
      try
      {
        localObject2 = URLDrawable.getDrawable((String)localObject2, localDrawable, (Drawable)localObject1);
        if (URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext)) {
          break label399;
        }
        bool = true;
        ((URLDrawable)localObject2).setAutoDownload(bool);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          label296:
          if (QLog.isColorLevel()) {
            QLog.e("TroopSignItemBuilder", 2, "setSourceView exception" + localException.toString());
          }
        }
      }
      ((Drawable)localObject1).setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
      localTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, localResources));
      localTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localTextView.setPadding(AIOUtils.a(5.0F, localResources), 0, AIOUtils.a(5.0F, localResources), 0);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131361877);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131361877);
      paramBaseChatItemLayout.addView(paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramBaseChatItemLayout = (FrameLayout.LayoutParams)paramSignItemHolder.e.getLayoutParams();
      if (!localMessageForTroopSign.isSend()) {
        break label457;
      }
    }
    label399:
    label457:
    for (paramBaseChatItemLayout.leftMargin = BaseChatItemLayout.j;; paramBaseChatItemLayout.leftMargin = this.f)
    {
      paramSignItemHolder.e.setLayoutParams(paramBaseChatItemLayout);
      return;
      bool = false;
      break;
      localTextView.setCompoundDrawables(null, null, null, null);
      break label296;
    }
  }
  
  public void a(TroopSignItemBuilder.SignItemHolder paramSignItemHolder, MessageForTroopSign paramMessageForTroopSign)
  {
    boolean bool = paramMessageForTroopSign.isSend();
    if ((paramMessageForTroopSign.markType == 1) || (paramMessageForTroopSign.markType == 2)) {
      if (!TextUtils.isEmpty(paramMessageForTroopSign.markIconUrl))
      {
        Object localObject = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.h;
        localURLDrawableOptions.mRequestHeight = this.h;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramMessageForTroopSign.markIconUrl, localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramSignItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    while (paramMessageForTroopSign.markType == 1)
    {
      paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
      paramSignItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramSignItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      a(paramSignItemHolder.jdField_b_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      continue;
      paramSignItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (paramMessageForTroopSign.markType == 2)
    {
      paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
      paramSignItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramSignItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramSignItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForTroopSign.markDesc);
      a(paramSignItemHolder.jdField_b_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
    }
    if (paramMessageForTroopSign.markType == 3)
    {
      paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramSignItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(4);
      paramSignItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageForTroopSign.markWord);
      paramSignItemHolder.d.setText(paramMessageForTroopSign.markDesc);
      a(paramSignItemHolder.jdField_c_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
    }
    paramSignItemHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
    paramSignItemHolder.jdField_b_of_type_AndroidViewView.setVisibility(4);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    super.a((MessageForTroopSign)((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage, localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    if (a()) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {
      return;
    }
    Object localObject1 = (TroopSignItemBuilder.SignItemHolder)AIOUtils.a(paramView);
    Object localObject2 = (MessageForTroopSign)((TroopSignItemBuilder.SignItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView == ((TroopSignItemBuilder.SignItemHolder)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout)
    {
      localObject2 = ((MessageForTroopSign)localObject2).srcAction;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_checkin", "", "entry", "clk_obj_graybar", 0, 0, "", "", "", "");
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label267;
      }
      QLog.d("TroopSignItemBuilder", 2, "onSrcClick actionURL:" + (String)localObject2);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          paramView.putExtra("url", (String)localObject1);
          PublicAccountUtil.a(paramView, (String)localObject1);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          return;
        }
        catch (Exception paramView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("TroopSignItemBuilder", 2, "onClick exp:", paramView);
        return;
        if (paramView != ((TroopSignItemBuilder.SignItemHolder)localObject1).jdField_a_of_type_AndroidViewView) {
          break label276;
        }
        localObject2 = ((MessageForTroopSign)localObject2).msgAction;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_checkin", "", "entry", "clk_obj", 0, 0, "", "", "", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopSignItemBuilder", 2, "onContentClick actionURL:" + (String)localObject2);
          localObject1 = localObject2;
        }
        label267:
        continue;
      }
      super.onClick(paramView);
      return;
      label276:
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder
 * JD-Core Version:    0.7.0.1
 */