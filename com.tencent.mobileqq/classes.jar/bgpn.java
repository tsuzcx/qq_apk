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

public class bgpn
  implements bgot
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "vipARLevelValue", 20);
  private static bgpn jdField_a_of_type_Bgpn;
  private amgm jdField_a_of_type_Amgm;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bgpn a()
  {
    if (jdField_a_of_type_Bgpn == null) {}
    try
    {
      if (jdField_a_of_type_Bgpn == null) {
        jdField_a_of_type_Bgpn = new bgpn();
      }
      return jdField_a_of_type_Bgpn;
    }
    finally {}
  }
  
  public void a(amgm paramamgm)
  {
    if (paramamgm != null)
    {
      this.jdField_a_of_type_Amgm = paramamgm;
      QLog.i("VipARQGLoaderManager", 1, "onConfigLoadSuccess bean != null  switch = " + paramamgm.jdField_a_of_type_Int);
    }
  }
  
  public void a(amgn paramamgn, bgos parambgos)
  {
    if ((paramamgn == null) || (TextUtils.isEmpty(paramamgn.b))) {}
    String str1;
    do
    {
      return;
      str1 = paramamgn.b;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(str1) == null) {
        break;
      }
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData map exist");
    } while (parambgos == null);
    parambgos.a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1));
    return;
    String str2 = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(str1.hashCode()));
    if (TextUtils.isEmpty(str2))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData pathDir = null");
      return;
    }
    ThreadManager.executeOnFileThread(new VipQGLoaderManager.1(this, str2, str1, parambgos, paramamgn));
  }
  
  public void a(String paramString)
  {
    QLog.e("VipARQGLoaderManager", 1, "onConfigLoadFail error = " + paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Amgm != null) && (this.jdField_a_of_type_Amgm.jdField_a_of_type_Int != 0) && (!bgph.a(this.jdField_a_of_type_Amgm.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT > jdField_a_of_type_Int);
  }
  
  public void b(amgm paramamgm)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setVipARConfig vipARConfig == null  ");
    if (paramamgm == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VipARQGLoaderManager", 1, bool);
      this.jdField_a_of_type_Amgm = paramamgm;
      return;
    }
  }
  
  public void b(amgn paramamgn, bgos parambgos)
  {
    if ((paramamgn == null) || (TextUtils.isEmpty(paramamgn.b)) || (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null))
    {
      if (parambgos != null)
      {
        localObject = new StringBuilder().append("downloadQGModelData zipUrl = null or Download = null , config == null ");
        if (paramamgn != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        parambgos.b(bool);
        return;
      }
    }
    Object localObject = paramamgn.b;
    String str = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(((String)localObject).hashCode())) + ".zip";
    if (QZLog.isColorLevel()) {
      QZLog.i("VipARQGLoaderManager", 2, "download qg js file zipUrl = " + (String)localObject + " tempPath = " + str);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download((String)localObject, str, false, new bgpo(this, parambgos, (String)localObject, str, paramamgn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgpn
 * JD-Core Version:    0.7.0.1
 */