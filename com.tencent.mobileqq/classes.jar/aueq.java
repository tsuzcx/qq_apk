import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aueq
  implements aqrn
{
  private FileManagerEntity a;
  
  public aueq(FileManagerEntity paramFileManagerEntity)
  {
    this.a = paramFileManagerEntity;
  }
  
  private String a()
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.a != null)
      {
        localJSONObject.put("file_color_note_sessionId", this.a.nSessionId);
        localJSONObject.put("file_color_note_cloud_lastTime", this.a.lastTime);
        localJSONObject.put("file_color_note_cloud_fileId", this.a.WeiYunFileId);
        localJSONObject.put("file_color_note_fileName", this.a.fileName);
        localJSONObject.put("file_color_note_fileSize", this.a.fileSize);
        localJSONObject.put("file_color_note_cloud_srcType", this.a.nWeiYunSrcType);
        localJSONObject.put("file_color_note_cloud_encodeUrl", this.a.strLargeThumPath);
        localJSONObject.put("file_color_note_cloud_dirKey", this.a.WeiYunDirKey);
        localJSONObject.put("file_color_note_cloud_", this.a.strFileMd5);
        localJSONObject.put("file_color_note_cloud_", this.a.strFileSHA);
        str = localJSONObject.toString();
      }
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (this.a == null)
    {
      QLog.i("CloudFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    aqrv localaqrv = new aqrv();
    localaqrv.a(17039360);
    String str = auoo.b(3, this.a.nSessionId + this.a.WeiYunFileId);
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqrv.a(str);
    localaqrv.b(this.a.fileName);
    localaqrv.c(auog.a(this.a.fileSize));
    int i = aunj.a(aunj.a(this.a.fileName));
    localaqrv.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaqrv.a(str.getBytes());
    }
    return localaqrv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aueq
 * JD-Core Version:    0.7.0.1
 */