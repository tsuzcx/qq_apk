import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class atvl
  implements aqoa
{
  private String a;
  
  public atvl(String paramString)
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
    aqoi localaqoi = new aqoi();
    localaqoi.a(17039360);
    String str = aufd.b(5, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("LocalFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqoi.a(str);
    str = auea.a(this.a);
    localaqoi.b(str);
    localaqoi.c(FileUtil.filesizeToString(auea.a(this.a)));
    int i = auea.a(auea.a(str));
    localaqoi.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaqoi.a(str.getBytes());
    }
    return localaqoi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvl
 * JD-Core Version:    0.7.0.1
 */