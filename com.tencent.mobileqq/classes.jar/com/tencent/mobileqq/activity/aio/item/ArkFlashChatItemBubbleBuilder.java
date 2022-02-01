package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;

public class ArkFlashChatItemBubbleBuilder
  extends BaseBubbleBuilder
{
  private static final int a;
  private static final int d;
  private static final int e;
  protected View.OnClickListener a;
  
  static
  {
    jdField_a_of_type_Int = BaseChatItemLayout.h;
    d = BaseChatItemLayout.i;
    jdField_e_of_type_Int = BaseChatItemLayout.k;
  }
  
  public ArkFlashChatItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ArkFlashChatItemBubbleBuilder.3(this);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int j;
    for (int i = 0; i < k; i = j + 1)
    {
      j = i;
      if ('\024' == paramString.charAt(i))
      {
        int m = i + 1;
        j = i;
        if (m < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(m))
          {
            m = i + 2;
            j = i;
            if (m < k)
            {
              if (paramBoolean)
              {
                if (paramString.charAt(m) == '\024') {
                  paramString.setCharAt(m, 'ý');
                }
              }
              else if (paramString.charAt(m) == 'ý') {
                paramString.setCharAt(m, '\024');
              }
              j = i + 4;
            }
          }
        }
      }
    }
    return paramString.toString();
  }
  
  protected static final String[] a(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = -1;
    } else {
      i = paramString1.indexOf("://");
    }
    if (i == -1)
    {
      arrayOfString[0] = paramString1;
      return arrayOfString;
    }
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (BaseChatItemLayout)paramView;
    paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
    paramChatMessage = (RelativeLayout)paramViewGroup.findViewById(2131377969);
    "com.tencent.mobileqq".equals(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramOnLongClickAndTouchListener = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a;
    if (paramChatMessage != null) {
      paramViewGroup.removeView(paramChatMessage);
    }
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "ArkFlashChatItemBubbleBuilder getBubbleView");
    }
    paramBaseChatItemLayout = (MessageForArkFlashChat)paramChatMessage;
    if (paramBaseChatItemLayout.arkContainer == null) {
      paramBaseChatItemLayout.arkContainer = new ArkFlashChatContainerWrapper();
    } else if (paramBaseChatItemLayout.arkContainer.a()) {
      paramBaseChatItemLayout.arkContainer.reinitArkContainer();
    }
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity;
    ArkFlashChatItemBubbleBuilder.Holder localHolder = (ArkFlashChatItemBubbleBuilder.Holder)paramViewHolder;
    Object localObject2;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558798, null);
      paramView = paramViewHolder.findViewById(2131362973);
      localObject1 = (ArkAppLoadLayout)paramViewHolder.findViewById(2131370350);
      localObject2 = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)FlashChatPanel.a());
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)FlashChatPanel.b());
      ((ArkAppLoadLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)FlashChatPanel.a());
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)FlashChatPanel.b());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localObject1);
      localHolder.d = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131366877);
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131366878));
      localHolder.c = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131370360);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramViewHolder.findViewById(2131362947));
      localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramViewHolder.findViewById(2131377247));
      localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
      localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(false);
      localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(0);
      paramView = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.getLayoutParams();
      paramView.width = ((int)FlashChatPanel.a());
      paramView.height = ((int)FlashChatPanel.b());
      paramView.leftMargin = 0;
      localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setLayoutParams(paramView);
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramChatMessage.isSend();
    paramView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    paramView.setClipRadius(16.0F);
    paramView.setBorderType(1);
    paramView.setAlignLeft(paramChatMessage.isSend() ^ true);
    paramChatMessage = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    int i;
    if (paramBaseChatItemLayout.uniseq == ((Message)localObject1).uniseq) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    boolean bool;
    if ((i != 0) && ((!paramBaseChatItemLayout.isread) || (((FlashChatManager)localObject1).a(paramBaseChatItemLayout)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("testMyStopAnimLogic ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramBaseChatItemLayout.uniseq);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramBaseChatItemLayout.getSummery());
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramBaseChatItemLayout.isread);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(((FlashChatManager)localObject1).a(paramBaseChatItemLayout));
      QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject2).toString());
    }
    if (bool)
    {
      ((FlashChatManager)localObject1).b(paramBaseChatItemLayout);
      ((FlashChatManager)localObject1).a(null);
    }
    else if ((i != 0) && (((FlashChatManager)localObject1).b(paramBaseChatItemLayout)))
    {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("testMyStopAnimLogic ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramBaseChatItemLayout.uniseq);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramBaseChatItemLayout.getSummery());
      QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    long l = paramBaseChatItemLayout.uniseq;
    paramBaseChatItemLayout.arkContainer.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.ark_app_message.appName, paramBaseChatItemLayout.ark_app_message.appView, paramBaseChatItemLayout.ark_app_message.appMinVersion, paramBaseChatItemLayout.ark_app_message.appResId, paramBaseChatItemLayout.ark_app_message.getMeta(l, false), ArkAppCenterUtil.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, FlashChatPanel.a(), FlashChatPanel.b(), FlashChatPanel.a(), FlashChatPanel.b(), paramBaseChatItemLayout);
    paramBaseChatItemLayout.setupSendLoading(localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar);
    if (bool) {
      paramView.setCallback(new ArkFlashChatItemBubbleBuilder.1(this, paramBaseChatItemLayout));
    } else {
      paramView.setCallback(new ArkFlashChatItemBubbleBuilder.2(this, paramBaseChatItemLayout));
    }
    paramView.a(paramBaseChatItemLayout.arkContainer, paramChatMessage);
    localHolder.b = paramBaseChatItemLayout.msg;
    paramView.setTag(localHolder);
    paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (paramChatMessage != null)
    {
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    localHolder.jdField_a_of_type_AndroidViewView = paramViewHolder;
    localHolder.d.setVisibility(8);
    localHolder.c.setVisibility(0);
    localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
    localHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setBkgColorNormal(ArkAppLoadLayout.b);
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(paramBaseChatItemLayout.ark_app_message.promptText);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkFlashChatItemBubbleBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    if ((paramChatMessage instanceof MessageForArkFlashChat))
    {
      paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131700902));
      localStringBuilder.append(paramChatMessage.ark_app_message.promptText);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131700901));
    localStringBuilder.append(paramChatMessage.msg);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131367180: 
      paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      if (paramChatMessage != null)
      {
        if (paramChatMessage.ark_app_message == null) {
          return;
        }
        paramContext = new Bundle();
        paramContext.putInt("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramContext.putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramContext.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        paramContext.putInt("forward_type", 33);
        paramContext.putString("forward_flashchat_rawcontent", paramChatMessage.ark_app_message.toAppXml());
        paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.getSummery());
        paramContext.putInt("selection_mode", this.c);
        paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        return;
      }
      break;
    case 2131366494: 
      b(paramChatMessage);
      return;
    case 2131365480: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131365311: 
      if (paramChatMessage.msg != null) {
        try
        {
          ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage.msg);
          return;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatItemBuilder", 2, paramContext.toString());
          }
        }
      }
      break;
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkFlashChat)AIOUtils.a(paramView);
    if (paramView == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ArkFlashChatItemBubbleBuilder.4(this, paramView), new ArkFlashChatItemBubbleBuilder.5(this)).show();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296384);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_e_of_type_Int, jdField_a_of_type_Int, i, d);
      return;
    }
    paramView.setPadding(i, jdField_a_of_type_Int, jdField_e_of_type_Int, d);
  }
  
  public boolean a(String paramString1, String paramString2, MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SourceClickHandler clickWebMsg  url = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://"))))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("title", paramString2);
      ((Intent)localObject).putExtra("url", paramString1);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramMessageForArkFlashChat, (Intent)localObject, paramString1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SourceClickHandler clickAppMsg url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", actionData = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", actionDataA = ");
      localStringBuilder.append(paramString3);
      QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
    }
    paramString1 = a(paramString2, paramString3);
    paramString2 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (paramString2 == null) {
          return false;
        }
        paramString2.addFlags(67108864);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      label170:
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, paramString1.getMessage());
      }
    }
    try
    {
      ((StartAppCheckHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER)).b(paramString1[0].trim(), this.jdField_a_of_type_AndroidContentContext, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      break label170;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
    return true;
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    Object localObject = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    localQQCustomMenu.a(2131365311, HardCodeUtil.a(2131700900), 2130838903);
    if (localObject != null)
    {
      paramView = (MessageForArkFlashChat)((ChatItemBuilder.BaseHolder)localObject).a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        localQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
        if (paramView.isMultiMsg) {
          return localQQCustomMenu.a();
        }
        if (paramView.istroop == 0) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, ((ChatItemBuilder.BaseHolder)localObject).a, null);
        }
        if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramView, new Bundle());
        }
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramView, new Bundle());
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isSearch", false);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramView, (Bundle)localObject);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
        return localQQCustomMenu.a();
      }
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    QfavBuilder.a(null, paramChatMessage.msg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */