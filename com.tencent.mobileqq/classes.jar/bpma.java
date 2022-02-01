import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class bpma
  implements bpme
{
  bpma(bplz parambplz) {}
  
  public void a(int paramInt)
  {
    bplz.a(this.a).h();
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
      zqd.a(this.a.jdField_a_of_type_AndroidContentContext, localPtvTemplateInfo);
      return;
    }
    if (bplz.a(this.a) == paramInt)
    {
      bplz.jdField_c_of_type_Boolean = true;
      bplz.a(this.a, paramInt);
      bplz.jdField_c_of_type_Int = paramInt;
      bplz.jdField_b_of_type_Int = localPtvTemplateInfo.categoryId;
      bplz.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.id;
    }
    try
    {
      localJSONObject = new JSONObject();
      if (TextUtils.isEmpty(bplz.jdField_b_of_type_JavaLangString)) {
        break label418;
      }
      if (!"0".equals(bplz.jdField_b_of_type_JavaLangString)) {
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
    if (bplz.jdField_b_of_type_Int != 0) {}
    for (localObject = Integer.valueOf(bplz.jdField_b_of_type_Int);; localObject = "empty")
    {
      localJSONObject.put("lens_tab", localObject);
      localJSONObject.put("id_pos", bplz.jdField_c_of_type_Int);
      abbe.a("mystatus_shoot", "lens_select", 0, 0, new String[] { "", String.valueOf(aluf.a), localJSONObject.toString() });
      QLog.d("Q.videostory.capture", 1, "change material result:" + localJSONObject.toString());
      ((bprk)bplq.a(14)).a(localPtvTemplateInfo.id, 3);
      if (!localPtvTemplateInfo.id.equals("0"))
      {
        bplz.jdField_b_of_type_Boolean = true;
        if (!bplz.jdField_c_of_type_Boolean) {
          bplz.jdField_a_of_type_Boolean = false;
        }
        this.a.jdField_a_of_type_Brhn.a(localPtvTemplateInfo, 111);
      }
      this.a.a(null);
      if (!localPtvTemplateInfo.usable) {
        bqyg.a("", "0X8006A1A");
      }
      ((bpmw)bplq.a(5)).a(this.a.d, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
      return;
      bplz.jdField_c_of_type_Boolean = false;
      break;
      label393:
      localObject = bplz.jdField_b_of_type_JavaLangString;
      break label175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpma
 * JD-Core Version:    0.7.0.1
 */