import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class aoln
{
  private Map<String, String> a = new HashMap();
  
  public static aoln a(aoko[] paramArrayOfaoko)
  {
    Object localObject;
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        aoln localaoln = new aoln();
        i = 0;
        localObject = localaoln;
        if (i >= paramArrayOfaoko.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaoko[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localaoln.a.put("apolloGrayUrlWhite", paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localaoln.a.put("apolloTraceConfig", paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaoko)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfaoko, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, aoln paramaoln)
  {
    if ((paramQQAppInterface == null) || (paramaoln == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramaoln.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramaoln.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          alit.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          alit.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoln
 * JD-Core Version:    0.7.0.1
 */