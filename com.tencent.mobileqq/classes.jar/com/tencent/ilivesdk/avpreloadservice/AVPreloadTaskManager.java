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
  private int jdField_a_of_type_Int = 60;
  private Context jdField_a_of_type_AndroidContentContext;
  private AVPreloadEngine jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVPreloadTaskManager.2(this);
  private String jdField_a_of_type_JavaLangString = "";
  private List<AVPreloadTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<AVPreloadServiceInterface.AVPreloadResultListener> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int = 6;
  private List<AVPreloadTask> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int = 2;
  private List<AVPreloadTask> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int jdField_d_of_type_Int = 6;
  private List<AVPreloadTask> jdField_d_of_type_JavaUtilList = new ArrayList();
  private int e = 5;
  
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
      Object localObject2;
      if (paramAVPreloadTask.e() <= 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task refresh cycle is ");
        ((StringBuilder)localObject2).append(paramAVPreloadTask.e());
        ((StringBuilder)localObject2).append(" not to update!");
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
        return false;
      }
      long l = paramAVPreloadTask.l() + 1L;
      paramAVPreloadTask.l(l);
      if (l > this.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("refresh time out max time = ");
        ((StringBuilder)localObject2).append(this.e);
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
        paramAVPreloadTask.l(0L);
        b(paramAVPreloadTask);
        return false;
      }
      while (this.jdField_c_of_type_JavaUtilList.size() > this.jdField_b_of_type_Int)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("update queue size:");
        ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaUtilList.size());
        ((StringBuilder)localObject2).append("  > max size:");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
        localObject2 = (AVPreloadTask)this.jdField_c_of_type_JavaUtilList.get(0);
        this.jdField_c_of_type_JavaUtilList.remove(localObject2);
        b((AVPreloadTask)localObject2);
      }
      paramAVPreloadTask.k(System.currentTimeMillis());
      this.jdField_c_of_type_JavaUtilList.add(paramAVPreloadTask);
      return true;
    }
    for (;;)
    {
      throw paramAVPreloadTask;
    }
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preload queue is contain task  url= ");
        localStringBuilder.append(paramAVPreloadTask.b());
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", localStringBuilder.toString(), new Object[0]);
        return false;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() >= this.jdField_c_of_type_Int)
      {
        paramAVPreloadTask = new StringBuilder();
        paramAVPreloadTask.append("preload queue is full, max count = ");
        paramAVPreloadTask.append(this.jdField_c_of_type_Int);
        AVPreloadLog.c("AVPreload|AVPreloadTaskManager", paramAVPreloadTask.toString(), new Object[0]);
        return false;
      }
      this.jdField_b_of_type_JavaUtilList.add(paramAVPreloadTask);
      return true;
    }
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
      Object localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AVPreloadTask localAVPreloadTask = (AVPreloadTask)((Iterator)localObject2).next();
        if ((localAVPreloadTask.b().equalsIgnoreCase(paramAVPreloadTask.b())) || (localAVPreloadTask.a().equalsIgnoreCase(paramAVPreloadTask.a())))
        {
          ((Iterator)localObject2).remove();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("remove task taskId=#");
          ((StringBuilder)localObject2).append(paramAVPreloadTask.j());
          ((StringBuilder)localObject2).append(" key id=");
          ((StringBuilder)localObject2).append(paramAVPreloadTask.a());
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
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      Object localObject3;
      while (localIterator.hasNext())
      {
        localObject3 = (AVPreloadTask)localIterator.next();
        long l = System.currentTimeMillis() - ((AVPreloadTask)localObject3).a();
        if (l >= 10000L)
        {
          localCopyOnWriteArrayList.add(localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("preload time out, preload time = ");
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append(" > max time = ");
          ((StringBuilder)localObject3).append(10000);
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject3).toString(), new Object[0]);
        }
      }
      localIterator = localCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (AVPreloadTask)localIterator.next();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.c((AVPreloadTaskInterface)localObject3);
        this.jdField_b_of_type_JavaUtilList.remove(localObject3);
        ((AVPreloadTask)localObject3).e(50);
        f((AVPreloadTask)localObject3);
      }
      localCopyOnWriteArrayList.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("------enter waiting queue, but task is playing, taskId=#");
      ((StringBuilder)???).append(paramAVPreloadTask.j());
      ((StringBuilder)???).append("url = ");
      ((StringBuilder)???).append(paramAVPreloadTask.b());
      AVPreloadLog.c("AVPreload|Core", ((StringBuilder)???).toString(), new Object[0]);
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if (TextUtils.isEmpty(localAVPreloadTask.b()))
        {
          AVPreloadLog.c("AVPreload|AVPreloadTaskManager", "item url is empty", new Object[0]);
        }
        else if (TextUtils.isEmpty(localAVPreloadTask.a()))
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
      paramAVPreloadTask = new StringBuilder();
      paramAVPreloadTask.append("-----waiting queue max size:");
      paramAVPreloadTask.append(this.jdField_b_of_type_Int);
      paramAVPreloadTask.append(" waiting queue current size:");
      paramAVPreloadTask.append(this.jdField_a_of_type_JavaUtilList.size());
      AVPreloadLog.b("AVPreload|Core", paramAVPreloadTask.toString(), new Object[0]);
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
    for (;;)
    {
      throw paramAVPreloadTask;
    }
  }
  
  private void g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      AVPreloadTask localAVPreloadTask;
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        if (System.currentTimeMillis() - localAVPreloadTask.k() >= localAVPreloadTask.e() * 1000L) {
          localCopyOnWriteArrayList.add(localAVPreloadTask);
        }
      }
      localIterator = localCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        this.jdField_c_of_type_JavaUtilList.remove(localAVPreloadTask);
        if (localAVPreloadTask.f() < 200) {
          localAVPreloadTask.e(50);
        }
        f(localAVPreloadTask);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("update time out url =");
        localStringBuilder.append(localAVPreloadTask.b());
        localStringBuilder.append("update queue task size=");
        localStringBuilder.append(this.jdField_c_of_type_JavaUtilList.size());
        AVPreloadLog.a("AVPreload|AVPreloadTaskManager", localStringBuilder.toString(), new Object[0]);
      }
      c();
      localCopyOnWriteArrayList.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
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
    if (TextUtils.isEmpty(paramString))
    {
      AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "url2Task url is null.", new Object[0]);
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if (localAVPreloadTask.b().equalsIgnoreCase(paramString)) {
        return localAVPreloadTask;
      }
      if ((localAVPreloadTask.a().equalsIgnoreCase(AVPreloadUtils.c(paramString))) && (!TextUtils.isEmpty(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
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
  
  public void a(Context paramContext, AppGeneralInfoService paramAppGeneralInfoService, AVPreloadTaskManager.DLProxyInitCompletedListener paramDLProxyInitCompletedListener, HttpInterface paramHttpInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine = new AVPreloadEngine(paramContext, paramHttpInterface);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a(this);
    ThreadCenter.postLogicTask(new AVPreloadTaskManager.1(this, paramContext, paramAppGeneralInfoService, paramDLProxyInitCompletedListener), "init_dlproxy_thread");
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
      if (this.jdField_c_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        b(paramAVPreloadTask);
        return;
      }
      return;
    }
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramAVPreloadResultListener);
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task preload failed taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.j());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.b());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).b(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
    e((AVPreloadTask)paramAVPreloadTaskInterface);
    c();
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, Bitmap paramBitmap, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------ task first frame come taskId=#");
    localStringBuilder.append(paramAVPreloadTaskInterface.j());
    localStringBuilder.append(" url = ");
    localStringBuilder.append(paramAVPreloadTaskInterface.b());
    AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
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
    paramString = new StringBuilder();
    paramString.append("------ task gap time come  taskId=#");
    paramString.append(paramAVPreloadTaskInterface.j());
    paramString.append(" url = ");
    paramString.append(paramAVPreloadTaskInterface.b());
    paramString.append(" gap time = ");
    paramString.append(paramLong);
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    paramString = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (paramString.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramString.next()).a(paramAVPreloadTaskInterface.b(), paramLong, paramAVPreloadTaskInterface);
    }
  }
  
  public void a(AVPreloadTaskInterface paramAVPreloadTaskInterface, String paramString, AVPreloadTaskInterface.TaskReportInfo paramTaskReportInfo)
  {
    paramString = new StringBuilder();
    paramString.append("------ task preload finish taskId=#");
    paramString.append(paramAVPreloadTaskInterface.j());
    paramString.append(" url = ");
    paramString.append(paramAVPreloadTaskInterface.b());
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    paramAVPreloadTaskInterface.b(System.currentTimeMillis());
    paramString = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (paramString.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)paramString.next()).a(paramAVPreloadTaskInterface.b(), paramTaskReportInfo, paramAVPreloadTaskInterface);
    }
    paramAVPreloadTaskInterface = (AVPreloadTask)paramAVPreloadTaskInterface;
    e(paramAVPreloadTaskInterface);
    c(paramAVPreloadTaskInterface);
    c();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a(paramString);
  }
  
  public void a(List<Long> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("------task cache check, not find task id =#");
            localStringBuilder.append(l);
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
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a(paramBoolean);
  }
  
  public boolean a(AVPreloadTask paramAVPreloadTask)
  {
    if (this.jdField_b_of_type_JavaUtilList.contains(paramAVPreloadTask)) {
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramAVPreloadTask)) {
      return true;
    }
    return this.jdField_c_of_type_JavaUtilList.contains(paramAVPreloadTask);
  }
  
  public List<AVPreloadTask> b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
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
      if (this.jdField_c_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        this.jdField_c_of_type_JavaUtilList.remove(paramAVPreloadTask);
        b(paramAVPreloadTask);
        return;
      }
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(paramAVPreloadTask);
      return;
    }
  }
  
  public void b(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramAVPreloadResultListener);
  }
  
  public void b(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task preload complete taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.j());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.b());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).c(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
    e((AVPreloadTask)paramAVPreloadTaskInterface);
    c();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(paramBoolean);
  }
  
  public boolean b(AVPreloadTask paramAVPreloadTask)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      while (this.jdField_d_of_type_JavaUtilList.contains(paramAVPreloadTask))
      {
        this.jdField_d_of_type_JavaUtilList.remove(paramAVPreloadTask);
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", "enEliminatedQueue eliminated queue contain the task, remove the task", new Object[0]);
      }
      if ((paramAVPreloadTask.f() == 200) && (this.jdField_d_of_type_JavaUtilList.size() != 0) && (this.jdField_d_of_type_JavaUtilList.get(0) != null) && (((AVPreloadTask)this.jdField_d_of_type_JavaUtilList.get(0)).f() == 200))
      {
        localObject2 = (AVPreloadTask)this.jdField_d_of_type_JavaUtilList.get(0);
        if (!((AVPreloadTask)localObject2).c()) {
          ((AVPreloadTask)localObject2).e(100);
        }
        this.jdField_d_of_type_JavaUtilList.remove(localObject2);
        this.jdField_d_of_type_JavaUtilList.add(0, paramAVPreloadTask);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("TASK_PRIORITY_URGENT change to TASK_PRIORITY_NORMAL url = ");
        localStringBuilder.append(((AVPreloadTask)localObject2).b());
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", localStringBuilder.toString(), new Object[0]);
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("------enter eliminated queue url = ");
      ((StringBuilder)localObject2).append(paramAVPreloadTask.b());
      ((StringBuilder)localObject2).append(" priority is ");
      ((StringBuilder)localObject2).append(paramAVPreloadTask.f());
      AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject2).toString(), new Object[0]);
      this.jdField_d_of_type_JavaUtilList.add(0, paramAVPreloadTask);
      Collections.sort(this.jdField_d_of_type_JavaUtilList, new AVPreloadTaskManager.3(this));
      while (this.jdField_d_of_type_JavaUtilList.size() > this.jdField_d_of_type_Int)
      {
        localObject2 = (AVPreloadTask)this.jdField_d_of_type_JavaUtilList.get(this.jdField_d_of_type_JavaUtilList.size() - 1);
        if (localObject2 != null)
        {
          this.jdField_d_of_type_JavaUtilList.remove(this.jdField_d_of_type_JavaUtilList.size() - 1);
          if (((AVPreloadTask)localObject2).c())
          {
            this.jdField_d_of_type_JavaUtilList.add(0, localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("------playing task can not eliminated queue url = ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.b());
            ((StringBuilder)localObject2).append(" priority is ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.f());
            AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject2).toString(), new Object[0]);
          }
          else
          {
            this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b((AVPreloadTaskInterface)localObject2);
            ((AVPreloadTask)localObject2).a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("------remove from eliminated queue url = ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.b());
            ((StringBuilder)localObject2).append(" priority is ");
            ((StringBuilder)localObject2).append(paramAVPreloadTask.f());
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
  
  public List<AVPreloadTask> c()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() >= 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preload size=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilList.size());
      ((StringBuilder)localObject).append(">= max count");
      ((StringBuilder)localObject).append(2);
      AVPreloadLog.c("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject).toString(), new Object[0]);
      return;
    }
    Object localObject = a();
    if (!((AVPreloadTask)localObject).c())
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b((AVPreloadTaskInterface)localObject);
      if (d((AVPreloadTask)localObject))
      {
        ((AVPreloadTask)localObject).a(System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.a((AVPreloadTaskInterface)localObject);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("------start preload task taskId =#");
        localStringBuilder.append(((AVPreloadTask)localObject).j());
        localStringBuilder.append(" url = ");
        localStringBuilder.append(((AVPreloadTask)localObject).b());
        AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
        g((AVPreloadTaskInterface)localObject);
        return;
      }
      AVPreloadLog.c("AVPreload|Core", "------start preload task failed, enter preload queue failed.", new Object[0]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------start preload but task is playing taskId =#");
    localStringBuilder.append(((AVPreloadTask)localObject).j());
    localStringBuilder.append(" url = ");
    localStringBuilder.append(((AVPreloadTask)localObject).b());
    AVPreloadLog.c("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void c(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task preload stop taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.j());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.b());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).d(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.c(paramBoolean);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------ task can play  taskId=#");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.j());
    ((StringBuilder)localObject).append(" url = ");
    ((StringBuilder)localObject).append(paramAVPreloadTaskInterface.b());
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)((Iterator)localObject).next()).f(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      AVPreloadTask localAVPreloadTask;
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.b(localAVPreloadTask);
        if (localAVPreloadTask.f() < 200) {
          localAVPreloadTask.e(70);
        }
        localAVPreloadTask.d(false);
        localAVPreloadTask.c(System.currentTimeMillis());
        localIterator.remove();
        b(localAVPreloadTask);
      }
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localAVPreloadTask.d(false);
        localIterator.remove();
        b(localAVPreloadTask);
      }
      localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localAVPreloadTask = (AVPreloadTask)localIterator.next();
        localAVPreloadTask.d(false);
        localIterator.remove();
        b(localAVPreloadTask);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
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
      if (this.jdField_b_of_type_JavaUtilList.size() < 2)
      {
        paramAVPreloadTaskInterface = new StringBuilder();
        paramAVPreloadTaskInterface.append("add task current size=");
        paramAVPreloadTaskInterface.append(this.jdField_b_of_type_JavaUtilList.size());
        paramAVPreloadTaskInterface.append(" < max count=");
        paramAVPreloadTaskInterface.append(2);
        AVPreloadLog.b("AVPreload|AVPreloadTaskManager", paramAVPreloadTaskInterface.toString(), new Object[0]);
        c();
        return;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject2 = this.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          AVPreloadTask localAVPreloadTask = (AVPreloadTask)((Iterator)localObject2).next();
          if (localAVPreloadTask.f() < paramAVPreloadTaskInterface.f())
          {
            this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine.c(localAVPreloadTask);
            ((Iterator)localObject2).remove();
            f(localAVPreloadTask);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("pause one low level task, add task taskId#");
            ((StringBuilder)localObject2).append(paramAVPreloadTaskInterface.j());
            ((StringBuilder)localObject2).append(" key id=");
            ((StringBuilder)localObject2).append(paramAVPreloadTaskInterface.a());
            AVPreloadLog.a("AVPreload|AVPreloadTaskManager", ((StringBuilder)localObject2).toString(), new Object[0]);
          }
        }
        c();
        return;
      }
    }
    for (;;)
    {
      throw paramAVPreloadTaskInterface;
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
    //   15: getfield 51	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   18: aload_1
    //   19: invokeinterface 157 2 0
    //   24: ifeq +31 -> 55
    //   27: aload_0
    //   28: getfield 70	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   31: aload_1
    //   32: invokevirtual 399	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   35: aload_0
    //   36: getfield 51	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   39: aload_1
    //   40: invokeinterface 141 2 0
    //   45: pop
    //   46: aload_1
    //   47: invokeinterface 471 1 0
    //   52: aload_2
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 49	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   59: aload_1
    //   60: invokeinterface 157 2 0
    //   65: ifeq +31 -> 96
    //   68: aload_0
    //   69: getfield 70	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   72: aload_1
    //   73: invokevirtual 399	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   76: aload_0
    //   77: getfield 49	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   80: aload_1
    //   81: invokeinterface 141 2 0
    //   86: pop
    //   87: aload_1
    //   88: invokeinterface 471 1 0
    //   93: aload_2
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 53	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   100: aload_1
    //   101: invokeinterface 157 2 0
    //   106: ifeq +31 -> 137
    //   109: aload_0
    //   110: getfield 70	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   113: aload_1
    //   114: invokevirtual 399	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   117: aload_0
    //   118: getfield 53	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   121: aload_1
    //   122: invokeinterface 141 2 0
    //   127: pop
    //   128: aload_1
    //   129: invokeinterface 471 1 0
    //   134: aload_2
    //   135: monitorexit
    //   136: return
    //   137: aload_0
    //   138: getfield 55	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   141: aload_1
    //   142: invokeinterface 157 2 0
    //   147: ifeq +46 -> 193
    //   150: aload_1
    //   151: invokeinterface 462 1 0
    //   156: sipush 200
    //   159: if_icmpne +6 -> 165
    //   162: aload_2
    //   163: monitorexit
    //   164: return
    //   165: aload_0
    //   166: getfield 70	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadEngine	Lcom/tencent/ilivesdk/avpreloadservice/AVPreloadEngine;
    //   169: aload_1
    //   170: invokevirtual 399	com/tencent/ilivesdk/avpreloadservice/AVPreloadEngine:b	(Lcom/tencent/ilivesdk/avpreloadservice_interface/AVPreloadTaskInterface;)V
    //   173: aload_0
    //   174: getfield 55	com/tencent/ilivesdk/avpreloadservice/AVPreloadTaskManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   177: aload_1
    //   178: invokeinterface 141 2 0
    //   183: pop
    //   184: aload_1
    //   185: invokeinterface 471 1 0
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
  
  public void g(AVPreloadTaskInterface paramAVPreloadTaskInterface)
  {
    paramAVPreloadTaskInterface.a(System.currentTimeMillis());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((AVPreloadServiceInterface.AVPreloadResultListener)localIterator.next()).a(paramAVPreloadTaskInterface.b(), paramAVPreloadTaskInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager
 * JD-Core Version:    0.7.0.1
 */