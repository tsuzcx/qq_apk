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
  static int g;
  private static int h;
  private static int i;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
  Trans_entity jdField_a_of_type_ComRookeryTranslateModelTrans_entity;
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AlphaAnimation b = new AlphaAnimation(1.0F, 0.0F);
  private long c;
  private boolean f = true;
  
  public TextTranslationItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.b.setDuration(150L);
    this.b.setFillAfter(true);
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
    if (h != 0) {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, h, 0, "", str, "", "");
    }
    if (i != 0) {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, i, 0, "", str, "", "");
    }
    if (g != 0) {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountRes(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, g, 0, "", str, "", "");
    }
    h = 0;
    i = 0;
    g = 0;
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
    paramHolder.jdField_c_of_type_AndroidViewView = paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379099);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379098));
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130847256);
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_c_of_type_AndroidViewView != null) {
      paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    }
    if (paramHolder.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(this.jdField_a_of_type_AndroidContentContext, 1.5D), a(this.jdField_a_of_type_AndroidContentContext, 4.0D));
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText, String paramString1, String paramString2)
  {
    if (paramHolder.e == 100000)
    {
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = localTransDiskCache.a(paramString1, paramHolder.jdField_b_of_type_Long, paramString2);
      }
      paramString1 = this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity;
      if ((paramString1 != null) && (paramString1.a().booleanValue()) && (!paramMessageForText.isSend()))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        return;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    }
  }
  
  private boolean a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    if (paramMessageForText.isSend()) {
      return true;
    }
    if (paramHolder.jdField_a_of_type_Boolean)
    {
      paramHolder.jdField_a_of_type_Boolean = false;
      return true;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_b_of_type_Long)) == null) {
      l1 = 0L;
    } else {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_b_of_type_Long))).longValue();
    }
    if (l2 - l1 < 800L) {
      return true;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramHolder.jdField_b_of_type_Long), Long.valueOf(l2));
    if (QLog.isColorLevel())
    {
      paramMessageForText = new StringBuilder();
      paramMessageForText.append("on click translate status:");
      paramMessageForText.append(paramHolder.h);
      QLog.i("Translator", 2, paramMessageForText.toString());
    }
    return paramHolder.h != 0;
  }
  
  private static void b(Context paramContext, TextTranslationItemBuilder.Holder paramHolder)
  {
    if (paramHolder.jdField_c_of_type_AndroidViewView != null) {
      paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView != null) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    }
    if (paramHolder.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(paramContext, 14.0D), a(paramContext, 5.0D));
    }
  }
  
  private void b(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    paramHolder.e = ((int)paramMessageForText.vipBubbleID);
    paramHolder.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramHolder.g = paramMessageForText.istroop;
    paramHolder.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramHolder.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    paramHolder.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramHolder.e == 100000)
    {
      paramHolder.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = null;
      Object localObject3 = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localObject3 != null) {
        this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = ((TransDiskCache)localObject3).a(paramMessageForText.msg, paramHolder.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject3 = this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Trans_entity)localObject3).a().booleanValue())
        {
          localObject1 = localObject2;
          if (!paramMessageForText.isSend())
          {
            paramHolder.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a();
            localObject1 = new QQText(paramHolder.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramHolder.e == 100000)
    {
      if (paramHolder.h == 0)
      {
        paramHolder.d.setText((CharSequence)localObject1);
        return;
      }
      if ((!paramMessageForText.isSend()) && (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity != null) && (paramHolder.h == 1))
      {
        paramMessageForText = paramHolder.d.getText();
        int m = paramHolder.d.getMeasuredWidth();
        int k = paramHolder.d.getMeasuredHeight();
        paramHolder.d.setText((CharSequence)localObject1);
        localObject2 = paramHolder.d;
        int j = 0;
        ((TextView)localObject2).measure(0, 0);
        if (paramHolder.d.getMeasuredWidth() < BaseChatItemLayout.e) {
          j = paramHolder.d.getMeasuredWidth() - m;
        }
        m = paramHolder.d.getMeasuredHeight();
        paramHolder.d.setText(paramMessageForText);
        paramMessageForText = new BubbleResizeAnimation(paramHolder.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
        paramMessageForText.setAnimationListener(new TextTranslationItemBuilder.TextTranslateAnimationListener((CharSequence)localObject1, paramHolder, this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation, this.b));
        paramHolder.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      }
    }
    else
    {
      paramHolder.d.setText((CharSequence)localObject1);
    }
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
      paramViewHolder = (LinearLayout)((Activity)paramBaseChatItemLayout).getLayoutInflater().inflate(2131561864, null);
      localHolder.jdField_a_of_type_AndroidViewViewGroup = paramViewHolder;
      localHolder.d = ((AnimationTextView)paramViewHolder.findViewById(2131364524));
      localHolder.d.setMaxWidth(BaseChatItemLayout.e);
      localHolder.d.setMovementMethod(new LinkMovementMethod());
    }
    localHolder.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    localHolder.d.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    localHolder.d.setOnTouchListener(paramOnLongClickAndTouchListener);
    localHolder.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localHolder.d.setOnClickListener(this);
    localHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((localHolder.d instanceof AnimationTextView)) {
      ((AnimationTextView)localHolder.d).onDoubleClick = new TextTranslationItemBuilder.1(this);
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
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, BaseChatItemLayout.j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  @TargetApi(16)
  protected void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    if (paramHolder == null) {
      return;
    }
    if ((paramHolder.e == 100000) && (paramMessageForText.msgtype == -1000))
    {
      if (a(paramHolder, paramMessageForText)) {
        return;
      }
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      String str = LocaleUtil.a(localContext);
      paramMessageForText = null;
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        paramMessageForText = localTransDiskCache.a(paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, str);
      }
      if (paramMessageForText != null)
      {
        if (!paramMessageForText.a().equalsIgnoreCase(paramHolder.jdField_c_of_type_JavaLangString))
        {
          if ((paramMessageForText.a().booleanValue()) && (!TranslateCache.a(localContext).b(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long)))
          {
            i += 1;
            TranslateCache.a(localContext).b(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          TranslateCache.a(localContext).a(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, paramMessageForText.a());
          paramHolder.h = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
        a(2131716732);
        return;
      }
      h += 1;
      paramHolder.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      if (!AITranslator.a().a(localContext, paramHolder, paramHolder.jdField_b_of_type_JavaLangString, Language.fromString(str), new TextTranslationItemBuilder.TextTranslateItemCallback(this.jdField_a_of_type_AndroidContentContext, paramHolder, str, this.jdField_a_of_type_AndroidWidgetBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).booleanValue())
      {
        b(this.jdField_a_of_type_AndroidContentContext, paramHolder);
        if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
        {
          a(2131716732);
          return;
        }
        a(2131716734);
        return;
      }
      a(paramHolder);
      TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, Boolean.valueOf(true));
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
        paramString = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localObject = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localObject != null) {
          paramString = ((TransDiskCache)localObject).a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);
        } else {
          paramString = null;
        }
        localObject = str;
        if (paramString != null)
        {
          localObject = str;
          if (paramString.a().booleanValue())
          {
            localObject = str;
            if (!paramChatMessage.isSend()) {
              localObject = paramString.a();
            }
          }
        }
      }
    }
    QfavBuilder.a(null, (String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131364521) && (paramView.getId() != 2131364524))
    {
      super.onClick(paramView);
    }
    else
    {
      MessageForText localMessageForText = (MessageForText)AIOUtils.a(paramView);
      a((TextTranslationItemBuilder.Holder)AIOUtils.a(paramView), localMessageForText);
      AIOUtils.o = true;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder
 * JD-Core Version:    0.7.0.1
 */