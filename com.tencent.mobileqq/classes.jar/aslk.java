import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aslk
{
  private int a;
  private int b;
  
  public static aslk a(aqlg paramaqlg)
  {
    aslk localaslk = new aslk();
    if (paramaqlg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramaqlg = paramaqlg.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramaqlg))
        {
          paramaqlg = new JSONObject(paramaqlg);
          localaslk.a(paramaqlg.optInt("business_switch", 0));
          localaslk.b(paramaqlg.optInt("showInRecentView", 0));
          return localaslk;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localaslk;
        }
      }
      catch (JSONException paramaqlg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramaqlg.toString());
        }
      }
    }
    return localaslk;
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
 * Qualified Name:     aslk
 * JD-Core Version:    0.7.0.1
 */