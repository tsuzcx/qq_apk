package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoodleLayoutConnector
{
  private static DoodleLayoutConnector jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilDoodleLayoutConnector;
  private WeakReference<DoodleLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<DoodleLayout> b;
  
  public static DoodleLayoutConnector a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilDoodleLayoutConnector == null) {
      jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilDoodleLayoutConnector = new DoodleLayoutConnector();
    }
    return jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureUtilDoodleLayoutConnector;
  }
  
  public DoodleLayout a(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (DoodleLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        break label66;
      }
    }
    else
    {
      localObject = this.b;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (DoodleLayout)this.b.get();
        break label66;
      }
    }
    Object localObject = null;
    label66:
    if ((localObject == null) && (QLog.isColorLevel())) {
      QLog.e("DoodleLayoutConnector", 2, "getDoodleLayout null, not init yet");
    }
    return localObject;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unbind ");
      localStringBuilder.append(paramInt);
      QLog.d("DoodleLayoutConnector", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.b = null;
  }
  
  public void a(int paramInt, DoodleLayout paramDoodleLayout)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bind ");
      localStringBuilder.append(paramInt);
      QLog.d("DoodleLayoutConnector", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleLayout);
      return;
    }
    this.b = new WeakReference(paramDoodleLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.DoodleLayoutConnector
 * JD-Core Version:    0.7.0.1
 */