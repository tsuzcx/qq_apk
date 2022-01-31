import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class bfky
  extends bflm
{
  bfkz jdField_a_of_type_Bfkz;
  
  public bfky(bfko parambfko, Activity paramActivity, bfkz parambfkz)
  {
    super(paramActivity);
    this.jdField_a_of_type_Bfkz = parambfkz;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (bfll.a())
      {
        this.jdField_a_of_type_Bfko.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bfko.jdField_b_of_type_Boolean = false;
        long l = -1L;
        switch (this.jdField_a_of_type_Bfkz.jdField_a_of_type_Int)
        {
        case 1: 
        default: 
          l = this.jdField_a_of_type_Bfko.a(this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bfkz.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bfkz.jdField_b_of_type_Boolean);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bfko.jdField_a_of_type_Long = l;
          this.jdField_a_of_type_Bfko.jdField_b_of_type_Long = System.currentTimeMillis();
          if ((paramBoolean.booleanValue()) && (this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidOsBundle != null))
          {
            paramBoolean = bfip.a(this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidOsBundle.getString(bfjy.i), "NEWYYB");
            bfip.a("311", paramBoolean, this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidOsBundle.getString(bfjy.b));
            Context localContext = bexd.a().a();
            if (localContext != null) {
              bfip.a(localContext, "312", paramBoolean, this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidOsBundle.getString(bfjy.b));
            }
          }
          if ((this.jdField_a_of_type_Bfko.jdField_a_of_type_Bflc != null) && (this.jdField_a_of_type_Bfko.jdField_a_of_type_Bflc.isShowing())) {
            this.jdField_a_of_type_Bfko.jdField_a_of_type_Bflc.dismiss();
          }
          return;
          this.jdField_a_of_type_Bfko.e = true;
          if (this.jdField_a_of_type_Bfko.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct != null)
          {
            l = this.jdField_a_of_type_Bfko.a().addDownloadTaskFromAuthorize(this.jdField_a_of_type_Bfko.jdField_a_of_type_ComTencentTmassistantsdkTMAssistantCallYYBParamStruct, "2");
          }
          else
          {
            bfhg.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            continue;
            l = this.jdField_a_of_type_Bfko.b(this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Bfkz.jdField_a_of_type_Boolean, this.jdField_a_of_type_Bfkz.jdField_b_of_type_Boolean);
            continue;
            l = this.jdField_a_of_type_Bfko.b(this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidOsBundle);
          }
        }
      }
      if (this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
      }
      this.jdField_a_of_type_Bfko.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
      return;
    }
    if (this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
    this.jdField_a_of_type_Bfko.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_Bfkz.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfky
 * JD-Core Version:    0.7.0.1
 */