import java.util.Set;

class beeu
  extends befy
{
  beeu(bees parambees) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bees.c(this.a))))) {
      this.a.b = 2;
    }
    befc.c("TroopFileTransferMgr", befc.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bfaw.a(bees.b(this.a), bees.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeu
 * JD-Core Version:    0.7.0.1
 */