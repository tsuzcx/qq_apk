import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.ShuayishuaConfig;
import com.tencent.mobileqq.olympic.TorchInfo;
import com.tencent.qphone.base.util.QLog;

public class aywq
  extends aywr
{
  public aywq(OlympicManager paramOlympicManager) {}
  
  public void a(boolean paramBoolean, int paramInt1, TorchInfo paramTorchInfo, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      OlympicManager localOlympicManager = this.a;
      QLog.i("OlympicManager", 2, "onGetMyTorchInfo.isSuccess=" + paramBoolean + ",errCode=" + paramInt1 + ",errStr=,info=" + paramTorchInfo);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte, TorchInfo paramTorchInfo)
  {
    if (QLog.isColorLevel())
    {
      OlympicManager localOlympicManager = this.a;
      QLog.i("OlympicManager", 2, "onCollectTorch.isSuccess=" + paramBoolean + ",errCode=" + paramInt + ",errStr=" + paramString + ",sig=" + paramArrayOfByte + ",info=" + paramTorchInfo);
    }
    OlympicManager.a(this.a, false);
    if (paramBoolean)
    {
      OlympicManager.a(this.a, paramArrayOfByte);
      if (paramInt == 0)
      {
        bdla.b(this.a.a, "CliOper", "", "", "0X80069C8", "0X80069C8", 0, 0, "", "", "", "");
        this.a.a(1);
        this.a.a(paramTorchInfo);
        OlympicManager.b(this.a).obtainMessage(6).sendToTarget();
        OlympicManager.b(this.a).obtainMessage(5).sendToTarget();
        paramArrayOfByte = Long.valueOf(-1L);
        paramString = paramArrayOfByte;
        if (OlympicManager.a(this.a) != null)
        {
          paramString = paramArrayOfByte;
          if (OlympicManager.a(this.a).type == 2) {
            paramString = Long.valueOf(OlympicManager.a(this.a).uiBegin);
          }
        }
        OlympicManager.a(this.a).obtainMessage(7, paramString).sendToTarget();
      }
    }
    else
    {
      return;
    }
    if (paramInt == 1)
    {
      this.a.a(1);
      OlympicManager.b(this.a).obtainMessage(6).sendToTarget();
      OlympicManager.b(this.a).obtainMessage(5).sendToTarget();
      return;
    }
    OlympicManager.b(this.a, false);
    OlympicManager.b(this.a, null);
    OlympicManager.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywq
 * JD-Core Version:    0.7.0.1
 */