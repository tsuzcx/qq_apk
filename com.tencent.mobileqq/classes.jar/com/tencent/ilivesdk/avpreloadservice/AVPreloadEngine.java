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
  private ITPDownloadProxy a;
  private Context b;
  private AVPreloadDispatcher c;
  private Handler d = new Handler(Looper.getMainLooper());
  private List<Long> e = new ArrayList();
  private int f = 1638400;
  private long g = 1200L;
  private int h = 0;
  private boolean i = true;
  private boolean j = false;
  private String k = "";
  private boolean l = false;
  private String m = "";
  private Set<AVPreloadEngine.PreloadResultListener> n = new HashSet();
  
  public AVPreloadEngine(Context paramContext, HttpInterface paramHttpInterface)
  {
    this.b = paramContext;
    this.c = new AVPreloadDispatcher(paramHttpInterface);
  }
  
  private void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, ArrayList<String> paramArrayList)
  {
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("dl_param_preload_size", Integer.valueOf(this.f));
    ((Map)localObject1).put("dl_param_preload_duration", Long.valueOf(this.g));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b.getExternalFilesDir(null));
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
    localObject2 = AVPreloadUtils.a(paramAVPreloadTaskInterface.s());
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
    long l1 = this.a.startPlay((String)localObject2, paramArrayList, new AVPreloadEngine.AVPreloadPlayListener(this, paramAVPreloadTaskInterface));
    this.e.add(Long.valueOf(l1));
    paramAVPreloadTaskInterface.j(l1);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_START);
    paramArrayList = this.a.getPlayUrl((int)l1, 0);
    paramAVPreloadTaskInterface.c(paramArrayList);
    paramAVPreloadTaskInterface.h(this.h);
    this.d.post(new AVPreloadEngine.2(this));
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append("start reload taskId #");
    ((StringBuffer)localObject1).append(paramAVPreloadTaskInterface.r());
    ((StringBuffer)localObject1).append(" url = ");
    ((StringBuffer)localObject1).append(paramAVPreloadTaskInterface.s());
    ((StringBuffer)localObject1).append("local url=");
    ((StringBuffer)localObject1).append(paramArrayList);
    ((StringBuffer)localObject1).append(" key id = ");
    ((StringBuffer)localObject1).append(paramAVPreloadTaskInterface.q());
    AVPreloadLog.b("AVPreloadEngine", ((StringBuffer)localObject1).toString(), new Object[0]);
  }
  
  public void a()
  {
    if (this.a == null) {
      return;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      long l1 = ((Long)localIterator.next()).longValue();
      this.a.stopPlay((int)l1);
    }
    b();
    this.b = null;
  }
  
  public void a(int paramInt)
  {
    ITPDownloadProxy localITPDownloadProxy = this.a;
    if (localITPDownloadProxy == null) {
      return;
    }
    localITPDownloadProxy.stopPlay(paramInt);
  }
  
  public void a(Context paramContext, int paramInt, String paramString)
  {
    this.a = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    if (this.a == null) {
      return;
    }
    paramString = new TPDLProxyInitParam(paramInt, "1.0", paramString);
    this.a.init(paramContext, paramString);
  }
  
  public void a(AVPreloadEngine.PreloadResultListener paramPreloadResultListener)
  {
    this.n.add(paramPreloadResultListener);
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (this.a == null) {
      return;
    }
    if (paramAVPreloadTaskInterface == null)
    {
      AVPreloadLog.c("AVPreloadEngine", "start task is null.", new Object[0]);
      return;
    }
    if (paramAVPreloadTaskInterface.r() != 0L) {
      b(paramAVPreloadTaskInterface);
    }
    Object localObject2 = paramAVPreloadTaskInterface.s();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("AVPreload start task! url: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject1).toString(), new Object[0]);
    localObject1 = localObject2;
    if (this.j)
    {
      String str = this.k;
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (!str.isEmpty())
        {
          localObject1 = ((String)localObject2).replace(URI.create((String)localObject2).getHost(), this.k);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("AVPreload will frame seek! frameSeekDomain: ");
          ((StringBuilder)localObject2).append(this.k);
          ((StringBuilder)localObject2).append(" taskUrl:");
          ((StringBuilder)localObject2).append((String)localObject1);
          AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject2).toString(), new Object[0]);
        }
      }
    }
    if (this.l)
    {
      localObject2 = this.m;
      if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AVPreload will use dispatch! dispatchDomain: ");
        ((StringBuilder)localObject2).append(this.m);
        ((StringBuilder)localObject2).append(" taskUrl:");
        ((StringBuilder)localObject2).append((String)localObject1);
        AVPreloadLog.b("AVPreloadEngine", ((StringBuilder)localObject2).toString(), new Object[0]);
        this.c.a(this.m);
        this.c.a((String)localObject1, new AVPreloadEngine.1(this, paramAVPreloadTaskInterface));
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
    this.k = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b()
  {
    this.n.clear();
  }
  
  public void b(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (this.a == null) {
      return;
    }
    if (paramAVPreloadTaskInterface == null)
    {
      AVPreloadLog.c("AVPreloadEngine", "stop task is null.", new Object[0]);
      return;
    }
    if (paramAVPreloadTaskInterface.B()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop reload taskId #");
    localStringBuilder.append(paramAVPreloadTaskInterface.r());
    localStringBuilder.append(" key id =");
    localStringBuilder.append(paramAVPreloadTaskInterface.q());
    AVPreloadLog.a("AVPreloadEngine", localStringBuilder.toString(), new Object[0]);
    this.a.stopPlay((int)paramAVPreloadTaskInterface.r());
    this.e.remove(Long.valueOf(paramAVPreloadTaskInterface.r()));
    paramAVPreloadTaskInterface.j(0L);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_STOP);
    paramAVPreloadTaskInterface.a(false);
    this.d.post(new AVPreloadEngine.3(this, paramAVPreloadTaskInterface));
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void c(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (this.a == null) {
      return;
    }
    if (paramAVPreloadTaskInterface == null)
    {
      AVPreloadLog.c("AVPreloadEngine", "pause task is null.", new Object[0]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause reload taskId #");
    localStringBuilder.append(paramAVPreloadTaskInterface.r());
    localStringBuilder.append(" key id =");
    localStringBuilder.append(paramAVPreloadTaskInterface.q());
    AVPreloadLog.b("AVPreloadEngine", localStringBuilder.toString(), new Object[0]);
    this.a.pauseDownload((int)paramAVPreloadTaskInterface.r());
    paramAVPreloadTaskInterface.j(0L);
    paramAVPreloadTaskInterface.a(AVPreloadTaskInterface.AVPreloadState.PRELOAD_STOP);
    this.d.post(new AVPreloadEngine.4(this, paramAVPreloadTaskInterface));
  }
  
  public void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadEngine
 * JD-Core Version:    0.7.0.1
 */