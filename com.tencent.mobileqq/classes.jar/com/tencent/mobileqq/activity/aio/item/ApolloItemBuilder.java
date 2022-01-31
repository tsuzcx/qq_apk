package com.tencent.mobileqq.activity.aio.item;

import aaod;
import actn;
import acun;
import acxn;
import adkx;
import adky;
import adkz;
import adla;
import adlb;
import adlc;
import adld;
import adle;
import adlf;
import airz;
import aism;
import ajey;
import ajfg;
import ajfh;
import ajmu;
import ajmw;
import ajyc;
import akvj;
import ambh;
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
import aquz;
import aqva;
import awzw;
import bbct;
import bbev;
import bblr;
import bblt;
import bbqp;
import bcpq;
import bfol;
import bfoy;
import bgkh;
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
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mye;
import xpx;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  private aism jdField_a_of_type_Aism;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new adkz(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new adlb(this);
  private View.OnClickListener e = new adlc(this);
  public boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (bbct.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new adky(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adla(this);
    paramQQAppInterface = (airz)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Aism = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838234), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838238), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838242), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838238), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838234), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838243), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838244), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838243), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838218), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838219), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838220), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838219), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838218), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838221), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838222), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838221), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, adle paramadle, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    boolean bool2 = false;
    if ((paramadle == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    label630:
    do
    {
      do
      {
        return paramView;
      } while (!(paramadle instanceof adle));
      if ((paramMessageForApollo != null) && (this.g))
      {
        b(paramadle, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null)
        {
          paramacxn = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
          if (!TextUtils.isEmpty(paramacxn)) {
            paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramacxn);
          }
          if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
          {
            paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
            if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
            }
            paramadle.e = paramMessageForApollo.mApolloMessage.id;
          }
        }
        else
        {
          paramView.setContentDescription(ajyc.a(2131700392) + paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
          paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
          paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramadle.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
          paramadle.jdField_a_of_type_AndroidWidgetTextView.setText(paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder);
          paramadle.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if (paramadle.jdField_a_of_type_ComTencentImageURLImageView != null) {
            paramadle.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          }
          if (paramadle.jdField_c_of_type_AndroidWidgetTextView != null) {
            paramadle.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          paramadle.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramadle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams;
          if (paramadle.jdField_d_of_type_AndroidWidgetImageView == null)
          {
            paramacxn = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramacxn.setId(2131366477);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(1, 2131364110);
            localLayoutParams.addRule(15, 2131363077);
            localLayoutParams.leftMargin = 10;
            paramacxn.setContentDescription(ajyc.a(2131700394));
            paramBaseChatItemLayout.addView(paramacxn, localLayoutParams);
            paramacxn.setImageResource(2130846197);
            paramadle.jdField_d_of_type_AndroidWidgetImageView = paramacxn;
            paramadle.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          if (paramadle.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            paramacxn = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramacxn.setId(2131366476);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(0, 2131364110);
            localLayoutParams.addRule(15, 2131363077);
            paramacxn.setContentDescription(ajyc.a(2131700398));
            paramBaseChatItemLayout.addView(paramacxn, localLayoutParams);
            paramacxn.setImageResource(2130846197);
            paramadle.jdField_c_of_type_AndroidWidgetImageView = paramacxn;
            paramadle.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          paramacxn = (TextView)paramBaseChatItemLayout.findViewById(2131364141);
          if ((!paramMessageForApollo.mNeedTimeStamp) || (paramMessageForApollo.time <= 0L) || (paramacxn == null) || (paramMessageForApollo.time == ((Long)paramacxn.getTag()).longValue())) {
            break label992;
          }
          paramadle.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, actn.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadle.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, actn.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadle.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramadle.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramacxn = ((ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
          if ((paramadle.jdField_b_of_type_Int == paramadle.jdField_c_of_type_Int - 1) && (paramacxn != null) && (paramacxn.actionType != 5) && (a(paramMessageForApollo)))
          {
            if (((paramMessageForApollo.extraflag != 32768) || (!paramMessageForApollo.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMessageForApollo))) {
              break label1041;
            }
            j = 1;
            if (j == 0)
            {
              if ((!this.h) || (this.jdField_d_of_type_Long != paramMessageForApollo.uniseq)) {
                break label1067;
              }
              if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramMessageForApollo.isSend()) {
                  break label1047;
                }
                paramadle.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                paramadle.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
          }
          if (((paramadle.jdField_b_of_type_Int == paramadle.jdField_c_of_type_Int - 1) && (paramacxn != null) && (paramacxn.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Aism != null) && (this.jdField_a_of_type_Aism.a(paramMessageForApollo))) && ((paramMessageForApollo.isSend()) || (!airz.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq))))) {
            break label1112;
          }
          airz.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
          a(paramadle, 1);
        }
        while (paramadle.jdField_b_of_type_Int != paramadle.jdField_c_of_type_Int - 1)
        {
          boolean bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            paramBaseChatItemLayout = (ajfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
            bool1 = bool2;
            if (paramBaseChatItemLayout.a() != null) {
              bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
            }
          }
          a(paramMessageForApollo, paramadle, bool1);
          a(paramMessageForApollo);
          return paramView;
          if (TextUtils.isEmpty(paramMessageForApollo.inputText)) {
            break;
          }
          paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
          break;
          paramadle.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, actn.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadle.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, actn.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          break label630;
          j = 0;
          break label742;
          paramadle.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramadle.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          break label800;
          if ((this.h) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq)) {
            break label800;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
          ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramadle), 5, null, true);
          break label800;
        }
        if (this.i) {
          e();
        }
        if (paramMessageForApollo.isSend()) {}
        for (int j = 0;; j = 1)
        {
          a(paramadle, j);
          break;
        }
      }
      if (paramMessageForApollo != null)
      {
        b(paramadle, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramadle.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramadle.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramadle.e));
      }
      paramadle.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramadle.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramacxn);
      paramadle.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramadle.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramacxn);
      a(paramadle, paramView.getResources(), false);
      if (paramadle.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramadle.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramadle.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramadle.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (paramadle.jdField_a_of_type_AndroidWidgetImageView == null);
    label742:
    paramadle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    label800:
    label992:
    return paramView;
  }
  
  private bcpq a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new bcpq(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  static void a(adle paramadle, boolean paramBoolean)
  {
    int k = 0;
    if ((paramadle.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramadle.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramadle.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramadle.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        j = 8;
        ((ImageView)localObject).setVisibility(j);
      }
    }
    else
    {
      if (paramadle.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramadle.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        j = 8;
        label68:
        ((TextView)localObject).setVisibility(j);
      }
      if (paramadle.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramadle.jdField_a_of_type_ComTencentImageURLImageView;
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
      if (paramadle.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramadle.jdField_b_of_type_AndroidWidgetImageView;
        j = k;
        if (paramBoolean) {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
      }
      if (paramadle.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramadle.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    Object localObject = xpx.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)))
    {
      int j = ((FragmentActivity)paramContext).getChatFragment().a().f();
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
    localObject = adld.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    bgkh.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    airz localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localairz.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localairz.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localairz.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localairz.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
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
      localairz.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localairz.a(localApolloBaseInfo.uin, 1);
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
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838228), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838232), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838229), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838230), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838231), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838223), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838227), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838224), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838225), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838226), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(adle paramadle, boolean paramBoolean)
  {
    if (!(paramadle instanceof adle)) {}
    do
    {
      do
      {
        return;
        a(paramadle, false);
        if (!this.g) {
          break;
        }
        if (paramadle.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131372876);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131372877);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramadle.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramadle.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramadle.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
          ((AnimationTextView)localObject).setMinWidth(actn.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramadle.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramadle.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramadle.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramadle.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramadle.f = 0;
        if (paramadle.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, actn.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramadle.jdField_a_of_type_AndroidTextStyleImageSpan = new adlf((Drawable)localObject);
        }
        if (paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramadle.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int m = BaseChatItemLayout.n;
        int k = BaseChatItemLayout.o;
        int j = BaseChatItemLayout.n;
        if (paramBoolean)
        {
          m = BaseChatItemLayout.o;
          k = BaseChatItemLayout.n;
          j = BaseChatItemLayout.o;
        }
        paramadle.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.l, k, BaseChatItemLayout.m);
        localObject = (ViewGroup.MarginLayoutParams)paramadle.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.l, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = actn.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = actn.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramadle.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramadle.jdField_b_of_type_AndroidWidgetImageView == null);
      paramadle.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramadle.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramadle.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(actn.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramadle.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramadle.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramadle.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839140);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramadle.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramadle.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000)) {
      return false;
    }
    if (!airz.a(this.jdField_a_of_type_AndroidContentContext)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (airz.c("discuss") == 0)) {
      return false;
    }
    paramMessageForApollo = ((airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (paramMessageForApollo != null)
    {
      this.jdField_c_of_type_Int = paramMessageForApollo.apolloStatus;
      return airz.a(paramMessageForApollo);
    }
    return false;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if (this.g) {
      return 1;
    }
    return 2;
  }
  
  public acun a()
  {
    return new adle();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    paramacxn = (adle)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramacxn.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramacxn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramacxn.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.e);
          paramChatMessage.setMinWidth(actn.a(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(actn.a(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842091);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(actn.a(6.0F, (Resources)localObject1), 0, actn.a(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364110);
          paramView.addRule(3, 2131364110);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = actn.a(-3.0F, (Resources)localObject1);
          paramView.leftMargin = actn.a(12.0F, (Resources)localObject1);
          paramacxn.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramacxn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramacxn.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.e);
        }
        paramacxn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = ajyc.a(2131700396);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramacxn.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838365);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramacxn.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramacxn.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actn.a(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramacxn.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramacxn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramacxn.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramacxn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramacxn.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramacxn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(actn.a(5.0F, paramChatMessage), 0, actn.a(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842091);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364110);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364110);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = actn.a(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = actn.a(12.0F, paramChatMessage);
      paramacxn.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramacxn.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramacxn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramacxn.jdField_c_of_type_AndroidWidgetTextView.setText(ajyc.a(2131700399));
    paramView = paramChatMessage.getDrawable(2130838363);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramacxn.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramacxn.jdField_c_of_type_AndroidWidgetTextView.setPadding(actn.a(5.0F, paramChatMessage), 0, actn.a(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramacun instanceof adle)) {
      return paramView;
    }
    paramacun = (adle)paramacun;
    if ((paramView == null) || ((paramacun != null) && (paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131372877);
      paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramacxn);
      paramChatMessage.setOnLongClickListener(paramacxn);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramacun, paramChatMessage, paramBaseChatItemLayout, paramacxn);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajyc.a(2131700395) + paramChatMessage.msg;
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
          case 2131364985: 
            aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
    Object localObject3 = ((ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / bbct.a);
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
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690064), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((bbqp)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131690129);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    if (!(paramacun instanceof adle)) {}
    adle localadle;
    do
    {
      return;
      localadle = (adle)paramacun;
    } while ((paramambh == null) || (localadle.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramambh.jdField_a_of_type_Int == 0) || (!paramambh.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacun = paramView.getColorStateList(2131166876);
        if (paramacun != null) {
          localadle.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacun);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramacun = paramView.getColorStateList(2131166875);; paramacun = paramView.getColorStateList(2131166874))
      {
        localadle.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacun);
        return;
        paramacun = paramView.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambh.jdField_b_of_type_Int == 0) {
      localadle.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramambh.jdField_c_of_type_Int == 0)
    {
      localadle.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
      return;
      localadle.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambh.jdField_b_of_type_Int);
    }
    localadle.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramambh.jdField_c_of_type_Int);
  }
  
  public void a(adle paramadle, int paramInt)
  {
    paramadle = (MessageForApollo)paramadle.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramadle.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ajey localajey = ((ajfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a();
      if (localajey != null) {
        localajey.a(paramInt, paramadle);
      }
    }
  }
  
  public void a(adle paramadle, Resources paramResources, boolean paramBoolean)
  {
    if ((paramadle == null) || (paramResources == null)) {
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838364);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838366);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramadle.e));
        File localFile = new File(adld.a(paramadle.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramadle.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramadle.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramadle.e + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramadle) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramadle.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramadle.e));
      paramadle.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramadle.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramadle.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramadle.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (adle)actn.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      Object localObject = (bbqp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajmu.jdField_b_of_type_Int) {
        ((bbqp)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1, "userClick");
      }
      bfol localbfol;
      ajmw localajmw;
      ApolloActionData localApolloActionData;
      for (;;)
      {
        localObject = ((airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
        localajmw = (ajmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
        localApolloActionData = localajmw.a(paramView.e);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ajmu.jdField_b_of_type_Int) || (localObject == null) || (((ApolloBaseInfo)localObject).apolloVipFlag == 1)) {
          break;
        }
        localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690080));
        localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690079), 1);
        paramView.f = 1;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajmu.e) {
          ((bbqp)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "userClick");
        } else if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajmu.jdField_c_of_type_Int) {
          ((bbqp)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, "userClick");
        } else if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajmu.d) {
          akvj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajmu.jdField_c_of_type_Int) && (localApolloActionData != null) && (localObject != null) && (localApolloActionData.vipLevel < ((ApolloBaseInfo)localObject).apolloVipLevel))
      {
        localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690080));
        localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690079), 1);
        paramView.f = 2;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajmu.e) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localajmw.b(localApolloActionData.actionId))))
      {
        localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690077));
        localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690076), 1);
        paramView.f = 3;
      }
      for (;;)
      {
        localbfol.c(2131690596);
        localbfol.a(new adkx(this, paramView, localApolloActionData, localbfol));
        localbfol.show();
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajmu.d)
        {
          localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690078));
          paramView.f = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690086), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = actn.a(paramView);
    if (!(paramView instanceof adle)) {}
    airz localairz;
    do
    {
      do
      {
        return;
        paramView = (adle)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        airz.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!airz.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        airz.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while ((localairz != null) && (localairz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    adle localadle;
    if ((paramView != null) && ((actn.a(paramView) instanceof adle)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        airz.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localadle = (adle)actn.a(paramView);
      if (!super.a(paramMessageForApollo, localadle.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localadle.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localadle.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localadle.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = actn.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof adle)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = actn.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof adle));
      localObject = (adle)localObject;
      paramBaseChatItemLayout2 = (adle)paramBaseChatItemLayout2;
    } while (((adle)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, adle paramadle, boolean paramBoolean)
  {
    paramadle.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (airz.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramadle.e)))
    {
      localObject = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((localObject != null) && (((airz)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2)) {
        paramadle.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramadle.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        airz.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramadle.e));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        return;
      }
    }
    int j;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        j = 2130838228;
      }
    }
    for (;;)
    {
      paramadle.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      return;
      j = 2130838223;
      continue;
      if (paramMessageForApollo.isSend()) {
        j = 2130838234;
      } else {
        j = 2130838218;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (mye.a().a(paramMessageForApollo.frienduin)) {}
    int j;
    do
    {
      return false;
      j = airz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (((paramMessageForApollo.is3dAction()) && (j != 2)) || ((!paramMessageForApollo.is3dAction()) && (j != 1)));
    return true;
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    paramView = actn.a(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
      return localbblr.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction())) {
        localbblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131690060), 2130838306);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbblr, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int j;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131372876);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        j = 2130838228;
      }
    }
    for (;;)
    {
      paramView.setImageResource(j);
      return;
      label51:
      j = 2130838223;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        j = 2130838234;
      } else {
        j = 2130838218;
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
        localObject3 = (airz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((airz)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = awzw.a();
    String str2 = ajyc.a(2131700393);
    int j = str2.indexOf(ajyc.a(2131700391));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new aquz((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((aquz)localObject1).a(j, j + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aquz)localObject1);
    aqva.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (adle)actn.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (adle)actn.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (adle)actn.a(paramView);
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
    paramView = actn.a(paramView);
    if (!(paramView instanceof adle)) {}
    do
    {
      return;
      paramView = (adle)paramView;
      if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */