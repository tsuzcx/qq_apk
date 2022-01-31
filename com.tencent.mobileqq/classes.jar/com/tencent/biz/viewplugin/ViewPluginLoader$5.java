package com.tencent.biz.viewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import batl;
import batm;
import batr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;
import xai;

public class ViewPluginLoader$5
  implements Runnable
{
  public ViewPluginLoader$5(xai paramxai, JSONObject paramJSONObject, String paramString, batl parambatl) {}
  
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
      localObject = new batm(str, (File)localObject);
      ((batm)localObject).b = 3;
      this.this$0.a().a((batm)localObject, this.jdField_a_of_type_Batl, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginLoader", 2, "start Download url = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */