import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class arbq
{
  private Map<String, String> a = new HashMap();
  
  public static arbq a(araj[] paramArrayOfaraj)
  {
    Object localObject;
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        arbq localarbq = new arbq();
        i = 0;
        localObject = localarbq;
        if (i >= paramArrayOfaraj.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaraj[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaraj[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localarbq.a.put("apolloGrayUrlWhite", paramArrayOfaraj[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localarbq.a.put("apolloTraceConfig", paramArrayOfaraj[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaraj)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfaraj, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, arbq paramarbq)
  {
    if ((paramQQAppInterface == null) || (paramarbq == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramarbq.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramarbq.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          annu.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          annu.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbq
 * JD-Core Version:    0.7.0.1
 */