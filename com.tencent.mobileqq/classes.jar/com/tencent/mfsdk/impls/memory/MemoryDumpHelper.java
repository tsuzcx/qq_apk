package com.tencent.mfsdk.impls.memory;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.opt.clearmemory.MemoryConfigs;
import cooperation.qzone.util.ProcessUtils;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class MemoryDumpHelper
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static MemoryDumpHelper jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper = null;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryDump", 0);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected QQProgressDialog a;
  
  private MemoryDumpHelper()
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(com.tencent.qapmsdk.common.thread.ThreadManager.getMonitorThreadLooper());
  }
  
  public static Activity a()
  {
    Object localObject;
    if (2 == BaseApplicationImpl.sProcessId) {
      localObject = ProcessUtils.getTopActivity();
    }
    for (;;)
    {
      if ((localObject != null) && (((Activity)localObject).isFinishing()))
      {
        return null;
        if (BaseActivity.sTopActivity != null) {
          localObject = BaseActivity.sTopActivity;
        }
      }
      else
      {
        return localObject;
      }
      localObject = null;
    }
  }
  
  public static MemoryDumpHelper a()
  {
    if (jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper == null) {
        jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper = new MemoryDumpHelper();
      }
      return jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper;
    }
    finally {}
  }
  
  private void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new MemoryDumpHelper.4(this, paramString1, paramString2, paramOnClickListener1, paramOnClickListener2), 100L);
  }
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("ReportDump dump mem.").append("fromLeak=").append(paramBoolean1);
    localStringBuilder.append(". Threshold=").append((100 - MagnifierSDK.a().a().a) * Runtime.getRuntime().maxMemory() / 100L / 1024L);
    localStringBuilder.append(" KB HeapMax=");
    localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
    localStringBuilder.append(" KB HeapSize=");
    localStringBuilder.append((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
    localStringBuilder.append(" KB HeapSizeBeforeTrim=").append(paramLong);
    QLog.d("QAPM_MemoryDumpHelper", 2, localStringBuilder.toString());
    jdField_a_of_type_AndroidOsHandler.postDelayed(new MemoryDumpHelper.6(this, paramBoolean1, paramString1, paramString2, paramBoolean2), 100L);
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   8: ifnull +25 -> 33
    //   11: aload_0
    //   12: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   15: invokevirtual 80	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   18: ifeq +15 -> 33
    //   21: aload_0
    //   22: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   25: invokevirtual 83	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   33: invokestatic 188	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:a	()Landroid/app/Activity;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnonnull +25 -> 63
    //   41: iload_2
    //   42: istore_1
    //   43: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +13 -> 59
    //   49: ldc 171
    //   51: iconst_2
    //   52: ldc 193
    //   54: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload_2
    //   58: istore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_1
    //   62: ireturn
    //   63: aload_0
    //   64: new 77	com/tencent/mobileqq/utils/QQCustomDialog
    //   67: dup
    //   68: aload_3
    //   69: ldc 194
    //   71: invokespecial 197	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   74: putfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   77: aload_0
    //   78: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   81: ldc 198
    //   83: invokevirtual 201	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   86: aload_0
    //   87: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   90: aconst_null
    //   91: invokevirtual 205	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   94: pop
    //   95: aload_0
    //   96: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   99: ldc 206
    //   101: new 208	com/tencent/mfsdk/impls/memory/MemoryDumpHelper$5
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 210	com/tencent/mfsdk/impls/memory/MemoryDumpHelper$5:<init>	(Lcom/tencent/mfsdk/impls/memory/MemoryDumpHelper;)V
    //   109: invokevirtual 214	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   112: pop
    //   113: aload_0
    //   114: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   117: iconst_0
    //   118: invokevirtual 218	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   121: iconst_1
    //   122: istore_1
    //   123: goto -64 -> 59
    //   126: astore_3
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_3
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	MemoryDumpHelper
    //   42	81	1	bool1	boolean
    //   1	57	2	bool2	boolean
    //   36	33	3	localActivity	Activity
    //   126	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	33	126	finally
    //   33	37	126	finally
    //   43	57	126	finally
    //   63	121	126	finally
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (BaseApplicationImpl.sApplication.getRuntime().isBackgroundPause) {
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "app is background");
      }
    }
    while ((NetworkCenter.getInstance().getNetType() == 1) || (!QLog.isColorLevel())) {
      return false;
    }
    QLog.d("QAPM_MemoryDumpHelper", 2, "network is not wifi");
    return false;
  }
  
  private void b()
  {
    com.tencent.mobileqq.app.ThreadManager.getUIHandler().post(new MemoryDumpHelper.8(this));
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(a(), BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131706557));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new MemoryDumpHelper.9(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "show juhua exception", localException);
        }
      }
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    String str = HardCodeUtil.a(2131705803);
    HardCodeUtil.a(2131705810);
    try
    {
      if (!a(true)) {
        return;
      }
      a(str, HardCodeUtil.a(2131706561), new MemoryDumpHelper.2(this, paramString), new MemoryDumpHelper.3(this));
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "enable ex", paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      if (!a(false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump needShowDumpWarning false");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump startDumpingMemory !");
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new MemoryDumpHelper.1(this, "", paramString1, paramLong), 100L);
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump enable ex", paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper
 * JD-Core Version:    0.7.0.1
 */