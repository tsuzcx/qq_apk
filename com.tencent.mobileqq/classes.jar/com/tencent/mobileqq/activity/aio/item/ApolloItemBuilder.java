package com.tencent.mobileqq.activity.aio.item;

import abke;
import aean;
import agej;
import aggl;
import agjk;
import agyi;
import agyj;
import agyk;
import agyl;
import agym;
import agyn;
import agyo;
import agyp;
import agyq;
import amsx;
import amtl;
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
import anfx;
import anga;
import angf;
import angg;
import anlk;
import annv;
import annx;
import anzj;
import apcx;
import aqkt;
import avpd;
import avpe;
import bcrg;
import bhlo;
import bhnv;
import bhuk;
import bhum;
import bjbs;
import blir;
import blji;
import bmgb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
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
import nlj;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  private amtl jdField_a_of_type_Amtl;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new agyk(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new agym(this);
  private View.OnClickListener e = new agyn(this);
  public boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (bhlo.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new agyj(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agyl(this);
    paramQQAppInterface = (amsx)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Amtl = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838423), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838424), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838425), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838424), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838423), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838426), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838427), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838426), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838407), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838408), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838409), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838408), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838407), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838410), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838411), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838410), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, agyp paramagyp, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramagyp == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    while (!(paramagyp instanceof agyp)) {
      return paramView;
    }
    label427:
    boolean bool3;
    if ((paramMessageForApollo != null) && (this.g))
    {
      b(paramagyp, paramMessageForApollo.isSend());
      a(paramMessageForApollo, paramView, paramagyp);
      paramagyp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramagyp.jdField_a_of_type_ComTencentImageURLImageView != null) {
        paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      if (paramagyp.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramagyp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramagyp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramagyp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams;
      if (paramagyp.jdField_d_of_type_AndroidWidgetImageView == null)
      {
        paramagjk = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramagjk.setId(2131366905);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(1, 2131364423);
        localLayoutParams.addRule(15, 2131363324);
        localLayoutParams.leftMargin = 10;
        paramagjk.setContentDescription(anzj.a(2131699318));
        paramBaseChatItemLayout.addView(paramagjk, localLayoutParams);
        paramagjk.setImageResource(2130847114);
        paramagyp.jdField_d_of_type_AndroidWidgetImageView = paramagjk;
        paramagyp.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      if (paramagyp.jdField_c_of_type_AndroidWidgetImageView == null)
      {
        paramagjk = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramagjk.setId(2131366904);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(0, 2131364423);
        localLayoutParams.addRule(15, 2131363324);
        paramagjk.setContentDescription(anzj.a(2131699322));
        paramBaseChatItemLayout.addView(paramagjk, localLayoutParams);
        paramagjk.setImageResource(2130847114);
        paramagyp.jdField_c_of_type_AndroidWidgetImageView = paramagjk;
        paramagyp.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      paramagjk = (TextView)paramBaseChatItemLayout.findViewById(2131364454);
      if ((paramMessageForApollo.mNeedTimeStamp) && (paramMessageForApollo.time > 0L) && (paramagjk != null) && (paramMessageForApollo.time != ((Long)paramagjk.getTag()).longValue()))
      {
        paramagyp.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
        paramagyp.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, agej.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
        paramagyp.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramagyp.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramagjk = ((annx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
        a(paramMessageForApollo, paramBaseChatItemLayout, paramagyp, paramagjk);
        if ((paramagyp.jdField_b_of_type_Int == paramagyp.jdField_c_of_type_Int - 1) && (paramagjk != null) && (paramagjk.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Amtl != null) && (this.jdField_a_of_type_Amtl.a(paramMessageForApollo))) {}
        a(paramMessageForApollo, paramagyp);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label820;
        }
        paramBaseChatItemLayout = (angf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
        if (paramBaseChatItemLayout.a() != null) {
          bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
        }
        bool2 = bool1;
        if (paramBaseChatItemLayout.a() == null) {
          break label820;
        }
        bool3 = paramBaseChatItemLayout.a().c();
        bool2 = bool1;
      }
    }
    label820:
    for (bool1 = bool3;; bool1 = true)
    {
      a(paramMessageForApollo, paramagyp, bool2, bool1);
      a(paramMessageForApollo);
      return paramView;
      paramagyp.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, agej.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramagyp.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, agej.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      break label427;
      if (paramMessageForApollo != null)
      {
        b(paramagyp, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramagyp.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramagyp.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramagyp.e));
      }
      paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramagjk);
      paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramagjk);
      a(paramagyp, paramView.getResources(), false);
      if (paramagyp.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramagyp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramagyp.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramagyp.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramagyp.jdField_a_of_type_AndroidWidgetImageView == null) {
        break;
      }
      paramagyp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramView;
    }
  }
  
  private bjbs a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new bjbs(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  private void a(agyp paramagyp)
  {
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (paramagyp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == annv.jdField_b_of_type_Int) {
      localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1, "userClick");
    }
    do
    {
      return;
      if (paramagyp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == annv.e)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "userClick");
        return;
      }
      if (paramagyp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == annv.jdField_c_of_type_Int)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, "userClick");
        return;
      }
    } while (paramagyp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != annv.d);
    apcx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
  }
  
  private void a(agyp paramagyp, blir paramblir, ApolloActionData paramApolloActionData)
  {
    paramblir.c(2131690580);
    paramblir.a(new agyi(this, paramagyp, paramApolloActionData, paramblir));
    paramblir.show();
  }
  
  static void a(agyp paramagyp, boolean paramBoolean)
  {
    int k = 0;
    if ((paramagyp.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramagyp.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramagyp.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramagyp.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        j = 8;
        ((ImageView)localObject).setVisibility(j);
      }
    }
    else
    {
      if (paramagyp.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramagyp.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        j = 8;
        label68:
        ((TextView)localObject).setVisibility(j);
      }
      if (paramagyp.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramagyp.jdField_a_of_type_ComTencentImageURLImageView;
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
      if (paramagyp.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramagyp.jdField_b_of_type_AndroidWidgetImageView;
        j = k;
        if (paramBoolean) {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
      }
      if (paramagyp.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramagyp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    Object localObject = abke.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n))
    {
      int j = ((FragmentActivity)paramContext).getChatFragment().a().g();
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
      paramView.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
    }
    localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramMessageForApollo.mApolloMessage.id;
    paramSessionInfo = new AIOImageData();
    paramSessionInfo.f = paramMessageForApollo.uniseq;
    paramSessionInfo.jdField_a_of_type_JavaLangString = ApolloUtil.a((ApolloActionData)localObject, 0);
    localObject = agyo.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    bmgb.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localamsx.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localamsx.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localamsx.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localamsx.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
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
      localamsx.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localamsx.a(localApolloBaseInfo.uin, 1);
  }
  
  private void a(MessageForApollo paramMessageForApollo, agyp paramagyp)
  {
    int k = 0;
    if (anlk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
    {
      j = 1;
      if (((paramMessageForApollo.isSend()) || (!amsx.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq)))) && ((paramMessageForApollo.isSend()) || (j != 0))) {
        break label121;
      }
      amsx.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
      if (j == 0) {
        break label87;
      }
      a(paramagyp, 1);
    }
    label87:
    label121:
    while ((paramagyp.jdField_b_of_type_Int != paramagyp.jdField_c_of_type_Int - 1) || ((j == 0) && ((anlk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (!paramMessageForApollo.isSend()) || (bcrg.a() - paramMessageForApollo.time >= 10L))))
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
      a(paramagyp, j);
      return;
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView, agyp paramagyp)
  {
    if (paramMessageForApollo.mApolloMessage != null)
    {
      String str = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
      if (!TextUtils.isEmpty(str)) {
        paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(str);
      }
      if ((!paramMessageForApollo.isDoubleAction()) || (paramMessageForApollo.mApolloMessage.text == null) || (paramMessageForApollo.mApolloMessage.text.length <= 0)) {
        break label207;
      }
      paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
      }
    }
    for (;;)
    {
      paramagyp.e = paramMessageForApollo.mApolloMessage.id;
      paramView.setContentDescription(anzj.a(2131699316) + paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
      paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
      paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramagyp.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
      paramagyp.jdField_a_of_type_AndroidWidgetTextView.setText(paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder);
      return;
      label207:
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agyp paramagyp)
  {
    ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramagyp), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agyp paramagyp, ApolloActionData paramApolloActionData)
  {
    int j;
    if ((paramagyp.jdField_b_of_type_Int == paramagyp.jdField_c_of_type_Int - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (!a(paramMessageForApollo)))
    {
      if (((paramMessageForApollo.extraflag != 32768) || (!paramMessageForApollo.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMessageForApollo))) {
        break label138;
      }
      j = 1;
      if (j == 0)
      {
        if ((!this.h) || (this.jdField_d_of_type_Long != paramMessageForApollo.uniseq)) {
          break label162;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
        {
          if (!paramMessageForApollo.isSend()) {
            break label144;
          }
          paramagyp.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramagyp.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
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
      paramagyp.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramagyp.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
    a(paramMessageForApollo, paramBaseChatItemLayout, paramagyp);
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
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838417), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838421), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838418), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838419), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838420), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838412), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838416), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838413), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838414), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838415), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(agyp paramagyp, boolean paramBoolean)
  {
    if (!(paramagyp instanceof agyp)) {}
    do
    {
      do
      {
        return;
        a(paramagyp, false);
        if (!this.g) {
          break;
        }
        if (paramagyp.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131374210);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131374211);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramagyp.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramagyp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramagyp.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.f);
          ((AnimationTextView)localObject).setMinWidth(agej.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramagyp.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramagyp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramagyp.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramagyp.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramagyp.f = 0;
        if (paramagyp.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, agej.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramagyp.jdField_a_of_type_AndroidTextStyleImageSpan = new agyq((Drawable)localObject);
        }
        if (paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramagyp.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int m = BaseChatItemLayout.o;
        int k = BaseChatItemLayout.p;
        int j = BaseChatItemLayout.o;
        if (paramBoolean)
        {
          m = BaseChatItemLayout.p;
          k = BaseChatItemLayout.o;
          j = BaseChatItemLayout.p;
        }
        paramagyp.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.m, k, BaseChatItemLayout.n);
        localObject = (ViewGroup.MarginLayoutParams)paramagyp.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.m, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = agej.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = agej.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramagyp.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramagyp.jdField_b_of_type_AndroidWidgetImageView == null);
      paramagyp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramagyp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramagyp.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(agej.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramagyp.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramagyp.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramagyp.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839410);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramagyp.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramagyp.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    Object localObject = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (localVasExtensionHandler != null)
    {
      ArrayList localArrayList = new ArrayList(2);
      int j;
      if (!paramMessageForApollo.isSend())
      {
        ApolloBaseInfo localApolloBaseInfo = ((amsx)localObject).a(paramMessageForApollo.senderuin);
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
        localObject = ((amsx)localObject).a(paramMessageForApollo.mApolloMessage.peer_uin + "");
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
    while ((!amsx.b(this.jdField_a_of_type_AndroidContentContext)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (amsx.c("discuss") == 0))) {
      return false;
    }
    paramMessageForApollo = ((amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
  
  public aggl a()
  {
    return new agyp();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramagjk = (agyp)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramagjk.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramagjk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((annx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramagjk.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.f);
          paramChatMessage.setMinWidth(agej.a(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(agej.a(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842581);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(agej.a(6.0F, (Resources)localObject1), 0, agej.a(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364423);
          paramView.addRule(3, 2131364423);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = agej.a(-3.0F, (Resources)localObject1);
          paramView.leftMargin = agej.a(12.0F, (Resources)localObject1);
          paramagjk.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramagjk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramagjk.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.e);
        }
        paramagjk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = anzj.a(2131699320);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramagjk.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838545);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramagjk.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramagjk.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramagjk.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramagjk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramagjk.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramagjk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramagjk.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramagjk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(agej.a(5.0F, paramChatMessage), 0, agej.a(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842581);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364423);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364423);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = agej.a(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(12.0F, paramChatMessage);
      paramagjk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramagjk.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramagjk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramagjk.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131699323));
    paramView = paramChatMessage.getDrawable(2130838543);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramagjk.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramagjk.jdField_c_of_type_AndroidWidgetTextView.setPadding(agej.a(5.0F, paramChatMessage), 0, agej.a(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramaggl instanceof agyp)) {
      return paramView;
    }
    paramaggl = (agyp)paramaggl;
    if ((paramView == null) || ((paramaggl != null) && (paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131374211);
      paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramagjk);
      paramChatMessage.setOnLongClickListener(paramagjk);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramaggl, paramChatMessage, paramBaseChatItemLayout, paramagjk);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anzj.a(2131699319) + paramChatMessage.msg;
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
          case 2131365352: 
            aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          }
        } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_del", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
        return;
      } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
      a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
      return;
      super.a(paramChatMessage);
    } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_withdraw", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = ((annx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / bhlo.a);
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
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690009), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((VasExtensionHandler)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131690053);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    if (!(paramaggl instanceof agyp)) {}
    agyp localagyp;
    do
    {
      return;
      localagyp = (agyp)paramaggl;
    } while ((paramaqkt == null) || (localagyp.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaggl = paramView.getColorStateList(2131167013);
        if (paramaggl != null) {
          localagyp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramaggl = paramView.getColorStateList(2131167012);; paramaggl = paramView.getColorStateList(2131167011))
      {
        localagyp.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaggl);
        return;
        paramaggl = paramView.getColorStateList(2131167009);
        break;
      }
    }
    if (paramaqkt.jdField_b_of_type_Int == 0) {
      localagyp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramaqkt.jdField_c_of_type_Int == 0)
    {
      localagyp.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167011));
      return;
      localagyp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
    }
    localagyp.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqkt.jdField_c_of_type_Int);
  }
  
  public void a(agyp paramagyp, int paramInt)
  {
    paramagyp = (MessageForApollo)paramagyp.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramagyp.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = (angf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      anfx localanfx = ((angf)localObject).a();
      localObject = ((angf)localObject).a();
      if (this.jdField_c_of_type_Int != 1) {
        ((anga)localObject).e(true);
      }
      if (localanfx != null) {
        localanfx.a(paramInt, paramagyp);
      }
    }
  }
  
  public void a(agyp paramagyp, Resources paramResources, boolean paramBoolean)
  {
    if ((paramagyp == null) || (paramResources == null)) {
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838544);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838546);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramagyp.e));
        File localFile = new File(agyo.a(paramagyp.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramagyp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramagyp.e + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramagyp) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramagyp.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramagyp.e));
      paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramagyp.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramagyp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramagyp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (agyp)agej.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      a(paramView);
      ApolloBaseInfo localApolloBaseInfo = ((amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
      annx localannx = (annx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      ApolloActionData localApolloActionData = localannx.a(paramView.e);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == annv.jdField_b_of_type_Int) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690021));
        localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690020), 1);
        paramView.f = 1;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == annv.jdField_c_of_type_Int) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690021));
        localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690020), 1);
        paramView.f = 2;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == annv.e) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localannx.b(localApolloActionData.actionId))))
      {
        localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690018));
        localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690017), 1);
        paramView.f = 3;
      }
      for (;;)
      {
        a(paramView, localblir, localApolloActionData);
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == annv.d)
        {
          localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690019));
          paramView.f = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690023), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = agej.a(paramView);
    if (!(paramView instanceof agyp)) {}
    amsx localamsx;
    do
    {
      do
      {
        return;
        paramView = (agyp)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        amsx.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!amsx.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        amsx.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while ((localamsx != null) && (localamsx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    agyp localagyp;
    if ((paramView != null) && ((agej.a(paramView) instanceof agyp)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        amsx.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localagyp = (agyp)agej.a(paramView);
      if (!super.a(paramMessageForApollo, localagyp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localagyp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localagyp.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localagyp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = agej.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof agyp)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = agej.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof agyp));
      localObject = (agyp)localObject;
      paramBaseChatItemLayout2 = (agyp)paramBaseChatItemLayout2;
    } while (((agyp)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, agyp paramagyp, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramagyp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (amsx.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramagyp.e)))
    {
      localObject = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((localObject != null) && (((amsx)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2) && (paramBoolean2)) {
        paramagyp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean1)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramagyp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        amsx.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramagyp.e));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        return;
      }
    }
    int j;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        j = 2130838417;
      }
    }
    for (;;)
    {
      paramagyp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      return;
      j = 2130838412;
      continue;
      if (paramMessageForApollo.isSend()) {
        j = 2130838423;
      } else {
        j = 2130838407;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (nlj.a().a(paramMessageForApollo.frienduin)) {}
    int j;
    do
    {
      return true;
      j = amsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (((paramMessageForApollo.is3dAction()) && (j != 2)) || ((!paramMessageForApollo.is3dAction()) && (this.jdField_c_of_type_Int == 2)));
    return false;
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = agej.a(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
      return localbhuk.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction()) && (anlk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)) {
        localbhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131690005), 2130838479);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbhuk, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int j;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131374210);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        j = 2130838417;
      }
    }
    for (;;)
    {
      paramView.setImageResource(j);
      return;
      label51:
      j = 2130838412;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        j = 2130838423;
      } else {
        j = 2130838407;
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
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0));
          this.i = false;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
          str1 = "apollo_invite_gray_tip" + (String)localObject2 + "_" + (String)localObject1;
          localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        } while (!localSharedPreferences.getBoolean(str1, true));
        localObject3 = (amsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((amsx)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = bcrg.a();
    String str2 = anzj.a(2131699317);
    int j = str2.indexOf(anzj.a(2131699315));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new avpd((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((avpd)localObject1).a(j, j + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avpd)localObject1);
    avpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (agyp)agej.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (agyp)agej.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (agyp)agej.a(paramView);
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
    paramView = agej.a(paramView);
    if (!(paramView instanceof agyp)) {}
    do
    {
      return;
      paramView = (agyp)paramView;
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