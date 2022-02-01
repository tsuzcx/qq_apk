import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class bcfz
  extends bcfs
{
  public static final String a;
  public ArrayList<bcfy> a;
  protected final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bcfz.class.getSimpleName();
  }
  
  public bcfz(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
  }
  
  public bcfz(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
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
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONObject(paramString).getJSONArray("itemList");
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      } else {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
    catch (JSONException paramString)
    {
      if (!QLog.isColorLevel()) {
        break label281;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "parseLayoutExtensions, e = " + paramString);
    return;
    int i = 0;
    for (;;)
    {
      JSONObject localJSONObject;
      int j;
      try
      {
        if ((i >= localJSONArray.length()) || (i >= 5)) {
          break label281;
        }
        localJSONObject = localJSONArray.getJSONObject(i);
        paramString = null;
        j = localJSONObject.optInt("type");
        switch (j)
        {
        case 1: 
          if (paramString == null) {
            break label285;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        }
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label281;
        }
      }
      if ((a() instanceof DynamicSearch.ResultItem))
      {
        paramString = new bcga(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, localJSONObject, j, (DynamicSearch.ResultItem)a());
        continue;
        QLog.e(jdField_a_of_type_JavaLangString, 2, "parseLayoutExtensions, e = " + paramString);
      }
      else if ((a() instanceof UnifySearchCommon.ResultItem))
      {
        paramString = new bcga(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, localJSONObject, j, (UnifySearchCommon.ResultItem)a());
        continue;
        if (localJSONArray != null) {
          break;
        }
        label281:
        return;
        continue;
        label285:
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
 * Qualified Name:     bcfz
 * JD-Core Version:    0.7.0.1
 */