import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class asre
  implements apkw
{
  private String a;
  
  public asre(String paramString)
  {
    this.a = paramString;
    if (FileUtils.fileExistsAndNotEmpty(this.a)) {
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
    if (!FileUtils.fileExistsAndNotEmpty(this.a))
    {
      QLog.i("LocalFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    aple localaple = new aple();
    localaple.a(17039360);
    String str = ataw.b(5, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("LocalFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaple.a(str);
    str = aszt.a(this.a);
    localaple.b(str);
    localaple.c(FileUtil.filesizeToString(aszt.a(this.a)));
    int i = aszt.a(aszt.a(str));
    localaple.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaple.a(str.getBytes());
    }
    return localaple.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asre
 * JD-Core Version:    0.7.0.1
 */