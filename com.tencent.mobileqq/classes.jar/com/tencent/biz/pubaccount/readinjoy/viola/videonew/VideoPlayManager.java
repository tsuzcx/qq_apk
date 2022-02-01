package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.content.Context;
import android.support.v4.util.ArraySet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.OnVideoPluginInstallListener;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class VideoPlayManager
  implements VideoPluginInstall.OnVideoPluginInstallListener
{
  private int jdField_a_of_type_Int = 1000;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private VideoPlayManager.MediaPlayListenerAdapterImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$MediaPlayListenerAdapterImpl = new VideoPlayManager.MediaPlayListenerAdapterImpl(this, null);
  private VideoPlayManager.UiHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$UiHandler = new VideoPlayManager.UiHandler(this);
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam;
  private List<VideoPlayManager.VideoStatusListener> jdField_a_of_type_JavaUtilList;
  private Set<VideoPlayerWrapper> jdField_a_of_type_JavaUtilSet = new ArraySet();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  public VideoPlayManager(Context paramContext)
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private VideoPlayerWrapper a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      localObject = null;
    }
    VideoPlayerWrapper localVideoPlayerWrapper;
    do
    {
      do
      {
        return localObject;
        localVideoPlayerWrapper = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$MediaPlayListenerAdapterImpl);
        localObject = localVideoPlayerWrapper;
      } while (paramVideoPlayParam == null);
      localObject = localVideoPlayerWrapper;
    } while (!paramVideoPlayParam.jdField_f_of_type_Boolean);
    localVideoPlayerWrapper.e(true);
    return localVideoPlayerWrapper;
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {}
    do
    {
      return;
      paramVideoPlayerWrapper.a(null);
      paramVideoPlayerWrapper.n();
    } while (paramVideoPlayerWrapper.j());
    paramVideoPlayerWrapper.j();
    ThreadManager.excute(new VideoPlayManager.2(this, paramVideoPlayerWrapper), 64, null, false);
  }
  
  private void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam) == null)
    {
      ThreadManager.post(new VideoPlayManager.1(this, paramVideoPlayParam), 5, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo hit cache");
    }
    VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo);
    e(paramVideoPlayParam);
  }
  
  private void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam == null) || (VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam) == null)) {
      return;
    }
    paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView == null)
    {
      VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a(paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup);
      Object localObject = VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).a();
      if ((localObject == null) || (((IVideoView)localObject).a() == null))
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(paramVideoPlayParam, 123, 99, null);
        }
        VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam, null);
        return;
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView = ((IVideoView)localObject);
      ((IVideoView)localObject).a().setId(2131376562);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(paramVideoPlayParam);
      }
    }
    VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).b(paramVideoPlayParam.jdField_f_of_type_Int);
    VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).d(this.e);
    VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam).c(paramVideoPlayParam.jdField_a_of_type_Boolean);
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a().setVisibility(0);
    ThreadManager.excute(new VideoPlayManager.PlayStartVideoRunnable(this, paramVideoPlayParam), 64, null, true);
  }
  
  public int a()
  {
    if (a()) {
      return VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).b();
    }
    return -1;
  }
  
  public long a()
  {
    if (a()) {
      return VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).b();
    }
    return 0L;
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam != null) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam) != null))
    {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).d();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)localIterator.next()).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam != null) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam) != null) && (d()))
    {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).f();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam, paramInt);
      }
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    paramVideoPlayParam = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVideoPlayParam.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)paramVideoPlayParam.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam, false);
    }
  }
  
  public void a(VideoPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramVideoStatusListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam != null) {
        d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam);
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((VideoPlayManager.VideoStatusListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam, 123, 99, null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam != null) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam) != null);
  }
  
  public long b()
  {
    if (a()) {
      return VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).a();
    }
    return 0L;
  }
  
  public void b()
  {
    a(2);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam != null) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam) != null) && ((c()) || (b())))
    {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).e();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)localIterator.next()).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam, paramInt);
      }
    }
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager playVideo");
    }
    Iterator localIterator;
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() vid=" + paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoInfo.a);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo: playerParam=" + paramVideoPlayParam);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (localIterator.hasNext())
    {
      ((VideoPlayManager.VideoStatusListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Viola.VideoPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
      return;
    }
    d(paramVideoPlayParam);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).d(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (a()) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).d());
  }
  
  public void c()
  {
    if (a())
    {
      a(VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((VideoPlayManager.VideoStatusListener)localIterator.next()).e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$UiHandler.removeMessages(0);
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).b(paramInt);
    }
  }
  
  public void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      a(VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (a()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).c(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return (a()) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).e());
  }
  
  public void d()
  {
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnPause() isPlaying()=" + d());
    }
    if (d())
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      b();
    }
  }
  
  public void d(int paramInt)
  {
    if (a()) {
      VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).a(paramInt);
    }
  }
  
  public boolean d()
  {
    return (a()) && (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).f());
  }
  
  public void e()
  {
    this.c = true;
    if ((this.d) && (b())) {
      a();
    }
    label84:
    for (;;)
    {
      this.jdField_f_of_type_Boolean = false;
      this.d = false;
      return;
      if (this.jdField_f_of_type_Boolean)
      {
        AppRuntime localAppRuntime = ReadInJoyUtils.a();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {}
        for (boolean bool = ((QQAppInterface)localAppRuntime).isVideoChatting();; bool = false)
        {
          if (bool) {
            break label84;
          }
          this.jdField_a_of_type_Boolean = true;
          b(2);
          break;
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void f()
  {
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "doOnDestory: ");
    }
    this.b = true;
    c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam != null)
    {
      if (VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam) != null)
      {
        VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam).l();
        VideoPlayManager.VideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam, null);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$VideoPlayParam = null;
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)localIterator.next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.i())) {
          localVideoPlayerWrapper.l();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager$UiHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */