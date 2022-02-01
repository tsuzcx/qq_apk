package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apuc;
import com.tencent.common.app.BaseApplicationImpl;

public class DynamicAvatarDownloadManager$2
  implements Runnable
{
  public DynamicAvatarDownloadManager$2(apuc paramapuc, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a).append("#").append(0);
    BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_avatar", 4).edit().putString("dynamic_load_count_one_day", localStringBuilder.toString()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */