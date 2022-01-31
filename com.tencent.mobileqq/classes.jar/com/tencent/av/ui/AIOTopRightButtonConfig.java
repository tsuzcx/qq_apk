package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.funchat.AVConfigManagerBase;
import org.json.JSONException;
import org.json.JSONObject;

public class AIOTopRightButtonConfig
  extends AVConfigManagerBase
{
  private static AIOTopRightButtonConfig jdField_a_of_type_ComTencentAvUiAIOTopRightButtonConfig;
  public static String b = "AIOTopRightButtonConfig";
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = true;
  private String c;
  
  private AIOTopRightButtonConfig()
  {
    super("aiobutton");
  }
  
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
  
  public boolean a(String paramString)
  {
    if ((this.c == null) || (!this.c.equals(paramString)))
    {
      this.c = paramString;
      b(b(paramString));
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b(String paramString)
  {
    AVLog.a(b, "updateConfig begin.");
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.a(b, "updateConfig| content isEmpty");
      this.c = null;
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("AVFromRightCornerEnable")) {
          this.jdField_a_of_type_Boolean = localJSONObject.getBoolean("AVFromRightCornerEnable");
        }
        AVLog.a(b, "updateConfig| mIsShowAIOButtonTag = " + this.jdField_a_of_type_Boolean);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          this.c = null;
          AVLog.e(b, "parseConfig|parse failed.context = " + paramString);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.AIOTopRightButtonConfig
 * JD-Core Version:    0.7.0.1
 */