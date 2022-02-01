import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class aqyj
{
  private Map<String, String> a = new HashMap();
  
  public static aqyj a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject;
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      aqyj localaqyj;
      int i;
      try
      {
        localaqyj = new aqyj();
        i = 0;
        localObject = localaqyj;
        if (i >= paramArrayOfaqxa.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaqxa[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localaqyj.a.put("apolloGrayUrlWhite", paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localaqyj.a.put("apolloTraceConfig", paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaqxa)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfaqxa, new Object[0]);
        return null;
      }
      if (((JSONObject)localObject).has("strangerConfig")) {
        localaqyj.a.put("strangerConfig", paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aqyj paramaqyj)
  {
    if ((paramQQAppInterface == null) || (paramaqyj == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramaqyj.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramaqyj.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          anjy.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          anjy.a(paramQQAppInterface, str2);
        } else if ("strangerConfig".equals(str1)) {
          anjy.b(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyj
 * JD-Core Version:    0.7.0.1
 */