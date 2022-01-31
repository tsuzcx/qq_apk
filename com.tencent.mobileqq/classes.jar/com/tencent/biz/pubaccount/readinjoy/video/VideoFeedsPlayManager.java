package com.tencent.biz.pubaccount.readinjoy.video;

import aclk;
import aclm;
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
import baip;
import bbmy;
import bgmq;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import nbe;
import new;
import nmv;
import npj;
import org.json.JSONException;
import org.json.JSONObject;
import pqa;
import pqb;
import pxw;
import pyu;
import pyw;
import qem;
import qen;
import qeq;
import qer;
import qes;
import qfk;
import qhw;
import qhy;
import qia;
import qji;
import qka;

public class VideoFeedsPlayManager
  implements TVK_IMediaPlayer.OnDownloadCallbackListener, qia
{
  private int jdField_a_of_type_Int;
  private aclm jdField_a_of_type_Aclm;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new qem(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TVK_NetVideoInfo a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private ArrayList<qes> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<qhw, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private pyu jdField_a_of_type_Pyu;
  private qen jdField_a_of_type_Qen = new qen(this, null);
  private qeq jdField_a_of_type_Qeq;
  private qer jdField_a_of_type_Qer;
  private qfk jdField_a_of_type_Qfk;
  private qhy jdField_a_of_type_Qhy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private qeq jdField_b_of_type_Qeq;
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
    this.jdField_a_of_type_Qhy = new qhy(paramContext.getApplicationContext());
    this.jdField_a_of_type_Qhy.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    qji.a().a(this);
    this.jdField_a_of_type_Pyu = pyu.a();
    if (pyu.a(this.jdField_a_of_type_AndroidContentContext)) {
      f(true);
    }
    for (;;)
    {
      this.jdField_h_of_type_Boolean = bgmq.g(paramQQAppInterface);
      return;
      f(false);
    }
  }
  
  private qeq a(qeq paramqeq)
  {
    if (paramqeq == this.jdField_a_of_type_Qeq) {
      return paramqeq;
    }
    return null;
  }
  
  private qhw a()
  {
    return b(this.jdField_a_of_type_Qeq);
  }
  
  private qhw a(qeq paramqeq)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    paramqeq = new qhw(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    paramqeq.a(this.jdField_a_of_type_Qen);
    return paramqeq;
  }
  
  private qhw a(qhw paramqhw)
  {
    if (paramqhw == a()) {
      return paramqhw;
    }
    return null;
  }
  
  private void a(String paramString, String[] paramArrayOfString, int paramInt, long paramLong)
  {
    int i1 = 0;
    qeq localqeq = this.jdField_a_of_type_Qeq;
    if ((localqeq == null) || (localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {}
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
                  } while (paramLong != localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
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
                  if (!baip.a(paramString)) {
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
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653701, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            } while (localqeq.jdField_a_of_type_Pxw == null);
            localqeq.jdField_a_of_type_Pxw.a(localqeq, 999, 997, null);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_UNSAFE");
            }
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653699, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          } while (localqeq.jdField_a_of_type_Pxw == null);
          localqeq.jdField_a_of_type_Pxw.a(localqeq, 999, 997, null);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_FILE_EXPIRED");
          }
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653700, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        } while (localqeq.jdField_a_of_type_Pxw == null);
        localqeq.jdField_a_of_type_Pxw.a(localqeq, 999, 997, null);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "handleMessage FileMsg.STATUS_RECV_CANCEL");
      return;
      paramLong = localqeq.jdField_a_of_type_Long;
      paramString = ShortVideoUtils.a(localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      str = localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    } while ((this.jdField_a_of_type_Qeq == null) || (a() == null));
    a().a(paramArrayOfString, paramString, localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, str, paramLong, localqeq.jdField_a_of_type_Boolean, this);
  }
  
  private void a(pqb parampqb)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, parampqb), 16, null, true);
  }
  
  private void a(qhw paramqhw)
  {
    if (paramqhw == null) {}
    int i1;
    do
    {
      return;
      paramqhw.p();
      i1 = paramqhw.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramqhw.k();
    ThreadManager.excute(new VideoFeedsPlayManager.6(this, paramqhw), 16, null, true);
  }
  
  private void a(boolean paramBoolean, qeq paramqeq)
  {
    Object localObject;
    if (paramqeq.jdField_a_of_type_Pqb != null)
    {
      localObject = a();
      paramqeq.jdField_a_of_type_Pqb.jdField_a_of_type_Long = ((qhw)localObject).a(this.jdField_c_of_type_Boolean);
      paramqeq.jdField_a_of_type_Pqb.jdField_e_of_type_Int = ((qhw)localObject).c();
      paramqeq.jdField_a_of_type_Pqb.jdField_m_of_type_Long = ((qhw)localObject).c();
      paramqeq.jdField_a_of_type_Pqb.jdField_f_of_type_Int = ((qhw)localObject).d();
      paramqeq.jdField_a_of_type_Pqb.jdField_c_of_type_Boolean = ((qhw)localObject).jdField_b_of_type_Boolean;
      paramqeq.jdField_a_of_type_Pqb.jdField_p_of_type_Long = ((qhw)localObject).jdField_b_of_type_Long;
      paramqeq.jdField_a_of_type_Pqb.jdField_o_of_type_Long = ((qhw)localObject).jdField_a_of_type_Long;
      paramqeq.jdField_a_of_type_Pqb.q = ((qhw)localObject).e();
      paramqeq.jdField_a_of_type_Pqb.r = ((qhw)localObject).h();
      paramqeq.jdField_a_of_type_Pqb.jdField_f_of_type_JavaLangString = ((qhw)localObject).a();
      paramqeq.jdField_a_of_type_Pqb.t = ((qhw)localObject).g();
      paramqeq.jdField_a_of_type_Pqb.u = ((qhw)localObject).f();
      if ((paramqeq.jdField_a_of_type_Pqb.jdField_a_of_type_Long == 0L) && (paramqeq.jdField_a_of_type_Pqb.jdField_c_of_type_Long == 0L))
      {
        paramqeq.jdField_a_of_type_Pqb.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - paramqeq.jdField_a_of_type_Pqb.jdField_b_of_type_Long);
        paramqeq.jdField_a_of_type_Pqb.jdField_e_of_type_Long = paramqeq.jdField_a_of_type_Pqb.jdField_c_of_type_Long;
      }
      paramqeq.jdField_a_of_type_Pqb.v = qka.a().a();
      localObject = qka.a().a();
      paramqeq.jdField_a_of_type_Pqb.z = localObject[0];
      paramqeq.jdField_a_of_type_Pqb.A = localObject[1];
      paramqeq.jdField_a_of_type_Pqb.x = localObject[2];
      paramqeq.jdField_a_of_type_Pqb.y = localObject[3];
      paramqeq.jdField_a_of_type_Pqb.w = localObject[4];
      a(paramqeq.jdField_a_of_type_Pqb);
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
    if ((f()) && (paramBoolean) && (!paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Boolean))
    {
      if (a().d() != 0L) {
        break label597;
      }
      paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int = paramqeq.jdField_a_of_type_Pqa.jdField_e_of_type_Int;
      paramqeq.jdField_a_of_type_Pqa.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = paramqeq.jdField_a_of_type_Pqa;
      if (paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int != 0) {
        break label615;
      }
      paramBoolean = true;
      ((pqa)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramqeq.jdField_a_of_type_Pqa.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = paramqeq.jdField_a_of_type_Pqa;
      new.a(((pqa)localObject).jdField_a_of_type_Boolean, ((pqa)localObject).jdField_d_of_type_Int, ((pqa)localObject).jdField_e_of_type_Int, ((pqa)localObject).jdField_b_of_type_Boolean, ((pqa)localObject).jdField_c_of_type_Boolean, ((pqa)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nbe.a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((pqa)localObject).jdField_d_of_type_Int;
      i6 = ((pqa)localObject).jdField_e_of_type_Int;
      if (!((pqa)localObject).jdField_b_of_type_Boolean) {
        break label620;
      }
      i1 = 1;
      if (!((pqa)localObject).jdField_c_of_type_Boolean) {
        break label625;
      }
      i2 = 1;
      if (!npj.a(this.jdField_a_of_type_Qeq)) {
        break label631;
      }
      i3 = 20;
      label503:
      if (!((pqa)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = nbe.a(i5, i6, i1, i2, i3, i4, 0, nbe.aD, 0);
      nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_f_of_type_Int).b(((pqa)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      npj.a(this.jdField_a_of_type_Qeq);
      return;
      paramqeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int = ((int)a().d());
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
  
  private boolean a(qeq paramqeq)
  {
    return a(paramqeq) != null;
  }
  
  private boolean a(qhw paramqhw)
  {
    return a(paramqhw) != null;
  }
  
  private qhw b(qeq paramqeq)
  {
    if (paramqeq != null) {
      return paramqeq.jdField_a_of_type_Qhw;
    }
    return null;
  }
  
  private void b(qeq paramqeq, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((b(paramqeq) == null) || (b(paramqeq).a() != null))
    {
      boolean bool1 = bool2;
      if (b(paramqeq) != null)
      {
        bool1 = bool2;
        if (b(paramqeq).a() != null)
        {
          b(paramqeq).b(false);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay: videoPlayer.tag isn't null!");
          }
          bool1 = true;
        }
      }
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramqeq, bool1, paramBoolean), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    paramqeq.jdField_a_of_type_Qhw.a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    c(paramqeq, paramBoolean);
  }
  
  private void c(qeq paramqeq, boolean paramBoolean)
  {
    boolean bool2 = false;
    if ((paramqeq == null) || (b(paramqeq) == null)) {
      return;
    }
    paramqeq.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramqeq.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      localObject = b(paramqeq).b();
      if (localObject == null)
      {
        if (paramqeq.jdField_a_of_type_Pxw != null) {
          paramqeq.jdField_a_of_type_Pxw.a(paramqeq, 999, 999, null);
        }
        paramqeq.jdField_a_of_type_Qhw = null;
        return;
      }
      paramqeq.jdField_a_of_type_AndroidViewView = ((View)localObject);
      ((View)localObject).setId(2131309037);
      paramqeq.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      b(paramqeq).a((IVideoViewBase)localObject);
      if (paramqeq.jdField_a_of_type_Pxw != null) {
        paramqeq.jdField_a_of_type_Pxw.g(paramqeq);
      }
      if ((paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000) && ((localObject instanceof IVideoViewBase))) {
        ((IVideoViewBase)localObject).setFixedSize(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      b(paramqeq).b(i1);
      localObject = b(paramqeq);
      if ((!this.n) && (!this.jdField_g_of_type_Boolean)) {
        break label537;
      }
      bool1 = true;
      label281:
      ((qhw)localObject).d(bool1);
      localObject = b(paramqeq);
      if ((!this.jdField_h_of_type_Boolean) || (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean)) {
        break label543;
      }
    }
    label537:
    label543:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((qhw)localObject).a(bool1);
      b(paramqeq).e(paramqeq.jdField_b_of_type_Boolean);
      b(paramqeq).a().setOutputMute(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramqeq).a().getOutputMute());
      }
      paramqeq.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramqeq.jdField_a_of_type_Pqb.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramqeq.jdField_a_of_type_Pqb != null)
      {
        paramqeq.jdField_a_of_type_Pqb.n = 0;
        paramqeq.jdField_a_of_type_Pqb.jdField_o_of_type_Int = 0;
        paramqeq.jdField_a_of_type_Pqb.jdField_p_of_type_Int = 0;
        paramqeq.jdField_a_of_type_Pqb.jdField_g_of_type_Boolean = false;
        paramqeq.jdField_a_of_type_Pqb.jdField_h_of_type_Boolean = false;
        localObject = paramqeq.jdField_a_of_type_Pqb;
        bool1 = bool2;
        if (this.jdField_h_of_type_Boolean)
        {
          bool1 = bool2;
          if (!paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) {
            bool1 = true;
          }
        }
        ((pqb)localObject).jdField_i_of_type_Boolean = bool1;
      }
      ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramqeq, b(paramqeq), paramBoolean), 16, null, true);
      return;
      i1 = paramqeq.jdField_a_of_type_Int;
      break;
      bool1 = false;
      break label281;
    }
  }
  
  private void d(qeq paramqeq)
  {
    pqb localpqb;
    if (paramqeq != null)
    {
      paramqeq.jdField_a_of_type_Pqb = new pqb();
      paramqeq.jdField_a_of_type_Pqb.jdField_a_of_type_Int = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramqeq.jdField_a_of_type_Pqb.jdField_b_of_type_JavaLangString = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramqeq.jdField_a_of_type_Pqb.jdField_a_of_type_JavaLangString = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localpqb = paramqeq.jdField_a_of_type_Pqb;
      if (this.jdField_a_of_type_Int != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 5;; i1 = 2)
    {
      localpqb.jdField_c_of_type_Int = i1;
      paramqeq.jdField_a_of_type_Pqb.jdField_i_of_type_Int = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramqeq.jdField_a_of_type_Pqb.j = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramqeq.jdField_a_of_type_Pqb.s = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramqeq.jdField_a_of_type_Pqb.jdField_a_of_type_Boolean = true;
      paramqeq.jdField_a_of_type_Pqb.n = 0;
      paramqeq.jdField_a_of_type_Pqb.jdField_o_of_type_Int = 0;
      paramqeq.jdField_a_of_type_Pqb.jdField_p_of_type_Int = 0;
      paramqeq.jdField_a_of_type_Pqb.jdField_f_of_type_Boolean = false;
      paramqeq.jdField_a_of_type_Pqb.jdField_g_of_type_JavaLangString = "";
      paramqeq.jdField_a_of_type_Pqb.jdField_g_of_type_Boolean = false;
      paramqeq.jdField_a_of_type_Pqb.jdField_h_of_type_Boolean = false;
      paramqeq.jdField_a_of_type_Pqb.jdField_g_of_type_Int = paramqeq.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramqeq.jdField_a_of_type_Pqb.jdField_h_of_type_Int = paramqeq.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramqeq != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramqeq.jdField_a_of_type_Pqa = new pqa();
        i1 = paramqeq.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", nbe.P);
        paramqeq.jdField_a_of_type_Pqa.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private boolean f()
  {
    return (this.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa != null) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)
      {
        if (this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          return;
        }
        int i1 = new JSONObject(paramString).getInt("callBackType");
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "OnDownloadCallback callBackType=" + i1 + ", msg.videoFileStatus=" + this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
        }
        if ((i1 == 7) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus != 2003))
        {
          paramString = this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
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
    if ((this.jdField_a_of_type_Qeq != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_Qeq == null) || (this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public qeq a()
  {
    return this.jdField_a_of_type_Qeq;
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
      if (f())
      {
        String str = this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_h_of_type_JavaLangString;
        if (this.jdField_a_of_type_JavaUtilSet.contains(str)) {
          break label191;
        }
        this.jdField_a_of_type_JavaUtilSet.add(str);
      }
    }
    label191:
    for (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_f_of_type_Int = pqa.jdField_a_of_type_Int;; this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_f_of_type_Int = pqa.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.l = this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.b();
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.k = this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.a();
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
    if ((this.jdField_a_of_type_Qeq != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw.a(this.jdField_a_of_type_Qeq, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(qeq paramqeq)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Qeq = paramqeq;
    if (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw != null) {
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw.e(this.jdField_a_of_type_Qeq);
    }
  }
  
  public void a(qeq paramqeq, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    Object localObject;
    if ((paramqeq != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Qeq = paramqeq;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((qes)((Iterator)localObject).next()).a(this.jdField_a_of_type_Qeq);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
        }
        return;
      }
    }
    if (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw != null) {
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw.a(this.jdField_a_of_type_Qeq, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    if ((b(paramqeq) != null) && (b(paramqeq).d()) && (b(paramqeq).a() == paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramqeq.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Qeq = null;
      paramqeq.jdField_a_of_type_Pqb.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramqeq.jdField_a_of_type_Pqb.jdField_m_of_type_Int = 2;
      paramqeq.jdField_a_of_type_Qhw.l();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Qen.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramqeq.jdField_a_of_type_Qhw);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramqeq.jdField_a_of_type_Pqb.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Qen.a(paramqeq);
      this.jdField_a_of_type_Qen.c(paramqeq.jdField_a_of_type_Qhw);
      return;
    }
    if ((paramqeq != null) && (paramqeq.jdField_a_of_type_Boolean) && ((b(paramqeq) == null) || (b(paramqeq).a() == paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        if (b(paramqeq) == null) {
          break label484;
        }
      }
      label484:
      for (localObject = Integer.valueOf(b(paramqeq).e());; localObject = null)
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, localObject);
        if (b(paramqeq) != null) {
          b(paramqeq).l();
        }
        paramqeq.jdField_a_of_type_Pqb.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        paramqeq.jdField_a_of_type_Pqb.jdField_m_of_type_Int = 1;
        this.l = true;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
        return;
      }
    }
    this.jdField_b_of_type_Qeq = null;
    d(this.jdField_a_of_type_Qeq);
    if ((this.jdField_a_of_type_Qhy != null) && (!this.jdField_a_of_type_Qhy.a()))
    {
      this.jdField_a_of_type_Qhy.a();
      return;
    }
    if (paramqeq != null) {
      paramqeq.jdField_a_of_type_Pqb.jdField_m_of_type_Int = 0;
    }
    b(paramqeq, false);
  }
  
  public void a(qer paramqer)
  {
    this.jdField_a_of_type_Qer = paramqer;
  }
  
  public void a(qes paramqes)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramqes);
  }
  
  public void a(qfk paramqfk)
  {
    this.jdField_a_of_type_Qfk = paramqfk;
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
    if ((this.jdField_a_of_type_Qeq != null) && (a() != null) && ((a().e() == 3) || (a().e() == 4)))
    {
      a().h();
      if (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw != null) {
        this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw.d(this.jdField_a_of_type_Qeq);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((qes)((Iterator)localObject).next()).d(this.jdField_a_of_type_Qeq);
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
    if ((f()) && (a() != null))
    {
      if (a().d() != 0L) {
        break label431;
      }
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int = this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_e_of_type_Int;
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_e_of_type_Int = ((int)a().b(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa;
      if (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int != 0) {
        break label452;
      }
      bool = true;
      ((pqa)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localObject = this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa;
      new.a(((pqa)localObject).jdField_a_of_type_Boolean, ((pqa)localObject).jdField_d_of_type_Int, ((pqa)localObject).jdField_e_of_type_Int, ((pqa)localObject).jdField_b_of_type_Boolean, ((pqa)localObject).jdField_c_of_type_Boolean, ((pqa)localObject).jdField_f_of_type_Int);
      localAdvertisementInfo = nbe.a(this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((pqa)localObject).jdField_d_of_type_Int;
      i6 = ((pqa)localObject).jdField_e_of_type_Int;
      if (!((pqa)localObject).jdField_b_of_type_Boolean) {
        break label458;
      }
      i1 = 1;
      if (!((pqa)localObject).jdField_c_of_type_Boolean) {
        break label463;
      }
      i2 = 1;
      if (!npj.a(this.jdField_a_of_type_Qeq)) {
        break label468;
      }
      i3 = 20;
      label336:
      if (!((pqa)localObject).jdField_a_of_type_Boolean) {
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
      JSONObject localJSONObject = nbe.a(i5, i6, i1, i2, i3, i4, 0, nbe.aD, 0);
      nbe.a(new nmv().a(this.jdField_a_of_type_AndroidContentContext).a(nbe.jdField_f_of_type_Int).b(((pqa)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(localJSONObject).a());
      npj.a(this.jdField_a_of_type_Qeq);
      return;
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqa.jdField_d_of_type_Int = ((int)a().d());
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
  
  public void b(qeq paramqeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo");
    }
    if (paramqeq == null) {}
    qhw localqhw;
    do
    {
      do
      {
        return;
        localqhw = b(paramqeq);
      } while ((localqhw != null) && (paramqeq.jdField_a_of_type_Boolean) && (localqhw.a() == paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      this.jdField_a_of_type_JavaLangString = null;
    } while (((this.jdField_a_of_type_Qhy != null) && (!this.jdField_a_of_type_Qhy.a())) || ((localqhw != null) && (!localqhw.a()) && (localqhw.e() != 6) && (localqhw.e() != 7)));
    paramqeq.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Qeq = paramqeq;
    d(this.jdField_b_of_type_Qeq);
    if (this.jdField_b_of_type_Qeq.jdField_a_of_type_Pxw != null) {
      this.jdField_b_of_type_Qeq.jdField_a_of_type_Pxw.f(this.jdField_b_of_type_Qeq);
    }
    b(paramqeq, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw != null)) {
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw.c(this.jdField_a_of_type_Qeq);
    }
    if ((this.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qfk != null) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw != null)) {
      this.jdField_a_of_type_Qfk.a(1, this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_Qeq != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_Qeq);
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((qes)localIterator.next()).a(this.jdField_a_of_type_Qeq, this.jdField_c_of_type_Boolean);
        }
      }
      c(this.jdField_a_of_type_Qeq);
    }
    if (this.jdField_a_of_type_Qeq != null) {
      this.jdField_a_of_type_Qeq = null;
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
  public void c(qeq paramqeq)
  {
    if (paramqeq != null) {
      a(paramqeq.jdField_a_of_type_Qhw);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Qeq != null) {
        a(this.jdField_a_of_type_Qeq, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw != null)) {
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pxw.a(this.jdField_a_of_type_Qeq, 999, 998, null);
    }
    this.jdField_a_of_type_Qeq = null;
  }
  
  public boolean c()
  {
    return (a() != null) && (a().e() == 3);
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
      if ((a() != null) && (this.jdField_a_of_type_Qeq != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Qeq.jdField_a_of_type_Int)
    {
      a().b(i1);
      return;
    }
  }
  
  public boolean d()
  {
    return a() == 0;
  }
  
  public void e()
  {
    boolean bool2 = true;
    this.jdField_f_of_type_Boolean = true;
    if ((this.m) && (a() != null) && (a().d())) {
      a();
    }
    label60:
    label119:
    label122:
    for (;;)
    {
      this.k = false;
      this.m = false;
      pyw localpyw = pyw.a();
      if (!pyu.a().c())
      {
        bool1 = bool2;
        localpyw.b(bool1);
        qka.a().a(this.jdField_a_of_type_AndroidContentContext);
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
    if ((b(this.jdField_b_of_type_Qeq) != null) && (b(this.jdField_b_of_type_Qeq).a() != null)) {
      b(this.jdField_b_of_type_Qeq).a().setOutputMute(paramBoolean);
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
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "doOnPause() isPlaying()=" + c());
    }
    if (c())
    {
      this.k = true;
      this.l = false;
      b();
    }
    qka.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pyu.b(paramBoolean);
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Qeq);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Qeq);
    if (this.jdField_a_of_type_Qeq != null)
    {
      if (a() != null)
      {
        a().m();
        this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw = null;
      }
      this.jdField_a_of_type_Qeq = null;
    }
    if (this.jdField_b_of_type_Qeq != null)
    {
      if (b(this.jdField_b_of_type_Qeq) != null)
      {
        b(this.jdField_b_of_type_Qeq).m();
        this.jdField_b_of_type_Qeq.jdField_a_of_type_Qhw = null;
      }
      this.jdField_b_of_type_Qeq = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        qhw localqhw = (qhw)localIterator.next();
        if ((localqhw != null) && (localqhw.e() != 8)) {
          localqhw.m();
        }
      }
    }
    if (this.jdField_a_of_type_Qhy != null)
    {
      this.jdField_a_of_type_Qhy.b();
      this.jdField_a_of_type_Qhy = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    qji.a().b(this);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (aclk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) {
        aclk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidViewView, null);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_Aclm != null) {
      this.jdField_a_of_type_Aclm = null;
    }
    this.jdField_a_of_type_Qer = null;
    this.jdField_a_of_type_Qfk = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_Qeq) != null) {
      b(this.jdField_b_of_type_Qeq).d(paramBoolean);
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
    qhw localqhw;
    if (a() != null)
    {
      localqhw = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localqhw.d(bool1);
      if (b(this.jdField_b_of_type_Qeq) != null)
      {
        localqhw = b(this.jdField_b_of_type_Qeq);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localqhw.d(paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */