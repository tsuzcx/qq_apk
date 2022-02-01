package com.tencent.luggage.wxa.ky;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class a
  extends TXCloudVideoView
{
  private n a;
  private a.a b;
  private a.c c;
  private int d;
  private boolean e;
  private a.b f;
  
  public a(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new n(paramContext);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.e)
    {
      a.c localc = this.c;
      if (localc != null) {
        localc.a(paramBoolean, this.d);
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.a.a();
    o.d("MicroMsg.AppBrandLivePlayerView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((k)localObject).a), ((k)localObject).b });
    localObject = this.f;
    if (localObject != null) {
      ((a.b)localObject).a();
    }
  }
  
  public void a(int paramInt)
  {
    k localk = this.a.a(paramInt);
    o.d("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(localk.a), localk.b });
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = this.a.a(this, paramBundle);
    o.d("MicroMsg.AppBrandLivePlayerView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.a), paramBundle.b });
  }
  
  public void a(a.a parama)
  {
    this.b = parama;
  }
  
  public void a(a.b paramb)
  {
    this.f = paramb;
  }
  
  public void a(a.c paramc)
  {
    this.c = paramc;
  }
  
  public void a(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.a.a(paramITXLivePlayListener);
  }
  
  public void a(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.a.a(paramITXAudioVolumeEvaluationListener);
  }
  
  public void a(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.a.a(paramITXSnapshotListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    paramString = this.a.a(paramString, paramJSONObject);
    int i = paramString.a;
    boolean bool = false;
    o.d("MicroMsg.AppBrandLivePlayerView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(i), paramString.b });
    if (paramString.a == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    k localk = this.a.b();
    o.d("MicroMsg.AppBrandLivePlayerView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(localk.a), localk.b });
  }
  
  public void b(Bundle paramBundle)
  {
    this.e = paramBundle.getBoolean("needEvent", this.e);
    paramBundle = this.a.a(paramBundle);
    o.d("MicroMsg.AppBrandLivePlayerView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.a), paramBundle.b });
  }
  
  public boolean b(int paramInt)
  {
    o.d("MicroMsg.AppBrandLivePlayerView", "enterFullScreen direction:%s", new Object[] { Integer.valueOf(paramInt) });
    a.a locala = this.b;
    if (locala == null)
    {
      o.c("MicroMsg.AppBrandLivePlayerView", "enterFullScreen mFullScreenDelegate null");
      return false;
    }
    if (locala.b())
    {
      o.d("MicroMsg.AppBrandLivePlayerView", "enterFullScreen already full screen");
      return true;
    }
    this.b.a(paramInt);
    this.d = paramInt;
    b(true);
    return true;
  }
  
  public boolean c()
  {
    o.d("MicroMsg.AppBrandLivePlayerView", "quitFullScreen");
    a.a locala = this.b;
    if (locala == null)
    {
      o.c("MicroMsg.AppBrandLivePlayerView", "quitFullScreen mFullScreenDelegate null");
      return false;
    }
    if (!locala.b())
    {
      o.d("MicroMsg.AppBrandLivePlayerView", "quitFullScreen already quit full screen");
      return true;
    }
    this.b.a();
    return true;
  }
  
  public void d()
  {
    o.d("MicroMsg.AppBrandLivePlayerView", "onExitFullScreen");
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.a
 * JD-Core Version:    0.7.0.1
 */