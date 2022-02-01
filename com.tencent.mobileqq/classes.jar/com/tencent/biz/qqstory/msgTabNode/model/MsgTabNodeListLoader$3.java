package com.tencent.biz.qqstory.msgTabNode.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class MsgTabNodeListLoader$3
  extends SimpleObserver<List<MsgTabVideoData>>
{
  ArrayList<String> a = new ArrayList();
  
  MsgTabNodeListLoader$3(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void a(List<MsgTabVideoData> paramList)
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onNext()");
    super.onNext(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      MsgTabVideoData localMsgTabVideoData = (MsgTabVideoData)paramList.get(i);
      if (!localMsgTabVideoData.a) {
        this.a.add(localMsgTabVideoData.c);
      }
      i += 1;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onComplete()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onComplete()");
    super.onComplete();
    this.b.a(this.a);
  }
  
  public void onError(@NonNull Error paramError)
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onError()");
    super.onError(paramError);
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.3
 * JD-Core Version:    0.7.0.1
 */