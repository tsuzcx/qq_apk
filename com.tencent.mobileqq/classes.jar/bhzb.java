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

public class bhzb
  implements bhyh
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "vipARLevelValue", 20);
  private static bhzb jdField_a_of_type_Bhzb;
  private amwp jdField_a_of_type_Amwp;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bhzb a()
  {
    if (jdField_a_of_type_Bhzb == null) {}
    try
    {
      if (jdField_a_of_type_Bhzb == null) {
        jdField_a_of_type_Bhzb = new bhzb();
      }
      return jdField_a_of_type_Bhzb;
    }
    finally {}
  }
  
  public void a(amwp paramamwp)
  {
    if (paramamwp != null)
    {
      this.jdField_a_of_type_Amwp = paramamwp;
      QLog.i("VipARQGLoaderManager", 1, "onConfigLoadSuccess bean != null  switch = " + paramamwp.jdField_a_of_type_Int);
    }
  }
  
  public void a(amwq paramamwq, bhyg parambhyg)
  {
    if ((paramamwq == null) || (TextUtils.isEmpty(paramamwq.b))) {}
    String str1;
    do
    {
      return;
      str1 = paramamwq.b;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(str1) == null) {
        break;
      }
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData map exist");
    } while (parambhyg == null);
    parambhyg.a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1));
    return;
    String str2 = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(str1.hashCode()));
    if (TextUtils.isEmpty(str2))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData pathDir = null");
      return;
    }
    ThreadManager.executeOnFileThread(new VipQGLoaderManager.1(this, str2, str1, parambhyg, paramamwq));
  }
  
  public void a(String paramString)
  {
    QLog.e("VipARQGLoaderManager", 1, "onConfigLoadFail error = " + paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Amwp != null) && (this.jdField_a_of_type_Amwp.jdField_a_of_type_Int != 0) && (!bhyv.a(this.jdField_a_of_type_Amwp.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT > jdField_a_of_type_Int);
  }
  
  public void b(amwp paramamwp)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setVipARConfig vipARConfig == null  ");
    if (paramamwp == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VipARQGLoaderManager", 1, bool);
      this.jdField_a_of_type_Amwp = paramamwp;
      return;
    }
  }
  
  public void b(amwq paramamwq, bhyg parambhyg)
  {
    if ((paramamwq == null) || (TextUtils.isEmpty(paramamwq.b)) || (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null))
    {
      if (parambhyg != null)
      {
        localObject = new StringBuilder().append("downloadQGModelData zipUrl = null or Download = null , config == null ");
        if (paramamwq != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        parambhyg.b(bool);
        return;
      }
    }
    Object localObject = paramamwq.b;
    String str = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(((String)localObject).hashCode())) + ".zip";
    if (QZLog.isColorLevel()) {
      QZLog.i("VipARQGLoaderManager", 2, "download qg js file zipUrl = " + (String)localObject + " tempPath = " + str);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download((String)localObject, str, false, new bhzc(this, parambhyg, (String)localObject, str, paramamwq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhzb
 * JD-Core Version:    0.7.0.1
 */