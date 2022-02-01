import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqqs
  implements aqlb<String>
{
  public ArrayList<aqqt> a = new ArrayList();
  
  public void a(String paramString)
  {
    this.a.clear();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config content is empty");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("random_list");
        if (paramString != null)
        {
          i = 0;
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            aqqt localaqqt = new aqqt();
            localaqqt.a = localJSONObject.optString("nick", "");
            localaqqt.b = localJSONObject.optString("headid", "");
            localaqqt.c = localJSONObject.optString("url", "");
            if ((!TextUtils.isEmpty(localaqqt.a)) && (!TextUtils.isEmpty(localaqqt.b)) && (!TextUtils.isEmpty(localaqqt.c))) {
              break label230;
            }
            if (!QLog.isColorLevel()) {
              break label235;
            }
            QLog.e("OpenSdkRandomConfig", 2, new Object[] { "OpenVirtual.random.config.parse.find invalid,index=", Integer.valueOf(i) });
            break label235;
            if (j == 0) {
              break label240;
            }
            this.a.add(localaqqt);
            break label240;
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("OpenSdkRandomConfig", 2, new Object[] { "OpenVirtual.random.config.parse=", toString() });
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config.getException.", paramString);
        return;
      }
      label230:
      int j = 1;
      continue;
      label235:
      j = 0;
      continue;
      label240:
      i += 1;
    }
  }
  
  public String toString()
  {
    if (this.a.size() > 0) {
      return this.a.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqqs
 * JD-Core Version:    0.7.0.1
 */