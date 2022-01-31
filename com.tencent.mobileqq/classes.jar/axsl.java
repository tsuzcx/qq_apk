import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class axsl
  implements bacj
{
  private axpw jdField_a_of_type_Axpw;
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public axsl(axsk paramaxsk, axpw paramaxpw, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_Axpw = paramaxpw;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public axsl(axsk paramaxsk, axpw paramaxpw, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(paramaxsk, paramaxpw, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(anff paramanff)
  {
    Object localObject2 = null;
    if (paramanff.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramanff.k)) && (!paramanff.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramanff.j)) && (!paramanff.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramanff.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramanff.j + " respXErrNo: " + paramanff.k);
        }
        paramanff.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramanff.a != null) {
        try
        {
          localObject1 = paramanff.a.getInputStream();
          if (localObject1 != null) {
            return axsk.a(this.jdField_a_of_type_Axsk, (InputStream)localObject1, paramanff.e, this.jdField_a_of_type_Axpw, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
          paramanff.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramanff.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axsl
 * JD-Core Version:    0.7.0.1
 */