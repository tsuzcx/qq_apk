import com.tencent.qphone.base.util.QLog;

class aucg
  extends aubv
{
  aucg(aucf paramaucf) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof auct))) {
      aucf.a(this.a, (auct)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aucg
 * JD-Core Version:    0.7.0.1
 */