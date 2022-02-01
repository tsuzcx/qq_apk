package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.HashMap;

public class LoverChattingGrayTipItemBuilder
  extends UniteGrayTipItemBuilder
{
  public HashMap<Long, Integer> a;
  
  public LoverChattingGrayTipItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = paramView;
    try
    {
      if (!(paramViewHolder instanceof LoverChattingGrayTipItemBuilder.Holder))
      {
        localObject1 = paramView;
        QLog.e("LoverChattingGrayTipItemBuilder", 1, "diffclashh =" + paramViewHolder.getClass());
      }
      localObject1 = paramView;
      localHolder = (LoverChattingGrayTipItemBuilder.Holder)paramViewHolder;
      paramViewHolder = paramView;
      if (paramView == null)
      {
        localObject1 = paramView;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558659, null);
        localObject1 = paramView;
        localHolder.b = ((TextView)paramView.findViewById(2131368046));
        localObject1 = paramView;
        localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370854));
        localObject1 = paramView;
        localObject2 = localHolder.b.getLayoutParams();
        paramViewHolder = paramView;
        localObject1 = paramView;
        if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
        {
          localObject1 = paramView;
          localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
          paramViewHolder = paramView;
          localObject1 = paramView;
          if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != BaseChatItemLayout.y)
          {
            localObject1 = paramView;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = BaseChatItemLayout.y;
            paramViewHolder = paramView;
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        LoverChattingGrayTipItemBuilder.Holder localHolder;
        Object localObject2;
        paramViewHolder = (AbstractChatItemBuilder.ViewHolder)localObject1;
      }
    }
    try
    {
      localHolder.b.setLineSpacing(0.0F, 1.0F);
      localHolder.b.setIncludeFontPadding(true);
      localHolder.b.setMovementMethod(null);
      localHolder.b.setTextColor(paramViewHolder.getResources().getColorStateList(2131167334));
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageRecord.uniseq)))
      {
        paramView = ObjectAnimator.ofFloat(localHolder.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
        localObject1 = ObjectAnimator.ofFloat(localHolder.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).play(paramView).with((Animator)localObject1);
        ((AnimatorSet)localObject2).setDuration(3000L);
        ((AnimatorSet)localObject2).start();
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageRecord.uniseq), Integer.valueOf(1));
        localObject1 = paramMessageRecord.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = "1";
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", paramView, "", "1"));
        if (QLog.isColorLevel()) {
          QLog.d("LoverChattingGrayTipItemBuilder", 2, "revoke msg grayTipItemBuilder msg uinseq=  message" + paramMessageRecord.msg.hashCode());
        }
      }
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if ((paramMessageRecord.tipParam != null) && (paramMessageRecord.tipParam.a() != null))
      {
        long l1 = paramMessageRecord.uniseq;
        long l2 = localHolder.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("LoverChattingGrayTipItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
        }
        paramView = paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localHolder.b);
        paramMessageRecord.tipParam.a();
        localHolder.b.setText(paramView);
        localHolder.b.setClickable(true);
        localHolder.b.setFocusable(true);
        localHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
        return paramViewHolder;
      }
      localHolder.b.setText(paramMessageRecord.msg);
      localHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      localHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (AppSetting.d)
      {
        localHolder.b.setAccessibilityDelegate(null);
        return paramViewHolder;
      }
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("LoverChattingGrayTipItemBuilder", 2, "LoverChattingGrayTipItemBuilder  exception " + paramMessageRecord.toString());
      return paramViewHolder;
    }
    return paramViewHolder;
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new LoverChattingGrayTipItemBuilder.Holder(this);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LoverChattingGrayTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */