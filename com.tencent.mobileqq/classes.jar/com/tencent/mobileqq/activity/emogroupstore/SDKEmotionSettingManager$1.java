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
    return this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager, SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager), Long.valueOf(SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager)).longValue(), false, "");
      SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager);
      return;
    }
    int i = paramArrayList.size();
    ReportController.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).clear();
    SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager).addAll(paramArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.1
 * JD-Core Version:    0.7.0.1
 */