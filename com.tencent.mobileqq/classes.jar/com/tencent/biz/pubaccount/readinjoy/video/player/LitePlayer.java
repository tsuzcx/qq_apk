package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.OnVideoPluginInstallListener;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LitePlayer
  implements VideoPluginInstall.OnVideoPluginInstallListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  @NonNull
  protected Context a;
  @NonNull
  protected ViewGroup a;
  @NonNull
  protected VideoPlayerWrapper a;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private LitePlayer.MediaPlayListenerAdapterImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl = new LitePlayer.MediaPlayListenerAdapterImpl(this);
  @Nullable
  private LitePlayer.PlayParams jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams;
  private LitePlayer.UiHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler = new LitePlayer.UiHandler(this);
  private final String jdField_a_of_type_JavaLangString = "LitePlayer<" + Integer.toHexString(hashCode()) + ">";
  private List<PlayerStatusListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<IPlayerReporter> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 100;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l;
  
  @UiThread
  public LitePlayer(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.l = paramBoolean;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = a();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    paramBoolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "LitePlayer: isPluginInstalled=" + paramBoolean);
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
    }
  }
  
  @UiThread
  private VideoPlayerWrapper a()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString);
    localVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl);
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (boolean bool = true;; bool = false)
    {
      localVideoPlayerWrapper.a((ViewGroup)localObject, bool, this.l);
      localObject = localVideoPlayerWrapper.a();
      if (localObject != null)
      {
        ((View)localObject).setId(2131376562);
        this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
      }
      localVideoPlayerWrapper.a(this.k);
      localVideoPlayerWrapper.c(this.j);
      localVideoPlayerWrapper.e(this.h);
      localVideoPlayerWrapper.a(this.jdField_a_of_type_Float);
      localVideoPlayerWrapper.d(this.i);
      localVideoPlayerWrapper.b(this.jdField_a_of_type_Int);
      return localVideoPlayerWrapper;
    }
  }
  
  private void a(LitePlayer.PlayParams paramPlayParams)
  {
    if (TextUtils.isEmpty(paramPlayParams.jdField_b_of_type_JavaLangString))
    {
      a(paramPlayParams.jdField_a_of_type_JavaLangString, paramPlayParams.jdField_a_of_type_Int, paramPlayParams.jdField_a_of_type_Long);
      return;
    }
    a(paramPlayParams.jdField_a_of_type_JavaLangString, paramPlayParams.jdField_b_of_type_JavaLangString, paramPlayParams.jdField_a_of_type_Int, paramPlayParams.jdField_a_of_type_Long, paramPlayParams.jdField_b_of_type_Int);
  }
  
  static void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "openByUrl: vid=" + paramString1 + ", url=" + paramString2 + ", playType=" + paramInt1 + ", startPosition=" + paramLong);
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, 201, 109, 0, "player had destoryed", null);
    }
    do
    {
      return;
      if ((paramBoolean1) && (TextUtils.isEmpty(paramString2)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, 201, 61, 0, "url null", null);
        return;
      }
      if ((!paramBoolean1) && (TextUtils.isEmpty(paramString1)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, 201, 61, 0, "vid null", null);
        return;
      }
    } while (a(paramLong));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams = new LitePlayer.PlayParams(this, paramString1, paramString2, paramInt1, paramLong, paramInt2);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
      return;
    }
    n();
    b(paramString1, paramString2);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString1, paramString2, paramInt1, paramLong, 0L, paramInt2, paramBoolean2, true, this.g, paramString3);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString1, paramInt1, paramLong, this.g);
  }
  
  private boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams != null) && (this.g) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a() == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: status=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams.jdField_a_of_type_Long = paramLong;
      Iterator localIterator;
      if ((f()) || (g()) || (i()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: hasPrePlay, just go onVideoPrepared");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((IPlayerReporter)localIterator.next()).a(true);
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((IPlayerReporter)localIterator.next()).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.k();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.p();
        o();
        return true;
      }
      if ((c()) || (d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: prePlaying, just do nothing ");
        }
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((IPlayerReporter)localIterator.next()).a(false);
        }
        this.g = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.k();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.p();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.sendEmptyMessageDelayed(1, 10000L);
        return true;
      }
      this.g = false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPreload: checkPreload player was preload but status error");
      }
    }
    return false;
  }
  
  private void b(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {}
    do
    {
      return;
      paramVideoPlayerWrapper.n();
    } while ((paramVideoPlayerWrapper.j()) || (paramVideoPlayerWrapper.i()));
    paramVideoPlayerWrapper.j();
    ThreadManager.excute(new LitePlayer.6(this, paramVideoPlayerWrapper), 16, null, true);
  }
  
  private void b(LitePlayer.PlayParams paramPlayParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramPlayParams);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.removeMessages(1);
  }
  
  private void b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IPlayerReporter)localIterator.next()).a(paramString1, paramString2, this.g, this.k);
    }
    paramString1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramString1.hasNext()) {
      ((PlayerStatusListener)paramString1.next()).onVideoOpen();
    }
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkPlayer: tag=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a());
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a() != null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.j()))
    {
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = a();
    }
  }
  
  private void o()
  {
    this.g = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.removeMessages(1);
    if (this.jdField_c_of_type_Boolean)
    {
      c();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams.jdField_a_of_type_Long / 1000L != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a() / 1000L)) {
        b((int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams.jdField_a_of_type_Long / 1000L));
      }
      return;
    }
    this.d = true;
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (((VideoPlayerWrapper)localObject).f())
    {
      long l1 = ((VideoPlayerWrapper)localObject).a();
      if (l1 >= ((VideoPlayerWrapper)localObject).b() - 500L) {
        this.f = true;
      }
      while (this.jdField_a_of_type_JavaUtilList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((PlayerStatusListener)((Iterator)localObject).next()).onProgressChanged(l1);
        }
        if ((l1 >= 0L) && (this.f) && (((VideoPlayerWrapper)localObject).m()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoReplayOnLoop: pos=" + l1);
          }
          this.f = false;
          this.jdField_b_of_type_Int += 1;
          ((VideoPlayerWrapper)localObject).m();
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((PlayerStatusListener)((Iterator)localObject).next()).onVideoEnd(this.jdField_b_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
  }
  
  public Map<String, String> a()
  {
    Map localMap = PlayFeedbackHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
    PlayFeedbackHelper.a(localMap);
    return localMap;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "replay: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams);
    }
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(paramInt);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(null, paramInt1, paramInt2, paramInt3, paramString, null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    g();
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    h();
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, -1, -1);
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper != null) {
      b(paramVideoPlayerWrapper);
    }
  }
  
  public void a(IPlayerReporter paramIPlayerReporter)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramIPlayerReporter);
  }
  
  public void a(PlayerStatusListener paramPlayerStatusListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramPlayerStatusListener);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(new LitePlayer.1(this, paramString, paramInt, paramLong));
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a("", paramString, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.sendEmptyMessage(0);
    b(new LitePlayer.PlayParams(this, paramString1, paramString2, 0, 0L, 0));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString1, paramString2, null, true, paramInt1, paramLong, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    a(new LitePlayer.2(this, paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramLong, paramInt2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onInstallComplete: success=" + paramBoolean + ", mHasDestory=" + this.jdField_b_of_type_Boolean);
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_Boolean) {}
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams);
        return;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((PlayerStatusListener)localIterator.next()).onVideoError(123, 99, null);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = true;
    this.k = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startPreload: coverFrame=" + paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams != null) && ((d()) || (f()) || (g()) || (h()) || (i()));
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start: status=" + a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((PlayerStatusListener)localIterator.next()).beforeVideoStart();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.sendEmptyMessage(0);
    VideoFeedsHelper.a(new LitePlayer.3(this));
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IPlayerReporter)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pause: status=" + a());
    }
    if ((h()) || (i()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      VideoFeedsHelper.a(new LitePlayer.4(this));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "restart: status=" + a());
    }
    if ((g()) || (f()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
      VideoFeedsHelper.a(new LitePlayer.5(this));
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop: mPlayParam=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((PlayerStatusListener)localIterator.next()).onVideoStop();
      }
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((IPlayerReporter)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, this.jdField_b_of_type_Int);
      }
    }
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
    this.g = false;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$PlayParams = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.removeMessages(0);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.o();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.g();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$MediaPlayListenerAdapterImpl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, null);
  }
  
  public void k()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause() isPlaying()=" + h());
    }
    if ((h()) || (i()))
    {
      this.e = true;
      this.jdField_a_of_type_Boolean = false;
      d();
    }
  }
  
  public void l()
  {
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onResume: ");
    }
    if ((this.d) && (f())) {
      o();
    }
    label96:
    for (;;)
    {
      this.e = false;
      this.d = false;
      return;
      if (this.e)
      {
        AppRuntime localAppRuntime = ReadInJoyUtils.a();
        if ((localAppRuntime instanceof QQAppInterface)) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).isVideoChatting();; bool = false)
        {
          if (bool) {
            break label96;
          }
          this.jdField_a_of_type_Boolean = true;
          e();
          break;
        }
      }
    }
  }
  
  public void m()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestory: ");
    }
    f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerLitePlayer$UiHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.LitePlayer
 * JD-Core Version:    0.7.0.1
 */