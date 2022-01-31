import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bfph
  extends bfpv
{
  bfpi jdField_a_of_type_Bfpi;
  
  public bfph(bfox parambfox, Activity paramActivity, bfpi parambfpi)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bfpi = parambfpi;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bfpu.a())
      {
        this.jdField_a_of_type_Bfox.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bfox.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bfpi.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bfox.a(this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bfpi.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bfpi.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bfox.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bfox.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bfmy.a(this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidOsBundle.getString(bfoh.i), "NEWYYB");
            bfmy.a("311", paramBoolean, this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidOsBundle.getString(bfoh.b));
            Context localContext = bfbm.a().a();
            if (localContext != null) {
              bfmy.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidOsBundle.getString(bfoh.b));
            }
          }
          if ((this.jdField_a_of_type_Bfox.jdField_a_of_type_Bfpl != null) && (this.jdField_a_of_type_Bfox.jdField_a_of_type_Bfpl.isShowing())) {
            this.jdField_a_of_type_Bfox.jdField_a_of_type_Bfpl.dismiss();
          }
          return;
          this.jdField_a_of_type_Bfox.e = true;
          if (this.jdField_a_of_type_Bfox.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bfox.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bfox.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bflp.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bfox.b(this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bfpi.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bfpi.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bfox.b(this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bfox.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bfox.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bfpi.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfph
 * JD-Core Version:    0.7.0.1
 */