package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import bfni;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
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
import noo;
import omu;
import owu;
import owv;
import owx;
import oxb;
import oxc;
import oxe;
import oxf;
import oxg;
import oxh;
import oxi;
import oxj;
import oxk;
import oxl;
import oxo;
import oxp;
import oxr;
import qua;

public class VideoView
  extends FrameLayout
  implements Runnable
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private long jdField_a_of_type_Long;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoView.8(this);
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private owu jdField_a_of_type_Owu;
  private owx jdField_a_of_type_Owx = new oxb(this);
  private oxk jdField_a_of_type_Oxk;
  private oxl jdField_a_of_type_Oxl;
  private oxo jdField_a_of_type_Oxo;
  public boolean a;
  public int[] a;
  private long jdField_b_of_type_Long;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private String jdField_b_of_type_JavaLangString;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean = true;
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
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    h();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    h();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    h();
  }
  
  private IVideoViewBase a()
  {
    if (bfni.d()) {
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
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bhvh.b()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bhvh.q()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bhvh.r()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(bhvh.f()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bhvh.g()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(bhvh.b()));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new VideoView.2(this, paramBoolean));
  }
  
  private boolean c()
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
        b(false);
        n();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void h()
  {
    setTag(Integer.valueOf(new Random().nextInt()));
    this.jdField_a_of_type_AndroidContentContext = getContext();
    k();
  }
  
  private void i()
  {
    if (!owv.a())
    {
      QLog.d("gifvideo.VideoView", 1, "not installed, now install");
      a(1);
      if (!owv.a(this.jdField_a_of_type_Owx)) {
        owv.a(this.jdField_a_of_type_Owx);
      }
      owv.a();
      return;
    }
    a(2);
    j();
  }
  
  private void j()
  {
    switch (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
    default: 
      return;
    }
    k();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      label72:
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
          {
            if (!owv.a()) {
              break label72;
            }
            a(3);
            if (c())
            {
              o();
              a(4);
              l();
            }
          }
          else
          {
            return;
          }
          QLog.d("gifvideo.VideoView", 1, "videoplayer is null");
          a(-1);
          continue;
          i();
        }
        finally {}
      }
    }
    a(4);
    l();
  }
  
  private void l()
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
        r();
        return;
      }
      x();
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "video player is null");
    a(-1);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    switch (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
    default: 
      return;
    }
    s();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new oxe(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new oxf(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new oxg(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new oxh(this));
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new oxi(this));
  }
  
  private void o()
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
    p();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 4)
    {
      ((KandianUrlImageView)localObject).setVisibility(i);
      return;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {}
    try
    {
      omu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(this.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {}
    try
    {
      omu.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(this.jdField_d_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void r()
  {
    b(true);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 7)
      {
        t();
        a(7);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        if (this.jdField_a_of_type_Owu != null) {
          this.jdField_a_of_type_Owu.a();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility() == 0) {
          f();
        }
      }
      return;
    }
    QLog.d("gifvideo.VideoView", 1, "video player is null");
    a(-1);
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility() == 0) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      noo.a(null, "", "0X800A587", "0X800A587", 0, 0, this.jdField_b_of_type_Long + "", "", l1 - l2 + "", "", false);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " hidecover alpha: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getAlpha());
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, "alpha", new float[] { 1.0F, 0.0F });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new oxj(this));
      }
      if (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null)
      {
        this.jdField_b_of_type_AndroidAnimationObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator.clone();
        this.jdField_b_of_type_AndroidAnimationObjectAnimator.setTarget(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
      }
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (a() != 9)
      {
        if (this.jdField_a_of_type_Owu != null) {
          this.jdField_a_of_type_Owu.b();
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        w();
        a(9);
      }
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
    a(-1);
  }
  
  private void w()
  {
    ThreadManager.getUIHandler().post(new VideoView.10(this));
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
    this.jdField_a_of_type_Owu = null;
  }
  
  private void y()
  {
    if ((this.jdField_f_of_type_Int == 2) || (this.jdField_f_of_type_Int == 6)) {
      a(oxr.a(), new oxc(this));
    }
    while (!this.jdField_e_of_type_Boolean) {
      return;
    }
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void E_()
  {
    ThreadManager.getFileThreadHandler().post(new VideoView.13(this));
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
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void a(String paramString)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, paramString, "");
    localTVK_PlayerVideoInfo.setPreLoad(false);
    localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qua.jdField_a_of_type_JavaLangString);
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
  
  public void a(oxo paramoxo, oxp paramoxp)
  {
    this.jdField_a_of_type_Oxo = paramoxo;
    if (this.jdField_a_of_type_Oxo != null) {
      this.jdField_a_of_type_Oxo.a(this.jdField_b_of_type_JavaLangString, paramoxp);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.g == jdField_b_of_type_Int)
    {
      if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
        b();
      }
      if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5)) {
        b();
      }
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
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      ThreadManager.getFileThreadHandler().post(new VideoView.12(this));
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(String paramString)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", qua.jdField_a_of_type_JavaLangString);
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setPlayType(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_kandian_feeds");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    a(localTVK_PlayerVideoInfo);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      QLog.d("gifvideo.VideoView", 2, getTag() + " opening " + a() + " " + paramString);
      a(5);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), new String[] { paramString }, 0L, 0L, localTVK_PlayerVideoInfo, null);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
  }
  
  public boolean b()
  {
    if ((a() == 7) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3)) {
      return true;
    }
    if (((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!this.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) || (getVisibility() != 0)) {
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    ThreadManager.getFileThreadHandler().post(new VideoView.11(this));
    return true;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public void c()
  {
    QLog.d("gifvideo.VideoView", 2, "pause");
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 7))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      a(8);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    QLog.d("gifvideo.VideoView", 1, "destroy");
    x();
  }
  
  public void f()
  {
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void g()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().post(new VideoView.15(this));
  }
  
  public boolean isShown()
  {
    if (this.jdField_a_of_type_Oxk != null) {
      return (super.isShown()) && (this.jdField_a_of_type_Oxk.a());
    }
    return super.isShown();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    p();
    q();
  }
  
  public void run()
  {
    long l2;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Oxl != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 500L);
      l2 = 0L;
    }
    try
    {
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_a_of_type_Oxl.a(l1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e("gifvideo.VideoView", 2, "run: " + QLog.getStackTraceString(localException));
          l1 = l2;
        }
      }
    }
  }
  
  public void setCoverUrl(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    p();
  }
  
  public void setFileSize(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(this.jdField_c_of_type_Boolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void setOnCheckShownListener(oxk paramoxk)
  {
    this.jdField_a_of_type_Oxk = paramoxk;
  }
  
  public void setOnProgressChangedListener(oxl paramoxl)
  {
    this.jdField_a_of_type_Oxl = paramoxl;
  }
  
  public void setPlayIconSize(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = Utils.dp2px(paramInt1);
      localLayoutParams.height = Utils.dp2px(paramInt2);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setPlayIconUrl(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    q();
  }
  
  public void setPlayIconVisible(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    KandianUrlImageView localKandianUrlImageView;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      localKandianUrlImageView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      if (!this.jdField_b_of_type_Boolean) {
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
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoBusiType(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setVideoPlayListener(owu paramowu)
  {
    this.jdField_a_of_type_Owu = paramowu;
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