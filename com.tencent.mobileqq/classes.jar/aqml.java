import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class aqml
{
  private Map<String, String> a = new HashMap();
  
  public static aqml a(aqlg[] paramArrayOfaqlg)
  {
    Object localObject;
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        aqml localaqml = new aqml();
        i = 0;
        localObject = localaqml;
        if (i >= paramArrayOfaqlg.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaqlg[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localaqml.a.put("apolloGrayUrlWhite", paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localaqml.a.put("apolloTraceConfig", paramArrayOfaqlg[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaqlg)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfaqlg, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aqml paramaqml)
  {
    if ((paramQQAppInterface == null) || (paramaqml == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramaqml.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramaqml.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          anca.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          anca.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqml
 * JD-Core Version:    0.7.0.1
 */