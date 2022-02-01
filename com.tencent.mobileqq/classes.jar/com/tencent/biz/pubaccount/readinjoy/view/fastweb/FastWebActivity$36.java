package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class FastWebActivity$36
  implements INetInfoHandler
{
  FastWebActivity$36(FastWebActivity paramFastWebActivity) {}
  
  public void onNetMobile2None()
  {
    FastWebActivity.m(this.a);
    FastWebVideoPlayManager.a.onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    FastWebActivity.m(this.a);
    FastWebVideoPlayManager.a.onNetMobile2Wifi(paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    FastWebActivity.m(this.a);
    FastWebVideoPlayManager.a.onNetNone2Mobile(paramString);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    FastWebActivity.m(this.a);
    FastWebVideoPlayManager.a.onNetNone2Wifi(paramString);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    FastWebActivity.m(this.a);
    FastWebVideoPlayManager.a.onNetWifi2Mobile(paramString);
  }
  
  public void onNetWifi2None()
  {
    FastWebActivity.m(this.a);
    FastWebVideoPlayManager.a.onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.36
 * JD-Core Version:    0.7.0.1
 */