import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class bfid
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
  public boolean d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public bfid()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static bfid a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if ((paramJSONObject == null) || (!paramJSONObject.has("msg"))) {
      return null;
    }
    bfid localbfid = new bfid();
    localbfid.jdField_a_of_type_JavaLangString = paramJSONObject.optString("fid");
    if (paramJSONObject.has("is_read")) {
      if (paramJSONObject.optInt("is_read") == 0) {
        break label79;
      }
    }
    JSONObject localJSONObject;
    label79:
    for (boolean bool1 = true;; bool1 = false)
    {
      localbfid.jdField_d_of_type_Boolean = bool1;
      localJSONObject = paramJSONObject.optJSONObject("msg");
      if (localJSONObject != null) {
        break;
      }
      return null;
    }
    localbfid.jdField_c_of_type_JavaLangString = localJSONObject.optString("text_face");
    if (localbfid.jdField_c_of_type_JavaLangString != null) {
      localbfid.jdField_c_of_type_JavaLangString = localbfid.jdField_c_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    localbfid.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
    if (localbfid.jdField_b_of_type_JavaLangString != null) {
      localbfid.jdField_b_of_type_JavaLangString = localbfid.jdField_b_of_type_JavaLangString.replace("&#10;", "<br/>");
    }
    if ((localbfid.jdField_b_of_type_JavaLangString == null) || (localbfid.jdField_c_of_type_JavaLangString == null)) {
      return null;
    }
    localbfid.i = paramJSONObject.optString("fid");
    Object localObject = localJSONObject.optJSONArray("pics");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject != null)
      {
        localbfid.jdField_d_of_type_JavaLangString = ("https://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/628");
        localbfid.e = ("https://gdynamic.qpic.cn/gdynamic/" + ((JSONObject)localObject).optString("id") + "/");
      }
    }
    localObject = paramJSONObject.optJSONObject("settings");
    if (localObject != null)
    {
      if (((JSONObject)localObject).optInt("is_show_edit_card", 0) != 1) {
        break label459;
      }
      bool1 = true;
      localbfid.jdField_a_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("tip_window_type", 0) != 0) {
        break label464;
      }
      bool1 = true;
      label338:
      localbfid.jdField_b_of_type_Boolean = bool1;
      if (((JSONObject)localObject).optInt("confirm_required", 0) != 1) {
        break label469;
      }
    }
    label459:
    label464:
    label469:
    for (bool1 = bool2;; bool1 = false)
    {
      localbfid.jdField_c_of_type_Boolean = bool1;
      if (localJSONObject.has("v"))
      {
        localJSONObject = localJSONObject.optJSONObject("v");
        localbfid.f = localJSONObject.optString("l");
        localbfid.jdField_d_of_type_JavaLangString = localJSONObject.optString("bi");
      }
      localbfid.g = paramJSONObject.optString("u");
      localbfid.h = ContactUtils.getTroopMemberName(paramQQAppInterface, paramString, localbfid.g);
      localbfid.jdField_a_of_type_Long = paramJSONObject.optLong("pubt");
      localbfid.jdField_b_of_type_Int = paramJSONObject.optInt("read_num");
      return localbfid;
      bool1 = false;
      break;
      bool1 = false;
      break label338;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfid
 * JD-Core Version:    0.7.0.1
 */