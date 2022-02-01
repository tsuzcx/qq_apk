package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.OnlineStatusChatLayoutHandler;
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
import com.tencent.mobileqq.utils.QQTheme;
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
  public static int b = 255;
  protected static final Handler h = new Handler(Looper.getMainLooper());
  public static boolean m;
  public static ColorFilter n = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
  private AIOAnimationConatiner a;
  @Deprecated
  public BaseAdapter c;
  public QQAppInterface d;
  public Context e;
  public SessionInfo f;
  public IFaceDecoder g;
  long i = 0L;
  long j = 0L;
  protected float k;
  protected HashSet<Long> l = new HashSet();
  public boolean o = false;
  public boolean p = false;
  protected ViewGroup q;
  protected BaseBubbleBuilderMenuProcessor r;
  View.OnLongClickListener s = new BaseBubbleBuilder.2(this);
  protected boolean t = false;
  private Runnable w = null;
  private IChatLayoutHandlerFactory x;
  private IChatLayoutListener y = new BaseBubbleBuilder.1(this);
  
  static
  {
    boolean bool;
    if ((!"MNC".equals(Build.VERSION.CODENAME)) && (Build.VERSION.SDK_INT < 23)) {
      bool = false;
    } else {
      bool = true;
    }
    m = bool;
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.d = paramQQAppInterface;
    this.c = paramBaseAdapter;
    this.e = paramContext;
    this.f = paramSessionInfo;
    this.a = paramAIOAnimationConatiner;
    this.k = paramContext.getResources().getDisplayMetrics().density;
    this.x = new ChatLayoutHandlerFactory(paramQQAppInterface, this.f, paramContext, this, this.s);
    this.r = new BaseBubbleBuilderMenuProcessorImpl(paramQQAppInterface, this.f);
    a(ChatLayoutListenerController.c, this.y);
    ((OnlineStatusChatLayoutHandler)this.x.a(2)).a();
  }
  
  @NotNull
  private Bundle a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool = this.f.G;
    int i1 = 0;
    if ((!bool) && (!(paramContext instanceof MultiForwardActivity))) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      int i2 = c(paramChatMessage);
      i1 = i2;
    }
    catch (Exception paramChatMessage)
    {
      paramContext = new StringBuilder();
      paramContext.append("getBubbleType error : ");
      paramContext.append(paramChatMessage);
      QLog.e("ChatItemBuilder", 1, paramContext.toString());
    }
    paramViewHolder.k = i1;
    paramChatMessage = new Bundle();
    paramChatMessage.putBoolean("shouldDownload", bool);
    paramChatMessage.putInt("bubbleType", i1);
    return paramChatMessage;
  }
  
  @NotNull
  private Bundle a(CharSequence paramCharSequence)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("inInMiniAIO", this.o);
    localBundle.putBoolean("inChatHistory", this.p);
    localBundle.putCharSequence("dateTime", paramCharSequence);
    return localBundle;
  }
  
  private void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Bundle localBundle = a(paramChatMessage, paramContext, paramViewHolder);
    this.x.b().a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, localBundle);
  }
  
  private void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, CharSequence paramCharSequence)
  {
    paramCharSequence = a(paramCharSequence);
    this.x.a().a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramViewHolder, paramCharSequence);
    paramViewGroup = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
    if (paramViewGroup != null) {
      ((IHeadIconProcessor)paramViewGroup.a()).a(this, this.d, paramChatMessage);
    }
  }
  
  private void a(View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramView != null) && (paramView.getId() == 2131430578))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131442204);
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
          paramView = paramView.c();
          if (paramView != null)
          {
            paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
            paramView.topMargin = ((Bundle)localObject).getInt("headViewTop", 0);
            paramView.bottomMargin = ((Bundle)localObject).getInt("headViewBottom", 0);
          }
        }
        if ((paramBaseChatItemLayout.ae != null) && (paramBaseChatItemLayout.ae.getVisibility() == 0) && (bool3))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.ae.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("pendantViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("pendantViewBottom", 0);
        }
        paramView = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
        if (paramView != null)
        {
          paramView = paramView.c();
          if ((paramView != null) && (paramView.getViewVisibility() == 0) && (bool2))
          {
            paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
            paramView.topMargin = ((Bundle)localObject).getInt("nickNameViewTop", 0);
            paramView.bottomMargin = ((Bundle)localObject).getInt("nickNameViewBottom", 0);
          }
        }
        if ((paramBaseChatItemLayout.aa != null) && (paramBaseChatItemLayout.aa.getVisibility() == 0) && (bool1))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.aa.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("timeStampTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("timeStampBottom", 0);
        }
        paramBaseChatItemLayout.setTag(2131442204, null);
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
    if (AppSetting.e)
    {
      paramViewHolder.r.append(d(paramChatMessage));
      paramChatMessage = Spannable.Factory.getInstance().newSpannable(paramViewHolder.r.toString());
      if (Linkify.addLinks(paramChatMessage, 15)) {
        paramBaseChatItemLayout.setContentDescription(paramChatMessage);
      } else {
        paramBaseChatItemLayout.setContentDescription(paramViewHolder.r.toString());
      }
      paramBaseChatItemLayout.setFocusable(true);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = this.e;
    if ((localObject instanceof BaseActivity)) {
      localObject = (QQAppInterface)((BaseActivity)localObject).getAppRuntime();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a((AppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin()), paramString2, null);
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public View a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ViewGroup paramViewGroup, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    SessionInfo localSessionInfo = this.f;
    if ((localSessionInfo != null) && (localSessionInfo.a == 1) && (paramChatMessage != null)) {
      try
      {
        long l1 = Long.parseLong(this.f.b);
        long l2 = paramChatMessage.shmsgseq;
        int i1 = MessageUtils.b(paramChatMessage.msgUid);
        if ((TroopEssenceUtil.a(this.d, l1, l2, i1)) && (paramViewGroup != null) && (paramViewHolder != null) && (!paramChatMessage.isMultiMsg))
        {
          if (paramView == null) {
            try
            {
              paramView = LayoutInflater.from(this.e).inflate(2131629567, null);
              paramView.setOnClickListener(new BaseBubbleBuilder.3(this, l2, i1));
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
  
  protected abstract BaseBubbleBuilder.ViewHolder a();
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    paramContext = BaseBubbleBuilderMenuProcessorImpl.a(this.r);
    if (paramContext != null) {
      paramContext.a(paramInt, this.e, paramChatMessage);
    }
  }
  
  public void a(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.x.a(paramInt, paramIChatLayoutListener);
  }
  
  protected void a(Drawable paramDrawable, ColorFilter paramColorFilter)
  {
    if ((!QQTheme.isNowSimpleUI()) && (paramDrawable != null))
    {
      paramDrawable.setColorFilter(paramColorFilter);
      paramDrawable.invalidateSelf();
    }
  }
  
  public void a(View paramView, ViewGroup paramViewGroup, Integer paramInteger, ChatMessage paramChatMessage, int paramInt, Boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if ((paramViewGroup != null) && (paramChatMessage != null))
    {
      Object localObject = this.f;
      if ((localObject != null) && (((SessionInfo)localObject).b != null)) {
        localObject = this.f.b;
      } else {
        localObject = "";
      }
      if (!TroopEssenceUtil.a(this.d, paramChatMessage, (String)localObject))
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
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131430578);
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
    paramLayoutParams.addRule(5, 2131430578);
    paramLayoutParams.addRule(7, 0);
    paramLayoutParams.leftMargin = (this.e.getResources().getDimensionPixelSize(2131296615) + DisplayUtil.a(this.e, 10.0F));
    paramLayoutParams.rightMargin = 0;
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  public void a(View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (SystemDragUtils.a(false))
    {
      SystemDragUtils.DragTouchDelegate localDragTouchDelegate = new SystemDragUtils.DragTouchDelegate();
      SystemDragUtils.a(this.e, localDragTouchDelegate, paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(localDragTouchDelegate);
      paramView.setOnLongClickListener(localDragTouchDelegate);
      return;
    }
    paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i2 = BaseChatItemLayout.k;
    int i1 = i2;
    if (StructMsgItemLayout12.a(paramChatMessage)) {
      i1 = i2 - AIOUtils.b(10.0F, paramView.getResources());
    }
    i2 = BaseChatItemLayout.getBubblePaddingAlignError();
    int i3 = BaseChatItemLayout.getBubblePaddingAlignHead();
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(i2, i1, i3, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(i3, i1, i2, BaseChatItemLayout.l);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    c(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (this.a != null)
    {
      if (paramBubbleInfo == null) {
        return;
      }
      Object localObject5 = (BubbleManager)this.d.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      Object localObject3;
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramChatMessage.msg)) {
        localObject3 = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramChatMessage.msg);
      } else {
        localObject3 = paramChatMessage.msg;
      }
      if ((localObject5 != null) && (!android.text.TextUtils.isEmpty((CharSequence)localObject3)))
      {
        localObject1 = ((BubbleManager)localObject5).a(paramBubbleInfo.a, false);
        if ((localObject1 != null) && (((BubbleConfig)localObject1).y != null) && (((BubbleConfig)localObject1).a((String)localObject3)))
        {
          i3 = 1;
          break label112;
        }
      }
      int i3 = 0;
      label112:
      boolean bool = paramChatMessage instanceof MessageForText;
      Object localObject2;
      if (bool)
      {
        localObject4 = paramBubbleInfo.a((String)localObject3);
        localObject2 = localObject4;
        if (localObject4 != null)
        {
          localObject1 = paramBubbleInfo.a(this.d, 1);
          if ((localObject1 != null) && (((Pair)localObject1).first != null))
          {
            i2 = 1;
            break label189;
          }
          i2 = 0;
          break label189;
        }
      }
      else
      {
        localObject2 = null;
      }
      int i2 = 0;
      Object localObject1 = null;
      Object localObject4 = localObject2;
      label189:
      int i1;
      if (bool)
      {
        localObject2 = paramBubbleInfo.a(this.d, 6);
        if ((localObject2 != null) && (((Pair)localObject2).first != null)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
      else
      {
        i1 = 0;
        localObject2 = null;
      }
      if ((!android.text.TextUtils.isEmpty((CharSequence)localObject3)) && (bool) && (VersionUtils.e()))
      {
        localObject3 = paramBubbleInfo.a(this.d, 3);
        if ((localObject3 != null) && (((Pair)localObject3).first != null) && (paramView.getWidth() > ((BubbleInfo.CommonAttrs)((Pair)localObject3).first).l.u))
        {
          i4 = 1;
          break label310;
        }
      }
      int i4 = 0;
      label310:
      if ((localObject5 != null) && (bool))
      {
        localObject5 = ((BubbleManager)localObject5).a(paramBubbleInfo.a, false);
        if ((localObject5 != null) && (((BubbleConfig)localObject5).p != null) && (((BubbleConfig)localObject5).p.x != 0) && (VersionUtils.e()))
        {
          if (paramChatMessage.isSend()) {
            localObject3 = paramChatMessage.selfuin;
          } else if ((paramChatMessage.istroop != 1000) && (paramChatMessage.istroop != 1020) && (paramChatMessage.istroop != 1004)) {
            localObject3 = paramChatMessage.senderuin;
          } else {
            localObject3 = paramChatMessage.frienduin;
          }
          FriendsManager localFriendsManager = (FriendsManager)this.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localFriendsManager != null)
          {
            localObject3 = localFriendsManager.x((String)localObject3);
            if (localObject3 != null)
            {
              if (((BubbleConfig)localObject5).p.x != -1) {
                if (((ExtensionInfo)localObject3).pendantId != ((BubbleConfig)localObject5).p.x) {
                  break label499;
                }
              }
              i5 = 1;
              break label502;
            }
          }
        }
      }
      label499:
      int i5 = 0;
      label502:
      if (i3 != 0)
      {
        long l1 = BubbleInterActiveAnim.a(this.d, paramChatMessage, this.f, this.a);
        if (l1 != -1L) {
          this.a.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l1) });
        }
      }
      if ((i2 == 0) && (i4 == 0) && (i5 == 0) && (i1 == 0)) {
        break label613;
      }
      this.a.b(0);
      label613:
      if (i2 != 0)
      {
        a("keyword_trigger", paramBubbleInfo.a, (String)localObject4);
        this.a.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject1 });
      }
      if (i1 != 0) {
        this.a.a(0, 100, new Object[] { Integer.valueOf(6), Long.valueOf(paramChatMessage.uniseq), localObject2 });
      }
      if ((i4 != 0) || (i5 != 0))
      {
        if (i4 != 0) {
          i1 = 3;
        } else {
          i1 = 5;
        }
        this.a.a(0, 100, new Object[] { Integer.valueOf(i1), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramBubbleInfo.a), this.d });
      }
      if (paramBubbleInfo.a(paramView.getHeight()))
      {
        paramView = paramBubbleInfo.a(this.d, 2);
        if ((paramView != null) && (paramView.first != null))
        {
          a("wordnum_trigger", paramBubbleInfo.a, null);
          this.a.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
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
    this.g = paramIFaceDecoder;
    ChatLayoutHandler localChatLayoutHandler = this.x.a(0);
    if (localChatLayoutHandler != null) {
      ((HeadIconHandler)localChatLayoutHandler).a(paramIFaceDecoder);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2) {}
  
  protected void a(ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if (this.a == null) {
      return;
    }
    paramBubbleInfo = paramBubbleInfo.a(this.d, 0);
    if ((paramBubbleInfo != null) && (paramBubbleInfo.first != null))
    {
      e();
      this.a.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramBubbleInfo });
    }
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, Callback paramCallback)
  {
    if ((paramMessageRecord.extraflag != 32772) || (!((IOrderMediaMsgService)this.d.getRuntimeService(IOrderMediaMsgService.class)).addCallback(this.f.b, paramMessageRecord.uniseq, paramView, paramCallback)))
    {
      paramMessageRecord = FileTransferManager.a(this.d);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramCallback);
      }
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    if ((paramBundle != null) && ((paramInt == 2131438943) || (paramInt == 2131431695))) {
      paramBundle.putBoolean("isInvokeMenuShow", this.t);
    }
    IBaseBubbleBuilderMenuAddProcessor localIBaseBubbleBuilderMenuAddProcessor = BaseBubbleBuilderMenuProcessorImpl.b(this.r);
    if (localIBaseBubbleBuilderMenuAddProcessor != null) {
      localIBaseBubbleBuilderMenuAddProcessor.a(paramQQCustomMenu, paramContext, paramInt, paramChatMessage, paramBundle);
    }
    if ((paramBundle != null) && ((paramInt == 2131438943) || (paramInt == 2131431695))) {
      this.t = paramBundle.getBoolean("isInvokeMenuShow", false);
    }
  }
  
  protected void a(Integer paramInteger, MessageRecord paramMessageRecord, Boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, ViewGroup paramViewGroup)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      paramLayoutParams.addRule(1, paramInteger.intValue());
      paramLayoutParams.leftMargin = DisplayUtil.a(this.e, 5.0F);
      return;
    }
    if (paramMessageRecord.isSend())
    {
      paramLayoutParams.addRule(0, paramInteger.intValue());
      paramLayoutParams.rightMargin = DisplayUtil.a(this.e, 5.0F);
      return;
    }
    paramLayoutParams.addRule(1, paramInteger.intValue());
    paramLayoutParams.leftMargin = DisplayUtil.a(this.e, 5.0F);
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
    h.removeCallbacksAndMessages(null);
    MessageProgressController.a().b();
    b(ChatLayoutListenerController.c, this.y);
    ((OnlineStatusChatLayoutHandler)this.x.a(2)).b();
  }
  
  public void b(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    this.x.b(paramInt, paramIChatLayoutListener);
  }
  
  protected void b(View paramView) {}
  
  protected void b(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
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
  
  public abstract int c(ChatMessage paramChatMessage);
  
  protected void c(View paramView)
  {
    this.x.a(0, paramView);
  }
  
  protected void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = this.d.getMsgCache().g(paramChatMessage);
    paramBaseChatItemLayout.setProgressVisable(bool);
    if (!bool) {
      d(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  public boolean c()
  {
    return BaseChatItemLayout.ad;
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    return null;
  }
  
  protected abstract String d(ChatMessage paramChatMessage);
  
  public void d()
  {
    this.c.notifyDataSetChanged();
  }
  
  protected void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setNetIconVisible(paramChatMessage.isSentByXG());
  }
  
  protected void e()
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.a;
    if (localAIOAnimationConatiner != null) {
      localAIOAnimationConatiner.b(0);
    }
  }
  
  public void e(ChatMessage paramChatMessage) {}
  
  public void f() {}
  
  public int g()
  {
    int i2 = -1;
    int i1 = i2;
    try
    {
      if (this.e != null)
      {
        Object localObject = ((BaseActivity)this.e).getChatFragment();
        i1 = i2;
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          i1 = i2;
          if (localObject != null) {
            i1 = ((BaseChatPie)localObject).bb();
          }
        }
      }
      return i1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public void onClick(View paramView)
  {
    if ((!c()) && (!this.f.G) && (!(this.e instanceof MultiForwardActivity)))
    {
      AIOUtils.q = true;
      this.x.a(4, paramView);
      this.x.a(5, paramView);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131430595: 
        if (this.f.a == 1) {
          c(paramView);
        }
        break;
      case 2131430601: 
        ((FlashChatManager)this.d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramView.getContext(), null);
        break;
      case 2131430587: 
        c(paramView);
        break;
      }
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */