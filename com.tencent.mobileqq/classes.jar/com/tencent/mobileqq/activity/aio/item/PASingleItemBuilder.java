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
    if ((paramHolder == null) || (paramChatMessage == null)) {}
    label25:
    EcShopAssistantManager localEcShopAssistantManager;
    EcshopReportHandler localEcshopReportHandler;
    label95:
    label228:
    label234:
    do
    {
      return;
      String str;
      JumpAction localJumpAction;
      int i;
      if (TextUtils.isEmpty(paramHolder.f))
      {
        str = paramHolder.e;
        localEcShopAssistantManager = (EcShopAssistantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
        localEcshopReportHandler = (EcshopReportHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
        if (TextUtils.isEmpty(str)) {
          break label469;
        }
        localJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str);
        if (localJumpAction != null) {
          break label298;
        }
        if (paramHolder.jdField_a_of_type_Long != 0L) {
          break label228;
        }
        i = 0;
        if (i == 0) {
          break label257;
        }
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, str)) {
          break label234;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
      }
      for (;;)
      {
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
        if ((paramChatMessage == null) || (localEcShopAssistantManager == null) || (localEcshopReportHandler == null) || (!localEcShopAssistantManager.a(paramChatMessage.senderuin))) {
          break;
        }
        localEcshopReportHandler.a(false, paramChatMessage, 1, str);
        return;
        str = paramHolder.f;
        break label25;
        i = 1;
        break label95;
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
        continue;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        continue;
        if (TextUtils.isEmpty(localJumpAction.a()))
        {
          if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_a_of_type_Long, str)) {
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          } else {
            PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
          }
        }
        else if (!localJumpAction.a()) {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        } else {
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramHolder.jdField_a_of_type_JavaLangString, paramHolder.jdField_b_of_type_JavaLangString, paramHolder.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
    } while ((paramChatMessage == null) || (localEcShopAssistantManager == null) || (localEcshopReportHandler == null) || (!localEcShopAssistantManager.a(paramChatMessage.senderuin)));
    label257:
    label298:
    label469:
    localEcshopReportHandler.a(false, paramChatMessage, 1, paramHolder.jdField_c_of_type_JavaLangString);
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
    paramString1.putExtra("assignBackText", paramContext.getResources().getString(2131690778));
    paramString1.putExtra("puin", paramString4);
    if (paramLong >= 0L) {
      paramString1.putExtra("msg_id", String.valueOf(paramLong));
    }
    paramString1.putExtra("source_name", paramString5);
    paramString1.putExtra("fromAio", true);
    paramString1.putExtra("uin_type", 1008);
    paramString1.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(paramString4));
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramString1, paramString3);
    if (paramString1.getComponent() != null) {
      paramContext.startActivity(paramString1);
    }
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", paramString4, "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString3, "", "", "");
      return;
      paramQQAppInterface = new ActivityURIRequest(paramContext, "/pubaccount/browser");
      paramQQAppInterface.extra().putAll(paramString1.getExtras());
      QRoute.startUri(paramQQAppInterface, null);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    int i = 0;
    paramString2 = Uri.parse(paramString2);
    paramString1 = paramString2.getScheme();
    paramString2 = paramString2.getHost();
    if ((!TextUtils.isEmpty(paramString1)) && (AppUtil.a(paramString1)))
    {
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      if (AppLaucherHelper.a(paramString2) == 0) {}
      Bundle localBundle;
      int j;
      for (;;)
      {
        localBundle = AppLaucherHelper.a(paramString2);
        j = localBundle.getInt("a_launch_mode", 268435456);
        if (i == 0) {
          break;
        }
        localAppLaucherHelper.a(paramQQAppInterface, paramContext, String.valueOf(paramLong), paramString2, paramString1, j);
        return true;
        i = 1;
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
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER) != null) && (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramChatMessage.mPAMessage.items != null) && (paramChatMessage.mPAMessage.items.size() > 0))
        {
          String str = ((PAMessage.Item)paramChatMessage.mPAMessage.items.get(0)).title;
          VSReporter.a(paramChatMessage.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, str });
        }
      }
    }
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout.setPadding(0, AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558914, null);
    }
    paramView = (MessageForPubAccount)paramMessageRecord;
    paramViewHolder = (PASingleItemBuilder.Holder)paramViewHolder;
    View localView = paramLinearLayout.findViewById(2131372679);
    Object localObject5 = (TextView)paramLinearLayout.findViewById(2131372665);
    Object localObject2 = (TextView)paramLinearLayout.findViewById(2131372681);
    Object localObject3 = (TextView)paramLinearLayout.findViewById(2131372680);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131372678);
    Object localObject6 = (TextView)paramLinearLayout.findViewById(2131372670);
    Object localObject7 = (TextView)paramLinearLayout.findViewById(2131372671);
    Object localObject8 = (TextView)paramLinearLayout.findViewById(2131372672);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131372673);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131372674);
    Object localObject4 = (TextView)paramLinearLayout.findViewById(2131372676);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject6);
    localArrayList.add(localObject7);
    localArrayList.add(localObject8);
    localArrayList.add(localTextView1);
    localArrayList.add(localTextView2);
    localObject6 = paramView.mPAMessage;
    label405:
    int i;
    long l;
    if (((PAMessage)localObject6).grayTips != null)
    {
      ((TextView)localObject5).setText(((PAMessage)localObject6).grayTips);
      ((TextView)localObject5).setVisibility(0);
      localObject5 = (PAMessage.Item)((PAMessage)localObject6).items.get(0);
      paramViewHolder.jdField_c_of_type_JavaLangString = ((PAMessage.Item)localObject5).url;
      paramViewHolder.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject5).actionUrl;
      paramViewHolder.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject5).nativeJumpString;
      paramViewHolder.jdField_c_of_type_Int = ((PAMessage)localObject6).type;
      paramViewHolder.jdField_b_of_type_Int = 5;
      paramViewHolder.jdField_a_of_type_JavaLangObject = Long.valueOf(paramView.uniseq);
      paramViewHolder.d = ((PAMessage)localObject6).moreText;
      paramViewHolder.jdField_a_of_type_Long = ((PAMessage.Item)localObject5).appId;
      paramViewHolder.e = ((PAMessage.Item)localObject5).actionData;
      paramViewHolder.f = ((PAMessage.Item)localObject5).a_actionData;
      paramViewHolder.g = ((PAMessage.Item)localObject5).i_actionData;
      if (TextUtils.isEmpty(((PAMessage)localObject6).moreText)) {
        break label841;
      }
      ((TextView)localObject4).setText(((PAMessage)localObject6).moreText);
      localObject4 = Util.c(((PAMessage.Item)localObject5).title);
      ((TextView)localObject2).setText((CharSequence)localObject4);
      if (((PAMessage.Item)localObject5).mVideoFlag == 1)
      {
        localObject7 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842848);
        i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        ((Drawable)localObject7).setBounds(i, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + i, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        localObject8 = new SpannableString((String)localObject4 + "1");
        ((SpannableString)localObject8).setSpan(new ImageSpan((Drawable)localObject7, 0), ((String)localObject4).length(), ((String)localObject4).length() + 1, 17);
        ((TextView)localObject2).setText((CharSequence)localObject8);
      }
      if (((PAMessage.Item)localObject5).time == 0L) {
        break label852;
      }
      l = ((PAMessage.Item)localObject5).time;
      label572:
      if (l == 0L) {
        break label862;
      }
      ((TextView)localObject3).setText(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, l * 1000L));
      ((TextView)localObject3).setVisibility(0);
    }
    for (;;)
    {
      try
      {
        localObject2 = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(((PAMessage.Item)localObject5).cover, 0);
        i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        int j = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int k = AIOUtils.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (i - j);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = k;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
        ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
        paramMessageRecord = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        paramMessageRecord.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((ImageView)localObject1).setImageDrawable(paramMessageRecord);
        paramMessageRecord = ((PAMessage.Item)localObject5).digestList;
        if (paramMessageRecord != null)
        {
          i = paramMessageRecord.size();
          j = 0;
          if (j < localArrayList.size())
          {
            localObject1 = (TextView)localArrayList.get(j);
            if (i > j)
            {
              ((TextView)localObject1).setText((CharSequence)paramMessageRecord.get(j));
              ((TextView)localObject1).setVisibility(0);
              j += 1;
              continue;
              ((TextView)localObject5).setVisibility(8);
              break;
              label841:
              ((TextView)localObject4).setText(2131694701);
              break label405;
              label852:
              l = ((PAMessage)localObject6).sendTime;
              break label572;
              label862:
              ((TextView)localObject3).setVisibility(8);
              continue;
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        ((ImageView)localObject1).setImageResource(2130838183);
        continue;
        ((TextView)localObject1).setVisibility(8);
        continue;
        localView.setTag(paramViewHolder);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(paramOnLongClickAndTouchListener);
        localView.setOnLongClickListener(paramOnLongClickAndTouchListener);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER) != null) && (((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramView.mPAMessage.items != null) && (paramView.mPAMessage.items.size() > 0)) {
          VSReporter.a(paramView.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localObject4 });
        }
        return paramLinearLayout;
      }
      i = 0;
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new PASingleItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
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
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder
 * JD-Core Version:    0.7.0.1
 */