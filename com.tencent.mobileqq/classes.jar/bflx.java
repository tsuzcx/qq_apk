import java.util.Set;

class bflx
  extends bfnb
{
  bflx(bflv parambflv) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bflv.c(this.a))))) {
      this.a.b = 2;
    }
    bfmf.c("TroopFileTransferMgr", bfmf.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bgjc.a(bflv.b(this.a), bflv.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflx
 * JD-Core Version:    0.7.0.1
 */