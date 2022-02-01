package com.tencent.mobileqq.activity.qwallet.utils;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FontConvert
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public static FontConvert a()
  {
    return FontConvert.FontConvertHolder.a;
  }
  
  public String a()
  {
    ResourceInfo localResourceInfo = ((IPreloadService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPreloadService.class, "")).getResInfoByResId("text_translate");
    if (localResourceInfo == null) {
      return null;
    }
    return localResourceInfo.folderPath;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramString;
        } while (!this.jdField_a_of_type_Boolean);
        localObject = paramString;
      } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
      localObject = paramString;
    } while (TextUtils.isEmpty(this.b));
    Object localObject = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      int j = this.jdField_a_of_type_JavaLangString.indexOf(c);
      if (j != -1) {
        ((StringBuilder)localObject).append(this.b.charAt(j));
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append(c);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("FontConvert", 2, "traditionalToSimplified params is " + paramString + ",result is " + (String)localObject);
    }
    return localObject;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/activity/qwallet/utils/FontConvert:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 114	android/os/Handler
    //   17: dup
    //   18: invokestatic 120	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   21: invokespecial 123	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   24: new 125	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 128	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:<init>	(Lcom/tencent/mobileqq/activity/qwallet/utils/FontConvert;)V
    //   32: invokevirtual 132	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   35: pop
    //   36: goto -25 -> 11
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	FontConvert
    //   6	2	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   14	36	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.FontConvert
 * JD-Core Version:    0.7.0.1
 */