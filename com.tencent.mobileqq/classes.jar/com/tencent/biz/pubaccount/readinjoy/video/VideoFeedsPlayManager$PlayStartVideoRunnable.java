package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import rym;
import ryn;
import ryo;
import sdj;
import sgk;
import sjo;

public class VideoFeedsPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private WeakReference<ryo> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<sdj> b;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, ryo paramryo, sdj paramsdj, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramryo);
    this.b = new WeakReference(paramsdj);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(String paramString, long paramLong)
  {
    sjo localsjo = sjo.a();
    localsjo.a(paramString, new ryn(this, paramLong, localsjo));
  }
  
  private void a(ryo paramryo, sdj paramsdj, long paramLong)
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.this$0);
      paramsdj.b = localVideoPreDownloadMgr.a(null, paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      localVideoPreDownloadMgr.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramsdj.b);
    }
    paramsdj.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramLong, paramryo.jdField_a_of_type_Boolean);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    ryo localryo = (ryo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    sdj localsdj = (sdj)this.b.get();
    if ((localryo == null) || (localsdj == null)) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          if (VideoFeedsPlayManager.e(this.this$0))
          {
            localsdj.l();
            return;
          }
          if ((!this.jdField_a_of_type_Boolean) && (!VideoFeedsPlayManager.a(this.this$0, localsdj)))
          {
            VideoFeedsPlayManager.a(this.this$0, localsdj);
            return;
          }
          if (!this.jdField_a_of_type_Boolean) {
            VideoFeedsPlayManager.a(this.this$0, true);
          }
          l = localryo.jdField_a_of_type_Long;
          if (l > 0L) {
            VideoFeedsPlayManager.f(this.this$0, true);
          }
          if (localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=" + localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
          }
        } while (VideoFeedsPlayManager.a(this.this$0) == null);
        VideoFeedsPlayManager.a(this.this$0).a(localsdj, 201, 60, 0, "video info busiType error", null);
        return;
        if (sgk.a(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int))
        {
          a(localryo, localsdj, l);
          return;
        }
        if ((localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 2) && ((localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)))) {
          break;
        }
        if (localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null)
        {
          a(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, l);
          return;
        }
      } while (VideoFeedsPlayManager.a(this.this$0) == null);
      VideoFeedsPlayManager.a(this.this$0).a(localsdj, 201, 61, 0, "vid null", null);
      return;
      if (localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 5) {
        break;
      }
    } while (localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null);
    Object localObject = VideoFeedsPlayManager.a(this.this$0);
    if (localObject != null)
    {
      localsdj.b = ((VideoPreDownloadMgr)localObject).a(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + " ;isPreDownloadHit: " + localsdj.b);
      }
      ((VideoPreDownloadMgr)localObject).a(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localsdj.b);
    }
    localObject = null;
    if (localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
      localObject = localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.s;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString.startsWith("http"))) {
      localObject = localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localsdj.a("", (String)localObject, 101, l, 0L, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, false, localryo.jdField_a_of_type_Boolean);
        return;
      }
      a(localryo, localsdj, l);
      return;
      if ((localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r))) {
        break;
      }
      localsdj.a("", localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, 101, l, 0L, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, true, localryo.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */