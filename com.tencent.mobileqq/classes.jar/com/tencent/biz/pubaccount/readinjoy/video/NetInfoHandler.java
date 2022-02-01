package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class NetInfoHandler
  implements INetInfoHandler
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private final RIJDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager;
  private final VideoHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler;
  private final ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  
  public NetInfoHandler(VideoHandler paramVideoHandler)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler = paramVideoHandler;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = paramVideoHandler.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager = paramVideoHandler.a();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().b(false);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b())) {}
    VideoPlayManager localVideoPlayManager;
    do
    {
      return;
      localVideoPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a();
    } while (!localVideoPlayManager.b());
    localVideoPlayManager.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.9(this));
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().b(true);
    } while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.10(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.1(this));
    }
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a();
          if (paramString != null) {
            paramString.b(false);
          }
        } while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b()));
        i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.a()) {
            i = 1;
          }
        }
      } while (i == 0);
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a();
      localVideoPlayParam = paramString.a();
      if ((!paramString.b()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.2(this));
        return;
      }
      if ((paramString.d()) && (localVideoPlayParam != null) && (paramString.b() == localVideoPlayParam.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + paramString.b());
        }
        paramString.c();
        return;
      }
    } while ((localVideoPlayParam == null) || (!paramString.d()) || (paramString.b() != localVideoPlayParam.c));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + paramString.b());
    }
    paramString.c();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.7(this));
    }
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().b(true);
      } while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b()));
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a();
      localVideoPlayParam = paramString.a();
      if ((!paramString.b()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.8(this));
        return;
      }
      if ((localVideoPlayParam != null) && (paramString.b() == localVideoPlayParam.c) && (paramString.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + paramString.b());
        }
        paramString.c();
        return;
      }
    } while ((localVideoPlayParam == null) || (paramString.b() != localVideoPlayParam.c) || (!paramString.d()));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + paramString.b());
    }
    paramString.c();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.5(this));
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().b(false);
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a();
      i = j;
      if (paramString != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a() != null)
        {
          i = j;
          if (paramString.a() != null) {
            i = 1;
          }
        }
      }
    } while ((i == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().g()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.6(this, paramString));
  }
  
  public void onNetWifi2None()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.3(this));
    }
    VideoPlayManager localVideoPlayManager;
    int i;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a().b(false);
      localVideoPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a();
      i = j;
      if (localVideoPlayManager != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersVideoHandler.a() != null)
        {
          i = j;
          if (localVideoPlayManager.a() != null) {
            i = 1;
          }
        }
      }
    } while ((i == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().g()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.4(this, localVideoPlayManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */