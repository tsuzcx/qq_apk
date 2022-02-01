package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoPlayRecommendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class VideoFullPlayController$VideoRecommendObserver
  extends VideoPlayRecommendObserver
{
  private VideoFullPlayController$VideoRecommendObserver(VideoFullPlayController paramVideoFullPlayController) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "onGetRecommend:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      VideoFullPlayController.a(this.a).addAll(VideoFullPlayController.a(this.a).a(paramBundle));
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFullPlayController.VideoRecommendObserver
 * JD-Core Version:    0.7.0.1
 */