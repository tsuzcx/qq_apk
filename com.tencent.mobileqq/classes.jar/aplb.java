import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aplb
  implements amgw
{
  private FileManagerEntity a;
  
  public aplb(FileManagerEntity paramFileManagerEntity)
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
    amhc localamhc = new amhc();
    localamhc.a(17039360);
    String str = apvk.b(1, this.a.nSessionId + "");
    if (QLog.isColorLevel()) {
      QLog.i("OfflineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "] fileId[" + this.a.Uuid + "]");
    }
    localamhc.a(str);
    localamhc.b(this.a.fileName);
    localamhc.c(apvb.a(this.a.fileSize));
    int i = apue.a(apue.a(this.a.fileName));
    localamhc.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localamhc.a(str.getBytes());
    }
    return localamhc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplb
 * JD-Core Version:    0.7.0.1
 */