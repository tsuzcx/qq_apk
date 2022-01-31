import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class arik
  implements aocf
{
  private String a;
  
  public arik(String paramString)
  {
    this.a = paramString;
    if (bdhb.b(this.a)) {
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
    if (!bdhb.b(this.a))
    {
      QLog.i("FavFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    aocl localaocl = new aocl();
    localaocl.a(17039360);
    String str = arsx.b(4, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("FavFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaocl.a(str);
    str = arrr.a(this.a);
    localaocl.b(str);
    localaocl.c(arso.a(arrr.a(this.a)));
    int i = arrr.a(arrr.a(str));
    localaocl.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaocl.a(str.getBytes());
    }
    return localaocl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arik
 * JD-Core Version:    0.7.0.1
 */