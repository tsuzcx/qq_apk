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
      ((StoryVideoTaskInfo)this.a.b).q = (paramPublishStoryVideoRespond.a * 1000L);
      paramErrorMessage = ((StoryVideoTaskInfo)this.a.b).b();
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramPublishStoryVideoRespond.b });
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramErrorMessage.date, paramPublishStoryVideoRespond.e });
      if (paramErrorMessage.isFakeFeedItem())
      {
        ((StoryVideoTaskInfo)this.a.b).a(paramPublishStoryVideoRespond.b);
        paramErrorMessage.setDate(paramPublishStoryVideoRespond.e);
      }
      else if (!paramErrorMessage.feedId.equals(paramPublishStoryVideoRespond.b))
      {
        SLog.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramErrorMessage.feedId, paramPublishStoryVideoRespond.b });
      }
      if (!TextUtils.isEmpty(paramPublishStoryVideoRespond.f))
      {
        ((StoryVideoTaskInfo)this.a.b).s = paramPublishStoryVideoRespond.f;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramPublishStoryVideoRespond.f });
      }
      if (!TextUtils.isEmpty(paramPublishStoryVideoRespond.h))
      {
        ((StoryVideoTaskInfo)this.a.b).s = paramPublishStoryVideoRespond.h;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramPublishStoryVideoRespond.h });
      }
      ((StoryVideoTaskInfo)this.a.b).z = paramPublishStoryVideoRespond.i;
      paramErrorMessage = new StringBuilder();
      paramErrorMessage.append("add to shareGroup rsp:");
      paramErrorMessage.append(((StoryVideoTaskInfo)this.a.b).z);
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", paramErrorMessage.toString());
      ((StoryVideoTaskInfo)this.a.b).A = paramPublishStoryVideoRespond.g;
      if (this.a.d())
      {
        paramPublishStoryVideoRequest = this.a;
        paramPublishStoryVideoRequest.a(paramPublishStoryVideoRequest.d, new ErrorMessage());
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.b });
        if (this.a.d == 7)
        {
          new DeleteStoryVideoHandler().a(((StoryVideoTaskInfo)this.a.b).s);
          if (paramPublishStoryVideoRespond.i != null)
          {
            paramPublishStoryVideoRequest = paramPublishStoryVideoRespond.i.iterator();
            while (paramPublishStoryVideoRequest.hasNext())
            {
              paramPublishStoryVideoRespond = ((AddGroupVideoResponse.AddGroupFeed)paramPublishStoryVideoRequest.next()).c.values().iterator();
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
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.b });
        if ((paramPublishStoryVideoRequest.R != null) && (paramPublishStoryVideoRequest.R.a == 1))
        {
          int i = ((StoryVideoTaskInfo)this.a.b).E;
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
          if (TextUtils.isEmpty(paramPublishStoryVideoRequest.R.f)) {
            j = 2;
          } else {
            j = 1;
          }
          paramPublishStoryVideoRespond = paramPublishStoryVideoRequest.R.a();
          if (paramPublishStoryVideoRequest.w == 1) {
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
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.6
 * JD-Core Version:    0.7.0.1
 */