import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class aysu
  implements bbec
{
  private ayqf jdField_a_of_type_Ayqf;
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public aysu(ayst paramayst, ayqf paramayqf, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_Ayqf = paramayqf;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public aysu(ayst paramayst, ayqf paramayqf, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(paramayst, paramayqf, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(anvt paramanvt)
  {
    Object localObject2 = null;
    if (paramanvt.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramanvt.k)) && (!paramanvt.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramanvt.j)) && (!paramanvt.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramanvt.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramanvt.j + " respXErrNo: " + paramanvt.k);
        }
        paramanvt.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramanvt.a != null) {
        try
        {
          localObject1 = paramanvt.a.getInputStream();
          if (localObject1 != null) {
            return ayst.a(this.jdField_a_of_type_Ayst, (InputStream)localObject1, paramanvt.e, this.jdField_a_of_type_Ayqf, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
          paramanvt.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramanvt.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aysu
 * JD-Core Version:    0.7.0.1
 */