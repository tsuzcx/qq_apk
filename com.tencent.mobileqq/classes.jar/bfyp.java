import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bfyp
{
  public int a;
  private String jdField_a_of_type_JavaLangString;
  private List<bfyq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public static bfyp a(String paramString)
  {
    bfyp localbfyp = new bfyp();
    localbfyp.a(paramString);
    return localbfyp;
  }
  
  private void a(String paramString)
  {
    long l = System.currentTimeMillis();
    this.jdField_b_of_type_JavaLangString = paramString;
    new ArrayList();
    JSONObject localJSONObject1 = new JSONObject(paramString);
    this.jdField_b_of_type_Int = localJSONObject1.optInt("errorcode");
    this.jdField_a_of_type_JavaLangString = localJSONObject1.optString("errormsg");
    JSONArray localJSONArray = localJSONObject1.optJSONArray("items");
    int i = 0;
    while (i < localJSONArray.length())
    {
      JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
      bfyq localbfyq = new bfyq();
      localbfyq.jdField_a_of_type_JavaLangString = localJSONObject2.optString("itemstring");
      localbfyq.jdField_a_of_type_Boolean = "YES".equalsIgnoreCase(localJSONObject2.optString("item"));
      localbfyq.jdField_a_of_type_Int = localJSONObject2.optInt("itemconf");
      JSONObject localJSONObject3 = localJSONObject2.optJSONObject("itemcoord");
      localbfyq.jdField_b_of_type_Int = localJSONObject3.optInt("x");
      localbfyq.c = localJSONObject3.optInt("y");
      localbfyq.d = localJSONObject3.optInt("width");
      localbfyq.e = localJSONObject3.optInt("height");
      if (!localbfyq.a())
      {
        yuk.e("QQ.Troop.homework.ArithResult", "arith homework json error!! all json=" + paramString);
        znw.a("arith homework json error!! json=" + localJSONObject2, new Object[0]);
      }
      if (!localbfyq.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Int += 1;
      }
      this.jdField_a_of_type_JavaUtilList.add(localbfyq);
      i += 1;
    }
    this.jdField_a_of_type_OrgJsonJSONArray = localJSONArray;
    this.jdField_a_of_type_OrgJsonJSONObject = localJSONObject1;
    yuk.d("QQ.Troop.homework.ArithResult", "parse json cost=" + (System.currentTimeMillis() - l));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bfyq a(int paramInt)
  {
    return (bfyq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public String a()
  {
    yuk.d("QQ.Troop.homework.ArithResult", "toJson:" + this.jdField_a_of_type_Boolean);
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bfyq)this.jdField_a_of_type_JavaUtilList.get(i);
        JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i);
        if (((bfyq)localObject).jdField_a_of_type_Boolean) {}
        for (localObject = "YES";; localObject = "NO")
        {
          localJSONObject.put("item", localObject);
          i += 1;
          break;
        }
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("items", this.jdField_a_of_type_OrgJsonJSONArray);
    }
    for (Object localObject = this.jdField_a_of_type_OrgJsonJSONObject.toString();; localObject = this.jdField_b_of_type_JavaLangString)
    {
      yuk.d("QQ.Troop.homework.ArithResult", "toJSON cost=" + (System.currentTimeMillis() - l));
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyp
 * JD-Core Version:    0.7.0.1
 */