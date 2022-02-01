import com.tencent.open.virtual.OpenSdkVirtualManager.2;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bjzq
  extends bkaa
{
  public bjzq(OpenSdkVirtualManager.2 param2) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.deleteVirtual.result:", paramString1 });
    avcw.a("KEY_DELETE_VIRTUAL_D18", this.a.jdField_a_of_type_Bjzb, paramBoolean);
    int i = paramInt;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        i = new JSONObject(paramString1).optInt("ErrorCode");
        paramInt = i;
        i = paramInt;
        if (paramInt == 0)
        {
          paramBoolean = true;
          QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.deleteVirtual.result:", paramString1 });
          if (this.a.jdField_a_of_type_Bjpq != null) {
            this.a.jdField_a_of_type_Bjpq.a(paramBoolean, paramInt);
          }
          return;
        }
      }
      catch (Exception paramString2)
      {
        QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "Exception.e", paramString2);
        i = paramInt;
      }
      paramBoolean = false;
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjzq
 * JD-Core Version:    0.7.0.1
 */