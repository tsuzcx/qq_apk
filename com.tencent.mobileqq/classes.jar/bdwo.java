import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class bdwo
  implements bgml
{
  private bdub jdField_a_of_type_Bdub;
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public bdwo(bdwn parambdwn, bdub parambdub, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_Bdub = parambdub;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public bdwo(bdwn parambdwn, bdub parambdub, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(parambdwn, parambdub, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(arul paramarul)
  {
    Object localObject2 = null;
    if (paramarul.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramarul.k)) && (!paramarul.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramarul.j)) && (!paramarul.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramarul.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramarul.j + " respXErrNo: " + paramarul.k);
        }
        paramarul.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramarul.a != null) {
        try
        {
          localObject1 = paramarul.a.getInputStream();
          if (localObject1 != null) {
            return bdwn.a(this.jdField_a_of_type_Bdwn, (InputStream)localObject1, paramarul.e, this.jdField_a_of_type_Bdub, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
          paramarul.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramarul.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwo
 * JD-Core Version:    0.7.0.1
 */