package com.tencent.mfsdk.impls.memory;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
  private static MemoryDumpHelper jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryDump", 0);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected QQProgressDialog a;
  
  private MemoryDumpHelper()
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(com.tencent.qapmsdk.common.thread.ThreadManager.getMonitorThreadLooper());
  }
  
  public static Activity a()
  {
    Object localObject1;
    if (2 == BaseApplicationImpl.sProcessId) {
      localObject1 = ProcessUtils.getTopActivity();
    } else if (BaseActivity.sTopActivity != null) {
      localObject1 = BaseActivity.sTopActivity;
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((Activity)localObject1).isFinishing()) {
        localObject2 = null;
      }
    }
    return localObject2;
  }
  
  public static MemoryDumpHelper a()
  {
    if (jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper == null) {
          jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper = new MemoryDumpHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMfsdkImplsMemoryMemoryDumpHelper;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   13: invokevirtual 80	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   16: ifeq +27 -> 43
    //   19: aload_0
    //   20: getfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   23: invokevirtual 83	com/tencent/mobileqq/utils/QQCustomDialog:dismiss	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 73	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   31: goto +12 -> 43
    //   34: astore_1
    //   35: goto +11 -> 46
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	MemoryDumpHelper
    //   34	1	1	localObject	Object
    //   38	11	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	34	finally
    //   39	43	34	finally
    //   2	31	38	java/lang/Exception
  }
  
  private void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new MemoryDumpHelper.4(this, paramString1, paramString2, paramOnClickListener1, paramOnClickListener2), 100L);
  }
  
  private void a(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("ReportDump dump mem.");
    localStringBuilder.append("fromLeak=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(". Threshold=");
    localStringBuilder.append((100 - MagnifierSDK.a().a().a) * Runtime.getRuntime().maxMemory() / 100L / 1024L);
    localStringBuilder.append(" KB HeapMax=");
    localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
    localStringBuilder.append(" KB HeapSize=");
    localStringBuilder.append((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
    localStringBuilder.append(" KB HeapSizeBeforeTrim=");
    localStringBuilder.append(paramLong);
    QLog.d("QAPM_MemoryDumpHelper", 2, localStringBuilder.toString());
    jdField_a_of_type_AndroidOsHandler.postDelayed(new MemoryDumpHelper.6(this, paramBoolean1, paramString1, paramString2, paramBoolean2), 100L);
  }
  
  private boolean a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      Activity localActivity = a();
      if (localActivity == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump initDialog ctx == null");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(localActivity, 2131756189);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131558978);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, new MemoryDumpHelper.5(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
      return true;
    }
    finally {}
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (BaseApplicationImpl.sApplication.getRuntime().isBackgroundPause)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "app is background");
      }
      return false;
    }
    if ((NetworkCenter.getInstance().getNetType() != 1) && (QLog.isColorLevel())) {
      QLog.d("QAPM_MemoryDumpHelper", 2, "network is not wifi");
    }
    return false;
  }
  
  private void b()
  {
    com.tencent.mobileqq.app.ThreadManager.getUIHandler().post(new MemoryDumpHelper.8(this));
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   6: ifnonnull +65 -> 71
    //   9: aload_0
    //   10: new 271	com/tencent/mobileqq/widget/QQProgressDialog
    //   13: dup
    //   14: invokestatic 188	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:a	()Landroid/app/Activity;
    //   17: invokestatic 22	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   20: invokevirtual 275	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   23: ldc_w 276
    //   26: invokevirtual 282	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   29: invokespecial 283	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   32: putfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   35: aload_0
    //   36: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   39: ldc_w 284
    //   42: invokestatic 289	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   45: invokevirtual 292	com/tencent/mobileqq/widget/QQProgressDialog:a	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   52: iconst_0
    //   53: invokevirtual 294	com/tencent/mobileqq/widget/QQProgressDialog:c	(Z)V
    //   56: aload_0
    //   57: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   60: new 296	com/tencent/mfsdk/impls/memory/MemoryDumpHelper$9
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 297	com/tencent/mfsdk/impls/memory/MemoryDumpHelper$9:<init>	(Lcom/tencent/mfsdk/impls/memory/MemoryDumpHelper;)V
    //   68: invokevirtual 301	com/tencent/mobileqq/widget/QQProgressDialog:setOnDismissListener	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   71: aload_0
    //   72: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   75: invokevirtual 304	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   78: goto +24 -> 102
    //   81: astore_1
    //   82: goto +23 -> 105
    //   85: astore_1
    //   86: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +13 -> 102
    //   92: ldc 171
    //   94: iconst_2
    //   95: ldc_w 306
    //   98: aload_1
    //   99: invokestatic 309	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	MemoryDumpHelper
    //   81	1	1	localObject	Object
    //   85	23	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	71	81	finally
    //   71	78	81	finally
    //   86	102	81	finally
    //   2	71	85	java/lang/Exception
    //   71	78	85	java/lang/Exception
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   13: invokevirtual 312	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   16: ifeq +27 -> 43
    //   19: aload_0
    //   20: getfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   23: invokevirtual 313	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 269	com/tencent/mfsdk/impls/memory/MemoryDumpHelper:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   31: goto +12 -> 43
    //   34: astore_1
    //   35: goto +11 -> 46
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	MemoryDumpHelper
    //   34	1	1	localObject	Object
    //   38	11	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	34	finally
    //   39	43	34	finally
    //   2	31	38	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    String str = HardCodeUtil.a(2131705850);
    HardCodeUtil.a(2131705857);
    try
    {
      if (!a(true)) {
        return;
      }
      a(str, HardCodeUtil.a(2131706587), new MemoryDumpHelper.2(this, paramString), new MemoryDumpHelper.3(this));
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
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump needShowDumpWarning false");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "ReportDump startDumpingMemory !");
      }
      if (!AppSetting.c())
      {
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
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper
 * JD-Core Version:    0.7.0.1
 */