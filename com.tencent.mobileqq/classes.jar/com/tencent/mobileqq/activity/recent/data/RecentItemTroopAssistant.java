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
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
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
      if (this.mUnreadNum > 0) {
        this.mContentDesc = String.format(HardCodeUtil.a(2131713137), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
      }
    }
    else {
      return;
    }
    this.mContentDesc = String.format(HardCodeUtil.a(2131713143), new Object[] { this.mLastMsg, this.mShowTime });
  }
  
  private void a(Context paramContext, Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (paramMessage != null) && (paramMsgSummary != null) && (AnonymousChatHelper.a(paramMessage))) {
      this.mLastMsg = paramMsgSummary.a(paramContext, AnonymousChatHelper.a(paramMessage), -1);
    }
  }
  
  private void a(Message paramMessage, MsgSummary paramMsgSummary)
  {
    SpannableString localSpannableString;
    String str;
    if ((!TextUtils.isEmpty(paramMsgSummary.strContent)) || (!TextUtils.isEmpty(paramMsgSummary.suffix)))
    {
      localSpannableString = null;
      if (TextUtils.isEmpty(paramMsgSummary.strContent)) {
        break label213;
      }
      str = paramMsgSummary.strContent.toString();
      localObject = str;
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix))
      {
        localObject = str;
        if (TextUtils.indexOf(paramMsgSummary.strContent, paramMsgSummary.strPrefix) == 0)
        {
          localObject = str;
          if (paramMsgSummary.strContent.length() <= paramMsgSummary.strPrefix.length() + 2) {}
        }
      }
    }
    label213:
    for (Object localObject = (String)str.subSequence(paramMsgSummary.strPrefix.length() + 2, paramMsgSummary.strContent.length());; localObject = paramMsgSummary.suffix.toString())
    {
      if (!TextUtils.isEmpty(paramMsgSummary.strPrefix)) {
        localSpannableString = new ColorNickText(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessage = ColorNickManager.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new QQText((CharSequence)localObject, 3, 16);
      return;
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, MsgSummary paramMsgSummary)
  {
    if ((paramBaseQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramBaseQQAppInterface, paramContext, paramIMCoreMessageStub, paramMsgSummary);
    if ((paramIMCoreMessageStub instanceof Message)) {}
    for (paramIMCoreMessageStub = (Message)paramIMCoreMessageStub;; paramIMCoreMessageStub = null)
    {
      a(paramIMCoreMessageStub, paramMsgSummary);
      extraUpdate(paramBaseQQAppInterface, paramContext, paramMsgSummary);
      a(paramContext);
      a(paramContext, paramIMCoreMessageStub, paramMsgSummary);
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */