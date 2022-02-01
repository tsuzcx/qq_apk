package com.tencent.ilivesdk.avpreloadservice;

import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadScenes;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AVPreloadStrategyManger
{
  private AVPreloadStrategyManger.AVPreloadStrategyChangeListener jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger$AVPreloadStrategyChangeListener;
  private Map<AVPreloadServiceInterface.AVPreloadScenes, List<AVPreloadTask>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<AVPreloadServiceInterface.AVPreloadScenes, Integer> b = new HashMap();
  
  public AVPreloadStrategyManger()
  {
    Map localMap = this.b;
    AVPreloadServiceInterface.AVPreloadScenes localAVPreloadScenes = AVPreloadServiceInterface.AVPreloadScenes.SWITCH_ROOM;
    Integer localInteger = Integer.valueOf(3);
    localMap.put(localAVPreloadScenes, localInteger);
    this.b.put(AVPreloadServiceInterface.AVPreloadScenes.CLICKED_FEEDS, Integer.valueOf(6));
    this.b.put(AVPreloadServiceInterface.AVPreloadScenes.LIVE_TAB, localInteger);
    this.b.put(AVPreloadServiceInterface.AVPreloadScenes.NO_UPDATE_FEEDS, Integer.valueOf(5));
  }
  
  public int a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    return ((Integer)this.b.get(paramAVPreloadScenes)).intValue();
  }
  
  public List<AVPreloadTask> a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramAVPreloadScenes)) {
      return (List)this.jdField_a_of_type_JavaUtilMap.get(paramAVPreloadScenes);
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilMap.put(paramAVPreloadScenes, localCopyOnWriteArrayList);
    Collections.sort(localCopyOnWriteArrayList, new AVPreloadStrategyManger.1(this));
    return localCopyOnWriteArrayList;
  }
  
  public Map<AVPreloadServiceInterface.AVPreloadScenes, List<AVPreloadTask>> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      if (localList != null) {
        localList.clear();
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger$AVPreloadStrategyChangeListener = null;
  }
  
  public void a(AVPreloadStrategyManger.AVPreloadStrategyChangeListener paramAVPreloadStrategyChangeListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger$AVPreloadStrategyChangeListener = paramAVPreloadStrategyChangeListener;
  }
  
  public void a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes, AVPreloadTask paramAVPreloadTask)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramAVPreloadScenes);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new CopyOnWriteArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(paramAVPreloadScenes, localObject);
    }
    if (((List)localObject).contains(paramAVPreloadTask)) {
      ((List)localObject).remove(paramAVPreloadTask);
    }
    ((List)localObject).add(paramAVPreloadTask);
    int i = a(paramAVPreloadScenes);
    if (i == 0)
    {
      ((List)localObject).clear();
      paramAVPreloadTask = new StringBuilder();
      paramAVPreloadTask.append("add task max size == 0, scene ");
      paramAVPreloadTask.append(paramAVPreloadScenes);
      AVPreloadLog.c("AVPreload|AVPreloadStrategyManger", paramAVPreloadTask.toString(), new Object[0]);
      return;
    }
    while (((List)localObject).size() > i)
    {
      paramAVPreloadTask = this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadStrategyManger$AVPreloadStrategyChangeListener;
      if (paramAVPreloadTask != null) {
        paramAVPreloadTask.a(paramAVPreloadScenes, (AVPreloadTask)((List)localObject).get(0));
      }
      ((List)localObject).remove(0);
    }
  }
  
  public void b(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes, AVPreloadTask paramAVPreloadTask)
  {
    if (paramAVPreloadScenes == AVPreloadServiceInterface.AVPreloadScenes.NO_UPDATE_FEEDS)
    {
      paramAVPreloadTask.d(0);
      return;
    }
    paramAVPreloadTask.d(60);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadStrategyManger
 * JD-Core Version:    0.7.0.1
 */