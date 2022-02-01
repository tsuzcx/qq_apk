import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aycu
{
  public static aycv a;
  public static boolean a;
  public static long c = 0L;
  protected long a;
  protected QQAppInterface a;
  protected long b;
  protected long d = 524288000L;
  protected long e = 31457280L;
  protected long f = 31457280L;
  protected long g = 31457280L;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static final void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    c();
    jdField_a_of_type_Aycv.a(paramLong, paramBoolean1, paramBoolean2);
  }
  
  public static final void b()
  {
    c();
    jdField_a_of_type_Aycv.b();
  }
  
  public static final void c()
  {
    if (jdField_a_of_type_Aycv == null) {
      try
      {
        if (jdField_a_of_type_Aycv == null) {
          jdField_a_of_type_Aycv = new aycv();
        }
        return;
      }
      finally {}
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    d();
    paramBoolean = a();
    if (QLog.isColorLevel()) {
      ayde.a("PIC_TAG_PRELOAD", "isOverLimit", "isInDPCWhiteList:" + paramBoolean);
    }
    if ((paramInt2 == 0) || ((paramBoolean) && (paramInt2 != 3)))
    {
      if (this.b >= this.d)
      {
        aydr.a(paramInt2, this.d);
        ayde.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowWIFI:" + this.b);
        return -8;
      }
    }
    else if (paramInt2 == 1)
    {
      if (this.jdField_a_of_type_Long >= this.e)
      {
        aydr.a(paramInt2, this.e);
        ayde.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",PreDownMax4GFlow:" + this.e);
        return -8;
      }
    }
    else if (paramInt2 == 2)
    {
      if (this.jdField_a_of_type_Long >= this.f)
      {
        aydr.a(paramInt2, this.f);
        ayde.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",PreDownMax3GFlow:" + this.f);
        return -8;
      }
    }
    else if ((paramInt2 == 3) && (this.jdField_a_of_type_Long >= this.g))
    {
      aydr.a(paramInt2, this.g);
      ayde.a("PIC_TAG_PRELOAD", "isOverLimit", "result:true,netWokrType:" + paramInt2 + ",picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",PreDownMax2GFlow:" + this.g);
      return -8;
    }
    return 0;
  }
  
  public void a()
  {
    jdField_a_of_type_Boolean = aydq.a("PicPreDownSwitchNew", Boolean.valueOf(true)).booleanValue();
    c = aydq.a("PicAuDownTimePoint", 0L);
    this.d = aydq.a("MaxWifiFlow", 524288000L);
    this.e = aydq.a("Max4GFlow", 31457280L);
    this.f = aydq.a("Max3GFlow", 31457280L);
    this.g = aydq.a("Max2GFlow", 31457280L);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.BaseStrategy", 2, "initConfig(): PreDownUseLocalFlowSet=" + jdField_a_of_type_Boolean + " PicAuDownTimePoint=" + c + " PreDownMaxWifiFlow=" + this.d + " PreDownMax4GFlow=" + this.e + " PreDownMax3GFlow=" + this.f + " PreDownMax2GFlow=" + this.g);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  public boolean a()
  {
    return DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
  }
  
  public void d()
  {
    c();
    long[] arrayOfLong = jdField_a_of_type_Aycv.a();
    this.jdField_a_of_type_Long = (arrayOfLong[0] + arrayOfLong[1]);
    this.b = (arrayOfLong[2] + arrayOfLong[3]);
    if (QLog.isColorLevel()) {
      ayde.a("PIC_TAG_PRELOAD", "", "updateTrafficData ", "picTrafficFlowXG:" + this.jdField_a_of_type_Long + ",C2CPicDownFlowXG:" + arrayOfLong[0] + ",Group/DiscussPicDownFlowXG:" + arrayOfLong[1] + ",picTrafficFlowWIFI:" + this.b + ",C2CPicDownFlowWIFI:" + arrayOfLong[2] + ",Group/DiscussPicDownFlowWIFI:" + arrayOfLong[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycu
 * JD-Core Version:    0.7.0.1
 */