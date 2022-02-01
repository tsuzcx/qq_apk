package com.tencent.av.gameplay;

import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QAVGamePlaySoConfigInfo
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  private QAVGamePlaySoConfigInfo()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static QAVGamePlaySoConfigInfo a()
  {
    Object localObject = QAVConfig.b(298).jdField_a_of_type_JavaLangString;
    QAVGamePlaySoConfigInfo localQAVGamePlaySoConfigInfo = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localQAVGamePlaySoConfigInfo = a((String)localObject);
    }
    localObject = localQAVGamePlaySoConfigInfo;
    if (localQAVGamePlaySoConfigInfo == null) {
      localObject = new QAVGamePlaySoConfigInfo();
    }
    return localObject;
  }
  
  static QAVGamePlaySoConfigInfo a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      QAVGamePlaySoConfigInfo localQAVGamePlaySoConfigInfo = new QAVGamePlaySoConfigInfo();
      localQAVGamePlaySoConfigInfo.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      localQAVGamePlaySoConfigInfo.jdField_a_of_type_Int = paramString.getInt("task_id");
      localQAVGamePlaySoConfigInfo.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      localQAVGamePlaySoConfigInfo.b = paramString.getString("MD5_zip_so");
      localQAVGamePlaySoConfigInfo.c = paramString.getString("MD5_so");
      localQAVGamePlaySoConfigInfo.d = paramString.getString("so_name");
      return localQAVGamePlaySoConfigInfo;
    }
    catch (Exception paramString)
    {
      QLog.d("QavGPDownloadManager", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
    return null;
  }
  
  public String toString()
  {
    return String.format("task_id[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], MD5_so[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaLangString, this.b, this.c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gameplay.QAVGamePlaySoConfigInfo
 * JD-Core Version:    0.7.0.1
 */