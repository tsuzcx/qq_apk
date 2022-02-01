import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class bgyt
  extends QIPCModule
{
  public static bgyt a;
  private bgyv a;
  
  private bgyt()
  {
    super("Module_CheckInServer");
  }
  
  public static bgyt a()
  {
    if (jdField_a_of_type_Bgyt == null) {}
    try
    {
      if (jdField_a_of_type_Bgyt == null) {
        jdField_a_of_type_Bgyt = new bgyt();
      }
      return jdField_a_of_type_Bgyt;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bgyv != null)
    {
      this.jdField_a_of_type_Bgyv.d();
      this.jdField_a_of_type_Bgyv = null;
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
    bgys localbgys;
    if (("ACTION_UPLOAD_PIC".equals(paramString)) || ("ACTION_UPLOAD_VIDEO".equals(paramString)))
    {
      localbgys = new bgys();
      if ("ACTION_UPLOAD_PIC".equals(paramString))
      {
        localbgys.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
        paramString = new bgyu(localbgys, paramInt);
        this.jdField_a_of_type_Bgyv = paramString;
        paramString.a();
      }
    }
    for (;;)
    {
      return null;
      localbgys.jdField_a_of_type_JavaLangString = paramBundle.getString("BUNDLE_NAME_FILEPATH");
      localbgys.b = paramBundle.getString("BUNDLE_NAME_COVER");
      localbgys.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_NAME_VIDEOTIME");
      paramString = new bgyx(localbgys, paramInt);
      break;
      if ("ACTION_CANCEL".equals(paramString)) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyt
 * JD-Core Version:    0.7.0.1
 */