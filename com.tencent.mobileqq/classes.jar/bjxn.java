import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bjxn
  extends bjyb
{
  bjxo jdField_a_of_type_Bjxo;
  
  public bjxn(bjxd parambjxd, Activity paramActivity, bjxo parambjxo)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bjxo = parambjxo;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bjya.a())
      {
        this.jdField_a_of_type_Bjxd.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bjxd.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bjxo.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bjxo.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bjxo.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bjxd.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bjxd.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bjvg.a(this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle.getString(bjwo.i), "NEWYYB");
            bjvg.a("311", paramBoolean, this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle.getString(bjwo.b));
            Context localContext = bjjo.a().a();
            if (localContext != null) {
              bjvg.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle.getString(bjwo.b));
            }
          }
          if ((this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr != null) && (this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr.isShowing())) {
            this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr.dismiss();
          }
          return;
          this.jdField_a_of_type_Bjxd.e = true;
          if (this.jdField_a_of_type_Bjxd.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bjxd.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bjxd.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bjtx.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bjxd.b(this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bjxo.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bjxo.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bjxd.b(this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bjxd.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bjxd.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxn
 * JD-Core Version:    0.7.0.1
 */