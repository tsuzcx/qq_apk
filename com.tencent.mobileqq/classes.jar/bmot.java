import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bmot
  extends bmau
{
  public final bmat a;
  private String d;
  
  public bmot(bmor parambmor, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bmat = new bmat(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bmat.a = new avsk("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    bmor.a(this.jdField_a_of_type_Bmor, this.jdField_a_of_type_Bmat, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(bmba parambmba)
  {
    if (parambmba == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = parambmba.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bmba parambmba)
  {
    boolean bool = bmor.a(this.jdField_a_of_type_Bmor);
    if (parambmba != null)
    {
      parambmba.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      parambmba.jdField_a_of_type_JavaLangString = str;
      bmor.a(this.jdField_a_of_type_Bmor);
      if (this.jdField_a_of_type_Bmor.jdField_a_of_type_Bmax.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bmor.jdField_a_of_type_Bmax.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(bmba parambmba)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Bmor.c)
    {
      if (parambmba != null) {
        parambmba.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
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
      String str = this.jdField_a_of_type_Bmor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Bmor.jdField_a_of_type_Bmaw, String.valueOf(769), this.jdField_a_of_type_Bmor.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Bmor.a(str), this.jdField_a_of_type_Bmor.a(str), this.jdField_a_of_type_Bmor.a(str), parambmba);
      this.jdField_d_of_type_JavaLangString = parambmba.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bmor.jdField_a_of_type_Bmaw == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bmor.jdField_a_of_type_Bmaw.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmot
 * JD-Core Version:    0.7.0.1
 */