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
  @SuppressLint({"UseSparseArrays"})
  private final HashMap<Integer, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final IQIMManager[] jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager = new IQIMManager[15];
  
  public static IQIMManager a(int paramInt)
  {
    return QIMManager.InstanceHolder.a().c(paramInt);
  }
  
  public static QIMManager a()
  {
    return QIMManager.InstanceHolder.a();
  }
  
  public static AppInterface a()
  {
    return (AppInterface)a();
  }
  
  private static AppRuntime a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return localAppRuntime;
    }
    return BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  private boolean a()
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
  
  public static IQIMManager b(int paramInt)
  {
    return QIMManager.InstanceHolder.a().jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    for (;;)
    {
      Object localObject3 = this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager;
      if (i < localObject3.length) {
        try
        {
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new Object());
          }
          Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
          try
          {
            localObject3 = this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager[i];
            if (localObject3 != null)
            {
              SLog.b("QIMManager", "destroy manager : %s", localObject3);
              ((IQIMManager)localObject3).b();
            }
            this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager[i] = null;
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
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager[paramInt] != null;
  }
  
  public IQIMManager c(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager;
    Object localObject3 = localObject1[paramInt];
    if (localObject3 == null) {}
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new Object());
        }
        localObject3 = this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        try
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager[paramInt];
          if (localObject1 != null) {
            return localObject1;
          }
          if (a()) {}
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
            this.jdField_a_of_type_ArrayOfComTencentAelightCameraAioeditorCaptureIQIMManager[paramInt] = localObject1;
            if (localObject1 != null)
            {
              ((IQIMManager)localObject1).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.QIMManager
 * JD-Core Version:    0.7.0.1
 */