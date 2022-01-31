import com.tencent.qphone.base.util.QLog;

class arpb
  extends aroq
{
  arpb(arpa paramarpa) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof arpo))) {
      arpa.a(this.a, (arpo)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arpb
 * JD-Core Version:    0.7.0.1
 */