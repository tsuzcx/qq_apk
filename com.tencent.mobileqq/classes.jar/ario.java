import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class ario
  implements aocf
{
  private bbtn jdField_a_of_type_Bbtn;
  private String jdField_a_of_type_JavaLangString;
  
  public ario(long paramLong, bbtn parambbtn)
  {
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_Bbtn = parambbtn;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_Bbtn.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_Bbtn.c);
      if (this.jdField_a_of_type_Bbtn.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_Bbtn.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_Bbtn.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_Bbtn.h);
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
    if (this.jdField_a_of_type_Bbtn != null) {}
    aocl localaocl = new aocl();
    localaocl.a(17039360);
    String str = arsx.b(2, this.jdField_a_of_type_Bbtn.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localaocl.a(str);
    localaocl.b(this.jdField_a_of_type_Bbtn.g);
    localaocl.c(arso.a(this.jdField_a_of_type_Bbtn.c));
    int i = arrr.a(arrr.a(this.jdField_a_of_type_Bbtn.g));
    localaocl.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localaocl.a(str.getBytes());
    }
    return localaocl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ario
 * JD-Core Version:    0.7.0.1
 */