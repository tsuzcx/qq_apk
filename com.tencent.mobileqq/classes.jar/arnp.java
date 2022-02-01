import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arnp
{
  private int a;
  private int b;
  
  public static arnp a(aptx paramaptx)
  {
    arnp localarnp = new arnp();
    if (paramaptx != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramaptx = paramaptx.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramaptx))
        {
          paramaptx = new JSONObject(paramaptx);
          localarnp.a(paramaptx.optInt("business_switch", 0));
          localarnp.b(paramaptx.optInt("showInRecentView", 0));
          return localarnp;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return localarnp;
        }
      }
      catch (JSONException paramaptx)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramaptx.toString());
        }
      }
    }
    return localarnp;
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
 * Qualified Name:     arnp
 * JD-Core Version:    0.7.0.1
 */