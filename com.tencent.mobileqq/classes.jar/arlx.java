import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arlx
  implements arae<String>
{
  public int a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    QLog.i("QFileIPv6ConfigBean", 1, "configID:449 onParse FileIPv6Config:" + paramString);
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.toLowerCase();
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is empty, configID:449 use default value");
      a();
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(str).getJSONObject("ipv6config");
        if (paramString == null) {
          break label252;
        }
        if (paramString.has("allswitch"))
        {
          this.jdField_a_of_type_Boolean = paramString.getBoolean("allswitch");
          if (!paramString.has("c2cenable")) {
            break label214;
          }
          this.b = paramString.getBoolean("c2cenable");
          if (!paramString.has("groupenable")) {
            break label222;
          }
          this.c = paramString.getBoolean("groupenable");
          if (!paramString.has("discenable")) {
            break label230;
          }
          this.d = paramString.getBoolean("discenable");
          if (!paramString.has("datalineenable")) {
            break label238;
          }
          this.e = paramString.getBoolean("datalineenable");
          if (!paramString.has("strategy")) {
            break;
          }
          this.jdField_a_of_type_Int = paramString.getInt("strategy");
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("QFileIPv6ConfigBean", 1, paramString, new Object[0]);
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      continue;
      label214:
      this.b = false;
      continue;
      label222:
      this.c = false;
      continue;
      label230:
      this.d = false;
      continue;
      label238:
      this.e = false;
    }
    this.jdField_a_of_type_Int = 0;
    return;
    label252:
    QLog.w("QFileIPv6ConfigBean", 1, "FileIPv6ConfigContent is no ipv6config. use default value");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlx
 * JD-Core Version:    0.7.0.1
 */