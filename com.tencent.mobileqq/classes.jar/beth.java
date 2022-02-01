import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class beth
  implements bhvc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private beyf jdField_a_of_type_Beyf = new beti(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public beth(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString5;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.e = paramString4;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Beyf.addFilter(new Class[] { berv.class, besa.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class });
    paramQQAppInterface.a().a(this.jdField_a_of_type_Beyf);
  }
  
  private void b()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    Message localMessage = new Message();
    localMessage.what = 1005;
    bete localbete = new bete(this.jdField_b_of_type_JavaLangString, this.c, 0);
    localbete.jdField_b_of_type_Int = 1;
    localbete.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    localMessage.obj = localbete;
    localMessage.arg1 = 0;
    berp.a(localMessage, beth.class, 0L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.e, this.d, this.jdField_b_of_type_Long, this.jdField_b_of_type_Int);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 3000))
    {
      if (this.jdField_a_of_type_Int == 1001) {}
      for (long l = AppSetting.c;; l = bezh.b())
      {
        int i = (int)l;
        if (new File(this.c).length() > i)
        {
          bhmq.a(-1L, this.jdField_a_of_type_Int, true, "group_compress", "ForwardImageProcessor.uploadImage");
          this.c = bhmq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.c, i);
        }
        if (bhmq.a(null, this.c, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
          break;
        }
        return;
      }
    }
    beyg localbeyg = new beyg();
    localbeyg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbeyg.c = this.jdField_b_of_type_JavaLangString;
    localbeyg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbeyg.jdField_b_of_type_Int = 1;
    localbeyg.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.e = 1009;
    localbeyg.i = this.c;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Beyf);
  }
  
  public void a(bhva parambhva1, bhva parambhva2) {}
  
  public void a(String paramString) {}
  
  public boolean a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    return false;
  }
  
  public void b(bhva parambhva1, bhva parambhva2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beth
 * JD-Core Version:    0.7.0.1
 */