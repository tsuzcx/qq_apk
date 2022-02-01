import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class aymg
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d;
  
  public aymg()
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {}
    while (!paramRedTypeInfo.red_desc.has()) {
      return;
    }
    Object localObject = paramRedTypeInfo.red_desc.get();
    try
    {
      localObject = new JSONObject((String)localObject);
      this.jdField_b_of_type_Boolean = ((JSONObject)localObject).optBoolean("isOfficialNotify");
      this.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("redContentType");
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("redContentMsg");
      this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("topicId");
      this.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("userType");
      this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("msgId");
      this.jdField_a_of_type_Int = Integer.valueOf(paramRedTypeInfo.red_content.get()).intValue();
      this.d = ((JSONObject)localObject).optString("faceUrl");
      this.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("uin");
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      paramRedTypeInfo.printStackTrace();
    }
  }
  
  public void a(oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    boolean bool2 = true;
    if (paramRedDotInfo == null) {}
    while ((!paramRedDotInfo.str_custom_buffer.has()) || (paramRedDotInfo.str_custom_buffer.get().isEmpty())) {
      return;
    }
    paramRedDotInfo = paramRedDotInfo.str_custom_buffer.get().toStringUtf8();
    for (;;)
    {
      try
      {
        paramRedDotInfo = new JSONObject(paramRedDotInfo);
        if (paramRedDotInfo.optInt("official_topic") == 1)
        {
          bool1 = true;
          this.jdField_b_of_type_Boolean = bool1;
          this.jdField_b_of_type_Int = paramRedDotInfo.optInt("red_content_type");
          this.jdField_a_of_type_JavaLangString = paramRedDotInfo.optString("red_content_msg");
          this.jdField_b_of_type_JavaLangString = paramRedDotInfo.optString("red_topic_tag");
          this.jdField_c_of_type_Int = paramRedDotInfo.optInt("red_user_type");
          if (paramRedDotInfo.optInt("red_type") != 0) {
            break label145;
          }
          bool1 = bool2;
          this.jdField_a_of_type_Boolean = bool1;
          this.jdField_c_of_type_JavaLangString = paramRedDotInfo.optString("red_msg_id");
          return;
        }
      }
      catch (Exception paramRedDotInfo)
      {
        paramRedDotInfo.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label145:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymg
 * JD-Core Version:    0.7.0.1
 */