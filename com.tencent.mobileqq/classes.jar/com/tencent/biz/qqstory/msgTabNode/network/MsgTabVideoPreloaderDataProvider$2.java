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
    if (this.a != null)
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
          if (i >= MsgTabVideoPreloaderDataProvider.a(this.c)) {
            break;
          }
          if ((localMsgTabVideoData != null) && (!localMsgTabVideoData.a) && (localMsgTabVideoData.e != null))
          {
            localArrayList.add(localMsgTabVideoData.e);
            i += 1;
          }
        }
      }
      this.a.a(this.b, localArrayList);
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
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.2
 * JD-Core Version:    0.7.0.1
 */