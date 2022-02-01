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
    localFeatureTriggerEvent.featureVersionId = String.valueOf(this.a.a());
    localFeatureTriggerEvent.featureName = this.a.b();
    localFeatureTriggerEvent.featureValue = this.a.c();
    localFeatureTriggerEvent.abTestId = this.a.e();
    DatasetEntity localDatasetEntity = this.b;
    if (localDatasetEntity != null)
    {
      localFeatureTriggerEvent.datasetID = String.valueOf(localDatasetEntity.getDatasetId());
      localFeatureTriggerEvent.versionID = String.valueOf(this.b.getVersionId());
    }
    DBManager.a().a(localFeatureTriggerEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.ToggleImpl.2
 * JD-Core Version:    0.7.0.1
 */