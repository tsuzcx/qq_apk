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
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
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
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return null;
    }
    localObject = new WSPlayerWrapper((Context)localObject);
    ((WSPlayerWrapper)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl);
    return localObject;
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
    if (paramWSPlayerWrapper == null) {
      return;
    }
    paramWSPlayerWrapper.k();
    int i1 = paramWSPlayerWrapper.e();
    if ((i1 != 7) && (i1 != 8) && (i1 != 0))
    {
      if (i1 == 6) {
        return;
      }
      paramWSPlayerWrapper.e();
      ThreadManager.excute(new WSPlayerManager.6(this, paramWSPlayerWrapper), 16, null, true);
    }
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
    if (paramWSPlayerParam == null) {
      return;
    }
    if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null)
    {
      localObject = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView.a();
      if ((localObject != null) && (((View)localObject).getParent() != paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSPlayerManager.java][createVideoPlayerAndPlay] playerParam.mVideoView.getParent:");
        localStringBuilder.append(((View)localObject).getParent());
        localStringBuilder.append(", playerParam.mVideoLayout:");
        localStringBuilder.append(paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup);
        WSLog.d("WS_VIDEO_PLAYER", localStringBuilder.toString());
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = null;
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = null;
      }
    }
    Object localObject = a(paramWSPlayerParam);
    if ((localObject != null) && (((WSPlayerWrapper)localObject).a() == null))
    {
      WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][createVideoPlayerAndPlay] hit getVideoPlayerFromParam. goto innerPlayVideo!");
      paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.a(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo);
      d(paramWSPlayerParam, paramBoolean);
      return;
    }
    boolean bool2 = false;
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
  }
  
  private void d(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject1 = a(paramWSPlayerParam);
    if ((paramWSPlayerParam != null) && (localObject1 != null) && (paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
      if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView == null)
      {
        WSLog.e("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][innerPlayVideo] videoView null. goto getVideoViewScroll.");
        localObject2 = ((WSPlayerWrapper)localObject1).a();
        if (localObject2 != null)
        {
          View localView = ((IWSVideoView)localObject2).a();
          if (localView != null)
          {
            paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = ((IWSVideoView)localObject2);
            paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
            ((WSPlayerWrapper)localObject1).a((IWSVideoView)localObject2);
            if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
              paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.b(paramWSPlayerParam);
            }
            if ((paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_Int <= 0) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_Int <= 0) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_Int >= 10000) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_Int >= 10000)) {
              break label234;
            }
            ((IWSVideoView)localObject2).a(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_Int, paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_Int);
            break label234;
          }
        }
        if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
          paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(paramWSPlayerParam, 999, 999, null);
        }
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = null;
        return;
      }
      label234:
      int i1;
      if (this.jdField_a_of_type_Boolean) {
        i1 = 2;
      } else {
        i1 = paramWSPlayerParam.jdField_a_of_type_Int;
      }
      ((WSPlayerWrapper)localObject1).b(i1);
      boolean bool;
      if ((!this.k) && (!this.g)) {
        bool = false;
      } else {
        bool = true;
      }
      ((WSPlayerWrapper)localObject1).c(bool);
      ((WSPlayerWrapper)localObject1).a(this.h);
      ((WSPlayerWrapper)localObject1).d(paramWSPlayerParam.jdField_b_of_type_Boolean);
      ((WSPlayerWrapper)localObject1).a().b(this.i);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[WSPlayerManager.java][innerPlayVideo] xyAxis:");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", isMuted:");
      ((StringBuilder)localObject2).append(this.i);
      ((StringBuilder)localObject2).append(", mPreOutputFirstFrame:");
      ((StringBuilder)localObject2).append(this.h);
      WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject2).toString());
      localObject2 = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView.a();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      ThreadManager.excute(new WSPlayerManager.PlayStartVideoRunnable(this, paramWSPlayerParam, (WSPlayerWrapper)localObject1, paramBoolean), 16, null, true);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSPlayerManager.java][innerPlayVideo] playParam:");
    ((StringBuilder)localObject1).append(paramWSPlayerParam);
    WSLog.d("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject1).toString());
  }
  
  private void e(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (paramWSPlayerParam != null)
    {
      if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport == null) {
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport = new WSPlayerReportImpl();
      }
      IWSPlayerReport localIWSPlayerReport = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport;
      String str;
      if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null) {
        str = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
      localIWSPlayerReport.a(str, paramBoolean, paramWSPlayerParam.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void h()
  {
    if (b())
    {
      c();
      return;
    }
    if ((a()) || (e()) || (d()) || (h())) {
      b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
    }
  }
  
  private void i()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<------------------------------- [WSPlayerManager.java][onVideoStart] title:");
    ((StringBuilder)localObject).append(b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam));
    WSLog.g("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.4(this));
    localObject = a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    if (localObject != null) {
      ((IWSPlayerReport)localObject).b(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam));
    }
  }
  
  public int a()
  {
    if (b() != null) {
      return b().e();
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (b() != null)) {
      return b().a();
    }
    return 0L;
  }
  
  public WSPlayerParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  }
  
  public void a()
  {
    if (b() != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new WSPlayerManager.3(this));
        return;
      }
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][start] videoPlayer.start!");
      b().b();
      i();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (b() != null))
    {
      this.j = true;
      b().a(paramInt);
      if (paramBoolean)
      {
        WSPlayerParam localWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
        if ((localWSPlayerParam != null) && (localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null))
        {
          long l1 = b().b();
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, paramInt, l1);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("===============================> [WSPlayerManager.java][prePlayVideo] title:");
    ((StringBuilder)localObject).append(b(paramWSPlayerParam));
    WSLog.g("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
    if (paramWSPlayerParam == null)
    {
      WSLog.d("WS_VIDEO_PRE_PLAY", "[WSPlayerManager.java][prePlayVideo] playerParam is null.");
      return;
    }
    localObject = a(paramWSPlayerParam);
    if ((localObject != null) && (paramWSPlayerParam.jdField_a_of_type_Boolean) && (((WSPlayerWrapper)localObject).a() == paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo = null;
    WSVideoPluginInstall localWSVideoPluginInstall = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall;
    if ((localWSVideoPluginInstall != null) && (!localWSVideoPluginInstall.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a();
      return;
    }
    if ((localObject == null) || (((WSPlayerWrapper)localObject).a()) || (((WSPlayerWrapper)localObject).e() == 6) || (((WSPlayerWrapper)localObject).e() == 7))
    {
      paramWSPlayerParam.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
      e(paramWSPlayerParam, true);
      if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      }
      c(paramWSPlayerParam, true);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][switchPlayerVideoViewLayout] startTime:");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    if (paramWSPlayerParam == null)
    {
      WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] playerParam null.");
      return;
    }
    if ((paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null) && (paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      localObject = a(paramWSPlayerParam);
      if (localObject == null)
      {
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][switchPlayerVideoViewLayout] videoPlayer null.");
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
      ((WSPlayerWrapper)localObject).b(paramWSPlayerParam.jdField_a_of_type_Int);
      ((WSPlayerWrapper)localObject).a(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView, paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup);
      ((WSPlayerWrapper)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
      if (paramBoolean) {
        h();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, jdField_a_of_type_JavaLangObject);
      ((WSPlayerWrapper)localObject).h();
      this.jdField_a_of_type_AndroidOsHandler.post(new WSPlayerManager.1(this, paramWSPlayerParam));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][switchPlayerVideoViewLayout] videoView:");
    ((StringBuilder)localObject).append(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView);
    ((StringBuilder)localObject).append(", videoLayout:");
    ((StringBuilder)localObject).append(paramWSPlayerParam.jdField_a_of_type_AndroidViewViewGroup);
    WSLog.d("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
  }
  
  public void a(WSPlayerStatusListener paramWSPlayerStatusListener)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.contains(paramWSPlayerStatusListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramWSPlayerStatusListener);
    }
  }
  
  public void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][onInstallComplete] success:");
    ((StringBuilder)localObject).append(paramBoolean);
    WSLog.d("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
      if (localObject != null) {
        b((WSPlayerParam)localObject, false);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    }
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
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((WSPlayerStatusListener)((Iterator)localObject).next()).d(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
        }
      }
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-------------------------------> [WSPlayerManager.java][playVideo] title:");
    ((StringBuilder)localObject1).append(b(paramWSPlayerParam));
    WSLog.g("WS_VIDEO_PLAYER", ((StringBuilder)localObject1).toString());
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[WSPlayerManager.java][playVideo] videoUrl:");
      ((StringBuilder)localObject1).append(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_b_of_type_JavaLangString);
      WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject1).toString());
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
      this.jdField_b_of_type_Int = 0;
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((WSPlayerStatusListener)((Iterator)localObject1).next()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, paramBoolean);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-4);
      localObject1 = a(paramWSPlayerParam);
      Object localObject2 = a(paramWSPlayerParam);
      if ((localObject1 != null) && (((WSPlayerWrapper)localObject1).e()) && (((WSPlayerWrapper)localObject1).a() == paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo))
      {
        paramWSPlayerParam.jdField_a_of_type_Boolean = false;
        this.o = false;
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
        paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.f();
        localObject1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo;
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager$MediaPlayListenerAdapterImpl.a((TVK_NetVideoInfo)localObject1, paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper);
        }
        if (localObject2 != null)
        {
          ((IWSPlayerReport)localObject2).a(true);
          ((IWSPlayerReport)localObject2).a(2);
          ((IWSPlayerReport)localObject2).a(a(paramWSPlayerParam));
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[WSPlayerManager.java][playVideo] hasPrePlay, just go startVideoAfterPrepared! title:");
        ((StringBuilder)localObject1).append(b(paramWSPlayerParam));
        WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject1).toString());
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[WSPlayerManager.java][playVideo] prePlaying, just do nothing! playerStatus:");
        if (localObject1 != null) {
          localObject1 = Integer.valueOf(((WSPlayerWrapper)localObject1).e());
        } else {
          localObject1 = " ";
        }
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(", title:");
        ((StringBuilder)localObject2).append(b(paramWSPlayerParam));
        WSLog.d("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject2).toString());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 150L);
        return;
      }
      this.o = false;
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
      e(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall;
      if ((localObject1 != null) && (!((WSVideoPluginInstall)localObject1).a()))
      {
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] installPlugin!");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall.a();
        return;
      }
      WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] createVideoPlayerAndPlay!");
      c(paramWSPlayerParam, false);
      return;
    }
    WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][playVideo] error, playerParam or videoInfo is null.");
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (b() != null)
      {
        WSPlayerParam localWSPlayerParam = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
        if (localWSPlayerParam != null)
        {
          int i1;
          if (this.jdField_a_of_type_Boolean) {
            i1 = 2;
          } else {
            i1 = localWSPlayerParam.jdField_a_of_type_Int;
          }
          b().b(i1);
        }
      }
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
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
      ((WSPlayerParam)localObject).jdField_a_of_type_Boolean = false;
      if (((WSPlayerParam)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate.g(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((WSPlayerStatusListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, this.jdField_c_of_type_Boolean);
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSPlayerManager.java][stop] title:");
      ((StringBuilder)localObject).append(b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam));
      WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][doOnDestroy] isStopVideo:");
    ((StringBuilder)localObject).append(paramBoolean);
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_Boolean = true;
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
    if (localObject != null)
    {
      ((WSVideoPreDownloadManager)localObject).a();
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
    localObject = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    if ((localObject != null) && (localObject != this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam))
    {
      localObject = a((WSPlayerParam)localObject);
      if (localObject != null)
      {
        ((WSPlayerWrapper)localObject).g();
        this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = null;
      }
      this.o = false;
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WSPlayerWrapper localWSPlayerWrapper = (WSPlayerWrapper)((Iterator)localObject).next();
        if ((localWSPlayerWrapper != null) && (localWSPlayerWrapper.e() != 8) && ((localWSPlayerWrapper != b()) || (paramBoolean))) {
          localWSPlayerWrapper.g();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall;
    if (localObject != null)
    {
      ((WSVideoPluginInstall)localObject).b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerForNetInfoHandler;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][doOnResume] mIsNeedStartOnResume:");
    ((StringBuilder)localObject).append(this.n);
    ((StringBuilder)localObject).append(", mIsNeedRestartOnResume:");
    ((StringBuilder)localObject).append(this.l);
    WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    this.f = true;
    if ((this.n) && (b() != null) && (b().e()))
    {
      a();
    }
    else if (this.l)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      boolean bool;
      if (localObject != null) {
        bool = ((QQAppInterface)localObject).isVideoChatting();
      } else {
        bool = false;
      }
      if (!bool)
      {
        this.m = true;
        c();
      }
    }
    this.l = false;
    this.n = false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerManager.java][doOnPause] isPlaying:");
    localStringBuilder.append(c());
    WSLog.e("WS_VIDEO_PLAYER", localStringBuilder.toString());
    if (c())
    {
      this.l = true;
      this.m = false;
      b();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.k = paramBoolean;
    WSPlayerWrapper localWSPlayerWrapper = b();
    boolean bool2 = false;
    if (localWSPlayerWrapper != null)
    {
      boolean bool1;
      if ((!paramBoolean) && (!this.g)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localWSPlayerWrapper.c(bool1);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager
 * JD-Core Version:    0.7.0.1
 */