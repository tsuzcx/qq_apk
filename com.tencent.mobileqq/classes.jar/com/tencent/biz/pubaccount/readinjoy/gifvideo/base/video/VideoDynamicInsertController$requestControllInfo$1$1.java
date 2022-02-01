package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController.IWatchInfoCallback;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDynamicInsertController$requestControllInfo$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertController$IWatchInfoCallback;", "getWatchInfo", "", "rowKey", "", "action", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertAction;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoDynamicInsertController$requestControllInfo$1$1
  implements RIJFeedsDynamicInsertController.IWatchInfoCallback
{
  public void a(@Nullable String paramString, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    QLog.d(this.a.this$0.a(), 1, "getWatchInfo rowKey: " + paramString + ", action: " + paramRIJFeedsInsertAction);
    if (paramRIJFeedsInsertAction.a() == RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS)
    {
      localObject = this.a.this$0.a();
      if (localObject == null) {
        break label154;
      }
      localObject = ((VideoPlayController)localObject).a();
      if (localObject == null) {
        break label154;
      }
    }
    label154:
    for (Object localObject = ((BaseArticleInfo)localObject).innerUniqueID;; localObject = null)
    {
      if (Intrinsics.areEqual(paramString, localObject))
      {
        paramString = this.a.this$0.a();
        if (paramString != null)
        {
          paramString = paramString.a();
          if (paramString != null)
          {
            paramString = paramString.innerUniqueID;
            if (paramString != null) {
              paramString = (Integer)this.a.this$0.a().put(paramString, Integer.valueOf(paramRIJFeedsInsertAction.a()));
            }
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoDynamicInsertController.requestControllInfo.1.1
 * JD-Core Version:    0.7.0.1
 */