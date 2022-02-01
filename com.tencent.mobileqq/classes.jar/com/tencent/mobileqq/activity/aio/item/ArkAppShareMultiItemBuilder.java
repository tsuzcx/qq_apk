package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListView.RefreshUiCallback;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.open.sdk.report.SdkShareReporter.ArkReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.List;

public class ArkAppShareMultiItemBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener, ContextMenuBuilder2, ArkHorizontalListView.RefreshUiCallback
{
  private List<MessageForArkApp> a = new ArrayList();
  
  public ArkAppShareMultiItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private RelativeLayout.LayoutParams a(BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.width = -1;
    localLayoutParams1.height = (ArkAppCenterUtil.a + AIOUtils.b(29.0F, this.e.getResources()));
    localLayoutParams1.leftMargin = 0;
    paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, 0, BaseChatItemLayout.l + BaseChatItemLayout.m);
    Object localObject1 = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
    if (localObject1 != null)
    {
      Object localObject2 = ((HeadIconWrapper)localObject1).c();
      int i;
      if (localObject2 != null)
      {
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams();
        if (paramBoolean)
        {
          localLayoutParams2.rightMargin = this.e.getResources().getDimensionPixelSize(2131296617);
        }
        else if ((paramBaseChatItemLayout.ac != null) && (paramBaseChatItemLayout.ac.getVisibility() != 8))
        {
          i = MessageForArkApp.dp2px(30.0F);
          localLayoutParams2.leftMargin = (BaseChatItemLayout.s + i);
          localLayoutParams1.leftMargin = (i - BaseChatItemLayout.s);
        }
        else
        {
          localLayoutParams2.leftMargin = this.e.getResources().getDimensionPixelSize(2131296617);
        }
        ((BaseChatItemLayoutViewBasicAbility)localObject2).setLayoutParams(localLayoutParams2);
      }
      localObject1 = ((IHeadIconProcessor)((HeadIconWrapper)localObject1).a()).b();
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull()))
      {
        localObject2 = (RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject1).getLayoutParams();
        i = MessageForArkApp.dp2px(1.0F);
        if (paramBoolean)
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131430587);
          ((RelativeLayout.LayoutParams)localObject2).rightMargin = (-i);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131430587);
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = (-i);
        }
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    if ((paramBaseChatItemLayout.ac != null) && (paramBaseChatItemLayout.ac.getVisibility() != 8))
    {
      localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.ac.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.s;
      paramBaseChatItemLayout.ac.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if ((paramBaseChatItemLayout.ae != null) && (paramBaseChatItemLayout.ae.getVisibility() != 8))
    {
      localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.ae.getLayoutParams();
      if (paramBoolean) {
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = BaseChatItemLayout.t;
      } else if ((paramBaseChatItemLayout.ac != null) && (paramBaseChatItemLayout.ac.getVisibility() != 8)) {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (MessageForArkApp.dp2px(25.0F) + BaseChatItemLayout.s);
      } else {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.s;
      }
      paramBaseChatItemLayout.ae.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    return localLayoutParams1;
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.a(paramContext, paramMessageForArkApp, this.f.a);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131430578);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131430578);
      localLayoutParams.leftMargin = paramInt3;
    }
    else
    {
      localLayoutParams.addRule(7, 2131430578);
      localLayoutParams.rightMargin = paramInt3;
    }
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.a.contains(paramMessageForArkApp))
    {
      SdkShareReporter.a(paramMessageForArkApp);
      this.a.add(paramMessageForArkApp);
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    if (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isDebugMode()) {
      return;
    }
    paramQQCustomMenu.a(2131428748, this.e.getString(2131887064), 2130839076);
    paramQQCustomMenu.a(2131428750, this.e.getString(2131887063), 2130839076);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopTodoUtils.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131430283, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131430651, paramChatMessage, null);
    }
  }
  
  private void b(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp.arkContainer != null) {
      paramMessageForArkApp = paramMessageForArkApp.arkContainer.e();
    } else {
      paramMessageForArkApp = "not loaded";
    }
    QQToast.makeText(paramContext, paramMessageForArkApp, 2000).show();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = (ArkAppShareMultiItemBuilder.ShareMultiHolder)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.h.getLayoutParams();
    paramOnLongClickAndTouchListener = paramChatMessage.a(NickNameChatItemLayoutProcessor.h);
    if (paramOnLongClickAndTouchListener != null) {
      if ((paramOnLongClickAndTouchListener.checkViewNonNull()) && (paramOnLongClickAndTouchListener.getViewVisibility() == 0))
      {
        paramViewGroup.addRule(3, 2131430596);
        paramViewGroup.topMargin = BaseChatItemLayout.k;
      }
      else
      {
        paramViewGroup.addRule(6, 2131430587);
        paramViewGroup.topMargin = 0;
      }
    }
    paramView.h.setLayoutParams(paramViewGroup);
    return paramChatMessage;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForArkApp localMessageForArkApp1 = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp1.isSend();
    Object localObject1 = a(paramBaseChatItemLayout, bool);
    Resources localResources = this.e.getResources();
    int k = BaseChatItemLayout.getTextPaddingAlignHead() * 2 + MessageForArkApp.dp2px(40.0F) + localResources.getDimensionPixelSize(2131296615);
    int m = localResources.getDimensionPixelSize(2131296605);
    int i = ArkAppCenterUtil.d - k - ArkAppCenterUtil.a - m;
    if (bool) {
      j = i;
    } else {
      j = k - m;
    }
    if (bool) {
      k -= m;
    } else {
      k = i;
    }
    QLog.d("ArkAppShareMultiItemBuilder", 1, new Object[] { "ArkFold.appName:", localMessageForArkApp1.ark_app_message.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(ArkAppCenterUtil.a), ", displaywitdh=", Integer.valueOf(ArkAppCenterUtil.c), ", headerWidth=", Integer.valueOf(j), ",footerWidth=", Integer.valueOf(k) });
    ArkAppShareMultiItemBuilder.ShareMultiHolder localShareMultiHolder = (ArkAppShareMultiItemBuilder.ShareMultiHolder)paramViewHolder;
    paramView = (ArkHorizontalListView)paramView;
    if (paramView == null)
    {
      paramView = new ArkHorizontalListView(this.e);
      paramView.setDividerWidth(m);
      paramOnLongClickAndTouchListener = new ArkHorizontalListViewAdapter(this.e, this.f, paramView, paramOnLongClickAndTouchListener);
      paramView.setAdapter(paramOnLongClickAndTouchListener);
    }
    else
    {
      paramOnLongClickAndTouchListener = (ArkHorizontalListViewAdapter)paramView.getAdapter();
    }
    paramView.setIsSend(bool);
    paramView.MIN_SPACE = (ArkAppCenterUtil.c / 4);
    paramOnLongClickAndTouchListener.a(j, k);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramView.setRefreshCallback(this);
    paramView.setTag(localShareMultiHolder);
    localShareMultiHolder.a = localMessageForArkApp1.msg;
    localShareMultiHolder.j.setMiniAioShieldItemTouchListener(this);
    k = localMessageForArkApp1.getMsgArkAppCount();
    paramOnLongClickAndTouchListener.c(paramOnLongClickAndTouchListener.a() - k);
    localObject1 = null;
    int j = 0;
    while (j < k)
    {
      MessageForArkApp localMessageForArkApp2 = localMessageForArkApp1.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)paramOnLongClickAndTouchListener.b(j) == null) {
        paramOnLongClickAndTouchListener.a(localMessageForArkApp2);
      } else {
        paramOnLongClickAndTouchListener.b(j, localMessageForArkApp2);
      }
      Object localObject2 = localObject1;
      if (localMessageForArkApp2 != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(localMessageForArkApp2.ark_app_message.appName))
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localMessageForArkApp2.ark_app_message.appName;
          }
        }
      }
      j += 1;
      localObject1 = localObject2;
    }
    a(paramView);
    if (paramOnLongClickAndTouchListener.a() == 1)
    {
      int n;
      if (paramBaseChatItemLayout.ag != null)
      {
        j = MessageForArkApp.dp2px(16.0F);
        k = MessageForArkApp.dp2px(47.0F);
        m = localResources.getDimensionPixelSize(2131296615);
        n = BaseChatItemLayout.s;
        a(paramBaseChatItemLayout.ag, j, k, i - j - m - n, bool);
      }
      if (paramBaseChatItemLayout.ah != null)
      {
        j = MessageForArkApp.dp2px(24.0F);
        k = MessageForArkApp.dp2px(45.0F);
        m = localResources.getDimensionPixelSize(2131296615);
        n = BaseChatItemLayout.s;
        a(paramBaseChatItemLayout.ah, j, k, i - j - m - n, bool);
      }
    }
    if (v)
    {
      paramOnLongClickAndTouchListener = new StringBuilder();
      if ((localShareMultiHolder.r != null) && (localShareMultiHolder.r.length() > 0)) {
        paramOnLongClickAndTouchListener.append(localShareMultiHolder.r);
      }
      paramOnLongClickAndTouchListener.append(d(localMessageForArkApp1));
      paramView.setContentDescription(paramOnLongClickAndTouchListener);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Type is card, and talkbackText is ");
      ((StringBuilder)localObject1).append(paramOnLongClickAndTouchListener);
      ArkAppCenter.a("ArkAppShareMultiItemBuilder", ((StringBuilder)localObject1).toString());
    }
    ArkAsyncShareMsgManager.d(localMessageForArkApp1);
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).playShareMsgAction(this.d, this.f, paramChatMessage, paramViewHolder.l, paramViewHolder.m);
    a(localMessageForArkApp1);
    if (this.d != null)
    {
      if (TroopEssenceUtil.a(this.d, paramChatMessage, this.f.b))
      {
        localShareMultiHolder.b = super.a(localShareMultiHolder.b, localShareMultiHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
        super.a(localShareMultiHolder.b, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
        TroopEssenceReportUtil.a(this.d, localShareMultiHolder.b, this.f.b);
        return paramView;
      }
      if (localShareMultiHolder.b != null) {
        localShareMultiHolder.b.setVisibility(8);
      }
    }
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppShareMultiItemBuilder.ShareMultiHolder();
  }
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null) && (paramChatMessage.arkContainer.getErrorInfo() != null) && (MessageForArkApp.isAllowedArkForward(false, paramChatMessage))) {
      paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
    }
    return paramQQCustomMenu;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131433636: 
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      if (localMessageForArkApp != null)
      {
        if (localMessageForArkApp.ark_app_message == null) {
          return;
        }
        paramChatMessage = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, localMessageForArkApp.ark_app_message.appName, localMessageForArkApp, localMessageForArkApp);
        paramContext = paramChatMessage;
        if (paramChatMessage == null) {
          paramContext = localMessageForArkApp;
        }
        if (paramContext != null)
        {
          if (paramContext.ark_app_message == null) {
            return;
          }
          Intent localIntent = new Intent();
          if (paramContext.getMsgArkAppCount() >= 1)
          {
            paramChatMessage = QQCustomArkDialog.AppInfo.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, ArkAppCenterUtil.d(), null, null);
            localIntent.putExtra("is_ark_display_share", true);
          }
          else
          {
            paramChatMessage = new Bundle();
          }
          SdkShareReporter.ArkReportData localArkReportData = SdkShareReporter.c(paramContext);
          if (localArkReportData.c)
          {
            paramChatMessage.putString("forward_ark_app_type", localArkReportData.a);
            paramChatMessage.putString("forward_ark_app_title", localArkReportData.b);
            paramChatMessage.putInt("forward_ark_app_result", localArkReportData.e);
          }
          paramChatMessage.putInt("forward_type", 27);
          paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
          paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
          paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
          paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
          paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
          paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
          paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
          paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
          paramChatMessage.putString("forward_appId_ark_from_sdk", paramContext.ark_app_message.appId);
          paramChatMessage.putString("struct_share_key_source_name", paramContext.ark_app_message.mSourceName);
          paramChatMessage.putString("struct_share_key_source_action_data", paramContext.ark_app_message.mSourceActionData);
          paramChatMessage.putString("struct_share_key_source_a_action_data", paramContext.ark_app_message.mSource_A_ActionData);
          paramChatMessage.putString("struct_share_key_source_url", paramContext.ark_app_message.mSourceUrl);
          paramChatMessage.putInt("selection_mode", this.u);
          paramChatMessage.putInt("forward_source_uin_type", this.f.a);
          localIntent.putExtras(paramChatMessage);
          ForwardBaseOption.a((Activity)this.e, localIntent, 21);
          if (localMessageForArkApp.isMultiMsg)
          {
            ReportController.b(this.d, "dc00898", "", "", "0X8009D66", "0X8009D66", 11, 0, "11", "", "", "");
            return;
          }
        }
      }
      break;
    case 2131432813: 
      QfavBuilder.a(this.d, this.e, paramChatMessage);
      return;
    case 2131431695: 
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    case 2131428750: 
      b(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    case 2131428748: 
      a(paramContext, (MessageForArkApp)paramChatMessage);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ArkHorizontalListView paramArkHorizontalListView)
  {
    BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)paramArkHorizontalListView.getTag();
    if (localViewHolder != null)
    {
      if (!(localViewHolder instanceof ArkAppShareMultiItemBuilder.ShareMultiHolder)) {
        return;
      }
      HeadIconWrapper localHeadIconWrapper = (HeadIconWrapper)localViewHolder.j.a(HeadIconWrapper.class);
      if (localHeadIconWrapper != null)
      {
        Object localObject = localHeadIconWrapper.c();
        boolean bool = true;
        int j;
        if (localObject != null)
        {
          int[] arrayOfInt = new int[2];
          ((BaseChatItemLayoutViewBasicAbility)localObject).getLocationOnScreen(arrayOfInt);
          j = arrayOfInt[0];
          int k = ((BaseChatItemLayoutViewBasicAbility)localObject).getMeasuredWidth();
          int m = arrayOfInt[1];
          int n = ((BaseChatItemLayoutViewBasicAbility)localObject).getMeasuredHeight();
          int i1 = paramArkHorizontalListView.getChildCount();
          localObject = new int[2];
          i = 0;
          while (i < i1)
          {
            View localView = paramArkHorizontalListView.getChildAt(i);
            if (localView != null)
            {
              localView.getLocationOnScreen((int[])localObject);
              int i2 = localObject[0];
              int i3 = localView.getMeasuredWidth();
              int i4 = localObject[1];
              int i5 = localView.getMeasuredHeight();
              if (((localView instanceof LinearLayout)) && (i2 + i3 >= arrayOfInt[0]) && (localObject[0] <= j + k) && (i4 + i5 >= arrayOfInt[1]) && (localObject[1] <= m + n))
              {
                i = 1;
                break label228;
              }
            }
            i += 1;
          }
        }
        int i = 0;
        label228:
        if ((localViewHolder.j.ae != null) && (localViewHolder.j.ae.getVisibility() == 0)) {
          j = 1;
        } else {
          j = 0;
        }
        if ((i == 0) || (j != 0)) {
          bool = false;
        }
        if (localHeadIconWrapper != null) {
          ((IHeadIconProcessor)localHeadIconWrapper.a()).a(bool);
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (paramChatMessage == null) {
      return;
    }
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 0)) {
      if ((!paramChatMessage.senderuin.equals(this.d.getCurrentUin())) && (paramChatMessage.isSupportReply()))
      {
        if (((paramChatMessage instanceof MessageForArkApp)) && (((MessageForArkApp)paramChatMessage).msg != null)) {
          paramQQCustomMenu.a(2131444634, this.e.getString(2131895468), 2130839072);
        }
      }
      else if ((paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768) && ((paramChatMessage instanceof MessageForArkApp)) && (paramChatMessage.istroop != 3000) && (((MessageForArkApp)paramChatMessage).msg != null)) {
        paramQQCustomMenu.a(2131444634, this.e.getString(2131895468), 2130839072);
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
    if (paramView != null) {
      paramView = paramView.q;
    } else {
      paramView = null;
    }
    if ((paramView != null) && ((paramView instanceof MessageForArkApp)))
    {
      a(localQQCustomMenu);
      if (paramView.isMultiMsg) {
        a(localQQCustomMenu, paramView, null);
      } else {
        b(localQQCustomMenu, paramView, null);
      }
    }
    return localQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public QQCustomMenu b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage, ChatItemBuilder.BaseHolder paramBaseHolder)
  {
    paramBaseHolder = (MessageForArkApp)paramChatMessage;
    if ((paramBaseHolder != null) && (paramBaseHolder.ark_app_message != null) && (paramBaseHolder.arkContainer != null) && (paramBaseHolder.arkContainer.getErrorInfo() != null))
    {
      if (MessageForArkApp.isAllowedArkForward(false, paramBaseHolder)) {
        paramQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
      }
      boolean bool2;
      if ((paramBaseHolder.extraflag != 32768) && (!this.d.getMsgCache().f(paramBaseHolder)))
      {
        Boolean localBoolean = (Boolean)ArkAppCenterCheckEvent.a(3, paramBaseHolder.ark_app_message.appName, paramBaseHolder, Boolean.valueOf(true));
        boolean bool1;
        if (localBoolean != null) {
          bool1 = localBoolean.booleanValue();
        } else {
          bool1 = true;
        }
        bool2 = bool1;
        if (bool1)
        {
          a(paramQQCustomMenu, this.e, 2131438943, paramBaseHolder, new Bundle());
          bool2 = bool1;
        }
      }
      else
      {
        bool2 = true;
      }
      if (bool2) {
        a(paramQQCustomMenu, this.e, 2131431695, paramBaseHolder, new Bundle());
      } else {
        ChatActivityFacade.a(paramQQCustomMenu, this.e, this.f.a);
      }
      a(paramQQCustomMenu, paramBaseHolder);
      try
      {
        if (((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).canReply(paramBaseHolder.ark_app_message.appName, paramBaseHolder.ark_app_message.appView))
        {
          a(paramBaseHolder, paramQQCustomMenu);
          a(paramQQCustomMenu, this.e, 2131444651, paramBaseHolder, null);
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add reply menu error, exception =");
        localStringBuilder.append(localException.getMessage());
        QLog.d("ArkAppShareMultiItemBuilder", 2, localStringBuilder.toString());
      }
      super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
      if (QfavHelper.a(paramChatMessage)) {
        super.a(paramQQCustomMenu, this.e, 2131432813, null, null);
      }
      paramChatMessage = new Bundle();
      paramChatMessage.putBoolean("isSearch", false);
      super.a(paramQQCustomMenu, this.e, 2131449133, paramBaseHolder, paramChatMessage);
      super.a(paramQQCustomMenu, this.e, 2131428089, null, null);
      return paramQQCustomMenu;
    }
    ChatActivityFacade.a(paramQQCustomMenu, this.e, this.f.a);
    super.a(paramQQCustomMenu, this.e, 2131439015, null, null);
    super.a(paramQQCustomMenu, this.e, 2131428089, null, null);
    return paramQQCustomMenu;
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = (MessageForArkApp)AIOUtils.a(paramView);
    if (paramView == null) {
      return;
    }
    String str1 = this.e.getString(2131886574);
    String str2 = this.e.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.e, 230, str1, str2, new ArkAppShareMultiItemBuilder.1(this, paramView), new ArkAppShareMultiItemBuilder.2(this)).show();
    }
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
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if (localMessageForArkApp.ark_app_message != null)
    {
      if (localMessageForArkApp.ark_app_message.promptText == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
        localStringBuilder.append("发出");
      } else {
        localStringBuilder.append("发来");
      }
      localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
      if (localMessageForArkApp.arkContainer != null)
      {
        paramChatMessage = localMessageForArkApp.arkContainer.i;
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localStringBuilder.append(paramChatMessage);
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppShareMultiItemBuilder
 * JD-Core Version:    0.7.0.1
 */