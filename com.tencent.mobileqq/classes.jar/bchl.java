import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bchl
  extends bchz
{
  bchm jdField_a_of_type_Bchm;
  
  public bchl(bchb parambchb, Activity paramActivity, bchm parambchm)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bchm = parambchm;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bchy.a())
      {
        this.jdField_a_of_type_Bchb.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bchb.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bchm.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bchb.a(this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bchm.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bchm.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bchb.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bchb.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bcfb.a(this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidOsBundle.getString(bcgl.i), "NEWYYB");
            bcfb.a("311", paramBoolean, this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidOsBundle.getString(bcgl.b));
            Context localContext = bbtm.a().a();
            if (localContext != null) {
              bcfb.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidOsBundle.getString(bcgl.b));
            }
          }
          if ((this.jdField_a_of_type_Bchb.jdField_a_of_type_Bchp != null) && (this.jdField_a_of_type_Bchb.jdField_a_of_type_Bchp.isShowing())) {
            this.jdField_a_of_type_Bchb.jdField_a_of_type_Bchp.dismiss();
          }
          return;
          this.jdField_a_of_type_Bchb.e = true;
          if (this.jdField_a_of_type_Bchb.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bchb.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bchb.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bcds.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bchb.b(this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bchm.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bchm.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bchb.b(this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bchb.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bchb.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bchm.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchl
 * JD-Core Version:    0.7.0.1
 */