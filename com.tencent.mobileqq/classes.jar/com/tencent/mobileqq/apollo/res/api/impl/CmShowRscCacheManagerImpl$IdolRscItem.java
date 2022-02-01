package com.tencent.mobileqq.apollo.res.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class CmShowRscCacheManagerImpl$IdolRscItem
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 6) {
      return this.jdField_a_of_type_JavaLangString;
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_b_of_type_JavaLangString.endsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append("/");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("/");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("/");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public boolean a()
  {
    return (new File(b()).exists()) && (b());
  }
  
  public String b()
  {
    if (8 == this.jdField_a_of_type_Int)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public boolean b()
  {
    if ((CMResUtil.d(b())) && (this.jdField_a_of_type_Int == 8))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/room/");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("room.bin");
      return CMResUtil.d(localStringBuilder.toString());
    }
    return false;
  }
  
  public String c()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFaceDataJson this:");
      ((StringBuilder)localObject1).append(this);
      QLog.d("[cmshow]IdolRscItem", 2, ((StringBuilder)localObject1).toString());
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Int == 6)
    {
      localObject1 = MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("face.json");
      localObject1 = new File(localStringBuilder.toString());
      if (((File)localObject1).exists())
      {
        try
        {
          localObject1 = FileUtils.readFileToString((File)localObject1);
          return localObject1;
        }
        catch (Exception localException1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFaceDataJson ");
          localStringBuilder.append(localException1);
          QLog.e("[cmshow]IdolRscItem", 1, localStringBuilder.toString());
        }
      }
      else
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("blendshape.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (((File)localObject2).exists()) {
          try
          {
            localObject2 = FileUtils.readFileToString((File)localObject2);
            return localObject2;
          }
          catch (Exception localException2)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getFaceDataJson ");
            localStringBuilder.append(localException2);
            QLog.e("[cmshow]IdolRscItem", 1, localStringBuilder.toString());
          }
        }
      }
    }
    else
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("face.json");
      localObject3 = new File(((StringBuilder)localObject3).toString());
      if (((File)localObject3).exists())
      {
        try
        {
          localObject3 = FileUtils.readFileToString((File)localObject3);
          return localObject3;
        }
        catch (Exception localException3)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFaceDataJson ");
          localStringBuilder.append(localException3);
          QLog.e("[cmshow]IdolRscItem", 1, localStringBuilder.toString());
        }
      }
      else
      {
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/");
        ((StringBuilder)localObject4).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject4).append(File.separator);
        ((StringBuilder)localObject4).append("blendshape.json");
        localObject4 = new File(((StringBuilder)localObject4).toString());
        if (((File)localObject4).exists()) {
          try
          {
            localObject4 = FileUtils.readFileToString((File)localObject4);
            return localObject4;
          }
          catch (Exception localException4)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getFaceDataJson ");
            localStringBuilder.append(localException4);
            QLog.e("[cmshow]IdolRscItem", 1, localStringBuilder.toString());
          }
        }
      }
    }
    return "";
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("IdolRscItem{");
    localStringBuffer.append("mResType=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mDownFileName='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mId=");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", mDownPrefixxUrl='");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mCacheJsonName='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscCacheManagerImpl.IdolRscItem
 * JD-Core Version:    0.7.0.1
 */