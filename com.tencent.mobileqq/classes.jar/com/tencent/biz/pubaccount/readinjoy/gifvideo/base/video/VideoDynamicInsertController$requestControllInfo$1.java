package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController.IWatchInfoCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoDynamicInsertController$requestControllInfo$1
  implements Runnable
{
  VideoDynamicInsertController$requestControllInfo$1(VideoDynamicInsertController paramVideoDynamicInsertController) {}
  
  public final void run()
  {
    QLog.d(this.this$0.a(), 1, "requestControllInfo preloadWatchInfoInMainFeeds");
    RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.a;
    Object localObject = this.this$0.a();
    if (localObject != null) {}
    for (localObject = ((VideoPlayController)localObject).a();; localObject = null)
    {
      localRIJFeedsDynamicInsertController.a((BaseArticleInfo)localObject, 1, (RIJFeedsDynamicInsertController.IWatchInfoCallback)new VideoDynamicInsertController.requestControllInfo.1.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoDynamicInsertController.requestControllInfo.1
 * JD-Core Version:    0.7.0.1
 */