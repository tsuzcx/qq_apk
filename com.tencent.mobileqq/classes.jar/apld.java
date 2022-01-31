import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class apld
  implements amgw
{
  private azqt jdField_a_of_type_Azqt;
  private String jdField_a_of_type_JavaLangString;
  
  public apld(long paramLong, azqt paramazqt)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Azqt = paramazqt;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Azqt.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Azqt.c);
      if (this.jdField_a_of_type_Azqt.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Azqt.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Azqt.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Azqt.h);
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
    if (this.jdField_a_of_type_Azqt != null) {}
    amhc localamhc = new amhc();
    localamhc.a(17039360);
    String str = apvk.b(2, this.jdField_a_of_type_Azqt.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localamhc.a(str);
    localamhc.b(this.jdField_a_of_type_Azqt.g);
    localamhc.c(apvb.a(this.jdField_a_of_type_Azqt.c));
    int i = apue.a(apue.a(this.jdField_a_of_type_Azqt.g));
    localamhc.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localamhc.a(str.getBytes());
    }
    return localamhc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apld
 * JD-Core Version:    0.7.0.1
 */