import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import java.util.ArrayList;

public class bdsg
  implements lol
{
  protected long a;
  protected Context a;
  protected bdsb a;
  protected QQGAudioCtrl a;
  
  public bdsg(Context paramContext, long paramLong, bdsb parambdsb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bdsb = parambdsb;
    a();
    a();
  }
  
  private void a()
  {
    bdsj.c("MultiOperatorBase", "initGAudioCtrl");
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
        {
          int i = bdse.a();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(AppSetting.a());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, 1, "8.3.0");
          ClientLogReport.instance().init(this.jdField_a_of_type_AndroidContentContext, AppSetting.a());
          GAClientLogReport.instance();
          return;
        }
        bdsj.a("MultiOperatorBase", "initGAudioCtrl create instance fail.");
        return;
      }
    }
    catch (Exception localException)
    {
      bdsj.a("MultiOperatorBase", "initGAudioCtrl  fail.", localException);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
  }
  
  private boolean a()
  {
    bdsj.c("MultiOperatorBase", "loadLibrary");
    try
    {
      SoLoadUtil.a(this.jdField_a_of_type_AndroidContentContext, "c++_shared", 0, false);
      SoLoadUtil.a(this.jdField_a_of_type_AndroidContentContext, "xplatform", 0, false);
      UpdateAvSo.a(this.jdField_a_of_type_AndroidContentContext, "SDKCommon", true);
      UpdateAvSo.a(this.jdField_a_of_type_AndroidContentContext, "VideoCtrl", true);
      UpdateAvSo.a(this.jdField_a_of_type_AndroidContentContext, "qav_media_engine", true);
      return true;
    }
    catch (Throwable localThrowable)
    {
      bdsj.a("MultiOperatorBase", "loadLibrary fail.", localThrowable);
    }
    return false;
  }
  
  private void b()
  {
    bdsj.c("MultiOperatorBase", "unInitGAudioCtrl");
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.uninit();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      }
      return;
    }
    catch (Exception localException)
    {
      bdsj.a("MultiOperatorBase", "unInitGAudioCtrl  fail.", localException);
    }
  }
  
  public long a(int paramInt1, int paramInt2, long paramLong)
  {
    return 0L;
  }
  
  public QQGAudioCtrl a()
  {
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  }
  
  public lga a()
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt, long paramLong, int... paramVarArgs) {}
  
  public void a(int paramInt, ArrayList<lnp> paramArrayList) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong1, long paramLong2, ArrayList<loh> paramArrayList) {}
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bdsb != null) {
      this.jdField_a_of_type_Bdsb.a(paramLong1, paramLong2, paramArrayOfByte);
    }
  }
  
  public void a(long paramLong, ArrayList<lnp> paramArrayList, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3) {}
  
  public void a(lnp paramlnp, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs) {}
  
  public void b(int paramInt, long paramLong) {}
  
  public void b(int paramInt1, long paramLong, int paramInt2) {}
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void b(long paramLong1, long paramLong2, String paramString) {}
  
  public void b(long paramLong, ArrayList<lnp> paramArrayList) {}
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bdsb = null;
    b();
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void c(long paramLong, int paramInt1, int paramInt2) {}
  
  public void c(ArrayList<lne> paramArrayList) {}
  
  public void d(long paramLong) {}
  
  public void e(int paramInt1, long paramLong, int paramInt2) {}
  
  public void f(int paramInt) {}
  
  public void f(long paramLong) {}
  
  public void g(long paramLong) {}
  
  public void g(byte[] paramArrayOfByte) {}
  
  public void h(int paramInt) {}
  
  public void y() {}
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsg
 * JD-Core Version:    0.7.0.1
 */