import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class ayoo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public ayoo()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static ayoo a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {
      return null;
    }
    ayoo localayoo = new ayoo();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("msg");
    if (localJSONObject == null) {
      return null;
    }
    localayoo.jdField_b_of_type_JavaLangString = localJSONObject.optString("text_face");
    if (localayoo.jdField_b_of_type_JavaLangString != null) {
      localayoo.jdField_b_of_type_JavaLangString = localayoo.jdField_b_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    localayoo.jdField_a_of_type_JavaLangString = localJSONObject.optString("title");
    if (localayoo.jdField_a_of_type_JavaLangString != null) {
      localayoo.jdField_a_of_type_JavaLangString = localayoo.jdField_a_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    if ((localayoo.jdField_a_of_type_JavaLangString == null) || (localayoo.jdField_b_of_type_JavaLangString == null)) {
      return null;
    }
    Object localObject = localJSONObject.optJSONArray("pics");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject != null)
      {
        localayoo.c = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
        localayoo.d = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
      }
    }
    localObject = paramJSONObject.optJSONObject("settings");
    if (localObject != null) {
      if (((JSONObject)localObject).optInt("is_show_edit_card", 0) != 1) {
        break label363;
      }
    }
    for (;;)
    {
      localayoo.jdField_a_of_type_Boolean = bool;
      if (localJSONObject.has("v"))
      {
        localJSONObject = localJSONObject.optJSONObject("v");
        localayoo.e = localJSONObject.optString("l");
        localayoo.c = localJSONObject.optString("bi");
      }
      localayoo.f = paramJSONObject.optString("u");
      localayoo.g = babh.h(paramQQAppInterface, paramString, localayoo.f);
      localayoo.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
      localayoo.jdField_b_of_type_Int = paramJSONObject.optInt("read_num");
      return localayoo;
      label363:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayoo
 * JD-Core Version:    0.7.0.1
 */