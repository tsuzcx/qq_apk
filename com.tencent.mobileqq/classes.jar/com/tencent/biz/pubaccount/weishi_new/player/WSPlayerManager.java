package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import anni;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import ujv;
import ujw;
import ujz;
import uka;
import ukb;
import ukc;
import uke;
import ukf;
import ukg;
import uki;
import uko;
import ukq;
import upe;

public class WSPlayerManager
  implements uki
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new uka(this, Looper.getMainLooper());
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private ArrayList<ukc> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<uke, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ujw jdField_a_of_type_Ujw;
  private ujz jdField_a_of_type_Ujz = new ujz(this, null);
  private ukb jdField_a_of_type_Ukb;
  private ukg jdField_a_of_type_Ukg;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ukb jdField_b_of_type_Ukb;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public WSPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ukg = new ukg();
    this.jdField_a_of_type_Ukg.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Ujw = new ujw(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ujw);
    this.h = true;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 123)
    {
      if (paramInt2 == 103) {
        return anni.a(2131714907) + paramInt1 + "-" + paramInt2 + ")";
      }
      return anni.a(2131714894) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204) {
        return anni.a(2131714871) + paramInt1 + "-" + paramInt2 + ")";
      }
      if (paramInt2 == 202) {
        return anni.a(2131714811) + paramInt1 + "-" + paramInt2 + ")";
      }
      return anni.a(2131714909) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80) {
        return anni.a(2131714838) + paramInt1 + "-" + paramInt2 + ")";
      }
      return anni.a(2131714840) + paramInt1 + "-" + paramInt2 + ")";
    }
    return anni.a(2131714864) + paramInt1 + "-" + paramInt2 + ")";
  }
  
  private String a(ukb paramukb)
  {
    if (paramukb == null) {
      return "WSPlayerParam is null!";
    }
    if (paramukb.jdField_a_of_type_Ukf == null) {
      return "VideoInfo is null!";
    }
    return paramukb.jdField_a_of_type_Ukf.jdField_b_of_type_JavaLangString;
  }
  
  private ukb a(ukb paramukb)
  {
    if (paramukb == this.jdField_a_of_type_Ukb) {
      return paramukb;
    }
    return null;
  }
  
  private uke a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    uke localuke = new uke(this.jdField_a_of_type_AndroidContentContext);
    localuke.a(this.jdField_a_of_type_Ujz);
    return localuke;
  }
  
  private uke a(ukb paramukb)
  {
    if (paramukb != null) {
      return paramukb.jdField_a_of_type_Uke;
    }
    return null;
  }
  
  private uke a(uke paramuke)
  {
    if (paramuke == b()) {
      return paramuke;
    }
    return null;
  }
  
  private uko a(ukb paramukb)
  {
    if (paramukb != null) {
      return paramukb.jdField_a_of_type_Uko;
    }
    return null;
  }
  
  private void a(uke paramuke)
  {
    if (paramuke == null) {}
    int i1;
    do
    {
      return;
      paramuke.k();
      i1 = paramuke.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramuke.e();
    ThreadManager.excute(new WSPlayerManager.6(this, paramuke), 16, null, true);
  }
  
  private boolean a(ukb paramukb)
  {
    return a(paramukb) != null;
  }
  
  private boolean a(uke paramuke)
  {
    return a(paramuke) != null;
  }
  
  private String b(ukb paramukb)
  {
    if (paramukb == null) {
      return "WSPlayerParam is null.";
    }
    if (paramukb.jdField_a_of_type_Ukf == null) {
      return "VideoInfo is null.";
    }
    return paramukb.jdField_a_of_type_Ukf.d;
  }
  
  private uke b()
  {
    return a(this.jdField_a_of_type_Ukb);
  }
  
  private void b(ukb paramukb)
  {
    if (paramukb != null) {
      a(paramukb.jdField_a_of_type_Uke);
    }
  }
  
  private void c(ukb paramukb, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramukb == null) {
      return;
    }
    if ((paramukb.jdField_a_of_type_AndroidViewView != null) && (paramukb.jdField_a_of_type_AndroidViewView.getParent() != paramukb.jdField_a_of_type_AndroidViewViewGroup))
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + paramukb.jdField_a_of_type_AndroidViewView.getParent() + ", playerParam.mVideoLayout:" + paramukb.jdField_a_of_type_AndroidViewViewGroup);
      paramukb.jdField_a_of_type_Uke = null;
      paramukb.jdField_a_of_type_AndroidViewView = null;
    }
    uke localuke = a(paramukb);
    if ((localuke == null) || (localuke.a() != null))
    {
      boolean bool1 = bool2;
      if (localuke != null)
      {
        bool1 = bool2;
        if (localuke.a() != null)
        {
          localuke.b(false);
          upe.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
          bool1 = true;
        }
      }
      ThreadManager.post(new WSPlayerManager.2(this, paramukb, bool1, paramBoolean), 5, null, true);
      return;
    }
    upe.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
    paramukb.jdField_a_of_type_Uke.a(paramukb.jdField_a_of_type_Ukf);
    d(paramukb, paramBoolean);
  }
  
  private void d(ukb paramukb, boolean paramBoolean)
  {
    uke localuke = a(paramukb);
    if ((paramukb == null) || (localuke == null) || (paramukb.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      upe.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] playParam:" + paramukb);
      return;
    }
    paramukb.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (paramukb.jdField_a_of_type_AndroidViewView == null)
    {
      upe.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
      View localView = localuke.a();
      if (localView == null)
      {
        if (paramukb.jdField_a_of_type_Ujv != null) {
          paramukb.jdField_a_of_type_Ujv.a(paramukb, 999, 999, null);
        }
        paramukb.jdField_a_of_type_Uke = null;
        return;
      }
      paramukb.jdField_a_of_type_AndroidViewView = localView;
      paramukb.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      localuke.a((IVideoViewBase)localView);
      if (paramukb.jdField_a_of_type_Ujv != null) {
        paramukb.jdField_a_of_type_Ujv.b(paramukb);
      }
      if ((paramukb.jdField_a_of_type_Ukf != null) && (paramukb.jdField_a_of_type_Ukf.jdField_a_of_type_Int > 0) && (paramukb.jdField_a_of_type_Ukf.jdField_b_of_type_Int > 0) && (paramukb.jdField_a_of_type_Ukf.jdField_b_of_type_Int < 10000) && (paramukb.jdField_a_of_type_Ukf.jdField_a_of_type_Int < 10000)) {
        ((IVideoViewBase)localView).setFixedSize(paramukb.jdField_a_of_type_Ukf.jdField_a_of_type_Int, paramukb.jdField_a_of_type_Ukf.jdField_b_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localuke.b(i1);
      if ((!this.k) && (!this.g)) {
        break label404;
      }
    }
    label404:
    for (boolean bool = true;; bool = false)
    {
      localuke.c(bool);
      localuke.a(this.h);
      localuke.d(paramukb.jdField_b_of_type_Boolean);
      localuke.a().setOutputMute(this.i);
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][innerPlayVideo] xyAxis:" + i1 + ", isMuted:" + this.i + ", mPreOutputFirstFrame:" + this.h);
      paramukb.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramukb, localuke, paramBoolean), 16, null, true);
      return;
      i1 = paramukb.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void e(ukb paramukb, boolean paramBoolean)
  {
    uko localuko;
    if (paramukb != null)
    {
      if (paramukb.jdField_a_of_type_Uko == null) {
        paramukb.jdField_a_of_type_Uko = new ukq();
      }
      localuko = paramukb.jdField_a_of_type_Uko;
      if (paramukb.jdField_a_of_type_Ukf == null) {
        break label57;
      }
    }
    label57:
    for (String str = paramukb.jdField_a_of_type_Ukf.jdField_a_of_type_JavaLangString;; str = "")
    {
      localuko.a(str, paramBoolean, paramukb.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  private void g()
  {
    if (b()) {
      c();
    }
    while ((!a()) && (!e()) && (!d()) && (!h())) {
      return;
    }
    b(this.jdField_a_of_type_Ukb, false);
  }
  
  private void h()
  {
    upe.g("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + b(this.jdField_a_of_type_Ukb));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.4(this));
    uko localuko = a(this.jdField_a_of_type_Ukb);
    if (localuko != null) {
      localuko.b(a(this.jdField_a_of_type_Ukb));
    }
  }
  
  public int a()
  {
    if (b() != null) {
      return b().e();
    }
    return 0;
  }
  
  public ukb a()
  {
    return this.jdField_a_of_type_Ukb;
  }
  
  public void a()
  {
    if (b() != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new WSPlayerManager.3(this));
      }
    }
    else {
      return;
    }
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
    b().b();
    h();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ukb != null) && (b() != null))
    {
      this.j = true;
      b().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Ukb != null) && (this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv != null))
      {
        long l1 = b().b();
        this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv.a(this.jdField_a_of_type_Ukb, paramInt, l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(ukb paramukb)
  {
    upe.g("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + b(paramukb));
    if (paramukb == null) {
      upe.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
    }
    uke localuke;
    do
    {
      do
      {
        return;
        localuke = a(paramukb);
      } while ((localuke != null) && (paramukb.jdField_a_of_type_Boolean) && (localuke.a() == paramukb.jdField_a_of_type_Ukf));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      if ((this.jdField_a_of_type_Ukg != null) && (!this.jdField_a_of_type_Ukg.a()))
      {
        this.jdField_a_of_type_Ukg.a();
        return;
      }
    } while ((localuke != null) && (!localuke.a()) && (localuke.e() != 6) && (localuke.e() != 7));
    paramukb.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Ukb = paramukb;
    e(paramukb, true);
    if (this.jdField_b_of_type_Ukb.jdField_a_of_type_Ujv != null) {
      this.jdField_b_of_type_Ukb.jdField_a_of_type_Ujv.a(this.jdField_b_of_type_Ukb);
    }
    c(paramukb, true);
  }
  
  public void a(ukb paramukb, boolean paramBoolean)
  {
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout]");
    if (paramukb == null)
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramukb.jdField_a_of_type_AndroidViewView == null) || (paramukb.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + paramukb.jdField_a_of_type_AndroidViewView + ", videoLayout:" + paramukb.jdField_a_of_type_AndroidViewViewGroup);
      return;
    }
    uke localuke = a(paramukb);
    if (localuke == null)
    {
      upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
      return;
    }
    this.jdField_a_of_type_Ukb = paramukb;
    View localView = paramukb.jdField_a_of_type_AndroidViewView;
    localuke.b(paramukb.jdField_a_of_type_Int);
    localuke.a(localView);
    paramukb.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    localuke.a((IVideoViewBase)localView);
    localuke.a(this.jdField_a_of_type_Ujz);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    if (paramBoolean) {
      g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localuke, jdField_a_of_type_JavaLangObject);
    localuke.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.1(this, paramukb));
  }
  
  public void a(ukc paramukc)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramukc))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramukc);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Ukb != null) {
        b(this.jdField_a_of_type_Ukb, false);
      }
      return;
    }
    this.jdField_a_of_type_Ukb = null;
  }
  
  public boolean a()
  {
    return a() == 2;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ukb != null) && (b() != null) && ((b().e() == 3) || (b().e() == 4)))
    {
      b().c();
      if (this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv != null) {
        this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv.e(this.jdField_a_of_type_Ukb);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((ukc)localIterator.next()).d(this.jdField_a_of_type_Ukb);
        }
      }
    }
  }
  
  public void b(ukb paramukb, boolean paramBoolean)
  {
    upe.g("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + b(paramukb));
    if ((paramukb != null) && (paramukb.jdField_a_of_type_Ukf != null))
    {
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + paramukb.jdField_a_of_type_Ukf.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Ukb = paramukb;
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        ((ukc)((Iterator)localObject1).next()).a(this.jdField_a_of_type_Ukb);
        continue;
        upe.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
        return;
      }
    }
    if (this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv != null) {
      this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv.a(this.jdField_a_of_type_Ukb, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-4);
    Object localObject1 = a(paramukb);
    Object localObject2 = a(paramukb);
    if ((localObject1 != null) && (((uke)localObject1).d()) && (((uke)localObject1).a() == paramukb.jdField_a_of_type_Ukf))
    {
      paramukb.jdField_a_of_type_Boolean = false;
      this.o = false;
      this.jdField_b_of_type_Ukb = null;
      paramukb.jdField_a_of_type_Uke.f();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Ujz.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramukb.jdField_a_of_type_Uke);
      }
      if (localObject2 != null)
      {
        ((uko)localObject2).a(true);
        ((uko)localObject2).a(2);
        ((uko)localObject2).a(a(paramukb));
      }
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + b(paramukb));
      this.jdField_a_of_type_Ujz.a();
      return;
    }
    if ((paramukb.jdField_a_of_type_Boolean) && ((localObject1 == null) || (((uke)localObject1).a() == paramukb.jdField_a_of_type_Ukf)))
    {
      if (localObject1 != null) {
        ((uke)localObject1).f();
      }
      this.m = true;
      if (localObject2 != null)
      {
        ((uko)localObject2).a(false);
        ((uko)localObject2).a(1);
      }
      localObject2 = new StringBuilder().append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((uke)localObject1).e());; localObject1 = " ")
      {
        upe.d("WS_VIDEO_PRE_PLAY", localObject1 + ", title:" + b(paramukb));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
    }
    this.o = false;
    this.jdField_b_of_type_Ukb = null;
    e(this.jdField_a_of_type_Ukb, false);
    if ((this.jdField_a_of_type_Ukg != null) && (!this.jdField_a_of_type_Ukg.a()))
    {
      this.jdField_a_of_type_Ukg.a();
      return;
    }
    c(paramukb, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((b() != null) && (this.jdField_a_of_type_Ukb != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Ukb.jdField_a_of_type_Int)
    {
      b().b(i1);
      return;
    }
  }
  
  public boolean b()
  {
    return a() == 5;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.5(this));
  }
  
  public void c(boolean paramBoolean)
  {
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = null;
    }
    if (paramBoolean) {
      d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Ukb);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Ukb);
    if ((this.jdField_a_of_type_Ukb != null) && (paramBoolean))
    {
      if (b() != null)
      {
        b().g();
        this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke = null;
      }
      this.jdField_a_of_type_Ukb = null;
    }
    Object localObject;
    if (this.jdField_b_of_type_Ukb != null)
    {
      localObject = a(this.jdField_b_of_type_Ukb);
      if (localObject != null)
      {
        ((uke)localObject).g();
        this.jdField_b_of_type_Ukb.jdField_a_of_type_Uke = null;
      }
      this.o = false;
      this.jdField_b_of_type_Ukb = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        uke localuke = (uke)((Iterator)localObject).next();
        if ((localuke != null) && (localuke.e() != 8) && ((localuke != b()) || (paramBoolean))) {
          localuke.g();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_Ukg != null)
    {
      this.jdField_a_of_type_Ukg.b();
      this.jdField_a_of_type_Ukg = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_Ujw != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Ujw);
      this.jdField_a_of_type_Ujw = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public boolean c()
  {
    return a() == 3;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Ukb != null) && (b() != null))
    {
      Object localObject = a(this.jdField_a_of_type_Ukb);
      if (localObject != null) {
        ((uko)localObject).a(this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke, this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_Ukb.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv != null) {
        this.jdField_a_of_type_Ukb.jdField_a_of_type_Ujv.g(this.jdField_a_of_type_Ukb);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ukc)((Iterator)localObject).next()).a(this.jdField_a_of_type_Ukb, this.jdField_c_of_type_Boolean);
        }
      }
      upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + b(this.jdField_a_of_type_Ukb));
      b(this.jdField_a_of_type_Ukb);
    }
    if (this.jdField_a_of_type_Ukb != null) {
      this.jdField_a_of_type_Ukb = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
    uke localuke = b();
    if (localuke != null) {
      localuke.c(paramBoolean);
    }
    localuke = a(this.jdField_b_of_type_Ukb);
    if (localuke != null) {
      localuke.c(paramBoolean);
    }
  }
  
  public boolean d()
  {
    return a() == 7;
  }
  
  public void e()
  {
    this.f = true;
    if ((this.n) && (b() != null) && (b().d())) {
      a();
    }
    label85:
    for (;;)
    {
      this.l = false;
      this.n = false;
      return;
      if (this.l)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
        for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();; bool = false)
        {
          if (bool) {
            break label85;
          }
          this.m = true;
          c();
          break;
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.k = paramBoolean;
    uke localuke = b();
    if (localuke != null) {
      if ((!paramBoolean) && (!this.g)) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = true;; bool1 = false)
    {
      localuke.c(bool1);
      localuke = a(this.jdField_b_of_type_Ukb);
      if (localuke != null)
      {
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.g) {}
        }
        else
        {
          paramBoolean = true;
        }
        localuke.c(paramBoolean);
      }
      return;
    }
  }
  
  public boolean e()
  {
    return a() == 6;
  }
  
  public void f()
  {
    this.f = false;
    upe.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + c());
    if (c())
    {
      this.l = true;
      this.m = false;
      b();
    }
  }
  
  public boolean f()
  {
    return a() == 1;
  }
  
  public boolean g()
  {
    return a() == 4;
  }
  
  public boolean h()
  {
    return a() == 0;
  }
  
  public boolean i()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */