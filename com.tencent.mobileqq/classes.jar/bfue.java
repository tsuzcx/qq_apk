import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class bfue
  implements nuw
{
  bfue(bfud parambfud) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (bfud.a(bfud.a(this.a), bfud.b(this.a)))
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
            FileUtils.deleteDirectory(nvf.a(bfud.a(this.a)) + bfud.a(this.a));
            bfud.a(this.a);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (bfud.a(bfud.a(this.a), bfud.b(this.a)));
          bfud.b(this.a);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          bfud.a(this.a, paramString);
          return;
        }
      } while (bfud.a(bfud.a(this.a), bfud.b(this.a)));
      bfud.b(this.a);
      return;
    }
    bfud.b(this.a);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfue
 * JD-Core Version:    0.7.0.1
 */