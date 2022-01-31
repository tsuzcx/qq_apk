import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class axqi
  implements baky
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private axvs jdField_a_of_type_Axvs = new axqj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public axqi(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
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
    this.jdField_a_of_type_Axvs.addFilter(new Class[] { axoy.class, axpc.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class });
    paramQQAppInterface.a().a(this.jdField_a_of_type_Axvs);
  }
  
  private void b()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    Message localMessage = new Message();
    localMessage.what = 1005;
    axqf localaxqf = new axqf(this.jdField_b_of_type_JavaLangString, this.c, 0);
    localaxqf.jdField_b_of_type_Int = 1;
    localaxqf.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    localMessage.obj = localaxqf;
    localMessage.arg1 = 0;
    axou.a(localMessage, axqi.class, 0L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.e, this.d, this.jdField_b_of_type_Long, this.jdField_b_of_type_Int);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 3000))
    {
      if (this.jdField_a_of_type_Int == 1001) {}
      for (long l = AppSetting.c;; l = axwv.b())
      {
        int i = (int)l;
        if (new File(this.c).length() > i)
        {
          bacm.a(-1L, this.jdField_a_of_type_Int, true, "group_compress", "ForwardImageProcessor.uploadImage");
          this.c = bacm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.c, i);
        }
        if (bacm.a(null, this.c, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
          break;
        }
        return;
      }
    }
    axvt localaxvt = new axvt();
    localaxvt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localaxvt.c = this.jdField_b_of_type_JavaLangString;
    localaxvt.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localaxvt.jdField_b_of_type_Int = 1;
    localaxvt.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.e = 1009;
    localaxvt.i = this.c;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Axvs);
  }
  
  public void a(bakw parambakw1, bakw parambakw2) {}
  
  public void a(String paramString) {}
  
  public boolean a(bakw parambakw1, bakw parambakw2, int paramInt)
  {
    return false;
  }
  
  public void b(bakw parambakw1, bakw parambakw2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axqi
 * JD-Core Version:    0.7.0.1
 */