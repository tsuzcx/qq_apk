import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class avpk
  extends avpj
{
  public int a;
  public String a;
  public String b = "";
  
  public avpk()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1001;
  }
  
  private RedAppInfo a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq getRedPointInfo", 2, "path = " + paramString);
    }
    if ("7720.772004".equals(paramString)) {}
    for (paramString = asfj.a(paramQQAppInterface, paramString);; paramString = ((avpq)paramQQAppInterface.getManager(36)).a(paramString)) {
      return avpt.a(paramString);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq clearRed", 2, "path = " + paramString);
    }
    ((avpq)paramQQAppInterface.getManager(36)).b(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq reportRedInfo", 2, "path = " + paramString + "act_id == " + paramInt);
    }
    if (paramString == null) {
      return;
    }
    try
    {
      if (paramString.contains("\\.")) {}
      for (i = Integer.parseInt(paramString.split("\\.")[0]);; i = Integer.parseInt(paramString))
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          paramString = ((avpq)paramQQAppInterface.getManager(36)).a(paramString);
          localJSONObject.put("service_type", 0);
          localJSONObject.put("act_id", paramInt);
          localJSONObject.put("obj_id", "");
          localJSONObject.put("pay_amt", 0);
          localJSONObject.put("service_id", i);
          ((avpq)paramQQAppInterface.getManager(36)).c(paramString, localJSONObject.toString());
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("path", this.jdField_a_of_type_JavaLangString);
    paramBundle.putInt("act_id", this.jdField_a_of_type_Int);
    paramBundle.putString("reportPath", this.b);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("cmd");
    if ("getRedInfo".equals(localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
      }
      paramQQAppInterface = a(this.jdField_a_of_type_JavaLangString, paramQQAppInterface);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("redInfoResp", paramQQAppInterface);
      paramBundle.putBundle("keyResponse", (Bundle)localObject);
      super.a(paramBundle);
    }
    do
    {
      return;
      if ("reportRedInfo".equals(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
        }
        a(paramQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        return;
      }
    } while (!"clearRedInfo".equals(localObject));
    if (QLog.isColorLevel()) {
      QLog.d("GetRedPointInfoReq onReceive", 2, "cmd = " + (String)localObject);
    }
    a(paramQQAppInterface, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("path");
    this.jdField_a_of_type_Int = paramBundle.getInt("act_id");
    this.b = paramBundle.getString("reportPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avpk
 * JD-Core Version:    0.7.0.1
 */