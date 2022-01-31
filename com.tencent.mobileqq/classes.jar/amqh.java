import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class amqh
{
  private Map<String, String> a = new HashMap();
  
  public static amqh a(ampi[] paramArrayOfampi)
  {
    Object localObject;
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        amqh localamqh = new amqh();
        i = 0;
        localObject = localamqh;
        if (i >= paramArrayOfampi.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfampi[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localamqh.a.put("apolloGrayUrlWhite", paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localamqh.a.put("apolloTraceConfig", paramArrayOfampi[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfampi)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfampi, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, amqh paramamqh)
  {
    if ((paramQQAppInterface == null) || (paramamqh == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramamqh.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramamqh.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          ajmt.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          ajmt.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqh
 * JD-Core Version:    0.7.0.1
 */