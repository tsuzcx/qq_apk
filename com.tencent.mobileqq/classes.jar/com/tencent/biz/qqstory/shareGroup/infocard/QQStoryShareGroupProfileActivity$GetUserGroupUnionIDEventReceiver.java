package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent;
import com.tencent.biz.qqstory.shareGroup.model.GroupID;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

class QQStoryShareGroupProfileActivity$GetUserGroupUnionIDEventReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent>
{
  public QQStoryShareGroupProfileActivity$GetUserGroupUnionIDEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent paramGetUserGroupUnionIDEvent)
  {
    if ((TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.t)) && (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.v)) && (paramGetUserGroupUnionIDEvent.g.isSuccess()) && (!paramGetUserGroupUnionIDEvent.a.isEmpty()))
    {
      paramGetUserGroupUnionIDEvent = paramGetUserGroupUnionIDEvent.a.iterator();
      while (paramGetUserGroupUnionIDEvent.hasNext())
      {
        GroupID localGroupID = (GroupID)paramGetUserGroupUnionIDEvent.next();
        if (paramQQStoryShareGroupProfileActivity.v.equals(localGroupID.a))
        {
          paramQQStoryShareGroupProfileActivity.t = localGroupID.b;
          QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity) ^ true);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserGroupUnionIDHandler.GetUserGroupUnionIDEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.GetUserGroupUnionIDEventReceiver
 * JD-Core Version:    0.7.0.1
 */