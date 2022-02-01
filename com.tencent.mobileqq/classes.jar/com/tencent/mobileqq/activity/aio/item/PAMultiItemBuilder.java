package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;

public class PAMultiItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PAMultiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new PAMultiItemBuilder.1(this);
  }
  
  private void a(MessageForPubAccount paramMessageForPubAccount, PAMultiItemBuilder.Holder paramHolder, long paramLong, String paramString)
  {
    if (paramHolder != null)
    {
      if (paramMessageForPubAccount == null) {
        return;
      }
      if (paramLong > 0L) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramLong), "", "", "");
      }
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      if ((localEcShopAssistantManager != null) && (localEcshopReportHandler != null) && (localEcShopAssistantManager.a(paramMessageForPubAccount.senderuin))) {
        localEcshopReportHandler.a(false, paramMessageForPubAccount, paramHolder.d + 1, paramString);
      }
      paramHolder = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if ((paramHolder != null) && (paramHolder.isCertifiedAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramMessageForPubAccount.mPAMessage.items != null) && (paramMessageForPubAccount.mPAMessage.items.size() > 0)) {
        VSReporter.a(paramMessageForPubAccount.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramMessageForPubAccount.mPAMessage.items.get(0)).title });
      }
    }
  }
  
  private void a(PAMessage.Item paramItem, PAMultiItemBuilder.Holder paramHolder, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      JumpAction localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
      if (localJumpAction == null)
      {
        int i;
        if (paramItem.appId != 0L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (!PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          } else {
            ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
          }
        }
        else {
          PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        }
      }
      else if (TextUtils.isEmpty(localJumpAction.a()))
      {
        if (!PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
          PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        } else {
          ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        }
      }
      else if (!localJumpAction.a())
      {
        PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
      }
      else
      {
        ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
      }
      ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
      return;
    }
    PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364521);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
    }
    return paramChatMessage;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)paramView).setOrientation(1);
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = paramLinearLayout.mPAMessage;
    double d = BaseChatItemLayout.d;
    Double.isNaN(d);
    int i = (int)(d * 0.5D);
    ArrayList localArrayList = localPAMessage.items;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    Object localObject1;
    if (localPAMessage.grayTips != null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setText(localPAMessage.grayTips);
      paramViewHolder.setGravity(17);
      paramViewHolder.setSingleLine();
      paramViewHolder.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewHolder.setBackgroundResource(2130844764);
      paramViewHolder.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramViewHolder.setTextColor(-1);
      paramViewHolder.setTextSize(12.0F);
      localViewGroup.addView(paramViewHolder);
    }
    int j = 0;
    while (j < localArrayList.size())
    {
      localObject1 = new PAMultiItemBuilder.Holder(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(j);
      ((PAMultiItemBuilder.Holder)localObject1).jdField_b_of_type_Int = 5;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((PAMultiItemBuilder.Holder)localObject1).d = j;
      if (j == 0) {
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558811, null);
      }
      int k;
      for (;;)
      {
        break;
        if (j == localArrayList.size() - 1)
        {
          paramViewHolder = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, i);
          k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = k;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = k;
          paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramViewHolder.setBackgroundResource(2131165953);
          localViewGroup.addView(paramViewHolder);
          paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558809, null);
        }
        else
        {
          if (j != 1)
          {
            paramViewHolder = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject2 = new ViewGroup.MarginLayoutParams(-1, i);
            k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
            ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = k;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = k;
            paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramViewHolder.setBackgroundResource(2131165953);
            localViewGroup.addView(paramViewHolder);
          }
          paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558810, null);
        }
      }
      Object localObject3 = (TextView)paramViewHolder.findViewById(2131372247);
      Object localObject2 = (ImageView)paramViewHolder.findViewById(2131372246);
      if ((j == 0) && ((localObject2 instanceof PAImageView))) {
        ((PAImageView)localObject2).setUseRadiusRound(true, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296443));
      }
      String str = Util.c(localItem.title);
      ((TextView)localObject3).setText(str);
      if (localItem.mVideoFlag == 1)
      {
        Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (j == 0) {
          k = 2130842747;
        } else {
          k = 2130842748;
        }
        localObject4 = ((Resources)localObject4).getDrawable(k);
        k = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        ((Drawable)localObject4).setBounds(k, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + k, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(str);
        ((StringBuilder)localObject5).append("1");
        localObject5 = new SpannableString(((StringBuilder)localObject5).toString());
        ((SpannableString)localObject5).setSpan(new ImageSpan((Drawable)localObject4, 0), str.length(), str.length() + 1, 17);
        ((TextView)localObject3).setText((CharSequence)localObject5);
      }
      try
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
        ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
        if (j == 0)
        {
          k = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
          int m = AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = AIOUtils.b(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (k - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
        }
        else
        {
          k = AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = k;
        }
        ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
      }
      catch (Exception localException)
      {
        label995:
        break label995;
      }
      ((ImageView)localObject2).setImageResource(2130838024);
      localViewGroup.addView(paramViewHolder);
      paramViewHolder.setTag(localObject1);
      paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      j += 1;
    }
    paramView.setBackgroundResource(2130838259);
    paramMessageRecord = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if ((paramMessageRecord != null) && (paramMessageRecord.isCertifiedAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      VSReporter.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new PAMultiItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = (IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    boolean bool;
    if (paramChatMessage.issend == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.deletePubAccountMsg(localQQAppInterface, localContext, str, paramInt, l, bool);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131365480, this.jdField_a_of_type_AndroidContentContext.getString(2131690788), 2130838907);
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */