import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class awin
{
  private static awio a;
  public static long c;
  public static long d;
  protected long a;
  protected QQAppInterface a;
  protected long b;
  protected long e = 524288000L;
  protected long f = 10485760L;
  protected long g = 10485760L;
  protected long h = 5242880L;
  
  public static final void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    c();
    jdField_a_of_type_Awio.a(paramLong, paramBoolean1, paramBoolean2);
  }
  
  public static final void b()
  {
    c();
    jdField_a_of_type_Awio.a();
  }
  
  private static final void c()
  {
    if (jdField_a_of_type_Awio == null) {
      try
      {
        if (jdField_a_of_type_Awio == null) {
          jdField_a_of_type_Awio = new awio();
        }
        return;
      }
      finally {}
    }
  }
  
  private void d()
  {
    c();
    long[] arrayOfLong = jdField_a_of_type_Awio.a();
    this.jdField_a_of_type_Long = (arrayOfLong[0] + arrayOfLong[1]);
    this.b = (arrayOfLong[2] + arrayOfLong[3]);
    if (QLog.isColorLevel()) {
      awiw.a("PIC_TAG_PRELOAD", "", "updateTrafficData ", "picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",C2CPicDownFlowXG:" + arrayOfLong[0] + ",Group/DiscussPicDownFlowXG:" + arrayOfLong[1] + ",picTrafficFlowWIFI:" + this.b + ",C2CPicDownFlowWIFI:" + arrayOfLong[2] + ",Group/DiscussPicDownFlowWIFI:" + arrayOfLong[3]);
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    d();
    paramBoolean = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
    if (QLog.isColorLevel()) {
      awiw.a("PIC_TAG_PRELOAD", "isOverLimit", "isInDPCWhiteList:" + paramBoolean);
    }
    if ((paramInt2 == 0) || ((paramBoolean) && (paramInt2 != 3)))
    {
      if (this.b >= this.e)
      {
        awjk.a(paramInt2, this.e);
        awiw.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowWIFI:" + this.b);
        return -8;
      }
    }
    else if (paramInt2 == 1)
    {
      if (this.jdField_a_of_type_Long >= this.f)
      {
        awjk.a(paramInt2, this.f);
        awiw.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long);
        return -8;
      }
    }
    else if (paramInt2 == 2)
    {
      if (this.jdField_a_of_type_Long >= this.g)
      {
        awjk.a(paramInt2, this.g);
        awiw.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long);
        return -8;
      }
    }
    else if ((paramInt2 == 3) && (this.jdField_a_of_type_Long >= this.h))
    {
      awjk.a(paramInt2, this.h);
      awiw.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long);
      return -8;
    }
    return 0;
  }
  
  public void a()
  {
    c = awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "UseLocalFlowSet", 0L);
    d = awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "PicDTPt2", 0L);
    this.e = awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "MaxWifiFlow", 524288000L);
    this.f = awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Max4GFlow", 10485760L);
    this.g = awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Max3GFlow", 10485760L);
    this.h = awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Max2GFlow", 5242880L);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awin
 * JD-Core Version:    0.7.0.1
 */