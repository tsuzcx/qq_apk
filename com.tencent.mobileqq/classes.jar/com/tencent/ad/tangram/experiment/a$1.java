package com.tencent.ad.tangram.experiment;

import com.tencent.ad.tangram.analysis.AdUin;
import com.tencent.ad.tangram.settings.AdSettingsManager;
import com.tencent.ad.tangram.settings.AdSettingsManager.Listener;

final class a$1
  implements AdSettingsManager.Listener
{
  public void onUpdated()
  {
    AdExperimentManager.INSTANCE.updateCache(AdUin.INSTANCE.getUIN(), AdSettingsManager.INSTANCE.getCache());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.experiment.a.1
 * JD-Core Version:    0.7.0.1
 */