package com.tencent.biz.pubaccount.readinjoy.video;

import acwd;
import acwf;
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
import bbjw;
import bcpw;
import bhvh;
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
import nmf;
import npx;
import nyg;
import oau;
import org.json.JSONException;
import org.json.JSONObject;
import qbw;
import qbx;
import qjv;
import qku;
import qkw;
import qqk;
import qql;
import qqo;
import qqp;
import qqq;
import qri;
import qub;
import qud;
import quf;
import qvn;
import qwf;

public class VideoFeedsPlayManager
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, quf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private acwf jdField_a_of_type_Acwf;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new qqk(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TVK_NetVideoInfo a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList<qqq> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<String, qub> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private qku jdField_a_of_type_Qku;
  private qql jdField_a_of_type_Qql = new qql(this, null);
  private qqo jdField_a_of_type_Qqo;
  private qqp jdField_a_of_type_Qqp;
  private qri jdField_a_of_type_Qri;
  private qud jdField_a_of_type_Qud;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private qqo jdField_b_of_type_Qqo;
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
    this.jdField_a_of_type_Qud = new qud(paramContext.getApplicationContext());
    this.jdField_a_of_type_Qud.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    qvn.a().a(this);
    this.jdField_a_of_type_Qku = qku.a();
    if (qku.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      this.jdField_h_of_type_Boolean = bhvh.g(paramQQAppInterface);
      return;
      f(false);
    }
  }
  
  private qqo a(qqo paramqqo)
  {
    if (paramqqo == this.jdField_a_of_type_Qqo) {
      return paramqqo;
    }
    return null;
  }
  
  private qub a()
  {
    return b(this.jdField_a_of_type_Qqo);
  }
  
  private qub a(qqo paramqqo)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    paramqqo = new qub(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    paramqqo.a(this.jdField_a_of_type_Qql);
    return paramqqo;
  }
  
  private qub a(qub paramqub)
  {
    if (paramqub == a()) {
      return paramqub;
    }
    return null;
  }
  
  private void a(String paramString, String[] paramArrayOfString, int paramInt, long paramLong)
  {
    int i1 = 0;
    qqo localqqo = this.jdField_a_of_type_Qqo;
    if ((localqqo == null) || (localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {}
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
                  } while (paramLong != localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
                  if (!bbjw.a(paramString)) {
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
              bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719585, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            } while (localqqo.jdField_a_of_type_Qjv == null);
            localqqo.jdField_a_of_type_Qjv.a(localqqo, 999, 997, null);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_UNSAFE");
            }
            bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719583, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          } while (localqqo.jdField_a_of_type_Qjv == null);
          localqqo.jdField_a_of_type_Qjv.a(localqqo, 999, 997, null);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_EXPIRED");
          }
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719584, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        } while (localqqo.jdField_a_of_type_Qjv == null);
        localqqo.jdField_a_of_type_Qjv.a(localqqo, 999, 997, null);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_RECV_CANCEL");
      return;
      paramLong = localqqo.jdField_a_of_type_Long;
      paramString = ShortVideoUtils.a(localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      str = localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    } while ((this.jdField_a_of_type_Qqo == null) || (a() == null));
    a().a(paramArrayOfString, paramString, localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, str, paramLong, localqqo.jdField_a_of_type_Boolean, this);
  }
  
  private void a(qbx paramqbx)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramqbx), 16, null, true);
  }
  
  private void a(qub paramqub)
  {
    if (paramqub == null) {}
    int i1;
    do
    {
      return;
      paramqub.p();
      i1 = paramqub.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramqub.k();
    ThreadManager.excute(new VideoFeedsPlayManager.6(this, paramqub), 16, null, true);
  }
  
  private void a(boolean paramBoolean, qqo paramqqo)
  {
    Object localObject;
    if (paramqqo.jdField_a_of_type_Qbx != null)
    {
      localObject = a();
      paramqqo.jdField_a_of_type_Qbx.jdField_a_of_type_Long = ((qub)localObject).a(this.jdField_c_of_type_Boolean);
      paramqqo.jdField_a_of_type_Qbx.jdField_e_of_type_Int = ((qub)localObject).c();
      paramqqo.jdField_a_of_type_Qbx.jdField_m_of_type_Long = ((qub)localObject).c();
      paramqqo.jdField_a_of_type_Qbx.jdField_f_of_type_Int = ((qub)localObject).d();
      paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Boolean = ((qub)localObject).jdField_b_of_type_Boolean;
      paramqqo.jdField_a_of_type_Qbx.jdField_p_of_type_Long = ((qub)localObject).jdField_b_of_type_Long;
      paramqqo.jdField_a_of_type_Qbx.jdField_o_of_type_Long = ((qub)localObject).jdField_a_of_type_Long;
      paramqqo.jdField_a_of_type_Qbx.q = ((qub)localObject).f();
      paramqqo.jdField_a_of_type_Qbx.r = ((qub)localObject).i();
      paramqqo.jdField_a_of_type_Qbx.jdField_f_of_type_JavaLangString = ((qub)localObject).a();
      paramqqo.jdField_a_of_type_Qbx.t = ((qub)localObject).h();
      paramqqo.jdField_a_of_type_Qbx.u = ((qub)localObject).g();
      if ((paramqqo.jdField_a_of_type_Qbx.jdField_a_of_type_Long == 0L) && (paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Long == 0L))
      {
        paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramqqo.jdField_a_of_type_Qbx.jdField_b_of_type_Long);
        paramqqo.jdField_a_of_type_Qbx.jdField_e_of_type_Long = paramqqo.jdField_a_of_type_Qbx.jdField_c_of_type_Long;
      }
      paramqqo.jdField_a_of_type_Qbx.v = qwf.a().a();
      localObject = qwf.a().a();
      paramqqo.jdField_a_of_type_Qbx.z = localObject[0];
      paramqqo.jdField_a_of_type_Qbx.A = localObject[1];
      paramqqo.jdField_a_of_type_Qbx.x = localObject[2];
      paramqqo.jdField_a_of_type_Qbx.y = localObject[3];
      paramqqo.jdField_a_of_type_Qbx.w = localObject[4];
      a(paramqqo.jdField_a_of_type_Qbx);
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
    if ((g()) && (paramBoolean) && (!paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label597;
      }
      paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int = paramqqo.jdField_a_of_type_Qbw.jdField_e_of_type_Int;
      paramqqo.jdField_a_of_type_Qbw.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramqqo.jdField_a_of_type_Qbw;
      if (paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int != 0) {
        break label615;
      }
      paramBoolean = true;
      ((qbw)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramqqo.jdField_a_of_type_Qbw.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = paramqqo.jdField_a_of_type_Qbw;
      npx.a(((qbw)localObject).jdField_a_of_type_Boolean, ((qbw)localObject).jdField_d_of_type_Int, ((qbw)localObject).jdField_e_of_type_Int, ((qbw)localObject).jdField_b_of_type_Boolean, ((qbw)localObject).jdField_c_of_type_Boolean, ((qbw)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nmf.a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qbw)localObject).jdField_d_of_type_Int;
      i6 = ((qbw)localObject).jdField_e_of_type_Int;
      if (!((qbw)localObject).jdField_b_of_type_Boolean) {
        break label620;
      }
      i1 = 1;
      if (!((qbw)localObject).jdField_c_of_type_Boolean) {
        break label625;
      }
      i2 = 1;
      if (!oau.a(this.jdField_a_of_type_Qqo)) {
        break label631;
      }
      i3 = 20;
      label503:
      if (!((qbw)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = nmf.a(i5, i6, i1, i2, i3, i4, 0, nmf.aE, 0);
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_f_of_type_Int).b(((qbw)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oau.a(this.jdField_a_of_type_Qqo);
      return;
      paramqqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int = ((int)a().e());
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
  
  private boolean a(qqo paramqqo)
  {
    return a(paramqqo) != null;
  }
  
  private boolean a(qub paramqub)
  {
    return a(paramqub) != null;
  }
  
  private qub b(qqo paramqqo)
  {
    if (paramqqo != null) {
      return paramqqo.jdField_a_of_type_Qub;
    }
    return null;
  }
  
  private void b(qqo paramqqo, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((b(paramqqo) == null) || (b(paramqqo).a() != null))
    {
      boolean bool1 = bool2;
      if (b(paramqqo) != null)
      {
        bool1 = bool2;
        if (b(paramqqo).a() != null)
        {
          b(paramqqo).b(false);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay: videoPlayer.tag isn't null!");
          }
          bool1 = true;
        }
      }
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramqqo, bool1, paramBoolean), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    paramqqo.jdField_a_of_type_Qub.a(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    c(paramqqo, paramBoolean);
  }
  
  private void c(qqo paramqqo, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((paramqqo == null) || (b(paramqqo) == null)) {
      return;
    }
    paramqqo.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramqqo.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      localObject = b(paramqqo).b();
      if (localObject == null)
      {
        if (paramqqo.jdField_a_of_type_Qjv != null) {
          paramqqo.jdField_a_of_type_Qjv.a(paramqqo, 999, 999, null);
        }
        paramqqo.jdField_a_of_type_Qub = null;
        return;
      }
      paramqqo.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131374778);
      paramqqo.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      b(paramqqo).a((IVideoViewBase)localObject);
      if (paramqqo.jdField_a_of_type_Qjv != null) {
        paramqqo.jdField_a_of_type_Qjv.g(paramqqo);
      }
      if ((paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000) && ((localObject instanceof IVideoViewBase))) {
        ((IVideoViewBase)localObject).setFixedSize(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      b(paramqqo).b(i1);
      localObject = b(paramqqo);
      if ((!this.n) && (!this.jdField_g_of_type_Boolean)) {
        break label537;
      }
      bool1 = true;
      label281:
      ((qub)localObject).d(bool1);
      localObject = b(paramqqo);
      if ((!this.jdField_h_of_type_Boolean) || (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean)) {
        break label543;
      }
    }
    label537:
    label543:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((qub)localObject).a(bool1);
      b(paramqqo).e(paramqqo.jdField_b_of_type_Boolean);
      b(paramqqo).a().setOutputMute(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramqqo).a().getOutputMute());
      }
      paramqqo.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramqqo.jdField_a_of_type_Qbx.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramqqo.jdField_a_of_type_Qbx != null)
      {
        paramqqo.jdField_a_of_type_Qbx.n = 0;
        paramqqo.jdField_a_of_type_Qbx.jdField_o_of_type_Int = 0;
        paramqqo.jdField_a_of_type_Qbx.jdField_p_of_type_Int = 0;
        paramqqo.jdField_a_of_type_Qbx.jdField_g_of_type_Boolean = false;
        paramqqo.jdField_a_of_type_Qbx.jdField_h_of_type_Boolean = false;
        localObject = paramqqo.jdField_a_of_type_Qbx;
        bool1 = bool2;
        if (this.jdField_h_of_type_Boolean)
        {
          bool1 = bool2;
          if (!paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) {
            bool1 = true;
          }
        }
        ((qbx)localObject).jdField_i_of_type_Boolean = bool1;
      }
      ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramqqo, b(paramqqo), paramBoolean), 16, null, true);
      return;
      i1 = paramqqo.jdField_a_of_type_Int;
      break;
      bool1 = false;
      break label281;
    }
  }
  
  private void d(qqo paramqqo)
  {
    qbx localqbx;
    if (paramqqo != null)
    {
      paramqqo.jdField_a_of_type_Qbx = new qbx();
      paramqqo.jdField_a_of_type_Qbx.jdField_a_of_type_Int = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramqqo.jdField_a_of_type_Qbx.jdField_b_of_type_JavaLangString = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramqqo.jdField_a_of_type_Qbx.jdField_a_of_type_JavaLangString = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localqbx = paramqqo.jdField_a_of_type_Qbx;
      if (this.jdField_a_of_type_Int != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 5;; i1 = 2)
    {
      localqbx.jdField_c_of_type_Int = i1;
      paramqqo.jdField_a_of_type_Qbx.jdField_i_of_type_Int = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramqqo.jdField_a_of_type_Qbx.j = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramqqo.jdField_a_of_type_Qbx.s = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramqqo.jdField_a_of_type_Qbx.jdField_a_of_type_Boolean = true;
      paramqqo.jdField_a_of_type_Qbx.n = 0;
      paramqqo.jdField_a_of_type_Qbx.jdField_o_of_type_Int = 0;
      paramqqo.jdField_a_of_type_Qbx.jdField_p_of_type_Int = 0;
      paramqqo.jdField_a_of_type_Qbx.jdField_f_of_type_Boolean = false;
      paramqqo.jdField_a_of_type_Qbx.jdField_g_of_type_JavaLangString = "";
      paramqqo.jdField_a_of_type_Qbx.jdField_g_of_type_Boolean = false;
      paramqqo.jdField_a_of_type_Qbx.jdField_h_of_type_Boolean = false;
      paramqqo.jdField_a_of_type_Qbx.jdField_g_of_type_Int = paramqqo.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramqqo.jdField_a_of_type_Qbx.jdField_h_of_type_Int = paramqqo.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramqqo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramqqo.jdField_a_of_type_Qbw = new qbw();
        i1 = paramqqo.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", nmf.P);
        paramqqo.jdField_a_of_type_Qbw.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          return;
        }
        int i1 = new JSONObject(paramString).getInt("callBackType");
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "OnDownloadCallback callBackType=" + i1 + ", msg.videoFileStatus=" + this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
        }
        if ((i1 == 7) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 2003))
        {
          paramString = this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
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
    if ((this.jdField_a_of_type_Qqo != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Qqo == null) || (this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public qqo a()
  {
    return this.jdField_a_of_type_Qqo;
  }
  
  public qub a(String paramString)
  {
    return (qub)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
        String str = this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString;
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          break label191;
        }
        this.jdField_a_of_type_JavaUtilSet.add(str);
      }
    }
    label191:
    for (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_f_of_type_Int = qbw.jdField_a_of_type_Int;; this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_f_of_type_Int = qbw.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.l = this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.b();
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.k = this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.a();
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
    if ((this.jdField_a_of_type_Qqo != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv.a(this.jdField_a_of_type_Qqo, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(qqo paramqqo)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Qqo = paramqqo;
    if (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv != null) {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv.e(this.jdField_a_of_type_Qqo);
    }
  }
  
  public void a(qqo paramqqo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    Object localObject;
    if ((paramqqo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Qqo = paramqqo;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((qqq)((Iterator)localObject).next()).a(this.jdField_a_of_type_Qqo);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
        }
        return;
      }
    }
    if (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv != null) {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv.a(this.jdField_a_of_type_Qqo, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    if ((b(paramqqo) != null) && (b(paramqqo).e()) && (b(paramqqo).a() == paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramqqo.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Qqo = null;
      paramqqo.jdField_a_of_type_Qbx.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramqqo.jdField_a_of_type_Qbx.jdField_m_of_type_Int = 2;
      paramqqo.jdField_a_of_type_Qub.l();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Qql.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramqqo.jdField_a_of_type_Qub);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramqqo.jdField_a_of_type_Qbx.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Qql.a(paramqqo);
      this.jdField_a_of_type_Qql.c(paramqqo.jdField_a_of_type_Qub);
      return;
    }
    if ((paramqqo != null) && (paramqqo.jdField_a_of_type_Boolean) && ((b(paramqqo) == null) || (b(paramqqo).a() == paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (b(paramqqo) == null) {
          break label484;
        }
      }
      label484:
      for (localObject = Integer.valueOf(b(paramqqo).e());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (b(paramqqo) != null) {
          b(paramqqo).l();
        }
        paramqqo.jdField_a_of_type_Qbx.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        paramqqo.jdField_a_of_type_Qbx.jdField_m_of_type_Int = 1;
        this.l = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    this.jdField_b_of_type_Qqo = null;
    d(this.jdField_a_of_type_Qqo);
    if ((this.jdField_a_of_type_Qud != null) && (!this.jdField_a_of_type_Qud.a()))
    {
      this.jdField_a_of_type_Qud.a();
      return;
    }
    if (paramqqo != null) {
      paramqqo.jdField_a_of_type_Qbx.jdField_m_of_type_Int = 0;
    }
    b(paramqqo, false);
  }
  
  public void a(qqp paramqqp)
  {
    this.jdField_a_of_type_Qqp = paramqqp;
  }
  
  public void a(qqq paramqqq)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramqqq);
  }
  
  public void a(qri paramqri)
  {
    this.jdField_a_of_type_Qri = paramqri;
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
    if ((this.jdField_a_of_type_Qqo != null) && (a() != null) && ((a().e() == 3) || (a().e() == 4)))
    {
      a().h();
      if (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv != null) {
        this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv.d(this.jdField_a_of_type_Qqo);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((qqq)((Iterator)localObject).next()).d(this.jdField_a_of_type_Qqo);
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
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int = this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_e_of_type_Int;
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw;
      if (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int != 0) {
        break label452;
      }
      bool = true;
      ((qbw)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw;
      npx.a(((qbw)localObject).jdField_a_of_type_Boolean, ((qbw)localObject).jdField_d_of_type_Int, ((qbw)localObject).jdField_e_of_type_Int, ((qbw)localObject).jdField_b_of_type_Boolean, ((qbw)localObject).jdField_c_of_type_Boolean, ((qbw)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nmf.a(this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((qbw)localObject).jdField_d_of_type_Int;
      i6 = ((qbw)localObject).jdField_e_of_type_Int;
      if (!((qbw)localObject).jdField_b_of_type_Boolean) {
        break label458;
      }
      i1 = 1;
      if (!((qbw)localObject).jdField_c_of_type_Boolean) {
        break label463;
      }
      i2 = 1;
      if (!oau.a(this.jdField_a_of_type_Qqo)) {
        break label468;
      }
      i3 = 20;
      label336:
      if (!((qbw)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = nmf.a(i5, i6, i1, i2, i3, i4, 0, nmf.aE, 0);
      nmf.a(new nyg().a(this.jdField_a_of_type_AndroidContentContext).a(nmf.jdField_f_of_type_Int).b(((qbw)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      oau.a(this.jdField_a_of_type_Qqo);
      return;
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbw.jdField_d_of_type_Int = ((int)a().e());
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
  
  public void b(qqo paramqqo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo");
    }
    if (paramqqo == null) {}
    qub localqub;
    do
    {
      do
      {
        return;
        localqub = b(paramqqo);
      } while ((localqub != null) && (paramqqo.jdField_a_of_type_Boolean) && (localqub.a() == paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      this.jdField_a_of_type_JavaLangString = null;
    } while (((this.jdField_a_of_type_Qud != null) && (!this.jdField_a_of_type_Qud.a())) || ((localqub != null) && (!localqub.a()) && (localqub.e() != 6) && (localqub.e() != 7)));
    paramqqo.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Qqo = paramqqo;
    d(this.jdField_b_of_type_Qqo);
    if (this.jdField_b_of_type_Qqo.jdField_a_of_type_Qjv != null) {
      this.jdField_b_of_type_Qqo.jdField_a_of_type_Qjv.f(this.jdField_b_of_type_Qqo);
    }
    b(paramqqo, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv != null)) {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv.c(this.jdField_a_of_type_Qqo);
    }
    if ((this.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qri != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub != null)) {
      this.jdField_a_of_type_Qri.a(1, this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Qqo != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Qqo);
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((qqq)localIterator.next()).a(this.jdField_a_of_type_Qqo, this.jdField_c_of_type_Boolean);
        }
      }
      c(this.jdField_a_of_type_Qqo);
    }
    if (this.jdField_a_of_type_Qqo != null) {
      this.jdField_a_of_type_Qqo = null;
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
  public void c(qqo paramqqo)
  {
    if (paramqqo != null) {
      a(paramqqo.jdField_a_of_type_Qub);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Qqo != null) {
        a(this.jdField_a_of_type_Qqo, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv != null)) {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qjv.a(this.jdField_a_of_type_Qqo, 999, 998, null);
    }
    this.jdField_a_of_type_Qqo = null;
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
      if ((a() != null) && (this.jdField_a_of_type_Qqo != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Qqo.jdField_a_of_type_Int)
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
      qkw localqkw = qkw.a();
      if (!qku.a().c())
      {
        bool1 = bool2;
        localqkw.b(bool1);
        qwf.a().a(this.jdField_a_of_type_AndroidContentContext);
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
    if ((b(this.jdField_b_of_type_Qqo) != null) && (b(this.jdField_b_of_type_Qqo).a() != null)) {
      b(this.jdField_b_of_type_Qqo).a().setOutputMute(paramBoolean);
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
    qwf.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qku.b(paramBoolean);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Qqo);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Qqo);
    if (this.jdField_a_of_type_Qqo != null)
    {
      if (a() != null)
      {
        a().m();
        this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub = null;
      }
      this.jdField_a_of_type_Qqo = null;
    }
    if (this.jdField_b_of_type_Qqo != null)
    {
      if (b(this.jdField_b_of_type_Qqo) != null)
      {
        b(this.jdField_b_of_type_Qqo).m();
        this.jdField_b_of_type_Qqo.jdField_a_of_type_Qub = null;
      }
      this.jdField_b_of_type_Qqo = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        qub localqub = (qub)localIterator.next();
        if ((localqub != null) && (localqub.e() != 8)) {
          localqub.m();
        }
      }
    }
    if (this.jdField_a_of_type_Qud != null)
    {
      this.jdField_a_of_type_Qud.b();
      this.jdField_a_of_type_Qud = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    qvn.a().b(this);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) {
        acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidViewView, null);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Acwf != null) {
      this.jdField_a_of_type_Acwf = null;
    }
    this.jdField_a_of_type_Qqp = null;
    this.jdField_a_of_type_Qri = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Qqo) != null) {
      b(this.jdField_b_of_type_Qqo).d(paramBoolean);
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
    qub localqub;
    if (a() != null)
    {
      localqub = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localqub.d(bool1);
      if (b(this.jdField_b_of_type_Qqo) != null)
      {
        localqub = b(this.jdField_b_of_type_Qqo);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localqub.d(paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */