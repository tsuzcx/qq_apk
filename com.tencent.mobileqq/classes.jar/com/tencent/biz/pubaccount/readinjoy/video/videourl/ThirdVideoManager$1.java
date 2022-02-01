package com.tencent.biz.pubaccount.readinjoy.video.videourl;

import android.os.Bundle;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class ThirdVideoManager$1
  implements BusinessObserver
{
  ThirdVideoManager$1(ThirdVideoManager paramThirdVideoManager, NewIntent paramNewIntent, String paramString1, String paramString2, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    ThirdVideoManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlThirdVideoManager, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlThirdVideoManager$UUIDToUrlCallback, this.jdField_a_of_type_Long, paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.1
 * JD-Core Version:    0.7.0.1
 */