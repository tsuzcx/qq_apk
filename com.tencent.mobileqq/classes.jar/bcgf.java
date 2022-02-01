import android.view.View;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class bcgf
  extends bcga
{
  public static final String a;
  public int a;
  public CharSequence a;
  public ArrayList<bcgg> a;
  public int b;
  protected final String b;
  protected final String j = "showType";
  protected final String k = "moreText";
  protected final String l = "moreUrl";
  public String m;
  
  static
  {
    jdField_a_of_type_JavaLangString = bcgf.class.getSimpleName();
  }
  
  public bcgf(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
  }
  
  public bcgf(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      int n;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("showType");
        this.jdField_a_of_type_JavaLangCharSequence = paramString.optString("moreText");
        this.m = paramString.optString("moreUrl");
        JSONArray localJSONArray = paramString.optJSONArray("itemList");
        if (this.jdField_a_of_type_JavaUtilArrayList == null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          break label273;
          if (i < localJSONArray.length())
          {
            localJSONObject = localJSONArray.optJSONObject(i);
            paramString = null;
            n = localJSONObject.optInt("type");
          }
        }
        else
        {
          switch (n)
          {
          case 1: 
            if (paramString == null) {
              break label281;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
            break label281;
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 0, "layout 13 parse layout error :" + paramString.toString());
        }
      }
      return;
      if ((a() instanceof DynamicSearch.ResultItem))
      {
        paramString = new bcgi(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, localJSONObject, n, (DynamicSearch.ResultItem)a());
      }
      else if ((a() instanceof UnifySearchCommon.ResultItem))
      {
        paramString = new bcgi(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, localJSONObject, n, (UnifySearchCommon.ResultItem)a());
        continue;
        label273:
        i = 0;
        continue;
        continue;
        label281:
        i += 1;
      }
    }
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgf
 * JD-Core Version:    0.7.0.1
 */