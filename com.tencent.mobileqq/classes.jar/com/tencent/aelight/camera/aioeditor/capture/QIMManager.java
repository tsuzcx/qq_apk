package com.tencent.aelight.camera.aioeditor.capture;

import android.annotation.SuppressLint;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMPasterConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class QIMManager
{
  private final IQIMManager[] a = new IQIMManager[15];
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Object> b = new HashMap();
  
  public static IQIMManager a(int paramInt)
  {
    return QIMManager.InstanceHolder.a().d(paramInt);
  }
  
  public static QIMManager a()
  {
    return QIMManager.InstanceHolder.a();
  }
  
  public static IQIMManager b(int paramInt)
  {
    return QIMManager.InstanceHolder.a().a[paramInt];
  }
  
  public static AppInterface c()
  {
    return (AppInterface)e();
  }
  
  private boolean d()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check process: ");
      localStringBuilder.append(localAppRuntime);
      QLog.d("QIMManager", 2, localStringBuilder.toString());
    }
    return ((localAppRuntime instanceof QQAppInterface)) || ((localAppRuntime instanceof ToolRuntimePeak));
  }
  
  private static AppRuntime e()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return localAppRuntime;
    }
    return BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
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
              SLog.b("QIMManager", "destroy manager : %s", localObject3);
              ((IQIMManager)localObject3).d();
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
  
  public boolean c(int paramInt)
  {
    return this.a[paramInt] != null;
  }
  
  public IQIMManager d(int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject3 = localObject1[paramInt];
    if (localObject3 == null) {}
    for (;;)
    {
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
          if (d()) {}
          switch (paramInt)
          {
          case 14: 
            localObject1 = new DoodleEmojiManager();
            break;
          case 13: 
            localObject1 = new QIMCaptureVarManager();
            break;
          case 12: 
            localObject1 = new QIMInformationPasterManager();
            break;
          case 8: 
            localObject1 = new QimMusicPlayer();
            break;
          case 7: 
            localObject1 = new DynamicTextConfigManager();
            break;
          case 5: 
            localObject1 = new CaptureComboManager();
            break;
          case 4: 
            localObject1 = new PasterDataManager();
            break;
          case 3: 
            localObject1 = new QIMPtvTemplateManager();
            break;
          case 2: 
            localObject1 = new QIMMusicConfigManager();
            break;
          case 1: 
            localObject1 = new QIMPasterConfigManager();
            this.a[paramInt] = localObject1;
            if (localObject1 != null)
            {
              ((IQIMManager)localObject1).c();
              SLog.b("QIMManager", "onInit manager : %s", localObject1);
            }
            return localObject1;
            throw new RuntimeException("invalid process");
          }
        }
        finally {}
        return localIQIMManager;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.QIMManager
 * JD-Core Version:    0.7.0.1
 */