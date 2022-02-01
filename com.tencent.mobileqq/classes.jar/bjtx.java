import android.content.Context;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class bjtx
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bjua jdField_a_of_type_Bjua;
  
  public bjtx(Context paramContext, bjua parambjua)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    bjuf.a().a(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_Bjua = parambjua;
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
      bjuc.c("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
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
  
  public static void a(bjtt parambjtt)
  {
    if (parambjtt != null) {
      parambjtt.b();
    }
  }
  
  public static void a(bjtt parambjtt, Context paramContext, long paramLong)
  {
    if (parambjtt != null) {
      parambjtt.b(llc.a(paramLong, String.valueOf(AppSetting.a()), paramContext));
    }
  }
  
  public bjty a()
  {
    return this.jdField_a_of_type_Bjua;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjua != null)
    {
      this.jdField_a_of_type_Bjua.g();
      this.jdField_a_of_type_Bjua = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    bjuf.a().a();
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtx
 * JD-Core Version:    0.7.0.1
 */