package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
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
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.todo.TroopTodoUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
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
  implements BaseBubbleBuilder.TouchDelegate, BaseChatItemLayout.MiniAioShieldItemTouchListener
{
  private SessionInfo a = null;
  private int w;
  private int x;
  private List<MessageForArkApp> y = new ArrayList();
  
  public ArkAppItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = paramSessionInfo;
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.a(paramContext, paramMessageForArkApp, this.f.a);
  }
  
  private void a(View paramView, MessageForArkApp paramMessageForArkApp)
  {
    if (!this.y.contains(paramMessageForArkApp))
    {
      SdkShareReporter.a(paramMessageForArkApp);
      if ((paramView != null) && (this.f != null) && (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).isQQGamePubAccount(this.f.b))) {
        ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).reportArkExposure(paramView.getContext(), paramMessageForArkApp);
      }
      this.y.add(paramMessageForArkApp);
    }
  }
  
  private void a(View paramView, MessageForArkApp paramMessageForArkApp, ArkAppItemBubbleBuilder.Holder paramHolder, ArkViewImplement.ArkViewInterface paramArkViewInterface)
  {
    if (v)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if ((paramHolder.r != null) && (paramHolder.r.length() > 0)) {
        localStringBuilder.append(paramHolder.r);
      }
      localStringBuilder.append(d(paramMessageForArkApp));
      paramView.setContentDescription(localStringBuilder);
      paramArkViewInterface.setContentDescription(localStringBuilder);
      paramView = new StringBuilder();
      paramView.append("Type is normal, and talkbackText is ");
      paramView.append(localStringBuilder);
      QLog.i("ArkAppItemBubbleBuilder", 1, paramView.toString());
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ArkAppItemBubbleBuilder.Holder paramHolder)
  {
    if (this.d != null)
    {
      if (TroopEssenceUtil.a(this.d, paramChatMessage, this.f.b))
      {
        paramHolder.s = super.a(paramHolder.s, paramHolder, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.a(this.e, 21.0F));
        super.a(paramHolder.s, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
        TroopEssenceReportUtil.a(this.d, paramHolder.s, this.f.b);
        return;
      }
      if (paramHolder.s != null) {
        paramHolder.s.setVisibility(8);
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
    int i = ArkAppCenterUtil.a;
    int k = MessageForArkApp.dp2px(390.0F);
    boolean bool2 = MessageForArkApp.isSetSizeByConfig(paramConfig);
    StringBuilder localStringBuilder = new StringBuilder("isSetSize=");
    localStringBuilder.append(bool2);
    localStringBuilder.append(",param=[");
    Object localObject;
    if (bool2)
    {
      localObject = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.d(), paramConfig.width.intValue(), paramConfig.height.intValue());
      if (localObject != null)
      {
        if (bool1) {
          j = i;
        } else {
          j = ((MessageForArkApp.Size)localObject).width;
        }
        this.w = j;
        this.x = ((MessageForArkApp.Size)localObject).height;
        paramMessageForArkApp.arkContainer.setFixSize(this.w, this.x);
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
      this.w = j;
      this.x = -1;
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
    ArkAppCenterUtil.a("ArkAppItemBubbleBuilder.attachArkView", this.e);
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
  
  private void b(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.bottomMargin = MessageForArkApp.dp2px(55.0F);
      if (paramBoolean)
      {
        paramView.addRule(0, 2131430578);
        paramView.addRule(1, 0);
        return;
      }
      paramView.addRule(1, 2131430578);
      paramView.addRule(0, 0);
    }
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
          localObject = QQCustomArkDialog.AppInfo.a(paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp.ark_app_message.appView, paramMessageForArkApp.ark_app_message.appMinVersion, paramMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.d(), null, null);
          localIntent.putExtra("is_ark_display_share", true);
        }
        else
        {
          localObject = new Bundle();
        }
        SdkShareReporter.ArkReportData localArkReportData = SdkShareReporter.c(paramMessageForArkApp);
        if (localArkReportData.c)
        {
          ((Bundle)localObject).putString("forward_ark_app_type", localArkReportData.a);
          ((Bundle)localObject).putString("forward_ark_app_title", localArkReportData.b);
          ((Bundle)localObject).putInt("forward_ark_app_result", localArkReportData.e);
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
        ((Bundle)localObject).putInt("selection_mode", this.u);
        ((Bundle)localObject).putInt("forward_source_uin_type", this.f.a);
        localIntent.putExtras((Bundle)localObject);
        ForwardBaseOption.a((Activity)this.e, localIntent, 21);
      }
    }
  }
  
  private void b(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    int i = TroopEssenceUtil.a(this.f, paramChatMessage, this.d);
    if (i == 2)
    {
      a(paramQQCustomMenu, this.e, 2131432608, paramChatMessage, null);
      return;
    }
    if (i == 1) {
      a(paramQQCustomMenu, this.e, 2131432607, paramChatMessage, null);
    }
  }
  
  private boolean c(MessageForArkApp paramMessageForArkApp)
  {
    if (!ForwardSDKB77AIOHelper.a(paramMessageForArkApp))
    {
      QLog.d("ArkAppItemBubbleBuilder", 1, "showForbidShareDialog false");
      return false;
    }
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.x);
    QLog.d("ArkAppItemBubbleBuilder", 1, new Object[] { "resend forbid msg wording=", paramMessageForArkApp });
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.e, 230);
    localQQCustomDialog.setMessage(paramMessageForArkApp);
    localQQCustomDialog.setPositiveButton(2131892267, new ArkAppItemBubbleBuilder.4(this));
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
  
  private boolean d(MessageForArkApp paramMessageForArkApp)
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
  
  private void e(View paramView)
  {
    if ((this.f != null) && ((this.f.a == 0) || (this.f.a == 1)))
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView instanceof MessageForArkApp))
      {
        paramView = (MessageForArkApp)paramView;
        if (paramView.ark_app_message != null) {
          ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).handleBubbleViewForGameShare(1, this.f, paramView);
        }
      }
    }
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
      paramView = LayoutInflater.from(this.e).inflate(2131624417, null);
      localHolder.c = ((ArkAppView)paramView.findViewById(2131428746));
      localHolder.d = ((LinearLayout)paramView.findViewById(2131428755));
      localHolder.e = ((ImageView)paramView.findViewById(2131428754));
      localHolder.f = ((TextView)paramView.findViewById(2131428756));
      localHolder.c.setTag(localHolder);
      localHolder.b = ((ArkAppLoadLayout)paramView.findViewById(2131437612));
    }
    localHolder.j.setMiniAioShieldItemTouchListener(this);
    if (localHolder.b != null)
    {
      localObject1 = (RelativeLayout.LayoutParams)localHolder.b.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ArkAppCenterUtil.a;
      ((RelativeLayout.LayoutParams)localObject1).height = ArkAppCenterUtil.a;
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      localHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    paramView.findViewById(2131428772).setPadding(0, 0, 0, 0);
    a(localMessageForArkApp);
    if (localHolder.d != null) {
      localHolder.d.setVisibility(8);
    }
    if (ArkTipsManager.b().b(paramChatMessage.uniseq)) {
      localMessageForArkApp.arkContainer = ArkTipsManager.b().f();
    }
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new ArkAioContainerWrapper();
    }
    localMessageForArkApp.arkContainer.a(this.a);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("multiAio.ArkAppItemBubbleBuilder set session info =");
      ((StringBuilder)localObject1).append(ArkAppQQModuleBase.a(this.a));
      QLog.d("ArkAppItemBubbleBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = localHolder.b;
    localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.d(), localMessageForArkApp, this.f);
    Object localObject2 = new ArkAppItemBubbleBuilder.1(this, localMessageForArkApp, localHolder);
    localHolder.c.setLoadCallback((ArkViewImplement.LoadCallback)localObject2);
    a(localMessageForArkApp, localConfig);
    localHolder.a = localMessageForArkApp.msg;
    localObject2 = localHolder.c;
    ArkAppView localArkAppView = localHolder.c;
    float f;
    if (QQTheme.isNowSimpleUI()) {
      f = 8.0F;
    } else {
      f = 16.0F;
    }
    ((ArkViewImplement.ArkViewInterface)localObject2).setClipRadius(f);
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
    ArkAsyncShareMsgManager.d(localMessageForArkApp);
    if (paramBaseChatItemLayout.ah != null) {
      b(paramBaseChatItemLayout.ah, localMessageForArkApp.isSend());
    }
    if (paramBaseChatItemLayout.ag != null) {
      b(paramBaseChatItemLayout.ag, localMessageForArkApp.isSend());
    }
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).playShareMsgAction(this.d, this.f, paramChatMessage, paramViewHolder.l, paramViewHolder.m);
    a(paramView, localMessageForArkApp);
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).handleBubbleViewForGameShare(0, this.f, localMessageForArkApp);
    a(paramChatMessage, paramBaseChatItemLayout, localHolder);
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ArkAppItemBubbleBuilder.Holder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131433636: 
      b((MessageForArkApp)paramChatMessage);
      return;
    case 2131432813: 
      QfavBuilder.a(this.d, this.e, paramChatMessage);
      return;
    case 2131431695: 
      ChatActivityFacade.b(this.e, this.d, paramChatMessage);
      return;
    case 2131428750: 
      b(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    a(paramContext, (MessageForArkApp)paramChatMessage);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      e(paramView);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.e.getResources().getDimensionPixelSize(2131296616);
    int j = BaseChatItemLayout.k;
    int k = BaseChatItemLayout.l;
    int m = BaseChatItemLayout.getBubblePaddingAlignError();
    if (QQTheme.isNowSimpleUI()) {
      i = BaseChatItemLayout.getBubblePaddingAlignHead();
    }
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
  
  public void a(View paramView, boolean paramBoolean) {}
  
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
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof ArkAppItemBubbleBuilder.Holder;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
    if (this.f == null) {
      return localQQCustomMenu.d();
    }
    if (this.f.a == 10007) {
      return localQQCustomMenu.d();
    }
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.q;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        a(localQQCustomMenu);
        if ((MessageForArkApp.isAllowedArkForward(false, paramView)) && (!d(paramView))) {
          localQQCustomMenu.a(2131433636, this.e.getString(2131889668), 2130839066);
        }
        if (paramView.isMultiMsg) {
          return localQQCustomMenu.d();
        }
        boolean bool1 = TextUtils.isEmpty(paramView.ark_app_message.appName);
        boolean bool2 = true;
        int i;
        if ((!bool1) && (d(paramView))) {
          i = 1;
        } else {
          i = 0;
        }
        bool1 = bool2;
        if (paramView.extraflag != 32768)
        {
          bool1 = bool2;
          if (!this.d.getMsgCache().f(paramView))
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
                a(localQQCustomMenu, this.e, 2131438943, paramView, new Bundle());
              }
            }
          }
        }
        if (bool1) {
          a(localQQCustomMenu, this.e, 2131431695, paramView, new Bundle());
        } else {
          ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
        }
        if (TroopTodoUtils.a(paramView)) {
          a(localQQCustomMenu, paramView);
        }
        super.a(localQQCustomMenu, this.e, 2131439015, null, null);
        if (TroopEssenceUtil.b(paramView)) {
          b(localQQCustomMenu, paramView);
        }
        try
        {
          if (((IArkMsgReplyMgr)QRoute.api(IArkMsgReplyMgr.class)).canReply(paramView.ark_app_message.appName, paramView.ark_app_message.appView))
          {
            a(paramView, localQQCustomMenu);
            a(localQQCustomMenu, this.e, 2131444651, paramView, null);
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
          super.a(localQQCustomMenu, this.e, 2131432813, null, null);
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isSearch", false);
        super.a(localQQCustomMenu, this.e, 2131449133, paramView, localBundle);
        super.a(localQQCustomMenu, this.e, 2131428089, null, null);
        return localQQCustomMenu.d();
      }
    }
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    super.a(localQQCustomMenu, this.e, 2131439015, null, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    ReportController.b(this.d, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
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
    if (paramView.isSendFromLocal())
    {
      if (c(paramView)) {
        return;
      }
      DialogUtil.a(this.e, 230, str1, str2, new ArkAppItemBubbleBuilder.2(this, paramView), new ArkAppItemBubbleBuilder.3(this)).show();
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    return this;
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */