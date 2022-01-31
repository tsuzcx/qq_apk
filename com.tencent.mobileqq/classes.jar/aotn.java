import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aotn
  implements alsd
{
  private DataLineMsgRecord a;
  
  public aotn(DataLineMsgRecord paramDataLineMsgRecord)
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
    alsl localalsl = new alsl();
    localalsl.a(17039360);
    String str = apdq.b(6, this.a.sessionid + "");
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localalsl.a(str);
    localalsl.b(this.a.filename);
    localalsl.c(apdh.a(this.a.filesize));
    int i = apck.a(apck.a(this.a.filename));
    localalsl.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localalsl.a(str.getBytes());
    }
    return localalsl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotn
 * JD-Core Version:    0.7.0.1
 */