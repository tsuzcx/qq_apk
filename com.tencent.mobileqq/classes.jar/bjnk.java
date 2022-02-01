import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bjnk
{
  private static bjnk jdField_a_of_type_Bjnk;
  private bjnm jdField_a_of_type_Bjnm = new bjnm(this, null);
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new bjnl(this, "Module_DownloaderGetCodeServer");
  private Map<String, Bundle> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static bjnk a()
  {
    if (jdField_a_of_type_Bjnk == null) {}
    try
    {
      jdField_a_of_type_Bjnk = new bjnk();
      return jdField_a_of_type_Bjnk;
    }
    finally {}
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnk
 * JD-Core Version:    0.7.0.1
 */