package com.tencent.biz.viewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import bbwt;
import bbwu;
import bbwz;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;
import xjf;

public class ViewPluginLoader$5
  implements Runnable
{
  public ViewPluginLoader$5(xjf paramxjf, JSONObject paramJSONObject, String paramString, bbwt parambbwt) {}
  
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
      localObject = new bbwu(str, (File)localObject);
      ((bbwu)localObject).b = 3;
      this.this$0.a().a((bbwu)localObject, this.jdField_a_of_type_Bbwt, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginLoader", 2, "start Download url = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */