import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aojp
{
  private int a;
  private int b;
  
  public static aojp a(ampi paramampi)
  {
    aojp localaojp = new aojp();
    if (paramampi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramampi = paramampi.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramampi))
        {
          paramampi = new JSONObject(paramampi);
          localaojp.a(paramampi.optInt("business_switch", 0));
          localaojp.b(paramampi.optInt("showInRecentView", 0));
          return localaojp;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localaojp;
        }
      }
      catch (JSONException paramampi)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramampi.toString());
        }
      }
    }
    return localaojp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojp
 * JD-Core Version:    0.7.0.1
 */