import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class bfne
  extends bfnn
{
  bfne(bfna parambfna, bfmm parambfmm, bfnj parambfnj, String paramString, JSONObject paramJSONObject) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    bool2 = false;
    boolean bool3 = true;
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkVirtualManager", 2, new Object[] { "OpenVirtual.uploadAvatarImage.result:", bfnl.a(paramString1, this.jdField_a_of_type_Bfmm.jdField_a_of_type_JavaLangString) });
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
        bfna.a(this.jdField_a_of_type_Bfna);
        if (bfna.b(this.jdField_a_of_type_Bfna) < 2) {
          break;
        }
      } while ((this.jdField_a_of_type_Bfnj == null) || (this.jdField_a_of_type_Bfnj == null));
      this.jdField_a_of_type_Bfnj.a(bool1, this.jdField_a_of_type_JavaLangString, paramString2, i);
      return;
      bfna.a(this.jdField_a_of_type_Bfna, this.jdField_a_of_type_Bfmm, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Bfnj);
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
      if ((this.jdField_a_of_type_Bfnj != null) && (this.jdField_a_of_type_Bfnj != null)) {
        this.jdField_a_of_type_Bfnj.a(bool1, this.jdField_a_of_type_JavaLangString, paramString2, i);
      }
      return;
      paramInt = paramString1.optInt("uint32_ret_to_http", i);
      paramString1 = null;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfne
 * JD-Core Version:    0.7.0.1
 */