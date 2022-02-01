import java.util.Set;

class bevp
  extends bewt
{
  bevp(bevn parambevn) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bevn.c(this.a))))) {
      this.a.b = 2;
    }
    bevx.c("TroopFileTransferMgr", bevx.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bfrh.a(bevn.b(this.a), bevn.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevp
 * JD-Core Version:    0.7.0.1
 */