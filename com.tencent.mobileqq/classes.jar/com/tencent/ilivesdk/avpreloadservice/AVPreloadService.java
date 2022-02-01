package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceAdapter;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadResultListener;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadScenes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AVPreloadService
  implements ThreadCenter.HandlerKeyable, AVPreloadStrategyManger.AVPreloadStrategyChangeListener, AVPreloadServiceInterface
{
  private AVPreloadStrategyManger jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger;
  private AVPreloadTaskManager jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager;
  private AVPreloadServiceAdapter jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter;
  private AVPreloadServiceInterface.AVPreloadScenes jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
  private AVPreloadServiceInterface.AVPreloadScenes b = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
  
  public AVPreloadTask a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    String str = AVPreloadUtils.c(paramString);
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Iterator localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a().values().iterator();
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
        localObject = localAVPreloadTask;
        if (paramString.equalsIgnoreCase(localAVPreloadTask.c())) {
          break;
        }
        localObject = localAVPreloadTask;
        if (paramString.equalsIgnoreCase(localAVPreloadTask.b())) {
          break;
        }
      } while (!str.equalsIgnoreCase(localAVPreloadTask.a()));
      return localAVPreloadTask;
      localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b().iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localAVPreloadTask = (AVPreloadTask)localIterator1.next();
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.c())) {
            break;
          }
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.b())) {
            break;
          }
          if (str.equalsIgnoreCase(localAVPreloadTask.a())) {
            return localAVPreloadTask;
          }
        }
      }
      localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a().iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localAVPreloadTask = (AVPreloadTask)localIterator1.next();
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.c())) {
            break;
          }
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.b())) {
            break;
          }
          if (str.equalsIgnoreCase(localAVPreloadTask.a())) {
            return localAVPreloadTask;
          }
        }
      }
      localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c().iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localAVPreloadTask = (AVPreloadTask)localIterator1.next();
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.c())) {
            break;
          }
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.b())) {
            break;
          }
          if (str.equalsIgnoreCase(localAVPreloadTask.a())) {
            return localAVPreloadTask;
          }
        }
      }
      localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.d().iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localAVPreloadTask = (AVPreloadTask)localIterator1.next();
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.c())) {
            break;
          }
          localObject = localAVPreloadTask;
          if (paramString.equalsIgnoreCase(localAVPreloadTask.b())) {
            break;
          }
          if (str.equalsIgnoreCase(localAVPreloadTask.a())) {
            return localAVPreloadTask;
          }
        }
      }
      return null;
    }
  }
  
  public String a(String paramString)
  {
    String str = AVPreloadUtils.c(paramString);
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a().values().iterator();
      Object localObject3;
      Object localObject2;
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((List)((Iterator)localObject1).next()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject2 = (AVPreloadTask)((Iterator)localObject3).next();
            if ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).b())) && (!str.equalsIgnoreCase(((AVPreloadTask)localObject2).a()))) {
              break;
            }
            localObject1 = paramString;
            if (((AVPreloadTask)localObject2).a()) {
              localObject1 = ((AVPreloadTask)localObject2).c();
            }
          }
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject1;
                localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b().iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
                } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).b())) && (!str.equalsIgnoreCase(((AVPreloadTask)localObject2).a())));
                localObject1 = paramString;
              } while (!((AVPreloadTask)localObject2).a());
              return ((AVPreloadTask)localObject2).c();
              localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a().iterator();
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
              } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).b())) && (!str.equalsIgnoreCase(((AVPreloadTask)localObject2).a())));
              localObject1 = paramString;
            } while (!((AVPreloadTask)localObject2).a());
            return ((AVPreloadTask)localObject2).c();
            localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c().iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
            } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).b())) && (!str.equalsIgnoreCase(((AVPreloadTask)localObject2).a())));
            localObject1 = paramString;
          } while (!((AVPreloadTask)localObject2).a());
          return ((AVPreloadTask)localObject2).c();
          localObject2 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.d().iterator();
          do
          {
            localObject1 = paramString;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (AVPreloadTask)((Iterator)localObject2).next();
          } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject3).b())) && (!str.equalsIgnoreCase(((AVPreloadTask)localObject3).a())));
          localObject1 = paramString;
        } while (System.currentTimeMillis() - ((AVPreloadTask)localObject3).k() > ((AVPreloadTask)localObject3).e() * 1000L);
        localObject1 = paramString;
      } while (!((AVPreloadTask)localObject3).a());
      return ((AVPreloadTask)localObject3).c();
    }
  }
  
  public void a()
  {
    if (this.b != AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB) {
      AVPreloadLog.b("AVPreload|AVPreloadService", "switchPreload2LiveTabPage not fit latestPreloadScenes=" + this.b, new Object[0]);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.e();
      int i = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB);
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(i);
      Object localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB);
      Object localObject2 = new ArrayList((Collection)localObject1);
      ((List)localObject1).clear();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
        ((AVPreloadTask)localObject2).d(false);
        a(((AVPreloadTask)localObject2).b());
      }
    }
  }
  
  public void a(AVPreloadServiceAdapter paramAVPreloadServiceAdapter)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter = paramAVPreloadServiceAdapter;
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramAVPreloadResultListener);
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = paramAVPreloadScenes;
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes != AVPreloadServiceInterface.AVPreloadScenes.SWITCH_ROOM) {
      this.b = paramAVPreloadScenes;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(paramAVPreloadScenes));
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes, AVPreloadTask paramAVPreloadTask)
  {
    AVPreloadLog.b("AVPreload|Core", "------strategy list eliminated task url = " + paramAVPreloadTask.b() + " local url" + paramAVPreloadTask.c() + " scene = " + paramAVPreloadScenes, new Object[0]);
    if (!paramAVPreloadTask.c()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(paramAVPreloadTask);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AVPreloadTask localAVPreloadTask;
    do
    {
      return;
      localAVPreloadTask = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramString);
    } while (localAVPreloadTask == null);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.f(localAVPreloadTask);
    AVPreloadLog.b("AVPreload|Core", "------remove task url = " + paramString + " scenes = " + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, new Object[0]);
  }
  
  public boolean a(String paramString)
  {
    AVPreloadTask localAVPreloadTask2 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramString);
    AVPreloadTask localAVPreloadTask1 = localAVPreloadTask2;
    if (localAVPreloadTask2 == null)
    {
      localAVPreloadTask1 = new AVPreloadTask();
      localAVPreloadTask1.a(AVPreloadUtils.c(paramString));
    }
    localAVPreloadTask1.b(paramString);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, localAVPreloadTask1);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.b(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, localAVPreloadTask1);
    if (!this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(localAVPreloadTask1))
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.e(localAVPreloadTask1);
      AVPreloadLog.b("AVPreload|Core", "------add task url = " + paramString + " scenes = " + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, new Object[0]);
      return false;
    }
    AVPreloadLog.b("AVPreload|Core", "------add task task is in working queue url = " + paramString + " scenes = " + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, new Object[0]);
    return false;
  }
  
  public String b(String paramString)
  {
    String str = AVPreloadUtils.b(paramString);
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a().values().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((List)((Iterator)localObject1).next()).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            AVPreloadTask localAVPreloadTask = (AVPreloadTask)((Iterator)localObject2).next();
            if ((!paramString.equalsIgnoreCase(localAVPreloadTask.c())) && (!str.equalsIgnoreCase(AVPreloadUtils.b(localAVPreloadTask.c())))) {
              break;
            }
            AVPreloadLog.b("AVPreload|Core", "------ exchangeRemoteServerPlayUrl url = " + localAVPreloadTask.b() + " local url = " + localAVPreloadTask.c(), new Object[0]);
            localObject1 = localAVPreloadTask.b();
            return localObject1;
          }
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
        if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) || (str.equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))))
        {
          AVPreloadLog.b("AVPreload|Core", "------ exchangeRemoteServerPlayUrl url = " + ((AVPreloadTask)localObject2).b() + " local url = " + ((AVPreloadTask)localObject2).c(), new Object[0]);
          return ((AVPreloadTask)localObject2).b();
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
        if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) || (str.equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))))
        {
          AVPreloadLog.b("AVPreload|Core", "------ exchangeRemoteServerPlayUrl url = " + ((AVPreloadTask)localObject2).b() + " local url = " + ((AVPreloadTask)localObject2).c(), new Object[0]);
          return ((AVPreloadTask)localObject2).b();
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
        if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) || (str.equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))))
        {
          AVPreloadLog.b("AVPreload|Core", "------ exchangeRemoteServerPlayUrl url = " + ((AVPreloadTask)localObject2).b() + " local url = " + ((AVPreloadTask)localObject2).c(), new Object[0]);
          return ((AVPreloadTask)localObject2).b();
        }
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.d().iterator();
      do
      {
        localObject1 = paramString;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (AVPreloadTask)((Iterator)localObject2).next();
      } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject1).c())) && (!str.equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject1).c()))));
      AVPreloadLog.b("AVPreload|Core", "------ exchangeRemoteServerPlayUrl url = " + ((AVPreloadTask)localObject1).b() + " local url = " + ((AVPreloadTask)localObject1).c(), new Object[0]);
      return ((AVPreloadTask)localObject1).b();
    }
  }
  
  public void b()
  {
    if (this.b != AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS) {
      AVPreloadLog.b("AVPreload|AVPreloadService", "switchPreload2FeedsPage not fit latestPreloadScenes=" + this.b, new Object[0]);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS;
      AVPreloadLog.b("AVPreload|Core", "------switchPreload2FeedsPage scenes = " + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.e();
      int i = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS);
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(i);
      Object localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS);
      Object localObject2 = new ArrayList((Collection)localObject1);
      ((List)localObject1).clear();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVPreloadTask)((Iterator)localObject1).next();
        ((AVPreloadTask)localObject2).d(false);
        a(((AVPreloadTask)localObject2).b());
      }
    }
  }
  
  public void b(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(paramAVPreloadResultListener);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AVPreloadTask localAVPreloadTask;
    do
    {
      return;
      localAVPreloadTask = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramString);
    } while (localAVPreloadTask == null);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(localAVPreloadTask);
    AVPreloadLog.b("AVPreload|Core", "------stop task url = " + paramString + " scenes = " + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, new Object[0]);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = a(paramString);
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://127.0.0.1")));
    return true;
  }
  
  public void c(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a().values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((List)((Iterator)localObject).next()).iterator();
      while (localIterator.hasNext()) {
        ((AVPreloadTask)localIterator.next()).d(false);
      }
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.d();
    localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramString);
    if (localObject != null)
    {
      ((AVPreloadTask)localObject).d(true);
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a((AVPreloadTask)localObject);
      AVPreloadLog.b("AVPreload|Core", "------prepare play,url = " + ((AVPreloadTask)localObject).b() + "local url = " + ((AVPreloadTask)localObject).c() + " scene = " + this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, new Object[0]);
      return;
    }
    AVPreloadLog.c("AVPreload|Core", "------prepare play but task is not ready, url = " + paramString, new Object[0]);
  }
  
  public void clearEventOutput() {}
  
  public void d(String paramString) {}
  
  public void onCreate(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter != null) {
      AVPreloadLog.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter.a());
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager = new AVPreloadTaskManager(paramContext, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter.a());
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger = new AVPreloadStrategyManger();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(this);
  }
  
  public void onDestroy()
  {
    ThreadCenter.clear(this);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a();
    AVPreloadLog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadService
 * JD-Core Version:    0.7.0.1
 */