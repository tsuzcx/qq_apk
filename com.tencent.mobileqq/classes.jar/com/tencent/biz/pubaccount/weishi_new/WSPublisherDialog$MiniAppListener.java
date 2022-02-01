package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import java.lang.ref.WeakReference;

class WSPublisherDialog$MiniAppListener
  implements MiniAppLaunchListener
{
  private WeakReference<WSPublisherDialog> jdField_a_of_type_JavaLangRefWeakReference;
  
  WSPublisherDialog$MiniAppListener(WSPublisherDialog paramWSPublisherDialog1, WSPublisherDialog paramWSPublisherDialog2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWSPublisherDialog2);
  }
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launch mini program ");
    String str;
    if (paramBoolean) {
      str = "success";
    } else {
      str = "fail";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(", bundle: ");
    localStringBuilder.append(paramBundle.toString());
    WSLog.d("WSPublisherDialog", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSPublisherDialog.MiniAppListener
 * JD-Core Version:    0.7.0.1
 */