package com.tencent.biz.pubaccount.readinjoy.ugc.editvideo;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

final class PublishVideoHelper$2
  extends ProtoUtils.TroopProtocolObserver
{
  PublishVideoHelper$2(PublishVideoHelper.IMoveUgcVideoCallback paramIMoveUgcVideoCallback, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback.a(paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback =" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback);
      }
    }
    for (;;)
    {
      ReadInJoyLogicEngineEventDispatcher.a().e(this.jdField_a_of_type_Int);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback is null.");
      }
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoPublishVideoHelper$IMoveUgcVideoCallback.a(paramInt, paramString);
    }
    QLog.e("RIJUGC.PublishVideoHelper", 1, "moveVideo: columnId = " + this.jdField_a_of_type_Int + "errorCode = " + paramInt + ",errorMsg =" + paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper.2
 * JD-Core Version:    0.7.0.1
 */