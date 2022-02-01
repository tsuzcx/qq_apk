package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import arum;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetEmoticonWhenNoFile
  extends AsyncStep
{
  public int a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_free_emosm_update_time", 0L);
    if (System.currentTimeMillis() - l > 43200000L)
    {
      new arum(this.a.app).a("https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json", "3").a();
      localSharedPreferences.edit().putLong("last_pull_free_emosm_update_time", System.currentTimeMillis()).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile
 * JD-Core Version:    0.7.0.1
 */