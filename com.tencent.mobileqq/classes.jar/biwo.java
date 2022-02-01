import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class biwo
  extends bixc
{
  biwp jdField_a_of_type_Biwp;
  
  public biwo(biwe parambiwe, Activity paramActivity, biwp parambiwp)
  {
    super(paramActivity);
    this.jdField_a_of_type_Biwp = parambiwp;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bixb.a())
      {
        this.jdField_a_of_type_Biwe.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Biwe.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Biwp.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Biwe.a(this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Biwp.jdField_a_of_type_Boolean, this.jdField_a_of_type_Biwp.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Biwe.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Biwe.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = biuh.a(this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidOsBundle.getString(bivp.i), "NEWYYB");
            biuh.a("311", paramBoolean, this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidOsBundle.getString(bivp.b));
            Context localContext = biip.a().a();
            if (localContext != null) {
              biuh.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidOsBundle.getString(bivp.b));
            }
          }
          if ((this.jdField_a_of_type_Biwe.jdField_a_of_type_Biws != null) && (this.jdField_a_of_type_Biwe.jdField_a_of_type_Biws.isShowing())) {
            this.jdField_a_of_type_Biwe.jdField_a_of_type_Biws.dismiss();
          }
          return;
          this.jdField_a_of_type_Biwe.e = true;
          if (this.jdField_a_of_type_Biwe.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Biwe.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Biwe.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bisy.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Biwe.b(this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Biwp.jdField_a_of_type_Boolean, this.jdField_a_of_type_Biwp.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Biwe.b(this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Biwe.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Biwe.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Biwp.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biwo
 * JD-Core Version:    0.7.0.1
 */