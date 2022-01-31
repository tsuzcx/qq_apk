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
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.util.HashMap;
import vfu;
import vfv;
import vfw;

public class TextTranslationItemBuilder
  extends TextItemBuilder
{
  public static int b;
  private static int jdField_c_of_type_Int;
  private static int h;
  public AlphaAnimation a;
  Trans_entity jdField_a_of_type_ComRookeryTranslateModelTrans_entity;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public AlphaAnimation b;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = true;
  
  public TextTranslationItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(150L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
  }
  
  private int a(double paramDouble)
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * paramDouble);
  }
  
  public static int a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    String str;
    if (paramInt == 0) {
      str = "0";
    }
    for (;;)
    {
      if (jdField_c_of_type_Int != 0) {
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Clk_bubble__translate", 0, jdField_c_of_type_Int, 0, "", str, "", "");
      }
      if (h != 0) {
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Back_original_text", 0, h, 0, "", str, "", "");
      }
      if (jdField_b_of_type_Int != 0) {
        StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Same_language", 0, jdField_b_of_type_Int, 0, "", str, "", "");
      }
      jdField_c_of_type_Int = 0;
      h = 0;
      jdField_b_of_type_Int = 0;
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
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, TextTranslationItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_b_of_type_AndroidViewView = paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131361966);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView = ((RotateableView)paramHolder.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372074));
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.setBackgroundResource(2130843770);
  }
  
  private void a(TextTranslationItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.a();
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(1.5D), a(4.0D));
  }
  
  @SuppressLint({"NewApi"})
  private void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText, BaseChatItemLayout paramBaseChatItemLayout)
  {
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
    if (paramHolder.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.clearAnimation();
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.setAnimation(null);
      if (Build.VERSION.SDK_INT > 10) {
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    Object localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    if (!TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a((String)localObject, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long))
    {
      b(paramHolder);
      label140:
      this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = null;
      if (paramHolder.jdField_e_of_type_Int == 100000)
      {
        TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localTransDiskCache != null) {
          this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = localTransDiskCache.a(str, paramHolder.jdField_b_of_type_Long, (String)localObject);
        }
        if ((this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity == null) || (!this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a().booleanValue()) || (paramMessageForText.isSend())) {
          break label471;
        }
      }
    }
    label471:
    for (paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter);; paramHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter))
    {
      this.jdField_c_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((this.jdField_c_of_type_Boolean) && (!paramMessageForText.isSend()) && (paramHolder.jdField_e_of_type_Int == 100000) && (paramMessageForText.msgtype == -1000))
      {
        paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText.time, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
        i = 0;
        if (paramMessageForText.isSend()) {
          i = 1;
        }
        paramBaseChatItemLayout.setHearIconPosition(i);
        paramBaseChatItemLayout.a.setText(2131436458);
        SharedPreUtils.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_c_of_type_Long = paramHolder.jdField_b_of_type_Long;
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Newbie_guide__external", 0, 1, 0);
      }
      if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_c_of_type_Long != paramHolder.jdField_b_of_type_Long)) {
        break;
      }
      paramBaseChatItemLayout.setTimeStamp(true, paramMessageForText.time, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a, null);
      int i = 0;
      if (paramMessageForText.isSend()) {
        i = 1;
      }
      paramBaseChatItemLayout.setHearIconPosition(i);
      paramBaseChatItemLayout.a.setText(2131436458);
      return;
      a(paramHolder);
      break label140;
    }
  }
  
  private void b(TextTranslationItemBuilder.Holder paramHolder)
  {
    paramHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetRotateableView.b();
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setPadding(paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), paramHolder.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() - 2, a(14.0D), a(5.0D));
  }
  
  private void b(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    paramHolder.jdField_e_of_type_Int = ((int)paramMessageForText.vipBubbleID);
    paramHolder.jdField_b_of_type_Long = paramMessageForText.uniseq;
    paramHolder.f = paramMessageForText.istroop;
    paramHolder.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    paramHolder.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
  }
  
  private void c(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    int i = 0;
    paramHolder.jdField_b_of_type_JavaLangString = paramMessageForText.msg;
    Object localObject2 = paramMessageForText.sb;
    Object localObject1 = localObject2;
    if (paramHolder.jdField_e_of_type_Int == 100000)
    {
      paramHolder.jdField_c_of_type_JavaLangString = paramMessageForText.msg;
      localObject1 = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = null;
      TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache != null) {
        this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity = localTransDiskCache.a(paramMessageForText.msg, paramHolder.jdField_b_of_type_Long, (String)localObject1);
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity.a().booleanValue())
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
    if (paramHolder.jdField_e_of_type_Int == 100000)
    {
      localObject2 = paramHolder.jdField_b_of_type_JavaLangString;
      if (paramHolder.g == 0) {
        paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      while ((paramMessageForText.isSend()) || (this.jdField_a_of_type_ComRookeryTranslateModelTrans_entity == null) || (paramHolder.g != 1)) {
        return;
      }
      paramMessageForText = paramHolder.jdField_e_of_type_AndroidWidgetTextView.getText();
      int k = paramHolder.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth();
      int j = paramHolder.jdField_e_of_type_AndroidWidgetTextView.getMeasuredHeight();
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.measure(0, 0);
      if (paramHolder.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth() < BaseChatItemLayout.d) {
        i = paramHolder.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth() - k;
      }
      k = paramHolder.jdField_e_of_type_AndroidWidgetTextView.getMeasuredHeight();
      paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText(paramMessageForText);
      paramMessageForText = new BubbleResizeAnimation(paramHolder.jdField_a_of_type_AndroidViewViewGroup, 300, i, k - j);
      paramMessageForText.setAnimationListener(new vfv(this, paramHolder, (CharSequence)localObject1));
      paramHolder.jdField_a_of_type_AndroidViewViewGroup.startAnimation(paramMessageForText);
      return;
    }
    paramHolder.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
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
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (TextTranslationItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = (LinearLayout)((Activity)localContext).getLayoutInflater().inflate(2130970882, null);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = paramViewHolder;
      paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView = ((AnimationTextView)paramViewHolder.findViewById(2131363557));
      paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(BaseChatItemLayout.d);
      paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView.setMovementMethod(new LinkMovementMethod());
    }
    paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    int j = BaseChatItemLayout.n;
    int i = BaseChatItemLayout.o;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.n;
    }
    paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
    paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    if ((paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.jdField_e_of_type_AndroidWidgetTextView).a = new vfu(this);
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TextTranslationItemBuilder.Holder(this);
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, BaseChatItemLayout.i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  @TargetApi(16)
  protected void a(TextTranslationItemBuilder.Holder paramHolder, MessageForText paramMessageForText)
  {
    if (paramHolder == null) {
      break label4;
    }
    label4:
    Context localContext;
    String str;
    label330:
    for (;;)
    {
      return;
      if ((paramHolder.jdField_e_of_type_Int == 100000) && (paramMessageForText.msgtype == -1000) && (!paramMessageForText.isSend()))
      {
        if (paramHolder.jdField_a_of_type_Boolean)
        {
          paramHolder.jdField_a_of_type_Boolean = false;
          return;
        }
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_b_of_type_Long)) == null) {}
        for (long l1 = 0L;; l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramHolder.jdField_b_of_type_Long))).longValue())
        {
          if (l2 - l1 < 800L) {
            break label330;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramHolder.jdField_b_of_type_Long), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("Translator", 2, "on click translate status:" + paramHolder.g);
          }
          if (paramHolder.g != 0) {
            break;
          }
          localContext = this.jdField_a_of_type_AndroidContentContext;
          str = LocaleUtil.a(localContext);
          paramMessageForText = null;
          TransDiskCache localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
          if (localTransDiskCache != null) {
            paramMessageForText = localTransDiskCache.a(paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, str);
          }
          if (paramMessageForText == null) {
            break label340;
          }
          if (paramMessageForText.a().equalsIgnoreCase(paramHolder.jdField_c_of_type_JavaLangString)) {
            break label332;
          }
          if ((paramMessageForText.a().booleanValue()) && (!TranslateCache.a(localContext).b(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long)))
          {
            h += 1;
            TranslateCache.a(localContext).b(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, Boolean.valueOf(true));
          }
          paramMessageForText.a();
          TranslateCache.a(localContext).a(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, paramMessageForText.a());
          paramHolder.g = 1;
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
          return;
        }
      }
    }
    label332:
    a(2131436435);
    return;
    label340:
    jdField_c_of_type_Int += 1;
    paramHolder.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (!AITranslator.a().a(localContext, paramHolder, paramHolder.jdField_b_of_type_JavaLangString, Language.fromString(str), new vfw(this, paramHolder, localContext, str)).booleanValue())
    {
      b(paramHolder);
      if (AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext).booleanValue())
      {
        a(2131436435);
        return;
      }
      a(2131436438);
      return;
    }
    a(paramHolder);
    TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(str, paramHolder.jdField_c_of_type_JavaLangString, paramHolder.jdField_b_of_type_Long, Boolean.valueOf(true));
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    String str = paramChatMessage.msg;
    TransDiskCache localTransDiskCache;
    if (((paramChatMessage instanceof MessageForText)) && (((MessageForText)paramChatMessage).vipBubbleID == 100000L))
    {
      localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (localTransDiskCache == null) {
        break label142;
      }
    }
    label142:
    for (Object localObject = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);; localObject = null)
    {
      if ((localObject != null) && (((Trans_entity)localObject).a().booleanValue()) && (!paramChatMessage.isSend())) {}
      for (localObject = ((Trans_entity)localObject).a();; localObject = str)
      {
        QfavBuilder.a(null, (String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 1);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131361877) || (paramView.getId() == 2131363557))
    {
      MessageForText localMessageForText = (MessageForText)AIOUtils.a(paramView);
      a((TextTranslationItemBuilder.Holder)AIOUtils.a(paramView), localMessageForText);
      AIOUtils.m = true;
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder
 * JD-Core Version:    0.7.0.1
 */