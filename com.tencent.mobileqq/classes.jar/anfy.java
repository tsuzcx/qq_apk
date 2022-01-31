import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry;
import org.json.JSONObject;

class anfy
  implements angb
{
  anfy(anfx paramanfx) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      JSONObject localJSONObject = this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.a.a.jdField_a_of_type_Anfw.c, this.a.a.jdField_a_of_type_Int, this.a.a.b, "uploaded", this.a.a.jdField_a_of_type_JavaLangString, 0);
      try
      {
        localJSONObject.put("result", 0);
        localJSONObject.put("progress", 1.0D);
        localJSONObject.put("coverurl", paramString);
        QLog.e("TroopHWJsPlugin", 2, "upload thumb success:" + localJSONObject.toString());
        this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.a.a.jdField_a_of_type_Anfw.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("TroopHWJsPlugin", 2, "upload thumb exception:", paramString);
        return;
      }
    }
    QLog.e("TroopHWJsPlugin", 1, "upload thumb failed!");
    this.a.b(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfy
 * JD-Core Version:    0.7.0.1
 */