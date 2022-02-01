import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class baze
  extends bazc
{
  public static final String a;
  public float a;
  public int a;
  public CharSequence a;
  public float b;
  public CharSequence b;
  public String b;
  public String j;
  public String k;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.uniteSearch." + baze.class.getSimpleName();
  }
  
  public baze(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public baze(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("bannerImageType");
      this.jdField_b_of_type_JavaLangString = paramString.optString("bannerImageUrl");
      this.jdField_a_of_type_Float = ((float)paramString.optDouble("bannerImageWidth"));
      this.jdField_b_of_type_Float = ((float)paramString.optDouble("bannerImageHeight"));
      this.j = paramString.optString("topLeftTagText");
      this.k = paramString.optString("topLeftTagColor");
      this.jdField_a_of_type_JavaLangCharSequence = paramString.optString("firstLineText");
      this.jdField_b_of_type_JavaLangCharSequence = paramString.optString("secondLineText");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baze
 * JD-Core Version:    0.7.0.1
 */