import android.content.Context;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class bkdm
  implements lnz
{
  protected long a;
  protected Context a;
  protected bkdh a;
  protected QQGAudioCtrl a;
  
  public bkdm(Context paramContext, long paramLong, bkdh parambkdh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bkdh = parambkdh;
    a();
    a();
  }
  
  private void a()
  {
    bkdp.c("MultiOperatorBase", "initGAudioCtrl");
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
        {
          int i = bkdk.a();
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setCallback(this);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(AppSetting.a());
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, 1, "8.4.5", new llf().a());
          ClientLogReport.instance().init(this.jdField_a_of_type_AndroidContentContext, AppSetting.a());
          GAClientLogReport.instance();
          return;
        }
        bkdp.a("MultiOperatorBase", "initGAudioCtrl create instance fail.");
        return;
      }
    }
    catch (Exception localException)
    {
      bkdp.a("MultiOperatorBase", "initGAudioCtrl  fail.", localException);
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
  }
  
  private boolean a()
  {
    bkdp.c("MultiOperatorBase", "loadLibrary");
    try
    {
      SoLoadUtil.a(this.jdField_a_of_type_AndroidContentContext, "c++_shared", 0, false);
      SoLoadUtil.a(this.jdField_a_of_type_AndroidContentContext, "xplatform", 0, false);
      AVSoUtils.a(this.jdField_a_of_type_AndroidContentContext, "SDKCommon", true);
      AVSoUtils.a(this.jdField_a_of_type_AndroidContentContext, "VideoCtrl", true);
      AVSoUtils.a(this.jdField_a_of_type_AndroidContentContext, "qav_media_engine", true);
      return true;
    }
    catch (Throwable localThrowable)
    {
      bkdp.a("MultiOperatorBase", "loadLibrary fail.", localThrowable);
    }
    return false;
  }
  
  private void b()
  {
    bkdp.c("MultiOperatorBase", "unInitGAudioCtrl");
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
      bkdp.a("MultiOperatorBase", "unInitGAudioCtrl  fail.", localException);
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
  
  public lff a()
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(int paramInt, long paramLong, lwf paramlwf) {}
  
  public void a(int paramInt, long paramLong, int... paramVarArgs) {}
  
  public void a(int paramInt, ArrayList<lnd> paramArrayList) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, long paramLong2, String paramString) {}
  
  public void a(long paramLong1, long paramLong2, ArrayList<lnv> paramArrayList) {}
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bkdh != null) {
      this.jdField_a_of_type_Bkdh.a(paramLong1, paramLong2, paramArrayOfByte);
    }
  }
  
  public void a(long paramLong, ArrayList<lnd> paramArrayList, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2) {}
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4) {}
  
  public void a(lnd paramlnd, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a_(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    QLog.w("MultiOperatorBase", 1, "setEncodeDecodePtr, sessionType[2], clean[" + paramBoolean1 + "], isRemote[" + paramBoolean2 + "], isMultiEngine[" + true + "], seq[" + paramLong + "]");
    GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (!paramBoolean2) {
        break label213;
      }
      if (paramBoolean1)
      {
        if (localGraphicRenderMgr.decoderPtrRef > 0) {
          localGraphicRenderMgr.decoderPtrRef -= 1;
        }
        if (localGraphicRenderMgr.decoderPtrRef == 0) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0L);
        }
        QLog.w("MultiOperatorBase", 1, "setEncodeDecodePtr, decoderPtrRef:=" + localGraphicRenderMgr.decoderPtrRef);
      }
    }
    else
    {
      return;
    }
    localGraphicRenderMgr.decoderPtrRef += 1;
    if (localGraphicRenderMgr.decoderPtrRef >= 1)
    {
      paramLong = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(paramLong);
    }
    QLog.w("MultiOperatorBase", 1, "setEncodeDecodePtr, decoderPtrRef:=" + localGraphicRenderMgr.decoderPtrRef);
    return;
    label213:
    if (paramBoolean1) {}
    for (paramLong = l;; paramLong = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEncodeFrameFunctionPtrFunPtr())
    {
      localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(paramLong);
      return;
    }
  }
  
  public void b(int paramInt, long paramLong) {}
  
  public void b(int paramInt1, long paramLong, int paramInt2) {}
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3) {}
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void b(long paramLong1, long paramLong2, String paramString) {}
  
  public void b(long paramLong, ArrayList<lnd> paramArrayList) {}
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void c(long paramLong, int paramInt1, int paramInt2) {}
  
  public void c(ArrayList<lms> paramArrayList) {}
  
  public void d(long paramLong, int paramInt1, int paramInt2) {}
  
  public void e(int paramInt1, long paramLong, int paramInt2) {}
  
  public void e(long paramLong) {}
  
  public void e(long paramLong, int paramInt1, int paramInt2) {}
  
  public void f(int paramInt) {}
  
  public void f(long paramLong) {}
  
  public void f(byte[] paramArrayOfByte) {}
  
  public void g()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Bkdh = null;
    b();
  }
  
  public void h(int paramInt) {}
  
  public void y() {}
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdm
 * JD-Core Version:    0.7.0.1
 */