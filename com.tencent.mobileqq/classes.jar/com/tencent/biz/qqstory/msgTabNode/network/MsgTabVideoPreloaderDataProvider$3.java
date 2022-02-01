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
    paramList = this.a;
    if (paramList != null) {
      paramList.a(this.b, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    MsgTabVideoPreloaderDataProvider.DataProviderListener localDataProviderListener = this.a;
    if (localDataProviderListener != null) {
      localDataProviderListener.a(this.b, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.3
 * JD-Core Version:    0.7.0.1
 */