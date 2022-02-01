package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaPlayHelper
  implements Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  static String l = SharedPreUtils.v(BaseApplication.getContext());
  static String[] m;
  private int A;
  private boolean B;
  private long C;
  private long D;
  private int E;
  private String F;
  private String G;
  private String H;
  private boolean I = false;
  private boolean J = false;
  private long K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private long S;
  private String T;
  private boolean U = true;
  private boolean V = true;
  private boolean W = true;
  private int X = 0;
  private int Y;
  private int Z = -1;
  private String a = "MediaPlayHelperUI";
  private int aa;
  private PowerManager.WakeLock ab;
  private String b = "MediaPlayHelper";
  TVK_IProxyFactory c;
  TVK_IMediaPlayer d;
  Handler e;
  Context f;
  VideoPlayMedioInfo g;
  IAIOImageProvider h;
  long i;
  long j;
  boolean k;
  int n = 0;
  int o = 1;
  private boolean p = false;
  private int q;
  private int r;
  private int s;
  private long t;
  private int u;
  private int v;
  private int w;
  private long x;
  private long y;
  private long z;
  
  static
  {
    String str = l;
    if ((str != null) && (str.length() > 0)) {
      m = l.split("\\|");
    }
  }
  
  private void a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split("\r\n");
    if (paramString == null) {
      return;
    }
    int i2 = 0;
    this.E = b(paramString[0]);
    int i3 = 1;
    int i1 = 1;
    Object localObject1;
    while (i1 < paramString.length)
    {
      localObject1 = paramString[i1];
      if (((String)localObject1).startsWith("User-ReturnCode")) {
        this.F = c((String)localObject1);
      } else if (((String)localObject1).startsWith("X-RtFlag")) {
        this.G = c((String)localObject1);
      } else if (((String)localObject1).startsWith("Content-Type")) {
        this.H = c((String)localObject1);
      }
      i1 += 1;
    }
    paramString = m;
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = this.H;
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = m;
        if ((paramString.length == 1) && (paramString[0] != null) && (paramString[0].toLowerCase().equals("allin")))
        {
          i1 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d(this.a, 2, "check content all in");
            i1 = i3;
          }
        }
        else
        {
          paramString = m;
          int i4 = paramString.length;
          i1 = 0;
          while (i1 < i4)
          {
            localObject1 = paramString[i1];
            if ((localObject1 != null) && (this.H.contains((CharSequence)localObject1)))
            {
              i1 = i3;
              break label259;
            }
            i1 += 1;
          }
          i1 = 0;
        }
        label259:
        if (i1 == 0)
        {
          paramString = new StringBuilder();
          localObject1 = m;
          i3 = localObject1.length;
          i1 = i2;
          while (i1 < i3)
          {
            localObject2 = localObject1[i1];
            if (localObject2 != null)
            {
              paramString.append((String)localObject2);
              paramString.append("|");
            }
            i1 += 1;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("not accept content type: real:");
          ((StringBuilder)localObject1).append(this.H);
          ((StringBuilder)localObject1).append(". whiteList_type :");
          ((StringBuilder)localObject1).append(paramString.toString());
          localObject1 = ((StringBuilder)localObject1).toString();
          if (QLog.isColorLevel()) {
            QLog.d(this.a, 2, (String)localObject1);
          }
          Object localObject2 = new HashMap();
          ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
          ((HashMap)localObject2).put("Content-Type", this.H);
          ((HashMap)localObject2).put("White-List", paramString.toString());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
          throw new IOException((String)localObject1);
        }
      }
    }
  }
  
  private int b(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      int i1 = paramString.indexOf(' ');
      if (i1 >= 0)
      {
        i1 += 1;
        if (i1 < paramString.length())
        {
          paramString = paramString.substring(i1);
          if (paramString != null)
          {
            paramString = paramString.trim();
            paramString = paramString.substring(0, paramString.indexOf(' '));
            try
            {
              i1 = Integer.parseInt(paramString);
              return i1;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
    }
    return -1;
  }
  
  private String c(String paramString)
  {
    if (paramString != null)
    {
      int i1 = paramString.indexOf(':');
      if (i1 >= 0)
      {
        i1 += 1;
        if (i1 < paramString.length())
        {
          paramString = paramString.substring(i1);
          if (paramString != null) {
            return paramString.trim();
          }
        }
      }
    }
    return null;
  }
  
  private boolean l()
  {
    if (!this.p)
    {
      TVK_SDKMgr.initSdk(this.f.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.p = true;
      if (TVK_SDKMgr.isInstalled(this.f.getApplicationContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "TVK_SDKMgr is Installed");
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "start install TVK_SDKMgr ");
      }
      ThreadManagerV2.excute(new MediaPlayHelper.2(this, this.f.getApplicationContext()), 64, null, false);
      return false;
    }
    return true;
  }
  
  private void m()
  {
    Object localObject1 = this.g;
    int i2;
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayMedioInfo)localObject1).f;
      i2 = this.g.g;
    }
    else
    {
      localObject1 = null;
      i2 = -1;
    }
    if ((localObject1 != null) && (this.Z != -1))
    {
      if (((MessageForShortVideo)localObject1).videoFileStatus == 2003) {
        return;
      }
      if (!this.W) {
        return;
      }
      this.W = false;
      long l1 = this.j;
      int i1;
      if (l1 == 0L) {
        i1 = 0;
      } else {
        i1 = (int)(this.i * 100L / l1);
      }
      if (((MessageForShortVideo)localObject1).videoFileProgress < 0) {
        ((MessageForShortVideo)localObject1).videoFileProgress = 0;
      }
      int i3 = ((MessageForShortVideo)localObject1).videoFileProgress;
      if (((((MessageForShortVideo)localObject1).videoFileStatus == 1002) || (((MessageForShortVideo)localObject1).videoFileStatus == 2002)) && (((MessageForShortVideo)localObject1).videoFileStatus == this.Z) && (i1 - i3 < 10)) {
        return;
      }
      if ((i2 != 6) && (i2 != 17) && (i2 != 9) && (i2 != 20))
      {
        i3 = i1;
        if (i2 != 67) {}
      }
      else
      {
        if (this.Z == 2002) {
          ((MessageForShortVideo)localObject1).transferedSize = ((int)this.i);
        }
        i3 = i1;
        if (this.Z == 2003)
        {
          ((MessageForShortVideo)localObject1).transferedSize = 0;
          i3 = 100;
        }
      }
      if ((((MessageForShortVideo)localObject1).videoFileStatus == 2004) || (((MessageForShortVideo)localObject1).videoFileStatus == 1004))
      {
        i1 = this.Z;
        if (i1 == 1002) {
          return;
        }
        if (i1 == 2002) {
          return;
        }
      }
      ((MessageForShortVideo)localObject1).videoFileStatus = this.Z;
      ((MessageForShortVideo)localObject1).fileType = i2;
      ((MessageForShortVideo)localObject1).videoFileProgress = i3;
      Object localObject2 = ShortVideoUtils.findVideoPathIfExists((MessageForShortVideo)localObject1);
      if ((this.Z == 2003) && (!StringUtil.isEmpty((String)localObject2))) {
        ((MessageForShortVideo)localObject1).lastModified = new File((String)localObject2).lastModified();
      }
      localObject2 = this.h;
      if (localObject2 != null) {
        ((IAIOImageProvider)localObject2).a((MessageForShortVideo)localObject1);
      }
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      i2 = paramString.getInt("callBackType");
      i1 = paramString.getInt("fileSize");
      long l1 = i1;
      if (l1 != this.j)
      {
        this.j = l1;
        str = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MediaPlayer] OnDownloadCallback fileSize mismatched msg.file=");
        localStringBuilder.append(this.j);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      i3 = paramString.getInt("newFileSize");
      l1 = paramString.getInt("offset");
      if (!QLog.isColorLevel()) {
        break label1074;
      }
      str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadCallback, offset = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", seekFlagForCacheProgress = ");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" mFileSize=");
      localStringBuilder.append(this.j);
      QLog.d(str, 2, localStringBuilder.toString());
      if (l1 <= 0L) {
        break label1077;
      }
      if (this.k)
      {
        this.i = l1;
        this.k = false;
        break label1077;
      }
      if (l1 > this.i) {
        this.i = l1;
      }
      label246:
      i4 = paramString.getInt("httpDownloadSum");
      this.q = i4;
      if (QLog.isColorLevel())
      {
        str = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnDownloadCallback, mTransferredSize = ");
        localStringBuilder.append(this.i);
        localStringBuilder.append("  httpDownloadSum=");
        localStringBuilder.append(i4);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (i4 > 0) {
        this.r += 1;
      }
      i5 = paramString.getInt("dataFromCacheSize");
      if (this.s < i5) {
        this.s = i5;
      }
      this.Y = paramString.getInt("speedKBS");
      if ((i2 != 7) && (i2 != 3))
      {
        if ((i2 != 1) || (!paramString.has("httpHeader"))) {
          break label1080;
        }
        str = paramString.getString("httpHeader");
      }
    }
    catch (JSONException paramString)
    {
      int i2;
      int i1;
      String str;
      int i3;
      int i4;
      int i5;
      label426:
      paramString.printStackTrace();
    }
    try
    {
      a(str);
    }
    catch (IOException localIOException)
    {
      break label426;
    }
    this.X = 9064;
    this.Z = 2005;
    m();
    if ((!TextUtils.isEmpty(this.F)) && (this.F.equals("-5103059")))
    {
      this.Z = 5002;
      m();
      break label1080;
      if (i2 == 7)
      {
        if (this.g != null) {
          this.g.a = false;
        }
        this.i = this.j;
        this.Z = 2003;
        m();
      }
      if (this.D != 0L)
      {
        this.C = (System.currentTimeMillis() - this.D);
        this.D = 0L;
      }
    }
    label1074:
    label1077:
    label1080:
    for (;;)
    {
      if (this.N == 0) {
        this.N = paramString.getInt("httpRedirectNum");
      }
      if (this.O == 0) {
        this.O = paramString.getInt("httpRedirectCostMs");
      }
      if ((paramString.has("httpDNSCostMs")) && (this.P == 0)) {
        this.P = paramString.getInt("httpDNSCostMs");
      }
      if ((paramString.has("httpConnectCostMs")) && (this.Q == 0)) {
        this.Q = paramString.getInt("httpConnectCostMs");
      }
      if ((paramString.has("httpFirstRecvCostMs")) && (this.R == 0)) {
        this.R = paramString.getInt("httpFirstRecvCostMs");
      }
      if ((paramString.has("httpURL")) && (this.T == null)) {
        this.T = paramString.getString("httpURL");
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("[MediaPlayer] OnDownloadCallback:");
        paramString.append("callBackType=");
        paramString.append(i2);
        paramString.append("|");
        paramString.append("fileSize=");
        paramString.append(i1);
        paramString.append("|");
        paramString.append("newFileSize=");
        paramString.append(i3);
        paramString.append("|");
        paramString.append("offset=");
        paramString.append(this.i);
        paramString.append("|");
        paramString.append("httpDownloadSum=");
        paramString.append(i4);
        paramString.append("|");
        paramString.append("dataFromCacheSize=");
        paramString.append(i5);
        paramString.append("|");
        paramString.append("speedKBS=");
        paramString.append(this.Y);
        paramString.append("|");
        paramString.append("HttpRedirectNum=");
        paramString.append(this.N);
        paramString.append("|");
        paramString.append("HttpRedirectCostMs=");
        paramString.append(this.O);
        paramString.append("|");
        paramString.append("HttpDNSCost=");
        paramString.append(this.P);
        paramString.append("|");
        paramString.append("HttpConnectCost=");
        paramString.append(this.Q);
        paramString.append("|");
        paramString.append("HttpFirstRecvCost=");
        paramString.append(this.R);
        paramString.append("|");
        paramString.append("mHttpUrl=");
        paramString.append(this.T);
        paramString.append("|");
        QLog.i(this.a, 2, paramString.toString());
      }
      if (this.e != null)
      {
        paramString = this.e.obtainMessage();
        paramString.what = 7;
        paramString.arg1 = this.Y;
        this.e.sendMessage(paramString);
        return;
      }
      return;
      break;
      break label246;
    }
  }
  
  public View a(Context paramContext)
  {
    this.c = TVK_SDKMgr.getProxyFactory();
    TVK_IProxyFactory localTVK_IProxyFactory = this.c;
    if (localTVK_IProxyFactory != null)
    {
      paramContext = (View)localTVK_IProxyFactory.createVideoView_Scroll(paramContext);
      paramContext.setBackgroundColor(-16777216);
      paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramContext.setVisibility(0);
      ((IVideoViewBase)paramContext).addViewCallBack(this);
      return paramContext;
    }
    return null;
  }
  
  public View a(Context paramContext, Handler paramHandler, VideoPlayMedioInfo paramVideoPlayMedioInfo, IAIOImageProvider paramIAIOImageProvider)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onCreateVideoSdkView  ");
    }
    this.f = paramContext;
    this.e = paramHandler;
    this.g = paramVideoPlayMedioInfo;
    this.h = paramIAIOImageProvider;
    this.i = paramVideoPlayMedioInfo.p;
    if (this.ab == null)
    {
      paramHandler = this.f;
      if (paramHandler != null)
      {
        this.ab = ((PowerManager)paramHandler.getSystemService("power")).newWakeLock(536870922, this.a);
        this.ab.setReferenceCounted(false);
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "init mWakeLock");
        }
      }
    }
    try
    {
      if (l())
      {
        paramContext = a(paramContext);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramHandler = new HashMap();
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "previewVideoViewCreateSuc", false, 0L, 0L, paramHandler, null);
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, " releaseMediaPlayer");
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      ((TVK_IMediaPlayer)localObject).stop();
      this.d.release();
      this.d.removeAllListener();
      this.d = null;
    }
    if (this.ab != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, " releaseMediaPlayer, mWakeLock.release()");
      }
      this.ab.release();
    }
    this.f = null;
    this.g = null;
    localObject = this.e;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.e = null;
  }
  
  public void a(int paramInt)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.d;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.seekTo(paramInt);
    }
    this.n += 1;
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.L = paramInt1;
    this.M = paramInt2;
    k();
    this.Z = 2005;
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("#play#, videoPath=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new TVK_PlayerVideoInfo();
    ((TVK_PlayerVideoInfo)localObject1).setPlayType(4);
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("shouq_bus_type", "bus_type_preview_local_fs");
    ((TVK_PlayerVideoInfo)localObject1).setReportInfoMap((Map)localObject2);
    localObject2 = this.d;
    if ((localObject2 != null) && (this.f != null))
    {
      ((TVK_IMediaPlayer)localObject2).setOutputMute(this.g.m);
      this.d.openMediaPlayerByUrl(this.f.getApplicationContext(), paramString, paramLong, 0L, (TVK_PlayerVideoInfo)localObject1);
    }
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong, String paramString3, Context paramContext)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString1);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20160518));
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    Object localObject = new HashMap();
    ((Map)localObject).put("shouq_bus_type", "bus_type_aio_long_fs");
    localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
    localTVK_PlayerVideoInfo.setConfigMap("duration", paramString2);
    localTVK_PlayerVideoInfo.setVid(paramString3);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#play#, videoFileTime =");
      localStringBuilder.append(paramString2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      paramString2 = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#play#, setVid =");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(" videoPath=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
      paramString1 = this.a;
      paramString2 = new StringBuilder();
      paramString2.append("#play#, url0 =");
      paramString2.append(paramArrayOfString[0]);
      QLog.d(paramString1, 2, paramString2.toString());
    }
    paramString1 = this.d;
    if (paramString1 != null)
    {
      paramString1.setOutputMute(this.g.m);
      this.d.openMediaPlayerByUrl(paramContext.getApplicationContext(), paramArrayOfString, paramLong, 0L, localTVK_PlayerVideoInfo, null);
    }
  }
  
  public boolean a(Context paramContext, IVideoViewBase paramIVideoViewBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#initMediePlay  ");
    }
    if (this.d == null)
    {
      this.d = this.c.createMediaPlayer(paramContext.getApplicationContext(), paramIVideoViewBase);
      this.d.setOnCompletionListener(this);
      this.d.setOnErrorListener(this);
      this.d.setOnVideoPreparedListener(this);
      this.d.setOnSeekCompleteListener(this);
      this.d.setOnInfoListener(this);
      this.d.setOnNetVideoInfoListener(this);
      this.d.setOnVideoPreparingListener(this);
      this.d.setOnDownloadCallback(this);
      return true;
    }
    return false;
  }
  
  public long b()
  {
    return this.Y;
  }
  
  public void b(int paramInt)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.d;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setDownloadNetworkChange(paramInt);
    }
  }
  
  public void c()
  {
    if (this.d != null)
    {
      if (this.ab != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, " pause, mWakeLock.release()");
        }
        this.ab.release();
      }
      this.d.pause();
    }
  }
  
  public void d()
  {
    if (this.d != null)
    {
      if (this.ab != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, " start, mWakeLock.acquire()");
        }
        this.ab.acquire();
      }
      this.d.start();
    }
  }
  
  public void e()
  {
    this.k = true;
  }
  
  public long f()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.d;
    if (localTVK_IMediaPlayer != null)
    {
      long l1 = localTVK_IMediaPlayer.getCurrentPostion();
      long l2 = this.d.getDuration();
      if (l2 <= 0L) {
        return 0L;
      }
      double d1 = 10000L * l1 / l2;
      Double.isNaN(d1);
      this.aa = ((int)(d1 + 0.5D));
      return l1;
    }
    return 0L;
  }
  
  public long g()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.d;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public boolean h()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.d;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    QLog.d(this.a, 2, "#handleMessage#, ");
  }
  
  public long i()
  {
    return this.i;
  }
  
  public void j()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.d;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public void k()
  {
    if (this.U)
    {
      Object localObject1 = this.g;
      if (localObject1 != null)
      {
        if (this.d == null) {
          return;
        }
        Object localObject2 = ((VideoPlayMedioInfo)localObject1).f;
        if (localObject2 == null) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "#doNewReport#, ");
        }
        HashMap localHashMap = new HashMap();
        StringBuffer localStringBuffer1 = new StringBuffer();
        if (!this.g.a) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        if (this.o == 0) {
          i1 = 3;
        }
        localHashMap.put("player_state", String.valueOf(i1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" player_state ");
        ((StringBuilder)localObject1).append(i1);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("Download", String.valueOf(this.B));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" Download");
        ((StringBuilder)localObject1).append(this.B);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("FileSize", String.valueOf(this.j));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FileSize");
        ((StringBuilder)localObject1).append(this.j);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpDownloadSum", String.valueOf(this.q));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpDownloadSum");
        ((StringBuilder)localObject1).append(this.q);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        if (!this.B)
        {
          localHashMap.put("DataFromCacheSize", String.valueOf(this.j));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" DataFromCacheSize");
          ((StringBuilder)localObject1).append(this.j);
          localStringBuffer1.append(((StringBuilder)localObject1).toString());
        }
        else
        {
          localHashMap.put("DataFromCacheSize", String.valueOf(this.s));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" DataFromCacheSize");
          ((StringBuilder)localObject1).append(this.s);
          localStringBuffer1.append(((StringBuilder)localObject1).toString());
        }
        localHashMap.put("FileDuration", String.valueOf(this.d.getDuration()));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FileDuration");
        ((StringBuilder)localObject1).append(this.d.getDuration());
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("PlayTime", String.valueOf(this.t));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" PlayTime");
        ((StringBuilder)localObject1).append(this.t);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("PlayStateCount", String.valueOf(this.u));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" PlayStateCount");
        ((StringBuilder)localObject1).append(this.u);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("PlayProgress", String.valueOf(this.aa / 100));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" PlayProgress");
        ((StringBuilder)localObject1).append(this.aa / 100);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("FirstPlayTime", String.valueOf(this.x));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FirstPlayTime");
        ((StringBuilder)localObject1).append(this.x);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("FirstBufferTime", String.valueOf(this.y));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FirstBufferTime");
        ((StringBuilder)localObject1).append(this.y);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("SeekTimes", String.valueOf(this.n));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SeekTimes");
        ((StringBuilder)localObject1).append(this.n);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        int i1 = this.A;
        if (i1 != 0) {
          i1 -= 1;
        }
        localHashMap.put("BufferTimes", String.valueOf(i1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" BufferTimes");
        ((StringBuilder)localObject1).append(i1);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("BufferCostTime", String.valueOf(this.z));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" BufferCostTime");
        ((StringBuilder)localObject1).append(this.z);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        if (this.D != 0L)
        {
          this.C = (System.currentTimeMillis() - this.D);
          this.D = 0L;
        }
        i1 = this.r;
        if (i1 != 0) {
          i1 = this.q / (i1 * 1000);
        } else {
          i1 = 0;
        }
        localHashMap.put("SpeedKBS", String.valueOf(i1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SpeedKBS");
        ((StringBuilder)localObject1).append(i1);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        i1 = this.w;
        String str1 = "1";
        if (i1 > 0) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("IsRePlay", localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" IsRePlay");
        ((StringBuilder)localObject1).append(this.w);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("SuspendTimes", String.valueOf(this.v));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SuspendTimes");
        ((StringBuilder)localObject1).append(this.v);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        i1 = this.X;
        boolean bool;
        if (i1 != 0)
        {
          localHashMap.put("param_FailCode", String.valueOf(i1));
          bool = false;
        }
        else
        {
          bool = true;
        }
        localHashMap.put("ErrorCode", String.valueOf(this.L));
        localHashMap.put("ErrorDetailCode", String.valueOf(this.M));
        localHashMap.put("HttpStatus", String.valueOf(this.E));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpStatus");
        ((StringBuilder)localObject1).append(this.E);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("User-ReturnCode", this.F);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" User-ReturnCode");
        ((StringBuilder)localObject1).append(this.F);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("X-RtFlag", this.G);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" X-RtFlag");
        ((StringBuilder)localObject1).append(this.G);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        StringBuffer localStringBuffer2 = new StringBuffer("");
        localObject1 = null;
        if (!StringUtil.isEmpty(this.T)) {
          localObject1 = InnerDns.getHostFromUrl(this.T);
        }
        if ((this.g.c != null) && (this.g.c.length > 0))
        {
          i1 = 0;
          for (int i2 = -1;; i2 = i3)
          {
            i3 = i2;
            if (i1 >= this.g.c.length) {
              break;
            }
            String str2 = InnerDns.getHostFromUrl(this.g.c[i1]);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str2);
            localStringBuilder.append(",");
            localStringBuffer2.append(localStringBuilder.toString());
            i3 = i2;
            if (i2 == -1)
            {
              i3 = i2;
              if (!StringUtil.isEmpty((String)localObject1))
              {
                i3 = i2;
                if (((String)localObject1).equals(str2)) {
                  i3 = i1;
                }
              }
            }
            i1 += 1;
          }
        }
        int i3 = -1;
        localHashMap.put("IpList", localStringBuffer2.toString());
        i1 = i3 + 1;
        localHashMap.put("SuccIpIndex", String.valueOf(i1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SuccIpIndex");
        ((StringBuilder)localObject1).append(i1);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpDomain", this.g.e);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpDomain");
        ((StringBuilder)localObject1).append(this.g.e);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpRedirectNum", String.valueOf(this.N));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpRedirectNum");
        ((StringBuilder)localObject1).append(this.N);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpRedirectCostMs", String.valueOf(this.O));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpRedirectCostMs");
        ((StringBuilder)localObject1).append(this.O);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpDnsCostMs", String.valueOf(this.P));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpDnsCostMs");
        ((StringBuilder)localObject1).append(this.P);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpConnectCostMs", String.valueOf(this.Q));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpConnectCostMs");
        ((StringBuilder)localObject1).append(this.Q);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.R));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpFirstRecvCostMs");
        ((StringBuilder)localObject1).append(this.R);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("RetrySuccessTimes", "0");
        localHashMap.put("RetryFailedTimes", "0");
        localHashMap.put("ApplyCostTime", String.valueOf(this.S));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" ApplyCostTime");
        ((StringBuilder)localObject1).append(this.S);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpCostTime", String.valueOf(this.C));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpCostTime");
        ((StringBuilder)localObject1).append(this.C);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("DownType", "1");
        localHashMap.put("SceneType", "2");
        localHashMap.put("BusiType", "0");
        localHashMap.put("SubBusiType", String.valueOf(((MessageForShortVideo)localObject2).subBusiType));
        SVUtils.a((MessageForShortVideo)localObject2);
        localHashMap.put("FromUin", String.valueOf(SVUtils.a((MessageForShortVideo)localObject2)));
        localHashMap.put("Uuid", String.valueOf(((MessageForShortVideo)localObject2).uuid));
        localHashMap.put("MsgFileMd5", String.valueOf(((MessageForShortVideo)localObject2).md5));
        localHashMap.put("DownFileMd5", String.valueOf(((MessageForShortVideo)localObject2).md5));
        localObject1 = String.valueOf(NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()));
        localHashMap.put("NetworkInfo", localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" NetworkInfo");
        ((StringBuilder)localObject2).append((String)localObject1);
        localStringBuffer1.append(((StringBuilder)localObject2).toString());
        localHashMap.put("ProductVersion", String.valueOf(AppSetting.d()));
        localHashMap.put("EncryptKey", "0");
        if (this.I) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("IsUpdateSuit", localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" IsUpdateSuit");
        if (this.I) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        localStringBuffer1.append(((StringBuilder)localObject2).toString());
        localHashMap.put("UpdateSuitCostTime", String.valueOf(this.K));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" UpdateSuitCostTime");
        ((StringBuilder)localObject1).append(this.K);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        if (this.J) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("UpdateSuitResult", localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" UpdateSuitResult");
        if (this.J) {
          localObject1 = str1;
        } else {
          localObject1 = "0";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        localStringBuffer1.append(((StringBuilder)localObject2).toString());
        if (QLog.isColorLevel()) {
          QLog.w(this.a, 2, localStringBuffer1.toString());
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actStreamingVideoPlay", bool, this.C, this.j, localHashMap, "");
        this.U = false;
        this.u = 0;
        this.n = 0;
        this.A = 0;
        this.v = 0;
        this.z = 0L;
        this.C = 0L;
        this.t = 0L;
        this.Q = 0;
        this.P = 0;
        this.x = 0L;
        this.y = 0L;
        this.S = 0L;
        this.R = 0;
        this.O = 0;
        this.K = 0L;
        this.L = 0;
        this.M = 0;
      }
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d(this.a, 2, "#onCompletion#, ");
    paramTVK_IMediaPlayer = this.e;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(2);
    }
    if (VersionUtils.b())
    {
      paramTVK_IMediaPlayer = this.f;
      if (paramTVK_IMediaPlayer != null) {
        ((AudioManager)paramTVK_IMediaPlayer.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
    paramTVK_IMediaPlayer = this.ab;
    if (paramTVK_IMediaPlayer != null)
    {
      paramTVK_IMediaPlayer.release();
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, " onCompletion, mWakeLock.release()");
      }
    }
    k();
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MediaPlayer] onError what=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",extra=");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.o = 0;
    a(paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    paramTVK_IMediaPlayer = this.e;
    if (paramTVK_IMediaPlayer != null)
    {
      paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.obtainMessage();
      paramTVK_IMediaPlayer.what = 100;
      paramTVK_IMediaPlayer.arg1 = paramInt1;
      paramTVK_IMediaPlayer.arg2 = paramInt2;
      this.e.sendMessage(paramTVK_IMediaPlayer);
    }
    if (this.ab != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, " onError, mWakeLock.release()");
      }
      this.ab.release();
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (paramInt != 21)
    {
      if (paramInt == 22)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "video end buffering !");
        }
        paramTVK_IMediaPlayer = this.e;
        if (paramTVK_IMediaPlayer != null)
        {
          paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.obtainMessage();
          paramTVK_IMediaPlayer.what = 200;
          paramTVK_IMediaPlayer.arg1 = 92;
          paramTVK_IMediaPlayer.arg2 = paramInt;
          this.e.sendMessage(paramTVK_IMediaPlayer);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "video start buffering !");
      }
      paramTVK_IMediaPlayer = this.e;
      if (paramTVK_IMediaPlayer != null)
      {
        paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.obtainMessage();
        paramTVK_IMediaPlayer.what = 200;
        paramTVK_IMediaPlayer.arg1 = 929;
        this.e.sendMessage(paramTVK_IMediaPlayer);
      }
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onNetVideoInfo#, ");
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onSeekComplete#, ");
    }
    paramTVK_IMediaPlayer = this.e;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(4);
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onSurfaceChanged#, ");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onSurfaceCreated#, ");
    }
    paramSurfaceHolder = this.g;
    if (paramSurfaceHolder != null) {
      if (!paramSurfaceHolder.a)
      {
        if (this.g.b != null) {
          a(this.g.b, this.g.q);
        }
      }
      else if (!this.g.h)
      {
        if (this.g.f == null) {
          paramSurfaceHolder = "0";
        } else {
          paramSurfaceHolder = String.valueOf(this.g.f.videoFileTime);
        }
        String str;
        if (this.g.f == null) {
          str = "";
        } else {
          str = this.g.f.md5;
        }
        a(this.g.a(), paramSurfaceHolder, this.g.c, this.g.q, str, this.f);
      }
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onSurfaceDestory#, ");
    }
    paramSurfaceHolder = this.d;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.stop();
    }
    if (VersionUtils.b())
    {
      paramSurfaceHolder = this.f;
      if (paramSurfaceHolder != null) {
        ((AudioManager)paramSurfaceHolder.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
    if (this.ab != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, " onSurfaceDestory, mWakeLock.release()");
      }
      this.ab.release();
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onVideoPrepared#, ");
    }
    paramTVK_IMediaPlayer = this.e;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(1);
    }
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "#onVideoPreparing#, ");
    }
    paramTVK_IMediaPlayer = this.e;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaPlayHelper
 * JD-Core Version:    0.7.0.1
 */