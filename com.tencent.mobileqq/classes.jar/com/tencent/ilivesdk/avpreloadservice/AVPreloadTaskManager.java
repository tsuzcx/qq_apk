package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadResultListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadTaskInterface.TaskReportInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class AVPreloadTaskManager
  implements ThreadCenter.HandlerKeyable, AVPreloadEngine.PreloadResultListener
{
  private Context a;
  private AVPreloadEngine b;
  private final Object c = new Object();
  private int d = 60;
  private int e = 6;
  private int f = 2;
  private int g = 6;
  private int h = 5;
  private Set<AVPreloadServiceInterface.AVPreloadResultListener> i = new HashSet();
  private List<AVPreloadTask> j = new ArrayList();
  private List<AVPreloadTask> k = new ArrayList();
  private List<AVPreloadTask> l = new ArrayList();
  private List<AVPreloadTask> m = new ArrayList();
  private String n = "";
  private Runnable o = new AVPreloadTaskManager.2(this);
  
  private boolean e(AVPreloadTask paramAVPreloadTask)
  {
    synchronized (this.c)
    {
      Object localObject2;
      if (paramAVPreloadTask.o() <= 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task refresh cycle is ");
        ((StringBuilder)localObject2).append(paramAVPreloadTask.o());
        ((StringBuilder)localObject2).append(" not to update!");
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
        return false;
      }
      long l1 = paramAVPreloadTask.w() + 1L;
      paramAVPreloadTask.l(l1);
      if (l1 > this.h)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("refresh time out max time = ");
        ((StringBuilder)localObject2).append(this.h);
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
        paramAVPreloadTask.l(0L);
        d(paramAVPreloadTask);
        return false;
      }
      while (this.l.size() > this.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("update queue size:");
        ((StringBuilder)localObject2).append(this.l.size());
        ((StringBuilder)localObject2).append("  > max size:");
        ((StringBuilder)localObject2).append(this.e);
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
        localObject2 = (AVPreloadTask)this.l.get(0);
        this.l.remove(localObject2);
        d((AVPreloadTask)localObject2);
      }
      paramAVPreloadTask.k(System.currentTimeMillis());
      this.l.add(paramAVPreloadTask);
      return true;
    }
    for (;;)
    {
      throw paramAVPreloadTask;
    }
  }
  
  private boolean f(AVPreloadTask paramAVPreloadTask)
  {
    if (paramAVPreloadTask == null)
    {
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "preload queue task is null", new Object[0]);
      return false;
    }
    synchronized (this.c)
    {
      if (this.k.contains(paramAVPreloadTask))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preload queue is contain task  url= ");
        localStringBuilder.append(paramAVPreloadTask.s());
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", localStringBuilder.toString(), new Object[0]);
        return false;
      }
      if (this.k.size() >= this.f)
      {
        paramAVPreloadTask = new StringBuilder();
        paramAVPreloadTask.append("preload queue is full, max count = ");
        paramAVPreloadTask.append(this.f);
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", paramAVPreloadTask.toString(), new Object[0]);
        return false;
      }
      this.k.add(paramAVPreloadTask);
      return true;
    }
  }
  
  private boolean g(AVPreloadTask paramAVPreloadTask)
  {
    if (paramAVPreloadTask == null)
    {
      AVPreloadLog.a("AVPreload|AVPreloadTaskManager", "remove task from preload queue,but task is null", new Object[0]);
      return false;
    }
    if (!this.k.contains(paramAVPreloadTask)) {
      return false;
    }
    synchronized (this.c)
    {
      Object localObject2 = this.k.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AVPreloadTask localAVPreloadTask = (AVPreloadTask)((Iterator)localObject2).next();
        if ((localAVPreloadTask.s().equalsIgnoreCase(paramAVPreloadTask.s())) || (localAVPreloadTask.q().equalsIgnoreCase(paramAVPreloadTask.q())))
        {
          ((Iterator)localObject2).remove();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remove task taskId=#");
          ((StringBuilder)localObject2).append(paramAVPreloadTask.r());
          ((StringBuilder)localObject2).append(" key id=");
          ((StringBuilder)localObject2).append(paramAVPreloadTask.q());
          AVPreloadLog.a("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
          return true;
        }
      }
      return false;
    }
    for (;;)
    {
      throw paramAVPreloadTask;
    }
  }
  
  private boolean h(AVPreloadTask paramAVPreloadTask)
  {
    if (paramAVPreloadTask == null)
    {
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "enter waiting queue but task is null.", new Object[0]);
      return false;
    }
    if (paramAVPreloadTask.B())
    {
      d(paramAVPreloadTask);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("------enter waiting queue, but task is playing, taskId=#");
      ((StringBuilder)???).append(paramAVPreloadTask.r());
      ((StringBuilder)???).append("url = ");
      ((StringBuilder)???).append(paramAVPreloadTask.s());
      AVPreloadLog.c("AVPreload|Core", ((StringBuilder)???).toString(), new Object[0]);
      return false;
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if (TextUtils.isEmpty(localAVPreloadTask.s()))
        {
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "item url is empty", new Object[0]);
        }
        else if (TextUtils.isEmpty(localAVPreloadTask.q()))
        {
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "item keyId is empty", new Object[0]);
        }
        else if ((localAVPreloadTask.s().equalsIgnoreCase(paramAVPreloadTask.s())) || (localAVPreloadTask.q().equalsIgnoreCase(paramAVPreloadTask.q())))
        {
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "waiting queue has the task.", new Object[0]);
          return false;
        }
      }
      this.j.add(0, paramAVPreloadTask);
      paramAVPreloadTask = new StringBuilder();
      paramAVPreloadTask.append("-----waiting queue max size:");
      paramAVPreloadTask.append(this.e);
      paramAVPreloadTask.append(" waiting queue current size:");
      paramAVPreloadTask.append(this.j.size());
      AVPreloadLog.b("AVPreload|Core", paramAVPreloadTask.toString(), new Object[0]);
      while (this.j.size() > this.e)
      {
        paramAVPreloadTask = (AVPreloadTask)this.j.get(this.j.size() - 1);
        this.l.remove(paramAVPreloadTask);
        this.j.remove(this.j.size() - 1);
        if (paramAVPreloadTask.u() < 200) {
          paramAVPreloadTask.e(50);
        }
        d(paramAVPreloadTask);
      }
      return true;
    }
    for (;;)
    {
      throw paramAVPreloadTask;
    }
  }
  
  private void j()
  {
    synchronized (this.c)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      Iterator localIterator = this.k.iterator();
      Object localObject3;
      while (localIterator.hasNext())
      {
        localObject3 = (AVPreloadTask)localIterator.next();
        long l1 = System.currentTimeMillis() - ((AVPreloadTask)localObject3).b();
        if (l1 >= 10000L)
        {
          localCopyOnWriteArrayList.add(localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("preload time out, preload time = ");
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append(" > max time = ");
          ((StringBuilder)localObject3).append(10000);
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject3).toString(), new Object[0]);
        }
      }
      localIterator = localCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (AVPreloadTask)localIterator.next();
        this.b.c((AVPreloadTaskInterface)localObject3);
        this.k.remove(localObject3);
        ((AVPreloadTask)localObject3).e(50);
        h((AVPreloadTask)localObject3);
      }
      localCopyOnWriteArrayList.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void k()
  {
    synchronized (this.c)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      Iterator localIterator = this.l.iterator();
      AVPreloadTask localAVPreloadTask;
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if (System.currentTimeMillis() - localAVPreloadTask.v() >= localAVPreloadTask.o() * 1000L) {
          localCopyOnWriteArrayList.add(localAVPreloadTask);
        }
      }
      localIterator = localCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        this.l.remove(localAVPreloadTask);
        if (localAVPreloadTask.u() < 200) {
          localAVPreloadTask.e(50);
        }
        h(localAVPreloadTask);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update time out url =");
        localStringBuilder.append(localAVPreloadTask.s());
        localStringBuilder.append("update queue task size=");
        localStringBuilder.append(this.l.size());
        AVPreloadLog.a("AVPreload|AVPreloadTaskManager", localStringBuilder.toString(), new Object[0]);
      }
      g();
      localCopyOnWriteArrayList.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private AVPreloadTask l()
  {
    synchronized (this.c)
    {
      if (this.j.size() == 0)
      {
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "deWaitingQueue waiting queue is empty.", new Object[0]);
        return null;
      }
      AVPreloadTask localAVPreloadTask = (AVPreloadTask)this.j.get(0);
      this.j.remove(0);
      return localAVPreloadTask;
    }
  }
  
  public AVPreloadTask a(long paramLong)
  {
    Iterator localIterator = this.j.iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.r() == paramLong) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.r() == paramLong) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.r() == paramLong) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.r() == paramLong) {
        return localAVPreloadTask;
      }
    }
    return null;
  }
  
  public void a()
  {
    b();
    ThreadCenter.clear(this);
    this.b.a();
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Context paramContext, AppGeneralInfoService paramAppGeneralInfoService, AVPreloadTaskManager.DLProxyInitCompletedListener paramDLProxyInitCompletedListener, HttpInterface paramHttpInterface)
  {
    this.a = paramContext;
    this.b = new AVPreloadEngine(paramContext, paramHttpInterface);
    this.b.a(this);
    ThreadCenter.postLogicTask(new AVPreloadTaskManager.1(this, paramContext, paramAppGeneralInfoService, paramDLProxyInitCompletedListener), "init_dlproxy_thread");
  }
  
  public void a(AVPreloadTask paramAVPreloadTask)
  {
    synchronized (this.c)
    {
      if (this.k.contains(paramAVPreloadTask))
      {
        this.k.remove(paramAVPreloadTask);
        d(paramAVPreloadTask);
        return;
      }
      if (this.j.contains(paramAVPreloadTask))
      {
        d(paramAVPreloadTask);
        return;
      }
      if (this.l.contains(paramAVPreloadTask))
      {
        d(paramAVPreloadTask);
        return;
      }
      return;
    }
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.i.add(paramAVPreloadResultListener);
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task preload failed taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.r());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.s());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).b(paramAVPreloadTaskInterface.s(), paramAVPreloadTaskInterface);
    }
    g((AVPreloadTask)paramAVPreloadTaskInterface);
    g();
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, Bitmap paramBitmap, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------ task first frame come taskId=#");
    localStringBuilder.append(paramAVPreloadTaskInterface.r());
    localStringBuilder.append(" url = ");
    localStringBuilder.append(paramAVPreloadTaskInterface.s());
    AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
    paramAVPreloadTaskInterface.a(paramBitmap);
    paramAVPreloadTaskInterface.b(paramBoolean);
    int i1 = UIUtil.getScreenWidth(this.a);
    int i2 = UIUtil.getScreenHeight(this.a);
    paramAVPreloadTaskInterface.f(Math.max(i1 / 5, i2 / 5));
    paramBitmap = this.i.iterator();
    while (paramBitmap.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramBitmap.next()).e(paramAVPreloadTaskInterface.s(), paramAVPreloadTaskInterface);
    }
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, String paramString, long paramLong)
  {
    paramString = new StringBuilder();
    paramString.append("------ task gap time come  taskId=#");
    paramString.append(paramAVPreloadTaskInterface.r());
    paramString.append(" url = ");
    paramString.append(paramAVPreloadTaskInterface.s());
    paramString.append(" gap time = ");
    paramString.append(paramLong);
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    paramString = this.i.iterator();
    while (paramString.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramString.next()).a(paramAVPreloadTaskInterface.s(), paramLong, paramAVPreloadTaskInterface);
    }
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, String paramString, AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo)
  {
    paramString = new StringBuilder();
    paramString.append("------ task preload finish taskId=#");
    paramString.append(paramAVPreloadTaskInterface.r());
    paramString.append(" url = ");
    paramString.append(paramAVPreloadTaskInterface.s());
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    paramAVPreloadTaskInterface.b(System.currentTimeMillis());
    paramString = this.i.iterator();
    while (paramString.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramString.next()).a(paramAVPreloadTaskInterface.s(), paramTaskReportInfo, paramAVPreloadTaskInterface);
    }
    paramAVPreloadTaskInterface = (AVPreloadTask)paramAVPreloadTaskInterface;
    g(paramAVPreloadTaskInterface);
    e(paramAVPreloadTaskInterface);
    g();
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(List<Long> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      synchronized (this.c)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          long l1 = ((Long)paramList.next()).longValue();
          if (a(l1) == null)
          {
            this.b.a((int)l1);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("------task cache check, not find task id =#");
            localStringBuilder.append(l1);
            AVPreloadLog.c("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
            paramList.remove();
          }
        }
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public void b()
  {
    this.i.clear();
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.i.remove(paramAVPreloadResultListener);
  }
  
  public void b(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task preload complete taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.r());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.s());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).c(paramAVPreloadTaskInterface.s(), paramAVPreloadTaskInterface);
    }
    g((AVPreloadTask)paramAVPreloadTaskInterface);
    g();
  }
  
  public void b(String paramString)
  {
    this.b.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }
  
  public boolean b(AVPreloadTask paramAVPreloadTask)
  {
    if (this.k.contains(paramAVPreloadTask)) {
      return true;
    }
    if (this.j.contains(paramAVPreloadTask)) {
      return true;
    }
    return this.l.contains(paramAVPreloadTask);
  }
  
  public AVPreloadTask c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "url2Task url is null.", new Object[0]);
      return null;
    }
    Iterator localIterator = this.j.iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.s().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.q().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.s().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.q().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.s().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.q().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.s().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.q().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.q()))) {
        return localAVPreloadTask;
      }
    }
    return null;
  }
  
  public List<AVPreloadTask> c()
  {
    return this.j;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c(AVPreloadTask paramAVPreloadTask)
  {
    paramAVPreloadTask.d(false);
    synchronized (this.c)
    {
      if (this.k.contains(paramAVPreloadTask))
      {
        this.b.b(paramAVPreloadTask);
        this.k.remove(paramAVPreloadTask);
        d(paramAVPreloadTask);
        return;
      }
      if (this.j.contains(paramAVPreloadTask))
      {
        this.j.remove(paramAVPreloadTask);
        d(paramAVPreloadTask);
        return;
      }
      if (this.l.contains(paramAVPreloadTask))
      {
        this.l.remove(paramAVPreloadTask);
        d(paramAVPreloadTask);
        return;
      }
      this.b.b(paramAVPreloadTask);
      return;
    }
  }
  
  public void c(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task preload stop taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.r());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.s());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).d(paramAVPreloadTaskInterface.s(), paramAVPreloadTaskInterface);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  public List<AVPreloadTask> d()
  {
    return this.k;
  }
  
  public void d(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task can play  taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.r());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.s());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).f(paramAVPreloadTaskInterface.s(), paramAVPreloadTaskInterface);
    }
  }
  
  public boolean d(AVPreloadTask paramAVPreloadTask)
  {
    synchronized (this.c)
    {
      while (this.m.contains(paramAVPreloadTask))
      {
        this.m.remove(paramAVPreloadTask);
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "enEliminatedQueue eliminated queue contain the task, remove the task", new Object[0]);
      }
      if ((paramAVPreloadTask.u() == 200) && (this.m.size() != 0) && (this.m.get(0) != null) && (((AVPreloadTask)this.m.get(0)).u() == 200))
      {
        localObject2 = (AVPreloadTask)this.m.get(0);
        if (!((AVPreloadTask)localObject2).B()) {
          ((AVPreloadTask)localObject2).e(100);
        }
        this.m.remove(localObject2);
        this.m.add(0, paramAVPreloadTask);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TASK_PRIORITY_URGENT change to TASK_PRIORITY_NORMAL url = ");
        localStringBuilder.append(((AVPreloadTask)localObject2).s());
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", localStringBuilder.toString(), new Object[0]);
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("------enter eliminated queue url = ");
      ((StringBuilder)localObject2).append(paramAVPreloadTask.s());
      ((StringBuilder)localObject2).append(" priority is ");
      ((StringBuilder)localObject2).append(paramAVPreloadTask.u());
      AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject2).toString(), new Object[0]);
      this.m.add(0, paramAVPreloadTask);
      Collections.sort(this.m, new AVPreloadTaskManager.3(this));
      while (this.m.size() > this.g)
      {
        localObject2 = (AVPreloadTask)this.m.get(this.m.size() - 1);
        if (localObject2 != null)
        {
          this.m.remove(this.m.size() - 1);
          if (((AVPreloadTask)localObject2).B())
          {
            this.m.add(0, localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("------playing task can not eliminated queue url = ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.s());
            ((StringBuilder)localObject2).append(" priority is ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.u());
            AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject2).toString(), new Object[0]);
          }
          else
          {
            this.b.b((AVPreloadTaskInterface)localObject2);
            ((AVPreloadTask)localObject2).A();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("------remove from eliminated queue url = ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.s());
            ((StringBuilder)localObject2).append(" priority is ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.u());
            AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject2).toString(), new Object[0]);
          }
        }
      }
      return true;
    }
    for (;;)
    {
      throw paramAVPreloadTask;
    }
  }
  
  public List<AVPreloadTask> e()
  {
    return this.l;
  }
  
  public void e(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (paramAVPreloadTaskInterface == null) {
      return;
    }
    synchronized (this.c)
    {
      if (this.m.contains(paramAVPreloadTaskInterface)) {
        this.m.remove(paramAVPreloadTaskInterface);
      }
      if (paramAVPreloadTaskInterface.u() < 100) {
        paramAVPreloadTaskInterface.e(100);
      }
      h((AVPreloadTask)paramAVPreloadTaskInterface);
      if (this.k.size() < 2)
      {
        paramAVPreloadTaskInterface = new StringBuilder();
        paramAVPreloadTaskInterface.append("add task current size=");
        paramAVPreloadTaskInterface.append(this.k.size());
        paramAVPreloadTaskInterface.append(" < max count=");
        paramAVPreloadTaskInterface.append(2);
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", paramAVPreloadTaskInterface.toString(), new Object[0]);
        g();
        return;
      }
      synchronized (this.c)
      {
        Object localObject2 = this.k.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          AVPreloadTask localAVPreloadTask = (AVPreloadTask)((Iterator)localObject2).next();
          if (localAVPreloadTask.u() < paramAVPreloadTaskInterface.u())
          {
            this.b.c(localAVPreloadTask);
            ((Iterator)localObject2).remove();
            h(localAVPreloadTask);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("pause one low level task, add task taskId#");
            ((StringBuilder)localObject2).append(paramAVPreloadTaskInterface.r());
            ((StringBuilder)localObject2).append(" key id=");
            ((StringBuilder)localObject2).append(paramAVPreloadTaskInterface.q());
            AVPreloadLog.a("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
          }
        }
        g();
        return;
      }
    }
    for (;;)
    {
      throw paramAVPreloadTaskInterface;
    }
  }
  
  public List<AVPreloadTask> f()
  {
    return this.m;
  }
  
  /* Error */
  public void f(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:c	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 61	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:k	Ljava/util/List;
    //   18: aload_1
    //   19: invokeinterface 159 2 0
    //   24: ifeq +31 -> 55
    //   27: aload_0
    //   28: getfield 80	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:b	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   31: aload_1
    //   32: invokevirtual 419	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   35: aload_0
    //   36: getfield 61	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:k	Ljava/util/List;
    //   39: aload_1
    //   40: invokeinterface 144 2 0
    //   45: pop
    //   46: aload_1
    //   47: invokeinterface 463 1 0
    //   52: aload_2
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 59	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:j	Ljava/util/List;
    //   59: aload_1
    //   60: invokeinterface 159 2 0
    //   65: ifeq +31 -> 96
    //   68: aload_0
    //   69: getfield 80	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:b	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   72: aload_1
    //   73: invokevirtual 419	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   76: aload_0
    //   77: getfield 59	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:j	Ljava/util/List;
    //   80: aload_1
    //   81: invokeinterface 144 2 0
    //   86: pop
    //   87: aload_1
    //   88: invokeinterface 463 1 0
    //   93: aload_2
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 63	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:l	Ljava/util/List;
    //   100: aload_1
    //   101: invokeinterface 159 2 0
    //   106: ifeq +31 -> 137
    //   109: aload_0
    //   110: getfield 80	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:b	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   113: aload_1
    //   114: invokevirtual 419	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   117: aload_0
    //   118: getfield 63	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:l	Ljava/util/List;
    //   121: aload_1
    //   122: invokeinterface 144 2 0
    //   127: pop
    //   128: aload_1
    //   129: invokeinterface 463 1 0
    //   134: aload_2
    //   135: monitorexit
    //   136: return
    //   137: aload_0
    //   138: getfield 65	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:m	Ljava/util/List;
    //   141: aload_1
    //   142: invokeinterface 159 2 0
    //   147: ifeq +46 -> 193
    //   150: aload_1
    //   151: invokeinterface 454 1 0
    //   156: sipush 200
    //   159: if_icmpne +6 -> 165
    //   162: aload_2
    //   163: monitorexit
    //   164: return
    //   165: aload_0
    //   166: getfield 80	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:b	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   169: aload_1
    //   170: invokevirtual 419	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   173: aload_0
    //   174: getfield 65	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:m	Ljava/util/List;
    //   177: aload_1
    //   178: invokeinterface 144 2 0
    //   183: pop
    //   184: aload_1
    //   185: invokeinterface 463 1 0
    //   190: aload_2
    //   191: monitorexit
    //   192: return
    //   193: aload_2
    //   194: monitorexit
    //   195: return
    //   196: astore_1
    //   197: aload_2
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	AVPreloadTaskManager
    //   0	201	1	paramAVPreloadTaskInterface	AVPreloadTaskInterface
    //   4	194	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	196	finally
    //   14	54	196	finally
    //   55	95	196	finally
    //   96	136	196	finally
    //   137	164	196	finally
    //   165	192	196	finally
    //   193	195	196	finally
    //   197	199	196	finally
  }
  
  public void g()
  {
    if (this.j.size() == 0) {
      return;
    }
    if (this.k.size() >= 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preload size=");
      ((StringBuilder)localObject).append(this.k.size());
      ((StringBuilder)localObject).append(">= max count");
      ((StringBuilder)localObject).append(2);
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject).toString(), new Object[0]);
      return;
    }
    Object localObject = l();
    if (!((AVPreloadTask)localObject).B())
    {
      this.b.b((AVPreloadTaskInterface)localObject);
      if (f((AVPreloadTask)localObject))
      {
        ((AVPreloadTask)localObject).a(System.currentTimeMillis());
        this.b.a((AVPreloadTaskInterface)localObject);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("------start preload task taskId =#");
        localStringBuilder.append(((AVPreloadTask)localObject).r());
        localStringBuilder.append(" url = ");
        localStringBuilder.append(((AVPreloadTask)localObject).s());
        AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
        g((AVPreloadTaskInterface)localObject);
        return;
      }
      AVPreloadLog.c("AVPreload|Core", "------start preload task failed, enter preload queue failed.", new Object[0]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------start preload but task is playing taskId =#");
    localStringBuilder.append(((AVPreloadTask)localObject).r());
    localStringBuilder.append(" url = ");
    localStringBuilder.append(((AVPreloadTask)localObject).s());
    AVPreloadLog.c("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
  }
  
  public void g(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    paramAVPreloadTaskInterface.a(System.currentTimeMillis());
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)localIterator.next()).a(paramAVPreloadTaskInterface.s(), paramAVPreloadTaskInterface);
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
    localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
    localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
    localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
  }
  
  public void i()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.k.iterator();
      AVPreloadTask localAVPreloadTask;
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        this.b.b(localAVPreloadTask);
        if (localAVPreloadTask.u() < 200) {
          localAVPreloadTask.e(70);
        }
        localAVPreloadTask.d(false);
        localAVPreloadTask.c(System.currentTimeMillis());
        localIterator.remove();
        d(localAVPreloadTask);
      }
      localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localAVPreloadTask.d(false);
        localIterator.remove();
        d(localAVPreloadTask);
      }
      localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localAVPreloadTask.d(false);
        localIterator.remove();
        d(localAVPreloadTask);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager
 * JD-Core Version:    0.7.0.1
 */