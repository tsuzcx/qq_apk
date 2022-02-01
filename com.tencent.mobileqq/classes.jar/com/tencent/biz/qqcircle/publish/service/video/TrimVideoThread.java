package com.tencent.biz.qqcircle.publish.service.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostVideoHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class TrimVideoThread
  implements Runnable
{
  public static int a;
  private Handler b;
  private String c;
  private long d;
  private long e;
  private long f;
  private String g;
  private boolean h;
  private String i;
  private String j;
  private int k;
  private int l;
  private Handler m = new Handler();
  private String n = "";
  private boolean o;
  private boolean p;
  private boolean q;
  private String r = QCircleConfigHelper.a("QZoneTextSetting", "VideoFilePathNull", "视频文件路径为空");
  private String s = QCircleConfigHelper.a("QZoneTextSetting", "VideoFileNotExist", "视频文件不存在");
  private String t = QCircleConfigHelper.a("QZoneTextSetting", "VideoTrimTimeError", "裁剪时间错误");
  private String u = QCircleConfigHelper.a("QZoneTextSetting", "VideoReadCacheFail", "读取缓存位置失败");
  private String v = QCircleConfigHelper.a("QZoneTextSetting", "VideoTrimSuccess", "裁剪成功");
  private String w = QCircleConfigHelper.a("QZoneTextSetting", "VideoTrimFail", "裁剪失败, code=");
  private Runnable x = new TrimVideoThread.1(this);
  
  public TrimVideoThread(Context paramContext, Handler paramHandler, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.i = paramContext.getFilesDir().getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleHostVideoHelper.getShortVideoSoPath(paramContext));
    localStringBuilder.append(QCircleHostVideoHelper.getShortVideoSoLibName());
    this.j = localStringBuilder.toString();
    this.b = paramHandler;
    this.c = paramString1;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramLong3;
    this.k = paramInt;
    this.g = paramString2;
    this.h = paramBoolean1;
    this.o = paramBoolean2;
    this.p = paramBoolean3;
    this.q = paramBoolean4;
    paramContext = new StringBuilder();
    paramContext.append("videoPath=");
    paramContext.append(paramString1);
    paramContext.append(", startTime=");
    paramContext.append(paramLong1);
    paramContext.append(", endTime=");
    paramContext.append(paramLong2);
    paramContext.append(", mFilesDir=");
    paramContext.append(this.i);
    paramContext.append(", mSoFullPath=");
    paramContext.append(this.j);
    paramContext.append(", retryNum=");
    paramContext.append(this.k);
    paramContext.append(" isQcircle:");
    QLog.d("[upload2][compress]", 1, new Object[] { paramContext.toString(), Boolean.valueOf(paramBoolean4) });
  }
  
  private static String a()
  {
    return QCircleHostQzoneHelper.getVideoFileCacheDir();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    a(localMessage);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.getData().putString("target_file", paramString1);
    localMessage.getData().putString("report_msg", paramString2);
    localMessage.getData().putString("source_path", this.c);
    localMessage.getData().putString("client_key", this.g);
    localMessage.getData().putBoolean("noDeleteFile", this.o);
    a(localMessage);
  }
  
  private void a(Message paramMessage)
  {
    Object localObject = this.b;
    if (localObject != null) {
      try
      {
        ((Handler)localObject).sendMessage(paramMessage);
        return;
      }
      catch (Exception paramMessage)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TrimVideo Callback Error");
        ((StringBuilder)localObject).append(paramMessage.getMessage());
        QLog.w("TrimVideoThread", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    QLog.e("TrimVideoThread", 1, "TrimVideo Callback is NULL");
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public void run()
  {
    if (TextUtils.isEmpty(this.c))
    {
      a(1001, "", this.r);
      QLog.e("[upload2][compress]", 1, this.r);
      return;
    }
    if (!a(this.c))
    {
      a(1001, "", this.s);
      QLog.e("[upload2][compress]", 1, this.s);
      return;
    }
    if ((this.d >= 0L) && (this.e >= 0L) && (this.f >= 0L))
    {
      Object localObject2 = a();
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        a(1001, "", this.u);
        QLog.e("[upload2][compress]", 1, this.u);
        return;
      }
      this.l = 0;
      a(1002, this.l);
      this.m.postDelayed(this.x, 5000L);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(".mp4");
      localObject1 = ((StringBuilder)localObject1).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("/");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("TmpRawVideo.mp4");
      this.n = localStringBuilder.toString();
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 1005;
      ((Message)localObject2).obj = localObject1;
      this.b.sendMessage((Message)localObject2);
      QLog.d("[upload2][compress]", 1, new Object[] { "Start trim video", " mvideoPath= ", this.c, "  videoPath= ", localObject1, " mTmpVideoPath= mTmpVideoPath" });
      int i1 = VideoTrimmer.a(this.i, this.j, this.c, (String)localObject1, this.d, this.e, this.f, this.h, this.k, this.b, this.n, this.g, this.p, this.q);
      this.m.removeCallbacks(this.x);
      if (i1 == 0)
      {
        a(1000, (String)localObject1, this.v);
        QLog.d("[upload2][compress]", 1, new Object[] { "trim video success", " mvideoPath= ", this.c, "  videoPath= ", localObject1, " mTmpVideoPath= mTmpVideoPath" });
        QCircleCompressReportUtils.a(0, "trim video success");
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.w);
      ((StringBuilder)localObject2).append(i1);
      a(1001, "", ((StringBuilder)localObject2).toString());
      QLog.d("[upload2][compress]", 1, new Object[] { "trim video fail", " mvideoPath= ", this.c, "  videoPath= ", localObject1, " mTmpVideoPath= mTmpVideoPath", " status=", String.valueOf(i1) });
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("trim video fail");
      ((StringBuilder)localObject1).append(i1);
      QCircleCompressReportUtils.a(i1, ((StringBuilder)localObject1).toString());
      return;
    }
    a(1001, "", this.t);
    QLog.e("[upload2][compress]", 1, this.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.service.video.TrimVideoThread
 * JD-Core Version:    0.7.0.1
 */