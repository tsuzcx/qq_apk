import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

public class annt
  extends annv
  implements annx
{
  public annt(anny paramanny)
  {
    super(null, paramanny);
    this.jdField_a_of_type_Annx = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    return "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/" + paramString + ".zip";
  }
  
  public void a(annv paramannv, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    bhyo localbhyo = new bhyo(paramString1, new File(paramString2));
    localbhyo.p = true;
    localbhyo.n = true;
    localbhyo.f = "apollo_gif";
    localbhyo.b = 1;
    localbhyo.q = true;
    localbhyo.r = true;
    localbhyo.a(new annu(this, paramString1, paramString2, paramString3));
    paramannv = BaseApplicationImpl.getApplication();
    if (paramannv != null)
    {
      paramannv = paramannv.getRuntime();
      if (!(paramannv instanceof QQAppInterface)) {}
    }
    for (paramannv = (QQAppInterface)paramannv;; paramannv = null)
    {
      if (paramannv != null)
      {
        paramannv = (bhyq)paramannv.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        if (paramannv != null)
        {
          paramannv = paramannv.a(3);
          if (paramannv != null) {
            paramannv.a(localbhyo, localbhyo.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.executeOnNetWorkThread(new QQFrameZipDecoder.2(this, localbhyo));
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annt
 * JD-Core Version:    0.7.0.1
 */