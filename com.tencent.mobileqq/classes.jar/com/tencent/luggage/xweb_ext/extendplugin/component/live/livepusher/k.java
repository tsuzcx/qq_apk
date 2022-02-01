package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class k
  implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  @NonNull
  private static h.b ah = h.b.a;
  private int A = 0;
  private boolean B = true;
  private boolean C = true;
  private String D = "vertical";
  private String E = "high";
  private int F = 5;
  private int G = 3;
  private String H = "smooth";
  private String I = "";
  private String J = "";
  private boolean K = false;
  private boolean L = false;
  private boolean M = true;
  private boolean N = false;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  private String R = "auto";
  private float S = 0.0F;
  private float T = 0.0F;
  private float U = 0.1F;
  private String V = "";
  private boolean W = false;
  private boolean X = false;
  private boolean Y = false;
  private String Z = "auto";
  private Context a;
  private int aa = 0;
  private int ab = 368;
  private int ac = 640;
  private boolean ad = false;
  @NonNull
  private final h ae = ah.a();
  private boolean af = false;
  private boolean ag = false;
  private TXCloudVideoView b;
  private WXLivePushConfig c;
  @NonNull
  private final WXLivePusher d;
  private ITXLivePushListener e;
  private Surface f;
  private Handler g;
  private int h = 0;
  private String i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = true;
  private String m = "front";
  private boolean n = false;
  private boolean o = false;
  private TXLivePusher.ITXSnapshotListener p;
  private TXLivePusher.OnBGMNotify q;
  private TXLivePusher.ITXAudioVolumeEvaluationListener r;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private int v = 1;
  private int w = 2;
  private int x = -1;
  private int y = -1;
  private boolean z = false;
  
  public k(Context paramContext)
  {
    this.a = paramContext;
    this.c = new WXLivePushConfig();
    this.d = new WXLivePusher(paramContext);
    this.d.setConfig(this.c);
    this.d.setPushListener(this);
    this.d.setBGMNofify(this);
    this.d.setAudioVolumeEvaluationListener(this);
  }
  
  private float a(@NonNull JSONObject paramJSONObject, @NonNull String paramString)
  {
    float f2 = (float)paramJSONObject.optDouble(paramString, 1.0D);
    float f1 = f2;
    if (f2 < 0.0F)
    {
      o.d("TXLivePusherJSAdapter", "parseAlpha, alpha(%f) is illegal", new Object[] { Float.valueOf(f2) });
      f1 = 0.0F;
    }
    f2 = f1;
    if (f1 > 1.0F)
    {
      o.d("TXLivePusherJSAdapter", "parseAlpha, alpha(%f)  is illegal", new Object[] { Float.valueOf(f1) });
      f2 = 1.0F;
    }
    return f2;
  }
  
  private void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustHomeOrientation, angle:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", orientation:");
    localStringBuilder.append(paramString);
    o.d("TXLivePusherJSAdapter", localStringBuilder.toString());
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
          label90:
          paramInt = 1;
          break label141;
        }
      }
      for (;;)
      {
        paramInt = 2;
        break label141;
        if (paramInt == 0)
        {
          if (!paramString.equals("horizontal")) {
            break label90;
          }
          paramInt = i1;
          break label141;
        }
        if (paramInt != 2) {
          break label137;
        }
        if (!paramString.equals("horizontal")) {
          break;
        }
      }
      label137:
      paramInt = -2147483648;
    }
    label141:
    paramString = new StringBuilder();
    paramString.append("adjustHomeOrientation, homeOrientation:");
    paramString.append(paramInt);
    o.d("TXLivePusherJSAdapter", paramString.toString());
    if (paramInt != -2147483648)
    {
      this.c.setHomeOrientation(paramInt);
      this.d.setConfig(this.c);
    }
  }
  
  private void a(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull g.a parama)
  {
    if (!paramBundle.containsKey(paramString))
    {
      o.e("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, %s is not exist in params", new Object[] { paramString });
      return;
    }
    float f2 = paramBundle.getFloat(paramString, 0.0F);
    float f1 = f2;
    if (f2 < 0.0F)
    {
      o.d("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", new Object[] { Float.valueOf(f2), paramString });
      f1 = 0.0F;
    }
    f2 = f1;
    if (f1 > 1.0F)
    {
      o.d("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", new Object[] { Float.valueOf(f1), paramString });
      f2 = 1.0F;
    }
    k();
    o.e("TXLivePusherJSAdapter", "applyFaceBeauty, faceBeautyType: %s, rate: %f", new Object[] { parama, Float.valueOf(f2) });
    this.ae.a(parama, f2);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0)) {
      return;
    }
    int i7 = paramBundle.getInt("mode", this.v);
    if ((paramBoolean) || (i7 != this.v)) {
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
    int i5 = this.x;
    int i3 = this.y;
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
      o.b("TXLivePusherJSAdapter", ((StringBuilder)localObject1).toString());
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
    i2 = paramBundle.getInt("aspect", this.w);
    i3 = paramBundle.getInt("videoWidth", this.ab);
    i5 = paramBundle.getInt("videoHeight", this.ac);
    Object localObject2 = paramBundle.getString("audioQuality", this.E);
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
    int i8 = paramBundle.getInt("focusMode", this.A);
    Object localObject1 = this.c;
    if (i8 != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((WXLivePushConfig)localObject1).setTouchFocus(bool1);
    boolean bool2 = this.l;
    boolean bool1 = bool2;
    if (paramBundle.keySet().contains("devicePosition"))
    {
      this.m = paramBundle.getString("devicePosition", this.m);
      bool1 = bool2;
      if (this.m.equalsIgnoreCase("back")) {
        bool1 = false;
      }
      this.c.setFrontCamera(bool1);
    }
    Object localObject3 = paramBundle.getString("orientation", this.D);
    if (!((String)localObject3).equalsIgnoreCase(this.D)) {
      if (((String)localObject3).equalsIgnoreCase("horizontal"))
      {
        a(this.h, (String)localObject3);
        this.d.setRenderRotation(90);
      }
      else if (((String)localObject3).equalsIgnoreCase("vertical"))
      {
        a(this.h, (String)localObject3);
        this.d.setRenderRotation(0);
      }
    }
    String str1 = paramBundle.getString("localMirror", this.R);
    if (!str1.equalsIgnoreCase(this.R)) {
      if (str1.equalsIgnoreCase("auto")) {
        this.c.setLocalVideoMirrorType(0);
      } else if (str1.equalsIgnoreCase("enable")) {
        this.c.setLocalVideoMirrorType(1);
      } else if (str1.equalsIgnoreCase("disable")) {
        this.c.setLocalVideoMirrorType(2);
      }
    }
    String str2 = paramBundle.getString("backgroundImage", this.J);
    localObject1 = BitmapFactory.decodeFile(str2);
    if (localObject1 != null) {
      this.c.setPauseImg((Bitmap)localObject1);
    }
    bool2 = paramBundle.getBoolean("backgroundMute", this.K);
    if (i7 == 6) {
      this.c.setPauseFlag(1);
    } else {
      this.c.setPauseFlag(3);
    }
    boolean bool3 = paramBundle.getBoolean("zoom", this.M);
    this.c.setEnableZoom(bool3);
    float f1 = this.S;
    Object localObject4 = localObject2;
    f1 = paramBundle.getFloat("watermarkLeft", f1);
    float f2 = paramBundle.getFloat("watermarkTop", this.T);
    float f3 = paramBundle.getFloat("watermarkWidth", this.U);
    localObject1 = paramBundle.getString("watermarkImage", this.V);
    Object localObject5 = BitmapFactory.decodeFile((String)localObject1);
    if (localObject5 != null) {
      this.c.setWatermark((Bitmap)localObject5, f1, f2, f3);
    } else if ((this.d.isPushing()) && (paramBundle.keySet().contains("watermarkImage"))) {
      this.c.setWatermark((Bitmap)localObject5, f1, f2, f3);
    }
    boolean bool4 = paramBundle.getBoolean("enableAGC", this.W);
    this.c.enableAGC(bool4);
    boolean bool5 = paramBundle.getBoolean("enableANS", this.X);
    this.c.enableANS(bool5);
    boolean bool6 = paramBundle.getBoolean("enableEarMonitor", this.Y);
    this.c.enableAudioEarMonitoring(bool6);
    localObject5 = paramBundle.getString("audioVolumeType", this.Z);
    if (((String)localObject5).equalsIgnoreCase("voicecall")) {
      this.c.setVolumeType(2);
    } else if (((String)localObject5).equalsIgnoreCase("media")) {
      this.c.setVolumeType(1);
    } else {
      this.c.setVolumeType(0);
    }
    boolean bool7 = paramBundle.getBoolean("enableCamera", this.B);
    this.c.enablePureAudioPush(bool7 ^ true);
    if ((i2 == this.w) && (i4 == this.x) && (i6 == this.y) && (i8 == this.A) && (bool1 == this.l) && (bool2 == this.K) && (bool3 == this.M) && (bool4 == this.W) && (bool5 == this.X) && (bool6 == this.Y) && (bool7 == this.B) && (i3 == this.ab) && (i5 == this.ac) && (f1 == this.S) && (f2 == this.T) && (f3 == this.U) && (str1.equalsIgnoreCase(this.R)) && (((String)localObject5).equalsIgnoreCase(this.Z))) {
      if ((str2.equalsIgnoreCase(this.J)) && (((String)localObject3).equalsIgnoreCase(this.D))) {
        if (localObject4.equalsIgnoreCase(this.E))
        {
          if (((String)localObject1).equalsIgnoreCase(this.V))
          {
            i1 = 0;
            break label1545;
          }
        }
        else {}
      }
    }
    i1 = 1;
    label1545:
    localObject4 = localObject1;
    if ((!paramBoolean) && (i1 == 0)) {
      break label1575;
    }
    this.d.setConfig(this.c);
    label1575:
    if (bool7 != this.B) {
      if (bool7)
      {
        e();
        b(true);
      }
      else
      {
        e();
      }
    }
    boolean bool8;
    if (paramBundle.keySet().contains("enableMic"))
    {
      bool8 = paramBundle.getBoolean("enableMic", this.C);
      if (bool8 != this.C) {
        if (bool8)
        {
          f();
          c(true);
        }
        else
        {
          f();
        }
      }
      if ((!paramBoolean) && (bool8 == this.C)) {
        break label1693;
      }
      this.d.setMute(bool8 ^ true);
      label1693:
      this.C = bool8;
      this.z = (bool8 ^ true);
    }
    else if (paramBundle.keySet().contains("muted"))
    {
      bool8 = paramBundle.getBoolean("muted", this.z);
      if ((paramBoolean) || (bool8 != this.z)) {
        this.d.setMute(bool8);
      }
      this.z = bool8;
    }
    localObject1 = paramBundle;
    this.v = i7;
    this.w = i2;
    this.A = i8;
    this.B = bool7;
    this.W = bool4;
    this.X = bool5;
    this.Y = bool6;
    this.R = str1;
    this.Z = ((String)localObject5);
    this.ab = i3;
    this.ac = i5;
    this.l = bool1;
    this.D = ((String)localObject3);
    this.K = bool2;
    this.J = str2;
    this.x = i4;
    this.y = i6;
    this.E = ((String)localObject2);
    this.M = bool3;
    this.S = f1;
    this.T = f2;
    this.U = f3;
    this.V = localObject4;
    this.N = ((Bundle)localObject1).getBoolean("needEvent", this.N);
    this.O = ((Bundle)localObject1).getBoolean("needBGMEvent", this.O);
    bool1 = this.Q;
    if (paramBundle.keySet().contains("remoteMirror")) {
      bool1 = ((Bundle)localObject1).getBoolean("remoteMirror");
    } else if (paramBundle.keySet().contains("mirror")) {
      bool1 = ((Bundle)localObject1).getBoolean("mirror");
    }
    if (bool1 != this.Q) {
      this.d.setMirror(bool1);
    }
    this.Q = bool1;
    i2 = ((Bundle)localObject1).getInt("beauty", this.F);
    i3 = ((Bundle)localObject1).getInt("whiteness", this.G);
    localObject2 = ((Bundle)localObject1).getString("beautyStyle", this.H);
    if ((paramBoolean) || (i2 != this.F) || (i3 != this.G) || (!((String)localObject2).equalsIgnoreCase(this.H)))
    {
      if (((String)localObject2).equalsIgnoreCase("nature")) {
        this.d.setBeautyFilter(1, i2, i3, 2);
      }
    }
    else {
      break label2140;
    }
    this.d.setBeautyFilter(0, i2, i3, 2);
    label2140:
    i1 = 0;
    this.F = i2;
    this.G = i3;
    this.H = ((String)localObject2);
    localObject2 = ((Bundle)localObject1).getString("filterImage", this.I);
    if (!((String)localObject2).equalsIgnoreCase(this.I))
    {
      localObject3 = BitmapFactory.decodeFile((String)localObject2);
      this.d.setFilter((Bitmap)localObject3);
    }
    this.I = ((String)localObject2);
    i2 = ((Bundle)localObject1).getInt("audioReverbType", this.aa);
    if (i2 != this.aa) {
      this.d.setReverb(i2);
    }
    this.aa = i2;
    bool1 = ((Bundle)localObject1).getBoolean("needAudioVolume", this.ad);
    if (bool1 != this.ad)
    {
      localObject2 = this.d;
      if (bool1) {
        i1 = 300;
      }
      ((WXLivePusher)localObject2).enableAudioVolumeEvaluation(i1);
    }
    this.ad = bool1;
    bool1 = ((Bundle)localObject1).getBoolean("debug", this.P);
    if ((paramBoolean) || (bool1 != this.P)) {
      this.d.showDebugLog(bool1);
    }
    this.P = bool1;
    this.ag = ((Bundle)localObject1).getBoolean("customEffect", this.ag);
    if (g())
    {
      o.d("TXLivePusherJSAdapter", "parseAndApplyParams, useCustomEffect");
      c(paramBundle);
      d(paramBundle);
      e(paramBundle);
      f(paramBundle);
    }
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
    o.d("TXLivePusherJSAdapter", paramString);
  }
  
  private boolean a(@NonNull JSONObject paramJSONObject)
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "applyFilter, useCustomEffect is false");
      return false;
    }
    String str = paramJSONObject.optString("path", null);
    if (af.c(str))
    {
      o.c("TXLivePusherJSAdapter", "applyFilter, resourcePath is null");
      return false;
    }
    float f2 = (float)paramJSONObject.optDouble("alpha", 1.0D);
    float f1 = f2;
    if (f2 < 0.0F)
    {
      o.d("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, alpha(%f) is illegal", new Object[] { Float.valueOf(f2) });
      f1 = 0.0F;
    }
    f2 = f1;
    if (f1 > 1.0F)
    {
      o.d("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, alpha(%f)  is illegal", new Object[] { Float.valueOf(f1) });
      f2 = 1.0F;
    }
    k();
    o.e("TXLivePusherJSAdapter", "applyFilter, resourcePath: %s, alpha: %f", new Object[] { str, Float.valueOf(f2) });
    this.ae.a(str, f2);
    return true;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.k) && (paramBoolean))
    {
      Object localObject = this.b;
      if (localObject != null) {
        ((TXCloudVideoView)localObject).setVisibility(0);
      }
      localObject = this.f;
      if (localObject != null) {
        this.d.setSurface((Surface)localObject);
      }
      this.d.startCameraPreview(this.b);
      this.k = true;
    }
  }
  
  private boolean b(@NonNull JSONObject paramJSONObject)
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "applySticker, useCustomEffect is false");
      return false;
    }
    String str = paramJSONObject.optString("path", null);
    if (af.c(str))
    {
      o.d("TXLivePusherJSAdapter", "applySticker, resourcePath is null");
      return c(paramJSONObject);
    }
    paramJSONObject = l(paramJSONObject);
    if (paramJSONObject == null)
    {
      o.c("TXLivePusherJSAdapter", "applySticker, stickerType is null");
      return false;
    }
    k();
    o.e("TXLivePusherJSAdapter", "applySticker, stickerType: %s, resourcePath: %s", new Object[] { paramJSONObject, str });
    this.ae.a(paramJSONObject, str);
    return true;
  }
  
  private void c(@NonNull Bundle paramBundle)
  {
    a(paramBundle, "skinWhiteness", g.a.a);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d.startAudioRecord();
    }
  }
  
  private boolean c(@NonNull JSONObject paramJSONObject)
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, useCustomEffect is false");
      return false;
    }
    g.c localc = l(paramJSONObject);
    if (localc == null)
    {
      o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType is null");
      return false;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("stickers");
    ArrayList localArrayList;
    int i1;
    JSONObject localJSONObject;
    if (localJSONArray != null)
    {
      int i2 = localJSONArray.length();
      if (i2 != 0)
      {
        localArrayList = new ArrayList(i2);
        i1 = 0;
        if (i1 < i2)
        {
          localJSONObject = localJSONArray.optJSONObject(i1);
          if (localJSONObject == null)
          {
            o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerJsonObj(%d) is null", new Object[] { Integer.valueOf(i1) });
            return false;
          }
        }
      }
    }
    label499:
    for (;;)
    {
      try
      {
        str1 = localJSONObject.getString("title");
        i3 = localJSONObject.getInt("len");
        str2 = localJSONObject.getString("path");
        if (af.c(str2))
        {
          o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, resDirPath is empty", new Object[] { Integer.valueOf(i1) });
          return false;
        }
        str3 = localJSONObject.optString("md5", "");
        paramJSONObject = null;
        if (g.c.c != localc) {
          if (g.c.b != localc) {
            break label499;
          }
        }
        paramJSONObject = localJSONObject.getJSONArray("pos");
        if (4 != paramJSONObject.length())
        {
          o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, length of posJsonArr is not 4", new Object[] { Integer.valueOf(i1) });
          return false;
        }
        paramJSONObject = new StickerItemInfo.a(paramJSONObject.getDouble(0), paramJSONObject.getDouble(1), paramJSONObject.getDouble(2), paramJSONObject.getDouble(3));
      }
      catch (Exception paramJSONObject)
      {
        String str1;
        int i3;
        String str2;
        String str3;
        Object localObject1;
        Object localObject2;
        int i4;
        o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, convert fail since %s", new Object[] { paramJSONObject });
        return false;
      }
      localObject1 = StickerItemInfo.StickerBackType.BACKGROUND;
      if (g.c.a == localc)
      {
        localObject2 = StickerItemInfo.StickerBackType.from(localJSONObject.getInt("segtype"));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, type is null", new Object[] { Integer.valueOf(i1) });
          return false;
        }
      }
      i4 = localJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
      localObject2 = StickerItemInfo.TriggerAction.from(i4);
      if (localObject2 == null)
      {
        o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, actionInt: %d, action is null", new Object[] { Integer.valueOf(i1), Integer.valueOf(i4) });
        return false;
      }
      localArrayList.add(new StickerItemInfo(localJSONObject.optInt("id", i1), str1, i3, (StickerItemInfo.TriggerAction)localObject2, str2, str3, paramJSONObject, (StickerItemInfo.StickerBackType)localObject1));
      i1 += 1;
      break;
      k();
      o.e("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType: %s", new Object[] { localc });
      return this.ae.a(localc, localArrayList);
      o.c("TXLivePusherJSAdapter", "applyStickerWorkaround, stickersJsonArr is empty");
      return false;
    }
  }
  
  private void d(@NonNull Bundle paramBundle)
  {
    a(paramBundle, "skinSmoothness", g.a.b);
  }
  
  private boolean d(@NonNull JSONObject paramJSONObject)
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "applyMakeup, useCustomEffect is false");
      return false;
    }
    String str = paramJSONObject.optString("path", null);
    if (af.c(str))
    {
      o.d("TXLivePusherJSAdapter", "applyMakeup, resourcePath is null");
      return e(paramJSONObject);
    }
    paramJSONObject = m(paramJSONObject);
    if (paramJSONObject == null)
    {
      o.c("TXLivePusherJSAdapter", "applyMakeup, makeupType is null");
      return false;
    }
    k();
    o.e("TXLivePusherJSAdapter", "applyMakeup, makeupType: %s, resourcePath: %s", new Object[] { paramJSONObject, str });
    this.ae.a(paramJSONObject, str);
    return true;
  }
  
  private void e()
  {
    this.d.stopCameraPreview(true);
    this.k = false;
  }
  
  private void e(@NonNull Bundle paramBundle)
  {
    a(paramBundle, "faceThinness", g.a.c);
  }
  
  private boolean e(@NonNull JSONObject paramJSONObject)
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, useCustomEffect is false");
      return false;
    }
    g.b localb = m(paramJSONObject);
    if (localb == null)
    {
      o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, makeupType is null");
      return false;
    }
    paramJSONObject = paramJSONObject.optJSONObject("makeup");
    if (paramJSONObject == null)
    {
      o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, makeupJsonObj is null");
      return false;
    }
    k();
    o.e("TXLivePusherJSAdapter", "applyMakeupWorkaround, makeupType: %s", new Object[] { localb });
    int i1 = k.3.a[localb.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5)
            {
              o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, should not reach");
              return false;
            }
            paramJSONObject = j(paramJSONObject);
            if (paramJSONObject == null)
            {
              o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, eyeBrowInfo is null");
              return false;
            }
            return this.ae.a(paramJSONObject);
          }
          paramJSONObject = i(paramJSONObject);
          if (paramJSONObject == null)
          {
            o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, faceContourInfo is null");
            return false;
          }
          return this.ae.a(paramJSONObject);
        }
        paramJSONObject = h(paramJSONObject);
        if (paramJSONObject == null)
        {
          o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, blusherStickInfo is null");
          return false;
        }
        return this.ae.a(paramJSONObject);
      }
      paramJSONObject = g(paramJSONObject);
      if (paramJSONObject == null)
      {
        o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, eyeShadowInfo is null");
        return false;
      }
      return this.ae.a(paramJSONObject);
    }
    paramJSONObject = f(paramJSONObject);
    if (paramJSONObject == null)
    {
      o.c("TXLivePusherJSAdapter", "applyMakeupWorkaround, lipStickInfo is null");
      return false;
    }
    return this.ae.a(paramJSONObject);
  }
  
  @Nullable
  private i f(@NonNull JSONObject paramJSONObject)
  {
    float f1 = a(paramJSONObject, "alpha");
    i.a locala = k(paramJSONObject);
    if (locala == null)
    {
      o.c("TXLivePusherJSAdapter", "parseLipStickInfo, color is null");
      return null;
    }
    i.b localb = i.b.a(paramJSONObject.optInt("lipstickType", 0));
    if (localb == null)
    {
      o.c("TXLivePusherJSAdapter", "parseLipStickInfo, type is null");
      return null;
    }
    int i1 = paramJSONObject.optInt("faceModel", 0);
    if (i1 != 0)
    {
      o.c("TXLivePusherJSAdapter", "parseLipStickInfo, faceModel is illegal");
      return null;
    }
    return new i(f1, locala, localb, i1, i.c.a);
  }
  
  private void f()
  {
    this.d.stopAudioRecord();
  }
  
  private void f(@NonNull Bundle paramBundle)
  {
    a(paramBundle, "eyeBigness", g.a.d);
  }
  
  @Nullable
  private c g(@NonNull JSONObject paramJSONObject)
  {
    float f1 = a(paramJSONObject, "alpha");
    String str1 = paramJSONObject.optString("leftPath", "");
    if (af.c(str1))
    {
      o.c("TXLivePusherJSAdapter", "parseEyeShadowInfo, leftPath is empty");
      return null;
    }
    String str2 = paramJSONObject.optString("leftPathMD5", "");
    return new c(f1, str1, str2, str1, str2, paramJSONObject.optString("shimmerPosition", null), paramJSONObject.optString("shimmerPositionMD5", ""));
  }
  
  private boolean g()
  {
    return (this.ag) && (this.ae.a());
  }
  
  @Nullable
  private a h(@NonNull JSONObject paramJSONObject)
  {
    float f1 = a(paramJSONObject, "alpha");
    a.a locala = a.a.a;
    String str1 = paramJSONObject.optString("leftPath", "");
    if (af.c(str1))
    {
      o.c("TXLivePusherJSAdapter", "parseBlusherStickInfo, leftPath is empty");
      return null;
    }
    String str2 = paramJSONObject.optString("leftPathMD5", "");
    String str3 = paramJSONObject.optString("rightPath", "");
    if (af.c(str3))
    {
      o.c("TXLivePusherJSAdapter", "parseBlusherStickInfo, rightPath is empty");
      return null;
    }
    String str4 = paramJSONObject.optString("rightPathMD5", "");
    int i1 = paramJSONObject.optInt("faceModel", 0);
    if (i1 != 0)
    {
      o.c("TXLivePusherJSAdapter", "parseBlusherStickInfo, faceModel is illegal");
      return null;
    }
    return new a(f1, locala, str1, str2, str3, str4, i1);
  }
  
  private boolean h()
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "clearFilters, useCustomEffect is false");
      return false;
    }
    k();
    o.e("TXLivePusherJSAdapter", "clearFilters");
    this.ae.b();
    return true;
  }
  
  @Nullable
  private d i(@NonNull JSONObject paramJSONObject)
  {
    float f1 = a(paramJSONObject, "highlightAlpha");
    float f2 = a(paramJSONObject, "shadowAlpha");
    String str1 = paramJSONObject.optString("highlightPath", "");
    if (af.c(str1))
    {
      o.c("TXLivePusherJSAdapter", "parseFaceContourInfo, highLightPath is empty");
      return null;
    }
    String str2 = paramJSONObject.optString("highlightPathMD5", "");
    String str3 = paramJSONObject.optString("shadowPath", "");
    if (af.c(str3))
    {
      o.c("TXLivePusherJSAdapter", "parseFaceContourInfo, shadowPath is empty");
      return null;
    }
    String str4 = paramJSONObject.optString("shadowPathMD5", "");
    int i1 = paramJSONObject.optInt("faceModel", 0);
    if (i1 != 0)
    {
      o.c("TXLivePusherJSAdapter", "parseFaceContourInfo, faceModel is illegal");
      return null;
    }
    return new d(f1, f2, str1, str2, str3, str4, i1);
  }
  
  private boolean i()
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "clearStickers, useCustomEffect is false");
      return false;
    }
    k();
    o.e("TXLivePusherJSAdapter", "clearStickers");
    this.ae.c();
    return true;
  }
  
  @Nullable
  private b j(@NonNull JSONObject paramJSONObject)
  {
    float f1 = a(paramJSONObject, "alpha");
    String str1 = paramJSONObject.optString("leftPath", "");
    if (af.c(str1))
    {
      o.c("TXLivePusherJSAdapter", "parseEyeBrowInfo, leftPath is empty");
      return null;
    }
    String str2 = paramJSONObject.optString("leftPathMD5", "");
    String str3 = paramJSONObject.optString("rightPath", "");
    if (af.c(str3))
    {
      o.c("TXLivePusherJSAdapter", "parseEyeBrowInfo, rightPath is empty");
      return null;
    }
    String str4 = paramJSONObject.optString("rightPathMD5", "");
    int i1 = paramJSONObject.optInt("faceModel", 0);
    if (i1 != 0)
    {
      o.c("TXLivePusherJSAdapter", "parseEyeBrowInfo, faceModel is illegal");
      return null;
    }
    return new b(f1, str1, str2, str3, str4, i1);
  }
  
  private boolean j()
  {
    if (!g())
    {
      o.c("TXLivePusherJSAdapter", "clearMakeups, useCustomEffect is false");
      return false;
    }
    k();
    o.e("TXLivePusherJSAdapter", "clearMakeups");
    this.ae.d();
    return true;
  }
  
  @Nullable
  private i.a k(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("color");
    if (af.c(paramJSONObject))
    {
      o.c("TXLivePusherJSAdapter", "parseColor, colorStr is empty");
      return null;
    }
    try
    {
      int i1 = Color.parseColor(paramJSONObject);
      return new i.a(Color.red(i1), Color.green(i1), Color.blue(i1));
    }
    catch (Exception paramJSONObject)
    {
      label50:
      break label50;
    }
    o.c("TXLivePusherJSAdapter", "parseColor, colorStr is illegal");
    return null;
  }
  
  private void k()
  {
    if (!this.af)
    {
      o.e("TXLivePusherJSAdapter", "applyWeEffect");
      this.c.setCustomModeType(256);
      this.d.setConfig(this.c);
      this.d.setVideoProcessListener(this.ae);
      this.af = true;
    }
  }
  
  @Nullable
  private g.c l(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("stickerType", null);
    if (af.c(paramJSONObject))
    {
      o.c("TXLivePusherJSAdapter", "parseStickerType, stickerTypeStr is empty");
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("back")) {
      return g.c.a;
    }
    if (paramJSONObject.equalsIgnoreCase("front")) {
      return g.c.b;
    }
    if (paramJSONObject.equalsIgnoreCase("2d")) {
      return g.c.c;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseStickerType, stickerTypeStr: ");
    localStringBuilder.append(paramJSONObject);
    o.c("TXLivePusherJSAdapter", localStringBuilder.toString());
    return null;
  }
  
  @Nullable
  private g.b m(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("makeupType", null);
    if (af.c(paramJSONObject))
    {
      o.c("TXLivePusherJSAdapter", "parseMakeupType, makeupTypeStr is empty");
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("lipStick")) {
      return g.b.a;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeShadow")) {
      return g.b.b;
    }
    if (paramJSONObject.equalsIgnoreCase("blusherStick")) {
      return g.b.c;
    }
    if (paramJSONObject.equalsIgnoreCase("faceContour")) {
      return g.b.d;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeBrow")) {
      return g.b.e;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseMakeupType, makeupTypeStr: ");
    localStringBuilder.append(paramJSONObject);
    o.c("TXLivePusherJSAdapter", localStringBuilder.toString());
    return null;
  }
  
  public com.tencent.luggage.wxa.fz.a a()
  {
    if (!this.j) {
      return new com.tencent.luggage.wxa.fz.a(-3, "uninited livePusher");
    }
    try
    {
      this.d.stopBGM();
      e();
      f();
      this.d.stopPusher();
      this.d.setPushListener(null);
      this.j = false;
      return new com.tencent.luggage.wxa.fz.a();
    }
    finally {}
  }
  
  public com.tencent.luggage.wxa.fz.a a(float paramFloat1, float paramFloat2)
  {
    this.d.setFocusPosition(paramFloat1, paramFloat2);
    return new com.tencent.luggage.wxa.fz.a();
  }
  
  public com.tencent.luggage.wxa.fz.a a(int paramInt1, int paramInt2)
  {
    this.d.setSurfaceSize(paramInt1, paramInt2);
    return new com.tencent.luggage.wxa.fz.a();
  }
  
  public com.tencent.luggage.wxa.fz.a a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new com.tencent.luggage.wxa.fz.a(-1, "invalid params");
    }
    if (this.e != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      this.e.onPushEvent(-9999999, localBundle);
    }
    a("InitLivePusher", paramBundle);
    this.b = null;
    this.i = paramBundle.getString("pushUrl", "");
    this.d.setPusherUrl(this.i);
    a(paramBundle, true);
    this.u = paramBundle.getBoolean("autopush", this.u);
    if (this.u)
    {
      paramBundle = this.i;
      if ((paramBundle != null) && (!paramBundle.isEmpty()) && (!this.d.isPushing()))
      {
        o.d("TXLivePusherJSAdapter", "initLivePusher: startPusher");
        b(this.B);
        c(this.C);
        if (this.B)
        {
          paramBundle = this.f;
          if (paramBundle != null) {
            this.d.setSurface(paramBundle);
          }
        }
        this.d.startPusher(this.i);
      }
    }
    this.j = true;
    return new com.tencent.luggage.wxa.fz.a();
  }
  
  public com.tencent.luggage.wxa.fz.a a(Surface paramSurface)
  {
    this.f = paramSurface;
    this.d.setSurface(paramSurface);
    return new com.tencent.luggage.wxa.fz.a();
  }
  
  public com.tencent.luggage.wxa.fz.a a(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new com.tencent.luggage.wxa.fz.a(-1, "invalid params");
    }
    if (!this.j) {
      return new com.tencent.luggage.wxa.fz.a(-3, "uninited livePusher");
    }
    String str;
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("operateLivePusher: type = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" params = ");
    localStringBuilder.append(str);
    o.d("TXLivePusherJSAdapter", localStringBuilder.toString());
    boolean bool1;
    int i6;
    int i2;
    int i7;
    int i3;
    int i8;
    int i4;
    int i9;
    int i10;
    int i11;
    int i1;
    if (paramString.equalsIgnoreCase("start"))
    {
      paramString = this.i;
      if ((paramString != null) && (!paramString.isEmpty()) && (!this.d.isPushing()))
      {
        b(this.B);
        c(this.C);
        if (this.B)
        {
          paramString = this.f;
          if (paramString != null) {
            this.d.setSurface(paramString);
          }
        }
        this.d.startPusher(this.i);
      }
    }
    else
    {
      bool1 = paramString.equalsIgnoreCase("stop");
      int i5 = 0;
      i6 = 0;
      i2 = 0;
      i7 = 0;
      i3 = 0;
      i8 = 0;
      i4 = 0;
      i9 = 0;
      boolean bool2 = false;
      if (bool1)
      {
        this.L = false;
        try
        {
          this.d.stopBGM();
          e();
          f();
          this.d.stopPusher();
        }
        finally {}
      }
      else
      {
        bool1 = paramString.equalsIgnoreCase("pause");
        str = null;
        if (bool1)
        {
          if ((this.L) && (this.d.isPushing())) {
            this.d.turnOnFlashLight(false);
          }
          this.d.pausePusher();
          this.t = this.s;
          if (this.t) {
            a("pauseBGM", null);
          }
        }
        else if (paramString.equalsIgnoreCase("resume"))
        {
          this.d.resumePusher();
          if (this.t) {
            a("resumeBGM", null);
          }
        }
        else if (paramString.equalsIgnoreCase("startPreview"))
        {
          if (this.d.isPushing())
          {
            o.d("TXLivePusherJSAdapter", "do not support startPreview when pushing");
          }
          else
          {
            e();
            b(this.B);
          }
        }
        else if (paramString.equalsIgnoreCase("stopPreview"))
        {
          if (this.d.isPushing()) {
            o.d("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
          } else {
            e();
          }
        }
        else
        {
          bool1 = paramString.equalsIgnoreCase("switchCamera");
          i10 = 1;
          i11 = 1;
          i1 = 1;
          if (bool1)
          {
            this.l ^= true;
            this.c.setFrontCamera(this.l);
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
            a(bool1, this.p);
          }
          else
          {
            if (paramString.equalsIgnoreCase("toggleTorch"))
            {
              bool1 = this.L ^ true;
              bool2 = this.d.turnOnFlashLight(bool1);
              if (!bool2) {
                bool1 = this.L;
              }
              this.L = bool1;
              if (bool2) {
                i1 = i5;
              } else {
                i1 = -2;
              }
              if (bool2) {
                paramString = "Success";
              } else {
                paramString = "Failed";
              }
              return new com.tencent.luggage.wxa.fz.a(i1, paramString);
            }
            if (paramString.equalsIgnoreCase("playBGM"))
            {
              if (paramJSONObject != null) {
                paramString = paramJSONObject.optString("BGMFilePath", "");
              } else {
                paramString = "";
              }
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("playBGM filePath = ");
              paramJSONObject.append(paramString);
              o.d("TXLivePusherJSAdapter", paramJSONObject.toString());
              if ((paramString != null) && (paramString.length() > 0)) {
                this.d.playBGM(paramString);
              } else {
                return new com.tencent.luggage.wxa.fz.a(-2, "fail");
              }
            }
            else if (paramString.equalsIgnoreCase("stopBGM"))
            {
              this.d.stopBGM();
              this.s = false;
            }
            else if (paramString.equalsIgnoreCase("pauseBGM"))
            {
              this.d.pauseBGM();
              this.s = false;
            }
            else if (paramString.equalsIgnoreCase("resumeBGM"))
            {
              this.d.resumeBGM();
              this.s = true;
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
                  break label942;
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
    }
    return new com.tencent.luggage.wxa.fz.a();
    label942:
    if (paramString.equalsIgnoreCase("sendMessage"))
    {
      paramString = str;
      if (paramJSONObject != null) {
        paramString = paramJSONObject.optString("msg");
      }
      if (paramString != null)
      {
        bool1 = this.d.sendMessageEx(paramString.getBytes());
        if (bool1) {
          i1 = i6;
        } else {
          i1 = -2;
        }
        if (bool1) {
          paramString = "Success";
        } else {
          paramString = "Failed";
        }
        return new com.tencent.luggage.wxa.fz.a(i1, paramString);
      }
      return new com.tencent.luggage.wxa.fz.a(-2, "fail");
    }
    if (paramString.equalsIgnoreCase("applyFilter"))
    {
      if ((paramJSONObject == null) || (!a(paramJSONObject))) {
        i1 = 0;
      }
      if (i1 == 0) {
        i2 = -2;
      }
      if (i1 != 0) {
        paramString = "Success";
      } else {
        paramString = "Failed";
      }
      return new com.tencent.luggage.wxa.fz.a(i2, paramString);
    }
    if (paramString.equalsIgnoreCase("clearFilters"))
    {
      bool1 = h();
      if (bool1) {
        i1 = i7;
      } else {
        i1 = -2;
      }
      if (bool1) {
        paramString = "Success";
      } else {
        paramString = "Failed";
      }
      return new com.tencent.luggage.wxa.fz.a(i1, paramString);
    }
    if (paramString.equalsIgnoreCase("applySticker"))
    {
      if ((paramJSONObject != null) && (b(paramJSONObject))) {
        i1 = i10;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        i2 = i3;
      } else {
        i2 = -2;
      }
      if (i1 != 0) {
        paramString = "Success";
      } else {
        paramString = "Failed";
      }
      return new com.tencent.luggage.wxa.fz.a(i2, paramString);
    }
    if (paramString.equalsIgnoreCase("clearStickers"))
    {
      bool1 = i();
      if (bool1) {
        i1 = i8;
      } else {
        i1 = -2;
      }
      if (bool1) {
        paramString = "Success";
      } else {
        paramString = "Failed";
      }
      return new com.tencent.luggage.wxa.fz.a(i1, paramString);
    }
    if (paramString.equalsIgnoreCase("applyMakeup"))
    {
      if ((paramJSONObject != null) && (d(paramJSONObject))) {
        i1 = i11;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        i2 = i4;
      } else {
        i2 = -2;
      }
      if (i1 != 0) {
        paramString = "Success";
      } else {
        paramString = "Failed";
      }
      return new com.tencent.luggage.wxa.fz.a(i2, paramString);
    }
    if (paramString.equalsIgnoreCase("clearMakeups"))
    {
      bool1 = j();
      if (bool1) {
        i1 = i9;
      } else {
        i1 = -2;
      }
      if (bool1) {
        paramString = "Success";
      } else {
        paramString = "Failed";
      }
      return new com.tencent.luggage.wxa.fz.a(i1, paramString);
    }
    return new com.tencent.luggage.wxa.fz.a(-4, "invalid operate command");
  }
  
  public com.tencent.luggage.wxa.fz.a a(boolean paramBoolean)
  {
    this.n = this.d.isPushing();
    if (this.n)
    {
      if (paramBoolean)
      {
        this.o = paramBoolean;
        return a("stop", null);
      }
      return a("pause", null);
    }
    return new com.tencent.luggage.wxa.fz.a();
  }
  
  public void a(int paramInt)
  {
    t.a(new k.1(this, paramInt));
  }
  
  public void a(Handler paramHandler)
  {
    this.g = paramHandler;
  }
  
  public void a(ITXLivePushListener paramITXLivePushListener)
  {
    this.e = paramITXLivePushListener;
  }
  
  public void a(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.r = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.p = paramITXSnapshotListener;
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.q = paramOnBGMNotify;
  }
  
  public void a(boolean paramBoolean, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    WXLivePusher localWXLivePusher = this.d;
    if ((localWXLivePusher != null) && (localWXLivePusher.isPushing())) {
      this.d.snapshot(new k.2(this, paramITXSnapshotListener, paramBoolean));
    }
  }
  
  public int b()
  {
    WXLivePusher localWXLivePusher = this.d;
    if (localWXLivePusher != null) {
      return localWXLivePusher.getMaxZoom();
    }
    return 0;
  }
  
  public com.tencent.luggage.wxa.fz.a b(int paramInt)
  {
    this.d.setZoom(paramInt);
    return new com.tencent.luggage.wxa.fz.a();
  }
  
  public com.tencent.luggage.wxa.fz.a b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new com.tencent.luggage.wxa.fz.a(-1, "invalid params");
    }
    a("updateLivePusher", paramBundle);
    if (!this.j) {
      return new com.tencent.luggage.wxa.fz.a(-3, "uninited livePusher");
    }
    a(paramBundle, false);
    String str1 = paramBundle.getString("pushUrl", this.i);
    if ((str1 != null) && (!str1.isEmpty()))
    {
      String str2 = this.i;
      if ((str2 != null) && (!str2.equalsIgnoreCase(str1)) && (this.d.isPushing()))
      {
        o.d("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
        e();
        f();
        this.d.stopPusher();
      }
    }
    this.i = str1;
    this.d.setPusherUrl(this.i);
    this.u = paramBundle.getBoolean("autopush", this.u);
    if (this.u)
    {
      paramBundle = this.i;
      if ((paramBundle != null) && (!paramBundle.isEmpty()) && (!this.d.isPushing()))
      {
        o.d("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
        b(this.B);
        c(this.C);
        if (this.B)
        {
          paramBundle = this.f;
          if (paramBundle != null) {
            this.d.setSurface(paramBundle);
          }
        }
        this.d.startPusher(this.i);
      }
    }
    return new com.tencent.luggage.wxa.fz.a();
  }
  
  public void c()
  {
    if (this.e != null)
    {
      o.d("TXLivePusherJSAdapter", "sendHandupStop, send event 5000");
      this.e.onPushEvent(5000, new Bundle());
    }
  }
  
  public com.tencent.luggage.wxa.fz.a d()
  {
    if (this.n)
    {
      if (this.o) {
        return a("start", null);
      }
      return a("resume", null);
    }
    return new com.tencent.luggage.wxa.fz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k
 * JD-Core Version:    0.7.0.1
 */