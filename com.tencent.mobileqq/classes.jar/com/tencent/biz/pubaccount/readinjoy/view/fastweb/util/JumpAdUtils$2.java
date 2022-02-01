package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianPopupWindow.OnComplainListener;

final class JumpAdUtils$2
  implements KandianPopupWindow.OnComplainListener
{
  JumpAdUtils$2(Context paramContext, AdData paramAdData) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAdUtils", 2, "onPopupWindowForAdComplain");
    }
    if ((this.a instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 3);
      localIntent.putExtra("key_ad_info", this.b);
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyUninterestComplainFragmentForResult((Activity)this.a, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils.2
 * JD-Core Version:    0.7.0.1
 */