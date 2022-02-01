package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import anzj;
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
import mqq.util.WeakReference;
import ukp;
import uku;
import ukx;
import uky;
import ukz;
import ula;
import ulc;
import uld;
import ule;
import ulg;
import ulm;
import ulo;
import uqf;

public class WSPlayerManager
  implements ulg
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new uky(this, Looper.getMainLooper());
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private ArrayList<ula> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<ulc, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private uku jdField_a_of_type_Uku;
  private ukx jdField_a_of_type_Ukx = new ukx(this, null);
  private ukz jdField_a_of_type_Ukz;
  private ule jdField_a_of_type_Ule;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ukz jdField_b_of_type_Ukz;
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
    this.jdField_a_of_type_Ule = new ule();
    this.jdField_a_of_type_Ule.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Uku = new uku(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uku);
    this.h = true;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 123)
    {
      if (paramInt2 == 103) {
        return anzj.a(2131715016) + paramInt1 + "-" + paramInt2 + ")";
      }
      return anzj.a(2131715003) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204) {
        return anzj.a(2131714980) + paramInt1 + "-" + paramInt2 + ")";
      }
      if (paramInt2 == 202) {
        return anzj.a(2131714920) + paramInt1 + "-" + paramInt2 + ")";
      }
      return anzj.a(2131715018) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80) {
        return anzj.a(2131714947) + paramInt1 + "-" + paramInt2 + ")";
      }
      return anzj.a(2131714949) + paramInt1 + "-" + paramInt2 + ")";
    }
    return anzj.a(2131714973) + paramInt1 + "-" + paramInt2 + ")";
  }
  
  private String a(ukz paramukz)
  {
    if (paramukz == null) {
      return "WSPlayerParam is null!";
    }
    if (paramukz.jdField_a_of_type_Uld == null) {
      return "VideoInfo is null!";
    }
    return paramukz.jdField_a_of_type_Uld.jdField_b_of_type_JavaLangString;
  }
  
  private ukz a(ukz paramukz)
  {
    if (paramukz == this.jdField_a_of_type_Ukz) {
      return paramukz;
    }
    return null;
  }
  
  private ulc a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    ulc localulc = new ulc(this.jdField_a_of_type_AndroidContentContext);
    localulc.a(this.jdField_a_of_type_Ukx);
    return localulc;
  }
  
  private ulc a(ukz paramukz)
  {
    if (paramukz != null) {
      return paramukz.jdField_a_of_type_Ulc;
    }
    return null;
  }
  
  private ulc a(ulc paramulc)
  {
    if (paramulc == b()) {
      return paramulc;
    }
    return null;
  }
  
  private ulm a(ukz paramukz)
  {
    if (paramukz != null) {
      return paramukz.jdField_a_of_type_Ulm;
    }
    return null;
  }
  
  private void a(ulc paramulc)
  {
    if (paramulc == null) {}
    int i1;
    do
    {
      return;
      paramulc.k();
      i1 = paramulc.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramulc.e();
    ThreadManager.excute(new WSPlayerManager.6(this, paramulc), 16, null, true);
  }
  
  private boolean a(ukz paramukz)
  {
    return a(paramukz) != null;
  }
  
  private boolean a(ulc paramulc)
  {
    return a(paramulc) != null;
  }
  
  private String b(ukz paramukz)
  {
    if (paramukz == null) {
      return "WSPlayerParam is null.";
    }
    if (paramukz.jdField_a_of_type_Uld == null) {
      return "VideoInfo is null.";
    }
    return paramukz.jdField_a_of_type_Uld.d;
  }
  
  private ulc b()
  {
    return a(this.jdField_a_of_type_Ukz);
  }
  
  private void b(ukz paramukz)
  {
    if (paramukz != null) {
      a(paramukz.jdField_a_of_type_Ulc);
    }
  }
  
  private void c(ukz paramukz, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramukz == null) {
      return;
    }
    if ((paramukz.jdField_a_of_type_AndroidViewView != null) && (paramukz.jdField_a_of_type_AndroidViewView.getParent() != paramukz.jdField_a_of_type_AndroidViewViewGroup))
    {
      uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + paramukz.jdField_a_of_type_AndroidViewView.getParent() + ", playerParam.mVideoLayout:" + paramukz.jdField_a_of_type_AndroidViewViewGroup);
      paramukz.jdField_a_of_type_Ulc = null;
      paramukz.jdField_a_of_type_AndroidViewView = null;
    }
    ulc localulc = a(paramukz);
    if ((localulc == null) || (localulc.a() != null))
    {
      boolean bool1 = bool2;
      if (localulc != null)
      {
        bool1 = bool2;
        if (localulc.a() != null)
        {
          localulc.b(false);
          uqf.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
          bool1 = true;
        }
      }
      ThreadManager.post(new WSPlayerManager.2(this, new WeakReference(paramukz), bool1, paramBoolean), 5, null, true);
      return;
    }
    uqf.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
    paramukz.jdField_a_of_type_Ulc.a(paramukz.jdField_a_of_type_Uld);
    d(paramukz, paramBoolean);
  }
  
  private void d(ukz paramukz, boolean paramBoolean)
  {
    ulc localulc = a(paramukz);
    if ((paramukz == null) || (localulc == null) || (paramukz.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      uqf.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] playParam:" + paramukz);
      return;
    }
    paramukz.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (paramukz.jdField_a_of_type_AndroidViewView == null)
    {
      uqf.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
      View localView = localulc.a();
      if (localView == null)
      {
        if (paramukz.jdField_a_of_type_Ukp != null) {
          paramukz.jdField_a_of_type_Ukp.a(paramukz, 999, 999, null);
        }
        paramukz.jdField_a_of_type_Ulc = null;
        return;
      }
      paramukz.jdField_a_of_type_AndroidViewView = localView;
      paramukz.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      localulc.a((IVideoViewBase)localView);
      if (paramukz.jdField_a_of_type_Ukp != null) {
        paramukz.jdField_a_of_type_Ukp.b(paramukz);
      }
      if ((paramukz.jdField_a_of_type_Uld != null) && (paramukz.jdField_a_of_type_Uld.jdField_a_of_type_Int > 0) && (paramukz.jdField_a_of_type_Uld.jdField_b_of_type_Int > 0) && (paramukz.jdField_a_of_type_Uld.jdField_b_of_type_Int < 10000) && (paramukz.jdField_a_of_type_Uld.jdField_a_of_type_Int < 10000)) {
        ((IVideoViewBase)localView).setFixedSize(paramukz.jdField_a_of_type_Uld.jdField_a_of_type_Int, paramukz.jdField_a_of_type_Uld.jdField_b_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localulc.b(i1);
      if ((!this.k) && (!this.g)) {
        break label404;
      }
    }
    label404:
    for (boolean bool = true;; bool = false)
    {
      localulc.c(bool);
      localulc.a(this.h);
      localulc.d(paramukz.jdField_b_of_type_Boolean);
      localulc.a().setOutputMute(this.i);
      uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][innerPlayVideo] xyAxis:" + i1 + ", isMuted:" + this.i + ", mPreOutputFirstFrame:" + this.h);
      paramukz.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramukz, localulc, paramBoolean), 16, null, true);
      return;
      i1 = paramukz.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void e(ukz paramukz, boolean paramBoolean)
  {
    ulm localulm;
    if (paramukz != null)
    {
      if (paramukz.jdField_a_of_type_Ulm == null) {
        paramukz.jdField_a_of_type_Ulm = new ulo();
      }
      localulm = paramukz.jdField_a_of_type_Ulm;
      if (paramukz.jdField_a_of_type_Uld == null) {
        break label57;
      }
    }
    label57:
    for (String str = paramukz.jdField_a_of_type_Uld.jdField_a_of_type_JavaLangString;; str = "")
    {
      localulm.a(str, paramBoolean, paramukz.jdField_a_of_type_JavaLangString);
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
    b(this.jdField_a_of_type_Ukz, false);
  }
  
  private void h()
  {
    uqf.g("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + b(this.jdField_a_of_type_Ukz));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.4(this));
    ulm localulm = a(this.jdField_a_of_type_Ukz);
    if (localulm != null) {
      localulm.b(a(this.jdField_a_of_type_Ukz));
    }
  }
  
  public int a()
  {
    if (b() != null) {
      return b().e();
    }
    return 0;
  }
  
  public ukz a()
  {
    return this.jdField_a_of_type_Ukz;
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
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
    b().b();
    h();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ukz != null) && (b() != null))
    {
      this.j = true;
      b().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Ukz != null) && (this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp != null))
      {
        long l1 = b().b();
        this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp.a(this.jdField_a_of_type_Ukz, paramInt, l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(ukz paramukz)
  {
    uqf.g("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + b(paramukz));
    if (paramukz == null) {
      uqf.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
    }
    ulc localulc;
    do
    {
      do
      {
        return;
        localulc = a(paramukz);
      } while ((localulc != null) && (paramukz.jdField_a_of_type_Boolean) && (localulc.a() == paramukz.jdField_a_of_type_Uld));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      if ((this.jdField_a_of_type_Ule != null) && (!this.jdField_a_of_type_Ule.a()))
      {
        this.jdField_a_of_type_Ule.a();
        return;
      }
    } while ((localulc != null) && (!localulc.a()) && (localulc.e() != 6) && (localulc.e() != 7));
    paramukz.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Ukz = paramukz;
    e(paramukz, true);
    if (this.jdField_b_of_type_Ukz.jdField_a_of_type_Ukp != null) {
      this.jdField_b_of_type_Ukz.jdField_a_of_type_Ukp.a(this.jdField_b_of_type_Ukz);
    }
    c(paramukz, true);
  }
  
  public void a(ukz paramukz, boolean paramBoolean)
  {
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout]");
    if (paramukz == null)
    {
      uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramukz.jdField_a_of_type_AndroidViewView == null) || (paramukz.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + paramukz.jdField_a_of_type_AndroidViewView + ", videoLayout:" + paramukz.jdField_a_of_type_AndroidViewViewGroup);
      return;
    }
    ulc localulc = a(paramukz);
    if (localulc == null)
    {
      uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
      return;
    }
    this.jdField_a_of_type_Ukz = paramukz;
    View localView = paramukz.jdField_a_of_type_AndroidViewView;
    localulc.b(paramukz.jdField_a_of_type_Int);
    localulc.a(localView);
    paramukz.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    localulc.a((IVideoViewBase)localView);
    localulc.a(this.jdField_a_of_type_Ukx);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    if (paramBoolean) {
      g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localulc, jdField_a_of_type_JavaLangObject);
    localulc.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.1(this, paramukz));
  }
  
  public void a(ula paramula)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramula))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramula);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Ukz != null) {
        b(this.jdField_a_of_type_Ukz, false);
      }
      return;
    }
    this.jdField_a_of_type_Ukz = null;
  }
  
  public boolean a()
  {
    return a() == 2;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ukz != null) && (b() != null) && ((b().e() == 3) || (b().e() == 4)))
    {
      b().c();
      if (this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp != null) {
        this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp.e(this.jdField_a_of_type_Ukz);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((ula)localIterator.next()).d(this.jdField_a_of_type_Ukz);
        }
      }
    }
  }
  
  public void b(ukz paramukz, boolean paramBoolean)
  {
    uqf.g("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + b(paramukz));
    if ((paramukz != null) && (paramukz.jdField_a_of_type_Uld != null))
    {
      uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + paramukz.jdField_a_of_type_Uld.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Ukz = paramukz;
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        ((ula)((Iterator)localObject1).next()).a(this.jdField_a_of_type_Ukz);
        continue;
        uqf.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
        return;
      }
    }
    if (this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp != null) {
      this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp.a(this.jdField_a_of_type_Ukz, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-4);
    Object localObject1 = a(paramukz);
    Object localObject2 = a(paramukz);
    if ((localObject1 != null) && (((ulc)localObject1).d()) && (((ulc)localObject1).a() == paramukz.jdField_a_of_type_Uld))
    {
      paramukz.jdField_a_of_type_Boolean = false;
      this.o = false;
      this.jdField_b_of_type_Ukz = null;
      paramukz.jdField_a_of_type_Ulc.f();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Ukx.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramukz.jdField_a_of_type_Ulc);
      }
      if (localObject2 != null)
      {
        ((ulm)localObject2).a(true);
        ((ulm)localObject2).a(2);
        ((ulm)localObject2).a(a(paramukz));
      }
      uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + b(paramukz));
      this.jdField_a_of_type_Ukx.a();
      return;
    }
    if ((paramukz.jdField_a_of_type_Boolean) && ((localObject1 == null) || (((ulc)localObject1).a() == paramukz.jdField_a_of_type_Uld)))
    {
      if (localObject1 != null) {
        ((ulc)localObject1).f();
      }
      this.m = true;
      if (localObject2 != null)
      {
        ((ulm)localObject2).a(false);
        ((ulm)localObject2).a(1);
      }
      localObject2 = new StringBuilder().append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((ulc)localObject1).e());; localObject1 = " ")
      {
        uqf.d("WS_VIDEO_PRE_PLAY", localObject1 + ", title:" + b(paramukz));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
    }
    this.o = false;
    this.jdField_b_of_type_Ukz = null;
    e(this.jdField_a_of_type_Ukz, false);
    if ((this.jdField_a_of_type_Ule != null) && (!this.jdField_a_of_type_Ule.a()))
    {
      this.jdField_a_of_type_Ule.a();
      return;
    }
    c(paramukz, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((b() != null) && (this.jdField_a_of_type_Ukz != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Ukz.jdField_a_of_type_Int)
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
      b().a().setOutputMute(paramBoolean);
    }
    ulc localulc = a(this.jdField_b_of_type_Ukz);
    if ((localulc != null) && (localulc.a() != null)) {
      localulc.a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return a() == 3;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Ukz != null) && (b() != null))
    {
      Object localObject = a(this.jdField_a_of_type_Ukz);
      if (localObject != null) {
        ((ulm)localObject).a(this.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc, this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_Ukz.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp != null) {
        this.jdField_a_of_type_Ukz.jdField_a_of_type_Ukp.g(this.jdField_a_of_type_Ukz);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ula)((Iterator)localObject).next()).a(this.jdField_a_of_type_Ukz, this.jdField_c_of_type_Boolean);
        }
      }
      uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + b(this.jdField_a_of_type_Ukz));
      b(this.jdField_a_of_type_Ukz);
    }
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public void d(boolean paramBoolean)
  {
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = null;
    }
    if (paramBoolean) {
      d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Ukz);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Ukz);
    if ((this.jdField_a_of_type_Ukz != null) && (paramBoolean))
    {
      if (b() != null)
      {
        b().g();
        this.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc = null;
      }
      this.jdField_a_of_type_Ukz = null;
    }
    Object localObject;
    if (this.jdField_b_of_type_Ukz != null)
    {
      localObject = a(this.jdField_b_of_type_Ukz);
      if (localObject != null)
      {
        ((ulc)localObject).g();
        this.jdField_b_of_type_Ukz.jdField_a_of_type_Ulc = null;
      }
      this.o = false;
      this.jdField_b_of_type_Ukz = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ulc localulc = (ulc)((Iterator)localObject).next();
        if ((localulc != null) && (localulc.e() != 8) && ((localulc != b()) || (paramBoolean))) {
          localulc.g();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_Ule != null)
    {
      this.jdField_a_of_type_Ule.b();
      this.jdField_a_of_type_Ule = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_Uku != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Uku);
      this.jdField_a_of_type_Uku = null;
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
    this.g = paramBoolean;
    ulc localulc = b();
    if (localulc != null) {
      localulc.c(paramBoolean);
    }
    localulc = a(this.jdField_b_of_type_Ukz);
    if (localulc != null) {
      localulc.c(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return a() == 6;
  }
  
  public void f()
  {
    this.f = false;
    uqf.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + c());
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
    ulc localulc = b();
    if (localulc != null) {
      if ((!paramBoolean) && (!this.g)) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = true;; bool1 = false)
    {
      localulc.c(bool1);
      localulc = a(this.jdField_b_of_type_Ukz);
      if (localulc != null)
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
        localulc.c(paramBoolean);
      }
      return;
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
    return this.i;
  }
  
  public boolean j()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */