package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;

public class WSInstanceStateForPublicAccFrom
  implements IWSInstanceState
{
  public void a(Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onSaveInstanceState] outState:");
    ((StringBuilder)localObject).append(paramBundle);
    WSLog.a("WSInstanceStateForPublicAccFrom", ((StringBuilder)localObject).toString());
    if (paramBundle == null) {
      return;
    }
    localObject = WSPublicAccReport.getInstance().getEnterPublicAccFrom();
    paramBundle.putString("key_enter_public_acc_from", (String)localObject);
    WSSharePreferencesUtil.a("key_enter_public_acc_from", (String)localObject);
  }
  
  public void b(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.a("WSInstanceStateForPublicAccFrom", localStringBuilder.toString());
    if (paramBundle == null)
    {
      if (!TextUtils.isEmpty(WSPublicAccReport.getInstance().getEnterPublicAccFrom())) {
        return;
      }
      paramBundle = WSSharePreferencesUtil.a("key_enter_public_acc_from", "");
      WSPublicAccReport.getInstance().setEnterPublicAccFrom(paramBundle);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onViewStateRestored] enterPublicAccFrom:");
      localStringBuilder.append(paramBundle);
      WSLog.d("WSInstanceStateForPublicAccFrom", localStringBuilder.toString());
      return;
    }
    paramBundle = paramBundle.getString("key_enter_public_acc_from");
    if (!TextUtils.isEmpty(paramBundle)) {
      WSPublicAccReport.getInstance().setEnterPublicAccFrom(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSInstanceStateForPublicAccFrom
 * JD-Core Version:    0.7.0.1
 */