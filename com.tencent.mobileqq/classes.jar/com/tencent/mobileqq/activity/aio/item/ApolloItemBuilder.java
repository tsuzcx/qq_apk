package com.tencent.mobileqq.activity.aio.item;

import aael;
import aciy;
import acju;
import acmv;
import aczv;
import aczw;
import aczx;
import aczy;
import aczz;
import adaa;
import adab;
import adac;
import adad;
import aifg;
import aift;
import aisa;
import aisi;
import aisj;
import aiys;
import aiyu;
import ajjy;
import akgx;
import almt;
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
import aqax;
import aqay;
import awao;
import babp;
import badq;
import bajr;
import bakh;
import bakj;
import baot;
import bbms;
import begr;
import behe;
import bfcq;
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
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mnf;
import xgx;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  private aift jdField_a_of_type_Aift;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new aczx(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new aczz(this);
  private View.OnClickListener e = new adaa(this);
  public boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (babp.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aczw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aczy(this);
    paramQQAppInterface = (aifg)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Aift = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838226), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838227), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838228), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838227), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838226), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838229), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838230), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838229), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838210), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838211), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838212), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838211), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838210), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838213), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838214), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838213), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, adac paramadac, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    boolean bool2 = false;
    if ((paramadac == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    label630:
    do
    {
      do
      {
        return paramView;
      } while (!(paramadac instanceof adac));
      if ((paramMessageForApollo != null) && (this.g))
      {
        b(paramadac, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null)
        {
          paramacmv = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
          if (!TextUtils.isEmpty(paramacmv)) {
            paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramacmv);
          }
          if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
          {
            paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
            if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
            }
            paramadac.e = paramMessageForApollo.mApolloMessage.id;
          }
        }
        else
        {
          paramView.setContentDescription(ajjy.a(2131634604) + paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
          paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
          paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramadac.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
          paramadac.jdField_a_of_type_AndroidWidgetTextView.setText(paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder);
          paramadac.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if (paramadac.jdField_a_of_type_ComTencentImageURLImageView != null) {
            paramadac.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          }
          if (paramadac.jdField_c_of_type_AndroidWidgetTextView != null) {
            paramadac.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          paramadac.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramadac.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams;
          if (paramadac.jdField_d_of_type_AndroidWidgetImageView == null)
          {
            paramacmv = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramacmv.setId(2131300868);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(1, 2131298552);
            localLayoutParams.addRule(15, 2131297536);
            localLayoutParams.leftMargin = 10;
            paramacmv.setContentDescription(ajjy.a(2131634606));
            paramBaseChatItemLayout.addView(paramacmv, localLayoutParams);
            paramacmv.setImageResource(2130846016);
            paramadac.jdField_d_of_type_AndroidWidgetImageView = paramacmv;
            paramadac.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          if (paramadac.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            paramacmv = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramacmv.setId(2131300867);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(0, 2131298552);
            localLayoutParams.addRule(15, 2131297536);
            paramacmv.setContentDescription(ajjy.a(2131634610));
            paramBaseChatItemLayout.addView(paramacmv, localLayoutParams);
            paramacmv.setImageResource(2130846016);
            paramadac.jdField_c_of_type_AndroidWidgetImageView = paramacmv;
            paramadac.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          paramacmv = (TextView)paramBaseChatItemLayout.findViewById(2131298583);
          if ((!paramMessageForApollo.mNeedTimeStamp) || (paramMessageForApollo.time <= 0L) || (paramacmv == null) || (paramMessageForApollo.time == ((Long)paramacmv.getTag()).longValue())) {
            break label992;
          }
          paramadac.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, aciy.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadac.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, aciy.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadac.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramadac.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramacmv = ((aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
          if ((paramadac.jdField_b_of_type_Int == paramadac.jdField_c_of_type_Int - 1) && (paramacmv != null) && (paramacmv.actionType != 5) && (a(paramMessageForApollo)))
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
                paramadac.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                paramadac.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
          }
          if (((paramadac.jdField_b_of_type_Int == paramadac.jdField_c_of_type_Int - 1) && (paramacmv != null) && (paramacmv.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Aift != null) && (this.jdField_a_of_type_Aift.a(paramMessageForApollo))) && ((paramMessageForApollo.isSend()) || (!aifg.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq))))) {
            break label1112;
          }
          aifg.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
          a(paramadac, 1);
        }
        while (paramadac.jdField_b_of_type_Int != paramadac.jdField_c_of_type_Int - 1)
        {
          boolean bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            paramBaseChatItemLayout = (aisi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
            bool1 = bool2;
            if (paramBaseChatItemLayout.a() != null) {
              bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
            }
          }
          a(paramMessageForApollo, paramadac, bool1);
          a(paramMessageForApollo);
          return paramView;
          if (TextUtils.isEmpty(paramMessageForApollo.inputText)) {
            break;
          }
          paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
          break;
          paramadac.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, aciy.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadac.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, aciy.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          break label630;
          j = 0;
          break label742;
          paramadac.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramadac.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          break label800;
          if ((this.h) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq)) {
            break label800;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
          ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramadac), 5, null, true);
          break label800;
        }
        if (this.i) {
          e();
        }
        if (paramMessageForApollo.isSend()) {}
        for (int j = 0;; j = 1)
        {
          a(paramadac, j);
          break;
        }
      }
      if (paramMessageForApollo != null)
      {
        b(paramadac, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramadac.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramadac.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramadac.e));
      }
      paramadac.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramadac.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramacmv);
      paramadac.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramadac.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramacmv);
      a(paramadac, paramView.getResources(), false);
      if (paramadac.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramadac.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramadac.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramadac.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (paramadac.jdField_a_of_type_AndroidWidgetImageView == null);
    label742:
    paramadac.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    label800:
    label992:
    return paramView;
  }
  
  private bbms a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new bbms(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  static void a(adac paramadac, boolean paramBoolean)
  {
    int k = 0;
    if ((paramadac.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramadac.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramadac.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramadac.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        j = 8;
        ((ImageView)localObject).setVisibility(j);
      }
    }
    else
    {
      if (paramadac.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramadac.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        j = 8;
        label68:
        ((TextView)localObject).setVisibility(j);
      }
      if (paramadac.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramadac.jdField_a_of_type_ComTencentImageURLImageView;
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
      if (paramadac.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramadac.jdField_b_of_type_AndroidWidgetImageView;
        j = k;
        if (paramBoolean) {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
      }
      if (paramadac.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramadac.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    Object localObject = xgx.a(paramView);
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
    localObject = adab.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    bfcq.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    aifg localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localaifg.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localaifg.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localaifg.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localaifg.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
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
      localaifg.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localaifg.a(localApolloBaseInfo.uin, 1);
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
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838220), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838224), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838221), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838222), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838223), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838215), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838219), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838216), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838217), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838218), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(adac paramadac, boolean paramBoolean)
  {
    if (!(paramadac instanceof adac)) {}
    do
    {
      do
      {
        return;
        a(paramadac, false);
        if (!this.g) {
          break;
        }
        if (paramadac.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131307164);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131307165);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramadac.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramadac.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramadac.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
          ((AnimationTextView)localObject).setMinWidth(aciy.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramadac.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramadac.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramadac.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramadac.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramadac.f = 0;
        if (paramadac.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, aciy.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramadac.jdField_a_of_type_AndroidTextStyleImageSpan = new adad((Drawable)localObject);
        }
        if (paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramadac.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int m = BaseChatItemLayout.n;
        int k = BaseChatItemLayout.o;
        int j = BaseChatItemLayout.n;
        if (paramBoolean)
        {
          m = BaseChatItemLayout.o;
          k = BaseChatItemLayout.n;
          j = BaseChatItemLayout.o;
        }
        paramadac.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.l, k, BaseChatItemLayout.m);
        localObject = (ViewGroup.MarginLayoutParams)paramadac.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.l, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = aciy.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = aciy.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramadac.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramadac.jdField_b_of_type_AndroidWidgetImageView == null);
      paramadac.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramadac.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramadac.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(aciy.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramadac.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramadac.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramadac.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839113);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramadac.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramadac.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000)) {
      return false;
    }
    if (!aifg.a(this.jdField_a_of_type_AndroidContentContext)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (aifg.c("discuss") == 0)) {
      return false;
    }
    paramMessageForApollo = ((aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (paramMessageForApollo != null)
    {
      this.jdField_c_of_type_Int = paramMessageForApollo.apolloStatus;
      return aifg.a(paramMessageForApollo);
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
  
  public acju a()
  {
    return new adac();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramacmv = (adac)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramacmv.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramacmv.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramacmv.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.e);
          paramChatMessage.setMinWidth(aciy.a(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(aciy.a(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130841999);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(aciy.a(6.0F, (Resources)localObject1), 0, aciy.a(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131298552);
          paramView.addRule(3, 2131298552);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = aciy.a(-3.0F, (Resources)localObject1);
          paramView.leftMargin = aciy.a(12.0F, (Resources)localObject1);
          paramacmv.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramacmv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramacmv.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.e);
        }
        paramacmv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = ajjy.a(2131634608);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramacmv.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838357);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramacmv.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramacmv.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramacmv.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramacmv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramacmv.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramacmv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramacmv.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramacmv.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(aciy.a(5.0F, paramChatMessage), 0, aciy.a(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130841999);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131298552);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131298552);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = aciy.a(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = aciy.a(12.0F, paramChatMessage);
      paramacmv.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramacmv.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramacmv.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramacmv.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634611));
    paramView = paramChatMessage.getDrawable(2130838355);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramacmv.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramacmv.jdField_c_of_type_AndroidWidgetTextView.setPadding(aciy.a(5.0F, paramChatMessage), 0, aciy.a(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramacju instanceof adac)) {
      return paramView;
    }
    paramacju = (adac)paramacju;
    if ((paramView == null) || ((paramacju != null) && (paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131307165);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramacmv);
      paramChatMessage.setOnLongClickListener(paramacmv);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramacju, paramChatMessage, paramBaseChatItemLayout, paramacmv);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajjy.a(2131634607) + paramChatMessage.msg;
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
          case 2131299417: 
            aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          }
        } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_del", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
        return;
      } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
      a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
      return;
      super.a(paramChatMessage);
    } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_withdraw", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = ((aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / babp.a);
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
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131624510), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (baot)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((baot)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131624575);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    if (!(paramacju instanceof adac)) {}
    adac localadac;
    do
    {
      return;
      localadac = (adac)paramacju;
    } while ((paramalmt == null) || (localadac.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramalmt.jdField_a_of_type_Int == 0) || (!paramalmt.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacju = paramView.getColorStateList(2131101282);
        if (paramacju != null) {
          localadac.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacju);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramacju = paramView.getColorStateList(2131101281);; paramacju = paramView.getColorStateList(2131101280))
      {
        localadac.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacju);
        return;
        paramacju = paramView.getColorStateList(2131101278);
        break;
      }
    }
    if (paramalmt.jdField_b_of_type_Int == 0) {
      localadac.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramalmt.jdField_c_of_type_Int == 0)
    {
      localadac.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131101280));
      return;
      localadac.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramalmt.jdField_b_of_type_Int);
    }
    localadac.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramalmt.jdField_c_of_type_Int);
  }
  
  public void a(adac paramadac, int paramInt)
  {
    paramadac = (MessageForApollo)paramadac.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramadac.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      aisa localaisa = ((aisi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a();
      if (localaisa != null) {
        localaisa.a(paramInt, paramadac);
      }
    }
  }
  
  public void a(adac paramadac, Resources paramResources, boolean paramBoolean)
  {
    if ((paramadac == null) || (paramResources == null)) {
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838356);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838358);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramadac.e));
        File localFile = new File(adab.a(paramadac.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramadac.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramadac.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramadac.e + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramadac) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramadac.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramadac.e));
      paramadac.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramadac.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramadac.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramadac.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (adac)aciy.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      Object localObject = (baot)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      begr localbegr;
      aiyu localaiyu;
      ApolloActionData localApolloActionData;
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == aiys.jdField_b_of_type_Int)
      {
        ((baot)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1, "userClick");
        localObject = ((aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
        localaiyu = (aiyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
        localApolloActionData = localaiyu.a(paramView.e);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != aiys.jdField_b_of_type_Int) || (localObject == null) || (((ApolloBaseInfo)localObject).apolloVipFlag == 1)) {
          break label357;
        }
        localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624526));
        localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624525), 1);
        paramView.f = 1;
      }
      for (;;)
      {
        label241:
        localbegr.c(2131625035);
        localbegr.a(new aczv(this, paramView, localApolloActionData, localbegr));
        localbegr.show();
        label357:
        do
        {
          return;
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == aiys.e)
          {
            ((baot)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "userClick");
            break;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == aiys.jdField_c_of_type_Int)
          {
            ((baot)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, "userClick");
            break;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != aiys.d) {
            break;
          }
          akgx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          break;
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == aiys.jdField_c_of_type_Int) && (localApolloActionData != null) && (localObject != null) && (localApolloActionData.vipLevel < ((ApolloBaseInfo)localObject).apolloVipLevel))
          {
            localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624526));
            localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624525), 1);
            paramView.f = 2;
            break label241;
          }
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == aiys.e) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localaiyu.b(localApolloActionData.actionId))))
          {
            localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624523));
            localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624522), 1);
            paramView.f = 3;
            break label241;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == aiys.d)
          {
            localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624524));
            paramView.f = 4;
            break label241;
          }
        } while ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)));
        localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131624532), 1);
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = aciy.a(paramView);
    if (!(paramView instanceof adac)) {}
    aifg localaifg;
    do
    {
      do
      {
        return;
        paramView = (adac)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        aifg.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!aifg.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        aifg.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while ((localaifg != null) && (localaifg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    adac localadac;
    if ((paramView != null) && ((aciy.a(paramView) instanceof adac)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        aifg.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localadac = (adac)aciy.a(paramView);
      if (!super.a(paramMessageForApollo, localadac.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localadac.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localadac.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localadac.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = aciy.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof adac)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = aciy.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof adac));
      localObject = (adac)localObject;
      paramBaseChatItemLayout2 = (adac)paramBaseChatItemLayout2;
    } while (((adac)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, adac paramadac, boolean paramBoolean)
  {
    paramadac.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (aifg.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramadac.e)))
    {
      localObject = (aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((localObject != null) && (((aifg)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2)) {
        paramadac.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramadac.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        aifg.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramadac.e));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        return;
      }
    }
    int j;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        j = 2130838220;
      }
    }
    for (;;)
    {
      paramadac.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      return;
      j = 2130838215;
      continue;
      if (paramMessageForApollo.isSend()) {
        j = 2130838226;
      } else {
        j = 2130838210;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (mnf.a().a(paramMessageForApollo.frienduin)) {}
    int j;
    do
    {
      return false;
      j = aifg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (((paramMessageForApollo.is3dAction()) && (j != 2)) || ((!paramMessageForApollo.is3dAction()) && (j != 1)));
    return true;
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = aciy.a(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
      return localbakh.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction())) {
        localbakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131624506), 2130838298);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbakh, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int j;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131307164);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        j = 2130838220;
      }
    }
    for (;;)
    {
      paramView.setImageResource(j);
      return;
      label51:
      j = 2130838215;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        j = 2130838226;
      } else {
        j = 2130838210;
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
        localObject3 = (aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((aifg)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = awao.a();
    String str2 = ajjy.a(2131634605);
    int j = str2.indexOf(ajjy.a(2131634603));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new aqax((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((aqax)localObject1).a(j, j + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aqax)localObject1);
    aqay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (adac)aciy.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (adac)aciy.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (adac)aciy.a(paramView);
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
    paramView = aciy.a(paramView);
    if (!(paramView instanceof adac)) {}
    do
    {
      return;
      paramView = (adac)paramView;
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