package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AIOTopRightButtonConfig
{
  public static String a = "AIOTopRightButtonConfig";
  private static AIOTopRightButtonConfig c;
  private int b = -1;
  private Object d = new Object();
  
  public static AIOTopRightButtonConfig a()
  {
    try
    {
      if (c == null) {
        c = new AIOTopRightButtonConfig();
      }
      return c;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    synchronized (this.d)
    {
      this.b = 1;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONObject(paramString);
        if ((paramString.has("AVFromRightCornerEnable")) && (!paramString.getBoolean("AVFromRightCornerEnable"))) {
          this.b = 0;
        }
      }
      catch (JSONException paramString)
      {
        QLog.w(a, 1, "updateConfig, JSONException", paramString);
      }
      return;
    }
  }
  
  public boolean b(String paramString)
  {
    if (this.b == -1) {
      a(QAVConfig.b(192).b);
    }
    return this.b == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AIOTopRightButtonConfig
 * JD-Core Version:    0.7.0.1
 */