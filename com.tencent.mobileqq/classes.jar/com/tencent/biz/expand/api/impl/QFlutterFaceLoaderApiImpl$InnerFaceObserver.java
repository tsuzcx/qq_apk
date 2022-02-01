package com.tencent.biz.expand.api.impl;

import android.graphics.Bitmap;
import com.tencent.biz.expand.api.IQFlutterFaceLoaderApi.ApiFaceObserver;
import com.tencent.mobileqq.flutter.qqface.DecodeRequest;
import com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.FaceObserver;

public class QFlutterFaceLoaderApiImpl$InnerFaceObserver
  implements QFlutterFaceLoader.FaceObserver
{
  private IQFlutterFaceLoaderApi.ApiFaceObserver jdField_a_of_type_ComTencentBizExpandApiIQFlutterFaceLoaderApi$ApiFaceObserver;
  
  public QFlutterFaceLoaderApiImpl$InnerFaceObserver(QFlutterFaceLoaderApiImpl paramQFlutterFaceLoaderApiImpl, IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver)
  {
    this.jdField_a_of_type_ComTencentBizExpandApiIQFlutterFaceLoaderApi$ApiFaceObserver = paramApiFaceObserver;
  }
  
  public void onFaceUpdate(DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizExpandApiIQFlutterFaceLoaderApi$ApiFaceObserver != null) {
      this.jdField_a_of_type_ComTencentBizExpandApiIQFlutterFaceLoaderApi$ApiFaceObserver.onFaceUpdate(this.jdField_a_of_type_ComTencentBizExpandApiImplQFlutterFaceLoaderApiImpl.convert2Api(paramDecodeRequest), paramBitmap, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.impl.QFlutterFaceLoaderApiImpl.InnerFaceObserver
 * JD-Core Version:    0.7.0.1
 */