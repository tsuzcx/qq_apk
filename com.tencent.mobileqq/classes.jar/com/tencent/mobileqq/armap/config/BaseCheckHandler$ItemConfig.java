package com.tencent.mobileqq.armap.config;

import android.text.TextUtils;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class BaseCheckHandler$ItemConfig
{
  public int a;
  public Object a;
  public String a;
  public List a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public BaseCheckHandler$ItemConfig(int paramInt1, int paramInt2, ARMapConfig.ResInfo paramResInfo)
  {
    this(paramInt1, paramInt2, paramResInfo.md5, paramResInfo.url, Integer.valueOf(paramResInfo.extra));
  }
  
  public BaseCheckHandler$ItemConfig(int paramInt1, int paramInt2, String paramString1, String paramString2, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.e = ARResUtil.a(BaseCheckHandler.e, paramString1);
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.d = paramString1;
    if (paramInt2 == 3)
    {
      this.jdField_c_of_type_JavaLangString = BaseCheckHandler.jdField_a_of_type_JavaLangString;
      this.d = "tree";
      return;
    }
    if (paramInt2 == 7)
    {
      paramString1 = a(paramString2, paramString1);
      this.jdField_c_of_type_JavaLangString = new File(BaseCheckHandler.jdField_b_of_type_JavaLangString, paramString1).getAbsolutePath();
      this.d = paramString1;
      return;
    }
    if (paramInt2 == 12)
    {
      this.e = ARResUtil.b(BaseCheckHandler.e, paramString1);
      return;
    }
    this.jdField_c_of_type_JavaLangString = ARResUtil.b(paramString1);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = "";
    }
    do
    {
      return paramString2;
      Object localObject2 = "";
      String[] arrayOfString = paramString1.split("/");
      Object localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length > 0) {
          localObject1 = arrayOfString[(arrayOfString.length - 1)];
        }
      }
      int i = ((String)localObject1).indexOf(".");
      localObject2 = localObject1;
      if (i > 1) {
        localObject2 = ((String)localObject1).substring(0, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseCheckHandler", 2, "getPOIModelDirName ItemConfig filename:" + (String)localObject2 + ",url:" + paramString1 + ",md5 = " + paramString2);
      }
      paramString1 = (String)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramString1 = (String)localObject2;
        if (((String)localObject2).startsWith(paramString2)) {
          paramString1 = ((String)localObject2).substring(paramString2.length(), ((String)localObject2).length());
        }
      }
      paramString2 = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("BaseCheckHandler", 2, "getPOIModelDirName result =" + paramString1);
    return paramString1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ItemConfig::");
    localStringBuilder.append("busiType:").append(this.jdField_a_of_type_Int).append("type").append(this.jdField_b_of_type_Int).append(",md5:").append(this.jdField_b_of_type_JavaLangString).append(",url:").append(this.jdField_a_of_type_JavaLangString).append(" ,dirPath:").append(this.jdField_c_of_type_JavaLangString).append(",dirName:").append(this.d).append(" ,zipFile:").append(this.e).append(" ,extar:").append(this.jdField_a_of_type_JavaLangObject).append(",fileList:").append(this.jdField_a_of_type_JavaUtilList).append(",extraFlag:").append(this.jdField_c_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.BaseCheckHandler.ItemConfig
 * JD-Core Version:    0.7.0.1
 */