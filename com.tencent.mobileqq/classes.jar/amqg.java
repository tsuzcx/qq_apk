import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class amqg
{
  private Map<String, String> a = new HashMap();
  
  public static amqg a(amph[] paramArrayOfamph)
  {
    Object localObject;
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        amqg localamqg = new amqg();
        i = 0;
        localObject = localamqg;
        if (i >= paramArrayOfamph.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfamph[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localamqg.a.put("apolloGrayUrlWhite", paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localamqg.a.put("apolloTraceConfig", paramArrayOfamph[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfamph)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfamph, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, amqg paramamqg)
  {
    if ((paramQQAppInterface == null) || (paramamqg == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramamqg.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramamqg.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          ajmr.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          ajmr.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqg
 * JD-Core Version:    0.7.0.1
 */