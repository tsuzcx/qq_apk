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
  static String jdField_a_of_type_JavaLangString = SharedPreUtils.f(BaseApplication.getContext());
  static String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  VideoPlayMedioInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
  TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 1;
  long jdField_b_of_type_Long;
  Context jdField_b_of_type_AndroidContentContext;
  private String jdField_b_of_type_JavaLangString = "MediaPlayHelperUI";
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString = "MediaPlayHelper";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private long jdField_i_of_type_Long;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r = 0;
  private int s;
  private int t = -1;
  private int u;
  
  static
  {
    String str = jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.length() > 0)) {
      jdField_a_of_type_ArrayOfJavaLangString = jdField_a_of_type_JavaLangString.split("\\|");
    }
  }
  
  private int a(String paramString)
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
  
  private String a(String paramString)
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
  
  private void a(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return;
    }
    paramString = paramString.split("\r\n");
    if (paramString == null) {
      return;
    }
    int i2 = 0;
    this.jdField_j_of_type_Int = a(paramString[0]);
    int i3 = 1;
    int i1 = 1;
    Object localObject1;
    while (i1 < paramString.length)
    {
      localObject1 = paramString[i1];
      if (((String)localObject1).startsWith("User-ReturnCode")) {
        this.jdField_d_of_type_JavaLangString = a((String)localObject1);
      } else if (((String)localObject1).startsWith("X-RtFlag")) {
        this.jdField_e_of_type_JavaLangString = a((String)localObject1);
      } else if (((String)localObject1).startsWith("Content-Type")) {
        this.jdField_f_of_type_JavaLangString = a((String)localObject1);
      }
      i1 += 1;
    }
    paramString = jdField_a_of_type_ArrayOfJavaLangString;
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = this.jdField_f_of_type_JavaLangString;
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = jdField_a_of_type_ArrayOfJavaLangString;
        if ((paramString.length == 1) && (paramString[0] != null) && (paramString[0].toLowerCase().equals("allin")))
        {
          i1 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "check content all in");
            i1 = i3;
          }
        }
        else
        {
          paramString = jdField_a_of_type_ArrayOfJavaLangString;
          int i4 = paramString.length;
          i1 = 0;
          while (i1 < i4)
          {
            localObject1 = paramString[i1];
            if ((localObject1 != null) && (this.jdField_f_of_type_JavaLangString.contains((CharSequence)localObject1)))
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
          localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
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
          ((StringBuilder)localObject1).append(this.jdField_f_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(". whiteList_type :");
          ((StringBuilder)localObject1).append(paramString.toString());
          localObject1 = ((StringBuilder)localObject1).toString();
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, (String)localObject1);
          }
          Object localObject2 = new HashMap();
          ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
          ((HashMap)localObject2).put("Content-Type", this.jdField_f_of_type_JavaLangString);
          ((HashMap)localObject2).put("White-List", paramString.toString());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
          throw new IOException((String)localObject1);
        }
      }
    }
  }
  
  private boolean b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(this.jdField_b_of_type_AndroidContentContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_b_of_type_Boolean = true;
      if (TVK_SDKMgr.isInstalled(this.jdField_b_of_type_AndroidContentContext.getApplicationContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "TVK_SDKMgr is Installed");
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "start install TVK_SDKMgr ");
      }
      ThreadManagerV2.excute(new MediaPlayHelper.2(this, this.jdField_b_of_type_AndroidContentContext.getApplicationContext()), 64, null, false);
      return false;
    }
    return true;
  }
  
  private void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
    int i2;
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Int;
    }
    else
    {
      localObject1 = null;
      i2 = -1;
    }
    if ((localObject1 != null) && (this.t != -1))
    {
      if (((MessageForShortVideo)localObject1).videoFileStatus == 2003) {
        return;
      }
      if (!this.jdField_h_of_type_Boolean) {
        return;
      }
      this.jdField_h_of_type_Boolean = false;
      long l1 = this.jdField_b_of_type_Long;
      int i1;
      if (l1 == 0L) {
        i1 = 0;
      } else {
        i1 = (int)(this.jdField_a_of_type_Long * 100L / l1);
      }
      if (((MessageForShortVideo)localObject1).videoFileProgress < 0) {
        ((MessageForShortVideo)localObject1).videoFileProgress = 0;
      }
      int i3 = ((MessageForShortVideo)localObject1).videoFileProgress;
      if (((((MessageForShortVideo)localObject1).videoFileStatus == 1002) || (((MessageForShortVideo)localObject1).videoFileStatus == 2002)) && (((MessageForShortVideo)localObject1).videoFileStatus == this.t) && (i1 - i3 < 10)) {
        return;
      }
      if ((i2 != 6) && (i2 != 17) && (i2 != 9))
      {
        i3 = i1;
        if (i2 != 20) {}
      }
      else
      {
        if (this.t == 2002) {
          ((MessageForShortVideo)localObject1).transferedSize = ((int)this.jdField_a_of_type_Long);
        }
        i3 = i1;
        if (this.t == 2003)
        {
          ((MessageForShortVideo)localObject1).transferedSize = 0;
          i3 = 100;
        }
      }
      if ((((MessageForShortVideo)localObject1).videoFileStatus == 2004) || (((MessageForShortVideo)localObject1).videoFileStatus == 1004))
      {
        i1 = this.t;
        if (i1 == 1002) {
          return;
        }
        if (i1 == 2002) {
          return;
        }
      }
      ((MessageForShortVideo)localObject1).videoFileStatus = this.t;
      ((MessageForShortVideo)localObject1).fileType = i2;
      ((MessageForShortVideo)localObject1).videoFileProgress = i3;
      Object localObject2 = ShortVideoUtils.findVideoPathIfExists((MessageForShortVideo)localObject1);
      if ((this.t == 2003) && (!StringUtil.a((String)localObject2))) {
        ((MessageForShortVideo)localObject1).lastModified = new File((String)localObject2).lastModified();
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
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
      if (l1 != this.jdField_b_of_type_Long)
      {
        this.jdField_b_of_type_Long = l1;
        str = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[MediaPlayer] OnDownloadCallback fileSize mismatched msg.file=");
        localStringBuilder.append(this.jdField_b_of_type_Long);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      i3 = paramString.getInt("newFileSize");
      l1 = paramString.getInt("offset");
      if (!QLog.isColorLevel()) {
        break label1074;
      }
      str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadCallback, offset = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", seekFlagForCacheProgress = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" mFileSize=");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      QLog.d(str, 2, localStringBuilder.toString());
      if (l1 <= 0L) {
        break label1077;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_Boolean = false;
        break label1077;
      }
      if (l1 > this.jdField_a_of_type_Long) {
        this.jdField_a_of_type_Long = l1;
      }
      label246:
      i4 = paramString.getInt("httpDownloadSum");
      this.jdField_c_of_type_Int = i4;
      if (QLog.isColorLevel())
      {
        str = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnDownloadCallback, mTransferredSize = ");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append("  httpDownloadSum=");
        localStringBuilder.append(i4);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (i4 > 0) {
        this.jdField_d_of_type_Int += 1;
      }
      i5 = paramString.getInt("dataFromCacheSize");
      if (this.jdField_e_of_type_Int < i5) {
        this.jdField_e_of_type_Int = i5;
      }
      this.s = paramString.getInt("speedKBS");
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
    this.r = 9064;
    this.t = 2005;
    g();
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals("-5103059")))
    {
      this.t = 5002;
      g();
      break label1080;
      if (i2 == 7)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        this.t = 2003;
        g();
      }
      if (this.jdField_h_of_type_Long != 0L)
      {
        this.jdField_g_of_type_Long = (System.currentTimeMillis() - this.jdField_h_of_type_Long);
        this.jdField_h_of_type_Long = 0L;
      }
    }
    label1074:
    label1077:
    label1080:
    for (;;)
    {
      if (this.m == 0) {
        this.m = paramString.getInt("httpRedirectNum");
      }
      if (this.n == 0) {
        this.n = paramString.getInt("httpRedirectCostMs");
      }
      if ((paramString.has("httpDNSCostMs")) && (this.o == 0)) {
        this.o = paramString.getInt("httpDNSCostMs");
      }
      if ((paramString.has("httpConnectCostMs")) && (this.p == 0)) {
        this.p = paramString.getInt("httpConnectCostMs");
      }
      if ((paramString.has("httpFirstRecvCostMs")) && (this.q == 0)) {
        this.q = paramString.getInt("httpFirstRecvCostMs");
      }
      if ((paramString.has("httpURL")) && (this.jdField_g_of_type_JavaLangString == null)) {
        this.jdField_g_of_type_JavaLangString = paramString.getString("httpURL");
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
        paramString.append(this.jdField_a_of_type_Long);
        paramString.append("|");
        paramString.append("httpDownloadSum=");
        paramString.append(i4);
        paramString.append("|");
        paramString.append("dataFromCacheSize=");
        paramString.append(i5);
        paramString.append("|");
        paramString.append("speedKBS=");
        paramString.append(this.s);
        paramString.append("|");
        paramString.append("HttpRedirectNum=");
        paramString.append(this.m);
        paramString.append("|");
        paramString.append("HttpRedirectCostMs=");
        paramString.append(this.n);
        paramString.append("|");
        paramString.append("HttpDNSCost=");
        paramString.append(this.o);
        paramString.append("|");
        paramString.append("HttpConnectCost=");
        paramString.append(this.p);
        paramString.append("|");
        paramString.append("HttpFirstRecvCost=");
        paramString.append(this.q);
        paramString.append("|");
        paramString.append("mHttpUrl=");
        paramString.append(this.jdField_g_of_type_JavaLangString);
        paramString.append("|");
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, paramString.toString());
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString.what = 7;
        paramString.arg1 = this.s;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
      return;
      break;
      break label246;
    }
  }
  
  public long a()
  {
    return this.s;
  }
  
  public View a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    TVK_IProxyFactory localTVK_IProxyFactory = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onCreateVideoSdkView  ");
    }
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = paramVideoPlayMedioInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_a_of_type_Long = paramVideoPlayMedioInfo.jdField_d_of_type_Long;
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null)
    {
      paramHandler = this.jdField_b_of_type_AndroidContentContext;
      if (paramHandler != null)
      {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)paramHandler.getSystemService("power")).newWakeLock(536870922, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "init mWakeLock");
        }
      }
    }
    try
    {
      if (b())
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, " releaseMediaPlayer");
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localObject != null)
    {
      ((TVK_IMediaPlayer)localObject).stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.removeAllListener();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " releaseMediaPlayer, mWakeLock.release()");
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    this.jdField_b_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = null;
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public void a(int paramInt)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.seekTo(paramInt);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    f();
    this.t = 2005;
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
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
    localObject2 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if ((localObject2 != null) && (this.jdField_b_of_type_AndroidContentContext != null))
    {
      ((TVK_IMediaPlayer)localObject2).setOutputMute(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_b_of_type_AndroidContentContext.getApplicationContext(), paramString, paramLong, 0L, (TVK_PlayerVideoInfo)localObject1);
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
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#play#, videoFileTime =");
      localStringBuilder.append(paramString2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      paramString2 = this.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#play#, setVid =");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(" videoPath=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
      paramString1 = this.jdField_b_of_type_JavaLangString;
      paramString2 = new StringBuilder();
      paramString2.append("#play#, url0 =");
      paramString2.append(paramArrayOfString[0]);
      QLog.d(paramString1, 2, paramString2.toString());
    }
    paramString1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramString1 != null)
    {
      paramString1.setOutputMute(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_e_of_type_Boolean);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(paramContext.getApplicationContext(), paramArrayOfString, paramLong, 0L, localTVK_PlayerVideoInfo, null);
    }
  }
  
  public boolean a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public boolean a(Context paramContext, IVideoViewBase paramIVideoViewBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#initMediePlay  ");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext.getApplicationContext(), paramIVideoViewBase);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
      return true;
    }
    return false;
  }
  
  public long b()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      long l1 = localTVK_IMediaPlayer.getCurrentPostion();
      long l2 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
      if (l2 <= 0L) {
        return 0L;
      }
      double d1 = 10000L * l1 / l2;
      Double.isNaN(d1);
      this.u = ((int)(d1 + 0.5D));
      return l1;
    }
    return 0L;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, " pause, mWakeLock.release()");
        }
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void b(int paramInt)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setDownloadNetworkChange(paramInt);
    }
  }
  
  public long c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      return localTVK_IMediaPlayer.getDuration();
    }
    return 0L;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, " start, mWakeLock.acquire()");
        }
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public void f()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
          return;
        }
        Object localObject2 = ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        if (localObject2 == null) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#doNewReport#, ");
        }
        HashMap localHashMap = new HashMap();
        StringBuffer localStringBuffer1 = new StringBuffer();
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        if (this.jdField_b_of_type_Int == 0) {
          i1 = 3;
        }
        localHashMap.put("player_state", String.valueOf(i1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" player_state ");
        ((StringBuilder)localObject1).append(i1);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("Download", String.valueOf(this.jdField_c_of_type_Boolean));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" Download");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("FileSize", String.valueOf(this.jdField_b_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FileSize");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_Long);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpDownloadSum", String.valueOf(this.jdField_c_of_type_Int));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpDownloadSum");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        if (!this.jdField_c_of_type_Boolean)
        {
          localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_b_of_type_Long));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" DataFromCacheSize");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_Long);
          localStringBuffer1.append(((StringBuilder)localObject1).toString());
        }
        else
        {
          localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_e_of_type_Int));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" DataFromCacheSize");
          ((StringBuilder)localObject1).append(this.jdField_e_of_type_Int);
          localStringBuffer1.append(((StringBuilder)localObject1).toString());
        }
        localHashMap.put("FileDuration", String.valueOf(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration()));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FileDuration");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("PlayTime", String.valueOf(this.jdField_c_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" PlayTime");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("PlayStateCount", String.valueOf(this.jdField_f_of_type_Int));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" PlayStateCount");
        ((StringBuilder)localObject1).append(this.jdField_f_of_type_Int);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("PlayProgress", String.valueOf(this.u / 100));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" PlayProgress");
        ((StringBuilder)localObject1).append(this.u / 100);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("FirstPlayTime", String.valueOf(this.jdField_d_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FirstPlayTime");
        ((StringBuilder)localObject1).append(this.jdField_d_of_type_Long);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("FirstBufferTime", String.valueOf(this.jdField_e_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" FirstBufferTime");
        ((StringBuilder)localObject1).append(this.jdField_e_of_type_Long);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("SeekTimes", String.valueOf(this.jdField_a_of_type_Int));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SeekTimes");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        int i1 = this.jdField_i_of_type_Int;
        if (i1 != 0) {
          i1 -= 1;
        }
        localHashMap.put("BufferTimes", String.valueOf(i1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" BufferTimes");
        ((StringBuilder)localObject1).append(i1);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("BufferCostTime", String.valueOf(this.jdField_f_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" BufferCostTime");
        ((StringBuilder)localObject1).append(this.jdField_f_of_type_Long);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        if (this.jdField_h_of_type_Long != 0L)
        {
          this.jdField_g_of_type_Long = (System.currentTimeMillis() - this.jdField_h_of_type_Long);
          this.jdField_h_of_type_Long = 0L;
        }
        i1 = this.jdField_d_of_type_Int;
        if (i1 != 0) {
          i1 = this.jdField_c_of_type_Int / (i1 * 1000);
        } else {
          i1 = 0;
        }
        localHashMap.put("SpeedKBS", String.valueOf(i1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SpeedKBS");
        ((StringBuilder)localObject1).append(i1);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        i1 = this.jdField_h_of_type_Int;
        String str1 = "1";
        if (i1 > 0) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("IsRePlay", localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" IsRePlay");
        ((StringBuilder)localObject1).append(this.jdField_h_of_type_Int);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("SuspendTimes", String.valueOf(this.jdField_g_of_type_Int));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" SuspendTimes");
        ((StringBuilder)localObject1).append(this.jdField_g_of_type_Int);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        i1 = this.r;
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
        localHashMap.put("ErrorCode", String.valueOf(this.k));
        localHashMap.put("ErrorDetailCode", String.valueOf(this.l));
        localHashMap.put("HttpStatus", String.valueOf(this.jdField_j_of_type_Int));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpStatus");
        ((StringBuilder)localObject1).append(this.jdField_j_of_type_Int);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("User-ReturnCode", this.jdField_d_of_type_JavaLangString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" User-ReturnCode");
        ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangString);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("X-RtFlag", this.jdField_e_of_type_JavaLangString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" X-RtFlag");
        ((StringBuilder)localObject1).append(this.jdField_e_of_type_JavaLangString);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        StringBuffer localStringBuffer2 = new StringBuffer("");
        localObject1 = null;
        if (!StringUtil.a(this.jdField_g_of_type_JavaLangString)) {
          localObject1 = InnerDns.getHostFromUrl(this.jdField_g_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
        {
          i1 = 0;
          for (int i2 = -1;; i2 = i3)
          {
            i3 = i2;
            if (i1 >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString.length) {
              break;
            }
            String str2 = InnerDns.getHostFromUrl(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString[i1]);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str2);
            localStringBuilder.append(",");
            localStringBuffer2.append(localStringBuilder.toString());
            i3 = i2;
            if (i2 == -1)
            {
              i3 = i2;
              if (!StringUtil.a((String)localObject1))
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
        localHashMap.put("HttpDomain", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_JavaLangString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpDomain");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_JavaLangString);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpRedirectNum", String.valueOf(this.m));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpRedirectNum");
        ((StringBuilder)localObject1).append(this.m);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpRedirectCostMs", String.valueOf(this.n));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpRedirectCostMs");
        ((StringBuilder)localObject1).append(this.n);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpDnsCostMs", String.valueOf(this.o));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpDnsCostMs");
        ((StringBuilder)localObject1).append(this.o);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpConnectCostMs", String.valueOf(this.p));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpConnectCostMs");
        ((StringBuilder)localObject1).append(this.p);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.q));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpFirstRecvCostMs");
        ((StringBuilder)localObject1).append(this.q);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("RetrySuccessTimes", "0");
        localHashMap.put("RetryFailedTimes", "0");
        localHashMap.put("ApplyCostTime", String.valueOf(this.jdField_j_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" ApplyCostTime");
        ((StringBuilder)localObject1).append(this.jdField_j_of_type_Long);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        localHashMap.put("HttpCostTime", String.valueOf(this.jdField_g_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" HttpCostTime");
        ((StringBuilder)localObject1).append(this.jdField_g_of_type_Long);
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
        localHashMap.put("ProductVersion", String.valueOf(AppSetting.a()));
        localHashMap.put("EncryptKey", "0");
        if (this.jdField_d_of_type_Boolean) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("IsUpdateSuit", localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" IsUpdateSuit");
        if (this.jdField_d_of_type_Boolean) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        localStringBuffer1.append(((StringBuilder)localObject2).toString());
        localHashMap.put("UpdateSuitCostTime", String.valueOf(this.jdField_i_of_type_Long));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" UpdateSuitCostTime");
        ((StringBuilder)localObject1).append(this.jdField_i_of_type_Long);
        localStringBuffer1.append(((StringBuilder)localObject1).toString());
        if (this.jdField_e_of_type_Boolean) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        localHashMap.put("UpdateSuitResult", localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" UpdateSuitResult");
        if (this.jdField_e_of_type_Boolean) {
          localObject1 = str1;
        } else {
          localObject1 = "0";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        localStringBuffer1.append(((StringBuilder)localObject2).toString());
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, localStringBuffer1.toString());
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actStreamingVideoPlay", bool, this.jdField_g_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "");
        this.jdField_f_of_type_Boolean = false;
        this.jdField_f_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_i_of_type_Int = 0;
        this.jdField_g_of_type_Int = 0;
        this.jdField_f_of_type_Long = 0L;
        this.jdField_g_of_type_Long = 0L;
        this.jdField_c_of_type_Long = 0L;
        this.p = 0;
        this.o = 0;
        this.jdField_d_of_type_Long = 0L;
        this.jdField_e_of_type_Long = 0L;
        this.jdField_j_of_type_Long = 0L;
        this.q = 0;
        this.n = 0;
        this.jdField_i_of_type_Long = 0L;
        this.k = 0;
        this.l = 0;
      }
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleMessage#, ");
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onCompletion#, ");
    paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(2);
    }
    if (VersionUtils.b())
    {
      paramTVK_IMediaPlayer = this.jdField_b_of_type_AndroidContentContext;
      if (paramTVK_IMediaPlayer != null) {
        ((AudioManager)paramTVK_IMediaPlayer.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
    paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsPowerManager$WakeLock;
    if (paramTVK_IMediaPlayer != null)
    {
      paramTVK_IMediaPlayer.release();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onCompletion, mWakeLock.release()");
      }
    }
    f();
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MediaPlayer] onError what=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",extra=");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = 0;
    a(paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler;
    if (paramTVK_IMediaPlayer != null)
    {
      paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.obtainMessage();
      paramTVK_IMediaPlayer.what = 100;
      paramTVK_IMediaPlayer.arg1 = paramInt1;
      paramTVK_IMediaPlayer.arg2 = paramInt2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramTVK_IMediaPlayer);
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onError, mWakeLock.release()");
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
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
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "video end buffering !");
        }
        paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler;
        if (paramTVK_IMediaPlayer != null)
        {
          paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.obtainMessage();
          paramTVK_IMediaPlayer.what = 200;
          paramTVK_IMediaPlayer.arg1 = 92;
          paramTVK_IMediaPlayer.arg2 = paramInt;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramTVK_IMediaPlayer);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "video start buffering !");
      }
      paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler;
      if (paramTVK_IMediaPlayer != null)
      {
        paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.obtainMessage();
        paramTVK_IMediaPlayer.what = 200;
        paramTVK_IMediaPlayer.arg1 = 929;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramTVK_IMediaPlayer);
      }
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onNetVideoInfo#, ");
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSeekComplete#, ");
    }
    paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(4);
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSurfaceChanged#, ");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSurfaceCreated#, ");
    }
    paramSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
    if (paramSurfaceHolder != null) {
      if (!paramSurfaceHolder.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString != null) {
          a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_e_of_type_Long);
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          paramSurfaceHolder = "0";
        } else {
          paramSurfaceHolder = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
        }
        String str;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          str = "";
        } else {
          str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.a(), paramSurfaceHolder, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_e_of_type_Long, str, this.jdField_b_of_type_AndroidContentContext);
      }
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onSurfaceDestory#, ");
    }
    paramSurfaceHolder = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.stop();
    }
    if (VersionUtils.b())
    {
      paramSurfaceHolder = this.jdField_b_of_type_AndroidContentContext;
      if (paramSurfaceHolder != null) {
        ((AudioManager)paramSurfaceHolder.getSystemService("audio")).abandonAudioFocus(null);
      }
    }
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onSurfaceDestory, mWakeLock.release()");
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onVideoPrepared#, ");
    }
    paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(1);
    }
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#onVideoPreparing#, ");
    }
    paramTVK_IMediaPlayer = this.jdField_a_of_type_AndroidOsHandler;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaPlayHelper
 * JD-Core Version:    0.7.0.1
 */