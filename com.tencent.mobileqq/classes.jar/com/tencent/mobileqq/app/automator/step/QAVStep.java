package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.AVPathUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QAVStep
  extends AsyncStep
{
  protected int doStep()
  {
    Object localObject1 = AVPathUtil.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("config.xml");
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("qav_config_flag", 0);
    int i = ((SharedPreferences)localObject2).getInt("flag_delete", 0);
    if (i != 0)
    {
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QAVStep, flag_delete[");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("]");
        QLog.w("QQInitHandler", 1, ((StringBuilder)localObject1).toString());
      }
      return 7;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(106);
    FileUtils.deleteDirectory(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(132);
    localStringBuilder.append((String)localObject3);
    FileUtils.deleteFile(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(176);
    localStringBuilder.append((String)localObject3);
    FileUtils.deleteFile(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(216);
    localStringBuilder.append((String)localObject3);
    FileUtils.deleteFile(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(263);
    FileUtils.deleteDirectory(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(270);
    FileUtils.deleteDirectory(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(370);
    localStringBuilder.append((String)localObject3);
    FileUtils.deleteFile(localStringBuilder.toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("beauty");
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("beauty_config.json");
    FileUtils.deleteFile(((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append("signal_strength");
    FileUtils.deleteDirectory(((StringBuilder)localObject3).toString());
    i = ApkUtils.a(BaseApplicationImpl.getContext());
    ((SharedPreferences)localObject2).edit().putInt("flag_delete", i).commit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QAVStep
 * JD-Core Version:    0.7.0.1
 */