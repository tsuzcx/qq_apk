package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import rrk;
import rrl;
import rrm;
import rwf;
import rzg;
import scq;

public class VideoFeedsPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private WeakReference<rrm> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<rwf> b;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, rrm paramrrm, rwf paramrwf, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramrrm);
    this.b = new WeakReference(paramrwf);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(String paramString, long paramLong)
  {
    scq localscq = scq.a();
    localscq.a(paramString, new rrl(this, paramLong, localscq));
  }
  
  private void a(rrm paramrrm, rwf paramrwf, long paramLong)
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.this$0);
      paramrwf.b = localVideoPreDownloadMgr.a(null, paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      localVideoPreDownloadMgr.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramrwf.b);
    }
    paramrwf.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramLong, paramrrm.jdField_a_of_type_Boolean);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    rrm localrrm = (rrm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    rwf localrwf = (rwf)this.b.get();
    if ((localrrm == null) || (localrwf == null)) {}
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
            localrwf.h();
            return;
          }
          if ((!this.jdField_a_of_type_Boolean) && (!VideoFeedsPlayManager.a(this.this$0, localrwf)))
          {
            VideoFeedsPlayManager.a(this.this$0, localrwf);
            return;
          }
          if (!this.jdField_a_of_type_Boolean) {
            VideoFeedsPlayManager.a(this.this$0, true);
          }
          l = localrrm.jdField_a_of_type_Long;
          if (l > 0L) {
            VideoFeedsPlayManager.f(this.this$0, true);
          }
          if (localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=" + localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
          }
        } while (VideoFeedsPlayManager.a(this.this$0) == null);
        VideoFeedsPlayManager.a(this.this$0).a(localrwf, 201, 60, 0, "video info busiType error", null);
        return;
        if (rzg.a(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int))
        {
          a(localrrm, localrwf, l);
          return;
        }
        if ((localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 2) && ((localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)))) {
          break;
        }
        if (localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null)
        {
          a(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, l);
          return;
        }
      } while (VideoFeedsPlayManager.a(this.this$0) == null);
      VideoFeedsPlayManager.a(this.this$0).a(localrwf, 201, 61, 0, "vid null", null);
      return;
      if (localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 5) {
        break;
      }
    } while (localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null);
    Object localObject = VideoFeedsPlayManager.a(this.this$0);
    if (localObject != null)
    {
      localrwf.b = ((VideoPreDownloadMgr)localObject).a(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + " ;isPreDownloadHit: " + localrwf.b);
      }
      ((VideoPreDownloadMgr)localObject).a(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrwf.b);
    }
    localObject = null;
    if (localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
      localObject = localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.s;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString.startsWith("http"))) {
      localObject = localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localrwf.a("", (String)localObject, 101, l, 0L, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, false, localrrm.jdField_a_of_type_Boolean);
        return;
      }
      a(localrrm, localrwf, l);
      return;
      if ((localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r))) {
        break;
      }
      localrwf.a("", localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, 101, l, 0L, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, true, localrrm.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */