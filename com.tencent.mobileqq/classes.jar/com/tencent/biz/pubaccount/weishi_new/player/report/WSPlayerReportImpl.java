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
  private WSPlayerReportData a = new WSPlayerReportData();
  private boolean b;
  private long c;
  
  private void a()
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    this.a.F = true;
  }
  
  private void a(WSPlayerReportData paramWSPlayerReportData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerReportImpl.java][onStop] mReportData:");
    localStringBuilder.append(paramWSPlayerReportData.toString());
    WSLog.d("WS_VIDEO_REPORT", localStringBuilder.toString());
    this.b = true;
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
        this.a.A = str;
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
      this.a.E = ((String)paramObject);
    }
  }
  
  public void a(int paramInt)
  {
    this.a.k = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    WSPlayerReportData localWSPlayerReportData = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt2);
    localWSPlayerReportData.C = localStringBuilder.toString();
    this.a.D = paramString;
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
    this.a.z = (SystemClock.uptimeMillis() - this.c);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramWSPlayerWrapper));
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, boolean paramBoolean)
  {
    WSPlayerReportData localWSPlayerReportData = this.a;
    int i;
    if ((paramWSPlayerWrapper.b() instanceof SuperPlayerImpl)) {
      i = 1;
    } else {
      i = 0;
    }
    localWSPlayerReportData.a = i;
    this.a.j = paramWSPlayerWrapper.L();
    this.a.d = paramWSPlayerWrapper.v();
    this.a.e = paramWSPlayerWrapper.t();
    this.a.h = paramWSPlayerWrapper.u();
    this.a.B = paramWSPlayerWrapper.w();
    this.a.m = paramWSPlayerWrapper.A();
    this.a.l = paramWSPlayerWrapper.z();
    this.a.n = paramWSPlayerWrapper.G();
    this.a.q = paramWSPlayerWrapper.F();
    this.a.o = paramWSPlayerWrapper.I();
    this.a.p = paramWSPlayerWrapper.H();
    this.a.r = paramWSPlayerWrapper.J();
    this.a.H = paramWSPlayerWrapper.x();
    this.a.s = paramWSPlayerWrapper.B();
    this.a.G = WSExpABTestManager.a().i();
    a(this.a);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.b = false;
    long l;
    if (!paramBoolean) {
      l = SystemClock.uptimeMillis();
    } else {
      l = 0L;
    }
    this.c = l;
    WSPlayerReportData localWSPlayerReportData = this.a;
    localWSPlayerReportData.c = paramString1;
    localWSPlayerReportData.b = paramString2;
    localWSPlayerReportData.i = false;
    localWSPlayerReportData.j = false;
    localWSPlayerReportData.k = 0;
    localWSPlayerReportData.f = 0;
    localWSPlayerReportData.g = 0;
    localWSPlayerReportData.B = 0;
    localWSPlayerReportData.p = 0L;
    localWSPlayerReportData.o = 0L;
    localWSPlayerReportData.n = "";
    localWSPlayerReportData.C = "";
    localWSPlayerReportData.D = "";
    localWSPlayerReportData.d = "";
    localWSPlayerReportData.A = "";
    localWSPlayerReportData.E = "";
    localWSPlayerReportData.F = false;
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerReportImpl.java][onHitPreload] loaded:");
    localStringBuilder.append(paramBoolean);
    WSLog.e("WS_VIDEO_REPORT", localStringBuilder.toString());
    this.c = SystemClock.uptimeMillis();
    this.a.i = paramBoolean;
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    WSPlayerReportData localWSPlayerReportData = this.a;
    int j = 0;
    if (paramWSPlayerWrapper != null) {
      i = paramWSPlayerWrapper.q();
    } else {
      i = 0;
    }
    localWSPlayerReportData.f = i;
    localWSPlayerReportData = this.a;
    int i = j;
    if (paramWSPlayerWrapper != null) {
      i = paramWSPlayerWrapper.r();
    }
    localWSPlayerReportData.g = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl
 * JD-Core Version:    0.7.0.1
 */