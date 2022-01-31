import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class bcdl
  implements nbs
{
  bcdl(bcdk parambcdk) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (bcdk.a(bcdk.a(this.a), bcdk.b(this.a)))
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
            bdhb.a(ncb.a(bcdk.a(this.a)) + bcdk.a(this.a));
            bcdk.a(this.a);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (bcdk.a(bcdk.a(this.a), bcdk.b(this.a)));
          bcdk.b(this.a);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          bcdk.a(this.a, paramString);
          return;
        }
      } while (bcdk.a(bcdk.a(this.a), bcdk.b(this.a)));
      bcdk.b(this.a);
      return;
    }
    bcdk.b(this.a);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdl
 * JD-Core Version:    0.7.0.1
 */