import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class apkz
  implements amgw
{
  private String a;
  
  public apkz(String paramString)
  {
    this.a = paramString;
    if (bbdj.b(this.a)) {
      this.a = new File(this.a).getAbsolutePath();
    }
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("file_color_note_local_path", this.a);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (!bbdj.b(this.a))
    {
      QLog.i("FavFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    amhc localamhc = new amhc();
    localamhc.a(17039360);
    String str = apvk.b(4, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("FavFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localamhc.a(str);
    str = apue.a(this.a);
    localamhc.b(str);
    localamhc.c(apvb.a(apue.a(this.a)));
    int i = apue.a(apue.a(str));
    localamhc.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localamhc.a(str.getBytes());
    }
    return localamhc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apkz
 * JD-Core Version:    0.7.0.1
 */