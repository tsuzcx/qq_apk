package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MsgTabPlayPageLoader$MsgTabVidSyncer$1
  extends SimpleObserver<List<MsgTabVideoData>>
{
  MsgTabPlayPageLoader$MsgTabVidSyncer$1(MsgTabPlayPageLoader.MsgTabVidSyncer paramMsgTabVidSyncer, IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack) {}
  
  public void a(List<MsgTabVideoData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.b));
    localGroupInfo.c = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MsgTabVideoData localMsgTabVideoData = (MsgTabVideoData)localIterator.next();
      String str = localMsgTabVideoData.b;
      localGroupInfo.d.put(localMsgTabVideoData.c, str);
      localGroupInfo.c.add(localMsgTabVideoData.c);
    }
    paramList = MsgTabPlayPageLoader.b(paramList);
    if ((paramList != null) && (!MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.b).b())) {
      localGroupInfo.f = paramList.c;
    }
    localArrayList.add(localGroupInfo);
    this.a.a(localArrayList, MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.b).b() ^ true);
  }
  
  public void onError(@NonNull Error paramError)
  {
    int i;
    if ((paramError instanceof ErrorMessage)) {
      i = ((ErrorMessage)paramError).errorCode;
    } else {
      i = 0;
    }
    paramError = new ArrayList();
    paramError.add(MsgTabPlayPageLoader.MsgTabVidSyncer.a(this.b));
    this.a.a(new ErrorMessage(i, "fail"), paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayPageLoader.MsgTabVidSyncer.1
 * JD-Core Version:    0.7.0.1
 */