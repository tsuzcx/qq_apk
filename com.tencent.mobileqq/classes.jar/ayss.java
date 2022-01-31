import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class ayss
  implements bbdo
{
  private ayqd jdField_a_of_type_Ayqd;
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public ayss(aysr paramaysr, ayqd paramayqd, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_Ayqd = paramayqd;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public ayss(aysr paramaysr, ayqd paramayqd, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(paramaysr, paramayqd, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(anvo paramanvo)
  {
    Object localObject2 = null;
    if (paramanvo.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramanvo.k)) && (!paramanvo.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramanvo.j)) && (!paramanvo.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramanvo.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramanvo.j + " respXErrNo: " + paramanvo.k);
        }
        paramanvo.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramanvo.a != null) {
        try
        {
          localObject1 = paramanvo.a.getInputStream();
          if (localObject1 != null) {
            return aysr.a(this.jdField_a_of_type_Aysr, (InputStream)localObject1, paramanvo.e, this.jdField_a_of_type_Ayqd, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
          paramanvo.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramanvo.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayss
 * JD-Core Version:    0.7.0.1
 */