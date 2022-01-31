import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class baom
  implements bdlq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private baua jdField_a_of_type_Baua = new baon(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public baom(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
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
    this.jdField_a_of_type_Baua.addFilter(new Class[] { banc.class, bang.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class });
    paramQQAppInterface.a().a(this.jdField_a_of_type_Baua);
  }
  
  private void b()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    Message localMessage = new Message();
    localMessage.what = 1005;
    baoj localbaoj = new baoj(this.jdField_b_of_type_JavaLangString, this.c, 0);
    localbaoj.jdField_b_of_type_Int = 1;
    localbaoj.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    localMessage.obj = localbaoj;
    localMessage.arg1 = 0;
    bamw.a(localMessage, baom.class, 0L);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.e, this.d, this.jdField_b_of_type_Long, this.jdField_b_of_type_Int);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 3000))
    {
      if (this.jdField_a_of_type_Int == 1001) {}
      for (long l = AppSetting.c;; l = bavd.b())
      {
        int i = (int)l;
        if (new File(this.c).length() > i)
        {
          bdda.a(-1L, this.jdField_a_of_type_Int, true, "group_compress", "ForwardImageProcessor.uploadImage");
          this.c = bdda.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), this.c, i);
        }
        if (bdda.a(null, this.c, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
          break;
        }
        return;
      }
    }
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbaub.c = this.jdField_b_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbaub.jdField_b_of_type_Int = 1;
    localbaub.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.e = 1009;
    localbaub.i = this.c;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Baua);
  }
  
  public void a(bdlo parambdlo1, bdlo parambdlo2) {}
  
  public void a(String paramString) {}
  
  public boolean a(bdlo parambdlo1, bdlo parambdlo2, int paramInt)
  {
    return false;
  }
  
  public void b(bdlo parambdlo1, bdlo parambdlo2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baom
 * JD-Core Version:    0.7.0.1
 */