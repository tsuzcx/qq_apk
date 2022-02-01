package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import anni;
import bdnf;
import bdnt;
import bgwv;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import njo;

public class RecentItemTroopAssistant
  extends RecentItemTroopAssistantBaseData
{
  public static final String TAG = "RecentItemTroopAssistant";
  @ParcelAnnotation.NotParcel
  public RecentUser mUser;
  
  public RecentItemTroopAssistant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.mUser = paramRecentUser;
  }
  
  private void a()
  {
    if (AppSetting.c)
    {
      if (this.mUnreadNum > 0) {
        this.mContentDesc = String.format(anni.a(2131711953), new Object[] { Integer.valueOf(this.mUnreadNum), this.mShowTime });
      }
    }
    else {
      return;
    }
    this.mContentDesc = String.format(anni.a(2131711959), new Object[] { this.mLastMsg, this.mShowTime });
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
  {
    if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (paramMessage != null) && (paramMsgSummary != null) && (njo.a(paramMessage))) {
      this.mLastMsg = paramMsgSummary.parseMsgWithExtraInfo(paramContext, paramContext.getResources().getString(2131696514), -1);
    }
  }
  
  private void a(QQMessageFacade.Message paramMessage, MsgSummary paramMsgSummary)
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
        localSpannableString = new bdnf(paramMsgSummary.strPrefix, 16).a();
      }
      paramMessage = bgwv.a((String)localObject, paramMessage, 16, 3);
      localObject = new SpannableStringBuilder();
      if (localSpannableString != null) {
        ((SpannableStringBuilder)localObject).append(localSpannableString).append(": ");
      }
      ((SpannableStringBuilder)localObject).append(paramMessage);
      paramMsgSummary.strContent = new bdnt((CharSequence)localObject, 3, 16);
      return;
    }
  }
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext, IMCoreMessageStub paramIMCoreMessageStub, MsgSummary paramMsgSummary)
  {
    if ((paramIMCoreAppRuntime == null) || (paramContext == null)) {
      return;
    }
    super.update(paramIMCoreAppRuntime, paramContext, paramIMCoreMessageStub, paramMsgSummary);
    if ((paramIMCoreMessageStub instanceof QQMessageFacade.Message)) {}
    for (paramIMCoreMessageStub = (QQMessageFacade.Message)paramIMCoreMessageStub;; paramIMCoreMessageStub = null)
    {
      a(paramIMCoreMessageStub, paramMsgSummary);
      extraUpdate(paramIMCoreAppRuntime, paramContext, paramMsgSummary);
      dealMsgAttention(paramContext);
      a(paramContext, paramIMCoreMessageStub, paramMsgSummary);
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */