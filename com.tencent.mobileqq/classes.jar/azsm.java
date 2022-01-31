import java.util.Set;

class azsm
  extends aztq
{
  azsm(azsk paramazsk) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(azsk.c(this.a))))) {
      this.a.b = 2;
    }
    azst.c("TroopFileTransferMgr", azst.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bajt.a(azsk.b(this.a), azsk.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azsm
 * JD-Core Version:    0.7.0.1
 */