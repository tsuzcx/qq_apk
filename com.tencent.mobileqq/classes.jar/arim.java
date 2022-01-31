import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arim
  implements aocf
{
  private FileManagerEntity a;
  
  public arim(FileManagerEntity paramFileManagerEntity)
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
    aocl localaocl = new aocl();
    localaocl.a(17039360);
    String str = arsx.b(1, this.a.nSessionId + "");
    if (QLog.isColorLevel()) {
      QLog.i("OfflineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "] fileId[" + this.a.Uuid + "]");
    }
    localaocl.a(str);
    localaocl.b(this.a.fileName);
    localaocl.c(arso.a(this.a.fileSize));
    int i = arrr.a(arrr.a(this.a.fileName));
    localaocl.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaocl.a(str.getBytes());
    }
    return localaocl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arim
 * JD-Core Version:    0.7.0.1
 */