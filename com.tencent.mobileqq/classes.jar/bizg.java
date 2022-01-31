import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bizg
  extends bime
{
  public final bimd a;
  private String d;
  
  public bizg(bize parambize, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bimd = new bimd(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bimd.a = new asta("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    bize.a(this.jdField_a_of_type_Bize, this.jdField_a_of_type_Bimd, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(bimk parambimk)
  {
    if (parambimk == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = parambimk.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bimk parambimk)
  {
    boolean bool = bize.a(this.jdField_a_of_type_Bize);
    if (parambimk != null)
    {
      parambimk.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      parambimk.jdField_a_of_type_JavaLangString = str;
      bize.a(this.jdField_a_of_type_Bize);
      if (this.jdField_a_of_type_Bize.jdField_a_of_type_Bimh.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bize.jdField_a_of_type_Bimh.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(bimk parambimk)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Bize.c)
    {
      if (parambimk != null) {
        parambimk.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
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
      String str = this.jdField_a_of_type_Bize.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Bize.jdField_a_of_type_Bimg, String.valueOf(769), this.jdField_a_of_type_Bize.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Bize.a(str), this.jdField_a_of_type_Bize.a(str), this.jdField_a_of_type_Bize.a(str), parambimk);
      this.jdField_d_of_type_JavaLangString = parambimk.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bize.jdField_a_of_type_Bimg == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bize.jdField_a_of_type_Bimg.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bizg
 * JD-Core Version:    0.7.0.1
 */