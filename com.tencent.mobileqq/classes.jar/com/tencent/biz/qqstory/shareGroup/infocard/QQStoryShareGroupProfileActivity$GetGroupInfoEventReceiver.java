package com.tencent.biz.qqstory.shareGroup.infocard;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class QQStoryShareGroupProfileActivity$GetGroupInfoEventReceiver
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, GetShareGroupInfoHandler.GetShareGroupInfoEvent>
{
  public QQStoryShareGroupProfileActivity$GetGroupInfoEventReceiver(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.s, paramGetShareGroupInfoEvent.a)) {
      return;
    }
    if ((paramGetShareGroupInfoEvent.g.isSuccess()) && (paramGetShareGroupInfoEvent.b != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update sharegroup info: ");
        localStringBuilder.append(paramGetShareGroupInfoEvent.b.toString());
        QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, localStringBuilder.toString());
      }
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramGetShareGroupInfoEvent.b);
      return;
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramGetShareGroupInfoEvent);
  }
  
  public Class acceptEventClass()
  {
    return GetShareGroupInfoHandler.GetShareGroupInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.GetGroupInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */