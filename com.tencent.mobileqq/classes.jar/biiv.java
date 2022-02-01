import android.content.Context;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class biiv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private biiy jdField_a_of_type_Biiy;
  
  public biiv(Context paramContext, biiy parambiiy)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    bijd.a().a(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_Biiy = parambiiy;
    ClientLogReport.instance();
    GAClientLogReport.instance();
  }
  
  public static int a()
  {
    int i;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    for (;;)
    {
      bija.c("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
      return i;
      if (AppNetConnInfo.isMobileConn()) {
        switch (AppNetConnInfo.getMobileInfo())
        {
        default: 
          i = 100;
          break;
        case 1: 
          i = 3;
          break;
        case 2: 
          i = 9;
          break;
        case 3: 
          i = 11;
          break;
        case 4: 
          i = 14;
          break;
        }
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(biir parambiir)
  {
    if (parambiir != null) {
      parambiir.b();
    }
  }
  
  public static void a(biir parambiir, Context paramContext, long paramLong)
  {
    if (parambiir != null) {
      parambiir.b(lkq.a(paramLong, String.valueOf(AppSetting.a()), paramContext));
    }
  }
  
  public biiw a()
  {
    return this.jdField_a_of_type_Biiy;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Biiy != null)
    {
      this.jdField_a_of_type_Biiy.g();
      this.jdField_a_of_type_Biiy = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    bijd.a().a();
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biiv
 * JD-Core Version:    0.7.0.1
 */