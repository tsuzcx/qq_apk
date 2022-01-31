import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bdlm
  extends bdma
{
  bdln jdField_a_of_type_Bdln;
  
  public bdlm(bdlc parambdlc, Activity paramActivity, bdln parambdln)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bdln = parambdln;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bdlz.a())
      {
        this.jdField_a_of_type_Bdlc.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bdlc.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bdln.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bdlc.a(this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bdln.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bdln.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bdlc.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bdlc.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bdjc.a(this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle.getString(bdkm.i), "NEWYYB");
            bdjc.a("311", paramBoolean, this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle.getString(bdkm.b));
            Context localContext = bcxm.a().a();
            if (localContext != null) {
              bdjc.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle.getString(bdkm.b));
            }
          }
          if ((this.jdField_a_of_type_Bdlc.jdField_a_of_type_Bdlq != null) && (this.jdField_a_of_type_Bdlc.jdField_a_of_type_Bdlq.isShowing())) {
            this.jdField_a_of_type_Bdlc.jdField_a_of_type_Bdlq.dismiss();
          }
          return;
          this.jdField_a_of_type_Bdlc.e = true;
          if (this.jdField_a_of_type_Bdlc.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bdlc.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bdlc.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bdht.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bdlc.b(this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bdln.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bdln.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bdlc.b(this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bdlc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bdlc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bdln.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdlm
 * JD-Core Version:    0.7.0.1
 */