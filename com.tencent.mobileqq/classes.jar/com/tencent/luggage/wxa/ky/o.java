package com.tencent.luggage.wxa.ky;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class o
  implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private boolean A = true;
  private String B = "vertical";
  private String C = "high";
  private int D = 5;
  private int E = 3;
  private String F = "smooth";
  private String G = "";
  private String H = "";
  private boolean I = false;
  private boolean J = false;
  private boolean K = true;
  private boolean L = false;
  private boolean M = false;
  private boolean N = false;
  private boolean O = false;
  private String P = "auto";
  private float Q = 0.0F;
  private float R = 0.0F;
  private float S = 0.1F;
  private String T = "";
  private boolean U = false;
  private boolean V = false;
  private boolean W = false;
  private String X = "auto";
  private int Y = 0;
  private int Z = 368;
  private Context a;
  private int aa = 640;
  private boolean ab = false;
  private Handler ac;
  private TXCloudVideoView b;
  private WXLivePushConfig c;
  private WXLivePusher d;
  private ITXLivePushListener e;
  private int f = 0;
  private String g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  private String k = "front";
  private boolean l = false;
  private boolean m = false;
  private TXLivePusher.ITXSnapshotListener n;
  private TXLivePusher.OnBGMNotify o;
  private TXLivePusher.ITXAudioVolumeEvaluationListener p;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private int t = 1;
  private int u = 2;
  private int v = -1;
  private int w = -1;
  private boolean x = false;
  private int y = 0;
  private boolean z = true;
  
  public o(Context paramContext)
  {
    this.a = paramContext;
    this.ac = new Handler(this.a.getMainLooper());
    this.c = new WXLivePushConfig();
    this.d = new WXLivePusher(paramContext);
    this.d.setConfig(this.c);
    this.d.setPushListener(this);
    this.d.setBGMNofify(this);
    this.d.setAudioVolumeEvaluationListener(this);
  }
  
  private void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustHomeOrientation, angle:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", orientation:");
    localStringBuilder.append(paramString);
    com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", localStringBuilder.toString());
    int i1 = 0;
    if (paramInt == 1)
    {
      paramInt = i1;
      if (paramString.equals("horizontal")) {
        paramInt = 3;
      }
    }
    else
    {
      if (paramInt == 3) {
        if (paramString.equals("horizontal"))
        {
          label88:
          paramInt = 1;
          break label139;
        }
      }
      for (;;)
      {
        paramInt = 2;
        break label139;
        if (paramInt == 0)
        {
          if (!paramString.equals("horizontal")) {
            break label88;
          }
          paramInt = i1;
          break label139;
        }
        if (paramInt != 2) {
          break label135;
        }
        if (!paramString.equals("horizontal")) {
          break;
        }
      }
      label135:
      paramInt = -2147483648;
    }
    label139:
    paramString = new StringBuilder();
    paramString.append("adjustHomeOrientation, homeOrientation:");
    paramString.append(paramInt);
    com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", paramString.toString());
    if (paramInt != -2147483648)
    {
      this.c.setHomeOrientation(paramInt);
      this.d.setConfig(this.c);
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0)) {
      return;
    }
    int i7 = paramBundle.getInt("mode", this.t);
    if ((paramBoolean) || (i7 != this.t)) {
      switch (i7)
      {
      default: 
        break;
      case 7: 
        this.d.setVideoQuality(7, true, false);
        this.c.setVideoEncodeGop(5);
        break;
      case 6: 
        this.d.setVideoQuality(6, false, false);
        break;
      case 5: 
        this.d.setVideoQuality(5, true, false);
        break;
      case 4: 
        this.d.setVideoQuality(4, true, false);
        break;
      case 3: 
        this.d.setVideoQuality(3, true, false);
        this.c.setVideoEncodeGop(5);
        break;
      case 2: 
        this.d.setVideoQuality(2, true, false);
        this.c.setVideoEncodeGop(5);
        break;
      case 1: 
        this.d.setVideoQuality(1, true, false);
        this.c.setVideoEncodeGop(5);
      }
    }
    int i5 = this.v;
    int i3 = this.w;
    int i6 = paramBundle.getInt("minBitrate", -1);
    int i4 = paramBundle.getInt("maxBitrate", -1);
    int i2 = i6;
    int i1 = i4;
    if (i6 > i4)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseAndApplyParams -> swap min and max bitrate, may be something error. min = ");
      ((StringBuilder)localObject1).append(i6);
      ((StringBuilder)localObject1).append(" max = ");
      ((StringBuilder)localObject1).append(i4);
      com.tencent.luggage.wxa.qz.o.b("TXLivePusherJSAdapter", ((StringBuilder)localObject1).toString());
      i1 = i6;
      i2 = i4;
    }
    i4 = i5;
    i6 = i3;
    if (i2 != -1)
    {
      i4 = i5;
      i6 = i3;
      if (i1 != -1)
      {
        i4 = 200;
        if (i2 < 200) {
          i2 = i4;
        }
        i4 = 5000;
        if (i1 <= 5000) {
          i4 = i1;
        }
        i1 = i5;
        if (i2 <= i4)
        {
          i3 = i4;
          i1 = i2;
        }
        i4 = i1;
        i6 = i3;
        if (i1 != -1)
        {
          i4 = i1;
          i6 = i3;
          if (i3 != -1)
          {
            i4 = i1;
            i6 = i3;
            if (i1 <= i3)
            {
              this.c.setMinVideoBitrate(i1);
              this.c.setMaxVideoBitrate(i3);
              i6 = i3;
              i4 = i1;
            }
          }
        }
      }
    }
    i2 = paramBundle.getInt("aspect", this.u);
    i3 = paramBundle.getInt("videoWidth", this.Z);
    i5 = paramBundle.getInt("videoHeight", this.aa);
    Object localObject2 = paramBundle.getString("audioQuality", this.C);
    if (i7 == 6)
    {
      if (i2 == 1) {
        this.c.setVideoResolution(13);
      } else if (i2 == 2) {
        this.c.setVideoResolution(0);
      }
      if ((i3 > 0) && (i3 <= 1920) && (i5 > 0) && (i5 <= 1920)) {
        this.c.setVideoResolution(i3, i5);
      }
      if (((String)localObject2).equalsIgnoreCase("low")) {
        this.c.setAudioSampleRate(16000);
      } else if (((String)localObject2).equalsIgnoreCase("high")) {
        this.c.setAudioSampleRate(48000);
      }
    }
    int i8 = paramBundle.getInt("focusMode", this.y);
    Object localObject1 = this.c;
    if (i8 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((WXLivePushConfig)localObject1).setTouchFocus(bool1);
    boolean bool2 = this.j;
    boolean bool1 = bool2;
    if (paramBundle.keySet().contains("devicePosition"))
    {
      this.k = paramBundle.getString("devicePosition", this.k);
      bool1 = bool2;
      if (this.k.equalsIgnoreCase("back")) {
        bool1 = false;
      }
      this.c.setFrontCamera(bool1);
    }
    String str1 = paramBundle.getString("orientation", this.B);
    if (!str1.equalsIgnoreCase(this.B)) {
      if (str1.equalsIgnoreCase("horizontal"))
      {
        a(this.f, str1);
        this.d.setRenderRotation(90);
      }
      else if (str1.equalsIgnoreCase("vertical"))
      {
        a(this.f, str1);
        this.d.setRenderRotation(0);
      }
    }
    String str2 = paramBundle.getString("localMirror", this.P);
    if (!str2.equalsIgnoreCase(this.P)) {
      if (str2.equalsIgnoreCase("auto")) {
        this.c.setLocalVideoMirrorType(0);
      } else if (str2.equalsIgnoreCase("enable")) {
        this.c.setLocalVideoMirrorType(1);
      } else if (str2.equalsIgnoreCase("disable")) {
        this.c.setLocalVideoMirrorType(2);
      }
    }
    String str3 = paramBundle.getString("backgroundImage", this.H);
    localObject1 = BitmapFactory.decodeFile(str3);
    if (localObject1 != null) {
      this.c.setPauseImg((Bitmap)localObject1);
    }
    bool2 = paramBundle.getBoolean("backgroundMute", this.I);
    if (bool2) {
      this.c.setPauseFlag(3);
    } else {
      this.c.setPauseFlag(1);
    }
    boolean bool3 = paramBundle.getBoolean("zoom", this.K);
    this.c.setEnableZoom(bool3);
    float f1 = this.Q;
    Object localObject3 = localObject2;
    f1 = paramBundle.getFloat("watermarkLeft", f1);
    float f2 = paramBundle.getFloat("watermarkTop", this.R);
    float f3 = paramBundle.getFloat("watermarkWidth", this.S);
    localObject1 = paramBundle.getString("watermarkImage", this.T);
    Object localObject4 = BitmapFactory.decodeFile((String)localObject1);
    if (localObject4 != null) {
      this.c.setWatermark((Bitmap)localObject4, f1, f2, f3);
    } else if ((this.d.isPushing()) && (paramBundle.keySet().contains("watermarkImage"))) {
      this.c.setWatermark((Bitmap)localObject4, f1, f2, f3);
    }
    boolean bool4 = paramBundle.getBoolean("enableAGC", this.U);
    this.c.enableAGC(bool4);
    boolean bool5 = paramBundle.getBoolean("enableANS", this.V);
    this.c.enableANS(bool5);
    boolean bool6 = paramBundle.getBoolean("enableEarMonitor", this.W);
    this.c.enableAudioEarMonitoring(bool6);
    localObject4 = paramBundle.getString("audioVolumeType", this.X);
    if (((String)localObject4).equalsIgnoreCase("voicecall")) {
      this.c.setVolumeType(2);
    } else if (((String)localObject4).equalsIgnoreCase("media")) {
      this.c.setVolumeType(1);
    } else {
      this.c.setVolumeType(0);
    }
    boolean bool7 = paramBundle.getBoolean("enableCamera", this.z);
    this.c.enablePureAudioPush(bool7 ^ true);
    if ((i2 == this.u) && (i4 == this.v) && (i6 == this.w) && (i8 == this.y) && (bool1 == this.j) && (bool2 == this.I) && (bool3 == this.K) && (bool4 == this.U) && (bool5 == this.V) && (bool6 == this.W) && (bool7 == this.z) && (i3 == this.Z) && (i5 == this.aa) && (f1 == this.Q) && (f2 == this.R) && (f3 == this.S) && (str2.equalsIgnoreCase(this.P)) && (((String)localObject4).equalsIgnoreCase(this.X))) {
      if ((str3.equalsIgnoreCase(this.H)) && (str1.equalsIgnoreCase(this.B))) {
        if (localObject3.equalsIgnoreCase(this.C))
        {
          if (((String)localObject1).equalsIgnoreCase(this.T))
          {
            i1 = 0;
            break label1540;
          }
        }
        else {}
      }
    }
    i1 = 1;
    label1540:
    localObject3 = localObject1;
    if ((!paramBoolean) && (i1 == 0)) {
      break label1570;
    }
    this.d.setConfig(this.c);
    label1570:
    if (bool7 != this.z) {
      if (bool7)
      {
        c();
        b(bool7);
      }
      else
      {
        c();
      }
    }
    boolean bool8;
    if (paramBundle.keySet().contains("enableMic"))
    {
      bool8 = paramBundle.getBoolean("enableMic", this.A);
      if (bool8 != this.A) {
        if (bool8)
        {
          d();
          c(true);
        }
        else
        {
          d();
        }
      }
      if ((!paramBoolean) && (bool8 == this.A)) {
        break label1689;
      }
      this.d.setMute(bool8 ^ true);
      label1689:
      this.A = bool8;
      this.x = (bool8 ^ true);
    }
    else if (paramBundle.keySet().contains("muted"))
    {
      bool8 = paramBundle.getBoolean("muted", this.x);
      if ((paramBoolean) || (bool8 != this.x)) {
        this.d.setMute(bool8);
      }
      this.x = bool8;
    }
    localObject1 = paramBundle;
    this.t = i7;
    this.u = i2;
    this.y = i8;
    this.z = bool7;
    this.U = bool4;
    this.V = bool5;
    this.W = bool6;
    this.P = str2;
    this.X = ((String)localObject4);
    this.Z = i3;
    this.aa = i5;
    this.j = bool1;
    this.B = str1;
    this.I = bool2;
    this.H = str3;
    this.v = i4;
    this.w = i6;
    this.C = ((String)localObject2);
    this.K = bool3;
    this.Q = f1;
    this.R = f2;
    this.S = f3;
    this.T = localObject3;
    this.L = ((Bundle)localObject1).getBoolean("needEvent", this.L);
    this.M = ((Bundle)localObject1).getBoolean("needBGMEvent", this.M);
    bool1 = this.O;
    if (paramBundle.keySet().contains("remoteMirror")) {
      bool1 = ((Bundle)localObject1).getBoolean("remoteMirror");
    } else if (paramBundle.keySet().contains("mirror")) {
      bool1 = ((Bundle)localObject1).getBoolean("mirror");
    }
    if (bool1 != this.O) {
      this.d.setMirror(bool1);
    }
    this.O = bool1;
    i2 = ((Bundle)localObject1).getInt("beauty", this.D);
    i3 = ((Bundle)localObject1).getInt("whiteness", this.E);
    paramBundle = ((Bundle)localObject1).getString("beautyStyle", this.F);
    if ((paramBoolean) || (i2 != this.D) || (i3 != this.E) || (!paramBundle.equalsIgnoreCase(this.F)))
    {
      if (paramBundle.equalsIgnoreCase("nature")) {
        this.d.setBeautyFilter(1, i2, i3, 2);
      }
    }
    else {
      break label2133;
    }
    this.d.setBeautyFilter(0, i2, i3, 2);
    label2133:
    i1 = 0;
    this.D = i2;
    this.E = i3;
    this.F = paramBundle;
    paramBundle = ((Bundle)localObject1).getString("filterImage", this.G);
    if (!paramBundle.equalsIgnoreCase(this.G))
    {
      localObject2 = BitmapFactory.decodeFile(paramBundle);
      this.d.setFilter((Bitmap)localObject2);
    }
    this.G = paramBundle;
    i2 = ((Bundle)localObject1).getInt("audioReverbType", this.Y);
    if (i2 != this.Y) {
      this.d.setReverb(i2);
    }
    this.Y = i2;
    bool1 = ((Bundle)localObject1).getBoolean("needAudioVolume", this.ab);
    if (bool1 != this.ab)
    {
      paramBundle = this.d;
      if (bool1) {
        i1 = 300;
      }
      paramBundle.enableAudioVolumeEvaluation(i1);
    }
    this.ab = bool1;
    bool1 = ((Bundle)localObject1).getBoolean("debug", this.N);
    if ((paramBoolean) || (bool1 != this.N)) {
      this.d.showDebugLog(bool1);
    }
    this.N = bool1;
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder;
      if ((!str.equalsIgnoreCase("pushUrl")) && (!str.equalsIgnoreCase("orientation")) && (!str.equalsIgnoreCase("backgroundImage")) && (!str.equalsIgnoreCase("audioQuality")) && (!str.equalsIgnoreCase("watermarkImage")) && (!str.equalsIgnoreCase("audioVolumeType")) && (!str.equalsIgnoreCase("localMirror")) && (!str.equalsIgnoreCase("devicePosition")) && (!str.equalsIgnoreCase("beautyStyle")) && (!str.equalsIgnoreCase("filterImage")))
      {
        if ((!str.equalsIgnoreCase("mode")) && (!str.equalsIgnoreCase("focusMode")) && (!str.equalsIgnoreCase("beauty")) && (!str.equalsIgnoreCase("whiteness")) && (!str.equalsIgnoreCase("aspect")) && (!str.equalsIgnoreCase("videoWidth")) && (!str.equalsIgnoreCase("videoHeight")) && (!str.equalsIgnoreCase("audioReverbType")) && (!str.equalsIgnoreCase("minBitrate")) && (!str.equalsIgnoreCase("maxBitrate")))
        {
          if ((!str.equalsIgnoreCase("hide")) && (!str.equalsIgnoreCase("autopush")) && (!str.equalsIgnoreCase("muted")) && (!str.equalsIgnoreCase("enableCamera")) && (!str.equalsIgnoreCase("enableMic")) && (!str.equalsIgnoreCase("enableAGC")) && (!str.equalsIgnoreCase("enableANS")) && (!str.equalsIgnoreCase("enableEarMonitor")) && (!str.equalsIgnoreCase("backgroundMute")) && (!str.equalsIgnoreCase("zoom")) && (!str.equalsIgnoreCase("needEvent")) && (!str.equalsIgnoreCase("needBGMEvent")) && (!str.equalsIgnoreCase("debug")) && (!str.equalsIgnoreCase("mirror")) && (!str.equalsIgnoreCase("remoteMirror")) && (!str.equalsIgnoreCase("needAudioVolume")))
          {
            if ((str.equalsIgnoreCase("watermarkLeft")) || (str.equalsIgnoreCase("watermarkTop")) || (str.equalsIgnoreCase("watermarkWidth")))
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
    com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.i) && (paramBoolean))
    {
      this.b.setVisibility(0);
      this.d.startCameraPreview(this.b);
      this.i = true;
    }
  }
  
  private void c()
  {
    this.d.stopCameraPreview(true);
    this.i = false;
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d.startAudioRecord();
    }
  }
  
  private void d()
  {
    this.d.stopAudioRecord();
  }
  
  public k a()
  {
    if (!this.h) {
      return new k(-3, "uninited livePusher");
    }
    this.d.stopBGM();
    c();
    d();
    this.d.stopPusher();
    this.d.setPushListener(null);
    this.h = false;
    return new k();
  }
  
  public k a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new k(-1, "invalid params");
    }
    a("updateLivePusher", paramBundle);
    if (!this.h) {
      return new k(-3, "uninited livePusher");
    }
    a(paramBundle, false);
    String str1 = paramBundle.getString("pushUrl", this.g);
    if ((str1 != null) && (!str1.isEmpty()))
    {
      String str2 = this.g;
      if ((str2 != null) && (!str2.equalsIgnoreCase(str1)) && (this.d.isPushing()))
      {
        com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
        c();
        d();
        this.d.stopPusher();
      }
    }
    this.g = str1;
    this.d.setPusherUrl(this.g);
    this.s = paramBundle.getBoolean("autopush", this.s);
    if (this.s)
    {
      paramBundle = this.g;
      if ((paramBundle != null) && (!paramBundle.isEmpty()) && (!this.d.isPushing()))
      {
        com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
        b(this.z);
        c(this.A);
        this.d.startPusher(this.g);
      }
    }
    return new k();
  }
  
  public k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    if ((paramTXCloudVideoView != null) && (paramBundle != null))
    {
      a("InitLivePusher", paramBundle);
      this.b = paramTXCloudVideoView;
      this.b.disableLog(false);
      this.g = paramBundle.getString("pushUrl", "");
      this.d.setPusherUrl(this.g);
      a(paramBundle, true);
      this.s = paramBundle.getBoolean("autopush", this.s);
      if (this.s)
      {
        paramTXCloudVideoView = this.g;
        if ((paramTXCloudVideoView != null) && (!paramTXCloudVideoView.isEmpty()) && (!this.d.isPushing()))
        {
          com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", "initLivePusher: startPusher");
          b(this.z);
          c(this.A);
          this.d.startPusher(this.g);
        }
      }
      this.h = true;
      return new k();
    }
    return new k(-1, "invalid params");
  }
  
  public k a(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new k(-1, "invalid params");
    }
    if (!this.h) {
      return new k(-3, "uninited livePusher");
    }
    String str2 = "";
    String str1;
    if (paramJSONObject != null) {
      str1 = paramJSONObject.toString();
    } else {
      str1 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("operateLivePusher: type = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" params = ");
    localStringBuilder.append(str1);
    com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", localStringBuilder.toString());
    boolean bool1;
    int i1;
    int i2;
    if (paramString.equalsIgnoreCase("start"))
    {
      paramString = this.g;
      if ((paramString != null) && (!paramString.isEmpty()) && (!this.d.isPushing()))
      {
        b(this.z);
        c(this.A);
        this.d.startPusher(this.g);
      }
    }
    else
    {
      bool1 = paramString.equalsIgnoreCase("stop");
      i1 = 0;
      i2 = 0;
      boolean bool2 = false;
      if (bool1)
      {
        this.J = false;
        this.d.stopBGM();
        c();
        d();
        this.d.stopPusher();
      }
      else
      {
        bool1 = paramString.equalsIgnoreCase("pause");
        localStringBuilder = null;
        if (bool1)
        {
          if ((this.J) && (this.d.isPushing())) {
            this.d.turnOnFlashLight(false);
          }
          this.d.pausePusher();
          this.r = this.q;
          if (this.r) {
            a("pauseBGM", null);
          }
        }
        else if (paramString.equalsIgnoreCase("resume"))
        {
          this.d.resumePusher();
          if (this.r) {
            a("resumeBGM", null);
          }
        }
        else if (paramString.equalsIgnoreCase("startPreview"))
        {
          if (this.d.isPushing())
          {
            com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", "do not support startPreview when pushing");
          }
          else
          {
            c();
            b(this.z);
          }
        }
        else if (paramString.equalsIgnoreCase("stopPreview"))
        {
          if (this.d.isPushing()) {
            com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
          } else {
            c();
          }
        }
        else if (paramString.equalsIgnoreCase("switchCamera"))
        {
          this.j ^= true;
          this.c.setFrontCamera(this.j);
          this.d.switchCamera();
        }
        else if (paramString.equalsIgnoreCase("snapshot"))
        {
          bool1 = bool2;
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
          a(bool1, this.n);
        }
        else
        {
          bool1 = paramString.equalsIgnoreCase("toggleTorch");
          str1 = "Success";
          if (bool1)
          {
            if (this.d.isPushing())
            {
              bool1 = this.J ^ true;
              bool2 = this.d.turnOnFlashLight(bool1);
              if (!bool2) {
                bool1 = this.J;
              }
              this.J = bool1;
              if (!bool2) {
                i1 = -2;
              }
              if (!bool2) {
                str1 = "Failed";
              }
              return new k(i1, str1);
            }
            return new k(-2, "fail");
          }
          if (paramString.equalsIgnoreCase("playBGM"))
          {
            paramString = str2;
            if (paramJSONObject != null) {
              paramString = paramJSONObject.optString("BGMFilePath", "");
            }
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("playBGM filePath = ");
            paramJSONObject.append(paramString);
            com.tencent.luggage.wxa.qz.o.d("TXLivePusherJSAdapter", paramJSONObject.toString());
            if ((paramString != null) && (paramString.length() > 0)) {
              this.d.playBGM(paramString);
            } else {
              return new k(-2, "fail");
            }
          }
          else if (paramString.equalsIgnoreCase("stopBGM"))
          {
            this.d.stopBGM();
            this.q = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.d.pauseBGM();
            this.q = false;
          }
          else if (paramString.equalsIgnoreCase("resumeBGM"))
          {
            this.d.resumeBGM();
            this.q = true;
          }
          else
          {
            bool1 = paramString.equalsIgnoreCase("setBGMVolume");
            double d1 = 1.0D;
            if (bool1)
            {
              if (paramJSONObject != null) {
                d1 = paramJSONObject.optDouble("volume", 1.0D);
              }
              this.d.setBGMVolume((float)d1);
            }
            else
            {
              if (!paramString.equalsIgnoreCase("setMICVolume")) {
                break label905;
              }
              if (paramJSONObject != null) {
                d1 = paramJSONObject.optDouble("volume", 1.0D);
              }
              this.d.setMicVolume((float)d1);
            }
          }
        }
      }
    }
    return new k();
    label905:
    if (paramString.equalsIgnoreCase("sendMessage"))
    {
      paramString = localStringBuilder;
      if (paramJSONObject != null) {
        paramString = paramJSONObject.optString("msg");
      }
      if (paramString != null)
      {
        bool1 = this.d.sendMessageEx(paramString.getBytes());
        if (bool1) {
          i1 = i2;
        } else {
          i1 = -2;
        }
        if (!bool1) {
          str1 = "Failed";
        }
        return new k(i1, str1);
      }
      return new k(-2, "fail");
    }
    return new k(-4, "invalid operate command");
  }
  
  public k a(boolean paramBoolean)
  {
    this.l = this.d.isPushing();
    if (this.l)
    {
      if (paramBoolean)
      {
        this.m = paramBoolean;
        if (this.L)
        {
          ITXLivePushListener localITXLivePushListener = this.e;
          if (localITXLivePushListener != null) {
            localITXLivePushListener.onPushEvent(5000, new Bundle());
          }
        }
        return a("stop", null);
      }
      return a("pause", null);
    }
    return new k();
  }
  
  public void a(int paramInt)
  {
    this.ac.post(new o.1(this, paramInt));
  }
  
  public void a(ITXLivePushListener paramITXLivePushListener)
  {
    this.e = paramITXLivePushListener;
  }
  
  public void a(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.p = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.n = paramITXSnapshotListener;
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.o = paramOnBGMNotify;
  }
  
  public void a(boolean paramBoolean, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    WXLivePusher localWXLivePusher = this.d;
    if ((localWXLivePusher != null) && (localWXLivePusher.isPushing())) {
      this.d.snapshot(new o.2(this, paramITXSnapshotListener, paramBoolean));
    }
  }
  
  public k b()
  {
    if (this.l)
    {
      if (this.m) {
        return a("start", null);
      }
      return a("resume", null);
    }
    return new k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.o
 * JD-Core Version:    0.7.0.1
 */