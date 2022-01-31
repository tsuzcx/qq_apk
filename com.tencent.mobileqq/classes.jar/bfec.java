import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class bfec
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  bfdg jdField_a_of_type_Bfdg;
  bfdi jdField_a_of_type_Bfdi;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private bfec(bfdz parambfdz, bfdg parambfdg, boolean paramBoolean1, Context paramContext, bfdi parambfdi, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Bfdg = parambfdg;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfdi = parambfdi;
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
      bfdz.a(this.jdField_a_of_type_Bfdz, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfdi, this.jdField_a_of_type_Bfdg);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      bfdz.a(this.jdField_a_of_type_Bfdz, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfdi, this.jdField_a_of_type_Bfdg);
      return;
      paramInt = i;
      if (this.b)
      {
        if (bfdz.a())
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
 * Qualified Name:     bfec
 * JD-Core Version:    0.7.0.1
 */