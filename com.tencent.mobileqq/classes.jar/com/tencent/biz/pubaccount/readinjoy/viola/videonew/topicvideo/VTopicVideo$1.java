package com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo;

import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView.OnVideoViewLifeCycleChangeListener;
import com.tencent.viola.core.dispatch.ComponentAppearEvent;
import com.tencent.viola.core.dispatch.IEvent;
import com.tencent.viola.core.dispatch.IObserver;

class VTopicVideo$1
  implements IObserver
{
  VTopicVideo$1(VTopicVideo paramVTopicVideo) {}
  
  public String getRef()
  {
    return this.a.getRef();
  }
  
  public void onReceive(IEvent paramIEvent)
  {
    if ((paramIEvent.getRef().equals(this.a.getRef())) && (this.a.getVideoLifeCycleChangeListener() != null))
    {
      paramIEvent = (ComponentAppearEvent)paramIEvent;
      if (!paramIEvent.event.equals("didDisappear")) {
        break label59;
      }
      this.a.getVideoLifeCycleChangeListener().J_();
    }
    label59:
    do
    {
      return;
      if (paramIEvent.event.equals("willAppear"))
      {
        this.a.getVideoLifeCycleChangeListener().H_();
        return;
      }
    } while (!paramIEvent.event.equals("didAppear"));
    this.a.getVideoLifeCycleChangeListener().I_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.VTopicVideo.1
 * JD-Core Version:    0.7.0.1
 */