import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class bdse
  implements bdrz
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bdsb jdField_a_of_type_Bdsb;
  private bdsh jdField_a_of_type_Bdsh;
  private QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  
  public bdse(Context paramContext, long paramLong, bdsb parambdsb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bdsb = parambdsb;
    this.jdField_a_of_type_Bdsb.a(this);
    bdsm.a().a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bdsh = new bdsh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this.jdField_a_of_type_Bdsb);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = this.jdField_a_of_type_Bdsh.a();
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
      bdsj.c("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
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
  
  public static void a(bdsb parambdsb)
  {
    if (parambdsb != null) {
      parambdsb.a();
    }
  }
  
  public static void a(bdsb parambdsb, Context paramContext, long paramLong)
  {
    if (parambdsb != null) {
      parambdsb.a(lll.a(paramLong, String.valueOf(AppSetting.a()), paramContext));
    }
  }
  
  public bdsf a()
  {
    return this.jdField_a_of_type_Bdsh;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdsh != null)
    {
      this.jdField_a_of_type_Bdsh.c();
      this.jdField_a_of_type_Bdsh = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bdsb = null;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    lll.a(String.valueOf(AppSetting.a()), this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdse
 * JD-Core Version:    0.7.0.1
 */