package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.player.report.IWSPlayerReport;
import com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSVideoView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
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

public class WSPlayerManager
  implements WSVideoPluginInstall.OnVideoPluginInstallListener
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new WSPlayerManager.PlayerHandler(this, Looper.getMainLooper());
  private WSPlayerForNetInfoHandler jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerForNetInfoHandler;
  private WSPlayerManager.MediaPlayListenerAdapterImpl jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl = new WSPlayerManager.MediaPlayListenerAdapterImpl(this, null);
  private WSPlayerParam jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  private WSVideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall;
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TVK_NetVideoInfo jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
  private ArrayList<WSPlayerStatusListener> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<WSPlayerWrapper, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private WSPlayerParam jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = true;
  private boolean g = false;
  private boolean h;
  private boolean i;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  
  public WSPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall = new WSVideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerForNetInfoHandler = new WSPlayerForNetInfoHandler(this);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerForNetInfoHandler);
    this.h = true;
  }
  
  private WSPlayerParam a(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam == this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam) {
      return paramWSPlayerParam;
    }
    return null;
  }
  
  private WSPlayerWrapper a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    WSPlayerWrapper localWSPlayerWrapper = new WSPlayerWrapper(this.jdField_a_of_type_AndroidContentContext);
    localWSPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl);
    return localWSPlayerWrapper;
  }
  
  private WSPlayerWrapper a(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      return paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
    }
    return null;
  }
  
  private WSPlayerWrapper a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (paramWSPlayerWrapper == b()) {
      return paramWSPlayerWrapper;
    }
    return null;
  }
  
  private IWSPlayerReport a(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      return paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport;
    }
    return null;
  }
  
  private String a(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam == null) {
      return "WSPlayerParam is null!";
    }
    if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) {
      return "VideoInfo is null!";
    }
    return paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_JavaLangString;
  }
  
  private void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (paramWSPlayerWrapper == null) {}
    int i1;
    do
    {
      return;
      paramWSPlayerWrapper.k();
      i1 = paramWSPlayerWrapper.e();
    } while ((i1 == 7) || (i1 == 8) || (i1 == 0) || (i1 == 6));
    paramWSPlayerWrapper.e();
    ThreadManager.excute(new WSPlayerManager.6(this, paramWSPlayerWrapper), 16, null, true);
  }
  
  private boolean a(WSPlayerParam paramWSPlayerParam)
  {
    return a(paramWSPlayerParam) != null;
  }
  
  private boolean a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    return a(paramWSPlayerWrapper) != null;
  }
  
  private WSPlayerWrapper b()
  {
    return a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
  }
  
  private String b(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam == null) {
      return "WSPlayerParam is null.";
    }
    if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) {
      return "VideoInfo is null.";
    }
    return paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.d;
  }
  
  private void b(WSPlayerParam paramWSPlayerParam)
  {
    if (paramWSPlayerParam != null) {
      a(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper);
    }
  }
  
  private void c(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramWSPlayerParam == null) {
      return;
    }
    if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null)
    {
      localObject = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView.a();
      if ((localObject != null) && (((View)localObject).getParent() != paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup))
      {
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:" + ((View)localObject).getParent() + ", playerParam.mVideoLayout:" + paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup);
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = null;
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = null;
      }
    }
    Object localObject = a(paramWSPlayerParam);
    if ((localObject == null) || (((WSPlayerWrapper)localObject).a() != null))
    {
      boolean bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((WSPlayerWrapper)localObject).a() != null)
        {
          ((WSPlayerWrapper)localObject).b(false);
          WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] videoPlayer.tag isn't null!");
          bool1 = true;
        }
      }
      ThreadManager.post(new WSPlayerManager.2(this, new WeakReference(paramWSPlayerParam), bool1, paramBoolean), 5, null, true);
      return;
    }
    WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
    paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.a(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo);
    d(paramWSPlayerParam, paramBoolean);
  }
  
  private void d(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    WSPlayerWrapper localWSPlayerWrapper = a(paramWSPlayerParam);
    if ((paramWSPlayerParam == null) || (localWSPlayerWrapper == null) || (paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      WSLog.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] playParam:" + paramWSPlayerParam);
      return;
    }
    paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    Object localObject;
    if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView == null)
    {
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
      localObject = localWSPlayerWrapper.a();
      View localView;
      if (localObject != null)
      {
        localView = ((IWSVideoView)localObject).a();
        if (localView != null) {}
      }
      else
      {
        if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
          paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(paramWSPlayerParam, 999, 999, null);
        }
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = null;
        return;
      }
      paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = ((IWSVideoView)localObject);
      paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      localWSPlayerWrapper.a((IWSVideoView)localObject);
      if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.b(paramWSPlayerParam);
      }
      if ((paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_Int > 0) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_Int > 0) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_Int < 10000) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_Int < 10000)) {
        ((IWSVideoView)localObject).a(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_Int, paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localWSPlayerWrapper.b(i1);
      if ((!this.k) && (!this.g)) {
        break label425;
      }
    }
    label425:
    for (boolean bool = true;; bool = false)
    {
      localWSPlayerWrapper.c(bool);
      localWSPlayerWrapper.a(this.h);
      localWSPlayerWrapper.d(paramWSPlayerParam.jdField_b_of_type_Boolean);
      localWSPlayerWrapper.a().b(this.i);
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][innerPlayVideo] xyAxis:" + i1 + ", isMuted:" + this.i + ", mPreOutputFirstFrame:" + this.h);
      localObject = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView.a();
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramWSPlayerParam, localWSPlayerWrapper, paramBoolean), 16, null, true);
      return;
      i1 = paramWSPlayerParam.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void e(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    IWSPlayerReport localIWSPlayerReport;
    if (paramWSPlayerParam != null)
    {
      if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport == null) {
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport = new WSPlayerReportImpl();
      }
      localIWSPlayerReport = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport;
      if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) {
        break label57;
      }
    }
    label57:
    for (String str = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_JavaLangString;; str = "")
    {
      localIWSPlayerReport.a(str, paramBoolean, paramWSPlayerParam.jdField_a_of_type_JavaLangString);
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
    b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
  }
  
  private void i()
  {
    WSLog.g("WS_VIDEO_PLAYER", "<------------------------------- [WSPlayerManager.java][onVideoStart] title:" + b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.4(this));
    IWSPlayerReport localIWSPlayerReport = a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    if (localIWSPlayerReport != null) {
      localIWSPlayerReport.b(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam));
    }
  }
  
  public int a()
  {
    if (b() != null) {
      return b().e();
    }
    return 0;
  }
  
  public WSPlayerParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
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
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
    b().b();
    i();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (b() != null))
    {
      this.j = true;
      b().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null))
      {
        long l1 = b().b();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, paramInt, l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.g("WS_VIDEO_PRE_PLAY", "===============================> [WSPlayerManager.java][prePlayVideo] title:" + b(paramWSPlayerParam));
    if (paramWSPlayerParam == null) {
      WSLog.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
    }
    WSPlayerWrapper localWSPlayerWrapper;
    do
    {
      do
      {
        return;
        localWSPlayerWrapper = a(paramWSPlayerParam);
      } while ((localWSPlayerWrapper != null) && (paramWSPlayerParam.jdField_a_of_type_Boolean) && (localWSPlayerWrapper.a() == paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a();
        return;
      }
    } while ((localWSPlayerWrapper != null) && (!localWSPlayerWrapper.a()) && (localWSPlayerWrapper.e() != 6) && (localWSPlayerWrapper.e() != 7));
    paramWSPlayerParam.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
    e(paramWSPlayerParam, true);
    if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    }
    c(paramWSPlayerParam, true);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] startTime:" + System.currentTimeMillis());
    if (paramWSPlayerParam == null)
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView == null) || (paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:" + paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView + ", videoLayout:" + paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup);
      return;
    }
    WSPlayerWrapper localWSPlayerWrapper = a(paramWSPlayerParam);
    if (localWSPlayerWrapper == null)
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
    localWSPlayerWrapper.b(paramWSPlayerParam.jdField_a_of_type_Int);
    localWSPlayerWrapper.a(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView, paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup);
    localWSPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    if (paramBoolean) {
      h();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localWSPlayerWrapper, jdField_a_of_type_JavaLangObject);
    localWSPlayerWrapper.h();
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.1(this, paramWSPlayerParam));
  }
  
  public void a(WSPlayerStatusListener paramWSPlayerStatusListener)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWSPlayerStatusListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramWSPlayerStatusListener);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) {
        b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
  }
  
  public boolean a()
  {
    return a() == 2;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (b() != null) && ((b().e() == 3) || (b().e() == 4)))
    {
      b().c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.e(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((WSPlayerStatusListener)localIterator.next()).d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
        }
      }
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    WSLog.g("WS_VIDEO_PLAYER", "-------------------------------> [WSPlayerManager.java][playVideo] title:" + b(paramWSPlayerParam));
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null))
    {
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] videoUrl:" + paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        ((WSPlayerStatusListener)((Iterator)localObject1).next()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
        continue;
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, paramBoolean);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-4);
    Object localObject1 = a(paramWSPlayerParam);
    Object localObject2 = a(paramWSPlayerParam);
    if ((localObject1 != null) && (((WSPlayerWrapper)localObject1).e()) && (((WSPlayerWrapper)localObject1).a() == paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo))
    {
      paramWSPlayerParam.jdField_a_of_type_Boolean = false;
      this.o = false;
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
      paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.f();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper);
      }
      if (localObject2 != null)
      {
        ((IWSPlayerReport)localObject2).a(true);
        ((IWSPlayerReport)localObject2).a(2);
        ((IWSPlayerReport)localObject2).a(a(paramWSPlayerParam));
      }
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:" + b(paramWSPlayerParam));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl.a();
      return;
    }
    if ((paramWSPlayerParam.jdField_a_of_type_Boolean) && ((localObject1 == null) || (((WSPlayerWrapper)localObject1).a() == paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo)))
    {
      if (localObject1 != null) {
        ((WSPlayerWrapper)localObject1).f();
      }
      this.m = true;
      if (localObject2 != null)
      {
        ((IWSPlayerReport)localObject2).a(false);
        ((IWSPlayerReport)localObject2).a(1);
      }
      localObject2 = new StringBuilder().append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((WSPlayerWrapper)localObject1).e());; localObject1 = " ")
      {
        WSLog.d("WS_VIDEO_PRE_PLAY", localObject1 + ", title:" + b(paramWSPlayerParam));
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
    }
    this.o = false;
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    e(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a();
      return;
    }
    c(paramWSPlayerParam, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((b() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_Int)
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
    WSPlayerWrapper localWSPlayerWrapper = a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    if ((localWSPlayerWrapper != null) && (localWSPlayerWrapper.a() != null)) {
      localWSPlayerWrapper.a().b(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return a() == 3;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (b() != null))
    {
      Object localObject = a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      if (localObject != null) {
        ((IWSPlayerReport)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper, this.jdField_c_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.g(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((WSPlayerStatusListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, this.jdField_c_of_type_Boolean);
        }
      }
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][stop] title:" + b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam));
      b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public void d(boolean paramBoolean)
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnDestroy] isStopVideo:" + paramBoolean);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = null;
    }
    if (paramBoolean) {
      d();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (paramBoolean))
    {
      if (b() != null)
      {
        b().g();
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = null;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    }
    Object localObject;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam))
    {
      localObject = a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      if (localObject != null)
      {
        ((WSPlayerWrapper)localObject).g();
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = null;
      }
      this.o = false;
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WSPlayerWrapper localWSPlayerWrapper = (WSPlayerWrapper)((Iterator)localObject).next();
        if ((localWSPlayerWrapper != null) && (localWSPlayerWrapper.e() != 8) && ((localWSPlayerWrapper != b()) || (paramBoolean))) {
          localWSPlayerWrapper.g();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerForNetInfoHandler != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerForNetInfoHandler);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerForNetInfoHandler = null;
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
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnResume] mIsNeedStartOnResume:" + this.n + ", mIsNeedRestartOnResume:" + this.l);
    this.f = true;
    if ((this.n) && (b() != null) && (b().e())) {
      a();
    }
    label127:
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
            break label127;
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
    WSPlayerWrapper localWSPlayerWrapper = b();
    if (localWSPlayerWrapper != null) {
      localWSPlayerWrapper.c(paramBoolean);
    }
    localWSPlayerWrapper = a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    if (localWSPlayerWrapper != null) {
      localWSPlayerWrapper.c(paramBoolean);
    }
  }
  
  public boolean e()
  {
    return a() == 6;
  }
  
  public void f()
  {
    this.f = false;
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][doOnPause] isPlaying:" + c());
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
    WSPlayerWrapper localWSPlayerWrapper = b();
    if (localWSPlayerWrapper != null) {
      if ((!paramBoolean) && (!this.g)) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = true;; bool1 = false)
    {
      localWSPlayerWrapper.c(bool1);
      localWSPlayerWrapper = a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      if (localWSPlayerWrapper != null)
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
        localWSPlayerWrapper.c(paramBoolean);
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
    WSPlayerWrapper localWSPlayerWrapper = b();
    if (localWSPlayerWrapper != null) {
      localWSPlayerWrapper.h();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */