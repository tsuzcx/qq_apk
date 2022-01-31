import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bcpy
  extends QIPCModule
{
  public static bcpy a;
  private bcqa a;
  
  private bcpy()
  {
    super("Module_CheckInServer");
  }
  
  public static bcpy a()
  {
    if (jdField_a_of_type_Bcpy == null) {}
    try
    {
      if (jdField_a_of_type_Bcpy == null) {
        jdField_a_of_type_Bcpy = new bcpy();
      }
      return jdField_a_of_type_Bcpy;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bcqa != null)
    {
      this.jdField_a_of_type_Bcqa.d();
      this.jdField_a_of_type_Bcqa = null;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Module_CheckInServer", 2, "notifyUploadResult callbackId" + paramInt + ", data = " + paramBundle.toString());
    }
    paramBundle = EIPCResult.createResult(0, paramBundle);
    a();
    callbackResult(paramInt, paramBundle);
  }
  
  public void onAccountChange()
  {
    super.onAccountChange();
    a();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Module_CheckInServer", 2, "action = " + paramString + ", params = " + paramBundle + ",callbackId=" + paramInt);
    }
    a();
    bcpx localbcpx;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbcpx = new bcpx();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbcpx.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new bcpz(localbcpx, paramInt);
        this.jdField_a_of_type_Bcqa = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbcpx.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbcpx.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbcpx.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new bcqc(localbcpx, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpy
 * JD-Core Version:    0.7.0.1
 */