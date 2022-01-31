import java.util.Set;

class bbqv
  extends bbrz
{
  bbqv(bbqt parambbqt) {}
  
  protected void a(Set<Long> paramSet)
  {
    this.a.b = 1;
    if ((paramSet != null) && (paramSet.contains(Long.valueOf(bbqt.c(this.a))))) {
      this.a.b = 2;
    }
    bbrc.c("TroopFileTransferMgr", bbrc.a, "onW2MPausedDownload mW2MPausedUploadState:" + this.a.a + " mW2MPausedDownloadState:" + this.a.b);
    if (this.a.a > 0)
    {
      if ((this.a.b == 2) || (this.a.a == 2)) {
        bcig.a(bbqt.b(this.a), bbqt.d(this.a), 107);
      }
      this.a.a = 0;
      this.a.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqv
 * JD-Core Version:    0.7.0.1
 */