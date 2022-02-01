package com.tencent.liteav;

import android.content.Context;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.lang.ref.WeakReference;

public abstract class n
{
  protected h a = null;
  protected Context b = null;
  protected TXCloudVideoView c = null;
  protected WeakReference<com.tencent.liteav.basic.c.b> d;
  
  public n(Context paramContext)
  {
    if (paramContext != null) {
      this.b = paramContext.getApplicationContext();
    }
  }
  
  public int a(String paramString)
  {
    return -1;
  }
  
  public abstract int a(String paramString, int paramInt);
  
  public abstract int a(boolean paramBoolean);
  
  public void a()
  {
    TXCLog.w("TXIPlayer", "pause not support");
  }
  
  public void a(float paramFloat)
  {
    TXCLog.w("TXIPlayer", "rate not implement");
  }
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Surface paramSurface) {}
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    this.d = new WeakReference(paramb);
  }
  
  public abstract void a(p paramp);
  
  public void a(h paramh)
  {
    this.a = paramh;
    if (this.a == null) {
      this.a = new h();
    }
  }
  
  public void a(o paramo, com.tencent.liteav.basic.b.b paramb, Object paramObject) {}
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener) {}
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    this.c = paramTXCloudVideoView;
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener) {}
  
  public void b()
  {
    TXCLog.w("TXIPlayer", "resume not support");
  }
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract int d(int paramInt);
  
  public void d(boolean paramBoolean)
  {
    TXCLog.w("TXIPlayer", "autoPlay not implement");
  }
  
  public void e(int paramInt)
  {
    TXCLog.w("TXIPlayer", "seek not support");
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public abstract int h();
  
  public h i()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.n
 * JD-Core Version:    0.7.0.1
 */