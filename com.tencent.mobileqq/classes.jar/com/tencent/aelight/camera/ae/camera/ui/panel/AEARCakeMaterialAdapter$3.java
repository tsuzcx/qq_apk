package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;

class AEARCakeMaterialAdapter$3
  implements Runnable
{
  AEARCakeMaterialAdapter$3(AEARCakeMaterialAdapter paramAEARCakeMaterialAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = ((AEGiftMaterial)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a();
    Object localObject2 = AEARCakeMaterialAdapter.a(this.this$0).a();
    if (localObject2 == null) {
      return;
    }
    localObject2 = ((AEGiftMaterial)localObject2).a();
    this.this$0.notifyItemChanged(this.jdField_a_of_type_Int);
    localObject2 = ((AEARCakeMaterial)localObject2).k;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (localObject1 != null) && (((AEMaterialMetaData)localObject1).k.equals(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)) && (this.jdField_a_of_type_Boolean))
    {
      if (AEMaterialManager.jdField_a_of_type_Boolean)
      {
        AEQLog.b("AEARCakeMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (!AEMaterialManager.b)
      {
        AEQLog.b("AEARCakeMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
      if (this.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("### [material panel] download finish, select material ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k);
        AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject1).toString());
        this.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter.3
 * JD-Core Version:    0.7.0.1
 */