package com.tencent.biz.qqstory.msgTabNode.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class MsgTabVideoPreloaderDataProvider$2
  extends SimpleObserver<List<MsgTabVideoData>>
{
  MsgTabVideoPreloaderDataProvider$2(MsgTabVideoPreloaderDataProvider paramMsgTabVideoPreloaderDataProvider, MsgTabVideoPreloaderDataProvider.DataProviderListener paramDataProviderListener, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void a(List<MsgTabVideoData> paramList)
  {
    super.onNext(paramList);
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new MsgTabVideoPreloaderDataProvider.2.1(this));
        int i = 0;
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MsgTabVideoData localMsgTabVideoData = (MsgTabVideoData)paramList.next();
          if (i >= MsgTabVideoPreloaderDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider)) {
            break;
          }
          if ((localMsgTabVideoData != null) && (!localMsgTabVideoData.jdField_a_of_type_Boolean) && (localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
          {
            localArrayList.add(localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
            i += 1;
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, localArrayList);
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    MsgTabVideoPreloaderDataProvider.DataProviderListener localDataProviderListener = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener;
    if (localDataProviderListener != null) {
      localDataProviderListener.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.2
 * JD-Core Version:    0.7.0.1
 */