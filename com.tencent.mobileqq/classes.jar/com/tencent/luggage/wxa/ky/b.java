package com.tencent.luggage.wxa.ky;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.pd.t;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONObject;

public class b
  extends TXCloudVideoView
{
  public int a = 0;
  public String b = "";
  public String c;
  private t d;
  private Handler e = new Handler(getContext().getMainLooper());
  private b.a f = new b.a(this);
  private o g;
  private ITXLivePushListener h;
  private b.c i;
  private b.b j;
  
  public b(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.g = new o(paramContext);
    setBackgroundColor(-16777216);
    this.d = new t(getContext(), new b.1(this));
    this.d.enable();
    a(e());
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt != this.a)
    {
      this.a = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("orientation changed senorAngle = ");
      localStringBuilder.append(paramInt);
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", localStringBuilder.toString());
      this.g.a(paramInt);
      return true;
    }
    return false;
  }
  
  private int e()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getRotation();
  }
  
  public void a()
  {
    this.g.b();
  }
  
  public void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    b.b localb = this.j;
    if (localb != null) {
      localb.a(paramInt, paramString, paramHashMap);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = this.g.a(this, paramBundle);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.a), paramBundle.b });
  }
  
  public void a(c.d paramd)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[] { paramd });
    if ((paramd == c.d.b) || (paramd == c.d.a) || (paramd == c.d.h)) {
      this.g.a(true);
    }
  }
  
  public void a(b.b paramb)
  {
    this.j = paramb;
  }
  
  public void a(b.c paramc)
  {
    this.i = paramc;
  }
  
  public void a(ITXLivePushListener paramITXLivePushListener)
  {
    this.h = paramITXLivePushListener;
    this.g.a(this.h);
  }
  
  public void a(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.g.a(paramITXAudioVolumeEvaluationListener);
  }
  
  public void a(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.g.a(paramITXSnapshotListener);
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.g.a(paramOnBGMNotify);
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    paramString = this.g.a(paramString, paramJSONObject);
    int k = paramString.a;
    boolean bool = false;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(k), paramString.b });
    if (paramString.a == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    k localk = this.g.a(false);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", new Object[] { Integer.valueOf(localk.a), localk.b });
    this.d.disable();
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = this.g.a(paramBundle);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.a), paramBundle.b });
  }
  
  public void c()
  {
    k localk = this.g.b();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", new Object[] { Integer.valueOf(localk.a), localk.b });
    this.d.enable();
  }
  
  public void d()
  {
    Object localObject = this.g.a();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((k)localObject).a), ((k)localObject).b });
    localObject = this.i;
    if (localObject != null) {
      ((b.c)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.b
 * JD-Core Version:    0.7.0.1
 */