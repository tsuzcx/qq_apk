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
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
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
    if ((paramHolder == null) || (paramMessageForPubAccount == null)) {}
    do
    {
      return;
      if (paramLong > 0L) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramLong), "", "", "");
      }
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      if ((localEcShopAssistantManager != null) && (localEcshopReportHandler != null) && (localEcShopAssistantManager.a(paramMessageForPubAccount.senderuin))) {
        localEcshopReportHandler.a(false, paramMessageForPubAccount, paramHolder.d + 1, paramString);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER) == null) || (!((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (paramMessageForPubAccount.mPAMessage.items == null) || (paramMessageForPubAccount.mPAMessage.items.size() <= 0));
    VSReporter.a(paramMessageForPubAccount.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramMessageForPubAccount.mPAMessage.items.get(0)).title });
  }
  
  private void a(PAMessage.Item paramItem, PAMultiItemBuilder.Holder paramHolder, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      JumpAction localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
      int i;
      if (localJumpAction == null) {
        if (paramItem.appId != 0L)
        {
          i = 1;
          if (i == 0) {
            break label155;
          }
          if (PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            break label132;
          }
          PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        }
      }
      for (;;)
      {
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
        return;
        i = 0;
        break;
        label132:
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        continue;
        label155:
        PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        continue;
        if (TextUtils.isEmpty(localJumpAction.a()))
        {
          if (!PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          } else {
            PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
          }
        }
        else if (!localJumpAction.a()) {
          PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        } else {
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
        }
      }
    }
    PASingleItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364634);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
    }
    return paramChatMessage;
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)paramView).setOrientation(1);
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = paramLinearLayout.mPAMessage;
    int k = (int)(0.5D * BaseChatItemLayout.d);
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
      paramViewHolder.setBackgroundResource(2130844888);
      paramViewHolder.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramViewHolder.setTextColor(-1);
      paramViewHolder.setTextSize(12.0F);
      localViewGroup.addView(paramViewHolder);
    }
    int i = 0;
    label376:
    Object localObject2;
    if (i < localArrayList.size())
    {
      localObject1 = new PAMultiItemBuilder.Holder(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((PAMultiItemBuilder.Holder)localObject1).jdField_b_of_type_Int = 5;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((PAMultiItemBuilder.Holder)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((PAMultiItemBuilder.Holder)localObject1).d = i;
      Object localObject3;
      int j;
      if (i == 0)
      {
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558913, null);
        localObject3 = (TextView)paramViewHolder.findViewById(2131372669);
        localObject2 = (ImageView)paramViewHolder.findViewById(2131372668);
        if ((i == 0) && ((localObject2 instanceof PAImageView))) {
          ((PAImageView)localObject2).setUseRadiusRound(true, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296464));
        }
        String str = Util.c(localItem.title);
        ((TextView)localObject3).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label964;
          }
          j = 2130842847;
          label481:
          localObject4 = ((Resources)localObject4).getDrawable(j);
          j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject4).setBounds(j, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
          SpannableString localSpannableString = new SpannableString(str + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject4, 0), str.length(), str.length() + 1, 17);
          ((TextView)localObject3).setText(localSpannableString);
        }
      }
      for (;;)
      {
        try
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
          if (i != 0) {
            continue;
          }
          j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
          int m = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = AIOUtils.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
        }
        catch (Exception localException)
        {
          label964:
          ((ImageView)localObject2).setImageResource(2130838183);
          continue;
        }
        localViewGroup.addView(paramViewHolder);
        paramViewHolder.setTag(localObject1);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramViewHolder = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramViewHolder.setBackgroundResource(2131165942);
          localViewGroup.addView(paramViewHolder);
          paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558911, null);
          break label376;
        }
        if (i != 1)
        {
          paramViewHolder = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramViewHolder.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramViewHolder.setBackgroundResource(2131165942);
          localViewGroup.addView(paramViewHolder);
        }
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558912, null);
        break label376;
        j = 2130842848;
        break label481;
        j = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      }
    }
    paramView.setBackgroundResource(2130838423);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER) != null) && (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      VSReporter.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
    }
    return paramView;
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new PAMultiItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
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
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      paramContext.deletePubAccountMsg(localQQAppInterface, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(2131365636, this.jdField_a_of_type_AndroidContentContext.getString(2131690860), 2130839054);
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */