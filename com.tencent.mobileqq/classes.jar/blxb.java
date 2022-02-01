import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class blxb
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  blwf jdField_a_of_type_Blwf;
  blwh jdField_a_of_type_Blwh;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private blxb(blwy paramblwy, blwf paramblwf, boolean paramBoolean1, Context paramContext, blwh paramblwh, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Blwf = paramblwf;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blwh = paramblwh;
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
      blwy.a(this.jdField_a_of_type_Blwy, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blwh, this.jdField_a_of_type_Blwf);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      blwy.a(this.jdField_a_of_type_Blwy, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blwh, this.jdField_a_of_type_Blwf);
      return;
      paramInt = i;
      if (this.b)
      {
        if (blwy.a())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxb
 * JD-Core Version:    0.7.0.1
 */