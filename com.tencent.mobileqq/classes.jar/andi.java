import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class andi
{
  public int a;
  public long a;
  public String a;
  public volatile boolean a;
  public volatile int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f = "-1";
  public String g;
  
  public andi()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "0";
  }
  
  public String a()
  {
    Object localObject = new JSONObject();
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      try
      {
        String str = this.jdField_c_of_type_JavaLangString + "?amount=" + this.jdField_d_of_type_JavaLangString + "&state=" + this.f + "&goalScore=" + this.jdField_a_of_type_Int + "&curScore=" + this.jdField_d_of_type_Int + "&nickName=" + this.e;
        ((JSONObject)localObject).put("url", str);
        ((JSONObject)localObject).put("ret", this.f);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "url:" + str + ",state:" + this.f);
        }
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    for (;;)
    {
      return null;
      QLog.e("cmgame_process.CmGameLauncher", 1, "[getResult] baseUrl is null");
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("RedPacketInfo{");
    localStringBuffer.append("targetScore=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", grabState=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", res='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", needNotifyResult=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", listId='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", url='").append(this.jdField_c_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", gameId=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", amount='").append(this.jdField_d_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", nickname='").append(this.e).append('\'');
    localStringBuffer.append(", endScore=").append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", state='").append(this.f).append('\'');
    localStringBuffer.append(", payParam='").append(this.g).append('\'');
    localStringBuffer.append(", uin=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andi
 * JD-Core Version:    0.7.0.1
 */