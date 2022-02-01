package com.tencent.ilivesdk.avpreloadservice;

import android.os.Handler;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.AVPreloadState;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.TaskReportInfo;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class AVPreloadEngine$AVPreloadPlayListener
  implements ITPPlayListener
{
  private AVPreloadTaskInterface jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface;
  
  public AVPreloadEngine$AVPreloadPlayListener(AVPreloadEngine paramAVPreloadEngine, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface = paramAVPreloadTaskInterface;
  }
  
  public long getAdvRemainTime()
  {
    return 0L;
  }
  
  public int getCurrentPlayClipNo()
  {
    return 0;
  }
  
  public long getCurrentPosition()
  {
    return 0L;
  }
  
  public Object getPlayInfo(long paramLong)
  {
    return null;
  }
  
  public Object getPlayInfo(String paramString)
  {
    return null;
  }
  
  public long getPlayerBufferLength()
  {
    return 0L;
  }
  
  public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
  {
    AVPreloadLog.b("AVPreload|Core", "onDownloadCdnUrlExpired", new Object[0]);
  }
  
  public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("url=");
    localStringBuffer.append(paramString1);
    localStringBuffer.append("cdnIp=");
    localStringBuffer.append(paramString2);
    localStringBuffer.append("uip=");
    localStringBuffer.append(paramString3);
    localStringBuffer.append("errorCodeStr=");
    localStringBuffer.append(paramString4);
    AVPreloadLog.b("AVPreload|Core", "onDownloadCdnUrlInfoUpdate " + localStringBuffer.toString(), new Object[0]);
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    AVPreloadLog.b("AVPreload|Core", "onDownloadCdnUrlUpdate url =" + paramString, new Object[0]);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    AVPreloadLog.b("AVPreloadEngine", "download error taskId #" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.j() + " key id =" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(), new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_FAILED);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.c(paramInt2);
    AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine).post(new AVPreloadEngine.AVPreloadPlayListener.2(this));
  }
  
  public void onDownloadFinish()
  {
    AVPreloadLog.b("AVPreloadEngine", "download finish taskId #" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.j() + " key id =" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(), new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_COMPLETED);
    AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine).post(new AVPreloadEngine.AVPreloadPlayListener.1(this));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AVPreloadLog.c("AVPreloadEngine", "onDownloadProgressUpdate", new Object[0]);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    AVPreloadLog.b("AVPreload|Core", "onDownloadProtocolUpdate protocol=" + paramString1 + " protocolVer" + paramString2, new Object[0]);
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    AVPreloadLog.b("AVPreload|Core", "onDownloadStatusUpdate", new Object[0]);
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      AVPreloadLog.b("AVPreloadEngine", "onPlayCallback MESSAGE_PRELOAD_FINISH taskId #" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.j() + " key id =" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a() + "  ext1: " + paramObject1 + "     url: " + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.b(), new Object[0]);
      try
      {
        paramObject1 = new JSONObject(paramObject1.toString());
        if (!paramObject1.has("updateSpeed")) {
          break label169;
        }
        paramInt = paramObject1.getInt("speed");
        if (paramInt <= 0) {
          continue;
        }
        AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine, paramInt);
      }
      catch (JSONException paramObject1)
      {
        paramObject1.printStackTrace();
      }
      continue;
      label169:
      paramObject2 = new AVPreloadTaskInterface.TaskReportInfo();
      paramObject2.a(paramObject1.getInt("duration"));
      paramObject2.b(paramObject1.getInt("recvBytes"));
      paramObject2.a(paramObject1.getLong("preloadDurationMS"));
      paramObject2.b(paramObject1.getLong("preloadBytes"));
      if (paramObject1.getInt("isPlayerConnected") == 0) {}
      for (;;)
      {
        paramObject2.a(bool);
        paramObject2.c(paramObject1.getInt("speed"));
        paramObject2.a(paramObject1.getString("ipStr"));
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(paramObject2);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(true);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_FINISH);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.h(AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine));
        AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine).post(new AVPreloadEngine.AVPreloadPlayListener.3(this));
        break;
        bool = false;
      }
      AVPreloadLog.b("AVPreloadEngine", "onPlayCallback MESSAGE_PRELOAD_H264_CONFIG taskId #" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.j() + " url =" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.b() + "  ext1: " + paramObject1, new Object[0]);
      ThreadCenter.postLogicTask(new AVPreloadEngine.AVPreloadPlayListener.4(this, paramObject1), "decoder_first_frame_thread");
      continue;
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.a(true);
      AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine).post(new AVPreloadEngine.AVPreloadPlayListener.5(this));
      continue;
      AVPreloadLog.b("AVPreloadEngine", "onPlayCallback MESSAGE_GAPTIME taskId #" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.j() + " url =" + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadTaskInterface.b() + "  ext1: " + paramObject1, new Object[0]);
      AVPreloadEngine.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine).post(new AVPreloadEngine.AVPreloadPlayListener.6(this, paramObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener
 * JD-Core Version:    0.7.0.1
 */