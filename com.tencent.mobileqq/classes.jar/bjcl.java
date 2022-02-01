import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class bjcl
  implements bjcg
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bjci jdField_a_of_type_Bjci;
  private bjco jdField_a_of_type_Bjco;
  private QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  
  public bjcl(Context paramContext, bjci parambjci, bjco parambjco)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjci = parambjci;
    this.jdField_a_of_type_Bjci.a(this);
    bjct.a().a(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_Bjco = parambjco;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = this.jdField_a_of_type_Bjco.a();
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
      bjcq.c("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
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
  
  public static void a(bjci parambjci)
  {
    if (parambjci != null) {
      parambjci.a();
    }
  }
  
  public static void a(bjci parambjci, Context paramContext, long paramLong)
  {
    if (parambjci != null) {
      parambjci.a(lkl.a(paramLong, String.valueOf(AppSetting.a()), paramContext));
    }
  }
  
  public bjcm a()
  {
    return this.jdField_a_of_type_Bjco;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjco != null)
    {
      this.jdField_a_of_type_Bjco.g();
      this.jdField_a_of_type_Bjco = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Bjci = null;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    bjct.a().a();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    lkl.a(String.valueOf(AppSetting.a()), this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b(byte[] paramArrayOfByte) {}
  
  public void c(byte[] paramArrayOfByte) {}
  
  public void d(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(1, paramArrayOfByte);
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onNativeRecvGAudioCMD(2, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcl
 * JD-Core Version:    0.7.0.1
 */