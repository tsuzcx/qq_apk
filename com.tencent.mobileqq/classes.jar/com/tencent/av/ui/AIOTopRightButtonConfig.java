package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AIOTopRightButtonConfig
{
  private static AIOTopRightButtonConfig jdField_a_of_type_ComTencentAvUiAIOTopRightButtonConfig;
  public static String a = "AIOTopRightButtonConfig";
  private int jdField_a_of_type_Int = -1;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static AIOTopRightButtonConfig a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAvUiAIOTopRightButtonConfig == null) {
        jdField_a_of_type_ComTencentAvUiAIOTopRightButtonConfig = new AIOTopRightButtonConfig();
      }
      return jdField_a_of_type_ComTencentAvUiAIOTopRightButtonConfig;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Int = 1;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        if ((paramString.has("AVFromRightCornerEnable")) && (!paramString.getBoolean("AVFromRightCornerEnable"))) {
          this.jdField_a_of_type_Int = 0;
        }
      }
      catch (JSONException paramString)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "updateConfig, JSONException", paramString);
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(QAVConfig.b(192).jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AIOTopRightButtonConfig
 * JD-Core Version:    0.7.0.1
 */