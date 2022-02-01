import com.tencent.TMG.utils.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class bbnu
  extends bbnh
{
  public CharSequence a;
  public String a;
  public CharSequence b;
  public boolean b;
  
  public bbnu(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public bbnu(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_JavaLangCharSequence = bbup.a(paramString.optJSONArray("leftText"));
        this.jdField_b_of_type_JavaLangCharSequence = bbup.a(paramString.optJSONArray("rightText"));
        this.jdField_a_of_type_JavaLangString = paramString.optString("bgColor");
        if (paramString.optInt("needCenter") == 1)
        {
          this.jdField_b_of_type_Boolean = bool;
          return;
        }
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(c, 0, paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnu
 * JD-Core Version:    0.7.0.1
 */