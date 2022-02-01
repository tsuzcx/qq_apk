package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.rookery.translate.AITranslator;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.TransMemCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.type.Language;
import com.rookery.translate.util.LocaleUtil;
import com.rookery.translate.widget.BubbleResizeAnimation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.RotateableView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.HashMap;

public class TextTranslationItemBuilder
  extends TextItemBuilder
{
  static int G;
  private static int J;
  private static int K;
  Trans_entity F;
  private boolean H = true;
  private long I = -1L;
  AlphaAnimation a = new AlphaAnimation(0.0F, 1.0F);
  AlphaAnimation w = new AlphaAnimation(1.0F, 0.0F);
  HashMap<Long, Long> x = new HashMap();
  
  public TextTranslationItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a.setDuration(300L);
    this.a.setFillAfter(true);
    this.w.setDuration(150L);
    this.w.setFillAfter(true);
  }
  
  public static int a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    String str;
    if (paramInt == 0) {
      str = "0";
    } else if (paramInt == 1) {
      str = "1";
    } else if (paramInt == 3000) {
      str = "2";
    } else {
      str = "";
    }
    if (J != 0) {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, J, 0, "", str, "", "");
    }
    if (K != 0) {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, K, 0, "", str, "", "");
    }
    if (G != 0) {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, G, 0, "", str, "", "");
    }
    J = 0;
    K = 0;
    G = 0;
    return 0;
  }
  
  private static int a(Context paramContext, double paramDouble)
  {
    double d = paramContext.getResources().getDisplayMetrics().density;
    Double.isNaN(d);
    return (int)(paramDouble * d);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, TextTranslationItemBuilder.Holder paramHolder)
  {
    paramHolder.s = paramHolder.a.findViewById(2131447833);
    paramHolder.t = ((RotateableView)paramHolder.a.findViewById(2131447832));
    paramHolder.t.setBackgroundResource(2130848842);
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder)
  {
    if (paramHolder.s != null) {
      paramHolder.s.setVisibility(0);
    }
    if (paramHolder.t != null) {
      paramHolder.t.a();
    }
    if (paramHolder.a != null) {
      paramHolder.a.setPadding(paramHolder.a.getPaddingLeft(), paramHolder.a.getPaddingTop() - 2, a(this.e, 1.5D), a(this.e, 4.0D));
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText, String paramString1, String paramString2)
  {
    if (paramHolder.b == 100000)
    {
      TransDiskCache localTransDiskCache = TranslateCache.b(this.e.getApplicationContext());
      if (localTransDiskCache != null) {
        this.F = localTransDiskCache.a(paramString1, paramHolder.c, paramString2);
      }
      paramString1 = this.F;
      if ((paramString1 != null) && (paramString1.c().booleanValue()) && (!paramMessageForText.isSend()))
      {
        paramHolder.i = BubbleUtils.a(100001, this.d, this.e.getResources(), this.c);
        return;
      }
      paramHolder.i = BubbleUtils.a(100000, this.d, this.e.getResources(), this.c);
    }
  }
  
  private static void b(Context paramContext, TextTranslationItemBuilder.Holder paramHolder)
  {
    if (paramHolder.s != null) {
      paramHolder.s.setVisibility(8);
    }
    if (paramHolder.t != null) {
      paramHolder.t.b();
    }
    if (paramHolder.a != null) {
      paramHolder.a.setPadding(paramHolder.a.getPaddingLeft(), paramHolder.a.getPaddingTop() - 2, a(paramContext, 14.0D), a(paramContext, 5.0D));
    }
  }
  
  private void b(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    paramHolder.b = ((int)paramMessageForText.vipBubbleID);
    paramHolder.c = paramMessageForText.uniseq;
    paramHolder.d = paramMessageForText.istroop;
    paramHolder.e = paramMessageForText.msg;
    paramHolder.g = paramMessageForText.msg;
  }
  
  private void c(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    paramHolder.e = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramHolder.b == 100000)
    {
      paramHolder.g = paramMessageForText.msg;
      localObject1 = LocaleUtil.a(this.e.getApplicationContext());
      this.F = null;
      Object localObject3 = TranslateCache.b(this.e.getApplicationContext());
      if (localObject3 != null) {
        this.F = ((TransDiskCache)localObject3).a(paramMessageForText.msg, paramHolder.c, (String)localObject1);
      }
      localObject3 = this.F;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Trans_entity)localObject3).c().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramHolder.e = this.F.a();
            localObject1 = new QQText(paramHolder.e, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramHolder.b == 100000)
    {
      if (paramHolder.f == 0)
      {
        paramHolder.v.setText((CharSequence)localObject1);
        return;
      }
      if ((!paramMessageForText.isSend()) && (this.F != null) && (paramHolder.f == 1))
      {
        paramMessageForText = paramHolder.v.getText();
        int k = paramHolder.v.getMeasuredWidth();
        int j = paramHolder.v.getMeasuredHeight();
        paramHolder.v.setText((CharSequence)localObject1);
        localObject2 = paramHolder.v;
        int i = 0;
        ((TextView)localObject2).measure(0, 0);
        if (paramHolder.v.getMeasuredWidth() < BaseChatItemLayout.e) {
          i = paramHolder.v.getMeasuredWidth() - k;
        }
        k = paramHolder.v.getMeasuredHeight();
        paramHolder.v.setText(paramMessageForText);
        paramMessageForText = new BubbleResizeAnimation(paramHolder.a, 300, i, k - j);
        paramMessageForText.setAnimationListener(new TextTranslationItemBuilder.TextTranslateAnimationListener((CharSequence)localObject1, paramHolder, this.a, this.w));
        paramHolder.a.startAnimation(paramMessageForText);
      }
    }
    else
    {
      paramHolder.v.setText((CharSequence)localObject1);
    }
  }
  
  private boolean d(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    if (paramMessageForText.isSend()) {
      return true;
    }
    if (paramHolder.u)
    {
      paramHolder.u = false;
      return true;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    if (this.x.get(Long.valueOf(paramHolder.c)) == null) {
      l1 = 0L;
    } else {
      l1 = ((Long)this.x.get(Long.valueOf(paramHolder.c))).longValue();
    }
    if (l2 - l1 < 800L) {
      return true;
    }
    this.x.put(Long.valueOf(paramHolder.c), Long.valueOf(l2));
    if (QLog.isColorLevel())
    {
      paramMessageForText = new StringBuilder();
      paramMessageForText.append("on click translate status:");
      paramMessageForText.append(paramHolder.f);
      QLog.i("Translator", 2, paramMessageForText.toString());
    }
    return paramHolder.f != 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (TextTranslationItemBuilder.Holder)paramView.getTag();
    paramChatMessage = (MessageForText)paramChatMessage;
    b(paramViewGroup, paramChatMessage);
    paramOnLongClickAndTouchListener = (BaseChatItemLayout)paramView;
    a(paramOnLongClickAndTouchListener, paramViewGroup);
    a(paramViewGroup, paramChatMessage, paramOnLongClickAndTouchListener);
    c(paramViewGroup, paramChatMessage);
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    TextTranslationItemBuilder.Holder localHolder = (TextTranslationItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = (LinearLayout)((Activity)paramBaseChatItemLayout).getLayoutInflater().inflate(2131628282, null);
      localHolder.a = paramViewHolder;
      localHolder.v = ((AnimationTextView)paramViewHolder.findViewById(2131430581));
      localHolder.v.setMaxWidth(BaseChatItemLayout.e);
      localHolder.v.setMovementMethod(new LinkMovementMethod());
    }
    localHolder.v.setTextSize(0, this.f.r);
    int j = BaseChatItemLayout.getTextPaddingAlignHead();
    int i = BaseChatItemLayout.getTextPaddingAlignError();
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.getTextPaddingAlignError();
      i = BaseChatItemLayout.getTextPaddingAlignHead();
    }
    localHolder.v.setPadding(j, BaseChatItemLayout.n, i, BaseChatItemLayout.o);
    localHolder.v.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.v.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localHolder.v.setOnClickListener(this);
    localHolder.a.setOnClickListener(this);
    if ((localHolder.v instanceof AnimationTextView)) {
      ((AnimationTextView)localHolder.v).onDoubleClick = new TextTranslationItemBuilder.1(this);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextTranslationItemBuilder.Holder(this);
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.e, paramInt, 0).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignHead(), BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.getBubblePaddingAlignHead(), BaseChatItemLayout.k, BaseChatItemLayout.getBubblePaddingAlignError(), BaseChatItemLayout.l);
  }
  
  @TargetApi(16)
  protected void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    if (paramHolder == null) {
      return;
    }
    if ((paramHolder.b == 100000) && (paramMessageForText.msgtype == -1000))
    {
      if (d(paramHolder, paramMessageForText)) {
        return;
      }
      Context localContext = this.e;
      String str = LocaleUtil.a(localContext);
      paramMessageForText = null;
      TransDiskCache localTransDiskCache = TranslateCache.b(this.e.getApplicationContext());
      if (localTransDiskCache != null) {
        paramMessageForText = localTransDiskCache.a(paramHolder.g, paramHolder.c, str);
      }
      if (paramMessageForText != null)
      {
        if (!paramMessageForText.a().equalsIgnoreCase(paramHolder.g))
        {
          if ((paramMessageForText.c().booleanValue()) && (!TranslateCache.a(localContext).b(str, paramHolder.g, paramHolder.c)))
          {
            K += 1;
            TranslateCache.a(localContext).b(str, paramHolder.g, paramHolder.c, Boolean.valueOf(true));
          }
          paramMessageForText.b();
          TranslateCache.b(localContext).a(str, paramHolder.g, paramHolder.c, paramMessageForText.c());
          paramHolder.f = 1;
          this.c.notifyDataSetChanged();
          return;
        }
        a(2131914204);
        return;
      }
      J += 1;
      paramHolder.D = SystemClock.uptimeMillis();
      if (!AITranslator.a().a(localContext, paramHolder, paramHolder.e, Language.fromString(str), new TextTranslationItemBuilder.TextTranslateItemCallback(this.e, paramHolder, str, this.c, this.d)).booleanValue())
      {
        b(this.e, paramHolder);
        if (AITranslator.a().a(this.e).booleanValue())
        {
          a(2131914204);
          return;
        }
        a(2131914206);
        return;
      }
      a(paramHolder);
      TranslateCache.a(this.e.getApplicationContext()).a(str, paramHolder.g, paramHolder.c, Boolean.valueOf(true));
    }
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    String str = paramChatMessage.msg;
    Object localObject = str;
    if ((paramChatMessage instanceof MessageForText))
    {
      localObject = str;
      if (((MessageForText)paramChatMessage).vipBubbleID == 100000L)
      {
        paramString = LocaleUtil.a(this.e.getApplicationContext());
        localObject = TranslateCache.b(this.e.getApplicationContext());
        if (localObject != null) {
          paramString = ((TransDiskCache)localObject).a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);
        } else {
          paramString = null;
        }
        localObject = str;
        if (paramString != null)
        {
          localObject = str;
          if (paramString.c().booleanValue())
          {
            localObject = str;
            if (!paramChatMessage.isSend()) {
              localObject = paramString.a();
            }
          }
        }
      }
    }
    QfavBuilder.a(null, (String)localObject).b(this.d, paramChatMessage).a((Activity)this.e, this.d.getAccount());
    QfavReport.a(this.d, 6, 1);
  }
  
  protected boolean h()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131430578) && (paramView.getId() != 2131430581))
    {
      super.onClick(paramView);
    }
    else
    {
      MessageForText localMessageForText = (MessageForText)AIOUtils.a(paramView);
      a((TextTranslationItemBuilder.Holder)AIOUtils.b(paramView), localMessageForText);
      AIOUtils.q = true;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder
 * JD-Core Version:    0.7.0.1
 */