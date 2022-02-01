package com.tencent.aelight.camera.ae.control;

import android.annotation.SuppressLint;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterDataManager;
import com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.play.AEPlayShowMaterialManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class AEQIMManager
{
  private final IAEQIMManager[] a = new IAEQIMManager[5];
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Object> b = new HashMap();
  
  public static AEQIMManager a()
  {
    return AEQIMManager.InstanceHolder.a();
  }
  
  public static IAEQIMManager a(int paramInt)
  {
    return AEQIMManager.InstanceHolder.a().b(paramInt);
  }
  
  private boolean c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check process: ");
      localStringBuilder.append(localAppRuntime);
      QLog.d("AEQIMManager", 2, localStringBuilder.toString());
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  public IAEQIMManager b(int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject3 = localObject1[paramInt];
    if (localObject3 == null) {
      try
      {
        if (!this.b.containsKey(Integer.valueOf(paramInt))) {
          this.b.put(Integer.valueOf(paramInt), new Object());
        }
        localObject3 = this.b.get(Integer.valueOf(paramInt));
        try
        {
          localObject1 = this.a[paramInt];
          if (localObject1 != null) {
            return localObject1;
          }
          if (c())
          {
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt != 3)
                {
                  if (paramInt == 4) {
                    localObject1 = new AEFlashShowFilterDataManager();
                  }
                }
                else {
                  localObject1 = new AEFlashShowMaterialManager();
                }
              }
              else {
                localObject1 = new AEPlayShowMaterialManager();
              }
            }
            else {
              localObject1 = new AEMaterialManager();
            }
            this.a[paramInt] = localObject1;
            if (localObject1 != null)
            {
              ((IAEQIMManager)localObject1).onInit();
              SLog.b("AEQIMManager", "onInit manager : %s", localObject1);
            }
            return localObject1;
          }
          throw new RuntimeException("invalid process");
        }
        finally {}
        return localIAEQIMManager;
      }
      finally {}
    }
  }
  
  public void b()
  {
    int i = 0;
    for (;;)
    {
      Object localObject3 = this.a;
      if (i < localObject3.length) {
        try
        {
          if (!this.b.containsKey(Integer.valueOf(i))) {
            this.b.put(Integer.valueOf(i), new Object());
          }
          Object localObject1 = this.b.get(Integer.valueOf(i));
          try
          {
            localObject3 = this.a[i];
            if (localObject3 != null)
            {
              SLog.b("AEQIMManager", "destroy manager : %s", localObject3);
              ((IAEQIMManager)localObject3).onDestroy();
            }
            this.a[i] = null;
            i += 1;
            continue;
          }
          finally {}
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.control.AEQIMManager
 * JD-Core Version:    0.7.0.1
 */