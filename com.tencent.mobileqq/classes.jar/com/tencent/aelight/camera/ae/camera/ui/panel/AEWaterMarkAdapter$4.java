package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;

class AEWaterMarkAdapter$4
  implements Runnable
{
  AEWaterMarkAdapter$4(AEWaterMarkAdapter paramAEWaterMarkAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = (AEMaterialMetaData)this.this$0.a.get(this.jdField_a_of_type_Int);
    String str = AEWaterMarkAdapter.a(this.this$0).a();
    if ((!TextUtils.isEmpty(AEWaterMarkAdapter.a(this.this$0))) && (AEWaterMarkAdapter.a(this.this$0).equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (str.equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (localObject != null) && (((AEMaterialMetaData)localObject).k.equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (this.jdField_a_of_type_Boolean))
    {
      if (AEMaterialManager.jdField_a_of_type_Boolean)
      {
        AEQLog.b("AEWaterMarkAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (!AEMaterialManager.b)
      {
        AEQLog.b("AEWaterMarkAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      AEWaterMarkAdapter.a(this.this$0).b(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData, true);
      if (AEWaterMarkAdapter.a(this.this$0) != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("### [material panel] download finish, select material ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
        AEQLog.a("AEWaterMarkAdapter", ((StringBuilder)localObject).toString());
        AEWaterMarkAdapter.a(this.this$0).a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
        this.this$0.a(this.jdField_a_of_type_Int);
      }
    }
    else
    {
      this.this$0.notifyItemChanged(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkAdapter.4
 * JD-Core Version:    0.7.0.1
 */