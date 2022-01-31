package com.idlefish.flutterboost;

import android.content.Context;
import android.text.TextUtils;
import com.idlefish.flutterboost.interfaces.IContainerManager;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import com.idlefish.flutterboost.interfaces.IOperateSyncer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class FlutterViewContainerManager
  implements IContainerManager
{
  private final Map<String, FlutterViewContainerManager.OnResult> mOnResults = new HashMap();
  private final Map<IFlutterViewContainer, IContainerRecord> mRecordMap = new LinkedHashMap();
  private final Stack<IContainerRecord> mRecordStack = new Stack();
  private final Set<FlutterViewContainerManager.ContainerRef> mRefs = new HashSet();
  
  IContainerRecord closeContainer(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Object localObject1 = this.mRecordMap.entrySet().iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
    } while (!TextUtils.equals(paramString, ((IContainerRecord)((Map.Entry)localObject2).getValue()).uniqueId()));
    for (localObject1 = (IContainerRecord)((Map.Entry)localObject2).getValue();; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("closeContainer can not find uniqueId:");
        ((StringBuilder)localObject2).append(paramString);
        Debuger.exception(((StringBuilder)localObject2).toString());
      }
      FlutterBoost.instance().platform().closeContainer((IContainerRecord)localObject1, paramMap1, paramMap2);
      return localObject1;
    }
  }
  
  public IFlutterViewContainer findContainerById(String paramString)
  {
    Object localObject1 = this.mRecordMap.entrySet().iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
    } while (!TextUtils.equals(paramString, ((IContainerRecord)((Map.Entry)localObject2).getValue()).uniqueId()));
    for (localObject1 = (IFlutterViewContainer)((Map.Entry)localObject2).getKey(); localObject1 == null; localObject1 = null)
    {
      localObject2 = this.mRefs.iterator();
      FlutterViewContainerManager.ContainerRef localContainerRef;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localContainerRef = (FlutterViewContainerManager.ContainerRef)((Iterator)localObject2).next();
      } while (!TextUtils.equals(paramString, localContainerRef.uniqueId));
      return (IFlutterViewContainer)localContainerRef.container.get();
    }
    return localObject1;
  }
  
  public IOperateSyncer generateSyncer(IFlutterViewContainer paramIFlutterViewContainer)
  {
    Utils.assertCallOnMainThread();
    ContainerRecord localContainerRecord = new ContainerRecord(this, paramIFlutterViewContainer);
    if (this.mRecordMap.put(paramIFlutterViewContainer, localContainerRecord) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("container:");
      localStringBuilder.append(paramIFlutterViewContainer.getContainerUrl());
      localStringBuilder.append(" already exists!");
      Debuger.exception(localStringBuilder.toString());
    }
    this.mRefs.add(new FlutterViewContainerManager.ContainerRef(localContainerRecord.uniqueId(), paramIFlutterViewContainer));
    return localContainerRecord;
  }
  
  public IContainerRecord getCurrentTopRecord()
  {
    if (this.mRecordStack.isEmpty()) {
      return null;
    }
    return (IContainerRecord)this.mRecordStack.peek();
  }
  
  public IContainerRecord getLastGenerateRecord()
  {
    Object localObject = this.mRecordMap.values();
    if (!((Collection)localObject).isEmpty())
    {
      localObject = new ArrayList((Collection)localObject);
      return (IContainerRecord)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return null;
  }
  
  public boolean hasContainerAppear()
  {
    Iterator localIterator = this.mRecordMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((IContainerRecord)((Map.Entry)localIterator.next()).getValue()).getState() == 2) {
        return true;
      }
    }
    return false;
  }
  
  void onShownContainerChanged(String paramString1, String paramString2)
  {
    Utils.assertCallOnMainThread();
    Iterator localIterator = this.mRecordMap.entrySet().iterator();
    IFlutterViewContainer localIFlutterViewContainer1 = null;
    IFlutterViewContainer localIFlutterViewContainer2 = null;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (TextUtils.equals(paramString1, ((IContainerRecord)localEntry.getValue()).uniqueId())) {
        localIFlutterViewContainer2 = (IFlutterViewContainer)localEntry.getKey();
      }
      if (TextUtils.equals(paramString2, ((IContainerRecord)localEntry.getValue()).uniqueId()))
      {
        localIFlutterViewContainer1 = (IFlutterViewContainer)localEntry.getKey();
        label113:
        if ((localIFlutterViewContainer2 == null) || (localIFlutterViewContainer1 == null)) {}
      }
    }
    for (;;)
    {
      if (localIFlutterViewContainer1 != null) {
        localIFlutterViewContainer1.onContainerShown();
      }
      if (localIFlutterViewContainer2 != null) {
        localIFlutterViewContainer2.onContainerHidden();
      }
      return;
      break;
      break label113;
    }
  }
  
  void openContainer(String paramString, Map<String, Object> paramMap1, Map<String, Object> paramMap2, FlutterViewContainerManager.OnResult paramOnResult)
  {
    Object localObject2 = FlutterBoost.instance().currentActivity();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = FlutterBoost.instance().platform().getApplication();
    }
    if (paramMap1 == null) {
      paramMap1 = new HashMap();
    }
    for (;;)
    {
      localObject2 = paramMap1.remove("requestCode");
      if (localObject2 != null) {}
      for (int i = Integer.valueOf(String.valueOf(localObject2)).intValue();; i = 0)
      {
        paramMap1.put("__container_uniqueId_key__", ContainerRecord.genUniqueId(paramString));
        localObject2 = getCurrentTopRecord();
        if (paramOnResult != null) {
          this.mOnResults.put(((IContainerRecord)localObject2).uniqueId(), paramOnResult);
        }
        FlutterBoost.instance().platform().openContainer((Context)localObject1, paramString, paramMap1, i, paramMap2);
        return;
      }
    }
  }
  
  void popRecord(IContainerRecord paramIContainerRecord)
  {
    if (this.mRecordStack.peek() == paramIContainerRecord) {
      this.mRecordStack.pop();
    }
  }
  
  void pushRecord(IContainerRecord paramIContainerRecord)
  {
    if (!this.mRecordMap.containsValue(paramIContainerRecord)) {
      Debuger.exception("invalid record!");
    }
    this.mRecordStack.push(paramIContainerRecord);
  }
  
  public IContainerRecord recordOf(IFlutterViewContainer paramIFlutterViewContainer)
  {
    return (IContainerRecord)this.mRecordMap.get(paramIFlutterViewContainer);
  }
  
  void removeRecord(IContainerRecord paramIContainerRecord)
  {
    this.mRecordStack.remove(paramIContainerRecord);
    this.mRecordMap.remove(paramIContainerRecord.getContainer());
  }
  
  void setContainerResult(IContainerRecord paramIContainerRecord, int paramInt1, int paramInt2, Map<String, Object> paramMap)
  {
    if (findContainerById(paramIContainerRecord.uniqueId()) == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setContainerResult error, url=");
      ((StringBuilder)localObject).append(paramIContainerRecord.getContainer().getContainerUrl());
      Debuger.exception(((StringBuilder)localObject).toString());
    }
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("_requestCode__", Integer.valueOf(paramInt1));
    ((Map)localObject).put("_resultCode__", Integer.valueOf(paramInt2));
    paramIContainerRecord = (FlutterViewContainerManager.OnResult)this.mOnResults.remove(paramIContainerRecord.uniqueId());
    if (paramIContainerRecord != null) {
      paramIContainerRecord.onResult((Map)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterViewContainerManager
 * JD-Core Version:    0.7.0.1
 */