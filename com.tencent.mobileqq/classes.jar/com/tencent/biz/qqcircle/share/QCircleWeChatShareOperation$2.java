package com.tencent.biz.qqcircle.share;

import android.os.Handler;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StShare;

class QCircleWeChatShareOperation$2
  implements Runnable
{
  QCircleWeChatShareOperation$2(QCircleWeChatShareOperation paramQCircleWeChatShareOperation) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.f() == null) {
        return;
      }
      if (this.this$0.f().d == 1)
      {
        QCircleWeChatShareOperation.c(this.this$0);
      }
      else
      {
        QLog.d("QCircleWeChatShare", 1, "shareToWeChat share url icon");
        QCircleWeChatShareOperation.a(this.this$0, this.this$0.f().b.share.cover.picUrl.get());
      }
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToWeChat  Exception : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QCircleWeChatShare", 1, localStringBuilder.toString());
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToWeChat  OutOfMemoryError : ");
      localStringBuilder.append(localOutOfMemoryError.getMessage());
      QLog.e("QCircleWeChatShare", 1, localStringBuilder.toString());
    }
    RFThreadManager.getUIHandler().post(QCircleWeChatShareOperation.d(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleWeChatShareOperation.2
 * JD-Core Version:    0.7.0.1
 */