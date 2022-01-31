import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class apld
  implements amgv
{
  private String a;
  
  public apld(String paramString)
  {
    this.a = paramString;
    if (bbdx.b(this.a)) {
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
    if (!bbdx.b(this.a))
    {
      QLog.i("FavFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    amhb localamhb = new amhb();
    localamhb.a(17039360);
    String str = apvm.b(4, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("FavFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localamhb.a(str);
    str = apug.a(this.a);
    localamhb.b(str);
    localamhb.c(apvd.a(apug.a(this.a)));
    int i = apug.a(apug.a(str));
    localamhb.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localamhb.a(str.getBytes());
    }
    return localamhb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apld
 * JD-Core Version:    0.7.0.1
 */