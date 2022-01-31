package com.tencent.biz.pubaccount.weishi_new.player;

import alud;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import thf;
import thg;
import thj;
import thk;
import thl;
import thm;
import tho;
import thp;
import thq;
import ths;
import thy;
import tia;
import tlo;

public class WSPlayerManager
  implements ths
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new thk(this, Looper.getMainLooper());
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<thm> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<tho, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private thg jdField_a_of_type_Thg;
  private thj jdField_a_of_type_Thj = new thj(this, null);
  private thl jdField_a_of_type_Thl;
  private thq jdField_a_of_type_Thq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private thl jdField_b_of_type_Thl;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
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
    this.jdField_a_of_type_Thq = new thq();
    this.jdField_a_of_type_Thq.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Thg = new thg(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Thg);
    this.h = true;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 123)
    {
      if (paramInt2 == 103) {
        return alud.a(2131716630) + paramInt1 + "-" + paramInt2 + ")";
      }
      return alud.a(2131716617) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204) {
        return alud.a(2131716594) + paramInt1 + "-" + paramInt2 + ")";
      }
      if (paramInt2 == 202) {
        return alud.a(2131716534) + paramInt1 + "-" + paramInt2 + ")";
      }
      return alud.a(2131716632) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80) {
        return alud.a(2131716561) + paramInt1 + "-" + paramInt2 + ")";
      }
      return alud.a(2131716563) + paramInt1 + "-" + paramInt2 + ")";
    }
    return alud.a(2131716587) + paramInt1 + "-" + paramInt2 + ")";
  }
  
  private String a(thl paramthl)
  {
    if (paramthl == null) {
      return "WSPlayerParam is null.";
    }
    if (paramthl.jdField_a_of_type_Thp == null) {
      return "VideoInfo is null.";
    }
    return paramthl.jdField_a_of_type_Thp.d;
  }
  
  private thl a(thl paramthl)
  {
    if (paramthl == this.jdField_a_of_type_Thl) {
      return paramthl;
    }
    return null;
  }
  
  private tho a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    tho localtho = new tho(this.jdField_a_of_type_AndroidContentContext);
    localtho.a(this.jdField_a_of_type_Thj);
    return localtho;
  }
  
  private tho a(thl paramthl)
  {
    if (paramthl != null) {
      return paramthl.jdField_a_of_type_Tho;
    }
    return null;
  }
  
  private tho a(tho paramtho)
  {
    if (paramtho == b()) {
      return paramtho;
    }
    return null;
  }
  
  private thy a(thl paramthl)
  {
    if (paramthl != null) {
      return paramthl.jdField_a_of_type_Thy;
    }
    return null;
  }
  
  private void a(tho paramtho)
  {
    if (paramtho == null) {}
    int i1;
    do
    {
      return;
      paramtho.k();
      i1 = paramtho.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramtho.e();
    ThreadManager.excute(new WSPlayerManager.6(this, paramtho), 16, null, true);
  }
  
  private boolean a(thl paramthl)
  {
    return a(paramthl) != null;
  }
  
  private boolean a(tho paramtho)
  {
    return a(paramtho) != null;
  }
  
  private tho b()
  {
    return a(this.jdField_a_of_type_Thl);
  }
  
  private void b(thl paramthl)
  {
    if (paramthl != null) {
      a(paramthl.jdField_a_of_type_Tho);
    }
  }
  
  private void c(thl paramthl, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramthl == null) {
      return;
    }
    if ((paramthl.jdField_a_of_type_AndroidViewView != null) && (paramthl.jdField_a_of_type_AndroidViewView.getParent() != paramthl.jdField_a_of_type_AndroidViewViewGroup))
    {
      tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + paramthl.jdField_a_of_type_AndroidViewView.getParent() + ", playerParam.mVideoLayout:" + paramthl.jdField_a_of_type_AndroidViewViewGroup);
      paramthl.jdField_a_of_type_Tho = null;
      paramthl.jdField_a_of_type_AndroidViewView = null;
    }
    if ((a(paramthl) == null) || (a(paramthl).a() != null))
    {
      boolean bool1 = bool2;
      if (a(paramthl) != null)
      {
        bool1 = bool2;
        if (a(paramthl).a() != null)
        {
          a(paramthl).b(false);
          tlo.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
          bool1 = true;
        }
      }
      ThreadManager.post(new WSPlayerManager.2(this, paramthl, bool1, paramBoolean), 5, null, true);
      return;
    }
    tlo.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
    paramthl.jdField_a_of_type_Tho.a(paramthl.jdField_a_of_type_Thp);
    d(paramthl, paramBoolean);
  }
  
  private void d(thl paramthl, boolean paramBoolean)
  {
    if ((paramthl == null) || (a(paramthl) == null))
    {
      tlo.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] playParam:" + paramthl);
      return;
    }
    paramthl.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramthl.jdField_a_of_type_AndroidViewView == null)
    {
      tlo.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
      localObject = a(paramthl).a();
      if (localObject == null)
      {
        if (paramthl.jdField_a_of_type_Thf != null) {
          paramthl.jdField_a_of_type_Thf.a(paramthl, 999, 999, null);
        }
        paramthl.jdField_a_of_type_Tho = null;
        return;
      }
      paramthl.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramthl.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      a(paramthl).a((IVideoViewBase)localObject);
      if (paramthl.jdField_a_of_type_Thf != null) {
        paramthl.jdField_a_of_type_Thf.b(paramthl);
      }
      if ((paramthl.jdField_a_of_type_Thp != null) && (paramthl.jdField_a_of_type_Thp.jdField_a_of_type_Int > 0) && (paramthl.jdField_a_of_type_Thp.jdField_b_of_type_Int > 0) && (paramthl.jdField_a_of_type_Thp.jdField_b_of_type_Int < 10000) && (paramthl.jdField_a_of_type_Thp.jdField_a_of_type_Int < 10000)) {
        ((IVideoViewBase)localObject).setFixedSize(paramthl.jdField_a_of_type_Thp.jdField_a_of_type_Int, paramthl.jdField_a_of_type_Thp.jdField_b_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      a(paramthl).b(i1);
      localObject = a(paramthl);
      if ((!this.k) && (!this.g)) {
        break label421;
      }
    }
    label421:
    for (boolean bool = true;; bool = false)
    {
      ((tho)localObject).c(bool);
      a(paramthl).a(this.h);
      a(paramthl).d(paramthl.jdField_b_of_type_Boolean);
      a(paramthl).a().setOutputMute(this.i);
      tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][innerPlayVideo] xyAxis:" + i1 + ", isMuted:" + this.i + ", mPreOutputFirstFrame:" + this.h);
      paramthl.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramthl, a(paramthl), paramBoolean), 16, null, true);
      return;
      i1 = paramthl.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void e(thl paramthl, boolean paramBoolean)
  {
    thy localthy;
    if (paramthl != null)
    {
      if (paramthl.jdField_a_of_type_Thy == null) {
        paramthl.jdField_a_of_type_Thy = new tia();
      }
      localthy = paramthl.jdField_a_of_type_Thy;
      if (paramthl.jdField_a_of_type_Thp == null) {
        break label57;
      }
    }
    label57:
    for (String str = paramthl.jdField_a_of_type_Thp.jdField_a_of_type_JavaLangString;; str = "")
    {
      localthy.a(str, paramBoolean, paramthl.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  private void g()
  {
    if (b()) {
      c();
    }
    while ((!a()) && (!e()) && (!d())) {
      return;
    }
    b(this.jdField_a_of_type_Thl, false);
  }
  
  private void h()
  {
    tlo.g("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + a(this.jdField_a_of_type_Thl));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.4(this));
    if (a(this.jdField_a_of_type_Thl) != null) {
      a(this.jdField_a_of_type_Thl).b(a(this.jdField_a_of_type_Thl));
    }
  }
  
  public int a()
  {
    if (b() != null) {
      return b().e();
    }
    return 0;
  }
  
  public thl a()
  {
    return this.jdField_a_of_type_Thl;
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
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
    b().b();
    h();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Thl != null) && (b() != null))
    {
      this.j = true;
      b().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Thl != null) && (this.jdField_a_of_type_Thl.jdField_a_of_type_Thf != null))
      {
        long l1 = b().b();
        this.jdField_a_of_type_Thl.jdField_a_of_type_Thf.a(this.jdField_a_of_type_Thl, paramInt, l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(thl paramthl)
  {
    tlo.g("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + a(paramthl));
    if (paramthl == null) {
      tlo.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
    }
    tho localtho;
    do
    {
      do
      {
        return;
        localtho = a(paramthl);
      } while ((localtho != null) && (paramthl.jdField_a_of_type_Boolean) && (localtho.a() == paramthl.jdField_a_of_type_Thp));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      if ((this.jdField_a_of_type_Thq != null) && (!this.jdField_a_of_type_Thq.a()))
      {
        this.jdField_a_of_type_Thq.a();
        return;
      }
    } while ((localtho != null) && (!localtho.a()) && (localtho.e() != 6) && (localtho.e() != 7));
    paramthl.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Thl = paramthl;
    e(paramthl, true);
    if (this.jdField_b_of_type_Thl.jdField_a_of_type_Thf != null) {
      this.jdField_b_of_type_Thl.jdField_a_of_type_Thf.a(this.jdField_b_of_type_Thl);
    }
    c(paramthl, true);
  }
  
  public void a(thl paramthl, boolean paramBoolean)
  {
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout]");
    if (paramthl == null)
    {
      tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramthl.jdField_a_of_type_AndroidViewView == null) || (paramthl.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + paramthl.jdField_a_of_type_AndroidViewView + ", videoLayout:" + paramthl.jdField_a_of_type_AndroidViewViewGroup);
      return;
    }
    tho localtho = a(paramthl);
    if (localtho == null)
    {
      tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
      return;
    }
    this.jdField_a_of_type_Thl = paramthl;
    View localView = paramthl.jdField_a_of_type_AndroidViewView;
    localtho.b(paramthl.jdField_a_of_type_Int);
    localtho.a(localView);
    paramthl.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    localtho.a((IVideoViewBase)localView);
    localtho.a(this.jdField_a_of_type_Thj);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    if (paramBoolean) {
      g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localtho, this.jdField_a_of_type_JavaLangObject);
    localtho.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.1(this, paramthl));
  }
  
  public void a(thm paramthm)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramthm))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramthm);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Thl != null) {
        b(this.jdField_a_of_type_Thl, false);
      }
      return;
    }
    this.jdField_a_of_type_Thl = null;
  }
  
  public boolean a()
  {
    return a() == 2;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Thl != null) && (b() != null) && ((b().e() == 3) || (b().e() == 4)))
    {
      b().c();
      if (this.jdField_a_of_type_Thl.jdField_a_of_type_Thf != null) {
        this.jdField_a_of_type_Thl.jdField_a_of_type_Thf.e(this.jdField_a_of_type_Thl);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((thm)localIterator.next()).d(this.jdField_a_of_type_Thl);
        }
      }
    }
  }
  
  public void b(thl paramthl, boolean paramBoolean)
  {
    tlo.g("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + a(paramthl));
    Object localObject;
    if ((paramthl != null) && (paramthl.jdField_a_of_type_Thp != null))
    {
      tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + paramthl.jdField_a_of_type_Thp.jdField_b_of_type_JavaLangString);
      this.c = false;
      this.jdField_a_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Thl = paramthl;
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject).hasNext())
      {
        ((thm)((Iterator)localObject).next()).a(this.jdField_a_of_type_Thl);
        continue;
        tlo.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
        return;
      }
    }
    if (this.jdField_a_of_type_Thl.jdField_a_of_type_Thf != null) {
      this.jdField_a_of_type_Thl.jdField_a_of_type_Thf.a(this.jdField_a_of_type_Thl, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-4);
    if ((a(paramthl) != null) && (a(paramthl).d()) && (a(paramthl).a() == paramthl.jdField_a_of_type_Thp))
    {
      paramthl.jdField_a_of_type_Boolean = false;
      this.o = false;
      this.jdField_b_of_type_Thl = null;
      paramthl.jdField_a_of_type_Tho.f();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Thj.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramthl.jdField_a_of_type_Tho);
      }
      if (a(paramthl) != null)
      {
        a(paramthl).a(true);
        a(paramthl).a(a(paramthl));
      }
      tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + a(paramthl));
      this.jdField_a_of_type_Thj.a();
      return;
    }
    if ((paramthl.jdField_a_of_type_Boolean) && ((a(paramthl) == null) || (a(paramthl).a() == paramthl.jdField_a_of_type_Thp)))
    {
      if (a(paramthl) != null) {
        a(paramthl).f();
      }
      this.m = true;
      if (a(paramthl) != null) {
        a(paramthl).a(false);
      }
      StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
      if (a(paramthl) != null) {}
      for (localObject = Integer.valueOf(a(paramthl).e());; localObject = " ")
      {
        tlo.d("WS_VIDEO_PRE_PLAY", localObject + ", title:" + a(paramthl));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
    }
    this.o = false;
    this.jdField_b_of_type_Thl = null;
    e(this.jdField_a_of_type_Thl, false);
    if ((this.jdField_a_of_type_Thq != null) && (!this.jdField_a_of_type_Thq.a()))
    {
      this.jdField_a_of_type_Thq.a();
      return;
    }
    c(paramthl, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((b() != null) && (this.jdField_a_of_type_Thl != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Thl.jdField_a_of_type_Int)
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
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = null;
    }
    if (paramBoolean) {
      d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Thl);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Thl);
    if ((this.jdField_a_of_type_Thl != null) && (paramBoolean))
    {
      if (b() != null)
      {
        b().g();
        this.jdField_a_of_type_Thl.jdField_a_of_type_Tho = null;
      }
      this.jdField_a_of_type_Thl = null;
    }
    if (this.jdField_b_of_type_Thl != null)
    {
      if (a(this.jdField_b_of_type_Thl) != null)
      {
        a(this.jdField_b_of_type_Thl).g();
        this.jdField_b_of_type_Thl.jdField_a_of_type_Tho = null;
      }
      this.o = false;
      this.jdField_b_of_type_Thl = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        tho localtho = (tho)localIterator.next();
        if ((localtho != null) && (localtho.e() != 8) && ((localtho != b()) || (paramBoolean))) {
          localtho.g();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_Thq != null)
    {
      this.jdField_a_of_type_Thq.b();
      this.jdField_a_of_type_Thq = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_Thg != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Thg);
      this.jdField_a_of_type_Thg = null;
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
    if ((this.jdField_a_of_type_Thl != null) && (b() != null))
    {
      if (a(this.jdField_a_of_type_Thl) != null) {
        a(this.jdField_a_of_type_Thl).a(this.jdField_a_of_type_Thl.jdField_a_of_type_Tho, this.c);
      }
      this.jdField_a_of_type_Thl.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Thl.jdField_a_of_type_Thf != null) {
        this.jdField_a_of_type_Thl.jdField_a_of_type_Thf.g(this.jdField_a_of_type_Thl);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((thm)localIterator.next()).a(this.jdField_a_of_type_Thl, this.c);
        }
      }
      tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + a(this.jdField_a_of_type_Thl));
      b(this.jdField_a_of_type_Thl);
    }
    if (this.jdField_a_of_type_Thl != null) {
      this.jdField_a_of_type_Thl = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (b() != null) {
      b().c(paramBoolean);
    }
    if (a(this.jdField_b_of_type_Thl) != null) {
      a(this.jdField_b_of_type_Thl).c(paramBoolean);
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
        for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();; bool = false)
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
    tho localtho;
    if (b() != null)
    {
      localtho = b();
      if ((!paramBoolean) && (!this.g)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localtho.c(bool1);
      if (a(this.jdField_b_of_type_Thl) != null)
      {
        localtho = a(this.jdField_b_of_type_Thl);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.g) {}
        }
        else
        {
          paramBoolean = true;
        }
        localtho.c(paramBoolean);
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
    tlo.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + c());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */