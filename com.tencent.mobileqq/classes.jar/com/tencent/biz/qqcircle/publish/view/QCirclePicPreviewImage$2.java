package com.tencent.biz.qqcircle.publish.view;

import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;

class QCirclePicPreviewImage$2
  extends QCirclePicStateListener
{
  QCirclePicPreviewImage$2(QCirclePicPreviewImage paramQCirclePicPreviewImage, String paramString) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    paramOption = new StringBuilder();
    paramOption.append("path:");
    paramOption.append(this.a);
    paramOption.append("state callback:");
    paramOption.append(paramInt);
    QLog.d("QCirclePicPreviewImage", 1, paramOption.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.QCirclePicPreviewImage.2
 * JD-Core Version:    0.7.0.1
 */