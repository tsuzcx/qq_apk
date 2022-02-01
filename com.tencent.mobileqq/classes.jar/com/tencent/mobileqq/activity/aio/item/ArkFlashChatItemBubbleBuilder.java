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
  private static final int w = BaseChatItemLayout.k;
  private static final int x = BaseChatItemLayout.l;
  protected View.OnClickListener a = new ArkFlashChatItemBubbleBuilder.3(this);
  
  public ArkFlashChatItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (BaseChatItemLayout)paramView;
    paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
    paramChatMessage = (RelativeLayout)paramViewGroup.findViewById(2131446456);
    "com.tencent.mobileqq".equals(this.e.getPackageName());
    paramOnLongClickAndTouchListener = ((FlashChatManager)this.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c;
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
    } else if (paramBaseChatItemLayout.arkContainer.b()) {
      paramBaseChatItemLayout.arkContainer.reinitArkContainer();
    }
    float f = this.e.getResources().getDisplayMetrics().scaledDensity;
    ArkFlashChatItemBubbleBuilder.Holder localHolder = (ArkFlashChatItemBubbleBuilder.Holder)paramViewHolder;
    Object localObject2;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.e).inflate(2131624418, null);
      paramView = paramViewHolder.findViewById(2131428772);
      localObject1 = (ArkAppLoadLayout)paramViewHolder.findViewById(2131437612);
      localObject2 = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)FlashChatPanel.getFlashChatWidth());
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)FlashChatPanel.getFlashChatHeight());
      ((ArkAppLoadLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)FlashChatPanel.getFlashChatWidth());
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)FlashChatPanel.getFlashChatHeight());
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localHolder.c = ((ArkAppLoadLayout)localObject1);
      localHolder.e = localHolder.c.findViewById(2131433206);
      localHolder.g = ((TextView)localHolder.c.findViewById(2131433207));
      localHolder.d = localHolder.c.findViewById(2131437622);
      localHolder.f = ((ArkAppView)paramViewHolder.findViewById(2131428746));
      localHolder.a = ((AutoStartProgressBar)paramViewHolder.findViewById(2131445634));
      localHolder.a.setRadius(15.0F, true);
      localHolder.a.setShowCorner(false);
      localHolder.a.setDrawStatus(0);
      paramView = (RelativeLayout.LayoutParams)localHolder.a.getLayoutParams();
      paramView.width = ((int)FlashChatPanel.getFlashChatWidth());
      paramView.height = ((int)FlashChatPanel.getFlashChatHeight());
      paramView.leftMargin = 0;
      localHolder.a.setLayoutParams(paramView);
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramChatMessage.isSend();
    paramView = localHolder.f;
    paramView.setClipRadius(16.0F);
    paramView.setBorderType(1);
    paramView.setAlignLeft(paramChatMessage.isSend() ^ true);
    paramChatMessage = localHolder.c;
    Object localObject1 = this.d.getMessageFacade().getLastMessage(this.f.b, this.f.a);
    int i;
    if (paramBaseChatItemLayout.uniseq == ((Message)localObject1).uniseq) {
      i = 1;
    } else {
      i = 0;
    }
    localObject1 = (FlashChatManager)this.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
    boolean bool;
    if ((i != 0) && ((!paramBaseChatItemLayout.isread) || (((FlashChatManager)localObject1).b(paramBaseChatItemLayout)))) {
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
      ((StringBuilder)localObject2).append(((FlashChatManager)localObject1).b(paramBaseChatItemLayout));
      QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject2).toString());
    }
    if (bool)
    {
      ((FlashChatManager)localObject1).e(paramBaseChatItemLayout);
      ((FlashChatManager)localObject1).a(null);
    }
    else if ((i != 0) && (((FlashChatManager)localObject1).c(paramBaseChatItemLayout)))
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
    paramBaseChatItemLayout.arkContainer.a(this.d, this.e, paramBaseChatItemLayout.ark_app_message.appName, paramBaseChatItemLayout.ark_app_message.appView, paramBaseChatItemLayout.ark_app_message.appMinVersion, paramBaseChatItemLayout.ark_app_message.appResId, paramBaseChatItemLayout.ark_app_message.getMeta(l, false), ArkAppCenterUtil.d(), this.f, FlashChatPanel.getFlashChatWidth(), FlashChatPanel.getFlashChatHeight(), FlashChatPanel.getFlashChatWidth(), FlashChatPanel.getFlashChatHeight(), paramBaseChatItemLayout);
    paramBaseChatItemLayout.setupSendLoading(localHolder.a);
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
    localHolder.h = paramViewHolder;
    localHolder.e.setVisibility(8);
    localHolder.d.setVisibility(0);
    localHolder.a.setVisibility(8);
    localHolder.a.b();
    localHolder.c.setBkgColorNormal(ArkAppLoadLayout.b);
    if (v) {
      paramView.setContentDescription(paramBaseChatItemLayout.ark_app_message.promptText);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkFlashChatItemBubbleBuilder.Holder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131433636: 
      paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      if (paramChatMessage != null)
      {
        if (paramChatMessage.ark_app_message == null) {
          return;
        }
        paramContext = new Bundle();
        paramContext.putInt("uintype", this.f.a);
        paramContext.putString("uin", this.f.b);
        paramContext.putString("troop_uin", this.f.c);
        paramContext.putInt("forward_type", 33);
        paramContext.putString("forward_flashchat_rawcontent", paramChatMessage.ark_app_message.toAppXml());
        paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.getSummery());
        paramContext.putInt("selection_mode", this.u);
        paramContext.putInt("forward_source_uin_type", this.f.a);
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.e, paramChatMessage, 21);
        return;
      }
      break;
    case 2131432813: 
      b(paramChatMessage);
      return;
    case 2131431695: 
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    case 2131431492: 
      if (paramChatMessage.msg != null) {
        try
        {
          ((ClipboardManager)this.e.getSystemService("clipboard")).setText(paramChatMessage.msg);
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
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.e.getResources().getDimensionPixelSize(2131296616);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), w, i, x);
      return;
    }
    paramView.setPadding(i, w, BaseChatItemLayout.getBubblePaddingAlignError(), x);
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
      localObject = new Intent(this.e, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("title", paramString2);
      ((Intent)localObject).putExtra("url", paramString1);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramMessageForArkFlashChat, (Intent)localObject, paramString1);
      this.e.startActivity((Intent)localObject);
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
    paramString2 = this.e.getPackageManager();
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
      ((StartAppCheckHandler)this.d.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER)).b(paramString1[0].trim(), this.e, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      break label170;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
    }
    this.e.startActivity(paramString2);
    return true;
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    Object localObject = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
    localQQCustomMenu.a(2131431492, HardCodeUtil.a(2131898924), 2130839057);
    if (localObject != null)
    {
      paramView = (MessageForArkFlashChat)((ChatItemBuilder.BaseHolder)localObject).q;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        localQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
        if (paramView.isMultiMsg) {
          return localQQCustomMenu.d();
        }
        if (paramView.istroop == 0) {
          a(localQQCustomMenu, this.e, 2131444634, ((ChatItemBuilder.BaseHolder)localObject).q, null);
        }
        if ((paramView.isSend()) && (paramView.extraflag != 32768) && (!this.d.getMsgCache().f(paramView))) {
          a(localQQCustomMenu, this.e, 2131438943, paramView, new Bundle());
        }
        a(localQQCustomMenu, this.e, 2131431695, paramView, new Bundle());
        super.a(localQQCustomMenu, this.e, 2131439015, null, null);
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("isSearch", false);
        super.a(localQQCustomMenu, this.e, 2131449133, paramView, (Bundle)localObject);
        super.a(localQQCustomMenu, this.e, 2131428089, null, null);
        return localQQCustomMenu.d();
      }
    }
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = (MessageForArkFlashChat)AIOUtils.a(paramView);
    if (paramView == null) {
      return;
    }
    String str1 = this.e.getString(2131886574);
    String str2 = this.e.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.e, 230, str1, str2, new ArkFlashChatItemBubbleBuilder.4(this, paramView), new ArkFlashChatItemBubbleBuilder.5(this)).show();
    }
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    QfavBuilder.a(null, paramChatMessage.msg).b(this.d, paramChatMessage).a((Activity)this.e, this.d.getAccount());
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    if ((paramChatMessage instanceof MessageForArkFlashChat))
    {
      paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131898926));
      localStringBuilder.append(paramChatMessage.ark_app_message.promptText);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131898925));
    localStringBuilder.append(paramChatMessage.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */