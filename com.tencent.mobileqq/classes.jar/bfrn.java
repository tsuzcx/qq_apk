import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class bfrn
  extends bfrw
{
  bfrn(bfrj parambfrj, bfqv parambfqv, bfrs parambfrs, String paramString, JSONObject paramJSONObject) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    bool2 = false;
    boolean bool3 = true;
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkVirtualManager", 2, new Object[] { "OpenVirtual.uploadAvatarImage.result:", bfru.a(paramString1, this.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) });
    }
    localObject = null;
    bool1 = bool2;
    paramString2 = localObject;
    i = paramInt;
    if (paramBoolean) {}
    try
    {
      paramString1 = new JSONObject(paramString1);
      i = paramString1.optInt("ErrorCode");
      if (i != 0) {}
    }
    catch (JSONException paramString1)
    {
      label102:
      do
      {
        for (;;)
        {
          QLog.d("OpenSdkVirtualManager", 1, "OpenVirtual.uploadAvatarImage.e:", paramString1);
          bool1 = bool2;
          paramString2 = localObject;
          i = paramInt;
        }
        bfrj.a(this.jdField_a_of_type_Bfrj);
        if (bfrj.b(this.jdField_a_of_type_Bfrj) < 2) {
          break;
        }
      } while ((this.jdField_a_of_type_Bfrs == null) || (this.jdField_a_of_type_Bfrs == null));
      this.jdField_a_of_type_Bfrs.a(bool1, this.jdField_a_of_type_JavaLangString, paramString2, i);
      return;
      bfrj.a(this.jdField_a_of_type_Bfrj, this.jdField_a_of_type_Bfqv, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Bfrs);
      return;
    }
    try
    {
      paramString1 = paramString1.optJSONObject("msg_img_data");
      if (paramString1 == null) {
        break label273;
      }
      paramString1 = paramString1.optString("str_file_name");
      paramBoolean = bool3;
    }
    catch (JSONException paramString1)
    {
      paramInt = i;
      break label168;
      paramBoolean = false;
      paramString1 = null;
      break label102;
    }
    paramInt = i;
    for (;;)
    {
      i = paramInt;
      paramString2 = paramString1;
      bool1 = paramBoolean;
      if (!bool1) {
        break;
      }
      if ((this.jdField_a_of_type_Bfrs != null) && (this.jdField_a_of_type_Bfrs != null)) {
        this.jdField_a_of_type_Bfrs.a(bool1, this.jdField_a_of_type_JavaLangString, paramString2, i);
      }
      return;
      paramInt = paramString1.optInt("uint32_ret_to_http", i);
      paramString1 = null;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfrn
 * JD-Core Version:    0.7.0.1
 */