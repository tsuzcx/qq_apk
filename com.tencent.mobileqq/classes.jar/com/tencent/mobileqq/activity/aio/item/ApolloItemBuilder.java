package com.tencent.mobileqq.activity.aio.item;

import aavz;
import admh;
import afqr;
import aftk;
import agnj;
import agnk;
import agnl;
import agnm;
import agnn;
import agno;
import agnp;
import agnq;
import agnr;
import amlm;
import amme;
import ammt;
import amnc;
import anbz;
import ancc;
import anch;
import anci;
import anck;
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
import anhm;
import anjy;
import anjz;
import anka;
import ankc;
import anvx;
import aozm;
import aqhi;
import avhz;
import avia;
import bcrg;
import bhjq;
import bhjs;
import bisl;
import bkzi;
import bkzz;
import blvp;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nty;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  private static CopyOnWriteArraySet<amlm> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static final float b;
  private static int jdField_d_of_type_Int;
  private ammt jdField_a_of_type_Ammt;
  protected View.OnClickListener a;
  private MessageForApollo jdField_a_of_type_ComTencentMobileqqDataMessageForApollo;
  private View.OnClickListener b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new agnl(this);
  private long jdField_d_of_type_Long;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new agnn(this);
  private int jdField_e_of_type_Int = 135;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new agno(this);
  private int jdField_f_of_type_Int = 135;
  boolean jdField_f_of_type_Boolean = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (DeviceInfoUtil.getDispalyDpi() / 160) / 2.0F;
    jdField_d_of_type_Int = -1;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new agnk(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agnm(this);
    paramQQAppInterface = (amme)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Ammt = paramQQAppInterface.a();
    }
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838461), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838462), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838463), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838462), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838461), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838464), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838465), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838464), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838445), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838446), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838447), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838446), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838445), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838448), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838449), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838448), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, agnq paramagnq, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    int k = 1;
    if (a(paramMessageForApollo, paramagnq)) {
      return paramView;
    }
    if (paramMessageForApollo.isNewAnimation())
    {
      a(paramMessageForApollo, paramBaseChatItemLayout, paramagnq);
      return paramView;
    }
    if (paramagnq.jdField_a_of_type_Amlm != null)
    {
      paramagnq.jdField_a_of_type_Amlm.d();
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramagnq.jdField_a_of_type_Amlm);
    }
    a(paramagnq.jdField_c_of_type_AndroidViewView, 8);
    if (this.g)
    {
      b(paramagnq, paramMessageForApollo.isSend());
      a(paramMessageForApollo, paramView, paramagnq);
      paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      a(paramagnq.jdField_a_of_type_ComTencentImageURLImageView, 8);
      a(paramagnq.jdField_c_of_type_AndroidWidgetTextView, 8);
      a(paramagnq.jdField_a_of_type_AndroidWidgetTextView, 0);
      a(paramagnq.jdField_a_of_type_AndroidWidgetImageView, 0);
      b(paramMessageForApollo, paramBaseChatItemLayout, paramagnq);
      a(paramMessageForApollo, paramBaseChatItemLayout, paramagnq, ((ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(paramMessageForApollo.mApolloMessage.id));
      a(paramMessageForApollo, paramagnq);
      paramBaseChatItemLayout = (anch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER);
      if (paramBaseChatItemLayout.a() == null) {
        break label436;
      }
    }
    label428:
    label436:
    for (boolean bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);; bool1 = false)
    {
      if (paramBaseChatItemLayout.a() != null) {}
      for (boolean bool2 = paramBaseChatItemLayout.a().c();; bool2 = true)
      {
        a(paramMessageForApollo, paramagnq, bool1, bool2);
        b(paramMessageForApollo);
        if (anhm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {}
        for (;;)
        {
          if ((paramagnq.jdField_b_of_type_Int != paramagnq.jdField_c_of_type_Int - 1) || (k != 0) || (paramMessageForApollo.isSend())) {
            break label428;
          }
          a(paramMessageForApollo);
          return paramView;
          b(paramagnq, paramMessageForApollo.isSend());
          if (paramMessageForApollo.mApolloMessage != null) {
            paramagnq.jdField_e_of_type_Int = paramMessageForApollo.mApolloMessage.id;
          }
          paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramagnq.jdField_e_of_type_Int));
          paramagnq.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          paramagnq.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramaftk);
          paramagnq.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          paramagnq.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramaftk);
          a(paramagnq, paramView.getResources(), false);
          a(paramagnq.jdField_a_of_type_AndroidWidgetTextView, 8);
          a(paramagnq.jdField_b_of_type_AndroidWidgetTextView, 8);
          a(paramagnq.jdField_a_of_type_AndroidWidgetImageView, 8);
          break;
          k = 0;
        }
        break;
      }
    }
  }
  
  private bisl a()
  {
    if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null)
    {
      if (((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAuthcmShowDialog == null) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAuthcmShowDialog = new bisl(this.jdField_a_of_type_AndroidContentContext);
      }
      return ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().mAuthcmShowDialog;
    }
    return null;
  }
  
  private void a(agnq paramagnq)
  {
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
    if (paramagnq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == anka.jdField_c_of_type_Int) {
      localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 1, "userClick");
    }
    do
    {
      return;
      if (paramagnq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == anka.jdField_f_of_type_Int)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128, "userClick");
        return;
      }
      if (paramagnq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == anka.jdField_d_of_type_Int)
      {
        localVasExtensionHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 2, "userClick");
        return;
      }
    } while (paramagnq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != anka.jdField_e_of_type_Int);
    aozm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
  }
  
  private void a(agnq paramagnq, bkzi parambkzi, ApolloActionData paramApolloActionData)
  {
    parambkzi.c(2131690697);
    parambkzi.a(new agnj(this, paramagnq, paramApolloActionData, parambkzi));
    parambkzi.show();
  }
  
  static void a(agnq paramagnq, boolean paramBoolean)
  {
    int m = 0;
    if ((paramagnq.jdField_d_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramagnq.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramagnq.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramagnq.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        k = 8;
        ((ImageView)localObject).setVisibility(k);
      }
    }
    else
    {
      if (paramagnq.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramagnq.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label150;
        }
        k = 8;
        label68:
        ((TextView)localObject).setVisibility(k);
      }
      if (paramagnq.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramagnq.jdField_a_of_type_ComTencentImageURLImageView;
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
      if (paramagnq.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramagnq.jdField_b_of_type_AndroidWidgetImageView;
        k = m;
        if (paramBoolean) {
          k = 8;
        }
        ((ImageView)localObject).setVisibility(k);
      }
      if (paramagnq.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramagnq.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      k = 0;
      break;
      k = 0;
      break label68;
    }
  }
  
  public static void a(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = aavz.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.isUpComingPrevious))
    {
      int k = ((FragmentActivity)paramContext).getChatFragment().a().getCurrentPanel();
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
      paramView.putString("extra.GROUP_UIN", paramSessionInfo.curFriendUin);
      paramView.putString("uin", paramSessionInfo.curFriendUin);
      paramView.putInt("forward_source_uin_type", paramSessionInfo.curType);
    }
    localObject = new ApolloActionData();
    ((ApolloActionData)localObject).actionId = paramMessageForApollo.mApolloMessage.id;
    paramSessionInfo = new AIOImageData();
    paramSessionInfo.f = paramMessageForApollo.uniseq;
    paramSessionInfo.a = ApolloUtil.a((ApolloActionData)localObject, 0);
    localObject = agnp.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    blvp.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1, -1);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new ApolloItemBuilder.2(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramMessageForApollo != null))
    {
      this.i = false;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      Object localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
      Object localObject2 = "apollo_sp_key_aio_open_tips_count" + (String)localObject1;
      if (jdField_d_of_type_Int == -1) {
        jdField_d_of_type_Int = ((SharedPreferences)localObject3).getInt((String)localObject2, 0);
      }
      if (jdField_d_of_type_Int >= 3) {}
      int k;
      do
      {
        return;
        localObject4 = Calendar.getInstance();
        ((Calendar)localObject4).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        k = ((Calendar)localObject4).get(1);
        m = ((Calendar)localObject4).get(2);
        n = ((Calendar)localObject4).get(5);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("apollo_sp_key_aio_open_tips_day").append((String)localObject1).append("_").append(k).append("_").append(m + 1).append("_").append(n);
        localObject4 = ((StringBuilder)localObject4).toString();
      } while (((SharedPreferences)localObject3).getBoolean((String)localObject4, false));
      jdField_d_of_type_Int += 1;
      localObject3 = ((SharedPreferences)localObject3).edit();
      ((SharedPreferences.Editor)localObject3).putInt((String)localObject2, jdField_d_of_type_Int);
      ((SharedPreferences.Editor)localObject3).putBoolean((String)localObject4, true);
      ((SharedPreferences.Editor)localObject3).commit();
      QLog.d("ApolloItemBuilder", 1, "showOpenCmShowTips");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      long l = bcrg.a();
      Object localObject4 = anjy.a();
      localObject3 = ((anjz)localObject4).a;
      int m = ((String)localObject3).indexOf(((anjz)localObject4).b);
      int n = ((anjz)localObject4).b.length();
      localObject4 = new Bundle();
      ((Bundle)localObject4).putInt("key_action", 65);
      StringBuilder localStringBuilder = new StringBuilder().append("");
      if (paramMessageForApollo.is3dAction())
      {
        k = 2;
        ((Bundle)localObject4).putString("key_action_DATA", k);
        ((Bundle)localObject4).putString("textColor", "#40A0FF");
        localObject1 = new avhz((String)localObject2, (String)localObject1, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, -5020, 2359300, l);
        ((avhz)localObject1).a(m, m + n, (Bundle)localObject4);
        localObject2 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avhz)localObject1);
        avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        k = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        if (!paramMessageForApollo.is3dAction()) {
          break label513;
        }
      }
      label513:
      for (paramMessageForApollo = "3D";; paramMessageForApollo = "2D")
      {
        VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "opencm_guideword_show", k, 0, new String[] { paramMessageForApollo });
        return;
        k = 1;
        break;
      }
    }
    QLog.d("ApolloItemBuilder", 1, new Object[] { "showOpenCmShowTips, mShouldShowOpenTips=", Boolean.valueOf(this.i) });
  }
  
  private void a(MessageForApollo paramMessageForApollo, agnq paramagnq)
  {
    int m = 0;
    if (anhm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
    {
      k = 1;
      if (((paramMessageForApollo.isSend()) || (!amme.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq)))) && ((paramMessageForApollo.isSend()) || (k != 0))) {
        break label121;
      }
      amme.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
      if (k == 0) {
        break label87;
      }
      a(paramagnq, 1);
    }
    label87:
    label121:
    while ((paramagnq.jdField_b_of_type_Int != paramagnq.jdField_c_of_type_Int - 1) || ((k == 0) && ((anhm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0) || (!paramMessageForApollo.isSend()) || (bcrg.a() - paramMessageForApollo.time >= 10L))))
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
    if (this.j) {
      h();
    }
    if (paramMessageForApollo.isSend()) {}
    for (int k = m;; k = 1)
    {
      a(paramagnq, k);
      return;
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView, agnq paramagnq)
  {
    if (paramMessageForApollo.mApolloMessage != null)
    {
      String str = ApolloUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForApollo);
      if (!TextUtils.isEmpty(str)) {
        paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(str);
      }
      if ((!paramMessageForApollo.isDoubleAction()) || (paramMessageForApollo.mApolloMessage.text == null) || (paramMessageForApollo.mApolloMessage.text.length <= 0)) {
        break label207;
      }
      paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
      }
    }
    for (;;)
    {
      paramagnq.jdField_e_of_type_Int = paramMessageForApollo.mApolloMessage.id;
      paramView.setContentDescription(anvx.a(2131699902) + paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
      paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
      paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramagnq.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
      paramagnq.jdField_a_of_type_AndroidWidgetTextView.setText(paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder);
      return;
      label207:
      if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
        paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agnq paramagnq)
  {
    paramMessageForApollo = (MessageForApollo)paramagnq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramMessageForApollo.stickerWidth == 0)
    {
      paramMessageForApollo.stickerWidth = this.jdField_e_of_type_Int;
      if (paramMessageForApollo.stickerHeight != 0) {
        break label295;
      }
      paramMessageForApollo.stickerHeight = this.jdField_f_of_type_Int;
    }
    for (;;)
    {
      if (!paramagnq.jdField_a_of_type_Boolean)
      {
        paramagnq.jdField_a_of_type_Boolean = true;
        int k = AIOUtils.dp2px(paramMessageForApollo.stickerWidth, this.jdField_a_of_type_AndroidContentContext.getResources());
        int m = AIOUtils.dp2px(paramMessageForApollo.stickerHeight, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramBaseChatItemLayout = new amnc();
        paramBaseChatItemLayout.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidContentContext;
        paramBaseChatItemLayout.jdField_a_of_type_Int = k;
        paramBaseChatItemLayout.jdField_b_of_type_Int = m;
        paramagnq.jdField_a_of_type_Amlm = new amlm(paramBaseChatItemLayout);
        paramBaseChatItemLayout = paramagnq.jdField_a_of_type_Amlm.a();
        if ((paramBaseChatItemLayout != null) && (paramBaseChatItemLayout.getParent() == null))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, m);
          paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramBaseChatItemLayout, localLayoutParams);
          paramagnq.jdField_c_of_type_AndroidViewView = paramBaseChatItemLayout;
        }
      }
      if (paramagnq.jdField_a_of_type_Amlm != null) {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramagnq.jdField_a_of_type_Amlm);
      }
      a(paramagnq.jdField_a_of_type_ComTencentImageURLImageView, 8);
      a(paramagnq.jdField_c_of_type_AndroidWidgetTextView, 8);
      a(paramagnq.jdField_a_of_type_AndroidWidgetTextView, 8);
      a(paramagnq.jdField_b_of_type_AndroidWidgetTextView, 8);
      a(paramagnq.jdField_a_of_type_AndroidWidgetImageView, 8);
      a(paramagnq.jdField_c_of_type_AndroidViewView, 0);
      paramagnq.jdField_a_of_type_Amlm.a(paramMessageForApollo);
      paramagnq.jdField_a_of_type_Amlm.a();
      a(paramagnq.jdField_d_of_type_AndroidWidgetImageView, 8);
      a(paramagnq.jdField_c_of_type_AndroidWidgetImageView, 8);
      return;
      this.jdField_e_of_type_Int = paramMessageForApollo.stickerWidth;
      break;
      label295:
      this.jdField_f_of_type_Int = paramMessageForApollo.stickerHeight;
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agnq paramagnq, ApolloActionData paramApolloActionData)
  {
    int k;
    if ((paramagnq.jdField_b_of_type_Int == paramagnq.jdField_c_of_type_Int - 1) && (paramApolloActionData != null) && (paramApolloActionData.actionType != 5) && (!a(paramMessageForApollo)))
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
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
        {
          if (!paramMessageForApollo.isSend()) {
            break label144;
          }
          paramagnq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramagnq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
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
      paramagnq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramagnq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
    c(paramMessageForApollo, paramBaseChatItemLayout, paramagnq);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new ApolloItemBuilder.3(paramContext, paramInt, paramString));
  }
  
  private boolean a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {
      QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
    }
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "click game msg, roomId:" + paramMessageForApollo.roomId);
      }
      if ((paramMessageForApollo.mApolloMessage == null) || (paramMessageForApollo.mApolloMessage.id == 99999))
      {
        QQToast.a(paramView.getContext(), anvx.a(2131699907), 0).a();
        return true;
      }
    } while (!amme.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()));
    return false;
  }
  
  private boolean a(MessageForApollo paramMessageForApollo, agnq paramagnq)
  {
    if ((paramagnq == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    while (!(paramagnq instanceof agnq)) {
      return true;
    }
    return false;
  }
  
  private AnimationDrawable b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838455), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838459), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838456), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838457), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838458), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838450), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838454), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838451), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838452), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838453), 200);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private void b(agnq paramagnq, boolean paramBoolean)
  {
    if (!(paramagnq instanceof agnq)) {}
    do
    {
      do
      {
        return;
        a(paramagnq, false);
        if (!this.g) {
          break;
        }
        if (paramagnq.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131374184);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131374185);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramagnq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramagnq.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.jdField_f_of_type_Int);
          ((AnimationTextView)localObject).setMinWidth(AIOUtils.dp2px(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramagnq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramagnq.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramagnq.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramagnq.jdField_f_of_type_Int = 0;
        if (paramagnq.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, AIOUtils.dp2px(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramagnq.jdField_a_of_type_AndroidTextStyleImageSpan = new agnr((Drawable)localObject);
        }
        if (paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramagnq.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
        int n = BaseChatItemLayout.o;
        int m = BaseChatItemLayout.p;
        int k = BaseChatItemLayout.o;
        if (paramBoolean)
        {
          n = BaseChatItemLayout.p;
          m = BaseChatItemLayout.o;
          k = BaseChatItemLayout.p;
        }
        paramagnq.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.m, m, BaseChatItemLayout.n);
        localObject = (ViewGroup.MarginLayoutParams)paramagnq.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(n, BaseChatItemLayout.m, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = AIOUtils.dp2px(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = AIOUtils.dp2px(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramagnq.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramagnq.jdField_b_of_type_AndroidWidgetImageView == null);
      paramagnq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      if (paramagnq.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
        ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(13);
        paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
        paramagnq.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      }
    } while (paramagnq.jdField_b_of_type_AndroidWidgetImageView != null);
    Object localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130839466);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramagnq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramagnq.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localamme.a(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localamme.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localamme.a(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label267;
        }
        localamme.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
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
      localamme.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label267:
    localamme.a(localApolloBaseInfo.uin, 1);
  }
  
  private void b(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agnq paramagnq)
  {
    ImageView localImageView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramagnq.jdField_d_of_type_AndroidWidgetImageView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131367047);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364522);
      localLayoutParams.addRule(15, 2131363423);
      localLayoutParams.leftMargin = 10;
      localImageView.setContentDescription(anvx.a(2131699904));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130847120);
      paramagnq.jdField_d_of_type_AndroidWidgetImageView = localImageView;
      paramagnq.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    if (paramagnq.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setId(2131367046);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(0, 2131364522);
      localLayoutParams.addRule(15, 2131363423);
      localImageView.setContentDescription(anvx.a(2131699908));
      paramBaseChatItemLayout.addView(localImageView, localLayoutParams);
      localImageView.setImageResource(2130847120);
      paramagnq.jdField_c_of_type_AndroidWidgetImageView = localImageView;
      paramagnq.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    paramBaseChatItemLayout = (TextView)paramBaseChatItemLayout.findViewById(2131364553);
    if ((paramMessageForApollo.mNeedTimeStamp) && (paramMessageForApollo.time > 0L) && (paramBaseChatItemLayout != null) && (paramMessageForApollo.time != ((Long)paramBaseChatItemLayout.getTag()).longValue()))
    {
      paramagnq.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramagnq.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    }
    for (;;)
    {
      paramagnq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramagnq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramagnq.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
      paramagnq.jdField_d_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    }
  }
  
  private boolean b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000) && (!anck.a(paramMessageForApollo.istroop))) {}
    while ((!amme.b(this.jdField_a_of_type_AndroidContentContext)) || ((!anjy.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (anck.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) && (amme.c("discuss") == 0))) {
      return false;
    }
    paramMessageForApollo = ((amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
  
  private void c(MessageForApollo paramMessageForApollo)
  {
    Object localObject = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    VasExtensionHandler localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
    if (localVasExtensionHandler != null)
    {
      ArrayList localArrayList = new ArrayList(2);
      int k;
      if (!paramMessageForApollo.isSend())
      {
        ApolloBaseInfo localApolloBaseInfo = ((amme)localObject).a(paramMessageForApollo.senderuin);
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
        localObject = ((amme)localObject).a(paramMessageForApollo.mApolloMessage.peer_uin + "");
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
        localVasExtensionHandler.a((String[])localArrayList.toArray(new String[0]));
      }
    }
  }
  
  private void c(MessageForApollo paramMessageForApollo, BaseChatItemLayout paramBaseChatItemLayout, agnq paramagnq)
  {
    ThreadManager.post(new ApolloItemBuilder.1(this, paramMessageForApollo, paramBaseChatItemLayout, paramagnq), 5, null, true);
  }
  
  private boolean d()
  {
    return (!this.jdField_f_of_type_Boolean) || (a()) || (System.currentTimeMillis() - this.jdField_c_of_type_Long < 600L);
  }
  
  public static void e()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((amlm)localIterator.next()).c();
    }
  }
  
  public static void f()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((amlm)localIterator.next()).b();
    }
  }
  
  public static void g()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((amlm)localIterator.next()).d();
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForApollo)) && (((MessageForApollo)paramChatMessage).isNewAnimation())) {
      return 0;
    }
    if (this.g) {
      return 1;
    }
    return 2;
  }
  
  public afqr a()
  {
    return new agnq();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramaftk = (agnq)paramViewGroup.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    Object localObject2;
    Object localObject1;
    if (this.g)
    {
      if (paramaftk.jdField_c_of_type_AndroidWidgetTextView != null) {
        paramaftk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject2 = ((ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).b(paramChatMessage.mApolloMessage.id);
      if ((localObject2 != null) && (((ApolloActionData)localObject2).gameId > 0))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
        if (paramaftk.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramChatMessage = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramChatMessage.setMaxWidth(BaseChatItemLayout.jdField_f_of_type_Int);
          paramChatMessage.setMinWidth(AIOUtils.dp2px(35.0F, (Resources)localObject1));
          paramChatMessage.setHeight(AIOUtils.dp2px(18.0F, (Resources)localObject1));
          paramChatMessage.setSingleLine(true);
          paramChatMessage.setGravity(16);
          paramChatMessage.setEllipsize(TextUtils.TruncateAt.END);
          paramChatMessage.setTextColor(-1);
          paramChatMessage.setBackgroundResource(2130842656);
          paramChatMessage.setTextSize(2, 12.0F);
          paramChatMessage.setPadding(AIOUtils.dp2px(6.0F, (Resources)localObject1), 0, AIOUtils.dp2px(6.0F, (Resources)localObject1), 0);
          paramView = new RelativeLayout.LayoutParams(-2, -2);
          paramView.addRule(5, 2131364522);
          paramView.addRule(3, 2131364522);
          paramChatMessage.setLayoutParams(paramView);
          paramView.topMargin = AIOUtils.dp2px(-3.0F, (Resources)localObject1);
          paramView.leftMargin = AIOUtils.dp2px(12.0F, (Resources)localObject1);
          paramaftk.jdField_b_of_type_AndroidWidgetTextView = paramChatMessage;
          paramaftk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(paramChatMessage, paramView);
          paramaftk.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        }
        paramaftk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = anvx.a(2131699906);
        paramChatMessage = paramView;
        if (!TextUtils.isEmpty(((ApolloActionData)localObject2).gameName)) {
          paramChatMessage = paramView + "-" + ((ApolloActionData)localObject2).gameName;
        }
        paramaftk.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
        paramChatMessage = ((Resources)localObject1).getDrawable(2130838586);
        paramChatMessage.setBounds(0, 0, paramChatMessage.getIntrinsicWidth(), paramChatMessage.getIntrinsicHeight());
        paramaftk.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramChatMessage, null, null, null);
        paramaftk.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, (Resources)localObject1));
      }
      for (;;)
      {
        return paramViewGroup;
        if (paramaftk.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramaftk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
    if (paramaftk.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramaftk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramaftk.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      paramView = paramaftk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setSingleLine(true);
      ((TextView)localObject1).setGravity(16);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setPadding(AIOUtils.dp2px(5.0F, paramChatMessage), 0, AIOUtils.dp2px(5.0F, paramChatMessage), 0);
      ((TextView)localObject1).setBackgroundResource(2130842656);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131364522);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364522);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(-3.0F, paramChatMessage);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(12.0F, paramChatMessage);
      paramaftk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      paramaftk.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    paramaftk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramaftk.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131699909));
    paramView = paramChatMessage.getDrawable(2130838584);
    paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    paramaftk.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
    paramaftk.jdField_c_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(5.0F, paramChatMessage), 0, AIOUtils.dp2px(5.0F, paramChatMessage), 0);
    return paramViewGroup;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramafqr instanceof agnq)) {
      return paramView;
    }
    paramafqr = (agnq)paramafqr;
    if ((paramView == null) || ((paramafqr != null) && (paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout == null)))
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131374185);
      paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    for (;;)
    {
      paramChatMessage.setOnTouchListener(paramaftk);
      paramChatMessage.setOnLongClickListener(paramaftk);
      this.g = b(localMessageForApollo);
      return a(localMessageForApollo, paramafqr, paramChatMessage, paramBaseChatItemLayout, paramaftk);
      paramChatMessage = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anvx.a(2131699905) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((amlm)localIterator.next()).d();
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForApollo))) {}
    MessageForApollo localMessageForApollo;
    boolean bool;
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
          case 2131365475: 
            admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
          }
        } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
        if (bool) {}
        for (paramContext = "y_long_press_delbq";; paramContext = "long_press_del")
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", paramContext, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
          return;
        }
      } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
      a(localMessageForApollo.mApolloMessage.id, localMessageForApollo);
      return;
      super.a(paramChatMessage);
    } while ((localMessageForApollo == null) || (localMessageForApollo.mApolloMessage == null));
    if (bool) {}
    for (paramContext = "y_long_press_withdrawbq";; paramContext = "long_press_withdraw")
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", paramContext, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      return;
    }
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = ((ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(paramInt);
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
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690057), 1, this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    localObject3 = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
    if (paramMessageForApollo.isBarrageMode()) {}
    for (localObject2 = "1";; localObject2 = "0")
    {
      ((VasExtensionHandler)localObject3).a(paramInt, (String)localObject1, (String)localObject2, paramMessageForApollo.audioId, paramMessageForApollo.audioStartTime, paramMessageForApollo.isPlayDefaultAudio, "actionAdd");
      paramMessageForApollo = a();
      if (paramMessageForApollo == null) {
        break;
      }
      paramMessageForApollo.c(2131690108);
      paramMessageForApollo.show();
      return;
    }
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    if (!(paramafqr instanceof agnq)) {}
    agnq localagnq;
    do
    {
      return;
      localagnq = (agnq)paramafqr;
    } while ((paramaqhi == null) || (localagnq.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramaqhi.jdField_a_of_type_Int == 0) || (!paramaqhi.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramafqr = paramView.getColorStateList(2131167049);
        if (paramafqr != null) {
          localagnq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramafqr = paramView.getColorStateList(2131167048);; paramafqr = paramView.getColorStateList(2131167047))
      {
        localagnq.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramafqr);
        return;
        paramafqr = paramView.getColorStateList(2131167045);
        break;
      }
    }
    if (paramaqhi.jdField_b_of_type_Int == 0) {
      localagnq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramaqhi.jdField_c_of_type_Int == 0)
    {
      localagnq.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167047));
      return;
      localagnq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
    }
    localagnq.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramaqhi.jdField_c_of_type_Int);
  }
  
  public void a(agnq paramagnq, int paramInt)
  {
    paramagnq = (MessageForApollo)paramagnq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramagnq.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = (anch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER);
      anbz localanbz = ((anch)localObject).a();
      localObject = ((anch)localObject).a();
      if (this.jdField_c_of_type_Int != 1) {
        ((ancc)localObject).e(true);
      }
      if (localanbz != null) {
        localanbz.a(paramInt, paramagnq);
      }
    }
  }
  
  public void a(agnq paramagnq, Resources paramResources, boolean paramBoolean)
  {
    if ((paramagnq == null) || (paramResources == null)) {
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838585);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838587);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramagnq.jdField_e_of_type_Int));
        File localFile = new File(agnp.a(paramagnq.jdField_e_of_type_Int));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramagnq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramagnq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramagnq.jdField_e_of_type_Int + " drawable.getStatus()->" + paramResources.getStatus());
        return;
      }
      catch (Throwable paramagnq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloItemBuilder", 2, paramagnq.getMessage());
      return;
      label204:
      long l = 0L;
      continue;
      label210:
      paramResources = URLDrawable.getDrawable(paramResources, localURLDrawableOptions);
      paramResources.setTag(Integer.valueOf(paramagnq.jdField_e_of_type_Int));
      paramagnq.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramagnq.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramagnq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramagnq.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    paramView = (agnq)AIOUtils.getHolder(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      a(paramView);
      ApolloBaseInfo localApolloBaseInfo = ((amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
      ankc localankc = (ankc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      ApolloActionData localApolloActionData = localankc.a(paramView.jdField_e_of_type_Int);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == anka.jdField_c_of_type_Int) && (localApolloBaseInfo != null) && (localApolloBaseInfo.apolloVipFlag != 1))
      {
        localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690073));
        localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690072), 1);
        paramView.jdField_f_of_type_Int = 1;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == anka.jdField_d_of_type_Int) && (localApolloActionData != null) && (localApolloBaseInfo != null) && (localApolloActionData.vipLevel < localApolloBaseInfo.apolloVipLevel))
      {
        localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690073));
        localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690072), 1);
        paramView.jdField_f_of_type_Int = 2;
        ApolloUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "lmx_actchat");
        return;
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == anka.jdField_f_of_type_Int) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localankc.b(localApolloActionData.actionId))))
      {
        localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690070));
        localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690069), 1);
        paramView.jdField_f_of_type_Int = 3;
      }
      for (;;)
      {
        a(paramView, localbkzi, localApolloActionData);
        return;
        if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == anka.jdField_e_of_type_Int)
        {
          localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690071));
          paramView.jdField_f_of_type_Int = 4;
        }
        else
        {
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout))) {
            break;
          }
          localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690075), 1);
        }
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.getHolder(paramView);
    if (!(paramView instanceof agnq)) {}
    amme localamme;
    do
    {
      do
      {
        return;
        paramView = (agnq)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        amme.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.jdField_e_of_type_Int));
        return;
      }
      if (!amme.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.jdField_e_of_type_Int))) {
        amme.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.jdField_e_of_type_Int));
      }
      localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    } while ((localamme != null) && (localamme.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    }
    agnq localagnq;
    if ((paramView != null) && ((AIOUtils.getHolder(paramView) instanceof agnq)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        amme.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localagnq = (agnq)AIOUtils.getHolder(paramView);
      if (!super.a(paramMessageForApollo, localagnq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localagnq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localagnq.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localagnq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout1, BaseChatItemLayout paramBaseChatItemLayout2, int paramInt1, int paramInt2)
  {
    Object localObject = AIOUtils.getHolder(paramBaseChatItemLayout2);
    if (!(localObject instanceof agnq)) {}
    do
    {
      do
      {
        return;
        paramBaseChatItemLayout2 = AIOUtils.getHolder(paramBaseChatItemLayout1);
      } while (!(paramBaseChatItemLayout2 instanceof agnq));
      localObject = (agnq)localObject;
      paramBaseChatItemLayout2 = (agnq)paramBaseChatItemLayout2;
    } while (((agnq)localObject).jdField_e_of_type_Int != paramBaseChatItemLayout2.jdField_e_of_type_Int);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  protected void a(MessageForApollo paramMessageForApollo, agnq paramagnq, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramagnq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (amme.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramagnq.jdField_e_of_type_Int)))
    {
      localObject = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
      if ((localObject != null) && (((amme)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) != 2) && (paramBoolean2)) {
        paramagnq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean1)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramagnq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        amme.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramagnq.jdField_e_of_type_Int));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        }
        return;
      }
    }
    int k;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        k = 2130838455;
      }
    }
    for (;;)
    {
      paramagnq.jdField_a_of_type_AndroidWidgetImageView.setImageResource(k);
      return;
      k = 2130838450;
      continue;
      if (paramMessageForApollo.isSend()) {
        k = 2130838461;
      } else {
        k = 2130838445;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    if (nty.a().a(paramMessageForApollo.frienduin)) {}
    int k;
    do
    {
      return true;
      k = amme.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    } while (((paramMessageForApollo.is3dAction()) && (k != 2)) || ((!paramMessageForApollo.is3dAction()) && (this.jdField_c_of_type_Int == 2)));
    return false;
  }
  
  public bhjs[] a(View paramView)
  {
    boolean bool = false;
    bhjq localbhjq = new bhjq();
    paramView = AIOUtils.getMessage(paramView);
    if (ApolloUtil.a(paramView))
    {
      super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      return localbhjq.a();
    }
    MessageForApollo localMessageForApollo;
    if ((paramView instanceof MessageForApollo))
    {
      localMessageForApollo = (MessageForApollo)paramView;
      bool = localMessageForApollo.isNewAnimation();
      if ((this.g) && (!ApolloGameUtil.a(localMessageForApollo.msgType)) && (!localMessageForApollo.is3dAction()) && (anhm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) && (!bool)) {
        localbhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131690053), 2130838520);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbhjq, paramView);
      if (localMessageForApollo.mApolloMessage != null) {
        if (!bool) {
          break label247;
        }
      }
    }
    label247:
    for (paramView = "y_long_press_bq";; paramView = "long_press_msg")
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", paramView, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      if (!bool) {
        super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
      }
      return localbhjq.a();
    }
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int k;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131374184);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        k = 2130838455;
      }
    }
    for (;;)
    {
      paramView.setImageResource(k);
      return;
      label51:
      k = 2130838450;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        k = 2130838461;
      } else {
        k = 2130838445;
      }
    }
  }
  
  public void h()
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
          this.j = false;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
          str1 = "apollo_invite_gray_tip" + (String)localObject2 + "_" + (String)localObject1;
          localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        } while (!localSharedPreferences.getBoolean(str1, true));
        localObject3 = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
      } while (localObject3 == null);
      localObject3 = ((amme)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).isApolloStatusOpen()));
    long l = bcrg.a();
    String str2 = anvx.a(2131699903);
    int k = str2.indexOf(anvx.a(2131699901));
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#40A0FF");
    ((Bundle)localObject3).putString("key_action_DATA", "https://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new avhz((String)localObject1, (String)localObject2, str2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, -5040, 2359297, l);
    ((avhz)localObject1).a(k, k + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avhz)localObject1);
    avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (agnq)AIOUtils.getHolder(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (agnq)AIOUtils.getHolder(paramView);
    if (paramView.jdField_b_of_type_AndroidWidgetImageView != null) {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadFailed id: " + paramURLDrawable.getTag() + ", status: " + paramURLDrawable.getStatus());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    paramView = (agnq)AIOUtils.getHolder(paramView);
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
    if (!(paramView instanceof agnq)) {}
    do
    {
      return;
      paramView = (agnq)paramView;
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