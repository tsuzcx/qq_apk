import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amdw
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c = "分享给你1张图片";
  public String d = "";
  
  public amdw()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 10485760L;
    this.jdField_a_of_type_JavaLangString = "gh_0fc5d8395610";
    this.jdField_b_of_type_JavaLangString = "/pages/gallery/gallery?";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public static amdw a(String paramString)
  {
    boolean bool2 = false;
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    amdw localamdw = new amdw();
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
            localamdw.jdField_a_of_type_Boolean = bool1;
          }
        }
        else
        {
          if (localJSONObject.has("picShareToWeChatSize")) {
            localamdw.jdField_a_of_type_Long = localJSONObject.getLong("picShareToWeChatSize");
          }
          if (localJSONObject.has("PicShareToWeChatUserName")) {
            localamdw.jdField_a_of_type_JavaLangString = localJSONObject.getString("PicShareToWeChatUserName");
          }
          if (localJSONObject.has("PicShareToWeChatPath")) {
            localamdw.jdField_b_of_type_JavaLangString = localJSONObject.getString("PicShareToWeChatPath");
          }
          if (localJSONObject.has("PicShareToWeChatShareTicket"))
          {
            bool1 = bool2;
            if (localJSONObject.getInt("PicShareToWeChatShareTicket") == 1) {
              bool1 = true;
            }
            localamdw.jdField_b_of_type_Boolean = bool1;
          }
          if (localJSONObject.has("PicShareToWeChatMiniType")) {
            localamdw.jdField_a_of_type_Int = localJSONObject.getInt("PicShareToWeChatMiniType");
          }
          if (localJSONObject.has("PicShareToWeChatTitle")) {
            localamdw.c = localJSONObject.getString("PicShareToWeChatTitle");
          }
          paramString = localamdw;
          if (!localJSONObject.has("PicShareToWeChatDescription")) {
            break;
          }
          localamdw.d = localJSONObject.getString("PicShareToWeChatDescription");
          return localamdw;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("PicShareToWXConfigProcessor", 1, "parse error.", paramString);
        return localamdw;
      }
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdw
 * JD-Core Version:    0.7.0.1
 */