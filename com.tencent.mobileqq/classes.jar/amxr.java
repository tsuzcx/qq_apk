import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amxr
  implements ampd<String>
{
  public String a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  
  public amxr()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no troop");
    }
    do
    {
      return;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("videopreview");
        if (paramJSONObject == null)
        {
          QLog.e("QFileCommonConfigBean", 1, "parse Troop Json |type: 396no videoPreview");
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
        return;
      }
      this.m = paramJSONObject.getBoolean("switch");
      if (QLog.isColorLevel()) {
        QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview = " + this.m);
      }
      this.n = paramJSONObject.getBoolean("svip");
      if (QLog.isColorLevel()) {
        QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview for SVIP = " + this.n);
      }
      this.o = paramJSONObject.getBoolean("yearsvip");
    } while (!QLog.isColorLevel());
    QLog.d("QFileCommonConfigBean", 2, "troopVideoPriview for YearSVIP = " + this.n);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396no httpsJson");
    }
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("c2c_up");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2c_up = " + this.jdField_a_of_type_Boolean);
        }
        this.b = paramJSONObject.getBoolean("c2c_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2c_down = " + this.b);
        }
        this.c = paramJSONObject.getBoolean("c2czip_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2czip_down = " + this.c);
        }
        this.d = paramJSONObject.getBoolean("c2c_thumb");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_c2c_thumb = " + this.d);
        }
        this.e = paramJSONObject.getBoolean("disc_up");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disc_up = " + this.e);
        }
        this.f = paramJSONObject.getBoolean("disc_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disc_down = " + this.f);
        }
        this.g = paramJSONObject.getBoolean("disczip_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disczip_down = " + this.g);
        }
        this.h = paramJSONObject.getBoolean("disc_thumb");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_disc_thumb = " + this.h);
        }
        this.i = paramJSONObject.getBoolean("troop_up");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_troop_up = " + this.i);
        }
        this.j = paramJSONObject.getBoolean("troop_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_troop_down = " + this.j);
        }
        this.k = paramJSONObject.getBoolean("troopzip_down");
        if (QLog.isColorLevel()) {
          QLog.d("QFileCommonConfigBean", 2, "https_troopzip_down = " + this.k);
        }
        this.l = paramJSONObject.getBoolean("troop_thumb");
        if (QLog.isColorLevel())
        {
          QLog.d("QFileCommonConfigBean", 2, "https_troop_thumb = " + this.l);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("QFileCommonConfigBean", 1, paramJSONObject, new Object[0]);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QFileCommonConfigBean", 1, "receiveAllConfigs|type: 396configContent is empty");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      b(paramString.getJSONObject("https"));
      a(paramString.getJSONObject("troop"));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileCommonConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxr
 * JD-Core Version:    0.7.0.1
 */