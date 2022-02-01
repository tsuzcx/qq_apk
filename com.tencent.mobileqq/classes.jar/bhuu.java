import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.updatesystem.impl.VasHttpDownloaderImpl.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.listener.IDownloadListener;
import com.tencent.vas.update.entity.DownloadInfoParams;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class bhuu
  extends bhyn
  implements IHttpDownloader
{
  private bhyn jdField_a_of_type_Bhyn = new bhuv(this);
  private bhyq jdField_a_of_type_Bhyq;
  private IDownloadListener jdField_a_of_type_ComTencentVasUpdateCallbackListenerIDownloadListener;
  
  public bhuu()
  {
    try
    {
      this.jdField_a_of_type_Bhyq = ((bhyq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.jdField_a_of_type_Bhyq = new bhyq(BaseApplicationImpl.getApplication().getRuntime());
    }
  }
  
  private bhyo a(@NonNull DownloadInfoParams paramDownloadInfoParams)
  {
    bhyo localbhyo = new bhyo(paramDownloadInfoParams.mUrl, new File(paramDownloadInfoParams.mSavePath));
    localbhyo.f = "vas_update_system";
    localbhyo.e = true;
    localbhyo.p = true;
    localbhyo.r = true;
    localbhyo.q = true;
    localbhyo.j = true;
    localbhyo.n = false;
    localbhyo.s = false;
    localbhyo.a = paramDownloadInfoParams.mItemId;
    return localbhyo;
  }
  
  private bhyt a()
  {
    return this.jdField_a_of_type_Bhyq.a(4);
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
      localObject = (PreDownloadController)localQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
      paramIDownloadListener = new RunnableTask(localQQAppInterface, paramDownloadInfoParams.mUrl, paramIDownloadListener, 4000L);
      ((PreDownloadController)localObject).requestPreDownload(10019, "vas", paramDownloadInfoParams.mItemId, ((Integer)PreDownloadConstants.BUSINESS_PRIORITY.get(Integer.valueOf(10019))).intValue(), paramDownloadInfoParams.mUrl, paramDownloadInfoParams.mSavePath, 2, 0, true, paramIDownloadListener);
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
      ((PreDownloadController)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2)).preDownloadSuccess(paramString, paramLong);
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
    a().a(a(paramDownloadInfoParams), this.jdField_a_of_type_Bhyn, paramIDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuu
 * JD-Core Version:    0.7.0.1
 */