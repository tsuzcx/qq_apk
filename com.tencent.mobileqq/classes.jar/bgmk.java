import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class bgmk
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  bglo jdField_a_of_type_Bglo;
  bglq jdField_a_of_type_Bglq;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private bgmk(bgmh parambgmh, bglo parambglo, boolean paramBoolean1, Context paramContext, bglq parambglq, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Bglo = parambglo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bglq = parambglq;
    this.b = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      bgmh.a(this.jdField_a_of_type_Bgmh, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bglq, this.jdField_a_of_type_Bglo);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      bgmh.a(this.jdField_a_of_type_Bgmh, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bglq, this.jdField_a_of_type_Bglo);
      return;
      paramInt = i;
      if (this.b)
      {
        if (bgmh.a())
        {
          boolean bool = Dex2Oat.a(this.jdField_a_of_type_JavaLangString);
          if (bool) {}
          for (i = 4;; i = 2)
          {
            paramInt = i;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("plugin_tag", 2, "dialog needOTA :" + bool);
            paramInt = i;
            break;
          }
        }
        paramInt = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmk
 * JD-Core Version:    0.7.0.1
 */