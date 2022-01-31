import android.text.TextUtils;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.MTAReportController;
import cooperation.qzone.util.PanoramaUtil;
import java.util.Properties;

public class amkn
  implements Runnable
{
  public amkn(PanoramaUtil paramPanoramaUtil, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      Properties localProperties = new Properties();
      localProperties.put(this.b, this.jdField_a_of_type_JavaLangString);
      MTAReportController.a(BaseApplication.getContext()).reportTimeKVEvent("qzone_panorama", localProperties, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkn
 * JD-Core Version:    0.7.0.1
 */