import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.X5UpdateGuard.1;
import com.tencent.qqmini.proxyimpl.X5UpdateGuard.4;
import com.tencent.qqmini.proxyimpl.X5UpdateGuard.5;
import com.tencent.qqmini.proxyimpl.X5UpdateGuard.6;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

public class bksl
  implements TbsListener
{
  private static int jdField_a_of_type_Int = 100;
  private static bksl jdField_a_of_type_Bksl;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static int b = 110;
  private static int c = 120;
  private static int d = 121;
  private static int e = 122;
  private static int f = 177;
  private static int g = 200;
  private static int h = 220;
  private static int i = 232;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private bksq jdField_a_of_type_Bksq;
  private bksr jdField_a_of_type_Bksr;
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private Runnable jdField_a_of_type_JavaLangRunnable = new X5UpdateGuard.1(this);
  
  public static bksl a()
  {
    if (jdField_a_of_type_Bksl == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bksl == null) {
        jdField_a_of_type_Bksl = new bksl();
      }
      return jdField_a_of_type_Bksl;
    }
  }
  
  private void a()
  {
    try
    {
      QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onX5Failed");
      if ((this.jdField_a_of_type_Bksq != null) && (this.jdField_a_of_type_Bksq.isShowing())) {
        this.jdField_a_of_type_Bksq.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity(), anvx.a(2131705371), 0).a();
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("minisdk_X5UpdateGuard", 1, "", localThrowable);
    }
  }
  
  private void b()
  {
    try
    {
      QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onX5Succeed");
      if ((this.jdField_a_of_type_Bksq != null) && (this.jdField_a_of_type_Bksq.isShowing())) {
        this.jdField_a_of_type_Bksq.dismiss();
      }
      if (this.jdField_a_of_type_Bksr == null)
      {
        this.jdField_a_of_type_Bksr = new bksr(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity(), 2131755829);
        this.jdField_a_of_type_Bksr.setTitle(anvx.a(2131705369));
        this.jdField_a_of_type_Bksr.setMessage(anvx.a(2131705367));
        this.jdField_a_of_type_Bksr.setNegativeButton(anvx.a(2131705365), new bkso(this));
        this.jdField_a_of_type_Bksr.setPositiveButton(anvx.a(2131705368), new bksp(this));
        this.jdField_a_of_type_Bksr.setCanceledOnTouchOutside(false);
      }
      if (!this.jdField_a_of_type_Bksr.isShowing()) {
        this.jdField_a_of_type_Bksr.show();
      }
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("minisdk_X5UpdateGuard", 1, "", localThrowable);
    }
  }
  
  public void a(IMiniAppContext paramIMiniAppContext)
  {
    if (paramIMiniAppContext == null) {}
    int j;
    int k;
    do
    {
      return;
      j = QbSdk.getTbsVersion(paramIMiniAppContext.getContext());
      k = QbSdk.getTmpDirTbsVersion(paramIMiniAppContext.getContext());
      QLog.d("minisdk_X5UpdateGuard", 1, "getTbsVersion=" + j + " tmpDirTbsVersion=" + k);
    } while ((j > 0) || (k > 0) || (paramIMiniAppContext.getAttachedActivity() == null));
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
    bksr localbksr = new bksr(paramIMiniAppContext.getAttachedActivity(), 2131755829);
    localbksr.setTitle("小程序运行异常");
    localbksr.setMessage("升级浏览器组件之后可正常运行小程序，确定要升级么？");
    localbksr.setNegativeButton("取消", new bksm(this));
    localbksr.setPositiveButton("确定", new bksn(this, paramIMiniAppContext));
    localbksr.setCanceledOnTouchOutside(true);
    localbksr.show();
  }
  
  public void onDownloadFinish(int paramInt)
  {
    QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onDownloadFinish result=" + paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.4(this, paramInt));
  }
  
  public void onDownloadProgress(int paramInt)
  {
    QLog.d("minisdk_X5UpdateGuard", 1, "Tbs install onDownloadProgress=" + paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.6(this, paramInt));
  }
  
  public void onInstallFinish(int paramInt)
  {
    QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onInstallFinish result=" + paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AppBrandTask.runTaskOnUiThread(new X5UpdateGuard.5(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksl
 * JD-Core Version:    0.7.0.1
 */