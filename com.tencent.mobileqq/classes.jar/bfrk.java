import com.tencent.open.model.CreateVirtualResult;
import com.tencent.open.virtual.OpenSdkVirtualManager.1;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bfrk
  extends bfrw
{
  public bfrk(OpenSdkVirtualManager.1 param1) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    int j = 1;
    QLog.d("OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createVirtual.result:", bfru.a(paramString1, this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) });
    aseh.a("KEY_CREATE_VIRTUAL_D17", this.a.jdField_a_of_type_Bfqv, paramBoolean);
    paramString2 = new CreateVirtualResult();
    int i;
    if (paramBoolean) {
      i = paramInt;
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = paramInt;
        paramInt = paramString1.optInt("ErrorCode");
        if (paramInt == 0)
        {
          i = paramInt;
          paramString2.jdField_a_of_type_Long = paramString1.optLong("uint64_vuid");
          i = paramInt;
          paramString2.jdField_a_of_type_JavaLangString = paramString1.optString("str_head_url");
        }
      }
      catch (JSONException paramString1)
      {
        j = 0;
        paramInt = i;
        i = j;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenSdkVirtualManager", 2, new Object[] { "OpenVirtual.createResult=", bfru.a(paramString2.toString(), this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) });
        }
        if (this.a.jdField_a_of_type_Bfrs != null) {
          this.a.jdField_a_of_type_Bfrs.a(true, paramString2, paramInt);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          i = j;
        }
      }
      i = 0;
      if ((i == 0) && (this.a.jdField_a_of_type_Bfrs != null))
      {
        this.a.jdField_a_of_type_Bfrs.a(false, null, paramInt);
        return;
        QLog.d("OpenSdkVirtualManager", 2, "OpenVirtual.createVirtual.e:", paramString1);
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfrk
 * JD-Core Version:    0.7.0.1
 */