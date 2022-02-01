package com.tencent.biz.pubaccount.weishi_new.player.report;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerImpl;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class WSPlayerReportImpl
  implements IWSPlayerReport
{
  private long jdField_a_of_type_Long;
  private WSPlayerReportData jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData = new WSPlayerReportData();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_c_of_type_Boolean = true;
  }
  
  private void a(WSPlayerReportData paramWSPlayerReportData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerReportImpl.java][onStop] mReportData:");
    localStringBuilder.append(paramWSPlayerReportData.toString());
    WSLog.d("WS_VIDEO_REPORT", localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    WSPlayerReporter.a(paramWSPlayerReportData);
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).split(":", 2);
      if (paramObject.length == 2)
      {
        String str = paramObject[1];
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_e_of_type_JavaLangString = str;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSPlayerReportImpl.java][onInfo] PERFORMANCE_REPORT method:");
        localStringBuilder.append(paramObject[0]);
        localStringBuilder.append(", timeJson:");
        localStringBuilder.append(str);
        WSLog.e("WS_VIDEO_REPORT", localStringBuilder.toString());
      }
    }
  }
  
  private void b()
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_DECODER_BLOCK");
  }
  
  private void b(Object paramObject)
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED");
    if ((paramObject instanceof String)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_h_of_type_JavaLangString = ((String)paramObject);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    WSPlayerReportData localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt2);
    localWSPlayerReportData.jdField_f_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 28)
    {
      if (paramInt != 39)
      {
        if (paramInt != 41)
        {
          if (paramInt != 42) {
            return;
          }
          a(paramObject);
          return;
        }
        a();
        return;
      }
      b(paramObject);
      return;
    }
    b();
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.o = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramWSPlayerWrapper));
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, boolean paramBoolean)
  {
    WSPlayerReportData localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
    int i;
    if ((paramWSPlayerWrapper.a() instanceof SuperPlayerImpl)) {
      i = 1;
    } else {
      i = 0;
    }
    localWSPlayerReportData.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_b_of_type_Boolean = paramWSPlayerWrapper.g();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_c_of_type_JavaLangString = paramWSPlayerWrapper.a();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_a_of_type_Long = paramWSPlayerWrapper.c();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_b_of_type_Long = paramWSPlayerWrapper.d();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_f_of_type_Int = paramWSPlayerWrapper.c();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_e_of_type_Int = paramWSPlayerWrapper.d();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_c_of_type_Long = paramWSPlayerWrapper.e();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_d_of_type_JavaLangString = paramWSPlayerWrapper.c();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_f_of_type_Long = paramWSPlayerWrapper.g();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_d_of_type_Long = paramWSPlayerWrapper.i();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_e_of_type_Long = paramWSPlayerWrapper.h();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_g_of_type_Long = paramWSPlayerWrapper.j();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.i = paramWSPlayerWrapper.b();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_h_of_type_Long = paramWSPlayerWrapper.f();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_d_of_type_Boolean = WSExpABTestManager.a().c();
    a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.jdField_a_of_type_Boolean = false;
    long l;
    if (!paramBoolean) {
      l = SystemClock.uptimeMillis();
    } else {
      l = 0L;
    }
    this.jdField_a_of_type_Long = l;
    WSPlayerReportData localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
    localWSPlayerReportData.jdField_b_of_type_JavaLangString = paramString1;
    localWSPlayerReportData.jdField_a_of_type_JavaLangString = paramString2;
    localWSPlayerReportData.jdField_a_of_type_Boolean = false;
    localWSPlayerReportData.jdField_b_of_type_Boolean = false;
    localWSPlayerReportData.jdField_d_of_type_Int = 0;
    localWSPlayerReportData.jdField_b_of_type_Int = 0;
    localWSPlayerReportData.jdField_c_of_type_Int = 0;
    localWSPlayerReportData.jdField_f_of_type_Int = 0;
    localWSPlayerReportData.jdField_e_of_type_Long = 0L;
    localWSPlayerReportData.jdField_d_of_type_Long = 0L;
    localWSPlayerReportData.jdField_d_of_type_JavaLangString = "";
    localWSPlayerReportData.jdField_f_of_type_JavaLangString = "";
    localWSPlayerReportData.jdField_g_of_type_JavaLangString = "";
    localWSPlayerReportData.jdField_c_of_type_JavaLangString = "";
    localWSPlayerReportData.jdField_e_of_type_JavaLangString = "";
    localWSPlayerReportData.jdField_h_of_type_JavaLangString = "";
    localWSPlayerReportData.jdField_c_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerReportImpl.java][onHitPreload] loaded:");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WS_VIDEO_REPORT", localStringBuilder.toString());
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    WSPlayerReportData localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
    int j = 0;
    if (paramWSPlayerWrapper != null) {
      i = paramWSPlayerWrapper.a();
    } else {
      i = 0;
    }
    localWSPlayerReportData.jdField_b_of_type_Int = i;
    localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
    int i = j;
    if (paramWSPlayerWrapper != null) {
      i = paramWSPlayerWrapper.b();
    }
    localWSPlayerReportData.jdField_c_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl
 * JD-Core Version:    0.7.0.1
 */