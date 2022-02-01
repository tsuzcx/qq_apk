package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowRecommendPopupCommand;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsRecommendFragment$RIJObserver
  extends ReadInJoyObserver
{
  private VideoFeedsRecommendFragment$RIJObserver(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onQueryContentCoinNumResult: success=" + paramBoolean + ", retCode=" + paramBoolean + ", retMsg=" + paramString1 + ", rowkey=" + paramString2 + ", coinNum=" + paramInt2);
    }
    if (paramBoolean)
    {
      paramString1 = VideoFeedsRecommendFragment.a(this.a).iterator();
      while (paramString1.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramString1.next();
        if ((!TextUtils.isEmpty(localVideoInfo.g)) && (localVideoInfo.g.equals(paramString2)))
        {
          localVideoInfo.jdField_p_of_type_Int = paramInt2;
          VideoFeedsRecommendFragment.a(this.a).a(localVideoInfo);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCheckContentHasCoinResult: success=" + paramBoolean1 + ", retCode=" + paramBoolean1 + ", retMsg=" + paramString1 + ", rowkey=" + paramString2 + ", hasCoin=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      paramString1 = VideoFeedsRecommendFragment.a(this.a).iterator();
      while (paramString1.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramString1.next();
        if ((!TextUtils.isEmpty(localVideoInfo.g)) && (localVideoInfo.g.equals(paramString2)))
        {
          localVideoInfo.o = paramBoolean2;
          localVideoInfo.jdField_p_of_type_Boolean = true;
          if (localVideoInfo == this.a.b()) {
            VideoFeedsRecommendFragment.a(this.a).a(localVideoInfo, "0X800B2EA");
          }
          VideoFeedsRecommendFragment.a(this.a).a(localVideoInfo);
        }
      }
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    try
    {
      RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
      localRecommendFollowInfo.uin = paramLong;
      localRecommendFollowInfo.isFollowed = paramBoolean;
      SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(2, localRecommendFollowInfo));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoFeedsRecommendFragment", 2, "run: CheckAccountFollowedRunnable", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.RIJObserver
 * JD-Core Version:    0.7.0.1
 */