package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class QIMTailItemBubbleBuilder
  extends BaseBubbleBuilder
{
  public QIMTailItemBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private View a(Context paramContext, View paramView, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
      paramView.setBackgroundResource(2130843656);
    }
    TextView localTextView = (TextView)paramView;
    localTextView.setEnabled(paramBoolean);
    localTextView.setText(paramString1);
    localTextView.setId(2131430607);
    Drawable localDrawable;
    if (!TextUtils.isEmpty(paramString2))
    {
      localDrawable = localResources.getDrawable(2130852668);
      localDrawable.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      paramString1 = localResources.getDrawable(2130852669);
      paramString1.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
    }
    for (;;)
    {
      try
      {
        paramString2 = URLDrawable.getDrawable(paramString2, localDrawable, paramString1);
        if (URLDrawableHelper.isMobileNetAndAutodownDisabled(paramContext)) {
          break label353;
        }
        paramBoolean = true;
        ((URLDrawable)paramString2).setAutoDownload(paramBoolean);
        paramContext = paramString2;
      }
      catch (Exception paramContext)
      {
        QLog.e("ChatItemBuilder", 1, paramContext.getMessage(), paramContext);
        paramContext = paramString1;
      }
      localTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, localResources));
      paramContext.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
      localTextView.setCompoundDrawables(paramContext, null, null, null);
      break label319;
      if (paramInt != -1)
      {
        localTextView.setCompoundDrawablePadding(AIOUtils.b(3.0F, localResources));
        paramContext = localResources.getDrawable(paramInt);
        paramContext.setBounds(0, 0, AIOUtils.b(12.0F, localResources), AIOUtils.b(12.0F, localResources));
        localTextView.setCompoundDrawables(paramContext, null, null, null);
      }
      else
      {
        localTextView.setCompoundDrawables(null, null, null, null);
      }
      label319:
      localTextView.setPadding(AIOUtils.b(5.0F, localResources), 0, AIOUtils.b(5.0F, localResources), 0);
      paramView.setTag(paramMessageRecord);
      paramView.setOnClickListener(paramOnClickListener);
      return paramView;
      label353:
      paramBoolean = false;
    }
  }
  
  public View a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    paramSessionInfo = paramBaseChatItemLayout.getContext();
    boolean bool = "2".equals(paramMessageRecord.getExtInfoFromExtStr("app_tail_id"));
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseChatItemLayout.findViewById(2131446456);
    FlashChatManager.GlobalConfig localGlobalConfig = ((FlashChatManager)paramQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c;
    int i = FlashChatManager.a(paramMessageRecord);
    if (i == -1) {
      return paramBaseChatItemLayout;
    }
    String str = paramMessageRecord.getExtInfoFromExtStr("qim_source");
    if ((!TextUtils.isEmpty(localGlobalConfig.b)) && (bool) && ("1".equals(str)))
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008279", "0X8008279", i, 0, "", "", "", "");
      a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, paramSessionInfo, localRelativeLayout, localGlobalConfig.b, localGlobalConfig.d, -1, true);
      return paramBaseChatItemLayout;
    }
    if (localRelativeLayout != null) {
      paramBaseChatItemLayout.removeView(localRelativeLayout);
    }
    return paramBaseChatItemLayout;
  }
  
  protected void a(BaseChatItemLayout paramBaseChatItemLayout, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener, Context paramContext, RelativeLayout paramRelativeLayout, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new RelativeLayout(paramBaseChatItemLayout.getContext());
      paramRelativeLayout.setId(2131446456);
      i = 1;
    }
    else
    {
      i = 0;
    }
    Object localObject2 = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    }
    localObject2 = paramBaseChatItemLayout.getResources();
    boolean bool = paramMessageRecord.isSend();
    ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(-2.0F, (Resources)localObject2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(0.0F, (Resources)localObject2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131430578);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131430578);
    if (bool)
    {
      ((RelativeLayout.LayoutParams)localObject1).leftMargin += AIOUtils.b(18.0F, (Resources)localObject2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject1).leftMargin += AIOUtils.b(9.0F, (Resources)localObject2);
    }
    paramRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramRelativeLayout.getChildAt(0);
    if (localObject1 == null) {
      paramRelativeLayout.addView(a(paramContext, (View)localObject1, paramMessageRecord, paramString1, paramString2, paramInt, paramBoolean, paramOnClickListener));
    } else {
      a(paramContext, (View)localObject1, paramMessageRecord, paramString1, paramString2, paramInt, paramBoolean, paramOnClickListener);
    }
    if (i != 0) {
      paramBaseChatItemLayout.addView(paramRelativeLayout);
    }
    paramBaseChatItemLayout.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QIMTailItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */