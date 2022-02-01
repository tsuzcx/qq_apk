import android.text.TextUtils;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class axbl
{
  public int a;
  public MedalInfo a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  
  public axbl()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.strResJson);
        localJSONObject = null;
        i = localJSONArray.length();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevelCount <= 1) || (i <= this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel)) {
          continue;
        }
        localJSONObject = localJSONArray.getJSONObject(this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel);
        if ((localJSONObject != null) && (localJSONObject.has("owned3d"))) {
          this.jdField_a_of_type_JavaLangString = MedalWallMng.a(localJSONObject.getString("owned3d"));
        }
        if ((localJSONObject != null) && (localJSONObject.has("share"))) {
          this.c = MedalWallMng.a(localJSONObject.getString("share"));
        }
      }
      catch (Exception localException)
      {
        JSONArray localJSONArray;
        JSONObject localJSONObject;
        int i;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, "parse res json fail", localException);
        continue;
        if (this.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (!bhmi.b(this.b)) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        continue;
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.b))) {
        this.b = (MedalWallMng.b + bjtz.d(this.jdField_a_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_Int != 2) {
        continue;
      }
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
      if (i > 1) {
        localJSONObject = localJSONArray.getJSONObject(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbl
 * JD-Core Version:    0.7.0.1
 */