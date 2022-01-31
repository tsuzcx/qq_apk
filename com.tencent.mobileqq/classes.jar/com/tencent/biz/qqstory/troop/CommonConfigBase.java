package com.tencent.biz.qqstory.troop;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public abstract class CommonConfigBase
{
  public Context a;
  public String a;
  
  public CommonConfigBase(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    a(c());
  }
  
  public int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + b(), 0);
  }
  
  public abstract String a();
  
  public String a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonConfigBase", 2, "handleConfig type = " + paramConfig.type.get());
    }
    int i = a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
    int j = paramConfig.version.get();
    if (i == j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonConfigBase", 2, "handleConfig version code not changed .");
      }
      return null;
    }
    a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), j);
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonConfigBase", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      return null;
    }
    paramQQAppInterface = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    if (paramQQAppInterface.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramQQAppInterface.content.get().toByteArray());
      if (paramConfig == null) {}
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new String(paramConfig, "UTF-8");
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramQQAppInterface));
        }
        paramQQAppInterface = null;
        continue;
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramQQAppInterface));
        }
        System.gc();
        try
        {
          paramQQAppInterface = new String(paramConfig, "UTF-8");
        }
        catch (Throwable paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramQQAppInterface));
          }
        }
      }
      paramQQAppInterface = null;
      continue;
      paramQQAppInterface = paramQQAppInterface.content.get().toStringUtf8();
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove(paramString + "_" + b()).commit();
  }
  
  public void a(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString + "_" + b(), paramInt).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramConfig);
    b(paramQQAppInterface);
    a(paramQQAppInterface);
  }
  
  public abstract void a(String paramString);
  
  public abstract String b();
  
  public void b(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    if (TextUtils.isEmpty(paramString))
    {
      localSharedPreferences.edit().remove(this.jdField_a_of_type_JavaLangString + "_" + a());
      return;
    }
    localSharedPreferences.edit().putString(this.jdField_a_of_type_JavaLangString + "_" + a(), paramString).commit();
  }
  
  public String c()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getString(this.jdField_a_of_type_JavaLangString + "_" + a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.CommonConfigBase
 * JD-Core Version:    0.7.0.1
 */