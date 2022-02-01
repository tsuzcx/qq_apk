import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import org.json.JSONObject;

class bntc
  implements bntd
{
  bntc(bntb parambntb) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      JSONObject localJSONObject = this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.a.a.jdField_a_of_type_Bnsz.c, this.a.a.jdField_a_of_type_Int, this.a.a.b, "uploaded", this.a.a.jdField_a_of_type_JavaLangString, 0);
      try
      {
        localJSONObject.put("result", 0);
        localJSONObject.put("progress", 1.0D);
        localJSONObject.put("coverurl", paramString);
        QLog.e("TroopHWJsPlugin", 2, "upload thumb success:" + localJSONObject.toString());
        this.a.a.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.callJs(this.a.a.jdField_a_of_type_Bnsz.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntc
 * JD-Core Version:    0.7.0.1
 */