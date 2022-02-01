import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class atio
  extends atih
{
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  public atio(String paramString, BinaryMessenger paramBinaryMessenger)
  {
    super(paramString, paramBinaryMessenger);
    if (a() == null)
    {
      QLog.e("flutter.QQCircleChannel", 1, "[QQCircleChannel] invalid app");
      return;
    }
    paramString = a().getAppRuntime("qcircle_flutter");
    if (!(paramString instanceof QCircleFlutterAppInterface))
    {
      QLog.e("flutter.QQCircleChannel", 1, "[QQCircleChannel] invalid runtime, " + paramString);
      return;
    }
    paramString = ((QCircleFlutterAppInterface)paramString).getEntityManagerFactory();
    if (paramString == null)
    {
      QLog.e("flutter.QQCircleChannel", 1, "[QQCircleChannel] invalid factory");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramString.createEntityManager();
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQCircleChannel", 2, "[setReportSession] ");
    }
    jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public MethodChannel.MethodCallHandler a()
  {
    return new atip(this);
  }
  
  public MethodCodec a()
  {
    return atis.a;
  }
  
  public void a(String paramString, Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", paramString);
    localHashMap.put("arguments", paramMap);
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel.invokeMethod("__event__", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atio
 * JD-Core Version:    0.7.0.1
 */