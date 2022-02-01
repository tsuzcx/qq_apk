package com.tencent.biz.qcircleshadow.local;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class QCircleSampleInfo
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public QCircleSampleInfo a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public QCircleSampleInfo a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QCircleSampleInfo b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    SharedPreferences localSharedPreferences = MobileQQ.context.getSharedPreferences("QCircle_crash_share", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircle_crash_count_");
    localStringBuilder.append(paramInt);
    this.jdField_b_of_type_Int = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    return this;
  }
  
  public QCircleSampleInfo b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public QCircleSampleInfo c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public QCircleSampleInfo d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String d()
  {
    if ("Q_CIRCLE_PLUGIN_ASSET".equals(this.d)) {
      return "A";
    }
    if ("Q_CIRCLE_PLUGIN_NETWORK".equals(this.d)) {
      return "N";
    }
    if ("Q_CIRCLE_PLUGIN_TEST".equals(this.d)) {
      return "T";
    }
    return "U";
  }
  
  public QCircleSampleInfo e(String paramString)
  {
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleSampleInfo{mVersionCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mPluginZipPath='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPluginMangerApkPath='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mConfigJsonPath='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mType='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCrashCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mSupportMinHostVersion=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleSampleInfo
 * JD-Core Version:    0.7.0.1
 */