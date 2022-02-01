package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.ColorNickManager;

public class RecentItemTroopAssistant
  extends RecentItemTroopAssistantBaseData
{
  public static final String TAG = "RecentItemTroopAssistant";
  
  public RecentItemTroopAssistant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private void a()
  {
    if (AppSetting.d)
    {
      if (this.mUnreadNum > 0)
      {
        this.mContentDesc = String.format(HardCodeUtil.a(2131713112), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
        return;
      }
      this.mContentDesc = String.format(HardCodeUtil.a(2131713118), new Object[] { this.mLastMsg, this.mShowTime });
    }
  }
  
  private void a(Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (paramMessage != null) && (paramMsgSummary != null) && (AnonymousChatHelper.a(paramMessage))) {
      this.mLastMsg = paramMsgSummary.a(paramContext, AnonymousChatHelper.a(paramMessage), -1);
    }
  }
  
  private void a(Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      SpannableString localSpannableString = null;
      if (!TextUtils.isEmpty(paramMsgSummary.strContent))
      {
        String str = paramMsgSummary.strContent.toString();
        localObject = str;
        if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
        {
          localObject = str;
          if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0)
          {
            localObject = str;
            if (paramMsgSummary.strContent.length() > paramMsgSummary.strPrefix.length() + 2) {
              localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());
            }
          }
        }
      }
      else
      {
        localObject = paramMsgSummary.suffix.toString();
      }
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new ColorNickText(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessage = ColorNickManager.a((String)localObject, paramMessage, 16, 3);
      Object localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if (paramBaseQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramBaseQQAppInterface, paramContext, paramMessage, paramMsgSummary);
      if (!(paramMessage instanceof Message)) {
        paramMessage = null;
      }
      a(paramMessage, paramMsgSummary);
      extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
      a(paramContext);
      a(paramContext, paramMessage, paramMsgSummary);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */