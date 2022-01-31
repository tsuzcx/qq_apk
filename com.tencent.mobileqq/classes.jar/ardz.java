import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ardz
  implements anxw
{
  private DataLineMsgRecord a;
  
  public ardz(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.a = paramDataLineMsgRecord;
  }
  
  private String a()
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.a != null)
      {
        localJSONObject.put("file_color_note_uniSeq", this.a.sessionid);
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
      QLog.i("DatalineFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    anyc localanyc = new anyc();
    localanyc.a(17039360);
    String str = aroo.b(6, this.a.sessionid + "");
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localanyc.a(str);
    localanyc.b(this.a.filename);
    localanyc.c(arof.a(this.a.filesize));
    int i = arni.a(arni.a(this.a.filename));
    localanyc.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localanyc.a(str.getBytes());
    }
    return localanyc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardz
 * JD-Core Version:    0.7.0.1
 */