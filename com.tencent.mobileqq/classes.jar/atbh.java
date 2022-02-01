import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class atbh
{
  private int a;
  private int b;
  
  public static atbh a(araj paramaraj)
  {
    atbh localatbh = new atbh();
    if (paramaraj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramaraj = paramaraj.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramaraj))
        {
          paramaraj = new JSONObject(paramaraj);
          localatbh.a(paramaraj.optInt("business_switch", 0));
          localatbh.b(paramaraj.optInt("showInRecentView", 0));
          return localatbh;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localatbh;
        }
      }
      catch (JSONException paramaraj)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramaraj.toString());
        }
      }
    }
    return localatbh;
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
 * Qualified Name:     atbh
 * JD-Core Version:    0.7.0.1
 */