package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import bnrf;
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
import nzq;
import odr;
import org.json.JSONObject;
import qwu;
import qwv;
import rlr;
import rmn;
import rmp;
import rrj;
import rrk;
import rrm;
import rrn;
import rro;
import rsg;
import rwf;
import rwh;
import rwj;
import rxk;
import rxl;
import rxy;
import ryh;
import sab;
import sac;
import sad;
import tlx;
import tqa;

public class VideoFeedsPlayManager
  implements rwj, rxl
{
  private static List<VideoFeedsPlayManager> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new rrj(this, Looper.getMainLooper());
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<rro> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, rwf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private rmn jdField_a_of_type_Rmn;
  private rrk jdField_a_of_type_Rrk = new rrk(this, null);
  private rrm jdField_a_of_type_Rrm;
  private rrn jdField_a_of_type_Rrn;
  private rsg jdField_a_of_type_Rsg;
  private rwh jdField_a_of_type_Rwh;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private rrm jdField_b_of_type_Rrm;
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
    this.jdField_a_of_type_Rwh = new rwh();
    this.jdField_a_of_type_Rwh.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    rxk.a().a(this);
    this.jdField_a_of_type_Rmn = rmn.a();
    if (rmn.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      if ((bnrf.g(paramQQAppInterface)) || (sac.a.a())) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilList.add(this);
      j();
      return;
      f(false);
    }
  }
  
  private rrm a(rrm paramrrm)
  {
    if (paramrrm == this.jdField_a_of_type_Rrm) {
      return paramrrm;
    }
    return null;
  }
  
  private rwf a()
  {
    return b(this.jdField_a_of_type_Rrm);
  }
  
  private rwf a(rrm paramrrm)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_b_of_type_Boolean)) {
      return null;
    }
    paramrrm = new rwf(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramrrm.jdField_a_of_type_JavaLangString);
    paramrrm.a(this.jdField_a_of_type_Rrk);
    return paramrrm;
  }
  
  private rwf a(rwf paramrwf)
  {
    if (paramrwf == a()) {
      return paramrwf;
    }
    return null;
  }
  
  private void a(qwv paramqwv)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.8(this, paramqwv), 16, null, true);
  }
  
  private void a(rwf paramrwf)
  {
    if (paramrwf == null) {}
    do
    {
      return;
      paramrwf.n();
    } while (paramrwf.j());
    paramrwf.j();
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramrwf), 16, null, true);
  }
  
  private void a(boolean paramBoolean, rrm paramrrm)
  {
    Object localObject;
    if (paramrrm.jdField_a_of_type_Qwv != null)
    {
      localObject = a();
      paramrrm.jdField_a_of_type_Qwv.jdField_a_of_type_Long = ((rwf)localObject).a(this.jdField_c_of_type_Boolean);
      paramrrm.jdField_a_of_type_Qwv.jdField_f_of_type_Int = ((rwf)localObject).e();
      paramrrm.jdField_a_of_type_Qwv.jdField_n_of_type_Long = ((rwf)localObject).c();
      paramrrm.jdField_a_of_type_Qwv.jdField_g_of_type_Int = ((rwf)localObject).f();
      paramrrm.jdField_a_of_type_Qwv.jdField_c_of_type_Boolean = ((rwf)localObject).jdField_b_of_type_Boolean;
      paramrrm.jdField_a_of_type_Qwv.jdField_q_of_type_Long = ((rwf)localObject).jdField_b_of_type_Long;
      paramrrm.jdField_a_of_type_Qwv.jdField_p_of_type_Long = ((rwf)localObject).jdField_a_of_type_Long;
      paramrrm.jdField_a_of_type_Qwv.r = ((rwf)localObject).g();
      if ((paramrrm.jdField_a_of_type_Qwv.jdField_a_of_type_Long == 0L) && (paramrrm.jdField_a_of_type_Qwv.jdField_d_of_type_Long == 0L))
      {
        paramrrm.jdField_a_of_type_Qwv.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Long);
        paramrrm.jdField_a_of_type_Qwv.jdField_f_of_type_Long = paramrrm.jdField_a_of_type_Qwv.jdField_d_of_type_Long;
      }
      paramrrm.jdField_a_of_type_Qwv.t = rxy.a().a();
      paramrrm.jdField_a_of_type_Qwv.jdField_m_of_type_JavaLangString = ryh.a().a();
      paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      paramrrm.jdField_a_of_type_Qwv.jdField_l_of_type_Boolean = ((rwf)localObject).p();
      a(paramrrm.jdField_a_of_type_Qwv);
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
    if ((g()) && (paramBoolean) && (!paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label523;
      }
      paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int = paramrrm.jdField_a_of_type_Qwu.e;
      paramrrm.jdField_a_of_type_Qwu.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramrrm.jdField_a_of_type_Qwu;
      if (paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int != 0) {
        break label541;
      }
      paramBoolean = true;
      ((qwu)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramrrm.jdField_a_of_type_Qwu.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = paramrrm.jdField_a_of_type_Qwu;
      odr.a(((qwu)localObject).jdField_a_of_type_Boolean, ((qwu)localObject).jdField_d_of_type_Int, ((qwu)localObject).e, ((qwu)localObject).jdField_b_of_type_Boolean, ((qwu)localObject).jdField_c_of_type_Boolean, ((qwu)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nzq.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qwu)localObject).jdField_d_of_type_Int;
      i6 = ((qwu)localObject).e;
      if (!((qwu)localObject).jdField_b_of_type_Boolean) {
        break label546;
      }
      i1 = 1;
      if (!((qwu)localObject).jdField_c_of_type_Boolean) {
        break label551;
      }
      i2 = 1;
      if (!tqa.a(this.jdField_a_of_type_Rrm)) {
        break label557;
      }
      i3 = 20;
      label429:
      if (!((qwu)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = nzq.a(i5, i6, i1, i2, i3, i4, 0, nzq.aO, 0);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_f_of_type_Int).b(((qwu)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      tqa.a(this.jdField_a_of_type_Rrm);
      return;
      paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int = ((int)a().e());
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
  
  private boolean a(rrm paramrrm)
  {
    return a(paramrrm) != null;
  }
  
  private boolean a(rwf paramrwf)
  {
    return a(paramrwf) != null;
  }
  
  private rwf b(rrm paramrrm)
  {
    if (paramrrm != null) {
      return paramrrm.jdField_a_of_type_Rwf;
    }
    return null;
  }
  
  private void b(rrm paramrrm, boolean paramBoolean)
  {
    rwf localrwf = b(paramrrm);
    if (localrwf != null) {}
    for (Object localObject = localrwf.a(); (localrwf != null) && (localObject == null) && (localrwf.j()); localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramrrm.jdField_a_of_type_Rwf.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      d(paramrrm, paramBoolean);
      return;
    }
    StringBuilder localStringBuilder;
    if (paramrrm.jdField_c_of_type_Boolean)
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
        if (localrwf != null) {
          localrwf.b(true);
        }
        paramrrm.jdField_a_of_type_AndroidViewView = null;
        c(paramrrm, paramBoolean);
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
      QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject + ", oldPlayer=" + localrwf);
      if (localrwf != null) {
        localrwf.b(true);
      }
      paramrrm.jdField_a_of_type_AndroidViewView = null;
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramrrm, paramBoolean), 5, null, true);
      return;
    }
  }
  
  private void c(rrm paramrrm, boolean paramBoolean)
  {
    paramrrm.jdField_a_of_type_Rwf = a(paramrrm);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((paramrrm.jdField_a_of_type_Rwf != null) && (this.jdField_a_of_type_AndroidOsHandler != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      paramrrm.jdField_a_of_type_Rwf.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, paramrrm.jdField_a_of_type_Rwf);
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.3(this, paramrrm, paramBoolean));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(String.valueOf(this.jdField_a_of_type_Long), paramrrm.jdField_a_of_type_Rwf);
        this.jdField_a_of_type_Long += 1L;
      }
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + paramrrm.jdField_a_of_type_Rwf + ", mUIHandler = " + this.jdField_a_of_type_AndroidOsHandler);
  }
  
  private void d(rrm paramrrm)
  {
    qwv localqwv;
    if (paramrrm != null)
    {
      paramrrm.jdField_a_of_type_Qwv = new qwv();
      paramrrm.jdField_a_of_type_Qwv.jdField_a_of_type_Int = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_JavaLangString = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramrrm.jdField_a_of_type_Qwv.jdField_a_of_type_JavaLangString = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localqwv = paramrrm.jdField_a_of_type_Qwv;
      if (this.jdField_a_of_type_Int != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 5;; i1 = 2)
    {
      localqwv.jdField_d_of_type_Int = i1;
      paramrrm.jdField_a_of_type_Qwv.j = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramrrm.jdField_a_of_type_Qwv.k = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramrrm.jdField_a_of_type_Qwv.s = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramrrm.jdField_a_of_type_Qwv.jdField_a_of_type_Boolean = true;
      paramrrm.jdField_a_of_type_Qwv.o = 0;
      paramrrm.jdField_a_of_type_Qwv.jdField_p_of_type_Int = 0;
      paramrrm.jdField_a_of_type_Qwv.jdField_q_of_type_Int = 0;
      paramrrm.jdField_a_of_type_Qwv.jdField_f_of_type_Boolean = false;
      paramrrm.jdField_a_of_type_Qwv.jdField_f_of_type_JavaLangString = "";
      paramrrm.jdField_a_of_type_Qwv.jdField_g_of_type_Boolean = false;
      paramrrm.jdField_a_of_type_Qwv.jdField_h_of_type_Boolean = false;
      paramrrm.jdField_a_of_type_Qwv.jdField_h_of_type_Int = paramrrm.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramrrm.jdField_a_of_type_Qwv.jdField_i_of_type_Int = paramrrm.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramrrm != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramrrm.jdField_a_of_type_Qwu = new qwu();
        i1 = paramrrm.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", nzq.R);
        paramrrm.jdField_a_of_type_Qwu.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private void d(rrm paramrrm, boolean paramBoolean)
  {
    rwf localrwf = b(paramrrm);
    if ((paramrrm == null) || (localrwf == null)) {
      return;
    }
    paramrrm.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: ");
    }
    if (paramrrm.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      paramrrm.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      localrwf.a(paramrrm.jdField_a_of_type_AndroidViewViewGroup, paramrrm.jdField_c_of_type_Boolean, false);
      if ((paramrrm.jdField_c_of_type_Boolean) && (localrwf.a() != 0))
      {
        localrwf.g();
        paramrrm.jdField_c_of_type_Boolean = false;
        paramrrm.jdField_a_of_type_Rlr.b(paramrrm, false);
      }
      View localView = localrwf.a();
      if (localView == null)
      {
        if (paramrrm.jdField_a_of_type_Rlr != null) {
          paramrrm.jdField_a_of_type_Rlr.a(paramrrm, 999, 999, null);
        }
        paramrrm.jdField_a_of_type_Rwf = null;
        return;
      }
      paramrrm.jdField_a_of_type_AndroidViewView = localView;
      localView.setId(2131376164);
      if (paramrrm.jdField_a_of_type_Rlr != null) {
        paramrrm.jdField_a_of_type_Rlr.b(paramrrm);
      }
      if ((paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000)) {
        localrwf.a().a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localrwf.b(i1);
      if ((!this.o) && (!this.jdField_g_of_type_Boolean)) {
        break label502;
      }
    }
    label502:
    for (boolean bool = true;; bool = false)
    {
      localrwf.d(bool);
      localrwf.a(this.jdField_h_of_type_Boolean);
      localrwf.e(paramrrm.jdField_b_of_type_Boolean);
      localrwf.c(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramrrm).l());
      }
      paramrrm.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramrrm.jdField_a_of_type_Qwv != null)
      {
        paramrrm.jdField_a_of_type_Qwv.o = 0;
        paramrrm.jdField_a_of_type_Qwv.jdField_p_of_type_Int = 0;
        paramrrm.jdField_a_of_type_Qwv.jdField_q_of_type_Int = 0;
        paramrrm.jdField_a_of_type_Qwv.jdField_g_of_type_Boolean = false;
        paramrrm.jdField_a_of_type_Qwv.jdField_h_of_type_Boolean = false;
        paramrrm.jdField_a_of_type_Qwv.jdField_i_of_type_Boolean = this.jdField_h_of_type_Boolean;
      }
      if (!paramrrm.jdField_c_of_type_Boolean) {
        ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramrrm, localrwf, paramBoolean), 16, null, true);
      }
      paramrrm.jdField_c_of_type_Boolean = false;
      paramrrm.jdField_a_of_type_JavaLangString = null;
      return;
      i1 = paramrrm.jdField_a_of_type_Int;
      break;
    }
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu != null) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void i()
  {
    Object localObject;
    if (this.jdField_a_of_type_Rrm != null)
    {
      localObject = this.jdField_a_of_type_Rrm;
      if ((d()) || (b())) {
        this.k = true;
      }
      d();
      ((rrm)localObject).jdField_a_of_type_Rwf = null;
      ((rrm)localObject).jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Rrm = ((rrm)localObject);
    }
    if (this.jdField_b_of_type_Rrm != null)
    {
      if (b(this.jdField_b_of_type_Rrm) != null) {
        b(this.jdField_b_of_type_Rrm).l();
      }
      this.jdField_b_of_type_Rrm.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_Rrm.jdField_a_of_type_Rwf = null;
      this.jdField_b_of_type_Rrm = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        rwf localrwf = (rwf)((Iterator)localObject).next();
        if ((localrwf != null) && (!localrwf.i())) {
          localrwf.l();
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
    if ((this.jdField_a_of_type_Rrm != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Rrm == null) || (this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public rrm a()
  {
    return this.jdField_a_of_type_Rrm;
  }
  
  public rwf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (rwf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
        String str = this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          break label198;
        }
        this.jdField_a_of_type_JavaUtilSet.add(str);
      }
    }
    label198:
    for (this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.jdField_f_of_type_Int = qwu.jdField_a_of_type_Int;; this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.jdField_f_of_type_Int = qwu.jdField_c_of_type_Int)
    {
      if (this.jdField_a_of_type_Rrm != null)
      {
        this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwv.jdField_m_of_type_Int = this.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf.d();
        this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwv.jdField_l_of_type_Int = this.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf.c();
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
    if ((this.jdField_a_of_type_Rrm != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr.a(this.jdField_a_of_type_Rrm, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(rrm paramrrm)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Rrm = paramrrm;
    if (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr != null) {
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr.a(this.jdField_a_of_type_Rrm);
    }
  }
  
  public void a(rrm paramrrm, boolean paramBoolean)
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
      if ((paramrrm != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    this.j = false;
    this.jdField_a_of_type_Rrm = paramrrm;
    this.jdField_b_of_type_Rrm = null;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rro)((Iterator)localObject).next()).a(this.jdField_a_of_type_Rrm);
      }
    }
    if (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr != null) {
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr.a(this.jdField_a_of_type_Rrm, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    rwf localrwf = b(paramrrm);
    int i1;
    if ((localrwf != null) && ((localrwf.d()) || (localrwf.e()) || (localrwf.g())))
    {
      i1 = 1;
      if ((localrwf != null) && (localrwf.a() != paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
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
      paramrrm.jdField_a_of_type_Boolean = false;
      paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramrrm.jdField_a_of_type_Qwv.jdField_n_of_type_Int = 2;
      paramrrm.jdField_a_of_type_Rwf.k();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramrrm.jdField_a_of_type_Qwv.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Rrk.a(paramrrm);
      this.jdField_a_of_type_Rrk.e(paramrrm.jdField_a_of_type_Rwf);
      return;
      i1 = 0;
      break;
    }
    label411:
    if ((paramrrm.jdField_a_of_type_Boolean) && (i2 != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (localrwf == null) {
          break label523;
        }
      }
      for (localObject = Integer.valueOf(localrwf.b());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (localrwf != null) {
          localrwf.k();
        }
        paramrrm.jdField_a_of_type_Qwv.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        paramrrm.jdField_a_of_type_Qwv.jdField_n_of_type_Int = 1;
        this.m = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    label523:
    d(this.jdField_a_of_type_Rrm);
    paramrrm.jdField_a_of_type_Qwv.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if ((this.jdField_a_of_type_Rwh != null) && (!this.jdField_a_of_type_Rwh.a()))
    {
      this.jdField_a_of_type_Rwh.a();
      return;
    }
    paramrrm.jdField_a_of_type_Qwv.jdField_n_of_type_Int = 0;
    b(paramrrm, false);
  }
  
  public void a(rrn paramrrn)
  {
    this.jdField_a_of_type_Rrn = paramrrn;
  }
  
  public void a(rro paramrro)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramrro);
  }
  
  public void a(rsg paramrsg)
  {
    this.jdField_a_of_type_Rsg = paramrsg;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rrm != null) {
        a(this.jdField_a_of_type_Rrm, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr != null)) {
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr.a(this.jdField_a_of_type_Rrm, 999, 998, null);
    }
    this.jdField_a_of_type_Rrm = null;
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
    if ((localObject != null) && (!((rwf)localObject).q()) && (((rwf)localObject).f())) {}
    for (int i1 = 1; (this.jdField_a_of_type_Rrm != null) && (i1 != 0); i1 = 0)
    {
      a().f();
      if (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr != null) {
        this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr.d(this.jdField_a_of_type_Rrm);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rro)((Iterator)localObject).next()).d(this.jdField_a_of_type_Rrm);
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
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int = this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.e;
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.e = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu;
      if (this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int != 0) {
        break label461;
      }
      bool = true;
      ((qwu)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu;
      odr.a(((qwu)localObject).jdField_a_of_type_Boolean, ((qwu)localObject).jdField_d_of_type_Int, ((qwu)localObject).e, ((qwu)localObject).jdField_b_of_type_Boolean, ((qwu)localObject).jdField_c_of_type_Boolean, ((qwu)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nzq.a(this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qwu)localObject).jdField_d_of_type_Int;
      i6 = ((qwu)localObject).e;
      if (!((qwu)localObject).jdField_b_of_type_Boolean) {
        break label467;
      }
      i1 = 1;
      if (!((qwu)localObject).jdField_c_of_type_Boolean) {
        break label472;
      }
      i2 = 1;
      if (!tqa.a(this.jdField_a_of_type_Rrm)) {
        break label477;
      }
      i3 = 20;
      label345:
      if (!((qwu)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = nzq.a(i5, i6, i1, i2, i3, i4, 0, nzq.aO, 0);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.jdField_f_of_type_Int).b(((qwu)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      tqa.a(this.jdField_a_of_type_Rrm);
      return;
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int = ((int)a().e());
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
  
  public void b(rrm paramrrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo mPreplaying=" + this.jdField_b_of_type_Rrm + ", player=" + b(this.jdField_b_of_type_Rrm));
    }
    if ((paramrrm == null) || (paramrrm == this.jdField_a_of_type_Rrm)) {}
    do
    {
      rwf localrwf;
      do
      {
        return;
        localrwf = b(paramrrm);
      } while ((localrwf != null) && (paramrrm.jdField_a_of_type_Boolean) && (localrwf.a() == paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      if (b(this.jdField_b_of_type_Rrm) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "prePlayVideo: last preplay video not stop");
        }
        b(this.jdField_b_of_type_Rrm).b(true);
      }
      this.jdField_a_of_type_JavaLangString = null;
    } while ((this.jdField_a_of_type_Rwh == null) || (!this.jdField_a_of_type_Rwh.a()));
    paramrrm.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Rrm = paramrrm;
    d(this.jdField_b_of_type_Rrm);
    paramrrm.jdField_a_of_type_Qwv.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    b(paramrrm, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
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
  public void c(rrm paramrrm)
  {
    if (paramrrm != null) {
      a(paramrrm.jdField_a_of_type_Rwf);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr != null)) {
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Rlr.f(this.jdField_a_of_type_Rrm);
    }
    if ((this.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rsg != null) && (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf != null)) {
      this.jdField_a_of_type_Rsg.a(1, this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Rrm != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Rrm);
      this.jdField_a_of_type_Rrm.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Rrm.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Rrm.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((rro)localIterator.next()).a(this.jdField_a_of_type_Rrm, this.jdField_c_of_type_Boolean);
        }
      }
      c(this.jdField_a_of_type_Rrm);
    }
    if (this.jdField_a_of_type_Rrm != null) {
      this.jdField_a_of_type_Rrm = null;
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
      if ((a() != null) && (this.jdField_a_of_type_Rrm != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Rrm.jdField_a_of_type_Int)
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
    if ((this.k) && (this.jdField_a_of_type_Rrm != null)) {
      a(this.jdField_a_of_type_Rrm, false);
    }
    label150:
    label153:
    for (;;)
    {
      this.k = false;
      this.jdField_l_of_type_Boolean = false;
      this.n = false;
      rmp localrmp = rmp.a();
      if (!rmn.a().c())
      {
        bool1 = bool2;
        label60:
        localrmp.b(bool1);
        rxy.a().a(this.jdField_a_of_type_AndroidContentContext);
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
    if (b(this.jdField_b_of_type_Rrm) != null) {
      b(this.jdField_b_of_type_Rrm).c(paramBoolean);
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
    rxy.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rmn.b(paramBoolean);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Rrm);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Rrm);
    if (this.jdField_a_of_type_Rrm != null)
    {
      if (a() != null)
      {
        a().l();
        this.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf = null;
      }
      this.jdField_a_of_type_Rrm = null;
    }
    if (this.jdField_b_of_type_Rrm != null)
    {
      if (b(this.jdField_b_of_type_Rrm) != null)
      {
        b(this.jdField_b_of_type_Rrm).l();
        this.jdField_b_of_type_Rrm.jdField_a_of_type_Rwf = null;
      }
      this.jdField_b_of_type_Rrm = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        rwf localrwf = (rwf)localIterator.next();
        if ((localrwf != null) && (!localrwf.i())) {
          localrwf.l();
        }
      }
    }
    if (this.jdField_a_of_type_Rwh != null)
    {
      this.jdField_a_of_type_Rwh.b();
      this.jdField_a_of_type_Rwh = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    rxk.a().b(this);
    this.jdField_a_of_type_Rrn = null;
    this.jdField_a_of_type_Rsg = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Rrm) != null) {
      b(this.jdField_b_of_type_Rrm).d(paramBoolean);
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
    b(false);
    c();
  }
  
  public void h(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.o = paramBoolean;
    rwf localrwf;
    if (a() != null)
    {
      localrwf = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localrwf.d(bool1);
      if (b(this.jdField_b_of_type_Rrm) != null)
      {
        localrwf = b(this.jdField_b_of_type_Rrm);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localrwf.d(paramBoolean);
      }
      return;
    }
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    rwf localrwf;
    if (a() != null)
    {
      localrwf = a();
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localrwf.c(paramBoolean);
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
    rwf localrwf;
    if (a() != null)
    {
      localrwf = a();
      if (paramInt > 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      localrwf.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */