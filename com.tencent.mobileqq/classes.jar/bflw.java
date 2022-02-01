import java.util.Set;

class bflw
  extends bfoj
{
  bflw(bflv parambflv) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.a = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bflv.a(this.a))))) {
      this.a.a = 2;
    }
    bfmf.c("TroopFileTransferMgr", bfmf.a, "onW2MPausedUpload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.b > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bgjc.a(bflv.a(this.a), bflv.b(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflw
 * JD-Core Version:    0.7.0.1
 */