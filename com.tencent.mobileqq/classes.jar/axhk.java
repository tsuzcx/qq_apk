import com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class axhk
  extends axfz
{
  public axhk(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmTokenResponse:  isSuccess: " + paramBoolean);
    }
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, axhd paramaxhd)
  {
    if (paramBoolean) {
      this.a.a(paramaxhd);
    }
    super.a(paramBoolean, paramaxhd);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    Object localObject;
    if ((paramBoolean) && ((paramObject instanceof axgx)))
    {
      localObject = (axgx)paramObject;
      this.a.a((axgx)localObject);
    }
    for (;;)
    {
      super.a(paramBoolean, paramObject);
      return;
      if ((paramObject instanceof Integer))
      {
        localObject = (Integer)paramObject;
        this.a.a((Integer)localObject);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onRejectQRResponse:  isSuccess: " + paramBoolean);
    }
    super.b(paramBoolean);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    this.a.a(paramBoolean, paramObject);
    super.b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhk
 * JD-Core Version:    0.7.0.1
 */