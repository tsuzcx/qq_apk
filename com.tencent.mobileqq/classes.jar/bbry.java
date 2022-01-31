import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbry
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public bbry()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static bbry a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {}
    bbry localbbry;
    JSONObject localJSONObject;
    do
    {
      do
      {
        return null;
        localbbry = new bbry();
        localbbry.jdField_a_of_type_JavaLangString = paramJSONObject.optString("fid");
        localJSONObject = paramJSONObject.optJSONObject("msg");
      } while (localJSONObject == null);
      localbbry.jdField_c_of_type_JavaLangString = localJSONObject.optString("text_face");
      if (localbbry.jdField_c_of_type_JavaLangString != null) {
        localbbry.jdField_c_of_type_JavaLangString = localbbry.jdField_c_of_type_JavaLangString.replace("&#10;", "<br/>");
      }
      localbbry.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
      if (localbbry.jdField_b_of_type_JavaLangString != null) {
        localbbry.jdField_b_of_type_JavaLangString = localbbry.jdField_b_of_type_JavaLangString.replace("&#10;", "<br/>");
      }
    } while ((localbbry.jdField_b_of_type_JavaLangString == null) || (localbbry.jdField_c_of_type_JavaLangString == null));
    localbbry.i = paramJSONObject.optString("fid");
    Object localObject = localJSONObject.optJSONArray("pics");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject != null)
      {
        localbbry.d = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
        localbbry.e = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
      }
    }
    localObject = paramJSONObject.optJSONObject("settings");
    if (localObject != null)
    {
      if (((JSONObject)localObject).optInt("is_show_edit_card", 0) != 1) {
        break label424;
      }
      bool1 = true;
      localbbry.jdField_a_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("tip_window_type", 0) != 0) {
        break label429;
      }
      bool1 = true;
      label303:
      localbbry.jdField_b_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("confirm_required", 0) != 1) {
        break label434;
      }
    }
    label424:
    label429:
    label434:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localbbry.jdField_c_of_type_Boolean = bool1;
      if (localJSONObject.has("v"))
      {
        localJSONObject = localJSONObject.optJSONObject("v");
        localbbry.f = localJSONObject.optString("l");
        localbbry.d = localJSONObject.optString("bi");
      }
      localbbry.g = paramJSONObject.optString("u");
      localbbry.h = bdgc.h(paramQQAppInterface, paramString, localbbry.g);
      localbbry.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
      localbbry.jdField_b_of_type_Int = paramJSONObject.optInt("read_num");
      return localbbry;
      bool1 = false;
      break;
      bool1 = false;
      break label303;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbry
 * JD-Core Version:    0.7.0.1
 */