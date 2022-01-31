import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bdly
  implements DialogInterface.OnClickListener
{
  bdly(bdlr parambdlr, boolean paramBoolean1, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt1, boolean paramBoolean2, Activity paramActivity, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdii.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bdlr.b())
    {
      this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmc = new bdmc(this.jdField_a_of_type_Bdlr);
      this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmc.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmc.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmc.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmc.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bdlr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
        if ((this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf != null) && (this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf.isShowing())) {
          this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf.a(0, 1);
        }
      }
    }
    label636:
    for (;;)
    {
      paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.d);
      this.jdField_a_of_type_Bdlr.c = true;
      bdjr.a("201", bdjr.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.jdField_b_of_type_JavaLangString);
      paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 100 + "|" + paramDialogInterface;
      bdfh.a().a(25, paramDialogInterface);
      axqy.b(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 1)
      {
        paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bdlb.d);
        bdhz.b("6006", "1", "0", this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      if (("ANDROID.QQ.YYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString))) {
        yoa.a(null, "765", "205010", this.jdField_b_of_type_JavaLangString, "76501", "1", "156");
      }
      return;
      new bdmb(this.jdField_a_of_type_Bdlr, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmc).execute(new Void[0]);
      continue;
      if ((bdkw.h()) || (this.c)) {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_Bdlr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf == null) || (!this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf.isShowing())) {
          break label636;
        }
        this.jdField_a_of_type_Bdlr.jdField_a_of_type_Bdmf.dismiss();
        break;
        this.jdField_a_of_type_Bdlr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        continue;
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdly
 * JD-Core Version:    0.7.0.1
 */