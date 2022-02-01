import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class aueu
  implements aqrn
{
  private String a;
  
  public aueu(String paramString)
  {
    this.a = paramString;
    if (bhmi.b(this.a)) {
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
    if (!bhmi.b(this.a))
    {
      QLog.i("LocalFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    aqrv localaqrv = new aqrv();
    localaqrv.a(17039360);
    String str = auoo.b(5, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("LocalFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqrv.a(str);
    str = aunj.a(this.a);
    localaqrv.b(str);
    localaqrv.c(auog.a(aunj.a(this.a)));
    int i = aunj.a(aunj.a(str));
    localaqrv.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaqrv.a(str.getBytes());
    }
    return localaqrv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aueu
 * JD-Core Version:    0.7.0.1
 */