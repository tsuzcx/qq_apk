package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

class QQStoryShareGroupProfileActivity$GetSimpleInfoListEventReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, VidToSimpleInfoHandler.GetSimpleInfoListEvent>
{
  public QQStoryShareGroupProfileActivity$GetSimpleInfoListEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    if (paramGetSimpleInfoListEvent.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramGetSimpleInfoListEvent);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToSimpleInfoHandler.GetSimpleInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.GetSimpleInfoListEventReceiver
 * JD-Core Version:    0.7.0.1
 */