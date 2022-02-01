package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.AVPreloadState;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AVPreloadEngine
{
  private int jdField_a_of_type_Int = 1638400;
  private long jdField_a_of_type_Long = 1200L;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ITPDownloadProxy jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<AVPreloadEngine.PreloadResultListener> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int b = 0;
  
  public AVPreloadEngine(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.stopPlay((int)l);
    }
    b();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.stopPlay(paramInt);
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    paramString = new TPDLProxyInitParam(paramInt, "1.0", paramString);
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.init(paramContext, paramString);
  }
  
  public void a(AVPreloadEngine.PreloadResultListener paramPreloadResultListener)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramPreloadResultListener);
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (paramAVPreloadTaskInterface == null) {
      AVPreloadLog.c("AVPreloadEngine", "start task is null.", new Object[0]);
    }
    boolean bool;
    do
    {
      return;
      if (paramAVPreloadTaskInterface.j() != 0L) {
        b(paramAVPreloadTaskInterface);
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramAVPreloadTaskInterface.b());
      localObject2 = new HashMap();
      ((Map)localObject2).put("dl_param_preload_size", Integer.valueOf(this.jdField_a_of_type_Int));
      ((Map)localObject2).put("dl_param_preload_duration", Long.valueOf(this.jdField_a_of_type_Long));
      str = this.jdField_a_of_type_AndroidContentContext.getExternalFilesDir(null) + "/flvCache";
      localObject3 = new File(str);
      if (((File)localObject3).exists()) {
        break;
      }
      bool = ((File)localObject3).mkdir();
      AVPreloadLog.b("AVPreloadEngine", "flv dir path " + str + "is not exist, and mkdir, result=" + bool, new Object[0]);
    } while (!bool);
    Object localObject3 = AVPreloadUtils.a(paramAVPreloadTaskInterface.b());
    String str = str + "/" + (String)localObject3 + ".flv";
    File localFile = new File(str);
    if (localFile.exists()) {
      localFile.delete();
    }
    ((Map)localObject2).put("dl_param_save_path", str);
    Object localObject1 = new TPDownloadParam((ArrayList)localObject1, 212, (Map)localObject2);
    long l = this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.startPlay((String)localObject3, (TPDownloadParam)localObject1, new AVPreloadEngine.AVPreloadPlayListener(this, paramAVPreloadTaskInterface));
    this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    paramAVPreloadTaskInterface.j(l);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_START);
    localObject1 = this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.getPlayUrl((int)l, 0);
    paramAVPreloadTaskInterface.c((String)localObject1);
    paramAVPreloadTaskInterface.h(this.b);
    this.jdField_a_of_type_AndroidOsHandler.post(new AVPreloadEngine.1(this));
    Object localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("start reload taskId #");
    ((StringBuffer)localObject2).append(paramAVPreloadTaskInterface.j());
    ((StringBuffer)localObject2).append(" url = ");
    ((StringBuffer)localObject2).append(paramAVPreloadTaskInterface.b());
    ((StringBuffer)localObject2).append("local url=");
    ((StringBuffer)localObject2).append((String)localObject1);
    ((StringBuffer)localObject2).append(" key id = ");
    ((StringBuffer)localObject2).append(paramAVPreloadTaskInterface.a());
    AVPreloadLog.b("AVPreloadEngine", ((StringBuffer)localObject2).toString(), new Object[0]);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (paramAVPreloadTaskInterface == null) {
      AVPreloadLog.c("AVPreloadEngine", "stop task is null.", new Object[0]);
    }
    while (paramAVPreloadTaskInterface.c()) {
      return;
    }
    AVPreloadLog.a("AVPreloadEngine", "stop reload taskId #" + paramAVPreloadTaskInterface.j() + " key id =" + paramAVPreloadTaskInterface.a(), new Object[0]);
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.stopPlay((int)paramAVPreloadTaskInterface.j());
    this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(paramAVPreloadTaskInterface.j()));
    paramAVPreloadTaskInterface.j(0L);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_STOP);
    paramAVPreloadTaskInterface.a(false);
    this.jdField_a_of_type_AndroidOsHandler.post(new AVPreloadEngine.2(this, paramAVPreloadTaskInterface));
  }
  
  public void c(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (paramAVPreloadTaskInterface == null)
    {
      AVPreloadLog.c("AVPreloadEngine", "pause task is null.", new Object[0]);
      return;
    }
    AVPreloadLog.b("AVPreloadEngine", "pause reload taskId #" + paramAVPreloadTaskInterface.j() + " key id =" + paramAVPreloadTaskInterface.a(), new Object[0]);
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.pauseDownload((int)paramAVPreloadTaskInterface.j());
    paramAVPreloadTaskInterface.j(0L);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_STOP);
    this.jdField_a_of_type_AndroidOsHandler.post(new AVPreloadEngine.3(this, paramAVPreloadTaskInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine
 * JD-Core Version:    0.7.0.1
 */