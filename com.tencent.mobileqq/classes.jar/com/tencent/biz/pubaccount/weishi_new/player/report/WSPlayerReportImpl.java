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
    WSLog.d("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + paramWSPlayerReportData.toString());
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
        WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] PERFORMANCE_REPORT method:" + paramObject[0] + ", timeJson:" + str);
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
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_f_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 28: 
      b();
      return;
    case 39: 
      b(paramObject);
      return;
    case 41: 
      a();
      return;
    }
    a(paramObject);
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.o = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramWSPlayerWrapper));
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, boolean paramBoolean)
  {
    WSPlayerReportData localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
    if ((paramWSPlayerWrapper.a() instanceof SuperPlayerImpl)) {}
    for (int i = 1;; i = 0)
    {
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
      return;
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.jdField_a_of_type_Boolean = false;
    if (!paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_e_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_d_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_d_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_g_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_h_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + paramBoolean);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    int j = 0;
    WSPlayerReportData localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
    if (paramWSPlayerWrapper != null) {}
    for (int i = paramWSPlayerWrapper.a();; i = 0)
    {
      localWSPlayerReportData.jdField_b_of_type_Int = i;
      localWSPlayerReportData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportWSPlayerReportData;
      i = j;
      if (paramWSPlayerWrapper != null) {
        i = paramWSPlayerWrapper.b();
      }
      localWSPlayerReportData.jdField_c_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl
 * JD-Core Version:    0.7.0.1
 */