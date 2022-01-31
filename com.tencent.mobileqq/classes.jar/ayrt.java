import java.util.Set;

class ayrt
  extends ayug
{
  ayrt(ayrs paramayrs) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.a = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(ayrs.a(this.a))))) {
      this.a.a = 2;
    }
    aysb.c("TroopFileTransferMgr", aysb.a, "onW2MPausedUpload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.b > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        azic.a(ayrs.a(this.a), ayrs.b(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayrt
 * JD-Core Version:    0.7.0.1
 */