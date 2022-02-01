import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public abstract class anrh
  extends bfvp
{
  public anrh(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public void a(String paramString)
  {
    HashMap localHashMap = new HashMap(1);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.a == null) {
      this.a = "";
    }
    if (this.b == null) {
      this.b = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    paramString = new StringBuilder();
    paramString.append(str).append("source:").append(this.a).append("server_name:").append(this.b).append("action_name:").append(this.c);
    localHashMap.put("keyJumpParserUtilDoActionErrorInfo", paramString.toString());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, localHashMap, "", false);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrh
 * JD-Core Version:    0.7.0.1
 */