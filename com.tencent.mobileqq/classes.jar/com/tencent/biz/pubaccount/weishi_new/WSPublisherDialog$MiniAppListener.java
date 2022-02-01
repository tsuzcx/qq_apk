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
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      WSLog.d("WSPublisherDialog", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSPublisherDialog.MiniAppListener
 * JD-Core Version:    0.7.0.1
 */