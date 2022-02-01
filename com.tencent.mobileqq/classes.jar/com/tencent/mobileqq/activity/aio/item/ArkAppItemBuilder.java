package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.ark.api.ArkCommonUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppItemBuilder
  extends BaseBubbleBuilder
{
  private int a;
  private SessionInfo b;
  
  public ArkAppItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = paramSessionInfo;
  }
  
  private String a(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp != null)
    {
      paramMessageForArkApp = paramMessageForArkApp.ark_app_message;
      if (paramMessageForArkApp != null) {
        return paramMessageForArkApp.mSourceAd;
      }
    }
    return "";
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    if (("2747277822".equals(paramMessageForArkApp.frienduin)) && (paramMessageForArkApp.ark_app_message != null)) {}
    for (;;)
    {
      try
      {
        boolean bool = paramContext instanceof Activity;
        int j = 0;
        int i = j;
        if (bool)
        {
          i = j;
          if (((Activity)paramContext).getIntent().getIntExtra("qqgame_msg_scene_key", 0) == 2) {
            i = 1;
          }
        }
        JSONObject localJSONObject = new JSONObject(paramMessageForArkApp.ark_app_message.metaList);
        IQQGameHelper localIQQGameHelper = (IQQGameHelper)QRoute.api(IQQGameHelper.class);
        String str = paramMessageForArkApp.ark_app_message.appName;
        long l = paramMessageForArkApp.uniseq;
        if (i == 0) {
          break label182;
        }
        paramContext = "5";
        if (localIQQGameHelper.addQQGameArkField(str, String.valueOf(l), paramContext, localJSONObject) != null)
        {
          paramMessageForArkApp.ark_app_message.metaList = localJSONObject.toString();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramMessageForArkApp = new StringBuilder();
        paramMessageForArkApp.append("addQQGameArkField error:");
        paramMessageForArkApp.append(paramContext.getMessage());
        QLog.e("ArkAppItemBuilder", 1, paramMessageForArkApp.toString());
        paramContext.printStackTrace();
      }
      return;
      label182:
      paramContext = "4";
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, ArkAppMessage.Config paramConfig, View paramView)
  {
    int j = AIOUtils.b(352.0F, paramView.getResources());
    int i;
    if (MessageForArkApp.isSetHintSizeByConfig(paramConfig))
    {
      i = AIOUtils.b(paramConfig.hintWidth.intValue(), paramView.getResources());
      j = AIOUtils.b(paramConfig.hintHeight.intValue(), paramView.getResources());
    }
    else
    {
      i = -1;
    }
    paramMessageForArkApp.arkContainer.setHintSize(i, j);
    paramMessageForArkApp.arkContainer.a(this.jdField_a_of_type_Int, j);
  }
  
  private boolean a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optString("from");
      return "gw".equals(paramString);
    }
    catch (JSONException paramString) {}
    return false;
  }
  
  private void b(MessageForArkApp paramMessageForArkApp, ArkAppMessage.Config paramConfig, View paramView)
  {
    if (MessageForArkApp.isSetSizeByConfig(paramConfig))
    {
      paramConfig = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.a(), paramConfig.width.intValue(), paramConfig.height.intValue(), -1, -1, this.jdField_a_of_type_Int, -1);
      paramMessageForArkApp.arkContainer.setFixSize(paramConfig.width, paramConfig.height);
    }
    else
    {
      paramMessageForArkApp.arkContainer.setFixSize(this.jdField_a_of_type_Int, -1);
    }
    paramMessageForArkApp.arkContainer.setMaxSize(this.jdField_a_of_type_Int, -1);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int i = BaseChatItemLayout.jdField_b_of_type_Int;
    int j = BaseChatItemLayout.c;
    Object localObject1 = Boolean.valueOf(false);
    if ((i > j) && (QLog.isColorLevel())) {
      QLog.e("ArkAppItemBuilder", 2, String.format(Locale.CHINA, "widthPixels > heightPixels: (%d, %d)", new Object[] { Integer.valueOf(BaseChatItemLayout.jdField_b_of_type_Int), Integer.valueOf(BaseChatItemLayout.c) }));
    }
    paramBaseChatItemLayout.setProgressVisable(false);
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    paramBaseChatItemLayout.setHeadIconVisible(false);
    paramBaseChatItemLayout.setNetIconVisible(false);
    Object localObject2 = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.j);
    if ((localObject2 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject2).checkViewNonNull())) {
      ((BaseChatItemLayoutViewBasicAbility)localObject2).setData(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1, null, localObject1, Integer.valueOf(-1), Integer.valueOf(-1) });
    }
    localObject1 = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.i);
    if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull())) {
      ((BaseChatItemLayoutViewBasicAbility)localObject1).setViewVisibility(8);
    }
    paramBaseChatItemLayout.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_Int = (ArkAppCenterUtil.d - BaseChatItemLayout.t - BaseChatItemLayout.u);
    localObject2 = (MessageForArkApp)paramChatMessage;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("ArkFold.ArkAppCenterUtil.sRealDisplayWith=");
    ((StringBuilder)localObject3).append(ArkAppCenterUtil.d);
    ((StringBuilder)localObject3).append(",arkAppWidth=");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject3).append(",app=");
    if (((MessageForArkApp)localObject2).ark_app_message != null) {
      localObject1 = ((MessageForArkApp)localObject2).ark_app_message.appName;
    } else {
      localObject1 = "(null)";
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.i("ArkAppItemBuilder", 1, ((StringBuilder)localObject3).toString());
    localObject1 = (ArkAppItemBubbleBuilder.Holder)paramViewHolder;
    localObject3 = a((MessageForArkApp)localObject2);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558797, null);
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362947));
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362956));
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362955));
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362957));
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localObject1);
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370350));
      paramViewHolder = paramView;
      if (a((String)localObject3))
      {
        ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder = paramView;
      }
    }
    else
    {
      paramViewHolder = paramView;
    }
    if (((MessageForArkApp)localObject2).ark_app_message == null)
    {
      QLog.i("ArkAppItemBuilder", 1, "getBubbleView, ark_app_message is null");
      return paramViewHolder;
    }
    i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296425);
    j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296377);
    int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296426);
    int m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296376);
    paramView = (RelativeLayout)paramViewHolder.findViewById(2131362973);
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).addRule(14);
    paramView.setPadding(i, j, k, m);
    if (((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView != null) {
      if (((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).getAdSourceView(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject2, ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView, (String)localObject3))
      {
        paramView.removeView(((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView);
        paramView.addView(((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView);
        paramView = (RelativeLayout.LayoutParams)((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        paramView.topMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
        paramView.height = -2;
        paramView.width = -2;
        paramView.addRule(3, 2131362947);
      }
      else
      {
        paramView.removeView(((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_AndroidWidgetTextView);
      }
    }
    if (((MessageForArkApp)localObject2).ark_app_message != null)
    {
      paramView = ((MessageForArkApp)localObject2).ark_app_message.config;
      if (!StringUtil.a(paramView))
      {
        localObject3 = new ArkAppMessage.Config();
        ((ArkAppMessage.Config)localObject3).fromString(paramView);
        if ((((ArkAppMessage.Config)localObject3).fitWidthAndCentered != null) && (((ArkAppMessage.Config)localObject3).fitWidthAndCentered.intValue() == 1) && ((paramViewHolder instanceof ArkAppRootLayout)))
        {
          paramView = (RelativeLayout.LayoutParams)paramViewHolder.getLayoutParams();
          if (paramView != null) {
            paramView.addRule(14);
          }
        }
      }
    }
    a(paramViewHolder.getContext(), (MessageForArkApp)localObject2);
    if (((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      paramView = (RelativeLayout.LayoutParams)((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.addRule(14);
      paramView.width = this.jdField_a_of_type_Int;
      paramView.setMargins(i, j, k, m);
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
    }
    if (((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    paramView = new ArkAppItemBuilder.1(this, (MessageForArkApp)localObject2, (ArkAppItemBubbleBuilder.Holder)localObject1);
    ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramView);
    if (ArkTipsManager.a().a(paramChatMessage.uniseq)) {
      ((MessageForArkApp)localObject2).arkContainer = ArkTipsManager.a().a();
    }
    if (((MessageForArkApp)localObject2).arkContainer == null) {
      ((MessageForArkApp)localObject2).arkContainer = new ArkAioContainerWrapper();
    }
    ((MessageForArkApp)localObject2).arkContainer.a(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBuilder", 2, new Object[] { "multiAio.ArkAppItemBuilder set session info =", ArkCommonUtil.a(this.b) });
    }
    ((MessageForArkApp)localObject2).arkContainer.a(((MessageForArkApp)localObject2).ark_app_message.appName, ((MessageForArkApp)localObject2).ark_app_message.appView, ((MessageForArkApp)localObject2).ark_app_message.appMinVersion, ((MessageForArkApp)localObject2).ark_app_message.metaList, ArkAppCenterUtil.a(), (MessageForArkApp)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramView = new ArkAppMessage.Config();
    paramView.fromString(((MessageForArkApp)localObject2).ark_app_message.config);
    b((MessageForArkApp)localObject2, paramView, paramBaseChatItemLayout);
    a((MessageForArkApp)localObject2, paramView, paramBaseChatItemLayout);
    ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_JavaLangString = ((MessageForArkApp)localObject2).msg;
    paramView = ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    paramBaseChatItemLayout = ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localObject3 = ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    paramBaseChatItemLayout.setClipRadius(16.0F);
    ((ArkAppContainer.ArkViewExtraInterface)localObject3).a(((MessageForArkApp)localObject2).arkContainer, paramView);
    paramBaseChatItemLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (paramView != null)
    {
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq))))
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
      PublicAccountEventReport.a(117, paramChatMessage, ((ArkAppItemBubbleBuilder.Holder)localObject1).jdField_b_of_type_Int);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppItemBubbleBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      if (paramInt != 2131367180)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      if (paramChatMessage != null)
      {
        if (paramChatMessage.ark_app_message == null) {
          return;
        }
        MessageForArkApp localMessageForArkApp = (MessageForArkApp)ArkAppCenterCheckEvent.a(1, paramChatMessage.ark_app_message.appName, paramChatMessage, paramChatMessage);
        paramContext = localMessageForArkApp;
        if (localMessageForArkApp == null) {
          paramContext = paramChatMessage;
        }
        if (paramContext != null)
        {
          if (paramContext.ark_app_message == null) {
            return;
          }
          new Bundle();
          paramChatMessage = QQCustomArkDialog.AppInfo.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, ArkAppCenterUtil.a(), null, null);
          paramChatMessage.putInt("forward_type", 27);
          paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
          paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
          paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
          paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
          paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
          paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
          paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
          paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
          paramChatMessage.putInt("selection_mode", this.c);
          paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramContext = new Intent();
          paramContext.putExtras(paramChatMessage);
          paramContext.putExtra("is_ark_display_share", true);
          ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
        }
      }
    }
    else
    {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if (MessageForArkApp.isAllowedArkForward(true, paramView)) {
        localQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
      }
      if (paramView.isMultiMsg) {
        return localQQCustomMenu.a();
      }
    }
    localQQCustomMenu.a(2131365480, this.jdField_a_of_type_AndroidContentContext.getString(2131690788), 2130838907);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder
 * JD-Core Version:    0.7.0.1
 */