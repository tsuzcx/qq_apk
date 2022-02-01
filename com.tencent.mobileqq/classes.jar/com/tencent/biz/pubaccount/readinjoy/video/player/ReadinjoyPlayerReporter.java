package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class ReadinjoyPlayerReporter
  extends IPlayerReporter
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<ReadinjoyPlayerReporter.ReportInfoAction> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public ReadinjoyVideoReportData a;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private ReadinjoyPlayerReporter.ReportDelegate jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadinjoyPlayerReporter$ReportDelegate;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ReadinjoyPlayerReporter(int paramInt, ReadinjoyPlayerReporter.ReportDelegate paramReportDelegate)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = new ReadinjoyVideoReportData();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadinjoyPlayerReporter$ReportDelegate = paramReportDelegate;
    b();
  }
  
  private void a(ReadinjoyVideoReportData paramReadinjoyVideoReportData)
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, paramReadinjoyVideoReportData), 16, null, true);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramString2, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyPlayerReporter", 2, "视频预下载: url:" + paramString1 + " ;isPreDownloadHit: " + this.jdField_b_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramString1, this.jdField_b_of_type_Boolean);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(112, new ReadinjoyPlayerReporter.BufferingStartAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(113, new ReadinjoyPlayerReporter.BufferingEndAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(28, new ReadinjoyPlayerReporter.DecoderBlockAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(40, new ReadinjoyPlayerReporter.SkipOneFrameAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new ReadinjoyPlayerReporter.HWDecodeFailedAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(41, new ReadinjoyPlayerReporter.HWBackupUrlAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(42, new ReadinjoyPlayerReporter.PreForManceReportAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(208, new ReadinjoyPlayerReporter.ObjectMediaCodecInfoAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(105, new ReadinjoyPlayerReporter.FirstVideoFrameRenderedAction(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(209, new ReadinjoyPlayerReporter.VideoFrameCheckInfoAction(this));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = new ReadinjoyVideoReportData();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadinjoyPlayerReporter$ReportDelegate != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadinjoyPlayerReporter$ReportDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    ReadinjoyPlayerReporter.ReportInfoAction localReportInfoAction = (ReadinjoyPlayerReporter.ReportInfoAction)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localReportInfoAction != null) {
      localReportInfoAction.a(paramInt, paramObject);
    }
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Int = paramVideoPlayerWrapper.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_m_of_type_Int = paramVideoPlayerWrapper.c();
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = paramVideoPlayerWrapper.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Int = paramVideoPlayerWrapper.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Long = paramVideoPlayerWrapper.c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Int = paramVideoPlayerWrapper.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Boolean = paramVideoPlayerWrapper.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Long = paramVideoPlayerWrapper.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Long = paramVideoPlayerWrapper.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Long = paramVideoPlayerWrapper.g();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long == 0L))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.t = BandwidthPredictor.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_m_of_type_JavaLangString = VideoBufferRangeController.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l = paramVideoPlayerWrapper.p();
    paramVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.b());
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData);
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_j_of_type_Long = ThirdVideoManager.a().a.longValue();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_Int = paramVideoUrlInfo.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Boolean = paramVideoUrlInfo.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_JavaLangString = paramVideoUrlInfo.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_Boolean = paramVideoUrlInfo.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_j_of_type_JavaLangString = paramVideoUrlInfo.jdField_d_of_type_JavaLangString;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    boolean bool;
    if (!TextUtils.isEmpty(paramVideoUrlInfo.jdField_e_of_type_JavaLangString)) {
      bool = true;
    }
    for (;;)
    {
      ((ReadinjoyVideoReportData)localObject).jdField_h_of_type_Boolean = bool;
      try
      {
        localObject = new URL(paramVideoUrlInfo.jdField_a_of_type_JavaLangString).getHost();
        paramVideoUrlInfo = InnerDns.getInstance().reqDnsForIpList((String)localObject, 1006);
        ReadinjoyVideoReportData localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        if (paramVideoUrlInfo == null)
        {
          localReadinjoyVideoReportData.s = i;
          localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          if (paramVideoUrlInfo != null) {
            break label195;
          }
        }
        label195:
        for (paramVideoUrlInfo = "";; paramVideoUrlInfo = paramVideoUrlInfo.toString())
        {
          localReadinjoyVideoReportData.jdField_i_of_type_JavaLangString = paramVideoUrlInfo;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_JavaLangString = ((String)localObject);
          return;
          i = paramVideoUrlInfo.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramVideoUrlInfo)
      {
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    b(paramString1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o = 0;
    if (!paramBoolean1) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_i_of_type_Boolean = paramBoolean2;
    a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    ReadinjoyVideoReportData localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localReadinjoyVideoReportData.o = i;
      return;
    }
  }
  
  public void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long != 0L) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    ((ReadinjoyVideoReportData)localObject).jdField_f_of_type_Long += this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    ((ReadinjoyVideoReportData)localObject).jdField_c_of_type_Int += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_JavaLangString).append(", 预加载状态：").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o).append(", 预下载命中：").append(this.jdField_b_of_type_Boolean).append(", 首帧耗时：").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, paramVideoPlayerWrapper), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter
 * JD-Core Version:    0.7.0.1
 */