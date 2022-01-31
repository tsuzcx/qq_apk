import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class ayzn
  implements moc
{
  ayzn(ayzm paramayzm) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (ayzm.a(ayzm.a(this.a), ayzm.b(this.a)))
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
            bace.a(mol.a(ayzm.a(this.a)) + ayzm.a(this.a));
            ayzm.a(this.a);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (ayzm.a(ayzm.a(this.a), ayzm.b(this.a)));
          ayzm.b(this.a);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          ayzm.a(this.a, paramString);
          return;
        }
      } while (ayzm.a(ayzm.a(this.a), ayzm.b(this.a)));
      ayzm.b(this.a);
      return;
    }
    ayzm.b(this.a);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayzn
 * JD-Core Version:    0.7.0.1
 */