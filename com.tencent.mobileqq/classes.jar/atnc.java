import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class atnc
  implements aqck
{
  private bety jdField_a_of_type_Bety;
  private String jdField_a_of_type_JavaLangString;
  
  public atnc(long paramLong, bety parambety)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Bety = parambety;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Bety.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Bety.c);
      if (this.jdField_a_of_type_Bety.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Bety.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Bety.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Bety.h);
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
    if (this.jdField_a_of_type_Bety != null) {}
    aqcs localaqcs = new aqcs();
    localaqcs.a(17039360);
    String str = atwt.b(2, this.jdField_a_of_type_Bety.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqcs.a(str);
    localaqcs.b(this.jdField_a_of_type_Bety.g);
    localaqcs.c(atwl.a(this.jdField_a_of_type_Bety.c));
    int i = atvo.a(atvo.a(this.jdField_a_of_type_Bety.g));
    localaqcs.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaqcs.a(str.getBytes());
    }
    return localaqcs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnc
 * JD-Core Version:    0.7.0.1
 */