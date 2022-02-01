import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bkta
  extends bkep
{
  public final bkeo a;
  private String d;
  
  public bkta(bksy parambksy, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkeo = new bkeo(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bkeo.a = new aufm("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    bksy.a(this.jdField_a_of_type_Bksy, this.jdField_a_of_type_Bkeo, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(bkev parambkev)
  {
    if (parambkev == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = parambkev.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bkev parambkev)
  {
    boolean bool = bksy.a(this.jdField_a_of_type_Bksy);
    if (parambkev != null)
    {
      parambkev.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      parambkev.jdField_a_of_type_JavaLangString = str;
      bksy.a(this.jdField_a_of_type_Bksy);
      if (this.jdField_a_of_type_Bksy.jdField_a_of_type_Bkes.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bksy.jdField_a_of_type_Bkes.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(bkev parambkev)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Bksy.c)
    {
      if (parambkev != null) {
        parambkev.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
      }
      if (QLog.isColorLevel()) {
        QLog.d("QRProcessManager", 2, "pluginType:" + this.jdField_b_of_type_Int + "  preload:fail:serverswitch");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      String str = this.jdField_a_of_type_Bksy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Bksy.jdField_a_of_type_Bker, String.valueOf(769), this.jdField_a_of_type_Bksy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Bksy.a(str), this.jdField_a_of_type_Bksy.a(str), this.jdField_a_of_type_Bksy.a(str), parambkev);
      this.jdField_d_of_type_JavaLangString = parambkev.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bksy.jdField_a_of_type_Bker == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bksy.jdField_a_of_type_Bker.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkta
 * JD-Core Version:    0.7.0.1
 */