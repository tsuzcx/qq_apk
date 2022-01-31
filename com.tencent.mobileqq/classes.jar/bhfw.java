import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class bhfw
  implements bhga
{
  bhfw(bhfv parambhfv) {}
  
  public void a(int paramInt)
  {
    bhfv.a(this.a).h();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while (localPtvTemplateInfo == null);
    if (localPtvTemplateInfo.isWsBanner())
    {
      vnd.a(this.a.jdField_a_of_type_AndroidContentContext, localPtvTemplateInfo);
      return;
    }
    if (bhfv.a(this.a) == paramInt)
    {
      bhfv.jdField_d_of_type_Boolean = true;
      bhfv.a(this.a, paramInt);
      bhfv.jdField_c_of_type_Int = paramInt;
      bhfv.jdField_b_of_type_Int = localPtvTemplateInfo.categoryId;
      bhfv.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.id;
    }
    try
    {
      localJSONObject = new JSONObject();
      if (TextUtils.isEmpty(bhfv.jdField_b_of_type_JavaLangString)) {
        break label418;
      }
      if (!"0".equals(bhfv.jdField_b_of_type_JavaLangString)) {
        break label393;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label175:
        Object localObject;
        QLog.d("Q.videostory.capture", 1, "report failed");
        continue;
        String str = "empty";
      }
    }
    localJSONObject.put("lens_id", localObject);
    if (bhfv.jdField_b_of_type_Int != 0) {}
    for (localObject = Integer.valueOf(bhfv.jdField_b_of_type_Int);; localObject = "empty")
    {
      localJSONObject.put("lens_tab", localObject);
      localJSONObject.put("id_pos", bhfv.jdField_c_of_type_Int);
      wye.a("mystatus_shoot", "lens_select", 0, 0, new String[] { "", String.valueOf(ahhj.a), localJSONObject.toString() });
      QLog.d("Q.videostory.capture", 1, "change material result:" + localJSONObject.toString());
      ((bhlf)bhfm.a(14)).a(localPtvTemplateInfo.id, 3);
      if (!localPtvTemplateInfo.id.equals("0"))
      {
        bhfv.jdField_c_of_type_Boolean = true;
        if (!bhfv.jdField_d_of_type_Boolean) {
          bhfv.jdField_b_of_type_Boolean = false;
        }
        this.a.jdField_a_of_type_Bjin.a(localPtvTemplateInfo, 111);
      }
      this.a.a(null);
      if (!localPtvTemplateInfo.usable) {
        biyj.a("", "0X8006A1A");
      }
      ((bhgs)bhfm.a(5)).a(this.a.jdField_d_of_type_Int, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
      return;
      bhfv.jdField_d_of_type_Boolean = false;
      break;
      label393:
      localObject = bhfv.jdField_b_of_type_JavaLangString;
      break label175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhfw
 * JD-Core Version:    0.7.0.1
 */