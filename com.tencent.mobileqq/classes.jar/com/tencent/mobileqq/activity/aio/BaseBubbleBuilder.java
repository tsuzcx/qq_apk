package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable.Factory;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandlerFactory;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutListenerController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.HeadIconHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutHandlerFactory;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListener;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessorImpl;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SystemDragUtils;
import com.tencent.mobileqq.util.SystemDragUtils.DragTouchDelegate;
import com.tencent.mobileqq.utils.MessageProgressController;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;

public abstract class BaseBubbleBuilder
  extends ChatItemBuilder
  implements View.OnClickListener, ChatItemAnimLayout.OnItemAnimEndListener
{
  public static int a;
  public static ColorFilter a;
  public static final Handler a;
  public static boolean a;
  protected float a;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new BaseBubbleBuilder.2(this);
  protected ViewGroup a;
  @Deprecated
  public BaseAdapter a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private IChatLayoutHandlerFactory jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory;
  private IChatLayoutListener jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListener = new BaseBubbleBuilder.1(this);
  protected BaseBubbleBuilderMenuProcessor a;
  public QQAppInterface a;
  public IFaceDecoder a;
  protected HashSet<Long> a;
  long b;
  public boolean b;
  public boolean c = false;
  protected boolean d = false;
  
  static
  {
    jdField_a_of_type_Int = 255;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
      return;
    }
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory = new ChatLayoutHandlerFactory(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramContext, this, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor = new BaseBubbleBuilderMenuProcessorImpl(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    a(ChatLayoutListenerController.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListener);
  }
  
  @NotNull
  private Bundle a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) || ((paramContext instanceof MultiForwardActivity))) {}
    for (boolean bool = false;; bool = true)
    {
      try
      {
        int j = a(paramChatMessage);
        i = j;
      }
      catch (Exception paramChatMessage)
      {
        for (;;)
        {
          QLog.e("ChatItemBuilder", 1, "getBubbleType error : " + paramChatMessage);
        }
      }
      paramViewHolder.jdField_a_of_type_Int = i;
      paramChatMessage = new Bundle();
      paramChatMessage.putBoolean("shouldDownload", bool);
      paramChatMessage.putInt("bubbleType", i);
      return paramChatMessage;
    }
  }
  
  @NotNull
  private Bundle a(CharSequence paramCharSequence)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("inInMiniAIO", this.jdField_b_of_type_Boolean);
    localBundle.putBoolean("inChatHistory", this.c);
    localBundle.putCharSequence("dateTime", paramCharSequence);
    return localBundle;
  }
  
  private void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Bundle localBundle = a(paramChatMessage, paramContext, paramViewHolder);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.b().a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, localBundle);
  }
  
  private void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, CharSequence paramCharSequence)
  {
    paramCharSequence = a(paramCharSequence);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a().a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, paramCharSequence);
    paramBaseChatItemLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  private void a(View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramView != null) && (paramView.getId() == 2131364634))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131374571);
      if ((localObject instanceof Bundle))
      {
        localObject = (Bundle)localObject;
        boolean bool1 = ((Bundle)localObject).getBoolean("haveTimeStamp");
        boolean bool2 = ((Bundle)localObject).getBoolean("haveNickName");
        boolean bool3 = ((Bundle)localObject).getBoolean("havePendant");
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, "restoreLayoutParams params = " + ((Bundle)localObject).toString());
        }
        paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
        paramView.topMargin = ((Bundle)localObject).getInt("textViewTop", 0);
        paramView.bottomMargin = ((Bundle)localObject).getInt("textViewBotttom", 0);
        localLayoutParams.topMargin = ((Bundle)localObject).getInt("headViewTop", 0);
        localLayoutParams.bottomMargin = ((Bundle)localObject).getInt("headViewBottom", 0);
        if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (bool3))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("pendantViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("pendantViewBottom", 0);
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (bool2))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("nickNameViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("nickNameViewBottom", 0);
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (bool1))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("timeStampTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("timeStampBottom", 0);
        }
        paramBaseChatItemLayout.setTag(2131374571, null);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, Exception paramException)
  {
    String str = "";
    paramException = str;
    if (paramContext != null)
    {
      paramException = str;
      if ((paramContext instanceof Activity)) {
        paramException = paramContext.getClass().getName();
      }
    }
    QLog.e("BaseBubbleBuilder", 1, paramException + " baseBubbleBuilderCatchedException " + paramChatMessage.msgtype);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (AppSetting.d)
    {
      paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
      paramChatMessage = Spannable.Factory.getInstance().newSpannable(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
      if (!Linkify.addLinks(paramChatMessage, 15)) {
        break label53;
      }
      paramBaseChatItemLayout.setContentDescription(paramChatMessage);
    }
    for (;;)
    {
      paramBaseChatItemLayout.setFocusable(true);
      return;
      label53:
      paramBaseChatItemLayout.setContentDescription(paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin()), paramString2, null);
      }
      return;
    }
  }
  
  public int a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null)
          {
            int i = ((BaseChatPie)localObject).h();
            return i;
          }
        }
      }
    }
    catch (Exception localException)
    {
      return -1;
    }
    return -1;
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1 + ", msgseq = " + paramChatMessage.msgseq + ", shmsgseq = " + paramChatMessage.shmsgseq);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramView = (BaseChatItemLayout)paramView;
      boolean bool = AppSetting.d;
      if (paramView == null)
      {
        paramView = new BaseChatItemLayout(localContext);
        paramView.setId(2131363508);
        paramView.setFocusableInTouchMode(true);
        localViewHolder = a();
        paramView.setTag(localViewHolder);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
        paramView.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, BaseChatItemLayout.w);
        localViewHolder.jdField_b_of_type_Int = paramInt1;
        localViewHolder.c = paramInt2;
        Object localObject2 = null;
        localObject1 = localObject2;
        if (bool)
        {
          paramView.setContentDescription(null);
          localViewHolder.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
          localObject1 = localObject2;
          if (paramChatMessage.mNeedTimeStamp)
          {
            localObject1 = localObject2;
            if (paramChatMessage.time <= 0L) {}
          }
        }
      }
    }
    catch (Exception paramView)
    {
      label601:
      for (;;)
      {
        try
        {
          BaseBubbleBuilder.ViewHolder localViewHolder;
          Object localObject1 = TimeFormatterUtils.a(localContext, 3, paramChatMessage.time * 1000L);
          localViewHolder.jdField_b_of_type_JavaLangStringBuilder.append(" ").append((CharSequence)localObject1).append(" ");
          localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          if (paramChatMessage.isSend())
          {
            i = 1;
            paramView.setHearIconPosition(i);
            a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, localContext, paramView, localViewHolder, (CharSequence)localObject1);
            if (!b(paramChatMessage, paramView)) {
              continue;
            }
            paramView.setProgressVisable(false);
            paramView.setNetIconVisible(false);
            localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(null);
            paramOnLongClickAndTouchListener = a(paramChatMessage, localViewHolder, localViewHolder.jdField_a_of_type_AndroidViewView, paramView, paramOnLongClickAndTouchListener);
            localViewHolder.jdField_a_of_type_AndroidViewView = paramOnLongClickAndTouchListener;
            a(paramOnLongClickAndTouchListener, paramView);
            a(paramChatMessage, paramView, localViewHolder);
            a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, localContext, paramView, localViewHolder);
            if ((!paramChatMessage.mMsgAnimFlag) || (paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null) || (BaseBubbleBuilderUtil.a(paramChatMessage))) {
              continue;
            }
            paramChatMessage.mMsgAnimFlag = false;
            paramInt2 = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramInt1 = paramInt2;
            if (!paramChatMessage.isSend()) {
              paramInt1 = paramInt2 * -1;
            }
            paramView.a(paramChatMessage, paramInt1, 0.0F, 0.0F, 1.0F, this);
            paramView.a(localContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter);
            paramView.requestLayout();
            return paramView;
            paramView = paramView;
            a(paramChatMessage, localContext, paramView);
            paramView = null;
            continue;
            localViewHolder = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
            if (a(localViewHolder)) {
              break label601;
            }
            QLog.e("BubbleView", 1, "getView checkHolderTypeOk failed holder :" + localViewHolder + "  this:" + this);
            localViewHolder = a();
            paramView.setTag(localViewHolder);
            localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
          }
        }
        catch (Exception localException)
        {
          String str = "";
          continue;
          int i = 0;
          continue;
          a(paramChatMessage, paramView);
          continue;
          paramView.a(paramChatMessage);
        }
      }
    }
  }
  
  public View a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ViewGroup paramViewGroup, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (paramChatMessage == null))
    {
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramViewHolder = null;
    }
    long l2;
    int i;
    do
    {
      for (;;)
      {
        return paramViewHolder;
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          l2 = paramChatMessage.shmsgseq;
          i = MessageUtils.b(paramChatMessage.msgUid);
          if ((!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2, i)) || (paramViewGroup == null) || (paramViewHolder == null) || (paramChatMessage.isMultiMsg))
          {
            paramViewHolder = paramView;
            if (paramView == null) {
              continue;
            }
            paramView.setVisibility(8);
            return paramView;
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return null;
        }
      }
      paramViewHolder = paramView;
    } while (paramView != null);
    try
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563136, null);
      paramView.setOnClickListener(new BaseBubbleBuilder.3(this, l2, i));
      paramViewGroup.addView(paramView, new RelativeLayout.LayoutParams(paramInt1, paramInt2));
      return paramView;
    }
    catch (OutOfMemoryError paramView)
    {
      QLog.e("ChatItemBuilder", 2, "getEssenceView got OOM, e:" + paramView.getMessage());
      System.gc();
      return null;
    }
    catch (InflateException paramView)
    {
      QLog.e("ChatItemBuilder", 2, "getEssenceView got InflateException, e:" + paramView.getMessage());
      System.gc();
    }
    return null;
  }
  
  protected abstract View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return null;
  }
  
  protected abstract BaseBubbleBuilder.ViewHolder a();
  
  protected abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    MessageProgressController.a().a();
    b(ChatLayoutListenerController.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutListener);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    paramContext = BaseBubbleBuilderMenuProcessorImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor);
    if (paramContext != null) {
      paramContext.a(paramInt, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
    }
  }
  
  public void a(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a(paramInt, paramIChatLayoutListener);
  }
  
  protected void a(View paramView) {}
  
  public void a(View paramView, ViewGroup paramViewGroup, Integer paramInteger, ChatMessage paramChatMessage, int paramInt, Boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if ((paramViewGroup == null) || (paramChatMessage == null))
    {
      paramView.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null)) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString; !TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, (String)localObject); localObject = "")
    {
      paramView.setVisibility(8);
      return;
    }
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView.setVisibility(8);
      return;
    }
    a((RelativeLayout.LayoutParams)localObject);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364634);
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    if (paramInteger != null)
    {
      View localView = paramViewGroup.findViewById(paramInteger.intValue());
      if ((localView == null) || (localView.getVisibility() != 0)) {}
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        a(paramInteger, paramChatMessage, paramBoolean, (RelativeLayout.LayoutParams)localObject, paramViewGroup);
      }
      for (;;)
      {
        paramView.setVisibility(0);
        return;
        a(paramView, (RelativeLayout.LayoutParams)localObject);
      }
    }
  }
  
  protected void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.addRule(5, 2131364634);
    paramLayoutParams.addRule(7, 0);
    paramLayoutParams.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramLayoutParams.rightMargin = 0;
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  public void a(View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (SystemDragUtils.a(false))
    {
      SystemDragUtils.DragTouchDelegate localDragTouchDelegate = new SystemDragUtils.DragTouchDelegate();
      SystemDragUtils.a(this.jdField_a_of_type_AndroidContentContext, localDragTouchDelegate, paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(localDragTouchDelegate);
      paramView.setOnLongClickListener(localDragTouchDelegate);
      return;
    }
    paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.h;
    int i = j;
    if (StructMsgItemLayout12.a(paramChatMessage)) {
      i = j - AIOUtils.a(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, i, BaseChatItemLayout.j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.j, i, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    a(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) || (paramBubbleInfo == null)) {
      return;
    }
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject3 = null;
    BubbleConfig localBubbleConfig = null;
    Pair localPair = null;
    BubbleManager localBubbleManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    Object localObject2;
    label64:
    Object localObject1;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramChatMessage.msg))
    {
      localObject2 = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramChatMessage.msg);
      if ((localBubbleManager == null) || (android.text.TextUtils.isEmpty((CharSequence)localObject2))) {
        break label888;
      }
      localObject1 = localBubbleManager.a(paramBubbleInfo.jdField_a_of_type_Int, false);
      if ((localObject1 == null) || (((BubbleConfig)localObject1).b == null) || (!((BubbleConfig)localObject1).a((String)localObject2))) {
        break label888;
      }
    }
    label385:
    label858:
    label864:
    label870:
    label877:
    label888:
    for (int i = 1;; i = 0)
    {
      localObject1 = localBubbleConfig;
      int j = k;
      Object localObject4;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject4 = paramBubbleInfo.a((String)localObject2);
        localObject1 = localBubbleConfig;
        localObject3 = localObject4;
        j = k;
        if (localObject4 != null)
        {
          localObject1 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          if ((localObject1 == null) || (((Pair)localObject1).first == null)) {
            break label877;
          }
          j = 1;
          localObject3 = localObject4;
        }
      }
      for (;;)
      {
        k = m;
        if ((paramChatMessage instanceof MessageForText))
        {
          localPair = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
          if ((localPair == null) || (localPair.first == null)) {
            break label870;
          }
        }
        for (k = 1;; k = m)
        {
          m = n;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
          {
            m = n;
            if ((paramChatMessage instanceof MessageForText))
            {
              m = n;
              if (VersionUtils.e())
              {
                localObject2 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
                m = n;
                if (localObject2 != null)
                {
                  m = n;
                  if (((Pair)localObject2).first != null)
                  {
                    m = n;
                    if (paramView.getWidth() > ((BubbleInfo.CommonAttrs)((Pair)localObject2).first).a.j) {
                      m = 1;
                    }
                  }
                }
              }
            }
          }
          if ((localBubbleManager != null) && ((paramChatMessage instanceof MessageForText)))
          {
            localBubbleConfig = localBubbleManager.a(paramBubbleInfo.jdField_a_of_type_Int, false);
            if ((localBubbleConfig != null) && (localBubbleConfig.f != null) && (localBubbleConfig.f.k != 0) && (VersionUtils.e())) {
              if (paramChatMessage.isSend())
              {
                localObject2 = paramChatMessage.selfuin;
                localObject4 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
                if (localObject4 == null) {
                  break label864;
                }
                localObject2 = ((FriendsManager)localObject4).a((String)localObject2);
                if ((localObject2 == null) || ((localBubbleConfig.f.k != -1) && (((ExtensionInfo)localObject2).pendantId != localBubbleConfig.f.k))) {
                  break label864;
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (i != 0)
            {
              long l = BubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              if (l != -1L) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
              }
            }
            if ((j != 0) || (m != 0) || (n != 0) || (k != 0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(0);
            }
            if (j != 0)
            {
              a("keyword_trigger", paramBubbleInfo.jdField_a_of_type_Int, localObject3);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject1 });
            }
            if (k != 0) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(6), Long.valueOf(paramChatMessage.uniseq), localPair });
            }
            if ((m != 0) || (n != 0)) {
              if (m == 0) {
                break label858;
              }
            }
            for (i = 3;; i = 5)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramBubbleInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
              if (!paramBubbleInfo.a(paramView.getHeight())) {
                break;
              }
              paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
              if ((paramView == null) || (paramView.first == null)) {
                break;
              }
              a("wordnum_trigger", paramBubbleInfo.jdField_a_of_type_Int, null);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
              return;
              localObject2 = paramChatMessage.msg;
              break label64;
              if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
              {
                localObject2 = paramChatMessage.frienduin;
                break label385;
              }
              localObject2 = paramChatMessage.senderuin;
              break label385;
            }
          }
        }
        localObject3 = localObject4;
        j = k;
      }
    }
  }
  
  protected void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      return;
    }
    paramLayoutParams.addRule(5, 0);
    paramLayoutParams.addRule(7, 0);
    paramLayoutParams.addRule(0, 0);
    paramLayoutParams.addRule(1, 0);
    paramLayoutParams.rightMargin = 0;
    paramLayoutParams.leftMargin = 0;
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  public void a(IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    ChatLayoutHandler localChatLayoutHandler = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a(0);
    if (localChatLayoutHandler != null) {
      ((HeadIconHandler)localChatLayoutHandler).a(paramIFaceDecoder);
    }
  }
  
  public void a(ChatMessage paramChatMessage) {}
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2) {}
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage);
    paramBaseChatItemLayout.setProgressVisable(bool);
    if (!bool) {
      b(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {}
    do
    {
      return;
      paramBubbleInfo = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    } while ((paramBubbleInfo == null) || (paramBubbleInfo.first == null));
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramBubbleInfo });
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, FileTransferManager.Callback paramCallback)
  {
    OrderMediaMsgManager localOrderMediaMsgManager = (OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
    if ((paramMessageRecord.extraflag != 32772) || (!localOrderMediaMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.uniseq, paramView, paramCallback)))
    {
      paramMessageRecord = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramCallback);
      }
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    if ((paramBundle != null) && ((paramInt == 2131371954) || (paramInt == 2131365636))) {
      paramBundle.putBoolean("isInvokeMenuShow", this.d);
    }
    IBaseBubbleBuilderMenuAddProcessor localIBaseBubbleBuilderMenuAddProcessor = BaseBubbleBuilderMenuProcessorImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor);
    if (localIBaseBubbleBuilderMenuAddProcessor != null) {
      localIBaseBubbleBuilderMenuAddProcessor.a(paramQQCustomMenu, paramContext, paramInt, paramChatMessage, paramBundle);
    }
    if ((paramBundle != null) && ((paramInt == 2131371954) || (paramInt == 2131365636))) {
      this.d = paramBundle.getBoolean("isInvokeMenuShow", false);
    }
  }
  
  protected void a(Integer paramInteger, MessageRecord paramMessageRecord, Boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, ViewGroup paramViewGroup)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      paramLayoutParams.addRule(1, paramInteger.intValue());
      paramLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      return;
    }
    if (paramMessageRecord.isSend())
    {
      paramLayoutParams.addRule(0, paramInteger.intValue());
      paramLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      return;
    }
    paramLayoutParams.addRule(1, paramInteger.intValue());
    paramLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.jdField_a_of_type_Boolean;
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void b(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.b(paramInt, paramIChatLayoutListener);
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a(0, paramView);
  }
  
  protected void b(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  protected void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setNetIconVisible(paramChatMessage.isSentByXG());
  }
  
  protected boolean b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramBaseChatItemLayout))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return true;
    }
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(0);
    }
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    if (a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) || (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
      {
        AIOUtils.o = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a(3, paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a(4, paramView);
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131364641: 
          a(paramView);
          break;
        case 2131364643: 
          b(paramView);
          break;
        case 2131364651: 
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            b(paramView);
          }
          break;
        case 2131364656: 
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */