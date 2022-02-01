import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bfif
  extends QIPCModule
{
  public static bfif a;
  private bfih a;
  
  private bfif()
  {
    super("Module_CheckInServer");
  }
  
  public static bfif a()
  {
    if (jdField_a_of_type_Bfif == null) {}
    try
    {
      if (jdField_a_of_type_Bfif == null) {
        jdField_a_of_type_Bfif = new bfif();
      }
      return jdField_a_of_type_Bfif;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bfih != null)
    {
      this.jdField_a_of_type_Bfih.d();
      this.jdField_a_of_type_Bfih = null;
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
    bfie localbfie;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbfie = new bfie();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbfie.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new bfig(localbfie, paramInt);
        this.jdField_a_of_type_Bfih = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbfie.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbfie.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbfie.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new bfij(localbfie, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfif
 * JD-Core Version:    0.7.0.1
 */