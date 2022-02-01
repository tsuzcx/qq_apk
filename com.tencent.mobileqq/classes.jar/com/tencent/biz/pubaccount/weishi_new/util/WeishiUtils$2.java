package com.tencent.biz.pubaccount.weishi_new.util;

import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.DrawableController;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.net.URL;

final class WeishiUtils$2
  implements Runnable
{
  WeishiUtils$2(URL paramURL, long paramLong, KandianUrlImageView paramKandianUrlImageView, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = AbsDownloader.getFile(this.jdField_a_of_type_JavaNetURL.toString());
    if (localObject == null) {
      return;
    }
    String str = ((File)localObject).getAbsolutePath();
    long l2 = ((File)localObject).length();
    WSLog.c("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + this.jdField_a_of_type_Long + ", length:" + l2 + ", url = " + this.jdField_a_of_type_JavaNetURL.toString() + "\n--absolutePath = " + str);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.mController.a();
    long l1;
    if (localObject != null)
    {
      l1 = ((ImageRequest)localObject).f;
      if (localObject == null) {
        break label180;
      }
    }
    label180:
    for (int i = ((ImageRequest)localObject).d;; i = 0)
    {
      boolean bool = WeishiUtils.b(i);
      WsBeaconReportPresenter.a().a(true, false, bool, this.jdField_a_of_type_Long, l1, l2, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      return;
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.2
 * JD-Core Version:    0.7.0.1
 */