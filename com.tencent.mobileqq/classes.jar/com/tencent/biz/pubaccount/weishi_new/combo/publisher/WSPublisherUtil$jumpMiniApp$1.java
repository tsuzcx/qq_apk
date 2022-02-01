package com.tencent.biz.pubaccount.weishi_new.combo.publisher;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuc", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onLaunchResult"}, k=3, mv={1, 1, 16})
final class WSPublisherUtil$jumpMiniApp$1
  implements MiniAppLaunchListener
{
  public static final 1 a = new 1();
  
  public final void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
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
    WSLog.d("WSPublisherHelper", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherUtil.jumpMiniApp.1
 * JD-Core Version:    0.7.0.1
 */