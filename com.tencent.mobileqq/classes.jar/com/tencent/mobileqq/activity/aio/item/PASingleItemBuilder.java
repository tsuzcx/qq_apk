package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
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
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.business.base.AppUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PASingleItemBuilder
  extends AbstractChatItemBuilder
{
  View.OnClickListener a;
  
  public PASingleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new PASingleItemBuilder.1(this);
  }
  
  private void a(PASingleItemBuilder.Holder paramHolder, ChatMessage paramChatMessage, long paramLong)
  {
    if (paramHolder != null)
    {
      if (paramChatMessage == null) {
        return;
      }
      String str;
      if (TextUtils.isEmpty(paramHolder.f)) {
        str = paramHolder.e;
      } else {
        str = paramHolder.f;
      }
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
      if (!TextUtils.isEmpty(str))
      {
        JumpAction localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str);
        if (localJumpAction == null)
        {
          int i;
          if (paramHolder.jdField_a_of_type_Long == 0L) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0)
          {
            if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, str)) {
              a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
            } else {
              ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
            }
          }
          else {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          }
        }
        else if (TextUtils.isEmpty(localJumpAction.a()))
        {
          if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, str)) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          } else {
            ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
          }
        }
        else if (!localJumpAction.a())
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        }
        else
        {
          ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
        }
        ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
        if ((paramChatMessage != null) && (localEcShopAssistantManager != null) && (localEcshopReportHandler != null) && (localEcShopAssistantManager.a(paramChatMessage.senderuin))) {
          localEcshopReportHandler.a(false, paramChatMessage, 1, str);
        }
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
      if ((paramChatMessage != null) && (localEcShopAssistantManager != null) && (localEcshopReportHandler != null) && (localEcShopAssistantManager.a(paramChatMessage.senderuin))) {
        localEcshopReportHandler.a(false, paramChatMessage, 1, paramHolder.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    if (((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).jumpNative(paramString1, paramContext)) {
      return;
    }
    if ((paramString2 != null) && (paramString2.equals("open_local")))
    {
      paramString1 = new Bundle();
      paramString1.putString("schemaurl", paramString3);
      paramString1.putString("uin", paramQQAppInterface.getCurrentAccountUin());
      OpenAppClient.b((Activity)paramContext, paramString1);
      return;
    }
    paramString1 = new Intent();
    paramString1.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString1.putExtra("url", paramString3);
    paramString1.putExtra("assignBackText", paramContext.getResources().getString(2131690706));
    paramString1.putExtra("puin", paramString4);
    if (paramLong >= 0L) {
      paramString1.putExtra("msg_id", String.valueOf(paramLong));
    }
    paramString1.putExtra("source_name", paramString5);
    paramString1.putExtra("fromAio", true);
    paramString1.putExtra("uin_type", 1008);
    paramString1.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(paramString4));
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramString1, paramString3);
    if (paramString1.getComponent() != null)
    {
      paramContext.startActivity(paramString1);
    }
    else
    {
      paramQQAppInterface = new ActivityURIRequest(paramContext, "/pubaccount/browser");
      paramQQAppInterface.extra().putAll(paramString1.getExtras());
      QRoute.startUri(paramQQAppInterface, null);
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramString4, "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString3, "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    paramString2 = Uri.parse(paramString2);
    paramString1 = paramString2.getScheme();
    paramString2 = paramString2.getHost();
    boolean bool = TextUtils.isEmpty(paramString1);
    int i = 0;
    if ((!bool) && (AppUtil.a(paramString1)))
    {
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      if (AppLaucherHelper.a(paramString2) != 0) {
        i = 1;
      }
      Bundle localBundle = AppLaucherHelper.a(paramString2);
      int j = localBundle.getInt("a_launch_mode", 268435456);
      if (i != 0)
      {
        localAppLaucherHelper.a(paramQQAppInterface, paramContext, String.valueOf(paramLong), paramString2, paramString1, j);
        return true;
      }
      return AppUtil.a(paramContext, paramString1, localBundle, j);
    }
    return false;
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPubAccount))
    {
      paramChatMessage = (MessageForPubAccount)paramChatMessage;
      if ((paramChatMessage.mPAMessage != null) && (paramChatMessage.mPAMessage.mMsgId > 0L))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramChatMessage.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramChatMessage.mPAMessage.mMsgId), "", "", "");
        Object localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if ((localObject != null) && (((IPublicAccountDataManager)localObject).isCertifiedAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramChatMessage.mPAMessage.items != null) && (paramChatMessage.mPAMessage.items.size() > 0))
        {
          localObject = ((PAMessage.Item)paramChatMessage.mPAMessage.items.get(0)).title;
          VSReporter.a(paramChatMessage.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localObject });
        }
      }
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.b(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558812, null);
    }
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    paramViewHolder = (PASingleItemBuilder.Holder)paramViewHolder;
    View localView = paramView.findViewById(2131372257);
    Object localObject5 = (TextView)paramView.findViewById(2131372243);
    Object localObject4 = (TextView)paramView.findViewById(2131372259);
    Object localObject2 = (TextView)paramView.findViewById(2131372258);
    Object localObject1 = (ImageView)paramView.findViewById(2131372256);
    Object localObject6 = (TextView)paramView.findViewById(2131372248);
    Object localObject7 = (TextView)paramView.findViewById(2131372249);
    Object localObject8 = (TextView)paramView.findViewById(2131372250);
    TextView localTextView1 = (TextView)paramView.findViewById(2131372251);
    TextView localTextView2 = (TextView)paramView.findViewById(2131372252);
    Object localObject3 = (TextView)paramView.findViewById(2131372254);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject6);
    localArrayList.add(localObject7);
    localArrayList.add(localObject8);
    localArrayList.add(localTextView1);
    localArrayList.add(localTextView2);
    localObject6 = paramLinearLayout.mPAMessage;
    if (((PAMessage)localObject6).grayTips != null)
    {
      ((TextView)localObject5).setText(((PAMessage)localObject6).grayTips);
      ((TextView)localObject5).setVisibility(0);
    }
    else
    {
      ((TextView)localObject5).setVisibility(8);
    }
    localObject5 = (PAMessage.Item)((PAMessage)localObject6).items.get(0);
    paramViewHolder.jdField_c_of_type_JavaLangString = ((PAMessage.Item)localObject5).url;
    paramViewHolder.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject5).actionUrl;
    paramViewHolder.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject5).nativeJumpString;
    paramViewHolder.jdField_c_of_type_Int = ((PAMessage)localObject6).type;
    paramViewHolder.jdField_b_of_type_Int = 5;
    paramViewHolder.jdField_a_of_type_JavaLangObject = Long.valueOf(paramLinearLayout.uniseq);
    paramViewHolder.d = ((PAMessage)localObject6).moreText;
    paramViewHolder.jdField_a_of_type_Long = ((PAMessage.Item)localObject5).appId;
    paramViewHolder.e = ((PAMessage.Item)localObject5).actionData;
    paramViewHolder.f = ((PAMessage.Item)localObject5).a_actionData;
    paramViewHolder.g = ((PAMessage.Item)localObject5).i_actionData;
    if (!TextUtils.isEmpty(((PAMessage)localObject6).moreText)) {
      ((TextView)localObject3).setText(((PAMessage)localObject6).moreText);
    } else {
      ((TextView)localObject3).setText(2131694676);
    }
    localObject3 = Util.c(((PAMessage.Item)localObject5).title);
    ((TextView)localObject4).setText((CharSequence)localObject3);
    int i;
    if (((PAMessage.Item)localObject5).mVideoFlag == 1)
    {
      localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842748);
      i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      ((Drawable)localObject7).setBounds(i, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + i, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
      localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append((String)localObject3);
      ((StringBuilder)localObject8).append("1");
      localObject8 = new SpannableString(((StringBuilder)localObject8).toString());
      ((SpannableString)localObject8).setSpan(new ImageSpan((Drawable)localObject7, 0), ((String)localObject3).length(), ((String)localObject3).length() + 1, 17);
      ((TextView)localObject4).setText((CharSequence)localObject8);
    }
    long l;
    if (((PAMessage.Item)localObject5).time != 0L) {
      l = ((PAMessage.Item)localObject5).time;
    } else {
      l = ((PAMessage)localObject6).sendTime;
    }
    if (l != 0L)
    {
      ((TextView)localObject2).setText(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
      ((TextView)localObject2).setVisibility(0);
    }
    else
    {
      ((TextView)localObject2).setVisibility(8);
    }
    try
    {
      localObject2 = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((PAMessage.Item)localObject5).cover, 0);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
      j = AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = AIOUtils.b(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = (i - j);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = k;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = false;
      ((URLDrawable.URLDrawableOptions)localObject4).mGifRoundCorner = 0.0F;
      ((URLDrawable.URLDrawableOptions)localObject4).mExtraInfo = paramMessageRecord;
      paramMessageRecord = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
      paramMessageRecord.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((ImageView)localObject1).setImageDrawable(paramMessageRecord);
    }
    catch (Exception paramMessageRecord)
    {
      int j;
      label798:
      break label798;
    }
    ((ImageView)localObject1).setImageResource(2130838024);
    paramMessageRecord = ((PAMessage.Item)localObject5).digestList;
    if (paramMessageRecord != null) {
      i = paramMessageRecord.size();
    } else {
      i = 0;
    }
    j = 0;
    while (j < localArrayList.size())
    {
      localObject1 = (TextView)localArrayList.get(j);
      if (i > j)
      {
        ((TextView)localObject1).setText((CharSequence)paramMessageRecord.get(j));
        ((TextView)localObject1).setVisibility(0);
      }
      else
      {
        ((TextView)localObject1).setVisibility(8);
      }
      j += 1;
    }
    localView.setTag(paramViewHolder);
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnTouchListener(paramOnLongClickAndTouchListener);
    localView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramMessageRecord = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if ((paramMessageRecord != null) && (paramMessageRecord.isCertifiedAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      VSReporter.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localObject3 });
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new PASingleItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480) {
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
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder
 * JD-Core Version:    0.7.0.1
 */