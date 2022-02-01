package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import bkwm;
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
import obb;
import ofe;
import org.json.JSONObject;
import rds;
import rdt;
import rsr;
import rtp;
import rtr;
import ryl;
import rym;
import ryo;
import ryp;
import ryq;
import rzk;
import sdj;
import sdl;
import sdn;
import seo;
import sep;
import sfc;
import sfl;
import shf;
import shg;
import shh;
import trn;
import twr;

public class VideoFeedsPlayManager
  implements sdn, sep
{
  private static List<VideoFeedsPlayManager> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new ryl(this, Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ryq> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, sdj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private rtp jdField_a_of_type_Rtp;
  private rym jdField_a_of_type_Rym = new rym(this, null);
  private ryo jdField_a_of_type_Ryo;
  private ryp jdField_a_of_type_Ryp;
  private rzk jdField_a_of_type_Rzk;
  private sdl jdField_a_of_type_Sdl;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ryo jdField_b_of_type_Ryo;
  private volatile boolean jdField_b_of_type_Boolean;
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
    this.jdField_a_of_type_Sdl = new sdl();
    this.jdField_a_of_type_Sdl.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    seo.a().a(this);
    this.jdField_a_of_type_Rtp = rtp.a();
    if (rtp.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      if ((bkwm.g(paramQQAppInterface)) || (shg.a.a())) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilList.add(this);
      j();
      return;
      f(false);
    }
  }
  
  private ryo a(ryo paramryo)
  {
    if (paramryo == this.jdField_a_of_type_Ryo) {
      return paramryo;
    }
    return null;
  }
  
  private sdj a()
  {
    return b(this.jdField_a_of_type_Ryo);
  }
  
  private sdj a(ryo paramryo)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_b_of_type_Boolean)) {
      return null;
    }
    paramryo = new sdj(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramryo.jdField_a_of_type_JavaLangString);
    paramryo.a(this.jdField_a_of_type_Rym);
    return paramryo;
  }
  
  private sdj a(sdj paramsdj)
  {
    if (paramsdj == a()) {
      return paramsdj;
    }
    return null;
  }
  
  private void a(rdt paramrdt)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.8(this, paramrdt), 16, null, true);
  }
  
  private void a(sdj paramsdj)
  {
    if (paramsdj == null) {}
    do
    {
      return;
      paramsdj.n();
    } while (paramsdj.j());
    paramsdj.j();
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramsdj), 16, null, true);
  }
  
  private void a(boolean paramBoolean, ryo paramryo)
  {
    Object localObject;
    if (paramryo.jdField_a_of_type_Rdt != null)
    {
      localObject = a();
      paramryo.jdField_a_of_type_Rdt.jdField_a_of_type_Long = ((sdj)localObject).a(this.jdField_c_of_type_Boolean);
      paramryo.jdField_a_of_type_Rdt.jdField_f_of_type_Int = ((sdj)localObject).e();
      paramryo.jdField_a_of_type_Rdt.jdField_n_of_type_Long = ((sdj)localObject).c();
      paramryo.jdField_a_of_type_Rdt.jdField_g_of_type_Int = ((sdj)localObject).f();
      paramryo.jdField_a_of_type_Rdt.jdField_c_of_type_Boolean = ((sdj)localObject).jdField_b_of_type_Boolean;
      paramryo.jdField_a_of_type_Rdt.jdField_q_of_type_Long = ((sdj)localObject).jdField_b_of_type_Long;
      paramryo.jdField_a_of_type_Rdt.jdField_p_of_type_Long = ((sdj)localObject).jdField_a_of_type_Long;
      paramryo.jdField_a_of_type_Rdt.r = ((sdj)localObject).g();
      if ((paramryo.jdField_a_of_type_Rdt.jdField_a_of_type_Long == 0L) && (paramryo.jdField_a_of_type_Rdt.jdField_d_of_type_Long == 0L))
      {
        paramryo.jdField_a_of_type_Rdt.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Long);
        paramryo.jdField_a_of_type_Rdt.jdField_f_of_type_Long = paramryo.jdField_a_of_type_Rdt.jdField_d_of_type_Long;
      }
      paramryo.jdField_a_of_type_Rdt.t = sfc.a().a();
      paramryo.jdField_a_of_type_Rdt.jdField_m_of_type_JavaLangString = sfl.a().a();
      paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      paramryo.jdField_a_of_type_Rdt.jdField_l_of_type_Boolean = ((sdj)localObject).p();
      a(paramryo.jdField_a_of_type_Rdt);
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
    if ((h()) && (paramBoolean) && (!paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label523;
      }
      paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Int = paramryo.jdField_a_of_type_Rds.e;
      paramryo.jdField_a_of_type_Rds.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramryo.jdField_a_of_type_Rds;
      if (paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Int != 0) {
        break label541;
      }
      paramBoolean = true;
      ((rds)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramryo.jdField_a_of_type_Rds.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = paramryo.jdField_a_of_type_Rds;
      ofe.a(((rds)localObject).jdField_a_of_type_Boolean, ((rds)localObject).jdField_d_of_type_Int, ((rds)localObject).e, ((rds)localObject).jdField_b_of_type_Boolean, ((rds)localObject).jdField_c_of_type_Boolean, ((rds)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = obb.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((rds)localObject).jdField_d_of_type_Int;
      i6 = ((rds)localObject).e;
      if (!((rds)localObject).jdField_b_of_type_Boolean) {
        break label546;
      }
      i1 = 1;
      if (!((rds)localObject).jdField_c_of_type_Boolean) {
        break label551;
      }
      i2 = 1;
      if (!twr.a(this.jdField_a_of_type_Ryo)) {
        break label557;
      }
      i3 = 20;
      label429:
      if (!((rds)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = obb.a(i5, i6, i1, i2, i3, i4, 0, obb.aP, 0);
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_f_of_type_Int).b(((rds)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      twr.a(this.jdField_a_of_type_Ryo);
      return;
      paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Int = ((int)a().e());
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
    return (paramInt == 105) || (paramInt == 208);
  }
  
  private boolean a(ryo paramryo)
  {
    return a(paramryo) != null;
  }
  
  private boolean a(sdj paramsdj)
  {
    return a(paramsdj) != null;
  }
  
  private sdj b(ryo paramryo)
  {
    if (paramryo != null) {
      return paramryo.jdField_a_of_type_Sdj;
    }
    return null;
  }
  
  private void b(ryo paramryo, boolean paramBoolean)
  {
    sdj localsdj = b(paramryo);
    if (localsdj != null) {}
    for (Object localObject = localsdj.a(); (localsdj != null) && (localObject == null) && (localsdj.j()); localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramryo.jdField_a_of_type_Sdj.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      d(paramryo, paramBoolean);
      return;
    }
    StringBuilder localStringBuilder;
    if (paramryo.jdField_c_of_type_Boolean)
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
        if (localsdj != null) {
          localsdj.b(true);
        }
        paramryo.jdField_a_of_type_AndroidViewView = null;
        c(paramryo, paramBoolean);
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
      QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject + ", oldPlayer=" + localsdj);
      if (localsdj != null) {
        localsdj.b(true);
      }
      paramryo.jdField_a_of_type_AndroidViewView = null;
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramryo, paramBoolean), 5, null, true);
      return;
    }
  }
  
  private void c(ryo paramryo, boolean paramBoolean)
  {
    paramryo.jdField_a_of_type_Sdj = a(paramryo);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((paramryo.jdField_a_of_type_Sdj != null) && (this.jdField_a_of_type_AndroidOsHandler != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      paramryo.jdField_a_of_type_Sdj.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramryo.jdField_a_of_type_Sdj);
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.3(this, paramryo, paramBoolean));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(this.jdField_a_of_type_Long), paramryo.jdField_a_of_type_Sdj);
        this.jdField_a_of_type_Long += 1L;
      }
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + paramryo.jdField_a_of_type_Sdj + ", mUIHandler = " + this.jdField_a_of_type_AndroidOsHandler);
  }
  
  private void d(ryo paramryo)
  {
    rdt localrdt;
    if (paramryo != null)
    {
      paramryo.jdField_a_of_type_Rdt = new rdt();
      paramryo.jdField_a_of_type_Rdt.jdField_a_of_type_Int = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_JavaLangString = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramryo.jdField_a_of_type_Rdt.jdField_a_of_type_JavaLangString = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localrdt = paramryo.jdField_a_of_type_Rdt;
      if (this.jdField_a_of_type_Int != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 5;; i1 = 2)
    {
      localrdt.jdField_d_of_type_Int = i1;
      paramryo.jdField_a_of_type_Rdt.j = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramryo.jdField_a_of_type_Rdt.k = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramryo.jdField_a_of_type_Rdt.s = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramryo.jdField_a_of_type_Rdt.jdField_a_of_type_Boolean = true;
      paramryo.jdField_a_of_type_Rdt.o = 0;
      paramryo.jdField_a_of_type_Rdt.jdField_p_of_type_Int = 0;
      paramryo.jdField_a_of_type_Rdt.jdField_q_of_type_Int = 0;
      paramryo.jdField_a_of_type_Rdt.jdField_f_of_type_Boolean = false;
      paramryo.jdField_a_of_type_Rdt.jdField_f_of_type_JavaLangString = "";
      paramryo.jdField_a_of_type_Rdt.jdField_g_of_type_Boolean = false;
      paramryo.jdField_a_of_type_Rdt.jdField_h_of_type_Boolean = false;
      paramryo.jdField_a_of_type_Rdt.jdField_h_of_type_Int = paramryo.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramryo.jdField_a_of_type_Rdt.jdField_i_of_type_Int = paramryo.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramryo != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramryo.jdField_a_of_type_Rds = new rds();
        i1 = paramryo.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", obb.R);
        paramryo.jdField_a_of_type_Rds.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private void d(ryo paramryo, boolean paramBoolean)
  {
    sdj localsdj = b(paramryo);
    if ((paramryo == null) || (localsdj == null)) {
      return;
    }
    paramryo.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: ");
    }
    if (paramryo.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      paramryo.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      localsdj.a(paramryo.jdField_a_of_type_AndroidViewViewGroup, paramryo.jdField_c_of_type_Boolean, false);
      if ((paramryo.jdField_c_of_type_Boolean) && (localsdj.a() != 0))
      {
        localsdj.g();
        paramryo.jdField_c_of_type_Boolean = false;
        paramryo.jdField_a_of_type_Rsr.b(paramryo, false);
      }
      View localView = localsdj.a();
      if (localView == null)
      {
        if (paramryo.jdField_a_of_type_Rsr != null) {
          paramryo.jdField_a_of_type_Rsr.a(paramryo, 999, 999, null);
        }
        paramryo.jdField_a_of_type_Sdj = null;
        return;
      }
      paramryo.jdField_a_of_type_AndroidViewView = localView;
      localView.setId(2131375928);
      if (paramryo.jdField_a_of_type_Rsr != null) {
        paramryo.jdField_a_of_type_Rsr.b(paramryo);
      }
      if ((paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000)) {
        localsdj.a().a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localsdj.b(i1);
      if ((!this.o) && (!this.jdField_g_of_type_Boolean)) {
        break label502;
      }
    }
    label502:
    for (boolean bool = true;; bool = false)
    {
      localsdj.d(bool);
      localsdj.a(this.jdField_h_of_type_Boolean);
      localsdj.e(paramryo.jdField_b_of_type_Boolean);
      localsdj.c(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramryo).l());
      }
      paramryo.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramryo.jdField_a_of_type_Rdt != null)
      {
        paramryo.jdField_a_of_type_Rdt.o = 0;
        paramryo.jdField_a_of_type_Rdt.jdField_p_of_type_Int = 0;
        paramryo.jdField_a_of_type_Rdt.jdField_q_of_type_Int = 0;
        paramryo.jdField_a_of_type_Rdt.jdField_g_of_type_Boolean = false;
        paramryo.jdField_a_of_type_Rdt.jdField_h_of_type_Boolean = false;
        paramryo.jdField_a_of_type_Rdt.jdField_i_of_type_Boolean = this.jdField_h_of_type_Boolean;
      }
      if (!paramryo.jdField_c_of_type_Boolean) {
        ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramryo, localsdj, paramBoolean), 16, null, true);
      }
      paramryo.jdField_c_of_type_Boolean = false;
      paramryo.jdField_a_of_type_JavaLangString = null;
      return;
      i1 = paramryo.jdField_a_of_type_Int;
      break;
    }
  }
  
  private boolean h()
  {
    return (this.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds != null) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void i()
  {
    Object localObject;
    if (this.jdField_a_of_type_Ryo != null)
    {
      localObject = this.jdField_a_of_type_Ryo;
      if ((d()) || (b())) {
        this.k = true;
      }
      d();
      ((ryo)localObject).jdField_a_of_type_Sdj = null;
      ((ryo)localObject).jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Ryo = ((ryo)localObject);
    }
    if (this.jdField_b_of_type_Ryo != null)
    {
      if (b(this.jdField_b_of_type_Ryo) != null) {
        b(this.jdField_b_of_type_Ryo).l();
      }
      this.jdField_b_of_type_Ryo.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_Ryo.jdField_a_of_type_Sdj = null;
      this.jdField_b_of_type_Ryo = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        sdj localsdj = (sdj)((Iterator)localObject).next();
        if ((localsdj != null) && (!localsdj.i())) {
          localsdj.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
    if ((this.jdField_a_of_type_Ryo != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Ryo == null) || (this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public ryo a()
  {
    return this.jdField_a_of_type_Ryo;
  }
  
  public sdj a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (sdj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    Object localObject;
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
      if (h())
      {
        localObject = this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (this.jdField_a_of_type_JavaUtilSet.contains(localObject)) {
          break label195;
        }
        this.jdField_a_of_type_JavaUtilSet.add(localObject);
      }
    }
    label195:
    for (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.jdField_f_of_type_Int = rds.jdField_a_of_type_Int;; this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.jdField_f_of_type_Int = rds.jdField_c_of_type_Int)
    {
      localObject = a();
      if ((this.jdField_a_of_type_Ryo != null) && (localObject != null))
      {
        this.jdField_a_of_type_Ryo.jdField_a_of_type_Rdt.jdField_m_of_type_Int = ((sdj)localObject).d();
        this.jdField_a_of_type_Ryo.jdField_a_of_type_Rdt.jdField_l_of_type_Int = ((sdj)localObject).c();
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
    if ((this.jdField_a_of_type_Ryo != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr.a(this.jdField_a_of_type_Ryo, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(ryo paramryo)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Ryo = paramryo;
    if (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr != null) {
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr.a(this.jdField_a_of_type_Ryo);
    }
  }
  
  public void a(ryo paramryo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    if (this.jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo: mHasDestory=" + this.jdField_b_of_type_Boolean);
      }
    }
    do
    {
      return;
      if ((paramryo != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    this.j = false;
    this.jdField_a_of_type_Ryo = paramryo;
    this.jdField_b_of_type_Ryo = null;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ryq)((Iterator)localObject).next()).e(this.jdField_a_of_type_Ryo);
      }
    }
    if (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr != null) {
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr.a(this.jdField_a_of_type_Ryo, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    sdj localsdj = b(paramryo);
    int i1;
    if ((localsdj != null) && ((localsdj.d()) || (localsdj.e()) || (localsdj.g())))
    {
      i1 = 1;
      if ((localsdj != null) && (localsdj.a() != paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label405;
      }
    }
    label405:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 == 0) || (i2 == 0)) {
        break label411;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramryo.jdField_a_of_type_Boolean = false;
      paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramryo.jdField_a_of_type_Rdt.jdField_n_of_type_Int = 2;
      paramryo.jdField_a_of_type_Sdj.k();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramryo.jdField_a_of_type_Rdt.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Rym.a(paramryo);
      this.jdField_a_of_type_Rym.d(paramryo.jdField_a_of_type_Sdj);
      return;
      i1 = 0;
      break;
    }
    label411:
    if ((paramryo.jdField_a_of_type_Boolean) && (i2 != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (localsdj == null) {
          break label523;
        }
      }
      for (localObject = Integer.valueOf(localsdj.b());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (localsdj != null) {
          localsdj.k();
        }
        paramryo.jdField_a_of_type_Rdt.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        paramryo.jdField_a_of_type_Rdt.jdField_n_of_type_Int = 1;
        this.m = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    label523:
    d(this.jdField_a_of_type_Ryo);
    paramryo.jdField_a_of_type_Rdt.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if ((this.jdField_a_of_type_Sdl != null) && (!this.jdField_a_of_type_Sdl.a()))
    {
      this.jdField_a_of_type_Sdl.a();
      return;
    }
    paramryo.jdField_a_of_type_Rdt.jdField_n_of_type_Int = 0;
    b(paramryo, false);
  }
  
  public void a(ryp paramryp)
  {
    this.jdField_a_of_type_Ryp = paramryp;
  }
  
  public void a(ryq paramryq)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramryq);
  }
  
  public void a(rzk paramrzk)
  {
    this.jdField_a_of_type_Rzk = paramrzk;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Ryo != null) {
        a(this.jdField_a_of_type_Ryo, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr != null)) {
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr.a(this.jdField_a_of_type_Ryo, 999, 998, null);
    }
    this.jdField_a_of_type_Ryo = null;
  }
  
  public boolean a()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public long b()
  {
    if ((this.jdField_a_of_type_Ryo != null) && (a() != null)) {
      return a().a(g());
    }
    return 0L;
  }
  
  public void b()
  {
    Object localObject = a();
    if ((localObject != null) && (!((sdj)localObject).q()) && (((sdj)localObject).f())) {}
    for (int i1 = 1; (this.jdField_a_of_type_Ryo != null) && (i1 != 0); i1 = 0)
    {
      a().f();
      if (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr != null) {
        this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr.d(this.jdField_a_of_type_Ryo);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ryq)((Iterator)localObject).next()).c(this.jdField_a_of_type_Ryo);
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
    if ((h()) && (a() != null))
    {
      if (a().e() != 0L) {
        break label440;
      }
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.jdField_d_of_type_Int = this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.e;
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds;
      if (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.jdField_d_of_type_Int != 0) {
        break label461;
      }
      bool = true;
      ((rds)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds;
      ofe.a(((rds)localObject).jdField_a_of_type_Boolean, ((rds)localObject).jdField_d_of_type_Int, ((rds)localObject).e, ((rds)localObject).jdField_b_of_type_Boolean, ((rds)localObject).jdField_c_of_type_Boolean, ((rds)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = obb.a(this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((rds)localObject).jdField_d_of_type_Int;
      i6 = ((rds)localObject).e;
      if (!((rds)localObject).jdField_b_of_type_Boolean) {
        break label467;
      }
      i1 = 1;
      if (!((rds)localObject).jdField_c_of_type_Boolean) {
        break label472;
      }
      i2 = 1;
      if (!twr.a(this.jdField_a_of_type_Ryo)) {
        break label477;
      }
      i3 = 20;
      label345:
      if (!((rds)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = obb.a(i5, i6, i1, i2, i3, i4, 0, obb.aP, 0);
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.jdField_f_of_type_Int).b(((rds)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      twr.a(this.jdField_a_of_type_Ryo);
      return;
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rds.jdField_d_of_type_Int = ((int)a().e());
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
  
  public void b(ryo paramryo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo mPreplaying=" + this.jdField_b_of_type_Ryo + ", player=" + b(this.jdField_b_of_type_Ryo));
    }
    if ((paramryo == null) || (paramryo == this.jdField_a_of_type_Ryo)) {}
    do
    {
      sdj localsdj;
      do
      {
        return;
        localsdj = b(paramryo);
      } while ((localsdj != null) && (paramryo.jdField_a_of_type_Boolean) && (localsdj.a() == paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      if (b(this.jdField_b_of_type_Ryo) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "prePlayVideo: last preplay video not stop");
        }
        b(this.jdField_b_of_type_Ryo).b(true);
      }
      this.jdField_a_of_type_JavaLangString = null;
    } while ((this.jdField_a_of_type_Sdl == null) || (!this.jdField_a_of_type_Sdl.a()));
    paramryo.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Ryo = paramryo;
    d(this.jdField_b_of_type_Ryo);
    paramryo.jdField_a_of_type_Rdt.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    b(paramryo, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return (a() != null) && (a().e());
  }
  
  public long c()
  {
    if (a() != null) {
      return a().b();
    }
    return 0L;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.6(this));
  }
  
  @Deprecated
  public void c(ryo paramryo)
  {
    if (paramryo != null) {
      a(paramryo.jdField_a_of_type_Sdj);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr != null)) {
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Rsr.f(this.jdField_a_of_type_Ryo);
    }
    if ((this.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Rzk != null) && (this.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj != null)) {
      this.jdField_a_of_type_Rzk.a(1, this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Ryo != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Ryo);
      this.jdField_a_of_type_Ryo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Ryo.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Ryo.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((ryq)localIterator.next()).a(this.jdField_a_of_type_Ryo, this.jdField_c_of_type_Boolean);
        }
      }
      c(this.jdField_a_of_type_Ryo);
    }
    if (this.jdField_a_of_type_Ryo != null) {
      this.jdField_a_of_type_Ryo = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public boolean c()
  {
    return (a() != null) && (a().l());
  }
  
  public void d()
  {
    c(true);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((a() != null) && (this.jdField_a_of_type_Ryo != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Ryo.jdField_a_of_type_Int)
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
    if ((this.k) && (this.jdField_a_of_type_Ryo != null)) {
      a(this.jdField_a_of_type_Ryo, false);
    }
    label150:
    label153:
    for (;;)
    {
      this.k = false;
      this.jdField_l_of_type_Boolean = false;
      this.n = false;
      rtr localrtr = rtr.a();
      if (!rtp.a().c())
      {
        bool1 = bool2;
        label60:
        localrtr.b(bool1);
        sfc.a().a(this.jdField_a_of_type_AndroidContentContext);
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
      for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting();; bool1 = false)
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
    if (b(this.jdField_b_of_type_Ryo) != null) {
      b(this.jdField_b_of_type_Ryo).c(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return a() == 5;
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
    sfc.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rtp.b(paramBoolean);
  }
  
  public boolean f()
  {
    return a() == 3;
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Ryo);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Ryo);
    if (this.jdField_a_of_type_Ryo != null)
    {
      if (a() != null)
      {
        a().l();
        this.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj = null;
      }
      this.jdField_a_of_type_Ryo = null;
    }
    if (this.jdField_b_of_type_Ryo != null)
    {
      if (b(this.jdField_b_of_type_Ryo) != null)
      {
        b(this.jdField_b_of_type_Ryo).l();
        this.jdField_b_of_type_Ryo.jdField_a_of_type_Sdj = null;
      }
      this.jdField_b_of_type_Ryo = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        sdj localsdj = (sdj)localIterator.next();
        if ((localsdj != null) && (!localsdj.i())) {
          localsdj.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_Sdl != null)
    {
      this.jdField_a_of_type_Sdl.b();
      this.jdField_a_of_type_Sdl = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    seo.a().b(this);
    this.jdField_a_of_type_Ryp = null;
    this.jdField_a_of_type_Rzk = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Ryo) != null) {
      b(this.jdField_b_of_type_Ryo).d(paramBoolean);
    }
  }
  
  public boolean g()
  {
    return a() == 7;
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
    b(false);
    c();
  }
  
  public void h(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.o = paramBoolean;
    sdj localsdj;
    if (a() != null)
    {
      localsdj = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localsdj.d(bool1);
      if (b(this.jdField_b_of_type_Ryo) != null)
      {
        localsdj = b(this.jdField_b_of_type_Ryo);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localsdj.d(paramBoolean);
      }
      return;
    }
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    sdj localsdj;
    if (a() != null)
    {
      localsdj = a();
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localsdj.c(paramBoolean);
      return;
    }
  }
  
  public void onPhoneCome()
  {
    if (a() != null) {
      a().f();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    sdj localsdj;
    if (a() != null)
    {
      localsdj = a();
      if (paramInt > 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      localsdj.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */