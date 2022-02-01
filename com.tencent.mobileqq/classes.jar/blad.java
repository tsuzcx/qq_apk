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

public class blad
  implements bkzj
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "vipARLevelValue", 20);
  private static blad jdField_a_of_type_Blad;
  private aqdp jdField_a_of_type_Aqdp;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static blad a()
  {
    if (jdField_a_of_type_Blad == null) {}
    try
    {
      if (jdField_a_of_type_Blad == null) {
        jdField_a_of_type_Blad = new blad();
      }
      return jdField_a_of_type_Blad;
    }
    finally {}
  }
  
  public void a(aqdp paramaqdp)
  {
    if (paramaqdp != null)
    {
      this.jdField_a_of_type_Aqdp = paramaqdp;
      QLog.i("VipARQGLoaderManager", 1, "onConfigLoadSuccess bean != null  switch = " + paramaqdp.jdField_a_of_type_Int);
    }
  }
  
  public void a(aqdq paramaqdq, bkzi parambkzi)
  {
    if ((paramaqdq == null) || (TextUtils.isEmpty(paramaqdq.b))) {}
    String str1;
    do
    {
      return;
      str1 = paramaqdq.b;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(str1) == null) {
        break;
      }
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData map exist");
    } while (parambkzi == null);
    parambkzi.a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1));
    return;
    String str2 = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(str1.hashCode()));
    if (TextUtils.isEmpty(str2))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData pathDir = null");
      return;
    }
    ThreadManager.executeOnFileThread(new VipQGLoaderManager.1(this, str2, str1, parambkzi, paramaqdq));
  }
  
  public void a(String paramString)
  {
    QLog.e("VipARQGLoaderManager", 1, "onConfigLoadFail error = " + paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Aqdp != null) && (this.jdField_a_of_type_Aqdp.jdField_a_of_type_Int != 0) && (!bkzx.a(this.jdField_a_of_type_Aqdp.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT > jdField_a_of_type_Int);
  }
  
  public void b(aqdp paramaqdp)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setVipARConfig vipARConfig == null  ");
    if (paramaqdp == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VipARQGLoaderManager", 1, bool);
      this.jdField_a_of_type_Aqdp = paramaqdp;
      return;
    }
  }
  
  public void b(aqdq paramaqdq, bkzi parambkzi)
  {
    if ((paramaqdq == null) || (TextUtils.isEmpty(paramaqdq.b)) || (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null))
    {
      if (parambkzi != null)
      {
        localObject = new StringBuilder().append("downloadQGModelData zipUrl = null or Download = null , config == null ");
        if (paramaqdq != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        parambkzi.b(bool);
        return;
      }
    }
    Object localObject = paramaqdq.b;
    String str = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(((String)localObject).hashCode())) + ".zip";
    if (QZLog.isColorLevel()) {
      QZLog.i("VipARQGLoaderManager", 2, "download qg js file zipUrl = " + (String)localObject + " tempPath = " + str);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download((String)localObject, str, false, new blae(this, parambkzi, (String)localObject, str, paramaqdq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blad
 * JD-Core Version:    0.7.0.1
 */