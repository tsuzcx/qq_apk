package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertConfig;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDynamicInsertController;", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "videoPlayController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "requestInsertSet", "", "getRequestInsertSet", "()Ljava/util/Set;", "setRequestInsertSet", "(Ljava/util/Set;)V", "getVideoPlayController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "watchInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getWatchInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "getWatchProgressByRowkey", "rowKey", "hasRequestInsertCard", "", "onStateChanged", "", "oldState", "newState", "requestControllInfo", "delayTime", "updateProgress", "progress", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoDynamicInsertController
  implements VideoPlayController.OnStateChangeListener
{
  @Nullable
  private VideoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private Set<String> jdField_a_of_type_JavaUtilSet;
  @NotNull
  private final ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public VideoDynamicInsertController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController = paramVideoPlayController;
    this.jdField_a_of_type_JavaLangString = "VideoDynamicInsertController";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = SetsKt.emptySet();
    paramVideoPlayController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  private final int a(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {}
    for (;;)
    {
      return paramString.intValue();
      paramString = Integer.valueOf(-1);
    }
  }
  
  private final boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  private final void b(int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("requestControllInfo delayTime:").append(paramInt).append(", rowKey: ");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
    if (localObject != null)
    {
      localObject = ((VideoPlayController)localObject).a();
      if (localObject == null) {}
    }
    for (localObject = ((BaseArticleInfo)localObject).innerUniqueID;; localObject = null)
    {
      QLog.d(str, 1, (String)localObject);
      ThreadManager.a().postDelayed((Runnable)new VideoDynamicInsertController.requestControllInfo.1(this), paramInt);
      return;
    }
  }
  
  @Nullable
  public final VideoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final ConcurrentHashMap<String, Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public final void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
    RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController;
    if (localObject != null)
    {
      localObject = ((VideoPlayController)localObject).a();
      if (localObject != null)
      {
        localObject = ((BaseArticleInfo)localObject).innerUniqueID;
        int i = a((String)localObject);
        if ((localObject != null) && (i != -1) && (paramInt >= i) && (!a((String)localObject)))
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 1, "updateProgress: " + paramInt + ", actionProgress: " + i);
          this.jdField_a_of_type_JavaUtilSet = SetsKt.plus(this.jdField_a_of_type_JavaUtilSet, localObject);
          localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.a;
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
          if (localObject == null) {
            break label146;
          }
        }
      }
    }
    label146:
    for (localObject = ((VideoPlayController)localObject).a();; localObject = null)
    {
      localRIJFeedsDynamicInsertController.a((BaseArticleInfo)localObject, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_VIDEO_PLAY_PROGRESS, paramInt, 0, 0, 12, null));
      return;
      localObject = null;
      break;
    }
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
      if (localObject != null)
      {
        localObject = ((VideoPlayController)localObject).a();
        if ((localObject != null) && ((int)((BaseArticleInfo)localObject).mChannelID == 0))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController;
          if (localObject != null)
          {
            localObject = ((VideoPlayController)localObject).a();
            if (localObject == null) {}
          }
          for (localObject = ((BaseArticleInfo)localObject).innerUniqueID; a((String)localObject) == -1; localObject = null)
          {
            b(RIJFeedsDynamicInsertConfig.a.a(1));
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoDynamicInsertController
 * JD-Core Version:    0.7.0.1
 */