import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class bbzc
  implements nbs
{
  bbzc(bbzb parambbzb) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (bbzb.a(bbzb.a(this.a), bbzb.b(this.a)))
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
            bdcs.a(ncb.a(bbzb.a(this.a)) + bbzb.a(this.a));
            bbzb.a(this.a);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (bbzb.a(bbzb.a(this.a), bbzb.b(this.a)));
          bbzb.b(this.a);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          bbzb.a(this.a, paramString);
          return;
        }
      } while (bbzb.a(bbzb.a(this.a), bbzb.b(this.a)));
      bbzb.b(this.a);
      return;
    }
    bbzb.b(this.a);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzc
 * JD-Core Version:    0.7.0.1
 */