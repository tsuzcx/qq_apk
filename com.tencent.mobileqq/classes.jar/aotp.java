import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class aotp
  implements alsd
{
  private String a;
  
  public aotp(String paramString)
  {
    this.a = paramString;
    if (bace.b(this.a)) {
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
    if (!bace.b(this.a))
    {
      QLog.i("LocalFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    alsl localalsl = new alsl();
    localalsl.a(17039360);
    String str = apdq.b(5, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("LocalFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localalsl.a(str);
    str = apck.a(this.a);
    localalsl.b(str);
    localalsl.c(apdh.a(apck.a(this.a)));
    int i = apck.a(apck.a(str));
    localalsl.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localalsl.a(str.getBytes());
    }
    return localalsl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotp
 * JD-Core Version:    0.7.0.1
 */