package com.tencent.mobileqq.ar.arengine;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ARResourceManagerTools$2
  implements AsyncBack
{
  ARResourceManagerTools$2(ARResourceManagerTools paramARResourceManagerTools, ARResourceManagerTools.ARResourceCallback paramARResourceCallback, ArrayList paramArrayList, ARResourceDownload.DownloadInfo paramDownloadInfo) {}
  
  public void loaded(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Load offline package finish, code = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("param1");
    localStringBuilder.append(paramString);
    QLog.d("AREngine_ARResourceManagerTools", 2, localStringBuilder.toString());
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(true);
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(4, true);
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
          }
        }
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("data"))
        {
          paramString = paramString.getJSONArray("data");
          if (paramString.length() != 0) {
            paramString.getJSONObject(0).has("bid");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback == null) {
            return;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(true);
          this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(4, true);
          this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
          return;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
        if (paramString == null) {
          return;
        }
      }
      paramString.a(false);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(4, false);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
    }
    else
    {
      if (paramInt == 7)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload$DownloadInfo);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(true);
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(4, true);
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
          }
        }
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
      if (paramString != null)
      {
        paramString.a(false);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(4, false);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
      }
    }
  }
  
  public void progress(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Load offline progress  = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AREngine_ARResourceManagerTools", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
    if (localObject != null) {
      ((ARResourceManagerTools.ARResourceCallback)localObject).a(ARResourceManagerTools.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools, 0L, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceManagerTools.2
 * JD-Core Version:    0.7.0.1
 */