package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QCircleContentImage$QCirclePicStateListenerImpl
  extends QCirclePicStateListener
{
  private FeedBlockData a;
  private int b;
  private WeakReference<QCircleContentImage> c;
  
  public QCircleContentImage$QCirclePicStateListenerImpl(FeedBlockData paramFeedBlockData, int paramInt, QCircleContentImage paramQCircleContentImage)
  {
    this.a = paramFeedBlockData;
    this.b = paramInt;
    this.c = new WeakReference(paramQCircleContentImage);
  }
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    super.onStateChang(paramInt, paramOption);
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QCircleContentImage)((WeakReference)localObject).get();
    }
    if (localObject != null)
    {
      QCircleContentImage.a((QCircleContentImage)localObject, paramInt, paramOption, this.a, this.b);
      return;
    }
    QLog.d("QCirclePicStateListenerImpl", 1, "[onStateChang] content image should not be null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage.QCirclePicStateListenerImpl
 * JD-Core Version:    0.7.0.1
 */