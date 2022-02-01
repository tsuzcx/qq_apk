import java.util.Set;

class bfvj
  extends bfwn
{
  bfvj(bfvh parambfvh) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bfvh.c(this.a))))) {
      this.a.b = 2;
    }
    bfvr.c("TroopFileTransferMgr", bfvr.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bgri.a(bfvh.b(this.a), bfvh.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvj
 * JD-Core Version:    0.7.0.1
 */