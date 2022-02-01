package com.tencent.liteav.a;

import android.content.Context;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.liteav.audio.impl.Record.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
  implements com.tencent.liteav.audio.e, com.tencent.liteav.videoencoder.e
{
  private b a = new b();
  private com.tencent.liteav.videoencoder.a b = new com.tencent.liteav.videoencoder.a();
  private c c;
  private a.a d;
  private a.b e;
  private long f = 0L;
  private long g = -1L;
  private boolean h = false;
  private Handler i = new a.1(this, Looper.getMainLooper());
  
  public a(Context paramContext)
  {
    this.c = new c(paramContext, 1);
  }
  
  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "";
      break;
    case 10000005: 
      str = "Video encoding failed";
      break;
    case 10000004: 
      str = "Video encoding failed to initialize";
      break;
    case 10000003: 
      str = "Illegal video input parameters";
      break;
    case 10000002: 
      str = "Video encoder is not activated";
    }
    Handler localHandler = this.i;
    localHandler.sendMessage(Message.obtain(localHandler, 2, 1, 0, str));
    return str;
  }
  
  private static String a(Context paramContext)
  {
    Object localObject = null;
    if (paramContext == null) {
      return null;
    }
    if ((!"mounted".equals(Environment.getExternalStorageState())) && (Environment.isExternalStorageRemovable())) {
      return paramContext.getFilesDir().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
    paramContext = localObject;
    if (localFile != null) {
      paramContext = localFile.getPath();
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      long l = System.currentTimeMillis() / 1000L;
      Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(l));
      localStringBuilder.append("000");
      localObject = ((SimpleDateFormat)localObject).format(new Date(Long.valueOf(localStringBuilder.toString()).longValue()));
      paramContext = a(paramContext);
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TXUGC_%s");
      localStringBuilder.append(paramString);
      paramContext = new File(paramContext, String.format(localStringBuilder.toString(), new Object[] { localObject })).getAbsolutePath();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TXCStreamRecord", "create file path failed.", paramContext);
    }
    return null;
  }
  
  public void a()
  {
    this.h = false;
    this.a.a();
    this.b.stop();
    if (this.c.b() < 0)
    {
      localHandler = this.i;
      localHandler.sendMessage(Message.obtain(localHandler, 2, 1, 0, "mp4合成失败"));
      return;
    }
    Handler localHandler = this.i;
    localHandler.sendMessage(Message.obtain(localHandler, 2, 0, 0, ""));
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.b.pushVideoFrame(paramInt, this.d.a, this.d.b, paramLong);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(MediaFormat paramMediaFormat)
  {
    this.c.a(paramMediaFormat);
    if ((this.c.c()) && (this.c.a() < 0))
    {
      paramMediaFormat = this.i;
      paramMediaFormat.sendMessage(Message.obtain(paramMediaFormat, 2, 1, 0, "mp4 wrapper failed to start"));
    }
  }
  
  public void a(a.a parama)
  {
    this.d = parama;
    this.f = 0L;
    this.g = -1L;
    this.c.a(this.d.f);
    if ((parama.h > 0) && (parama.i > 0) && (parama.j > 0))
    {
      this.a.a(10, parama.i, parama.h, parama.j, new WeakReference(this));
      parama = f.a(this.d.i, this.d.h, 2);
      this.c.b(parama);
      this.h = true;
    }
    this.b.setListener(this);
    parama = new TXSVideoEncoderParam();
    parama.width = this.d.a;
    parama.height = this.d.b;
    parama.fps = this.d.c;
    parama.glContext = this.d.e;
    parama.annexb = true;
    parama.appendSpsPps = false;
    this.b.setBitrate(this.d.d);
    this.b.start(parama);
  }
  
  public void a(a.b paramb)
  {
    this.e = paramb;
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      this.c.b(paramTXSNALPacket.nalData, 0, paramTXSNALPacket.nalData.length, paramTXSNALPacket.pts * 1000L, paramTXSNALPacket.info.flags);
      if (this.g < 0L) {
        this.g = paramTXSNALPacket.pts;
      }
      if (paramTXSNALPacket.pts > this.f + 500L)
      {
        localObject = this.i;
        ((Handler)localObject).sendMessage(Message.obtain((Handler)localObject, 1, new Long(paramTXSNALPacket.pts - this.g)));
        this.f = paramTXSNALPacket.pts;
      }
    }
    else
    {
      paramTXSNALPacket = a(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video encode error! errmsg: ");
      ((StringBuilder)localObject).append(paramTXSNALPacket);
      TXCLog.e("TXCStreamRecord", ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.h)
    {
      this.a.a(paramArrayOfByte, paramLong);
      return;
    }
    TXCLog.e("TXCStreamRecord", "drainAudio fail because of not init yet!");
  }
  
  public void l(int paramInt) {}
  
  public void m(int paramInt) {}
  
  public void onRecordEncData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c.a(paramArrayOfByte, 0, paramArrayOfByte.length, paramLong * 1000L, 1);
  }
  
  public void onRecordError(int paramInt, String paramString) {}
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.a.a
 * JD-Core Version:    0.7.0.1
 */