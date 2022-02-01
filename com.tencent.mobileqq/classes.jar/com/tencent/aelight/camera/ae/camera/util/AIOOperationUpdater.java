package com.tencent.aelight.camera.ae.camera.util;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AIOOperationUpdater
{
  private CopyOnWriteArrayList<AIOOperationUpdater.OPERATION_ENUM> a;
  private HashMap<AIOOperationUpdater.OPERATION_ENUM, AIOOperationUpdater.IOperateConfig> b = new HashMap();
  private HashMap<AIOOperationUpdater.OPERATION_ENUM, AIOOperationUpdater.OperationRecoveryInfo> c;
  private HashMap<AIOOperationUpdater.OPERATION_ENUM, AIOOperationUpdater.IRecoveryOperator> d = new HashMap();
  
  public AIOOperationUpdater()
  {
    b();
    c();
  }
  
  private void b()
  {
    this.b.put(AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION, new AIOOperationUpdater.BeautyConfig(this, AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION));
    this.b.put(AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION, new AIOOperationUpdater.BeautyConfig(this, AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION));
    this.b.put(AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION, new AIOOperationUpdater.BeautyConfig(this, AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION));
    this.b.put(AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT, new AIOOperationUpdater.BeautyConfig(this, AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT));
    this.b.put(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION, new AIOOperationUpdater.1(this));
  }
  
  private void c()
  {
    this.d.put(AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION, new AIOOperationUpdater.2(this, AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION));
    this.d.put(AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION, new AIOOperationUpdater.3(this, AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION));
    this.d.put(AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION, new AIOOperationUpdater.4(this, AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION));
    this.d.put(AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT, new AIOOperationUpdater.5(this, AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT));
    this.d.put(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION, new AIOOperationUpdater.6(this));
  }
  
  private void d()
  {
    if (this.a == null) {
      this.a = new CopyOnWriteArrayList();
    }
  }
  
  public void a(AEFilterProcessTex paramAEFilterProcessTex)
  {
    if (paramAEFilterProcessTex != null)
    {
      Object localObject1 = this.a;
      if (localObject1 != null)
      {
        if (((CopyOnWriteArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = null;
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          AIOOperationUpdater.OPERATION_ENUM localOPERATION_ENUM = (AIOOperationUpdater.OPERATION_ENUM)localIterator.next();
          if (b(localOPERATION_ENUM))
          {
            Object localObject2 = (AIOOperationUpdater.IRecoveryOperator)this.d.get(localOPERATION_ENUM);
            if ((localObject2 == null) || (!((AIOOperationUpdater.IRecoveryOperator)localObject2).a(paramAEFilterProcessTex))) {
              break;
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localOPERATION_ENUM);
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null)
        {
          paramAEFilterProcessTex = ((ArrayList)localObject1).iterator();
          while (paramAEFilterProcessTex.hasNext()) {
            c((AIOOperationUpdater.OPERATION_ENUM)paramAEFilterProcessTex.next());
          }
        }
      }
    }
  }
  
  public void a(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    d();
    if (this.a.contains(paramOPERATION_ENUM)) {
      this.a.remove(paramOPERATION_ENUM);
    }
    this.a.add(paramOPERATION_ENUM);
  }
  
  public void a(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM, AIOOperationUpdater.OperationRecoveryInfo paramOperationRecoveryInfo)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    this.c.put(paramOPERATION_ENUM, paramOperationRecoveryInfo);
  }
  
  public void a(String paramString)
  {
    d();
    a(AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT);
    a(AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT, new AIOOperationUpdater.OperationRecoveryInfo(paramString, 0, 0));
  }
  
  public boolean a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.a;
    return (localCopyOnWriteArrayList == null) || (localCopyOnWriteArrayList.size() == 0);
  }
  
  public boolean b(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.a;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localCopyOnWriteArrayList != null)
    {
      if (!localCopyOnWriteArrayList.contains(paramOPERATION_ENUM)) {
        return true;
      }
      paramOPERATION_ENUM = (AIOOperationUpdater.IOperateConfig)this.b.get(paramOPERATION_ENUM);
      bool1 = bool2;
      if (paramOPERATION_ENUM != null) {
        bool1 = paramOPERATION_ENUM.a();
      }
    }
    return bool1;
  }
  
  public void c(AIOOperationUpdater.OPERATION_ENUM paramOPERATION_ENUM)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!((CopyOnWriteArrayList)localObject).contains(paramOPERATION_ENUM)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recovered-：");
      ((StringBuilder)localObject).append(paramOPERATION_ENUM);
      AEQLog.b("AIOOperationUpdater", ((StringBuilder)localObject).toString());
      this.a.remove(paramOPERATION_ENUM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater
 * JD-Core Version:    0.7.0.1
 */