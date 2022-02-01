package com.tencent.biz.pubaccount.weishi_new.player;

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
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import urk;
import urp;
import urr;
import urs;
import urt;
import uru;
import urw;
import urx;
import ury;
import usa;
import usf;
import ush;
import usk;
import usr;
import uya;

public class WSPlayerManager
  implements usa
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new urs(this, Looper.getMainLooper());
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private ArrayList<uru> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<urw, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private urp jdField_a_of_type_Urp;
  private urr jdField_a_of_type_Urr = new urr(this, null);
  private urt jdField_a_of_type_Urt;
  private ury jdField_a_of_type_Ury;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private urt jdField_b_of_type_Urt;
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
    this.jdField_a_of_type_Ury = new ury();
    this.jdField_a_of_type_Ury.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Urp = new urp(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Urp);
    this.h = true;
  }
  
  private String a(urt paramurt)
  {
    if (paramurt == null) {
      return "WSPlayerParam is null!";
    }
    if (paramurt.jdField_a_of_type_Urx == null) {
      return "VideoInfo is null!";
    }
    return paramurt.jdField_a_of_type_Urx.jdField_b_of_type_JavaLangString;
  }
  
  private urt a(urt paramurt)
  {
    if (paramurt == this.jdField_a_of_type_Urt) {
      return paramurt;
    }
    return null;
  }
  
  private urw a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    urw localurw = new urw(this.jdField_a_of_type_AndroidContentContext);
    localurw.a(this.jdField_a_of_type_Urr);
    return localurw;
  }
  
  private urw a(urt paramurt)
  {
    if (paramurt != null) {
      return paramurt.jdField_a_of_type_Urw;
    }
    return null;
  }
  
  private urw a(urw paramurw)
  {
    if (paramurw == b()) {
      return paramurw;
    }
    return null;
  }
  
  private usf a(urt paramurt)
  {
    if (paramurt != null) {
      return paramurt.jdField_a_of_type_Usf;
    }
    return null;
  }
  
  private void a(urw paramurw)
  {
    if (paramurw == null) {}
    int i1;
    do
    {
      return;
      paramurw.k();
      i1 = paramurw.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramurw.e();
    ThreadManager.excute(new WSPlayerManager.6(this, paramurw), 16, null, true);
  }
  
  private boolean a(urt paramurt)
  {
    return a(paramurt) != null;
  }
  
  private boolean a(urw paramurw)
  {
    return a(paramurw) != null;
  }
  
  private String b(urt paramurt)
  {
    if (paramurt == null) {
      return "WSPlayerParam is null.";
    }
    if (paramurt.jdField_a_of_type_Urx == null) {
      return "VideoInfo is null.";
    }
    return paramurt.jdField_a_of_type_Urx.d;
  }
  
  private urw b()
  {
    return a(this.jdField_a_of_type_Urt);
  }
  
  private void b(urt paramurt)
  {
    if (paramurt != null) {
      a(paramurt.jdField_a_of_type_Urw);
    }
  }
  
  private void c(urt paramurt, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramurt == null) {
      return;
    }
    if (paramurt.jdField_a_of_type_Usr != null)
    {
      localObject = paramurt.jdField_a_of_type_Usr.a();
      if ((localObject != null) && (((View)localObject).getParent() != paramurt.jdField_a_of_type_AndroidViewViewGroup))
      {
        uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + ((View)localObject).getParent() + ", playerParam.mVideoLayout:" + paramurt.jdField_a_of_type_AndroidViewViewGroup);
        paramurt.jdField_a_of_type_Urw = null;
        paramurt.jdField_a_of_type_Usr = null;
      }
    }
    Object localObject = a(paramurt);
    if ((localObject == null) || (((urw)localObject).a() != null))
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((urw)localObject).a() != null)
        {
          ((urw)localObject).b(false);
          uya.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
          bool1 = true;
        }
      }
      ThreadManager.post(new WSPlayerManager.2(this, new WeakReference(paramurt), bool1, paramBoolean), 5, null, true);
      return;
    }
    uya.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
    paramurt.jdField_a_of_type_Urw.a(paramurt.jdField_a_of_type_Urx);
    d(paramurt, paramBoolean);
  }
  
  private void d(urt paramurt, boolean paramBoolean)
  {
    urw localurw = a(paramurt);
    if ((paramurt == null) || (localurw == null) || (paramurt.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      uya.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] playParam:" + paramurt);
      return;
    }
    paramurt.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramurt.jdField_a_of_type_Usr == null)
    {
      uya.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
      localObject = localurw.a();
      View localView;
      if (localObject != null)
      {
        localView = ((usr)localObject).a();
        if (localView != null) {}
      }
      else
      {
        if (paramurt.jdField_a_of_type_Urk != null) {
          paramurt.jdField_a_of_type_Urk.a(paramurt, 999, 999, null);
        }
        paramurt.jdField_a_of_type_Urw = null;
        return;
      }
      paramurt.jdField_a_of_type_Usr = ((usr)localObject);
      paramurt.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      localurw.a((usr)localObject);
      if (paramurt.jdField_a_of_type_Urk != null) {
        paramurt.jdField_a_of_type_Urk.b(paramurt);
      }
      if ((paramurt.jdField_a_of_type_Urx != null) && (paramurt.jdField_a_of_type_Urx.jdField_a_of_type_Int > 0) && (paramurt.jdField_a_of_type_Urx.jdField_b_of_type_Int > 0) && (paramurt.jdField_a_of_type_Urx.jdField_b_of_type_Int < 10000) && (paramurt.jdField_a_of_type_Urx.jdField_a_of_type_Int < 10000)) {
        ((usr)localObject).a(paramurt.jdField_a_of_type_Urx.jdField_a_of_type_Int, paramurt.jdField_a_of_type_Urx.jdField_b_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localurw.b(i1);
      if ((!this.k) && (!this.g)) {
        break label425;
      }
    }
    label425:
    for (boolean bool = true;; bool = false)
    {
      localurw.c(bool);
      localurw.a(this.h);
      localurw.d(paramurt.jdField_b_of_type_Boolean);
      localurw.a().b(this.i);
      uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][innerPlayVideo] xyAxis:" + i1 + ", isMuted:" + this.i + ", mPreOutputFirstFrame:" + this.h);
      localObject = paramurt.jdField_a_of_type_Usr.a();
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramurt, localurw, paramBoolean), 16, null, true);
      return;
      i1 = paramurt.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void e(urt paramurt, boolean paramBoolean)
  {
    usf localusf;
    if (paramurt != null)
    {
      if (paramurt.jdField_a_of_type_Usf == null) {
        paramurt.jdField_a_of_type_Usf = new ush();
      }
      localusf = paramurt.jdField_a_of_type_Usf;
      if (paramurt.jdField_a_of_type_Urx == null) {
        break label57;
      }
    }
    label57:
    for (String str = paramurt.jdField_a_of_type_Urx.jdField_a_of_type_JavaLangString;; str = "")
    {
      localusf.a(str, paramBoolean, paramurt.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  private void h()
  {
    if (b()) {
      c();
    }
    while ((!a()) && (!e()) && (!d()) && (!h())) {
      return;
    }
    b(this.jdField_a_of_type_Urt, false);
  }
  
  private void i()
  {
    uya.g("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + b(this.jdField_a_of_type_Urt));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.4(this));
    usf localusf = a(this.jdField_a_of_type_Urt);
    if (localusf != null) {
      localusf.b(a(this.jdField_a_of_type_Urt));
    }
  }
  
  public int a()
  {
    if (b() != null) {
      return b().e();
    }
    return 0;
  }
  
  public urt a()
  {
    return this.jdField_a_of_type_Urt;
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
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
    b().b();
    i();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Urt != null) && (b() != null))
    {
      this.j = true;
      b().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Urt != null) && (this.jdField_a_of_type_Urt.jdField_a_of_type_Urk != null))
      {
        long l1 = b().b();
        this.jdField_a_of_type_Urt.jdField_a_of_type_Urk.a(this.jdField_a_of_type_Urt, paramInt, l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(urt paramurt)
  {
    uya.g("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + b(paramurt));
    if (paramurt == null) {
      uya.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
    }
    urw localurw;
    do
    {
      do
      {
        return;
        localurw = a(paramurt);
      } while ((localurw != null) && (paramurt.jdField_a_of_type_Boolean) && (localurw.a() == paramurt.jdField_a_of_type_Urx));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      if ((this.jdField_a_of_type_Ury != null) && (!this.jdField_a_of_type_Ury.a()))
      {
        this.jdField_a_of_type_Ury.a();
        return;
      }
    } while ((localurw != null) && (!localurw.a()) && (localurw.e() != 6) && (localurw.e() != 7));
    paramurt.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Urt = paramurt;
    e(paramurt, true);
    if (this.jdField_b_of_type_Urt.jdField_a_of_type_Urk != null) {
      this.jdField_b_of_type_Urt.jdField_a_of_type_Urk.a(this.jdField_b_of_type_Urt);
    }
    c(paramurt, true);
  }
  
  public void a(urt paramurt, boolean paramBoolean)
  {
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] startTime:" + System.currentTimeMillis());
    if (paramurt == null)
    {
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramurt.jdField_a_of_type_Usr == null) || (paramurt.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + paramurt.jdField_a_of_type_Usr + ", videoLayout:" + paramurt.jdField_a_of_type_AndroidViewViewGroup);
      return;
    }
    urw localurw = a(paramurt);
    if (localurw == null)
    {
      uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
      return;
    }
    this.jdField_a_of_type_Urt = paramurt;
    localurw.b(paramurt.jdField_a_of_type_Int);
    localurw.a(paramurt.jdField_a_of_type_Usr, paramurt.jdField_a_of_type_AndroidViewViewGroup);
    localurw.a(this.jdField_a_of_type_Urr);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    if (paramBoolean) {
      h();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localurw, jdField_a_of_type_JavaLangObject);
    localurw.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.1(this, paramurt));
  }
  
  public void a(uru paramuru)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramuru))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramuru);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Urt != null) {
        b(this.jdField_a_of_type_Urt, false);
      }
      return;
    }
    this.jdField_a_of_type_Urt = null;
  }
  
  public boolean a()
  {
    return a() == 2;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Urt != null) && (b() != null) && ((b().e() == 3) || (b().e() == 4)))
    {
      b().c();
      if (this.jdField_a_of_type_Urt.jdField_a_of_type_Urk != null) {
        this.jdField_a_of_type_Urt.jdField_a_of_type_Urk.e(this.jdField_a_of_type_Urt);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((uru)localIterator.next()).d(this.jdField_a_of_type_Urt);
        }
      }
    }
  }
  
  public void b(urt paramurt, boolean paramBoolean)
  {
    uya.g("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + b(paramurt));
    if ((paramurt != null) && (paramurt.jdField_a_of_type_Urx != null))
    {
      uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + paramurt.jdField_a_of_type_Urx.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Urt = paramurt;
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        ((uru)((Iterator)localObject1).next()).a(this.jdField_a_of_type_Urt);
        continue;
        uya.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
        return;
      }
    }
    if (this.jdField_a_of_type_Urt.jdField_a_of_type_Urk != null) {
      this.jdField_a_of_type_Urt.jdField_a_of_type_Urk.a(this.jdField_a_of_type_Urt, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-4);
    Object localObject1 = a(paramurt);
    Object localObject2 = a(paramurt);
    if ((localObject1 != null) && (((urw)localObject1).e()) && (((urw)localObject1).a() == paramurt.jdField_a_of_type_Urx))
    {
      paramurt.jdField_a_of_type_Boolean = false;
      this.o = false;
      this.jdField_b_of_type_Urt = null;
      paramurt.jdField_a_of_type_Urw.f();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Urr.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramurt.jdField_a_of_type_Urw);
      }
      if (localObject2 != null)
      {
        ((usf)localObject2).a(true);
        ((usf)localObject2).a(2);
        ((usf)localObject2).a(a(paramurt));
      }
      uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + b(paramurt));
      this.jdField_a_of_type_Urr.a();
      return;
    }
    if ((paramurt.jdField_a_of_type_Boolean) && ((localObject1 == null) || (((urw)localObject1).a() == paramurt.jdField_a_of_type_Urx)))
    {
      if (localObject1 != null) {
        ((urw)localObject1).f();
      }
      this.m = true;
      if (localObject2 != null)
      {
        ((usf)localObject2).a(false);
        ((usf)localObject2).a(1);
      }
      localObject2 = new StringBuilder().append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((urw)localObject1).e());; localObject1 = " ")
      {
        uya.d("WS_VIDEO_PRE_PLAY", localObject1 + ", title:" + b(paramurt));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
    }
    this.o = false;
    this.jdField_b_of_type_Urt = null;
    e(this.jdField_a_of_type_Urt, false);
    if ((this.jdField_a_of_type_Ury != null) && (!this.jdField_a_of_type_Ury.a()))
    {
      this.jdField_a_of_type_Ury.a();
      return;
    }
    c(paramurt, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((b() != null) && (this.jdField_a_of_type_Urt != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Urt.jdField_a_of_type_Int)
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
    this.i = paramBoolean;
    if ((b() != null) && (b().a() != null)) {
      b().a().b(paramBoolean);
    }
    urw localurw = a(this.jdField_b_of_type_Urt);
    if ((localurw != null) && (localurw.a() != null)) {
      localurw.a().b(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return a() == 3;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Urt != null) && (b() != null))
    {
      Object localObject = a(this.jdField_a_of_type_Urt);
      if (localObject != null) {
        ((usf)localObject).a(this.jdField_a_of_type_Urt.jdField_a_of_type_Urw, this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_Urt.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Urt.jdField_a_of_type_Urk != null) {
        this.jdField_a_of_type_Urt.jdField_a_of_type_Urk.g(this.jdField_a_of_type_Urt);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((uru)((Iterator)localObject).next()).a(this.jdField_a_of_type_Urt, this.jdField_c_of_type_Boolean);
        }
      }
      uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + b(this.jdField_a_of_type_Urt));
      b(this.jdField_a_of_type_Urt);
    }
    if (this.jdField_a_of_type_Urt != null) {
      this.jdField_a_of_type_Urt = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public void d(boolean paramBoolean)
  {
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = null;
    }
    if (paramBoolean) {
      d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Urt);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Urt);
    if ((this.jdField_a_of_type_Urt != null) && (paramBoolean))
    {
      if (b() != null)
      {
        b().g();
        this.jdField_a_of_type_Urt.jdField_a_of_type_Urw = null;
      }
      this.jdField_a_of_type_Urt = null;
    }
    Object localObject;
    if ((this.jdField_b_of_type_Urt != null) && (this.jdField_b_of_type_Urt != this.jdField_a_of_type_Urt))
    {
      localObject = a(this.jdField_b_of_type_Urt);
      if (localObject != null)
      {
        ((urw)localObject).g();
        this.jdField_b_of_type_Urt.jdField_a_of_type_Urw = null;
      }
      this.o = false;
      this.jdField_b_of_type_Urt = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        urw localurw = (urw)((Iterator)localObject).next();
        if ((localurw != null) && (localurw.e() != 8) && ((localurw != b()) || (paramBoolean))) {
          localurw.g();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_Ury != null)
    {
      this.jdField_a_of_type_Ury.b();
      this.jdField_a_of_type_Ury = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_Urp != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Urp);
      this.jdField_a_of_type_Urp = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public boolean d()
  {
    return a() == 7;
  }
  
  public void e()
  {
    this.f = true;
    if ((this.n) && (b() != null) && (b().e())) {
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
        for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting();; bool = false)
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
    this.g = paramBoolean;
    urw localurw = b();
    if (localurw != null) {
      localurw.c(paramBoolean);
    }
    localurw = a(this.jdField_b_of_type_Urt);
    if (localurw != null) {
      localurw.c(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return a() == 6;
  }
  
  public void f()
  {
    this.f = false;
    uya.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + c());
    if (c())
    {
      this.l = true;
      this.m = false;
      b();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.k = paramBoolean;
    urw localurw = b();
    if (localurw != null) {
      if ((!paramBoolean) && (!this.g)) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = true;; bool1 = false)
    {
      localurw.c(bool1);
      localurw = a(this.jdField_b_of_type_Urt);
      if (localurw != null)
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
        localurw.c(paramBoolean);
      }
      return;
    }
  }
  
  public boolean f()
  {
    return a() == 1;
  }
  
  public void g()
  {
    urw localurw = b();
    if (localurw != null) {
      localurw.h();
    }
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
    return this.i;
  }
  
  public boolean j()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */