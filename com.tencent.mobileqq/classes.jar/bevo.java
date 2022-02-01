import java.util.Set;

class bevo
  extends beyb
{
  bevo(bevn parambevn) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.a = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bevn.a(this.a))))) {
      this.a.a = 2;
    }
    bevx.c("TroopFileTransferMgr", bevx.a, "onW2MPausedUpload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.b > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bfrh.a(bevn.a(this.a), bevn.b(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bevo
 * JD-Core Version:    0.7.0.1
 */