import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;

class bmhn
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  bmgr jdField_a_of_type_Bmgr;
  bmgt jdField_a_of_type_Bmgt;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private bmhn(bmhk parambmhk, bmgr parambmgr, boolean paramBoolean1, Context paramContext, bmgt parambmgt, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_Bmgr = parambmgr;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmgt = parambmgt;
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
      bmhk.a(this.jdField_a_of_type_Bmhk, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmgt, this.jdField_a_of_type_Bmgr);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      bmhk.a(this.jdField_a_of_type_Bmhk, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmgt, this.jdField_a_of_type_Bmgr);
      return;
      paramInt = i;
      if (this.b)
      {
        if (bmhk.a())
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
 * Qualified Name:     bmhn
 * JD-Core Version:    0.7.0.1
 */