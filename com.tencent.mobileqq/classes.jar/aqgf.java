import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgf
{
  private int a;
  private int b;
  
  public static aqgf a(aoko paramaoko)
  {
    aqgf localaqgf = new aqgf();
    if (paramaoko != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramaoko = paramaoko.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramaoko))
        {
          paramaoko = new JSONObject(paramaoko);
          localaqgf.a(paramaoko.optInt("business_switch", 0));
          localaqgf.b(paramaoko.optInt("showInRecentView", 0));
          return localaqgf;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localaqgf;
        }
      }
      catch (JSONException paramaoko)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramaoko.toString());
        }
      }
    }
    return localaqgf;
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
 * Qualified Name:     aqgf
 * JD-Core Version:    0.7.0.1
 */