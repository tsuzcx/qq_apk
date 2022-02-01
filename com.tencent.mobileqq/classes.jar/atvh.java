import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class atvh
  implements aqoa
{
  private FileManagerEntity a;
  
  public atvh(FileManagerEntity paramFileManagerEntity)
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
    aqoi localaqoi = new aqoi();
    localaqoi.a(17039360);
    String str = aufd.b(3, this.a.nSessionId + this.a.WeiYunFileId);
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqoi.a(str);
    localaqoi.b(this.a.fileName);
    localaqoi.c(FileUtil.filesizeToString(this.a.fileSize));
    int i = auea.a(auea.a(this.a.fileName));
    localaqoi.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaqoi.a(str.getBytes());
    }
    return localaqoi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvh
 * JD-Core Version:    0.7.0.1
 */