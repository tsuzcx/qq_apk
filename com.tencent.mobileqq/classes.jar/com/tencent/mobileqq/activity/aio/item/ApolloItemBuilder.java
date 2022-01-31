package com.tencent.mobileqq.activity.aio.item;

import aanz;
import actj;
import acuj;
import acxj;
import adkv;
import adkw;
import adkx;
import adky;
import adkz;
import adla;
import adlb;
import adlc;
import adld;
import airx;
import aisk;
import ajew;
import ajfe;
import ajff;
import ajms;
import ajmu;
import ajya;
import akvi;
import ambg;
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
import aqvb;
import aqvc;
import awzy;
import bbdh;
import bbfj;
import bbmf;
import bbmh;
import bbrd;
import bcqf;
import bfpc;
import bfpp;
import bgky;
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
import myb;
import xpu;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  private aisk jdField_a_of_type_Aisk;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new adkx(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new adkz(this);
  private View.OnClickListener e = new adla(this);
  public boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (bbdh.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new adkw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adky(this);
    paramQQAppInterface = (airx)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Aisk = paramQQAppInterface.a();
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
  
  private View a(MessageForApollo paramMessageForApollo, adlc paramadlc, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    boolean bool2 = false;
    if ((paramadlc == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    label630:
    do
    {
      do
      {
        return paramView;
      } while (!(paramadlc instanceof adlc));
      if ((paramMessageForApollo != null) && (this.g))
      {
        b(paramadlc, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null)
        {
          paramacxj = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
          if (!TextUtils.isEmpty(paramacxj)) {
            paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramacxj);
          }
          if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
          {
            paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
            if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
            }
            paramadlc.e = paramMessageForApollo.mApolloMessage.id;
          }
        }
        else
        {
          paramView.setContentDescription(ajya.a(2131700403) + paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
          paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
          paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramadlc.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
          paramadlc.jdField_a_of_type_AndroidWidgetTextView.setText(paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder);
          paramadlc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if (paramadlc.jdField_a_of_type_ComTencentImageURLImageView != null) {
            paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          }
          if (paramadlc.jdField_c_of_type_AndroidWidgetTextView != null) {
            paramadlc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          paramadlc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramadlc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams;
          if (paramadlc.jdField_d_of_type_AndroidWidgetImageView == null)
          {
            paramacxj = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramacxj.setId(2131366477);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(1, 2131364109);
            localLayoutParams.addRule(15, 2131363076);
            localLayoutParams.leftMargin = 10;
            paramacxj.setContentDescription(ajya.a(2131700405));
            paramBaseChatItemLayout.addView(paramacxj, localLayoutParams);
            paramacxj.setImageResource(2130846203);
            paramadlc.jdField_d_of_type_AndroidWidgetImageView = paramacxj;
            paramadlc.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          if (paramadlc.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            paramacxj = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramacxj.setId(2131366476);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(0, 2131364109);
            localLayoutParams.addRule(15, 2131363076);
            paramacxj.setContentDescription(ajya.a(2131700409));
            paramBaseChatItemLayout.addView(paramacxj, localLayoutParams);
            paramacxj.setImageResource(2130846203);
            paramadlc.jdField_c_of_type_AndroidWidgetImageView = paramacxj;
            paramadlc.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          paramacxj = (TextView)paramBaseChatItemLayout.findViewById(2131364140);
          if ((!paramMessageForApollo.mNeedTimeStamp) || (paramMessageForApollo.time <= 0L) || (paramacxj == null) || (paramMessageForApollo.time == ((Long)paramacxj.getTag()).longValue())) {
            break label992;
          }
          paramadlc.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadlc.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, actj.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadlc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramadlc.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramacxj = ((ajmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
          if ((paramadlc.jdField_b_of_type_Int == paramadlc.jdField_c_of_type_Int - 1) && (paramacxj != null) && (paramacxj.actionType != 5) && (a(paramMessageForApollo)))
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
                paramadlc.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                paramadlc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
          }
          if (((paramadlc.jdField_b_of_type_Int == paramadlc.jdField_c_of_type_Int - 1) && (paramacxj != null) && (paramacxj.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Aisk != null) && (this.jdField_a_of_type_Aisk.a(paramMessageForApollo))) && ((paramMessageForApollo.isSend()) || (!airx.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq))))) {
            break label1112;
          }
          airx.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
          a(paramadlc, 1);
        }
        while (paramadlc.jdField_b_of_type_Int != paramadlc.jdField_c_of_type_Int - 1)
        {
          boolean bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            paramBaseChatItemLayout = (ajfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
            bool1 = bool2;
            if (paramBaseChatItemLayout.a() != null) {
              bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
            }
          }
          a(paramMessageForApollo, paramadlc, bool1);
          a(paramMessageForApollo);
          return paramView;
          if (TextUtils.isEmpty(paramMessageForApollo.inputText)) {
            break;
          }
          paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
          break;
          paramadlc.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, actj.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadlc.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, actj.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          break label630;
          j = 0;
          break label742;
          paramadlc.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramadlc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          break label800;
          if ((this.h) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq)) {
            break label800;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
          ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramadlc), 5, null, true);
          break label800;
        }
        if (this.i) {
          e();
        }
        if (paramMessageForApollo.isSend()) {}
        for (int j = 0;; j = 1)
        {
          a(paramadlc, j);
          break;
        }
      }
      if (paramMessageForApollo != null)
      {
        b(paramadlc, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramadlc.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramadlc.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramadlc.e));
      }
      paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramacxj);
      paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramacxj);
      a(paramadlc, paramView.getResources(), false);
      if (paramadlc.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramadlc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramadlc.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramadlc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (paramadlc.jdField_a_of_type_AndroidWidgetImageView == null);
    label742:
    paramadlc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    label800:
    label992:
    return paramView;
  }
  
  private bcqf a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new bcqf(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  static void a(adlc paramadlc, boolean paramBoolean)
  {
    int k = 0;
    if ((paramadlc.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramadlc.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramadlc.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramadlc.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        j = 8;
        ((ImageView)localObject).setVisibility(j);
      }
    }
    else
    {
      if (paramadlc.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramadlc.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        j = 8;
        label68:
        ((TextView)localObject).setVisibility(j);
      }
      if (paramadlc.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramadlc.jdField_a_of_type_ComTencentImageURLImageView;
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
      if (paramadlc.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramadlc.jdField_b_of_type_AndroidWidgetImageView;
        j = k;
        if (paramBoolean) {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
      }
      if (paramadlc.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramadlc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    Object localObject = xpu.a(paramView);
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
    localObject = adlb.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    bgky.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    airx localairx = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localairx.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localairx.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localairx.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localairx.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
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
      localairx.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localairx.a(localApolloBaseInfo.uin, 1);
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
  
  private void b(adlc paramadlc, boolean paramBoolean)
  {
    if (!(paramadlc instanceof adlc)) {}
    do
    {
      do
      {
        return;
        a(paramadlc, false);
        if (!this.g) {
          break;
        }
        if (paramadlc.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131372878);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131372879);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramadlc.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramadlc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramadlc.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
          ((AnimationTextView)localObject).setMinWidth(actj.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramadlc.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramadlc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramadlc.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramadlc.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramadlc.f = 0;
        if (paramadlc.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, actj.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramadlc.jdField_a_of_type_AndroidTextStyleImageSpan = new adld((Drawable)localObject);
        }
        if (paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramadlc.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int m = BaseChatItemLayout.n;
        int k = BaseChatItemLayout.o;
        int j = BaseChatItemLayout.n;
        if (paramBoolean)
        {
          m = BaseChatItemLayout.o;
          k = BaseChatItemLayout.n;
          j = BaseChatItemLayout.o;
        }
        paramadlc.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.l, k, BaseChatItemLayout.m);
        localObject = (ViewGroup.MarginLayoutParams)paramadlc.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.l, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = actj.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = actj.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramadlc.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramadlc.jdField_b_of_type_AndroidWidgetImageView == null);
      paramadlc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramadlc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramadlc.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(actj.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramadlc.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramadlc.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramadlc.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839140);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramadlc.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramadlc.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000)) {
      return false;
    }
    if (!airx.a(this.jdField_a_of_type_AndroidContentContext)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (airx.c("discuss") == 0)) {
      return false;
    }
    paramMessageForApollo = ((airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (paramMessageForApollo != null)
    {
      this.jdField_c_of_type_Int = paramMessageForApollo.apolloStatus;
      return airx.a(paramMessageForApollo);
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
  
  public acuj a()
  {
    return new adlc();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    paramacxj = (adlc)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramacxj.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramacxj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((ajmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramacxj.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.e);
          paramChatMessage.setMinWidth(actj.a(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(actj.a(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842092);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(actj.a(6.0F, (Resources)localObject1), 0, actj.a(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364109);
          paramView.addRule(3, 2131364109);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = actj.a(-3.0F, (Resources)localObject1);
          paramView.leftMargin = actj.a(12.0F, (Resources)localObject1);
          paramacxj.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramacxj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramacxj.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.e);
        }
        paramacxj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = ajya.a(2131700407);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramacxj.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838365);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramacxj.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramacxj.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actj.a(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramacxj.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramacxj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramacxj.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramacxj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramacxj.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramacxj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(actj.a(5.0F, paramChatMessage), 0, actj.a(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842092);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364109);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364109);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = actj.a(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = actj.a(12.0F, paramChatMessage);
      paramacxj.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramacxj.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramacxj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramacxj.jdField_c_of_type_AndroidWidgetTextView.setText(ajya.a(2131700410));
    paramView = paramChatMessage.getDrawable(2130838363);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramacxj.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramacxj.jdField_c_of_type_AndroidWidgetTextView.setPadding(actj.a(5.0F, paramChatMessage), 0, actj.a(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramacuj instanceof adlc)) {
      return paramView;
    }
    paramacuj = (adlc)paramacuj;
    if ((paramView == null) || ((paramacuj != null) && (paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131372879);
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramacxj);
      paramChatMessage.setOnLongClickListener(paramacxj);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramacuj, paramChatMessage, paramBaseChatItemLayout, paramacxj);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajya.a(2131700406) + paramChatMessage.msg;
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
          case 2131364984: 
            aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
    Object localObject3 = ((ajmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / bbdh.a);
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
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690064), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (bbrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((bbrd)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131690129);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    if (!(paramacuj instanceof adlc)) {}
    adlc localadlc;
    do
    {
      return;
      localadlc = (adlc)paramacuj;
    } while ((paramambg == null) || (localadlc.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramambg.jdField_a_of_type_Int == 0) || (!paramambg.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramacuj = paramView.getColorStateList(2131166876);
        if (paramacuj != null) {
          localadlc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramacuj);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramacuj = paramView.getColorStateList(2131166875);; paramacuj = paramView.getColorStateList(2131166874))
      {
        localadlc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramacuj);
        return;
        paramacuj = paramView.getColorStateList(2131166872);
        break;
      }
    }
    if (paramambg.jdField_b_of_type_Int == 0) {
      localadlc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramambg.jdField_c_of_type_Int == 0)
    {
      localadlc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166874));
      return;
      localadlc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramambg.jdField_b_of_type_Int);
    }
    localadlc.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramambg.jdField_c_of_type_Int);
  }
  
  public void a(adlc paramadlc, int paramInt)
  {
    paramadlc = (MessageForApollo)paramadlc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramadlc.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ajew localajew = ((ajfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a();
      if (localajew != null) {
        localajew.a(paramInt, paramadlc);
      }
    }
  }
  
  public void a(adlc paramadlc, Resources paramResources, boolean paramBoolean)
  {
    if ((paramadlc == null) || (paramResources == null)) {
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
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramadlc.e));
        File localFile = new File(adlb.a(paramadlc.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramadlc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramadlc.e + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramadlc) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramadlc.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramadlc.e));
      paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramadlc.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramadlc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramadlc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (adlc)actj.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      Object localObject = (bbrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajms.jdField_b_of_type_Int) {
        ((bbrd)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1, "userClick");
      }
      bfpc localbfpc;
      ajmu localajmu;
      ApolloActionData localApolloActionData;
      for (;;)
      {
        localObject = ((airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
        localajmu = (ajmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
        localApolloActionData = localajmu.a(paramView.e);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ajms.jdField_b_of_type_Int) || (localObject == null) || (((ApolloBaseInfo)localObject).apolloVipFlag == 1)) {
          break;
        }
        localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690080));
        localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690079), 1);
        paramView.f = 1;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajms.e) {
          ((bbrd)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "userClick");
        } else if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajms.jdField_c_of_type_Int) {
          ((bbrd)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, "userClick");
        } else if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajms.d) {
          akvi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajms.jdField_c_of_type_Int) && (localApolloActionData != null) && (localObject != null) && (localApolloActionData.vipLevel < ((ApolloBaseInfo)localObject).apolloVipLevel))
      {
        localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690080));
        localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690079), 1);
        paramView.f = 2;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajms.e) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localajmu.b(localApolloActionData.actionId))))
      {
        localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690077));
        localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690076), 1);
        paramView.f = 3;
      }
      for (;;)
      {
        localbfpc.c(2131690596);
        localbfpc.a(new adkv(this, paramView, localApolloActionData, localbfpc));
        localbfpc.show();
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ajms.d)
        {
          localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690078));
          paramView.f = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690086), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = actj.a(paramView);
    if (!(paramView instanceof adlc)) {}
    airx localairx;
    do
    {
      do
      {
        return;
        paramView = (adlc)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        airx.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!airx.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        airx.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localairx = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while ((localairx != null) && (localairx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    adlc localadlc;
    if ((paramView != null) && ((actj.a(paramView) instanceof adlc)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        airx.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localadlc = (adlc)actj.a(paramView);
      if (!super.a(paramMessageForApollo, localadlc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localadlc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localadlc.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localadlc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = actj.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof adlc)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = actj.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof adlc));
      localObject = (adlc)localObject;
      paramBaseChatItemLayout2 = (adlc)paramBaseChatItemLayout2;
    } while (((adlc)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, adlc paramadlc, boolean paramBoolean)
  {
    paramadlc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (airx.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramadlc.e)))
    {
      localObject = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((localObject != null) && (((airx)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2)) {
        paramadlc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramadlc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        airx.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramadlc.e));
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
      paramadlc.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
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
    if (myb.a().a(paramMessageForApollo.frienduin)) {}
    int j;
    do
    {
      return false;
      j = airx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (((paramMessageForApollo.is3dAction()) && (j != 2)) || ((!paramMessageForApollo.is3dAction()) && (j != 1)));
    return true;
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
      return localbbmf.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction())) {
        localbbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131690060), 2130838306);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbbmf, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int j;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131372878);
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
        localObject3 = (airx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((airx)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = awzy.a();
    String str2 = ajya.a(2131700404);
    int j = str2.indexOf(ajya.a(2131700402));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new aqvb((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((aqvb)localObject1).a(j, j + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aqvb)localObject1);
    aqvc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (adlc)actj.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (adlc)actj.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (adlc)actj.a(paramView);
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
    paramView = actj.a(paramView);
    if (!(paramView instanceof adlc)) {}
    do
    {
      return;
      paramView = (adlc)paramView;
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