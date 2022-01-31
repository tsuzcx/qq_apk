import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bgtj
  extends bggi
{
  public final bggh a;
  private String d;
  
  public bgtj(bgth parambgth, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bggh = new bggh(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bggh.a = new aqyb("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    bgth.a(this.jdField_a_of_type_Bgth, this.jdField_a_of_type_Bggh, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(bggo parambggo)
  {
    if (parambggo == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = parambggo.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(bggo parambggo)
  {
    boolean bool = bgth.a(this.jdField_a_of_type_Bgth);
    if (parambggo != null)
    {
      parambggo.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      parambggo.jdField_a_of_type_JavaLangString = str;
      bgth.a(this.jdField_a_of_type_Bgth);
      if (this.jdField_a_of_type_Bgth.jdField_a_of_type_Bggl.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bgth.jdField_a_of_type_Bggl.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(bggo parambggo)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Bgth.c)
    {
      if (parambggo != null) {
        parambggo.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
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
      String str = this.jdField_a_of_type_Bgth.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Bgth.jdField_a_of_type_Bggk, String.valueOf(769), this.jdField_a_of_type_Bgth.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Bgth.a(str), this.jdField_a_of_type_Bgth.a(str), this.jdField_a_of_type_Bgth.a(str), parambggo);
      this.jdField_d_of_type_JavaLangString = parambggo.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Bgth.jdField_a_of_type_Bggk == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Bgth.jdField_a_of_type_Bggk.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtj
 * JD-Core Version:    0.7.0.1
 */