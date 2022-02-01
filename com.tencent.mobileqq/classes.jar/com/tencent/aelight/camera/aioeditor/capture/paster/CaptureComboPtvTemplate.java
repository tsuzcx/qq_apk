package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.common.app.AppInterface;

public class CaptureComboPtvTemplate
  extends CaptureComboBase
{
  private float jdField_a_of_type_Float = 0.0F;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new CaptureComboPtvTemplate.1(this);
  private QIMPtvTemplateManager jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
  private PtvTemplateInfo jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.a(paramString);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = QIMManager.a();
  private int c;
  
  public CaptureComboPtvTemplate(String paramString)
  {
    super(null);
    this.jdField_c_of_type_Int = 2;
    paramString = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    if ((paramString != null) && (paramString.b))
    {
      this.jdField_c_of_type_Int = 3;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo == null) {
      this.jdField_c_of_type_Int = 3;
    }
  }
  
  public float a()
  {
    try
    {
      float f = this.jdField_a_of_type_Float;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo;
    if ((paramActivity != null) && (paramActivity.b))
    {
      paramActivity = new StringBuilder();
      paramActivity.append(QIMPtvTemplateManager.a);
      paramActivity.append(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.e);
      paramActivity = paramActivity.toString();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo, 111);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.a, this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.jdField_c_of_type_Int, paramActivity);
      return 0;
    }
    return -1;
  }
  
  public void a(Activity paramActivity, int paramInt) {}
  
  public int b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo == null)
      {
        this.jdField_c_of_type_Int = 3;
        i = this.jdField_c_of_type_Int;
        return i;
      }
      if (!this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.b)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoPtvTemplateManager$IPtvTemplateDownloadListener);
        a();
        this.jdField_c_of_type_Int = 1;
      }
      else if (this.jdField_a_of_type_ComTencentAelightCameraStructEditorPtvTemplateInfo.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Int = 1;
      }
      else
      {
        this.jdField_a_of_type_Float = 1.0F;
        this.jdField_c_of_type_Int = 3;
        b();
      }
      int i = this.jdField_c_of_type_Int;
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboPtvTemplate
 * JD-Core Version:    0.7.0.1
 */