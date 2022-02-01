import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class bevh
  implements bhmn
{
  private besv jdField_a_of_type_Besv;
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  
  public bevh(bevg parambevg, besv parambesv, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_Besv = parambesv;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public bevh(bevg parambevg, besv parambesv, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(parambevg, parambesv, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(asjz paramasjz)
  {
    Object localObject2 = null;
    if (paramasjz.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramasjz.k)) && (!paramasjz.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramasjz.j)) && (!paramasjz.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramasjz.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramasjz.j + " respXErrNo: " + paramasjz.k);
        }
        paramasjz.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramasjz.a != null) {
        try
        {
          localObject1 = paramasjz.a.getInputStream();
          if (localObject1 != null) {
            return bevg.a(this.jdField_a_of_type_Bevg, (InputStream)localObject1, paramasjz.e, this.jdField_a_of_type_Besv, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
          paramasjz.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramasjz.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevh
 * JD-Core Version:    0.7.0.1
 */