import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bfkl
{
  private static bfkl jdField_a_of_type_Bfkl;
  private bfkn jdField_a_of_type_Bfkn = new bfkn(this, null);
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new bfkm(this, "Module_DownloaderGetCodeServer");
  private Map<String, Bundle> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static bfkl a()
  {
    if (jdField_a_of_type_Bfkl == null) {}
    try
    {
      jdField_a_of_type_Bfkl = new bfkl();
      return jdField_a_of_type_Bfkl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfkl
 * JD-Core Version:    0.7.0.1
 */