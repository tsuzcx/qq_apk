import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoju
{
  private int a;
  private int b;
  
  public static aoju a(amph paramamph)
  {
    aoju localaoju = new aoju();
    if (paramamph != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramamph = paramamph.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramamph))
        {
          paramamph = new JSONObject(paramamph);
          localaoju.a(paramamph.optInt("business_switch", 0));
          localaoju.b(paramamph.optInt("showInRecentView", 0));
          return localaoju;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localaoju;
        }
      }
      catch (JSONException paramamph)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramamph.toString());
        }
      }
    }
    return localaoju;
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
 * Qualified Name:     aoju
 * JD-Core Version:    0.7.0.1
 */