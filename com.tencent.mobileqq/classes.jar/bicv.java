import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bicv
  extends bidj
{
  bicw jdField_a_of_type_Bicw;
  
  public bicv(bicl parambicl, Activity paramActivity, bicw parambicw)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bicw = parambicw;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bidi.a())
      {
        this.jdField_a_of_type_Bicl.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bicl.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bicw.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bicl.a(this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bicw.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bicw.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bicl.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bicl.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bias.a(this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidOsBundle.getString(bibw.i), "NEWYYB");
            bias.a("311", paramBoolean, this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidOsBundle.getString(bibw.b));
            Context localContext = bhpc.a().a();
            if (localContext != null) {
              bias.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidOsBundle.getString(bibw.b));
            }
          }
          if ((this.jdField_a_of_type_Bicl.jdField_a_of_type_Bicz != null) && (this.jdField_a_of_type_Bicl.jdField_a_of_type_Bicz.isShowing())) {
            this.jdField_a_of_type_Bicl.jdField_a_of_type_Bicz.dismiss();
          }
          return;
          this.jdField_a_of_type_Bicl.e = true;
          if (this.jdField_a_of_type_Bicl.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bicl.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bicl.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bhzm.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bicl.b(this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bicw.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bicw.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bicl.b(this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bicl.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bicl.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bicw.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicv
 * JD-Core Version:    0.7.0.1
 */