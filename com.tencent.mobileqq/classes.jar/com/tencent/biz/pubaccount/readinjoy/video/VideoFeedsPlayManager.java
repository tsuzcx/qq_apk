package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import bmqa;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import nxw;
import och;
import omp;
import oqj;
import org.json.JSONObject;
import rgb;
import rgc;
import ruv;
import rvr;
import rvt;
import sao;
import sap;
import sar;
import sas;
import sat;
import sbk;
import sfb;
import sfd;
import sff;
import sgc;
import sgu;
import shd;
import six;
import siy;
import siz;

public class VideoFeedsPlayManager
  implements sff
{
  private static List<VideoFeedsPlayManager> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new sao(this, Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<sat> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, sfb> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private rvr jdField_a_of_type_Rvr;
  private sap jdField_a_of_type_Sap = new sap(this, null);
  private sar jdField_a_of_type_Sar;
  private sas jdField_a_of_type_Sas;
  private sbk jdField_a_of_type_Sbk;
  private sfd jdField_a_of_type_Sfd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private sar jdField_b_of_type_Sar;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this(paramContext, paramQQAppInterface, 0);
  }
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Sfd = new sfd();
    this.jdField_a_of_type_Sfd.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    sgc.a().a(this);
    this.jdField_a_of_type_Rvr = rvr.a();
    if (rvr.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      if ((bmqa.g(paramQQAppInterface)) || (siy.a.a())) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilList.add(this);
      j();
      return;
      f(false);
    }
  }
  
  private sar a(sar paramsar)
  {
    if (paramsar == this.jdField_a_of_type_Sar) {
      return paramsar;
    }
    return null;
  }
  
  private sfb a()
  {
    return b(this.jdField_a_of_type_Sar);
  }
  
  private sfb a(sar paramsar)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    paramsar = new sfb(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramsar.jdField_a_of_type_JavaLangString);
    paramsar.a(this.jdField_a_of_type_Sap);
    return paramsar;
  }
  
  private sfb a(sfb paramsfb)
  {
    if (paramsfb == a()) {
      return paramsfb;
    }
    return null;
  }
  
  private void a(rgc paramrgc)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.8(this, paramrgc), 16, null, true);
  }
  
  private void a(sfb paramsfb)
  {
    if (paramsfb == null) {}
    do
    {
      return;
      paramsfb.n();
    } while (paramsfb.j());
    paramsfb.j();
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramsfb), 16, null, true);
  }
  
  private void a(boolean paramBoolean, sar paramsar)
  {
    Object localObject;
    if (paramsar.jdField_a_of_type_Rgc != null)
    {
      localObject = a();
      paramsar.jdField_a_of_type_Rgc.jdField_a_of_type_Long = ((sfb)localObject).a(this.jdField_c_of_type_Boolean);
      paramsar.jdField_a_of_type_Rgc.jdField_f_of_type_Int = ((sfb)localObject).e();
      paramsar.jdField_a_of_type_Rgc.jdField_n_of_type_Long = ((sfb)localObject).c();
      paramsar.jdField_a_of_type_Rgc.jdField_g_of_type_Int = ((sfb)localObject).f();
      paramsar.jdField_a_of_type_Rgc.jdField_c_of_type_Boolean = ((sfb)localObject).jdField_b_of_type_Boolean;
      paramsar.jdField_a_of_type_Rgc.jdField_q_of_type_Long = ((sfb)localObject).jdField_b_of_type_Long;
      paramsar.jdField_a_of_type_Rgc.jdField_p_of_type_Long = ((sfb)localObject).jdField_a_of_type_Long;
      paramsar.jdField_a_of_type_Rgc.r = ((sfb)localObject).g();
      if ((paramsar.jdField_a_of_type_Rgc.jdField_a_of_type_Long == 0L) && (paramsar.jdField_a_of_type_Rgc.jdField_d_of_type_Long == 0L))
      {
        paramsar.jdField_a_of_type_Rgc.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Long);
        paramsar.jdField_a_of_type_Rgc.jdField_f_of_type_Long = paramsar.jdField_a_of_type_Rgc.jdField_d_of_type_Long;
      }
      paramsar.jdField_a_of_type_Rgc.t = sgu.a().a();
      paramsar.jdField_a_of_type_Rgc.jdField_m_of_type_JavaLangString = shd.a().a();
      paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      paramsar.jdField_a_of_type_Rgc.jdField_l_of_type_Boolean = ((sfb)localObject).p();
      a(paramsar.jdField_a_of_type_Rgc);
    }
    label311:
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    int i1;
    label404:
    int i2;
    label415:
    int i3;
    if ((g()) && (paramBoolean) && (!paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label523;
      }
      paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Int = paramsar.jdField_a_of_type_Rgb.e;
      paramsar.jdField_a_of_type_Rgb.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramsar.jdField_a_of_type_Rgb;
      if (paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Int != 0) {
        break label541;
      }
      paramBoolean = true;
      ((rgb)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramsar.jdField_a_of_type_Rgb.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = paramsar.jdField_a_of_type_Rgb;
      och.a(((rgb)localObject).jdField_a_of_type_Boolean, ((rgb)localObject).jdField_d_of_type_Int, ((rgb)localObject).e, ((rgb)localObject).jdField_b_of_type_Boolean, ((rgb)localObject).jdField_c_of_type_Boolean, ((rgb)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nxw.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((rgb)localObject).jdField_d_of_type_Int;
      i6 = ((rgb)localObject).e;
      if (!((rgb)localObject).jdField_b_of_type_Boolean) {
        break label546;
      }
      i1 = 1;
      if (!((rgb)localObject).jdField_c_of_type_Boolean) {
        break label551;
      }
      i2 = 1;
      if (!oqj.a(this.jdField_a_of_type_Sar)) {
        break label557;
      }
      i3 = 20;
      label429:
      if (!((rgb)localObject).jdField_a_of_type_Boolean) {
        break label563;
      }
    }
    label523:
    label541:
    label546:
    label551:
    label557:
    label563:
    for (int i4 = 1;; i4 = 2)
    {
      JSONObject localJSONObject = nxw.a(i5, i6, i1, i2, i3, i4, 0, nxw.aI, 0);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_f_of_type_Int).b(((rgb)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oqj.a(this.jdField_a_of_type_Sar);
      return;
      paramsar.jdField_a_of_type_Rgb.jdField_d_of_type_Int = ((int)a().e());
      break;
      paramBoolean = false;
      break label311;
      i1 = 0;
      break label404;
      i2 = 0;
      break label415;
      i3 = 0;
      break label429;
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 42) || (paramInt == 105) || (paramInt == 208);
  }
  
  private boolean a(sar paramsar)
  {
    return a(paramsar) != null;
  }
  
  private boolean a(sfb paramsfb)
  {
    return a(paramsfb) != null;
  }
  
  private sfb b(sar paramsar)
  {
    if (paramsar != null) {
      return paramsar.jdField_a_of_type_Sfb;
    }
    return null;
  }
  
  private void b(sar paramsar, boolean paramBoolean)
  {
    sfb localsfb = b(paramsar);
    if (localsfb != null) {}
    for (Object localObject = localsfb.a(); (localsfb != null) && (localObject == null) && (localsfb.j()); localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramsar.jdField_a_of_type_Sfb.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      d(paramsar, paramBoolean);
      return;
    }
    StringBuilder localStringBuilder;
    if (paramsar.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("createVideoPlayerAndPlay: isSeamlessPlay， tag ");
        if (localObject == null) {
          break label149;
        }
      }
      label149:
      for (localObject = "not null";; localObject = "null")
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject);
        if (localsfb != null) {
          localsfb.b(true);
        }
        paramsar.jdField_a_of_type_AndroidViewView = null;
        c(paramsar, paramBoolean);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("createVideoPlayerAndPlay: tag ");
      if (localObject == null) {
        break label245;
      }
    }
    label245:
    for (localObject = "not null";; localObject = "null")
    {
      QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject + ", oldPlayer=" + localsfb);
      if (localsfb != null) {
        localsfb.b(true);
      }
      paramsar.jdField_a_of_type_AndroidViewView = null;
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramsar, paramBoolean), 5, null, true);
      return;
    }
  }
  
  private void c(sar paramsar, boolean paramBoolean)
  {
    paramsar.jdField_a_of_type_Sfb = a(paramsar);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((paramsar.jdField_a_of_type_Sfb != null) && (this.jdField_a_of_type_AndroidOsHandler != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      paramsar.jdField_a_of_type_Sfb.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramsar.jdField_a_of_type_Sfb);
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.3(this, paramsar, paramBoolean));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(this.jdField_a_of_type_Long), paramsar.jdField_a_of_type_Sfb);
        this.jdField_a_of_type_Long += 1L;
      }
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + paramsar.jdField_a_of_type_Sfb + ", mUIHandler = " + this.jdField_a_of_type_AndroidOsHandler);
  }
  
  private void d(sar paramsar)
  {
    rgc localrgc;
    if (paramsar != null)
    {
      paramsar.jdField_a_of_type_Rgc = new rgc();
      paramsar.jdField_a_of_type_Rgc.jdField_a_of_type_Int = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_JavaLangString = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramsar.jdField_a_of_type_Rgc.jdField_a_of_type_JavaLangString = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localrgc = paramsar.jdField_a_of_type_Rgc;
      if (this.jdField_a_of_type_Int != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 5;; i1 = 2)
    {
      localrgc.jdField_d_of_type_Int = i1;
      paramsar.jdField_a_of_type_Rgc.j = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramsar.jdField_a_of_type_Rgc.k = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramsar.jdField_a_of_type_Rgc.s = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramsar.jdField_a_of_type_Rgc.jdField_a_of_type_Boolean = true;
      paramsar.jdField_a_of_type_Rgc.o = 0;
      paramsar.jdField_a_of_type_Rgc.jdField_p_of_type_Int = 0;
      paramsar.jdField_a_of_type_Rgc.jdField_q_of_type_Int = 0;
      paramsar.jdField_a_of_type_Rgc.jdField_f_of_type_Boolean = false;
      paramsar.jdField_a_of_type_Rgc.jdField_f_of_type_JavaLangString = "";
      paramsar.jdField_a_of_type_Rgc.jdField_g_of_type_Boolean = false;
      paramsar.jdField_a_of_type_Rgc.jdField_h_of_type_Boolean = false;
      paramsar.jdField_a_of_type_Rgc.jdField_h_of_type_Int = paramsar.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramsar.jdField_a_of_type_Rgc.jdField_i_of_type_Int = paramsar.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramsar != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramsar.jdField_a_of_type_Rgb = new rgb();
        i1 = paramsar.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", nxw.R);
        paramsar.jdField_a_of_type_Rgb.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private void d(sar paramsar, boolean paramBoolean)
  {
    sfb localsfb = b(paramsar);
    if ((paramsar == null) || (localsfb == null)) {
      return;
    }
    paramsar.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: ");
    }
    if (paramsar.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      paramsar.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      localsfb.a(paramsar.jdField_a_of_type_AndroidViewViewGroup, paramsar.jdField_c_of_type_Boolean, false);
      if ((paramsar.jdField_c_of_type_Boolean) && (localsfb.a() != 0))
      {
        localsfb.g();
        paramsar.jdField_c_of_type_Boolean = false;
        paramsar.jdField_a_of_type_Ruv.b(paramsar, false);
      }
      View localView = localsfb.a();
      if (localView == null)
      {
        if (paramsar.jdField_a_of_type_Ruv != null) {
          paramsar.jdField_a_of_type_Ruv.a(paramsar, 999, 999, null);
        }
        paramsar.jdField_a_of_type_Sfb = null;
        return;
      }
      paramsar.jdField_a_of_type_AndroidViewView = localView;
      localView.setId(2131376024);
      if (paramsar.jdField_a_of_type_Ruv != null) {
        paramsar.jdField_a_of_type_Ruv.b(paramsar);
      }
      if ((paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000)) {
        localsfb.a().a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localsfb.b(i1);
      if ((!this.o) && (!this.jdField_g_of_type_Boolean)) {
        break label502;
      }
    }
    label502:
    for (boolean bool = true;; bool = false)
    {
      localsfb.d(bool);
      localsfb.a(this.jdField_h_of_type_Boolean);
      localsfb.e(paramsar.jdField_b_of_type_Boolean);
      localsfb.c(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramsar).l());
      }
      paramsar.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramsar.jdField_a_of_type_Rgc != null)
      {
        paramsar.jdField_a_of_type_Rgc.o = 0;
        paramsar.jdField_a_of_type_Rgc.jdField_p_of_type_Int = 0;
        paramsar.jdField_a_of_type_Rgc.jdField_q_of_type_Int = 0;
        paramsar.jdField_a_of_type_Rgc.jdField_g_of_type_Boolean = false;
        paramsar.jdField_a_of_type_Rgc.jdField_h_of_type_Boolean = false;
        paramsar.jdField_a_of_type_Rgc.jdField_i_of_type_Boolean = this.jdField_h_of_type_Boolean;
      }
      if (!paramsar.jdField_c_of_type_Boolean) {
        ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramsar, localsfb, paramBoolean), 16, null, true);
      }
      paramsar.jdField_c_of_type_Boolean = false;
      paramsar.jdField_a_of_type_JavaLangString = null;
      return;
      i1 = paramsar.jdField_a_of_type_Int;
      break;
    }
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb != null) && (this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void i()
  {
    Object localObject;
    if (this.jdField_a_of_type_Sar != null)
    {
      localObject = this.jdField_a_of_type_Sar;
      if ((d()) || (b())) {
        this.k = true;
      }
      d();
      ((sar)localObject).jdField_a_of_type_Sfb = null;
      ((sar)localObject).jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Sar = ((sar)localObject);
    }
    if (this.jdField_b_of_type_Sar != null)
    {
      if (b(this.jdField_b_of_type_Sar) != null) {
        b(this.jdField_b_of_type_Sar).l();
      }
      this.jdField_b_of_type_Sar.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_Sar.jdField_a_of_type_Sfb = null;
      this.jdField_b_of_type_Sar = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        sfb localsfb = (sfb)((Iterator)localObject).next();
        if ((localsfb != null) && (!localsfb.i())) {
          localsfb.l();
        }
      }
    }
  }
  
  private void j()
  {
    int i1 = Aladdin.getConfig(352).getIntegerFromString("play_manager_max_count", 3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "inspectPlayerMemory: size=" + jdField_a_of_type_JavaUtilList.size() + ", maxCount=" + i1);
    }
    if (jdField_a_of_type_JavaUtilList.size() > i1)
    {
      int i2 = jdField_a_of_type_JavaUtilList.size();
      ((VideoFeedsPlayManager)jdField_a_of_type_JavaUtilList.get(i2 - i1 - 1)).i();
    }
  }
  
  public int a()
  {
    if (a() != null) {
      return a().b();
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Sar != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Sar == null) || (this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public sar a()
  {
    return this.jdField_a_of_type_Sar;
  }
  
  public sfb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (sfb)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    if (a() != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new VideoFeedsPlayManager.4(this));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.5(this));
      if (g())
      {
        String str = this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          break label198;
        }
        this.jdField_a_of_type_JavaUtilSet.add(str);
      }
    }
    label198:
    for (this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.jdField_f_of_type_Int = rgb.jdField_a_of_type_Int;; this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.jdField_f_of_type_Int = rgb.jdField_c_of_type_Int)
    {
      if (this.jdField_a_of_type_Sar != null)
      {
        this.jdField_a_of_type_Sar.jdField_a_of_type_Rgc.jdField_m_of_type_Int = this.jdField_a_of_type_Sar.jdField_a_of_type_Sfb.d();
        this.jdField_a_of_type_Sar.jdField_a_of_type_Rgc.jdField_l_of_type_Int = this.jdField_a_of_type_Sar.jdField_a_of_type_Sfb.c();
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      a().d();
      break;
    }
  }
  
  public void a(float paramFloat)
  {
    if (a() != null) {
      a().a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Sar != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv.a(this.jdField_a_of_type_Sar, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(sar paramsar)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Sar = paramsar;
    if (this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv != null) {
      this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv.a(this.jdField_a_of_type_Sar);
    }
  }
  
  public void a(sar paramsar, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    Object localObject;
    if ((paramsar != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Sar = paramsar;
      this.jdField_b_of_type_Sar = null;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((sat)((Iterator)localObject).next()).a(this.jdField_a_of_type_Sar);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
        }
        return;
      }
    }
    if (this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv != null) {
      this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv.a(this.jdField_a_of_type_Sar, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    sfb localsfb = b(paramsar);
    int i1;
    if ((localsfb != null) && ((localsfb.d()) || (localsfb.e()) || (localsfb.g())))
    {
      i1 = 1;
      if ((localsfb != null) && (localsfb.a() != paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label361;
      }
    }
    label361:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 == 0) || (i2 == 0)) {
        break label367;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramsar.jdField_a_of_type_Boolean = false;
      paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramsar.jdField_a_of_type_Rgc.jdField_n_of_type_Int = 2;
      paramsar.jdField_a_of_type_Sfb.k();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramsar.jdField_a_of_type_Rgc.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Sap.a(paramsar);
      this.jdField_a_of_type_Sap.e(paramsar.jdField_a_of_type_Sfb);
      return;
      i1 = 0;
      break;
    }
    label367:
    if ((paramsar.jdField_a_of_type_Boolean) && (i2 != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (localsfb == null) {
          break label479;
        }
      }
      for (localObject = Integer.valueOf(localsfb.b());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (localsfb != null) {
          localsfb.k();
        }
        paramsar.jdField_a_of_type_Rgc.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        paramsar.jdField_a_of_type_Rgc.jdField_n_of_type_Int = 1;
        this.m = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    label479:
    d(this.jdField_a_of_type_Sar);
    paramsar.jdField_a_of_type_Rgc.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if ((this.jdField_a_of_type_Sfd != null) && (!this.jdField_a_of_type_Sfd.a()))
    {
      this.jdField_a_of_type_Sfd.a();
      return;
    }
    paramsar.jdField_a_of_type_Rgc.jdField_n_of_type_Int = 0;
    b(paramsar, false);
  }
  
  public void a(sas paramsas)
  {
    this.jdField_a_of_type_Sas = paramsas;
  }
  
  public void a(sat paramsat)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramsat);
  }
  
  public void a(sbk paramsbk)
  {
    this.jdField_a_of_type_Sbk = paramsbk;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public long b()
  {
    if (a() != null) {
      return a().b();
    }
    return 0L;
  }
  
  public void b()
  {
    Object localObject = a();
    if ((localObject != null) && (!((sfb)localObject).q()) && (((sfb)localObject).f())) {}
    for (int i1 = 1; (this.jdField_a_of_type_Sar != null) && (i1 != 0); i1 = 0)
    {
      a().f();
      if (this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv != null) {
        this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv.d(this.jdField_a_of_type_Sar);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sat)((Iterator)localObject).next()).d(this.jdField_a_of_type_Sar);
      }
    }
    boolean bool;
    label219:
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    label322:
    int i2;
    label332:
    int i3;
    if ((g()) && (a() != null))
    {
      if (a().e() != 0L) {
        break label440;
      }
      this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.jdField_d_of_type_Int = this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.e;
      this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb;
      if (this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.jdField_d_of_type_Int != 0) {
        break label461;
      }
      bool = true;
      ((rgb)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb;
      och.a(((rgb)localObject).jdField_a_of_type_Boolean, ((rgb)localObject).jdField_d_of_type_Int, ((rgb)localObject).e, ((rgb)localObject).jdField_b_of_type_Boolean, ((rgb)localObject).jdField_c_of_type_Boolean, ((rgb)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nxw.a(this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((rgb)localObject).jdField_d_of_type_Int;
      i6 = ((rgb)localObject).e;
      if (!((rgb)localObject).jdField_b_of_type_Boolean) {
        break label467;
      }
      i1 = 1;
      if (!((rgb)localObject).jdField_c_of_type_Boolean) {
        break label472;
      }
      i2 = 1;
      if (!oqj.a(this.jdField_a_of_type_Sar)) {
        break label477;
      }
      i3 = 20;
      label345:
      if (!((rgb)localObject).jdField_a_of_type_Boolean) {
        break label482;
      }
    }
    label440:
    label461:
    label467:
    label472:
    label477:
    label482:
    for (int i4 = 1;; i4 = 2)
    {
      JSONObject localJSONObject = nxw.a(i5, i6, i1, i2, i3, i4, 0, nxw.aI, 0);
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_f_of_type_Int).b(((rgb)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oqj.a(this.jdField_a_of_type_Sar);
      return;
      this.jdField_a_of_type_Sar.jdField_a_of_type_Rgb.jdField_d_of_type_Int = ((int)a().e());
      break;
      bool = false;
      break label219;
      i1 = 0;
      break label322;
      i2 = 0;
      break label332;
      i3 = 0;
      break label345;
    }
  }
  
  public void b(sar paramsar)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo mPreplaying=" + this.jdField_b_of_type_Sar + ", player=" + b(this.jdField_b_of_type_Sar));
    }
    if ((paramsar == null) || (paramsar == this.jdField_a_of_type_Sar)) {}
    do
    {
      sfb localsfb;
      do
      {
        return;
        localsfb = b(paramsar);
      } while ((localsfb != null) && (paramsar.jdField_a_of_type_Boolean) && (localsfb.a() == paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      if (b(this.jdField_b_of_type_Sar) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "prePlayVideo: last preplay video not stop");
        }
        b(this.jdField_b_of_type_Sar).b(true);
      }
      this.jdField_a_of_type_JavaLangString = null;
    } while ((this.jdField_a_of_type_Sfd == null) || (!this.jdField_a_of_type_Sfd.a()));
    paramsar.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Sar = paramsar;
    d(this.jdField_b_of_type_Sar);
    paramsar.jdField_a_of_type_Rgc.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    b(paramsar, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv != null)) {
      this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv.f(this.jdField_a_of_type_Sar);
    }
    if ((this.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Sbk != null) && (this.jdField_a_of_type_Sar.jdField_a_of_type_Sfb != null)) {
      this.jdField_a_of_type_Sbk.a(1, this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Sar.jdField_a_of_type_Sfb.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Sar != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Sar);
      this.jdField_a_of_type_Sar.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Sar.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Sar.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((sat)localIterator.next()).a(this.jdField_a_of_type_Sar, this.jdField_c_of_type_Boolean);
        }
      }
      c(this.jdField_a_of_type_Sar);
    }
    if (this.jdField_a_of_type_Sar != null) {
      this.jdField_a_of_type_Sar = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public boolean b()
  {
    return (a() != null) && (a().e());
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.6(this));
  }
  
  @Deprecated
  public void c(sar paramsar)
  {
    if (paramsar != null) {
      a(paramsar.jdField_a_of_type_Sfb);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Sar != null) {
        a(this.jdField_a_of_type_Sar, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv != null)) {
      this.jdField_a_of_type_Sar.jdField_a_of_type_Ruv.a(this.jdField_a_of_type_Sar, 999, 998, null);
    }
    this.jdField_a_of_type_Sar = null;
  }
  
  public boolean c()
  {
    return (a() != null) && (a().l());
  }
  
  public void d()
  {
    b(true);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((a() != null) && (this.jdField_a_of_type_Sar != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Sar.jdField_a_of_type_Int)
    {
      a().b(i1);
      return;
    }
  }
  
  public boolean d()
  {
    return (a() != null) && (a().f());
  }
  
  public void e()
  {
    boolean bool2 = true;
    this.jdField_f_of_type_Boolean = true;
    if ((this.k) && (this.jdField_a_of_type_Sar != null)) {
      a(this.jdField_a_of_type_Sar, false);
    }
    label150:
    label153:
    for (;;)
    {
      this.k = false;
      this.jdField_l_of_type_Boolean = false;
      this.n = false;
      rvt localrvt = rvt.a();
      if (!rvr.a().c())
      {
        bool1 = bool2;
        label60:
        localrvt.b(bool1);
        sgu.a().a(this.jdField_a_of_type_AndroidContentContext);
        return;
        if ((this.n) && (a() != null) && (a().d()))
        {
          a();
          continue;
        }
        if (!this.jdField_l_of_type_Boolean) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label150;
        }
      }
      for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();; bool1 = false)
      {
        if (bool1) {
          break label153;
        }
        this.m = true;
        c();
        break;
        bool1 = false;
        break label60;
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().c(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Sar) != null) {
      b(this.jdField_b_of_type_Sar).c(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return a() == 3;
  }
  
  public void f()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "doOnPause() isPlaying()=" + d());
    }
    if (d())
    {
      this.jdField_l_of_type_Boolean = true;
      this.m = false;
      b();
    }
    sgu.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rvr.b(paramBoolean);
  }
  
  public boolean f()
  {
    return a() == 7;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "doOnDestory: ");
    }
    jdField_a_of_type_JavaUtilList.remove(this);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Sar);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Sar);
    if (this.jdField_a_of_type_Sar != null)
    {
      if (a() != null)
      {
        a().l();
        this.jdField_a_of_type_Sar.jdField_a_of_type_Sfb = null;
      }
      this.jdField_a_of_type_Sar = null;
    }
    if (this.jdField_b_of_type_Sar != null)
    {
      if (b(this.jdField_b_of_type_Sar) != null)
      {
        b(this.jdField_b_of_type_Sar).l();
        this.jdField_b_of_type_Sar.jdField_a_of_type_Sfb = null;
      }
      this.jdField_b_of_type_Sar = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        sfb localsfb = (sfb)localIterator.next();
        if ((localsfb != null) && (!localsfb.i())) {
          localsfb.l();
        }
      }
    }
    if (this.jdField_a_of_type_Sfd != null)
    {
      this.jdField_a_of_type_Sfd.b();
      this.jdField_a_of_type_Sfd = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    sgc.a().b(this);
    this.jdField_a_of_type_Sas = null;
    this.jdField_a_of_type_Sbk = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Sar) != null) {
      b(this.jdField_b_of_type_Sar).d(paramBoolean);
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "checkPlayStateAfterPhoneCall mIsActivityOnResume = " + this.jdField_f_of_type_Boolean);
    }
    if (!this.jdField_f_of_type_Boolean) {}
    while ((!b()) || (!a())) {
      return;
    }
    a(false);
    c();
  }
  
  public void h(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.o = paramBoolean;
    sfb localsfb;
    if (a() != null)
    {
      localsfb = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localsfb.d(bool1);
      if (b(this.jdField_b_of_type_Sar) != null)
      {
        localsfb = b(this.jdField_b_of_type_Sar);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localsfb.d(paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */