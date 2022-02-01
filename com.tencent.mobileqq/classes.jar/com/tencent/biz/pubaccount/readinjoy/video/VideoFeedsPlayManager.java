package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import bmhv;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import ois;
import omx;
import org.json.JSONObject;
import rpz;
import rqa;
import sfg;
import sge;
import sgg;
import skn;
import sko;
import skq;
import skr;
import sks;
import sln;
import spn;
import spp;
import spr;
import sqb;
import sqt;
import squ;
import srh;
import srq;
import stv;
import stw;
import stx;
import ufy;
import uks;

public class VideoFeedsPlayManager
  implements spr, squ
{
  private static List<VideoFeedsPlayManager> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new skn(this, Looper.getMainLooper());
  private ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<sks> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<spn, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private sge jdField_a_of_type_Sge;
  private sko jdField_a_of_type_Sko = new sko(this, null);
  private skq jdField_a_of_type_Skq;
  private skr jdField_a_of_type_Skr;
  private sln jdField_a_of_type_Sln;
  private spp jdField_a_of_type_Spp;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private skq jdField_b_of_type_Skq;
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
    this.jdField_a_of_type_Spp = new spp();
    this.jdField_a_of_type_Spp.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    sqt.a().a(this);
    this.jdField_a_of_type_Sge = sge.a();
    if (sge.a(this.jdField_a_of_type_AndroidContentContext)) {
      e(true);
    }
    for (;;)
    {
      if ((bmhv.g(paramQQAppInterface)) || (stw.a.a())) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilList.add(this);
      i();
      return;
      e(false);
    }
  }
  
  private skq a(skq paramskq)
  {
    if (paramskq == this.jdField_a_of_type_Skq) {
      return paramskq;
    }
    return null;
  }
  
  private spn a()
  {
    return b(this.jdField_a_of_type_Skq);
  }
  
  private spn a(skq paramskq)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_b_of_type_Boolean)) {
      return null;
    }
    paramskq = new spn(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramskq.jdField_a_of_type_JavaLangString);
    paramskq.a(this.jdField_a_of_type_Sko);
    return paramskq;
  }
  
  private spn a(spn paramspn)
  {
    if (paramspn == a()) {
      return paramspn;
    }
    return null;
  }
  
  private void a(rqa paramrqa)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.8(this, paramrqa), 16, null, true);
  }
  
  private void a(spn paramspn)
  {
    if (paramspn == null) {}
    do
    {
      return;
      paramspn.n();
    } while (paramspn.j());
    paramspn.j();
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramspn), 16, null, true);
  }
  
  private void a(boolean paramBoolean, skq paramskq, ReportConstants.VideoEndType paramVideoEndType)
  {
    Object localObject;
    if (paramskq.jdField_a_of_type_Rqa != null)
    {
      localObject = a();
      paramskq.jdField_a_of_type_Rqa.jdField_a_of_type_Long = ((spn)localObject).a(this.jdField_c_of_type_Boolean);
      paramskq.jdField_a_of_type_Rqa.jdField_f_of_type_Int = ((spn)localObject).e();
      paramskq.jdField_a_of_type_Rqa.jdField_n_of_type_Long = ((spn)localObject).c();
      paramskq.jdField_a_of_type_Rqa.jdField_g_of_type_Int = ((spn)localObject).f();
      paramskq.jdField_a_of_type_Rqa.jdField_c_of_type_Boolean = ((spn)localObject).jdField_b_of_type_Boolean;
      paramskq.jdField_a_of_type_Rqa.jdField_q_of_type_Long = ((spn)localObject).jdField_b_of_type_Long;
      paramskq.jdField_a_of_type_Rqa.jdField_p_of_type_Long = ((spn)localObject).jdField_a_of_type_Long;
      paramskq.jdField_a_of_type_Rqa.r = ((spn)localObject).g();
      if ((paramskq.jdField_a_of_type_Rqa.jdField_a_of_type_Long == 0L) && (paramskq.jdField_a_of_type_Rqa.jdField_d_of_type_Long == 0L))
      {
        paramskq.jdField_a_of_type_Rqa.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Long);
        paramskq.jdField_a_of_type_Rqa.jdField_f_of_type_Long = paramskq.jdField_a_of_type_Rqa.jdField_d_of_type_Long;
      }
      paramskq.jdField_a_of_type_Rqa.t = srh.a().a();
      paramskq.jdField_a_of_type_Rqa.jdField_m_of_type_JavaLangString = srq.a().a();
      paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      paramskq.jdField_a_of_type_Rqa.jdField_l_of_type_Boolean = ((spn)localObject).p();
      ((spn)localObject).a(paramskq.jdField_a_of_type_Rqa.b());
      a(paramskq.jdField_a_of_type_Rqa);
    }
    label323:
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    int i1;
    label432:
    int i2;
    label443:
    int i3;
    if ((h()) && (paramBoolean) && (!paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label558;
      }
      paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Int = paramskq.jdField_a_of_type_Rpz.e;
      paramskq.jdField_a_of_type_Rpz.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramskq.jdField_a_of_type_Rpz;
      if (paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Int != 0) {
        break label576;
      }
      paramBoolean = true;
      ((rpz)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramskq.jdField_a_of_type_Rpz.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      paramskq.jdField_a_of_type_Rpz.jdField_h_of_type_Int = ((int)a().b());
      localObject = paramskq.jdField_a_of_type_Rpz;
      omx.a(((rpz)localObject).jdField_a_of_type_Boolean, ((rpz)localObject).jdField_d_of_type_Int, ((rpz)localObject).e, ((rpz)localObject).jdField_b_of_type_Boolean, ((rpz)localObject).jdField_c_of_type_Boolean, ((rpz)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = ois.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((rpz)localObject).jdField_d_of_type_Int;
      i6 = ((rpz)localObject).e;
      if (!((rpz)localObject).jdField_b_of_type_Boolean) {
        break label581;
      }
      i1 = 1;
      if (!((rpz)localObject).jdField_c_of_type_Boolean) {
        break label587;
      }
      i2 = 1;
      if (!uks.a(this.jdField_a_of_type_Skq)) {
        break label593;
      }
      i3 = 20;
      label457:
      if (!((rpz)localObject).jdField_a_of_type_Boolean) {
        break label599;
      }
    }
    label558:
    label576:
    label581:
    label587:
    label593:
    label599:
    for (int i4 = 1;; i4 = 2)
    {
      paramVideoEndType = ois.a(i5, i6, i1, i2, i3, i4, ((rpz)localObject).jdField_h_of_type_Int, 2, 0, ((rpz)localObject).jdField_i_of_type_Int, paramVideoEndType, true);
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(6).b(((rpz)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramVideoEndType).a());
      uks.a(this.jdField_a_of_type_Skq);
      return;
      paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Int = ((int)a().e());
      break;
      paramBoolean = false;
      break label323;
      i1 = 0;
      break label432;
      i2 = 0;
      break label443;
      i3 = 0;
      break label457;
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 105) || (paramInt == 208);
  }
  
  private boolean a(skq paramskq)
  {
    boolean bool2 = false;
    spn localspn = b(paramskq);
    int i1;
    int i2;
    label60:
    boolean bool1;
    if ((localspn != null) && ((localspn.d()) || (localspn.e()) || (localspn.g())))
    {
      i1 = 1;
      if ((localspn != null) && (localspn.a() != paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label165;
      }
      i2 = 1;
      if ((i1 == 0) || (i2 == 0)) {
        break label170;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramskq.jdField_a_of_type_Boolean = false;
      paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramskq.jdField_a_of_type_Rqa.jdField_n_of_type_Int = 2;
      paramskq.jdField_a_of_type_Spn.k();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramskq.jdField_a_of_type_Rqa.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Sko.a(paramskq);
      this.jdField_a_of_type_Sko.d(paramskq.jdField_a_of_type_Spn);
      bool1 = true;
    }
    label165:
    label170:
    do
    {
      do
      {
        return bool1;
        i1 = 0;
        break;
        i2 = 0;
        break label60;
        bool1 = bool2;
      } while (!paramskq.jdField_a_of_type_Boolean);
      bool1 = bool2;
    } while (i2 == 0);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
      if (localspn == null) {
        break label290;
      }
    }
    label290:
    for (Integer localInteger = Integer.valueOf(localspn.b());; localInteger = null)
    {
      QLog.d("VideoFeedsPlayManager.preplay", 2, localInteger);
      if (localspn != null) {
        localspn.k();
      }
      paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramskq.jdField_a_of_type_Rqa.jdField_n_of_type_Int = 1;
      this.m = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
      return true;
    }
  }
  
  private boolean a(spn paramspn)
  {
    return a(paramspn) != null;
  }
  
  private spn b(skq paramskq)
  {
    if (paramskq != null) {
      return paramskq.jdField_a_of_type_Spn;
    }
    return null;
  }
  
  private void b(skq paramskq, boolean paramBoolean)
  {
    spn localspn = b(paramskq);
    if (localspn != null) {}
    for (Object localObject = localspn.a(); (localspn != null) && (localObject == null) && (localspn.j()); localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramskq.jdField_a_of_type_Spn.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      d(paramskq, paramBoolean);
      return;
    }
    StringBuilder localStringBuilder;
    if (paramskq.jdField_c_of_type_Boolean)
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
        if (localspn != null) {
          localspn.b(true);
        }
        paramskq.jdField_a_of_type_AndroidViewView = null;
        c(paramskq, paramBoolean);
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
      QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject + ", oldPlayer=" + localspn);
      if (localspn != null) {
        localspn.b(true);
      }
      paramskq.jdField_a_of_type_AndroidViewView = null;
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramskq, paramBoolean), 5, null, true);
      return;
    }
  }
  
  private boolean b(skq paramskq)
  {
    return a(paramskq) != null;
  }
  
  private void c(skq paramskq, boolean paramBoolean)
  {
    paramskq.jdField_a_of_type_Spn = a(paramskq);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((paramskq.jdField_a_of_type_Spn != null) && (this.jdField_a_of_type_AndroidOsHandler != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      paramskq.jdField_a_of_type_Spn.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramskq.jdField_a_of_type_Spn, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.3(this, paramskq, paramBoolean));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + paramskq.jdField_a_of_type_Spn + ", mUIHandler = " + this.jdField_a_of_type_AndroidOsHandler);
  }
  
  private void d(skq paramskq)
  {
    rqa localrqa;
    if (paramskq != null)
    {
      paramskq.jdField_a_of_type_Rqa = new rqa();
      paramskq.jdField_a_of_type_Rqa.jdField_a_of_type_Int = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_JavaLangString = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramskq.jdField_a_of_type_Rqa.jdField_a_of_type_JavaLangString = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localrqa = paramskq.jdField_a_of_type_Rqa;
      if (this.jdField_a_of_type_Int != 1) {
        break label274;
      }
    }
    label274:
    for (int i1 = 5;; i1 = 2)
    {
      localrqa.jdField_d_of_type_Int = i1;
      paramskq.jdField_a_of_type_Rqa.j = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramskq.jdField_a_of_type_Rqa.k = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramskq.jdField_a_of_type_Rqa.s = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramskq.jdField_a_of_type_Rqa.jdField_a_of_type_Boolean = true;
      paramskq.jdField_a_of_type_Rqa.o = 0;
      paramskq.jdField_a_of_type_Rqa.jdField_p_of_type_Int = 0;
      paramskq.jdField_a_of_type_Rqa.jdField_q_of_type_Int = 0;
      paramskq.jdField_a_of_type_Rqa.jdField_f_of_type_Boolean = false;
      paramskq.jdField_a_of_type_Rqa.jdField_f_of_type_JavaLangString = "";
      paramskq.jdField_a_of_type_Rqa.jdField_g_of_type_Boolean = false;
      paramskq.jdField_a_of_type_Rqa.jdField_h_of_type_Boolean = false;
      paramskq.jdField_a_of_type_Rqa.jdField_h_of_type_Int = paramskq.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramskq.jdField_a_of_type_Rqa.jdField_i_of_type_Int = paramskq.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramskq != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramskq.jdField_a_of_type_Rpz = new rpz();
        i1 = paramskq.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", 10);
        paramskq.jdField_a_of_type_Rpz.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private void d(skq paramskq, boolean paramBoolean)
  {
    spn localspn = b(paramskq);
    if ((paramskq == null) || (localspn == null)) {
      return;
    }
    paramskq.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: ");
    }
    if (paramskq.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      paramskq.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      localspn.a(paramskq.jdField_a_of_type_AndroidViewViewGroup, paramskq.jdField_c_of_type_Boolean, false);
      if ((paramskq.jdField_c_of_type_Boolean) && (localspn.a() != 0))
      {
        localspn.g();
        paramskq.jdField_c_of_type_Boolean = false;
        paramskq.jdField_a_of_type_Sfg.b(paramskq, false);
      }
      View localView = localspn.a();
      if (localView == null)
      {
        if (paramskq.jdField_a_of_type_Sfg != null) {
          paramskq.jdField_a_of_type_Sfg.a(paramskq, 999, 999, null);
        }
        paramskq.jdField_a_of_type_Spn = null;
        return;
      }
      paramskq.jdField_a_of_type_AndroidViewView = localView;
      localView.setId(2131376175);
      if (paramskq.jdField_a_of_type_Sfg != null) {
        paramskq.jdField_a_of_type_Sfg.b(paramskq);
      }
      if ((paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000)) {
        localspn.a().a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localspn.b(i1);
      if ((!this.o) && (!this.jdField_g_of_type_Boolean)) {
        break label502;
      }
    }
    label502:
    for (boolean bool = true;; bool = false)
    {
      localspn.d(bool);
      localspn.a(this.jdField_h_of_type_Boolean);
      localspn.e(paramskq.jdField_b_of_type_Boolean);
      localspn.c(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramskq).l());
      }
      paramskq.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramskq.jdField_a_of_type_Rqa.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramskq.jdField_a_of_type_Rqa != null)
      {
        paramskq.jdField_a_of_type_Rqa.o = 0;
        paramskq.jdField_a_of_type_Rqa.jdField_p_of_type_Int = 0;
        paramskq.jdField_a_of_type_Rqa.jdField_q_of_type_Int = 0;
        paramskq.jdField_a_of_type_Rqa.jdField_g_of_type_Boolean = false;
        paramskq.jdField_a_of_type_Rqa.jdField_h_of_type_Boolean = false;
        paramskq.jdField_a_of_type_Rqa.jdField_i_of_type_Boolean = this.jdField_h_of_type_Boolean;
      }
      if (!paramskq.jdField_c_of_type_Boolean) {
        ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramskq, localspn, paramBoolean), 16, null, true);
      }
      paramskq.jdField_c_of_type_Boolean = false;
      paramskq.jdField_a_of_type_JavaLangString = null;
      return;
      i1 = paramskq.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void h()
  {
    Object localObject;
    if (this.jdField_a_of_type_Skq != null)
    {
      localObject = this.jdField_a_of_type_Skq;
      if ((d()) || (b())) {
        this.k = true;
      }
      b(ReportConstants.VideoEndType.EXIT_SCENE);
      ((skq)localObject).jdField_a_of_type_Spn = null;
      ((skq)localObject).jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Skq = ((skq)localObject);
    }
    if (this.jdField_b_of_type_Skq != null)
    {
      if (b(this.jdField_b_of_type_Skq) != null) {
        b(this.jdField_b_of_type_Skq).l();
      }
      this.jdField_b_of_type_Skq.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_Skq.jdField_a_of_type_Spn = null;
      this.jdField_b_of_type_Skq = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        spn localspn = (spn)((Iterator)localObject).next();
        if ((localspn != null) && (!localspn.i())) {
          localspn.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  private boolean h()
  {
    return (this.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz != null) && (this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void i()
  {
    int i1 = Aladdin.getConfig(352).getIntegerFromString("play_manager_max_count", 3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "inspectPlayerMemory: size=" + jdField_a_of_type_JavaUtilList.size() + ", maxCount=" + i1);
    }
    if (jdField_a_of_type_JavaUtilList.size() > i1)
    {
      int i2 = jdField_a_of_type_JavaUtilList.size();
      ((VideoFeedsPlayManager)jdField_a_of_type_JavaUtilList.get(i2 - i1 - 1)).h();
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
    if ((this.jdField_a_of_type_Skq != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Skq == null) || (this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public skq a()
  {
    return this.jdField_a_of_type_Skq;
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
        localObject = this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (this.jdField_a_of_type_JavaUtilSet.contains(localObject)) {
          break label206;
        }
        this.jdField_a_of_type_JavaUtilSet.add(localObject);
        this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_f_of_type_Int = rpz.jdField_a_of_type_Int;
      }
    }
    for (this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_i_of_type_Int = 0;; ((rpz)localObject).jdField_i_of_type_Int += 1)
    {
      localObject = a();
      if ((this.jdField_a_of_type_Skq != null) && (localObject != null))
      {
        this.jdField_a_of_type_Skq.jdField_a_of_type_Rqa.jdField_m_of_type_Int = ((spn)localObject).d();
        this.jdField_a_of_type_Skq.jdField_a_of_type_Rqa.jdField_l_of_type_Int = ((spn)localObject).c();
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      a().d();
      break;
      label206:
      this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_f_of_type_Int = rpz.jdField_c_of_type_Int;
      localObject = this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz;
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
    if ((this.jdField_a_of_type_Skq != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg.a(this.jdField_a_of_type_Skq, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(ReportConstants.VideoEndType paramVideoEndType)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = paramVideoEndType;
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(skq paramskq)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Skq = paramskq;
    if (this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg != null) {
      this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg.a(this.jdField_a_of_type_Skq);
    }
  }
  
  public void a(skq paramskq, boolean paramBoolean)
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
      do
      {
        return;
        if ((paramskq != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Skq = paramskq;
      this.jdField_b_of_type_Skq = null;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((sks)localIterator.next()).e(this.jdField_a_of_type_Skq);
        }
      }
      if (this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg != null) {
        this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg.a(this.jdField_a_of_type_Skq, paramBoolean);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    } while (a(paramskq));
    d(this.jdField_a_of_type_Skq);
    paramskq.jdField_a_of_type_Rqa.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if ((this.jdField_a_of_type_Spp != null) && (!this.jdField_a_of_type_Spp.a()))
    {
      this.jdField_a_of_type_Spp.a();
      return;
    }
    paramskq.jdField_a_of_type_Rqa.jdField_n_of_type_Int = 0;
    b(paramskq, false);
  }
  
  public void a(skr paramskr)
  {
    this.jdField_a_of_type_Skr = paramskr;
  }
  
  public void a(sks paramsks)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramsks);
  }
  
  public void a(sln paramsln)
  {
    this.jdField_a_of_type_Sln = paramsln;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Skq != null) {
        a(this.jdField_a_of_type_Skq, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg != null)) {
      this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg.a(this.jdField_a_of_type_Skq, 999, 998, null);
    }
    this.jdField_a_of_type_Skq = null;
  }
  
  public void a(boolean paramBoolean, ReportConstants.VideoEndType paramVideoEndType)
  {
    if ((this.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg != null)) {
      this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg.f(this.jdField_a_of_type_Skq);
    }
    if ((this.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Sln != null) && (this.jdField_a_of_type_Skq.jdField_a_of_type_Spn != null)) {
      this.jdField_a_of_type_Sln.a(1, this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Skq.jdField_a_of_type_Spn.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Skq != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Skq, paramVideoEndType);
      this.jdField_a_of_type_Skq.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Skq.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Skq.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramVideoEndType = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramVideoEndType.hasNext()) {
          ((sks)paramVideoEndType.next()).a(this.jdField_a_of_type_Skq, this.jdField_c_of_type_Boolean);
        }
      }
      sqb.a.a(this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, a(), c());
      c(this.jdField_a_of_type_Skq);
    }
    if (this.jdField_a_of_type_Skq != null) {
      this.jdField_a_of_type_Skq = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public boolean a()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public long b()
  {
    if ((this.jdField_a_of_type_Skq != null) && (a() != null)) {
      return a().a(g());
    }
    return 0L;
  }
  
  public void b()
  {
    Object localObject = a();
    if ((localObject != null) && (!((spn)localObject).q()) && (((spn)localObject).f())) {}
    for (int i1 = 1; (this.jdField_a_of_type_Skq != null) && (i1 != 0); i1 = 0)
    {
      a().f();
      if (this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg != null) {
        this.jdField_a_of_type_Skq.jdField_a_of_type_Sfg.d(this.jdField_a_of_type_Skq);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sks)((Iterator)localObject).next()).c(this.jdField_a_of_type_Skq);
      }
    }
    boolean bool;
    label219:
    rpz localrpz;
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    label340:
    int i2;
    label350:
    int i3;
    label363:
    int i4;
    label374:
    int i7;
    int i8;
    if ((h()) && (a() != null))
    {
      if (a().e() != 0L) {
        break label488;
      }
      this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_d_of_type_Int = this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.e;
      this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz;
      if (this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_d_of_type_Int != 0) {
        break label509;
      }
      bool = true;
      ((rpz)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_h_of_type_Int = ((int)a().b());
      localrpz = this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz;
      omx.a(localrpz.jdField_a_of_type_Boolean, localrpz.jdField_d_of_type_Int, localrpz.e, localrpz.jdField_b_of_type_Boolean, localrpz.jdField_c_of_type_Boolean, localrpz.jdField_f_of_type_Int);
      localAdvertisementInfo = ois.a(this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = localrpz.jdField_d_of_type_Int;
      i6 = localrpz.e;
      if (!localrpz.jdField_b_of_type_Boolean) {
        break label515;
      }
      i1 = 1;
      if (!localrpz.jdField_c_of_type_Boolean) {
        break label520;
      }
      i2 = 1;
      if (!uks.a(this.jdField_a_of_type_Skq)) {
        break label525;
      }
      i3 = 20;
      if (!localrpz.jdField_a_of_type_Boolean) {
        break label530;
      }
      i4 = 1;
      i7 = localrpz.jdField_h_of_type_Int;
      i8 = localrpz.jdField_i_of_type_Int;
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType == null) {
        break label536;
      }
    }
    label515:
    label520:
    label525:
    label530:
    label536:
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;; localObject = ReportConstants.VideoEndType.CLICK_PAUSE)
    {
      localObject = ois.a(i5, i6, i1, i2, i3, i4, i7, 2, 0, i8, (ReportConstants.VideoEndType)localObject, true);
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(6).b(localrpz.jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a((JSONObject)localObject).a());
      uks.a(this.jdField_a_of_type_Skq);
      return;
      label488:
      this.jdField_a_of_type_Skq.jdField_a_of_type_Rpz.jdField_d_of_type_Int = ((int)a().e());
      break;
      label509:
      bool = false;
      break label219;
      i1 = 0;
      break label340;
      i2 = 0;
      break label350;
      i3 = 0;
      break label363;
      i4 = 2;
      break label374;
    }
  }
  
  public void b(ReportConstants.VideoEndType paramVideoEndType)
  {
    a(true, paramVideoEndType);
  }
  
  public void b(skq paramskq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo mPreplaying=" + this.jdField_b_of_type_Skq + ", player=" + b(this.jdField_b_of_type_Skq));
    }
    if ((paramskq == null) || (paramskq == this.jdField_a_of_type_Skq)) {}
    do
    {
      spn localspn;
      do
      {
        return;
        localspn = b(paramskq);
      } while ((localspn != null) && (paramskq.jdField_a_of_type_Boolean) && (localspn.a() == paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      if (b(this.jdField_b_of_type_Skq) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "prePlayVideo: last preplay video not stop");
        }
        b(this.jdField_b_of_type_Skq).b(true);
      }
      this.jdField_a_of_type_JavaLangString = null;
    } while ((this.jdField_a_of_type_Spp == null) || (!this.jdField_a_of_type_Spp.a()));
    paramskq.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Skq = paramskq;
    d(this.jdField_b_of_type_Skq);
    paramskq.jdField_a_of_type_Rqa.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    b(paramskq, true);
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
  public void c(skq paramskq)
  {
    if (paramskq != null) {
      a(paramskq.jdField_a_of_type_Spn);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((a() != null) && (this.jdField_a_of_type_Skq != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Skq.jdField_a_of_type_Int)
    {
      a().b(i1);
      return;
    }
  }
  
  public boolean c()
  {
    return (a() != null) && (a().l());
  }
  
  public void d()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = null;
    this.jdField_f_of_type_Boolean = true;
    if ((this.k) && (this.jdField_a_of_type_Skq != null)) {
      a(this.jdField_a_of_type_Skq, false);
    }
    label155:
    label158:
    for (;;)
    {
      this.k = false;
      this.jdField_l_of_type_Boolean = false;
      this.n = false;
      sgg localsgg = sgg.a();
      if (!sge.a().c())
      {
        bool1 = bool2;
        label65:
        localsgg.b(bool1);
        srh.a().a(this.jdField_a_of_type_AndroidContentContext);
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
          break label155;
        }
      }
      for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting();; bool1 = false)
      {
        if (bool1) {
          break label158;
        }
        this.m = true;
        c();
        break;
        bool1 = false;
        break label65;
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().c(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Skq) != null) {
      b(this.jdField_b_of_type_Skq).c(paramBoolean);
    }
  }
  
  public boolean d()
  {
    return (a() != null) && (a().f());
  }
  
  public void e()
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
    srh.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Sge.b(paramBoolean);
  }
  
  public boolean e()
  {
    return a() == 5;
  }
  
  public void f()
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
    b(ReportConstants.VideoEndType.EXIT_SCENE);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Skq);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Skq);
    if (this.jdField_a_of_type_Skq != null)
    {
      if (a() != null)
      {
        a().l();
        this.jdField_a_of_type_Skq.jdField_a_of_type_Spn = null;
      }
      this.jdField_a_of_type_Skq = null;
    }
    if (this.jdField_b_of_type_Skq != null)
    {
      if (b(this.jdField_b_of_type_Skq) != null)
      {
        b(this.jdField_b_of_type_Skq).l();
        this.jdField_b_of_type_Skq.jdField_a_of_type_Spn = null;
      }
      this.jdField_b_of_type_Skq = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        spn localspn = (spn)localIterator.next();
        if ((localspn != null) && (!localspn.i())) {
          localspn.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_Spp != null)
    {
      this.jdField_a_of_type_Spp.b();
      this.jdField_a_of_type_Spp = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    sqt.a().b(this);
    this.jdField_a_of_type_Skr = null;
    this.jdField_a_of_type_Sln = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Skq) != null) {
      b(this.jdField_b_of_type_Skq).d(paramBoolean);
    }
  }
  
  public boolean f()
  {
    return a() == 3;
  }
  
  public void g()
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
  
  public void g(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.o = paramBoolean;
    spn localspn;
    if (a() != null)
    {
      localspn = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localspn.d(bool1);
      if (b(this.jdField_b_of_type_Skq) != null)
      {
        localspn = b(this.jdField_b_of_type_Skq);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localspn.d(paramBoolean);
      }
      return;
    }
  }
  
  public boolean g()
  {
    return a() == 7;
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    spn localspn;
    if (a() != null)
    {
      localspn = a();
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localspn.c(paramBoolean);
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
    spn localspn;
    if (a() != null)
    {
      localspn = a();
      if (paramInt > 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      localspn.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */