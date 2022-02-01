import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bgqw
  extends QIPCModule
{
  public static bgqw a;
  private bgqy a;
  
  private bgqw()
  {
    super("Module_CheckInServer");
  }
  
  public static bgqw a()
  {
    if (jdField_a_of_type_Bgqw == null) {}
    try
    {
      if (jdField_a_of_type_Bgqw == null) {
        jdField_a_of_type_Bgqw = new bgqw();
      }
      return jdField_a_of_type_Bgqw;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bgqy != null)
    {
      this.jdField_a_of_type_Bgqy.d();
      this.jdField_a_of_type_Bgqy = null;
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
    bgqv localbgqv;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbgqv = new bgqv();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbgqv.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new bgqx(localbgqv, paramInt);
        this.jdField_a_of_type_Bgqy = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbgqv.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbgqv.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbgqv.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new bgra(localbgqv, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgqw
 * JD-Core Version:    0.7.0.1
 */