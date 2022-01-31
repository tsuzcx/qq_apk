package com.tencent.biz.pubaccount.readinjoy.video;

import aery;
import aesa;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import bdnn;
import bkbq;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import noy;
import ntd;
import obk;
import oee;
import org.json.JSONException;
import org.json.JSONObject;
import qlp;
import qlq;
import qyz;
import qzy;
import raa;
import rfo;
import rfp;
import rfs;
import rft;
import rfu;
import rgn;
import rjn;
import rjp;
import rjr;
import rlb;
import rlt;
import rmc;

public class VideoFeedsPlayManager
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, rjr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aesa jdField_a_of_type_Aesa;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new rfo(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TVK_NetVideoInfo a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList<rfu> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, rjn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private qzy jdField_a_of_type_Qzy;
  private rfp jdField_a_of_type_Rfp = new rfp(this, null);
  private rfs jdField_a_of_type_Rfs;
  private rft jdField_a_of_type_Rft;
  private rgn jdField_a_of_type_Rgn;
  private rjp jdField_a_of_type_Rjp;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private rfs jdField_b_of_type_Rfs;
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
    this.jdField_a_of_type_Rjp = new rjp(paramContext.getApplicationContext());
    this.jdField_a_of_type_Rjp.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    rlb.a().a(this);
    this.jdField_a_of_type_Qzy = qzy.a();
    if (qzy.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      this.jdField_h_of_type_Boolean = bkbq.g(paramQQAppInterface);
      return;
      f(false);
    }
  }
  
  private rfs a(rfs paramrfs)
  {
    if (paramrfs == this.jdField_a_of_type_Rfs) {
      return paramrfs;
    }
    return null;
  }
  
  private rjn a()
  {
    return b(this.jdField_a_of_type_Rfs);
  }
  
  private rjn a(rfs paramrfs)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    paramrfs = new rjn(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    paramrfs.a(this.jdField_a_of_type_Rfp);
    return paramrfs;
  }
  
  private rjn a(rjn paramrjn)
  {
    if (paramrjn == a()) {
      return paramrjn;
    }
    return null;
  }
  
  private void a(String paramString, String[] paramArrayOfString, int paramInt, long paramLong)
  {
    int i1 = 0;
    rfs localrfs = this.jdField_a_of_type_Rfs;
    if ((localrfs == null) || (localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                  } while (paramLong != localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                  switch (paramInt)
                  {
                  case 1002: 
                  case 1003: 
                  default: 
                    return;
                  case 2002: 
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage STATUS_RECV_PROCESS: get url finished");
                    }
                    break;
                  }
                } while (paramArrayOfString == null);
                paramInt = i1;
                while (paramInt < 1)
                {
                  if (!bdnn.a(paramString)) {
                    paramArrayOfString[paramInt] = (paramArrayOfString[paramInt] + "&txhost=" + paramString);
                  }
                  paramInt += 1;
                }
              } while (!QLog.isColorLevel());
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage STATUS_RECV_FINISHED");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_RECV_ERROR");
              }
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            } while (localrfs.jdField_a_of_type_Qyz == null);
            localrfs.jdField_a_of_type_Qyz.a(localrfs, 999, 997, null);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_UNSAFE");
            }
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720138, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          } while (localrfs.jdField_a_of_type_Qyz == null);
          localrfs.jdField_a_of_type_Qyz.a(localrfs, 999, 997, null);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_EXPIRED");
          }
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720139, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        } while (localrfs.jdField_a_of_type_Qyz == null);
        localrfs.jdField_a_of_type_Qyz.a(localrfs, 999, 997, null);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_RECV_CANCEL");
      return;
      paramLong = localrfs.jdField_a_of_type_Long;
      paramString = ShortVideoUtils.a(localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      str = localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    } while ((this.jdField_a_of_type_Rfs == null) || (a() == null));
    a().a(paramArrayOfString, paramString, localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, str, paramLong, localrfs.jdField_a_of_type_Boolean, this);
  }
  
  private void a(qlq paramqlq)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramqlq), 16, null, true);
  }
  
  private void a(rjn paramrjn)
  {
    if (paramrjn == null) {}
    int i1;
    do
    {
      return;
      paramrjn.p();
      i1 = paramrjn.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramrjn.k();
    ThreadManager.excute(new VideoFeedsPlayManager.6(this, paramrjn), 16, null, true);
  }
  
  private void a(boolean paramBoolean, rfs paramrfs)
  {
    Object localObject;
    if (paramrfs.jdField_a_of_type_Qlq != null)
    {
      localObject = a();
      paramrfs.jdField_a_of_type_Qlq.jdField_a_of_type_Long = ((rjn)localObject).a(this.jdField_c_of_type_Boolean);
      paramrfs.jdField_a_of_type_Qlq.jdField_e_of_type_Int = ((rjn)localObject).c();
      paramrfs.jdField_a_of_type_Qlq.jdField_m_of_type_Long = ((rjn)localObject).c();
      paramrfs.jdField_a_of_type_Qlq.jdField_f_of_type_Int = ((rjn)localObject).d();
      paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Boolean = ((rjn)localObject).jdField_b_of_type_Boolean;
      paramrfs.jdField_a_of_type_Qlq.jdField_p_of_type_Long = ((rjn)localObject).jdField_b_of_type_Long;
      paramrfs.jdField_a_of_type_Qlq.jdField_o_of_type_Long = ((rjn)localObject).jdField_a_of_type_Long;
      paramrfs.jdField_a_of_type_Qlq.q = ((rjn)localObject).f();
      paramrfs.jdField_a_of_type_Qlq.r = ((rjn)localObject).f();
      paramrfs.jdField_a_of_type_Qlq.jdField_f_of_type_JavaLangString = ((rjn)localObject).a();
      paramrfs.jdField_a_of_type_Qlq.t = ((rjn)localObject).h();
      paramrfs.jdField_a_of_type_Qlq.u = ((rjn)localObject).g();
      if ((paramrfs.jdField_a_of_type_Qlq.jdField_a_of_type_Long == 0L) && (paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Long == 0L))
      {
        paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramrfs.jdField_a_of_type_Qlq.jdField_b_of_type_Long);
        paramrfs.jdField_a_of_type_Qlq.jdField_e_of_type_Long = paramrfs.jdField_a_of_type_Qlq.jdField_c_of_type_Long;
      }
      paramrfs.jdField_a_of_type_Qlq.v = rlt.a().a();
      paramrfs.jdField_a_of_type_Qlq.jdField_n_of_type_JavaLangString = rmc.a().a();
      a(paramrfs.jdField_a_of_type_Qlq);
    }
    label336:
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    int i1;
    label429:
    int i2;
    label440:
    int i3;
    if ((h()) && (paramBoolean) && (!paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label548;
      }
      paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int = paramrfs.jdField_a_of_type_Qlp.jdField_e_of_type_Int;
      paramrfs.jdField_a_of_type_Qlp.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramrfs.jdField_a_of_type_Qlp;
      if (paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int != 0) {
        break label566;
      }
      paramBoolean = true;
      ((qlp)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramrfs.jdField_a_of_type_Qlp.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = paramrfs.jdField_a_of_type_Qlp;
      ntd.a(((qlp)localObject).jdField_a_of_type_Boolean, ((qlp)localObject).jdField_d_of_type_Int, ((qlp)localObject).jdField_e_of_type_Int, ((qlp)localObject).jdField_b_of_type_Boolean, ((qlp)localObject).jdField_c_of_type_Boolean, ((qlp)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = noy.a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qlp)localObject).jdField_d_of_type_Int;
      i6 = ((qlp)localObject).jdField_e_of_type_Int;
      if (!((qlp)localObject).jdField_b_of_type_Boolean) {
        break label571;
      }
      i1 = 1;
      if (!((qlp)localObject).jdField_c_of_type_Boolean) {
        break label576;
      }
      i2 = 1;
      if (!oee.a(this.jdField_a_of_type_Rfs)) {
        break label582;
      }
      i3 = 20;
      label454:
      if (!((qlp)localObject).jdField_a_of_type_Boolean) {
        break label588;
      }
    }
    label548:
    label566:
    label571:
    label576:
    label582:
    label588:
    for (int i4 = 1;; i4 = 2)
    {
      JSONObject localJSONObject = noy.a(i5, i6, i1, i2, i3, i4, 0, noy.aE, 0);
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_f_of_type_Int).b(((qlp)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oee.a(this.jdField_a_of_type_Rfs);
      return;
      paramrfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int = ((int)a().e());
      break;
      paramBoolean = false;
      break label336;
      i1 = 0;
      break label429;
      i2 = 0;
      break label440;
      i3 = 0;
      break label454;
    }
  }
  
  private boolean a(rfs paramrfs)
  {
    return a(paramrfs) != null;
  }
  
  private boolean a(rjn paramrjn)
  {
    return a(paramrjn) != null;
  }
  
  private rjn b(rfs paramrfs)
  {
    if (paramrfs != null) {
      return paramrfs.jdField_a_of_type_Rjn;
    }
    return null;
  }
  
  private void b(rfs paramrfs, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((b(paramrfs) == null) || (b(paramrfs).a() != null))
    {
      boolean bool1 = bool2;
      if (b(paramrfs) != null)
      {
        bool1 = bool2;
        if (b(paramrfs).a() != null)
        {
          b(paramrfs).b(false);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay: videoPlayer.tag isn't null!");
          }
          bool1 = true;
        }
      }
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramrfs, bool1, paramBoolean), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    paramrfs.jdField_a_of_type_Rjn.a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    c(paramrfs, paramBoolean);
  }
  
  private void c(rfs paramrfs, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((paramrfs == null) || (b(paramrfs) == null)) {
      return;
    }
    paramrfs.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramrfs.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      localObject = b(paramrfs).b();
      if (localObject == null)
      {
        if (paramrfs.jdField_a_of_type_Qyz != null) {
          paramrfs.jdField_a_of_type_Qyz.a(paramrfs, 999, 999, null);
        }
        paramrfs.jdField_a_of_type_Rjn = null;
        return;
      }
      paramrfs.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131375294);
      paramrfs.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      b(paramrfs).a((IVideoViewBase)localObject);
      if (paramrfs.jdField_a_of_type_Qyz != null) {
        paramrfs.jdField_a_of_type_Qyz.g(paramrfs);
      }
      if ((paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000) && ((localObject instanceof IVideoViewBase))) {
        ((IVideoViewBase)localObject).setFixedSize(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      b(paramrfs).b(i1);
      localObject = b(paramrfs);
      if ((!this.n) && (!this.jdField_g_of_type_Boolean)) {
        break label537;
      }
      bool1 = true;
      label281:
      ((rjn)localObject).d(bool1);
      localObject = b(paramrfs);
      if ((!this.jdField_h_of_type_Boolean) || (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean)) {
        break label543;
      }
    }
    label537:
    label543:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((rjn)localObject).a(bool1);
      b(paramrfs).e(paramrfs.jdField_b_of_type_Boolean);
      b(paramrfs).a().setOutputMute(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramrfs).a().getOutputMute());
      }
      paramrfs.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramrfs.jdField_a_of_type_Qlq.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramrfs.jdField_a_of_type_Qlq != null)
      {
        paramrfs.jdField_a_of_type_Qlq.jdField_n_of_type_Int = 0;
        paramrfs.jdField_a_of_type_Qlq.jdField_o_of_type_Int = 0;
        paramrfs.jdField_a_of_type_Qlq.jdField_p_of_type_Int = 0;
        paramrfs.jdField_a_of_type_Qlq.jdField_g_of_type_Boolean = false;
        paramrfs.jdField_a_of_type_Qlq.jdField_h_of_type_Boolean = false;
        localObject = paramrfs.jdField_a_of_type_Qlq;
        bool1 = bool2;
        if (this.jdField_h_of_type_Boolean)
        {
          bool1 = bool2;
          if (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) {
            bool1 = true;
          }
        }
        ((qlq)localObject).jdField_i_of_type_Boolean = bool1;
      }
      ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramrfs, b(paramrfs), paramBoolean), 16, null, true);
      return;
      i1 = paramrfs.jdField_a_of_type_Int;
      break;
      bool1 = false;
      break label281;
    }
  }
  
  private void d(rfs paramrfs)
  {
    qlq localqlq;
    if (paramrfs != null)
    {
      paramrfs.jdField_a_of_type_Qlq = new qlq();
      paramrfs.jdField_a_of_type_Qlq.jdField_a_of_type_Int = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramrfs.jdField_a_of_type_Qlq.jdField_b_of_type_JavaLangString = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramrfs.jdField_a_of_type_Qlq.jdField_a_of_type_JavaLangString = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localqlq = paramrfs.jdField_a_of_type_Qlq;
      if (this.jdField_a_of_type_Int != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 5;; i1 = 2)
    {
      localqlq.jdField_c_of_type_Int = i1;
      paramrfs.jdField_a_of_type_Qlq.jdField_i_of_type_Int = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramrfs.jdField_a_of_type_Qlq.j = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramrfs.jdField_a_of_type_Qlq.s = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramrfs.jdField_a_of_type_Qlq.jdField_a_of_type_Boolean = true;
      paramrfs.jdField_a_of_type_Qlq.jdField_n_of_type_Int = 0;
      paramrfs.jdField_a_of_type_Qlq.jdField_o_of_type_Int = 0;
      paramrfs.jdField_a_of_type_Qlq.jdField_p_of_type_Int = 0;
      paramrfs.jdField_a_of_type_Qlq.jdField_f_of_type_Boolean = false;
      paramrfs.jdField_a_of_type_Qlq.jdField_g_of_type_JavaLangString = "";
      paramrfs.jdField_a_of_type_Qlq.jdField_g_of_type_Boolean = false;
      paramrfs.jdField_a_of_type_Qlq.jdField_h_of_type_Boolean = false;
      paramrfs.jdField_a_of_type_Qlq.jdField_g_of_type_Int = paramrfs.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramrfs.jdField_a_of_type_Qlq.jdField_h_of_type_Int = paramrfs.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramrfs != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramrfs.jdField_a_of_type_Qlp = new qlp();
        i1 = paramrfs.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", noy.P);
        paramrfs.jdField_a_of_type_Qlp.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private boolean h()
  {
    return (this.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          return;
        }
        int i1 = new JSONObject(paramString).getInt("callBackType");
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "OnDownloadCallback callBackType=" + i1 + ", msg.videoFileStatus=" + this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
        }
        if ((i1 == 7) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 2003))
        {
          paramString = this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          paramString.videoFileStatus = 2003;
          paramString.videoFileProgress = 100;
          paramString.transferedSize = 0;
          paramString.lastModified = new File(ShortVideoUtils.a(paramString, "mp4")).lastModified();
          paramString.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "OnDownloadCallback: Exception = " + paramString);
      }
    }
  }
  
  public int a()
  {
    if (a() != null) {
      return a().e();
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_Rfs != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Rfs == null) || (this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public rfs a()
  {
    return this.jdField_a_of_type_Rfs;
  }
  
  public rjn a(String paramString)
  {
    return (rjn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    if (a() != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new VideoFeedsPlayManager.3(this));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.4(this));
      if (h())
      {
        String str = this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString;
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          break label191;
        }
        this.jdField_a_of_type_JavaUtilSet.add(str);
      }
    }
    label191:
    for (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_f_of_type_Int = qlp.jdField_a_of_type_Int;; this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_f_of_type_Int = qlp.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.l = this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.b();
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.k = this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.a();
      return;
      a().f();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      break;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Rfs != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz.a(this.jdField_a_of_type_Rfs, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(rfs paramrfs)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Rfs = paramrfs;
    if (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz != null) {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz.e(this.jdField_a_of_type_Rfs);
    }
  }
  
  public void a(rfs paramrfs, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    Object localObject;
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Rfs = paramrfs;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((rfu)((Iterator)localObject).next()).a(this.jdField_a_of_type_Rfs);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
        }
        return;
      }
    }
    if (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz != null) {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz.a(this.jdField_a_of_type_Rfs, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    if ((b(paramrfs) != null) && (b(paramrfs).e()) && (b(paramrfs).a() == paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramrfs.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Rfs = null;
      paramrfs.jdField_a_of_type_Qlq.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramrfs.jdField_a_of_type_Qlq.jdField_m_of_type_Int = 2;
      paramrfs.jdField_a_of_type_Rjn.l();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Rfp.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramrfs.jdField_a_of_type_Rjn);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramrfs.jdField_a_of_type_Qlq.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Rfp.a(paramrfs);
      this.jdField_a_of_type_Rfp.c(paramrfs.jdField_a_of_type_Rjn);
      return;
    }
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_Boolean) && ((b(paramrfs) == null) || (b(paramrfs).a() == paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (b(paramrfs) == null) {
          break label484;
        }
      }
      label484:
      for (localObject = Integer.valueOf(b(paramrfs).e());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (b(paramrfs) != null) {
          b(paramrfs).l();
        }
        paramrfs.jdField_a_of_type_Qlq.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        paramrfs.jdField_a_of_type_Qlq.jdField_m_of_type_Int = 1;
        this.l = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    this.jdField_b_of_type_Rfs = null;
    d(this.jdField_a_of_type_Rfs);
    if ((this.jdField_a_of_type_Rjp != null) && (!this.jdField_a_of_type_Rjp.a()))
    {
      this.jdField_a_of_type_Rjp.a();
      return;
    }
    if (paramrfs != null) {
      paramrfs.jdField_a_of_type_Qlq.jdField_m_of_type_Int = 0;
    }
    b(paramrfs, false);
  }
  
  public void a(rft paramrft)
  {
    this.jdField_a_of_type_Rft = paramrft;
  }
  
  public void a(rfu paramrfu)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramrfu);
  }
  
  public void a(rgn paramrgn)
  {
    this.jdField_a_of_type_Rgn = paramrgn;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a()
  {
    return this.k;
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
    Object localObject;
    if ((this.jdField_a_of_type_Rfs != null) && (a() != null) && ((a().e() == 3) || (a().e() == 4)))
    {
      a().h();
      if (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz != null) {
        this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz.d(this.jdField_a_of_type_Rfs);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((rfu)((Iterator)localObject).next()).d(this.jdField_a_of_type_Rfs);
        }
      }
    }
    boolean bool;
    label210:
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    int i1;
    label313:
    int i2;
    label323:
    int i3;
    if ((h()) && (a() != null))
    {
      if (a().e() != 0L) {
        break label431;
      }
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int = this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_e_of_type_Int;
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp;
      if (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int != 0) {
        break label452;
      }
      bool = true;
      ((qlp)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp;
      ntd.a(((qlp)localObject).jdField_a_of_type_Boolean, ((qlp)localObject).jdField_d_of_type_Int, ((qlp)localObject).jdField_e_of_type_Int, ((qlp)localObject).jdField_b_of_type_Boolean, ((qlp)localObject).jdField_c_of_type_Boolean, ((qlp)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = noy.a(this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qlp)localObject).jdField_d_of_type_Int;
      i6 = ((qlp)localObject).jdField_e_of_type_Int;
      if (!((qlp)localObject).jdField_b_of_type_Boolean) {
        break label458;
      }
      i1 = 1;
      if (!((qlp)localObject).jdField_c_of_type_Boolean) {
        break label463;
      }
      i2 = 1;
      if (!oee.a(this.jdField_a_of_type_Rfs)) {
        break label468;
      }
      i3 = 20;
      label336:
      if (!((qlp)localObject).jdField_a_of_type_Boolean) {
        break label473;
      }
    }
    label431:
    label452:
    label458:
    label463:
    label468:
    label473:
    for (int i4 = 1;; i4 = 2)
    {
      JSONObject localJSONObject = noy.a(i5, i6, i1, i2, i3, i4, 0, noy.aE, 0);
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_f_of_type_Int).b(((qlp)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oee.a(this.jdField_a_of_type_Rfs);
      return;
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_d_of_type_Int = ((int)a().e());
      break;
      bool = false;
      break label210;
      i1 = 0;
      break label313;
      i2 = 0;
      break label323;
      i3 = 0;
      break label336;
    }
  }
  
  public void b(rfs paramrfs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo");
    }
    if (paramrfs == null) {}
    rjn localrjn;
    do
    {
      do
      {
        return;
        localrjn = b(paramrfs);
      } while ((localrjn != null) && (paramrfs.jdField_a_of_type_Boolean) && (localrjn.a() == paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      this.jdField_a_of_type_JavaLangString = null;
    } while (((this.jdField_a_of_type_Rjp != null) && (!this.jdField_a_of_type_Rjp.a())) || ((localrjn != null) && (!localrjn.a()) && (localrjn.e() != 6) && (localrjn.e() != 7)));
    paramrfs.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Rfs = paramrfs;
    d(this.jdField_b_of_type_Rfs);
    if (this.jdField_b_of_type_Rfs.jdField_a_of_type_Qyz != null) {
      this.jdField_b_of_type_Rfs.jdField_a_of_type_Qyz.f(this.jdField_b_of_type_Rfs);
    }
    b(paramrfs, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz != null)) {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz.c(this.jdField_a_of_type_Rfs);
    }
    if ((this.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rgn != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn != null)) {
      this.jdField_a_of_type_Rgn.a(1, this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Rfs != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Rfs);
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((rfu)localIterator.next()).a(this.jdField_a_of_type_Rfs, this.jdField_c_of_type_Boolean);
        }
      }
      c(this.jdField_a_of_type_Rfs);
    }
    if (this.jdField_a_of_type_Rfs != null) {
      this.jdField_a_of_type_Rfs = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public boolean b()
  {
    return (a() != null) && (a().e() == 5);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.5(this));
  }
  
  @Deprecated
  public void c(rfs paramrfs)
  {
    if (paramrfs != null) {
      a(paramrfs.jdField_a_of_type_Rjn);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Rfs != null) {
        a(this.jdField_a_of_type_Rfs, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz != null)) {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qyz.a(this.jdField_a_of_type_Rfs, 999, 998, null);
    }
    this.jdField_a_of_type_Rfs = null;
  }
  
  public boolean c()
  {
    return (a() != null) && (a().b());
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
      if ((a() != null) && (this.jdField_a_of_type_Rfs != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Rfs.jdField_a_of_type_Int)
    {
      a().b(i1);
      return;
    }
  }
  
  public boolean d()
  {
    return (a() != null) && (a().e() == 3);
  }
  
  public void e()
  {
    boolean bool2 = true;
    this.jdField_f_of_type_Boolean = true;
    if ((this.m) && (a() != null) && (a().e())) {
      a();
    }
    label60:
    label119:
    label122:
    for (;;)
    {
      this.k = false;
      this.m = false;
      raa localraa = raa.a();
      if (!qzy.a().c())
      {
        bool1 = bool2;
        localraa.b(bool1);
        rlt.a().a(this.jdField_a_of_type_AndroidContentContext);
        return;
        if (!this.k) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label119;
        }
      }
      for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();; bool1 = false)
      {
        if (bool1) {
          break label122;
        }
        this.l = true;
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
    if ((a() != null) && (a().a() != null)) {
      a().a().setOutputMute(paramBoolean);
    }
    if ((b(this.jdField_b_of_type_Rfs) != null) && (b(this.jdField_b_of_type_Rfs).a() != null)) {
      b(this.jdField_b_of_type_Rfs).a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return a() == 0;
  }
  
  public void f()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "doOnPause() isPlaying()=" + d());
    }
    if (d())
    {
      this.k = true;
      this.l = false;
      b();
    }
    rlt.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qzy.b(paramBoolean);
  }
  
  public boolean f()
  {
    return a() == 5;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "doOnDestory: ");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Rfs);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Rfs);
    if (this.jdField_a_of_type_Rfs != null)
    {
      if (a() != null)
      {
        a().m();
        this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn = null;
      }
      this.jdField_a_of_type_Rfs = null;
    }
    if (this.jdField_b_of_type_Rfs != null)
    {
      if (b(this.jdField_b_of_type_Rfs) != null)
      {
        b(this.jdField_b_of_type_Rfs).m();
        this.jdField_b_of_type_Rfs.jdField_a_of_type_Rjn = null;
      }
      this.jdField_b_of_type_Rfs = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        rjn localrjn = (rjn)localIterator.next();
        if ((localrjn != null) && (localrjn.e() != 8)) {
          localrjn.m();
        }
      }
    }
    if (this.jdField_a_of_type_Rjp != null)
    {
      this.jdField_a_of_type_Rjp.b();
      this.jdField_a_of_type_Rjp = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    rlb.a().b(this);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (aery.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) {
        aery.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidViewView, null);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Aesa != null) {
      this.jdField_a_of_type_Aesa = null;
    }
    this.jdField_a_of_type_Rft = null;
    this.jdField_a_of_type_Rgn = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Rfs) != null) {
      b(this.jdField_b_of_type_Rfs).d(paramBoolean);
    }
  }
  
  public boolean g()
  {
    return a() == 3;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "checkPlayStateAfterPhoneCall mIsActivityOnResume = " + this.jdField_f_of_type_Boolean);
    }
    if (!this.jdField_f_of_type_Boolean) {}
    while ((a() != 5) || (!a())) {
      return;
    }
    a(false);
    c();
  }
  
  public void h(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.n = paramBoolean;
    rjn localrjn;
    if (a() != null)
    {
      localrjn = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localrjn.d(bool1);
      if (b(this.jdField_b_of_type_Rfs) != null)
      {
        localrjn = b(this.jdField_b_of_type_Rfs);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localrjn.d(paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */