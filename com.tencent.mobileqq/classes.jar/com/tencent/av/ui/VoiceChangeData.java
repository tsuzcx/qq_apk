package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceChangeData
{
  private static VoiceChangeData jdField_a_of_type_ComTencentAvUiVoiceChangeData = null;
  public static String a;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  private VoiceChangeData.VoiceInfo[] jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static VoiceChangeData a()
  {
    if (jdField_a_of_type_ComTencentAvUiVoiceChangeData == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUiVoiceChangeData == null) {
        jdField_a_of_type_ComTencentAvUiVoiceChangeData = new VoiceChangeData();
      }
      return jdField_a_of_type_ComTencentAvUiVoiceChangeData;
    }
    finally {}
  }
  
  protected void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = new VoiceChangeData.VoiceInfo[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            VoiceChangeData.VoiceInfo localVoiceInfo = new VoiceChangeData.VoiceInfo();
            localVoiceInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localVoiceInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localVoiceInfo.c = localJSONObject.getString("icon2");
            localVoiceInfo.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localVoiceInfo.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo[i] = localVoiceInfo;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = null;
        return;
      }
    }
  }
  
  public VoiceChangeData.VoiceInfo[] a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) {
      a(QAVConfig.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo == null) && (!this.jdField_a_of_type_Boolean))
    {
      VoiceChangeDataReport.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeData
 * JD-Core Version:    0.7.0.1
 */