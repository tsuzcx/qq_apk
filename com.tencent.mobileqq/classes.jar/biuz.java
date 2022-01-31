import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class biuz
  extends bihx
{
  public final bihw a;
  private String d;
  
  public biuz(biux parambiux, int paramInt)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bihw = new bihw(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bihw.a = new asor("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    biux.a(this.jdField_a_of_type_Biux, this.jdField_a_of_type_Bihw, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void a(biid parambiid)
  {
    if (parambiid == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = parambiid.jdField_a_of_type_JavaLangString;
  }
  
  protected boolean a(biid parambiid)
  {
    boolean bool = biux.a(this.jdField_a_of_type_Biux);
    if (parambiid != null)
    {
      parambiid.jdField_a_of_type_Int = 2;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      parambiid.jdField_a_of_type_JavaLangString = str;
      biux.a(this.jdField_a_of_type_Biux);
      if (this.jdField_a_of_type_Biux.jdField_a_of_type_Biia.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Biux.jdField_a_of_type_Biia.jdField_b_of_type_Int;
      }
      return bool;
    }
  }
  
  protected boolean b(biid parambiid)
  {
    boolean bool1;
    if (!this.jdField_a_of_type_Biux.c)
    {
      if (parambiid != null) {
        parambiid.jdField_a_of_type_JavaLangString = "preload:fail:serverswitch";
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
      String str = this.jdField_a_of_type_Biux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool2 = a(this.jdField_a_of_type_Biux.jdField_a_of_type_Bihz, String.valueOf(769), this.jdField_a_of_type_Biux.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.read.android", this.jdField_a_of_type_Biux.a(str), this.jdField_a_of_type_Biux.a(str), this.jdField_a_of_type_Biux.a(str), parambiid);
      this.jdField_d_of_type_JavaLangString = parambiid.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Biux.jdField_a_of_type_Bihz == null);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Biux.jdField_a_of_type_Bihz.jdField_a_of_type_Int;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biuz
 * JD-Core Version:    0.7.0.1
 */