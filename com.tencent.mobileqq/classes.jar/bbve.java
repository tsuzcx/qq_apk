import java.util.Set;

class bbve
  extends bbwi
{
  bbve(bbvc parambbvc) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bbvc.c(this.a))))) {
      this.a.b = 2;
    }
    bbvl.c("TroopFileTransferMgr", bbvl.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bcmp.a(bbvc.b(this.a), bbvc.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbve
 * JD-Core Version:    0.7.0.1
 */