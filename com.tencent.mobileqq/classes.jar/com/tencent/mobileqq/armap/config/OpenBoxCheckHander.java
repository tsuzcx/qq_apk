package com.tencent.mobileqq.armap.config;

import aayk;
import aayl;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenBoxCheckHander
  extends BaseCheckHandler
{
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aayk(this);
  public OpenBoxCheckHander.OnResCheckResultListener a;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
  public List b = new ArrayList();
  
  public OpenBoxCheckHander(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    ThreadManager.postImmediately(new aayl(this, paramItemConfig), null, false);
  }
  
  int a()
  {
    return 2;
  }
  
  public String a()
  {
    return "OpenBoxCheckHander";
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = new File(new BaseCheckHandler.ItemConfig(1, 8, paramString2, paramString1, null).c, "text_icon.png");
    if (paramString1.exists()) {
      return paramString1.getAbsolutePath();
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new BaseCheckHandler.ItemConfig(1, 8, paramString2, paramString1, null);
    if (paramInt == 4) {
      paramString1 = new File(paramString2.c, "logo2.png");
    }
    for (;;)
    {
      if (paramString1.exists())
      {
        return paramString1.getAbsolutePath();
        paramString1 = new File(paramString2.c, "icon2.png");
        if (!paramString1.exists()) {
          paramString1 = new File(paramString2.c, "logo2.png");
        }
      }
      else
      {
        return "";
      }
    }
  }
  
  protected void a(BaseCheckHandler.ItemConfig paramItemConfig, int paramInt)
  {
    super.a(paramItemConfig, paramInt);
    if ((paramItemConfig != null) && (paramItemConfig.jdField_a_of_type_Int == 2) && (paramItemConfig.b == 10) && ((paramItemConfig.jdField_a_of_type_JavaLangObject instanceof Object[]))) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1, paramInt, 0, paramItemConfig).sendToTarget();
    }
  }
  
  public void a(OpenBoxCheckHander.OnResCheckResultListener paramOnResCheckResultListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigOpenBoxCheckHander$OnResCheckResultListener = paramOnResCheckResultListener;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString3, boolean paramBoolean, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.d(this.d, 2, "url or md5 is empty");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(0, new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), paramString3, Boolean.valueOf(paramBoolean), paramString4 }).sendToTarget();
  }
  
  public String b(String paramString1, String paramString2)
  {
    paramString1 = new File(new BaseCheckHandler.ItemConfig(1, 8, paramString2, paramString1, null).c, "topbg.png");
    if (paramString1.exists()) {
      return paramString1.getAbsolutePath();
    }
    return "";
  }
  
  public String c(String paramString1, String paramString2)
  {
    paramString1 = new File(new BaseCheckHandler.ItemConfig(1, 8, paramString2, paramString1, null).c, "greetings.txt");
    try
    {
      paramString1 = FileUtils.b(paramString1);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.OpenBoxCheckHander
 * JD-Core Version:    0.7.0.1
 */