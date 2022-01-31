import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class aref
  implements anxw
{
  private bbpe jdField_a_of_type_Bbpe;
  private String jdField_a_of_type_JavaLangString;
  
  public aref(long paramLong, bbpe parambbpe)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Bbpe = parambbpe;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Bbpe.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Bbpe.c);
      if (this.jdField_a_of_type_Bbpe.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Bbpe.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Bbpe.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Bbpe.h);
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
    if (this.jdField_a_of_type_Bbpe != null) {}
    anyc localanyc = new anyc();
    localanyc.a(17039360);
    String str = aroo.b(2, this.jdField_a_of_type_Bbpe.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localanyc.a(str);
    localanyc.b(this.jdField_a_of_type_Bbpe.g);
    localanyc.c(arof.a(this.jdField_a_of_type_Bbpe.c));
    int i = arni.a(arni.a(this.jdField_a_of_type_Bbpe.g));
    localanyc.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localanyc.a(str.getBytes());
    }
    return localanyc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aref
 * JD-Core Version:    0.7.0.1
 */