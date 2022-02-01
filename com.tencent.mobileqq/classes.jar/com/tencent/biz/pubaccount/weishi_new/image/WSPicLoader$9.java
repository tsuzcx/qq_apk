package com.tencent.biz.pubaccount.weishi_new.image;

import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import java.net.URL;

final class WSPicLoader$9
  implements IBitmapCallback
{
  WSPicLoader$9(long paramLong, String paramString1, String paramString2) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    WSPicLoader.a(paramImageRequest, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    paramThrowable = new StringBuilder();
    paramThrowable.append("onFail request = ");
    paramThrowable.append(paramImageRequest);
    WSLog.b("PreloadCoverImgLog", paramThrowable.toString());
    WsBeaconReportPresenter.a().a(true, true, false, 0L, 0L, 0L, paramImageRequest.a.toString(), this.b, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.9
 * JD-Core Version:    0.7.0.1
 */