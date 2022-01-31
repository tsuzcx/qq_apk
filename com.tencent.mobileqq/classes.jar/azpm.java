import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class azpm
  extends QIPCModule
{
  public static azpm a;
  private azpo a;
  
  private azpm()
  {
    super("Module_CheckInServer");
  }
  
  public static azpm a()
  {
    if (jdField_a_of_type_Azpm == null) {}
    try
    {
      if (jdField_a_of_type_Azpm == null) {
        jdField_a_of_type_Azpm = new azpm();
      }
      return jdField_a_of_type_Azpm;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Azpo != null)
    {
      this.jdField_a_of_type_Azpo.d();
      this.jdField_a_of_type_Azpo = null;
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
    azpl localazpl;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localazpl = new azpl();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localazpl.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new azpn(localazpl, paramInt);
        this.jdField_a_of_type_Azpo = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localazpl.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localazpl.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localazpl.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new azpq(localazpl, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azpm
 * JD-Core Version:    0.7.0.1
 */