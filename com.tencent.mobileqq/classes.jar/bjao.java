import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class bjao
  implements bjas
{
  bjao(bjan parambjan) {}
  
  public void a(int paramInt)
  {
    bjan.a(this.a).h();
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
      vzz.a(this.a.jdField_a_of_type_AndroidContentContext, localPtvTemplateInfo);
      return;
    }
    if (bjan.a(this.a) == paramInt)
    {
      bjan.jdField_c_of_type_Boolean = true;
      bjan.a(this.a, paramInt);
      bjan.jdField_c_of_type_Int = paramInt;
      bjan.jdField_b_of_type_Int = localPtvTemplateInfo.categoryId;
      bjan.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.id;
    }
    try
    {
      localJSONObject = new JSONObject();
      if (TextUtils.isEmpty(bjan.jdField_b_of_type_JavaLangString)) {
        break label418;
      }
      if (!"0".equals(bjan.jdField_b_of_type_JavaLangString)) {
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
    if (bjan.jdField_b_of_type_Int != 0) {}
    for (localObject = Integer.valueOf(bjan.jdField_b_of_type_Int);; localObject = "empty")
    {
      localJSONObject.put("lens_tab", localObject);
      localJSONObject.put("id_pos", bjan.jdField_c_of_type_Int);
      xhe.a("mystatus_shoot", "lens_select", 0, 0, new String[] { "", String.valueOf(ahua.a), localJSONObject.toString() });
      QLog.d("Q.videostory.capture", 1, "change material result:" + localJSONObject.toString());
      ((bjfx)bjae.a(14)).a(localPtvTemplateInfo.id, 3);
      if (!localPtvTemplateInfo.id.equals("0"))
      {
        bjan.jdField_b_of_type_Boolean = true;
        if (!bjan.jdField_c_of_type_Boolean) {
          bjan.jdField_a_of_type_Boolean = false;
        }
        this.a.jdField_a_of_type_Bkyy.a(localPtvTemplateInfo, 111);
      }
      this.a.a(null);
      if (!localPtvTemplateInfo.usable) {
        bkov.a("", "0X8006A1A");
      }
      ((bjbk)bjae.a(5)).a(this.a.d, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
      return;
      bjan.jdField_c_of_type_Boolean = false;
      break;
      label393:
      localObject = bjan.jdField_b_of_type_JavaLangString;
      break label175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjao
 * JD-Core Version:    0.7.0.1
 */