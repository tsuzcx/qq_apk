package com.tencent.biz.pubaccount.weishi_new.image;

import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import java.net.URL;

class WSPicLoader$6
  implements IBitmapCallback
{
  WSPicLoader$6(WSPicLoader paramWSPicLoader, long paramLong, String paramString1, String paramString2) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, ICloseableBitmap paramICloseableBitmap)
  {
    RIJImageOptReport.a(6, paramImageRequest);
    WSPicLoader.a(this.d, paramImageRequest, this.a, this.b, this.c);
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    paramThrowable = new StringBuilder();
    paramThrowable.append("onFail request = ");
    paramThrowable.append(paramImageRequest);
    WSLog.b("PreloadCoverImgLog", paramThrowable.toString());
    RIJImageOptReport.a(6, paramImageRequest);
    WsBeaconReportPresenter.a().a(paramImageRequest, true, true, 0L, paramImageRequest.a.toString(), this.c, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.6
 * JD-Core Version:    0.7.0.1
 */