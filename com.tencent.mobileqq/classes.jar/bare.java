import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bare
  extends QIPCModule
{
  public static bare a;
  private barg a;
  
  private bare()
  {
    super("Module_CheckInServer");
  }
  
  public static bare a()
  {
    if (jdField_a_of_type_Bare == null) {}
    try
    {
      if (jdField_a_of_type_Bare == null) {
        jdField_a_of_type_Bare = new bare();
      }
      return jdField_a_of_type_Bare;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Barg != null)
    {
      this.jdField_a_of_type_Barg.d();
      this.jdField_a_of_type_Barg = null;
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
    bard localbard;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbard = new bard();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbard.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new barf(localbard, paramInt);
        this.jdField_a_of_type_Barg = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbard.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbard.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbard.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new bari(localbard, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bare
 * JD-Core Version:    0.7.0.1
 */