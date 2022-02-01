import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class atvo
  implements aqoa
{
  private bfjs jdField_a_of_type_Bfjs;
  private String jdField_a_of_type_JavaLangString;
  
  public atvo(long paramLong, bfjs parambfjs)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Bfjs = parambfjs;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Bfjs.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Bfjs.c);
      if (this.jdField_a_of_type_Bfjs.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Bfjs.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Bfjs.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Bfjs.h);
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
    aqoi localaqoi = new aqoi();
    localaqoi.a(17039360);
    String str = aufd.b(2, this.jdField_a_of_type_Bfjs.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqoi.a(str);
    localaqoi.b(this.jdField_a_of_type_Bfjs.g);
    localaqoi.c(FileUtil.filesizeToString(this.jdField_a_of_type_Bfjs.c));
    int i = auea.a(auea.a(this.jdField_a_of_type_Bfjs.g));
    localaqoi.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaqoi.a(str.getBytes());
    }
    return localaqoi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvo
 * JD-Core Version:    0.7.0.1
 */