import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class apvg
{
  private Map<String, String> a = new HashMap();
  
  public static apvg a(aptx[] paramArrayOfaptx)
  {
    Object localObject;
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      try
      {
        apvg localapvg = new apvg();
        i = 0;
        localObject = localapvg;
        if (i >= paramArrayOfaptx.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloConfig_GrayProcessor", 2, new Object[] { "parse conf taskId:", Integer.valueOf(paramArrayOfaptx[i].jdField_a_of_type_Int) });
        }
        localObject = new JSONObject(paramArrayOfaptx[i].jdField_a_of_type_JavaLangString);
        if (((JSONObject)localObject).has("grayUrlConfig")) {
          localapvg.a.put("apolloGrayUrlWhite", paramArrayOfaptx[i].jdField_a_of_type_JavaLangString);
        } else if (((JSONObject)localObject).has("traceConfig")) {
          localapvg.a.put("apolloTraceConfig", paramArrayOfaptx[i].jdField_a_of_type_JavaLangString);
        }
      }
      catch (Exception paramArrayOfaptx)
      {
        QLog.e("ApolloConfig_GrayProcessor", 1, paramArrayOfaptx, new Object[0]);
        return null;
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, apvg paramapvg)
  {
    if ((paramQQAppInterface == null) || (paramapvg == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramapvg.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramapvg.a.get(str1);
        if ((paramBoolean) && (QLog.isColorLevel())) {
          QLog.d("ApolloConfig_GlobalProcessor", 2, new Object[] { "parseApolloGrayConfBean content:", str2 });
        }
        if ("apolloGrayUrlWhite".equals(str1)) {
          amio.a(paramQQAppInterface, str2, paramBoolean);
        } else if ("apolloTraceConfig".equals(str1)) {
          amio.a(paramQQAppInterface, str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvg
 * JD-Core Version:    0.7.0.1
 */