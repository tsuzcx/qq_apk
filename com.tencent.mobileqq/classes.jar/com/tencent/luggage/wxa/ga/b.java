package com.tencent.luggage.wxa.ga;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.wxa.fz.a;
import com.tencent.luggage.wxa.lr.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayConfig;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class b
  implements ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  private Context a;
  private TXCloudVideoView b;
  private WXLivePlayConfig c;
  private WXLivePlayer d;
  private ITXLivePlayListener e;
  private TXLivePlayer.ITXSnapshotListener f;
  private TXLivePlayer.ITXAudioVolumeEvaluationListener g;
  private Surface h;
  private Handler i;
  private String j = "";
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private int n = 1;
  private boolean o = false;
  private boolean p = false;
  private String q = "vertical";
  private String r = "fillCrop";
  private String s = "speaker";
  private float t = 1.0F;
  private float u = 3.0F;
  private boolean v = true;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
    this.c = new WXLivePlayConfig();
    this.d = new WXLivePlayer(this.a);
    this.d.enableHardwareDecode(true);
    this.d.setConfig(this.c);
    this.d.setPlayListener(this);
    this.d.setAudioVolumeEvaluationListener(this);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = this.o;
    if (paramBundle.keySet().contains("muteAudio")) {
      bool = paramBundle.getBoolean("muteAudio");
    } else if (paramBundle.keySet().contains("muted")) {
      bool = paramBundle.getBoolean("muted");
    }
    if ((paramBoolean) || (bool != this.o)) {
      this.d.muteAudio(bool);
    }
    this.o = bool;
    bool = paramBundle.getBoolean("muteVideo", this.p);
    if ((paramBoolean) || (bool != this.p)) {
      this.d.muteVideo(bool);
    }
    this.p = bool;
    Object localObject = paramBundle.getString("orientation", this.q);
    int i1 = 0;
    if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.q))) {
      if (((String)localObject).equalsIgnoreCase("horizontal")) {
        this.d.setRenderRotation(270);
      } else if (((String)localObject).equalsIgnoreCase("vertical")) {
        this.d.setRenderRotation(0);
      }
    }
    this.q = ((String)localObject);
    localObject = paramBundle.getString("objectFit", this.r);
    if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.r))) {
      if (((String)localObject).equalsIgnoreCase("fillCrop")) {
        this.d.setRenderMode(0);
      } else if (((String)localObject).equalsIgnoreCase("contain")) {
        this.d.setRenderMode(1);
      }
    }
    this.r = ((String)localObject);
    if (paramBundle.keySet().contains("soundMode"))
    {
      localObject = paramBundle.getString("soundMode", this.s);
      if (!((String)localObject).equalsIgnoreCase(this.s)) {
        if (((String)localObject).equalsIgnoreCase("speaker")) {
          this.d.setAudioRoute(0);
        } else if (((String)localObject).equalsIgnoreCase("ear")) {
          this.d.setAudioRoute(1);
        }
      }
      this.s = ((String)localObject);
    }
    localObject = null;
    if (paramBundle.keySet().contains("referrer"))
    {
      localObject = paramBundle.getString("referrer");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseAndApplyParams, referrer: ");
      localStringBuilder.append((String)localObject);
      o.d("TXLivePlayerJSAdapter", localStringBuilder.toString());
    }
    this.t = paramBundle.getFloat("minCache", this.t);
    this.u = paramBundle.getFloat("maxCache", this.u);
    this.c.setAutoAdjustCacheTime(true);
    this.c.setCacheTime(this.t);
    this.c.setMinAutoAdjustCacheTime(this.t);
    this.c.setMaxAutoAdjustCacheTime(this.u);
    localObject = d.a((String)localObject);
    if (localObject != null) {
      this.c.setHeaders((Map)localObject);
    }
    this.y = paramBundle.getBoolean("enableRecvMessage", this.y);
    this.c.setEnableMessage(this.y);
    this.d.setConfig(this.c);
    this.w = paramBundle.getBoolean("needEvent", this.w);
    paramBoolean = paramBundle.getBoolean("needAudioVolume", this.x);
    if (paramBoolean != this.x)
    {
      localObject = this.d;
      if (paramBoolean) {
        i1 = 300;
      }
      ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i1);
    }
    this.x = paramBoolean;
    paramBoolean = paramBundle.getBoolean("debug", this.z);
    if (paramBoolean != this.z) {
      this.d.showDebugLog(paramBoolean);
    }
    this.z = paramBoolean;
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder;
      if ((!str.equalsIgnoreCase("playUrl")) && (!str.equalsIgnoreCase("orientation")) && (!str.equalsIgnoreCase("objectFit")) && (!str.equalsIgnoreCase("soundMode")))
      {
        if ((!str.equalsIgnoreCase("mode")) && (!str.equalsIgnoreCase("playType")))
        {
          if ((!str.equalsIgnoreCase("minCache")) && (!str.equalsIgnoreCase("maxCache")))
          {
            if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autoplay")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("muteAudio")) || (str.equalsIgnoreCase("muteVideo")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needAudioVolume")) || (str.equalsIgnoreCase("enableRecvMessage")) || (str.equalsIgnoreCase("debug")))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString);
              localStringBuilder.append("\n");
              localStringBuilder.append(str);
              localStringBuilder.append(" = ");
              localStringBuilder.append(paramBundle.getBoolean(str));
              paramString = localStringBuilder.toString();
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append("\n");
            localStringBuilder.append(str);
            localStringBuilder.append(" = ");
            localStringBuilder.append(paramBundle.getFloat(str));
            paramString = localStringBuilder.toString();
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("\n");
          localStringBuilder.append(str);
          localStringBuilder.append(" = ");
          localStringBuilder.append(paramBundle.getInt(str));
          paramString = localStringBuilder.toString();
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("\n");
        localStringBuilder.append(str);
        localStringBuilder.append(" = ");
        localStringBuilder.append(paramBundle.getString(str));
        paramString = localStringBuilder.toString();
      }
    }
    o.d("TXLivePlayerJSAdapter", paramString);
  }
  
  private int c(Bundle paramBundle)
  {
    this.n = paramBundle.getInt("mode", this.n);
    if (this.n == 1)
    {
      paramBundle = this.j;
      if (paramBundle == null) {
        return 0;
      }
      if ((paramBundle != null) && ((paramBundle.startsWith("http://")) || (this.j.startsWith("https://"))) && (this.j.contains(".flv"))) {
        return 1;
      }
      return 0;
    }
    return 5;
  }
  
  public a a()
  {
    if (!this.l) {
      return new a(-3, "uninited livePlayer");
    }
    this.d.stopPlay(true);
    this.d.setPlayListener(null);
    this.l = false;
    return new a();
  }
  
  public a a(int paramInt1, int paramInt2)
  {
    this.d.setSurfaceSize(paramInt1, paramInt2);
    return new a();
  }
  
  public a a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new a(-1, "invalid params");
    }
    if (this.e != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      this.e.onPlayEvent(-9999999, localBundle);
    }
    a("initLivePlayer", paramBundle);
    this.b = null;
    this.j = paramBundle.getString("playUrl", this.j);
    this.k = c(paramBundle);
    a(paramBundle, true);
    this.m = paramBundle.getBoolean("autoplay", this.m);
    if ((paramBundle.getBoolean("canStartPlay", true)) && (this.m))
    {
      paramBundle = this.j;
      if ((paramBundle != null) && (!paramBundle.isEmpty()))
      {
        o.d("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
        this.d.startPlay(this.j, this.k);
      }
    }
    this.l = true;
    return new a();
  }
  
  public a a(Surface paramSurface)
  {
    this.h = paramSurface;
    this.d.setSurface(paramSurface);
    return new a();
  }
  
  public a a(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new a(-1, "invalid params");
    }
    String str;
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("operateLivePlayer: type = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" params = ");
    localStringBuilder.append(str);
    o.d("TXLivePlayerJSAdapter", localStringBuilder.toString());
    if (!this.l) {
      return new a(-3, "uninited livePlayer");
    }
    if (paramString.equalsIgnoreCase("play"))
    {
      this.d.startPlay(this.j, this.k);
    }
    else if (paramString.equalsIgnoreCase("stop"))
    {
      this.d.stopPlay(true);
    }
    else if (paramString.equalsIgnoreCase("pause"))
    {
      this.d.pause();
    }
    else if (paramString.equalsIgnoreCase("resume"))
    {
      this.d.resume();
    }
    else if (paramString.equalsIgnoreCase("mute"))
    {
      this.o ^= true;
      this.d.muteAudio(this.o);
    }
    else
    {
      if (!paramString.equalsIgnoreCase("snapshot")) {
        break label297;
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramJSONObject != null)
      {
        paramString = paramJSONObject.optString("quality");
        bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.equalsIgnoreCase("compressed")) {
            bool1 = true;
          }
        }
      }
      a(bool1, this.f);
    }
    return new a();
    label297:
    return new a(-4, "invalid operate command");
  }
  
  public void a(Handler paramHandler)
  {
    this.i = paramHandler;
  }
  
  public void a(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.e = paramITXLivePlayListener;
  }
  
  public void a(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.g = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.f = paramITXSnapshotListener;
  }
  
  public void a(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    WXLivePlayer localWXLivePlayer = this.d;
    if ((localWXLivePlayer != null) && (localWXLivePlayer.isPlaying())) {
      this.d.snapshot(new b.1(this, paramITXSnapshotListener, paramBoolean));
    }
  }
  
  public a b()
  {
    if (this.d.isPlaying()) {
      return a("pause", null);
    }
    return new a();
  }
  
  public a b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new a(-1, "invalid params");
    }
    if (!this.l) {
      return new a(-3, "uninited livePlayer");
    }
    a("updateLivePlayer", paramBundle);
    a(paramBundle, false);
    boolean bool = this.d.isPlaying();
    Object localObject1 = paramBundle.getString("playUrl", this.j);
    if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
    {
      Object localObject2 = this.j;
      if ((localObject2 != null) && (!((String)localObject2).equalsIgnoreCase((String)localObject1)) && (this.d.isPlaying()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateLivePlayer: stopPlay playUrl-old = ");
        ((StringBuilder)localObject2).append(this.j);
        ((StringBuilder)localObject2).append(" playUrl-new = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        o.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject2).toString());
        this.d.stopPlay(true);
      }
    }
    this.j = ((String)localObject1);
    int i1 = c(paramBundle);
    if ((i1 != this.k) && (this.d.isPlaying()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateLivePlayer: stopPlay  playType-old = ");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append(" playType-new = ");
      ((StringBuilder)localObject1).append(i1);
      o.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject1).toString());
      this.d.stopPlay(true);
    }
    this.k = i1;
    this.m = paramBundle.getBoolean("autoplay", this.m);
    if ((this.m) || (bool))
    {
      paramBundle = this.j;
      if ((paramBundle != null) && (!paramBundle.isEmpty()) && (!this.d.isPlaying()))
      {
        o.d("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        this.d.startPlay(this.j, this.k);
      }
    }
    return new a();
  }
  
  public void c()
  {
    ITXLivePlayListener localITXLivePlayListener = this.e;
    if (localITXLivePlayListener != null) {
      localITXLivePlayListener.onPlayEvent(6000, new Bundle());
    }
  }
  
  public a d()
  {
    return a("resume", null);
  }
  
  public boolean e()
  {
    return this.d.isPlaying();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.b
 * JD-Core Version:    0.7.0.1
 */