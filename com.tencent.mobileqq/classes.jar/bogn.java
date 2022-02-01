import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class bogn
  implements bogr
{
  bogn(bogm parambogm) {}
  
  public void a(int paramInt)
  {
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
      zfn.a(this.a.jdField_a_of_type_AndroidContentContext, localPtvTemplateInfo);
      return;
    }
    if (bogm.a(this.a) == paramInt)
    {
      bogm.jdField_c_of_type_Boolean = true;
      bogm.a(this.a, paramInt);
      bogm.jdField_c_of_type_Int = paramInt;
      bogm.jdField_b_of_type_Int = localPtvTemplateInfo.categoryId;
      bogm.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.id;
    }
    try
    {
      localJSONObject = new JSONObject();
      if (TextUtils.isEmpty(bogm.jdField_b_of_type_JavaLangString)) {
        break label406;
      }
      if (!"0".equals(bogm.jdField_b_of_type_JavaLangString)) {
        break label381;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label163:
        Object localObject;
        QLog.d("Q.videostory.capture", 1, "report failed");
        continue;
        String str = "empty";
      }
    }
    localJSONObject.put("lens_id", localObject);
    if (bogm.jdField_b_of_type_Int != 0) {}
    for (localObject = Integer.valueOf(bogm.jdField_b_of_type_Int);; localObject = "empty")
    {
      localJSONObject.put("lens_tab", localObject);
      localJSONObject.put("id_pos", bogm.jdField_c_of_type_Int);
      aanb.a("mystatus_shoot", "lens_select", 0, 0, new String[] { "", String.valueOf(alps.a), localJSONObject.toString() });
      QLog.d("Q.videostory.capture", 1, "change material result:" + localJSONObject.toString());
      ((boki)bogd.a(14)).a(localPtvTemplateInfo.id, 3);
      if (!localPtvTemplateInfo.id.equals("0"))
      {
        bogm.jdField_b_of_type_Boolean = true;
        if (!bogm.jdField_c_of_type_Boolean) {
          bogm.jdField_a_of_type_Boolean = false;
        }
        this.a.jdField_a_of_type_Bpqs.a(localPtvTemplateInfo, 111);
      }
      this.a.a(null);
      if (!localPtvTemplateInfo.usable) {
        bpia.a("", "0X8006A1A");
      }
      ((bohj)bogd.a(5)).a(this.a.d, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
      return;
      bogm.jdField_c_of_type_Boolean = false;
      break;
      label381:
      localObject = bogm.jdField_b_of_type_JavaLangString;
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogn
 * JD-Core Version:    0.7.0.1
 */