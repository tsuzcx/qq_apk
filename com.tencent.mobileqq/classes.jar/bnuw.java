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

public class bnuw
  implements bnuc
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "vipARLevelValue", 20);
  private static bnuw jdField_a_of_type_Bnuw;
  private arjw jdField_a_of_type_Arjw;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static bnuw a()
  {
    if (jdField_a_of_type_Bnuw == null) {}
    try
    {
      if (jdField_a_of_type_Bnuw == null) {
        jdField_a_of_type_Bnuw = new bnuw();
      }
      return jdField_a_of_type_Bnuw;
    }
    finally {}
  }
  
  public void a(arjw paramarjw)
  {
    if (paramarjw != null)
    {
      this.jdField_a_of_type_Arjw = paramarjw;
      QLog.i("VipARQGLoaderManager", 1, "onConfigLoadSuccess bean != null  switch = " + paramarjw.jdField_a_of_type_Int);
    }
  }
  
  public void a(arjx paramarjx, bnub parambnub)
  {
    if ((paramarjx == null) || (TextUtils.isEmpty(paramarjx.b))) {}
    String str1;
    do
    {
      return;
      str1 = paramarjx.b;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(str1) == null) {
        break;
      }
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData map exist");
    } while (parambnub == null);
    parambnub.a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1));
    return;
    String str2 = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(str1.hashCode()));
    if (TextUtils.isEmpty(str2))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData pathDir = null");
      return;
    }
    ThreadManager.executeOnFileThread(new VipQGLoaderManager.1(this, str2, str1, parambnub, paramarjx));
  }
  
  public void a(String paramString)
  {
    QLog.e("VipARQGLoaderManager", 1, "onConfigLoadFail error = " + paramString);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Arjw != null) && (this.jdField_a_of_type_Arjw.jdField_a_of_type_Int != 0) && (!bnuq.a(this.jdField_a_of_type_Arjw.jdField_a_of_type_JavaLangString)) && (Build.VERSION.SDK_INT > jdField_a_of_type_Int);
  }
  
  public void b(arjw paramarjw)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setVipARConfig vipARConfig == null  ");
    if (paramarjw == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VipARQGLoaderManager", 1, bool);
      this.jdField_a_of_type_Arjw = paramarjw;
      return;
    }
  }
  
  public void b(arjx paramarjx, bnub parambnub)
  {
    if ((paramarjx == null) || (TextUtils.isEmpty(paramarjx.b)) || (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null))
    {
      if (parambnub != null)
      {
        localObject = new StringBuilder().append("downloadQGModelData zipUrl = null or Download = null , config == null ");
        if (paramarjx != null) {
          break label61;
        }
      }
      label61:
      for (boolean bool = true;; bool = false)
      {
        parambnub.b(bool);
        return;
      }
    }
    Object localObject = paramarjx.b;
    String str = QzoneZipCacheHelper.getBasePath("vip_qg", String.valueOf(((String)localObject).hashCode())) + ".zip";
    if (QZLog.isColorLevel()) {
      QZLog.i("VipARQGLoaderManager", 2, "download qg js file zipUrl = " + (String)localObject + " tempPath = " + str);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download((String)localObject, str, false, new bnux(this, parambnub, (String)localObject, str, paramarjx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnuw
 * JD-Core Version:    0.7.0.1
 */