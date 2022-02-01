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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutViewWrapper;
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
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SystemDragUtils;
import com.tencent.mobileqq.util.SystemDragUtils.DragTouchDelegate;
import com.tencent.mobileqq.utils.MessageProgressController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import java.util.HashSet;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public abstract class BaseBubbleBuilder
  extends ChatItemBuilder
  implements View.OnClickListener, ChatItemAnimLayout.OnItemAnimEndListener
{
  public static ColorFilter a;
  protected static final Handler a;
  public static boolean a = false;
  public static int b = 255;
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
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    boolean bool;
    if ((!"MNC".equals(Build.VERSION.CODENAME)) && (Build.VERSION.SDK_INT < 23)) {
      bool = false;
    } else {
      bool = true;
    }
    jdField_a_of_type_Boolean = bool;
    jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
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
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n;
    int i = 0;
    if ((!bool) && (!(paramContext instanceof MultiForwardActivity))) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      int j = a(paramChatMessage);
      i = j;
    }
    catch (Exception paramChatMessage)
    {
      paramContext = new StringBuilder();
      paramContext.append("getBubbleType error : ");
      paramContext.append(paramChatMessage);
      QLog.e("ChatItemBuilder", 1, paramContext.toString());
    }
    paramViewHolder.jdField_a_of_type_Int = i;
    paramChatMessage = new Bundle();
    paramChatMessage.putBoolean("shouldDownload", bool);
    paramChatMessage.putInt("bubbleType", i);
    return paramChatMessage;
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
    paramViewGroup = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
    if (paramViewGroup != null) {
      ((IHeadIconProcessor)paramViewGroup.a()).a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  private void a(View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramView != null) && (paramView.getId() == 2131364521))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131374109);
      if ((localObject instanceof Bundle))
      {
        localObject = (Bundle)localObject;
        boolean bool1 = ((Bundle)localObject).getBoolean("haveTimeStamp");
        boolean bool2 = ((Bundle)localObject).getBoolean("haveNickName");
        boolean bool3 = ((Bundle)localObject).getBoolean("havePendant");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("restoreLayoutParams params = ");
          localStringBuilder.append(((Bundle)localObject).toString());
          QLog.i("ChatItemBuilder", 2, localStringBuilder.toString());
        }
        paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        paramView.topMargin = ((Bundle)localObject).getInt("textViewTop", 0);
        paramView.bottomMargin = ((Bundle)localObject).getInt("textViewBotttom", 0);
        paramView = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
        if (paramView != null)
        {
          paramView = paramView.a();
          if (paramView != null)
          {
            paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
            paramView.topMargin = ((Bundle)localObject).getInt("headViewTop", 0);
            paramView.bottomMargin = ((Bundle)localObject).getInt("headViewBottom", 0);
          }
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (bool3))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("pendantViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("pendantViewBottom", 0);
        }
        paramView = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
        if (paramView != null)
        {
          paramView = paramView.a();
          if ((paramView != null) && (paramView.getViewVisibility() == 0) && (bool2))
          {
            paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
            paramView.topMargin = ((Bundle)localObject).getInt("nickNameViewTop", 0);
            paramView.bottomMargin = ((Bundle)localObject).getInt("nickNameViewBottom", 0);
          }
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (bool1))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("timeStampTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("timeStampBottom", 0);
        }
        paramBaseChatItemLayout.setTag(2131374109, null);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, Exception paramException)
  {
    if ((paramContext != null) && ((paramContext instanceof Activity))) {
      paramContext = paramContext.getClass().getName();
    } else {
      paramContext = "";
    }
    paramException = new StringBuilder();
    paramException.append(paramContext);
    paramException.append(" baseBubbleBuilderCatchedException ");
    paramException.append(paramChatMessage.msgtype);
    QLog.e("BaseBubbleBuilder", 1, paramException.toString());
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (AppSetting.d)
    {
      paramViewHolder.b.append(a(paramChatMessage));
      paramChatMessage = Spannable.Factory.getInstance().newSpannable(paramViewHolder.b.toString());
      if (Linkify.addLinks(paramChatMessage, 15)) {
        paramBaseChatItemLayout.setContentDescription(paramChatMessage);
      } else {
        paramBaseChatItemLayout.setContentDescription(paramViewHolder.b.toString());
      }
      paramBaseChatItemLayout.setFocusable(true);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject instanceof BaseActivity)) {
      localObject = (QQAppInterface)((BaseActivity)localObject).getAppRuntime();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a((AppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin()), paramString2, null);
    }
  }
  
  public int a()
  {
    int j = -1;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        Object localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        i = j;
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          i = j;
          if (localObject != null) {
            i = ((BaseChatPie)localObject).d();
          }
        }
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public View a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ViewGroup paramViewGroup, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localSessionInfo != null) && (localSessionInfo.jdField_a_of_type_Int == 1) && (paramChatMessage != null)) {
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        long l2 = paramChatMessage.shmsgseq;
        int i = MessageUtils.b(paramChatMessage.msgUid);
        if ((TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2, i)) && (paramViewGroup != null) && (paramViewHolder != null) && (!paramChatMessage.isMultiMsg))
        {
          if (paramView == null) {
            try
            {
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562959, null);
              paramView.setOnClickListener(new BaseBubbleBuilder.3(this, l2, i));
              paramViewGroup.addView(paramView, new RelativeLayout.LayoutParams(paramInt1, paramInt2));
              return paramView;
            }
            catch (InflateException paramView)
            {
              paramViewHolder = new StringBuilder();
              paramViewHolder.append("getEssenceView got InflateException, e:");
              paramViewHolder.append(paramView.getMessage());
              QLog.e("ChatItemBuilder", 2, paramViewHolder.toString());
              System.gc();
              return null;
            }
            catch (OutOfMemoryError paramView)
            {
              paramViewHolder = new StringBuilder();
              paramViewHolder.append("getEssenceView got OOM, e:");
              paramViewHolder.append(paramView.getMessage());
              QLog.e("ChatItemBuilder", 2, paramViewHolder.toString());
              System.gc();
              return null;
            }
          }
          return paramView;
        }
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        return paramView;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return null;
      }
    }
    if (paramView != null) {
      paramView.setVisibility(8);
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
    if ((paramViewGroup != null) && (paramChatMessage != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if ((localObject != null) && (((SessionInfo)localObject).jdField_a_of_type_JavaLangString != null)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } else {
        localObject = "";
      }
      if (!TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, (String)localObject))
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
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364521);
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      if (paramInteger != null)
      {
        View localView = paramViewGroup.findViewById(paramInteger.intValue());
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          paramInt = 1;
          break label153;
        }
      }
      paramInt = 0;
      label153:
      if (paramInt != 0) {
        a(paramInteger, paramChatMessage, paramBoolean, (RelativeLayout.LayoutParams)localObject, paramViewGroup);
      } else {
        a(paramView, (RelativeLayout.LayoutParams)localObject);
      }
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  protected void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.addRule(5, 2131364521);
    paramLayoutParams.addRule(7, 0);
    paramLayoutParams.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383) + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
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
      i = j - AIOUtils.b(10.0F, paramView.getResources());
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null)
    {
      if (paramBubbleInfo == null) {
        return;
      }
      Object localObject5 = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      Object localObject3;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramChatMessage.msg)) {
        localObject3 = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramChatMessage.msg);
      } else {
        localObject3 = paramChatMessage.msg;
      }
      if ((localObject5 != null) && (!android.text.TextUtils.isEmpty((CharSequence)localObject3)))
      {
        localObject1 = ((BubbleManager)localObject5).a(paramBubbleInfo.jdField_a_of_type_Int, false);
        if ((localObject1 != null) && (((BubbleConfig)localObject1).b != null) && (((BubbleConfig)localObject1).a((String)localObject3)))
        {
          k = 1;
          break label112;
        }
      }
      int k = 0;
      label112:
      boolean bool = paramChatMessage instanceof MessageForText;
      Object localObject2;
      if (bool)
      {
        localObject4 = paramBubbleInfo.a((String)localObject3);
        localObject2 = localObject4;
        if (localObject4 != null)
        {
          localObject1 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          if ((localObject1 != null) && (((Pair)localObject1).first != null))
          {
            j = 1;
            break label189;
          }
          j = 0;
          break label189;
        }
      }
      else
      {
        localObject2 = null;
      }
      int j = 0;
      Object localObject1 = null;
      Object localObject4 = localObject2;
      label189:
      int i;
      if (bool)
      {
        localObject2 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
        if ((localObject2 != null) && (((Pair)localObject2).first != null)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else
      {
        i = 0;
        localObject2 = null;
      }
      if ((!android.text.TextUtils.isEmpty((CharSequence)localObject3)) && (bool) && (VersionUtils.e()))
      {
        localObject3 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
        if ((localObject3 != null) && (((Pair)localObject3).first != null) && (paramView.getWidth() > ((BubbleInfo.CommonAttrs)((Pair)localObject3).first).a.j))
        {
          m = 1;
          break label310;
        }
      }
      int m = 0;
      label310:
      if ((localObject5 != null) && (bool))
      {
        localObject5 = ((BubbleManager)localObject5).a(paramBubbleInfo.jdField_a_of_type_Int, false);
        if ((localObject5 != null) && (((BubbleConfig)localObject5).f != null) && (((BubbleConfig)localObject5).f.k != 0) && (VersionUtils.e()))
        {
          if (paramChatMessage.isSend()) {
            localObject3 = paramChatMessage.selfuin;
          } else if ((paramChatMessage.istroop != 1000) && (paramChatMessage.istroop != 1020) && (paramChatMessage.istroop != 1004)) {
            localObject3 = paramChatMessage.senderuin;
          } else {
            localObject3 = paramChatMessage.frienduin;
          }
          FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localFriendsManager != null)
          {
            localObject3 = localFriendsManager.a((String)localObject3);
            if (localObject3 != null)
            {
              if (((BubbleConfig)localObject5).f.k != -1) {
                if (((ExtensionInfo)localObject3).pendantId != ((BubbleConfig)localObject5).f.k) {
                  break label499;
                }
              }
              n = 1;
              break label502;
            }
          }
        }
      }
      label499:
      int n = 0;
      label502:
      if (k != 0)
      {
        long l = BubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        if (l != -1L) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
        }
      }
      if ((j == 0) && (m == 0) && (n == 0) && (i == 0)) {
        break label613;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(0);
      label613:
      if (j != 0)
      {
        a("keyword_trigger", paramBubbleInfo.jdField_a_of_type_Int, (String)localObject4);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject1 });
      }
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(6), Long.valueOf(paramChatMessage.uniseq), localObject2 });
      }
      if ((m != 0) || (n != 0))
      {
        if (m != 0) {
          i = 3;
        } else {
          i = 5;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramBubbleInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
      }
      if (paramBubbleInfo.a(paramView.getHeight()))
      {
        paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
        if ((paramView != null) && (paramView.first != null))
        {
          a("wordnum_trigger", paramBubbleInfo.jdField_a_of_type_Int, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
        }
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {
      return;
    }
    paramBubbleInfo = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if ((paramBubbleInfo != null) && (paramBubbleInfo.first != null))
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramBubbleInfo });
    }
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, Callback paramCallback)
  {
    if ((paramMessageRecord.extraflag != 32772) || (!((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.uniseq, paramView, paramCallback)))
    {
      paramMessageRecord = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramCallback);
      }
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    if ((paramBundle != null) && ((paramInt == 2131371562) || (paramInt == 2131365480))) {
      paramBundle.putBoolean("isInvokeMenuShow", this.d);
    }
    IBaseBubbleBuilderMenuAddProcessor localIBaseBubbleBuilderMenuAddProcessor = BaseBubbleBuilderMenuProcessorImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistMenuBaseBubbleBuilderMenuProcessor);
    if (localIBaseBubbleBuilderMenuAddProcessor != null) {
      localIBaseBubbleBuilderMenuAddProcessor.a(paramQQCustomMenu, paramContext, paramInt, paramChatMessage, paramBundle);
    }
    if ((paramBundle != null) && ((paramInt == 2131371562) || (paramInt == 2131365480))) {
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
    AIOAnimationConatiner localAIOAnimationConatiner = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    if (localAIOAnimationConatiner != null) {
      localAIOAnimationConatiner.b(0);
    }
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    if ((!a()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
    {
      AIOUtils.o = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a(3, paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistChatlayouthandlerIChatLayoutHandlerFactory.a(4, paramView);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131364538: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          b(paramView);
        }
        break;
      case 2131364543: 
        ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), null);
        break;
      case 2131364530: 
        b(paramView);
        break;
      }
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */