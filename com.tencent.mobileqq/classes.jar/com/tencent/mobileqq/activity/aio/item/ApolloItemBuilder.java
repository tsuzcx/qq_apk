package com.tencent.mobileqq.activity.aio.item;

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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
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
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteTaskHandler;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utq;
import uts;
import utt;
import utu;
import utv;
import utw;
import utx;

public class ApolloItemBuilder
  extends BaseBubbleBuilder
  implements URLDrawableDownListener
{
  public static final float b;
  protected View.OnClickListener a;
  private MessageForApollo a;
  private int jdField_b_of_type_Int = 0;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new utv(this);
  private long jdField_c_of_type_Long;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new utx(this);
  public boolean c;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = true;
  
  static
  {
    jdField_b_of_type_Float = 12.0F * (DeviceInfoUtil.d() / 160) / 2.0F;
  }
  
  public ApolloItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new utw(this);
  }
  
  private AnimationDrawable a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837999), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838000), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838001), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838000), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837999), 300);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838002), 100);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838003), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838002), 140);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837983), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837984), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837985), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837984), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837983), 300);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837986), 100);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837987), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837986), 140);
    localAnimationDrawable.selectDrawable(0);
    localAnimationDrawable.setOneShot(false);
    return localAnimationDrawable;
  }
  
  private View a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = false;
    if ((paramHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {}
    label633:
    do
    {
      do
      {
        return paramView;
      } while (!(paramHolder instanceof ApolloItemBuilder.Holder));
      if ((paramMessageForApollo != null) && (this.jdField_d_of_type_Boolean))
      {
        b(paramHolder, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null)
        {
          if ((paramMessageForApollo.mApolloMessage.name != null) && (paramMessageForApollo.mApolloMessage.name.length > 0)) {
            paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(new String(paramMessageForApollo.mApolloMessage.name));
          }
          if ((paramMessageForApollo.isDoubleAction()) && (paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
          {
            paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
            if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
              paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(" ").append(paramMessageForApollo.inputText);
            }
            paramHolder.e = paramMessageForApollo.mApolloMessage.id;
          }
        }
        else
        {
          paramView.setContentDescription("动作消息" + paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.toString());
          paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.insert(0, "[a]");
          paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan, 0, "[a]".length(), 33);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder);
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if (paramHolder.jdField_a_of_type_ComTencentImageURLImageView != null) {
            paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          }
          if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          RelativeLayout.LayoutParams localLayoutParams;
          if (paramHolder.d == null)
          {
            localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject).setId(2131361944);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(1, 2131361877);
            localLayoutParams.addRule(15, 2131361996);
            localLayoutParams.leftMargin = 10;
            ((ImageView)localObject).setContentDescription("加一");
            paramBaseChatItemLayout.addView((View)localObject, localLayoutParams);
            ((ImageView)localObject).setImageResource(2130843958);
            paramHolder.d = ((ImageView)localObject);
            paramHolder.d.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          }
          if (paramHolder.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject).setId(2131361943);
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(0, 2131361877);
            localLayoutParams.addRule(15, 2131361996);
            ((ImageView)localObject).setContentDescription("加一");
            paramBaseChatItemLayout.addView((View)localObject, localLayoutParams);
            ((ImageView)localObject).setImageResource(2130843958);
            paramHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject);
            paramHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          }
          Object localObject = (TextView)paramBaseChatItemLayout.findViewById(2131361861);
          if ((!paramMessageForApollo.mNeedTimeStamp) || (paramMessageForApollo.time <= 0L) || (localObject == null) || (paramMessageForApollo.time == ((Long)((TextView)localObject).getTag()).longValue())) {
            break label935;
          }
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramHolder.d.setPadding(0, AIOUtils.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramHolder.d.setVisibility(8);
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          localObject = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramMessageForApollo.mApolloMessage.id);
          if ((paramHolder.jdField_b_of_type_Int == paramHolder.jdField_c_of_type_Int - 1) && (localObject != null) && (((ApolloActionData)localObject).actionType != 5))
          {
            if (((paramMessageForApollo.extraflag != 32768) || (!paramMessageForApollo.isSendFromLocal())) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramMessageForApollo))) {
              break label984;
            }
            i = 1;
            if (i == 0)
            {
              if ((!this.e) || (this.jdField_d_of_type_Long != paramMessageForApollo.uniseq)) {
                break label1010;
              }
              if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
              {
                if (!paramMessageForApollo.isSend()) {
                  break label990;
                }
                paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                paramHolder.d.setVisibility(8);
              }
            }
          }
          if ((paramMessageForApollo.isSend()) || (!ApolloManager.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForApollo.uniseq)))) {
            break label1055;
          }
          ApolloManager.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForApollo.uniseq));
          a(paramHolder, 1);
        }
        while (paramHolder.jdField_b_of_type_Int != paramHolder.jdField_c_of_type_Int - 1)
        {
          boolean bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            paramBaseChatItemLayout = (SpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248);
            bool1 = bool2;
            if (paramBaseChatItemLayout.a() != null) {
              bool1 = paramBaseChatItemLayout.a().a(paramMessageForApollo.uniseq);
            }
          }
          a(paramMessageForApollo, paramHolder, bool1);
          a(paramMessageForApollo);
          return paramView;
          if (TextUtils.isEmpty(paramMessageForApollo.inputText)) {
            break;
          }
          paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.append("：").append(paramMessageForApollo.inputText);
          break;
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramHolder.d.setPadding(0, AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          break label633;
          i = 0;
          break label737;
          paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramHolder.d.setVisibility(0);
          break label795;
          if ((this.e) && (this.jdField_d_of_type_Long == paramMessageForApollo.uniseq)) {
            break label795;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo = paramMessageForApollo;
          ThreadManager.post(new utq(this, paramMessageForApollo, paramBaseChatItemLayout, paramHolder), 5, null, true);
          break label795;
        }
        if (this.f) {
          e();
        }
        if (paramMessageForApollo.isSend()) {}
        for (int i = 0;; i = 1)
        {
          a(paramHolder, i);
          break;
        }
      }
      if (paramMessageForApollo != null)
      {
        b(paramHolder, paramMessageForApollo.isSend());
        if (paramMessageForApollo.mApolloMessage != null) {
          paramHolder.e = paramMessageForApollo.mApolloMessage.id;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramHolder.e));
      }
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      a(paramHolder, paramView.getResources(), false);
      if (paramHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    } while (paramHolder.jdField_a_of_type_AndroidWidgetImageView == null);
    label737:
    label1010:
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    label795:
    label935:
    label984:
    label990:
    return paramView;
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
  
  public static void a(Context paramContext, View paramView, MessageForApollo paramMessageForApollo, SessionInfo paramSessionInfo)
  {
    if (paramMessageForApollo.mApolloMessage == null) {
      return;
    }
    Object localObject = AnimationUtils.a(paramView);
    paramView = new Bundle();
    paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)))
    {
      int i = ((FragmentActivity)paramContext).getChatFragment().a().f();
      paramView.putInt("extra.AIO_CURRENT_PANEL_STATE", i);
      if (i == 1)
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
    paramSessionInfo.g = paramMessageForApollo.uniseq;
    paramSessionInfo.jdField_a_of_type_JavaLangString = ApolloUtil.a((ApolloActionData)localObject, 0);
    localObject = ApolloItemBuilder.ApolloGifDownloader.a(paramMessageForApollo.mApolloMessage.id);
    paramSessionInfo.c = ((String)localObject);
    paramSessionInfo.b = ((String)localObject);
    PeakUtils.a(paramContext, paramView, new AIOImageProviderService(paramMessageForApollo.selfuin, paramMessageForApollo.frienduin, paramMessageForApollo.istroop, paramMessageForApollo), paramSessionInfo, -1);
  }
  
  static void a(ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    int j = 8;
    if ((paramHolder.jdField_c_of_type_AndroidWidgetTextView != null) && (!paramBoolean)) {
      paramHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Object localObject;
    if (paramHolder.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean)
      {
        i = 8;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    else
    {
      if (paramHolder.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramHolder.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label156;
        }
        i = 8;
        label69:
        ((TextView)localObject).setVisibility(i);
      }
      if (paramHolder.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        localObject = paramHolder.jdField_a_of_type_ComTencentImageURLImageView;
        if (!paramBoolean) {
          break label161;
        }
        i = 8;
        label95:
        ((URLImageView)localObject).setVisibility(i);
      }
      if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        localObject = paramHolder.jdField_b_of_type_AndroidWidgetImageView;
        if (!paramBoolean) {
          break label166;
        }
        i = 8;
        label121:
        ((ImageView)localObject).setVisibility(i);
      }
      if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramHolder = paramHolder.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label171;
        }
      }
    }
    label156:
    label161:
    label166:
    label171:
    for (int i = j;; i = 0)
    {
      paramHolder.setVisibility(i);
      return;
      i = 0;
      break;
      i = 0;
      break label69;
      i = 0;
      break label95;
      i = 0;
      break label121;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, ApolloFavActionData paramApolloFavActionData, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new uts(paramQQAppInterface, paramContext, paramApolloFavActionData, paramSessionInfo), 5, null, true);
  }
  
  private void a(MessageForApollo paramMessageForApollo)
  {
    long l2 = 0L;
    ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    ApolloBaseInfo localApolloBaseInfo;
    long l1;
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.isSend()))
    {
      localApolloBaseInfo = localApolloManager.b(paramMessageForApollo.senderuin);
      if (localApolloBaseInfo != null)
      {
        l1 = localApolloBaseInfo.apolloUpdateTime;
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label227;
        }
        localApolloManager.a(paramMessageForApollo.senderuin, 2);
      }
    }
    else
    {
      label73:
      if ((paramMessageForApollo != null) && (paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.isDoubleAction()) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMessageForApollo.mApolloMessage.peer_uin + "")))
      {
        localApolloBaseInfo = localApolloManager.b(paramMessageForApollo.mApolloMessage.peer_uin + "");
        l1 = l2;
        if (localApolloBaseInfo != null) {
          l1 = localApolloBaseInfo.apolloUpdateTime;
        }
        if (NetConnInfoCenter.getServerTime() - l1 <= 43200L) {
          break label268;
        }
        localApolloManager.a(paramMessageForApollo.mApolloMessage.peer_uin + "", 2);
      }
    }
    label227:
    while ((localApolloBaseInfo == null) || (1 != localApolloBaseInfo.apolloStatus) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS))
    {
      return;
      l1 = 0L;
      break;
      if ((localApolloBaseInfo == null) || (1 != localApolloBaseInfo.apolloStatus) || (localApolloBaseInfo.apolloServerTS == localApolloBaseInfo.apolloLocalTS)) {
        break label73;
      }
      localApolloManager.a(paramMessageForApollo.senderuin, 1);
      break label73;
    }
    label268:
    localApolloManager.a(localApolloBaseInfo.uin, 1);
  }
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new utt(paramContext, paramInt, paramString));
  }
  
  private boolean a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (paramMessageForApollo.istroop != 0) && (paramMessageForApollo.istroop != 1) && (paramMessageForApollo.istroop != 3000)) {}
    do
    {
      do
      {
        return false;
      } while ((!ApolloManager.a(this.jdField_a_of_type_AndroidContentContext)) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (ApolloManager.c("discuss") == 0)));
      paramMessageForApollo = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (paramMessageForApollo == null);
    this.jdField_b_of_type_Int = paramMessageForApollo.apolloStatus;
    if (this.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private AnimationDrawable b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimationDrawable = new AnimationDrawable();
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837993), 700);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837997), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837994), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837995), 200);
      localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837996), 200);
      localAnimationDrawable.setOneShot(false);
      localAnimationDrawable.selectDrawable(0);
      localAnimationDrawable.setOneShot(false);
      return localAnimationDrawable;
    }
    new AnimationDrawable();
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837988), 700);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837992), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837989), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837990), 200);
    localAnimationDrawable.addFrame(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837991), 200);
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
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
        if (paramHolder.jdField_a_of_type_AndroidWidgetImageView == null)
        {
          localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          ((ImageView)localObject).setId(2131362011);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131362010);
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
        }
        if (paramHolder.jdField_a_of_type_AndroidWidgetTextView == null)
        {
          localObject = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
          ((AnimationTextView)localObject).setMaxWidth(BaseChatItemLayout.e);
          ((AnimationTextView)localObject).setMinWidth(AIOUtils.a(73.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((AnimationTextView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramHolder.f = 0;
        if (paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan == null)
        {
          localObject = new ColorDrawable(0);
          ((ColorDrawable)localObject).setBounds(0, 0, AIOUtils.a(31.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramHolder.jdField_a_of_type_AndroidTextStyleImageSpan = new ApolloItemBuilder.VerticalImageSpan((Drawable)localObject);
        }
        if (paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder == null) {
          paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
        int k = BaseChatItemLayout.n;
        int j = BaseChatItemLayout.o;
        int i = BaseChatItemLayout.n;
        if (paramBoolean)
        {
          k = BaseChatItemLayout.o;
          j = BaseChatItemLayout.n;
          i = BaseChatItemLayout.o;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, BaseChatItemLayout.l, j, BaseChatItemLayout.m);
        localObject = (ViewGroup.MarginLayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).setMargins(k, BaseChatItemLayout.l, 0, 0);
        ((ViewGroup.MarginLayoutParams)localObject).width = AIOUtils.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((ViewGroup.MarginLayoutParams)localObject).height = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramHolder.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
      } while (paramHolder.jdField_b_of_type_AndroidWidgetImageView == null);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
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
    ((ImageView)localObject).setImageResource(2130838596);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if (this.jdField_d_of_type_Boolean) {
      return 1;
    }
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (ApolloItemBuilder.Holder)paramView.getTag();
    paramChatMessage = (MessageForApollo)paramChatMessage;
    if (this.jdField_d_of_type_Boolean)
    {
      if (paramViewGroup.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return paramView;
    }
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramViewGroup.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      paramOnLongClickAndTouchListener = paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setPadding(AIOUtils.a(5.0F, paramChatMessage), 0, AIOUtils.a(5.0F, paramChatMessage), 0);
      localTextView.setBackgroundResource(2130840645);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(5, 2131361877);
      localLayoutParams.addRule(3, 2131361877);
      localLayoutParams.topMargin = AIOUtils.a(-3.0F, paramChatMessage);
      localLayoutParams.leftMargin = AIOUtils.a(12.0F, paramChatMessage);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = localTextView;
      paramOnLongClickAndTouchListener.addView(localTextView, localLayoutParams);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("厘米秀");
    paramOnLongClickAndTouchListener = paramChatMessage.getDrawable(2130838090);
    paramOnLongClickAndTouchListener.setBounds(0, 0, paramOnLongClickAndTouchListener.getIntrinsicWidth(), paramOnLongClickAndTouchListener.getIntrinsicHeight());
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramOnLongClickAndTouchListener, null, null, null);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, paramChatMessage), 0, AIOUtils.a(5.0F, paramChatMessage), 0);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {
      return paramView;
    }
    paramViewHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    if (paramView != null)
    {
      paramChatMessage = paramView;
      if (paramViewHolder != null)
      {
        paramChatMessage = paramView;
        if (paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {}
      }
    }
    else
    {
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131362010);
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = paramChatMessage;
    }
    paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
    this.jdField_d_of_type_Boolean = a(localMessageForApollo);
    return a(localMessageForApollo, paramViewHolder, paramChatMessage, paramBaseChatItemLayout);
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ApolloItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "说" + paramChatMessage.msg;
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
    do
    {
      do
      {
        do
        {
          return;
          paramContext = (MessageForApollo)paramChatMessage;
          switch (paramInt)
          {
          default: 
            return;
          case 2131361906: 
            super.a(paramChatMessage);
          }
        } while ((paramContext == null) || (paramContext.mApolloMessage == null));
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_withdraw", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(paramContext.mApolloMessage.id) });
        return;
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      } while ((paramContext == null) || (paramContext.mApolloMessage == null));
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_del", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(paramContext.mApolloMessage.id) });
      return;
    } while ((paramContext == null) || (paramContext.mApolloMessage == null));
    a(paramContext.mApolloMessage.id, paramContext);
  }
  
  public void a(int paramInt, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).a(paramInt);
    Object localObject2 = paramMessageForApollo.inputText;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new TextView(BaseApplicationImpl.getContext());
      ((TextView)localObject1).setTextSize(51.0F / DeviceInfoUtil.a);
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
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131438197), 1, this.jdField_a_of_type_AndroidContentContext);
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
      paramMessageForApollo.c(2131438190);
      paramMessageForApollo.show();
      return;
    }
  }
  
  protected void a(View paramView)
  {
    paramView = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloItemBuilder", 2, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
      }
      Object localObject = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
      ActionSheet localActionSheet;
      ApolloDaoManager localApolloDaoManager;
      ApolloActionData localApolloActionData;
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_a_of_type_Int)
      {
        ((VasExtensionHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1, "userClick");
        localObject = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        localApolloActionData = localApolloDaoManager.a(paramView.e);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ApolloConstant.jdField_a_of_type_Int) || (localObject == null) || (((ApolloBaseInfo)localObject).apolloVipFlag == 1)) {
          break label357;
        }
        localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438207));
        localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438210), 1);
        paramView.f = 1;
      }
      for (;;)
      {
        label241:
        localActionSheet.c(2131433015);
        localActionSheet.a(new utu(this, paramView, localApolloActionData, localActionSheet));
        localActionSheet.show();
        label357:
        do
        {
          return;
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.d)
          {
            ((VasExtensionHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 128, "userClick");
            break;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_b_of_type_Int)
          {
            ((VasExtensionHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 2, "userClick");
            break;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != ApolloConstant.jdField_c_of_type_Int) {
            break;
          }
          ApolloContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          break;
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_b_of_type_Int) && (localApolloActionData != null) && (localObject != null) && (localApolloActionData.vipLevel < ((ApolloBaseInfo)localObject).apolloVipLevel))
          {
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438212));
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438215), 1);
            paramView.f = 2;
            break label241;
          }
          if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.d) && (localApolloActionData != null) && ((localApolloActionData.limitFree == 0) || (!localApolloDaoManager.a(localApolloActionData.actionId))))
          {
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438217));
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438218), 1);
            paramView.f = 3;
            break label241;
          }
          if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == ApolloConstant.jdField_c_of_type_Int)
          {
            localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438219));
            paramView.f = 4;
            break label241;
          }
        } while ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode == 0) && (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)));
        localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438220), 1);
      }
    }
    a(paramView, 2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView = AIOUtils.a(paramView);
    if (!(paramView instanceof ApolloItemBuilder.Holder)) {}
    ApolloManager localApolloManager;
    do
    {
      do
      {
        return;
        paramView = (ApolloItemBuilder.Holder)paramView;
      } while (paramInt1 != 1);
      if (paramInt2 == 0)
      {
        if (!super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        }
        ApolloManager.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramView.e));
        return;
      }
      if (!ApolloManager.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramView.e))) {
        ApolloManager.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramView.e));
      }
      localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    } while ((localApolloManager != null) && (localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2));
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
  }
  
  public void a(View paramView, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    ApolloItemBuilder.Holder localHolder;
    if ((paramView != null) && ((AIOUtils.a(paramView) instanceof ApolloItemBuilder.Holder)) && (paramMessageForApollo != null))
    {
      if (paramMessageForApollo.mApolloMessage != null) {
        ApolloManager.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramMessageForApollo.mApolloMessage.id));
      }
      localHolder = (ApolloItemBuilder.Holder)AIOUtils.a(paramView);
      if (!super.a(paramMessageForApollo, localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)) {
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
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
      if ((paramView != null) && (localHolder.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView.start();
      }
      return;
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (!(paramViewHolder instanceof ApolloItemBuilder.Holder)) {}
    ApolloItemBuilder.Holder localHolder;
    do
    {
      return;
      localHolder = (ApolloItemBuilder.Holder)paramViewHolder;
    } while ((paramBubbleInfo == null) || (localHolder.jdField_a_of_type_AndroidWidgetTextView == null));
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131494230);
        if (paramViewHolder != null) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if (!paramChatMessage.isSend()) {
          break label112;
        }
      }
      label112:
      for (paramViewHolder = paramView.getColorStateList(2131494229);; paramViewHolder = paramView.getColorStateList(2131494228))
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131494227);
        break;
      }
    }
    if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.jdField_c_of_type_Int == 0)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131494228));
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
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
    } while (((ApolloItemBuilder.Holder)localObject).e != paramBaseChatItemLayout2.e);
    a(paramBaseChatItemLayout1, paramInt1, paramInt2);
  }
  
  public void a(ApolloItemBuilder.Holder paramHolder, int paramInt)
  {
    paramHolder = (MessageForApollo)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (((!paramHolder.hasPlayed) || (paramInt == 2)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      SpriteBridge localSpriteBridge = ((SpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(248)).a();
      if (localSpriteBridge != null) {
        localSpriteBridge.a(paramInt, paramHolder);
      }
    }
  }
  
  public void a(ApolloItemBuilder.Holder paramHolder, Resources paramResources, boolean paramBoolean)
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
        localURLDrawableOptions.mFailedDrawable = paramResources.getDrawable(2130838091);
        localURLDrawableOptions.mLoadingDrawable = paramResources.getDrawable(2130838092);
        if (!paramBoolean) {
          break label204;
        }
        l = System.currentTimeMillis();
        paramResources = new URL("apollo_gif", "", String.valueOf(l + paramHolder.e));
        File localFile = new File(ApolloItemBuilder.ApolloGifDownloader.a(paramHolder.e));
        if (!localFile.exists()) {
          break label210;
        }
        paramResources = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
        paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloItemBuilder", 2, "actionId->" + paramHolder.e + " drawable.getStatus()->" + paramResources.getStatus());
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
      paramResources.setTag(Integer.valueOf(paramHolder.e));
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramResources);
      paramHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this);
      if (paramResources.getStatus() == 0) {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  protected void a(MessageForApollo paramMessageForApollo, ApolloItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject;
    if (ApolloManager.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(paramHolder.e)))
    {
      localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if ((localObject != null) && (((ApolloManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 2)) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      }
    }
    if (paramBoolean)
    {
      if (paramMessageForApollo.actionType == 5) {}
      for (localObject = b(paramMessageForApollo.isSend());; localObject = a(paramMessageForApollo.isSend()))
      {
        if (localObject != null)
        {
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
        }
        ApolloManager.jdField_a_of_type_JavaUtilHashSet.remove(Integer.valueOf(paramHolder.e));
        if (!paramMessageForApollo.hasPlayed) {
          ApolloUtil.a(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        return;
      }
    }
    int i;
    if (paramMessageForApollo.actionType == 5) {
      if (paramMessageForApollo.isSend()) {
        i = 2130837993;
      }
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      return;
      i = 2130837988;
      continue;
      if (paramMessageForApollo.isSend()) {
        i = 2130837999;
      } else {
        i = 2130837983;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((this.jdField_d_of_type_Boolean) && (!ApolloGameUtil.a(localMessageForApollo.msgType))) {
        localQQCustomMenu.a(2131366776, this.jdField_a_of_type_AndroidContentContext.getString(2131438189), 2130838045);
      }
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    return localQQCustomMenu.a();
  }
  
  public void b(View paramView, MessageForApollo paramMessageForApollo)
  {
    int i;
    if (((paramView instanceof BaseChatItemLayout)) && (paramMessageForApollo != null))
    {
      paramView = (ImageView)paramView.findViewById(2131362011);
      if (paramView != null)
      {
        if (paramMessageForApollo.actionType != 5) {
          break label58;
        }
        if (!paramMessageForApollo.isSend()) {
          break label51;
        }
        i = 2130837993;
      }
    }
    for (;;)
    {
      paramView.setImageResource(i);
      return;
      label51:
      i = 2130837988;
      continue;
      label58:
      if (paramMessageForApollo.isSend()) {
        i = 2130837999;
      } else {
        i = 2130837983;
      }
    }
  }
  
  public void e()
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
          this.f = false;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
          str = "apollo_invite_gray_tip" + (String)localObject2 + "_" + (String)localObject1;
          localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        } while (!localSharedPreferences.getBoolean(str, true));
        localObject3 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      } while (localObject3 == null);
      localObject3 = ((ApolloManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject3 == null) || (((ApolloBaseInfo)localObject3).apolloStatus == 1));
    long l = MessageCache.a();
    int i = "对方还没有开通厘米秀，无法看到动作。邀请".indexOf("邀");
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("key_action", 1);
    ((Bundle)localObject3).putString("textColor", "#00a5e0");
    ((Bundle)localObject3).putString("key_action_DATA", "http://cmshow.qq.com/act/beta4/html/my_invite.html?_wv=1025&adTag=aiotips");
    Object localObject1 = new UniteGrayTipParam((String)localObject1, (String)localObject2, "对方还没有开通厘米秀，无法看到动作。邀请", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -5040, 2359297, l);
    ((UniteGrayTipParam)localObject1).a(i, i + 2, (Bundle)localObject3);
    Object localObject2 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
    UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str, false).commit();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "Invitetip_show", 0, 0, new String[] { "" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder
 * JD-Core Version:    0.7.0.1
 */