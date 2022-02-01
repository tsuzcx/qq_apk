package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge.Callback;

class QQUrlImageBridgeImpl$1
  implements IBitmapCallback
{
  QQUrlImageBridgeImpl$1(QQUrlImageBridgeImpl paramQQUrlImageBridgeImpl, QQUrlImageBridge.Callback paramCallback) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQUrlImageBridge$Callback != null) {
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQUrlImageBridge$Callback.onSuccess(paramCloseableBitmap.a());
    }
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQUrlImageBridge$Callback != null) {
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQUrlImageBridge$Callback.onFail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQUrlImageBridgeImpl.1
 * JD-Core Version:    0.7.0.1
 */