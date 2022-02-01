package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseFaceListAdapter<PACKAGE extends FacePackage>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected IFaceSelectedListener a;
  protected PACKAGE a;
  protected FaceListPage a;
  
  public BaseFaceListAdapter(Context paramContext, FaceListPage paramFaceListPage)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage = paramFaceListPage;
  }
  
  public void a(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener = paramIFaceSelectedListener;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage = paramPACKAGE;
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceFaceListPage.a;
  }
  
  public int getCount()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceList", 2, "facePkg is null");
      }
      return 0;
    }
    int i = ((FacePackage)localObject).b();
    int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceFacePackage.a();
    if (j >= 1)
    {
      if ((QLog.isColorLevel()) && (i == 0)) {
        QLog.d("FaceList", 2, "totalFaceCount = 0");
      }
      if (i % j == 0) {
        return i / j;
      }
      return i / j + 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("per item count < 1 :");
    ((StringBuilder)localObject).append(j);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter
 * JD-Core Version:    0.7.0.1
 */