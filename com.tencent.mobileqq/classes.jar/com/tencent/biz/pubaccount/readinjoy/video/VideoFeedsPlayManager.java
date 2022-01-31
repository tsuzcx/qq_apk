package com.tencent.biz.pubaccount.readinjoy.video;

import acvz;
import acwb;
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
import bbkk;
import bcql;
import bhvy;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
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
import nmc;
import npu;
import nyd;
import oar;
import org.json.JSONException;
import org.json.JSONObject;
import qbt;
import qbu;
import qjs;
import qkr;
import qkt;
import qqh;
import qqi;
import qql;
import qqm;
import qqn;
import qrf;
import qty;
import qua;
import quc;
import qvk;
import qwc;

public class VideoFeedsPlayManager
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, quc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private acwb jdField_a_of_type_Acwb;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new qqh(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TVK_NetVideoInfo a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList<qqn> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, qty> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private qkr jdField_a_of_type_Qkr;
  private qqi jdField_a_of_type_Qqi = new qqi(this, null);
  private qql jdField_a_of_type_Qql;
  private qqm jdField_a_of_type_Qqm;
  private qrf jdField_a_of_type_Qrf;
  private qua jdField_a_of_type_Qua;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private qql jdField_b_of_type_Qql;
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
    this.jdField_a_of_type_Qua = new qua(paramContext.getApplicationContext());
    this.jdField_a_of_type_Qua.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    qvk.a().a(this);
    this.jdField_a_of_type_Qkr = qkr.a();
    if (qkr.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      this.jdField_h_of_type_Boolean = bhvy.g(paramQQAppInterface);
      return;
      f(false);
    }
  }
  
  private qql a(qql paramqql)
  {
    if (paramqql == this.jdField_a_of_type_Qql) {
      return paramqql;
    }
    return null;
  }
  
  private qty a()
  {
    return b(this.jdField_a_of_type_Qql);
  }
  
  private qty a(qql paramqql)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    paramqql = new qty(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    paramqql.a(this.jdField_a_of_type_Qqi);
    return paramqql;
  }
  
  private qty a(qty paramqty)
  {
    if (paramqty == a()) {
      return paramqty;
    }
    return null;
  }
  
  private void a(String paramString, String[] paramArrayOfString, int paramInt, long paramLong)
  {
    int i1 = 0;
    qql localqql = this.jdField_a_of_type_Qql;
    if ((localqql == null) || (localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {}
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
                  } while (paramLong != localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
                  if (!bbkk.a(paramString)) {
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
              bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719596, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            } while (localqql.jdField_a_of_type_Qjs == null);
            localqql.jdField_a_of_type_Qjs.a(localqql, 999, 997, null);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_UNSAFE");
            }
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719594, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          } while (localqql.jdField_a_of_type_Qjs == null);
          localqql.jdField_a_of_type_Qjs.a(localqql, 999, 997, null);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_EXPIRED");
          }
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719595, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        } while (localqql.jdField_a_of_type_Qjs == null);
        localqql.jdField_a_of_type_Qjs.a(localqql, 999, 997, null);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_RECV_CANCEL");
      return;
      paramLong = localqql.jdField_a_of_type_Long;
      paramString = ShortVideoUtils.a(localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      str = localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    } while ((this.jdField_a_of_type_Qql == null) || (a() == null));
    a().a(paramArrayOfString, paramString, localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, str, paramLong, localqql.jdField_a_of_type_Boolean, this);
  }
  
  private void a(qbu paramqbu)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramqbu), 16, null, true);
  }
  
  private void a(qty paramqty)
  {
    if (paramqty == null) {}
    int i1;
    do
    {
      return;
      paramqty.p();
      i1 = paramqty.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramqty.k();
    ThreadManager.excute(new VideoFeedsPlayManager.6(this, paramqty), 16, null, true);
  }
  
  private void a(boolean paramBoolean, qql paramqql)
  {
    Object localObject;
    if (paramqql.jdField_a_of_type_Qbu != null)
    {
      localObject = a();
      paramqql.jdField_a_of_type_Qbu.jdField_a_of_type_Long = ((qty)localObject).a(this.jdField_c_of_type_Boolean);
      paramqql.jdField_a_of_type_Qbu.jdField_e_of_type_Int = ((qty)localObject).c();
      paramqql.jdField_a_of_type_Qbu.jdField_m_of_type_Long = ((qty)localObject).c();
      paramqql.jdField_a_of_type_Qbu.jdField_f_of_type_Int = ((qty)localObject).d();
      paramqql.jdField_a_of_type_Qbu.jdField_c_of_type_Boolean = ((qty)localObject).jdField_b_of_type_Boolean;
      paramqql.jdField_a_of_type_Qbu.jdField_p_of_type_Long = ((qty)localObject).jdField_b_of_type_Long;
      paramqql.jdField_a_of_type_Qbu.jdField_o_of_type_Long = ((qty)localObject).jdField_a_of_type_Long;
      paramqql.jdField_a_of_type_Qbu.q = ((qty)localObject).f();
      paramqql.jdField_a_of_type_Qbu.r = ((qty)localObject).i();
      paramqql.jdField_a_of_type_Qbu.jdField_f_of_type_JavaLangString = ((qty)localObject).a();
      paramqql.jdField_a_of_type_Qbu.t = ((qty)localObject).h();
      paramqql.jdField_a_of_type_Qbu.u = ((qty)localObject).g();
      if ((paramqql.jdField_a_of_type_Qbu.jdField_a_of_type_Long == 0L) && (paramqql.jdField_a_of_type_Qbu.jdField_c_of_type_Long == 0L))
      {
        paramqql.jdField_a_of_type_Qbu.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramqql.jdField_a_of_type_Qbu.jdField_b_of_type_Long);
        paramqql.jdField_a_of_type_Qbu.jdField_e_of_type_Long = paramqql.jdField_a_of_type_Qbu.jdField_c_of_type_Long;
      }
      paramqql.jdField_a_of_type_Qbu.v = qwc.a().a();
      localObject = qwc.a().a();
      paramqql.jdField_a_of_type_Qbu.z = localObject[0];
      paramqql.jdField_a_of_type_Qbu.A = localObject[1];
      paramqql.jdField_a_of_type_Qbu.x = localObject[2];
      paramqql.jdField_a_of_type_Qbu.y = localObject[3];
      paramqql.jdField_a_of_type_Qbu.w = localObject[4];
      a(paramqql.jdField_a_of_type_Qbu);
    }
    label385:
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    int i1;
    label478:
    int i2;
    label489:
    int i3;
    if ((g()) && (paramBoolean) && (!paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label597;
      }
      paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Int = paramqql.jdField_a_of_type_Qbt.jdField_e_of_type_Int;
      paramqql.jdField_a_of_type_Qbt.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramqql.jdField_a_of_type_Qbt;
      if (paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Int != 0) {
        break label615;
      }
      paramBoolean = true;
      ((qbt)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramqql.jdField_a_of_type_Qbt.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = paramqql.jdField_a_of_type_Qbt;
      npu.a(((qbt)localObject).jdField_a_of_type_Boolean, ((qbt)localObject).jdField_d_of_type_Int, ((qbt)localObject).jdField_e_of_type_Int, ((qbt)localObject).jdField_b_of_type_Boolean, ((qbt)localObject).jdField_c_of_type_Boolean, ((qbt)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nmc.a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qbt)localObject).jdField_d_of_type_Int;
      i6 = ((qbt)localObject).jdField_e_of_type_Int;
      if (!((qbt)localObject).jdField_b_of_type_Boolean) {
        break label620;
      }
      i1 = 1;
      if (!((qbt)localObject).jdField_c_of_type_Boolean) {
        break label625;
      }
      i2 = 1;
      if (!oar.a(this.jdField_a_of_type_Qql)) {
        break label631;
      }
      i3 = 20;
      label503:
      if (!((qbt)localObject).jdField_a_of_type_Boolean) {
        break label637;
      }
    }
    label597:
    label615:
    label620:
    label625:
    label631:
    label637:
    for (int i4 = 1;; i4 = 2)
    {
      JSONObject localJSONObject = nmc.a(i5, i6, i1, i2, i3, i4, 0, nmc.aE, 0);
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_f_of_type_Int).b(((qbt)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oar.a(this.jdField_a_of_type_Qql);
      return;
      paramqql.jdField_a_of_type_Qbt.jdField_d_of_type_Int = ((int)a().e());
      break;
      paramBoolean = false;
      break label385;
      i1 = 0;
      break label478;
      i2 = 0;
      break label489;
      i3 = 0;
      break label503;
    }
  }
  
  private boolean a(qql paramqql)
  {
    return a(paramqql) != null;
  }
  
  private boolean a(qty paramqty)
  {
    return a(paramqty) != null;
  }
  
  private qty b(qql paramqql)
  {
    if (paramqql != null) {
      return paramqql.jdField_a_of_type_Qty;
    }
    return null;
  }
  
  private void b(qql paramqql, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((b(paramqql) == null) || (b(paramqql).a() != null))
    {
      boolean bool1 = bool2;
      if (b(paramqql) != null)
      {
        bool1 = bool2;
        if (b(paramqql).a() != null)
        {
          b(paramqql).b(false);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay: videoPlayer.tag isn't null!");
          }
          bool1 = true;
        }
      }
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramqql, bool1, paramBoolean), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    paramqql.jdField_a_of_type_Qty.a(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    c(paramqql, paramBoolean);
  }
  
  private void c(qql paramqql, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((paramqql == null) || (b(paramqql) == null)) {
      return;
    }
    paramqql.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramqql.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      localObject = b(paramqql).b();
      if (localObject == null)
      {
        if (paramqql.jdField_a_of_type_Qjs != null) {
          paramqql.jdField_a_of_type_Qjs.a(paramqql, 999, 999, null);
        }
        paramqql.jdField_a_of_type_Qty = null;
        return;
      }
      paramqql.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131374780);
      paramqql.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      b(paramqql).a((IVideoViewBase)localObject);
      if (paramqql.jdField_a_of_type_Qjs != null) {
        paramqql.jdField_a_of_type_Qjs.g(paramqql);
      }
      if ((paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000) && ((localObject instanceof IVideoViewBase))) {
        ((IVideoViewBase)localObject).setFixedSize(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      b(paramqql).b(i1);
      localObject = b(paramqql);
      if ((!this.n) && (!this.jdField_g_of_type_Boolean)) {
        break label537;
      }
      bool1 = true;
      label281:
      ((qty)localObject).d(bool1);
      localObject = b(paramqql);
      if ((!this.jdField_h_of_type_Boolean) || (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean)) {
        break label543;
      }
    }
    label537:
    label543:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((qty)localObject).a(bool1);
      b(paramqql).e(paramqql.jdField_b_of_type_Boolean);
      b(paramqql).a().setOutputMute(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramqql).a().getOutputMute());
      }
      paramqql.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramqql.jdField_a_of_type_Qbu.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramqql.jdField_a_of_type_Qbu != null)
      {
        paramqql.jdField_a_of_type_Qbu.n = 0;
        paramqql.jdField_a_of_type_Qbu.jdField_o_of_type_Int = 0;
        paramqql.jdField_a_of_type_Qbu.jdField_p_of_type_Int = 0;
        paramqql.jdField_a_of_type_Qbu.jdField_g_of_type_Boolean = false;
        paramqql.jdField_a_of_type_Qbu.jdField_h_of_type_Boolean = false;
        localObject = paramqql.jdField_a_of_type_Qbu;
        bool1 = bool2;
        if (this.jdField_h_of_type_Boolean)
        {
          bool1 = bool2;
          if (!paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) {
            bool1 = true;
          }
        }
        ((qbu)localObject).jdField_i_of_type_Boolean = bool1;
      }
      ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramqql, b(paramqql), paramBoolean), 16, null, true);
      return;
      i1 = paramqql.jdField_a_of_type_Int;
      break;
      bool1 = false;
      break label281;
    }
  }
  
  private void d(qql paramqql)
  {
    qbu localqbu;
    if (paramqql != null)
    {
      paramqql.jdField_a_of_type_Qbu = new qbu();
      paramqql.jdField_a_of_type_Qbu.jdField_a_of_type_Int = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramqql.jdField_a_of_type_Qbu.jdField_b_of_type_JavaLangString = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramqql.jdField_a_of_type_Qbu.jdField_a_of_type_JavaLangString = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localqbu = paramqql.jdField_a_of_type_Qbu;
      if (this.jdField_a_of_type_Int != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 5;; i1 = 2)
    {
      localqbu.jdField_c_of_type_Int = i1;
      paramqql.jdField_a_of_type_Qbu.jdField_i_of_type_Int = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramqql.jdField_a_of_type_Qbu.j = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramqql.jdField_a_of_type_Qbu.s = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramqql.jdField_a_of_type_Qbu.jdField_a_of_type_Boolean = true;
      paramqql.jdField_a_of_type_Qbu.n = 0;
      paramqql.jdField_a_of_type_Qbu.jdField_o_of_type_Int = 0;
      paramqql.jdField_a_of_type_Qbu.jdField_p_of_type_Int = 0;
      paramqql.jdField_a_of_type_Qbu.jdField_f_of_type_Boolean = false;
      paramqql.jdField_a_of_type_Qbu.jdField_g_of_type_JavaLangString = "";
      paramqql.jdField_a_of_type_Qbu.jdField_g_of_type_Boolean = false;
      paramqql.jdField_a_of_type_Qbu.jdField_h_of_type_Boolean = false;
      paramqql.jdField_a_of_type_Qbu.jdField_g_of_type_Int = paramqql.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramqql.jdField_a_of_type_Qbu.jdField_h_of_type_Int = paramqql.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramqql != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramqql.jdField_a_of_type_Qbt = new qbt();
        i1 = paramqql.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", nmc.P);
        paramqql.jdField_a_of_type_Qbt.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt != null) && (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          return;
        }
        int i1 = new JSONObject(paramString).getInt("callBackType");
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "OnDownloadCallback callBackType=" + i1 + ", msg.videoFileStatus=" + this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
        }
        if ((i1 == 7) && (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 2003))
        {
          paramString = this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
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
    if ((this.jdField_a_of_type_Qql != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Qql == null) || (this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public qql a()
  {
    return this.jdField_a_of_type_Qql;
  }
  
  public qty a(String paramString)
  {
    return (qty)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      if (g())
      {
        String str = this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString;
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          break label191;
        }
        this.jdField_a_of_type_JavaUtilSet.add(str);
      }
    }
    label191:
    for (this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_f_of_type_Int = qbt.jdField_a_of_type_Int;; this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_f_of_type_Int = qbt.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.l = this.jdField_a_of_type_Qql.jdField_a_of_type_Qty.b();
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.k = this.jdField_a_of_type_Qql.jdField_a_of_type_Qty.a();
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
    if ((this.jdField_a_of_type_Qql != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs.a(this.jdField_a_of_type_Qql, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(qql paramqql)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Qql = paramqql;
    if (this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs != null) {
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs.e(this.jdField_a_of_type_Qql);
    }
  }
  
  public void a(qql paramqql, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    Object localObject;
    if ((paramqql != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Qql = paramqql;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((qqn)((Iterator)localObject).next()).a(this.jdField_a_of_type_Qql);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
        }
        return;
      }
    }
    if (this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs != null) {
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs.a(this.jdField_a_of_type_Qql, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    if ((b(paramqql) != null) && (b(paramqql).e()) && (b(paramqql).a() == paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramqql.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Qql = null;
      paramqql.jdField_a_of_type_Qbu.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramqql.jdField_a_of_type_Qbu.jdField_m_of_type_Int = 2;
      paramqql.jdField_a_of_type_Qty.l();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Qqi.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramqql.jdField_a_of_type_Qty);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramqql.jdField_a_of_type_Qbu.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Qqi.a(paramqql);
      this.jdField_a_of_type_Qqi.c(paramqql.jdField_a_of_type_Qty);
      return;
    }
    if ((paramqql != null) && (paramqql.jdField_a_of_type_Boolean) && ((b(paramqql) == null) || (b(paramqql).a() == paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (b(paramqql) == null) {
          break label484;
        }
      }
      label484:
      for (localObject = Integer.valueOf(b(paramqql).e());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (b(paramqql) != null) {
          b(paramqql).l();
        }
        paramqql.jdField_a_of_type_Qbu.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        paramqql.jdField_a_of_type_Qbu.jdField_m_of_type_Int = 1;
        this.l = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    this.jdField_b_of_type_Qql = null;
    d(this.jdField_a_of_type_Qql);
    if ((this.jdField_a_of_type_Qua != null) && (!this.jdField_a_of_type_Qua.a()))
    {
      this.jdField_a_of_type_Qua.a();
      return;
    }
    if (paramqql != null) {
      paramqql.jdField_a_of_type_Qbu.jdField_m_of_type_Int = 0;
    }
    b(paramqql, false);
  }
  
  public void a(qqm paramqqm)
  {
    this.jdField_a_of_type_Qqm = paramqqm;
  }
  
  public void a(qqn paramqqn)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramqqn);
  }
  
  public void a(qrf paramqrf)
  {
    this.jdField_a_of_type_Qrf = paramqrf;
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
    if ((this.jdField_a_of_type_Qql != null) && (a() != null) && ((a().e() == 3) || (a().e() == 4)))
    {
      a().h();
      if (this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs != null) {
        this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs.d(this.jdField_a_of_type_Qql);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((qqn)((Iterator)localObject).next()).d(this.jdField_a_of_type_Qql);
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
    if ((g()) && (a() != null))
    {
      if (a().e() != 0L) {
        break label431;
      }
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_d_of_type_Int = this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_e_of_type_Int;
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt;
      if (this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_d_of_type_Int != 0) {
        break label452;
      }
      bool = true;
      ((qbt)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt;
      npu.a(((qbt)localObject).jdField_a_of_type_Boolean, ((qbt)localObject).jdField_d_of_type_Int, ((qbt)localObject).jdField_e_of_type_Int, ((qbt)localObject).jdField_b_of_type_Boolean, ((qbt)localObject).jdField_c_of_type_Boolean, ((qbt)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nmc.a(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qbt)localObject).jdField_d_of_type_Int;
      i6 = ((qbt)localObject).jdField_e_of_type_Int;
      if (!((qbt)localObject).jdField_b_of_type_Boolean) {
        break label458;
      }
      i1 = 1;
      if (!((qbt)localObject).jdField_c_of_type_Boolean) {
        break label463;
      }
      i2 = 1;
      if (!oar.a(this.jdField_a_of_type_Qql)) {
        break label468;
      }
      i3 = 20;
      label336:
      if (!((qbt)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = nmc.a(i5, i6, i1, i2, i3, i4, 0, nmc.aE, 0);
      nmc.a(new nyd().a(this.jdField_a_of_type_AndroidContentContext).a(nmc.jdField_f_of_type_Int).b(((qbt)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oar.a(this.jdField_a_of_type_Qql);
      return;
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qbt.jdField_d_of_type_Int = ((int)a().e());
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
  
  public void b(qql paramqql)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo");
    }
    if (paramqql == null) {}
    qty localqty;
    do
    {
      do
      {
        return;
        localqty = b(paramqql);
      } while ((localqty != null) && (paramqql.jdField_a_of_type_Boolean) && (localqty.a() == paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      this.jdField_a_of_type_JavaLangString = null;
    } while (((this.jdField_a_of_type_Qua != null) && (!this.jdField_a_of_type_Qua.a())) || ((localqty != null) && (!localqty.a()) && (localqty.e() != 6) && (localqty.e() != 7)));
    paramqql.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Qql = paramqql;
    d(this.jdField_b_of_type_Qql);
    if (this.jdField_b_of_type_Qql.jdField_a_of_type_Qjs != null) {
      this.jdField_b_of_type_Qql.jdField_a_of_type_Qjs.f(this.jdField_b_of_type_Qql);
    }
    b(paramqql, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs != null)) {
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs.c(this.jdField_a_of_type_Qql);
    }
    if ((this.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qrf != null) && (this.jdField_a_of_type_Qql.jdField_a_of_type_Qty != null)) {
      this.jdField_a_of_type_Qrf.a(1, this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Qql.jdField_a_of_type_Qty.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Qql != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Qql);
      this.jdField_a_of_type_Qql.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((qqn)localIterator.next()).a(this.jdField_a_of_type_Qql, this.jdField_c_of_type_Boolean);
        }
      }
      c(this.jdField_a_of_type_Qql);
    }
    if (this.jdField_a_of_type_Qql != null) {
      this.jdField_a_of_type_Qql = null;
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
  public void c(qql paramqql)
  {
    if (paramqql != null) {
      a(paramqql.jdField_a_of_type_Qty);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Qql != null) {
        a(this.jdField_a_of_type_Qql, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs != null)) {
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qjs.a(this.jdField_a_of_type_Qql, 999, 998, null);
    }
    this.jdField_a_of_type_Qql = null;
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
      if ((a() != null) && (this.jdField_a_of_type_Qql != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Qql.jdField_a_of_type_Int)
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
      qkt localqkt = qkt.a();
      if (!qkr.a().c())
      {
        bool1 = bool2;
        localqkt.b(bool1);
        qwc.a().a(this.jdField_a_of_type_AndroidContentContext);
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
    if ((b(this.jdField_b_of_type_Qql) != null) && (b(this.jdField_b_of_type_Qql).a() != null)) {
      b(this.jdField_b_of_type_Qql).a().setOutputMute(paramBoolean);
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
    qwc.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qkr.b(paramBoolean);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Qql);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Qql);
    if (this.jdField_a_of_type_Qql != null)
    {
      if (a() != null)
      {
        a().m();
        this.jdField_a_of_type_Qql.jdField_a_of_type_Qty = null;
      }
      this.jdField_a_of_type_Qql = null;
    }
    if (this.jdField_b_of_type_Qql != null)
    {
      if (b(this.jdField_b_of_type_Qql) != null)
      {
        b(this.jdField_b_of_type_Qql).m();
        this.jdField_b_of_type_Qql.jdField_a_of_type_Qty = null;
      }
      this.jdField_b_of_type_Qql = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        qty localqty = (qty)localIterator.next();
        if ((localqty != null) && (localqty.e() != 8)) {
          localqty.m();
        }
      }
    }
    if (this.jdField_a_of_type_Qua != null)
    {
      this.jdField_a_of_type_Qua.b();
      this.jdField_a_of_type_Qua = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    qvk.a().b(this);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) {
        acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidViewView, null);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Acwb != null) {
      this.jdField_a_of_type_Acwb = null;
    }
    this.jdField_a_of_type_Qqm = null;
    this.jdField_a_of_type_Qrf = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Qql) != null) {
      b(this.jdField_b_of_type_Qql).d(paramBoolean);
    }
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
    qty localqty;
    if (a() != null)
    {
      localqty = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localqty.d(bool1);
      if (b(this.jdField_b_of_type_Qql) != null)
      {
        localqty = b(this.jdField_b_of_type_Qql);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localqty.d(paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */