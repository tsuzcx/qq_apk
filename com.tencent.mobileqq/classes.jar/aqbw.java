import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqbw
{
  private int a;
  private int b;
  
  public static aqbw a(aogf paramaogf)
  {
    aqbw localaqbw = new aqbw();
    if (paramaogf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramaogf = paramaogf.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramaogf))
        {
          paramaogf = new JSONObject(paramaogf);
          localaqbw.a(paramaogf.optInt("business_switch", 0));
          localaqbw.b(paramaogf.optInt("showInRecentView", 0));
          return localaqbw;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localaqbw;
        }
      }
      catch (JSONException paramaogf)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramaogf.toString());
        }
      }
    }
    return localaqbw;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean b()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    return String.format("mBusinessSwitch:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbw
 * JD-Core Version:    0.7.0.1
 */