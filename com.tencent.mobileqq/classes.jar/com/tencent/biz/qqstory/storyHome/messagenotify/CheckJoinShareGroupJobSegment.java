package com.tencent.biz.qqstory.storyHome.messagenotify;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.OnGetShareGroupInfoCallback;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;

public class CheckJoinShareGroupJobSegment
  extends JobSegment
  implements GetShareGroupInfoHandler.OnGetShareGroupInfoCallback
{
  MessageData a;
  
  public void a(GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    if ((paramGetShareGroupInfoEvent == null) || (paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList.jobCheck", 2, "request failed, pass as default");
      }
      notifyResult(this.a);
      return;
    }
    if (paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isInvalid())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList.jobCheck", 2, "invalid");
      }
      notifyError(new ErrorMessage(-2, ""));
      return;
    }
    if (paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList.jobCheck", 2, "public group from remote");
      }
      notifyResult(this.a);
      return;
    }
    if (paramGetShareGroupInfoEvent.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isSubscribe())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList.jobCheck", 2, "member");
      }
      notifyResult(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgList.jobCheck", 2, "guest");
    }
    notifyError(new ErrorMessage(-2, ""));
  }
  
  protected void a(JobContext paramJobContext, MessageData paramMessageData)
  {
    if (paramMessageData.e != 99)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList.jobCheck", 2, "skip");
      }
      notifyResult(paramMessageData);
      return;
    }
    paramJobContext = ((ShareGroupManager)SuperManager.a(7)).a(paramMessageData.m);
    if ((paramJobContext != null) && (paramJobContext.isPublic()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgList.jobCheck", 2, "public group from local");
      }
      notifyResult(paramMessageData);
      return;
    }
    this.a = paramMessageData;
    paramJobContext = new ArrayList();
    paramJobContext.add(paramMessageData.m);
    new GetShareGroupInfoHandler(paramJobContext, String.valueOf(System.currentTimeMillis())).a(this).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.CheckJoinShareGroupJobSegment
 * JD-Core Version:    0.7.0.1
 */