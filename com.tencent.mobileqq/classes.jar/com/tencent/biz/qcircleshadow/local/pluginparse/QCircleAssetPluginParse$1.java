package com.tencent.biz.qcircleshadow.local.pluginparse;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

class QCircleAssetPluginParse$1
  implements Comparator<String>
{
  QCircleAssetPluginParse$1(QCircleAssetPluginParse paramQCircleAssetPluginParse, String paramString) {}
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.substring(this.jdField_a_of_type_JavaLangString.length(), paramString1.indexOf(".jpg"));
      String str = paramString2.substring(this.jdField_a_of_type_JavaLangString.length(), paramString2.indexOf(".jpg"));
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {
        paramString1 = "0";
      }
      paramString2 = str;
      if (TextUtils.isEmpty(str)) {
        paramString2 = "0";
      }
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (l1 - l2 < 0L) {
        return 1;
      }
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("parseAsset#sort exception:");
      paramString2.append(paramString1.toString());
      QLog.i("QCIRCLE_PLUGIN", 1, paramString2.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleAssetPluginParse.1
 * JD-Core Version:    0.7.0.1
 */