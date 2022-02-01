package com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.superplayer;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerSDKEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerSDKMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerSDKMgr;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "Lcom/tencent/mobileqq/videoplatform/SDKInitListener;", "()V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "initSDK", "", "installPlugin", "isInstalled", "", "onSDKInited", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayerSDKMgr
  implements IPlayerSDKMgr, SDKInitListener
{
  private static IPlayerSDKEventListener a;
  public static final SuperPlayerSDKMgr a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperSuperplayerSuperPlayerSDKMgr = new SuperPlayerSDKMgr();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "initSuperPlayerSDK() finish");
    }
  }
  
  public void a(@NotNull IPlayerSDKEventListener paramIPlayerSDKEventListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayerSDKEventListener, "listener");
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerSDKEventListener = paramIPlayerSDKEventListener;
    QQVideoPlaySDKManager.a((Context)BaseApplicationImpl.getContext(), (SDKInitListener)this);
  }
  
  public boolean a()
  {
    return QQVideoPlaySDKManager.a();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    IPlayerSDKEventListener localIPlayerSDKEventListener;
    if (paramBoolean)
    {
      localIPlayerSDKEventListener = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerSDKEventListener;
      if (localIPlayerSDKEventListener != null) {
        localIPlayerSDKEventListener.a();
      }
    }
    do
    {
      return;
      localIPlayerSDKEventListener = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerSDKEventListener;
    } while (localIPlayerSDKEventListener == null);
    localIPlayerSDKEventListener.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.superplayer.SuperPlayerSDKMgr
 * JD-Core Version:    0.7.0.1
 */