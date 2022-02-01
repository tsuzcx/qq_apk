import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class bkdk
  implements bkdf
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bkdh jdField_a_of_type_Bkdh;
  private bkdn jdField_a_of_type_Bkdn;
  private QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  
  public bkdk(Context paramContext, bkdh parambkdh, bkdn parambkdn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkdh = parambkdh;
    this.jdField_a_of_type_Bkdh.a(this);
    bkds.a().a(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_Bkdn = parambkdn;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = this.jdField_a_of_type_Bkdn.a();
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
      bkdp.c("QavCtrl", String.format("getApn networkType=%s", new Object[] { Integer.valueOf(i) }));
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
  
  public static void a(bkdh parambkdh)
  {
    if (parambkdh != null) {
      parambkdh.a();
    }
  }
  
  public static void a(bkdh parambkdh, Context paramContext, long paramLong)
  {
    if (parambkdh != null) {
      parambkdh.a(lkw.a(paramLong, String.valueOf(AppSetting.a()), paramContext));
    }
  }
  
  public bkdl a()
  {
    return this.jdField_a_of_type_Bkdn;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkdn != null)
    {
      this.jdField_a_of_type_Bkdn.g();
      this.jdField_a_of_type_Bkdn = null;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Bkdh = null;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    bkds.a().a();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    lkw.a(String.valueOf(AppSetting.a()), this.jdField_a_of_type_AndroidContentContext, paramArrayOfByte);
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
 * Qualified Name:     bkdk
 * JD-Core Version:    0.7.0.1
 */