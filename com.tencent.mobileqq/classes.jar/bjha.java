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

public class bjha
  implements TbsListener
{
  private static int jdField_a_of_type_Int = 100;
  private static bjha jdField_a_of_type_Bjha;
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
  private bjhf jdField_a_of_type_Bjhf;
  private bjhg jdField_a_of_type_Bjhg;
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private Runnable jdField_a_of_type_JavaLangRunnable = new X5UpdateGuard.1(this);
  
  public static bjha a()
  {
    if (jdField_a_of_type_Bjha == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bjha == null) {
        jdField_a_of_type_Bjha = new bjha();
      }
      return jdField_a_of_type_Bjha;
    }
  }
  
  private void a()
  {
    try
    {
      QLog.d("minisdk_X5UpdateGuard", 1, "Tbs onX5Failed");
      if ((this.jdField_a_of_type_Bjhf != null) && (this.jdField_a_of_type_Bjhf.isShowing())) {
        this.jdField_a_of_type_Bjhf.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity(), amtj.a(2131705020), 0).a();
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
      if ((this.jdField_a_of_type_Bjhf != null) && (this.jdField_a_of_type_Bjhf.isShowing())) {
        this.jdField_a_of_type_Bjhf.dismiss();
      }
      if (this.jdField_a_of_type_Bjhg == null)
      {
        this.jdField_a_of_type_Bjhg = new bjhg(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getAttachedActivity(), 2131755826);
        this.jdField_a_of_type_Bjhg.setTitle(amtj.a(2131705018));
        this.jdField_a_of_type_Bjhg.setMessage(amtj.a(2131705016));
        this.jdField_a_of_type_Bjhg.setNegativeButton(amtj.a(2131705014), new bjhd(this));
        this.jdField_a_of_type_Bjhg.setPositiveButton(amtj.a(2131705017), new bjhe(this));
        this.jdField_a_of_type_Bjhg.setCanceledOnTouchOutside(false);
      }
      if (!this.jdField_a_of_type_Bjhg.isShowing()) {
        this.jdField_a_of_type_Bjhg.show();
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
    bjhg localbjhg = new bjhg(paramIMiniAppContext.getAttachedActivity(), 2131755826);
    localbjhg.setTitle("小程序运行异常");
    localbjhg.setMessage("升级浏览器组件之后可正常运行小程序，确定要升级么？");
    localbjhg.setNegativeButton("取消", new bjhb(this));
    localbjhg.setPositiveButton("确定", new bjhc(this, paramIMiniAppContext));
    localbjhg.setCanceledOnTouchOutside(true);
    localbjhg.show();
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
 * Qualified Name:     bjha
 * JD-Core Version:    0.7.0.1
 */