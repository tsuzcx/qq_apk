import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class arec
  implements anxw
{
  private String a;
  
  public arec(String paramString)
  {
    this.a = paramString;
    if (bdcs.b(this.a)) {
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
    if (!bdcs.b(this.a))
    {
      QLog.i("LocalFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    anyc localanyc = new anyc();
    localanyc.a(17039360);
    String str = aroo.b(5, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("LocalFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localanyc.a(str);
    str = arni.a(this.a);
    localanyc.b(str);
    localanyc.c(arof.a(arni.a(this.a)));
    int i = arni.a(arni.a(str));
    localanyc.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localanyc.a(str.getBytes());
    }
    return localanyc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arec
 * JD-Core Version:    0.7.0.1
 */