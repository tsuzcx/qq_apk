import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class aohe
{
  private Map<String, String> a = new HashMap();
  
  public static aohe a(aogf[] paramArrayOfaogf)
  {
    Object localObject;
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        aohe localaohe = new aohe();
        i = 0;
        localObject = localaohe;
        if (i >= paramArrayOfaogf.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaogf[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localaohe.a.put("apolloGrayUrlWhite", paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localaohe.a.put("apolloTraceConfig", paramArrayOfaogf[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaogf)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfaogf, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aohe paramaohe)
  {
    if ((paramQQAppInterface == null) || (paramaohe == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramaohe.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramaohe.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          alee.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          alee.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aohe
 * JD-Core Version:    0.7.0.1
 */