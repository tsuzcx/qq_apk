package com.tencent.aelight.camera.aeeditor.manage;

import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.FILES;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public class AEEditorEffectConfigManager
{
  private static volatile AEEditorEffectConfigManager jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectConfigManager;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private AEEditorEffectConfigManager.IEffectGroupListBack jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectConfigManager$IEffectGroupListBack;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  private AEEditorEffectConfigManager()
  {
    AEQLog.b("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
  }
  
  public static AEEditorEffectConfigManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectConfigManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectConfigManager = new AEEditorEffectConfigManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectConfigManager;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("effect_group_list.json");
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangRunnable = new AEEditorEffectConfigManager.2(this);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(AEEditorEffectConfigManager.IEffectGroupListBack paramIEffectGroupListBack)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorManageAEEditorEffectConfigManager$IEffectGroupListBack = paramIEffectGroupListBack;
    a();
  }
  
  public void a(AEEditorEffectGroupListBean paramAEEditorEffectGroupListBean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorEffectConfigManager.1(this, paramAEEditorEffectGroupListBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager
 * JD-Core Version:    0.7.0.1
 */