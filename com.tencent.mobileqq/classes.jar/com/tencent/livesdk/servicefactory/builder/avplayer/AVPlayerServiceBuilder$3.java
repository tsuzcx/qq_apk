package com.tencent.livesdk.servicefactory.builder.avplayer;

import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerPreloadAdapter.AVPreloadListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadResultListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadScenes;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;

class AVPlayerServiceBuilder$3
  implements AVPlayerPreloadAdapter
{
  AVPlayerPreloadAdapter.AVPreloadListener jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfaceAVPlayerPreloadAdapter$AVPreloadListener;
  AVPreloadServiceInterface.AVPreloadResultListener jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadResultListener = new AVPlayerServiceBuilder.3.1(this);
  String jdField_a_of_type_JavaLangString;
  
  AVPlayerServiceBuilder$3(AVPlayerServiceBuilder paramAVPlayerServiceBuilder, AVPlayerBuilderServiceInterface paramAVPlayerBuilderServiceInterface, AVPreloadServiceInterface paramAVPreloadServiceInterface) {}
  
  public AVPreloadTaskInterface a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload()) {
      return this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.a(paramString);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload()) {
      str = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.a(paramString);
    }
    return str;
  }
  
  public void a(AVPlayerPreloadAdapter.AVPreloadListener paramAVPreloadListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.b(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadResultListener);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload())
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.a(AVPreloadServiceInterface.AVPreloadScenes.SWITCH_ROOM);
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.a(paramString);
    }
  }
  
  public void a(String paramString, AVPlayerPreloadAdapter.AVPreloadListener paramAVPreloadListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerservice_interfaceAVPlayerPreloadAdapter$AVPreloadListener = paramAVPreloadListener;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadResultListener);
    }
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.b(paramString);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.a(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.b(paramString);
    }
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.c(paramString);
    }
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.isUseLocalServerPreload()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface.d(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPlayerServiceBuilder.3
 * JD-Core Version:    0.7.0.1
 */