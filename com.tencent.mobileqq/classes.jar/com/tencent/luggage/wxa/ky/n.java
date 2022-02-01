package com.tencent.luggage.wxa.ky;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayConfig;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class n
  implements ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  private boolean A = true;
  private Context a;
  private TXCloudVideoView b;
  private WXLivePlayConfig c;
  private WXLivePlayer d;
  private ITXLivePlayListener e;
  private TXLivePlayer.ITXSnapshotListener f;
  private TXLivePlayer.ITXAudioVolumeEvaluationListener g;
  private String h = "";
  private int i = 0;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private int m = 1;
  private boolean n = false;
  private boolean o = false;
  private String p = "vertical";
  private String q = "contain";
  private String r = "speaker";
  private float s = 1.0F;
  private float t = 3.0F;
  private boolean u = true;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private boolean z = true;
  
  public n(Context paramContext)
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
    boolean bool = this.n;
    if (paramBundle.keySet().contains("muteAudio")) {
      bool = paramBundle.getBoolean("muteAudio");
    } else if (paramBundle.keySet().contains("muted")) {
      bool = paramBundle.getBoolean("muted");
    }
    if ((paramBoolean) || (bool != this.n)) {
      this.d.muteAudio(bool);
    }
    this.n = bool;
    bool = paramBundle.getBoolean("muteVideo", this.o);
    if ((paramBoolean) || (bool != this.o)) {
      this.d.muteVideo(bool);
    }
    this.o = bool;
    Object localObject = paramBundle.getString("orientation", this.p);
    int i1 = 0;
    if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.p))) {
      if (((String)localObject).equalsIgnoreCase("horizontal")) {
        this.d.setRenderRotation(270);
      } else if (((String)localObject).equalsIgnoreCase("vertical")) {
        this.d.setRenderRotation(0);
      }
    }
    this.p = ((String)localObject);
    localObject = paramBundle.getString("objectFit", this.q);
    if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.q))) {
      if (((String)localObject).equalsIgnoreCase("fillCrop")) {
        this.d.setRenderMode(0);
      } else if (((String)localObject).equalsIgnoreCase("contain")) {
        this.d.setRenderMode(1);
      }
    }
    this.q = ((String)localObject);
    if (paramBundle.keySet().contains("soundMode"))
    {
      localObject = paramBundle.getString("soundMode", this.r);
      if (!((String)localObject).equalsIgnoreCase(this.r)) {
        if (((String)localObject).equalsIgnoreCase("speaker")) {
          this.d.setAudioRoute(0);
        } else if (((String)localObject).equalsIgnoreCase("ear")) {
          this.d.setAudioRoute(1);
        }
      }
      this.r = ((String)localObject);
    }
    this.s = paramBundle.getFloat("minCache", this.s);
    this.t = paramBundle.getFloat("maxCache", this.t);
    this.c.setAutoAdjustCacheTime(true);
    this.c.setCacheTime(this.s);
    this.c.setMinAutoAdjustCacheTime(this.s);
    this.c.setMaxAutoAdjustCacheTime(this.t);
    this.x = paramBundle.getBoolean("enableRecvMessage", this.x);
    this.c.setEnableMessage(this.x);
    this.d.setConfig(this.c);
    this.v = paramBundle.getBoolean("needEvent", this.v);
    this.z = paramBundle.getBoolean("autoPauseIfNavigate", this.z);
    this.A = paramBundle.getBoolean("autoPauseIfOpenNative", this.A);
    paramBoolean = paramBundle.getBoolean("needAudioVolume", this.w);
    if (paramBoolean != this.w)
    {
      localObject = this.d;
      if (paramBoolean) {
        i1 = 300;
      }
      ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i1);
    }
    this.w = paramBoolean;
    paramBoolean = paramBundle.getBoolean("debug", this.y);
    if (paramBoolean != this.y) {
      this.d.showDebugLog(paramBoolean);
    }
    this.y = paramBoolean;
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
  
  private int b(Bundle paramBundle)
  {
    this.m = paramBundle.getInt("mode", this.m);
    if (this.m == 1)
    {
      paramBundle = this.h;
      if (paramBundle == null) {
        return 0;
      }
      if ((paramBundle != null) && ((paramBundle.startsWith("http://")) || (this.h.startsWith("https://"))) && (this.h.contains(".flv"))) {
        return 1;
      }
      return 0;
    }
    return 5;
  }
  
  public k a()
  {
    if (!this.j) {
      return new k(-3, "uninited livePlayer");
    }
    this.d.stopPlay(true);
    this.d.setPlayListener(null);
    this.j = false;
    return new k();
  }
  
  public k a(int paramInt)
  {
    o.d("TXLivePlayerJSAdapter", "enterBackground");
    if (((paramInt == 2) && (!this.A)) || ((paramInt == 1) && (!this.z)))
    {
      this.k = false;
      return new k();
    }
    this.k = this.d.isPlaying();
    if (this.k)
    {
      if (this.v)
      {
        ITXLivePlayListener localITXLivePlayListener = this.e;
        if (localITXLivePlayListener != null) {
          localITXLivePlayListener.onPlayEvent(6000, new Bundle());
        }
      }
      return a("pause", null);
    }
    return new k();
  }
  
  public k a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new k(-1, "invalid params");
    }
    if (!this.j) {
      return new k(-3, "uninited livePlayer");
    }
    a("updateLivePlayer", paramBundle);
    a(paramBundle, false);
    boolean bool = this.d.isPlaying();
    Object localObject1 = paramBundle.getString("playUrl", this.h);
    if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
    {
      Object localObject2 = this.h;
      if ((localObject2 != null) && (!((String)localObject2).equalsIgnoreCase((String)localObject1)) && (this.d.isPlaying()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateLivePlayer: stopPlay playUrl-old = ");
        ((StringBuilder)localObject2).append(this.h);
        ((StringBuilder)localObject2).append(" playUrl-new = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        o.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject2).toString());
        this.d.stopPlay(true);
      }
    }
    this.h = ((String)localObject1);
    int i1 = b(paramBundle);
    if ((i1 != this.i) && (this.d.isPlaying()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateLivePlayer: stopPlay  playType-old = ");
      ((StringBuilder)localObject1).append(this.i);
      ((StringBuilder)localObject1).append(" playType-new = ");
      ((StringBuilder)localObject1).append(i1);
      o.d("TXLivePlayerJSAdapter", ((StringBuilder)localObject1).toString());
      this.d.stopPlay(true);
    }
    this.i = i1;
    this.l = paramBundle.getBoolean("autoplay", this.l);
    if ((this.l) || (bool))
    {
      paramBundle = this.h;
      if ((paramBundle != null) && (!paramBundle.isEmpty()) && (!this.d.isPlaying()))
      {
        o.d("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
        this.d.startPlay(this.h, this.i);
      }
    }
    return new k();
  }
  
  public k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    if ((paramTXCloudVideoView != null) && (paramBundle != null))
    {
      a("initLivePlayer", paramBundle);
      this.b = paramTXCloudVideoView;
      this.b.disableLog(false);
      this.d.setPlayerView(paramTXCloudVideoView);
      this.h = paramBundle.getString("playUrl", this.h);
      this.i = b(paramBundle);
      a(paramBundle, true);
      this.l = paramBundle.getBoolean("autoplay", this.l);
      if (this.l)
      {
        paramTXCloudVideoView = this.h;
        if ((paramTXCloudVideoView != null) && (!paramTXCloudVideoView.isEmpty()))
        {
          o.d("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
          this.d.startPlay(this.h, this.i);
        }
      }
      this.j = true;
      return new k();
    }
    return new k(-1, "invalid params");
  }
  
  public k a(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new k(-1, "invalid params");
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
    if (!this.j) {
      return new k(-3, "uninited livePlayer");
    }
    if (paramString.equalsIgnoreCase("play"))
    {
      this.d.startPlay(this.h, this.i);
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
      this.n ^= true;
      this.d.muteAudio(this.n);
    }
    else
    {
      if (!paramString.equalsIgnoreCase("snapshot")) {
        break label298;
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
    return new k();
    label298:
    return new k(-4, "invalid operate command");
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
    if (localWXLivePlayer != null) {
      localWXLivePlayer.snapshot(new n.1(this, paramITXSnapshotListener, paramBoolean));
    }
  }
  
  public k b()
  {
    if (this.k) {
      return a("resume", null);
    }
    return new k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.n
 * JD-Core Version:    0.7.0.1
 */