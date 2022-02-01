package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.MiniAioShieldItemTouchListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterCheckEvent;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
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

public class ArkAppItemBubbleBuilder
  extends BaseBubbleBuilder
  implements BaseChatItemLayout.MiniAioShieldItemTouchListener
{
  private int jdField_a_of_type_Int;
  private List<MessageForArkApp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SessionInfo b = null;
  private int d;
  
  public ArkAppItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.b = paramSessionInfo;
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.a(paramContext, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  private void a(View paramView, MessageForArkApp paramMessageForArkApp)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageForArkApp))
    {
      SdkShareReporter.a(paramMessageForArkApp);
      if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).reportArkExposure(paramView.getContext(), paramMessageForArkApp);
      }
      this.jdField_a_of_type_JavaUtilList.add(paramMessageForArkApp);
    }
  }
  
  private void a(View paramView, MessageForArkApp paramMessageForArkApp, ArkAppItemBubbleBuilder.Holder paramHolder, ArkViewImplement.ArkViewInterface paramArkViewInterface)
  {
    if (e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if ((paramHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (paramHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        localStringBuilder.append(paramHolder.jdField_b_of_type_JavaLangStringBuilder);
      }
      localStringBuilder.append(a(paramMessageForArkApp));
      paramView.setContentDescription(localStringBuilder);
      paramArkViewInterface.setContentDescription(localStringBuilder);
      paramView = new StringBuilder();
      paramView.append("Type is normal, and talkbackText is ");
      paramView.append(localStringBuilder);
      QLog.i("ArkAppItemBubbleBuilder", 1, paramView.toString());
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.bottomMargin = MessageForArkApp.dp2px(55.0F);
      if (paramBoolean)
      {
        paramView.addRule(0, 2131364521);
        paramView.addRule(1, 0);
        return;
      }
      paramView.addRule(1, 2131364521);
      paramView.addRule(0, 0);
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ArkAppItemBubbleBuilder.Holder paramHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        paramHolder.c = super.a(paramHolder.c, paramHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(paramHolder.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
        TroopEssenceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramHolder.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramHolder.c != null) {
        paramHolder.c.setVisibility(8);
      }
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, ArkAppMessage.Config paramConfig)
  {
    boolean bool1;
    if ((paramConfig.autoSize != null) && (paramConfig.autoSize.intValue() == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = ArkAppCenterUtil.jdField_a_of_type_Int;
    int k = MessageForArkApp.dp2px(390.0F);
    boolean bool2 = MessageForArkApp.isSetSizeByConfig(paramConfig);
    StringBuilder localStringBuilder = new StringBuilder("isSetSize=");
    localStringBuilder.append(bool2);
    localStringBuilder.append(",param=[");
    Object localObject;
    if (bool2)
    {
      localObject = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.a(), paramConfig.width.intValue(), paramConfig.height.intValue());
      if (localObject != null)
      {
        if (bool1) {
          j = i;
        } else {
          j = ((MessageForArkApp.Size)localObject).width;
        }
        this.jdField_a_of_type_Int = j;
        this.d = ((MessageForArkApp.Size)localObject).height;
        paramMessageForArkApp.arkContainer.setFixSize(this.jdField_a_of_type_Int, this.d);
        localStringBuilder.append("arkConfig.width=");
        localStringBuilder.append(paramConfig.width);
        localStringBuilder.append(",arkConfig.height=");
        localStringBuilder.append(paramConfig.height);
        localStringBuilder.append("][autoSize=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",maxSize=");
        localStringBuilder.append(i);
        localStringBuilder.append("][size=");
        localStringBuilder.append(((MessageForArkApp.Size)localObject).width);
        localStringBuilder.append(",");
        localStringBuilder.append(((MessageForArkApp.Size)localObject).height);
        localStringBuilder.append("]");
        localStringBuilder.append("],app=");
        localStringBuilder.append(paramMessageForArkApp.ark_app_message.appName);
      }
    }
    else
    {
      if (bool1) {
        j = i;
      } else {
        j = -1;
      }
      this.jdField_a_of_type_Int = j;
      this.d = -1;
      localObject = paramMessageForArkApp.arkContainer;
      if (bool1) {
        j = i;
      } else {
        j = -1;
      }
      ((ArkAioContainerWrapper)localObject).setFixSize(j, -1);
      localStringBuilder.append("arkConfig.width=");
      localStringBuilder.append(paramConfig.width);
      localStringBuilder.append(",arkConfig.height=");
      localStringBuilder.append(paramConfig.height);
      localStringBuilder.append("][autoSize=");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",maxSize=");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      localStringBuilder.append(",app=");
      localStringBuilder.append(paramMessageForArkApp.ark_app_message.appName);
    }
    QLog.i("ArkAppItemBubbleBuilder", 1, localStringBuilder.toString());
    ArkAppCenterUtil.a("ArkAppItemBubbleBuilder.attachArkView", this.jdField_a_of_type_AndroidContentContext);
    int j = MessageForArkApp.dp2px(30.0F);
    int m = MessageForArkApp.dp2px(30.0F);
    paramMessageForArkApp.arkContainer.setMinSize(j, m);
    paramMessageForArkApp.arkContainer.setHintSize(-1, i);
    paramMessageForArkApp.arkContainer.a(i, i);
    paramMessageForArkApp.arkContainer.setMaxSize(i, k);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu)
  {
    if (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isDebugMode()) {
      return;
    }
    paramQQCustomMenu.a(2131362949, this.jdField_a_of_type_AndroidContentContext.getString(2131690165), 2130838922);
    paramQQCustomMenu.a(2131362951, this.jdField_a_of_type_AndroidContentContext.getString(2131690164), 2130838922);
  }
  
  private void a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366309, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366308, paramChatMessage, null);
    }
  }
  
  private boolean a(MessageForArkApp paramMessageForArkApp)
  {
    if (!ForwardSDKB77AIOHelper.a(paramMessageForArkApp))
    {
      QLog.d("ArkAppItemBubbleBuilder", 1, "showForbidShareDialog false");
      return false;
    }
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.x);
    QLog.d("ArkAppItemBubbleBuilder", 1, new Object[] { "resend forbid msg wording=", paramMessageForArkApp });
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setMessage(paramMessageForArkApp);
    localQQCustomDialog.setPositiveButton(2131694583, new ArkAppItemBubbleBuilder.4(this));
    try
    {
      localQQCustomDialog.show();
      return true;
    }
    catch (Exception paramMessageForArkApp)
    {
      QLog.e("ArkAppItemBubbleBuilder", 1, "Exception", paramMessageForArkApp);
    }
    return true;
  }
  
  private void b(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp.arkContainer != null) {
      paramMessageForArkApp = paramMessageForArkApp.arkContainer.b();
    } else {
      paramMessageForArkApp = "not loaded";
    }
    QQToast.a(paramContext, paramMessageForArkApp, 2000).a();
  }
  
  private void b(MessageForArkApp paramMessageForArkApp)
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
        Intent localIntent = new Intent();
        if (i == 1)
        {
          localObject = QQCustomArkDialog.AppInfo.a(paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp.ark_app_message.appView, paramMessageForArkApp.ark_app_message.appMinVersion, paramMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.a(), null, null);
          localIntent.putExtra("is_ark_display_share", true);
        }
        else
        {
          localObject = new Bundle();
        }
        SdkShareReporter.ArkReportData localArkReportData = SdkShareReporter.a(paramMessageForArkApp);
        if (localArkReportData.jdField_a_of_type_Boolean)
        {
          ((Bundle)localObject).putString("forward_ark_app_type", localArkReportData.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject).putString("forward_ark_app_title", localArkReportData.jdField_b_of_type_JavaLangString);
          ((Bundle)localObject).putInt("forward_ark_app_result", localArkReportData.jdField_a_of_type_Int);
        }
        ((Bundle)localObject).putInt("forward_type", 27);
        ((Bundle)localObject).putString("forward_ark_app_name", paramMessageForArkApp.ark_app_message.appName);
        ((Bundle)localObject).putString("forward_ark_app_view", paramMessageForArkApp.ark_app_message.appView);
        ((Bundle)localObject).putString("forward_ark_app_ver", paramMessageForArkApp.ark_app_message.appMinVersion);
        ((Bundle)localObject).putString("forward_ark_app_prompt", paramMessageForArkApp.ark_app_message.promptText);
        ((Bundle)localObject).putString("forward_ark_app_config", paramMessageForArkApp.ark_app_message.config);
        ((Bundle)localObject).putString("forward_ark_app_desc", paramMessageForArkApp.ark_app_message.appDesc);
        ((Bundle)localObject).putString("forward_ark_app_compat", paramMessageForArkApp.ark_app_message.compatibleText);
        ((Bundle)localObject).putString("forward_ark_app_meta", paramMessageForArkApp.ark_app_message.metaList);
        ((Bundle)localObject).putString("forward_appId_ark_from_sdk", paramMessageForArkApp.ark_app_message.appId);
        ((Bundle)localObject).putString("struct_share_key_source_name", paramMessageForArkApp.ark_app_message.mSourceName);
        ((Bundle)localObject).putString("struct_share_key_source_action_data", paramMessageForArkApp.ark_app_message.mSourceActionData);
        ((Bundle)localObject).putString("struct_share_key_source_a_action_data", paramMessageForArkApp.ark_app_message.mSource_A_ActionData);
        ((Bundle)localObject).putString("struct_share_key_source_url", paramMessageForArkApp.ark_app_message.mSourceUrl);
        ((Bundle)localObject).putInt("selection_mode", this.c);
        ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtras((Bundle)localObject);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
      }
    }
  }
  
  private boolean b(MessageForArkApp paramMessageForArkApp)
  {
    boolean bool = false;
    if (paramMessageForArkApp == null) {
      return false;
    }
    if (("com.tencent.test.troopapp".equals(paramMessageForArkApp.ark_app_message.appName)) || ("com.tencent.troopapp".equals(paramMessageForArkApp.ark_app_message.appName))) {
      bool = true;
    }
    return bool;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout.setHeadIconVisible(true);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(localMessageForArkApp.ark_app_message.config);
    ArkAppItemBubbleBuilder.Holder localHolder = (ArkAppItemBubbleBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558797, null);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362947));
      localHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362956));
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362955));
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362957));
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localHolder);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370350));
    }
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    if (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      localObject1 = (RelativeLayout.LayoutParams)localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ArkAppCenterUtil.jdField_a_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject1).height = ArkAppCenterUtil.jdField_a_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    paramView.findViewById(2131362973).setPadding(0, 0, 0, 0);
    a(localMessageForArkApp);
    if (localHolder.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      localHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (ArkTipsManager.a().a(paramChatMessage.uniseq)) {
      localMessageForArkApp.arkContainer = ArkTipsManager.a().a();
    }
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new ArkAioContainerWrapper();
    }
    localMessageForArkApp.arkContainer.a(this.b);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("multiAio.ArkAppItemBubbleBuilder set session info =");
      ((StringBuilder)localObject1).append(ArkAppQQModuleBase.a(this.b));
      QLog.d("ArkAppItemBubbleBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.a(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject2 = new ArkAppItemBubbleBuilder.1(this, localMessageForArkApp, localHolder);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject2);
    a(localMessageForArkApp, localConfig);
    localHolder.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
    localObject2 = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ArkAppView localArkAppView = localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ((ArkViewImplement.ArkViewInterface)localObject2).setClipRadius(16.0F);
    if (MessageForArkApp.isRectangleBorder(localConfig)) {
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(0);
    } else {
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(1);
    }
    ((ArkViewImplement.ArkViewInterface)localObject2).setAlignLeft(true ^ paramChatMessage.isSend());
    localArkAppView.a(localMessageForArkApp.arkContainer, (ArkAppLoadLayout)localObject1);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (localObject1 != null)
    {
      ((ArkAppLoadLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((ArkAppLoadLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    a(paramView, localMessageForArkApp, localHolder, (ArkViewImplement.ArkViewInterface)localObject2);
    ArkAsyncShareMsgManager.b(localMessageForArkApp);
    if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView != null) {
      a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView, localMessageForArkApp.isSend());
    }
    if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar, localMessageForArkApp.isSend());
    }
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).playShareMsgAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramViewHolder.b, paramViewHolder.c);
    a(paramView, localMessageForArkApp);
    a(paramChatMessage, paramBaseChatItemLayout, localHolder);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppItemBubbleBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
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
      if (MessageRecordInfo.a(paramChatMessage.issend)) {
        localStringBuilder.append("发出");
      } else {
        localStringBuilder.append("发来");
      }
      localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
      if (localMessageForArkApp.arkContainer != null)
      {
        paramChatMessage = localMessageForArkApp.arkContainer.jdField_b_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localStringBuilder.append(paramChatMessage);
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131367180: 
      b((MessageForArkApp)paramChatMessage);
      return;
    case 2131366494: 
      QfavBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
    case 2131365480: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131362951: 
      b(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    a(paramContext, (MessageForArkApp)paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkApp)AIOUtils.a(paramView);
    if (paramView == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    if (paramView.isSendFromLocal())
    {
      if (a(paramView)) {
        return;
      }
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ArkAppItemBubbleBuilder.2(this, paramView), new ArkAppItemBubbleBuilder.3(this)).show();
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296384);
    int j = BaseChatItemLayout.h;
    int k = BaseChatItemLayout.i;
    int m = BaseChatItemLayout.k;
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(m, j, i, k);
      return;
    }
    paramView.setPadding(i, j, m, k);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",message=");
      localStringBuilder.append(paramChatMessage);
      QLog.d("ArkAppItemBubbleBuilder", 2, localStringBuilder.toString());
    }
    super.a(paramView, paramChatMessage, paramInt);
    b(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  protected void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (paramChatMessage == null) {
      return;
    }
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 0)) {
      if ((!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (paramChatMessage.isSupportReply()))
      {
        if (((paramChatMessage instanceof MessageForArkApp)) && (((MessageForArkApp)paramChatMessage).msg != null)) {
          paramQQCustomMenu.a(2131376417, this.jdField_a_of_type_AndroidContentContext.getString(2131697695), 2130838918);
        }
      }
      else if ((paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768) && ((paramChatMessage instanceof MessageForArkApp)) && (paramChatMessage.istroop != 3000) && (((MessageForArkApp)paramChatMessage).msg != null)) {
        paramQQCustomMenu.a(2131376417, this.jdField_a_of_type_AndroidContentContext.getString(2131697695), 2130838918);
      }
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof ArkAppItemBubbleBuilder.Holder;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return localQQCustomMenu.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10007) {
      return localQQCustomMenu.a();
    }
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        a(localQQCustomMenu);
        if ((MessageForArkApp.isAllowedArkForward(false, paramView)) && (!b(paramView))) {
          localQQCustomMenu.a(2131367180, this.jdField_a_of_type_AndroidContentContext.getString(2131692644), 2130838912);
        }
        if (paramView.isMultiMsg) {
          return localQQCustomMenu.a();
        }
        boolean bool1 = TextUtils.isEmpty(paramView.ark_app_message.appName);
        boolean bool2 = true;
        int i;
        if ((!bool1) && (b(paramView))) {
          i = 1;
        } else {
          i = 0;
        }
        bool1 = bool2;
        if (paramView.extraflag != 32768)
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))
          {
            bool1 = bool2;
            if (i == 0)
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
          ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
        if (TroopEssenceUtil.b(paramView)) {
          a(localQQCustomMenu, paramView);
        }
        try
        {
          if (((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).canReply(paramView.ark_app_message.appName, paramView.ark_app_message.appView))
          {
            a(paramView, localQQCustomMenu);
            a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
          }
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add reply menu error, exception =");
          localStringBuilder.append(localException.getMessage());
          QLog.d("ArkAppItemBubbleBuilder", 2, localStringBuilder.toString());
        }
        if (QfavHelper.a(paramView)) {
          super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131366494, null, null);
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isSearch", false);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131380215, paramView, localBundle);
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
        return localQQCustomMenu.a();
      }
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */