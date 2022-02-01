package com.tencent.biz.qqcircle.richframework.compat;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper.SkinDownLoadLister;

class QCircleBaseActivity$SkinDownloadListener
  implements QCircleSkinHelper.SkinDownLoadLister
{
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if (QCircleBaseActivity.a(paramBoolean, paramString)) {
      RFThreadManager.getUIHandler().post(new QCircleBaseActivity.SkinDownloadListener.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity.SkinDownloadListener
 * JD-Core Version:    0.7.0.1
 */