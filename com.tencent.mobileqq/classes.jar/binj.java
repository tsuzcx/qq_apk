import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class binj
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  bimn jdField_a_of_type_Bimn;
  bimp jdField_a_of_type_Bimp;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private binj(bing parambing, bimn parambimn, boolean paramBoolean1, Context paramContext, bimp parambimp, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Bimn = parambimn;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bimp = parambimp;
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
      bing.a(this.jdField_a_of_type_Bing, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bimp, this.jdField_a_of_type_Bimn);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      bing.a(this.jdField_a_of_type_Bing, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bimp, this.jdField_a_of_type_Bimn);
      return;
      paramInt = i;
      if (this.b)
      {
        if (bing.a())
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
 * Qualified Name:     binj
 * JD-Core Version:    0.7.0.1
 */