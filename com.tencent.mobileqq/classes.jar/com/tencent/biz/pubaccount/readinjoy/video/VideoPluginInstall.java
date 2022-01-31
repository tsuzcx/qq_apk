package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import mio;
import mip;
import mir;

public class VideoPluginInstall
{
  private static boolean b;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new mip(this));
  private VideoPluginInstall.OnVideoPluginInstallListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoPluginInstall(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
  }
  
  private void c()
  {
    try
    {
      if (!b)
      {
        TVK_SDKMgr.setDebugEnable(true);
        TVK_SDKMgr.setOnLogListener(new mir(null));
        TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video", 2, "initVideoSDK() finish");
        }
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!a()) && (!this.jdField_a_of_type_Boolean)) {
      ThreadManager.post(new mio(this), 8, null, true);
    }
  }
  
  public void a(VideoPluginInstall.OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener = paramOnVideoPluginInstallListener;
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall$OnVideoPluginInstallListener = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall
 * JD-Core Version:    0.7.0.1
 */