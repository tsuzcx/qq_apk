import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class baqq
  extends QIPCModule
{
  public static baqq a;
  private baqs a;
  
  private baqq()
  {
    super("Module_CheckInServer");
  }
  
  public static baqq a()
  {
    if (jdField_a_of_type_Baqq == null) {}
    try
    {
      if (jdField_a_of_type_Baqq == null) {
        jdField_a_of_type_Baqq = new baqq();
      }
      return jdField_a_of_type_Baqq;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Baqs != null)
    {
      this.jdField_a_of_type_Baqs.d();
      this.jdField_a_of_type_Baqs = null;
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
    baqp localbaqp;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbaqp = new baqp();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbaqp.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new baqr(localbaqp, paramInt);
        this.jdField_a_of_type_Baqs = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbaqp.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbaqp.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbaqp.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new baqu(localbaqp, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baqq
 * JD-Core Version:    0.7.0.1
 */