package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArkAppMultiItemBubbleBuilder
  extends TextItemBuilder
{
  public ArkAppMultiItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private MessageForArkApp a(MessageForArkApp paramMessageForArkApp, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.isMultiItemMsg = true;
    localMessageForArkApp.compatibleMsg = paramMessageForArkApp.compatibleMsg;
    localMessageForArkApp.ark_app_message = paramArkAppMessage;
    localMessageForArkApp.issend = paramMessageForArkApp.issend;
    return localMessageForArkApp;
  }
  
  private String a(ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return null;
    }
    if (paramArkAppMessage.mAppList != null)
    {
      if (paramArkAppMessage.mAppList.isEmpty()) {
        return null;
      }
      try
      {
        localObject = new JSONArray();
        paramArkAppMessage = paramArkAppMessage.mAppList.iterator();
        while (paramArkAppMessage.hasNext()) {
          ((JSONArray)localObject).put(new JSONObject(((ArkAppMessage)paramArkAppMessage.next()).toAppXml()));
        }
        paramArkAppMessage = ((JSONArray)localObject).toString();
        return paramArkAppMessage;
      }
      catch (Exception paramArkAppMessage)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getArrayFromArkAppMessage catch error : ");
        ((StringBuilder)localObject).append(paramArkAppMessage.getMessage());
        QLog.e("ChatItemBuilder", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramMessageForArkApp.ark_app_message == null) {
        return;
      }
      Object localObject = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp, paramMessageForArkApp);
      if (localObject != null) {
        paramMessageForArkApp = (MessageForArkApp)localObject;
      }
      if (paramMessageForArkApp != null)
      {
        if (paramMessageForArkApp.ark_app_message == null) {
          return;
        }
        int i = paramMessageForArkApp.getMsgArkAppCount();
        localObject = new Intent();
        if (i == 1)
        {
          paramContext = QQCustomArkDialog.AppInfo.a(paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp.ark_app_message.appView, paramMessageForArkApp.ark_app_message.appMinVersion, paramMessageForArkApp.ark_app_message.metaList, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
          ((Intent)localObject).putExtra("is_ark_display_share", true);
        }
        else
        {
          paramContext = new Bundle();
        }
        paramContext.putInt("forward_type", 27);
        paramContext.putString("forward_ark_app_name", paramMessageForArkApp.ark_app_message.appName);
        paramContext.putString("forward_ark_app_view", paramMessageForArkApp.ark_app_message.appView);
        paramContext.putString("forward_ark_app_ver", paramMessageForArkApp.ark_app_message.appMinVersion);
        paramContext.putString("forward_ark_app_prompt", paramMessageForArkApp.ark_app_message.promptText);
        paramContext.putString("forward_ark_app_config", paramMessageForArkApp.ark_app_message.config);
        paramContext.putString("forward_ark_app_desc", paramMessageForArkApp.ark_app_message.appDesc);
        paramContext.putString("forward_ark_app_compat", paramMessageForArkApp.ark_app_message.compatibleText);
        paramContext.putString("forward_ark_app_meta", paramMessageForArkApp.ark_app_message.metaList);
        paramContext.putString("forward_ark_app_text", paramMessageForArkApp.ark_app_message.mText);
        paramContext.putString("forward_ark_app_list", a(paramMessageForArkApp.ark_app_message));
        paramContext.putString("forward_appId_ark_from_sdk", paramMessageForArkApp.ark_app_message.appId);
        paramContext.putString("struct_share_key_source_name", paramMessageForArkApp.ark_app_message.mSourceName);
        paramContext.putString("struct_share_key_source_action_data", paramMessageForArkApp.ark_app_message.mSourceActionData);
        paramContext.putString("struct_share_key_source_a_action_data", paramMessageForArkApp.ark_app_message.mSource_A_ActionData);
        paramContext.putString("struct_share_key_source_url", paramMessageForArkApp.ark_app_message.mSourceUrl);
        paramContext.putInt("selection_mode", this.c);
        ((Intent)localObject).putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      }
    }
  }
  
  private void a(ArkAppMultiItemBubbleBuilder.ArkAppMultiItemHolder paramArkAppMultiItemHolder, MessageForArkApp paramMessageForArkApp)
  {
    if ((e) && (paramArkAppMultiItemHolder != null) && (paramMessageForArkApp != null))
    {
      if ((paramArkAppMultiItemHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (paramArkAppMultiItemHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        paramArkAppMultiItemHolder.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
      }
      paramMessageForArkApp = a(paramMessageForArkApp);
      paramArkAppMultiItemHolder.d.setContentDescription(paramMessageForArkApp);
    }
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    if (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isDebugMode()) {
      return;
    }
    paramQQCustomMenu.a(2131362949, this.jdField_a_of_type_AndroidContentContext.getString(2131690165), 2130838922);
    paramQQCustomMenu.a(2131362951, this.jdField_a_of_type_AndroidContentContext.getString(2131690164), 2130838922);
  }
  
  private void b(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.a(paramContext, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  private void c(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp.arkContainer != null) {
      paramMessageForArkApp = paramMessageForArkApp.arkContainer.b();
    } else {
      paramMessageForArkApp = "not loaded";
    }
    QQToast.a(paramContext, paramMessageForArkApp, 2000).a();
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    localMessageForArkApp.isMultiItemMsg = true;
    boolean bool = paramChatMessage.isSend();
    paramView = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (ArkAppMultiItemBubbleBuilder.ArkAppMultiItemHolder)paramView.getTag();
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1 = new ArkAppMessage.Config();
    ((ArkAppMessage.Config)localObject1).fromString(localMessageForArkApp.ark_app_message.config);
    if (MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1))
    {
      paramInt1 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.a(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue()).height;
      paramInt2 = AIOUtils.b(29.0F, paramChatMessage);
    }
    else
    {
      paramInt1 = ArkAppCenterUtil.a;
      paramInt2 = AIOUtils.b(29.0F, paramChatMessage);
    }
    localObject1 = new RelativeLayout.LayoutParams(-1, paramInt1 + paramInt2);
    Object localObject2 = (HeadIconWrapper)paramView.a(HeadIconWrapper.class);
    int i = 0;
    if (localObject2 != null)
    {
      localObject2 = ((HeadIconWrapper)localObject2).a();
      if (localObject2 != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((BaseChatItemLayoutViewBasicAbility)localObject2).getLayoutParams();
        if ((true ^ TextUtils.isEmpty(localMessageForArkApp.ark_app_message.mText)))
        {
          paramViewGroup.d.setText(localMessageForArkApp.ark_app_message.mText);
          paramViewGroup.d.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364521);
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131364530);
          ((RelativeLayout.LayoutParams)localObject1).topMargin = (localLayoutParams.height / 2);
          paramViewGroup.d.setVisibility(8);
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
        paramView.setPadding(0, BaseChatItemLayout.v, 0, BaseChatItemLayout.i + BaseChatItemLayout.l);
        if (bool)
        {
          localLayoutParams.rightMargin = BaseChatItemLayout.o;
        }
        else if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
        {
          paramInt1 = AIOUtils.b(30.0F, paramChatMessage);
          localLayoutParams.leftMargin = (BaseChatItemLayout.t + paramInt1);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - BaseChatItemLayout.t);
        }
        else
        {
          localLayoutParams.leftMargin = BaseChatItemLayout.o;
        }
        localLayoutParams.addRule(10, 0);
        localLayoutParams.addRule(3, paramView.a());
        localLayoutParams.topMargin = paramChatMessage.getDimensionPixelSize(2131296413);
        ((BaseChatItemLayoutViewBasicAbility)localObject2).setLayoutParams(localLayoutParams);
      }
    }
    if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
    {
      localObject2 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.t;
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    if ((paramView.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramView.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
    {
      localObject2 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      if (bool) {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.u;
      } else if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (AIOUtils.b(25.0F, paramView.getResources()) + BaseChatItemLayout.t);
      } else {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.t;
      }
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    int k = BaseChatItemLayout.o * 2 + AIOUtils.b(40.0F, paramChatMessage) + paramChatMessage.getDimensionPixelSize(2131296383);
    int j = paramChatMessage.getDimensionPixelSize(2131296375);
    paramInt1 = BaseChatItemLayout.d - k - BaseChatItemLayout.e - j;
    if (bool) {
      paramInt2 = paramInt1;
    } else {
      paramInt2 = k - j;
    }
    if (bool) {
      paramInt1 = k - j;
    }
    if ((localMessageForArkApp.ark_app_message.mAppList != null) && (!localMessageForArkApp.ark_app_message.mAppList.isEmpty()) && (localMessageForArkApp.mExtendMsgArkAppList.isEmpty()))
    {
      paramChatMessage = localMessageForArkApp.ark_app_message.mAppList.iterator();
      while (paramChatMessage.hasNext())
      {
        localObject2 = (ArkAppMessage)paramChatMessage.next();
        ((ArkAppMessage)localObject2).config = localMessageForArkApp.ark_app_message.config;
        localMessageForArkApp.mExtendMsgArkAppList.add(a(localMessageForArkApp, (ArkAppMessage)localObject2));
      }
    }
    if (paramViewGroup.a == null)
    {
      localObject2 = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      ((ArkHorizontalListView)localObject2).MIN_SPACE = (BaseChatItemLayout.d / 4);
      ((ArkHorizontalListView)localObject2).setDividerWidth(j);
      paramChatMessage = new ArkHorizontalListViewAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkHorizontalListView)localObject2, paramOnLongClickAndTouchListener);
      ((ArkHorizontalListView)localObject2).setAdapter(paramChatMessage);
      paramViewGroup.a = ((ArkHorizontalListView)localObject2);
      paramViewGroup.a.setTag(localMessageForArkApp);
      paramView.addView(paramViewGroup.a, 0, (ViewGroup.LayoutParams)localObject1);
    }
    else
    {
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.a.setTag(localMessageForArkApp);
      paramChatMessage = (ArkHorizontalListViewAdapter)paramViewGroup.a.getAdapter();
    }
    paramViewGroup.a.setIsSend(bool);
    paramChatMessage.a(paramInt2, paramInt1);
    paramViewGroup.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
    paramInt2 = localMessageForArkApp.getMsgArkAppCount();
    paramChatMessage.a(paramChatMessage.a() - paramInt2);
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      paramOnLongClickAndTouchListener = localMessageForArkApp.getMsgArkAppByPosition(paramInt1);
      if ((MessageForArkApp)paramChatMessage.b(paramInt1) == null) {
        paramChatMessage.a(paramOnLongClickAndTouchListener);
      } else {
        paramChatMessage.b(paramInt1, paramOnLongClickAndTouchListener);
      }
      paramInt1 += 1;
    }
    a(paramViewGroup, localMessageForArkApp);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppMultiItemBubbleBuilder.ArkAppMultiItemHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return ((MessageForArkApp)paramChatMessage).compatibleMsg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131367180)
    {
      a(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    if (paramInt == 2131362949)
    {
      b(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    if (paramInt == 2131362951)
    {
      c(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        a(localQQCustomMenu);
        if (MessageForArkApp.isAllowedArkForward(false, paramView)) {
          localQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
        }
        if (paramView.isMultiMsg) {
          return localQQCustomMenu.a();
        }
        boolean bool3 = TextUtils.isEmpty(paramView.ark_app_message.appName);
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (paramView.extraflag != 32768)
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))
          {
            bool1 = bool2;
            if (!(bool3 ^ true))
            {
              Boolean localBoolean = (Boolean)ArkAppCenterCheckEvent.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool1 = localBoolean.booleanValue();
              } else {
                bool1 = true;
              }
              if (bool1) {
                a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramView, new Bundle());
              }
            }
          }
        }
        if (bool1) {
          a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramView, new Bundle());
        } else {
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        }
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
        return localQQCustomMenu.a();
      }
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppMultiItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */