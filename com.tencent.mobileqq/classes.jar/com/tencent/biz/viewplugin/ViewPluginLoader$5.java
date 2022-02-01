package com.tencent.biz.viewplugin;

import aapg;
import android.os.Bundle;
import android.text.TextUtils;
import bhyn;
import bhyo;
import bhyt;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ViewPluginLoader$5
  implements Runnable
{
  public ViewPluginLoader$5(aapg paramaapg, JSONObject paramJSONObject, String paramString, bhyn parambhyn) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      QLog.e("ViewPluginLoader", 1, "fTargetFile = " + this.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      Bundle localBundle = new Bundle();
      localObject = new bhyo(str, (File)localObject);
      ((bhyo)localObject).b = 3;
      this.this$0.a().a((bhyo)localObject, this.jdField_a_of_type_Bhyn, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginLoader", 2, "start Download url = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */