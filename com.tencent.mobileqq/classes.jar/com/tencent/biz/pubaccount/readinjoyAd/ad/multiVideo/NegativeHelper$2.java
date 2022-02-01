package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianPopupWindow.OnComplainListener;

class NegativeHelper$2
  implements KandianPopupWindow.OnComplainListener
{
  NegativeHelper$2(NegativeHelper paramNegativeHelper) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NegativeHelper", 2, "onPopupWindowForAdComplain");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", 3);
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyUninterestComplainFragmentForResult(NegativeHelper.a(this.a), localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper.2
 * JD-Core Version:    0.7.0.1
 */