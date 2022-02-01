import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class bfdz
  implements nkl
{
  bfdz(bfdy parambfdy) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (bfdy.a(bfdy.a(this.a), bfdy.b(this.a)))
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
            bgmg.a(nku.a(bfdy.a(this.a)) + bfdy.a(this.a));
            bfdy.a(this.a);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (bfdy.a(bfdy.a(this.a), bfdy.b(this.a)));
          bfdy.b(this.a);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          bfdy.a(this.a, paramString);
          return;
        }
      } while (bfdy.a(bfdy.a(this.a), bfdy.b(this.a)));
      bfdy.b(this.a);
      return;
    }
    bfdy.b(this.a);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdz
 * JD-Core Version:    0.7.0.1
 */