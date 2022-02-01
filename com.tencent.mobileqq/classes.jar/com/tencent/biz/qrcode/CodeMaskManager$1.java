package com.tencent.biz.qrcode;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.qphone.base.util.QLog;
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
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("updateTemplate2", System.currentTimeMillis());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://qm.qq.com/cgi-bin/tpl?v=1&os=a&resx=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append("&resy=");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append("&t=");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append("mType");
    ((StringBuilder)localObject1).append("=");
    ((StringBuilder)localObject1).append("qb_qrcode");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    try
    {
      localObject1 = HttpUtil.openUrl(this.this$0.jdField_a_of_type_AndroidAppActivity, (String)localObject2, "GET", null, null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("open :");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(", result: ");
        localStringBuilder.append((String)localObject1);
        QLog.d("QRHttpUtil", 2, localStringBuilder.toString());
      }
      localObject2 = new JSONObject((String)localObject1);
      if (((JSONObject)localObject2).getInt("r") == 0)
      {
        localObject2 = ((JSONObject)localObject2).getJSONArray("tpls");
        if (((JSONArray)localObject2).length() > 0)
        {
          this.this$0.jdField_a_of_type_AndroidOsHandler.post(new CodeMaskManager.1.1(this, (JSONArray)localObject2));
          localEditor.putString("tpl_json", (String)localObject1);
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QRHttpUtil", 2, localException.getMessage());
      }
      localEditor.putLong("updateTemplate2", 0L);
    }
    localEditor.commit();
    this.this$0.jdField_a_of_type_JavaLangThread = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.1
 * JD-Core Version:    0.7.0.1
 */