package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerSDKMgr;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.app.ThreadManager;

public class VideoPluginInstall
{
  private static boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new VideoPluginInstall.3(this));
  private VideoPluginInstall.OnVideoPluginInstallListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener;
  private IPlayerSDKMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerSDKMgr = PlayerHelper.a.a();
  private boolean jdField_a_of_type_Boolean;
  
  public VideoPluginInstall()
  {
    ThreadManager.executeOnSubThread(new VideoPluginInstall.1(this));
  }
  
  private void c()
  {
    try
    {
      if (!b)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerSDKMgr.a();
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new VideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(VideoPluginInstall.OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener = paramOnVideoPluginInstallListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerSDKMgr.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall
 * JD-Core Version:    0.7.0.1
 */