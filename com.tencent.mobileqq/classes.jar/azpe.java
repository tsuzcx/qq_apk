import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class azpe
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
  
  public azpe()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static azpe a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {}
    azpe localazpe;
    JSONObject localJSONObject;
    do
    {
      do
      {
        return null;
        localazpe = new azpe();
        localazpe.jdField_a_of_type_JavaLangString = paramJSONObject.optString("fid");
        localJSONObject = paramJSONObject.optJSONObject("msg");
      } while (localJSONObject == null);
      localazpe.jdField_c_of_type_JavaLangString = localJSONObject.optString("text_face");
      if (localazpe.jdField_c_of_type_JavaLangString != null) {
        localazpe.jdField_c_of_type_JavaLangString = localazpe.jdField_c_of_type_JavaLangString.replace("&#10;", "<br/>");
      }
      localazpe.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
      if (localazpe.jdField_b_of_type_JavaLangString != null) {
        localazpe.jdField_b_of_type_JavaLangString = localazpe.jdField_b_of_type_JavaLangString.replace("&#10;", "<br/>");
      }
    } while ((localazpe.jdField_b_of_type_JavaLangString == null) || (localazpe.jdField_c_of_type_JavaLangString == null));
    localazpe.i = paramJSONObject.optString("fid");
    Object localObject = localJSONObject.optJSONArray("pics");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject != null)
      {
        localazpe.d = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
        localazpe.e = ("http://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
      }
    }
    localObject = paramJSONObject.optJSONObject("settings");
    if (localObject != null)
    {
      if (((JSONObject)localObject).optInt("is_show_edit_card", 0) != 1) {
        break label424;
      }
      bool1 = true;
      localazpe.jdField_a_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("tip_window_type", 0) != 0) {
        break label429;
      }
      bool1 = true;
      label303:
      localazpe.jdField_b_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("confirm_required", 0) != 1) {
        break label434;
      }
    }
    label424:
    label429:
    label434:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localazpe.jdField_c_of_type_Boolean = bool1;
      if (localJSONObject.has("v"))
      {
        localJSONObject = localJSONObject.optJSONObject("v");
        localazpe.f = localJSONObject.optString("l");
        localazpe.d = localJSONObject.optString("bi");
      }
      localazpe.g = paramJSONObject.optString("u");
      localazpe.h = bbcl.h(paramQQAppInterface, paramString, localazpe.g);
      localazpe.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
      localazpe.jdField_b_of_type_Int = paramJSONObject.optInt("read_num");
      return localazpe;
      bool1 = false;
      break;
      bool1 = false;
      break label303;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azpe
 * JD-Core Version:    0.7.0.1
 */