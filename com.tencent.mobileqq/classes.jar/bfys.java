import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bfys
  extends QIPCModule
{
  public static bfys a;
  private bfyu a;
  
  private bfys()
  {
    super("Module_CheckInServer");
  }
  
  public static bfys a()
  {
    if (jdField_a_of_type_Bfys == null) {}
    try
    {
      if (jdField_a_of_type_Bfys == null) {
        jdField_a_of_type_Bfys = new bfys();
      }
      return jdField_a_of_type_Bfys;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bfyu != null)
    {
      this.jdField_a_of_type_Bfyu.d();
      this.jdField_a_of_type_Bfyu = null;
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
    bfyr localbfyr;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbfyr = new bfyr();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbfyr.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new bfyt(localbfyr, paramInt);
        this.jdField_a_of_type_Bfyu = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbfyr.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbfyr.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbfyr.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new bfyw(localbfyr, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfys
 * JD-Core Version:    0.7.0.1
 */