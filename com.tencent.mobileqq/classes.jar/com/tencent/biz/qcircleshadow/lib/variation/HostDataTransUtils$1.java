package com.tencent.biz.qcircleshadow.lib.variation;

import android.graphics.Bitmap;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;

final class HostDataTransUtils$1
  implements DecodeTaskCompletionListener
{
  HostDataTransUtils$1(QCircleFaceBitmapListener paramQCircleFaceBitmapListener, IFaceDecoder paramIFaceDecoder) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.d("HostDataTransUtils", 1, "shareToWeChat share user icon(need decode task)  onDecodeTaskCompleted");
    this.val$listener.getFaceBitmap(paramBitmap);
    this.val$faceDecoder.setDecodeTaskCompletionListener(null);
    this.val$faceDecoder.destory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils.1
 * JD-Core Version:    0.7.0.1
 */