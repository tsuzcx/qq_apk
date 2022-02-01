package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.item.IApolloItemBuilder;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.aio.BubbleProducer;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.player.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.api.player.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloGifDownloaderImpl;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.ApolloItemExposeReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils.AioOpenTips;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalImageSpan;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakUtils;
import cooperation.qzone.QZoneVipInfoManager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener, IApolloItemBuilder
{
  private static CopyOnWriteArraySet<IApolloBrickPlayer> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static final float b;
  private static int jdField_d_of_type_Int;
  protected View.OnClickListener a;
  private BubbleProducer jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.7(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.9(this);
  private int jdField_e_of_type_Int = 135;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.10(this);
  private int jdField_f_of_type_Int = 135;
  boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = QzoneConfig.getInstance().getConfig("CMShow", "CMShowGroupAIOWithAt", 0);
  private boolean jdField_g_of_type_Boolean;
  private boolean h = false;
  private boolean i = true;
  private boolean j = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (DeviceInfoUtil.e() / 160) / 2.0F;
    jdField_d_of_type_Int = -1;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.6(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.8(this);
    paramQQAppInterface = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiImplAioBubbleProducer = paramQQAppInterface.getBubbleProducer();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838536), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838537), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838538), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838537), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838536), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838539), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838540), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838539), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838514), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838515), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838516), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838515), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838514), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838517), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838518), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838517), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int k = 1;
    if (a(paramMessageForApollo, paramHolder)) {
      return paramView;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      b(paramHolder, paramMessageForApollo.isSend());
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ApolloItemExposeReportUtil.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForApollo);
      if (paramMessageForApollo.isNewAnimation())
      {
        a(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
        return paramView;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer != null)
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.destroy();
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer);
      }
      a(paramHolder.jdField_c_of_type_AndroidViewView, 8);
      a(paramHolder.jdField_e_of_type_AndroidWidgetTextView, 8);
      a(paramMessageForApollo, paramView, paramHolder);
      a(paramHolder.jdField_a_of_type_ComTencentImageURLImageView, 8);
      a(paramHolder.jdField_c_of_type_AndroidWidgetTextView, 8);
      a(paramHolder.jdField_a_of_type_AndroidWidgetTextView, 0);
      a(paramHolder.jdField_a_of_type_AndroidWidgetImageView, 0);
      b(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
      a(paramMessageForApollo, paramBaseChatItemLayout, paramHolder, ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramMessageForApollo.mApolloMessage.id));
      a(paramMessageForApollo, paramHolder);
      paramBaseChatItemLayout = (ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      if (paramBaseChatItemLayout.getTaskHandler() == null) {
        break label487;
      }
    }
    label479:
    label487:
    for (boolean bool1 = paramBaseChatItemLayout.getTaskHandler().a(paramMessageForApollo.uniseq);; bool1 = false)
    {
      if (paramBaseChatItemLayout.getSpriteContext() != null) {}
      for (boolean bool2 = paramBaseChatItemLayout.getSpriteContext().c();; bool2 = true)
      {
        a(paramMessageForApollo, paramHolder, bool1, bool2);
        b(paramMessageForApollo);
        if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {}
        for (;;)
        {
          if ((paramHolder.jdField_b_of_type_Int != paramHolder.jdField_c_of_type_Int - 1) || (k != 0) || (paramMessageForApollo.isSend())) {
            break label479;
          }
          a(paramMessageForApollo);
          return paramView;
          b(paramHolder, paramMessageForApollo.isSend());
          if (paramMessageForApollo.mApolloMessage != null) {
            paramHolder.jdField_e_of_type_Int = paramMessageForApollo.mApolloMessage.id;
          }
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramHolder.jdField_e_of_type_Int));
          paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramOnLongClickAndTouchListener);
          a(paramHolder, paramView.getResources(), false);
          a(paramHolder.jdField_a_of_type_AndroidWidgetTextView, 8);
          a(paramHolder.jdField_b_of_type_AndroidWidgetTextView, 8);
          a(paramHolder.jdField_a_of_type_AndroidWidgetImageView, 8);
          break;
          k = 0;
        }
        break;
      }
    }
  }
  
  private QQProgressDialog a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    QLog.i("ApolloItemBuilder", 1, "onAddNewCmShowAnimFailed " + paramInt);
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131694916), -1, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static void a(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = AnimationUtils.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n))
    {
      int k = ((FragmentActivity)paramContext).getChatFragment().a().g();
      paramView.putInt("extra.AIO_CURRENT_PANEL_STATE", k);
      if (k == 1)
      {
        localObject = (InputMethodManager)paramContext.getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).toggleSoftInput(1, 0);
        }
      }
    }
    paramView.putBoolean("IS_APP_SHARE_PIC", true);
    paramView.putBoolean("extra.IS_FROM_MULTI_MSG", true);
    paramView.putBoolean("extra.IS_APOLLO", true);
    if (paramSessionInfo != null)
    {
      paramView.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    }
    localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramMessageForApollo.mApolloMessage.id;
    paramSessionInfo = new AIOImageData();
    paramSessionInfo.f = paramMessageForApollo.uniseq;
    paramSessionInfo.jdField_a_of_type_JavaLangString = ApolloUtilImpl.getApolloResPath((ApolloActionData)localObject, 0);
    localObject = ApolloGifDownloaderImpl.getApolloGifFilePath(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    PeakUtils.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  private void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, TextView paramTextView)
  {
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramBubbleInfo = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramView = paramBubbleInfo.getColorStateList(2131167056);
        if (paramView != null) {
          paramTextView.setTextColor(paramView);
        }
        if (!paramChatMessage.isSend()) {
          break label77;
        }
      }
      label77:
      for (paramView = paramBubbleInfo.getColorStateList(2131167055);; paramView = paramBubbleInfo.getColorStateList(2131167054))
      {
        paramTextView.setLinkTextColor(paramView);
        return;
        paramView = paramBubbleInfo.getColorStateList(2131167052);
        break;
      }
    }
    if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
      paramTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.jdField_c_of_type_Int == 0)
    {
      paramTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167054));
      return;
      paramTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    }
    paramTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
  }
  
  private void a(ApolloItemBuilder.Holder paramHolder)
  {
    ApolloExtensionHandlerImpl localApolloExtensionHandlerImpl = (ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_d_of_type_Int) {
      localApolloExtensionHandlerImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 1, "userClick");
    }
    do
    {
      return;
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_g_of_type_Int)
      {
        localApolloExtensionHandlerImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128, "userClick");
        return;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_e_of_type_Int)
      {
        localApolloExtensionHandlerImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 2, "userClick");
        return;
      }
    } while (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ApolloConstant.jdField_f_of_type_Int);
    ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
  }
  
  private void a(ApolloItemBuilder.Holder paramHolder, ActionSheet paramActionSheet, ApolloActionData paramApolloActionData)
  {
    paramActionSheet.addCancelButton(2131690800);
    paramActionSheet.setOnButtonClickListener(new ApolloItemBuilder.5(this, paramHolder, paramApolloActionData, paramActionSheet));
    paramActionSheet.show();
  }
  
  static void a(ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    int m = 0;
    if ((paramHolder.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        k = 8;
        ((ImageView)localObject).setVisibility(k);
      }
    }
    else
    {
      if (paramHolder.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramHolder.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        k = 8;
        label68:
        ((TextView)localObject).setVisibility(k);
      }
      if (paramHolder.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramHolder.jdField_a_of_type_ComTencentImageURLImageView;
        if (!paramBoolean) {
          break label155;
        }
      }
    }
    label150:
    label155:
    for (int k = 8;; k = 0)
    {
      ((URLImageView)localObject).setVisibility(k);
      if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
        k = m;
        if (paramBoolean) {
          k = 8;
        }
        ((ImageView)localObject).setVisibility(k);
      }
      if (paramHolder.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      k = 0;
      break;
      k = 0;
      break label68;
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramMessageForApollo != null))
    {
      this.i = false;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
      String str = "apollo_sp_key_aio_open_tips_count" + (String)localObject1;
      if (jdField_d_of_type_Int == -1) {
        jdField_d_of_type_Int = ((SharedPreferences)localObject2).getInt(str, 0);
      }
      if (jdField_d_of_type_Int >= 3) {}
      do
      {
        return;
        localObject3 = Calendar.getInstance();
        ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        k = ((Calendar)localObject3).get(1);
        m = ((Calendar)localObject3).get(2);
        n = ((Calendar)localObject3).get(5);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("apollo_sp_key_aio_open_tips_day").append((String)localObject1).append("_").append(k).append("_").append(m + 1).append("_").append(n);
        localObject3 = ((StringBuilder)localObject3).toString();
      } while (((SharedPreferences)localObject2).getBoolean((String)localObject3, false));
      jdField_d_of_type_Int += 1;
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putInt(str, jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject2).putBoolean((String)localObject3, true);
      ((SharedPreferences.Editor)localObject2).commit();
      QLog.d("ApolloItemBuilder", 1, "showOpenCmShowTips");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      long l = MessageCache.a();
      Object localObject3 = ApolloConfigUtils.a();
      str = ((ApolloConfigUtils.AioOpenTips)localObject3).jdField_a_of_type_JavaLangString;
      int m = str.indexOf(((ApolloConfigUtils.AioOpenTips)localObject3).b);
      int n = ((ApolloConfigUtils.AioOpenTips)localObject3).b.length();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("key_action", 65);
      StringBuilder localStringBuilder = new StringBuilder().append("");
      if (paramMessageForApollo.is3dAction())
      {
        k = 2;
        ((Bundle)localObject3).putString("key_action_DATA", k);
        ((Bundle)localObject3).putString("textColor", "#40A0FF");
        localObject1 = new UniteGrayTipParam((String)localObject2, (String)localObject1, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 2359300, l);
        ((UniteGrayTipParam)localObject1).a(m, m + n, (Bundle)localObject3);
        localObject2 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
        UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        if (!paramMessageForApollo.is3dAction()) {
          break label593;
        }
        localObject1 = "3D";
        label495:
        VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "opencm_guideword_show", k, 0, new String[] { localObject1 });
        localObject1 = new ApolloDtReportUtil.DtReportParamsBuilder();
        if (!paramMessageForApollo.is3dAction()) {
          break label601;
        }
      }
      label593:
      label601:
      for (int k = 1;; k = 0)
      {
        ApolloDtReportUtil.a("aio_bubble", "apollo_tips", "expose", ((ApolloDtReportUtil.DtReportParamsBuilder)localObject1).a(k).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).a(str).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
        return;
        k = 1;
        break;
        localObject1 = "2D";
        break label495;
      }
    }
    QLog.d("ApolloItemBuilder", 1, new Object[] { "showOpenCmShowTips, mShouldShowOpenTips=", Boolean.valueOf(this.i) });
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView, ApolloItemBuilder.Holder paramHolder)
  {
    if (paramMessageForApollo.mApolloMessage != null)
    {
      String str = ApolloUtilImpl.getDisplayActionName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
      if (!TextUtils.isEmpty(str)) {
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(str);
      }
      if ((!paramMessageForApollo.isDoubleAction()) || (paramMessageForApollo.mApolloMessage.text == null) || (paramMessageForApollo.mApolloMessage.text.length <= 0)) {
        break label207;
      }
      paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
      }
    }
    for (;;)
    {
      paramHolder.jdField_e_of_type_Int = paramMessageForApollo.mApolloMessage.id;
      paramView.setContentDescription(HardCodeUtil.a(2131700480) + paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
      paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
      paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder);
      return;
      label207:
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    paramBaseChatItemLayout = (MessageForApollo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    label38:
    int m;
    int k;
    if (paramBaseChatItemLayout.stickerWidth == 0)
    {
      paramBaseChatItemLayout.stickerWidth = this.jdField_e_of_type_Int;
      if (paramBaseChatItemLayout.stickerHeight != 0) {
        break label563;
      }
      paramBaseChatItemLayout.stickerHeight = this.jdField_f_of_type_Int;
      m = BaseChatItemLayout.o;
      k = BaseChatItemLayout.p;
      if (!paramMessageForApollo.isSend()) {
        break label587;
      }
      m = BaseChatItemLayout.p;
      k = BaseChatItemLayout.o;
    }
    label563:
    label587:
    for (;;)
    {
      Object localObject;
      if (paramHolder.jdField_e_of_type_AndroidWidgetTextView == null)
      {
        localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
        ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_f_of_type_Int);
        ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        ((AnimationTextView)localObject).setId(2131374504);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        paramHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject);
      }
      if (!paramHolder.jdField_a_of_type_Boolean)
      {
        paramHolder.jdField_a_of_type_Boolean = true;
        int n = AIOUtils.a(paramBaseChatItemLayout.stickerWidth, this.jdField_a_of_type_AndroidContentContext.getResources());
        int i1 = AIOUtils.a(paramBaseChatItemLayout.stickerHeight, this.jdField_a_of_type_AndroidContentContext.getResources());
        localObject = new ApolloPlayerParams(this.jdField_a_of_type_AndroidContentContext, n, i1);
        paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer = ((IApolloBrickPlayer)QRoute.api(IApolloBrickPlayer.class));
        paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.setParams((ApolloPlayerParams)localObject);
        localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.getView();
        if ((localObject != null) && (((View)localObject).getParent() == null))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(n, i1);
          localLayoutParams.addRule(3, 2131374504);
          ((View)localObject).setPadding(m, BaseChatItemLayout.v, k, BaseChatItemLayout.w);
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
          paramHolder.jdField_c_of_type_AndroidViewView = ((View)localObject);
        }
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer != null) {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer);
      }
      if (paramBaseChatItemLayout.mApolloMessage.text != null)
      {
        localObject = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject).append(new String(paramBaseChatItemLayout.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramBaseChatItemLayout.inputText)) {
          ((SpannableStringBuilder)localObject).append(paramBaseChatItemLayout.inputText);
        }
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setPadding(m, BaseChatItemLayout.m, k, BaseChatItemLayout.n);
      }
      a(paramHolder.jdField_a_of_type_ComTencentImageURLImageView, 8);
      a(paramHolder.jdField_c_of_type_AndroidWidgetTextView, 8);
      a(paramHolder.jdField_a_of_type_AndroidWidgetTextView, 8);
      a(paramHolder.jdField_b_of_type_AndroidWidgetTextView, 8);
      a(paramHolder.jdField_a_of_type_AndroidWidgetImageView, 8);
      if ((paramMessageForApollo.isDoubleAction()) && (this.jdField_g_of_type_Int != 0)) {
        a(paramHolder.jdField_e_of_type_AndroidWidgetTextView, 0);
      }
      for (;;)
      {
        a(paramHolder.jdField_c_of_type_AndroidViewView, 0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.setMessageForApollo(paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramHolder.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerIApolloBrickPlayer.start();
        a(paramHolder.jdField_d_of_type_AndroidWidgetImageView, 8);
        a(paramHolder.jdField_c_of_type_AndroidWidgetImageView, 8);
        return;
        this.jdField_e_of_type_Int = paramBaseChatItemLayout.stickerWidth;
        break;
        this.jdField_f_of_type_Int = paramBaseChatItemLayout.stickerHeight;
        break label38;
        a(paramHolder.jdField_e_of_type_AndroidWidgetTextView, 8);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder, ApolloActionData paramApolloActionData)
  {
    int k;
    if ((paramHolder.jdField_b_of_type_Int == paramHolder.jdField_c_of_type_Int - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (!a(paramMessageForApollo)))
    {
      if (((paramMessageForApollo.extraflag != 32768) || (!paramMessageForApollo.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramMessageForApollo))) {
        break label138;
      }
      k = 1;
      if (k == 0)
      {
        if ((!this.h) || (this.jdField_d_of_type_Long != paramMessageForApollo.uniseq)) {
          break label162;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
        {
          if (!paramMessageForApollo.isSend()) {
            break label144;
          }
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    label138:
    label144:
    label162:
    while ((this.h) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq))
    {
      return;
      k = 0;
      break;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo = paramMessageForApollo;
    c(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
  }
  
  private void a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder)
  {
    int m = 0;
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
    {
      k = 1;
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (((paramMessageForApollo.isSend()) || (!localIApolloManagerService.isInActionPlayList(paramMessageForApollo.uniseq))) && ((paramMessageForApollo.isSend()) || (k != 0))) {
        break label150;
      }
      localIApolloManagerService.removeFromActionPlayList(Long.valueOf(paramMessageForApollo.uniseq).longValue());
      if (k == 0) {
        break label116;
      }
      a(paramHolder, 1);
    }
    label116:
    while ((paramHolder.jdField_b_of_type_Int != paramHolder.jdField_c_of_type_Int - 1) || ((k == 0) && ((((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (!paramMessageForApollo.isSend()) || (MessageCache.a() - paramMessageForApollo.time >= 10L))))
    {
      do
      {
        return;
        k = 0;
        break;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloItemBuilder", 2, new Object[] { "showApolloAction status is not open:", Integer.valueOf(this.jdField_c_of_type_Int) });
      return;
    }
    label150:
    if (this.j) {
      h();
    }
    if (paramMessageForApollo.isSend()) {}
    for (int k = m;; k = 1)
    {
      a(paramHolder, k);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.3(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new ApolloItemBuilder.4(paramContext, paramInt, paramString));
  }
  
  private boolean a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null)
    {
      QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "click game msg, roomId:" + paramMessageForApollo.roomId);
    }
    if ((paramMessageForApollo.mApolloMessage == null) || (paramMessageForApollo.mApolloMessage.id == 99999))
    {
      QQToast.a(paramView.getContext(), HardCodeUtil.a(2131700485), 0).a();
      return true;
    }
    return !((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
  
  private boolean a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder)
  {
    if ((paramHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    while (!(paramHolder instanceof ApolloItemBuilder.Holder)) {
      return true;
    }
    return false;
  }
  
  private AnimationDrawable b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838524), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838534), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838525), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838526), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838527), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838519), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838523), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838520), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838521), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838522), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (!(paramHolder instanceof ApolloItemBuilder.Holder)) {}
    do
    {
      do
      {
        return;
        a(paramHolder, false);
        if (!this.jdField_g_of_type_Boolean) {
          break;
        }
        if (paramHolder.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131374503);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131374505);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramHolder.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_f_of_type_Int);
          ((AnimationTextView)localObject).setMinWidth(AIOUtils.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramHolder.jdField_f_of_type_Int = 0;
        if (paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, AIOUtils.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan = new VerticalImageSpan((Drawable)localObject);
        }
        if (paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int n = BaseChatItemLayout.o;
        int m = BaseChatItemLayout.p;
        int k = BaseChatItemLayout.o;
        if (paramBoolean)
        {
          n = BaseChatItemLayout.p;
          m = BaseChatItemLayout.o;
          k = BaseChatItemLayout.p;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, m, BaseChatItemLayout.n);
        localObject = (ViewGroup.MarginLayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(n, BaseChatItemLayout.m, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = AIOUtils.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramHolder.jdField_b_of_type_AndroidWidgetImageView == null);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramHolder.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839545);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localIApolloManagerService.getApolloBaseInfoFromCache(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label236;
        }
        localIApolloManagerService.addToBulkPullMap(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label78:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localIApolloManagerService.getApolloBaseInfoFromCache(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label278;
        }
        localIApolloManagerService.addToBulkPullMap(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
      }
    }
    label236:
    while ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS))
    {
      return;
      l1 = 0L;
      break;
      if ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS)) {
        break label78;
      }
      localIApolloManagerService.addToBulkPullMap(paramMessageForApollo.senderuin, 1);
      break label78;
    }
    label278:
    localIApolloManagerService.addToBulkPullMap(localApolloBaseInfo.uin, 1);
  }
  
  private void b(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    ImageView localImageView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramHolder.jdField_d_of_type_AndroidWidgetImageView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131367239);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364634);
      localLayoutParams.addRule(15, 2131363508);
      localLayoutParams.leftMargin = 10;
      localImageView.setContentDescription(HardCodeUtil.a(2131700482));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130847477);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView = localImageView;
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    if (paramHolder.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131367238);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(0, 2131364634);
      localLayoutParams.addRule(15, 2131363508);
      localImageView.setContentDescription(HardCodeUtil.a(2131700486));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130847477);
      paramHolder.jdField_c_of_type_AndroidWidgetImageView = localImageView;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131364665);
    if ((paramMessageForApollo.mNeedTimeStamp) && (paramMessageForApollo.time > 0L) && (paramBaseChatItemLayout != null) && (paramMessageForApollo.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    }
    for (;;)
    {
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    }
  }
  
  private boolean b()
  {
    return (!this.jdField_f_of_type_Boolean) || (a()) || (System.currentTimeMillis() - this.jdField_c_of_type_Long < 600L);
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    Object localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (!((IApolloManagerService)localObject).isApolloSupport(this.jdField_a_of_type_AndroidContentContext)) {
      return false;
    }
    localObject = ((IApolloManagerService)localObject).getApolloBaseInfoFromCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (localObject != null)
    {
      this.jdField_c_of_type_Int = ((ApolloBaseInfo)localObject).apolloStatus;
      if (this.jdField_c_of_type_Int == 2) {
        return false;
      }
    }
    if (paramMessageForApollo == null) {
      return false;
    }
    int k = paramMessageForApollo.istroop;
    return ((ISpriteUtil)QRoute.api(ISpriteUtil.class)).isProperAIO(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void c(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null)
    {
      a(1);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloItemBuilder.2(this, paramMessageForApollo));
  }
  
  private void c(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramHolder), 5, null, true);
  }
  
  private void d(MessageForApollo paramMessageForApollo)
  {
    Object localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ApolloExtensionHandlerImpl localApolloExtensionHandlerImpl = (ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (localApolloExtensionHandlerImpl != null)
    {
      ArrayList localArrayList = new ArrayList(2);
      int k;
      if (!paramMessageForApollo.isSend())
      {
        ApolloBaseInfo localApolloBaseInfo = ((IApolloManagerService)localObject).getApolloBaseInfoFromCache(paramMessageForApollo.senderuin);
        if ((localApolloBaseInfo == null) || (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime > 300L)) {
          localArrayList.add(paramMessageForApollo.senderuin);
        }
        if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (!localApolloBaseInfo.isApolloStatusOpen()))
        {
          k = localApolloBaseInfo.apolloStatus;
          QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + paramMessageForApollo.senderuin + ", status: " + k);
        }
      }
      if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.peer_uin > 0L) && (paramMessageForApollo.mApolloMessage.peer_uin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))
      {
        localObject = ((IApolloManagerService)localObject).getApolloBaseInfoFromCache(paramMessageForApollo.mApolloMessage.peer_uin + "");
        if ((localObject == null) || (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime > 300L)) {
          localArrayList.add(paramMessageForApollo.mApolloMessage.peer_uin + "");
        }
        if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
        {
          k = ((ApolloBaseInfo)localObject).apolloStatus;
          QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + paramMessageForApollo.mApolloMessage.peer_uin + ", status: " + k);
        }
      }
      if (!localArrayList.isEmpty()) {
        localApolloExtensionHandlerImpl.a((String[])localArrayList.toArray(new String[0]));
      }
    }
  }
  
  public static void e()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((IApolloBrickPlayer)localIterator.next()).pause();
    }
  }
  
  public static void f()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((IApolloBrickPlayer)localIterator.next()).resume();
    }
  }
  
  public static void g()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((IApolloBrickPlayer)localIterator.next()).destroy();
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForApollo))
    {
      paramChatMessage = (MessageForApollo)paramChatMessage;
      if (paramChatMessage.isNewAnimation()) {
        if ((paramChatMessage.istroop != 1) || (!paramChatMessage.isDoubleAction()) || (this.jdField_g_of_type_Int == 0)) {}
      }
    }
    while (this.jdField_g_of_type_Boolean)
    {
      return 1;
      return 0;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramOnLongClickAndTouchListener = (ApolloItemBuilder.Holder)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.jdField_g_of_type_Boolean)
    {
      if (paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionInCache(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.jdField_f_of_type_Int);
          paramChatMessage.setMinWidth(AIOUtils.a(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(AIOUtils.a(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842802);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(AIOUtils.a(6.0F, (Resources)localObject1), 0, AIOUtils.a(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364634);
          paramView.addRule(3, 2131364634);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = AIOUtils.a(-3.0F, (Resources)localObject1);
          paramView.leftMargin = AIOUtils.a(12.0F, (Resources)localObject1);
          paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        }
        paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = HardCodeUtil.a(2131700484);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838655);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramOnLongClickAndTouchListener.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(AIOUtils.a(5.0F, paramChatMessage), 0, AIOUtils.a(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842802);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364634);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364634);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(12.0F, paramChatMessage);
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700487));
    paramView = paramChatMessage.getDrawable(2130838653);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramOnLongClickAndTouchListener.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, paramChatMessage), 0, AIOUtils.a(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {
      return paramView;
    }
    paramViewHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    if ((paramView == null) || ((paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131374505);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      this.jdField_g_of_type_Boolean = b(localMessageForApollo);
      return a(localMessageForApollo, paramViewHolder, paramChatMessage, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
      paramChatMessage = paramView;
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ApolloItemBuilder.Holder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131700483) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((IApolloBrickPlayer)localIterator.next()).destroy();
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
    ApolloItemExposeReportUtil.a.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    int k = 1;
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForApollo))) {}
    MessageForApollo localMessageForApollo;
    boolean bool;
    label213:
    label242:
    label383:
    do
    {
      do
      {
        do
        {
          return;
          localMessageForApollo = (MessageForApollo)paramChatMessage;
          bool = localMessageForApollo.isNewAnimation();
          switch (paramInt)
          {
          default: 
            super.a(paramInt, paramContext, paramChatMessage);
            return;
          case 2131365636: 
            ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          }
        } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
        if (bool) {}
        for (paramContext = "y_long_press_delbq";; paramContext = "long_press_del")
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", paramContext, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
          return;
        }
      } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
      if (localMessageForApollo.isNewAnimation())
      {
        c(localMessageForApollo);
        paramContext = new ApolloDtReportUtil.DtReportParamsBuilder();
        if (!localMessageForApollo.is3dAction()) {
          break label383;
        }
        paramInt = 1;
        paramContext = paramContext.a(paramInt).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
        if (!localMessageForApollo.isNewAnimation()) {
          break label388;
        }
        paramInt = 1;
        paramContext = paramContext.c(paramInt);
        if (!localMessageForApollo.is3dAction()) {
          break label393;
        }
        paramInt = localMessageForApollo.mApollo3DMessage.actionID_3D;
        paramContext = paramContext.c(String.valueOf(paramInt));
        if (!localMessageForApollo.isSend()) {
          break label405;
        }
        paramInt = 0;
        paramContext = paramContext.d(paramInt);
        if (!localMessageForApollo.isDoubleAction()) {
          break label410;
        }
        paramInt = k;
        paramContext = paramContext.e(ApolloDtReportUtil.a(paramInt, localMessageForApollo.actionType)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (!localMessageForApollo.is3dAction()) {
          break label415;
        }
      }
      for (paramInt = localMessageForApollo.mApollo3DMessage.actionID_3D;; paramInt = localMessageForApollo.mApolloMessage.id)
      {
        ApolloDtReportUtil.a("aio_bubble", "apollo_msg", "save", paramContext.g(ApolloDtReportUtil.b(paramInt)).a());
        return;
        a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
        break;
        paramInt = 0;
        break label213;
        paramInt = 0;
        break label242;
        paramInt = localMessageForApollo.mApolloMessage.id;
        break label265;
        paramInt = 1;
        break label284;
        paramInt = 0;
        break label301;
      }
      super.a(paramInt, paramContext, paramChatMessage);
    } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
    label265:
    label284:
    label301:
    if (bool) {}
    label388:
    label393:
    label405:
    label410:
    label415:
    for (paramContext = "y_long_press_withdrawbq";; paramContext = "long_press_withdraw")
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", paramContext, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      return;
    }
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / DeviceInfoUtil.a);
      localObject1 = ApolloUtilImpl.autoSplitText(((TextView)localObject1).getPaint(), 208.0F, (String)localObject2, 3);
      localObject1 = Pattern.compile("\n").matcher((CharSequence)localObject1).replaceAll("");
    }
    if ((localObject3 != null) && (((ApolloActionData)localObject3).feeType == 1))
    {
      localObject2 = new ApolloFavActionData();
      if (paramMessageForApollo.isBarrageMode()) {}
      for (paramInt = 1;; paramInt = 0)
      {
        ((ApolloFavActionData)localObject2).textType = paramInt;
        ((ApolloFavActionData)localObject2).text = ((String)localObject1);
        ((ApolloFavActionData)localObject2).acitonId = paramMessageForApollo.mApolloMessage.id;
        ((ApolloFavActionData)localObject2).audioId = paramMessageForApollo.audioId;
        ((ApolloFavActionData)localObject2).audioStartTime = paramMessageForApollo.audioStartTime;
        ((ApolloFavActionData)localObject2).playOriginalAudio = paramMessageForApollo.isPlayDefaultAudio;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (ApolloFavActionData)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690107), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((ApolloExtensionHandlerImpl)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131690164);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      a(paramView);
      ApolloBaseInfo localApolloBaseInfo = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfoFromCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloActionData localApolloActionData = localIApolloDaoManagerService.findActionById(paramView.jdField_e_of_type_Int);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_d_of_type_Int) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690124));
        localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690123), 1);
        paramView.jdField_f_of_type_Int = 1;
        QZoneVipInfoManager.cmJumpToYellowPlayDialog((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_e_of_type_Int) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690124));
        localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690123), 1);
        paramView.jdField_f_of_type_Int = 2;
        QZoneVipInfoManager.cmJumpToYellowPlayDialog((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_g_of_type_Int) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localIApolloDaoManagerService.isObtainActionById(localApolloActionData.actionId))))
      {
        localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690121));
        localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690120), 1);
        paramView.jdField_f_of_type_Int = 3;
      }
      for (;;)
      {
        a(paramView, localActionSheet, localApolloActionData);
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_f_of_type_Int)
        {
          localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690122));
          paramView.jdField_f_of_type_Int = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690126), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof ApolloItemBuilder.Holder)) {}
    IApolloManagerService localIApolloManagerService;
    do
    {
      do
      {
        return;
        paramView = (ApolloItemBuilder.Holder)paramView;
      } while (paramInt1 != 1);
      localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        localIApolloManagerService.removeFromActionDownloadList(paramView.jdField_e_of_type_Int);
        return;
      }
      if (!localIApolloManagerService.isInActionDownloadList(paramView.jdField_e_of_type_Int)) {
        localIApolloManagerService.addToActionDownloadList(paramView.jdField_e_of_type_Int);
      }
    } while (localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 2);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).setReaded(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    ApolloItemBuilder.Holder localHolder;
    if ((paramView != null) && ((AIOUtils.a(paramView) instanceof ApolloItemBuilder.Holder)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).removeFromActionDownloadList(paramMessageForApollo.mApolloMessage.id);
      }
      localHolder = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
      if (!super.a(paramMessageForApollo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      if ((paramView instanceof BaseChatItemLayout)) {
        if (paramMessageForApollo.actionType != 5) {
          break label173;
        }
      }
    }
    label173:
    for (paramView = b(paramMessageForApollo.isSend());; paramView = a(paramMessageForApollo.isSend()))
    {
      if ((paramView != null) && (localHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {}
    do
    {
      do
      {
        return;
        paramViewHolder = (ApolloItemBuilder.Holder)paramViewHolder;
      } while (paramBubbleInfo == null);
      if (paramViewHolder.jdField_e_of_type_AndroidWidgetTextView != null) {
        a(paramView, paramChatMessage, paramBubbleInfo, paramViewHolder.jdField_e_of_type_AndroidWidgetTextView);
      }
    } while (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView == null);
    a(paramView, paramChatMessage, paramBubbleInfo, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = AIOUtils.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof ApolloItemBuilder.Holder)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = AIOUtils.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof ApolloItemBuilder.Holder));
      localObject = (ApolloItemBuilder.Holder)localObject;
      paramBaseChatItemLayout2 = (ApolloItemBuilder.Holder)paramBaseChatItemLayout2;
    } while (((ApolloItemBuilder.Holder)localObject).jdField_e_of_type_Int != paramBaseChatItemLayout2.jdField_e_of_type_Int);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(ApolloItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder = (MessageForApollo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramHolder.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = (ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      ISpriteBridge localISpriteBridge = ((ISpriteScriptManager)localObject).getSpriteBridge();
      localObject = ((ISpriteScriptManager)localObject).getSpriteContext();
      if (this.jdField_c_of_type_Int != 1) {
        ((ISpriteContext)localObject).a(true);
      }
      if (localISpriteBridge != null) {
        localISpriteBridge.a(paramInt, paramHolder);
      }
    }
  }
  
  void a(ApolloItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
  {
    if ((paramHolder == null) || (paramResources == null)) {
      return;
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mGifRoundCorner = jdField_b_of_type_Float;
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838654);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838656);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramHolder.jdField_e_of_type_Int));
        File localFile = new File(ApolloGifDownloaderImpl.getApolloGifFilePath(paramHolder.jdField_e_of_type_Int));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramHolder.jdField_e_of_type_Int + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramHolder) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramHolder.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramHolder.jdField_e_of_type_Int));
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  protected void a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false);
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if ((localIApolloManagerService.isInActionDownloadList(paramHolder.jdField_e_of_type_Int)) && (localIApolloManagerService != null) && (localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) != 2) && (paramBoolean2)) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    }
    if (paramBoolean1)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (AnimationDrawable localAnimationDrawable = b(paramMessageForApollo.isSend());; localAnimationDrawable = a(paramMessageForApollo.isSend()))
      {
        if (localAnimationDrawable != null)
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
          localAnimationDrawable.start();
        }
        localIApolloManagerService.removeFromActionDownloadList(paramHolder.jdField_e_of_type_Int);
        if (!paramMessageForApollo.hasPlayed) {
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).setReaded(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        return;
      }
    }
    int k;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        k = 2130838524;
      }
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(k);
      return;
      k = 2130838519;
      continue;
      if (paramMessageForApollo.isSend()) {
        k = 2130838536;
      } else {
        k = 2130838514;
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ApolloItemBuilder.Holder))
    {
      paramObject = (ApolloItemBuilder.Holder)paramObject;
      paramObject.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false);
      if (paramObject.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramObject = paramObject.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
        if ((paramObject != null) && ((paramObject instanceof AnimationDrawable)))
        {
          ((AnimationDrawable)paramObject).stop();
          ((AnimationDrawable)paramObject).selectDrawable(0);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (AnonymousChatHelper.a().a(paramMessageForApollo.frienduin)) {
      return true;
    }
    int k = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return ((paramMessageForApollo.is3dAction()) && (k != 2)) || ((!paramMessageForApollo.is3dAction()) && (this.jdField_c_of_type_Int == 2));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    if (ApolloGameUtil.a(paramView))
    {
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return localQQCustomMenu.a();
    }
    boolean bool = false;
    MessageForApollo localMessageForApollo;
    if ((paramView instanceof MessageForApollo))
    {
      localMessageForApollo = (MessageForApollo)paramView;
      bool = localMessageForApollo.isNewAnimation();
      if ((!this.jdField_g_of_type_Boolean) || (ApolloGameUtil.a(localMessageForApollo.msgType)) || (localMessageForApollo.is3dAction()) || (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) || (bool)) {
        break label477;
      }
      localQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131690103), 2130838595);
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
      if (localMessageForApollo.mApolloMessage != null)
      {
        if (!bool) {
          break label511;
        }
        paramView = "y_long_press_bq";
        label229:
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", paramView, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
        paramView = new ApolloDtReportUtil.DtReportParamsBuilder();
        if (!localMessageForApollo.is3dAction()) {
          break label518;
        }
        k = 1;
        label301:
        paramView = paramView.a(k).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
        if (!localMessageForApollo.isNewAnimation()) {
          break label523;
        }
        k = 1;
        label330:
        paramView = paramView.c(k);
        if (!localMessageForApollo.is3dAction()) {
          break label528;
        }
        k = localMessageForApollo.mApollo3DMessage.actionID_3D;
        label353:
        paramView = paramView.c(String.valueOf(k));
        if (!localMessageForApollo.isSend()) {
          break label540;
        }
        k = 0;
        label372:
        paramView = paramView.d(k);
        if (!localMessageForApollo.isDoubleAction()) {
          break label545;
        }
        k = 1;
        label388:
        paramView = paramView.e(ApolloDtReportUtil.a(k, localMessageForApollo.actionType)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (!localMessageForApollo.is3dAction()) {
          break label550;
        }
      }
    }
    label518:
    label523:
    label528:
    label540:
    label545:
    label550:
    for (int k = localMessageForApollo.mApollo3DMessage.actionID_3D;; k = localMessageForApollo.mApolloMessage.id)
    {
      ApolloDtReportUtil.a("aio_bubble", "apollo_msg", "long_click", paramView.g(ApolloDtReportUtil.b(k)).a());
      if (!bool) {
        super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      }
      return localQQCustomMenu.a();
      label477:
      if ((!bool) || (!CmShowWnsUtils.j())) {
        break;
      }
      localQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131691971), 2130838595);
      break;
      label511:
      paramView = "long_press_msg";
      break label229;
      k = 0;
      break label301;
      k = 0;
      break label330;
      k = localMessageForApollo.mApolloMessage.id;
      break label353;
      k = 1;
      break label372;
      k = 0;
      break label388;
    }
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int k;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131374503);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        k = 2130838524;
      }
    }
    for (;;)
    {
      paramView.setImageResource(k);
      return;
      label51:
      k = 2130838519;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        k = 2130838536;
      } else {
        k = 2130838514;
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    label14:
    String str;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          break label14;
          do
          {
            return;
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0));
          this.j = false;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
          str = "apollo_invite_gray_tip" + (String)localObject2 + "_" + (String)localObject1;
          localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        } while (!localSharedPreferences.getBoolean(str, true));
        localObject3 = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      } while (localObject3 == null);
      localObject3 = ((IApolloManagerService)localObject3).getApolloBaseInfoFromCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = MessageCache.a();
    Object localObject3 = HardCodeUtil.a(2131700481);
    int k = ((String)localObject3).indexOf(HardCodeUtil.a(2131700479));
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 1);
    localBundle.putString("textColor", "#40A0FF");
    localBundle.putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new UniteGrayTipParam((String)localObject1, (String)localObject2, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((UniteGrayTipParam)localObject1).a(k, k + 2, localBundle);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
    ApolloDtReportUtil.a("aio_bubble", "apollo_tips", "expose", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).a((String)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof ApolloItemBuilder.Holder)) {}
    do
    {
      return;
      paramView = (ApolloItemBuilder.Holder)paramView;
      if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */