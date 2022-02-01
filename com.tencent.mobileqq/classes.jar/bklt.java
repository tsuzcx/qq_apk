import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class bklt
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  bkkx jdField_a_of_type_Bkkx;
  bkkz jdField_a_of_type_Bkkz;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private bklt(bklq parambklq, bkkx parambkkx, boolean paramBoolean1, Context paramContext, bkkz parambkkz, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Bkkx = parambkkx;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkkz = parambkkz;
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
      bklq.a(this.jdField_a_of_type_Bklq, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkkz, this.jdField_a_of_type_Bkkx);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      bklq.a(this.jdField_a_of_type_Bklq, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkkz, this.jdField_a_of_type_Bkkx);
      return;
      paramInt = i;
      if (this.b)
      {
        if (bklq.a())
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
 * Qualified Name:     bklt
 * JD-Core Version:    0.7.0.1
 */