import com.tencent.TMG.utils.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class ayos
  extends ayod
{
  public static final String a = ayos.class.getSimpleName();
  public String b;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public ayos(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public ayos(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("leftIcon");
      this.j = paramString.optString("firstTitle");
      this.k = paramString.optString("secondTitle");
      this.l = paramString.optString("moreText");
      this.m = paramString.optString("jumpUrl");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(a, 0, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayos
 * JD-Core Version:    0.7.0.1
 */