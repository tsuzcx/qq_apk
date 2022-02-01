package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
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
  private int jdField_a_of_type_Int = 15;
  private Context jdField_a_of_type_AndroidContentContext;
  private AVPreloadEngine jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVPreloadTaskManager.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private List<AVPreloadTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<AVPreloadServiceInterface.AVPreloadResultListener> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int = 6;
  private List<AVPreloadTask> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int = 1;
  private List<AVPreloadTask> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int jdField_d_of_type_Int = 6;
  private List<AVPreloadTask> jdField_d_of_type_JavaUtilList = new ArrayList();
  
  public AVPreloadTaskManager(Context paramContext, AppGeneralInfoService paramAppGeneralInfoService)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine = new AVPreloadEngine(paramContext);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a(paramContext, paramAppGeneralInfoService.getTPPlatform(), paramAppGeneralInfoService.getTPPlayerGuid());
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a(this);
    ThreadCenter.postDelayedUITask(this, this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private AVPreloadTask a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "deWaitingQueue waiting queue is empty.", new Object[0]);
        return null;
      }
      AVPreloadTask localAVPreloadTask = (AVPreloadTask)this.jdField_a_of_type_JavaUtilList.get(0);
      this.jdField_a_of_type_JavaUtilList.remove(0);
      return localAVPreloadTask;
    }
  }
  
  private boolean c(AVPreloadTask paramAVPreloadTask)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (paramAVPreloadTask.e() <= 0)
      {
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "task refresh cycle is " + paramAVPreloadTask.e() + " not to update!", new Object[0]);
        return false;
      }
      if (this.jdField_c_of_type_JavaUtilList.size() > this.jdField_b_of_type_Int)
      {
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "update queue size:" + this.jdField_c_of_type_JavaUtilList.size() + "  > max size:" + this.jdField_b_of_type_Int, new Object[0]);
        AVPreloadTask localAVPreloadTask = (AVPreloadTask)this.jdField_c_of_type_JavaUtilList.get(0);
        this.jdField_c_of_type_JavaUtilList.remove(localAVPreloadTask);
        b(localAVPreloadTask);
      }
    }
    paramAVPreloadTask.k(System.currentTimeMillis());
    this.jdField_c_of_type_JavaUtilList.add(paramAVPreloadTask);
    return true;
  }
  
  private boolean d(AVPreloadTask paramAVPreloadTask)
  {
    if (paramAVPreloadTask == null)
    {
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "preload queue task is null", new Object[0]);
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "preload queue is contain task  url= " + paramAVPreloadTask.b(), new Object[0]);
        return false;
      }
    }
    if (this.jdField_b_of_type_JavaUtilList.size() >= this.jdField_c_of_type_Int)
    {
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "preload queue is full, max count = " + this.jdField_c_of_type_Int, new Object[0]);
      return false;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramAVPreloadTask);
    return true;
  }
  
  private boolean e(AVPreloadTask paramAVPreloadTask)
  {
    if (paramAVPreloadTask == null)
    {
      AVPreloadLog.a("AVPreload|AVPreloadTaskManager", "remove task from preload queue,but task is null", new Object[0]);
      return false;
    }
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramAVPreloadTask)) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if ((localAVPreloadTask.b().equalsIgnoreCase(paramAVPreloadTask.b())) || (localAVPreloadTask.a().equalsIgnoreCase(paramAVPreloadTask.a())))
        {
          localIterator.remove();
          AVPreloadLog.a("AVPreload|AVPreloadTaskManager", "remove task taskId=#" + paramAVPreloadTask.j() + " key id=" + paramAVPreloadTask.a(), new Object[0]);
          return true;
        }
      }
    }
    return false;
  }
  
  private void f()
  {
    AVPreloadTask localAVPreloadTask;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        long l = System.currentTimeMillis() - localAVPreloadTask.a();
        if (l >= 10000L)
        {
          localCopyOnWriteArrayList.add(localAVPreloadTask);
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "preload time out, preload time = " + l + " > max time = " + 10000, new Object[0]);
        }
      }
    }
    Iterator localIterator = localObject2.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.c(localAVPreloadTask);
      this.jdField_b_of_type_JavaUtilList.remove(localAVPreloadTask);
      localAVPreloadTask.e(50);
      f(localAVPreloadTask);
    }
    localObject2.clear();
  }
  
  private boolean f(AVPreloadTask paramAVPreloadTask)
  {
    if (paramAVPreloadTask == null)
    {
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "enter waiting queue but task is null.", new Object[0]);
      return false;
    }
    if (paramAVPreloadTask.c())
    {
      b(paramAVPreloadTask);
      AVPreloadLog.c("AVPreload|Core", "------enter waiting queue, but task is playing, taskId=#" + paramAVPreloadTask.j() + "url = " + paramAVPreloadTask.b(), new Object[0]);
      return false;
    }
    for (;;)
    {
      AVPreloadTask localAVPreloadTask;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if (TextUtils.isEmpty(localAVPreloadTask.b())) {
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "item url is empty", new Object[0]);
        }
      }
      if (TextUtils.isEmpty(localAVPreloadTask.a()))
      {
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "item keyId is empty", new Object[0]);
      }
      else if ((localAVPreloadTask.b().equalsIgnoreCase(paramAVPreloadTask.b())) || (localAVPreloadTask.a().equalsIgnoreCase(paramAVPreloadTask.a())))
      {
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "waiting queue has the task.", new Object[0]);
        return false;
      }
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramAVPreloadTask);
    AVPreloadLog.b("AVPreload|Core", "-----waiting queue max size:" + this.jdField_b_of_type_Int + " waiting queue current size:" + this.jdField_a_of_type_JavaUtilList.size(), new Object[0]);
    while (this.jdField_a_of_type_JavaUtilList.size() > this.jdField_b_of_type_Int)
    {
      paramAVPreloadTask = (AVPreloadTask)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_c_of_type_JavaUtilList.remove(paramAVPreloadTask);
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      if (paramAVPreloadTask.f() < 200) {
        paramAVPreloadTask.e(50);
      }
      b(paramAVPreloadTask);
    }
    return true;
  }
  
  private void g()
  {
    AVPreloadTask localAVPreloadTask;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if (System.currentTimeMillis() - localAVPreloadTask.k() >= localAVPreloadTask.e() * 1000L) {
          localCopyOnWriteArrayList.add(localAVPreloadTask);
        }
      }
    }
    Iterator localIterator = localObject2.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      this.jdField_c_of_type_JavaUtilList.remove(localAVPreloadTask);
      if (localAVPreloadTask.f() < 200) {
        localAVPreloadTask.e(50);
      }
      f(localAVPreloadTask);
      AVPreloadLog.a("AVPreload|AVPreloadTaskManager", "update time out url =" + localAVPreloadTask.b() + "update queue task size=" + this.jdField_c_of_type_JavaUtilList.size(), new Object[0]);
    }
    c();
    localObject2.clear();
  }
  
  public AVPreloadTask a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.j() == paramLong) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.j() == paramLong) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.j() == paramLong) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.j() == paramLong) {
        return localAVPreloadTask;
      }
    }
    return null;
  }
  
  public AVPreloadTask a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "url2Task url is null.", new Object[0]);
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    AVPreloadTask localAVPreloadTask;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localObject = localAVPreloadTask;
        if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
          break;
        }
        if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
          return localAVPreloadTask;
        }
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localObject = localAVPreloadTask;
        if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
          break;
        }
        if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
          return localAVPreloadTask;
        }
      }
    }
    localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localObject = localAVPreloadTask;
        if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
          break;
        }
        if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
          return localAVPreloadTask;
        }
      }
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localObject = localAVPreloadTask;
        if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
          break;
        }
        if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
          return localAVPreloadTask;
        }
      }
    }
    return null;
  }
  
  public List<AVPreloadTask> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    b();
    ThreadCenter.clear(this);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a();
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(AVPreloadTask paramAVPreloadTask)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramAVPreloadTask);
        b(paramAVPreloadTask);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        b(paramAVPreloadTask);
        return;
      }
    }
    if (this.jdField_c_of_type_JavaUtilList.contains(paramAVPreloadTask))
    {
      b(paramAVPreloadTask);
      return;
    }
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramAVPreloadResultListener);
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadLog.b("AVPreload|Core", "------ task preload failed taskId=#" + paramAVPreloadTaskInterface.j() + " url = " + paramAVPreloadTaskInterface.b(), new Object[0]);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)localIterator.next()).b(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
    e((AVPreloadTask)paramAVPreloadTaskInterface);
    c();
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, Bitmap paramBitmap, boolean paramBoolean)
  {
    AVPreloadLog.b("AVPreload|Core", "------ task first frame come taskId=#" + paramAVPreloadTaskInterface.j() + " url = " + paramAVPreloadTaskInterface.b(), new Object[0]);
    paramAVPreloadTaskInterface.a(paramBitmap);
    paramAVPreloadTaskInterface.b(paramBoolean);
    int i = UIUtil.getScreenWidth(this.jdField_a_of_type_AndroidContentContext);
    int j = UIUtil.getScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    paramAVPreloadTaskInterface.f(Math.max(i / 5, j / 5));
    paramBitmap = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (paramBitmap.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramBitmap.next()).e(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, String paramString, long paramLong)
  {
    AVPreloadLog.b("AVPreload|Core", "------ task gap time come  taskId=#" + paramAVPreloadTaskInterface.j() + " url = " + paramAVPreloadTaskInterface.b() + " gap time = " + paramLong, new Object[0]);
    paramString = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (paramString.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramString.next()).a(paramAVPreloadTaskInterface.b(), paramLong, paramAVPreloadTaskInterface);
    }
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, String paramString, AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo)
  {
    AVPreloadLog.b("AVPreload|Core", "------ task preload finish taskId=#" + paramAVPreloadTaskInterface.j() + " url = " + paramAVPreloadTaskInterface.b(), new Object[0]);
    paramAVPreloadTaskInterface.b(System.currentTimeMillis());
    paramString = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (paramString.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramString.next()).a(paramAVPreloadTaskInterface.b(), paramTaskReportInfo, paramAVPreloadTaskInterface);
    }
    e((AVPreloadTask)paramAVPreloadTaskInterface);
    c((AVPreloadTask)paramAVPreloadTaskInterface);
    c();
  }
  
  public void a(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        long l = ((Long)paramList.next()).longValue();
        if (a(l) == null)
        {
          this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a((int)l);
          AVPreloadLog.c("AVPreload|Core", "------task cache check, not find task id =#" + l, new Object[0]);
          paramList.remove();
        }
      }
    }
  }
  
  public boolean a(AVPreloadTask paramAVPreloadTask)
  {
    if (this.jdField_b_of_type_JavaUtilList.contains(paramAVPreloadTask)) {}
    while ((this.jdField_a_of_type_JavaUtilList.contains(paramAVPreloadTask)) || (this.jdField_c_of_type_JavaUtilList.contains(paramAVPreloadTask))) {
      return true;
    }
    return false;
  }
  
  public List<AVPreloadTask> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(AVPreloadTask paramAVPreloadTask)
  {
    paramAVPreloadTask.d(false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(paramAVPreloadTask);
        this.jdField_b_of_type_JavaUtilList.remove(paramAVPreloadTask);
        b(paramAVPreloadTask);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramAVPreloadTask);
        b(paramAVPreloadTask);
        return;
      }
    }
    if (this.jdField_c_of_type_JavaUtilList.contains(paramAVPreloadTask))
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramAVPreloadTask);
      b(paramAVPreloadTask);
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(paramAVPreloadTask);
  }
  
  public void b(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramAVPreloadResultListener);
  }
  
  public void b(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadLog.b("AVPreload|Core", "------ task preload complete taskId=#" + paramAVPreloadTaskInterface.j() + " url = " + paramAVPreloadTaskInterface.b(), new Object[0]);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)localIterator.next()).c(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
    e((AVPreloadTask)paramAVPreloadTaskInterface);
    c();
  }
  
  public boolean b(AVPreloadTask paramAVPreloadTask)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_d_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        this.jdField_d_of_type_JavaUtilList.remove(paramAVPreloadTask);
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "enEliminatedQueue eliminated queue contain the task, remove the task", new Object[0]);
      }
    }
    AVPreloadTask localAVPreloadTask;
    if ((paramAVPreloadTask.f() == 200) && (this.jdField_d_of_type_JavaUtilList.size() != 0) && (this.jdField_d_of_type_JavaUtilList.get(0) != null) && (((AVPreloadTask)this.jdField_d_of_type_JavaUtilList.get(0)).f() == 200))
    {
      localAVPreloadTask = (AVPreloadTask)this.jdField_d_of_type_JavaUtilList.get(0);
      if (!localAVPreloadTask.c()) {
        localAVPreloadTask.e(100);
      }
      this.jdField_d_of_type_JavaUtilList.remove(localAVPreloadTask);
      this.jdField_d_of_type_JavaUtilList.add(0, paramAVPreloadTask);
      AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "TASK_PRIORITY_URGENT change to TASK_PRIORITY_NORMAL url = " + localAVPreloadTask.b(), new Object[0]);
    }
    AVPreloadLog.b("AVPreload|Core", "------enter eliminated queue url = " + paramAVPreloadTask.b() + " priority is " + paramAVPreloadTask.f(), new Object[0]);
    this.jdField_d_of_type_JavaUtilList.add(0, paramAVPreloadTask);
    Collections.sort(this.jdField_d_of_type_JavaUtilList, new AVPreloadTaskManager.2(this));
    while (this.jdField_d_of_type_JavaUtilList.size() > this.jdField_d_of_type_Int)
    {
      localAVPreloadTask = (AVPreloadTask)this.jdField_d_of_type_JavaUtilList.get(this.jdField_d_of_type_JavaUtilList.size() - 1);
      if (localAVPreloadTask != null)
      {
        this.jdField_d_of_type_JavaUtilList.remove(this.jdField_d_of_type_JavaUtilList.size() - 1);
        if (localAVPreloadTask.c())
        {
          this.jdField_d_of_type_JavaUtilList.add(0, localAVPreloadTask);
          AVPreloadLog.b("AVPreload|Core", "------playing task can not eliminated queue url = " + paramAVPreloadTask.b() + " priority is " + paramAVPreloadTask.f(), new Object[0]);
        }
        else
        {
          this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(localAVPreloadTask);
          localAVPreloadTask.a();
          AVPreloadLog.b("AVPreload|Core", "------remove from eliminated queue url = " + paramAVPreloadTask.b() + " priority is " + paramAVPreloadTask.f(), new Object[0]);
        }
      }
    }
    return true;
  }
  
  public List<AVPreloadTask> c()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() >= 1)
    {
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "preload size=" + this.jdField_b_of_type_JavaUtilList.size() + ">= max count" + 1, new Object[0]);
      return;
    }
    AVPreloadTask localAVPreloadTask = a();
    if (!localAVPreloadTask.c())
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(localAVPreloadTask);
      if (d(localAVPreloadTask))
      {
        localAVPreloadTask.a(System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a(localAVPreloadTask);
        AVPreloadLog.b("AVPreload|Core", "------start preload task taskId =#" + localAVPreloadTask.j() + " url = " + localAVPreloadTask.b(), new Object[0]);
        g(localAVPreloadTask);
      }
    }
    else
    {
      AVPreloadLog.c("AVPreload|Core", "------start preload but task is playing taskId =#" + localAVPreloadTask.j() + " url = " + localAVPreloadTask.b(), new Object[0]);
      return;
    }
    AVPreloadLog.c("AVPreload|Core", "------start preload task failed, enter preload queue failed.", new Object[0]);
  }
  
  public void c(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadLog.b("AVPreload|Core", "------ task preload stop taskId=#" + paramAVPreloadTaskInterface.j() + " url = " + paramAVPreloadTaskInterface.b(), new Object[0]);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)localIterator.next()).d(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
  }
  
  public List<AVPreloadTask> d()
  {
    return this.jdField_d_of_type_JavaUtilList;
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
    localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadTask)localIterator.next()).d(false);
    }
  }
  
  public void d(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    AVPreloadLog.b("AVPreload|Core", "------ task can play  taskId=#" + paramAVPreloadTaskInterface.j() + " url = " + paramAVPreloadTaskInterface.b(), new Object[0]);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)localIterator.next()).f(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
  }
  
  public void e()
  {
    AVPreloadTask localAVPreloadTask;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator1 = this.jdField_b_of_type_JavaUtilList.iterator();
      if (localIterator1.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator1.next();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(localAVPreloadTask);
        if (localAVPreloadTask.f() < 200) {
          localAVPreloadTask.e(70);
        }
        localAVPreloadTask.d(false);
        localAVPreloadTask.c(System.currentTimeMillis());
        localIterator1.remove();
        b(localAVPreloadTask);
      }
    }
    Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator2.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator2.next();
      localAVPreloadTask.d(false);
      localIterator2.remove();
      b(localAVPreloadTask);
    }
    localIterator2 = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator2.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator2.next();
      localAVPreloadTask.d(false);
      localIterator2.remove();
      b(localAVPreloadTask);
    }
  }
  
  public void e(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    if (paramAVPreloadTaskInterface == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_d_of_type_JavaUtilList.contains(paramAVPreloadTaskInterface)) {
        this.jdField_d_of_type_JavaUtilList.remove(paramAVPreloadTaskInterface);
      }
      if (paramAVPreloadTaskInterface.f() < 100) {
        paramAVPreloadTaskInterface.e(100);
      }
      f((AVPreloadTask)paramAVPreloadTaskInterface);
      if (this.jdField_b_of_type_JavaUtilList.size() < 1)
      {
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "add task current size=" + this.jdField_b_of_type_JavaUtilList.size() + " < max count=" + 1, new Object[0]);
        c();
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if (localAVPreloadTask.f() < paramAVPreloadTaskInterface.f())
        {
          this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.c(localAVPreloadTask);
          localIterator.remove();
          f(localAVPreloadTask);
          AVPreloadLog.a("AVPreload|AVPreloadTaskManager", "pause one low level task, add task taskId#" + paramAVPreloadTaskInterface.j() + " key id=" + paramAVPreloadTaskInterface.a(), new Object[0]);
        }
      }
      c();
      return;
    }
  }
  
  /* Error */
  public void f(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 49	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   18: aload_1
    //   19: invokeinterface 177 2 0
    //   24: ifeq +36 -> 60
    //   27: aload_0
    //   28: getfield 73	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   31: aload_1
    //   32: invokevirtual 388	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   35: aload_0
    //   36: getfield 49	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   39: aload_1
    //   40: invokeinterface 157 2 0
    //   45: pop
    //   46: aload_1
    //   47: invokeinterface 455 1 0
    //   52: aload_2
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_2
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    //   60: aload_0
    //   61: getfield 47	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   64: aload_1
    //   65: invokeinterface 177 2 0
    //   70: ifeq +31 -> 101
    //   73: aload_0
    //   74: getfield 73	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   77: aload_1
    //   78: invokevirtual 388	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   81: aload_0
    //   82: getfield 47	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   85: aload_1
    //   86: invokeinterface 157 2 0
    //   91: pop
    //   92: aload_1
    //   93: invokeinterface 455 1 0
    //   98: aload_2
    //   99: monitorexit
    //   100: return
    //   101: aload_0
    //   102: getfield 51	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   105: aload_1
    //   106: invokeinterface 177 2 0
    //   111: ifeq +31 -> 142
    //   114: aload_0
    //   115: getfield 73	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   118: aload_1
    //   119: invokevirtual 388	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   122: aload_0
    //   123: getfield 51	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   126: aload_1
    //   127: invokeinterface 157 2 0
    //   132: pop
    //   133: aload_1
    //   134: invokeinterface 455 1 0
    //   139: aload_2
    //   140: monitorexit
    //   141: return
    //   142: aload_0
    //   143: getfield 53	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   146: aload_1
    //   147: invokeinterface 177 2 0
    //   152: ifeq +46 -> 198
    //   155: aload_1
    //   156: invokeinterface 446 1 0
    //   161: sipush 200
    //   164: if_icmpne +6 -> 170
    //   167: aload_2
    //   168: monitorexit
    //   169: return
    //   170: aload_0
    //   171: getfield 73	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   174: aload_1
    //   175: invokevirtual 388	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   178: aload_0
    //   179: getfield 53	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   182: aload_1
    //   183: invokeinterface 157 2 0
    //   188: pop
    //   189: aload_1
    //   190: invokeinterface 455 1 0
    //   195: aload_2
    //   196: monitorexit
    //   197: return
    //   198: aload_2
    //   199: monitorexit
    //   200: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	AVPreloadTaskManager
    //   0	201	1	paramAVPreloadTaskInterface	AVPreloadTaskInterface
    //   4	195	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	55	finally
    //   14	54	55	finally
    //   56	58	55	finally
    //   60	100	55	finally
    //   101	141	55	finally
    //   142	169	55	finally
    //   170	197	55	finally
    //   198	200	55	finally
  }
  
  public void g(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    paramAVPreloadTaskInterface.a(System.currentTimeMillis());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)localIterator.next()).a(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager
 * JD-Core Version:    0.7.0.1
 */