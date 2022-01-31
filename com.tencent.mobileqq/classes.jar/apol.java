import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;
import com.tencent.qphone.base.util.QLog;

public class apol
  extends aroq
{
  public apol(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.d("MsgBackup", 1, "onConfirmTokenRepsponse called! is success");
    }
    for (;;)
    {
      super.a(paramBoolean);
      return;
      QLog.d("MsgBackup", 1, "onConfirmTokenRepsponse called! confirm token is failed!");
    }
  }
  
  public void a(boolean paramBoolean, arpu paramarpu)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.a, paramarpu);
      QLog.d("MsgBackup", 1, "onQueryStateResponse called! qrStateResponse = " + MsgBackupSettingFragment.a(this.a));
    }
    for (;;)
    {
      super.a(paramBoolean, paramarpu);
      return;
      QLog.d("MsgBackup", 1, "onQueryStateResponse called! query qr state is failed!");
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof arpo)))
    {
      MsgBackupSettingFragment.a = (arpo)paramObject;
      QLog.d("MsgBackup", 1, "onGetQrResponse called! qrResponse = " + MsgBackupSettingFragment.a);
    }
    for (;;)
    {
      super.a(paramBoolean, paramObject);
      return;
      QLog.d("MsgBackup", 1, "onGetQrResponse called! request qrCode is failed!");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! is success");
    }
    for (;;)
    {
      super.b(paramBoolean);
      return;
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! reject qr is failed!");
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.a, (arpk)paramObject);
      QLog.d("MsgBackup", 1, "onConfirmQrResponse called! qrConfirmReponse = " + MsgBackupSettingFragment.a(this.a));
    }
    for (;;)
    {
      super.b(paramBoolean, paramObject);
      return;
      QLog.d("MsgBackup", 1, "onConfirmQrResponse called! confirm qrCode is failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apol
 * JD-Core Version:    0.7.0.1
 */