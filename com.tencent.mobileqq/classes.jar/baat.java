import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class baat
  implements myy
{
  baat(baas parambaas) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (baas.a(baas.a(this.a), baas.b(this.a)))
    {
      do
      {
        String str;
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
          str = paramString.optString("url");
          paramInt = paramString.optInt("filesize");
          if ((str != null) && (str.endsWith("patch")))
          {
            bbdx.a(mzh.a(baas.a(this.a)) + baas.a(this.a));
            baas.a(this.a);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (baas.a(baas.a(this.a), baas.b(this.a)));
          baas.b(this.a);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          baas.a(this.a, paramString);
          return;
        }
      } while (baas.a(baas.a(this.a), baas.b(this.a)));
      baas.b(this.a);
      return;
    }
    baas.b(this.a);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baat
 * JD-Core Version:    0.7.0.1
 */