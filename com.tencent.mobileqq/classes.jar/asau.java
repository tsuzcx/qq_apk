import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import java.util.List;

public class asau
{
  public static asau a()
  {
    return asaw.a();
  }
  
  public static boolean a(DownloadInfo paramDownloadInfo)
  {
    return paramDownloadInfo.i == TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInSilentWhiteList: invoked. ", " businessName: ", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = asat.a().b.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInSilentWhiteList: invoked. ", " inWhite: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private void b(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] uniteUniversalDownload: invoked. in silent white list.", " downloadInfo: ", paramDownloadInfo });
    }
    if (!a(paramDownloadInfo)) {
      paramDownloadInfo.i = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
    }
    d(paramDownloadInfo, paramRunnable);
  }
  
  private boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInBlackList: invoked. ", " businessName: ", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = asat.a().jdField_a_of_type_JavaUtilList.contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] businessInBlackList: invoked. ", " inBlack: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private void c(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] uniteSilentDownload: invoked. in silent white list.", " downloadInfo: ", paramDownloadInfo });
    }
    ThreadManager.excute(paramRunnable, 16, null, true);
  }
  
  private void d(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    asbb.a(paramDownloadInfo, new asav(this, paramRunnable));
  }
  
  public void a(DownloadInfo paramDownloadInfo, Runnable paramRunnable)
  {
    String str = paramDownloadInfo.m;
    if (b(str))
    {
      QLog.d("[UniteDownload] DownloadManagerInterceptor", 1, new Object[] { "[check] uniteDownload: invoked. in black list.", " sourceBusinessName: ", str });
      return;
    }
    if (paramDownloadInfo.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, "[check] uniteDownload: invoked. pause continue");
      }
      ThreadManager.excute(paramRunnable, 16, null, true);
      return;
    }
    boolean bool3 = a(str);
    boolean bool4 = paramDownloadInfo.f;
    boolean bool1;
    if (!paramDownloadInfo.g)
    {
      bool1 = true;
      if (asat.a().jdField_a_of_type_Boolean) {
        break label213;
      }
    }
    label213:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[UniteDownload] DownloadManagerInterceptor", 2, new Object[] { "[check] uniteDownload: invoked. ", " inWhite: ", Boolean.valueOf(bool3), " isFromRockDownloader: ", Boolean.valueOf(bool4), " notUniteDownload: ", Boolean.valueOf(bool1), " disableUniteDownloadDialog: ", Boolean.valueOf(bool2) });
      }
      if ((!bool3) && (!bool4) && (!bool1) && (!bool2)) {
        break label219;
      }
      c(paramDownloadInfo, paramRunnable);
      return;
      bool1 = false;
      break;
    }
    label219:
    b(paramDownloadInfo, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asau
 * JD-Core Version:    0.7.0.1
 */