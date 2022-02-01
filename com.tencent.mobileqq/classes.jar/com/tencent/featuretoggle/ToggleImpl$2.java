package com.tencent.featuretoggle;

import com.tencent.featuretoggle.db.DBManager;
import com.tencent.featuretoggle.models.DatasetEntity;
import com.tencent.featuretoggle.models.FeatureTriggerEvent;
import com.tencent.featuretoggle.models.FeatureTriggered;

final class ToggleImpl$2
  implements Runnable
{
  ToggleImpl$2(FeatureTriggered paramFeatureTriggered, DatasetEntity paramDatasetEntity) {}
  
  public void run()
  {
    FeatureTriggerEvent localFeatureTriggerEvent = new FeatureTriggerEvent();
    localFeatureTriggerEvent.featureVersionId = String.valueOf(this.jdField_a_of_type_ComTencentFeaturetoggleModelsFeatureTriggered.a());
    localFeatureTriggerEvent.featureName = this.jdField_a_of_type_ComTencentFeaturetoggleModelsFeatureTriggered.a();
    localFeatureTriggerEvent.featureValue = this.jdField_a_of_type_ComTencentFeaturetoggleModelsFeatureTriggered.b();
    localFeatureTriggerEvent.abTestId = this.jdField_a_of_type_ComTencentFeaturetoggleModelsFeatureTriggered.c();
    DatasetEntity localDatasetEntity = this.jdField_a_of_type_ComTencentFeaturetoggleModelsDatasetEntity;
    if (localDatasetEntity != null)
    {
      localFeatureTriggerEvent.datasetID = String.valueOf(localDatasetEntity.getDatasetId());
      localFeatureTriggerEvent.versionID = String.valueOf(this.jdField_a_of_type_ComTencentFeaturetoggleModelsDatasetEntity.getVersionId());
    }
    DBManager.a().a(localFeatureTriggerEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleImpl.2
 * JD-Core Version:    0.7.0.1
 */