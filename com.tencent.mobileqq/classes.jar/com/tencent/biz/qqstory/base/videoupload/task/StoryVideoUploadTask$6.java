package com.tencent.biz.qqstory.base.videoupload.task;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler;
import com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed;
import com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class StoryVideoUploadTask$6
  implements CmdTaskManger.CommandCallback<PublishStoryVideoRequest, PublishStoryVideoRespond>
{
  StoryVideoUploadTask$6(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull PublishStoryVideoRequest paramPublishStoryVideoRequest, @Nullable PublishStoryVideoRespond paramPublishStoryVideoRespond, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((!paramErrorMessage.isFail()) && (paramPublishStoryVideoRespond != null))
    {
      ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).d = (paramPublishStoryVideoRespond.jdField_a_of_type_Long * 1000L);
      paramErrorMessage = ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a();
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString });
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramPublishStoryVideoRespond.c });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a(paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString);
        paramErrorMessage.setDate(paramPublishStoryVideoRespond.c);
      }
      else if (!paramErrorMessage.feedId.equals(paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString))
      {
        SLog.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString });
      }
      if (!TextUtils.isEmpty(paramPublishStoryVideoRespond.d))
      {
        ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).g = paramPublishStoryVideoRespond.d;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramPublishStoryVideoRespond.d });
      }
      if (!TextUtils.isEmpty(paramPublishStoryVideoRespond.e))
      {
        ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).g = paramPublishStoryVideoRespond.e;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramPublishStoryVideoRespond.e });
      }
      ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).b = paramPublishStoryVideoRespond.jdField_a_of_type_JavaUtilList;
      paramErrorMessage = new StringBuilder();
      paramErrorMessage.append("add to shareGroup rsp:");
      paramErrorMessage.append(((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).b);
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", paramErrorMessage.toString());
      ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).e = paramPublishStoryVideoRespond.b;
      if (this.a.a())
      {
        paramPublishStoryVideoRequest = this.a;
        paramPublishStoryVideoRequest.a(paramPublishStoryVideoRequest.jdField_a_of_type_Int, new ErrorMessage());
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo });
        if (this.a.jdField_a_of_type_Int == 7)
        {
          new DeleteStoryVideoHandler().a(((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).g);
          if (paramPublishStoryVideoRespond.jdField_a_of_type_JavaUtilList != null)
          {
            paramPublishStoryVideoRequest = paramPublishStoryVideoRespond.jdField_a_of_type_JavaUtilList.iterator();
            while (paramPublishStoryVideoRequest.hasNext())
            {
              paramPublishStoryVideoRespond = ((AddGroupVideoResponse.AddGroupFeed)paramPublishStoryVideoRequest.next()).a.values().iterator();
              while (paramPublishStoryVideoRespond.hasNext())
              {
                paramErrorMessage = (String)paramPublishStoryVideoRespond.next();
                new DeleteStoryVideoHandler().a(paramErrorMessage);
              }
            }
          }
        }
      }
      else
      {
        this.a.a(5, new ErrorMessage());
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo });
        if ((paramPublishStoryVideoRequest.a != null) && (paramPublishStoryVideoRequest.a.jdField_a_of_type_Int == 1))
        {
          int i = ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).f;
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2) {
                i = 0;
              } else {
                i = 4;
              }
            }
            else {
              i = 3;
            }
          }
          else {
            i = 2;
          }
          int j;
          if (TextUtils.isEmpty(paramPublishStoryVideoRequest.a.e)) {
            j = 2;
          } else {
            j = 1;
          }
          paramPublishStoryVideoRespond = paramPublishStoryVideoRequest.a.a();
          if (paramPublishStoryVideoRequest.e == 1) {
            paramPublishStoryVideoRequest = "2";
          } else {
            paramPublishStoryVideoRequest = "1";
          }
          StoryReportor.a("video_edit", "pub_url", j, i, new String[] { paramPublishStoryVideoRespond, "", paramPublishStoryVideoRequest });
        }
      }
    }
    else
    {
      paramErrorMessage.extraMsg = "submit";
      this.a.a(6, paramErrorMessage);
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.6
 * JD-Core Version:    0.7.0.1
 */