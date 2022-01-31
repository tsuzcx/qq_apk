import java.util.Set;

class azsk
  extends azto
{
  azsk(azsi paramazsi) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(azsi.c(this.a))))) {
      this.a.b = 2;
    }
    azsr.c("TroopFileTransferMgr", azsr.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bajf.a(azsi.b(this.a), azsi.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azsk
 * JD-Core Version:    0.7.0.1
 */