package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import sko;
import skp;
import skq;
import spn;
import sqb;
import ssp;
import swx;
import sxc;

public class VideoFeedsPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private WeakReference<skq> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<spn> b;
  
  public VideoFeedsPlayManager$PlayStartVideoRunnable(VideoFeedsPlayManager paramVideoFeedsPlayManager, skq paramskq, spn paramspn, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramskq);
    this.b = new WeakReference(paramspn);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(String paramString, long paramLong)
  {
    swx localswx = swx.a();
    localswx.a(paramString, new skp(this, paramLong, localswx));
  }
  
  private void a(skq paramskq, spn paramspn, long paramLong)
  {
    if (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable Error : busiType = 0, msg = null, vid=" + paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).a(paramspn, 201, 60, 0, "video info busiType error", null);
      }
    }
    do
    {
      do
      {
        return;
        if (ssp.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int))
        {
          c(paramskq, paramspn, paramLong);
          return;
        }
        if (!ssp.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int, paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        if (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null)
        {
          a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramLong);
          return;
        }
      } while (VideoFeedsPlayManager.a(this.this$0) == null);
      VideoFeedsPlayManager.a(this.this$0).a(paramspn, 201, 61, 0, "vid null", null);
      return;
      if (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 5)
      {
        b(paramskq, paramspn, paramLong);
        return;
      }
    } while ((paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r)));
    paramspn.a("", paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, 101, paramLong, 0L, paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, true, true, paramskq.jdField_a_of_type_Boolean);
  }
  
  private void a(skq paramskq, spn paramspn, sxc paramsxc, swx paramswx)
  {
    boolean bool = true;
    int j = 0;
    int i;
    if (paramsxc.jdField_a_of_type_Boolean)
    {
      i = 1;
      paramspn.jdField_b_of_type_Int = i;
      if (paramskq.jdField_a_of_type_Rqa != null)
      {
        paramskq.jdField_a_of_type_Rqa.jdField_j_of_type_Long = paramswx.a.longValue();
        paramskq.jdField_a_of_type_Rqa.jdField_e_of_type_Int = paramsxc.jdField_d_of_type_Int;
        paramskq.jdField_a_of_type_Rqa.d = paramsxc.jdField_a_of_type_Boolean;
        paramskq.jdField_a_of_type_Rqa.jdField_e_of_type_JavaLangString = paramsxc.c;
        paramskq.jdField_a_of_type_Rqa.jdField_e_of_type_Boolean = paramsxc.jdField_b_of_type_Boolean;
        paramskq.jdField_a_of_type_Rqa.jdField_f_of_type_Boolean = false;
        paramskq.jdField_a_of_type_Rqa.jdField_f_of_type_JavaLangString = "";
        paramskq.jdField_a_of_type_Rqa.jdField_j_of_type_JavaLangString = paramsxc.jdField_d_of_type_JavaLangString;
        paramspn = paramskq.jdField_a_of_type_Rqa;
        if (TextUtils.isEmpty(paramsxc.jdField_e_of_type_JavaLangString)) {
          break label237;
        }
      }
    }
    for (;;)
    {
      paramspn.jdField_h_of_type_Boolean = bool;
      try
      {
        paramsxc = new URL(paramsxc.jdField_a_of_type_JavaLangString).getHost();
        paramspn = InnerDns.getInstance().reqDnsForIpList(paramsxc, 1006);
        paramswx = paramskq.jdField_a_of_type_Rqa;
        if (paramspn == null)
        {
          i = j;
          paramswx.r = i;
          paramswx = paramskq.jdField_a_of_type_Rqa;
          if (paramspn != null) {
            break label221;
          }
        }
        label221:
        for (paramspn = "";; paramspn = paramspn.toString())
        {
          paramswx.i = paramspn;
          paramskq.jdField_a_of_type_Rqa.jdField_h_of_type_JavaLangString = paramsxc;
          return;
          i = paramspn.size();
          break;
        }
        return;
      }
      catch (Exception paramskq) {}
      i = 0;
      break;
      label237:
      bool = false;
    }
  }
  
  private boolean a(skq paramskq, spn paramspn)
  {
    if ((paramskq == null) || (paramspn == null)) {
      return false;
    }
    if (VideoFeedsPlayManager.e(this.this$0))
    {
      paramspn.l();
      return false;
    }
    if ((!this.jdField_a_of_type_Boolean) && (!VideoFeedsPlayManager.a(this.this$0, paramspn)))
    {
      VideoFeedsPlayManager.a(this.this$0, paramspn);
      return false;
    }
    return true;
  }
  
  private boolean a(sxc paramsxc, spn paramspn)
  {
    if (paramsxc.jdField_d_of_type_Int == 2) {
      if (VideoFeedsPlayManager.a(this.this$0) != null) {
        VideoFeedsPlayManager.a(this.this$0).a(paramspn, 202, 108, 0, "vid2url failed, video deleted", null);
      }
    }
    do
    {
      return false;
      if (!TextUtils.isEmpty(paramsxc.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (VideoFeedsPlayManager.a(this.this$0) == null);
    VideoFeedsPlayManager.a(this.this$0).a(paramspn, 202, 107, 0, "vid2url failed, get null", null);
    return false;
    return true;
  }
  
  private void b(skq paramskq, spn paramspn, long paramLong)
  {
    if (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    Object localObject = VideoFeedsPlayManager.a(this.this$0);
    if (localObject != null)
    {
      paramspn.jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject).a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "广告视频预下载: url:" + paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + " ;isPreDownloadHit: " + paramspn.jdField_b_of_type_Boolean);
      }
      ((VideoPreDownloadMgr)localObject).a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramspn.jdField_b_of_type_Boolean);
    }
    localObject = null;
    if (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) {
      localObject = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.s;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString.startsWith("http"))) {
      localObject = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramspn.a("", (String)localObject, 101, paramLong, 0L, paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int, true, false, paramskq.jdField_a_of_type_Boolean);
        return;
      }
      c(paramskq, paramspn, paramLong);
      return;
    }
  }
  
  private void c(skq paramskq, spn paramspn, long paramLong)
  {
    if (VideoFeedsPlayManager.a(this.this$0) != null)
    {
      VideoPreDownloadMgr localVideoPreDownloadMgr = VideoFeedsPlayManager.a(this.this$0);
      paramspn.jdField_b_of_type_Boolean = localVideoPreDownloadMgr.a(null, paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      localVideoPreDownloadMgr.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramspn.jdField_b_of_type_Boolean);
    }
    paramspn.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 1, paramLong, paramskq.jdField_a_of_type_Boolean);
  }
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    skq localskq = (skq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    spn localspn = (spn)this.b.get();
    if (!a(localskq, localspn))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "PlayStartVideoRunnable: checkVideoStatus error return");
      }
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      VideoFeedsPlayManager.a(this.this$0, true);
    }
    long l2 = localskq.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = sqb.a.a(localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.this$0;
    if (l1 > 0L) {}
    for (;;)
    {
      VideoFeedsPlayManager.f(localVideoFeedsPlayManager, bool);
      a(localskq, localspn, l1);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */