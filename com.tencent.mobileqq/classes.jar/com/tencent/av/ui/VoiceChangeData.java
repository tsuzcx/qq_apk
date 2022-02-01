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
  private static VoiceChangeData jdField_a_of_type_ComTencentAvUiVoiceChangeData;
  public static String a = "VoiceChangeData";
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  private VoiceChangeData.VoiceInfo[] jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = null;
  
  public static VoiceChangeData a()
  {
    if (jdField_a_of_type_ComTencentAvUiVoiceChangeData == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvUiVoiceChangeData == null) {
          jdField_a_of_type_ComTencentAvUiVoiceChangeData = new VoiceChangeData();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvUiVoiceChangeData;
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
        Object localObject3;
        Object localObject4;
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          localObject3 = jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("parseConfig|voices size= ");
          ((StringBuilder)localObject4).append(((JSONArray)localObject2).length());
          AVLog.printAllUserLog((String)localObject3, ((StringBuilder)localObject4).toString());
          this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = new VoiceChangeData.VoiceInfo[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localObject4 = new VoiceChangeData.VoiceInfo();
            ((VoiceChangeData.VoiceInfo)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).getString("name");
            ((VoiceChangeData.VoiceInfo)localObject4).jdField_b_of_type_JavaLangString = ((JSONObject)localObject3).getString("icon1");
            ((VoiceChangeData.VoiceInfo)localObject4).c = ((JSONObject)localObject3).getString("icon2");
            ((VoiceChangeData.VoiceInfo)localObject4).jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject3).getString("type"));
            ((VoiceChangeData.VoiceInfo)localObject4).jdField_b_of_type_Int = Integer.parseInt(((JSONObject)localObject3).getString("vip_level"));
            this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo[i] = localObject4;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        localObject3 = jdField_a_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("parseConfig, JSONException, \ncontent[");
        ((StringBuilder)localObject4).append(paramString);
        ((StringBuilder)localObject4).append("]");
        QLog.w((String)localObject3, 1, ((StringBuilder)localObject4).toString(), localJSONException);
        this.jdField_a_of_type_ArrayOfComTencentAvUiVoiceChangeData$VoiceInfo = null;
        return;
      }
    }
    for (;;)
    {
      throw paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeData
 * JD-Core Version:    0.7.0.1
 */