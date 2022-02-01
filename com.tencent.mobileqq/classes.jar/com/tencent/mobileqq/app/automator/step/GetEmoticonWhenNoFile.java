package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emoticon.IEPRecommendTask;
import com.tencent.mobileqq.emoticon.api.IEPRecommendTaskService;
import com.tencent.mobileqq.qroute.QRoute;

public class GetEmoticonWhenNoFile
  extends AsyncStep
{
  protected int doStep()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_free_emosm_update_time", 0L);
    if (System.currentTimeMillis() - l > 43200000L)
    {
      ((IEPRecommendTaskService)QRoute.api(IEPRecommendTaskService.class)).createEPRecommendTask(this.mAutomator.k).setParam("https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json", "3").runTask();
      localSharedPreferences.edit().putLong("last_pull_free_emosm_update_time", System.currentTimeMillis()).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile
 * JD-Core Version:    0.7.0.1
 */