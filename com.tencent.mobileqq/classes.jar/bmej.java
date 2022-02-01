import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bmej
  extends blqa
{
  public final blpz a;
  private String d;
  
  public bmej(bmeh parambmeh, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Blpz = new blpz(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Blpz.a = new avlg("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    bmeh.a(this.jdField_a_of_type_Bmeh, this.jdField_a_of_type_Blpz, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(blqg paramblqg)
  {
    if (paramblqg == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = paramblqg.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(blqg paramblqg)
  {
    boolean bool = bmeh.a(this.jdField_a_of_type_Bmeh);
    if (paramblqg != null)
    {
      paramblqg.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      paramblqg.jdField_a_of_type_JavaLangString = str;
      bmeh.a(this.jdField_a_of_type_Bmeh);
      if (this.jdField_a_of_type_Bmeh.jdField_a_of_type_Blqd.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bmeh.jdField_a_of_type_Blqd.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(blqg paramblqg)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Bmeh.c)
    {
      if (paramblqg != null) {
        paramblqg.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
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
      String str = this.jdField_a_of_type_Bmeh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Bmeh.jdField_a_of_type_Blqc, String.valueOf(769), this.jdField_a_of_type_Bmeh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Bmeh.a(str), this.jdField_a_of_type_Bmeh.a(str), this.jdField_a_of_type_Bmeh.a(str), paramblqg);
      this.jdField_d_of_type_JavaLangString = paramblqg.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bmeh.jdField_a_of_type_Blqc == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bmeh.jdField_a_of_type_Blqc.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmej
 * JD-Core Version:    0.7.0.1
 */