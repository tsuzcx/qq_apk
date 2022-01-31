import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class bava
  implements bdhg
{
  private basj jdField_a_of_type_Basj;
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public bava(bauz parambauz, basj parambasj, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_Basj = parambasj;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public bava(bauz parambauz, basj parambasj, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(parambauz, parambasj, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(aprk paramaprk)
  {
    Object localObject2 = null;
    if (paramaprk.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramaprk.k)) && (!paramaprk.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramaprk.j)) && (!paramaprk.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramaprk.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramaprk.j + " respXErrNo: " + paramaprk.k);
        }
        paramaprk.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramaprk.a != null) {
        try
        {
          localObject1 = paramaprk.a.getInputStream();
          if (localObject1 != null) {
            return bauz.a(this.jdField_a_of_type_Bauz, (InputStream)localObject1, paramaprk.e, this.jdField_a_of_type_Basj, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.w("NearbyImgDownloader", 2, localIOException.toString());
              localObject1 = localObject2;
            }
          }
          paramaprk.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramaprk.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bava
 * JD-Core Version:    0.7.0.1
 */