package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;

public class WSInstanceStateForSceneFrom
  implements IWSInstanceState
{
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      localObject = WSReportUtils.a();
      paramBundle.putString("key_scene_from", (String)localObject);
      WSSharePreferencesUtil.a("key_scene_from", (String)localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSInstanceStateForSceneFrom.java][onSaveInstanceState] outState:");
    ((StringBuilder)localObject).append(paramBundle);
    WSLog.d("WSInstanceStateLog", ((StringBuilder)localObject).toString());
  }
  
  public void b(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSInstanceStateForSceneFrom.java][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSInstanceStateLog", localStringBuilder.toString());
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_scene_from");
      if (!TextUtils.isEmpty(paramBundle)) {
        WSReportUtils.a(paramBundle);
      }
    }
    else if (TextUtils.isEmpty(WSReportUtils.a()))
    {
      paramBundle = WSSharePreferencesUtil.a("key_scene_from", "");
      WSReportUtils.a(paramBundle);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSInstanceStateForSceneFrom.java][onViewStateRestored] sceneFrom:");
      localStringBuilder.append(paramBundle);
      WSLog.d("WSInstanceStateLog", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSInstanceStateForSceneFrom
 * JD-Core Version:    0.7.0.1
 */