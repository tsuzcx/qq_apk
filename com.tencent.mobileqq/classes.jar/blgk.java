import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class blgk
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  blfo jdField_a_of_type_Blfo;
  blfq jdField_a_of_type_Blfq;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private blgk(blgh paramblgh, blfo paramblfo, boolean paramBoolean1, Context paramContext, blfq paramblfq, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Blfo = paramblfo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blfq = paramblfq;
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
      blgh.a(this.jdField_a_of_type_Blgh, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blfq, this.jdField_a_of_type_Blfo);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      blgh.a(this.jdField_a_of_type_Blgh, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Blfq, this.jdField_a_of_type_Blfo);
      return;
      paramInt = i;
      if (this.b)
      {
        if (blgh.a())
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
 * Qualified Name:     blgk
 * JD-Core Version:    0.7.0.1
 */