package com.tencent.biz.qqcircle.fragments.content;

import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.mobileqq.qcircle.api.data.Option;
import java.lang.ref.WeakReference;

class QCircleContentImage$UpdateConfigStick
  implements Runnable
{
  private WeakReference<Option> a;
  private WeakReference<QCircleContentImage> b;
  private FeedBlockData c;
  private int d;
  
  public QCircleContentImage$UpdateConfigStick(QCircleContentImage paramQCircleContentImage, FeedBlockData paramFeedBlockData, Option paramOption, int paramInt)
  {
    this.c = paramFeedBlockData;
    this.a = new WeakReference(paramOption);
    this.b = new WeakReference(paramQCircleContentImage);
    this.d = paramInt;
  }
  
  public void run()
  {
    Object localObject = this.b;
    Option localOption = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QCircleContentImage)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      localOption = (Option)localWeakReference.get();
    }
    if (localOption == null) {
      return;
    }
    QCircleContentImage.a((QCircleContentImage)localObject, this.c, localOption, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentImage.UpdateConfigStick
 * JD-Core Version:    0.7.0.1
 */