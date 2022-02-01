import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class asrh
  implements apkw
{
  private becp jdField_a_of_type_Becp;
  private String jdField_a_of_type_JavaLangString;
  
  public asrh(long paramLong, becp parambecp)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Becp = parambecp;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Becp.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Becp.c);
      if (this.jdField_a_of_type_Becp.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Becp.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Becp.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Becp.h);
        return localJSONObject.toString();
        localJSONObject.put("file_color_note_file_uuid", "");
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public ColorNote getColorNote()
  {
    aple localaple = new aple();
    localaple.a(17039360);
    String str = ataw.b(2, this.jdField_a_of_type_Becp.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaple.a(str);
    localaple.b(this.jdField_a_of_type_Becp.g);
    localaple.c(FileUtil.filesizeToString(this.jdField_a_of_type_Becp.c));
    int i = aszt.a(aszt.a(this.jdField_a_of_type_Becp.g));
    localaple.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaple.a(str.getBytes());
    }
    return localaple.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrh
 * JD-Core Version:    0.7.0.1
 */