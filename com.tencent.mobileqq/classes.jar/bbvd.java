import java.util.Set;

class bbvd
  extends bbxq
{
  bbvd(bbvc parambbvc) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.a = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bbvc.a(this.a))))) {
      this.a.a = 2;
    }
    bbvl.c("TroopFileTransferMgr", bbvl.a, "onW2MPausedUpload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.b > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bcmp.a(bbvc.a(this.a), bbvc.b(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvd
 * JD-Core Version:    0.7.0.1
 */