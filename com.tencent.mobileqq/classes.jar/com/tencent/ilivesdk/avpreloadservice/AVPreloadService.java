package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceAdapter;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadResultListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadScenes;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AVPreloadService
  implements ThreadCenter.HandlerKeyable, AVPreloadStrategyManger.AVPreloadStrategyChangeListener, AVPreloadSwitch.AVPreloadSwitchListener, AVPreloadServiceInterface
{
  private AVPreloadTaskManager a;
  private AVPreloadSwitch b;
  private boolean c = false;
  private AVPreloadStrategyManger d;
  private AVPreloadServiceAdapter e;
  private boolean f = false;
  private AVPreloadServiceInterface.AVPreloadScenes g = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
  private AVPreloadServiceInterface.AVPreloadScenes h = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
  
  private String a(String paramString1, String paramString2)
  {
    Iterator localIterator1 = this.d.b().values().iterator();
    AVPreloadTask localAVPreloadTask;
    do
    {
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
      localAVPreloadTask = (AVPreloadTask)localIterator2.next();
    } while ((!paramString1.equalsIgnoreCase(localAVPreloadTask.s())) && (!paramString2.equalsIgnoreCase(localAVPreloadTask.q())));
    if (localAVPreloadTask.p()) {
      paramString1 = localAVPreloadTask.t();
    }
    return paramString1;
    return null;
  }
  
  private String b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.a.d().iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q())))
      {
        if (localAVPreloadTask.p()) {
          paramString1 = localAVPreloadTask.t();
        }
        return paramString1;
      }
    }
    localIterator = this.a.c().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q())))
      {
        if (localAVPreloadTask.p()) {
          paramString1 = localAVPreloadTask.t();
        }
        return paramString1;
      }
    }
    localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q())))
      {
        if (localAVPreloadTask.p()) {
          paramString1 = localAVPreloadTask.t();
        }
        return paramString1;
      }
    }
    return null;
  }
  
  private String c(String paramString1, String paramString2)
  {
    Iterator localIterator = this.a.f().iterator();
    while (localIterator.hasNext())
    {
      AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q())))
      {
        if (System.currentTimeMillis() - localAVPreloadTask.v() > localAVPreloadTask.o() * 1000L) {
          return paramString1;
        }
        if (localAVPreloadTask.p()) {
          paramString1 = localAVPreloadTask.t();
        }
        return paramString1;
      }
    }
    return null;
  }
  
  private AVPreloadTask d(String paramString1, String paramString2)
  {
    AVPreloadTask localAVPreloadTask;
    do
    {
      Iterator localIterator1 = this.d.b().values().iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
      localAVPreloadTask = (AVPreloadTask)localIterator2.next();
    } while ((!paramString1.equalsIgnoreCase(localAVPreloadTask.t())) && (!paramString1.equalsIgnoreCase(localAVPreloadTask.s())) && (!paramString2.equalsIgnoreCase(localAVPreloadTask.q())));
    return localAVPreloadTask;
    return null;
  }
  
  private AVPreloadTask e(String paramString1, String paramString2)
  {
    Iterator localIterator = this.a.d().iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.t())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.a.c().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.t())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.t())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    return null;
  }
  
  private AVPreloadTask f(String paramString1, String paramString2)
  {
    Iterator localIterator = this.a.f().iterator();
    while (localIterator.hasNext())
    {
      AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.t())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.s())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b.b();
  }
  
  public void a(AVPreloadServiceAdapter paramAVPreloadServiceAdapter)
  {
    this.e = paramAVPreloadServiceAdapter;
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.a.a(paramAVPreloadResultListener);
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    this.g = paramAVPreloadScenes;
    if (this.g != AVPreloadServiceInterface.AVPreloadScenes.SWITCH_ROOM) {
      this.h = paramAVPreloadScenes;
    }
    this.a.a(this.d.b(paramAVPreloadScenes));
    if (!this.f)
    {
      AVPreloadLog.c("AVPreload|Core", "set preload scenes switch is not ready.", new Object[0]);
      return;
    }
    paramAVPreloadScenes = this.b.a(paramAVPreloadScenes);
    if (paramAVPreloadScenes == null)
    {
      AVPreloadLog.c("AVPreload|Core", "set preload scenes switch is null", new Object[0]);
      return;
    }
    if (paramAVPreloadScenes.f != 0) {
      this.a.a(paramAVPreloadScenes.f);
    }
    if (paramAVPreloadScenes.h != 0) {
      this.a.c(paramAVPreloadScenes.h);
    }
    if (paramAVPreloadScenes.g != 0) {
      this.a.b(paramAVPreloadScenes.g);
    }
    this.a.a(paramAVPreloadScenes.d);
    this.a.b(paramAVPreloadScenes.e);
    this.a.a(paramAVPreloadScenes.i);
    this.a.c(paramAVPreloadScenes.j);
    this.a.b(paramAVPreloadScenes.k);
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes, AVPreloadTask paramAVPreloadTask)
  {
    if (!this.c)
    {
      AVPreloadLog.c("AVPreload|Core", "onEliminatedTask but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------strategy list eliminated task url = ");
    localStringBuilder.append(paramAVPreloadTask.s());
    localStringBuilder.append(" local url");
    localStringBuilder.append(paramAVPreloadTask.t());
    localStringBuilder.append(" scene = ");
    localStringBuilder.append(paramAVPreloadScenes);
    AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
    if (!paramAVPreloadTask.B()) {
      this.a.c(paramAVPreloadTask);
    }
  }
  
  public boolean a(String paramString)
  {
    if (!this.c)
    {
      AVPreloadLog.c("AVPreload|Core", "addTask but isPreloadTaskManagerInited = false", new Object[0]);
      return false;
    }
    if ((this.f) && (!this.b.c(this.g)))
    {
      paramString = new StringBuilder();
      paramString.append("------addTask not support preload Scenes ");
      paramString.append(this.g);
      AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
      return false;
    }
    AVPreloadTask localAVPreloadTask = this.a.c(paramString);
    Object localObject = localAVPreloadTask;
    if (localAVPreloadTask == null)
    {
      localObject = new AVPreloadTask();
      ((AVPreloadTask)localObject).a(AVPreloadUtils.c(paramString));
    }
    ((AVPreloadTask)localObject).l(0L);
    ((AVPreloadTask)localObject).b(paramString);
    this.d.a(this.g, (AVPreloadTask)localObject);
    this.d.b(this.g, (AVPreloadTask)localObject);
    if (!this.a.b((AVPreloadTask)localObject))
    {
      this.a.e((AVPreloadTaskInterface)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("------add task url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" scenes = ");
      ((StringBuilder)localObject).append(this.g);
      AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------add task task is in working queue url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" scenes = ");
    ((StringBuilder)localObject).append(this.g);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    return false;
  }
  
  public void b()
  {
    if (!this.c)
    {
      AVPreloadLog.c("AVPreload|Core", "switchPreload2LiveTabPage but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (this.h != AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchPreload2LiveTabPage not fit latestPreloadScenes=");
      ((StringBuilder)localObject1).append(this.h);
      AVPreloadLog.b("AVPreload|AVPreloadService", ((StringBuilder)localObject1).toString(), new Object[0]);
      return;
    }
    this.g = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
    this.a.i();
    int i = this.d.b(AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB);
    this.a.a(i);
    Object localObject1 = this.d.a(AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB);
    Object localObject2 = new ArrayList((Collection)localObject1);
    ((List)localObject1).clear();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
      ((AVPreloadTask)localObject2).d(false);
      a(((AVPreloadTask)localObject2).s());
    }
  }
  
  public void b(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.a.b(paramAVPreloadResultListener);
  }
  
  public void b(String paramString)
  {
    if (!this.c)
    {
      AVPreloadLog.c("AVPreload|Core", "remove but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.a.c(paramString);
    if (localObject == null) {
      return;
    }
    this.a.f((AVPreloadTaskInterface)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------remove task url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" scenes = ");
    ((StringBuilder)localObject).append(this.g);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
  }
  
  public void c()
  {
    if (!this.c)
    {
      AVPreloadLog.c("AVPreload|Core", "switchPreload2FeedsPage but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (this.h != AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchPreload2FeedsPage not fit latestPreloadScenes=");
      ((StringBuilder)localObject1).append(this.h);
      AVPreloadLog.b("AVPreload|AVPreloadService", ((StringBuilder)localObject1).toString(), new Object[0]);
      return;
    }
    this.g = AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("------switchPreload2FeedsPage scenes = ");
    ((StringBuilder)localObject1).append(this.g);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject1).toString(), new Object[0]);
    this.a.i();
    int i = this.d.b(AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS);
    this.a.a(i);
    localObject1 = this.d.a(AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS);
    Object localObject2 = new ArrayList((Collection)localObject1);
    ((List)localObject1).clear();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
      ((AVPreloadTask)localObject2).d(false);
      a(((AVPreloadTask)localObject2).s());
    }
  }
  
  public void c(String paramString)
  {
    if (!this.c)
    {
      AVPreloadLog.c("AVPreload|Core", "stop but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.a.c(paramString);
    if (localObject == null) {
      return;
    }
    this.a.c((AVPreloadTask)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------stop task url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" scenes = ");
    ((StringBuilder)localObject).append(this.g);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
  }
  
  public void clearEventOutput() {}
  
  public void d()
  {
    if (this.b.a() != null)
    {
      if (this.b.a().size() == 0) {
        return;
      }
      this.f = true;
    }
  }
  
  public void d(String paramString)
  {
    if (!this.c)
    {
      AVPreloadLog.c("AVPreload|Core", "preparePlay but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    Object localObject = this.d.b().values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((List)((Iterator)localObject).next()).iterator();
      while (localIterator.hasNext()) {
        ((AVPreloadTask)localIterator.next()).d(false);
      }
    }
    this.a.h();
    localObject = this.a.c(paramString);
    if (localObject != null)
    {
      ((AVPreloadTask)localObject).d(true);
      this.a.a((AVPreloadTask)localObject);
      paramString = new StringBuilder();
      paramString.append("------prepare play,url = ");
      paramString.append(((AVPreloadTask)localObject).s());
      paramString.append("local url = ");
      paramString.append(((AVPreloadTask)localObject).t());
      paramString.append(" scene = ");
      paramString.append(this.g);
      AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------prepare play but task is not ready, url = ");
    ((StringBuilder)localObject).append(paramString);
    AVPreloadLog.c("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
  }
  
  public void e(String paramString) {}
  
  public boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = g(paramString);
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://127.0.0.1"));
  }
  
  public String g(String paramString)
  {
    if ((this.f) && (!this.b.c(this.g)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("------exchangeLocalServerPlayUrl not support preload Scenes ");
      ((StringBuilder)localObject).append(this.g);
      AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
      return paramString;
    }
    String str = AVPreloadUtils.c(paramString);
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    str = a(paramString, (String)localObject);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = b(paramString, (String)localObject);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    localObject = c(paramString, (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    return paramString;
  }
  
  public String h(String paramString)
  {
    Object localObject2 = AVPreloadUtils.b(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Iterator localIterator1 = this.d.b().values().iterator();
    do
    {
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
      localObject2 = (AVPreloadTask)localIterator2.next();
    } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).t())) && (!((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).t()))));
    paramString = new StringBuilder();
    paramString.append("------ exchangeRemoteServerPlayUrl url = ");
    paramString.append(((AVPreloadTask)localObject2).s());
    paramString.append(" local url = ");
    paramString.append(((AVPreloadTask)localObject2).t());
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    return ((AVPreloadTask)localObject2).s();
    localIterator1 = this.a.d().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (AVPreloadTask)localIterator1.next();
      if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).t())) || (((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).t()))))
      {
        paramString = new StringBuilder();
        paramString.append("------ exchangeRemoteServerPlayUrl url = ");
        paramString.append(((AVPreloadTask)localObject2).s());
        paramString.append(" local url = ");
        paramString.append(((AVPreloadTask)localObject2).t());
        AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
        return ((AVPreloadTask)localObject2).s();
      }
    }
    localIterator1 = this.a.c().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (AVPreloadTask)localIterator1.next();
      if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).t())) || (((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).t()))))
      {
        paramString = new StringBuilder();
        paramString.append("------ exchangeRemoteServerPlayUrl url = ");
        paramString.append(((AVPreloadTask)localObject2).s());
        paramString.append(" local url = ");
        paramString.append(((AVPreloadTask)localObject2).t());
        AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
        return ((AVPreloadTask)localObject2).s();
      }
    }
    localIterator1 = this.a.e().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (AVPreloadTask)localIterator1.next();
      if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).t())) || (((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).t()))))
      {
        paramString = new StringBuilder();
        paramString.append("------ exchangeRemoteServerPlayUrl url = ");
        paramString.append(((AVPreloadTask)localObject2).s());
        paramString.append(" local url = ");
        paramString.append(((AVPreloadTask)localObject2).t());
        AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
        return ((AVPreloadTask)localObject2).s();
      }
    }
    localIterator1 = this.a.f().iterator();
    do
    {
      localObject2 = paramString;
      if (!localIterator1.hasNext()) {
        break;
      }
      localObject2 = (AVPreloadTask)localIterator1.next();
    } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).t())) && (!((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).t()))));
    paramString = new StringBuilder();
    paramString.append("------ exchangeRemoteServerPlayUrl url = ");
    paramString.append(((AVPreloadTask)localObject2).s());
    paramString.append(" local url = ");
    paramString.append(((AVPreloadTask)localObject2).t());
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    localObject2 = ((AVPreloadTask)localObject2).s();
    return localObject2;
  }
  
  public AVPreloadTask i(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return null;
      }
      Object localObject2 = AVPreloadUtils.c(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = d(paramString, (String)localObject1);
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = e(paramString, (String)localObject1);
      if (localObject2 != null) {
        return localObject2;
      }
      paramString = f(paramString, (String)localObject1);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  public void onCreate(Context paramContext)
  {
    AVPreloadLog.a(this.e.a());
    this.b = new AVPreloadSwitch();
    this.b.a(this.e);
    this.a = new AVPreloadTaskManager();
    this.a.a(paramContext, this.e.b(), new AVPreloadService.1(this), this.e.c());
    this.d = new AVPreloadStrategyManger();
    this.d.a(this);
    this.b.a(this);
    a();
  }
  
  public void onDestroy()
  {
    ThreadCenter.clear(this);
    this.c = false;
    this.a.a();
    this.d.a();
    this.b.a(null);
    AVPreloadLog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadService
 * JD-Core Version:    0.7.0.1
 */