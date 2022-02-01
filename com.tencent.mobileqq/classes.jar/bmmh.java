import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.vip.ar.util.VipQGLoaderManager.1;
import java.util.HashMap;

public class bmmh
  implements bmln
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "vipARLevelValue", 20);
  private static bmmh jdField_a_of_type_Bmmh;
  private argw jdField_a_of_type_Argw;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bmmh a()
  {
    if (jdField_a_of_type_Bmmh == null) {}
    try
    {
      if (jdField_a_of_type_Bmmh == null) {
        jdField_a_of_type_Bmmh = new bmmh();
      }
      return jdField_a_of_type_Bmmh;
    }
    finally {}
  }
  
  public void a(argw paramargw)
  {
    if (paramargw != null)
    {
      this.jdField_a_of_type_Argw = paramargw;
      QLog.i("VipARQGLoaderManager", 1, "onConfigLoadSuccess bean != null  switch = " + paramargw.jdField_a_of_type_Int);
    }
  }
  
  public void a(argx paramargx, bmlm parambmlm)
  {
    if ((paramargx == null) || (TextUtils.isEmpty(paramargx.b))) {}
    String str1;
    do
    {
      return;
      str1 = paramargx.b;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(str1) == null) {
        break;
      }
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData map exist");
    } while (parambmlm == null);
    parambmlm.a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1));
    return;
    String str2 = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(str1.hashCode()));
    if (TextUtils.isEmpty(str2))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData pathDir = null");
      return;
    }
    ThreadManager.executeOnFileThread(new VipQGLoaderManager.1(this, str2, str1, parambmlm, paramargx));
  }
  
  public void a(String paramString)
  {
    QLog.e("VipARQGLoaderManager", 1, "onConfigLoadFail error = " + paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Argw != null) && (this.jdField_a_of_type_Argw.jdField_a_of_type_Int != 0) && (!bmmb.a(this.jdField_a_of_type_Argw.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT > jdField_a_of_type_Int);
  }
  
  public void b(argw paramargw)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setVipARConfig vipARConfig == null  ");
    if (paramargw == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VipARQGLoaderManager", 1, bool);
      this.jdField_a_of_type_Argw = paramargw;
      return;
    }
  }
  
  public void b(argx paramargx, bmlm parambmlm)
  {
    if ((paramargx == null) || (TextUtils.isEmpty(paramargx.b)) || (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null))
    {
      if (parambmlm != null)
      {
        localObject = new StringBuilder().append("downloadQGModelData zipUrl = null or Download = null , config == null ");
        if (paramargx != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        parambmlm.b(bool);
        return;
      }
    }
    Object localObject = paramargx.b;
    String str = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(((String)localObject).hashCode())) + ".zip";
    if (QZLog.isColorLevel()) {
      QZLog.i("VipARQGLoaderManager", 2, "download qg js file zipUrl = " + (String)localObject + " tempPath = " + str);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download((String)localObject, str, false, new bmmi(this, parambmlm, (String)localObject, str, paramargx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmh
 * JD-Core Version:    0.7.0.1
 */