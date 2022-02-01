package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.AVPreloadState;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import java.io.File;
import java.net.URI;
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
  private AVPreloadDispatcher jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher;
  private ITPDownloadProxy jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<AVPreloadEngine.PreloadResultListener> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public AVPreloadEngine(Context paramContext, HttpInterface paramHttpInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher = new AVPreloadDispatcher(paramHttpInterface);
  }
  
  private void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, ArrayList<String> paramArrayList)
  {
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("dl_param_preload_size", Integer.valueOf(this.jdField_a_of_type_Int));
    ((Map)localObject1).put("dl_param_preload_duration", Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getExternalFilesDir(null));
    ((StringBuilder)localObject2).append("/flvCache");
    String str = ((StringBuilder)localObject2).toString();
    localObject2 = new File(str);
    if (!((File)localObject2).exists())
    {
      boolean bool = ((File)localObject2).mkdir();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("flv dir path ");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("is not exist, and mkdir, result=");
      ((StringBuilder)localObject2).append(bool);
      AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject2).toString(), new Object[0]);
      if (!bool) {
        return;
      }
    }
    localObject2 = AVPreloadUtils.a(paramAVPreloadTaskInterface.b());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(str);
    ((StringBuilder)localObject3).append("/");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(".flv");
    str = ((StringBuilder)localObject3).toString();
    localObject3 = new File(str);
    if (((File)localObject3).exists()) {
      ((File)localObject3).delete();
    }
    ((Map)localObject1).put("dl_param_save_path", str);
    paramArrayList = new TPDownloadParam(paramArrayList, 17, (Map)localObject1);
    long l = this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.startPlay((String)localObject2, paramArrayList, new AVPreloadEngine.AVPreloadPlayListener(this, paramAVPreloadTaskInterface));
    this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
    paramAVPreloadTaskInterface.j(l);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_START);
    paramArrayList = this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.getPlayUrl((int)l, 0);
    paramAVPreloadTaskInterface.c(paramArrayList);
    paramAVPreloadTaskInterface.h(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.post(new AVPreloadEngine.2(this));
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append("start reload taskId #");
    ((StringBuffer)localObject1).append(paramAVPreloadTaskInterface.j());
    ((StringBuffer)localObject1).append(" url = ");
    ((StringBuffer)localObject1).append(paramAVPreloadTaskInterface.b());
    ((StringBuffer)localObject1).append("local url=");
    ((StringBuffer)localObject1).append(paramArrayList);
    ((StringBuffer)localObject1).append(" key id = ");
    ((StringBuffer)localObject1).append(paramAVPreloadTaskInterface.a());
    AVPreloadLog.b("AVPreloadEngine", ((StringBuffer)localObject1).toString(), new Object[0]);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy == null) {
      return;
    }
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
    ITPDownloadProxy localITPDownloadProxy = this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy;
    if (localITPDownloadProxy == null) {
      return;
    }
    localITPDownloadProxy.stopPlay(paramInt);
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    if (this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy == null) {
      return;
    }
    paramString = new TPDLProxyInitParam(paramInt, "1.0", paramString);
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.init(paramContext, paramString);
  }
  
  public void a(AVPreloadEngine.PreloadResultListener paramPreloadResultListener)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramPreloadResultListener);
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy == null) {
      return;
    }
    if (paramAVPreloadTaskInterface == null)
    {
      AVPreloadLog.c("AVPreloadEngine", "start task is null.", new Object[0]);
      return;
    }
    if (paramAVPreloadTaskInterface.j() != 0L) {
      b(paramAVPreloadTaskInterface);
    }
    Object localObject2 = paramAVPreloadTaskInterface.b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("AVPreload start task! url: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject1).toString(), new Object[0]);
    localObject1 = localObject2;
    if (this.jdField_b_of_type_Boolean)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.isEmpty())
        {
          localObject1 = ((String)localObject2).replace(URI.create((String)localObject2).getHost(), this.jdField_a_of_type_JavaLangString);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("AVPreload will frame seek! frameSeekDomain: ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" taskUrl:");
          ((StringBuilder)localObject2).append((String)localObject1);
          AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject2).toString(), new Object[0]);
        }
      }
    }
    if (this.c)
    {
      localObject2 = this.jdField_b_of_type_JavaLangString;
      if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AVPreload will use dispatch! dispatchDomain: ");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" taskUrl:");
        ((StringBuilder)localObject2).append((String)localObject1);
        AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject2).toString(), new Object[0]);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher.a(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadDispatcher.a((String)localObject1, new AVPreloadEngine.1(this, paramAVPreloadTaskInterface));
        return;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("AVPreload do not use dispatch! taskUrl:");
    ((StringBuilder)localObject2).append((String)localObject1);
    AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    a(paramAVPreloadTaskInterface, (ArrayList)localObject2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy == null) {
      return;
    }
    if (paramAVPreloadTaskInterface == null)
    {
      AVPreloadLog.c("AVPreloadEngine", "stop task is null.", new Object[0]);
      return;
    }
    if (paramAVPreloadTaskInterface.c()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop reload taskId #");
    localStringBuilder.append(paramAVPreloadTaskInterface.j());
    localStringBuilder.append(" key id =");
    localStringBuilder.append(paramAVPreloadTaskInterface.a());
    AVPreloadLog.a("AVPreloadEngine", localStringBuilder.toString(), new Object[0]);
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.stopPlay((int)paramAVPreloadTaskInterface.j());
    this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(paramAVPreloadTaskInterface.j()));
    paramAVPreloadTaskInterface.j(0L);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_STOP);
    paramAVPreloadTaskInterface.a(false);
    this.jdField_a_of_type_AndroidOsHandler.post(new AVPreloadEngine.3(this, paramAVPreloadTaskInterface));
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy == null) {
      return;
    }
    if (paramAVPreloadTaskInterface == null)
    {
      AVPreloadLog.c("AVPreloadEngine", "pause task is null.", new Object[0]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause reload taskId #");
    localStringBuilder.append(paramAVPreloadTaskInterface.j());
    localStringBuilder.append(" key id =");
    localStringBuilder.append(paramAVPreloadTaskInterface.a());
    AVPreloadLog.b("AVPreloadEngine", localStringBuilder.toString(), new Object[0]);
    this.jdField_a_of_type_ComTencentThumbplayerCoreDownloadproxyApiITPDownloadProxy.pauseDownload((int)paramAVPreloadTaskInterface.j());
    paramAVPreloadTaskInterface.j(0L);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_STOP);
    this.jdField_a_of_type_AndroidOsHandler.post(new AVPreloadEngine.4(this, paramAVPreloadTaskInterface));
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine
 * JD-Core Version:    0.7.0.1
 */