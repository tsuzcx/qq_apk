package com.tencent.biz.qqcircle.share;

import android.graphics.Bitmap;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._SendMessageToWX.Req;
import com.tencent.biz.qcircleshadow.lib.QCircleHostShareInvokeHelper;
import com.tencent.biz.qqcircle.widgets.QCircleProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QCircleWeChatShareOperation$4
  implements Runnable
{
  QCircleWeChatShareOperation$4(QCircleWeChatShareOperation paramQCircleWeChatShareOperation) {}
  
  public void run()
  {
    if ((QCircleWeChatShareOperation.e(this.this$0) != null) && (QCircleWeChatShareOperation.e(this.this$0).isShowing())) {
      QCircleWeChatShareOperation.e(this.this$0).dismiss();
    }
    QCircleWeChatShareOperation.b(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)QCircleWeChatShareOperation.f(this.this$0).remove("image");
    this.this$0.a(true);
    String str1 = QCircleWeChatShareOperation.a(this.this$0);
    String str2 = QCircleWeChatShareOperation.g(this.this$0);
    String str3 = QCircleWeChatShareOperation.h(this.this$0);
    String str4 = QCircleWeChatShareOperation.i(this.this$0);
    int i;
    if (this.this$0.o()) {
      i = QCircleHostConstants._SendMessageToWX.Req.WXSceneSession();
    } else {
      i = QCircleHostConstants._SendMessageToWX.Req.WXSceneTimeline();
    }
    QCircleHostShareInvokeHelper.shareQCircleToWX(str1, str2, localBitmap, str3, str4, i);
    QLog.d("QCircleWeChatShare", 1, "shareToWeChat success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleWeChatShareOperation.4
 * JD-Core Version:    0.7.0.1
 */