package com.tencent.biz.pubaccount.weishi_new.util;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import java.net.URL;

final class WeishiUtils$8
  implements IBitmapCallback
{
  WeishiUtils$8(long paramLong, String paramString1, String paramString2) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    WeishiUtils.a(paramImageRequest, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    WSLog.b("PreloadCoverImgLog", "onFail request = " + paramImageRequest);
    WsBeaconReportPresenter.a().a(true, true, false, 0L, 0L, 0L, paramImageRequest.a.toString(), this.b, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.8
 * JD-Core Version:    0.7.0.1
 */