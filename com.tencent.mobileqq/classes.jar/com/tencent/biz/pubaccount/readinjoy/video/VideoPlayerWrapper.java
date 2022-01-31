package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnPreAdListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mez;
import mfa;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoPlayerWrapper
  implements VideoPlayManager.PlayState, TVK_IMediaPlayer.OnCaptureImageListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnPreAdListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int = 2;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  private VideoPlayerWrapper.MediaPlayListenerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private TVK_NetVideoInfo.DefnInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private TVK_UserInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo;
  private Object jdField_a_of_type_JavaLangObject;
  public ArrayList a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private int b;
  public long b;
  public boolean b;
  private int jdField_c_of_type_Int;
  public long c;
  private boolean jdField_c_of_type_Boolean;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  
  public VideoPlayerWrapper(Context paramContext)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private View b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
    {
      a();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        return null;
      }
    }
    if (VersionUtils.d()) {
      return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    }
    return (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(this, paramString);
    }
    long l = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(paramString)) && ((this.j == 0L) || (l - this.j > 5000L))) {}
    try
    {
      paramString = new JSONObject(paramString);
      l = paramString.getLong("fileSize");
      int k = paramString.getInt("speedKBS");
      int m = paramString.getInt("offset");
      if ((l > 0L) && (this.jdField_b_of_type_Long == 0L)) {
        this.jdField_b_of_type_Long = l;
      }
      if (k >= 0)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
      }
      if (m > 0) {
        this.jdField_c_of_type_Long = m;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
  }
  
  public long a(boolean paramBoolean)
  {
    long l2 = this.e;
    if (paramBoolean) {}
    for (long l1 = b(); l1 - this.f > 0L; l1 = a()) {
      return l1 - this.f + l2;
    }
    return l2;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    try
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = b();
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() != null))
      {
        ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "remove scroll view parents!");
        }
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
    finally {}
  }
  
  public TVK_IMediaPlayer a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper initPlayer success!");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(VideoVolumeControl.a().a());
      c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      if (l1 - this.f > 0L)
      {
        long l2 = this.e;
        this.e = (l1 - this.f + l2);
      }
      this.f = paramInt;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(VideoPlayerWrapper.MediaPlayListenerAdapter paramMediaPlayListenerAdapter)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter = paramMediaPlayListenerAdapter;
  }
  
  public void a(IVideoViewBase paramIVideoViewBase)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {}
    while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(paramIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(this.jdField_b_of_type_Int);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "#VideoPlayerWrapper# playerStart, vid:" + paramString + ", playType:" + paramInt + ", startPosition:" + paramLong + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      QLog.e("Q.readinjoy.video", 1, "not idle state, should't reopen mediaplayer, vid:" + paramString + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
    paramString = new TVK_PlayerVideoInfo(paramInt, paramString, "");
    paramString.setPlayMode("cache_video");
    paramString.setConfigMap("keep_last_frame", "true");
    paramString.setConfigMap("cache_servers_type", "20160519");
    Object localObject = new HashMap();
    ((Map)localObject).put("shouq_bus_type", "bus_type_kandian_feeds");
    paramString.setReportInfoMap((Map)localObject);
    paramString.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    localObject = VideoPlayUtils.a();
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, paramString, (String)localObject, paramLong, 0L);
    }
    this.e = 0L;
    this.d = 0L;
    this.f = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, false, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean, true);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "#VideoPlayerWrapper# playerStartByUrl, url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      QLog.e("Q.readinjoy.video", 1, "not idle state, should't reopen mediaplayer, vid:" + paramString1 + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      return;
    }
    paramString1 = new TVK_PlayerVideoInfo(paramInt1, paramString1, "");
    if (paramLong2 > 0L) {
      paramString1.setConfigMap("filesize", String.valueOf(paramLong2));
    }
    if (paramInt2 > 0) {
      paramString1.setConfigMap("duration", String.valueOf(paramInt2));
    }
    paramString1.setConfigMap("keep_last_frame", "true");
    paramString1.setConfigMap("cache_servers_type", "20160519");
    if (paramBoolean1) {
      paramString1.setConfigMap("software_play", "true");
    }
    paramString1.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (!paramBoolean2) {
        break label281;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, ThirdVideoManager.a(paramString2), paramLong1, 0L, paramString1, null);
    }
    for (;;)
    {
      this.e = 0L;
      this.d = 0L;
      this.f = paramLong1;
      this.jdField_a_of_type_Int = paramInt1;
      return;
      label281:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString2, paramLong1, 0L, paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void a(String[] paramArrayOfString, String paramString1, int paramInt, String paramString2, long paramLong, TVK_IMediaPlayer.OnDownloadCallbackListener paramOnDownloadCallbackListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "#VideoPlayerWrapper# playerStartByUrlsForShortVideo, urls:" + Arrays.toString(paramArrayOfString) + ", localVideoPath:" + paramString1 + ", videoMD5:" + paramString2 + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      QLog.e("Q.readinjoy.video", 1, "not idle state, should't reopen mediaplayer, urls:" + Arrays.toString(paramArrayOfString) + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", videoMD5:" + paramString2);
      return;
    }
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", paramString1);
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setConfigMap("duration", String.valueOf(paramInt));
    localTVK_PlayerVideoInfo.setVid(paramString2);
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(paramOnDownloadCallbackListener);
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramArrayOfString, paramLong, 0L, localTVK_PlayerVideoInfo, null);
    }
    this.e = 0L;
    this.d = 0L;
    this.f = paramLong;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      return 1;
    }
    return 0;
  }
  
  public long b()
  {
    if (this.d != 0L) {
      return this.d;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    return -1L;
  }
  
  public long b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b();
    }
    return a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.video", 2, "VideoPlayerWrapper: setXYaxis value:" + paramInt);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing();
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long c()
  {
    return this.h;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnPreAdListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCaptureImageListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public long d()
  {
    return this.f;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public long e()
  {
    if ((this.i == 0L) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      int n = this.jdField_a_of_type_JavaUtilArrayList.size();
      int k = 0;
      int m = 0;
      while (k < n)
      {
        m += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(k)).intValue();
        k += 1;
      }
      if (n != 0) {
        this.i = (m / n);
      }
    }
    return this.i;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public long f()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_Long > 0L)
    {
      l1 = l2;
      if (this.jdField_c_of_type_Long > 0L) {
        l1 = this.jdField_c_of_type_Long / this.jdField_a_of_type_Long;
      }
    }
    return l1;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pauseDownload();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      ThreadManager.executeOnSubThread(new mfa(this, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer));
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() != null))
    {
      ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.i = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.j = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper: destory ");
    }
  }
  
  public void i()
  {
    this.e = 0L;
    this.f = 0L;
  }
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(this);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper onError!");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(this, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(this, paramInt, paramObject);
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper onInfo, start buffering ==> isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      this.g = System.currentTimeMillis();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper onInfo, end buffering <== isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Int += 1;
        this.h += System.currentTimeMillis() - this.g;
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (paramTVK_NetVideoInfo != null)
    {
      if (QLog.isColorLevel())
      {
        paramTVK_IMediaPlayer = paramTVK_NetVideoInfo.getDefinitionList().iterator();
        while (paramTVK_IMediaPlayer.hasNext())
        {
          TVK_NetVideoInfo.DefnInfo localDefnInfo = (TVK_NetVideoInfo.DefnInfo)paramTVK_IMediaPlayer.next();
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "[TVK_IMediaPlayer] onNetVideoInfo(): " + localDefnInfo.getmDefn() + ", " + localDefnInfo.getmDefnName() + ", isVip:" + localDefnInfo.isVip());
          }
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo = paramTVK_NetVideoInfo.getCurDefinition();
        QLog.d("Q.readinjoy.video", 2, "[TVK_IMediaPlayer] onNetVideoInfo(): 当前清晰度:" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo.getmDefn() + ", " + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo$DefnInfo.getmDefnName());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = paramTVK_NetVideoInfo;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(paramTVK_NetVideoInfo);
      }
    }
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong) {}
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper: onSeekComplete， isPause=" + b());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.b(this);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if ((QLog.isColorLevel()) && (paramTVK_IMediaPlayer != null)) {
      QLog.d("Q.readinjoy.video", 2, "[TVK_IMediaPlayer] onVideoPrepared(): stremDumpInfo=" + paramTVK_IMediaPlayer.getStreamDumpInfo());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter.a(this, this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.d = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    ThreadManager.post(new mez(this, paramTVK_IMediaPlayer), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */