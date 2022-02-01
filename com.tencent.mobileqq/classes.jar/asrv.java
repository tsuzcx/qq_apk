import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class asrv
{
  private int a;
  private int b;
  
  public static asrv a(aqxa paramaqxa)
  {
    asrv localasrv = new asrv();
    if (paramaqxa != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramaqxa = paramaqxa.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramaqxa))
        {
          paramaqxa = new JSONObject(paramaqxa);
          localasrv.a(paramaqxa.optInt("business_switch", 0));
          localasrv.b(paramaqxa.optInt("showInRecentView", 0));
          return localasrv;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localasrv;
        }
      }
      catch (JSONException paramaqxa)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramaqxa.toString());
        }
      }
    }
    return localasrv;
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
 * Qualified Name:     asrv
 * JD-Core Version:    0.7.0.1
 */