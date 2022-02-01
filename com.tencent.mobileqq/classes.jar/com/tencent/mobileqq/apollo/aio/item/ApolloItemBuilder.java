package com.tencent.mobileqq.apollo.aio.item;

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
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
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
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils.AioOpenTips;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.player.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.player.api.IApolloBrickPlayer;
import com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloGifDownloaderImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloAioBubbleReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ViewUtils;
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
import cooperation.peak.PeakUtils;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.os.MqqHandler;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener, IApolloItemBuilder
{
  private static CopyOnWriteArraySet<IApolloBrickPlayer> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static final float b;
  private static int jdField_d_of_type_Int;
  private int jdField_a_of_type_Int = 0;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo;
  private View.OnClickListener b;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.8(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.10(this);
  private int e;
  private int jdField_f_of_type_Int = 135;
  boolean jdField_f_of_type_Boolean = true;
  private boolean g;
  private boolean h = false;
  private boolean i = true;
  private boolean j = CmShowWnsUtils.v();
  private boolean k = true;
  
  static
  {
    jdField_b_of_type_Float = ViewUtils.b(12.0F) / 2.0F;
    jdField_d_of_type_Int = -1;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_e_of_type_Int = 135;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.7(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ApolloItemBuilder.9(this);
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838378), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838379), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838380), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838379), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838378), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838381), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838382), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838381), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838362), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838363), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838364), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838363), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838362), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838365), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838366), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838365), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (a(paramMessageForApollo, paramHolder)) {
      return paramView;
    }
    boolean bool1 = this.g;
    int m = 0;
    if (bool1)
    {
      b(paramHolder, paramMessageForApollo.isSend());
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ApolloAioBubbleReportUtil.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForApollo);
      if (paramMessageForApollo.isNewAnimation())
      {
        a(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
        return paramView;
      }
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer != null)
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.destroy();
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer);
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
      if (paramBaseChatItemLayout.getTaskHandler() != null) {
        bool1 = paramBaseChatItemLayout.getTaskHandler().a(paramMessageForApollo.uniseq);
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramBaseChatItemLayout.getSpriteContext() != null) {
        bool2 = paramBaseChatItemLayout.getSpriteContext().c();
      } else {
        bool2 = true;
      }
      a(paramMessageForApollo, paramHolder, bool1, bool2);
      b(paramMessageForApollo);
    }
    else
    {
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
    }
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {
      m = 1;
    }
    if ((paramHolder.jdField_b_of_type_Int == paramHolder.jdField_c_of_type_Int - 1) && (m == 0) && (!paramMessageForApollo.isSend())) {
      a(paramMessageForApollo);
    }
    return paramView;
  }
  
  private BaseChatPie a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      ChatFragment localChatFragment = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localChatFragment != null) {
        return localChatFragment.a();
      }
    }
    return null;
  }
  
  private QQProgressDialog a()
  {
    if (((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddNewCmShowAnimFailed ");
    localStringBuilder.append(paramInt);
    QLog.i("[cmshow]ApolloItemBuilder", 1, localStringBuilder.toString());
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131694906), -1, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  private void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, TextView paramTextView)
  {
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
        paramTextView.setTextColor(-16777216);
      } else {
        paramTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      }
      if (paramBubbleInfo.jdField_c_of_type_Int == 0)
      {
        paramTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167077));
        return;
      }
      paramTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
      return;
    }
    paramBubbleInfo = paramView.getResources();
    if (paramChatMessage.isSend()) {
      paramView = paramBubbleInfo.getColorStateList(2131167079);
    } else {
      paramView = paramBubbleInfo.getColorStateList(2131167075);
    }
    if (paramView != null) {
      paramTextView.setTextColor(paramView);
    }
    if (paramChatMessage.isSend()) {
      paramView = paramBubbleInfo.getColorStateList(2131167078);
    } else {
      paramView = paramBubbleInfo.getColorStateList(2131167077);
    }
    paramTextView.setLinkTextColor(paramView);
  }
  
  private void a(BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = (AIOEmoticonPanelHelper)paramBaseChatPie.a(104);
    if (paramBaseChatPie != null) {
      paramBaseChatPie.showEmoticonPanel(15);
    }
  }
  
  private void a(ApolloItemBuilder.Holder paramHolder)
  {
    ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_c_of_type_Int)
    {
      localApolloExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 1L, "userClick");
      return;
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_f_of_type_Int)
    {
      localApolloExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128L, "userClick");
      return;
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_d_of_type_Int)
    {
      localApolloExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 2L, "userClick");
      return;
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_e_of_type_Int) {
      ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    }
  }
  
  private void a(ApolloItemBuilder.Holder paramHolder, ActionSheet paramActionSheet, ApolloActionData paramApolloActionData)
  {
    paramActionSheet.addCancelButton(2131690728);
    paramActionSheet.setOnButtonClickListener(new ApolloItemBuilder.6(this, paramHolder, paramApolloActionData, paramActionSheet));
    paramActionSheet.show();
  }
  
  static void a(ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if ((paramHolder.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
    int n = 0;
    int m;
    if (localObject != null)
    {
      localObject = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        m = 8;
      } else {
        m = 0;
      }
      ((ImageView)localObject).setVisibility(m);
    }
    if (paramHolder.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = paramHolder.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean) {
        m = 8;
      } else {
        m = 0;
      }
      ((TextView)localObject).setVisibility(m);
    }
    if (paramHolder.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      localObject = paramHolder.jdField_a_of_type_ComTencentImageURLImageView;
      if (paramBoolean) {
        m = 8;
      } else {
        m = 0;
      }
      ((URLImageView)localObject).setVisibility(m);
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
      m = n;
      if (paramBoolean) {
        m = 8;
      }
      ((ImageView)localObject).setVisibility(m);
    }
    if (paramHolder.jdField_c_of_type_AndroidWidgetTextView != null) {
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    boolean bool = this.i;
    int m = 2;
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramMessageForApollo != null))
    {
      this.i = false;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("apollo_sp_key_aio_open_tips_count");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject3).toString();
      if (jdField_d_of_type_Int == -1) {
        jdField_d_of_type_Int = ((SharedPreferences)localObject2).getInt((String)localObject3, 0);
      }
      if (jdField_d_of_type_Int >= 3) {
        return;
      }
      Object localObject4 = Calendar.getInstance();
      ((Calendar)localObject4).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      int n = ((Calendar)localObject4).get(1);
      int i1 = ((Calendar)localObject4).get(2);
      int i2 = ((Calendar)localObject4).get(5);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("apollo_sp_key_aio_open_tips_day");
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(n);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(i1 + 1);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(i2);
      localObject4 = ((StringBuilder)localObject4).toString();
      if (((SharedPreferences)localObject2).getBoolean((String)localObject4, false)) {
        return;
      }
      jdField_d_of_type_Int += 1;
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putInt((String)localObject3, jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject2).putBoolean((String)localObject4, true);
      ((SharedPreferences.Editor)localObject2).commit();
      QLog.d("[cmshow]ApolloItemBuilder", 1, "showOpenCmShowTips");
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      long l = MessageCache.a();
      localObject3 = ApolloConfigUtils.a();
      localObject2 = ((ApolloConfigUtils.AioOpenTips)localObject3).jdField_a_of_type_JavaLangString;
      localObject4 = new Bundle();
      ((Bundle)localObject4).putInt("key_action", 65);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      if (!paramMessageForApollo.is3dAction()) {
        m = 1;
      }
      localStringBuilder.append(m);
      ((Bundle)localObject4).putString("key_action_DATA", localStringBuilder.toString());
      ((Bundle)localObject4).putString("textColor", "#40A0FF");
      localObject1 = new UniteGrayTipParam(str, (String)localObject1, (String)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5020, 2359300, l);
      m = ((String)localObject2).indexOf(((ApolloConfigUtils.AioOpenTips)localObject3).b);
      ((UniteGrayTipParam)localObject1).a(m, ((ApolloConfigUtils.AioOpenTips)localObject3).b.length() + m, (Bundle)localObject4);
      localObject3 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
      UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject3);
      ApolloAioBubbleReportUtil.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForApollo, (String)localObject2);
      return;
    }
    QLog.d("[cmshow]ApolloItemBuilder", 1, new Object[] { "showOpenCmShowTips, mShouldShowOpenTips=", Boolean.valueOf(this.i) });
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView, ApolloItemBuilder.Holder paramHolder)
  {
    if (paramMessageForApollo.mApolloMessage != null)
    {
      String str = ApolloUtilImpl.getDisplayActionName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
      if (!TextUtils.isEmpty(str)) {
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(str);
      }
      if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
      {
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
        }
      }
      else if (!TextUtils.isEmpty(paramMessageForApollo.inputText))
      {
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
      }
      paramHolder.jdField_e_of_type_Int = paramMessageForApollo.mApolloMessage.id;
    }
    paramMessageForApollo = new StringBuilder();
    paramMessageForApollo.append(HardCodeUtil.a(2131700621));
    paramMessageForApollo.append(paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
    paramView.setContentDescription(paramMessageForApollo.toString());
    paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
    paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan, 0, 3, 33);
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    paramBaseChatItemLayout = (MessageForApollo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramBaseChatItemLayout.stickerWidth == 0) {
      paramBaseChatItemLayout.stickerWidth = this.jdField_e_of_type_Int;
    } else {
      this.jdField_e_of_type_Int = paramBaseChatItemLayout.stickerWidth;
    }
    if (paramBaseChatItemLayout.stickerHeight == 0) {
      paramBaseChatItemLayout.stickerHeight = this.jdField_f_of_type_Int;
    } else {
      this.jdField_f_of_type_Int = paramBaseChatItemLayout.stickerHeight;
    }
    int m = BaseChatItemLayout.o;
    int n = BaseChatItemLayout.p;
    if (paramMessageForApollo.isSend())
    {
      m = BaseChatItemLayout.p;
      n = BaseChatItemLayout.o;
    }
    Object localObject;
    if (paramHolder.jdField_e_of_type_AndroidWidgetTextView == null)
    {
      localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
      ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_f_of_type_Int);
      ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      ((AnimationTextView)localObject).setId(2131374042);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
      paramHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    if (!paramHolder.jdField_a_of_type_Boolean)
    {
      paramHolder.jdField_a_of_type_Boolean = true;
      int i1 = AIOUtils.b(paramBaseChatItemLayout.stickerWidth, this.jdField_a_of_type_AndroidContentContext.getResources());
      int i2 = AIOUtils.b(paramBaseChatItemLayout.stickerHeight, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject = new ApolloPlayerParams(this.jdField_a_of_type_AndroidContentContext, i1, i2);
      paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer = ((IApolloBrickPlayer)QRoute.api(IApolloBrickPlayer.class));
      paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.setParams((ApolloPlayerParams)localObject);
      localObject = paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.getView();
      if ((localObject != null) && (((View)localObject).getParent() == null))
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i2);
        localLayoutParams.addRule(3, 2131374042);
        ((View)localObject).setPadding(m, BaseChatItemLayout.v, n, BaseChatItemLayout.w);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramHolder.jdField_c_of_type_AndroidViewView = ((View)localObject);
      }
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer != null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer);
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
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.setPadding(m, BaseChatItemLayout.m, n, BaseChatItemLayout.n);
    }
    a(paramHolder.jdField_a_of_type_ComTencentImageURLImageView, 8);
    a(paramHolder.jdField_c_of_type_AndroidWidgetTextView, 8);
    a(paramHolder.jdField_a_of_type_AndroidWidgetTextView, 8);
    a(paramHolder.jdField_b_of_type_AndroidWidgetTextView, 8);
    a(paramHolder.jdField_a_of_type_AndroidWidgetImageView, 8);
    if ((paramMessageForApollo.isDoubleAction()) && (this.j)) {
      a(paramHolder.jdField_e_of_type_AndroidWidgetTextView, 0);
    } else {
      a(paramHolder.jdField_e_of_type_AndroidWidgetTextView, 8);
    }
    a(paramHolder.jdField_c_of_type_AndroidViewView, 0);
    ((ApolloBrickPlayerImpl)paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer).setMessageForApollo(paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramHolder.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer.start();
    a(paramHolder.jdField_d_of_type_AndroidWidgetImageView, 8);
    a(paramHolder.jdField_c_of_type_AndroidWidgetImageView, 8);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder, ApolloActionData paramApolloActionData)
  {
    int m = paramHolder.jdField_b_of_type_Int;
    int i1 = paramHolder.jdField_c_of_type_Int;
    int n = 1;
    if ((m == i1 - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (!a(paramMessageForApollo)))
    {
      if (paramMessageForApollo.extraflag == 32768)
      {
        m = n;
        if (paramMessageForApollo.isSendFromLocal()) {}
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramMessageForApollo))
      {
        m = n;
      }
      else
      {
        m = 0;
      }
      if (m == 0) {
        if ((this.h) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq))
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
          {
            if (paramMessageForApollo.isSend())
            {
              paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
              paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              return;
            }
            paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        else if ((!this.h) || (this.jdField_d_of_type_Long != paramMessageForApollo.uniseq))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo = paramMessageForApollo;
          c(paramMessageForApollo, paramBaseChatItemLayout, paramHolder);
        }
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder)
  {
    int m;
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {
      m = 1;
    } else {
      m = 0;
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (((!paramMessageForApollo.isSend()) && (localIApolloManagerService.isInActionPlayList(paramMessageForApollo.uniseq))) || ((!paramMessageForApollo.isSend()) && (m == 0)))
    {
      localIApolloManagerService.removeFromActionPlayList(Long.valueOf(paramMessageForApollo.uniseq).longValue());
      if (m != 0)
      {
        a(paramHolder, 1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloItemBuilder", 2, new Object[] { "showApolloAction status is not open:", Integer.valueOf(this.jdField_a_of_type_Int) });
      }
    }
    else if ((paramHolder.jdField_b_of_type_Int == paramHolder.jdField_c_of_type_Int - 1) && ((m != 0) || ((((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) && (paramMessageForApollo.isSend()) && (MessageCache.a() - paramMessageForApollo.time < 10L))))
    {
      if (this.k) {
        h();
      }
      a(paramHolder, paramMessageForApollo.isSend() ^ true);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.4(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new ApolloItemBuilder.5(paramContext, paramInt, paramString));
  }
  
  private boolean a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null)
    {
      QLog.e("[cmshow]ApolloItemBuilder", 1, "errInfo->mr is null.");
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click game msg, roomId:");
      localStringBuilder.append(paramMessageForApollo.roomId);
      QLog.d("[cmshow]ApolloItemBuilder", 2, localStringBuilder.toString());
    }
    if ((paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.mApolloMessage.id != 99999)) {
      return !((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    }
    QQToast.a(paramView.getContext(), HardCodeUtil.a(2131700626), 0).a();
    return true;
  }
  
  private boolean a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder)
  {
    if ((paramHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage == null) {
        return true;
      }
      return !(paramHolder instanceof ApolloItemBuilder.Holder);
    }
    return true;
  }
  
  private AnimationDrawable b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838372), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838376), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838373), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838374), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838375), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838367), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838371), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838368), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838369), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838370), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private static void b(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = AnimationUtils.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n))
    {
      int m = ((BaseActivity)paramContext).getChatFragment().a().c();
      paramView.putInt("extra.AIO_CURRENT_PANEL_STATE", m);
      if (m == 1)
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
    paramSessionInfo.jdField_a_of_type_JavaLangString = CMGetResPathUtil.a((ApolloActionData)localObject, 0);
    localObject = ApolloGifDownloaderImpl.getApolloGifFilePath(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    PeakUtils.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  private void b(ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (!(paramHolder instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    a(paramHolder, false);
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.g)
    {
      if (paramHolder.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject).setId(2131374041);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(7, 2131374043);
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
      }
      if (paramHolder.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
        ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_f_of_type_Int);
        ((AnimationTextView)localObject).setMinWidth(AIOUtils.b(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
        ((ColorDrawable)localObject).setBounds(0, 0, AIOUtils.b(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan = new VerticalImageSpan((Drawable)localObject);
      }
      if (paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
      }
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
      int m = BaseChatItemLayout.o;
      int n = BaseChatItemLayout.p;
      int i1 = BaseChatItemLayout.o;
      if (paramBoolean)
      {
        m = BaseChatItemLayout.p;
        n = BaseChatItemLayout.o;
        i1 = BaseChatItemLayout.p;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, BaseChatItemLayout.m, n, BaseChatItemLayout.n);
      localObject = (ViewGroup.MarginLayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.m, 0, 0);
      ((ViewGroup.MarginLayoutParams)localObject).width = AIOUtils.b(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((ViewGroup.MarginLayoutParams)localObject).height = AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null) {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramHolder.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
      if (paramHolder.jdField_b_of_type_AndroidWidgetImageView == null)
      {
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject).setImageResource(2130839401);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
      }
    }
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    long l2 = 0L;
    Object localObject;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localObject = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(paramMessageForApollo.senderuin);
      if (localObject != null) {
        l1 = ((ApolloBaseInfo)localObject).apolloUpdateTime;
      } else {
        l1 = 0L;
      }
      if (NetConnInfoCenter.getServerTime() - l1 > 43200L) {
        localIApolloManagerService.addToBulkPullMap(paramMessageForApollo.senderuin, 2);
      } else if ((localObject != null) && (((ApolloBaseInfo)localObject).isApolloStatusOpen()) && (((ApolloBaseInfo)localObject).apolloServerTS != ((ApolloBaseInfo)localObject).apolloLocalTS)) {
        localIApolloManagerService.addToBulkPullMap(paramMessageForApollo.senderuin, 1);
      }
    }
    if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
      localStringBuilder.append("");
      if (!TextUtils.equals((CharSequence)localObject, localStringBuilder.toString()))
      {
        localObject = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
        localStringBuilder.append("");
        localObject = ((IApolloDaoManagerService)localObject).getApolloBaseInfoFromCache(localStringBuilder.toString());
        l1 = l2;
        if (localObject != null) {
          l1 = ((ApolloBaseInfo)localObject).apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 > 43200L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramMessageForApollo.mApolloMessage.peerUin);
          ((StringBuilder)localObject).append("");
          localIApolloManagerService.addToBulkPullMap(((StringBuilder)localObject).toString(), 2);
          return;
        }
        if ((localObject != null) && (((ApolloBaseInfo)localObject).isApolloStatusOpen()) && (((ApolloBaseInfo)localObject).apolloServerTS != ((ApolloBaseInfo)localObject).apolloLocalTS)) {
          localIApolloManagerService.addToBulkPullMap(((ApolloBaseInfo)localObject).uin, 1);
        }
      }
    }
  }
  
  private void b(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    ImageView localImageView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramHolder.jdField_d_of_type_AndroidWidgetImageView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131367028);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364521);
      localLayoutParams.addRule(15, 2131363435);
      localLayoutParams.leftMargin = 10;
      localImageView.setContentDescription(HardCodeUtil.a(2131700623));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130847347);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView = localImageView;
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    if (paramHolder.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131367027);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(0, 2131364521);
      localLayoutParams.addRule(15, 2131363435);
      localImageView.setContentDescription(HardCodeUtil.a(2131700627));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130847347);
      paramHolder.jdField_c_of_type_AndroidWidgetImageView = localImageView;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131364552);
    if ((paramMessageForApollo.mNeedTimeStamp) && (paramMessageForApollo.time > 0L) && (paramBaseChatItemLayout != null) && (paramMessageForApollo.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.b(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.b(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    }
    else
    {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramHolder.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    }
    paramHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean b()
  {
    return (!this.jdField_f_of_type_Boolean) || (a()) || (System.currentTimeMillis() - this.jdField_c_of_type_Long < 600L);
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      return false;
    }
    if (!((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(this.jdField_a_of_type_AndroidContentContext)) {
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (localApolloBaseInfo != null)
    {
      this.jdField_a_of_type_Int = localApolloBaseInfo.apolloStatus;
      if (this.jdField_a_of_type_Int == 2) {
        return false;
      }
    }
    int m = paramMessageForApollo.istroop;
    return SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void c(View paramView)
  {
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie != null)
    {
      EmoticonPanelCmShowHelper.a("1");
      localBaseChatPie.a(3);
      paramView.post(new ApolloItemBuilder.1(this, localBaseChatPie));
    }
  }
  
  private void c(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null)
    {
      a(1);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ApolloItemBuilder.3(this, paramMessageForApollo));
  }
  
  private void c(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, ApolloItemBuilder.Holder paramHolder)
  {
    ThreadManager.post(new ApolloItemBuilder.2(this, paramMessageForApollo, paramBaseChatItemLayout, paramHolder), 5, null, true);
  }
  
  private void d(MessageForApollo paramMessageForApollo)
  {
    ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (localApolloExtensionHandler != null)
    {
      ArrayList localArrayList = new ArrayList(2);
      Object localObject;
      int m;
      if (!paramMessageForApollo.isSend())
      {
        localObject = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(paramMessageForApollo.senderuin);
        if ((localObject == null) || (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime > 300L)) {
          localArrayList.add(paramMessageForApollo.senderuin);
        }
        if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
        {
          m = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("apollo status is not opened uin: ");
          ((StringBuilder)localObject).append(paramMessageForApollo.senderuin);
          ((StringBuilder)localObject).append(", status: ");
          ((StringBuilder)localObject).append(m);
          QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.peerUin > 0L) && (paramMessageForApollo.mApolloMessage.peerUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))
      {
        localObject = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
        localStringBuilder.append("");
        localObject = ((IApolloDaoManagerService)localObject).getApolloBaseInfoFromCache(localStringBuilder.toString());
        if (localObject != null) {
          if (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime <= 300L) {
            break label336;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
        localStringBuilder.append("");
        localArrayList.add(localStringBuilder.toString());
        label336:
        if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
        {
          m = ((ApolloBaseInfo)localObject).apolloStatus;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("apollo status is not opened uin: ");
          ((StringBuilder)localObject).append(paramMessageForApollo.mApolloMessage.peerUin);
          ((StringBuilder)localObject).append(", status: ");
          ((StringBuilder)localObject).append(m);
          QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (!localArrayList.isEmpty()) {
        localApolloExtensionHandler.a((String[])localArrayList.toArray(new String[0]));
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
      if (paramChatMessage.isNewAnimation())
      {
        if ((paramChatMessage.istroop == 1) && (paramChatMessage.isDoubleAction()) && (this.j)) {
          return 1;
        }
        return 0;
      }
    }
    if (this.g) {
      return 1;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (ApolloItemBuilder.Holder)paramView.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    if (this.g)
    {
      if (paramViewGroup.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramViewGroup.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return paramView;
    }
    if (paramViewGroup.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramViewGroup.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramOnLongClickAndTouchListener = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setPadding(AIOUtils.b(5.0F, paramChatMessage), 0, AIOUtils.b(5.0F, paramChatMessage), 0);
      localTextView.setBackgroundResource(2130842702);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(5, 2131364521);
      localLayoutParams.addRule(3, 2131364521);
      localLayoutParams.topMargin = AIOUtils.b(-3.0F, paramChatMessage);
      localLayoutParams.leftMargin = AIOUtils.b(12.0F, paramChatMessage);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = localTextView;
      paramOnLongClickAndTouchListener.addView(localTextView, localLayoutParams);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700628));
    paramOnLongClickAndTouchListener = paramChatMessage.getDrawable(2130838492);
    paramOnLongClickAndTouchListener.setBounds(0, 0, paramOnLongClickAndTouchListener.getIntrinsicWidth(), paramOnLongClickAndTouchListener.getIntrinsicHeight());
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnLongClickAndTouchListener, null, null, null);
    paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(5.0F, paramChatMessage), 0, AIOUtils.b(5.0F, paramChatMessage), 0);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {
      return paramView;
    }
    ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    if (paramView != null)
    {
      paramViewHolder = paramView;
      if (localHolder != null)
      {
        paramViewHolder = paramView;
        if (localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131374043);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewHolder;
    }
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramChatMessage = (MessageForApollo)paramChatMessage;
    this.g = b(paramChatMessage);
    return a(paramChatMessage, localHolder, paramViewHolder, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ApolloItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131700624));
    localStringBuilder.append(paramChatMessage.msg);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("this:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(", destroy(),apollo check game dialog dismiss");
      QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IApolloBrickPlayer)((Iterator)localObject).next()).destroy();
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
    ApolloAioBubbleReportUtil.a.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if (!(paramChatMessage instanceof MessageForApollo)) {
        return;
      }
      MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
      boolean bool = localMessageForApollo.isNewAnimation();
      if (paramInt != 2131365480)
      {
        if (paramInt != 2131366494)
        {
          if (paramInt != 2131371562)
          {
            super.a(paramInt, paramContext, paramChatMessage);
            return;
          }
          super.a(paramInt, paramContext, paramChatMessage);
          ApolloAioBubbleReportUtil.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageForApollo, bool);
          return;
        }
        if ((localMessageForApollo != null) && (localMessageForApollo.mApolloMessage != null))
        {
          if (localMessageForApollo.isNewAnimation()) {
            c(localMessageForApollo);
          } else {
            a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
          }
          ApolloAioBubbleReportUtil.a.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageForApollo);
        }
      }
      else
      {
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        ApolloAioBubbleReportUtil.a.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageForApollo, bool);
      }
    }
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(View paramView)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onErrorIconClick err code: ");
        ((StringBuilder)localObject).append(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode);
        ((StringBuilder)localObject).append(", extraflag: ");
        ((StringBuilder)localObject).append(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
        QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      a(paramView);
      Object localObject = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject).getApolloBaseInfoFromCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
      ApolloActionData localApolloActionData = ((IApolloDaoManagerService)localObject).findActionById(paramView.jdField_e_of_type_Int);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_c_of_type_Int) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690041));
        localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690040), 1);
        paramView.jdField_f_of_type_Int = 1;
        QZoneVipInfoManager.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_d_of_type_Int) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690041));
        localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690040), 1);
        paramView.jdField_f_of_type_Int = 2;
        QZoneVipInfoManager.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_f_of_type_Int) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!((IApolloDaoManagerService)localObject).isObtainActionById(localApolloActionData.actionId))))
      {
        localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690038));
        localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690037), 1);
        paramView.jdField_f_of_type_Int = 3;
      }
      else if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_e_of_type_Int)
      {
        localActionSheet.setMainTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690039));
        paramView.jdField_f_of_type_Int = 4;
      }
      else
      {
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
          return;
        }
        localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690043), 1);
      }
      a(paramView, localActionSheet, localApolloActionData);
      return;
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramView = (ApolloItemBuilder.Holder)paramView;
    if (paramInt1 == 1)
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
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
      if (localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 2) {
        return;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    }
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloMessageUtilImpl.setReaded(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if ((paramView != null) && ((AIOUtils.a(paramView) instanceof ApolloItemBuilder.Holder)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).removeFromActionDownloadList(paramMessageForApollo.mApolloMessage.id);
      }
      ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
      if (!super.a(paramMessageForApollo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      if ((paramView instanceof BaseChatItemLayout))
      {
        if (paramMessageForApollo.actionType == 5) {
          paramView = b(paramMessageForApollo.isSend());
        } else {
          paramView = a(paramMessageForApollo.isSend());
        }
        if ((paramView != null) && (localHolder.jdField_a_of_type_AndroidWidgetImageView != null))
        {
          localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
          paramView.start();
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramViewHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    if (paramBubbleInfo == null) {
      return;
    }
    if (paramViewHolder.jdField_e_of_type_AndroidWidgetTextView != null) {
      a(paramView, paramChatMessage, paramBubbleInfo, paramViewHolder.jdField_e_of_type_AndroidWidgetTextView);
    }
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
      a(paramView, paramChatMessage, paramBubbleInfo, paramViewHolder.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = AIOUtils.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramBaseChatItemLayout2 = AIOUtils.a(paramBaseChatItemLayout1);
    if (!(paramBaseChatItemLayout2 instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    localObject = (ApolloItemBuilder.Holder)localObject;
    paramBaseChatItemLayout2 = (ApolloItemBuilder.Holder)paramBaseChatItemLayout2;
    if (((ApolloItemBuilder.Holder)localObject).jdField_e_of_type_Int == paramBaseChatItemLayout2.jdField_e_of_type_Int) {
      a(paramBaseChatItemLayout1, paramInt1, paramInt2);
    }
  }
  
  protected void a(ApolloItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder = (MessageForApollo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramHolder.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = (ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      ISpriteBridge localISpriteBridge = ((ISpriteScriptManager)localObject).getSpriteBridge();
      localObject = ((ISpriteScriptManager)localObject).getSpriteContext();
      if (this.jdField_a_of_type_Int != 1) {
        ((ISpriteContext)localObject).a(true);
      }
      if (localISpriteBridge != null) {
        localISpriteBridge.a(paramInt, paramHolder);
      }
    }
  }
  
  void a(ApolloItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
  {
    if (paramHolder != null) {
      if (paramResources == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = jdField_b_of_type_Float;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramResources.getDrawable(2130838493);
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramResources.getDrawable(2130838495);
        if (!paramBoolean) {
          break label281;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(paramHolder.jdField_e_of_type_Int + l));
        File localFile = new File(ApolloGifDownloaderImpl.getApolloGifFilePath(paramHolder.jdField_e_of_type_Int));
        if (localFile.exists())
        {
          paramResources = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
          paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          paramResources = URLDrawable.getDrawable(paramResources, (URLDrawable.URLDrawableOptions)localObject);
          paramResources.setTag(Integer.valueOf(paramHolder.jdField_e_of_type_Int));
          paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
          paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
          if (paramResources.getStatus() == 0) {
            paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("actionId->");
          ((StringBuilder)localObject).append(paramHolder.jdField_e_of_type_Int);
          ((StringBuilder)localObject).append(" drawable.getStatus()->");
          ((StringBuilder)localObject).append(paramResources.getStatus());
          QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Throwable paramHolder)
      {
        QLog.e("[cmshow]ApolloItemBuilder", 1, paramHolder.getMessage());
      }
      return;
      label281:
      long l = 0L;
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
      AnimationDrawable localAnimationDrawable;
      if (paramMessageForApollo.actionType == 5) {
        localAnimationDrawable = b(paramMessageForApollo.isSend());
      } else {
        localAnimationDrawable = a(paramMessageForApollo.isSend());
      }
      if (localAnimationDrawable != null)
      {
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
      }
      localIApolloManagerService.removeFromActionDownloadList(paramHolder.jdField_e_of_type_Int);
      if (!paramMessageForApollo.hasPlayed) {
        ApolloMessageUtilImpl.setReaded(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
    else
    {
      int m;
      if (paramMessageForApollo.actionType == 5)
      {
        if (paramMessageForApollo.isSend()) {
          m = 2130838372;
        } else {
          m = 2130838367;
        }
      }
      else if (paramMessageForApollo.isSend()) {
        m = 2130838378;
      } else {
        m = 2130838362;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(m);
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
          paramObject = (AnimationDrawable)paramObject;
          paramObject.stop();
          paramObject.selectDrawable(0);
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
    int m = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    return ((paramMessageForApollo.is3dAction()) && (m != 2)) || ((!paramMessageForApollo.is3dAction()) && (this.jdField_a_of_type_Int == 2));
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    boolean bool;
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      bool = localMessageForApollo.isNewAnimation();
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction()) && (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (!bool)) {
        localQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131690019), 2130838437);
      } else if ((bool) && (CmShowWnsUtils.l())) {
        localQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131691896), 2130838437);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371562, paramView, new Bundle());
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365480, paramView, new Bundle());
      ApolloAioBubbleReportUtil.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool, localMessageForApollo);
    }
    else
    {
      bool = false;
    }
    if (!bool) {
      super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    }
    return localQQCustomMenu.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131374041);
      if (paramView != null)
      {
        int m;
        if (paramMessageForApollo.actionType == 5)
        {
          if (paramMessageForApollo.isSend()) {
            m = 2130838372;
          } else {
            m = 2130838367;
          }
        }
        else if (paramMessageForApollo.isSend()) {
          m = 2130838378;
        } else {
          m = 2130838362;
        }
        paramView.setImageResource(m);
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
      {
        this.k = false;
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("apollo_invite_gray_tip");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
        SharedPreferences localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        if (localSharedPreferences.getBoolean((String)localObject1, true))
        {
          Object localObject4 = ((IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfoFromCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((localObject4 != null) && (!((ApolloBaseInfo)localObject4).isApolloStatusOpen()))
          {
            long l = MessageCache.a();
            localObject4 = HardCodeUtil.a(2131700622);
            Bundle localBundle = new Bundle();
            localBundle.putInt("key_action", 1);
            localBundle.putString("textColor", "#40A0FF");
            localBundle.putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
            localObject2 = new UniteGrayTipParam((String)localObject2, (String)localObject3, (String)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
            int m = ((String)localObject4).indexOf(HardCodeUtil.a(2131700620));
            ((UniteGrayTipParam)localObject2).a(m, m + 2, localBundle);
            localObject3 = new MessageForUniteGrayTip();
            ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject2);
            UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloItemBuilder", 2, "send apollo gray tip");
            }
            localSharedPreferences.edit().putBoolean((String)localObject1, false).commit();
            ApolloAioBubbleReportUtil.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject4);
          }
        }
      }
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramView = new StringBuilder();
    paramView.append("onLoadFailed id: ");
    paramView.append(paramURLDrawable.getTag());
    paramView.append(", status: ");
    paramView.append(paramURLDrawable.getStatus());
    QLog.e("[cmshow]ApolloItemBuilder", 1, paramView.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloItemBuilder", 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    paramView = (ApolloItemBuilder.Holder)paramView;
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloItemBuilder", 2, "onLoadSuccessed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */