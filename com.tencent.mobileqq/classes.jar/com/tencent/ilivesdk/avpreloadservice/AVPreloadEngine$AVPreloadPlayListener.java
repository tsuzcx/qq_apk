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

public class AVPreloadEngine$AVPreloadPlayListener
  implements ITPPlayListener
{
  private AVPreloadTaskInterface b;
  
  public AVPreloadEngine$AVPreloadPlayListener(AVPreloadEngine paramAVPreloadEngine, AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    this.b = paramAVPreloadTaskInterface;
  }
  
  private void a()
  {
    this.b.a(true);
    AVPreloadEngine.c(this.a).post(new AVPreloadEngine.AVPreloadPlayListener.4(this));
  }
  
  private void a(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramInt != 5) {
      return;
    }
    paramInt = ((Integer)paramObject1).intValue();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return;
          }
          b(paramObject3.toString());
          return;
        }
        if (!AVPreloadEngine.d(this.a))
        {
          AVPreloadLog.c("AVPreloadEngine", "enableScreenShot = false", new Object[0]);
          return;
        }
        paramObject1 = new AVPreloadEngine.FrameData(this.a, null);
        paramObject3 = (String)paramObject3;
        try
        {
          paramObject1.c = ((byte[])paramObject2);
          paramObject1.d = paramObject1.c.length;
          paramObject2 = new JSONObject(paramObject3);
          paramObject1.a = paramObject2.getInt("width");
          paramObject1.b = paramObject2.getInt("height");
        }
        catch (Exception paramObject2)
        {
          paramObject2.printStackTrace();
        }
        a(paramObject1);
        return;
      }
      a();
      return;
    }
    a(paramObject3.toString());
  }
  
  private void a(AVPreloadEngine.FrameData paramFrameData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayCallback MESSAGE_PRELOAD_H264_CONFIG taskId #");
    localStringBuilder.append(this.b.r());
    localStringBuilder.append(" url =");
    localStringBuilder.append(this.b.s());
    AVPreloadLog.b("AVPreloadEngine", localStringBuilder.toString(), new Object[0]);
    ThreadCenter.postLogicTask(new AVPreloadEngine.AVPreloadPlayListener.6(this, paramFrameData), "decoder_first_frame_thread");
  }
  
  private void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPlayCallback MESSAGE_PRELOAD_FINISH taskId #");
    ((StringBuilder)localObject).append(this.b.r());
    ((StringBuilder)localObject).append(" key id =");
    ((StringBuilder)localObject).append(this.b.q());
    ((StringBuilder)localObject).append("  data: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("     url: ");
    ((StringBuilder)localObject).append(this.b.s());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool1 = false;
    AVPreloadLog.b("AVPreloadEngine", (String)localObject, new Object[0]);
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool2 = paramString.has("updateSpeed");
      if (bool2)
      {
        int i = paramString.getInt("speed");
        if (i > 0) {
          AVPreloadEngine.a(this.a, i);
        }
      }
      else
      {
        localObject = new AVPreloadTaskInterface.TaskReportInfo();
        ((AVPreloadTaskInterface.TaskReportInfo)localObject).a(paramString.getInt("duration"));
        ((AVPreloadTaskInterface.TaskReportInfo)localObject).b(paramString.getInt("recvBytes"));
        ((AVPreloadTaskInterface.TaskReportInfo)localObject).a(paramString.getLong("preloadDurationMS"));
        ((AVPreloadTaskInterface.TaskReportInfo)localObject).b(paramString.getLong("preloadBytes"));
        if (paramString.getInt("isPlayerConnected") == 0) {
          bool1 = true;
        }
        ((AVPreloadTaskInterface.TaskReportInfo)localObject).a(bool1);
        ((AVPreloadTaskInterface.TaskReportInfo)localObject).c(paramString.getInt("speed"));
        ((AVPreloadTaskInterface.TaskReportInfo)localObject).a(paramString.getString("ipStr"));
        this.b.a((AVPreloadTaskInterface.TaskReportInfo)localObject);
        this.b.a(true);
        this.b.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_FINISH);
        this.b.h(AVPreloadEngine.e(this.a));
        AVPreloadEngine.c(this.a).post(new AVPreloadEngine.AVPreloadPlayListener.3(this));
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayCallback MESSAGE_GAPTIME taskId #");
    localStringBuilder.append(this.b.r());
    localStringBuilder.append(" url =");
    localStringBuilder.append(this.b.s());
    localStringBuilder.append("  ext1: ");
    localStringBuilder.append(paramString);
    AVPreloadLog.b("AVPreloadEngine", localStringBuilder.toString(), new Object[0]);
    AVPreloadEngine.c(this.a).post(new AVPreloadEngine.AVPreloadPlayListener.5(this, paramString));
  }
  
  public long getAdvRemainTime()
  {
    return 0L;
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    return null;
  }
  
  public int getCurrentPlayClipNo()
  {
    return 0;
  }
  
  public long getCurrentPosition()
  {
    return 0L;
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    return null;
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
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
    paramString1 = new StringBuilder();
    paramString1.append("onDownloadCdnUrlInfoUpdate ");
    paramString1.append(localStringBuffer.toString());
    AVPreloadLog.b("AVPreload|Core", paramString1.toString(), new Object[0]);
  }
  
  public void onDownloadCdnUrlUpdate(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadCdnUrlUpdate url =");
    localStringBuilder.append(paramString);
    AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onDownloadError(int paramInt1, int paramInt2, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("download error taskId #");
    paramString.append(this.b.r());
    paramString.append(" key id =");
    paramString.append(this.b.q());
    AVPreloadLog.b("AVPreloadEngine", paramString.toString(), new Object[0]);
    this.b.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_FAILED);
    this.b.c(paramInt2);
    AVPreloadEngine.c(this.a).post(new AVPreloadEngine.AVPreloadPlayListener.2(this));
  }
  
  public void onDownloadFinish()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download finish taskId #");
    localStringBuilder.append(this.b.r());
    localStringBuilder.append(" key id =");
    localStringBuilder.append(this.b.q());
    AVPreloadLog.b("AVPreloadEngine", localStringBuilder.toString(), new Object[0]);
    this.b.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_COMPLETED);
    AVPreloadEngine.c(this.a).post(new AVPreloadEngine.AVPreloadPlayListener.1(this));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AVPreloadLog.c("AVPreloadEngine", "onDownloadProgressUpdate", new Object[0]);
  }
  
  public void onDownloadProtocolUpdate(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadProtocolUpdate protocol=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" protocolVer");
    localStringBuilder.append(paramString2);
    AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onDownloadStatusUpdate(int paramInt)
  {
    AVPreloadLog.b("AVPreload|Core", "onDownloadStatusUpdate", new Object[0]);
  }
  
  public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    a(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
    return null;
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    return 0;
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine.AVPreloadPlayListener
 * JD-Core Version:    0.7.0.1
 */