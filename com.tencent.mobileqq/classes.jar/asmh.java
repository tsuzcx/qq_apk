import com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class asmh
  extends askw
{
  public asmh(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmTokenResponse:  isSuccess: " + paramBoolean);
    }
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, asma paramasma)
  {
    if (paramBoolean) {
      this.a.a(paramasma);
    }
    super.a(paramBoolean, paramasma);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    Object localObject;
    if ((paramBoolean) && ((paramObject instanceof aslu)))
    {
      localObject = (aslu)paramObject;
      this.a.a((aslu)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asmh
 * JD-Core Version:    0.7.0.1
 */