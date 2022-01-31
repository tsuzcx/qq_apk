import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class aotr
  implements alsd
{
  private ayqd jdField_a_of_type_Ayqd;
  private String jdField_a_of_type_JavaLangString;
  
  public aotr(long paramLong, ayqd paramayqd)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Ayqd = paramayqd;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Ayqd.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Ayqd.c);
      if (this.jdField_a_of_type_Ayqd.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Ayqd.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Ayqd.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Ayqd.h);
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
    if (this.jdField_a_of_type_Ayqd != null) {}
    alsl localalsl = new alsl();
    localalsl.a(17039360);
    String str = apdq.b(2, this.jdField_a_of_type_Ayqd.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localalsl.a(str);
    localalsl.b(this.jdField_a_of_type_Ayqd.g);
    localalsl.c(apdh.a(this.jdField_a_of_type_Ayqd.c));
    int i = apck.a(apck.a(this.jdField_a_of_type_Ayqd.g));
    localalsl.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localalsl.a(str.getBytes());
    }
    return localalsl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotr
 * JD-Core Version:    0.7.0.1
 */