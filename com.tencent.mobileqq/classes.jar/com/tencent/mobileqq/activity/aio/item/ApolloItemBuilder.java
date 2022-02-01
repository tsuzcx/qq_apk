package com.tencent.mobileqq.activity.aio.item;

import abga;
import adrm;
import afur;
import afwr;
import afzq;
import agpc;
import agpd;
import agpe;
import agpf;
import agpg;
import agph;
import agpi;
import agpj;
import agpk;
import amhd;
import amhr;
import amud;
import amug;
import amul;
import amum;
import amzq;
import ancb;
import ancd;
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
import anni;
import aoph;
import apwt;
import auxc;
import auxd;
import bbyp;
import bgln;
import bgnt;
import bguh;
import bguj;
import biau;
import bkho;
import bkif;
import bley;
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
import njo;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  private amhr jdField_a_of_type_Amhr;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new agpe(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new agpg(this);
  private View.OnClickListener e = new agph(this);
  public boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (bgln.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new agpd(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agpf(this);
    paramQQAppInterface = (amhd)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Amhr = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838410), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838411), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838412), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838411), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838410), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838413), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838414), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838413), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838394), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838395), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838396), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838395), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838394), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838397), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838398), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838397), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, agpj paramagpj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    boolean bool4 = true;
    boolean bool3 = false;
    boolean bool1 = false;
    if ((paramagpj == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    label636:
    do
    {
      do
      {
        return paramView;
      } while (!(paramagpj instanceof agpj));
      if ((paramMessageForApollo != null) && (this.g))
      {
        b(paramagpj, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null)
        {
          paramafzq = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
          if (!TextUtils.isEmpty(paramafzq)) {
            paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramafzq);
          }
          if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
          {
            paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
            if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
            }
            paramagpj.e = paramMessageForApollo.mApolloMessage.id;
          }
        }
        else
        {
          paramView.setContentDescription(anni.a(2131699209) + paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
          paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
          paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramagpj.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
          paramagpj.jdField_a_of_type_AndroidWidgetTextView.setText(paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder);
          paramagpj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if (paramagpj.jdField_a_of_type_ComTencentImageURLImageView != null) {
            paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          }
          if (paramagpj.jdField_c_of_type_AndroidWidgetTextView != null) {
            paramagpj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          paramagpj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramagpj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams;
          if (paramagpj.jdField_d_of_type_AndroidWidgetImageView == null)
          {
            paramafzq = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramafzq.setId(2131366854);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(1, 2131364379);
            localLayoutParams.addRule(15, 2131363300);
            localLayoutParams.leftMargin = 10;
            paramafzq.setContentDescription(anni.a(2131699211));
            paramBaseChatItemLayout.addView(paramafzq, localLayoutParams);
            paramafzq.setImageResource(2130847097);
            paramagpj.jdField_d_of_type_AndroidWidgetImageView = paramafzq;
            paramagpj.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          if (paramagpj.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            paramafzq = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramafzq.setId(2131366853);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(0, 2131364379);
            localLayoutParams.addRule(15, 2131363300);
            paramafzq.setContentDescription(anni.a(2131699215));
            paramBaseChatItemLayout.addView(paramafzq, localLayoutParams);
            paramafzq.setImageResource(2130847097);
            paramagpj.jdField_c_of_type_AndroidWidgetImageView = paramafzq;
            paramagpj.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          paramafzq = (TextView)paramBaseChatItemLayout.findViewById(2131364410);
          if ((!paramMessageForApollo.mNeedTimeStamp) || (paramMessageForApollo.time <= 0L) || (paramafzq == null) || (paramMessageForApollo.time == ((Long)paramafzq.getTag()).longValue())) {
            break label947;
          }
          paramagpj.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramagpj.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, afur.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramagpj.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramagpj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramafzq = ((ancd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
          a(paramMessageForApollo, paramBaseChatItemLayout, paramagpj, paramafzq);
          if (((paramagpj.jdField_b_of_type_Int == paramagpj.jdField_c_of_type_Int - 1) && (paramafzq != null) && (paramafzq.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Amhr != null) && (this.jdField_a_of_type_Amhr.a(paramMessageForApollo))) && (amzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1)) {
            break label996;
          }
          j = 1;
          if (((paramMessageForApollo.isSend()) || (!amhd.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq)))) && ((paramMessageForApollo.isSend()) || (j != 0))) {
            break label1038;
          }
          amhd.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
          if (j == 0) {
            break label1002;
          }
          a(paramagpj, 1);
        }
        while ((paramagpj.jdField_b_of_type_Int != paramagpj.jdField_c_of_type_Int - 1) || ((j == 0) && ((amzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (!paramMessageForApollo.isSend()) || (bbyp.a() - paramMessageForApollo.time >= 10L)))) {
          for (;;)
          {
            boolean bool2 = bool4;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              paramBaseChatItemLayout = (amul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
              if (paramBaseChatItemLayout.a() != null) {
                bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
              }
              bool2 = bool4;
              bool3 = bool1;
              if (paramBaseChatItemLayout.a() != null)
              {
                bool2 = paramBaseChatItemLayout.a().c();
                bool3 = bool1;
              }
            }
            a(paramMessageForApollo, paramagpj, bool3, bool2);
            a(paramMessageForApollo);
            return paramView;
            if (TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              break;
            }
            paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
            break;
            paramagpj.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, afur.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
            paramagpj.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, afur.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
            break label636;
            j = 0;
            break label762;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloItemBuilder", 2, new Object[] { "showApolloAction status is not open:", Integer.valueOf(this.jdField_c_of_type_Int) });
            }
          }
        }
        if (this.i) {
          e();
        }
        if (paramMessageForApollo.isSend()) {}
        for (int j = 0;; j = 1)
        {
          a(paramagpj, j);
          break;
        }
      }
      if (paramMessageForApollo != null)
      {
        b(paramagpj, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramagpj.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramagpj.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramagpj.e));
      }
      paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramafzq);
      paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramafzq);
      a(paramagpj, paramView.getResources(), false);
      if (paramagpj.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramagpj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramagpj.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramagpj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (paramagpj.jdField_a_of_type_AndroidWidgetImageView == null);
    label762:
    paramagpj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    label947:
    label996:
    label1002:
    return paramView;
  }
  
  private biau a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new biau(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  private void a(agpj paramagpj)
  {
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (paramagpj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ancb.jdField_b_of_type_Int) {
      localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1, "userClick");
    }
    do
    {
      return;
      if (paramagpj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ancb.e)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "userClick");
        return;
      }
      if (paramagpj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ancb.jdField_c_of_type_Int)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, "userClick");
        return;
      }
    } while (paramagpj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ancb.d);
    aoph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
  }
  
  private void a(agpj paramagpj, bkho parambkho, ApolloActionData paramApolloActionData)
  {
    parambkho.c(2131690582);
    parambkho.a(new agpc(this, paramagpj, paramApolloActionData, parambkho));
    parambkho.show();
  }
  
  static void a(agpj paramagpj, boolean paramBoolean)
  {
    int k = 0;
    if ((paramagpj.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramagpj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramagpj.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramagpj.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        j = 8;
        ((ImageView)localObject).setVisibility(j);
      }
    }
    else
    {
      if (paramagpj.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramagpj.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        j = 8;
        label68:
        ((TextView)localObject).setVisibility(j);
      }
      if (paramagpj.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramagpj.jdField_a_of_type_ComTencentImageURLImageView;
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
      if (paramagpj.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramagpj.jdField_b_of_type_AndroidWidgetImageView;
        j = k;
        if (paramBoolean) {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
      }
      if (paramagpj.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramagpj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    Object localObject = abga.a(paramView);
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
    localObject = agpi.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    bley.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localamhd.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localamhd.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localamhd.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localamhd.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
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
      localamhd.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localamhd.a(localApolloBaseInfo.uin, 1);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agpj paramagpj)
  {
    ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramagpj), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agpj paramagpj, ApolloActionData paramApolloActionData)
  {
    int j;
    if ((paramagpj.jdField_b_of_type_Int == paramagpj.jdField_c_of_type_Int - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (!a(paramMessageForApollo)))
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
          paramagpj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramagpj.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
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
      paramagpj.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramagpj.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
    a(paramMessageForApollo, paramBaseChatItemLayout, paramagpj);
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
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838404), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838408), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838405), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838406), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838407), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838399), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838403), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838400), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838401), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838402), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(agpj paramagpj, boolean paramBoolean)
  {
    if (!(paramagpj instanceof agpj)) {}
    do
    {
      do
      {
        return;
        a(paramagpj, false);
        if (!this.g) {
          break;
        }
        if (paramagpj.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131374071);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131374072);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramagpj.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramagpj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramagpj.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.f);
          ((AnimationTextView)localObject).setMinWidth(afur.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramagpj.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramagpj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramagpj.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramagpj.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramagpj.f = 0;
        if (paramagpj.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, afur.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramagpj.jdField_a_of_type_AndroidTextStyleImageSpan = new agpk((Drawable)localObject);
        }
        if (paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramagpj.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int m = BaseChatItemLayout.o;
        int k = BaseChatItemLayout.p;
        int j = BaseChatItemLayout.o;
        if (paramBoolean)
        {
          m = BaseChatItemLayout.p;
          k = BaseChatItemLayout.o;
          j = BaseChatItemLayout.p;
        }
        paramagpj.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.m, k, BaseChatItemLayout.n);
        localObject = (ViewGroup.MarginLayoutParams)paramagpj.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.m, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = afur.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = afur.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramagpj.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramagpj.jdField_b_of_type_AndroidWidgetImageView == null);
      paramagpj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramagpj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramagpj.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(afur.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramagpj.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramagpj.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramagpj.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839402);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramagpj.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramagpj.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    Object localObject = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (localVasExtensionHandler != null)
    {
      ArrayList localArrayList = new ArrayList(2);
      int j;
      if (!paramMessageForApollo.isSend())
      {
        ApolloBaseInfo localApolloBaseInfo = ((amhd)localObject).a(paramMessageForApollo.senderuin);
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
        localObject = ((amhd)localObject).a(paramMessageForApollo.mApolloMessage.peer_uin + "");
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
    while ((!amhd.b(this.jdField_a_of_type_AndroidContentContext)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (amhd.c("discuss") == 0))) {
      return false;
    }
    paramMessageForApollo = ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
  
  public afwr a()
  {
    return new agpj();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    paramafzq = (agpj)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramafzq.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramafzq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((ancd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramafzq.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.f);
          paramChatMessage.setMinWidth(afur.a(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(afur.a(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842568);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(afur.a(6.0F, (Resources)localObject1), 0, afur.a(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364379);
          paramView.addRule(3, 2131364379);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = afur.a(-3.0F, (Resources)localObject1);
          paramView.leftMargin = afur.a(12.0F, (Resources)localObject1);
          paramafzq.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramafzq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramafzq.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.e);
        }
        paramafzq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = anni.a(2131699213);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramafzq.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838526);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramafzq.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramafzq.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramafzq.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramafzq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramafzq.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramafzq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramafzq.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramafzq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(afur.a(5.0F, paramChatMessage), 0, afur.a(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842568);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364379);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364379);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = afur.a(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(12.0F, paramChatMessage);
      paramafzq.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramafzq.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramafzq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramafzq.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131699216));
    paramView = paramChatMessage.getDrawable(2130838524);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramafzq.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramafzq.jdField_c_of_type_AndroidWidgetTextView.setPadding(afur.a(5.0F, paramChatMessage), 0, afur.a(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramafwr instanceof agpj)) {
      return paramView;
    }
    paramafwr = (agpj)paramafwr;
    if ((paramView == null) || ((paramafwr != null) && (paramafwr.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131374072);
      paramafwr.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramafzq);
      paramChatMessage.setOnLongClickListener(paramafzq);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramafwr, paramChatMessage, paramBaseChatItemLayout, paramafzq);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anni.a(2131699212) + paramChatMessage.msg;
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
          case 2131365308: 
            adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
    Object localObject3 = ((ancd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / bgln.a);
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
    if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690001), 1, this.jdField_a_of_type_AndroidContentContext);
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
      paramMessageForApollo.c(2131690045);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage, apwt paramapwt)
  {
    if (!(paramafwr instanceof agpj)) {}
    agpj localagpj;
    do
    {
      return;
      localagpj = (agpj)paramafwr;
    } while ((paramapwt == null) || (localagpj.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramapwt.jdField_a_of_type_Int == 0) || (!paramapwt.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramafwr = paramView.getColorStateList(2131167008);
        if (paramafwr != null) {
          localagpj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafwr);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramafwr = paramView.getColorStateList(2131167007);; paramafwr = paramView.getColorStateList(2131167006))
      {
        localagpj.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafwr);
        return;
        paramafwr = paramView.getColorStateList(2131167004);
        break;
      }
    }
    if (paramapwt.jdField_b_of_type_Int == 0) {
      localagpj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramapwt.jdField_c_of_type_Int == 0)
    {
      localagpj.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167006));
      return;
      localagpj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapwt.jdField_b_of_type_Int);
    }
    localagpj.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramapwt.jdField_c_of_type_Int);
  }
  
  public void a(agpj paramagpj, int paramInt)
  {
    paramagpj = (MessageForApollo)paramagpj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramagpj.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = (amul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      amud localamud = ((amul)localObject).a();
      localObject = ((amul)localObject).a();
      if (this.jdField_c_of_type_Int != 1) {
        ((amug)localObject).e(true);
      }
      if (localamud != null) {
        localamud.a(paramInt, paramagpj);
      }
    }
  }
  
  public void a(agpj paramagpj, Resources paramResources, boolean paramBoolean)
  {
    if ((paramagpj == null) || (paramResources == null)) {
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838525);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838527);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramagpj.e));
        File localFile = new File(agpi.a(paramagpj.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramagpj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramagpj.e + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramagpj) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramagpj.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramagpj.e));
      paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramagpj.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramagpj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramagpj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (agpj)afur.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      a(paramView);
      ApolloBaseInfo localApolloBaseInfo = ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null);
      ancd localancd = (ancd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      ApolloActionData localApolloActionData = localancd.a(paramView.e);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ancb.jdField_b_of_type_Int) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690013));
        localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690012), 1);
        paramView.f = 1;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ancb.jdField_c_of_type_Int) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690013));
        localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690012), 1);
        paramView.f = 2;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ancb.e) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localancd.b(localApolloActionData.actionId))))
      {
        localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690010));
        localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690009), 1);
        paramView.f = 3;
      }
      for (;;)
      {
        a(paramView, localbkho, localApolloActionData);
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ancb.d)
        {
          localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690011));
          paramView.f = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690015), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = afur.a(paramView);
    if (!(paramView instanceof agpj)) {}
    amhd localamhd;
    do
    {
      do
      {
        return;
        paramView = (agpj)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        amhd.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!amhd.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        amhd.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while ((localamhd != null) && (localamhd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    agpj localagpj;
    if ((paramView != null) && ((afur.a(paramView) instanceof agpj)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        amhd.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localagpj = (agpj)afur.a(paramView);
      if (!super.a(paramMessageForApollo, localagpj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localagpj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localagpj.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localagpj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = afur.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof agpj)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = afur.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof agpj));
      localObject = (agpj)localObject;
      paramBaseChatItemLayout2 = (agpj)paramBaseChatItemLayout2;
    } while (((agpj)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, agpj paramagpj, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramagpj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (amhd.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramagpj.e)))
    {
      localObject = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((localObject != null) && (((amhd)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2) && (paramBoolean2)) {
        paramagpj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean1)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramagpj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        amhd.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramagpj.e));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        return;
      }
    }
    int j;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        j = 2130838404;
      }
    }
    for (;;)
    {
      paramagpj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      return;
      j = 2130838399;
      continue;
      if (paramMessageForApollo.isSend()) {
        j = 2130838410;
      } else {
        j = 2130838394;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (njo.a().a(paramMessageForApollo.frienduin)) {}
    int j;
    do
    {
      return true;
      j = amhd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (((paramMessageForApollo.is3dAction()) && (j != 2)) || ((!paramMessageForApollo.is3dAction()) && (this.jdField_c_of_type_Int == 2)));
    return false;
  }
  
  public bguj[] a(View paramView)
  {
    bguh localbguh = new bguh();
    paramView = afur.a(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
      return localbguh.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction()) && (amzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)) {
        localbguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131689997), 2130838466);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbguh, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
    return localbguh.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int j;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131374071);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        j = 2130838404;
      }
    }
    for (;;)
    {
      paramView.setImageResource(j);
      return;
      label51:
      j = 2130838399;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        j = 2130838410;
      } else {
        j = 2130838394;
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
        localObject3 = (amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((amhd)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = bbyp.a();
    String str2 = anni.a(2131699210);
    int j = str2.indexOf(anni.a(2131699208));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new auxc((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((auxc)localObject1).a(j, j + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (auxc)localObject1);
    auxd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (agpj)afur.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (agpj)afur.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (agpj)afur.a(paramView);
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
    paramView = afur.a(paramView);
    if (!(paramView instanceof agpj)) {}
    do
    {
      return;
      paramView = (agpj)paramView;
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