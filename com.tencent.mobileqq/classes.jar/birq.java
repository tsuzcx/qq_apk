import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class birq
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  biqu jdField_a_of_type_Biqu;
  biqw jdField_a_of_type_Biqw;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private birq(birn parambirn, biqu parambiqu, boolean paramBoolean1, Context paramContext, biqw parambiqw, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Biqu = parambiqu;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biqw = parambiqw;
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
      birn.a(this.jdField_a_of_type_Birn, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biqw, this.jdField_a_of_type_Biqu);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      birn.a(this.jdField_a_of_type_Birn, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biqw, this.jdField_a_of_type_Biqu);
      return;
      paramInt = i;
      if (this.b)
      {
        if (birn.a())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birq
 * JD-Core Version:    0.7.0.1
 */