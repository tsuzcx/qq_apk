import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class auex
  implements aqrn
{
  private bftf jdField_a_of_type_Bftf;
  private String jdField_a_of_type_JavaLangString;
  
  public auex(long paramLong, bftf parambftf)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Bftf = parambftf;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Bftf.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Bftf.c);
      if (this.jdField_a_of_type_Bftf.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Bftf.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Bftf.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Bftf.h);
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
    if (this.jdField_a_of_type_Bftf != null) {}
    aqrv localaqrv = new aqrv();
    localaqrv.a(17039360);
    String str = auoo.b(2, this.jdField_a_of_type_Bftf.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaqrv.a(str);
    localaqrv.b(this.jdField_a_of_type_Bftf.g);
    localaqrv.c(auog.a(this.jdField_a_of_type_Bftf.c));
    int i = aunj.a(aunj.a(this.jdField_a_of_type_Bftf.g));
    localaqrv.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaqrv.a(str.getBytes());
    }
    return localaqrv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auex
 * JD-Core Version:    0.7.0.1
 */