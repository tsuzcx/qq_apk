package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.IBatchGetVideoInfoCallback;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class VideoViewVideoHolder$VideoInfoSegment
  extends JobSegment<String, StoryVideoItem>
  implements BatchGetVideoInfo.IBatchGetVideoInfoCallback
{
  String a;
  
  private VideoViewVideoHolder$VideoInfoSegment(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  private void a(StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.mErrorCode != 0))
    {
      SLog.d(this.b.a, "showPage, show error view, because video item error code = %d", new Object[] { Integer.valueOf(paramStoryVideoItem.mErrorCode) });
      VideoViewVideoHolder.c(this.b, 4);
      VideoViewVideoHolder.a(this.b, false);
      VideoViewVideoHolder.b(this.b, paramStoryVideoItem.mErrorCode);
      notifyError(new ErrorMessage(VideoViewVideoHolder.c(this.b), "videoDeleted"));
      return;
    }
    Object localObject;
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.isBasicInfoOK()))
    {
      VideoViewVideoHolder.a(this.b, paramStoryVideoItem);
      this.b.q.setVisibility(0);
      localObject = (String)this.b.q.getTag();
      if (!TextUtils.equals(this.b.c.b, (CharSequence)localObject))
      {
        this.b.q.setTag(this.b.c.b);
        PlayModeUtils.a(this.b.q, paramStoryVideoItem.mVideoLocalThumbnailPath, paramStoryVideoItem.getThumbUrl(), VideoViewVideoHolder.d(this.b), this.b.x);
      }
      a(paramStoryVideoItem);
      return;
    }
    if (paramBoolean)
    {
      VideoViewVideoHolder.a(this.b, 3);
      this.b.t.setVisibility(8);
      this.b.p.a(8);
      this.b.q.setVisibility(8);
      this.b.r.setVisibility(8);
      VideoViewVideoHolder.a(this.b, HardCodeUtil.a(2131913629));
      paramStoryVideoItem = new ArrayList();
      paramStoryVideoItem.add(this.b.c.b);
      localObject = VideoViewVideoHolder.e(this.b);
      if (localObject != null) {
        ((BatchGetVideoInfo)localObject).a();
      }
      VideoViewVideoHolder.a(this.b, new BatchGetVideoInfo(paramStoryVideoItem));
      VideoViewVideoHolder.e(this.b).a(this);
      VideoViewVideoHolder.e(this.b).b();
      return;
    }
    a();
  }
  
  public void a()
  {
    if (isCanceled()) {
      return;
    }
    BatchGetVideoInfo localBatchGetVideoInfo = VideoViewVideoHolder.e(this.b);
    VideoViewVideoHolder.a(this.b, null);
    if (localBatchGetVideoInfo != null) {
      localBatchGetVideoInfo.a();
    }
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoInfoSegment.2(this));
  }
  
  protected void a(StoryVideoItem paramStoryVideoItem)
  {
    VideoViewVideoHolder.d(this.b, 2);
    super.notifyResult(paramStoryVideoItem);
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    VideoViewVideoHolder.d(this.b, 1);
    this.a = paramString;
    a(((StoryManager)SuperManager.a(5)).b(this.b.c.b), true);
  }
  
  public void a(ArrayList<StoryVideoItem> paramArrayList)
  {
    if (isCanceled()) {
      return;
    }
    paramArrayList = VideoViewVideoHolder.e(this.b);
    VideoViewVideoHolder.a(this.b, null);
    if (paramArrayList != null) {
      paramArrayList.a();
    }
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoInfoSegment.1(this));
  }
  
  protected void onCancel()
  {
    super.onCancel();
    SLog.b(this.b.a, "VideoInfoSegment onCancel");
    BatchGetVideoInfo localBatchGetVideoInfo = VideoViewVideoHolder.e(this.b);
    VideoViewVideoHolder.a(this.b, null);
    if (localBatchGetVideoInfo != null) {
      localBatchGetVideoInfo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment
 * JD-Core Version:    0.7.0.1
 */