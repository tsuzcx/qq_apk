import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aplf
  implements amgv
{
  private FileManagerEntity a;
  
  public aplf(FileManagerEntity paramFileManagerEntity)
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
        localJSONObject.put("file_color_note_peerType", this.a.peerType);
        localJSONObject.put("file_color_note_peerUin", this.a.peerUin);
        localJSONObject.put("file_color_note_uniSeq", this.a.uniseq);
        localJSONObject.put("file_color_note_sessionId", this.a.nSessionId);
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
      QLog.i("OfflineFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    amhb localamhb = new amhb();
    localamhb.a(17039360);
    String str = apvm.b(1, this.a.nSessionId + "");
    if (QLog.isColorLevel()) {
      QLog.i("OfflineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "] fileId[" + this.a.Uuid + "]");
    }
    localamhb.a(str);
    localamhb.b(this.a.fileName);
    localamhb.c(apvd.a(this.a.fileSize));
    int i = apug.a(apug.a(this.a.fileName));
    localamhb.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localamhb.a(str.getBytes());
    }
    return localamhb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplf
 * JD-Core Version:    0.7.0.1
 */