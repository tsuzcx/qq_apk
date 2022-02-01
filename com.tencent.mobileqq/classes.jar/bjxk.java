import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bjxk
  implements DialogInterface.OnClickListener
{
  bjxk(bjxd parambjxd, boolean paramBoolean1, DialogInterface.OnClickListener paramOnClickListener, Bundle paramBundle, int paramInt1, boolean paramBoolean2, Activity paramActivity, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjtx.c("MyAppApi", "---onConfirm--onClick");
    if (!this.jdField_a_of_type_Bjxd.b())
    {
      this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo = new bjxo(this.jdField_a_of_type_Bjxd);
      this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 0);
        if ((this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr != null) && (this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr.isShowing())) {
          this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr.a(0, 1);
        }
      }
    }
    label636:
    for (;;)
    {
      paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.d);
      this.jdField_a_of_type_Bjxd.c = true;
      bjvg.a("201", bjvg.a(this.jdField_a_of_type_JavaLangString, "NEWYYB"), this.jdField_b_of_type_JavaLangString);
      paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 100 + "|" + paramDialogInterface;
      bjqw.a().a(25, paramDialogInterface);
      bdll.b(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 1)
      {
        paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("pageId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString("moduleId") + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.f) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.c) + "_" + this.jdField_a_of_type_AndroidOsBundle.getString(bjwo.d);
        bjto.b("6006", "1", "0", this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      if (("ANDROID.QQ.YYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.jdField_a_of_type_JavaLangString))) {
        acik.a(null, "765", "205010", this.jdField_b_of_type_JavaLangString, "76501", "1", "156");
      }
      return;
      new bjxn(this.jdField_a_of_type_Bjxd, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxo).execute(new Void[0]);
      continue;
      if ((bjwj.h()) || (this.c)) {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr == null) || (!this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr.isShowing())) {
          break label636;
        }
        this.jdField_a_of_type_Bjxd.jdField_a_of_type_Bjxr.dismiss();
        break;
        this.jdField_a_of_type_Bjxd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Boolean, this.d);
        continue;
        if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxk
 * JD-Core Version:    0.7.0.1
 */