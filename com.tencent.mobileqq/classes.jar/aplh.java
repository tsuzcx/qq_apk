import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class aplh
  implements amgv
{
  private azqv jdField_a_of_type_Azqv;
  private String jdField_a_of_type_JavaLangString;
  
  public aplh(long paramLong, azqv paramazqv)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Azqv = paramazqv;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Azqv.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Azqv.c);
      if (this.jdField_a_of_type_Azqv.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Azqv.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Azqv.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Azqv.h);
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
    if (this.jdField_a_of_type_Azqv != null) {}
    amhb localamhb = new amhb();
    localamhb.a(17039360);
    String str = apvm.b(2, this.jdField_a_of_type_Azqv.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localamhb.a(str);
    localamhb.b(this.jdField_a_of_type_Azqv.g);
    localamhb.c(apvd.a(this.jdField_a_of_type_Azqv.c));
    int i = apug.a(apug.a(this.jdField_a_of_type_Azqv.g));
    localamhb.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localamhb.a(str.getBytes());
    }
    return localamhb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplh
 * JD-Core Version:    0.7.0.1
 */