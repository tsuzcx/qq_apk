import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class awot
  extends awop
{
  public double a;
  public int a;
  public CharSequence a;
  public String a;
  public List<awoi> a;
  public double b;
  public int b;
  public CharSequence b;
  public String b;
  public boolean b;
  public CharSequence c;
  public List<String> c;
  public boolean c;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public awot(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public awot(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
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
    boolean bool2 = true;
    int n = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.i = paramString.optString("leftImageURL");
        this.jdField_a_of_type_Int = paramString.optInt("leftImageType", 1);
        this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaLangCharSequence = awvy.a(paramString.optString("headText"));
        this.jdField_a_of_type_JavaLangString = paramString.optString("headLineIconURL");
        this.jdField_b_of_type_JavaLangCharSequence = awvy.a(paramString.optString("descLineText"));
        this.jdField_c_of_type_JavaLangCharSequence = awvy.a(paramString.optString("firstLineText"));
        JSONArray localJSONArray = paramString.optJSONArray("imageList");
        int i;
        Object localObject;
        if (localJSONArray != null)
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList(localJSONArray.length());
          i = 0;
          if (i < localJSONArray.length())
          {
            localObject = localJSONArray.optJSONObject(i);
            localObject = new awoi(((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optInt("type"));
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            i += 1;
            continue;
          }
        }
        this.jdField_a_of_type_Double = paramString.optDouble("imageAspectRatio", 1.0D);
        this.jdField_b_of_type_Double = paramString.optDouble("singleImageScale", 1.0D);
        this.jdField_b_of_type_Int = paramString.optInt("imageTotalCount");
        if (paramString.optInt("topNeedHigherMargin", 0) == 1)
        {
          bool1 = true;
          this.jdField_b_of_type_Boolean = bool1;
          if (paramString.optInt("needCornerRadius", 0) != 1) {
            break label394;
          }
          bool1 = bool2;
          this.jdField_c_of_type_Boolean = bool1;
          localJSONArray = paramString.optJSONArray("dynamicLineImageList");
          if (localJSONArray != null)
          {
            this.jdField_c_of_type_JavaUtilList = new ArrayList(localJSONArray.length());
            i = n;
            if (i < localJSONArray.length())
            {
              localObject = localJSONArray.optJSONObject(i).optString("url");
              this.jdField_c_of_type_JavaUtilList.add(localObject);
              i += 1;
              continue;
            }
          }
          this.jdField_b_of_type_JavaLangString = paramString.optString("dynamicLineLeftText");
          this.j = paramString.optString("dynamicLineZanIconUrl");
          this.k = paramString.optString("dynamicLineZanText");
          this.l = paramString.optString("dynamicLineCommentIconUrl");
          this.m = paramString.optString("dynamicLineCommentText");
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label394:
      bool1 = false;
    }
  }
  
  public boolean b()
  {
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awot
 * JD-Core Version:    0.7.0.1
 */