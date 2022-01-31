import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bcuh
  extends QIPCModule
{
  public static bcuh a;
  private bcuj a;
  
  private bcuh()
  {
    super("Module_CheckInServer");
  }
  
  public static bcuh a()
  {
    if (jdField_a_of_type_Bcuh == null) {}
    try
    {
      if (jdField_a_of_type_Bcuh == null) {
        jdField_a_of_type_Bcuh = new bcuh();
      }
      return jdField_a_of_type_Bcuh;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bcuj != null)
    {
      this.jdField_a_of_type_Bcuj.d();
      this.jdField_a_of_type_Bcuj = null;
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
    bcug localbcug;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbcug = new bcug();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbcug.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new bcui(localbcug, paramInt);
        this.jdField_a_of_type_Bcuj = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbcug.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbcug.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbcug.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new bcul(localbcug, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuh
 * JD-Core Version:    0.7.0.1
 */