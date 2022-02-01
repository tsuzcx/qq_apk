package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerSdkMgr;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerWrapHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;

public class WSVideoPluginInstall
{
  private static volatile boolean b;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new WSVideoPluginInstall.3(this));
  private WSVideoPluginInstall.OnVideoPluginInstallListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall$OnVideoPluginInstallListener;
  private IWSPlayerSdkMgr jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerSdkMgr = WSPlayerWrapHelper.a().a();
  private boolean jdField_a_of_type_Boolean;
  
  public WSVideoPluginInstall()
  {
    ThreadManager.executeOnSubThread(new WSVideoPluginInstall.1(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerSdkMgr.a();
    try
    {
      if (!b)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerSdkMgr.a(BaseApplicationImpl.getContext());
        WSLog.f("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][initVideoSDK] finish!");
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    boolean bool = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVideoPluginInstall.java][installPlugin] isPluginInstalled:");
    localStringBuilder.append(bool);
    localStringBuilder.append(", mIsInstalling:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    WSLog.e("WS_VIDEO_WSVideoPluginInstall", localStringBuilder.toString());
    if ((!bool) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new WSVideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(WSVideoPluginInstall.OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall$OnVideoPluginInstallListener = paramOnVideoPluginInstallListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerSdkMgr.a(BaseApplicationImpl.getContext());
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPluginInstall$OnVideoPluginInstallListener = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall
 * JD-Core Version:    0.7.0.1
 */