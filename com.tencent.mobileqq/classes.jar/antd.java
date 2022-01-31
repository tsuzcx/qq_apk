import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class antd
{
  private int a;
  private int b;
  
  public static antd a(alzs paramalzs)
  {
    antd localantd = new antd();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString);
      localantd.a(paramalzs.optInt("business_switch", 0));
      localantd.b(paramalzs.optInt("showInRecentView", 0));
      return localantd;
    }
    catch (JSONException paramalzs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramalzs.toString());
    }
    return localantd;
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
 * Qualified Name:     antd
 * JD-Core Version:    0.7.0.1
 */