import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aolf
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c = "分享给你1张图片";
  public String d = "";
  
  public aolf()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 10485760L;
    this.jdField_a_of_type_JavaLangString = "gh_0fc5d8395610";
    this.jdField_b_of_type_JavaLangString = "/pages/gallery/gallery?";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public static aolf a(String paramString)
  {
    boolean bool2 = false;
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    aolf localaolf = new aolf();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("picShareToWeChatEnable"))
        {
          if (localJSONObject.getInt("picShareToWeChatEnable") == 1)
          {
            bool1 = true;
            localaolf.jdField_a_of_type_Boolean = bool1;
          }
        }
        else
        {
          if (localJSONObject.has("picShareToWeChatSize")) {
            localaolf.jdField_a_of_type_Long = localJSONObject.getLong("picShareToWeChatSize");
          }
          if (localJSONObject.has("PicShareToWeChatUserName")) {
            localaolf.jdField_a_of_type_JavaLangString = localJSONObject.getString("PicShareToWeChatUserName");
          }
          if (localJSONObject.has("PicShareToWeChatPath")) {
            localaolf.jdField_b_of_type_JavaLangString = localJSONObject.getString("PicShareToWeChatPath");
          }
          if (localJSONObject.has("PicShareToWeChatShareTicket"))
          {
            bool1 = bool2;
            if (localJSONObject.getInt("PicShareToWeChatShareTicket") == 1) {
              bool1 = true;
            }
            localaolf.jdField_b_of_type_Boolean = bool1;
          }
          if (localJSONObject.has("PicShareToWeChatMiniType")) {
            localaolf.jdField_a_of_type_Int = localJSONObject.getInt("PicShareToWeChatMiniType");
          }
          if (localJSONObject.has("PicShareToWeChatTitle")) {
            localaolf.c = localJSONObject.getString("PicShareToWeChatTitle");
          }
          paramString = localaolf;
          if (!localJSONObject.has("PicShareToWeChatDescription")) {
            break;
          }
          localaolf.d = localJSONObject.getString("PicShareToWeChatDescription");
          return localaolf;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("PicShareToWXConfigProcessor", 1, "parse error.", paramString);
        return localaolf;
      }
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolf
 * JD-Core Version:    0.7.0.1
 */