package com.tencent.biz.viewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import bead;
import beae;
import beaj;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;
import zcn;

public class ViewPluginLoader$5
  implements Runnable
{
  public ViewPluginLoader$5(zcn paramzcn, JSONObject paramJSONObject, String paramString, bead parambead) {}
  
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
      localObject = new beae(str, (File)localObject);
      ((beae)localObject).b = 3;
      this.this$0.a().a((beae)localObject, this.jdField_a_of_type_Bead, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginLoader", 2, "start Download url = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */