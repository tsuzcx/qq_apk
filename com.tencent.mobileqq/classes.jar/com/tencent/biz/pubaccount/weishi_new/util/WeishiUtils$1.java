package com.tencent.biz.pubaccount.weishi_new.util;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import java.net.URL;

final class WeishiUtils$1
  implements PublicAccountImageDownListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = SystemClock.uptimeMillis();
  
  WeishiUtils$1(String paramString, KandianUrlImageView paramKandianUrlImageView, int paramInt) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    WSLog.b("WeishiUtils", "onLoadSuccess!!!");
    this.jdField_a_of_type_Int = 0;
    if ((this.jdField_a_of_type_Long <= 0L) || (paramURL == null)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = 0L;
    WeishiUtils.a(paramURL, l1 - l2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.b);
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    WSLog.d("WeishiUtils", "url = " + paramURL + ", onLoadFailed!!!");
    WsBeaconReportPresenter.a().a(false, false, false, 0L, 0L, 0L, paramURL.toString(), this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_Int < 2)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      WSLog.d("WeishiUtils", "");
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(paramURL);
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.1
 * JD-Core Version:    0.7.0.1
 */