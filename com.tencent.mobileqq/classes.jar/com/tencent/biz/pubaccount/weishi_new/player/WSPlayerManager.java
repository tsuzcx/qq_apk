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
import vfs;
import vfx;
import vfz;
import vga;
import vgb;
import vgc;
import vgh;
import vgi;
import vgj;
import vgl;
import vgq;
import vgs;
import vgv;
import vhc;
import vmp;

public class WSPlayerManager
  implements vgl
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new vga(this, Looper.getMainLooper());
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private ArrayList<vgc> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<vgh, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private vfx jdField_a_of_type_Vfx;
  private vfz jdField_a_of_type_Vfz = new vfz(this, null);
  private vgb jdField_a_of_type_Vgb;
  private vgj jdField_a_of_type_Vgj;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private vgb jdField_b_of_type_Vgb;
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
    this.jdField_a_of_type_Vgj = new vgj();
    this.jdField_a_of_type_Vgj.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Vfx = new vfx(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vfx);
    this.h = true;
  }
  
  private String a(vgb paramvgb)
  {
    if (paramvgb == null) {
      return "WSPlayerParam is null!";
    }
    if (paramvgb.jdField_a_of_type_Vgi == null) {
      return "VideoInfo is null!";
    }
    return paramvgb.jdField_a_of_type_Vgi.jdField_b_of_type_JavaLangString;
  }
  
  private vgb a(vgb paramvgb)
  {
    if (paramvgb == this.jdField_a_of_type_Vgb) {
      return paramvgb;
    }
    return null;
  }
  
  private vgh a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    vgh localvgh = new vgh(this.jdField_a_of_type_AndroidContentContext);
    localvgh.a(this.jdField_a_of_type_Vfz);
    return localvgh;
  }
  
  private vgh a(vgb paramvgb)
  {
    if (paramvgb != null) {
      return paramvgb.jdField_a_of_type_Vgh;
    }
    return null;
  }
  
  private vgh a(vgh paramvgh)
  {
    if (paramvgh == b()) {
      return paramvgh;
    }
    return null;
  }
  
  private vgq a(vgb paramvgb)
  {
    if (paramvgb != null) {
      return paramvgb.jdField_a_of_type_Vgq;
    }
    return null;
  }
  
  private void a(vgh paramvgh)
  {
    if (paramvgh == null) {}
    int i1;
    do
    {
      return;
      paramvgh.k();
      i1 = paramvgh.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramvgh.e();
    ThreadManager.excute(new WSPlayerManager.6(this, paramvgh), 16, null, true);
  }
  
  private boolean a(vgb paramvgb)
  {
    return a(paramvgb) != null;
  }
  
  private boolean a(vgh paramvgh)
  {
    return a(paramvgh) != null;
  }
  
  private String b(vgb paramvgb)
  {
    if (paramvgb == null) {
      return "WSPlayerParam is null.";
    }
    if (paramvgb.jdField_a_of_type_Vgi == null) {
      return "VideoInfo is null.";
    }
    return paramvgb.jdField_a_of_type_Vgi.d;
  }
  
  private vgh b()
  {
    return a(this.jdField_a_of_type_Vgb);
  }
  
  private void b(vgb paramvgb)
  {
    if (paramvgb != null) {
      a(paramvgb.jdField_a_of_type_Vgh);
    }
  }
  
  private void c(vgb paramvgb, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramvgb == null) {
      return;
    }
    if (paramvgb.jdField_a_of_type_Vhc != null)
    {
      localObject = paramvgb.jdField_a_of_type_Vhc.a();
      if ((localObject != null) && (((View)localObject).getParent() != paramvgb.jdField_a_of_type_AndroidViewViewGroup))
      {
        vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + ((View)localObject).getParent() + ", playerParam.mVideoLayout:" + paramvgb.jdField_a_of_type_AndroidViewViewGroup);
        paramvgb.jdField_a_of_type_Vgh = null;
        paramvgb.jdField_a_of_type_Vhc = null;
      }
    }
    Object localObject = a(paramvgb);
    if ((localObject == null) || (((vgh)localObject).a() != null))
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((vgh)localObject).a() != null)
        {
          ((vgh)localObject).b(false);
          vmp.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
          bool1 = true;
        }
      }
      ThreadManager.post(new WSPlayerManager.2(this, new WeakReference(paramvgb), bool1, paramBoolean), 5, null, true);
      return;
    }
    vmp.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
    paramvgb.jdField_a_of_type_Vgh.a(paramvgb.jdField_a_of_type_Vgi);
    d(paramvgb, paramBoolean);
  }
  
  private void d(vgb paramvgb, boolean paramBoolean)
  {
    vgh localvgh = a(paramvgb);
    if ((paramvgb == null) || (localvgh == null) || (paramvgb.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      vmp.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] playParam:" + paramvgb);
      return;
    }
    paramvgb.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramvgb.jdField_a_of_type_Vhc == null)
    {
      vmp.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
      localObject = localvgh.a();
      View localView;
      if (localObject != null)
      {
        localView = ((vhc)localObject).a();
        if (localView != null) {}
      }
      else
      {
        if (paramvgb.jdField_a_of_type_Vfs != null) {
          paramvgb.jdField_a_of_type_Vfs.a(paramvgb, 999, 999, null);
        }
        paramvgb.jdField_a_of_type_Vgh = null;
        return;
      }
      paramvgb.jdField_a_of_type_Vhc = ((vhc)localObject);
      paramvgb.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      localvgh.a((vhc)localObject);
      if (paramvgb.jdField_a_of_type_Vfs != null) {
        paramvgb.jdField_a_of_type_Vfs.b(paramvgb);
      }
      if ((paramvgb.jdField_a_of_type_Vgi != null) && (paramvgb.jdField_a_of_type_Vgi.jdField_a_of_type_Int > 0) && (paramvgb.jdField_a_of_type_Vgi.jdField_b_of_type_Int > 0) && (paramvgb.jdField_a_of_type_Vgi.jdField_b_of_type_Int < 10000) && (paramvgb.jdField_a_of_type_Vgi.jdField_a_of_type_Int < 10000)) {
        ((vhc)localObject).a(paramvgb.jdField_a_of_type_Vgi.jdField_a_of_type_Int, paramvgb.jdField_a_of_type_Vgi.jdField_b_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localvgh.b(i1);
      if ((!this.k) && (!this.g)) {
        break label425;
      }
    }
    label425:
    for (boolean bool = true;; bool = false)
    {
      localvgh.c(bool);
      localvgh.a(this.h);
      localvgh.d(paramvgb.jdField_b_of_type_Boolean);
      localvgh.a().b(this.i);
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][innerPlayVideo] xyAxis:" + i1 + ", isMuted:" + this.i + ", mPreOutputFirstFrame:" + this.h);
      localObject = paramvgb.jdField_a_of_type_Vhc.a();
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramvgb, localvgh, paramBoolean), 16, null, true);
      return;
      i1 = paramvgb.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void e(vgb paramvgb, boolean paramBoolean)
  {
    vgq localvgq;
    if (paramvgb != null)
    {
      if (paramvgb.jdField_a_of_type_Vgq == null) {
        paramvgb.jdField_a_of_type_Vgq = new vgs();
      }
      localvgq = paramvgb.jdField_a_of_type_Vgq;
      if (paramvgb.jdField_a_of_type_Vgi == null) {
        break label57;
      }
    }
    label57:
    for (String str = paramvgb.jdField_a_of_type_Vgi.jdField_a_of_type_JavaLangString;; str = "")
    {
      localvgq.a(str, paramBoolean, paramvgb.jdField_a_of_type_JavaLangString);
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
    b(this.jdField_a_of_type_Vgb, false);
  }
  
  private void i()
  {
    vmp.g("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + b(this.jdField_a_of_type_Vgb));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.4(this));
    vgq localvgq = a(this.jdField_a_of_type_Vgb);
    if (localvgq != null) {
      localvgq.b(a(this.jdField_a_of_type_Vgb));
    }
  }
  
  public int a()
  {
    if (b() != null) {
      return b().e();
    }
    return 0;
  }
  
  public vgb a()
  {
    return this.jdField_a_of_type_Vgb;
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
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
    b().b();
    i();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Vgb != null) && (b() != null))
    {
      this.j = true;
      b().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_Vgb != null) && (this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs != null))
      {
        long l1 = b().b();
        this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs.a(this.jdField_a_of_type_Vgb, paramInt, l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(vgb paramvgb)
  {
    vmp.g("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + b(paramvgb));
    if (paramvgb == null) {
      vmp.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
    }
    vgh localvgh;
    do
    {
      do
      {
        return;
        localvgh = a(paramvgb);
      } while ((localvgh != null) && (paramvgb.jdField_a_of_type_Boolean) && (localvgh.a() == paramvgb.jdField_a_of_type_Vgi));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      if ((this.jdField_a_of_type_Vgj != null) && (!this.jdField_a_of_type_Vgj.a()))
      {
        this.jdField_a_of_type_Vgj.a();
        return;
      }
    } while ((localvgh != null) && (!localvgh.a()) && (localvgh.e() != 6) && (localvgh.e() != 7));
    paramvgb.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Vgb = paramvgb;
    e(paramvgb, true);
    if (this.jdField_b_of_type_Vgb.jdField_a_of_type_Vfs != null) {
      this.jdField_b_of_type_Vgb.jdField_a_of_type_Vfs.a(this.jdField_b_of_type_Vgb);
    }
    c(paramvgb, true);
  }
  
  public void a(vgb paramvgb, boolean paramBoolean)
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] startTime:" + System.currentTimeMillis());
    if (paramvgb == null)
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramvgb.jdField_a_of_type_Vhc == null) || (paramvgb.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + paramvgb.jdField_a_of_type_Vhc + ", videoLayout:" + paramvgb.jdField_a_of_type_AndroidViewViewGroup);
      return;
    }
    vgh localvgh = a(paramvgb);
    if (localvgh == null)
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
      return;
    }
    this.jdField_a_of_type_Vgb = paramvgb;
    localvgh.b(paramvgb.jdField_a_of_type_Int);
    localvgh.a(paramvgb.jdField_a_of_type_Vhc, paramvgb.jdField_a_of_type_AndroidViewViewGroup);
    localvgh.a(this.jdField_a_of_type_Vfz);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    if (paramBoolean) {
      h();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localvgh, jdField_a_of_type_JavaLangObject);
    localvgh.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.1(this, paramvgb));
  }
  
  public void a(vgc paramvgc)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramvgc))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramvgc);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Vgb != null) {
        b(this.jdField_a_of_type_Vgb, false);
      }
      return;
    }
    this.jdField_a_of_type_Vgb = null;
  }
  
  public boolean a()
  {
    return a() == 2;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vgb != null) && (b() != null) && ((b().e() == 3) || (b().e() == 4)))
    {
      b().c();
      if (this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs != null) {
        this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs.e(this.jdField_a_of_type_Vgb);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((vgc)localIterator.next()).d(this.jdField_a_of_type_Vgb);
        }
      }
    }
  }
  
  public void b(vgb paramvgb, boolean paramBoolean)
  {
    vmp.g("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + b(paramvgb));
    if ((paramvgb != null) && (paramvgb.jdField_a_of_type_Vgi != null))
    {
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + paramvgb.jdField_a_of_type_Vgi.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_Vgb = paramvgb;
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        ((vgc)((Iterator)localObject1).next()).a(this.jdField_a_of_type_Vgb);
        continue;
        vmp.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
        return;
      }
    }
    if (this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs != null) {
      this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs.a(this.jdField_a_of_type_Vgb, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-4);
    Object localObject1 = a(paramvgb);
    Object localObject2 = a(paramvgb);
    if ((localObject1 != null) && (((vgh)localObject1).e()) && (((vgh)localObject1).a() == paramvgb.jdField_a_of_type_Vgi))
    {
      paramvgb.jdField_a_of_type_Boolean = false;
      this.o = false;
      this.jdField_b_of_type_Vgb = null;
      paramvgb.jdField_a_of_type_Vgh.f();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_Vfz.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramvgb.jdField_a_of_type_Vgh);
      }
      if (localObject2 != null)
      {
        ((vgq)localObject2).a(true);
        ((vgq)localObject2).a(2);
        ((vgq)localObject2).a(a(paramvgb));
      }
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + b(paramvgb));
      this.jdField_a_of_type_Vfz.a();
      return;
    }
    if ((paramvgb.jdField_a_of_type_Boolean) && ((localObject1 == null) || (((vgh)localObject1).a() == paramvgb.jdField_a_of_type_Vgi)))
    {
      if (localObject1 != null) {
        ((vgh)localObject1).f();
      }
      this.m = true;
      if (localObject2 != null)
      {
        ((vgq)localObject2).a(false);
        ((vgq)localObject2).a(1);
      }
      localObject2 = new StringBuilder().append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((vgh)localObject1).e());; localObject1 = " ")
      {
        vmp.d("WS_VIDEO_PRE_PLAY", localObject1 + ", title:" + b(paramvgb));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
    }
    this.o = false;
    this.jdField_b_of_type_Vgb = null;
    e(this.jdField_a_of_type_Vgb, false);
    if ((this.jdField_a_of_type_Vgj != null) && (!this.jdField_a_of_type_Vgj.a()))
    {
      this.jdField_a_of_type_Vgj.a();
      return;
    }
    c(paramvgb, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((b() != null) && (this.jdField_a_of_type_Vgb != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_Vgb.jdField_a_of_type_Int)
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
    vgh localvgh = a(this.jdField_b_of_type_Vgb);
    if ((localvgh != null) && (localvgh.a() != null)) {
      localvgh.a().b(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return a() == 3;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Vgb != null) && (b() != null))
    {
      Object localObject = a(this.jdField_a_of_type_Vgb);
      if (localObject != null) {
        ((vgq)localObject).a(this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh, this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_Vgb.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs != null) {
        this.jdField_a_of_type_Vgb.jdField_a_of_type_Vfs.g(this.jdField_a_of_type_Vgb);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((vgc)((Iterator)localObject).next()).a(this.jdField_a_of_type_Vgb, this.jdField_c_of_type_Boolean);
        }
      }
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + b(this.jdField_a_of_type_Vgb));
      b(this.jdField_a_of_type_Vgb);
    }
    if (this.jdField_a_of_type_Vgb != null) {
      this.jdField_a_of_type_Vgb = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public void d(boolean paramBoolean)
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = null;
    }
    if (paramBoolean) {
      d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_Vgb);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_Vgb);
    if ((this.jdField_a_of_type_Vgb != null) && (paramBoolean))
    {
      if (b() != null)
      {
        b().g();
        this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh = null;
      }
      this.jdField_a_of_type_Vgb = null;
    }
    Object localObject;
    if ((this.jdField_b_of_type_Vgb != null) && (this.jdField_b_of_type_Vgb != this.jdField_a_of_type_Vgb))
    {
      localObject = a(this.jdField_b_of_type_Vgb);
      if (localObject != null)
      {
        ((vgh)localObject).g();
        this.jdField_b_of_type_Vgb.jdField_a_of_type_Vgh = null;
      }
      this.o = false;
      this.jdField_b_of_type_Vgb = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        vgh localvgh = (vgh)((Iterator)localObject).next();
        if ((localvgh != null) && (localvgh.e() != 8) && ((localvgh != b()) || (paramBoolean))) {
          localvgh.g();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_Vgj != null)
    {
      this.jdField_a_of_type_Vgj.b();
      this.jdField_a_of_type_Vgj = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_Vfx != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Vfx);
      this.jdField_a_of_type_Vfx = null;
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
    vgh localvgh = b();
    if (localvgh != null) {
      localvgh.c(paramBoolean);
    }
    localvgh = a(this.jdField_b_of_type_Vgb);
    if (localvgh != null) {
      localvgh.c(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return a() == 6;
  }
  
  public void f()
  {
    this.f = false;
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + c());
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
    vgh localvgh = b();
    if (localvgh != null) {
      if ((!paramBoolean) && (!this.g)) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = true;; bool1 = false)
    {
      localvgh.c(bool1);
      localvgh = a(this.jdField_b_of_type_Vgb);
      if (localvgh != null)
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
        localvgh.c(paramBoolean);
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
    vgh localvgh = b();
    if (localvgh != null) {
      localvgh.h();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */