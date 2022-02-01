package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AEMaterialAdapter$2
  implements Runnable
{
  AEMaterialAdapter$2(AEMaterialAdapter paramAEMaterialAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = (AEMaterialMetaData)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    String str = AEMaterialAdapter.a(this.this$0).a();
    if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)) && (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (str.equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (localObject != null) && (((AEMaterialMetaData)localObject).k.equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (this.jdField_a_of_type_Boolean))
    {
      if (AEMaterialManager.jdField_a_of_type_Boolean)
      {
        AEQLog.b("AEMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (!AEMaterialManager.b)
      {
        AEQLog.b("AEMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (AEMaterialAdapter.a(this.this$0) != null)
      {
        AEMaterialAdapter.a(this.this$0).a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData, AEMaterialAdapter.a(this.this$0) ^ true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("### [material panel] download finish, select material ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
        QLog.d("AEMaterialAdapter", 4, ((StringBuilder)localObject).toString());
        AEMaterialAdapter.a(this.this$0).a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */