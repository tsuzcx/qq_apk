package com.tencent.biz.pubaccount.weishi_new.image;

import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.net.URL;

public class WSImageDownListener
  implements IPublicAccountImageDownListener
{
  private long a = SystemClock.uptimeMillis();
  private int b;
  private WSPicOptions c;
  
  public WSImageDownListener(WSPicOptions paramWSPicOptions)
  {
    this.c = paramWSPicOptions;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSImageDownListener构造方法 startTime:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", thisHashCode:");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", option:");
    localStringBuilder.append(paramWSPicOptions.toString());
    WSLog.b("WSImageDownListener", localStringBuilder.toString());
  }
  
  private void a(URL paramURL, long paramLong, String paramString, ImageView paramImageView, int paramInt)
  {
    String str = paramURL.toString();
    WSFallKeyPicMonitor.b(1, str);
    ThreadManager.executeOnSubThread(new WSImageDownListener.1(this, paramURL, paramLong, paramImageView, str, paramString, paramInt));
  }
  
  public void a()
  {
    this.a = SystemClock.uptimeMillis();
  }
  
  public void a(URL paramURL, int paramInt)
  {
    IPublicAccountImageDownListener localIPublicAccountImageDownListener = this.c.g();
    if (localIPublicAccountImageDownListener != null) {
      localIPublicAccountImageDownListener.a(paramURL, paramInt);
    }
  }
  
  public void a(URL paramURL, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadSuccessed：");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("， cost:");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - this.a);
    ((StringBuilder)localObject).append(", thisHashCode:");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(", url:");
    ((StringBuilder)localObject).append(paramURL.toString());
    WSLog.b("WSImageDownListener", ((StringBuilder)localObject).toString());
    if ((paramObject instanceof ICloseableBitmap)) {
      localObject = ((ICloseableBitmap)paramObject).b();
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onLoadSuccessed] bitmap:");
    localStringBuilder.append(localObject);
    localStringBuilder.append(", options:");
    localStringBuilder.append(this.c.toString());
    WSLog.e("WSImageDownListener", localStringBuilder.toString());
    if (this.c == null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.a;
    this.b = 0;
    this.a = 0L;
    if (this.c.f()) {
      a(paramURL, l1 - l2, this.c.d(), this.c.a(), this.c.e());
    }
    localObject = this.c.g();
    if (localObject != null) {
      ((IPublicAccountImageDownListener)localObject).a(paramURL, paramObject);
    }
  }
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url = ");
    ((StringBuilder)localObject).append(paramURL);
    ((StringBuilder)localObject).append(", onLoadFailed!!!");
    WSLog.d("WSImageDownListener", ((StringBuilder)localObject).toString());
    if (this.c == null) {
      return;
    }
    WsBeaconReportPresenter.a().a(null, false, false, 0L, paramURL.toString(), this.c.d(), this.c.e());
    if (this.b < 3)
    {
      this.a = SystemClock.uptimeMillis();
      this.b += 1;
      if ((this.c.a() instanceof KandianUrlImageView)) {
        ((KandianUrlImageView)this.c.a()).setImage(paramURL);
      }
    }
    else
    {
      this.a = 0L;
      this.b = 0;
    }
    localObject = this.c.g();
    if (localObject != null) {
      ((IPublicAccountImageDownListener)localObject).a(paramURL, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSImageDownListener
 * JD-Core Version:    0.7.0.1
 */