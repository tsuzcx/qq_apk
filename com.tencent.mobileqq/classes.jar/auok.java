import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;

public class auok
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return QzoneZipCacheHelper.getBasePath("qzone_aio_gift", String.valueOf(paramString.hashCode()));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    return BaseApplicationImpl.getApplication().getCacheDir() + File.separator + paramString2 + File.separator + Utils.Crc64String(paramString1) + paramString1.substring(paramString1.lastIndexOf("."));
  }
  
  public static void a(auon paramauon, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.e("QzoneGiftUtil", 1, "downloadGiftZip fail with url = null  boxZipUrl = " + paramString1 + " giftZipUrl = " + paramString2 + " giftUrl = " + paramString3);
      return;
    }
    ThreadManagerV2.executeOnFileThread(new QzoneGiftUtil.1(paramauon, paramString1, paramString2, paramString3));
  }
  
  public static void a(String paramString1, String paramString2, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    QLog.i("QzoneGiftUtil", 1, "downloadGiftPhoto");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = new auom(paramQzoneZipCacheHelperCallBack);
    localaxro.jdField_a_of_type_JavaLangString = paramString1;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_c_of_type_JavaLangString = a(paramString1, paramString2);
    localaxro.jdField_c_of_type_Int = 2;
    localQQAppInterface.getNetEngine(0).a(localaxro);
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    return apdh.a(a(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auok
 * JD-Core Version:    0.7.0.1
 */