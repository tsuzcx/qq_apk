import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aplb
  implements amgv
{
  private DataLineMsgRecord a;
  
  public aplb(DataLineMsgRecord paramDataLineMsgRecord)
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
    amhb localamhb = new amhb();
    localamhb.a(17039360);
    String str = apvm.b(6, this.a.sessionid + "");
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localamhb.a(str);
    localamhb.b(this.a.filename);
    localamhb.c(apvd.a(this.a.filesize));
    int i = apug.a(apug.a(this.a.filename));
    localamhb.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localamhb.a(str.getBytes());
    }
    return localamhb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplb
 * JD-Core Version:    0.7.0.1
 */