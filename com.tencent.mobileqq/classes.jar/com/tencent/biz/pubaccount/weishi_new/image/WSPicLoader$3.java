package com.tencent.biz.pubaccount.weishi_new.image;

import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.net.URL;

final class WSPicLoader$3
  implements Runnable
{
  WSPicLoader$3(URL paramURL, long paramLong, KandianUrlImageView paramKandianUrlImageView, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = AbsDownloader.getFile(this.jdField_a_of_type_JavaNetURL.toString());
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = ((File)localObject2).getAbsolutePath();
    long l2 = ((File)localObject2).length();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("--successTime:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(", downloadCost:");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject2).append(", length:");
    ((StringBuilder)localObject2).append(l2);
    ((StringBuilder)localObject2).append(", url = ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaNetURL.toString());
    ((StringBuilder)localObject2).append("\n--absolutePath = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    WSLog.c("actWsFeedPicReqDuration", ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.mController.a();
    long l1;
    if (localObject1 != null) {
      l1 = ((ImageRequest)localObject1).f;
    } else {
      l1 = 0L;
    }
    int j = 0;
    if (localObject1 != null) {
      i = ((ImageRequest)localObject1).d;
    } else {
      i = 0;
    }
    boolean bool = WSPicLoader.a(i);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("hashCode:");
    int i = j;
    if (localObject1 != null) {
      i = ((ImageRequest)localObject1).hashCode();
    }
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", request:");
    ((StringBuilder)localObject2).append(localObject1);
    WSLog.b("loadPicSuccessReport", ((StringBuilder)localObject2).toString());
    WsBeaconReportPresenter.a().a(true, false, bool, this.jdField_a_of_type_Long, l1, l2, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.3
 * JD-Core Version:    0.7.0.1
 */