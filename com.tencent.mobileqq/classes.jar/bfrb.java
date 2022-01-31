import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class bfrb
  implements bfqw
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private bfqy jdField_a_of_type_Bfqy;
  private bfre jdField_a_of_type_Bfre;
  private QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  
  public bfrb(Context paramContext, long paramLong, bfqy parambfqy)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bfqy = parambfqy;
    this.jdField_a_of_type_Bfqy.a(this);
    bfrj.a().a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bfre = new bfre(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, this.jdField_a_of_type_Bfqy);
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = this.jdField_a_of_type_Bfre.a();
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
      bfrg.c("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
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
  
  public static void a(bfqy parambfqy)
  {
    if (parambfqy != null) {
      parambfqy.a();
    }
  }
  
  public static void a(bfqy parambfqy, Context paramContext, long paramLong)
  {
    if (parambfqy != null) {
      parambfqy.a(lno.a(paramLong, String.valueOf(AppSetting.a()), paramContext));
    }
  }
  
  public bfrc a()
  {
    return this.jdField_a_of_type_Bfre;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfre != null)
    {
      this.jdField_a_of_type_Bfre.c();
      this.jdField_a_of_type_Bfre = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bfqy = null;
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
    lno.a(String.valueOf(AppSetting.a()), this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrb
 * JD-Core Version:    0.7.0.1
 */