import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bgua
  extends bggz
{
  public final bggy a;
  private String d;
  
  public bgua(bgty parambgty, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bggy = new bggy(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bggy.a = new aqyd("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    bgty.a(this.jdField_a_of_type_Bgty, this.jdField_a_of_type_Bggy, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(bghf parambghf)
  {
    if (parambghf == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = parambghf.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bghf parambghf)
  {
    boolean bool = bgty.a(this.jdField_a_of_type_Bgty);
    if (parambghf != null)
    {
      parambghf.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      parambghf.jdField_a_of_type_JavaLangString = str;
      bgty.a(this.jdField_a_of_type_Bgty);
      if (this.jdField_a_of_type_Bgty.jdField_a_of_type_Bghc.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bgty.jdField_a_of_type_Bghc.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(bghf parambghf)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Bgty.c)
    {
      if (parambghf != null) {
        parambghf.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
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
      String str = this.jdField_a_of_type_Bgty.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Bgty.jdField_a_of_type_Bghb, String.valueOf(769), this.jdField_a_of_type_Bgty.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Bgty.a(str), this.jdField_a_of_type_Bgty.a(str), this.jdField_a_of_type_Bgty.a(str), parambghf);
      this.jdField_d_of_type_JavaLangString = parambghf.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bgty.jdField_a_of_type_Bghb == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bgty.jdField_a_of_type_Bghb.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgua
 * JD-Core Version:    0.7.0.1
 */