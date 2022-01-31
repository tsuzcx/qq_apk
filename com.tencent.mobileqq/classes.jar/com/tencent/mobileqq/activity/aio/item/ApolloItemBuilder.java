package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aelt;
import aeov;
import afdf;
import afdg;
import afdh;
import afdi;
import afdj;
import afdk;
import afdl;
import afdm;
import afdn;
import akji;
import akjw;
import akwi;
import akwq;
import akwr;
import alef;
import aleh;
import alpo;
import amly;
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
import ansf;
import aslp;
import aslq;
import ayvc;
import bdcb;
import bdee;
import bdkz;
import bdlb;
import bdpx;
import bepp;
import bhpy;
import bhql;
import bilx;
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
import nav;
import zen;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  private akjw jdField_a_of_type_Akjw;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new afdh(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new afdj(this);
  private View.OnClickListener e = new afdk(this);
  public boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (bdcb.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new afdg(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afdi(this);
    paramQQAppInterface = (akji)paramQQAppInterface.getManager(153);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Akjw = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838311), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838312), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838313), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838312), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838311), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838314), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838315), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838314), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838295), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838296), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838297), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838296), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838295), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838298), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838299), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838298), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, afdm paramafdm, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    boolean bool2 = false;
    if ((paramafdm == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    label630:
    do
    {
      do
      {
        return paramView;
      } while (!(paramafdm instanceof afdm));
      if ((paramMessageForApollo != null) && (this.g))
      {
        b(paramafdm, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null)
        {
          paramaeov = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
          if (!TextUtils.isEmpty(paramaeov)) {
            paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramaeov);
          }
          if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
          {
            paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
            if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
            }
            paramafdm.e = paramMessageForApollo.mApolloMessage.id;
          }
        }
        else
        {
          paramView.setContentDescription(alpo.a(2131700772) + paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
          paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
          paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramafdm.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
          paramafdm.jdField_a_of_type_AndroidWidgetTextView.setText(paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder);
          paramafdm.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if (paramafdm.jdField_a_of_type_ComTencentImageURLImageView != null) {
            paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          }
          if (paramafdm.jdField_c_of_type_AndroidWidgetTextView != null) {
            paramafdm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          paramafdm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramafdm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams;
          if (paramafdm.jdField_d_of_type_AndroidWidgetImageView == null)
          {
            paramaeov = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramaeov.setId(2131366583);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(1, 2131364171);
            localLayoutParams.addRule(15, 2131363112);
            localLayoutParams.leftMargin = 10;
            paramaeov.setContentDescription(alpo.a(2131700774));
            paramBaseChatItemLayout.addView(paramaeov, localLayoutParams);
            paramaeov.setImageResource(2130846582);
            paramafdm.jdField_d_of_type_AndroidWidgetImageView = paramaeov;
            paramafdm.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          if (paramafdm.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            paramaeov = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramaeov.setId(2131366582);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(0, 2131364171);
            localLayoutParams.addRule(15, 2131363112);
            paramaeov.setContentDescription(alpo.a(2131700778));
            paramBaseChatItemLayout.addView(paramaeov, localLayoutParams);
            paramaeov.setImageResource(2130846582);
            paramafdm.jdField_c_of_type_AndroidWidgetImageView = paramaeov;
            paramafdm.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
          }
          paramaeov = (TextView)paramBaseChatItemLayout.findViewById(2131364202);
          if ((!paramMessageForApollo.mNeedTimeStamp) || (paramMessageForApollo.time <= 0L) || (paramaeov == null) || (paramMessageForApollo.time == ((Long)paramaeov.getTag()).longValue())) {
            break label992;
          }
          paramafdm.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, aekt.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramafdm.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, aekt.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramafdm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          paramafdm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramaeov = ((aleh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
          if ((paramafdm.jdField_b_of_type_Int == paramafdm.jdField_c_of_type_Int - 1) && (paramaeov != null) && (paramaeov.actionType != 5) && (a(paramMessageForApollo)))
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
                paramafdm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                paramafdm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
          }
          if (((paramafdm.jdField_b_of_type_Int == paramafdm.jdField_c_of_type_Int - 1) && (paramaeov != null) && (paramaeov.actionType != 5) && (!paramMessageForApollo.hasPlayed) && (this.jdField_a_of_type_Akjw != null) && (this.jdField_a_of_type_Akjw.a(paramMessageForApollo))) && ((paramMessageForApollo.isSend()) || (!akji.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq))))) {
            break label1112;
          }
          akji.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
          a(paramafdm, 1);
        }
        while (paramafdm.jdField_b_of_type_Int != paramafdm.jdField_c_of_type_Int - 1)
        {
          boolean bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            paramBaseChatItemLayout = (akwq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
            bool1 = bool2;
            if (paramBaseChatItemLayout.a() != null) {
              bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
            }
          }
          a(paramMessageForApollo, paramafdm, bool1);
          a(paramMessageForApollo);
          return paramView;
          if (TextUtils.isEmpty(paramMessageForApollo.inputText)) {
            break;
          }
          paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
          break;
          paramafdm.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, aekt.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramafdm.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, aekt.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          break label630;
          j = 0;
          break label742;
          paramafdm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramafdm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          break label800;
          if ((this.h) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq)) {
            break label800;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
          ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramafdm), 5, null, true);
          break label800;
        }
        if (this.i) {
          e();
        }
        if (paramMessageForApollo.isSend()) {}
        for (int j = 0;; j = 1)
        {
          a(paramafdm, j);
          break;
        }
      }
      if (paramMessageForApollo != null)
      {
        b(paramafdm, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramafdm.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramafdm.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramafdm.e));
      }
      paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramaeov);
      paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramaeov);
      a(paramafdm, paramView.getResources(), false);
      if (paramafdm.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramafdm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramafdm.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramafdm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (paramafdm.jdField_a_of_type_AndroidWidgetImageView == null);
    label742:
    paramafdm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    label800:
    label992:
    return paramView;
  }
  
  private bepp a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b = new bepp(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b;
    }
    return null;
  }
  
  static void a(afdm paramafdm, boolean paramBoolean)
  {
    int k = 0;
    if ((paramafdm.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramafdm.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramafdm.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramafdm.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        j = 8;
        ((ImageView)localObject).setVisibility(j);
      }
    }
    else
    {
      if (paramafdm.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramafdm.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        j = 8;
        label68:
        ((TextView)localObject).setVisibility(j);
      }
      if (paramafdm.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramafdm.jdField_a_of_type_ComTencentImageURLImageView;
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
      if (paramafdm.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramafdm.jdField_b_of_type_AndroidWidgetImageView;
        j = k;
        if (paramBoolean) {
          j = 8;
        }
        ((ImageView)localObject).setVisibility(j);
      }
      if (paramafdm.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramafdm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    Object localObject = zen.a(paramView);
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
    localObject = afdl.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    bilx.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    akji localakji = (akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localakji.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localakji.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localakji.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localakji.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
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
      localakji.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localakji.a(localApolloBaseInfo.uin, 1);
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
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838305), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838309), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838306), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838307), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838308), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838300), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838304), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838301), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838302), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838303), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(afdm paramafdm, boolean paramBoolean)
  {
    if (!(paramafdm instanceof afdm)) {}
    do
    {
      do
      {
        return;
        a(paramafdm, false);
        if (!this.g) {
          break;
        }
        if (paramafdm.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131373316);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131373317);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramafdm.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramafdm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramafdm.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
          ((AnimationTextView)localObject).setMinWidth(aekt.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramafdm.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramafdm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramafdm.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramafdm.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramafdm.f = 0;
        if (paramafdm.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, aekt.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramafdm.jdField_a_of_type_AndroidTextStyleImageSpan = new afdn((Drawable)localObject);
        }
        if (paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramafdm.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int m = BaseChatItemLayout.n;
        int k = BaseChatItemLayout.o;
        int j = BaseChatItemLayout.n;
        if (paramBoolean)
        {
          m = BaseChatItemLayout.o;
          k = BaseChatItemLayout.n;
          j = BaseChatItemLayout.o;
        }
        paramafdm.jdField_a_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.l, k, BaseChatItemLayout.m);
        localObject = (ViewGroup.MarginLayoutParams)paramafdm.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(m, BaseChatItemLayout.l, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = aekt.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = aekt.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramafdm.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramafdm.jdField_b_of_type_AndroidWidgetImageView == null);
      paramafdm.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramafdm.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramafdm.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(aekt.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramafdm.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramafdm.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramafdm.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839224);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramafdm.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramafdm.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000)) {
      return false;
    }
    if (!akji.a(this.jdField_a_of_type_AndroidContentContext)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (akji.c("discuss") == 0)) {
      return false;
    }
    paramMessageForApollo = ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (paramMessageForApollo != null)
    {
      this.jdField_c_of_type_Int = paramMessageForApollo.apolloStatus;
      return akji.a(paramMessageForApollo);
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
  
  public aelt a()
  {
    return new afdm();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    paramaeov = (afdm)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramaeov.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramaeov.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((aleh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramaeov.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.e);
          paramChatMessage.setMinWidth(aekt.a(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(aekt.a(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842245);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(aekt.a(6.0F, (Resources)localObject1), 0, aekt.a(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364171);
          paramView.addRule(3, 2131364171);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = aekt.a(-3.0F, (Resources)localObject1);
          paramView.leftMargin = aekt.a(12.0F, (Resources)localObject1);
          paramaeov.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramaeov.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramaeov.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.e);
        }
        paramaeov.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = alpo.a(2131700776);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramaeov.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838425);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramaeov.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramaeov.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aekt.a(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramaeov.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramaeov.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramaeov.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramaeov.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramaeov.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramaeov.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(aekt.a(5.0F, paramChatMessage), 0, aekt.a(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842245);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364171);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364171);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = aekt.a(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = aekt.a(12.0F, paramChatMessage);
      paramaeov.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramaeov.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramaeov.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramaeov.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131700779));
    paramView = paramChatMessage.getDrawable(2130838423);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramaeov.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramaeov.jdField_c_of_type_AndroidWidgetTextView.setPadding(aekt.a(5.0F, paramChatMessage), 0, aekt.a(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramaelt instanceof afdm)) {
      return paramView;
    }
    paramaelt = (afdm)paramaelt;
    if ((paramView == null) || ((paramaelt != null) && (paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131373317);
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramaeov);
      paramChatMessage.setOnLongClickListener(paramaeov);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramaelt, paramChatMessage, paramBaseChatItemLayout, paramaeov);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alpo.a(2131700775) + paramChatMessage.msg;
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
          case 2131365069: 
            acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
    Object localObject3 = ((aleh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / bdcb.a);
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
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690111), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((bdpx)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131690176);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    if (!(paramaelt instanceof afdm)) {}
    afdm localafdm;
    do
    {
      return;
      localafdm = (afdm)paramaelt;
    } while ((paramansf == null) || (localafdm.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramansf.jdField_a_of_type_Int == 0) || (!paramansf.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramaelt = paramView.getColorStateList(2131166923);
        if (paramaelt != null) {
          localafdm.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaelt);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramaelt = paramView.getColorStateList(2131166922);; paramaelt = paramView.getColorStateList(2131166921))
      {
        localafdm.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaelt);
        return;
        paramaelt = paramView.getColorStateList(2131166919);
        break;
      }
    }
    if (paramansf.jdField_b_of_type_Int == 0) {
      localafdm.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramansf.jdField_c_of_type_Int == 0)
    {
      localafdm.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131166921));
      return;
      localafdm.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramansf.jdField_b_of_type_Int);
    }
    localafdm.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramansf.jdField_c_of_type_Int);
  }
  
  public void a(afdm paramafdm, int paramInt)
  {
    paramafdm = (MessageForApollo)paramafdm.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramafdm.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      akwi localakwi = ((akwq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a();
      if (localakwi != null) {
        localakwi.a(paramInt, paramafdm);
      }
    }
  }
  
  public void a(afdm paramafdm, Resources paramResources, boolean paramBoolean)
  {
    if ((paramafdm == null) || (paramResources == null)) {
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838424);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838426);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramafdm.e));
        File localFile = new File(afdl.a(paramafdm.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramafdm.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramafdm.e + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramafdm) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramafdm.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramafdm.e));
      paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramafdm.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramafdm.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramafdm.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (afdm)aekt.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      Object localObject = (bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == alef.jdField_b_of_type_Int) {
        ((bdpx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1, "userClick");
      }
      bhpy localbhpy;
      aleh localaleh;
      ApolloActionData localApolloActionData;
      for (;;)
      {
        localObject = ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
        localaleh = (aleh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
        localApolloActionData = localaleh.a(paramView.e);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != alef.jdField_b_of_type_Int) || (localObject == null) || (((ApolloBaseInfo)localObject).apolloVipFlag == 1)) {
          break;
        }
        localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690127));
        localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690126), 1);
        paramView.f = 1;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == alef.e) {
          ((bdpx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "userClick");
        } else if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == alef.jdField_c_of_type_Int) {
          ((bdpx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, "userClick");
        } else if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == alef.d) {
          amly.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == alef.jdField_c_of_type_Int) && (localApolloActionData != null) && (localObject != null) && (localApolloActionData.vipLevel < ((ApolloBaseInfo)localObject).apolloVipLevel))
      {
        localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690127));
        localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690126), 1);
        paramView.f = 2;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == alef.e) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localaleh.b(localApolloActionData.actionId))))
      {
        localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690124));
        localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690123), 1);
        paramView.f = 3;
      }
      for (;;)
      {
        localbhpy.c(2131690648);
        localbhpy.a(new afdf(this, paramView, localApolloActionData, localbhpy));
        localbhpy.show();
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == alef.d)
        {
          localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690125));
          paramView.f = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690133), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = aekt.a(paramView);
    if (!(paramView instanceof afdm)) {}
    akji localakji;
    do
    {
      do
      {
        return;
        paramView = (afdm)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        akji.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!akji.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        akji.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localakji = (akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    } while ((localakji != null) && (localakji.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    afdm localafdm;
    if ((paramView != null) && ((aekt.a(paramView) instanceof afdm)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        akji.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localafdm = (afdm)aekt.a(paramView);
      if (!super.a(paramMessageForApollo, localafdm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localafdm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localafdm.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localafdm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = aekt.a(paramBaseChatItemLayout2);
    if (!(localObject instanceof afdm)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = aekt.a(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof afdm));
      localObject = (afdm)localObject;
      paramBaseChatItemLayout2 = (afdm)paramBaseChatItemLayout2;
    } while (((afdm)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, afdm paramafdm, boolean paramBoolean)
  {
    paramafdm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (akji.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramafdm.e)))
    {
      localObject = (akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if ((localObject != null) && (((akji)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2)) {
        paramafdm.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramafdm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        akji.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramafdm.e));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        return;
      }
    }
    int j;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        j = 2130838305;
      }
    }
    for (;;)
    {
      paramafdm.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      return;
      j = 2130838300;
      continue;
      if (paramMessageForApollo.isSend()) {
        j = 2130838311;
      } else {
        j = 2130838295;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (nav.a().a(paramMessageForApollo.frienduin)) {}
    int j;
    do
    {
      return false;
      j = akji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (((paramMessageForApollo.is3dAction()) && (j != 2)) || ((!paramMessageForApollo.is3dAction()) && (j != 1)));
    return true;
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = aekt.a(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
      return localbdkz.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction())) {
        localbdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131690107), 2130838366);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbdkz, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int j;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131373316);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        j = 2130838305;
      }
    }
    for (;;)
    {
      paramView.setImageResource(j);
      return;
      label51:
      j = 2130838300;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        j = 2130838311;
      } else {
        j = 2130838295;
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
        localObject3 = (akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      } while (localObject3 == null);
      localObject3 = ((akji)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = ayvc.a();
    String str2 = alpo.a(2131700773);
    int j = str2.indexOf(alpo.a(2131700771));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new aslp((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((aslp)localObject1).a(j, j + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aslp)localObject1);
    aslq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (afdm)aekt.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (afdm)aekt.a(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (afdm)aekt.a(paramView);
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
    paramView = aekt.a(paramView);
    if (!(paramView instanceof afdm)) {}
    do
    {
      return;
      paramView = (afdm)paramView;
      if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */