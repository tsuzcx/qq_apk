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
  public HashMap<Long, Integer> e = new HashMap();
  
  public LoverChattingGrayTipItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    for (;;)
    {
      try
      {
        if (!(paramViewHolder instanceof LoverChattingGrayTipItemBuilder.Holder))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("diffclashh =");
          ((StringBuilder)localObject1).append(paramViewHolder.getClass());
          QLog.e("LoverChattingGrayTipItemBuilder", 1, ((StringBuilder)localObject1).toString());
        }
        LoverChattingGrayTipItemBuilder.Holder localHolder = (LoverChattingGrayTipItemBuilder.Holder)paramViewHolder;
        if (paramView != null) {
          break label798;
        }
        Object localObject1 = LayoutInflater.from(this.c).inflate(2131624114, null);
        paramView = (View)localObject1;
        try
        {
          localHolder.d = ((TextView)((View)localObject1).findViewById(2131434372));
          paramView = (View)localObject1;
          localHolder.e = ((ImageView)((View)localObject1).findViewById(2131437759));
          paramView = (View)localObject1;
          Object localObject2 = localHolder.d.getLayoutParams();
          paramViewHolder = (AbstractChatItemBuilder.ViewHolder)localObject1;
          paramView = (View)localObject1;
          if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
          {
            paramView = (View)localObject1;
            localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
            paramViewHolder = (AbstractChatItemBuilder.ViewHolder)localObject1;
            paramView = (View)localObject1;
            if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != BaseChatItemLayout.y)
            {
              paramView = (View)localObject1;
              ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = BaseChatItemLayout.y;
              paramViewHolder = (AbstractChatItemBuilder.ViewHolder)localObject1;
            }
          }
          paramView = paramViewHolder;
          localHolder.d.setLineSpacing(0.0F, 1.0F);
          paramView = paramViewHolder;
          localHolder.d.setIncludeFontPadding(true);
          paramView = paramViewHolder;
          localHolder.d.setMovementMethod(null);
          paramView = paramViewHolder;
          localHolder.d.setTextColor(paramViewHolder.getResources().getColorStateList(2131168417));
          paramView = paramViewHolder;
          if (this.e == null)
          {
            paramView = paramViewHolder;
            this.e = new HashMap();
          }
          paramView = paramViewHolder;
          if (!this.e.containsKey(Long.valueOf(paramMessageRecord.uniseq)))
          {
            paramView = paramViewHolder;
            localObject1 = ObjectAnimator.ofFloat(localHolder.e, "scaleX", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
            paramView = paramViewHolder;
            localObject2 = ObjectAnimator.ofFloat(localHolder.e, "scaleY", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
            paramView = paramViewHolder;
            AnimatorSet localAnimatorSet = new AnimatorSet();
            paramView = paramViewHolder;
            localAnimatorSet.play((Animator)localObject1).with((Animator)localObject2);
            paramView = paramViewHolder;
            localAnimatorSet.setDuration(3000L);
            paramView = paramViewHolder;
            localAnimatorSet.start();
            paramView = paramViewHolder;
            this.e.put(Long.valueOf(paramMessageRecord.uniseq), Integer.valueOf(1));
            paramView = paramViewHolder;
            localObject1 = paramMessageRecord.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
            paramView = paramViewHolder;
            boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (bool) {
              localObject1 = "1";
            }
            paramView = paramViewHolder;
            LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", (String)localObject1, "", "1"));
            paramView = paramViewHolder;
            if (QLog.isColorLevel())
            {
              paramView = paramViewHolder;
              localObject1 = new StringBuilder();
              paramView = paramViewHolder;
              ((StringBuilder)localObject1).append("revoke msg grayTipItemBuilder msg uinseq=  message");
              paramView = paramViewHolder;
              ((StringBuilder)localObject1).append(paramMessageRecord.msg.hashCode());
              paramView = paramViewHolder;
              QLog.d("LoverChattingGrayTipItemBuilder", 2, ((StringBuilder)localObject1).toString());
            }
          }
          paramView = paramViewHolder;
          paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
          paramView = paramViewHolder;
          if (paramMessageRecord.tipParam != null)
          {
            paramView = paramViewHolder;
            if (paramMessageRecord.tipParam.b() != null)
            {
              paramView = paramViewHolder;
              long l1 = paramMessageRecord.uniseq;
              paramView = paramViewHolder;
              long l2 = localHolder.c;
              paramView = paramViewHolder;
              if (QLog.isColorLevel())
              {
                paramView = paramViewHolder;
                QLog.d("LoverChattingGrayTipItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
              }
              paramView = paramViewHolder;
              paramLinearLayout = paramMessageRecord.getHightlightMsgText(this.a, paramLinearLayout.getContext(), false, localHolder.d);
              paramView = paramViewHolder;
              paramMessageRecord.tipParam.b();
              paramView = paramViewHolder;
              localHolder.d.setText(paramLinearLayout);
              paramView = paramViewHolder;
              localHolder.d.setClickable(true);
              paramView = paramViewHolder;
              localHolder.d.setFocusable(true);
              paramView = paramViewHolder;
              localHolder.d.setMovementMethod(LinkMovementMethod.getInstance());
              return paramViewHolder;
            }
          }
          paramView = paramViewHolder;
          localHolder.d.setText(paramMessageRecord.msg);
          paramView = paramViewHolder;
          localHolder.d.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramView = paramViewHolder;
          localHolder.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
          paramView = paramViewHolder;
          paramMessageRecord = paramViewHolder;
          if (!AppSetting.e) {
            break label796;
          }
          paramView = paramViewHolder;
          localHolder.d.setAccessibilityDelegate(null);
          return paramViewHolder;
        }
        catch (Exception paramMessageRecord) {}
        paramViewHolder = new StringBuilder();
      }
      catch (Exception paramMessageRecord) {}
      paramViewHolder.append("LoverChattingGrayTipItemBuilder  exception ");
      paramViewHolder.append(paramMessageRecord.toString());
      QLog.e("LoverChattingGrayTipItemBuilder", 2, paramViewHolder.toString());
      paramMessageRecord = paramView;
      label796:
      return paramMessageRecord;
      label798:
      paramViewHolder = paramView;
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new LoverChattingGrayTipItemBuilder.Holder(this);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LoverChattingGrayTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */