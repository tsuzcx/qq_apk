package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import befo;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import ndn;
import obj;
import oli;
import olj;
import oll;
import olp;
import olq;
import ols;
import olt;
import olu;
import olv;
import olw;
import olx;
import oma;
import omb;
import omd;
import qhv;

public class VideoView
  extends FrameLayout
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoView.8(this);
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private oli jdField_a_of_type_Oli;
  private oll jdField_a_of_type_Oll = new olp(this);
  private oma jdField_a_of_type_Oma;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private String jdField_b_of_type_JavaLangString;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "";
  private int g = jdField_a_of_type_Int;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
  }
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
    i();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    i();
  }
  
  private IVideoViewBase a()
  {
    if (befo.d()) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt)
  {
    QLog.d("gifvideo.VideoView", 2, getTag() + " change state from " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " to " + paramInt);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  private void a(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (paramTVK_PlayerVideoInfo != null)
    {
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bgmq.c()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bgmq.r()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bgmq.s()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(bgmq.f()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bgmq.g()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(bgmq.b()));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new VideoView.2(this, paramBoolean));
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = a();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
        a(false);
        o();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void i()
  {
    setTag(Integer.valueOf(new Random().nextInt()));
    this.jdField_a_of_type_AndroidContentContext = getContext();
    l();
  }
  
  private void j()
  {
    if (!olj.a())
    {
      QLog.d("gifvideo.VideoView", 1, "not installed, now install");
      a(1);
      if (!olj.a(this.jdField_a_of_type_Oll)) {
        olj.a(this.jdField_a_of_type_Oll);
      }
      olj.a();
      return;
    }
    a(2);
    k();
  }
  
  private void k()
  {
    switch (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
    default: 
      return;
    }
    l();
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      label72:
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
          {
            if (!olj.a()) {
              break label72;
            }
            a(3);
            if (b())
            {
              p();
              a(4);
              m();
            }
          }
          else
          {
            return;
          }
          QLog.d("gifvideo.VideoView", 1, "videoplayer is null");
          a(-1);
          continue;
          j();
        }
        finally {}
      }
    }
    a(4);
    m();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      switch (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 3: 
        s();
        return;
      }
      x();
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "video player is null");
    a(-1);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    switch (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
    default: 
      return;
    }
    t();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new ols(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new olt(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new olu(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new olv(this));
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new olw(this));
  }
  
  private void p()
  {
    removeAllViews();
    setBackgroundColor(Color.parseColor("#000000"));
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setBackgroundColor(Color.parseColor("#000000"));
      addView((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase, -1, -1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, -1, -1);
    q();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localLayoutParams);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(4);
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {}
    try
    {
      obj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(this.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void r()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {}
    try
    {
      obj.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(this.jdField_d_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void s()
  {
    a(true);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 7)
      {
        u();
        a(7);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        if (this.jdField_a_of_type_Oli != null) {
          this.jdField_a_of_type_Oli.a();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility() == 0) {
          g();
        }
      }
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "video player is null");
    a(-1);
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility() == 0) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      ndn.a(null, "", "0X800A587", "0X800A587", 0, 0, this.jdField_b_of_type_Long + "", "", l1 - l2 + "", "", false);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " hidecover alpha: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getAlpha());
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.addListener(new olx(this));
      localObjectAnimator.start();
      localObjectAnimator = localObjectAnimator.clone();
      localObjectAnimator.setTarget(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
      localObjectAnimator.start();
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (a() != 9)
      {
        if (this.jdField_a_of_type_Oli != null) {
          this.jdField_a_of_type_Oli.b();
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      a(9);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
    a(-1);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    a(0);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Oli = null;
  }
  
  private void y()
  {
    if ((this.jdField_f_of_type_Int == 2) || (this.jdField_f_of_type_Int == 6)) {
      a(omd.a(), new olq(this));
    }
    while (!this.jdField_d_of_type_Boolean) {
      return;
    }
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void F_()
  {
    ThreadManager.getFileThreadHandler().post(new VideoView.11(this));
  }
  
  public void G_()
  {
    QLog.d("gifvideo.VideoView", 2, "pause");
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 7))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      a(8);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    ThreadManager.getFileThreadHandler().post(new VideoView.10(this));
  }
  
  public void a(String paramString)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, paramString, "");
    localTVK_PlayerVideoInfo.setPreLoad(false);
    localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qhv.jdField_a_of_type_JavaLangString);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      QLog.d("gifvideo.VideoView", 2, getTag() + " opening " + paramString);
      a(5);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null, localTVK_PlayerVideoInfo, paramString, 0L, 0L);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
  }
  
  public void a(oma paramoma, omb paramomb)
  {
    this.jdField_a_of_type_Oma = paramoma;
    if (this.jdField_a_of_type_Oma != null) {
      this.jdField_a_of_type_Oma.a(this.jdField_b_of_type_JavaLangString, paramomb);
    }
  }
  
  public boolean a()
  {
    return a() == 7;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void b(String paramString)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qhv.jdField_a_of_type_JavaLangString);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setPlayType(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    a(localTVK_PlayerVideoInfo);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      QLog.d("gifvideo.VideoView", 2, getTag() + " opening " + paramString);
      a(5);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), new String[] { paramString }, 0L, 0L, localTVK_PlayerVideoInfo, null);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
  }
  
  public void e()
  {
    ThreadManager.getFileThreadHandler().post(new VideoView.12(this));
  }
  
  public void f()
  {
    QLog.d("gifvideo.VideoView", 1, "destroy");
    x();
  }
  
  public void g()
  {
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void h()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().post(new VideoView.14(this));
  }
  
  public void setCoverUrl(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    q();
  }
  
  public void setFileSize(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(this.jdField_b_of_type_Boolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void setPlayIconSize(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setPlayIconUrl(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    r();
  }
  
  public void setPlayIconVisible(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    KandianUrlImageView localKandianUrlImageView;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      localKandianUrlImageView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 4)
    {
      localKandianUrlImageView.setVisibility(i);
      return;
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setScaleType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_e_of_type_Int = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(this.jdField_e_of_type_Int);
      }
      return;
      this.jdField_e_of_type_Int = 1;
      continue;
      this.jdField_e_of_type_Int = 2;
    }
  }
  
  public void setUseVid(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoBusiType(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setVideoPlayListener(oli paramoli)
  {
    this.jdField_a_of_type_Oli = paramoli;
  }
  
  public void setVideoUrl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setVideoVid(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView
 * JD-Core Version:    0.7.0.1
 */