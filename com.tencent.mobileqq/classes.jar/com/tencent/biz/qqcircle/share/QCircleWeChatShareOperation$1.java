package com.tencent.biz.qqcircle.share;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._BaseResp.ErrCode;
import com.tencent.biz.qcircleshadow.lib.QCircleHostShareInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

class QCircleWeChatShareOperation$1
  implements QCircleWXShareListener
{
  QCircleWeChatShareOperation$1(QCircleWeChatShareOperation paramQCircleWeChatShareOperation) {}
  
  public void onWXShareResp(int paramInt, String paramString, Object paramObject)
  {
    if (QCircleWeChatShareOperation.a(this.a) != null)
    {
      if (!QCircleWeChatShareOperation.a(this.a).equals(paramObject)) {
        return;
      }
      if (paramInt == QCircleHostConstants._BaseResp.ErrCode.ERR_OK()) {
        QCircleToast.a(QCircleToast.d, HardCodeUtil.a(2131911957), 0);
      } else if (paramInt == QCircleHostConstants._BaseResp.ErrCode.ERR_USER_CANCEL()) {
        QLog.d("QCircleWeChatShare", 1, "share but user cancel");
      } else if (paramInt == QCircleHostConstants._BaseResp.ErrCode.ERR_AUTH_DENIED()) {
        QCircleToast.a(QCircleToast.c, HardCodeUtil.a(2131911955), 0);
      } else {
        QCircleToast.a(QCircleToast.c, HardCodeUtil.a(2131911955), 0);
      }
      QCircleHostShareInvokeHelper.removeWxShareObserver(QCircleWeChatShareOperation.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.QCircleWeChatShareOperation.1
 * JD-Core Version:    0.7.0.1
 */