import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class bglt
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  bgkx jdField_a_of_type_Bgkx;
  bgkz jdField_a_of_type_Bgkz;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private bglt(bglq parambglq, bgkx parambgkx, boolean paramBoolean1, Context paramContext, bgkz parambgkz, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Bgkx = parambgkx;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bgkz = parambgkz;
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
      bglq.a(this.jdField_a_of_type_Bglq, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgkz, this.jdField_a_of_type_Bgkx);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      bglq.a(this.jdField_a_of_type_Bglq, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgkz, this.jdField_a_of_type_Bgkx);
      return;
      paramInt = i;
      if (this.b)
      {
        if (bglq.a())
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
 * Qualified Name:     bglt
 * JD-Core Version:    0.7.0.1
 */