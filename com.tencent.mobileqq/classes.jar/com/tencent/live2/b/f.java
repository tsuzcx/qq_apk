package com.tencent.live2.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy.a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.d;
import com.tencent.live2.impl.a.g;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCRenderParams;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCSubCloud;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends TRTCCloudListener
  implements TRTCCloudListener.TRTCAudioFrameListener, TRTCCloudListener.TRTCVideoRenderListener
{
  private static Method A;
  private static Method B;
  private static Method C;
  private static final Map<String, f> a = new HashMap();
  private static TRTCCloud b;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  private static boolean h;
  private static boolean i;
  private static Method y;
  private static Method z;
  private final Handler c;
  private final TRTCCloud d;
  private final Map<String, f.b> j;
  private final Map<String, f.b> k;
  private final Map<String, f.c> l;
  private a.d m;
  private boolean n;
  private boolean o;
  private int p;
  private b q;
  private Context r;
  private f.a s;
  private V2TXLivePusherObserver t;
  private boolean u;
  private boolean v;
  private int w = 4;
  private Map<String, Integer> x;
  
  static
  {
    o();
  }
  
  public f(Context paramContext, a.d paramd, f.a parama)
  {
    this.r = paramContext.getApplicationContext();
    this.s = parama;
    if (paramd == a.d.b) {
      this.d = TRTCCloud.sharedInstance(paramContext).createSubCloud();
    } else {
      this.d = b;
    }
    this.d.setListener(this);
    this.c = new Handler(Looper.getMainLooper());
    this.j = new ConcurrentHashMap();
    this.k = new ConcurrentHashMap();
    this.l = new HashMap();
    this.p = 21;
    paramContext = new StringBuilder();
    paramContext.append("create instance:");
    paramContext.append(this.d.hashCode());
    f(paramContext.toString());
  }
  
  public static int a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    b.setWatermark(paramBitmap, 0, paramFloat1, paramFloat2, paramFloat3);
    return 0;
  }
  
  public static int a(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    b.sendCustomVideoData(com.tencent.live2.impl.b.a(paramV2TXLiveVideoFrame));
    return 0;
  }
  
  public static int a(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams)
  {
    TXCLog.i("V2-V2TRTCCloud", "startScreenCapture");
    g = true;
    m();
    b.startScreenCapture(paramTRTCVideoEncParam, paramTRTCScreenShareParams);
    return 0;
  }
  
  public static int a(boolean paramBoolean)
  {
    b.setVideoEncoderMirror(paramBoolean);
    return 0;
  }
  
  public static f a(Context paramContext, String paramString, a.d paramd, f.a parama)
  {
    if (paramd == a.d.a)
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if ((localf != null) && (localf.j()) && (localf.m == a.d.a)) {
          return localf;
        }
      }
    }
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("V2-V2TRTCCloud", "create instance fail. room id is empty.");
      return null;
    }
    if (a.containsKey(paramString))
    {
      paramContext = new StringBuilder();
      paramContext.append("find exist instance, maybe something error. roomId:");
      paramContext.append(paramString);
      TXCLog.e("V2-V2TRTCCloud", paramContext.toString());
      n();
      return (f)a.get(paramString);
    }
    paramContext = new f(paramContext, paramd, parama);
    paramd = new StringBuilder();
    paramd.append("create new instance. room id: ");
    paramd.append(paramString);
    paramd.append(" instance:");
    paramd.append(paramContext.hashCode());
    TXCLog.i("V2-V2TRTCCloud", paramd.toString());
    a.put(paramString, paramContext);
    return paramContext;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPushSurfaceSize [width:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("][height:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("]");
    TXCLog.i("V2-V2TRTCCloud", ((StringBuilder)localObject).toString());
    localObject = z;
    if (localObject == null)
    {
      TXCLog.e("V2-V2TRTCCloud", "set local surface size fail. reflect method fail.");
      return;
    }
    try
    {
      ((Method)localObject).invoke(b, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("V2-V2TRTCCloud", "set local surface size fail.", localException);
    }
  }
  
  public static void a(Context paramContext)
  {
    b = TRTCCloud.sharedInstance(paramContext);
  }
  
  public static void a(Bitmap paramBitmap, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoMuteImg [bitmap:");
    localStringBuilder.append(paramBitmap);
    localStringBuilder.append("][fps:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
    b.setVideoMuteImage(paramBitmap, paramInt);
  }
  
  public static void a(Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPushSurface surface:");
    if (paramSurface != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSurface.hashCode());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
    Object localObject = y;
    if (localObject == null)
    {
      TXCLog.e("V2-V2TRTCCloud", "set local surface fail. reflect method fail.");
      return;
    }
    try
    {
      ((Method)localObject).invoke(b, new Object[] { paramSurface });
      return;
    }
    catch (Exception paramSurface)
    {
      TXCLog.e("V2-V2TRTCCloud", "set local surface fail.", paramSurface);
    }
  }
  
  public static void a(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMicrophone quality: ");
    localStringBuilder.append(paramV2TXLiveAudioQuality);
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
    int i1 = 1;
    h = true;
    m();
    if (paramV2TXLiveAudioQuality != V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualitySpeech) {
      if (paramV2TXLiveAudioQuality == V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityMusic) {
        i1 = 3;
      } else {
        i1 = 2;
      }
    }
    b.startLocalAudio(i1);
  }
  
  public static void a(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    int i1 = f.30.a[paramV2TXLiveMirrorType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return;
        }
        b.setLocalViewMirror(2);
        return;
      }
      b.setLocalViewMirror(1);
      return;
    }
    b.setLocalViewMirror(0);
  }
  
  public static void a(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    b.setLocalViewRotation(com.tencent.live2.impl.b.b(paramV2TXLiveRotation));
  }
  
  public static void a(f paramf)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy instance:");
    if (paramf != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramf.hashCode());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
    Object localObject = a.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((Map.Entry)((Iterator)localObject).next()).getValue() == paramf)
      {
        ((Iterator)localObject).remove();
        paramf.k();
      }
    }
  }
  
  public static void a(a.g paramg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVideoEncoderParam param:");
    ((StringBuilder)localObject).append(paramg);
    TXCLog.i("V2-V2TRTCCloud", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("streamType", 0);
      ((JSONObject)localObject).put("videoWidth", paramg.a);
      ((JSONObject)localObject).put("videoHeight", paramg.b);
      ((JSONObject)localObject).put("videoBitrate", paramg.d);
      ((JSONObject)localObject).put("videoFps", paramg.c);
      paramg = new JSONObject();
      paramg.put("api", "setVideoEncodeParamEx");
      paramg.put("params", localObject);
      b.callExperimentalAPI(paramg.toString());
      return;
    }
    catch (JSONException paramg)
    {
      paramg.printStackTrace();
    }
  }
  
  private void a(TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterRoom frameworkType ");
    ((StringBuilder)localObject).append(this.w);
    f(((StringBuilder)localObject).toString());
    if (this.m == a.d.a)
    {
      c.a();
      this.d.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setFramework\", \"params\": {\"framework\":%d}}", new Object[] { Integer.valueOf(this.w) }));
    }
    else if (this.m == a.d.b)
    {
      c.a(paramTRTCParams.userId, paramTRTCParams.sdkAppId, String.valueOf(paramTRTCParams.strRoomId));
      this.d.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setRoomType\", \"params\": {\"type\":%d}}", new Object[] { Integer.valueOf(1) }));
      localObject = h.d();
      String str = h.c();
      TXCKeyPointReportProxy.a locala = new TXCKeyPointReportProxy.a();
      locala.d = paramInt;
      locala.e = str;
      locala.f = ((String)localObject);
      localObject = this.r;
      if (localObject != null) {
        localObject = ((Context)localObject).getPackageName();
      } else {
        localObject = "";
      }
      locala.h = ((String)localObject);
      locala.b = paramTRTCParams.sdkAppId;
      locala.g = TXCCommonUtil.getSDKVersionStr();
      locala.c = this.w;
      TXCKeyPointReportProxy.a(locala);
    }
    this.p = paramTRTCParams.role;
    TXCDRApi.txReportDAU(this.r, com.tencent.liteav.basic.datareport.a.bI, paramTRTCParams.sdkAppId, "");
    this.d.enterRoom(paramTRTCParams, paramInt);
  }
  
  public static void a(TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener, int paramInt1, int paramInt2)
  {
    b.setLocalVideoProcessListener(paramInt1, paramInt2, paramTRTCVideoFrameListener);
  }
  
  private void a(String paramString, int paramInt, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    f.b localb = (f.b)e(paramInt).get(paramString);
    Object localObject = (f.c)this.l.get(paramString);
    if ((localb != null) && (localObject != null))
    {
      boolean bool;
      if (f(paramInt)) {
        bool = ((f.c)localObject).c;
      } else {
        bool = ((f.c)localObject).f;
      }
      if ((paramV2TXLivePlayStatus == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying) && ((!bool) || (localb.j)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update status(video) fail.[userId:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("][videoAvailable:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("][videoMuted:");
        ((StringBuilder)localObject).append(localb.j);
        ((StringBuilder)localObject).append("][fromStatus:");
        ((StringBuilder)localObject).append(f.b.b(localb));
        ((StringBuilder)localObject).append("][toStatus:");
        ((StringBuilder)localObject).append(paramV2TXLivePlayStatus);
        ((StringBuilder)localObject).append("][reason:");
        ((StringBuilder)localObject).append(paramV2TXLiveStatusChangeReason);
        ((StringBuilder)localObject).append("]");
        h(((StringBuilder)localObject).toString());
        return;
      }
      if (!com.tencent.live2.impl.b.a(f.b.b(localb), paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update status(video) fail.[userId:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("][videoAvailable:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("][videoMuted:");
        ((StringBuilder)localObject).append(localb.j);
        ((StringBuilder)localObject).append("][fromStatus:");
        ((StringBuilder)localObject).append(f.b.b(localb));
        ((StringBuilder)localObject).append("][toStatus:");
        ((StringBuilder)localObject).append(paramV2TXLivePlayStatus);
        ((StringBuilder)localObject).append("][reason:");
        ((StringBuilder)localObject).append(paramV2TXLiveStatusChangeReason);
        ((StringBuilder)localObject).append("]");
        h(((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update status(video) success.[userId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("][fromStatus:");
      ((StringBuilder)localObject).append(f.b.b(localb));
      ((StringBuilder)localObject).append("][toStatus:");
      ((StringBuilder)localObject).append(paramV2TXLivePlayStatus);
      ((StringBuilder)localObject).append("][reason:");
      ((StringBuilder)localObject).append(paramV2TXLiveStatusChangeReason);
      ((StringBuilder)localObject).append("]");
      f(((StringBuilder)localObject).toString());
      f.b.b(localb, paramV2TXLivePlayStatus);
      this.c.post(new f.29(this, localb, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason));
      return;
    }
    paramV2TXLiveStatusChangeReason = new StringBuilder();
    paramV2TXLiveStatusChangeReason.append("update status(video) fail. cant'find info. [userInfo:");
    paramV2TXLivePlayStatus = "null";
    if (localObject == null) {
      paramString = "null";
    } else {
      paramString = Integer.valueOf(localObject.hashCode());
    }
    paramV2TXLiveStatusChangeReason.append(paramString);
    paramV2TXLiveStatusChangeReason.append("][playerInfo:");
    if (localb == null) {
      paramString = paramV2TXLivePlayStatus;
    } else {
      paramString = Integer.valueOf(localb.hashCode());
    }
    paramV2TXLiveStatusChangeReason.append(paramString);
    paramV2TXLiveStatusChangeReason.append("]");
    h(paramV2TXLiveStatusChangeReason.toString());
  }
  
  private void a(String paramString, int paramInt, TXCloudVideoView paramTXCloudVideoView, TRTCCloudDef.TRTCRenderParams paramTRTCRenderParams)
  {
    this.d.startRemoteView(paramString, paramInt, paramTXCloudVideoView);
    this.d.setRemoteRenderParams(paramString, paramInt, paramTRTCRenderParams);
  }
  
  private void a(String paramString, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    f.b localb = (f.b)this.j.get(paramString);
    Object localObject = (f.c)this.l.get(paramString);
    if ((localb != null) && (localObject != null))
    {
      StringBuilder localStringBuilder;
      if ((paramV2TXLivePlayStatus == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying) && ((!((f.c)localObject).b) || (localb.i)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update status(audio) fail.[userId:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][audioAvailable:");
        localStringBuilder.append(((f.c)localObject).b);
        localStringBuilder.append("][fromStatus:");
        localStringBuilder.append(f.b.a(localb));
        localStringBuilder.append("][toStatus:");
        localStringBuilder.append(paramV2TXLivePlayStatus);
        localStringBuilder.append("][reason:");
        localStringBuilder.append(paramV2TXLiveStatusChangeReason);
        localStringBuilder.append("]");
        h(localStringBuilder.toString());
        return;
      }
      if (!com.tencent.live2.impl.b.a(f.b.a(localb), paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update status(audio) fail.[userId:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][audioAvailable:");
        localStringBuilder.append(((f.c)localObject).b);
        localStringBuilder.append("][fromStatus:");
        localStringBuilder.append(f.b.a(localb));
        localStringBuilder.append("][toStatus:");
        localStringBuilder.append(paramV2TXLivePlayStatus);
        localStringBuilder.append("][reason:");
        localStringBuilder.append(paramV2TXLiveStatusChangeReason);
        localStringBuilder.append("]");
        h(localStringBuilder.toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update status(audio) success.[userId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("][fromStatus:");
      ((StringBuilder)localObject).append(f.b.a(localb));
      ((StringBuilder)localObject).append("][toStatus:");
      ((StringBuilder)localObject).append(paramV2TXLivePlayStatus);
      ((StringBuilder)localObject).append("][reason:");
      ((StringBuilder)localObject).append(paramV2TXLiveStatusChangeReason);
      ((StringBuilder)localObject).append("]");
      f(((StringBuilder)localObject).toString());
      f.b.a(localb, paramV2TXLivePlayStatus);
      this.c.post(new f.28(this, localb, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason));
      return;
    }
    paramV2TXLiveStatusChangeReason = new StringBuilder();
    paramV2TXLiveStatusChangeReason.append("update status(audio) fail. cant'find info. [userInfo:");
    paramV2TXLivePlayStatus = "null";
    if (localObject == null) {
      paramString = "null";
    } else {
      paramString = Integer.valueOf(localObject.hashCode());
    }
    paramV2TXLiveStatusChangeReason.append(paramString);
    paramV2TXLiveStatusChangeReason.append("][playerInfo:");
    if (localb == null) {
      paramString = paramV2TXLivePlayStatus;
    } else {
      paramString = Integer.valueOf(localb.hashCode());
    }
    paramV2TXLiveStatusChangeReason.append(paramString);
    paramV2TXLiveStatusChangeReason.append("]");
    h(paramV2TXLiveStatusChangeReason.toString());
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if ((this.m == a.d.b) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      f.b localb = (f.b)e(paramInt).remove(paramString1);
      if (localb == null)
      {
        paramString2 = new StringBuilder();
        paramString2.append("update remote user id fail. can't find [userId:");
        paramString2.append(paramString1);
        paramString2.append("] playerInfo.");
        h(paramString2.toString());
        return;
      }
      if (localb.a == null) {
        h("update remote user id fail. url param is null.");
      }
      localb.a.a(paramString2);
      e(paramInt).put(paramString2, localb);
      paramString1 = this.s;
      if (paramString1 != null) {
        this.c.post(new f.13(this, paramString1, paramString2));
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = (f.c)this.l.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUserVideoAvailableInner error: can't find [userId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("] user info.");
      h(((StringBuilder)localObject).toString());
      return;
    }
    if (f(paramInt)) {
      ((f.c)localObject).c = paramBoolean;
    } else {
      ((f.c)localObject).f = paramBoolean;
    }
    if (paramBoolean)
    {
      if (this.m == a.d.b)
      {
        if (!((f.c)localObject).b) {
          a("27eb683b73944771ce62fbddab2849a4", paramString, paramInt);
        }
        f.b localb = (f.b)e(paramInt).get(paramString);
        if (localb == null)
        {
          h("onUserVideoAvailableInner error: can't find player info.");
          return;
        }
        if (localb.b != null)
        {
          f("onUserVideoAvailableInner: start remote play.");
          a(paramString, paramInt, localb.b, localb.k);
        }
        else if ((localb.b == null) && (localb.c != null))
        {
          f("onUserVideoAvailableInner: start remote surface play.");
          a(paramString, paramInt, null, localb.k);
          try
          {
            A.invoke(this.d, new Object[] { paramString, Integer.valueOf(paramInt), localb.c });
          }
          catch (Exception localException)
          {
            TXCLog.e("V2-V2TRTCCloud", "set play surface size fail.", localException);
          }
        }
        else
        {
          g("onUserVideoAvailableInner: video view is null.waiting for view to start play.");
        }
      }
      if (f(paramInt))
      {
        if (((f.c)localObject).d) {
          a(paramString, 0, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted);
        }
      }
      else if (((f.c)localObject).g) {
        a(paramString, 2, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted);
      }
    }
    else
    {
      a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
      if (this.m == a.d.b)
      {
        if (!((f.c)localObject).b) {
          a(paramString, "27eb683b73944771ce62fbddab2849a4", paramInt);
        }
        this.d.stopRemoteView(paramString, paramInt);
      }
    }
    this.c.post(new f.15(this, paramString, paramInt, paramBoolean));
  }
  
  public static void a(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCamera [front:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("][view: ");
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramTXCloudVideoView.hashCode());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
    f = true;
    m();
    b.startLocalPreview(paramBoolean, paramTXCloudVideoView);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = (f)a.get(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(boolean paramBoolean)
  {
    if (i != paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableCustomVideoCapture enable: ");
      localStringBuilder.append(paramBoolean);
      TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
      i = paramBoolean;
      m();
      b.enableCustomVideoCapture(paramBoolean);
    }
    return 0;
  }
  
  public static void b()
  {
    if (f)
    {
      TXCLog.i("V2-V2TRTCCloud", "stopCamera");
      f = false;
      m();
      b.stopLocalPreview();
    }
  }
  
  public static void b(String paramString)
  {
    b.callExperimentalAPI(paramString);
  }
  
  public static void c()
  {
    if (h)
    {
      TXCLog.i("V2-V2TRTCCloud", "stopMicrophone");
      h = false;
      m();
      b.stopLocalAudio();
    }
  }
  
  public static void c(int paramInt)
  {
    try
    {
      C.invoke(null, new Object[] { Integer.valueOf(paramInt) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set env success. env:");
      localStringBuilder.append(paramInt);
      TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TXCLog.e("V2-V2TRTCCloud", "set env fail.", localException);
    }
  }
  
  public static int d()
  {
    if (g)
    {
      TXCLog.i("V2-V2TRTCCloud", "stopScreenCapture");
      g = false;
      m();
      b.stopScreenCapture();
    }
    return 0;
  }
  
  private void d(int paramInt)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("notify all instance switch role to:");
    if (paramInt == 20) {
      localObject1 = "anchor";
    } else {
      localObject1 = "audience";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    f(((StringBuilder)localObject2).toString());
    Object localObject1 = a.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!((f)localObject2).j()) && (((f)localObject2).a()))
      {
        ((f)localObject2).p = paramInt;
        ((f)localObject2).d.switchRole(paramInt);
        ((f)localObject2).d.muteLocalVideo(true);
        ((f)localObject2).d.muteLocalAudio(true);
      }
    }
  }
  
  public static TXAudioEffectManager e()
  {
    return b.getAudioEffectManager();
  }
  
  private Map<String, f.b> e(int paramInt)
  {
    if (f(paramInt)) {
      return this.j;
    }
    return this.k;
  }
  
  private boolean e(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || ("27eb683b73944771ce62fbddab2849a4".equals(paramString));
  }
  
  public static TXBeautyManager f()
  {
    return b.getBeautyManager();
  }
  
  private f.b f(String paramString, int paramInt)
  {
    Map localMap = e(paramInt);
    f.b localb2 = (f.b)localMap.get(paramString);
    f.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new f.b();
      localMap.put(paramString, localb1);
    }
    return localb1;
  }
  
  private void f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_trtccloud(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
  }
  
  private boolean f(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static TXDeviceManager g()
  {
    return b.getDeviceManager();
  }
  
  private void g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_trtccloud(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.w("V2-V2TRTCCloud", localStringBuilder.toString());
  }
  
  private void h(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_trtccloud(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.e("V2-V2TRTCCloud", localStringBuilder.toString());
  }
  
  private void k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("destroy instance:");
    ((StringBuilder)localObject).append(this.d.hashCode());
    f(((StringBuilder)localObject).toString());
    this.s = null;
    this.j.clear();
    this.k.clear();
    localObject = b;
    TRTCCloud localTRTCCloud = this.d;
    if (localObject != localTRTCCloud) {
      ((TRTCCloud)localObject).destroySubCloud(localTRTCCloud);
    }
    this.l.clear();
    n();
  }
  
  private static boolean l()
  {
    return (f) || (g) || (i) || (h);
  }
  
  private static void m()
  {
    if (!e) {
      return;
    }
    String str = null;
    Object localObject2 = a.values().iterator();
    Object localObject1;
    do
    {
      localObject1 = str;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (f)((Iterator)localObject2).next();
    } while ((localObject1 == null) || (!((f)localObject1).j()) || (!((f)localObject1).q.i()));
    if (localObject1 == null) {
      return;
    }
    if (((f)localObject1).i())
    {
      int i1;
      if (l()) {
        i1 = 20;
      } else {
        i1 = 21;
      }
      if (((f)localObject1).p != i1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("switch role to:");
        if (i1 == 20) {
          str = "anchor";
        } else {
          str = "audience";
        }
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" when room protocol.");
        TXCLog.i("V2-V2TRTCCloud", ((StringBuilder)localObject2).toString());
        ((f)localObject1).p = i1;
        ((f)localObject1).d.switchRole(i1);
      }
    }
  }
  
  private static void n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("All room info: [size:");
    localStringBuilder.append(a.size());
    localStringBuilder.append("]\n");
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (f)((Map.Entry)localObject).getValue();
      if (localObject != null)
      {
        localStringBuilder.append("[roomId:");
        localStringBuilder.append(str);
        localStringBuilder.append(",instance:");
        localStringBuilder.append(localObject.hashCode());
        localStringBuilder.append(",isInRoom:");
        localStringBuilder.append(((f)localObject).n);
        localStringBuilder.append(",isPusher:");
        localStringBuilder.append(((f)localObject).j());
        localStringBuilder.append("]\n");
      }
      else
      {
        localStringBuilder.append("[roomId:");
        localStringBuilder.append(str);
        localStringBuilder.append(",instance: null");
        localStringBuilder.append("]\n");
      }
    }
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
  }
  
  private static void o()
  {
    try
    {
      y = TRTCCloudImpl.class.getDeclaredMethod("setLocalSurface", new Class[] { Surface.class });
      z = TRTCCloudImpl.class.getDeclaredMethod("setLocalSurfaceSize", new Class[] { Integer.TYPE, Integer.TYPE });
      A = TRTCCloudImpl.class.getDeclaredMethod("setRemoteSurface", new Class[] { String.class, Integer.TYPE, Surface.class });
      B = TRTCCloudImpl.class.getDeclaredMethod("setRemoteSurfaceSize", new Class[] { String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE });
      TXCLog.i("V2-V2TRTCCloud", "initReflectMethod success.");
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      localNoSuchMethodException1.printStackTrace();
      TXCLog.e("V2-V2TRTCCloud", "initReflectMethod init fail.", localNoSuchMethodException1);
    }
    try
    {
      C = TRTCCloud.class.getDeclaredMethod("setNetEnv", new Class[] { Integer.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      localNoSuchMethodException2.printStackTrace();
    }
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (e(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("muteRemoteAudio: invalid user id:");
      ((StringBuilder)localObject).append(paramString);
      h(((StringBuilder)localObject).toString());
      return -3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("muteRemoteAudio [userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("][streamType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("][isMute:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    f(((StringBuilder)localObject).toString());
    f(paramString, paramInt).i = paramBoolean;
    if (paramBoolean)
    {
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    }
    else
    {
      localObject = (f.c)this.l.get(paramString);
      if ((localObject != null) && (((f.c)localObject).e))
      {
        a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
        if (this.o) {
          a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
        }
      }
    }
    if (f(paramInt))
    {
      this.d.muteRemoteAudio(paramString, paramBoolean);
      return 0;
    }
    return -4;
  }
  
  public void a(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void a(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    paramV2TXLiveTranscodingConfig = com.tencent.live2.impl.b.a(paramV2TXLiveTranscodingConfig);
    this.d.setMixTranscodingConfig(paramV2TXLiveTranscodingConfig);
  }
  
  public void a(V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerPusherObserver observer: ");
    localStringBuilder.append(paramV2TXLivePusherObserver);
    f(localStringBuilder.toString());
    this.t = paramV2TXLivePusherObserver;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (e(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregisterPlayerObserver: invalid user id:");
      localStringBuilder.append(paramString);
      h(localStringBuilder.toString());
      return;
    }
    paramString = (f.b)e(paramInt).get(paramString);
    if (paramString != null) {
      paramString.f = null;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRemoteSurface [userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("][streamType:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("][width:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("][height: ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("]");
    f(((StringBuilder)localObject).toString());
    if (e(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setPlaySurfaceSize: invalid user id:");
      ((StringBuilder)localObject).append(paramString);
      h(((StringBuilder)localObject).toString());
      return;
    }
    localObject = f(paramString, paramInt1);
    ((f.b)localObject).d = paramInt2;
    ((f.b)localObject).e = paramInt3;
    try
    {
      B.invoke(this.d, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    catch (Exception paramString)
    {
      TXCLog.e("V2-V2TRTCCloud", "set play surface size fail.", paramString);
    }
  }
  
  public void a(String paramString, int paramInt, Surface paramSurface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteSurface [userId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][streamType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][surface: ");
    if (paramSurface != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSurface.hashCode());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    f(localStringBuilder.toString());
    if (e(paramString))
    {
      paramSurface = new StringBuilder();
      paramSurface.append("setPlaySurface: invalid user id:");
      paramSurface.append(paramString);
      h(paramSurface.toString());
      return;
    }
    Object localObject = f(paramString, paramInt);
    ((f.b)localObject).c = paramSurface;
    if (((f.b)localObject).c != null)
    {
      f("start remote play after set surface.");
      a(paramString, paramInt, null, ((f.b)localObject).k);
    }
    try
    {
      A.invoke(this.d, new Object[] { paramString, Integer.valueOf(paramInt), paramSurface });
      return;
    }
    catch (Exception paramString)
    {
      TXCLog.e("V2-V2TRTCCloud", "set play surface size fail.", paramString);
    }
  }
  
  public void a(String paramString, int paramInt, V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    if (e(paramString))
    {
      paramV2TXLiveFillMode = new StringBuilder();
      paramV2TXLiveFillMode.append("set play view fill mode fail. invalid user id:");
      paramV2TXLiveFillMode.append(paramString);
      h(paramV2TXLiveFillMode.toString());
      return;
    }
    f.b localb = f(paramString, paramInt);
    localb.k.fillMode = com.tencent.live2.impl.b.b(paramV2TXLiveFillMode);
    this.d.setRemoteRenderParams(paramString, paramInt, localb.k);
  }
  
  public void a(String paramString, int paramInt, V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    if (e(paramString))
    {
      paramV2TXLiveRotation = new StringBuilder();
      paramV2TXLiveRotation.append("set play view rotation fail. invalid user id:");
      paramV2TXLiveRotation.append(paramString);
      h(paramV2TXLiveRotation.toString());
      return;
    }
    f.b localb = f(paramString, paramInt);
    localb.k.rotation = com.tencent.live2.impl.b.b(paramV2TXLiveRotation);
    this.d.setRemoteRenderParams(paramString, paramInt, localb.k);
  }
  
  public void a(String paramString, int paramInt, V2TXLivePlayer paramV2TXLivePlayer, V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    if (e(paramString))
    {
      paramV2TXLivePlayer = new StringBuilder();
      paramV2TXLivePlayer.append("registerPlayerObserver: invalid user id:");
      paramV2TXLivePlayer.append(paramString);
      h(paramV2TXLivePlayer.toString());
      return;
    }
    paramString = f(paramString, paramInt);
    paramString.g = paramV2TXLivePlayer;
    paramString.f = paramV2TXLivePlayerObserver;
  }
  
  public void a(String paramString, int paramInt, TXCloudVideoView paramTXCloudVideoView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayView: [userId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][view:");
    if (paramTXCloudVideoView == null)
    {
      localObject = "null";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTXCloudVideoView.hashCode());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("][streamType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    f(localStringBuilder.toString());
    if (e(paramString))
    {
      paramTXCloudVideoView = new StringBuilder();
      paramTXCloudVideoView.append("setPlayView: invalid user id:");
      paramTXCloudVideoView.append(paramString);
      h(paramTXCloudVideoView.toString());
      return;
    }
    Object localObject = f(paramString, paramInt);
    ((f.b)localObject).b = paramTXCloudVideoView;
    if (((f.b)localObject).b != null)
    {
      f("start remote play after set view.");
      a(paramString, paramInt, paramTXCloudVideoView, ((f.b)localObject).k);
      return;
    }
    g("waiting for video view for play.");
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (e(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableCustomRendering: invalid user id:");
      ((StringBuilder)localObject).append(paramString);
      h(((StringBuilder)localObject).toString());
      return;
    }
    int i1 = 1;
    if (paramBoolean)
    {
      f(paramString, paramInt1).h = true;
      this.d.setRemoteVideoRenderListener(paramString, paramInt2, paramInt3, this);
      return;
    }
    Object localObject = (f.b)e(paramInt1).get(paramString);
    if (localObject == null) {
      return;
    }
    ((f.b)localObject).h = false;
    if (f(paramInt1))
    {
      localObject = (f.b)this.k.get(paramString);
      paramInt1 = i1;
      if (localObject == null) {
        break label187;
      }
      if (!((f.b)localObject).h)
      {
        paramInt1 = i1;
        break label187;
      }
    }
    do
    {
      paramInt1 = 0;
      break;
      localObject = (f.b)this.j.get(paramString);
      paramInt1 = i1;
      if (localObject == null) {
        break;
      }
    } while (((f.b)localObject).h);
    paramInt1 = i1;
    label187:
    if (paramInt1 != 0) {
      this.d.setRemoteVideoRenderListener(paramString, 0, 0, null);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d.sendSEIMsg(paramArrayOfByte, 1);
  }
  
  public boolean a()
  {
    return this.n;
  }
  
  public int b(int paramInt)
  {
    this.d.enableAudioVolumeEvaluation(paramInt);
    return 0;
  }
  
  public int b(String paramString, int paramInt, boolean paramBoolean)
  {
    if (e(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("muteRemoteVideo: invalid user id:");
      ((StringBuilder)localObject).append(paramString);
      h(((StringBuilder)localObject).toString());
      return -3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("muteRemoteVideo [userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("][streamType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("][isMute:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    f(((StringBuilder)localObject).toString());
    f(paramString, paramInt).j = paramBoolean;
    if (paramBoolean)
    {
      a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    }
    else
    {
      localObject = (f.c)this.l.get(paramString);
      if (localObject != null)
      {
        boolean bool;
        if (f(paramInt)) {
          bool = ((f.c)localObject).d;
        } else {
          bool = ((f.c)localObject).g;
        }
        if (bool)
        {
          a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
          if (this.o) {
            a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
          }
        }
      }
    }
    if (f(paramInt))
    {
      this.d.muteRemoteVideoStream(paramString, paramBoolean);
      return 0;
    }
    return -4;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool2 = e(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((f.b)e(paramInt).get(paramString) != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      h("start push fail. url is empty.");
      return -3;
    }
    if (e)
    {
      h("start push fail. already have pusher instance. please check instance map. dumping room map info...");
      n();
      return -3;
    }
    if (i())
    {
      paramString = new StringBuilder();
      paramString.append("start push fail. already in room. roomId:");
      paramString.append(this.q);
      if (paramString.toString() != null) {
        paramString = this.q.f();
      } else {
        paramString = "null";
      }
      h(paramString);
      return -3;
    }
    b localb = b.a(paramString);
    if ((localb != null) && (localb.a()))
    {
      paramString = new StringBuilder();
      paramString.append("start push success. push param: ");
      paramString.append(localb);
      f(paramString.toString());
      this.q = localb;
      this.m = this.q.j();
      e = true;
      this.n = true;
      this.l.clear();
      this.d.setDefaultStreamRecvMode(this.q.k(), this.q.l());
      if (this.q.b())
      {
        paramString = new TRTCCloudDef.TRTCVideoEncParam();
        paramString.videoResolution = 100;
        paramString.videoFps = 15;
        paramString.videoBitrate = 100;
        paramString.videoResolutionMode = 1;
        b.enableEncSmallVideoStream(true, paramString);
      }
      else
      {
        b.enableEncSmallVideoStream(false, null);
      }
      b.callExperimentalAPI(String.format("{\"api\":\"enableBlackStream\", \"params\": {\"enable\":%b}}", new Object[] { Boolean.valueOf(this.q.c()) }));
      paramString = this.q.m();
      boolean bool = this.q.i();
      int i1 = 20;
      if (bool)
      {
        if (!l()) {
          i1 = 21;
        }
        paramString.role = i1;
      }
      else if (this.q.h())
      {
        paramString.role = 20;
        d(20);
      }
      c(this.q.d());
      a(paramString, this.q.e());
      this.d.muteLocalVideo(this.v);
      this.d.muteLocalAudio(this.u);
      n();
      paramString = this.t;
      if (paramString != null) {
        this.c.post(new f.1(this, paramString));
      }
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start push fail. invalid param. [url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][param:");
    localStringBuilder.append(localb);
    localStringBuilder.append("]");
    h(localStringBuilder.toString());
    return -2;
  }
  
  public int c(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopPlay [userId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][type:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    f(localStringBuilder.toString());
    this.d.stopRemoteView(paramString, paramInt);
    if (this.m == a.d.b)
    {
      this.w = 4;
      this.d.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setFramework\", \"params\": {\"framework\":%d}}", new Object[] { Integer.valueOf(1) }));
      this.n = false;
      this.m = null;
      this.p = 21;
      this.d.exitRoom();
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      this.l.clear();
      this.j.clear();
      this.k.clear();
      paramString = this.s;
      if (paramString != null)
      {
        this.c.post(new f.23(this, paramString));
        return 0;
      }
    }
    else
    {
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      e(paramInt).remove(paramString);
    }
    return 0;
  }
  
  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
    this.d.muteLocalAudio(paramBoolean);
  }
  
  public int d(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startPlay url: ");
    ((StringBuilder)localObject1).append(paramString);
    f(((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString)) {
      return -3;
    }
    paramString = a.b(paramString);
    localObject1 = f(paramString.b(), paramString.c());
    if (paramString.h())
    {
      if (this.n)
      {
        h("start play fail. already in room.");
        return -3;
      }
      localObject2 = paramString.j();
      int i1;
      if (e) {
        i1 = 20;
      } else {
        i1 = 21;
      }
      ((TRTCCloudDef.TRTCParams)localObject2).role = i1;
      this.n = true;
      a((TRTCCloudDef.TRTCParams)localObject2, paramString.f());
    }
    else
    {
      if (!paramString.i()) {
        break label244;
      }
      if (!this.n)
      {
        h("start play fail. no in room. you should enter room by using V2TXLivePusher.");
        return -3;
      }
      if (((f.b)localObject1).b != null)
      {
        f("start remote play.");
        a(paramString.b(), paramString.c(), ((f.b)localObject1).b, ((f.b)localObject1).k);
      }
      else
      {
        g("waiting for view to start remote play.");
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startPlay param:");
    ((StringBuilder)localObject2).append(paramString);
    f(((StringBuilder)localObject2).toString());
    this.m = paramString.d();
    ((f.b)localObject1).a = paramString;
    return 0;
    label244:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start play fail.invalid protocol. param:");
    ((StringBuilder)localObject1).append(paramString);
    h(((StringBuilder)localObject1).toString());
    return -2;
  }
  
  public void d(String paramString, int paramInt)
  {
    this.d.setRemoteAudioVolume(paramString, paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    this.v = paramBoolean;
    this.d.muteLocalVideo(paramBoolean);
  }
  
  public void e(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      b.snapshotVideo(paramString, paramInt, new f.31(this));
      return;
    }
    if (e(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("snapshot: invalid user id:");
      localStringBuilder.append(paramString);
      h(localStringBuilder.toString());
      return;
    }
    this.d.snapshotVideo(paramString, paramInt, new f.32(this, paramInt, paramString));
  }
  
  public void e(boolean paramBoolean)
  {
    TRTCCloud localTRTCCloud = b;
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    localTRTCCloud.showDebugView(i1);
  }
  
  public void f(boolean paramBoolean)
  {
    TRTCCloud localTRTCCloud = this.d;
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    localTRTCCloud.showDebugView(i1);
  }
  
  public int h()
  {
    f("stop push.");
    if (!i())
    {
      g("stop push fail. no in room or no push instance.");
      return -3;
    }
    this.n = false;
    e = false;
    this.p = 21;
    if (this.q.b()) {
      b.enableEncSmallVideoStream(false, null);
    }
    if (this.q.c()) {
      b.callExperimentalAPI(String.format("{\"api\":\"enableBlackStream\", \"params\": {\"enable\":%b}}", new Object[] { Boolean.valueOf(false) }));
    }
    this.q = null;
    this.w = 4;
    this.d.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setFramework\", \"params\": {\"framework\":%d}}", new Object[] { Integer.valueOf(1) }));
    b();
    c();
    d();
    b(false);
    a(null, 0, 0);
    Object localObject = this.d;
    if ((localObject instanceof TRTCSubCloud))
    {
      ((TRTCCloud)localObject).muteLocalVideo(true);
      this.d.muteLocalAudio(true);
    }
    this.d.exitRoom();
    if ((this.d instanceof TRTCSubCloud))
    {
      b.muteLocalVideo(false);
      b.muteLocalAudio(false);
    }
    localObject = this.m;
    this.m = null;
    int i1 = f.30.b[localObject.ordinal()];
    if (i1 != 1)
    {
      if (i1 == 2)
      {
        localObject = new ArrayList();
        ((List)localObject).addAll(this.j.values());
        ((List)localObject).addAll(this.k.values());
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f.b localb = (f.b)((Iterator)localObject).next();
          if ((localb != null) && (localb.a != null))
          {
            String str = localb.a.b();
            i1 = localb.a.c();
            a(str, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
            a(str, i1, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
          }
        }
        this.l.clear();
        this.j.clear();
        this.k.clear();
      }
    }
    else
    {
      d(21);
      this.l.clear();
      this.j.clear();
      this.k.clear();
    }
    localObject = this.t;
    if (localObject != null) {
      this.c.post(new f.12(this, (V2TXLivePusherObserver)localObject));
    }
    f("stop push success.");
    return 0;
  }
  
  public boolean i()
  {
    return (j()) && (a());
  }
  
  public boolean j()
  {
    b localb = this.q;
    return (localb != null) && (localb.a());
  }
  
  public void onCameraDidReady()
  {
    this.c.post(new f.21(this));
  }
  
  public void onCapturedRawAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onConnectionLost()
  {
    this.c.post(new f.19(this));
  }
  
  public void onConnectionRecovery()
  {
    this.c.post(new f.20(this));
  }
  
  public void onEnterRoom(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom result: ");
    ((StringBuilder)localObject).append(paramLong);
    f(((StringBuilder)localObject).toString());
    this.l.clear();
    this.o = false;
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.t;
    if (paramLong > 0L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("code", (int)paramLong);
      if (localV2TXLivePusherObserver != null) {
        this.c.post(new f.33(this, localV2TXLivePusherObserver, (Bundle)localObject, paramLong));
      }
    }
    else
    {
      if (j())
      {
        if (this.m == a.d.b) {
          d(21);
        }
        if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b))) {
          this.c.post(new f.34(this, localV2TXLivePusherObserver, paramLong));
        }
        this.m = null;
        e = false;
        this.q = null;
        this.n = false;
        this.p = 21;
      }
      else
      {
        this.m = null;
        this.n = false;
        this.p = 21;
      }
      int i1;
      if (paramLong == -3308L)
      {
        localObject = "enter room fail.request is timeout.";
        i1 = -6;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enter room fail.request is refused by server. [errorCode:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        localObject = ((StringBuilder)localObject).toString();
        i1 = -7;
      }
      this.c.post(new f.35(this, paramLong, localV2TXLivePusherObserver, (String)localObject, i1));
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onError code: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" info: ");
    ((StringBuilder)localObject).append(paramBundle);
    f(((StringBuilder)localObject).toString());
    localObject = this.t;
    int i1 = -1308;
    if (paramInt != -7001)
    {
      if (paramInt != -1319)
      {
        if (paramInt != -1314)
        {
          if (paramInt == -1317) {
            break label231;
          }
          if (paramInt != -1316)
          {
            if ((paramInt == -1309) || (paramInt == -1308)) {
              break label321;
            }
            if (paramInt == -1302) {
              break label231;
            }
            if (paramInt != -1301) {
              return;
            }
          }
        }
        h("onPushEvent: camera start error.");
        if (paramInt != -1316)
        {
          if (paramInt != -1314)
          {
            if (paramInt != -1301) {}
            for (paramString = "";; paramString = "start camera failed.")
            {
              paramInt = -1301;
              break;
            }
          }
          paramString = "camera not authorized.";
          paramInt = -1314;
        }
        else
        {
          paramString = "camera is occupied.";
          paramInt = -1316;
        }
        b();
        this.c.post(new f.6(this, (V2TXLivePusherObserver)localObject, paramInt, paramString, paramBundle));
        return;
      }
      label231:
      h("opPushEvent: microphone start error.");
      if (paramInt != -1319)
      {
        if (paramInt != -1317)
        {
          if (paramInt != -1302) {}
          for (paramString = "";; paramString = "start microphone failed.")
          {
            paramInt = -1302;
            break;
          }
        }
        paramString = "microphone not authorized.";
        paramInt = -1317;
      }
      else
      {
        paramString = "microphone is occupied.";
        paramInt = -1319;
      }
      c();
      this.c.post(new f.7(this, (V2TXLivePusherObserver)localObject, paramInt, paramString, paramBundle));
      return;
    }
    label321:
    if (paramInt != -7001)
    {
      if (paramInt != -1309)
      {
        if (paramInt != -1308)
        {
          paramString = "";
          paramInt = i1;
        }
        else
        {
          paramString = "screen capture start failed.";
          paramInt = i1;
        }
      }
      else
      {
        paramString = "screen capture isn't supported by system.";
        paramInt = -1309;
      }
    }
    else
    {
      paramString = "screen capture is interrupted by system.";
      paramInt = -7001;
    }
    d();
    this.c.post(new f.8(this, (V2TXLivePusherObserver)localObject, paramInt, paramString, paramBundle));
  }
  
  public void onExitRoom(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onExitRoom reason: ");
    ((StringBuilder)localObject1).append(paramInt);
    f(((StringBuilder)localObject1).toString());
    this.o = false;
    localObject1 = this.t;
    if ((localObject1 != null) && ((localObject1 instanceof com.tencent.live2.impl.a.b))) {
      this.c.post(new f.36(this, (V2TXLivePusherObserver)localObject1, paramInt));
    }
    if (paramInt == 0)
    {
      f("exit room success. do nothing.");
      return;
    }
    if (!this.n)
    {
      h("recv exit room callback, but not in room. maybe something error. dump debug info...");
      n();
      return;
    }
    if (j())
    {
      b();
      c();
      d();
      if (this.m == a.d.b) {
        d(21);
      }
      this.m = null;
      e = false;
      this.q = null;
      this.n = false;
      this.p = 21;
    }
    else
    {
      this.m = null;
      this.n = false;
      this.p = 21;
      localObject1 = this.s;
      if (localObject1 != null) {
        this.c.post(new f.2(this, (f.a)localObject1));
      }
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        localObject1 = "";
      } else {
        localObject1 = "room dismissed by server.";
      }
    }
    else {
      localObject1 = "kicked out by server.";
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", paramInt);
    Object localObject2 = this.t;
    if (localObject2 != null) {
      this.c.post(new f.3(this, (V2TXLivePusherObserver)localObject2, (String)localObject1, localBundle));
    }
    localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.j.values());
    ((List)localObject2).addAll(this.k.values());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      f.b localb = (f.b)((Iterator)localObject2).next();
      if ((localb != null) && (localb.a != null))
      {
        a(localb.a.b(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
        a(localb.a.b(), localb.a.c(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
      }
      this.c.post(new f.4(this, localb, (String)localObject1, localBundle));
    }
    this.j.clear();
    this.k.clear();
    this.l.clear();
    localObject1 = this.s;
    if (localObject1 != null) {
      this.c.post(new f.5(this, (f.a)localObject1, paramInt));
    }
  }
  
  public void onFirstAudioFrame(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFirstAudioFrame userId:");
    ((StringBuilder)localObject).append(paramString);
    f(((StringBuilder)localObject).toString());
    localObject = (f.c)this.l.get(paramString);
    if (localObject != null)
    {
      ((f.c)localObject).e = true;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFirstAudioFrame: can't find [userId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]user info.");
      h(((StringBuilder)localObject).toString());
    }
    a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFirstVideoFrame [userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("][streamType:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("][width:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("][height:");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("]");
    f(((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (f.c)this.l.get(paramString);
      if (localObject != null)
      {
        if (f(paramInt1)) {
          ((f.c)localObject).d = true;
        } else {
          ((f.c)localObject).g = true;
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onFirstVideoFrame: can't find [userId:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("]user info.");
        h(((StringBuilder)localObject).toString());
      }
      a(paramString, paramInt1, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
    }
  }
  
  public void onLocalProcessedAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onMicDidReady()
  {
    this.c.post(new f.24(this));
  }
  
  public void onMixedAllAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onMixedPlayAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onNetworkQuality(TRTCCloudDef.TRTCQuality paramTRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    this.c.post(new f.17(this, paramTRTCQuality, paramArrayList));
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = (f.b)this.j.get(paramString);
    if (paramString == null) {
      return;
    }
    paramString = paramString.f;
    if ((paramString != null) && ((paramString instanceof com.tencent.live2.impl.a.a))) {
      ((com.tencent.live2.impl.a.a)paramString).onRecvSEIMessage(new String(paramArrayOfByte));
    }
  }
  
  public void onRemoteUserAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame, String paramString) {}
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRemoteUserEnterRoom: [userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    f(((StringBuilder)localObject).toString());
    localObject = new f.c(null);
    ((f.c)localObject).a = paramString;
    this.l.put(paramString, localObject);
    this.c.post(new f.10(this, paramString));
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRemoteUserLeaveRoom: [userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("][reason:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    f(((StringBuilder)localObject).toString());
    localObject = (f.c)this.l.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRemoteUserLeaveRoom error: can't find [userId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("] user info.");
      h(((StringBuilder)localObject).toString());
      return;
    }
    f.b localb1 = (f.b)this.j.get(paramString);
    f.b localb2 = (f.b)this.k.get(paramString);
    if (localb1 != null)
    {
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
      a(paramString, 0, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
    }
    if (localb2 != null) {
      a(paramString, 2, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
    }
    this.l.remove(paramString);
    this.c.post(new f.11(this, (f.c)localObject, paramString, paramInt));
  }
  
  public void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    paramString = (f.b)e(paramInt).get(paramString);
    if (paramString == null) {
      return;
    }
    if ((paramString.f != null) && (paramString.g != null)) {
      paramString.f.onRenderVideoFrame(paramString.g, com.tencent.live2.impl.b.a(paramTRTCVideoFrame));
    }
  }
  
  public void onScreenCaptureStarted()
  {
    this.c.post(new f.22(this));
  }
  
  public void onSendFirstLocalAudioFrame()
  {
    f("onSendFirstLocalAudioFrame");
    this.c.post(new f.27(this));
  }
  
  public void onSendFirstLocalVideoFrame(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendFirstLocalVideoFrame type: ");
    localStringBuilder.append(paramInt);
    f(localStringBuilder.toString());
    if (paramInt == 0) {
      this.c.post(new f.26(this));
    }
  }
  
  public void onSetMixTranscodingConfig(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSetMixTranscodingConfig err: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg: ");
    ((StringBuilder)localObject).append(paramString);
    f(((StringBuilder)localObject).toString());
    localObject = this.t;
    if (localObject != null) {
      this.c.post(new f.25(this, paramInt, (V2TXLivePusherObserver)localObject, paramString));
    }
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    this.c.post(new f.18(this, paramTRTCStatistics));
  }
  
  public void onTryToReconnect()
  {
    f("onTryToReconnect");
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUserAudioAvailable [protocol:");
    ((StringBuilder)localObject).append(this.m);
    ((StringBuilder)localObject).append("][userId: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("][available: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    f(((StringBuilder)localObject).toString());
    localObject = (f.c)this.l.get(paramString);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUserAudioAvailable error: can't find [userId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("] user info.");
      h(((StringBuilder)localObject).toString());
      return;
    }
    ((f.c)localObject).b = paramBoolean;
    if (paramBoolean)
    {
      if ((this.m == a.d.b) && (!((f.c)localObject).c)) {
        a("27eb683b73944771ce62fbddab2849a4", paramString, 0);
      }
      if (((f.c)localObject).e) {
        a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted);
      }
    }
    else
    {
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
      if ((this.m == a.d.b) && (!((f.c)localObject).c)) {
        a(paramString, "27eb683b73944771ce62fbddab2849a4", 0);
      }
    }
    this.c.post(new f.14(this, paramString, paramBoolean));
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserSubStreamAvailable [protocol:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("][userId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    f(localStringBuilder.toString());
    a(paramString, paramBoolean, 2);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserVideoAvailable [protocol:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("][userId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    f(localStringBuilder.toString());
    a(paramString, paramBoolean, 0);
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    this.c.post(new f.16(this, paramArrayList));
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWarning code: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" msg: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" info: ");
    localStringBuilder.append(paramBundle);
    f(localStringBuilder.toString());
    if (paramInt != 2105) {
      return;
    }
    this.c.post(new f.9(this, paramString, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f
 * JD-Core Version:    0.7.0.1
 */