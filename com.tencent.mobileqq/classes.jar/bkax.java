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

public class bkax
  implements bkad
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "vipARLevelValue", 20);
  private static bkax jdField_a_of_type_Bkax;
  private aonw jdField_a_of_type_Aonw;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bkax a()
  {
    if (jdField_a_of_type_Bkax == null) {}
    try
    {
      if (jdField_a_of_type_Bkax == null) {
        jdField_a_of_type_Bkax = new bkax();
      }
      return jdField_a_of_type_Bkax;
    }
    finally {}
  }
  
  public void a(aonw paramaonw)
  {
    if (paramaonw != null)
    {
      this.jdField_a_of_type_Aonw = paramaonw;
      QLog.i("VipARQGLoaderManager", 1, "onConfigLoadSuccess bean != null  switch = " + paramaonw.jdField_a_of_type_Int);
    }
  }
  
  public void a(aonx paramaonx, bkac parambkac)
  {
    if ((paramaonx == null) || (TextUtils.isEmpty(paramaonx.b))) {}
    String str1;
    do
    {
      return;
      str1 = paramaonx.b;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(str1) == null) {
        break;
      }
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData map exist");
    } while (parambkac == null);
    parambkac.a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1));
    return;
    String str2 = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(str1.hashCode()));
    if (TextUtils.isEmpty(str2))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData pathDir = null");
      return;
    }
    ThreadManager.executeOnFileThread(new VipQGLoaderManager.1(this, str2, str1, parambkac, paramaonx));
  }
  
  public void a(String paramString)
  {
    QLog.e("VipARQGLoaderManager", 1, "onConfigLoadFail error = " + paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Aonw != null) && (this.jdField_a_of_type_Aonw.jdField_a_of_type_Int != 0) && (!bkar.a(this.jdField_a_of_type_Aonw.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT > jdField_a_of_type_Int);
  }
  
  public void b(aonw paramaonw)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setVipARConfig vipARConfig == null  ");
    if (paramaonw == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VipARQGLoaderManager", 1, bool);
      this.jdField_a_of_type_Aonw = paramaonw;
      return;
    }
  }
  
  public void b(aonx paramaonx, bkac parambkac)
  {
    if ((paramaonx == null) || (TextUtils.isEmpty(paramaonx.b)) || (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null))
    {
      if (parambkac != null)
      {
        localObject = new StringBuilder().append("downloadQGModelData zipUrl = null or Download = null , config == null ");
        if (paramaonx != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        parambkac.b(bool);
        return;
      }
    }
    Object localObject = paramaonx.b;
    String str = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(((String)localObject).hashCode())) + ".zip";
    if (QZLog.isColorLevel()) {
      QZLog.i("VipARQGLoaderManager", 2, "download qg js file zipUrl = " + (String)localObject + " tempPath = " + str);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download((String)localObject, str, false, new bkay(this, parambkac, (String)localObject, str, paramaonx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkax
 * JD-Core Version:    0.7.0.1
 */