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
  private AVPreloadStrategyManger jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger;
  private AVPreloadSwitch jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch;
  private AVPreloadTaskManager jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager;
  private AVPreloadServiceAdapter jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter;
  private AVPreloadServiceInterface.AVPreloadScenes jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
  private boolean jdField_a_of_type_Boolean = false;
  private AVPreloadServiceInterface.AVPreloadScenes jdField_b_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB;
  private boolean jdField_b_of_type_Boolean = false;
  
  private AVPreloadTask a(String paramString1, String paramString2)
  {
    AVPreloadTask localAVPreloadTask;
    do
    {
      Iterator localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a().values().iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((List)localIterator1.next()).iterator();
      }
      localAVPreloadTask = (AVPreloadTask)localIterator2.next();
    } while ((!paramString1.equalsIgnoreCase(localAVPreloadTask.c())) && (!paramString1.equalsIgnoreCase(localAVPreloadTask.b())) && (!paramString2.equalsIgnoreCase(localAVPreloadTask.a())));
    return localAVPreloadTask;
    return null;
  }
  
  private String a(String paramString1, String paramString2)
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
    } while ((!paramString1.equalsIgnoreCase(localAVPreloadTask.b())) && (!paramString2.equalsIgnoreCase(localAVPreloadTask.a())));
    if (localAVPreloadTask.a()) {
      paramString1 = localAVPreloadTask.c();
    }
    return paramString1;
    return null;
  }
  
  private AVPreloadTask b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b().iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.c())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.c())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
      }
    }
    localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.c())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
      }
    }
    return null;
  }
  
  private String b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b().iterator();
    AVPreloadTask localAVPreloadTask;
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a())))
      {
        if (localAVPreloadTask.a()) {
          paramString1 = localAVPreloadTask.c();
        }
        return paramString1;
      }
    }
    localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a())))
      {
        if (localAVPreloadTask.a()) {
          paramString1 = localAVPreloadTask.c();
        }
        return paramString1;
      }
    }
    localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c().iterator();
    while (localIterator.hasNext())
    {
      localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a())))
      {
        if (localAVPreloadTask.a()) {
          paramString1 = localAVPreloadTask.c();
        }
        return paramString1;
      }
    }
    return null;
  }
  
  private AVPreloadTask c(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.d().iterator();
    while (localIterator.hasNext())
    {
      AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.c())) || (paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a()))) {
        return localAVPreloadTask;
      }
    }
    return null;
  }
  
  private String c(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.d().iterator();
    while (localIterator.hasNext())
    {
      AVPreloadTask localAVPreloadTask = (AVPreloadTask)localIterator.next();
      if ((paramString1.equalsIgnoreCase(localAVPreloadTask.b())) || (paramString2.equalsIgnoreCase(localAVPreloadTask.a())))
      {
        if (System.currentTimeMillis() - localAVPreloadTask.k() > localAVPreloadTask.e() * 1000L) {
          return paramString1;
        }
        if (localAVPreloadTask.a()) {
          paramString1 = localAVPreloadTask.c();
        }
        return paramString1;
      }
    }
    return null;
  }
  
  public AVPreloadTask a(String paramString)
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
      localObject2 = a(paramString, (String)localObject1);
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = b(paramString, (String)localObject1);
      if (localObject2 != null) {
        return localObject2;
      }
      paramString = c(paramString, (String)localObject1);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("------exchangeLocalServerPlayUrl not support preload Scenes ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
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
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a();
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
      this.jdField_b_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = paramAVPreloadScenes;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(paramAVPreloadScenes));
    if (!this.jdField_b_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "set preload scenes switch is not ready.", new Object[0]);
      return;
    }
    paramAVPreloadScenes = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a(paramAVPreloadScenes);
    if (paramAVPreloadScenes == null)
    {
      AVPreloadLog.c("AVPreload|Core", "set preload scenes switch is null", new Object[0]);
      return;
    }
    if (paramAVPreloadScenes.a != 0) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramAVPreloadScenes.a);
    }
    if (paramAVPreloadScenes.jdField_c_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c(paramAVPreloadScenes.jdField_c_of_type_Int);
    }
    if (paramAVPreloadScenes.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(paramAVPreloadScenes.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramAVPreloadScenes.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(paramAVPreloadScenes.d);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramAVPreloadScenes.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c(paramAVPreloadScenes.e);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(paramAVPreloadScenes.jdField_c_of_type_JavaLangString);
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes, AVPreloadTask paramAVPreloadTask)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "onEliminatedTask but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("------strategy list eliminated task url = ");
    localStringBuilder.append(paramAVPreloadTask.b());
    localStringBuilder.append(" local url");
    localStringBuilder.append(paramAVPreloadTask.c());
    localStringBuilder.append(" scene = ");
    localStringBuilder.append(paramAVPreloadScenes);
    AVPreloadLog.b("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
    if (!paramAVPreloadTask.c()) {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(paramAVPreloadTask);
    }
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "remove but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramString);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.f((AVPreloadTaskInterface)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------remove task url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" scenes = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "addTask but isPreloadTaskManagerInited = false", new Object[0]);
      return false;
    }
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes)))
    {
      paramString = new StringBuilder();
      paramString.append("------addTask not support preload Scenes ");
      paramString.append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
      AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
      return false;
    }
    AVPreloadTask localAVPreloadTask = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramString);
    Object localObject = localAVPreloadTask;
    if (localAVPreloadTask == null)
    {
      localObject = new AVPreloadTask();
      ((AVPreloadTask)localObject).a(AVPreloadUtils.c(paramString));
    }
    ((AVPreloadTask)localObject).l(0L);
    ((AVPreloadTask)localObject).b(paramString);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, (AVPreloadTask)localObject);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.b(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes, (AVPreloadTask)localObject);
    if (!this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a((AVPreloadTask)localObject))
    {
      this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.e((AVPreloadTaskInterface)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("------add task url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" scenes = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
      AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------add task task is in working queue url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" scenes = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
    return false;
  }
  
  public String b(String paramString)
  {
    Object localObject2 = AVPreloadUtils.b(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a().values().iterator();
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
    } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) && (!((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))));
    paramString = new StringBuilder();
    paramString.append("------ exchangeRemoteServerPlayUrl url = ");
    paramString.append(((AVPreloadTask)localObject2).b());
    paramString.append(" local url = ");
    paramString.append(((AVPreloadTask)localObject2).c());
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    return ((AVPreloadTask)localObject2).b();
    localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (AVPreloadTask)localIterator1.next();
      if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) || (((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))))
      {
        paramString = new StringBuilder();
        paramString.append("------ exchangeRemoteServerPlayUrl url = ");
        paramString.append(((AVPreloadTask)localObject2).b());
        paramString.append(" local url = ");
        paramString.append(((AVPreloadTask)localObject2).c());
        AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
        return ((AVPreloadTask)localObject2).b();
      }
    }
    localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (AVPreloadTask)localIterator1.next();
      if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) || (((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))))
      {
        paramString = new StringBuilder();
        paramString.append("------ exchangeRemoteServerPlayUrl url = ");
        paramString.append(((AVPreloadTask)localObject2).b());
        paramString.append(" local url = ");
        paramString.append(((AVPreloadTask)localObject2).c());
        AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
        return ((AVPreloadTask)localObject2).b();
      }
    }
    localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.c().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (AVPreloadTask)localIterator1.next();
      if ((paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) || (((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))))
      {
        paramString = new StringBuilder();
        paramString.append("------ exchangeRemoteServerPlayUrl url = ");
        paramString.append(((AVPreloadTask)localObject2).b());
        paramString.append(" local url = ");
        paramString.append(((AVPreloadTask)localObject2).c());
        AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
        return ((AVPreloadTask)localObject2).b();
      }
    }
    localIterator1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.d().iterator();
    do
    {
      localObject2 = paramString;
      if (!localIterator1.hasNext()) {
        break;
      }
      localObject2 = (AVPreloadTask)localIterator1.next();
    } while ((!paramString.equalsIgnoreCase(((AVPreloadTask)localObject2).c())) && (!((String)localObject1).equalsIgnoreCase(AVPreloadUtils.b(((AVPreloadTask)localObject2).c()))));
    paramString = new StringBuilder();
    paramString.append("------ exchangeRemoteServerPlayUrl url = ");
    paramString.append(((AVPreloadTask)localObject2).b());
    paramString.append(" local url = ");
    paramString.append(((AVPreloadTask)localObject2).c());
    AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
    localObject2 = ((AVPreloadTask)localObject2).b();
    return localObject2;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "switchPreload2LiveTabPage but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (this.jdField_b_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes != AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchPreload2LiveTabPage not fit latestPreloadScenes=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
      AVPreloadLog.b("AVPreload|AVPreloadService", ((StringBuilder)localObject1).toString(), new Object[0]);
      return;
    }
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
  
  public void b(AVPreloadServiceInterface.AVPreloadResultListener paramAVPreloadResultListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b(paramAVPreloadResultListener);
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "stop but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramString);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.b((AVPreloadTask)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------stop task url = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" scenes = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = a(paramString);
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http://127.0.0.1"));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "switchPreload2FeedsPage but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
    if (this.jdField_b_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes != AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchPreload2FeedsPage not fit latestPreloadScenes=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
      AVPreloadLog.b("AVPreload|AVPreloadService", ((StringBuilder)localObject1).toString(), new Object[0]);
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes = AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("------switchPreload2FeedsPage scenes = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
    AVPreloadLog.b("AVPreload|Core", ((StringBuilder)localObject1).toString(), new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.e();
    int i = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(i);
    localObject1 = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS);
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
  
  public void c(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      AVPreloadLog.c("AVPreload|Core", "preparePlay but isPreloadTaskManagerInited = false", new Object[0]);
      return;
    }
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
      paramString = new StringBuilder();
      paramString.append("------prepare play,url = ");
      paramString.append(((AVPreloadTask)localObject).b());
      paramString.append("local url = ");
      paramString.append(((AVPreloadTask)localObject).c());
      paramString.append(" scene = ");
      paramString.append(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceInterface$AVPreloadScenes);
      AVPreloadLog.b("AVPreload|Core", paramString.toString(), new Object[0]);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("------prepare play but task is not ready, url = ");
    ((StringBuilder)localObject).append(paramString);
    AVPreloadLog.c("AVPreload|Core", ((StringBuilder)localObject).toString(), new Object[0]);
  }
  
  public void clearEventOutput() {}
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a() != null)
    {
      if (this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a().size() == 0) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void d(String paramString) {}
  
  public void onCreate(Context paramContext)
  {
    AVPreloadLog.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter.a());
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch = new AVPreloadSwitch();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a(this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager = new AVPreloadTaskManager();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a(paramContext, this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter.a(), new AVPreloadService.1(this), this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter.a());
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger = new AVPreloadStrategyManger();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a(this);
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a(this);
    a();
  }
  
  public void onDestroy()
  {
    ThreadCenter.clear(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadTaskManager.a();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger.a();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch.a(null);
    AVPreloadLog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadService
 * JD-Core Version:    0.7.0.1
 */