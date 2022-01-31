import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class baqr
  implements bdcx
{
  private baoa jdField_a_of_type_Baoa;
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public baqr(baqq parambaqq, baoa parambaoa, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_Baoa = parambaoa;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public baqr(baqq parambaqq, baoa parambaoa, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(parambaqq, parambaoa, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(apnb paramapnb)
  {
    Object localObject2 = null;
    if (paramapnb.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramapnb.k)) && (!paramapnb.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramapnb.j)) && (!paramapnb.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramapnb.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramapnb.j + " respXErrNo: " + paramapnb.k);
        }
        paramapnb.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramapnb.a != null) {
        try
        {
          localObject1 = paramapnb.a.getInputStream();
          if (localObject1 != null) {
            return baqq.a(this.jdField_a_of_type_Baqq, (InputStream)localObject1, paramapnb.e, this.jdField_a_of_type_Baoa, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
          paramapnb.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramapnb.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqr
 * JD-Core Version:    0.7.0.1
 */