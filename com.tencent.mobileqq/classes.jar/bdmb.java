import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bdmb
  extends bdmp
{
  bdmc jdField_a_of_type_Bdmc;
  
  public bdmb(bdlr parambdlr, Activity paramActivity, bdmc parambdmc)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bdmc = parambdmc;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bdmo.a())
      {
        this.jdField_a_of_type_Bdlr.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bdlr.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bdmc.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bdlr.a(this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bdmc.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bdmc.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bdlr.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bdlr.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bdjr.a(this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle.getString(bdlb.i), "NEWYYB");
            bdjr.a("311", paramBoolean, this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle.getString(bdlb.b));
            Context localContext = bcyb.a().a();
            if (localContext != null) {
              bdjr.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle.getString(bdlb.b));
            }
          }
          if ((this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf != null) && (this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf.isShowing())) {
            this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf.dismiss();
          }
          return;
          this.jdField_a_of_type_Bdlr.e = true;
          if (this.jdField_a_of_type_Bdlr.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bdlr.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bdlr.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bdii.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bdlr.b(this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bdmc.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bdmc.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bdlr.b(this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bdlr.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bdlr.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdmb
 * JD-Core Version:    0.7.0.1
 */