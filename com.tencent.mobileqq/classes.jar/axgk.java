import com.tencent.qphone.base.util.QLog;

class axgk
  extends axfz
{
  axgk(axgj paramaxgj) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    if ((paramBoolean) && ((paramObject instanceof axgx))) {
      axgj.a(this.a, (axgx)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axgk
 * JD-Core Version:    0.7.0.1
 */