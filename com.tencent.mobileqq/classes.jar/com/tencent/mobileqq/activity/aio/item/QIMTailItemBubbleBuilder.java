package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
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
  
  private View a(Context paramContext, View paramView, MessageRecord paramMessageRecord, FlashChatManager.GlobalConfig paramGlobalConfig, View.OnClickListener paramOnClickListener)
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
      paramView.setBackgroundResource(2130840661);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setText(paramGlobalConfig.b);
      localTextView.setId(2131361860);
      if (!TextUtils.isEmpty(paramGlobalConfig.d))
      {
        Object localObject = paramGlobalConfig.d;
        Drawable localDrawable = localResources.getDrawable(2130846176);
        localDrawable.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        paramGlobalConfig = localResources.getDrawable(2130846177);
        paramGlobalConfig.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        try
        {
          localObject = URLDrawable.getDrawable((String)localObject, localDrawable, paramGlobalConfig);
          if (URLDrawableHelper.a(paramContext)) {
            break label265;
          }
          bool = true;
          ((URLDrawable)localObject).setAutoDownload(bool);
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            boolean bool;
            QLog.e("ChatItemBuilder", 1, paramContext.getMessage(), paramContext);
            paramContext = paramGlobalConfig;
          }
        }
        localTextView.setCompoundDrawablePadding(AIOUtils.a(3.0F, localResources));
        paramContext.setBounds(0, 0, AIOUtils.a(12.0F, localResources), AIOUtils.a(12.0F, localResources));
        localTextView.setCompoundDrawables(paramContext, null, null, null);
      }
      for (;;)
      {
        localTextView.setPadding(AIOUtils.a(5.0F, localResources), 0, AIOUtils.a(5.0F, localResources), 0);
        paramView.setTag(paramMessageRecord);
        paramView.setOnClickListener(paramOnClickListener);
        return paramView;
        label265:
        bool = false;
        break;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public View a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    boolean bool = "2".equals(paramMessageRecord.getExtInfoFromExtStr("app_tail_id"));
    paramSessionInfo = (RelativeLayout)paramBaseChatItemLayout.findViewById(2131361882);
    FlashChatManager.GlobalConfig localGlobalConfig = ((FlashChatManager)paramQQAppInterface.getManager(216)).a;
    int i = FlashChatManager.a(paramMessageRecord);
    if (i == -1) {}
    Object localObject;
    do
    {
      return paramBaseChatItemLayout;
      localObject = paramMessageRecord.getExtInfoFromExtStr("qim_source");
      if ((!TextUtils.isEmpty(localGlobalConfig.b)) && (bool) && ("1".equals(localObject))) {
        break;
      }
    } while (paramSessionInfo == null);
    paramBaseChatItemLayout.removeView(paramSessionInfo);
    return paramBaseChatItemLayout;
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008279", "0X8008279", i, 0, "", "", "", "");
    if (paramSessionInfo == null)
    {
      paramQQAppInterface = new RelativeLayout(paramBaseChatItemLayout.getContext());
      paramQQAppInterface.setId(2131361882);
      i = 1;
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)paramQQAppInterface.getLayoutParams();
      paramSessionInfo = (SessionInfo)localObject;
      if (localObject == null) {
        paramSessionInfo = new RelativeLayout.LayoutParams(-2, -2);
      }
      localObject = paramBaseChatItemLayout.getResources();
      bool = paramMessageRecord.isSend();
      paramSessionInfo.topMargin = AIOUtils.a(-2.0F, (Resources)localObject);
      paramSessionInfo.leftMargin = AIOUtils.a(0.0F, (Resources)localObject);
      paramSessionInfo.addRule(5, 2131361877);
      paramSessionInfo.addRule(3, 2131361877);
      int j;
      if (bool)
      {
        j = paramSessionInfo.leftMargin;
        paramSessionInfo.leftMargin = (AIOUtils.a(18.0F, (Resources)localObject) + j);
        paramSessionInfo.addRule(1, 0);
        paramSessionInfo.addRule(7, 2131361863);
        paramQQAppInterface.setLayoutParams(paramSessionInfo);
        paramSessionInfo = paramQQAppInterface.getChildAt(0);
        if (paramSessionInfo != null) {
          break label351;
        }
        paramQQAppInterface.addView(a(localContext, paramSessionInfo, paramMessageRecord, localGlobalConfig, paramOnClickListener));
      }
      for (;;)
      {
        if (i != 0) {
          paramBaseChatItemLayout.addView(paramQQAppInterface);
        }
        paramBaseChatItemLayout.requestLayout();
        return paramBaseChatItemLayout;
        j = paramSessionInfo.leftMargin;
        paramSessionInfo.leftMargin = (AIOUtils.a(9.0F, (Resources)localObject) + j);
        paramSessionInfo.addRule(7, 2131361877);
        break;
        label351:
        a(localContext, paramSessionInfo, paramMessageRecord, localGlobalConfig, paramOnClickListener);
      }
      i = 0;
      paramQQAppInterface = paramSessionInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QIMTailItemBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */