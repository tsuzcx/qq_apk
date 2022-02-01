package com.tencent.mobileqq.activity.aio.item;

import aagn;
import acvv;
import aezf;
import afce;
import afuu;
import afuv;
import afuw;
import afux;
import afuy;
import afuz;
import afva;
import afvb;
import afvc;
import alnr;
import alof;
import amar;
import amau;
import amaz;
import amba;
import amge;
import amip;
import amir;
import amtj;
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
import anwk;
import apee;
import aucf;
import aucg;
import bbko;
import bgaz;
import bgbb;
import bhht;
import bjnw;
import bjon;
import bkkh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nmy;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  private alof jdField_a_of_type_Alof;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new afuw(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new afuy(this);
  private View.OnClickListener e = new afuz(this);
  public boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (DeviceInfoUtil.getDispalyDpi() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new afuv(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afux(this);
    paramQQAppInterface = (alnr)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Alof = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838448), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838449), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838450), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838449), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838448), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838451), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838452), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838451), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838432), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838433), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838434), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838433), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838432), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838435), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838436), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838435), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, afvb paramafvb, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramafvb == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    while (!(paramafvb instanceof afvb)) {
      return paramView;
    }
    label428:
    boolean bool3;
    if ((paramMessageForApollo != null) && (this.g))
    {
      b(paramafvb, paramMessageForApollo.isSend());
      a(paramMessageForApollo, paramView, paramafvb);
      paramafvb.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramafvb.jdField_a_of_type_ComTencentImageURLImageView != null) {
        paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      if (paramafvb.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramafvb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramafvb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramafvb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams;
      if (paramafvb.jdField_d_of_type_AndroidWidgetImageView == null)
      {
        paramafce = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramafce.setId(2131366929);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(1, 2131364441);
        localLayoutParams.addRule(15, 2131363354);
        localLayoutParams.leftMargin = 10;
        paramafce.setContentDescription(amtj.a(2131699553));
        paramBaseChatItemLayout.addView(paramafce, localLayoutParams);
        paramafce.setImageResource(2130847022);
        paramafvb.jdField_d_of_type_AndroidWidgetImageView = paramafce;
        paramafvb.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      if (paramafvb.jdField_c_of_type_AndroidWidgetImageView == null)
      {
        paramafce = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramafce.setId(2131366928);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(0, 2131364441);
        localLayoutParams.addRule(15, 2131363354);
        paramafce.setContentDescription(amtj.a(2131699557));
        paramBaseChatItemLayout.addView(paramafce, localLayoutParams);
        paramafce.setImageResource(2130847022);
        paramafvb.jdField_c_of_type_AndroidWidgetImageView = paramafce;
        paramafvb.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      paramafce = (TextView)paramBaseChatItemLayout.findViewById(2131364472);
      if ((paramMessageForApollo.mNeedTimeStamp) && (paramMessageForApollo.time > 0L) && (paramafce != null) && (paramMessageForApollo.time != ((Long)paramafce.getTag()).longValue()))
      {
        paramafvb.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
        paramafvb.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
        paramafvb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramafvb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramafce = ((amir)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
        a(paramMessageForApollo, paramBaseChatItemLayout, paramafvb, paramafce);
        if ((paramafvb.jdField_b_of_type_Int == paramafvb.jdField_c_of_type_Int - 1) && (paramafce != null) && (paramafce.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Alof != null) && (this.jdField_a_of_type_Alof.a(paramMessageForApollo))) {}
        a(paramMessageForApollo, paramafvb);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label821;
        }
        paramBaseChatItemLayout = (amaz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
        if (paramBaseChatItemLayout.a() != null) {
          bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
        }
        bool2 = bool1;
        if (paramBaseChatItemLayout.a() == null) {
          break label821;
        }
        bool3 = paramBaseChatItemLayout.a().c();
        bool2 = bool1;
      }
    }
    label821:
    for (bool1 = bool3;; bool1 = true)
    {
      a(paramMessageForApollo, paramafvb, bool2, bool1);
      a(paramMessageForApollo);
      return paramView;
      paramafvb.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramafvb.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      break label428;
      if (paramMessageForApollo != null)
      {
        b(paramafvb, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramafvb.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramafvb.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramafvb.e));
      }
      paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramafce);
      paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramafce);
      a(paramafvb, paramView.getResources(), false);
      if (paramafvb.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramafvb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramafvb.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramafvb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramafvb.jdField_a_of_type_AndroidWidgetImageView == null) {
        break;
      }
      paramafvb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramView;
    }
  }
  
  private bhht a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAuthcmShowDialog == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAuthcmShowDialog = new bhht(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAuthcmShowDialog;
    }
    return null;
  }
  
  private void a(afvb paramafvb)
  {
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(71);
    if (paramafvb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == amip.jdField_b_of_type_Int) {
      localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 1, "userClick");
    }
    do
    {
      return;
      if (paramafvb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == amip.e)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128, "userClick");
        return;
      }
      if (paramafvb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == amip.jdField_c_of_type_Int)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 2, "userClick");
        return;
      }
    } while (paramafvb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != amip.d);
    anwk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
  }
  
  private void a(afvb paramafvb, bjnw parambjnw, ApolloActionData paramApolloActionData)
  {
    parambjnw.c(2131690620);
    parambjnw.a(new afuu(this, paramafvb, paramApolloActionData, parambjnw));
    parambjnw.show();
  }
  
  static void a(afvb paramafvb, boolean paramBoolean)
  {
    int k = 0;
    if ((paramafvb.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramafvb.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramafvb.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramafvb.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        j = 8;
        ((ImageView)localObject).setVisibility(j);
      }
    }
    else
    {
      if (paramafvb.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramafvb.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        j = 8;
        label68:
        ((TextView)localObject).setVisibility(j);
      }
      if (paramafvb.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramafvb.jdField_a_of_type_ComTencentImageURLImageView;
        if (!paramBoolean) {
          break label155;
        }
      }
    }
    label150:
    label155:
    for (int j = 8;; j = 0)
    {
      ((URLImageView)localObject).setVisibility(j);
      if (paramafvb.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramafvb.jdField_b_of_type_AndroidWidgetImageView;
        j = k;
        if (paramBoolean) {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
      }
      if (paramafvb.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramafvb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      j = 0;
      break;
      j = 0;
      break label68;
    }
  }
  
  public static void a(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = aagn.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.isUpComingPrevious))
    {
      int j = ((FragmentActivity)paramContext).getChatFragment().a().getCurrentPanel();
      paramView.putInt("extra.AIO_CURRENT_PANEL_STATE", j);
      if (j == 1)
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
      paramView.putString("extra.GROUP_UIN", paramSessionInfo.curFriendUin);
      paramView.putString("uin", paramSessionInfo.curFriendUin);
      paramView.putInt("forward_source_uin_type", paramSessionInfo.curType);
    }
    localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramMessageForApollo.mApolloMessage.id;
    paramSessionInfo = new AIOImageData();
    paramSessionInfo.f = paramMessageForApollo.uniseq;
    paramSessionInfo.a = ApolloUtil.a((ApolloActionData)localObject, 0);
    localObject = afva.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    bkkh.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    alnr localalnr = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localalnr.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localalnr.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localalnr.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localalnr.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
      }
    }
    label227:
    while ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS))
    {
      return;
      l1 = 0L;
      break;
      if ((localApolloBaseInfo == null) || (!localApolloBaseInfo.isApolloStatusOpen()) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS)) {
        break label73;
      }
      localalnr.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localalnr.a(localApolloBaseInfo.uin, 1);
  }
  
  private void a(MessageForApollo paramMessageForApollo, afvb paramafvb)
  {
    int k = 0;
    if (amge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
    {
      j = 1;
      if (((paramMessageForApollo.isSend()) || (!alnr.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq)))) && ((paramMessageForApollo.isSend()) || (j != 0))) {
        break label121;
      }
      alnr.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
      if (j == 0) {
        break label87;
      }
      a(paramafvb, 1);
    }
    label87:
    label121:
    while ((paramafvb.jdField_b_of_type_Int != paramafvb.jdField_c_of_type_Int - 1) || ((j == 0) && ((amge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (!paramMessageForApollo.isSend()) || (bbko.a() - paramMessageForApollo.time >= 10L))))
    {
      do
      {
        return;
        j = 0;
        break;
      } while (!QLog.isColorLevel());
      QLog.d("ApolloItemBuilder", 2, new Object[] { "showApolloAction status is not open:", Integer.valueOf(this.jdField_c_of_type_Int) });
      return;
    }
    if (this.i) {
      e();
    }
    if (paramMessageForApollo.isSend()) {}
    for (int j = k;; j = 1)
    {
      a(paramafvb, j);
      return;
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView, afvb paramafvb)
  {
    if (paramMessageForApollo.mApolloMessage != null)
    {
      String str = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
      if (!TextUtils.isEmpty(str)) {
        paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(str);
      }
      if ((!paramMessageForApollo.isDoubleAction()) || (paramMessageForApollo.mApolloMessage.text == null) || (paramMessageForApollo.mApolloMessage.text.length <= 0)) {
        break label207;
      }
      paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
      }
    }
    for (;;)
    {
      paramafvb.e = paramMessageForApollo.mApolloMessage.id;
      paramView.setContentDescription(amtj.a(2131699551) + paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
      paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
      paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramafvb.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
      paramafvb.jdField_a_of_type_AndroidWidgetTextView.setText(paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder);
      return;
      label207:
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, afvb paramafvb)
  {
    ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramafvb), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, afvb paramafvb, ApolloActionData paramApolloActionData)
  {
    int j;
    if ((paramafvb.jdField_b_of_type_Int == paramafvb.jdField_c_of_type_Int - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (!a(paramMessageForApollo)))
    {
      if (((paramMessageForApollo.extraflag != 32768) || (!paramMessageForApollo.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramMessageForApollo))) {
        break label138;
      }
      j = 1;
      if (j == 0)
      {
        if ((!this.h) || (this.jdField_d_of_type_Long != paramMessageForApollo.uniseq)) {
          break label162;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
        {
          if (!paramMessageForApollo.isSend()) {
            break label144;
          }
          paramafvb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramafvb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
    label138:
    label144:
    label162:
    while ((this.h) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq))
    {
      return;
      j = 0;
      break;
      paramafvb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramafvb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
    a(paramMessageForApollo, paramBaseChatItemLayout, paramafvb);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new ApolloItemBuilder.3(paramContext, paramInt, paramString));
  }
  
  private AnimationDrawable b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838442), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838446), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838443), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838444), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838445), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838437), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838441), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838438), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838439), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838440), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(afvb paramafvb, boolean paramBoolean)
  {
    if (!(paramafvb instanceof afvb)) {}
    do
    {
      do
      {
        return;
        a(paramafvb, false);
        if (!this.g) {
          break;
        }
        if (paramafvb.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131373955);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131373956);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramafvb.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramafvb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramafvb.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.f);
          ((AnimationTextView)localObject).setMinWidth(AIOUtils.dp2px(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramafvb.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramafvb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramafvb.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramafvb.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramafvb.f = 0;
        if (paramafvb.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, AIOUtils.dp2px(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramafvb.jdField_a_of_type_AndroidTextStyleImageSpan = new afvc((Drawable)localObject);
        }
        if (paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramafvb.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
        int m = BaseChatItemLayout.o;
        int k = BaseChatItemLayout.p;
        int j = BaseChatItemLayout.o;
        if (paramBoolean)
        {
          m = BaseChatItemLayout.p;
          k = BaseChatItemLayout.o;
          j = BaseChatItemLayout.p;
        }
        paramafvb.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.m, k, BaseChatItemLayout.n);
        localObject = (ViewGroup.MarginLayoutParams)paramafvb.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.m, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = AIOUtils.dp2px(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramafvb.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramafvb.jdField_b_of_type_AndroidWidgetImageView == null);
      paramafvb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramafvb.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramafvb.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramafvb.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramafvb.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramafvb.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839445);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramafvb.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramafvb.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    Object localObject = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(71);
    if (localVasExtensionHandler != null)
    {
      ArrayList localArrayList = new ArrayList(2);
      int j;
      if (!paramMessageForApollo.isSend())
      {
        ApolloBaseInfo localApolloBaseInfo = ((alnr)localObject).a(paramMessageForApollo.senderuin);
        if ((localApolloBaseInfo == null) || (NetConnInfoCenter.getServerTime() - localApolloBaseInfo.apolloUpdateTime > 300L)) {
          localArrayList.add(paramMessageForApollo.senderuin);
        }
        if ((QLog.isColorLevel()) && (localApolloBaseInfo != null) && (!localApolloBaseInfo.isApolloStatusOpen()))
        {
          j = localApolloBaseInfo.apolloStatus;
          QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + paramMessageForApollo.senderuin + ", status: " + j);
        }
      }
      if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.peer_uin > 0L) && (paramMessageForApollo.mApolloMessage.peer_uin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()))
      {
        localObject = ((alnr)localObject).a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        if ((localObject == null) || (NetConnInfoCenter.getServerTime() - ((ApolloBaseInfo)localObject).apolloUpdateTime > 300L)) {
          localArrayList.add(paramMessageForApollo.mApolloMessage.peer_uin + "");
        }
        if ((QLog.isColorLevel()) && (localObject != null) && (!((ApolloBaseInfo)localObject).isApolloStatusOpen()))
        {
          j = ((ApolloBaseInfo)localObject).apolloStatus;
          QLog.d("ApolloItemBuilder", 2, "apollo status is not opened uin: " + paramMessageForApollo.mApolloMessage.peer_uin + ", status: " + j);
        }
      }
      if (!localArrayList.isEmpty()) {
        localVasExtensionHandler.a((String[])localArrayList.toArray(new String[0]));
      }
    }
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000)) {}
    while ((!alnr.b(this.jdField_a_of_type_AndroidContentContext)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) && (alnr.c("discuss") == 0))) {
      return false;
    }
    paramMessageForApollo = ((alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (paramMessageForApollo != null)
    {
      this.jdField_c_of_type_Int = paramMessageForApollo.apolloStatus;
      if (this.jdField_c_of_type_Int != 2) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return true;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if (this.g) {
      return 1;
    }
    return 2;
  }
  
  public aezf a()
  {
    return new afvb();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    paramafce = (afvb)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramafce.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramafce.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((amir)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramafce.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.f);
          paramChatMessage.setMinWidth(AIOUtils.dp2px(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(AIOUtils.dp2px(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842626);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(AIOUtils.dp2px(6.0F, (Resources)localObject1), 0, AIOUtils.dp2px(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364441);
          paramView.addRule(3, 2131364441);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = AIOUtils.dp2px(-3.0F, (Resources)localObject1);
          paramView.leftMargin = AIOUtils.dp2px(12.0F, (Resources)localObject1);
          paramafce.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramafce.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramafce.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.e);
        }
        paramafce.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = amtj.a(2131699555);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramafce.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838570);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramafce.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramafce.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramafce.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramafce.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramafce.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramafce.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramafce.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramafce.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(AIOUtils.dp2px(5.0F, paramChatMessage), 0, AIOUtils.dp2px(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842626);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364441);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364441);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(12.0F, paramChatMessage);
      paramafce.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramafce.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramafce.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramafce.jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131699558));
    paramView = paramChatMessage.getDrawable(2130838568);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramafce.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramafce.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(5.0F, paramChatMessage), 0, AIOUtils.dp2px(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramaezf instanceof afvb)) {
      return paramView;
    }
    paramaezf = (afvb)paramaezf;
    if ((paramView == null) || ((paramaezf != null) && (paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131373956);
      paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramafce);
      paramChatMessage.setOnLongClickListener(paramafce);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramaezf, paramChatMessage, paramBaseChatItemLayout, paramafce);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return amtj.a(2131699554) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForApollo))) {}
    MessageForApollo localMessageForApollo;
    do
    {
      do
      {
        do
        {
          return;
          localMessageForApollo = (MessageForApollo)paramChatMessage;
          switch (paramInt)
          {
          default: 
            super.a(paramInt, paramContext, paramChatMessage);
            return;
          case 2131365382: 
            acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          }
        } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_del", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
        return;
      } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
      a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
      return;
      super.a(paramChatMessage);
    } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_withdraw", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = ((amir)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / DeviceInfoUtil.density);
      localObject1 = ApolloUtil.a(((TextView)localObject1).getPaint(), 208.0F, (String)localObject2, 3);
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
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690028), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(71);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((VasExtensionHandler)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131690072);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    if (!(paramaezf instanceof afvb)) {}
    afvb localafvb;
    do
    {
      return;
      localafvb = (afvb)paramaezf;
    } while ((paramapee == null) || (localafvb.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramapee.a == 0) || (!paramapee.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaezf = paramView.getColorStateList(2131167035);
        if (paramaezf != null) {
          localafvb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaezf);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramaezf = paramView.getColorStateList(2131167034);; paramaezf = paramView.getColorStateList(2131167033))
      {
        localafvb.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaezf);
        return;
        paramaezf = paramView.getColorStateList(2131167031);
        break;
      }
    }
    if (paramapee.jdField_b_of_type_Int == 0) {
      localafvb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramapee.jdField_c_of_type_Int == 0)
    {
      localafvb.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167033));
      return;
      localafvb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
    }
    localafvb.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramapee.jdField_c_of_type_Int);
  }
  
  public void a(afvb paramafvb, int paramInt)
  {
    paramafvb = (MessageForApollo)paramafvb.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramafvb.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = (amaz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      amar localamar = ((amaz)localObject).a();
      localObject = ((amaz)localObject).a();
      if (this.jdField_c_of_type_Int != 1) {
        ((amau)localObject).e(true);
      }
      if (localamar != null) {
        localamar.a(paramInt, paramafvb);
      }
    }
  }
  
  public void a(afvb paramafvb, Resources paramResources, boolean paramBoolean)
  {
    if ((paramafvb == null) || (paramResources == null)) {
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838569);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838571);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramafvb.e));
        File localFile = new File(afva.a(paramafvb.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramafvb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramafvb.e + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramafvb) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramafvb.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramafvb.e));
      paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramafvb.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramafvb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramafvb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (afvb)AIOUtils.getHolder(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      a(paramView);
      ApolloBaseInfo localApolloBaseInfo = ((alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
      amir localamir = (amir)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      ApolloActionData localApolloActionData = localamir.a(paramView.e);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == amip.jdField_b_of_type_Int) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690040));
        localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690039), 1);
        paramView.f = 1;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == amip.jdField_c_of_type_Int) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690040));
        localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690039), 1);
        paramView.f = 2;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == amip.e) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localamir.b(localApolloActionData.actionId))))
      {
        localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690037));
        localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690036), 1);
        paramView.f = 3;
      }
      for (;;)
      {
        a(paramView, localbjnw, localApolloActionData);
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == amip.d)
        {
          localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690038));
          paramView.f = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690042), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.getHolder(paramView);
    if (!(paramView instanceof afvb)) {}
    alnr localalnr;
    do
    {
      do
      {
        return;
        paramView = (afvb)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        alnr.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!alnr.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        alnr.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localalnr = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while ((localalnr != null) && (localalnr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    }
    afvb localafvb;
    if ((paramView != null) && ((AIOUtils.getHolder(paramView) instanceof afvb)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        alnr.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localafvb = (afvb)AIOUtils.getHolder(paramView);
      if (!super.a(paramMessageForApollo, localafvb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localafvb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      if ((paramView instanceof BaseChatItemLayout)) {
        if (paramMessageForApollo.actionType != 5) {
          break label152;
        }
      }
    }
    label152:
    for (paramView = b(paramMessageForApollo.isSend());; paramView = a(paramMessageForApollo.isSend()))
    {
      if ((paramView != null) && (localafvb.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localafvb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = AIOUtils.getHolder(paramBaseChatItemLayout2);
    if (!(localObject instanceof afvb)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = AIOUtils.getHolder(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof afvb));
      localObject = (afvb)localObject;
      paramBaseChatItemLayout2 = (afvb)paramBaseChatItemLayout2;
    } while (((afvb)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, afvb paramafvb, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramafvb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (alnr.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramafvb.e)))
    {
      localObject = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((localObject != null) && (((alnr)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) != 2) && (paramBoolean2)) {
        paramafvb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean1)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramafvb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        alnr.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramafvb.e));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        }
        return;
      }
    }
    int j;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        j = 2130838442;
      }
    }
    for (;;)
    {
      paramafvb.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      return;
      j = 2130838437;
      continue;
      if (paramMessageForApollo.isSend()) {
        j = 2130838448;
      } else {
        j = 2130838432;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (nmy.a().a(paramMessageForApollo.frienduin)) {}
    int j;
    do
    {
      return true;
      j = alnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    } while (((paramMessageForApollo.is3dAction()) && (j != 2)) || ((!paramMessageForApollo.is3dAction()) && (this.jdField_c_of_type_Int == 2)));
    return false;
  }
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    paramView = AIOUtils.getMessage(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
      return localbgaz.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction()) && (amge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)) {
        localbgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131690024), 2130838504);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbgaz, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    return localbgaz.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int j;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131373955);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        j = 2130838442;
      }
    }
    for (;;)
    {
      paramView.setImageResource(j);
      return;
      label51:
      j = 2130838437;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        j = 2130838448;
      } else {
        j = 2130838432;
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    label14:
    String str1;
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
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0));
          this.i = false;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
          str1 = "apollo_invite_gray_tip" + (String)localObject2 + "_" + (String)localObject1;
          localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        } while (!localSharedPreferences.getBoolean(str1, true));
        localObject3 = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((alnr)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = bbko.a();
    String str2 = amtj.a(2131699552);
    int j = str2.indexOf(amtj.a(2131699550));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new aucf((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, -5040, 2359297, l);
    ((aucf)localObject1).a(j, j + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aucf)localObject1);
    aucg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (afvb)AIOUtils.getHolder(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (afvb)AIOUtils.getHolder(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (afvb)AIOUtils.getHolder(paramView);
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
    paramView = AIOUtils.getHolder(paramView);
    if (!(paramView instanceof afvb)) {}
    do
    {
      return;
      paramView = (afvb)paramView;
      if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */