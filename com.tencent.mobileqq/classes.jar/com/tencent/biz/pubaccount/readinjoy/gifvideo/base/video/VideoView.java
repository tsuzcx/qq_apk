package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import bhtb;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import nrt;
import orc;
import org.json.JSONException;
import org.json.JSONObject;
import pbw;
import pbx;
import pbz;
import pcd;
import pce;
import pcf;
import pcg;
import pch;
import pci;
import pcj;
import pck;
import pcl;
import pcm;
import pcn;
import pcq;
import pcr;
import pct;
import rjm;

public class VideoView
  extends FrameLayout
  implements Runnable
{
  public static int a;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public static int b;
  public static int c;
  public static int d;
  private long jdField_a_of_type_Long;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new pch(this);
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private IVideoViewBase jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoView.11(this);
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private pbw jdField_a_of_type_Pbw;
  private pbz jdField_a_of_type_Pbz = new pcd(this);
  private pcm jdField_a_of_type_Pcm;
  private pcn jdField_a_of_type_Pcn;
  private pcq jdField_a_of_type_Pcq;
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
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "";
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString = "";
  private int h;
  private int i = jdField_a_of_type_Int;
  
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
  
  private void A()
  {
    try
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      m();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
      a(0);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = null;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
      this.jdField_g_of_type_JavaLangString = "";
      this.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_Pbw = null;
      return;
    }
    finally {}
  }
  
  private void B()
  {
    try
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " stopPlay");
      this.jdField_f_of_type_JavaLangString = "";
      this.jdField_g_of_type_JavaLangString = "";
      g();
      y();
      C();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void C()
  {
    long l1;
    long l2;
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_e_of_type_JavaLangString);
      localJSONObject.put("playduration", l1 - l2);
      nrt.a(null, "", "0X8007408", "0X8007408", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("gifvideo.VideoView", 1, localJSONException.getMessage());
    }
  }
  
  private void D()
  {
    if ((this.jdField_f_of_type_Int == 2) || (this.jdField_f_of_type_Int == 6)) {
      a(pct.a(), new pcg(this));
    }
    while (!this.jdField_e_of_type_Boolean) {
      return;
    }
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  private static Drawable a()
  {
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850075);
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private IVideoViewBase a()
  {
    if (bhtb.d()) {
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
      paramTVK_PlayerVideoInfo.setConfigMap("ff_probesize", String.valueOf(bkbq.b()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_ff_probelist_switch", String.valueOf(bkbq.r()));
      paramTVK_PlayerVideoInfo.setConfigMap("is_download_async_io", String.valueOf(bkbq.s()));
      paramTVK_PlayerVideoInfo.setConfigMap("httpbuffertime_for_playpreload", String.valueOf(bkbq.f()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_switch", String.valueOf(bkbq.g()));
      paramTVK_PlayerVideoInfo.setConfigMap("dynamic_buffer_config_json", String.valueOf(bkbq.b()));
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    ThreadManager.post(new VideoView.4(this, paramRunnable), 10, null, false);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(this.jdField_d_of_type_Boolean);
      ThreadManager.getUIHandler().post(new VideoView.5(this, paramBoolean));
    }
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) || (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration() < 200L)) {}
    while ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4)) {
      return false;
    }
    return true;
  }
  
  private void h()
  {
    setTag(Integer.valueOf(new Random().nextInt()));
    this.jdField_a_of_type_AndroidContentContext = getContext();
    k();
  }
  
  private void i()
  {
    if (!pbx.a())
    {
      QLog.d("gifvideo.VideoView", 1, "not installed, now install");
      a(1);
      if (!pbx.a(this.jdField_a_of_type_Pbz)) {
        pbx.a(this.jdField_a_of_type_Pbz);
      }
      pbx.a();
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
      try
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
        {
          if (!pbx.a()) {
            break label46;
          }
          a(3);
          a(new VideoView.2(this));
          l();
        }
        for (;;)
        {
          return;
          label46:
          i();
        }
        a(4);
      }
      finally {}
    }
    n();
  }
  
  private void l()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
      localViewTreeObserver.addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  private void m()
  {
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  private void n()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
          break label70;
        }
        int j = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        switch (j)
        {
        case 4: 
        case 5: 
        default: 
          return;
        }
      }
      finally {}
      t();
      continue;
      A();
      continue;
      label70:
      QLog.d("gifvideo.VideoView", 1, "video player is null");
      a(-1);
    }
  }
  
  /* Error */
  private void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 142	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 79	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   13: invokevirtual 323	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   16: istore_1
    //   17: iload_1
    //   18: tableswitch	default:+18 -> 36, 3:+21->39
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: invokespecial 518	com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView:u	()V
    //   43: goto -7 -> 36
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	VideoView
    //   16	2	1	j	int
    //   46	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	46	finally
    //   39	43	46	finally
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new pci(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new pcj(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new pck(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(new pcl(this));
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new pce(this));
  }
  
  private void q()
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
    r();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    if (this.jdField_g_of_type_Int != 0) {
      ((FrameLayout.LayoutParams)localObject).width = this.jdField_g_of_type_Int;
    }
    if (this.h != 0) {
      ((FrameLayout.LayoutParams)localObject).height = this.h;
    }
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int j = 0;; j = 4)
    {
      ((KandianUrlImageView)localObject).setVisibility(j);
      return;
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {}
    try
    {
      orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(this.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void s()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {}
    try
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(a()).a(new URL(this.jdField_d_of_type_JavaLangString));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void t()
  {
    b(true);
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 7)
      {
        v();
        a(7);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        if (this.jdField_a_of_type_Pbw != null) {
          this.jdField_a_of_type_Pbw.a();
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
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility() == 0) && (!this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_JavaLangString)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      nrt.a(null, "", "0X800A587", "0X800A587", 0, 0, this.jdField_b_of_type_Long + "", "", l1 - l2 + "", "", false);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      QLog.d("gifvideo.VideoView", 1, getTag() + " hidecover alpha: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getAlpha());
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, "alpha", new float[] { 1.0F, 0.0F });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(300L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new pcf(this));
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
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      }
      a(8);
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
    a(-1);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (a() != 9)
      {
        if (this.jdField_a_of_type_Pbw != null) {
          this.jdField_a_of_type_Pbw.b();
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        z();
        a(9);
      }
      return;
    }
    QLog.d("gifvideo.VideoView", 2, "video player is null");
    a(-1);
  }
  
  private void z()
  {
    ThreadManager.getUIHandler().post(new VideoView.13(this));
  }
  
  public void E_()
  {
    ThreadManager.post(new VideoView.16(this), 10, null, false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getPlayedTime();
    }
    return 0L;
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
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", rjm.jdField_a_of_type_JavaLangString);
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
  
  public void a(pcq parampcq, pcr parampcr)
  {
    this.jdField_a_of_type_Pcq = parampcq;
    if (this.jdField_a_of_type_Pcq != null) {
      this.jdField_a_of_type_Pcq.a(this.jdField_b_of_type_JavaLangString, parampcr);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.i == jdField_b_of_type_Int)
    {
      if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 3)) {
        c();
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
    QLog.d("gifvideo.VideoView", 2, "receive stop");
    if (!d()) {
      QLog.d("gifvideo.VideoView", 2, "has not inited, return");
    }
    while (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    ThreadManager.post(new VideoView.15(this), 10, null, false);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void b(String paramString)
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setPlayMode("cache_video");
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", rjm.jdField_a_of_type_JavaLangString);
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
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.i;
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
  
  public boolean c()
  {
    QLog.d("gifvideo.VideoView", 2, "receive startPlay");
    if (!d())
    {
      QLog.d("gifvideo.VideoView", 2, "has not inited, return false");
      return false;
    }
    if ((a() == 7) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3))
    {
      QLog.d("gifvideo.VideoView", 2, "isPlaying or has started " + a() + " " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      return true;
    }
    if (((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) || (getVisibility() != 0))
    {
      QLog.d("gifvideo.VideoView", 2, "preparedUrl != mVideoUrl, " + this.jdField_f_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString + " " + getVisibility());
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    ThreadManager.post(new VideoView.14(this), 10, null, false);
    return true;
  }
  
  public boolean d()
  {
    return a() >= 4;
  }
  
  public void e()
  {
    QLog.d("gifvideo.VideoView", 1, "destroy");
    A();
  }
  
  public void f()
  {
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void g()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().post(new VideoView.18(this));
  }
  
  public boolean isShown()
  {
    if (this.jdField_a_of_type_Pcm != null) {
      return (super.isShown()) && (this.jdField_a_of_type_Pcm.a());
    }
    return super.isShown();
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    r();
    s();
  }
  
  public void run()
  {
    long l2;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_Pcn != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 500L);
      l2 = 0L;
    }
    try
    {
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_a_of_type_Pcn.a(l1);
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
    r();
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
  
  public void setOnCheckShownListener(pcm parampcm)
  {
    this.jdField_a_of_type_Pcm = parampcm;
  }
  
  public void setOnProgressChangedListener(pcn parampcn)
  {
    this.jdField_a_of_type_Pcn = parampcn;
  }
  
  public void setPlayIconSize(int paramInt1, int paramInt2)
  {
    this.jdField_g_of_type_Int = Utils.dp2px(paramInt1);
    this.h = Utils.dp2px(paramInt2);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = this.jdField_g_of_type_Int;
      localLayoutParams.height = this.h;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setPlayIconUrl(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    s();
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
    for (int j = 0;; j = 4)
    {
      localKandianUrlImageView.setVisibility(j);
      return;
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setReportR5(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void setScaleType(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_e_of_type_Int = 0;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(this.jdField_e_of_type_Int);
        }
        return;
      }
      finally {}
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
  
  public void setVideoPlayListener(pbw parampbw)
  {
    this.jdField_a_of_type_Pbw = parampbw;
  }
  
  public void setVideoUrl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setVideoVid(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.equals(this.jdField_b_of_type_JavaLangString)) {
        b();
      }
      this.jdField_b_of_type_JavaLangString = paramString;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView
 * JD-Core Version:    0.7.0.1
 */