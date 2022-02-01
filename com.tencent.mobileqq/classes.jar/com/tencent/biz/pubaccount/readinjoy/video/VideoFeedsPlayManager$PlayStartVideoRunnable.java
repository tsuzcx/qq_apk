package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import sap;
import saq;
import sar;
import sfb;
import sic;
import slm;

public class VideoFeedsPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private WeakReference<sar> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<sfb> b;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, sar paramsar, sfb paramsfb, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramsar);
    this.b = new WeakReference(paramsfb);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(String paramString, long paramLong)
  {
    slm localslm = slm.a();
    localslm.a(paramString, new saq(this, paramLong, localslm));
  }
  
  private void a(sar paramsar, sfb paramsfb, long paramLong)
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.this$0);
      paramsfb.b = localVideoPreDownloadMgr.a(null, paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      localVideoPreDownloadMgr.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramsfb.b);
    }
    paramsfb.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramLong, paramsar.jdField_a_of_type_Boolean);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    sar localsar = (sar)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    sfb localsfb = (sfb)this.b.get();
    if ((!this.jdField_a_of_type_Boolean) && (!VideoFeedsPlayManager.a(this.this$0, localsfb))) {}
    label57:
    long l;
    do
    {
      do
      {
        do
        {
          break label57;
          break label57;
          do
          {
            return;
          } while ((localsar == null) || (localsfb == null) || (VideoFeedsPlayManager.e(this.this$0)));
          if (!this.jdField_a_of_type_Boolean) {
            VideoFeedsPlayManager.a(this.this$0, true);
          }
          l = localsar.jdField_a_of_type_Long;
          if (l > 0L) {
            VideoFeedsPlayManager.f(this.this$0, true);
          }
          if (localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=" + localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
          }
        } while (VideoFeedsPlayManager.a(this.this$0) == null);
        VideoFeedsPlayManager.a(this.this$0).a(localsfb, 201, 60, 0, "video info busiType error", null);
        return;
        if (sic.a(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int))
        {
          a(localsar, localsfb, l);
          return;
        }
        if ((localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 2) && ((localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)))) {
          break;
        }
        if (localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null)
        {
          a(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, l);
          return;
        }
      } while (VideoFeedsPlayManager.a(this.this$0) == null);
      VideoFeedsPlayManager.a(this.this$0).a(localsfb, 201, 61, 0, "vid null", null);
      return;
      if (localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 5) {
        break;
      }
    } while (localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null);
    Object localObject = VideoFeedsPlayManager.a(this.this$0);
    if (localObject != null)
    {
      localsfb.b = ((VideoPreDownloadMgr)localObject).a(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + " ;isPreDownloadHit: " + localsfb.b);
      }
      ((VideoPreDownloadMgr)localObject).a(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localsfb.b);
    }
    localObject = null;
    if (localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
      localObject = localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.s;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString.startsWith("http"))) {
      localObject = localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localsfb.a("", (String)localObject, 101, l, 0L, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, false, localsar.jdField_a_of_type_Boolean);
        return;
      }
      a(localsar, localsfb, l);
      return;
      if ((localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r))) {
        break;
      }
      localsfb.a("", localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, 101, l, 0L, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d, true, true, localsar.jdField_a_of_type_Boolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */