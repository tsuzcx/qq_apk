import java.util.Set;

class azsl
  extends azuy
{
  azsl(azsk paramazsk) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.a = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(azsk.a(this.a))))) {
      this.a.a = 2;
    }
    azst.c("TroopFileTransferMgr", azst.a, "onW2MPausedUpload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.b > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bajt.a(azsk.a(this.a), azsk.b(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azsl
 * JD-Core Version:    0.7.0.1
 */