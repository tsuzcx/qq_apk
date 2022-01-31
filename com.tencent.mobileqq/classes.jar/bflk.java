import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bflk
  extends beyr
{
  public final beyq a;
  private String d;
  
  public bflk(bfli parambfli, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Beyq = new beyq(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Beyq.a = new aqdz("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    bfli.a(this.jdField_a_of_type_Bfli, this.jdField_a_of_type_Beyq, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(beyx parambeyx)
  {
    if (parambeyx == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = parambeyx.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(beyx parambeyx)
  {
    boolean bool = bfli.a(this.jdField_a_of_type_Bfli);
    if (parambeyx != null)
    {
      parambeyx.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      parambeyx.jdField_a_of_type_JavaLangString = str;
      bfli.a(this.jdField_a_of_type_Bfli);
      if (this.jdField_a_of_type_Bfli.jdField_a_of_type_Beyu.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bfli.jdField_a_of_type_Beyu.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(beyx parambeyx)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Bfli.c)
    {
      if (parambeyx != null) {
        parambeyx.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
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
      String str = this.jdField_a_of_type_Bfli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Bfli.jdField_a_of_type_Beyt, String.valueOf(769), this.jdField_a_of_type_Bfli.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Bfli.a(str), this.jdField_a_of_type_Bfli.a(str), this.jdField_a_of_type_Bfli.a(str), parambeyx);
      this.jdField_d_of_type_JavaLangString = parambeyx.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bfli.jdField_a_of_type_Beyt == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bfli.jdField_a_of_type_Beyt.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflk
 * JD-Core Version:    0.7.0.1
 */