package com.tencent.biz.pubaccount.weishi_new.image;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.imageloader.DrawableController;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.net.URL;

class WSImageDownListener$1
  implements Runnable
{
  WSImageDownListener$1(WSImageDownListener paramWSImageDownListener, URL paramURL, long paramLong, ImageView paramImageView, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = AbsDownloader.getFile(this.a.toString());
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = ((File)localObject2).getAbsolutePath();
    long l = ((File)localObject2).length();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("--successTime:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(", downloadCost:");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(", length:");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(", url = ");
    ((StringBuilder)localObject2).append(this.a.toString());
    ((StringBuilder)localObject2).append("\n--absolutePath = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    WSLog.c("actWsFeedPicReqDuration", ((StringBuilder)localObject2).toString());
    localObject1 = null;
    localObject2 = this.c;
    if ((localObject2 instanceof KandianUrlImageView)) {
      localObject1 = ((KandianUrlImageView)localObject2).mController.b();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("hashCode:");
    int i;
    if (localObject1 != null) {
      i = ((ImageRequest)localObject1).hashCode();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", request:");
    ((StringBuilder)localObject2).append(localObject1);
    WSLog.b("loadPicSuccessReport", ((StringBuilder)localObject2).toString());
    WsBeaconReportPresenter.a().a((ImageRequest)localObject1, true, false, l, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSImageDownListener.1
 * JD-Core Version:    0.7.0.1
 */