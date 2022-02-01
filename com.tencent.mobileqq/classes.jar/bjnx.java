import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bjnx
  extends bjol
{
  bjny jdField_a_of_type_Bjny;
  
  public bjnx(bjnn parambjnn, Activity paramActivity, bjny parambjny)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bjny = parambjny;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bjok.a())
      {
        this.jdField_a_of_type_Bjnn.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bjnn.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bjny.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bjnn.a(this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bjny.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bjny.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bjnn.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bjnn.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bjlu.a(this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle.getString(bjmy.i), "NEWYYB");
            bjlu.a("311", paramBoolean, this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle.getString(bjmy.b));
            Context localContext = bizw.a().a();
            if (localContext != null) {
              bjlu.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle.getString(bjmy.b));
            }
          }
          if ((this.jdField_a_of_type_Bjnn.jdField_a_of_type_Bjob != null) && (this.jdField_a_of_type_Bjnn.jdField_a_of_type_Bjob.isShowing())) {
            this.jdField_a_of_type_Bjnn.jdField_a_of_type_Bjob.dismiss();
          }
          return;
          this.jdField_a_of_type_Bjnn.e = true;
          if (this.jdField_a_of_type_Bjnn.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bjnn.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bjnn.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bjko.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bjnn.b(this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bjny.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bjny.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bjnn.b(this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bjnn.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bjnn.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bjny.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnx
 * JD-Core Version:    0.7.0.1
 */