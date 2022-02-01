package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
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
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.SharedPreUtils;
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
    }
    for (;;)
    {
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
      if (paramInt == 1) {
        str = "1";
      } else if (paramInt == 3000) {
        str = "2";
      } else {
        str = "";
      }
    }
  }
  
  private static int a(Context paramContext, double paramDouble)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramDouble);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, TextTranslationItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_c_of_type_AndroidViewView = paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379765);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379764));
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130847387);
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
    int k = 1;
    String str = paramMessageForText.msg;
    if (paramHolder == null) {
      return;
    }
    if (paramHolder.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -2;
      ((RelativeLayout.LayoutParams)localObject).height = -2;
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    }
    if (paramHolder.d != null)
    {
      paramHolder.d.clearAnimation();
      paramHolder.d.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramHolder.d.setAlpha(1.0F);
      }
    }
    Object localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long))
    {
      b(this.jdField_a_of_type_AndroidContentContext, paramHolder);
      this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = null;
      a(paramHolder, paramMessageForText, str, (String)localObject);
      this.f = SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.f) && (!paramMessageForText.isSend()) && (paramHolder.e == 100000) && (paramMessageForText.msgtype == -1000))
      {
        paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
        if (!paramMessageForText.isSend()) {
          break label388;
        }
      }
    }
    label388:
    for (int j = 1;; j = 0)
    {
      paramBaseChatItemLayout.setHearIconPosition(j);
      paramBaseChatItemLayout.a.setText(2131720023);
      SharedPreUtils.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Long = paramHolder.jdField_b_of_type_Long;
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCountCliOper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramHolder.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      if (paramMessageForText.isSend()) {}
      for (j = k;; j = 0)
      {
        paramBaseChatItemLayout.setHearIconPosition(j);
        paramBaseChatItemLayout.a.setText(2131720023);
        return;
        a(paramHolder);
        break;
      }
    }
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText, String paramString1, String paramString2)
  {
    if (paramHolder.e == 100000)
    {
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = localTransDiskCache.a(paramString1, paramHolder.jdField_b_of_type_Long, paramString2);
      }
      if ((this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity != null) && (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a().booleanValue()) && (!paramMessageForText.isSend())) {
        paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      }
    }
    else
    {
      return;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);
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
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_b_of_type_Long)) == null) {}
    for (long l1 = 0L; l2 - l1 < 800L; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_b_of_type_Long))).longValue()) {
      return true;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramHolder.jdField_b_of_type_Long), Long.valueOf(l2));
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "on click translate status:" + paramHolder.h);
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
    int j = 0;
    paramHolder.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    CharSequence localCharSequence = paramMessageForText.sb;
    Object localObject = localCharSequence;
    if (paramHolder.e == 100000)
    {
      paramHolder.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = null;
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = localTransDiskCache.a(paramMessageForText.msg, paramHolder.jdField_b_of_type_Long, (String)localObject);
      }
      localObject = localCharSequence;
      if (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity != null)
      {
        localObject = localCharSequence;
        if (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a().booleanValue())
        {
          localObject = localCharSequence;
          if (!paramMessageForText.isSend())
          {
            paramHolder.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a();
            localObject = new QQText(paramHolder.jdField_b_of_type_JavaLangString, 13, 32, paramMessageForText);
          }
        }
      }
    }
    if (paramHolder.e == 100000)
    {
      if (paramHolder.h == 0) {
        paramHolder.d.setText((CharSequence)localObject);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity == null) || (paramHolder.h != 1)) {
        return;
      }
      paramMessageForText = paramHolder.d.getText();
      int m = paramHolder.d.getMeasuredWidth();
      int k = paramHolder.d.getMeasuredHeight();
      paramHolder.d.setText((CharSequence)localObject);
      paramHolder.d.measure(0, 0);
      if (paramHolder.d.getMeasuredWidth() < BaseChatItemLayout.e) {
        j = paramHolder.d.getMeasuredWidth() - m;
      }
      m = paramHolder.d.getMeasuredHeight();
      paramHolder.d.setText(paramMessageForText);
      paramMessageForText = new BubbleResizeAnimation(paramHolder.jdField_a_of_type_AndroidViewViewGroup, 300, j, m - k);
      paramMessageForText.setAnimationListener(new TextTranslationItemBuilder.TextTranslateAnimationListener((CharSequence)localObject, paramHolder, this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation, this.b));
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramHolder.d.setText((CharSequence)localObject);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramViewGroup = (TextTranslationItemBuilder.Holder)paramView.getTag();
    b(paramViewGroup, (MessageForText)paramChatMessage);
    a((BaseChatItemLayout)paramView, paramViewGroup);
    a(paramViewGroup, (MessageForText)paramChatMessage, (BaseChatItemLayout)paramView);
    c(paramViewGroup, (MessageForText)paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (TextTranslationItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2131562031, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramViewHolder;
      paramBaseChatItemLayout.d = ((AnimationTextView)paramViewHolder.findViewById(2131364637));
      paramBaseChatItemLayout.d.setMaxWidth(BaseChatItemLayout.e);
      paramBaseChatItemLayout.d.setMovementMethod(new LinkMovementMethod());
    }
    paramBaseChatItemLayout.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int k = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.d.setPadding(k, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    paramBaseChatItemLayout.d.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new TextTranslationItemBuilder.1(this);
    }
    return paramViewHolder;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new TextTranslationItemBuilder.Holder(this);
  }
  
  @Deprecated
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
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
    if (paramHolder == null) {}
    while ((paramHolder.e != 100000) || (paramMessageForText.msgtype != -1000) || (a(paramHolder, paramMessageForText))) {
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
      a(2131717073);
      return;
    }
    h += 1;
    paramHolder.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramHolder, paramHolder.jdField_b_of_type_JavaLangString, Language.fromString(str), new TextTranslationItemBuilder.TextTranslateItemCallback(this.jdField_a_of_type_AndroidContentContext, paramHolder, str, this.jdField_a_of_type_AndroidWidgetBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).booleanValue())
    {
      b(this.jdField_a_of_type_AndroidContentContext, paramHolder);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131717073);
        return;
      }
      a(2131717075);
      return;
    }
    a(paramHolder);
    TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, Boolean.valueOf(true));
  }
  
  protected void a(ChatMessage paramChatMessage, String paramString)
  {
    String str = paramChatMessage.msg;
    TransDiskCache localTransDiskCache;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      paramString = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache == null) {
        break label142;
      }
    }
    label142:
    for (paramString = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (paramString = paramString.a();; paramString = str)
      {
        QfavBuilder.a(null, paramString).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364634) || (paramView.getId() == 2131364637))
    {
      MessageForText localMessageForText = (MessageForText)AIOUtils.a(paramView);
      a((TextTranslationItemBuilder.Holder)AIOUtils.a(paramView), localMessageForText);
      AIOUtils.o = true;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder
 * JD-Core Version:    0.7.0.1
 */