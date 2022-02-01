package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lbe;

public class QAVStep
  extends AsyncStep
{
  public int a()
  {
    String str1 = lbe.a();
    String str2 = File.separator + "config.xml";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qav_config_flag", 0);
    int i = localSharedPreferences.getInt("flag_delete", 0);
    if (i != 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QQInitHandler", 1, "QAVStep, flag_delete[" + i + "]");
      }
      return 7;
    }
    FileUtils.deleteDirectory(str1 + 106);
    FileUtils.deleteFile(str1 + 132 + str2);
    FileUtils.deleteFile(str1 + 176 + str2);
    FileUtils.deleteFile(str1 + 216 + str2);
    FileUtils.deleteDirectory(str1 + 263);
    FileUtils.deleteDirectory(str1 + 270);
    FileUtils.deleteFile(str1 + 370 + str2);
    FileUtils.deleteFile(str1 + "beauty" + File.separator + "beauty_config.json");
    FileUtils.deleteDirectory(str1 + "signal_strength");
    i = aqmy.a(BaseApplicationImpl.getContext());
    localSharedPreferences.edit().putInt("flag_delete", i).commit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QAVStep
 * JD-Core Version:    0.7.0.1
 */