import com.tencent.image.URLDrawable.DownloadListener;

class bcbr
  implements URLDrawable.DownloadListener
{
  bcbr(bcbo parambcbo) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    bcbo.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbr
 * JD-Core Version:    0.7.0.1
 */