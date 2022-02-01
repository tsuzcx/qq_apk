package com.tencent.mobileqq.activity.emogroupstore;

import android.os.AsyncTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class SDKEmotionSettingManager$1
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  SDKEmotionSettingManager$1(SDKEmotionSettingManager paramSDKEmotionSettingManager, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.b.a(this.a);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      int i = paramArrayList.size();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ReportController.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, localStringBuilder.toString(), "", "", "");
      SDKEmotionSettingManager.d(this.b).clear();
      SDKEmotionSettingManager.d(this.b).addAll(paramArrayList);
      this.b.a(paramArrayList);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" openSetEmotion error pathList = ");
    localStringBuilder.append(paramArrayList);
    QLog.e("SDKEmotionSettingManager", 1, localStringBuilder.toString());
    paramArrayList = this.b;
    SDKEmotionSettingManager.a(paramArrayList, SDKEmotionSettingManager.a(paramArrayList), Long.valueOf(SDKEmotionSettingManager.b(this.b)).longValue(), false, "");
    SDKEmotionSettingManager.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.1
 * JD-Core Version:    0.7.0.1
 */