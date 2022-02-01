package com.tencent.biz.qqstory.msgTabNode.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;
import java.util.List;

class MsgTabVideoPreloaderDataProvider$3
  extends SimpleObserver<List<MsgTabVideoData>>
{
  MsgTabVideoPreloaderDataProvider$3(MsgTabVideoPreloaderDataProvider paramMsgTabVideoPreloaderDataProvider, MsgTabVideoPreloaderDataProvider.DataProviderListener paramDataProviderListener, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void a(List<MsgTabVideoData> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.3
 * JD-Core Version:    0.7.0.1
 */