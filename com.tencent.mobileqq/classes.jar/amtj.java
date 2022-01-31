import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.MTAReportController;
import java.util.Properties;

public final class amtj
  implements Runnable
{
  public amtj(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    Properties localProperties = new Properties();
    localProperties.put(this.jdField_a_of_type_JavaLangString, this.b);
    MTAReportController.a(BaseApplicationImpl.getContext()).reportTimeKVEvent(this.c, localProperties, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtj
 * JD-Core Version:    0.7.0.1
 */