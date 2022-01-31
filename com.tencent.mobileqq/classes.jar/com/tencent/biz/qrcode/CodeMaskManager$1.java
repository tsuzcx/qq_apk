package com.tencent.biz.qrcode;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import naj;
import org.json.JSONArray;
import org.json.JSONObject;

class CodeMaskManager$1
  extends Thread
{
  CodeMaskManager$1(CodeMaskManager paramCodeMaskManager, String paramString, SharedPreferences paramSharedPreferences, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString);
  }
  
  public void run()
  {
    localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("updateTemplate2", System.currentTimeMillis());
    Object localObject = "http://qm.qq.com/cgi-bin/tpl?v=1&os=a&resx=" + this.jdField_a_of_type_Int + "&resy=" + this.b + "&t=" + this.c + "&" + "mType" + "=" + "qb_qrcode";
    try
    {
      String str = naj.a(this.this$0.jdField_a_of_type_AndroidAppActivity, (String)localObject, "GET", null, null);
      if (QLog.isColorLevel()) {
        QLog.d("QRHttpUtil", 2, "open :" + (String)localObject + ", result: " + str);
      }
      localObject = new JSONObject(str);
      if (((JSONObject)localObject).getInt("r") == 0)
      {
        localObject = ((JSONObject)localObject).getJSONArray("tpls");
        if (((JSONArray)localObject).length() > 0)
        {
          this.this$0.jdField_a_of_type_AndroidOsHandler.post(new CodeMaskManager.1.1(this, (JSONArray)localObject));
          localEditor.putString("tpl_json", str);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QRHttpUtil", 2, localException.getMessage());
        }
        localEditor.putLong("updateTemplate2", 0L);
      }
    }
    localEditor.commit();
    this.this$0.jdField_a_of_type_JavaLangThread = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.1
 * JD-Core Version:    0.7.0.1
 */