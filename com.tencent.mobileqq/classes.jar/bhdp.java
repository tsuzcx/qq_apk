import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bhdp
  extends bhhe
  implements IHttpDownloader
{
  private bhhe jdField_a_of_type_Bhhe = new bhdq(this);
  private bhhh jdField_a_of_type_Bhhh;
  private IDownloadListener jdField_a_of_type_ComTencentVasUpdateCallbackListenerIDownloadListener;
  
  public bhdp()
  {
    try
    {
      this.jdField_a_of_type_Bhhh = ((bhhh)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(47));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.jdField_a_of_type_Bhhh = new bhhh(BaseApplicationImpl.getApplication().getRuntime());
    }
  }
  
  private bhhf a(@NonNull DownloadInfoParams paramDownloadInfoParams)
  {
    bhhf localbhhf = new bhhf(paramDownloadInfoParams.mUrl, new File(paramDownloadInfoParams.mSavePath));
    localbhhf.f = "vas_update_system";
    localbhhf.e = true;
    localbhhf.p = true;
    localbhhf.r = true;
    localbhhf.q = true;
    localbhhf.j = true;
    localbhhf.n = false;
    localbhhf.s = false;
    localbhhf.a = paramDownloadInfoParams.mItemId;
    return localbhhf;
  }
  
  private bhhk a()
  {
    return this.jdField_a_of_type_Bhhh.a(4);
  }
  
  private void a(DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener)
  {
    if ((a() == null) || (paramDownloadInfoParams == null))
    {
      QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null or params = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VasUpdate_HttpImpl", 2, "onPreloadDownloadStart");
    }
    paramIDownloadListener = new VasHttpDownloaderImpl.1(this, paramDownloadInfoParams, paramIDownloadListener);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (beaw)localQQAppInterface.getManager(193);
      paramIDownloadListener = new beax(localQQAppInterface, paramDownloadInfoParams.mUrl, paramIDownloadListener, 4000L);
      ((beaw)localObject).a(10019, "vas", paramDownloadInfoParams.mItemId, ((Integer)beay.c.get(Integer.valueOf(10019))).intValue(), paramDownloadInfoParams.mUrl, paramDownloadInfoParams.mSavePath, 2, 0, true, paramIDownloadListener);
      return;
    }
    QLog.e("VasUpdate_HttpImpl", 1, "onPreloadDownloadStart app is not QQAppInterface");
    paramIDownloadListener.run();
  }
  
  private void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasUpdate_HttpImpl", 2, "onPreloadDownloadComplete url = " + paramString + " fileSize = " + paramLong);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((beaw)((QQAppInterface)localAppRuntime).getManager(193)).a(paramString, paramLong);
      return;
    }
    QLog.e("VasUpdate_HttpImpl", 1, "onPreloadDownloadComplete app is not QQAppInterface");
  }
  
  public void cancelDownload(String paramString)
  {
    if (a() == null)
    {
      QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null");
      return;
    }
    a().a(false, paramString);
  }
  
  public void startDownload(DownloadInfoParams paramDownloadInfoParams, IDownloadListener paramIDownloadListener, Bundle paramBundle)
  {
    if ((a() == null) || (paramDownloadInfoParams == null))
    {
      QLog.e("VasUpdate_HttpImpl", 1, "startDownload download = null  or params = null");
      return;
    }
    this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerIDownloadListener = paramIDownloadListener;
    if ((paramDownloadInfoParams.mFrom != null) && (paramDownloadInfoParams.mFrom.contains("silent_download")) && (paramBundle == null))
    {
      a(paramDownloadInfoParams, paramIDownloadListener);
      return;
    }
    paramIDownloadListener = new Bundle();
    paramIDownloadListener.putString("from", paramDownloadInfoParams.mFrom);
    a().a(a(paramDownloadInfoParams), this.jdField_a_of_type_Bhhe, paramIDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdp
 * JD-Core Version:    0.7.0.1
 */